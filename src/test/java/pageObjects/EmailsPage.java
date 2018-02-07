package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmailsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//a[text()='Body']")
    private WebElement bodyColumn;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//i[@title='Update Personalized List']")
    private WebElement selectColumns;

    @FindBy(how = How.XPATH, using = ".//*[@id=\"slush_left\"]/option[text()='Body']")
    private WebElement bodyOption;

    @FindBy(how = How.XPATH, using = ".//*[@id=\"addRemoveButtons\"]/a[@title='Add']")
    private WebElement addOption;

    @FindBy(how = How.XPATH, using = ".//button[@id=\"ok_button\"]")
    private WebElement okButton;

    @FindBy(how = How.XPATH, using = ".//span[@id='sys_email_hide_search']//select")
    public WebElement filterColumn;

    @FindBy(how = How.XPATH, using = ".//span[@id='sys_email_hide_search']//input")
    private WebElement filterText;

    @FindBy(how = How.XPATH, using = ".//table[@id='sys_email_table']//tr[@data-list_id]")
    private WebElement emails;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//td[@name='recipients']//input")
    private WebElement recipientFilter;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//td[@name='subject']//input")
    private WebElement subjectFilter;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//td[@name='body']//input")
    private WebElement bodyFilter;

    public EmailsPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToIFrame();
        WaitForElementToBeClicable(filterColumn);
        SwitchToDefault();
    }

    private void addBodyColumn()
    {
        if (!(isElementPresent(bodyColumn)))
        {
            WaitForElement(selectColumns);
            click(selectColumns);
            click(bodyOption);
            click(addOption);
            click(okButton);
        }
    }

    private void addFilter(String FilterColumn, String FilterText)
    {
        selectValue(filterColumn,FilterColumn);
        setValue(filterText,FilterText);
        filterText.sendKeys(Keys.ENTER);
        sleep(2);
    }

    public void Email_Exists(String Recipient, String Subject, String BodyText) {
        SwitchToIFrame();

        addBodyColumn();
        addFilter("Body", BodyText);

        WaitForElementToBeClicable(recipientFilter);
        recipientFilter.sendKeys(Recipient);
        recipientFilter.sendKeys(Keys.ENTER);
        sleep(2);

        WaitForElementToBeClicable(subjectFilter);
        subjectFilter.sendKeys(Subject);
        subjectFilter.sendKeys(Keys.ENTER);
        sleep(2);

        WaitForElementToBeClicable(bodyFilter);
        click(bodyFilter);
        bodyFilter.sendKeys(Keys.ENTER);

        WaitForPageRefresh();

        AssertDisplayed(emails);

        SwitchToDefault();

    }

}
