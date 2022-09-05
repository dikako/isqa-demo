package demo.driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static demo.utils.Constants.APP;

public class IOSDriverInstance {

    public static IOSDriver<IOSElement> iosDriver;
    static Dotenv dotenv = Dotenv.load();

    public static void initialize() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", dotenv.get("DEVICE_NAME"));
        caps.setCapability("platformVersion", dotenv.get("PLATFORM_VERSION"));
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("app", APP + dotenv.get("APP"));
        try {
            iosDriver = new IOSDriver<>(new URL(Objects.requireNonNull(dotenv.get("APPIUM_URL"))), caps);
            iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        iosDriver.quit();
    }
}
