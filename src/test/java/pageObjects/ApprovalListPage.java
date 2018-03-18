package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApprovalListPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='Approvals']")
    public WebElement approvalsHeader;


    public boolean isAt()
    {
        return isElementPresent(approvalsHeader);
    }

    public ApprovalListPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(approvalsHeader);
        SwitchToDefault();
    }

    public void selectRecord(String recordNo)
    {
        SwitchToDefaultIFrame();
        WaitForElement(approvalsHeader);
        ClickElementByXPath(".//a[contains(text(),'" + recordNo + "')]/../../td[3]//a");
        SwitchToDefault();
        new ApprovalPage().WaitForPageLoad(recordNo);
    }

}
