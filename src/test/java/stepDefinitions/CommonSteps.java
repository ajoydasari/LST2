package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataObjects.SNOWUser;
import pageObjects.*;

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
    }



    @Given("^I am Logged in ServiceNow ESS as Admin$")
    public void i_am_Logged_in_ServiceNow_ESS_as_Admin() throws Throwable {
        Poise_LoginPage poiseloginpage = new Poise_LoginPage();
        SNOW_LoginPage snowloginpage = new SNOW_LoginPage();

        navigate("https://lssitest.service-now.com/ess");

        if (poiseloginpage.isAt())
            poiseloginpage.login();

        snowloginpage.ESSlogin();
    }

    @When("^I Logoff and Login as$")
    public void i_Logoff_and_Login_as(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        SNOWUser user= new SNOWUser();
        user.initialize(data);
        WaitForPageRefresh();
        HomePage homePage = new HomePage();
        homePage.Impersonate_User(user.username);
    }

    @When("^I Logoff and Login as ESS User$")
    public void i_Logoff_and_Login_as_ESS_User(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        SNOWUser user= new SNOWUser();
        user.initialize(data);
        WaitForPageRefresh();
        HomePage homePage = new HomePage();
        homePage.Impersonate_ESSUser(user.username);
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
