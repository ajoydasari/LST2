package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CatalogTasksPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='Catalog Tasks']")
    private WebElement catalogTasksHeader;

    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(catalogTasksHeader);
        SwitchToDefault();
    }

    public CatalogTasksPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectTaskItem(String taskItem)
    {
        SwitchToDefaultIFrame();
        ClickElementByXPath(".//a[contains(text(),'"+taskItem+"')]");
        new CatalogTaskPage().WaitForPageLoad();
        SwitchToDefault();
    }

}

