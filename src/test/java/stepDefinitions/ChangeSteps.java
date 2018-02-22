package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.ChangeData;
import pageObjects.ChangePage;
import pageObjects.HomePage;
import pageObjects.LHSNavigationPage;
import pageObjects.ProblemPage;

import java.util.List;

public class ChangeSteps  extends Util {


    private String changeNo;
    private ChangeData changeData;
    private ChangeData change1Data;
    private ChangeData change2Data;
    private ChangeData change3Data;

    public ChangeSteps(){
        change1Data = new ChangeData();
        change2Data = new ChangeData();
        change3Data = new ChangeData();
    }

    public ChangeData GetChangeObject(String ChangeNumber)
    {
        switch (ChangeNumber) {
            case "Change":
                changeData = change1Data;
                break;
            case "Change2":
                changeData = change2Data;
                break;
            case "Change3":
                changeData = change3Data;
                break;
            default:
                changeData = change1Data;
        }
        return  changeData;
    }



    @When("^I Click on Create New in the Change module menu$")
    public void i_Create_a_new_Problem_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();

        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewChange();

        ChangePage changePage = new ChangePage();
        changeData = GetChangeObject("Change");
        changeData.initialize(data);
        changeNo = changePage.NewChange(changeData);

        SaveData("Change", changeNo);
    }

}
