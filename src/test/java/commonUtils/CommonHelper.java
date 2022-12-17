package commonUtils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CommonHelper {


    public static void openWebPage(String url, WebDriver driver) {
        driver.navigate().to(url);
    }

    public static void keypadDown(WebElement element, WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element.sendKeys(Keys.DOWN);
    }

    public static void keypadEnter(WebElement element, WebDriver driver) {

        element.sendKeys(Keys.ENTER);
    }

    public static String getElementTextValue(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String Text = wait.until(ExpectedConditions.visibilityOf(po)).getText();
        return Text;
    }

    public static String getElementAttribute(String Attribute, WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String attribute = wait.until(ExpectedConditions.visibilityOf(po)).getAttribute(Attribute);
        return attribute;
    }

    public static void waitUntilElementAppears(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po));
    }

    public static void clickWhenReady(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(po));
        wait.until(ExpectedConditions.visibilityOf(po)).click();
    }


    public static void clearField(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).clear();
    }

    public static void doubleClick(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po));
        Actions builder = new Actions(driver);
        builder.doubleClick(po).perform();
    }

    public static void verifyElementAppears(WebElement Po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(Po));
    }

    public static void sendText(WebElement po, String Text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).sendKeys(Text);
    }

    public static void sendTextSlowly(WebElement po, String Text, WebDriver driver) {
        for (int i = 0; i < Text.length(); i++) {
            char c = Text.charAt(i);
            String s = new StringBuilder().append(c).toString();
            po.sendKeys(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void addScreenshotToCucumberReport(Scenario scenario, WebDriver driver) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }

    public static void scrollToElement(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", po);
    }

    public static void scrollUpToElement(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", po);
    }

    public static void scrollToTheTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1000)");
    }

    public static String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void switchToOpenedTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public static void clickUsingJS(WebElement po, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", po);
    }

    public static void sendTextUsingJS(String text, WebElement po, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementByXpath('" + po + "').value ='" + text + "'");
    }


    public static WebElement findElementByText(String tagName, String text, WebDriver driver) {
        return driver.findElement(By.xpath("//" + tagName + "[text()=" + "'" + text + "'" + "]"));
    }

    public static WebElement findElementByAny(String tagName, String attribute, String attributeValue, WebDriver driver) {
        return driver.findElement(By.xpath("//" + tagName + "[@" + attribute + "=" + "'" + attributeValue + "'" + "]"));
    }

    public static void waitElementToClickable(WebElement po, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(po));
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}