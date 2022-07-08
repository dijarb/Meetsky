package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user")
    public WebElement usernameBox;

    @FindBy(id="password")
    public WebElement passwordBox;

    @FindBy(id="submit-form")
    public WebElement loginButton;

    @FindBy(id="lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "reset-password-submit")
    public WebElement resetPasswordButton;

    @FindBy(css = "p.warning.wrongPasswordMsg")
    public WebElement wrongUsernamePasswordText;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement eyeSign;


}
