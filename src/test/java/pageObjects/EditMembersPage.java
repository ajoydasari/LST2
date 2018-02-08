package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditMembersPage extends Util {

    @FindBy(how = How.ID, using = "_incident")
    private WebElement incidentSearchEdit;

    @FindBy(how = How.XPATH, using = ".//a[@data-original-title='Add']")
    private WebElement rightArrow;

    @FindBy(how = How.ID, using = "select_0")
    private WebElement childList;

    @FindBy(how = How.ID, using = "select_0_sysverb_save")
    private WebElement save;

    public EditMembersPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        WaitForPageRefresh();
        SwitchToIFrame();
        WaitForElement(childList.findElement(By.tagName("option")));
        SwitchToDefault();
    }

    public void AddChild(String searchText) {
        SwitchToIFrame();
        WaitForElement(incidentSearchEdit);
        incidentSearchEdit.sendKeys(searchText);
        sleep(1);
        selectValue(childList,searchText);
        click(rightArrow);
        sleep(1);
        click(save);
        SwitchToDefault();
        WaitForPageRefresh();
    }
}
