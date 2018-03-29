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
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class Util extends XMLUtil{
    protected static WebDriver driver = null;
    private static String parentWindowHandler;
    private static Set<String> oldWindows;
    private static int defaultTimeout = 40;
    protected String GblEmailsUser = "Ajoy Dasari";
//    protected static String SNOW_URL = "https://lssitest.service-now.com/welcome.do";
//    protected static String SNOW_URL1 = "https://lssitest.service-now.com/";
//    protected static String SNOW_URL2 = "https://lssitest.service-now.com/login.do";
    protected static String SNOW_URL = "https://lssidatabuild.service-now.com/welcome.do";
    protected static String SNOW_URL1 = "https://lssidatabuild.service-now.com/";
    protected static String SNOW_URL2 = "https://lssidatabuild.service-now.com/login.do";

    protected static void sleep(int waitValue) {
        System.out.println("Sleeping for '" + waitValue + "' half seconds");
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
        Boolean found=false;
        System.out.println("Waiting for Element :" + element.toString() + ", a maximum of "+defaultTimeout+" seconds");
        try {
            for (int i = 0; i < defaultTimeout ; i++) {
                try {
                    found=element.isDisplayed();
                    if(found){
                        found = true;
                        break;
                    }
                    else
                        sleep(1);
                } catch (Exception e) {
                    sleep(1);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while Waiting for Element, Exception :" + e.getMessage());
        }
        Assert.assertTrue(found, "WaitForElement : Element Found = ");
    }


    protected static void WaitForElementToBeClicable(WebElement element) {
        Boolean waiting=true;
        int timeout = defaultTimeout;
        WaitForElement(element);
        System.out.println("Waiting for Element To Be Clickable :" + element.toString());
        for (int i = timeout; i > 0; i--) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 1);
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                } catch (Exception e) {
                    sleep(1);
                }
        }
    }


    protected static void WaitForElementToBeClickableByXPath(String xpath) {
        System.out.println("Waiting for Element To Be Clickable By XPath:" + xpath);
        for (int i = defaultTimeout; i > 0; i--) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
                break;
            } catch (Exception e) {
                sleep(1);
            }
        }
    }

    protected static void WaitForElementToDisappear(WebElement element) {
        System.out.println("Waiting for Element to Disappear :" + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected static WebElement ElementByXPath(String xpath) {

        WaitForElement(driver.findElement(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    protected static void ClickElementByXPath(String xpath) {
        boolean found = false;
        System.out.println("Clicking on Element with Xpath:" + xpath);
        for (int i = defaultTimeout; i > 0; i--) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
                driver.findElement(By.xpath(xpath)).click();
                found = true;
                break;
            } catch (Exception e) {
                sleep(1);
                Log("Sleeping for 1 Second");
            }
        }
        Assert.assertTrue(found==true, "ClickElementByXPath : Element NOT Found");
    }

    protected static void SwitchToIFrame() {
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
        String value="";
            try {
                WaitForElement(element);
                value = element.getAttribute("value");
            } catch (NoSuchElementException e) {
                sleep(5);
                value = element.getAttribute("value");
            }
        return value;
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
            if(value==null)
                value = element.getText();
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


    protected static void ClickToOpenNewWindow(WebElement element) {
        boolean found=false;
        CaptureWindowHandles();
        for (int i = 0; i < 3; i++) {
            click(element);
            found = SwitchToNewWindow();
            if(found)
                break;
            else
                sleep(2);
        }
    }


    protected static void SelectFromLookup(WebElement element, String linkText) {
        ClickToOpenNewWindow(element);
        try{
            WebElement element1 = driver.findElement(By.xpath(".//div[@class='input-group']/input"));
        if(isElementPresent(element1))
        {
            sendKeysVerify(element1,linkText);
            element1.sendKeys(Keys.ENTER);
            sleep(3);
        }
        }catch (Exception e){}
        ClickElementByXPath(".//a[text()='"+ linkText +"']");
        SwitchToOldWindow();
        SwitchToIFrame();
    }


    protected static boolean SwitchToNewWindow() {
        boolean found=false;
        for (int i = defaultTimeout; i > 0; i--) {
            try {
                SwitchToDefault();
                Set<String> allWindows;
                allWindows = driver.getWindowHandles();
                allWindows.removeAll(oldWindows);
                String newWindow = allWindows.iterator().next();
                driver.switchTo().window(newWindow);
                found=true;
                break;
            } catch (Exception e) {
                sleep(1);
            }
        }
        if(found)
            Log("New Window Found : '" + driver.getTitle() + "'");
        else
            Log("New Window Not Found : '");
        return found;
    }

    protected static void CloseNewWindow() {
        driver.close();
    }

    protected static void selectValue(WebElement element, String optionValue) {
        System.out.println("Select Value - " + element.toString() + " : '" + optionValue + "'");
        WaitForElement(element);
        WaitForElementToBeClicable(element);
        try {
            new Select(element).selectByVisibleText(optionValue);
            return;
        } catch (NoSuchElementException e) {
          Log("selectValue: Unable to select option by Visible Text");
        }

        try {
            new Select(element).selectByValue(optionValue);
            return;
        } catch (NoSuchElementException e) {
            Log("selectValue: Unable to select option by Value");
        }

        try {
            List<WebElement> options = element.findElements(By.tagName("option"));
            for (WebElement option : options) {
                WaitForElementToBeClicable(option);
                click(element);
                if (option.getAttribute("text").contains(optionValue))
                    click(option);
                else
                    Log("selectValue: Unable to select option using Text Attribute");
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
        sleep(2);
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
        Log("Verifying Element is Displayed :" + element.toString());
        WaitForElement(element);
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
        Boolean found=false;
        WaitForElement(element);
        WaitForElementToBeClicable(element);
        System.out.println("Clicking on Element :" + element.toString());
        for (int i = 0; i <defaultTimeout ; i++) {
            try {
                element.click();
                found=true;
                break;
            } catch (Exception e) {
                sleep(1);
            }
        }
        Assert.assertTrue(found==true, "Element '" + element.toString() + "'");
    }


    protected static void click_NoAssert(WebElement element)
    {
        Boolean found=false;
        WaitForElement(element);
        WaitForElementToBeClicable(element);
        System.out.println("Clicking on Element :" + element.toString());
        for (int i = 0; i <defaultTimeout ; i++) {
            try {
                element.click();
                found=true;
                break;
            } catch (Exception e) {
                sleep(1);
            }
        }
//        Assert.assertTrue(found==true, "Element '" + element.toString() + "'");
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


    protected static void PageLoadWait()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i=0; i<defaultTimeout; i++){
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
            sleep(1);
        }
        sleep(20);
    }

    protected static void WaitForPageRefresh()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i=0; i<defaultTimeout; i++){
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
            sleep(1);
        }
        sleep(6);
    }

    protected static void WaitForPopup()
    {
        sleep(1);
    }


    protected static void WaitForElementValue(WebElement element, String expected){
        Log("Waiting For Element Value: '"+ expected+"'");
        String actual = getValue(element);
        for (int i = defaultTimeout; i > 0; i--) {
//            if(expected.equals(actual)) {
            if(actual.contains(expected)) {
                sleep(2);
                break;
            }
            else {
                Log("expected:'"+expected+"', actual:'"+actual+"', result:"+actual.contains(expected));
                sleep(2);
                actual = getValue(element);
            }
        }
    }


    protected static void AssertElementValue(WebElement element, String expected){
        Log("Asserting Element Value: '"+ expected+"'");
        WaitForElement(element);
        String actual = getValue(element);
        //Log("Expected: '" + expected + "', Actual: '" + actual + "'");
        for (int i = defaultTimeout; i > 0; i--) {
            if(expected.equals(actual)) {
                Log("Expected: '" + expected + "', Actual: '" + actual + "', retry count:="+(defaultTimeout-i));
                break;
            }
            else {
                sleep(2);
                actual = getValue(element);
                Log("Expected: '" + expected + "', Actual: '" + actual + "', retry count:="+(defaultTimeout-i));
            }
        }
        Assert.assertTrue(expected.equals(actual), "Assert Failed, Expected: '" + expected + ", Actual: '" + actual + "'");
        //Log("Expected: '" + expected + "', Actual: '" + actual + "'");
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
        WaitForElementToBeClicable(element);
        try {
            element.clear();
            element.sendKeys(text);
        }
        catch (Exception e){
            sleep(5);
            element.clear();
            element.sendKeys(text);
        }
    }


    protected static void sendKeysEnter(WebElement element, String text) {
        Log("Entering Text'"+text+"' in ths element '"+element+"'");
        WaitForElement(element);
        WaitForElementToBeClicable(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        WaitForPageRefresh();
    }


    protected static void sendKeysVerify(WebElement element, String text) {
        String enteredValue;
        Log("Entering Text'"+text+"' in ths element '"+element+"'");
        WaitForElement(element);
        WaitForElementToBeClicable(element);
        do {
            element.clear();
            element.sendKeys(text);
            enteredValue = getValue(element).trim();
            //Log("'"+text+"="+enteredValue+"'");
        }while(!(text.equals(enteredValue)));

    }

    protected static void sendChars(WebElement element, String text) {
        Log("Entering Text'"+text+"' in ths element '"+element+"'");
        for (int i = 0; i < text.length() ; i++) {
            element.sendKeys(String.valueOf(text.charAt(i)));
        }
    }



    public void ScrollPage(WebElement element, int pages)
    {
        System.out.println("Scrolling Page, Pages to Scroll : " + pages);
        element.click();
        for (int i = 0; i < pages; i++)
        {
            element.sendKeys(Keys.PAGE_DOWN);
            sleep(1);
        }
    }

    public void selectTab(WebElement element) {
        WaitForElement(element);
        for (int i = defaultTimeout; i > 0; i--) {
            if (!(element.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            {
                click(element);
                WaitForPageRefresh();
            }
            else
                break;
        }
    }

    public void WaitForMessage(String messageText) {
        WebElement element;
        String displayedText = "";

        for (int i = defaultTimeout; i > 0; i--) {
            try {
                element = ElementByXPath(".//div[@class='outputmsg_div']//span[@class='outputmsg_text']");
                displayedText = getText(element);
                if (displayedText.equals(messageText))
                {
                    Log("WaitForMessage: Message displayed: '" + messageText +"'");
                    break;
                }
                else
                    sleep(1);
            } catch (Exception e) {
                Log("Exception Occurred in WaitForMessage, Error Details: " + e.getMessage());
            }
        }
    }

    public int Length(String stringContent){
        return StringUtils.trim(stringContent).length();
    }

    public String getRandomNumber() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String formatted = String.format("%05d", num);
        return formatted;
    }


    public void WaitForEmailsToBeSent()
    {
        sleep(5);
    }
}

