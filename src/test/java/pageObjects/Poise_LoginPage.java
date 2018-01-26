package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Poise_LoginPage extends Util{
    @FindBy(how = How.ID, using = "userNameInput")
    private WebElement userid;

    @FindBy(how = How.ID, using = "passwordInput")
    private WebElement password;

    @FindBy(how = How.ID, using = "submitButton")
    private WebElement submit;

    @FindBy(how = How.XPATH, using = ".//div[text()='Welcome to ServiceNow']")
    private WebElement welcome;

    public boolean isAt()
    {
        return isElementPresent(userid);
    }

    public void login() {
        WaitForElement(userid);
        // We continue using the element just as before
        userid.sendKeys("poise\\xxxxxxxx");
        password.sendKeys("xxxxxxxxxx");
        click(submit);
        WaitForElement(welcome);
    }

    public Poise_LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
}
