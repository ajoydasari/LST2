package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RequestedItemsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='Requested Items']")
    private WebElement requestItemsHeader;

    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(requestItemsHeader);
        SwitchToDefault();
    }

    public RequestedItemsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectRequestItem(String requestItem)
    {
        SwitchToDefaultIFrame();
        ClickElementByXPath(".//a[contains(text(),'"+requestItem+"')]");
        new RequestedItemPage().WaitForPageLoad();
        SwitchToDefault();
    }

}

