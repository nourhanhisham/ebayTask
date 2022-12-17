package pages.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {

    @FindBy(xpath = "//span[text()=\"Hi! \"]")
    WebElement hiUserLink;

    @FindBy(xpath = "//input[@placeholder=\"Search for anything\"]")
    WebElement searchTextBox;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@class=\"srp-controls__control srp-controls__count\"]/h1/span)[2]")
    WebElement searchResults;

    @FindBy(xpath = "(//div[@class=\"srp-controls__control srp-controls__count\"]/h1/span)[1]")
    WebElement resultsCount;

}
