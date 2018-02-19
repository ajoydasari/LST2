package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class Util extends XMLUtil{
    protected static WebDriver driver = null;
    private static String parentWindowHandler;
    private static Set<String> oldWindows;
    private static int defaultTimeout = 20;
    protected String GblEmailsUser = "Ajoy Dasari";

    protected static void sleep(int waitValue) {
        System.out.println("Sleeping for '" + waitValue + "' seconds");
        try {
            Thread.sleep(waitValue * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("SameParameterValue")
    protected static void navigate(String URL) {
        System.out.println("Navigating to URL: " + URL);
        driver.get(URL);
    }


    protected static boolean isElementPresent(WebElement element) {
        System.out.println("Checking to see if Element is Present :" + element.toString());
        try {
            element.isDisplayed();
            System.out.println("Checking to see if Element is Present : Element Found !");
            return true;
        } catch (Exception e) {
            System.out.println("Checking to see if Element is Present : Element Not Found !");
            return false;
        }
    }

    protected static void WaitForElement(WebElement element) {
        Boolean waiting=true;
        int timeout = defaultTimeout;
        System.out.println("Waiting for Element :" + element.toString());
        while(waiting) {
            if(timeout>0)
            {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 5);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    waiting = false;
                } catch (Exception e) {
                    sleep(1);
                }
                timeout = timeout -1;
            }else {
                waiting = false;
            }
        }
    }


    protected static void WaitForElementToBeClicable(WebElement element) {
        Boolean waiting=true;
        int timeout = defaultTimeout;
        System.out.println("Waiting for Element To Be Clickable :" + element.toString());
        while(waiting) {
            if(timeout>0)
            {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 5);
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    waiting = false;
                } catch (Exception e) {
                    sleep(1);
                }
                timeout = timeout -1;
            }else {
                waiting = false;
            }
        }
    }


    protected static void WaitForElementToBeClickableByXPath(String xpath) {
        Boolean waiting=true;
        int timeout = defaultTimeout;
        System.out.println("Waiting for Element To Be Clickable By XPath:" + xpath);
        while(waiting) {
            if(timeout>0)
            {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 5);
                    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
                    waiting = false;
                } catch (Exception e) {
                    sleep(1);
                }
                timeout = timeout -1;
            }else {
                waiting = false;
            }
        }
    }


    protected static void WaitForElementToDisappear(WebElement element) {
        System.out.println("Waiting for Element to Disappear :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected static WebElement ElementByXPath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    protected static void ClickElementByXPath(String xpath) {
        System.out.println("Clicking on Element :" + xpath);
//        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WaitForElementToBeClickableByXPath(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    protected static void SwitchToIFrame() {
        //System.out.println("Switching Focus to the default IFrame :");
        WaitForElement(driver.findElement(By.tagName("iframe")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    }

    protected static void SwitchToDefaultIFrame() {
        SwitchToDefault();
        WaitForElement(driver.findElement(By.tagName("iframe")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    }


    public static void SwitchToIFrame(String IdOrName) {
        driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[(@id='" + IdOrName + "') or (@name='" + IdOrName + "')]")));
    }

    protected static void SwitchToDefault() {
        //System.out.println("Switching Focus to Default Window");
        driver.switchTo().defaultContent();
    }

    protected static void Readonly(WebElement element) {
        System.out.println("Verifying Element is ReadOnly :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        String readonly = element.getAttribute("readOnly");
        Log("ReadOnly :=" + readonly);
        Assert.assertTrue((readonly.contains("true")), "Element '" + element.toString() + "' is NOT ReadOnly");
    }



    protected static void IsEditable(WebElement element)
    {
        System.out.println("Verifying Element is Editable :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        String classname = element.getAttribute("class");
        Log("classname :=" + classname);
        Assert.assertTrue((!(classname.contains("readonly"))), "Element '" + element.toString() + "' is NOT Editable");
    }



    protected static void NotReadonly(WebElement element) {
        System.out.println("Verifying Element is Not ReadOnly :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        String readonly = element.getAttribute("readOnly");
        Assert.assertTrue((readonly.equals("false")), "Element '" + element.toString() + "' is ReadOnly");
    }

    protected static String getValue(WebElement element) {
        //WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        //wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("value");
    }

    protected static String getText(WebElement element) {
        String value;
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));

        if(element.getTagName().equals("select")) {
            value = getValue(element);
            value = element.findElement(By.xpath(".//option[@value='" + value + "']")).getAttribute("text");
            System.out.println("element is a select: value: = "+value);
        }
        else if (element.getTagName().equals("td")) {
            value = element.getAttribute("textContent");
            System.out.println("element is a td: value: = "+value);
        }
        else {
            value = element.getAttribute("text");
            System.out.println("element is not a select: value: = " + value);
        }

        return value;
    }


    protected static void CaptureWindowHandles() {
        parentWindowHandler = driver.getWindowHandle();
        oldWindows = driver.getWindowHandles();
    }

    protected static void SwitchToOldWindow() {
        driver.switchTo().window(parentWindowHandler);
    }

    protected static void SwitchToNewWindow() {
        sleep(1);
        SwitchToDefault();
        Set<String> allWindows;
        allWindows = driver.getWindowHandles();
        allWindows.removeAll(oldWindows);
        String newWindow = allWindows.iterator().next();
        driver.switchTo().window(newWindow);
    }

    protected static void CloseNewWindow() {
        driver.close();
    }

    protected static void selectValue(WebElement element, String optionValue) {
        try {
            WaitForElementToBeClicable(element);
            System.out.println("Select Value - " + element.toString() + " : '"+ optionValue + "'");
            click(element);
            List<WebElement> options = element.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if((option.getText().contains(optionValue)) || (option.getAttribute("value").contains(optionValue)))
                {
                    Log("Option '"+ optionValue +"' Found!");
                    click(option);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in 'selectValue' method :" + e.getMessage());
        }
    }

    protected static void setValue(WebElement element, String textValue) {
        try {
            System.out.println("Set Value - " + element.toString() + " : '"+ textValue + "'");
            element.sendKeys(textValue);
        } catch (Exception e) {
            System.out.println("Exception occurred in 'setValue' method :" + e.getMessage());
        }
    }

    protected static void sendKeys_Select(WebElement element, String valueToSelect)
    {
        WaitForElementToBeClicable(element);
        element.clear();
        element.sendKeys(valueToSelect);
        ClickElementByXPath(".//*[text()='" + valueToSelect + "']");
    }

    protected static void SaveData(String variableName, String variableData)
    {
        xmlobj.saveData(variableName,variableData);
    }

    protected static String RetrieveData(String variableName)
    {
        return xmlobj.retrieveData(variableName);
    }

    protected static void AssertDisplayed(WebElement element)
    {
        System.out.println("Verifying Element is Displayed :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
    }

    protected static void AssertNotDisplayed(WebElement element)
    {
        System.out.println("Verifying Element is Not Displayed :" + element.toString());
        boolean found = element.isDisplayed();
        if(found==true) {
            System.out.println("Verifying Element is Not Displayed : Element Found !");
            Assert.fail("Verifying Element is Not Displayed : Element Found !");
        }
        else
            System.out.println("Verifying Element is Not Displayed : Element Not Found !");
    }

    protected static void IsEmpty(WebElement element)
    {
        System.out.println("Verifying Element is Empty :" + element.toString());
        String Value = element.getText();
        Assert.assertTrue(Value.isEmpty(), "Element '" + element.toString() + "' is NOT Empty");
    }


    protected static void IsNotEmpty(WebElement element)
    {
        System.out.println("Verifying Element is NOT Empty :" + element.toString());
        String Value = element.getText();
        Assert.assertTrue(Value.length()==0, "Element '" + element.toString() + "' is Empty");
    }

    protected static void click(WebElement element)
    {
        System.out.println("Clicking on Element :" + element.toString());
        WaitForElementToBeClicable(element);
        element.click();
    }

    //This method takes a picture of the current screen when called and saves in the Screenshots folder
    protected static void captureScreenshot() {
        try {
            String filePath = "C:\\Selenium\\IntelliJ_Projects\\LST2\\target\\screenshots";
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date date = new Date();
            String date1 = dateFormat.format(date);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filePath + "\\screenshot_" + date1 + ".png"));

            System.out.println("***Placed screen shot in " + filePath
                    + "\\screenshot_" + date1 + ".png" + " ***");
            Reporter.log("<a href='" + filePath + "\\screenshot_" + date1
                    + ".png" + "'>screenshot</a>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void WaitForPageRefresh()
    {
        sleep(8);
    }

    protected static void WaitForPopup()
    {
        sleep(1);
    }

    protected static void AssertElementValue(WebElement element, String expected){
        Log("Asserting Element Value: '"+ expected+"'");
        String actual = getValue(element);
        Log("Expected: '" + expected + "', Actual: '" + actual + "'");
        Assert.assertTrue(expected.equals(actual), "Assert Failed, Expected: '" + expected + ", Actual: '" + actual + "'");
    }

    protected static void AssertElementText(WebElement element, String expected) {
        Log("Asserting Element Text: '"+ expected+"'");
        WaitForElement(element);
        String actual = getText(element);
        Assert.assertTrue(expected.equals(actual), "Assert Failed, Expected: '" + expected + ", Actual: '" + actual + "'");
    }

    protected static void Log(String text)
    {
        System.out.println(text);
    }

    protected static void Checked(WebElement element)
    {
        Log("Checking Element is Checked: "+ element);
        Boolean result = element.isSelected();
        Log("Checked Property Value is : "+ result);
        Assert.assertTrue(result.equals(true),"Checkbox is NOT Ticked");
    }

    protected static void UnChecked(WebElement element)
    {
        Log("Checking Element is UnChecked: "+ element);
        Boolean result = element.isSelected();
        Assert.assertTrue(result.equals(false),"Checkbox is Ticked");
    }

    public static Boolean Check_checkbox(WebElement element)
    {
        Boolean result = element.isSelected();
        if(!result)
            click(element);
        return result;
    }

    public static Boolean UnCheck_checkbox(WebElement element)
    {
        Boolean result = element.isSelected();
        if(result)
            click(element);
        return result;
    }

    protected static String FormatEmailReceiver(String emailUser)
    {
        return StringUtils.remove(emailUser,' ');
    }


    protected static void AssertAlertText(String expectedText) {
        Alert alert = driver.switchTo().alert();
        String displayedText = alert.getText();
        Log("Alert Text Displayed is : "+ displayedText);
        Assert.assertTrue(expectedText.equals(displayedText),"Alert Text displayed doesn't match the expected");
        Alert_OK();
    }


    protected static void Alert_OK() {
        Alert alert = driver.switchTo().alert();
        Log("Clicking OK on Alert ");
        alert.accept();
    }



    protected static void sendKeys(WebElement element, String text) {
        Log("Entering Text'"+text+"' in ths element '"+element+"'");
        WaitForElement(element);
        element.sendKeys(text);
    }

    protected static void sendChars(WebElement element, String text) {
        Log("Entering Text'"+text+"' in ths element '"+element+"'");
        for (int i = 0; i < text.length() ; i++) {
            element.sendKeys(String.valueOf(text.charAt(i)));
        }
    }


}

