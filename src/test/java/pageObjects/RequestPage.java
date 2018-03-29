package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RequestPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2//div[text()='Request']")
    private WebElement requestHeader;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Requested')]")
    private WebElement requestedItemsTab;

    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(requestHeader);
        SwitchToDefault();
    }

    public RequestPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectRequestedItem(String requestItem)
    {
        SwitchToDefaultIFrame();
        RequestedItemPage requestedItemPage = new RequestedItemPage();
        selectTab(requestedItemsTab);
        ClickElementByXPath(".//a[contains(text(),'"+requestItem+"')]");
        requestedItemPage.WaitForPageLoad();
        SwitchToDefault();
    }
}

