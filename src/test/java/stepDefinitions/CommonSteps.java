package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataObjects.SNOWUser;
import pageObjects.HomePage;
import pageObjects.Poise_LoginPage;
import pageObjects.SNOW_LoginPage;

import java.util.List;

public class CommonSteps extends Util {


    @Given("^I am Logged in ServiceNow as Admin$")
    public void i_am_Logged_in_ServiceNow_as_Admin() throws Throwable {
        Poise_LoginPage poiseloginpage = new Poise_LoginPage();
        SNOW_LoginPage snowloginpage = new SNOW_LoginPage();

        navigate("https://lssitest.service-now.com/welcome.do");

        if (poiseloginpage.isAt())
            poiseloginpage.login();

        snowloginpage.login();
        //sleep(2);
        //Make sure the test instance is opened as sometimes poise login automatically launch to prod instead of test
        //navigate("https://lssitest.service-now.com/welcome.do");
        //sleep(2);

    }

    @When("^I Logoff and Login as$")
    public void i_Logoff_and_Login_as(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        SNOWUser user= new SNOWUser();
        user.initialize(data);

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(user.username);
    }

    @When("^I Select All Apps Tab$")
    public void I_Select_All_Apps_Tab()
    {
        new HomePage().SelectAllAppsTab();
    }

    @When("^I Select Favourites Tab$")
    public void I_Select_Favourites_Tab()
    {
        new HomePage().SelectFavouritesTab();
    }
}
