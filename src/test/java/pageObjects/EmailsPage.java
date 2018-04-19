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

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//a[text()='Target']")
    private WebElement targetColumn;

//    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//i[@title='Update Personalized List']")
    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email_expanded']//i[@data-title='Personalize List Columns']")
    private WebElement selectColumns;

    @FindBy(how = How.XPATH, using = ".//*[@id=\"slush_left\"]/option[text()='Body']")
    private WebElement bodyOption;

    @FindBy(how = How.XPATH, using = ".//*[@id=\"slush_left\"]/option[text()='Target']")
    private WebElement targetOption;

    @FindBy(how = How.XPATH, using = ".//*[@id=\"slush_left\"]/option[text()='State']")
    private WebElement stateOption;

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

    @FindBy(how = How.XPATH, using = ".//a/span[text()='Created on Today']/..")
    private WebElement createdToday;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email']//a[text()='Created']")
    public WebElement createdColumn;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email']//a[text()='Created']/..//i[contains(@class,'vcr-up')]")
    public WebElement createdSortAsc;

    @FindBy(how = How.XPATH, using = ".//div[@id='sys_email']//a[text()='Created']/..//i[contains(@class,'vcr-down')]")
    public WebElement createdSortDesc;


    public EmailsPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElementToBeClickable(filterColumn);
        SwitchToDefault();
    }

    private void addBodyColumn()
    {
        SwitchToDefaultIFrame();
        if (!(isElementPresent(bodyColumn)))
        {
            WaitForElement(selectColumns);
            for (int i = 0; i < 3; i++) {
                click(selectColumns);
                WaitForPageRefresh();
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

    private void addTargetColumn() {
        SwitchToDefaultIFrame();
        if (!(isElementPresent(targetColumn))) {
            WaitForElement(selectColumns);
            for (int i = 0; i < defaultTimeout; i++) {
                try {
                    if (isElementPresent(targetOption)) {
                        System.out.println("Checking to see if Target Element is Present : Element Found !");
                        click(targetOption);
                        click(addOption);
                        click(okButton);
                        break;
                    } else if (isElementPresent(stateOption)) {
                        System.out.println("Target Element Not Found !");
                        click(stateOption);
                        stateOption.sendKeys(Keys.PAGE_DOWN);
                        sleep(1);
                    } else if (isElementPresent(selectColumns)) {
                        sleep(1);
                        click(selectColumns);
                    }
                } catch (Exception e) {
                }
                WaitForPageRefresh();
                SwitchToDefaultIFrame();
            }
        }
    }

    private void addFilter(String FilterColumn, String FilterText)
    {
        selectValue(filterColumn,FilterColumn);
        sendKeysVerify(filterText,FilterText);
        filterText.sendKeys(Keys.ENTER);
        sleep(2);
        WaitForElementToBeClickable(filterColumn);
    }

    private void amendbodyFilter()
    {
        click(showHideFilter);
        WaitForElementToBeClickable(bodyFilterCondition);
        selectValue(bodyFilterCondition,"LIKE");
        click(runFilters);
        sleep(2);
        WaitForElementToBeClickable(bodyColumn);
    }

    private void refreshFilter()
    {
        if(isElementPresent(subjectFilter)) {
            click(subjectFilter);
            subjectFilter.sendKeys(Keys.ENTER);
        }
        else
        {
            click(showHideFilter);
            WaitForPageRefresh();
            click(runFilters);
        }
        WaitForPageRefresh();
    }

    public void Email_Exists(String Recipient, String Subject, String BodyText) {

        int retryCount = 3;
        WaitForPageLoad();

        SwitchToDefaultIFrame();
        WaitForElement(filterColumn);
        addFilter("Recipients", Recipient);
        addBodyColumn();

        WaitForElementToBeClickable(subjectFilter);
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



    public void Email_Exists1(String Recipient, String Subject, String targetText) {

        int retryCount = 3;
        WaitForPageLoad();

        SwitchToDefaultIFrame();

        click(createdToday);
        WaitForPageRefresh();

        addFilter("Recipients", Recipient);
        addTargetColumn();

        WaitForElementToBeClickable(subjectFilter);
        sendKeysVerify(subjectFilter,Subject);
        subjectFilter.sendKeys(Keys.ENTER);
        sleep(2);

        if(isElementPresent(createdColumn))
        if(!(isElementPresent(createdSortDesc))) {
            click(createdColumn);
            sleep(5);
            if (isElementPresent(createdSortAsc)) {
                click(createdColumn);
                sleep(5);
            }
        }

        for (int i = 0; i < 5; i++) {
            try {
                if (isElementPresent(ElementByXPath(".//table[@id='sys_email_table']//tr[@data-list_id]//a[contains(text(),'" + targetText + "')]")))
                    break;
            }catch (Exception e){}

            refreshFilter();

        }

        AssertDisplayed(ElementByXPath(".//table[@id='sys_email_table']//tr[@data-list_id]//a[contains(text(),'"+targetText+"')]"));

        SwitchToDefault();

    }

}
