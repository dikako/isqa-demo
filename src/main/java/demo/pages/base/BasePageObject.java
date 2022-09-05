package demo.pages.base;

import demo.utils.Utils;
import demo.driver.IOSDriverInstance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static demo.data.Data.*;
import static demo.utils.Constants.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class BasePageObject {

    public IOSDriver<?> getDriver() {
        return IOSDriverInstance.iosDriver;
    }

    public IOSElement waitUntil(ExpectedCondition<WebElement> conditions, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        return (IOSElement) wait.until(conditions);
    }

    public IOSElement waitUntil(ExpectedCondition<WebElement> conditions) {
        return waitUntil(conditions, TIMEOUT);
    }

    public IOSElement waitUntilClickable(By by, Integer timeout) {
        return waitUntil(ExpectedConditions.elementToBeClickable(by), timeout);
    }

    public IOSElement waitUntilVisible(By by) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), TIMEOUT);
    }

    public IOSElement waitUntilVisible(By by, Integer timeout) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), timeout);
    }

    public IOSElement waitUntilPresent(By by) {
        return waitUntil(ExpectedConditions.presenceOfElementLocated(by), TIMEOUT);
    }

    public List<WebElement> waitAllUntilPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public IOSElement waitUntilPresent(By by, Integer timeoutInSeconds) {
        return waitUntil(ExpectedConditions.presenceOfElementLocated(by), timeoutInSeconds);
    }

    public Boolean waitUntilInvisible(By by, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitUntilInvisible(By by) {
        return waitUntilInvisible(by, TIMEOUT);
    }

    /**
     * Begin Region click by locator
     * You can just provide your element:
     * examples:
     * id_your element id, name_your element name or xpath_your xpath element
     *
     * @author Fransiskus Andika Setiawan - 08/03/2022
     */
    public void clickOn(By by, int index) {
        By element = (By) getDriver().findElements(by).get(index);
        waitUntilClickable(element, TIMEOUT).click();
    }

    public void clickOn(MobileBy by, Integer timeoutInSeconds) {
        waitUntilClickable(by, timeoutInSeconds).click();
    }

    public void clickOn(MobileBy by) {
        clickOn(by, TIMEOUT);
    }

    public void clickOn(By by, Integer timeoutInSeconds) {
        waitUntilClickable(by, timeoutInSeconds).click();
    }

    public void clickOn(By by) {
        clickOn(by, TIMEOUT);
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

    public void clickOn(String element) {
        clickOn(element(element));
    }

    public void clickOn(String element, Object args) {
        clickOn(element(element, args));
    }

    public void clickOn(String element, int index) {
        clickOn(element(element), index);
    }

    public void clickOn(String element, int index, Object args) {
        clickOn(element(element, args), index);
    }

    /**
     * End Region click by locator
     */

    public IOSElement find(By by) {
        return waitUntilPresent(by);
    }

    public IOSElement finder(MobileBy by) {
        return waitUntilPresent(by);
    }

    public IOSElement find(String cssSelector) {
        return waitUntilPresent(By.cssSelector(cssSelector));
    }

    /**
     * Begin Region type by locator
     * You can just provide your element and your text input:
     * examples:
     * id_your element id, name_your element name or xpath_your xpath element + your text input
     *
     * @author Fransiskus Andika Setiawan - 08/03/2022
     */
    public void typeOn(By by, int index, String text) {
        IOSElement element = (IOSElement) getDriver().findElements(by).get(index);
        element.clear();
        element.setValue(text);
    }

    public void typeOn(By by, String text) {
        IOSElement element = waitUntilVisible(by);
        element.setValue(text);
    }

    public void typeOn(By by, Integer text) {
        IOSElement element = waitUntilVisible(by);
        element.clear();
        element.setValue(String.valueOf(text));
    }

    public void typeOn(By by, Double text) {
        IOSElement element = waitUntilVisible(by);
        element.clear();
        element.setValue(String.valueOf(text));
    }

    public void typeOn(By by, Keys keys) {
        IOSElement element = waitUntilVisible(by);
        element.sendKeys(keys);
    }

    public void typeOn(String element, String text) {
        typeOn(element(element), text);
    }

    public void typeOn(String element, String text, Object args) {
        typeOn(element(element, args), text);
    }

    public void typeOn(String element, int index, String text) {
        typeOn(element(element), index, text);
    }

    public void typeOn(String element, int index, String text, Object args) {
        typeOn(element(element, args), index, text);
    }

    public void typeOn(String element, Keys keys) {
        typeOn(element(element), keys);
    }

    public void typeOn(String element, Keys keys, Object args) {
        typeOn(element(element, args), keys);
    }

    public void clearText(By by) {
        IOSElement element = waitUntilVisible(by);
        element.clear();
    }

    public void clearText(By by, int index) {
        IOSElement element = (IOSElement) getDriver().findElements(by).get(index);
        element.clear();
    }

    public void clearText(String element) {
        clearText(element(element));
    }

    public void clearText(String element, Object args) {
        clearText(element(element, args));
    }

    public void clearText(String element, int index) {
        clearText(element(element), index);
    }

    public void clearText(String element, int index, Object args) {
        clearText(element(element, args), index);
    }
    /*
     * End Region type by locator
     */

    public List<WebElement> findAll(By by) {
        return waitAllUntilPresent(by);
    }

    public List<WebElement> findAll(String element) {
        return findAll(element(element));
    }

    public List<WebElement> findAll(String element, Object args) {
        return findAll(element(element, args));
    }

    public Alert getAlert() {
        return getDriver().switchTo().alert();
    }

    /**
     * Begin Region check element is visible by locator
     * You can just provide your element and your text input:
     * examples:
     * id_your element id, name_your element name or xpath_your xpath element + your text input
     *
     * @author Fransiskus Andika Setiawan - 08/04/2022
     */
    public Boolean isVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 1);
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchFrameException.class);

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isVisible(By by, int index) {
        By element = (By) getDriver().findElements(by).get(index);
        return isVisible(element);
    }

    public Boolean isVisible(String element) {
        return isVisible(element(element));
    }

    public Boolean isVisible(String element, Object args) {
        return isVisible(element(element, args));
    }

    public Boolean isVisible(String element, int index) {
        return isVisible(element(element), index);
    }

    public Boolean isVisible(String element, int index, Object args) {
        return isVisible(element(element, args), index);
    }
    /*
     * End Region check element is visible by locator
     */

    /**
     * Begin Region check element is present by locator
     * You can just provide your element and your text input:
     * examples:
     * id_your element id, name_your element name or xpath_your xpath element + your text input
     *
     * @author Fransiskus Andika Setiawan - 07/04/2022
     */
    public Boolean isPresent(By by) {
        return getListElementSize(by) != 0;
    }

    public Boolean isPresent(By by, int index) {
        By element = (By) getDriver().findElements(by).get(index);
        return isPresent(element);
    }

    public Boolean isPresent(String element) {
        return isPresent(element(element));
    }

    public Boolean isPresent(String element, Object args) {
        return isPresent(element(element, args));
    }

    public Boolean isPresent(String element, int index) {
        return isPresent(element(element), index);
    }

    public Boolean isPresent(String element, int index, Object args) {
        return isPresent(element(element, args), index);
    }

    /**
     * End Region check element is present by locator
     */

    public Boolean isDisplayed(By by) {
        return find(by).isDisplayed();
    }

    public Boolean isDisplayed(String cssSelector) {
        return find(cssSelector).isDisplayed();
    }

    /**
     * Begin Region get attribute on element by locator
     * You can just provide your element and your text input:
     * examples:
     * id_your element id, name_your element name or xpath_your xpath element + your text input
     *
     * @author Fransiskus Andika Setiawan - 08/04/2022
     */
    public String getAttribute(By by, String attributeName) {
        return find(by).getAttribute(attributeName);
    }

    public String getAttribute(By by, String attributeName, int index) {
        return findAll(by).get(index).getAttribute(attributeName);
    }

    public String getAttribute(String element, String attribute) {
        return getAttribute(element(element), attribute);
    }

    public String getAttribute(String element, String attribute, Object args) {
        return getAttribute(element(element, args), attribute);
    }

    public String getAttribute(String element, String attribute, int index) {
        return getAttribute(element(element), attribute, index);
    }

    public String getAttribute(String element, String attribute, int index, Object args) {
        return getAttribute(element(element, args), attribute, index);
    }

    /**
     * End Region get attribute on element by locator
     */


    public TouchActions getTouchActions() {
        return new TouchActions(getDriver());
    }

    public TouchAction getTouchAction() {
        return new TouchAction<>(getDriver());
    }

    public void scrollIntoView(By locator) {
        WebElement element = find(locator);
        JavascriptExecutor js = (JavascriptExecutor) IOSDriverInstance.iosDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Begin Region scroll
     * Function for scroll in app native iOS
     */
    public void scrollToElement(MobileElement element, String direction) {
        final int ANIMATION_TIME = 200;
        final HashMap<String, String> scrollObject = new HashMap<String, String>();
        switch (direction) {
            case "DOWN":
            case "UP":
            case "LEFT":
            case "RIGHT":
                scrollObject.put("direction", direction.toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("mobileScrollElementIOS(): dir: '" + direction + "' NOT supported");
        }
        scrollObject.put("element", element.getId());
        try {
            getDriver().executeScript(SCROLL, scrollObject);
            Thread.sleep(ANIMATION_TIME);
        } catch (Exception e) {
            System.err.println("mobileScrollElementIOS(): FAILED\n" + e.getMessage());
        }
    }

    public void swipeToElements(MobileElement element, String direction, int numberOfScroll) {
        for (int i = 1; i <= numberOfScroll; i++) {
            scrollToElement(element, direction);
        }
    }

    public void scrollToRight(MobileElement element) {
        scrollToElement(element, "RIGHT");
    }

    public void scrollToLeft(MobileElement element) {
        scrollToElement(element, "LEFT");
    }

    public void scrollToUp(MobileElement element) {
        scrollToElement(element, "UP");
    }

    public void scrollToDown(MobileElement element) {
        scrollToElement(element, "DOWN");
    }

    public void scrollScreen(String direction) {
        final int ANIMATION_TIME = 800;
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (direction) {
            case "DOWN":
                scrollObject.put("direction", "down");
                break;
            case "UP":
                scrollObject.put("direction", "up");
                break;
            case "LEFT":
                scrollObject.put("direction", "left");
                break;
            case "RIGHT":
                scrollObject.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + direction + "' NOT supported");
        }
        try {
            getDriver().executeScript(SCROLL, scrollObject);
            Thread.sleep(ANIMATION_TIME);
        } catch (Exception e) {
            System.err.println("mobileScrollIOS(): FAILED\n" + e.getMessage());
        }
    }

    public void scrollToRight() {
        scrollScreen("RIGHT");
    }

    public void scrollToLeft() {
        scrollScreen("LEFT");
    }

    public void scrollToUp() {
        scrollScreen("UP");
    }

    public void scrollToDown() {
        scrollScreen("DOWN");
    }
    /* End Region scroll */

    public void elementDisplayed(By element) {
        getDriver().findElement(element);
    }

    /**
     * Begin Region long press
     * Function for long press in app native iOS
     *
     * @author Fransiskus Andika Setiawan - 12/01/2022
     */
    public void longPress(int x1, int yStart1, int yEnd1) {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / x1;
        int yStart = size.height / yStart1;
        int yEnd = size.height / yEnd1;
        new TouchAction<>(getDriver())
                .longPress(point(x, yStart))
                .moveTo(point(x, yEnd))
                .release()
                .perform();
    }

    public void longPres(By from, By to) {
        new TouchAction<>(getDriver()).longPress(ElementOption.element(find(from)))
                .moveTo(ElementOption.element(find(to)))
                .release()
                .perform();
    }

    public void longPress(By element, int y, int xStart, int xEnd) {
        Dimension size = getListElementDimensionSize(element);
        int yElement = getElementLocation(element).y + (size.height / y);
        int xStarts = size.width / xStart;
        int xEnds = size.width / xEnd;
        new TouchAction<>(getDriver())
                .longPress(point(xStarts, yElement))
                .moveTo(point(xEnds, yElement))
                .release()
                .perform();
    }

    public void longPress(By element, int y, int xStart) {
        Dimension size = getListElementDimensionSize(element);
        int yElement = getElementLocation(element).y + (size.height / y);
        int xEnd = size.width;
        new TouchAction<>(getDriver())
                .longPress(point(xStart, yElement))
                .moveTo(point(xEnd, yElement))
                .release()
                .perform();
    }

    public void longPress(String element, int y, int xStart, int xEnd) {
        longPress(element(element), y, xStart, xEnd);
    }

    public void longPress(String element, int y, int xStart, int xEnd, Object args) {
        longPress(element(element, args), y, xStart, xEnd);
    }

    public void longPress(String element, int y, int xStart) {
        longPress(element(element), y, xStart);
    }

    public void longPress(String element, int y, int xStart, Object args) {
        longPress(element(element, args), y, xStart);
    }

    public void longPress(String from, String to) {
        longPres(element(from), element(to));
    }
    /* End Region long press */

    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
    }

    /**
     * Begin Region swipe
     * Function for swipe
     *
     * @author Fransiskus Andika Setiawan - 17/01/2022
     */
    public void swipe(String direction) {
        Map<String, Object> params = new HashMap<>();
        switch (direction.toLowerCase()) {
            case "down":
                params.put("direction", "down");
                break;
            case "up":
                params.put("direction", "up");
                break;
            case "left":
                params.put("direction", "left");
                break;
            case "right":
                params.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + direction + "' NOT supported");
        }
        this.getDriver().executeScript(SWIPE, params);
    }

    public void swipeDown() {
        swipe("down");
    }

    public void swipeUp() {
        swipe("up");
    }

    public void swipeRight() {
        swipe("right");
    }

    public void swipeLeft() {
        swipe("left");
    }

    public void swipeUpToElement(By element) {
        for (int i = 0; i < DEFAULT_SWIPE_DURATION; i++) {
            if (!isPresent(element)) {
                swipeUp();
            }
        }
    }

    public void swipeLeftToElement(By element) {
        for (int i = 0; i < DEFAULT_SWIPE_DURATION; i++) {
            if (!isPresent(element)) {
                swipeLeft();
            }
        }
    }

    public void swipeDownToElement(By element) {
        for (int i = 0; i < DEFAULT_SWIPE_DURATION; i++) {
            if (!isPresent(element)) {
                swipeDown();
            }
        }
    }

    public void swipeRightToElement(By element) {
        for (int i = 0; i < DEFAULT_SWIPE_DURATION; i++) {
            if (!isPresent(element)) {
                swipeRight();
            }
        }
    }
    /* End region swipe */

    /* This function for hide keyboard */
    public void hideKeyboard() {
        getDriver().switchTo().activeElement().sendKeys(Keys.RETURN);
    }

    public void tapDoneKeyboard() {
        tap("KEY_DONE");
    }

    /**
     * Begin Region scroll and click element
     * This function for handle scroll and click to element
     * with max scroll 10% - 100%
     *
     * @author Fransiskus Andika Setiawan - 17/01/2022
     */
    public void clickOn(By element, String needScroll) {
        IOSElement scrollTo = find(element);
        try {
            switch (needScroll) {
                case "10%":
                    scrollTo.sendKeys("0.1");
                    break;
                case "20%":
                    scrollTo.sendKeys("0.2");
                    break;
                case "30%":
                    scrollTo.sendKeys("0.3");
                    break;
                case "40%":
                    scrollTo.sendKeys("0.4");
                    break;
                case "50%":
                    scrollTo.sendKeys("0.5");
                    break;
                case "60%":
                    scrollTo.sendKeys("0.6");
                    break;
                case "70%":
                    scrollTo.sendKeys("0.7");
                    break;
                case "80%":
                    scrollTo.sendKeys("0.8");
                    break;
                case "90%":
                    scrollTo.sendKeys("0.9");
                    break;
                case "100%":
                    scrollTo.sendKeys("1.0");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + needScroll);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Success auto scroll to " + element);
        }
    }

    public void scrollToElementAndClick(By element) {
        clickOn(element, "50%");
    }

    public void scrollToElementAndClick(String element) {
        scrollToElementAndClick(element(element));
    }

    public void scrollToElementAndClick(String element, Object args) {
        scrollToElementAndClick(element(element, args));
    }
    /* End Region scroll and click element */

    public int getOrderNumber(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            setMaxNumber(i);
        }
        return getMaxNumber();
    }

    public void goToDeeplink(String deeplink) {
        getDriver().get(appIdentifier + deeplink);
    }

    public void inputTextElementActive(String text) {
        WebElement element = getDriver().switchTo().activeElement();
        element.sendKeys(text);
    }

    public String getText(By by) {
        return find(by).getText();
    }

    public String getText(By by, int index) {
        return findAll(by).get(index).getText();
    }

    public String getText(String element) {
        return getText(element(element));
    }

    public String getText(String element, Object args) {
        return getText(element(element, args));
    }

    public String getText(String element, int index) {
        return getText(element(element), index);
    }

    public String getText(String element, int index, Object args) {
        return getText(element(element, args), index);
    }

    public String getText() {
        return getDriver().switchTo().activeElement().getText();
    }

    /**
     * Begin Region swipe to specified element locator
     * Swipe in specified element container
     *
     * @author Fransiskus Andika Setiawan - 02/02/2022
     */
    protected void maxSwipeCountError(By elementLocator, int iteration, int swipeCount) {
        if (iteration == swipeCount - 1) {
            throw new NoSuchElementException("Element with locator : " + elementLocator + " doesn't exist!");
        }
    }

    public void coordinateSwipe(By element) {
        Dimension size = find(element).getSize();
        Point point = find(element).getCenter();

        setX0((int) ((double) size.width * 0.8D));
        setX1((int) ((double) size.width * 0.2D));
        setY0((int) ((double) size.height * 0.7D));
        setY1((int) ((double) size.height * 0.3D));
        setX(point.getX());
        setY(point.getY());
    }

    public void swipeToSpecifiedElement(String direction, By element) {
        coordinateSwipe(element);
        switch (direction.toUpperCase()) {
            case "RIGHT":
                new TouchAction<>(getDriver()).press((new PointOption<>()).withCoordinates(x1, y))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo((new PointOption<>()).withCoordinates(x0, y))
                        .release()
                        .perform();
                break;
            case "LEFT":
                new TouchAction<>(getDriver()).press((new PointOption<>()).withCoordinates(x0, y))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo((new PointOption<>()).withCoordinates(x1, y))
                        .release()
                        .perform();
                break;
            case "UP":
                new TouchAction<>(getDriver()).press((new PointOption<>()).withCoordinates(x, y0))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo((new PointOption<>()).withCoordinates(x, y1))
                        .release()
                        .perform();
                break;
            case "DOWN":
                new TouchAction<>(getDriver()).press((new PointOption<>()).withCoordinates(x, y1))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo((new PointOption<>()).withCoordinates(x, y0))
                        .release()
                        .perform();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction.toUpperCase());
        }
    }

    public void swipeLeftToSpecifiedElement(By element) {
        swipeToSpecifiedElement("LEFT", element);
    }

    public void swipeRightToSpecifiedElement(By element) {
        swipeToSpecifiedElement("RIGHT", element);
    }

    public void swipeUpToSpecifiedElement(By element) {
        swipeToSpecifiedElement("UP", element);
    }

    public void swipeDownToSpecifiedElement(By element) {
        swipeToSpecifiedElement("DOWN", element);
    }

    public void swipeLeftToSpecifiedElement(By element, int maxScroll) {
        for (int i = 0; i < maxScroll; i++) {
            swipeToSpecifiedElement("LEFT", element);
        }
    }

    public void swipeLeftToSpecifiedElement(String element, int maxScroll) {
        swipeLeftToSpecifiedElement(element(element), maxScroll);
    }

    public void swipeLeftToSpecifiedElement(String element, int maxScroll, Object args) {
        swipeLeftToSpecifiedElement(element(element, args), maxScroll);
    }

    public void swipeRightToSpecifiedElement(By element, int maxScroll) {
        for (int i = 0; i < maxScroll; i++) {
            swipeToSpecifiedElement("RIGHT", element);
        }
    }

    public void swipeUpToSpecifiedElement(By element, int maxScroll) {
        for (int i = 0; i < maxScroll; i++) {
            swipeToSpecifiedElement("UP", element);
        }
    }

    public void swipeDownToSpecifiedElement(By element, int maxScroll) {
        for (int i = 0; i < maxScroll; i++) {
            swipeToSpecifiedElement("DOWN", element);
        }
    }

    public void swipeToSpecifiedElement(String direction, By elementContainer, By elementLocator) {
        for (int i = 0; i < TIMEOUT; ++i) {
            if (!isPresent(elementLocator)) {
                swipeToSpecifiedElement(direction, elementContainer);
            }
        }
    }

    public void swipeLeftToSpecifiedElement(By elementContainer, By elementLocator) {
        swipeToSpecifiedElement("LEFT", elementContainer, elementLocator);
    }

    public void swipeRightToSpecifiedElement(By elementContainer, By elementLocator) {
        swipeToSpecifiedElement("RIGHT", elementContainer, elementLocator);
    }

    public void swipeUpToSpecifiedElement(By elementContainer, By elementLocator) {
        swipeToSpecifiedElement("UP", elementContainer, elementLocator);
    }

    public void swipeDownToSpecifiedElement(By elementContainer, By elementLocator) {
        swipeToSpecifiedElement("DOWN", elementContainer, elementLocator);
    }
    /* End Region swipe to specified element locator */

    /**
     * Begin Region swipe in screen apps
     * Swipe in screen apps
     *
     * @author Fransiskus Andika Setiawan - 02/02/2022
     */
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

    public void swipeUpScreenToElement(By element) {
        while (!isPresent(element) || !isVisible(element)) {
            swipeScreen("UP");
        }
    }

    public void swipeUpScreenToElement(String element) {
        swipeUpScreenToElement(element(element));
    }

    public void swipeUpScreenToElement(String element, Object args) {
        swipeUpScreenToElement(element(element, args));
    }

    public void swipeDownScreenToElement(By element) {
        while (!isPresent(element) || !isVisible(element)) {
            swipeScreen("DOWN");
        }
    }

    public void refreshPage() {
        swipeScreen("DOWN");
    }

    public void refreshPage(int numberOfRefresh) {
        for (int i = 1; i <= numberOfRefresh; i++) {
            swipeDown();
        }
    }

    public void swipeUpScreen(int max) {
        for (int i = 0; i < max; i++) {
            swipeScreen("UP");
        }
    }

    public void swipeUpScreen(int max, int divideMidX, int divideMidY) {
        for (int i = 0; i < max; i++) {
            swipeScreen("UP", divideMidX, divideMidY);
        }
    }

    public void swipeUpScreen(int divideMidX, int divideMidY) {
        swipeScreen("UP", divideMidX, divideMidY);
    }

    public void swipeUpScreen() {
        swipeScreen("UP");
    }

    public void swipeDownScreen(int max) {
        for (int i = 0; i < max; i++) {
            swipeScreen("DOWN");
        }
    }

    public void swipeDownScreen(int max, int divideMidX, int divideMidY) {
        for (int i = 0; i < max; i++) {
            swipeScreen("DOWN", divideMidX, divideMidY);
        }
    }

    public void swipeDownScreen(int divideMidX, int divideMidY) {
        swipeScreen("DOWN", divideMidX, divideMidY);
    }

    public void swipeDownScreen() {
        swipeScreen("DOWN");
    }
    /* End Region swipe in screen apps */

    public void deleteTextByLength(By element, int length) {
        clickOn(element);
        By elementDelete = MobileBy.id("Delete");
        for (int i = 0; i <= length; i++) {
            clickOn(elementDelete);
        }
    }

    public String toRupiah(Double number) {
        return String.format("%,.0f", number);
    }

    public boolean regexMatcher(String data, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }

    public void popupAction(String action) {
        String element;
        switch (action.toUpperCase()) {
            case "DONT ALLOW":
                element = "NATIVE_POPUP_DONT_ALLOW";
                break;
            case "ALLOW":
                element = "NATIVE_POPUP_ALLOW";
                break;
            case "ASK APP NOT TO TRACK":
                element = "NATIVE_ASK_APP_NOT_TO_TRACK";
                break;
            case "OK":
                element = "NATIVE_POPUP_OK";
                break;
            case "TONTON SEKARANG":
                element = "NATIVE_POPUP_TONTON_SEKARANG";
                break;
            case "CANCEL":
                element = "NATIVE_POPUP_CANCEL";
                break;
            case "LOGOUT":
                element = "NATIVE_POPUP_LOGOUT";
                break;
            case "ALLOW ACCESS ALL PHOTOS":
                element = "NATIVE_POPUP_ALLOW_ACCESS_TO_ALL_PHOTOS";
                break;
            case "TAKE PICTURE FROM CAMERA":
                element = "NATIVE_POPUP_TAKE_PICTURE_FROM_CAMERA";
                break;
            case "CHOOSE EXISTING PICTURE":
                element = "NATIVE_POPUP_CHOOSE_EXISTING_PICTURE";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action.toUpperCase());
        }
        if (isPresent(element)) {
            clickOn(element);
        }
    }

    public void clearField(By by) {
        IOSElement element = waitUntilVisible(by);
        element.clear();
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Begin Region tap action
     * If you need click specific coordinate Search coordinates in your appium inspection
     *
     * @author Fransiskus Andika Setiawan - 07/04/2022
     */
    public void tapByCoordinates(int x, int y) {
        new MultiTouchAction(getDriver())
                .add(new TouchAction<>(getDriver())
                        .tap(point(x, y))
                        .waitAction(waitOptions(ofSeconds(TIMEOUT)))
                        .perform());
    }

    public void tap(By element) {
        new MultiTouchAction(getDriver())
                .add(new TouchAction<>(getDriver())
                        .tap(TapOptions.tapOptions().withElement(ElementOption.element(waitUntilClickable(element, TIMEOUT))))
                        .perform());
    }

    public void tap(By by, int index) {
        IOSElement element = (IOSElement) getDriver().findElements(by).get(index);
        new MultiTouchAction(getDriver())
                .add(new TouchAction<>(getDriver())
                        .tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
                        .perform());
    }

    public void tap(String element) {
        tap(element(element));
    }

    public void tap(String element, Object args) {
        tap(element(element, args));
    }

    public void tap(String element, int index) {
        tap(element(element), index);
    }

    public void tap(String element, int index, Object args) {
        tap(element(element, args), index);
    }
    /*
     * End Region tap action
     */

    /**
     * Begin Region get clipboard
     * Not support in Real Devices
     *
     * @author Fransiskus Andika Setiawan - 11/04/2022
     */
    public String getClipboard() {
        getDriver().getClipboard(ClipboardContentType.PLAINTEXT);
        return getDriver().getClipboardText();
    }
    /*
     * End Region get clipboard
     */


    /**
     * Begin Region get element size
     *
     * @author Fransiskus Andika Setiawan - 22/04/2022
     */
    public Integer getListElementSize(By element) {
        return getDriver().findElements(element).size();
    }

    public Dimension getListElementDimensionSize(By element) {
        return getDriver().findElement(element).getSize();
    }

    public Integer getListElementSize(String element) {
        return getListElementSize(element(element));
    }

    public Integer getListElementSize(String element, Object args) {
        return getListElementSize(element(element, args));
    }

    public Dimension getListElementDimensionSize(String element) {
        return getListElementDimensionSize(element(element));
    }

    public Point getElementLocation(By element) {
        return getDriver().findElement(element).getLocation();
    }
    /*
     * End Region get element size
     */

    /**
     * Begin Region tap first element and last element
     *
     * @author Fransiskus Andika Setiawan - 03/06/2022
     */
    public void tapFirstElement(By element) {
        tap(element, 0);
    }

    public void tapFirstElement(String element) {
        tapFirstElement(element(element));
    }

    public void tapFirstElement(String element, Object args) {
        tapFirstElement(element(element, args));
    }

    public void tapLastElement(By element) {
        tap(element, getListElementSize(element) - 1);
    }

    public void tapLastElement(String element) {
        tapLastElement(element(element));
    }

    public void tapLastElement(String element, Object args) {
        tapLastElement(element(element, args));
    }
    /*
     * End Region tap first element and last element
     */

    /**
     * Begin Region handle choose picker wheel
     *
     * @author Fransiskus Andika Setiawan - 21/07/2022
     */
    public void scrollKeysPickerWheels(String[] data) {
        for (int i = 0; i < data.length; i++) {
            IOSElement element = (IOSElement) getDriver().findElement(By.xpath("*//XCUIElementTypePickerWheel[" + (i + 1) + "]"));
            element.sendKeys(data[i]);
        }
    }
    /*
     * End Region handle choose picker wheel
     */
}
