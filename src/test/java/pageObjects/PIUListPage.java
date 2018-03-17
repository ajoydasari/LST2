package pageObjects;

import Utilities.Util;
import dataObjects.PIUData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PIUListPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='PIUs.']")
    public WebElement piusHeader;

    @FindBy(how = How.XPATH, using = ".//div[@id='u_piu_expanded']//a[text()='Number']/..//i[contains(@class,'vcr-up')]")
    public WebElement sortPIUs_Descending;

    @FindBy(how = How.XPATH, using = ".//div[@id='u_piu_expanded']//a[text()='Number']/..//i[contains(@class,'vcr-down')]")
    public WebElement sortPIUs_Ascending;

    public boolean isAt()
    {
        return isElementPresent(piusHeader);
    }

    public PIUListPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(piusHeader);
        SwitchToDefault();
    }


    public void selectRecord(String changeNo)
    {
        SwitchToDefaultIFrame();
        WaitForElement(piusHeader);
        if(isElementPresent(sortPIUs_Descending)) {
            click(sortPIUs_Descending);
            WaitForElement(sortPIUs_Ascending );
        }
        ClickElementByXPath(".//a[text()='"+changeNo+"']/../..//a[contains(text(),'PIU')]");
        SwitchToDefault();
        new PIUPage().WaitForPageLoad();
    }

}
