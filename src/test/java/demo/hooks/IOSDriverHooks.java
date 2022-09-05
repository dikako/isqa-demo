package demo.hooks;

import demo.utils.Constants;
import demo.driver.IOSDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static demo.utils.Utils.compressBytes;
import static demo.utils.Utils.loadElementProperties;

public class IOSDriverHooks {
    @Before(value = "@iOS")
    public void initializeWebdriver() {
        IOSDriverInstance.initialize();
        loadElementProperties(Constants.ELEMENTS);
    }

    @After(value = "@iOS")
    public void quitWebdriver(Scenario scenario) {
        if (scenario.isFailed()) {
            try{
                final byte[] data = compressBytes(((TakesScreenshot) IOSDriverInstance.iosDriver).getScreenshotAs(OutputType.BYTES));
                scenario.attach(data, "image/png", "Failed Screenshot");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }
        IOSDriverInstance.quit();
    }
}
