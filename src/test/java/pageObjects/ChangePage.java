package pageObjects;

import Utilities.Util;
import dataObjects.ChangeData;
import dataObjects.IncidentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangePage extends Util {


    @FindBy(how = How.ID, using = "sys_readonly.change.number")
    private WebElement changeNumber;

    @FindBy(how = How.ID, using = "_incident")
    private WebElement incidentSearchEdit;

    @FindBy(how = How.XPATH, using = ".//a[@data-original-title='Add']")
    private WebElement rightArrow;

    @FindBy(how = How.ID, using = "select_0")
    private WebElement childList;

    @FindBy(how = How.ID, using = "select_0_sysverb_save")
    private WebElement Save;

    public ChangePage()
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


    public String CompleteNewChangeDetails(ChangeData changeData) {

        String changeNo;
        SwitchToIFrame();

        changeNo = getValue(changeNumber);

        SwitchToDefault();

        return changeNo;
    }



    public String NewChange(ChangeData changeData)
    {
        String changeNo = CompleteNewChangeDetails(changeData);

        SwitchToIFrame();

        click(Save);
        WaitForPageRefresh();

        SwitchToDefault();

        return changeNo;
    }


}
