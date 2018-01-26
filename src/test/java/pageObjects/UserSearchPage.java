package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserSearchPage extends Util {

    @FindBy(how = How.XPATH, using = ".//span[@id='sys_user_hide_search']//input[@placeholder='Search']")
    private WebElement searchForUser;

    public void SearchForUser(String username) {
        searchForUser.sendKeys(username);
        searchForUser.sendKeys(Keys.ENTER);
        ClickElementByXPath(".//a[text()='"+username+"']");
    }

    public UserSearchPage()
    {
        PageFactory.initElements(driver,this);
    }
}
