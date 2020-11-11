package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPages {

    public SmartBearOrderPages(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(linkText = "Order")
    public WebElement orderLink;

    @FindBy(xpath = "//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtName']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")
    public  WebElement streetInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox4']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")
    public  WebElement visaRadioButton;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    public WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")
    public WebElement expireDateInput;

    @FindBy(linkText = "Process")
    public WebElement processButton;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr/td[2]")
    public List<WebElement> namesColumn;




}
