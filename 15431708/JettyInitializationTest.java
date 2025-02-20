import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycleListener;
import org.eclipse.jetty.util.component.LifeCycle;
import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;
import java.util.HashSet;

public class JettyInitializationTest {

    public static class MyInitializer implements ServletContainerInitializer {
        public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
            Servlet servlet = new MyServlet();
            ctx.addServlet("foo", servlet).addMapping("/*");
        }
    }

    public static class JettyStartingListener extends AbstractLifeCycleListener {
        private final ServletContext sc;
        
        public JettyStartingListener(ServletContext sc) {
            this.sc = sc;
        }
        
        @Override
        public void lifeCycleStarting(LifeCycle event) {
            try {
                new MyInitializer().onStartup(new HashSet<Class<?>>(), sc);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class MyServlet extends javax.servlet.http.HttpServlet {
        // Servlet implementation
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(0);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        
        // Apply patch to remove duplication
        context.addLifeCycleListener(new JettyStartingListener(context.getServletContext()));
        
        server.setHandler(context);
        server.start();
        server.join();
    }
} 