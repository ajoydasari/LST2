package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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


    public EmailsPage()
    {
        PageFactory.initElements(driver,this);
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
        if (!(isElementPresent(bodyColumn)))
        {
            WaitForElement(selectColumns);
            click(selectColumns);
            click(bodyOption);
            click(addOption);
            click(okButton);
        }
    }

    public void findEmail(String Recepient, String Subject, String BodyText)
    {
        SwitchToIFrame();

        addBodyColumn();

        SwitchToDefault();

    }

}
