package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IncidentsListPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='Incidents']")
    private WebElement incidentsHeader;


    public boolean isAt()
    {
        return isElementPresent(incidentsHeader);
    }

    public IncidentsListPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectIncident(String incidentNo)
    {
        SwitchToDefault();
        SwitchToIFrame();
        WaitForElement(incidentsHeader);
        ClickElementByXPath(".//a[text()='" + incidentNo + "']");
        SwitchToDefault();
    }
}
