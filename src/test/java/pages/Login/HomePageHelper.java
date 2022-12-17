package pages.Login;

import StepDefinition.Hooks;
import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageHelper extends HomePageElements {
    WebDriver driver = Hooks.getWebDriver();

    public HomePageHelper() {
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageIsOpened() {
        CommonHelper.waitUntilElementAppears(hiUserLink, driver);
        Assert.assertTrue(hiUserLink.isDisplayed());
    }

    public void SearchForProduct(String item) {
        CommonHelper.waitUntilElementAppears(searchTextBox, driver);
        CommonHelper.sendText(searchTextBox, item, driver);
        CommonHelper.waitUntilElementAppears(searchButton, driver);
        CommonHelper.clickWhenReady(searchButton, driver);
    }

    public void verifySearchResult(String itemName) {
        CommonHelper.waitUntilElementAppears(searchResults, driver);
        String resultName = CommonHelper.getElementTextValue(searchResults, driver);
        Assert.assertTrue(resultName.contains(itemName));
    }

    public void printSearchCount() {
        CommonHelper.waitUntilElementAppears(resultsCount, driver);
        System.out.println(resultsCount.getText());
    }
}
