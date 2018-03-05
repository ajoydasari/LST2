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

//    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//i[@title='Update Personalized List']")
    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//i[@data-title='Personalize List Columns']")
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

    @FindBy(how = How.ID, using = "sys_email_filter_toggle_image")
    private WebElement showHideFilter;

    @FindBy(how = How.XPATH, using = ".//span[text()='Body']/../../../../td[3]/select")
    private WebElement bodyFilterCondition;

    @FindBy(how = How.XPATH, using = ".//button[text()='Run']")
    private WebElement runFilters;

    public EmailsPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(filterColumn);
//        WaitForPageRefresh();
        SwitchToDefault();
    }

    private void addBodyColumn()
    {
        if (!(isElementPresent(bodyColumn)))
        {
            WaitForElement(selectColumns);
            for (int i = 0; i < 3; i++) {
                click(selectColumns);
                if(isElementPresent(bodyOption)) {
                    System.out.println("Checking to see if Element is Present : Element Found !");
                    break;
                }
                else
                    sleep(1);
            }
            click(bodyOption);
            click(addOption);
            click(okButton);
            WaitForPageRefresh();
            SwitchToDefaultIFrame();
        }
    }

    private void addFilter(String FilterColumn, String FilterText)
    {
        selectValue(filterColumn,FilterColumn);
        sendKeysVerify(filterText,FilterText);
        filterText.sendKeys(Keys.ENTER);
        sleep(2);
        WaitForElementToBeClicable(filterColumn);
    }

    private void amendbodyFilter()
    {
        click(showHideFilter);
        WaitForElementToBeClicable(bodyFilterCondition);
        selectValue(bodyFilterCondition,"LIKE");
        click(runFilters);
        sleep(2);
        WaitForElementToBeClicable(bodyColumn);
    }

    private void refreshFilter()
    {
        click(showHideFilter);
        WaitForElementToBeClicable(bodyFilterCondition);
        click(runFilters);
        sleep(2);
        WaitForElementToBeClicable(bodyColumn);
    }

    public void Email_Exists(String Recipient, String Subject, String BodyText) {

        int retryCount = 3;
        WaitForPageLoad();

        SwitchToDefaultIFrame();
        WaitForElement(filterColumn);
        addFilter("Recipients", Recipient);
        addBodyColumn();

        WaitForElementToBeClicable(subjectFilter);
        sendKeysVerify(subjectFilter,Subject);
        subjectFilter.sendKeys(Keys.ENTER);
        sleep(2);

        sendKeysVerify(bodyFilter,BodyText);
        subjectFilter.sendKeys(Keys.ENTER);
        sleep(5);

        amendbodyFilter();

        for (int i = 0; i < 5; i++) {
            if(isElementPresent(emails))
                break;
            else
                refreshFilter();
        }

        AssertDisplayed(emails);

        SwitchToDefault();

    }

}
