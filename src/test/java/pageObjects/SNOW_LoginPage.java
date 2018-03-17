package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class SNOW_LoginPage extends Util{

    @FindBy(how = How.ID, using = "user_name")
    private WebElement userid;

    @FindBy(how = How.ID, using = "user_password")
    private WebElement password;

    @FindBy(how = How.ID, using = "sysverb_login")
    private WebElement login;

    @FindBy(how = How.XPATH, using = ".//a/button")
    private WebElement btncontinue;

    @FindBy(how = How.XPATH, using = ".//input[@id='home_title']")
    private WebElement welcome;

    @FindBy(how = How.XPATH, using = ".//img[@src='ITnowlogolarge.png']")
    private WebElement ESSLogo;

    @FindBy(how = How.XPATH, using = ".//span[@class='icon-loading']")
    private WebElement loading;

    public boolean isAt()
    {
        return isElementPresent(userid);
    }

    public void login() {
        userid.sendKeys("xxxxxxxxx");
        password.sendKeys("xxxxxxxxx");
        click(login);
        click(btncontinue);
        WaitForElementToDisappear(loading);
        SwitchToIFrame();
        WaitForElement(welcome);
        SwitchToDefault();
    }

    public void ESSlogin() {
        userid.sendKeys("xxxxxxxxx");
        password.sendKeys("xxxxxxxxx");
        click(login);
        WaitForElement(ESSLogo);
    }

    public SNOW_LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
}
