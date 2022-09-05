package demo.pages.base;

import demo.utils.Utils;
import demo.driver.IOSDriverInstance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static demo.utils.Constants.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePageObject {

    public IOSDriver<?> getDriver() {
        return IOSDriverInstance.iosDriver;
    }

    public IOSElement waitUntil(ExpectedCondition<WebElement> conditions, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        return (IOSElement) wait.until(conditions);
    }

    public IOSElement waitUntilClickable(By by, Integer timeout) {
        return waitUntil(ExpectedConditions.elementToBeClickable(by), timeout);
    }

    public IOSElement waitUntilVisible(By by) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), TIMEOUT);
    }

    public By element(String elementLocator) {
        String elementValue = Utils.ELEMENTS.getProperty(elementLocator);
        if (elementValue == null) {
            System.out.println("Couldn't find element : " + elementLocator + " ! Please check properties file!");
            throw new NoSuchElementException("Couldn't find element : " + elementLocator);
        } else {
            String[] locator = elementValue.split("_");
            String locatorType = locator[0];
            String locatorValue = elementValue.substring(elementValue.indexOf("_") + 1);
            byte var = -1;
            switch (locatorType.hashCode()) {
                case 3355:
                    if (locatorType.contains("id")) {
                        var = 1;
                    }
                    break;
                case 3373707:
                    if (locatorType.contains("name")) {
                        var = 2;
                    }
                    break;
                case 114256029:
                    if (locatorType.contains("xpath")) {
                        var = 3;
                    }
                    break;
                case -2141255700:
                    if (locatorType.contains("containsText")) {
                        var = 4;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + var);
            }

            switch (var) {
                case 1:
                    return MobileBy.id(locatorValue);
                case 2:
                    return MobileBy.name(locatorValue);
                case 3:
                    return MobileBy.xpath(locatorValue);
                case 4:
                    return MobileBy.xpath("//*[contains(@name, '" + locatorValue + "')]");
                default:
                    return null;
            }
        }
    }

    public String element(String elementLocator, Object args) {
        String elementValue = Utils.ELEMENTS.getProperty(elementLocator);
        String constructedValue = String.format(elementValue, args);
        String constructedLocator = "TEMP_" + elementLocator;

        try {
            Utils.ELEMENTS.remove(constructedLocator);
        } catch (NullPointerException e) {
            System.out.println("No properties key found!");
        }

        Utils.ELEMENTS.setProperty(constructedLocator, constructedValue);
        return constructedLocator;
    }

    public void typeOn(By by, String text) {
        IOSElement element = waitUntilVisible(by);
        element.setValue(text);
    }

    public void typeOn(String element, String text) {
        typeOn(element(element), text);
    }

    public Boolean isPresent(By by) {
        return getListElementSize(by) != 0;
    }
    public Boolean isPresent(String element) {
        return isPresent(element(element));
    }

    public Boolean isPresent(String element, Object args) {
        return isPresent(element(element, args));
    }

    public void hideKeyboard() {
        getDriver().switchTo().activeElement().sendKeys(Keys.RETURN);
    }

    public void swipeScreen(String direction, int divideMidXs, int divideMidYs) {
        int deviceWidth = getDriver().manage().window().getSize().getWidth();
        int deviceHeight = getDriver().manage().window().getSize().getHeight();
        int midX = (deviceWidth / divideMidXs);
        int midY = (deviceHeight / divideMidYs);
        int bottomEdge = (int) (deviceHeight * 0.85f);

        Dimension size = getDriver().manage().window().getSize();
        int y0 = (int) ((double) size.height * 0.7D);
        int y1 = (int) ((double) size.height * 0.3D);

        switch (direction.toUpperCase()) {
            case "DOWN":
                new TouchAction<>(getDriver())
                        .press(point(midX, midY))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo(point(midX, bottomEdge))
                        .release()
                        .perform();
                break;
            case "UP":
                new TouchAction<>(getDriver())
                        .press((new PointOption<>()).withCoordinates(midX, y0))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo((new PointOption<>()).withCoordinates(midX, y1))
                        .release()
                        .perform();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction.toUpperCase());
        }
    }

    public void swipeScreen(String direction) {
        swipeScreen(direction, 2, 2);
    }

    public void swipeUpScreen() {
        swipeScreen("UP");
    }

    public void tap(By element) {
        new MultiTouchAction(getDriver())
                .add(new TouchAction<>(getDriver())
                        .tap(TapOptions.tapOptions().withElement(ElementOption.element(waitUntilClickable(element, TIMEOUT))))
                        .perform());
    }

    public void tap(String element) {
        tap(element(element));
    }

    public Integer getListElementSize(By element) {
        return getDriver().findElements(element).size();
    }

    public Dimension getListElementDimensionSize(By element) {
        return getDriver().findElement(element).getSize();
    }

    public Point getElementLocation(By element) {
        return getDriver().findElement(element).getLocation();
    }
}
