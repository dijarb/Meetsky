package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement icon;

    @FindBy(xpath = "//span[@class='user-status-menu-item__header']")
    public WebElement usernameText;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;
}