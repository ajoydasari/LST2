package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Util {


    @FindBy(how = How.ID, using = "home_title")
    private WebElement homePage000;

    @FindBy(how = How.ID, using = "user_info_dropdown")
    private WebElement userinfodropdown;

    @FindBy(how = How.XPATH, using = ".//a[text()='Impersonate User']/..")
    private WebElement impersonateUser;

    @FindBy(how = How.XPATH, using = ".//span[text()='Search for user']/../..")
    private WebElement searchForUserDropdown;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class,'icon-search')]")
    private WebElement globalSearchIcon;

    @FindBy(how = How.XPATH, using = ".//*[@id='sysparm_search']")
    private WebElement globalSearch;

    @FindBy(how = How.ID, using = "s2id_autogen2_search")
    private WebElement searchInput;

    @FindBy(how = How.ID, using = "impersonate_title")
    private WebElement impersonatePopup;

    @FindBy(how = How.XPATH, using = ".//input[@id='home_title']")
    private WebElement welcome;

    @FindBy(how = How.ID, using = "favorites_tab")
    private WebElement favouritesTab;

    @FindBy(how = How.XPATH, using = ".//a[@id='allApps_tab']")
    private WebElement allAppsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='icon-loading']")
    private WebElement loading;

    @FindBy(how = How.XPATH, using = ".//div[@id='output_messages']/button")
    private WebElement notificationMsg;

    @FindBy(how = How.XPATH, using = ".//button[@data-dismiss='alert']")
    private WebElement closeAlert;

    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(homePage000);
        SwitchToDefault();
    }

    public void Impersonate_User(String username) {
        if(isElementPresent(closeAlert))
            click(closeAlert);
        WaitForElement(userinfodropdown);
        click(userinfodropdown);
        WaitForElement(impersonateUser);
        click(impersonateUser);
        WaitForElement(searchForUserDropdown);
        click(searchForUserDropdown);
        sendKeysVerify(searchInput,username);
        sleep(2);
        ClickElementByXPath(".//ul[@class='select2-results']//div[text()='"+username+"']");
//        WaitForPageRefresh();
        try {
            WaitForElementToDisappear(impersonatePopup);
        }catch (Exception e){}

        SwitchToDefaultIFrame();
        WaitForElement(welcome);
        SwitchToDefault();
        new HomePage().WaitForPageLoad();
}


    public void Impersonate_ESSUser(String username) {
        WaitForElement(userinfodropdown);
        click(userinfodropdown);
        WaitForElement(impersonateUser);
        click(impersonateUser);
        WaitForElement(searchForUserDropdown);
        click(searchForUserDropdown);
        sendKeysVerify(searchInput,username);
        sleep(2);
        ClickElementByXPath(".//ul[@class='select2-results']//div[text()='"+username+"']");
        SwitchToDefault();
        new ESSLandingPage().WaitForPageLoad();
    }

    public void SelectFavouritesTab() {
        WaitForElementToDisappear(loading);
        WaitForElement(favouritesTab);
        if(favouritesTab.getAttribute("aria-expanded").equals("false")) {
            click(favouritesTab);
            WaitForPageRefresh();
        }
    }

    public void SelectAllAppsTab() {
        WaitForElementToDisappear(loading);
        WaitForElement(allAppsTab);
        if(allAppsTab.getAttribute("aria-expanded").equals("false")) {
            click(allAppsTab);
            WaitForPageRefresh();
        }
    }


    public void GlobalSearch(String searchText) {
            SwitchToDefault();
            WaitForElement(globalSearchIcon);
            click(globalSearchIcon);
            WaitForElement(globalSearch);
            globalSearch.clear();
            globalSearch.sendKeys(searchText);
            globalSearch.sendKeys(Keys.ENTER);

            SwitchToDefaultIFrame();
            WaitForElement(notificationMsg);
            click(notificationMsg);
    }

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
}

