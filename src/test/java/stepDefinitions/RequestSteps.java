package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.OrderSomethingData;
import pageObjects.*;

import java.util.List;

public class RequestSteps extends Util {

    private OrderSomethingData orderSomethingData;
    public RequestSteps(){
        orderSomethingData = new OrderSomethingData();
    }


    @When("^I Click on Order Something$")
    public void I_Click_on_Order_Something(){
        new ESSLandingPage().selectOrderSomething();
    }


    @When("^I Select the User Access category$")
    public void I_Select_the_User_Access_category(){
        new OrderSomethingPage().selectUserAccess();
    }


    @When("^I Select the Hardware Access category$")
    public void I_Select_the_Hardware_Access_category(){
        new OrderSomethingPage().selectHardware();
    }

    @When("^I Select the Removable Storage subcategory$")
    public void I_Select_the_Removable_Storage_category(){
        new OrderSomethingPage().selectRemovableStorage();
    }

    @When("^I Select the Encrypted USB Memory Stick item$")
    public void I_Select_the_Encrypted_USB_Memory_Stick_item(){
        new OrderSomethingPage().selectEncryptedUSB();
    }

    @When("^I Select the User Access Software subcategory$")
    public void I_Select_the_User_Access_Software_subcategory()
    {
        new OrderSomethingPage().selectUserAccessSoftware();
    }

    @When("^I Select the ASYS Access item$")
    public void I_Select_the_ASYS_Access_item()
    {
        new OrderSomethingPage().selectASYSAccess();
    }

    @When("^I Populate ASYS record with the information$")
    public void I_Populate_ASYS_record_with_the_information(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        orderSomethingData.initialize(data);
        new OrderSomethingPage().CompleteASYSAccessDetails(orderSomethingData);
    }


    @When("^I Populate the USB Memory Stick record with the information$")
    public void I_Populate_the_USB_Memory_Stick_record_with_the_information(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        orderSomethingData.initialize(data);
        new OrderSomethingPage().CompleteUSBMemoryStickDetails(orderSomethingData);
    }

    @When("^I update the record with the information$")
    public void I_update_the_record_with_the_information(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        orderSomethingData.initialize(data);
        new OrderSomethingPage().UpdateASYSAccessDetails(orderSomethingData);
    }

    @When("^I Add to cart$")
    public void I_Add_to_cart()
    {
        new OrderSomethingPage().addToCart();
    }


    @When("^I Edit item$")
    public void I_Edit_item()
    {
        new OrderSomethingPage().editItem();
    }


    @When("^the quantity has automatically changed to (.*)$")
    public void the_quantity_has_automatically_changed(String qty)
    {
        new OrderSomethingPage().validateQty(qty);
    }

    @When("^I Edit the quantity to (.*)$")
    public void I_Edit_the_quantity(String qty)
    {
        new OrderSomethingPage().editQty(qty);
    }


    @Then("^Quantity cap for this item is (.*) message displayed$")
    public void Quantity_cap_for_this_item_is_message_displayed(String qty)
    {
        new OrderSomethingPage().messageDisplayed(qty);
    }

    @Then("^I Save to Regular Orders$")
    public void I_Save_to_Regular_Orders()
    {
        new OrderSomethingPage().saveToRegularOrders();
    }

    @Then("^I name the regular order$")
    public void I_name_the_regular_order(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        orderSomethingData.initialize(data);
        new OrderSomethingPage().nameRegularOrder(orderSomethingData);
    }

    @When("^I Edit item and click on Save$")
    public void I_Edit_item_and_save()
    {
        new OrderSomethingPage().editItemSave();
    }


    @When("^I Click on Checkout$")
    public void I_Click_on_Checkout()
    {
        new OrderSomethingPage().Checkout();
    }


    @When("^I Delete the item from the cart$")
    public void I_Delete_the_item_from_the_cart()
    {
        new OrderSomethingPage().removeItem();
    }

    @When("^I Navigate to the homepage$")
    public void I_Navigate_to_the_homepage()
    {
        new ESSLandingPage().navigateToHome();
    }


    @When("^I Navigate to My Open Orders$")
    public void I_Navigate_to_My_Open_Orders()
    {
        new ESSLandingPage().MyOpenOrders();
    }


    @When("^I Select the requested item$")
    public void I_Select_the_requested_item()
    {
        ESSMyOpenRequestsPage essMyOpenRequestsPage = new ESSMyOpenRequestsPage();
        essMyOpenRequestsPage.SelectFirstOrder();
        String requestNo = essMyOpenRequestsPage.getRequestNumber();
        String ritmNo = essMyOpenRequestsPage.getRITMNumber();

        SaveData("Request", requestNo);
        SaveData("RITMNo", ritmNo);
    }


    @When("^Order State displayed as '(.*)'$")
    public void Order_State_displayed_as(String state)
    {
        new ESSMyOpenRequestsPage().validateState(state);
    }

    @Then("^'Escalate Approval' and 'Withdraw' buttons are displayed$")
    public void escalate_Approval_and_Withdraw_buttons_are_displayed()
    {
        new ESSMyOpenRequestsPage().validateButtonDisplayed("Escalate Approval");
        new ESSMyOpenRequestsPage().validateButtonDisplayed("Withdraw");
    }

    @Then("^the Approvers name is displayed$")
    public void Approvers_name_is_displayed(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        orderSomethingData.initialize(data);
        new ESSMyOpenRequestsPage().verifyApproverDisplayed(orderSomethingData);
    }


    @When("^I Logout of ESS$")
    public void I_Logout_of_ESS()
    {
        new ESSLandingPage().ESSLogout();
    }

    @Then("^New Request Raised email sent to the Requester '(.*)'")
    public void New_Request_Raised_email_sent_to_the_Requester(String requester) {

        WaitForEmailsToBeSent();

        String requestNo = RetrieveData("Request");
        Find_Email1(FormatEmailReceiver(requester), "New Request Raised", requestNo);
    }


    @Then("^an email is sent to the Approver")
    public void an_email_is_sent_to_the_Approver(OrderSomethingData orderSomethingData) {

        WaitForEmailsToBeSent();

        String requestNo = RetrieveData("RITMNo");
        Find_Email1(FormatEmailReceiver(orderSomethingData.Approver), "New Requested Item", requestNo);
    }


    @Then("^an email is sent to the 2nd Approver '(.*)'")
    public void an_email_is_sent_to_the_2ndApprover(String approver) {

        WaitForEmailsToBeSent();

        String requestNo = RetrieveData("RITMNo");
        Find_Email1(FormatEmailReceiver(approver), "*For Your Approval", requestNo);
    }

    private void Find_Email1(String requester, String subject, String targetText)
    {
        LHSNavigationPage navPage = new LHSNavigationPage();
        EmailsPage emails = new EmailsPage();
        navPage.openEmails();
        emails.Email_Exists1(requester, subject, targetText);
    }

    @When("^I Click on the Approval for the request item")
    public void I_Click_on_the_Approval_for_the_request_item(OrderSomethingData orderSomethingData) {

        String requestNo = RetrieveData("RITMNo");
        new ApprovalListPage().selectRecord(requestNo);
        new ApprovalPage().WaitForPageLoad(requestNo);
    }


    @When("^I Search and Open the Request Item")
    public void I_Search_and_Open_the_Request_Item() {
        new CommonPageObjects().Find_Record("RITMNo");
    }


}
