package pageObjects;

import Utilities.Util;
import dataObjects.OrderSomethingData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ESSMyClosedRequestsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//table")
    private WebElement requestedItemsTable;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement firstOrder;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Closure code']")
    private WebElement firstOrderState;

    public void WaitForPageLoad()
    {
        WaitForElement(requestedItemsTable);
    }

    public ESSMyClosedRequestsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void VerifyRequestDisplayed(String requestNo) {
        AssertDisplayed(ElementByXPath(".//table/tbody//td[1][contains(text(),'"+requestNo+"')]"));
    }


    public void validateState(String state)
    {
        Log("Verifying Order State : '" + state + "'");
        AssertElementText(firstOrderState, state);
    }
}

