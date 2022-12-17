package StepDefinition.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login.HomePageHelper;

public class HomePageStepDefinition {


    HomePageHelper homePageHelper;


    public HomePageStepDefinition() {
        homePageHelper = new HomePageHelper();
    }

    @Given("User Opens Home Page")
    public void UserEntersHisRegisteredNIDAndPassword() {
        homePageHelper.verifyHomePageIsOpened();
    }

    @And("^User Search For Item \"([^\"]*)\"$")
    public void userSearchForItem(String item) {
        homePageHelper.SearchForProduct(item);
    }

    @And("Print Search Count")
    public void printSearchCount() {
        homePageHelper.printSearchCount();
    }

    @Then("^Verify Search Result For \"([^\"]*)\"$")
    public void verifySearchResult(String item) {
        homePageHelper.verifySearchResult(item);
    }

}
