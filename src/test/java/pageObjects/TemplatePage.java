package pageObjects;

import Utilities.Util;
import dataObjects.TemplateData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class TemplatePage extends Util {


    @FindBy(how = How.ID, using = "sysverb_new")
    private WebElement newTemplate;

    @FindBy(how = How.ID, using = "sys_template.name")
    private WebElement Name;

    @FindBy(how = How.ID, using = "s2id_sys_template.table")
    private WebElement Table;

    @FindBy(how = How.ID, using = "sys_template.u_groups_unlock")
    private WebElement Groups;

    @FindBy(how = How.ID, using = "sys_template.short_description")
    private WebElement ShortDescription;

    @FindBy(how = How.ID, using = "sysverb_insert")
    private WebElement Submit;

    @FindBy(how = How.ID, using = "s2id_autogen1_search")
    private WebElement TableEdit;

    @FindBy(how = How.XPATH, using = ".//*[@id='select2-results-1']//div[contains(text(),'Change Request [change_request]')]")
    private WebElement TableSelect;

    @FindBy(how = How.ID, using = "sys_display.sys_template.u_groups")
    private WebElement GroupsEdit;

    public void NewTemplate() {
        //SwitchToDefaultIFrame();
        click(newTemplate);
        WaitForPageRefresh();
        //SwitchToDefault();
    }


    public void CreateNewTemplate(TemplateData templateData){
        sendKeys(Name, templateData.Name);
        click(Table);
        sendKeys(TableEdit, templateData.Table);
        click(TableSelect);
        sendKeys(ShortDescription, templateData.ShortDescription);
        click(Groups);
        sendKeys(GroupsEdit,templateData.Groups);
    }
}
