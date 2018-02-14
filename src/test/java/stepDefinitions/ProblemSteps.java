package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.*;
import pageObjects.*;

import java.util.List;

public class ProblemSteps extends Util {
    private String problemNo;
    private ProblemData problemData;
    private ProblemData problem1Data;


    public ProblemData GetProblemObject(String ProblemNumber)
    {
        switch (ProblemNumber) {
            case "Problem":
                problemData = problem1Data;
                break;
//            case "Problem2":
//                problemData = problem2Data;
//                break;
//            case "Problem3":
//                problemData = problem3Data;
//                break;
            default:
                problemData = problem1Data;
        }
        return  problemData;
    }


    @When("^I Create a new (.*) record with details$")
    public void i_Create_a_new_Problem_with_details(String ProblemNumber, DataTable dataTable) {
        List<List<String>> data = dataTable.raw();

        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewProblem();

        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject(ProblemNumber);
        problemData.initialize(data);
        problemNo = problemPage.NewProblem(problemData);

        SaveData(ProblemNumber, problemNo);
    }


}
