package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IncidentsListPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h1[text()='Incidents']")
    public WebElement incidentsHeader;


    public boolean isAt()
    {
        return isElementPresent(incidentsHeader);
    }

    public IncidentsListPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElement(incidentsHeader);
        SwitchToDefault();
    }

    public void selectIncident(String incidentNo)
    {
        SwitchToDefault();
        SwitchToIFrame();
        WaitForElement(incidentsHeader);
        ClickElementByXPath(".//a[text()='" + incidentNo + "']");
        SwitchToDefault();
        new IncidentPage().WaitForPageLoad();
    }

    public void incidenNotExists(String incidentNo)
    {
        try {
            SwitchToDefault();
            SwitchToIFrame();
            WaitForElement(incidentsHeader);
            WebElement element = driver.findElement(By.xpath(".//a[text()='" + incidentNo + "']"));
            AssertNotDisplayed(element);
            SwitchToDefault();
        } catch (Exception e) {
        System.out.println("Incident '"+incidentNo+"' Not Displayed !");
            SwitchToDefault();
        }
    }
}
