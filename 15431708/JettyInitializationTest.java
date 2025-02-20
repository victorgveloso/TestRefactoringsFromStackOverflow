import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class JettyInitializationTest {

    public static class I implements ServletContainerInitializer {
        public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
            Servlet servlet = new MyServlet();
            ctx.addServlet("foo", servlet).addMapping("/*");
        }
    }

    public static class MyServlet extends javax.servlet.http.HttpServlet {
        // Servlet implementation
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(0);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        
        // Duplicated initialization
        Servlet servlet = new MyServlet();
        context.addServlet(servlet, "/*");
        
        server.setHandler(context);
        server.start();
        server.join();
    }
} 