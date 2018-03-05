package pageObjects;

import Utilities.Util;
import dataObjects.ChangeData;
import dataObjects.RiskImpactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RiskImpactPage extends Util {


    @FindBy(how = How.XPATH, using = ".//h2/div[text()='Change risk and Impact']")
    private WebElement newRecord;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_ten")
    private WebElement noUsersImpacted;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_thirtyseven")
    private WebElement impactOnService;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_eight")
    private WebElement withinServiceHours;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_nine")
    private WebElement dateTimeFlexible;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_thirteen")
    private WebElement testingDone;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_fifteen")
    private WebElement testingCompleted;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_sixteen")
    private WebElement evidenceProvided;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_twentyone")
    private WebElement involveOtherSuppliers;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_thirtyone")
    private WebElement accessObtained;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_twenty")
    private WebElement canServicebeRestored;

    @FindBy(how = How.ID, using = "u_risk_and_impact.u_q_thirtyfour")
    private WebElement prerequisitesCompleted;

    @FindBy(how = How.ID, using = "complete_impact")
    private WebElement completeRiskImpact;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Impact']")
    private WebElement impactTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Testing']")
    private WebElement testingTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Change Resources']")
    private WebElement changeResourcesTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Change Implementation']")
    private WebElement changeImplementationTab;

    public RiskImpactPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(newRecord);
        WaitForElement(noUsersImpacted.findElement(By.tagName("option")));
        SwitchToDefault();
    }


    public void CompleteNewRecordDetails(RiskImpactData riskImpactData) {

        SwitchToIFrame();
        selectTab(impactTab);
        selectValue(noUsersImpacted,riskImpactData.HowManyImpacted);
        selectValue(impactOnService,riskImpactData.WhatImpactOnService);
        selectValue(withinServiceHours,riskImpactData.WithinServiceHours);
        selectValue(dateTimeFlexible,riskImpactData.DateStartTimeCanChange);

        selectTab(testingTab);
        selectValue(testingDone,riskImpactData.TestingDone);
        selectValue(testingCompleted,riskImpactData.TestingCompleted);
        selectValue(evidenceProvided,riskImpactData.EvidenceProvided);

        selectTab(changeResourcesTab);
        selectValue(involveOtherSuppliers,riskImpactData.InvolveOtherSuppliers);

        selectTab(changeImplementationTab);
        selectValue(accessObtained,riskImpactData.AccessObtained);
        selectValue(canServicebeRestored,riskImpactData.CanServicesBeRestored);
        selectValue(prerequisitesCompleted,riskImpactData.PrerequisitesCompleted);
        SwitchToDefault();
    }


    public void ClickCompleteRiskImpact() {
        SwitchToDefaultIFrame();
        click(completeRiskImpact);
        //WaitForPageRefresh();
        ChangePage changePage = new ChangePage();
        changePage.WaitForSubmitForValidation();
        SwitchToDefault();
    }
}
