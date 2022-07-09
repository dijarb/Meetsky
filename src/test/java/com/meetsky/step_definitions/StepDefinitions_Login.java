package com.meetsky.step_definitions;

import com.github.javafaker.Faker;
import com.meetsky.pages.DashboardPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class StepDefinitions_Login {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Given("User is in login page")
    public void user_is_in_login_page() {
        BrowserUtils.verifyTitle("Meetsky - QA");
    }
    
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @And("username is under profile icon")
    public void usernameIsUnderProfileIcon() {
        WebElement username = dashboardPage.usernameText;

        String expectedUsername = ConfigurationReader.getProperty("username");
        String actualUsername = username.getText();

        Assert.assertTrue(username.isDisplayed());
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        userEntersValidUsername();
        userEntersValidPassword();
    }

    @When("user enters valid username")
    public void userEntersValidUsername() {
        String username = ConfigurationReader.getProperty("username");
        loginPage.usernameBox.sendKeys(username);
    }

    @When("user enters valid password")
    public void userEntersValidPassword() {
        String password = ConfigurationReader.getProperty("password");
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("user can see dashboard page")
    public void userCanSeeDashboardPage() {
        BrowserUtils.verifyTitle("Files - Meetsky - QA");
    }

    @And("user presses Enter Key")
    public void userPressesEnterKey() {
        new Actions(Driver.getDriver()).sendKeys(Keys.ENTER).perform();
    }

    @When("user enters invalid credentials")
    public void userEntersInvalidCredentials() {
        userEntersInvalidUsername();
        userEntersInvalidPassword();
    }

    @And("user enters invalid username")
    public void userEntersInvalidUsername() {
        loginPage.usernameBox.sendKeys(new Faker().name().username());

    }

    @And("user enters invalid password")
    public void userEntersInvalidPassword() {
        loginPage.passwordBox.sendKeys(new Faker().bothify("####????"));
    }

    @Then("Wrong username or password message is displayed")
    public void wrongUsernameOrPasswordMessageIsDisplayed() {
        WebElement wrongUsernamePasswordText = loginPage.wrongUsernamePasswordText;

        BrowserUtils.waitForElementToDisplay(wrongUsernamePasswordText);
        Assert.assertTrue(wrongUsernamePasswordText.isDisplayed());
    }

    @Then("Please fill out this field message is displayed on username box")
    public void pleaseFillOutThisFieldMessageIsDisplayedOnUsernameBox() {
        Assert.assertEquals("Please fill out this field.", loginPage.usernameBox.getAttribute("validationMessage"));
    }


    @Then("Please fill out this field message is displayed on password box")
    public void pleaseFillOutThisFieldMessageIsDisplayedOnPasswordBox() {
        Assert.assertEquals("Please fill out this field.", loginPage.passwordBox.getAttribute("validationMessage"));
    }

    @Then("user can see password in form of dots")
    public void userCanSeePasswordInFormOfDots() {
        Assert.assertEquals("password", loginPage.passwordBox.getAttribute("type"));
    }

    @And("user clicks on the eye sign")
    public void userClicksOnTheEyeSign() {
        loginPage.eyeSign.click();
    }
    @And("user clicks on profile icon")
    public void userClicksOnProfileIcon() {
        dashboardPage.icon.click();
    }
    @Then("user can see password explicitly")
    public void userCanSeePasswordExplicitly() {
        Assert.assertEquals("text", loginPage.passwordBox.getAttribute("type"));
    }

    @Given("user can see Forgot password? link")
    public void userCanSeeForgotPasswordLink() {
        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed());
    }
    @And("user clicks on Forgot password? link")
    public void userClicksOnForgotPasswordLink() {
        loginPage.forgotPasswordLink.click();
    }
    @Then("user can see Reset password text on the next page")
    public void userCanSeeResetPasswordTextOnTheNextPage() {
        WebElement resetButton = loginPage.resetPasswordButton;

        BrowserUtils.waitForElementToDisplay(resetButton);
        Assert.assertTrue(resetButton.isDisplayed());
    }
    @Given("username and password boxes are empty")
    public void usernameAndPasswordBoxesAreEmpty() {
        loginPage.usernameBox.clear();
        loginPage.passwordBox.clear();
    }

    @Then("user can see valid placeholders on Username and Password fields")
    public void userCanSeeValidPlaceholdersOnUsernameAndPasswordFields() {
        Assert.assertEquals("Username or email", loginPage.usernameBox.getAttribute("placeholder"));
        Assert.assertEquals("Password", loginPage.passwordBox.getAttribute("placeholder"));
    }

    @Given("browser is restarted")
    public void browserIsRestarted() {
        String url = Driver.getDriver().getCurrentUrl();

        Driver.closeDriver();
        Driver.getDriver().get(url);
    }


}
