package com.meetsky.step_definitions;

import com.meetsky.pages.DashboardPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;

public class StepDefinitions_Logout {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    StepDefinitions_Login login = new StepDefinitions_Login();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        if (!Driver.getDriver().getCurrentUrl().startsWith("https://qa.meetsky.net/index.php/apps/")){
            login.userEntersValidCredentials();
            login.userPressesEnterKey();
        }
        BrowserUtils.verifyUrlStartsWith("https://qa.meetsky.net/index.php/apps/");
    }

    @And("user clicks logout button")
    public void userClicksLogoutButton() {
        dashboardPage.logoutButton.click();
    }

    @And("User clicks step back button")
    public void userClicksStepBackButton() {
        Driver.getDriver().navigate().back();
    }
}
