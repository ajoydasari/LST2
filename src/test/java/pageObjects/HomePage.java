package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Util {
    @FindBy(how = How.XPATH, using = "id('user_info_dropdown')//span[@class='caret']")
    private WebElement userinfodropdown;

    @FindBy(how = How.XPATH, using = ".//a[text()='Impersonate User']/..")
    private WebElement impersonateUser;

    @FindBy(how = How.XPATH, using = ".//span[text()='Search for user']/../..")
    private WebElement searchForUserDropdown;

    @FindBy(how = How.ID, using = "s2id_autogen2_search")
    private WebElement searchInput;

    @FindBy(how = How.ID, using = "impersonate_title")
    private WebElement impersonatePopup;

    @FindBy(how = How.XPATH, using = ".//input[@id='home_title']")
    private WebElement welcome;

    @FindBy(how = How.XPATH, using = ".//a[@id='favorites_tab']")
    private WebElement favouritesTab;

    @FindBy(how = How.XPATH, using = ".//a[@id='allApps_tab']")
    private WebElement allAppsTab;

    public void Impersonate_User(String username) {
        userinfodropdown.click();
        click(impersonateUser);
        click(searchForUserDropdown);
        searchInput.sendKeys(username);

        ClickElementByXPath(".//ul[@class='select2-results']//div[text()='"+username+"']");
        WaitForElementToDisappear(impersonatePopup);

        SwitchToIFrame();
        WaitForElement(welcome);
        SwitchToDefault();
        WaitForPageLoad();
    }

    public void SelectFavouritesTab() {
        favouritesTab.click();
    }

    public void SelectAllAppsTab() {
        WaitForElement(allAppsTab);
        allAppsTab.click();
    }


    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
}

