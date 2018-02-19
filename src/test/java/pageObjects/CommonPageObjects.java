package pageObjects;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonPageObjects extends Util {

    @FindBy(how = How.XPATH, using = ".//table[@id='table_clone']")
    private static WebElement totalRows;

    @FindBy(how = How.ID, using = "window.GwtDateTimePicker")
    private static WebElement dateTimePicker;

    @FindBy(how = How.ID, using = "GwtDateTimePicker_month_prev")
    private static WebElement dtpprevMonth;

    @FindBy(how = How.ID, using = "GwtDateTimePicker_month")
    private static WebElement dtpmonthYear;

    @FindBy(how = How.ID, using = "GwtDateTimePicker_month_next")
    private static WebElement dtpnextMonth;

    @FindBy(how = How.XPATH, using = ".//table[@id='window.GwtDateTimePicker']//td[text()='Go to Today']")
    private static WebElement dtpToday;

//    @FindBy(how = How.XPATH, using = ".//table[@id='window.GwtDateTimePicker']//td[(@class='calText calCurrentMonthDate') or (@class='calText calCurrentDate')]")
//    private static WebElement dtpDays;



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


    public static void selectCalendarDate(String supplieddate) {
        System.out.println("selectCalendarDate() - Supplied Date: " + supplieddate);
        boolean found = false;

        try {
            WaitForElement(dateTimePicker);
            if (isElementPresent(dateTimePicker)) {

                if (supplieddate.toUpperCase().equals("TODAY"))
                    click(dtpToday);
                else {
                    SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date myDate = myDateFormat.parse(supplieddate);
                    Calendar myCalendar = Calendar.getInstance();
                    myCalendar.setTime(myDate);

                    int suppliedday = myCalendar.get(Calendar.DAY_OF_MONTH);
                    int suppliedmonth = myCalendar.get(Calendar.MONTH);
                    int suppliedyear = myCalendar.get(Calendar.YEAR);

                    String selectedMonthYear = getText(dtpmonthYear);
                    String selectedMonth = selectedMonthYear.split(" ")[0];
                    int selectedYearNum = Integer.parseInt(selectedMonthYear.split(" ")[1]);

                    Date date = new SimpleDateFormat("MMMM").parse(selectedMonth);
                    myCalendar.setTime(date);
                    int monthNumber = myCalendar.get(Calendar.MONTH);

                    while ((monthNumber != suppliedmonth) || (selectedYearNum != suppliedyear)) {

                        if ((selectedYearNum > suppliedyear) || (monthNumber > suppliedmonth))
                            click(dtpprevMonth);
                        else if ((selectedYearNum < suppliedyear) || (monthNumber < suppliedmonth))
                            click(dtpnextMonth);

                        sleep(1);

                        selectedMonthYear = getText(dtpmonthYear);
                        selectedMonth = selectedMonthYear.split(" ")[0];
                        selectedYearNum = Integer.parseInt(selectedMonthYear.split(" ")[1]);

                        date = new SimpleDateFormat("MMMM").parse(selectedMonth);
                        myCalendar.setTime(date);
                        monthNumber = myCalendar.get(Calendar.MONTH);
                    }
                    ClickElementByXPath(".//table[@id='window.GwtDateTimePicker']//td[(@class='calText calCurrentMonthDate') or (@class='calText calCurrentDate')]//a[text()='" + suppliedday + "']");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        } finally {
            System.out.println("selectCalendarDate() - FINISH");
        }
    }


}
