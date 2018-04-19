package pageObjects;

import Utilities.Util;
import dataObjects.OrderSomethingData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ESSMyOpenRequestsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement requestedItemsTable;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement firstOpenOrder;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[2]")
    private WebElement secondOpenOrder;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[3]")
    private WebElement thirdOpenOrder;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='State']")
    private WebElement firstOpenOrderState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[2]/td[@data-th='State']")
    private WebElement secondOpenOrderState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[3]/td[@data-th='State']")
    private WebElement thirdOpenOrderState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Closure code']")
    private WebElement firstClosedOrderState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Estimated Delivery']")
    private WebElement firstOpenOrderEstimatedDelivery;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[2]/td[@data-th='Estimated Delivery']")
    private WebElement secondOpenOrderEstimatedDelivery;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[3]/td[@data-th='Estimated Delivery']")
    private WebElement thirdOpenOrderEstimatedDelivery;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Request']")
    private WebElement firstRequestNo;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Number']")
    private WebElement firstRITMtNo;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[2]/td[@data-th='Number']")
    private WebElement secondRITMtNo;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[3]/td[@data-th='Number']")
    private WebElement thirdRITMtNo;

    @FindBy(how = How.XPATH, using = ".//input[@value='Escalate Approval']")
    private WebElement escalateApproval;

    @FindBy(how = How.XPATH, using = ".//input[@value='Withdraw']")
    private WebElement withdraw;

    @FindBy(how = How.XPATH, using = ".//input[@value='Accept']")
    private WebElement accept;

    @FindBy(how = How.XPATH, using = ".//input[@value='Dispute']")
    private WebElement dispute;

    @FindBy(how = How.XPATH, using = ".//*[text()='Supervisor approver']/..//div")
    private WebElement approverName;

    @FindBy(how = How.NAME, using = "searchRITM")
    private WebElement searchRITMDropdown;

    @FindBy(how = How.XPATH, using = ".//select/following-sibling::input")
    private WebElement searchRITMDEdit;

    @FindBy(how = How.XPATH, using = ".//input[@value='Search']")
    private WebElement searchRITMBtn;

    @FindBy(how = How.XPATH, using = ".//input[@value='Clear Search']")
    private WebElement clearSearch;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'has been created for investigation')]")
    private WebElement incidentCreatedMessage;

    @FindBy(how = How.XPATH, using = ".//button[@aria-label='Close Notification']")
    private WebElement closeIncidentCreatedMessage;

    public void WaitForPageLoad()
    {
        WaitForElement(requestedItemsTable);
    }

    public ESSMyOpenRequestsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void SearchOrder(String searchText)
    {
        selectValue(searchRITMDropdown,"RITM Number");
        sendKeysVerify(searchRITMDEdit, searchText);
        click(searchRITMBtn);
        WaitForPageRefresh();
    }


    public void ClearSearch()
    {
        click(clearSearch);
        WaitForPageRefresh();
    }

    public void SelectFirstOrder()
    {
        click(firstOpenOrder);
        WaitForPageRefresh();
    }

    public void SelectSecondOrder()
    {
        click(secondOpenOrder);
        WaitForPageRefresh();
    }

    public void SelectThirdOrder()
    {
        click(thirdOpenOrder);
        WaitForPageRefresh();
    }

    public void validateState(String state)
    {
        Log("Verifying Order State : '" + state + "'");
        if(state.contains("Closed"))
            AssertElementText(firstClosedOrderState, state);
        else
            AssertElementText(firstOpenOrderState, state);
    }


    public void validateSecondOrderState(String state)
    {
        Log("Verifying Order State : '" + state + "'");
//        if(state.contains("Closed"))
//            AssertElementText(firstClosedOrderState, state);
//        else
            AssertElementText(secondOpenOrderState, state);
    }


    public void validateThirdOrderState(String state)
    {
        Log("Verifying Order State : '" + state + "'");
//        if(state.contains("Closed"))
//            AssertElementText(firstClosedOrderState, state);
//        else
            AssertElementText(thirdOpenOrderState, state);
    }

    public void validateButtonDisplayed(String buttonText)
    {
        SwitchToDefaultIFrame();
        switch (buttonText) {
            case "Escalate Approval":
                AssertDisplayed(escalateApproval);
                break;
            case "Withdraw":
                AssertDisplayed(withdraw);
                break;
        }
        SwitchToDefault();
    }

    public String getRequestNumber()
    {
        return getText(firstRequestNo);
    }


    public String getRITMNumber()
    {
        return getText(firstRITMtNo);
    }

    public String getSecondRITMNumber()
    {
        return getText(secondRITMtNo);
    }

    public String getThirdRITMNumber()
    {
        return getText(thirdRITMtNo);
    }

    public void verifyApproverDisplayed(OrderSomethingData orderSomethingData)
    {
        SwitchToDefaultIFrame();
        AssertElementText(approverName,orderSomethingData.Approver);
        SwitchToDefault();
    }



    public void verifyEstimatedDeliveryDateDisplayed()
    {
        String estimatedDeliveryDate = getText(firstOpenOrderEstimatedDelivery);
        Assert.assertTrue(estimatedDeliveryDate.length()>10,"Estimated Delivery Date is NOT Displayed");
    }


    public void verifyEstimatedDeliveryDateDisplayed2()
    {
        String estimatedDeliveryDate = getText(secondOpenOrderEstimatedDelivery);
        Assert.assertTrue(estimatedDeliveryDate.length()>10,"Estimated Delivery Date is NOT Displayed for Second Order");
    }


    public void verifyEstimatedDeliveryDateDisplayed3()
    {
        String estimatedDeliveryDate = getText(thirdOpenOrderEstimatedDelivery);
        Assert.assertTrue(estimatedDeliveryDate.length()>10,"Estimated Delivery Date is NOT Displayed for Third Order");
    }

    public void verifyCustomerVisibleWorknotes(String notes)
    {
        SwitchToDefaultIFrame();
        AssertDisplayed(ElementByXPath(".//p[contains(text(),'"+ notes +"')]"));
        SwitchToDefault();
    }


    public void AcceptRequest()
    {
        SwitchToDefaultIFrame();
        click_NoAssert(accept);
    }


    public void DisputeRequest(String comments)
    {
        SwitchToDefaultIFrame();
        click_NoAssert(dispute);
        ConfirmAcceptComments(comments);
    }

    public void ConfirmAcceptComments(String comments) {
        driver.switchTo().alert().sendKeys(comments);
        sleep(3);
        driver.switchTo().alert().accept();
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void VerifyRequestNotDisplayed(String requestNo) {
        AssertNotDisplayed(ElementByXPath(".//table/tbody//td[1][contains(text(),'"+requestNo+"')]"));
    }


    public String extractIncidentNumber(String messageText)
//    public String extractIncidentNumber()
    {
        //String message = "Incident INC0551137 has been created for investigation.";
        String incidentNo = messageText.substring(9,19);

        return incidentNo;
    }


    public void VerifyIncidentCreated() {
        SwitchToDefaultIFrame();
        WaitForElement(incidentCreatedMessage);
        String incidentText = incidentCreatedMessage.getAttribute("innerText");
        Log(incidentText);
        String incidentNo = new ESSMyOpenRequestsPage().extractIncidentNumber(incidentText);
        SaveData("IncidentNo", incidentNo);
        click(closeIncidentCreatedMessage);
        SwitchToDefault();
    }

}

