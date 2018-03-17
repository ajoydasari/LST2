package pageObjects;

import Utilities.Util;
import dataObjects.ChangeData;
import dataObjects.ReadyReckonerData;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static java.util.Objects.isNull;

public class ReadyReckonerPage extends Util {


    @FindBy(how = How.ID, using = "sys_display.u_change_release_self_assessment.u_it_service")
    private WebElement service;

    @FindBy(how = How.XPATH, using = ".//a[@id='lookup.u_change_release_self_assessment.u_it_service']")
    private WebElement serviceLookup;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_is_this_a_standard_or_emergency_change")
    private WebElement emergencyChange;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_is_this_introducing_a_new_service")
    private WebElement newService;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_question_2")
    private WebElement multiEnvironment;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_question_3")
    private WebElement multipleSuppliers;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_question_4")
    private WebElement impactOtherSystems;

    @FindBy(how = How.ID, using = "u_change_release_self_assessment.u_question_5")
    private WebElement deployTogether;

    @FindBy(how = How.ID, using = "sys_readonly.u_change_release_self_assessment.u_result")
    private WebElement result;

    @FindBy(how = How.XPATH, using = ".//button[text()='Calculate Score'][contains(@style,'lightgreen')]")
    private WebElement calculateScore;

    @FindBy(how = How.XPATH, using = ".//button[text()='Go to Change'][contains(@style,'lightgreen')]")
    private WebElement GotoChange;

    @FindBy(how = How.XPATH, using = ".//button[text()='Delete']")
    private WebElement delete;

    public ReadyReckonerPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToIFrame();
        //WaitForElement(emergencyChange.findElement(By.tagName("option")));
        WaitForElement(calculateScore);
        SwitchToDefault();
        WaitForPageRefresh();
    }


    public void CompleteReadyReckoner(ReadyReckonerData readyReckonerData) {

        SwitchToDefaultIFrame();

        //sendKeys_Select(service, readyReckonerData.ITService);
        sendKeys(service, readyReckonerData.ITService);
        SelectFromLookup(serviceLookup, readyReckonerData.ITService);
        selectValue(emergencyChange, readyReckonerData.EmergencyChange);

        if(readyReckonerData.NewService != null)
            selectValue(newService, readyReckonerData.NewService);
        if(readyReckonerData.MultiEnvironment != null)
            selectValue(multiEnvironment, readyReckonerData.MultiEnvironment);
        if(readyReckonerData.MultipleSuppliers != null)
            selectValue(multipleSuppliers, readyReckonerData.MultipleSuppliers);
        if(readyReckonerData.ImpactOtherITSystems != null)
            selectValue(impactOtherSystems, readyReckonerData.ImpactOtherITSystems);
        if(readyReckonerData.DeployTogether != null)
            selectValue(deployTogether, readyReckonerData.DeployTogether);

        SwitchToDefault();
    }



    public void CalculateScore() {
        SwitchToIFrame();
        click(calculateScore);
        WaitForElement(GotoChange);
        SwitchToDefault();
    }


    public void GoToChange() {
        SwitchToIFrame();
        click(GotoChange);
        SwitchToDefault();
    }


    public void Delete() {
        SwitchToIFrame();
        click(delete);
        SwitchToDefault();
    }

}
