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

    protected void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(homePage000);
        SwitchToDefault();
    }

    public void Impersonate_User(String username) {
        click(userinfodropdown);
        click(impersonateUser);
        click(searchForUserDropdown);
        searchInput.sendKeys(username);

        ClickElementByXPath(".//ul[@class='select2-results']//div[text()='"+username+"']");
        WaitForElementToDisappear(impersonatePopup);

        SwitchToIFrame();
        WaitForElement(welcome);
        SwitchToDefault();
        new HomePage().WaitForPageLoad();
        sleep(5);
    }

    public void SelectFavouritesTab() {
        WaitForElementToDisappear(loading);
        if(favouritesTab.getAttribute("aria-expanded").equals("false")) {
            click(favouritesTab);
            WaitForPageRefresh();
        }
    }

    public void SelectAllAppsTab() {
        WaitForElementToDisappear(loading);
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
            WaitForPageRefresh();

    }

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
}

