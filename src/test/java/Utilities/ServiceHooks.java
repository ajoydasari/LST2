package Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class ServiceHooks extends Util {

    public void killChrome()
    {
        //Kill all active browsers
        try {
            Runtime.getRuntime().exec("C:\\Selenium\\IntelliJ_Projects\\LST2\\KillChrome.bat");
            sleep(5);
        }catch (IOException e){}
    }

    @Before
    public void initializeTest()
    {
        killChrome();

        xmlobj = new XMLUtil();
        xmlfilename ="C:\\Selenium\\IntelliJ_Projects\\LST2\\target\\LST2_RunData.xml";
        xmlobj.setXMLFileName(xmlfilename);
        xmlobj.CreateXML(xmlfilename);
        xmlobj.saveData("Browser","Chrome");

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\IntelliJ_Projects\\LST2\\target\\drivers\\chromedriver-windows-32bit.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //driver = new ChromeDriver();
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                Log("Waiting for 5 Seconds before Capturing the Screenshot");
                sleep(5);
                captureScreenshot();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Step 4- Close Driver
        driver.close();

        //Step 5- Quit Driver
        driver.quit();
    }
}