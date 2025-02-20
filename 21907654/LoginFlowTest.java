import android.test.ActivityInstrumentationTestCase2;
import com.jjoe64.graphview.R;
import com.robotium.solo.Solo;
import jxl.read.biff.BiffException;
import java.io.IOException;

public class LoginFlowTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    private String user, pass, bp, rdc, pr, ch, sv, flag;

    public LoginFlowTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        Excel rd = new Excel();
        rd.read();
        user = rd.getUser();
        pass = rd.getPass();
        bp = rd.getBill();
        rdc = rd.getRdc();
        pr = rd.getPr();
    }

    public void testApp() throws BiffException, IOException {
        login();
        testMfaVerification();
        testAccountNavigation();
        testTransfers();
        testAdditionalFeatures();
        logout();
    }

    private void login() {
        solo.enterText(0, user);
        solo.sleep(1000);
        solo.enterText(1, "xxx");
        solo.sleep(1000);
        solo.clickOnButton(1);
        solo.sleep(5000);
        solo.clickOnButton(0);
        solo.sleep(2500);
        solo.enterText(1, pass);
        solo.sleep(2500);
        solo.clickOnButton(1);
        solo.sleep(10000);
    }

    private void testMfaVerification() {
        solo.clickOnButton(0);
        solo.sleep(20000);
    }

    private void testAccountNavigation() {
        solo.clickOnButton(0);
        solo.sleep(15000);
        // Account history implementation...
    }

    private void testTransfers() {
        solo.clickOnMenuItem("Transfers");
        // Transfer steps implementation...
    }

    private void testAdditionalFeatures() {
        // Bill Pay, RDC, PR implementations...
    }

    private void logout() {
        solo.clickOnImage(0);
        solo.sleep(5000);
        solo.clickOnButton(1);
        solo.sleep(5000);
        solo.clickOnImage(0);
        solo.sleep(10000);
        solo.clickOnButton(0);
        solo.sleep(10000);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
} 