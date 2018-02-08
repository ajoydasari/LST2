package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObjects extends Util {

    @FindBy(how = How.XPATH, using = ".//table[@id='table_clone']")
    private static WebElement totalRows;

    public CommonPageObjects()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        WaitForPopup();
    }

    protected String getResultsCount() {
        String rows="";
        WaitForPageLoad();
        try {
            rows = totalRows.getAttribute("total_rows");
            System.out.println("Number of Records in the Search Popup :" + rows);
        } catch (Exception e) {
            System.out.println("Exception Occurred in getResultsCount function, details: "+e.getMessage());
        }
        return rows;
    }
}
