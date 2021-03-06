package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ESSLandingPage extends Util {

    @FindBy(how = How.XPATH, using = ".//img[@src='ITnowlogolarge.png']")
    private WebElement ESSLogo;

    @FindBy(how = How.XPATH, using = ".//a[contains(@ng-if,'portal.logo')]")
    private WebElement ESSSession;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Resolve it yourself']")
    private WebElement resolveITYourself;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Report an Issue']")
    private WebElement reportAnIssue;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Chat with us']")
    private WebElement chatWithUs;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Order Something']")
    private WebElement orderSomething;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Track My Orders']")
    private WebElement trackMyOrders;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Track My Incidents']")
    private WebElement trackMyIncidents;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Search ITnow or enter catalogue code']")
    private WebElement searchEdit;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Search ITnow or enter catalogue code']/..//button")
    private WebElement searchLookup;

    @FindBy(how = How.XPATH, using = ".//span[text()='Home']")
    private WebElement home;

    @FindBy(how = How.XPATH, using = ".//span[text()='My Incidents']")
    private WebElement myIncidents;

    @FindBy(how = How.XPATH, using = ".//span[text()='My Open Incidents']")
    private WebElement myOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//span[text()='My Orders']")
    private WebElement myOrders;

    @FindBy(how = How.XPATH, using = ".//span[text()='My Open Orders']")
    private WebElement myOpenOrders;

    @FindBy(how = How.XPATH, using = ".//span[text()='My Closed Orders']")
    private WebElement myClosedOrders;

    @FindBy(how = How.XPATH, using = ".//span[text()='Order Something']")
    private WebElement myOrdersOrderSomething;

    @FindBy(how = How.XPATH, using = ".//span[text()='Chat']")
    private WebElement chat;

    @FindBy(how = How.XPATH, using = ".//span[text()='Cart']")
    private WebElement cart;

    @FindBy(how = How.XPATH, using = ".//ul[contains(@ng-if,'user.logged_in')]")
    private WebElement loggedinUser;

    @FindBy(how = How.XPATH, using = ".//a[text()='Logout']")
    private WebElement logout;

    @FindBy(how = How.XPATH, using = ".//th/div[contains(text(),'Number')]/../i[contains(@class,'down') and contains(@class,'grey')]")
    private WebElement sortNumberDesc;

    public boolean IsAt()
    {
        return(isElementPresent(ESSLogo));
    }

    public boolean IsAtESS()
    {
        return(isElementPresent(ESSSession));
    }

    public void WaitForPageLoad()
    {
        WaitForElement(ESSLogo);
    }

    public ESSLandingPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void selectOrderSomething()
    {
        click(orderSomething);
    }

    public void navigateToHome()
    {
        click(home);
        WaitForPageLoad();
    }

    public void MyOpenIncidents()
    {
        click(myIncidents);
        click(myOpenIncidents);
        WaitForPageRefresh();
    }

    public void MyOpenOrders()
    {
        click(myOrders);
        click(myOpenOrders);
        WaitForPageRefresh();
        click(sortNumberDesc);
        WaitForPageRefresh();
        if(isElementPresent(sortNumberDesc))
            click(sortNumberDesc);
        WaitForPageRefresh();
    }

    public void MyClosedOrders()
    {
        click(myOrders);
        click(myClosedOrders);
        WaitForPageRefresh();
    }

    public void ESSLogout()
    {
        click(loggedinUser);
        click(logout);
        WaitForPageRefresh();
    }


    public void MyOrders_OrderSomething()
    {
        click(myOrders);
        click(myOrdersOrderSomething);
        new ESSMyOpenRequestsPage().WaitForPageLoad();
    }


}

