package pageObjects;

import Utilities.Util;
import dataObjects.PIUData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PIUPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2//*[text()='PIU']")
    public WebElement piuHeader;

    @FindBy(how = How.ID, using = "u_piu.u_change_complete")
    public WebElement changeCompleted;

    @FindBy(how = How.ID, using = "u_piu.u_change_success")
    public WebElement changeSuccess;

    @FindBy(how = How.ID, using = "u_piu.u_ci_update")
    public WebElement assetCIData;

    @FindBy(how = How.ID, using = "complete_piu")
    public WebElement completePIU;

    @FindBy(how = How.ID, using = "u_piu.u_change_complete_details")
    public WebElement completionDetails;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement save;

    public boolean isAt()
    {
        return isElementPresent(piuHeader);
    }

    public PIUPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(piuHeader);
        SwitchToDefault();
    }

    public void populatePIURecord(PIUData piuData)
    {
        SwitchToDefaultIFrame();
        WaitForElement(piuHeader);
        selectValue(changeCompleted,piuData.ChangeCompletedWithinChangeWindow);
        if(piuData.ChangeCompletedWithinChangeWindow.equals("No"))
            sendKeys(completionDetails, piuData.CompletionDetails);
        selectValue(changeSuccess,piuData.ChangeMetSuccessCriteria);
        selectValue(assetCIData,piuData.AssetCINeedUpdating);
        SwitchToDefault();
    }


    public void saveRecord()
    {
        SwitchToDefaultIFrame();
        click(save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void CompletePIU()
    {
        SwitchToDefaultIFrame();
        WaitForElement(piuHeader);
        click(completePIU);
        WaitForPageRefresh();
        SwitchToDefault();
        new PIUPage().WaitForPageLoad();
    }
}
