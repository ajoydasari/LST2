package pageObjects;

import Utilities.Util;
import dataObjects.OrderSomethingData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ESSMyOpenRequestsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//table")
    private WebElement requestedItemsTable;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement firstOpenOrder;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='State']")
    private WebElement firstOpenOrderState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Estimated Delivery']")
    private WebElement firstOpenOrderEstimatedDelivery;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Request']")
    private WebElement firstRequestNo;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Number']")
    private WebElement firstRITMtNo;

    @FindBy(how = How.XPATH, using = ".//input[@value='Escalate Approval']")
    private WebElement escalateApproval;

    @FindBy(how = How.XPATH, using = ".//input[@value='Withdraw']")
    private WebElement withdraw;

    @FindBy(how = How.XPATH, using = ".//input[@value='Accept']")
    private WebElement accept;

    @FindBy(how = How.XPATH, using = ".//*[text()='Supervisor approver']/..//div")
    private WebElement approverName;

    public void WaitForPageLoad()
    {
        WaitForElement(requestedItemsTable);
    }

    public ESSMyOpenRequestsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void SelectFirstOrder()
    {
        click(firstOpenOrder);
    }

    public void validateState(String state)
    {
        Log("Verifying Order State : '" + state + "'");
        AssertElementText(firstOpenOrderState, state);
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



    public void verifyCustomerVisibleWorknotes(String notes)
    {
        AssertDisplayed(ElementByXPath(".//p[contains(text(),'"+ notes +"')]"));
    }


    public void AcceptRequest()
    {
        click(accept);
        WaitForPageRefresh();
    }

    public void ConfirmAcceptComments(String comments) {
        driver.switchTo().alert().sendKeys(comments);
        sleep(3);
        driver.switchTo().alert().accept();
        WaitForPageRefresh();
    }


    public void VerifyRequestNotDisplayed(String requestNo) {
        AssertNotDisplayed(ElementByXPath(".//table/tbody//td[1][contains(text(),'"+requestNo+"')]"));
    }


}

