import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.junit.Test;
import static org.junit.Assert.*;

public class PageTitleTest {
    private WebDriver driver;
    private String title;
    
    // Original version from question/0.java
    public void verifyTitle(int secsToWait) {
        new WebDriverWait(driver, secsToWait)
                .withMessage("Any message you want")
                .until(ExpectedConditions.titleIs(title));
    }

    // Improved version from question/1.java
    public void verifyTitleWithCustomError(int secsToWait) {
        try {
            new WebDriverWait(driver, secsToWait)
                    .until(ExpectedConditions.titleIs(title));
        }
        catch (TimeoutException e) {
            throw new AssertionError(String.format(
                "Expected page title [%s] but was [%s]", 
                title, driver.getTitle()));
        }
    }
} 