package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LHSNavigationPage extends Util {

    @FindBy(how = How.ID, using = "filter")
    private WebElement filter;

    @FindBy(how = How.XPATH, using = ".//span[text()='Create New']")
    private WebElement CreateNew;

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Assignment Groups Open Incidents']")
    private WebElement myGroupOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='Emails']")
    private WebElement emails;


    public LHSNavigationPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void CreateNewIncident() {
        click(CreateNew);
        SwitchToIFrame();
        WaitForElement(newRecord);
        SwitchToDefault();
    }

    public void MyAssignmentGroupOpenIncidents()
    {
        myGroupOpenIncidents.click();
    }

    private void setFilter(String filterText)
    {
        filter.sendKeys(filterText);
        filter.sendKeys(Keys.ENTER);
    }

    public void openEmails()
    {
        setFilter("Emails");
        click(emails);
        WaitForPageLoad();
    }
}
