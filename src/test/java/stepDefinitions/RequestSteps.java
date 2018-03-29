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

    @When("^I Navigate to My Closed Orders$")
    public void I_Navigate_to_My_Closed_Orders()
    {
        new ESSLandingPage().MyClosedOrders();
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

    @When("^I Logout of ESS and Login to ServiceNow as Admin$")
    public void I_Logout_of_ESS_and_Login_to_ServiceNow_as_Admin()
    {
        Poise_LoginPage poiseloginpage = new Poise_LoginPage();
        SNOW_LoginPage snowloginpage = new SNOW_LoginPage();

        new ESSLandingPage().ESSLogout();
        navigate(SNOW_URL);

        if (poiseloginpage.isAt())
            poiseloginpage.login();

        snowloginpage.ESSlogin();

        if (new ESSLandingPage().IsAt())
            navigate(SNOW_URL1);

    }



    @Then("^New Request Raised email sent to the Requester '(.*)'")
    public void New_Request_Raised_email_sent_to_the_Requester(String requester) {

        WaitForEmailsToBeSent();

        String requestNo = RetrieveData("Request");
        Find_Email1(FormatEmailReceiver(requester), "New Request Raised", requestNo);
    }


    @Then("^an email is sent to the Approver")
    public void an_email_is_sent_to_the_Approver() {

        WaitForEmailsToBeSent();

        String requestNo = RetrieveData("RITMNo");
        Find_Email(FormatEmailReceiver(orderSomethingData.Approver), "New Requested Item", requestNo);
    }


    @Then("^an email is sent to the 2nd Approver '(.*)'")
    public void an_email_is_sent_to_the_2ndApprover(String approver) {

        WaitForEmailsToBeSent();
        new HomePage().Impersonate_User(GblEmailsUser);

        String requestNo = RetrieveData("RITMNo");
        Find_Email1(approver, "New Requested Item", requestNo);
    }


    @Then("^an email is sent to the Fulfiller '(.*)'")
    public void an_email_is_sent_to_the_Fulfiller(String fulfiller) {

        WaitForEmailsToBeSent();
        new HomePage().Impersonate_User(GblEmailsUser);
        new CommonPageObjects().Find_Record("RITMNo");
        String TaskNo = new RequestedItemPage().getRequestTaskNo();
        SaveData("TaskNo", TaskNo);
        String requestNo = RetrieveData("RITMNo");
//        Find_Email1(fulfiller, "New Request Task For Your Action", requestNo);
        Find_Email1(fulfiller, "*New Requested Item", requestNo);
    }



    private void Find_Email(String requester, String subject, String bodyText)
    {
        LHSNavigationPage navPage = new LHSNavigationPage();
        EmailsPage emails = new EmailsPage();
        navPage.openEmails();
        emails.Email_Exists(requester, subject, bodyText);
    }

    private void Find_Email1(String requester, String subject, String targetText)
    {
        LHSNavigationPage navPage = new LHSNavigationPage();
        EmailsPage emails = new EmailsPage();
        navPage.openEmails();
        emails.Email_Exists1(requester, subject, targetText);
    }

    @When("^I Click on the Approval for the request item")
    public void I_Click_on_the_Approval_for_the_request_item() {

        String requestNo = RetrieveData("RITMNo");
        new ApprovalListPage().selectRecord(requestNo);
        new ApprovalPage().WaitForPageLoad(requestNo);
    }


    @When("^I Search and Open the Request Item")
    public void I_Search_and_Open_the_Request_Item() {
        new CommonPageObjects().Find_Record("RITMNo");
    }


    @When("^I Navigate to the approval task of the request item assigned to (.*)")
    public void I_Navigate_to_the_approval_task_of_the_request_item_assigned(String approver) {
        RequestPage requestPage = new RequestPage();
        RequestedItemPage requestedItemPage = new RequestedItemPage();
        String requestNo = RetrieveData("RITMNo");
//        requestPage.selectRequestedItem(requestNo);
        requestedItemPage.selectApprovalItem(approver);
    }


    @When("^The the estimated delivery date is displayed")
    public void The_the_estimated_delivery_date_is_displayed() {
        new ESSMyOpenRequestsPage().verifyEstimatedDeliveryDateDisplayed();
    }


    @When("^I Navigate to the Items module on the Service Catalog application menu")
    public void I_Navigate_to_the_Items_module_on_the_Service_Catalog_application_menu() {
        LHSNavigationPage navPage = new LHSNavigationPage();
        navPage.openServiceCatalogItems();
    }

    @When("^I Navigate to the requested item")
    public void I_Navigate_to_the_requested_item() {
        LHSNavigationPage navPage = new LHSNavigationPage();
        RequestedItemsPage requestedItemsPage = new RequestedItemsPage();
        String requestNo = RetrieveData("RITMNo");
        requestedItemsPage.selectRequestItem(requestNo);
    }


    @When("^the user can view the request item fullfilment task in the tasks tab")
    public void the_user_can_view_the_request_item_fullfilment_task_in_the_tasks_tab() {
        RequestedItemPage requestedItemPage = new RequestedItemPage();
        String taskNo = RetrieveData("TaskNo");
        requestedItemPage.verifyImplementTaskDisplayed(taskNo);
    }


    @When("^I Navigate to My Groups Work module")
    public void I_Navigate_to_My_Groups_Work_module() {
        LHSNavigationPage navPage = new LHSNavigationPage();
        navPage.openMyGroupWork();
    }

    @When("^I Select the fultilment task for the requested item")
    public void I_Select_the_fultilment_task_for_the_requested_item() {
        String taskNo = RetrieveData("TaskNo");
        new CatalogTasksPage().selectTaskItem(taskNo);
    }

    @When("^the SLA assigned to the fulfilment task is appropriate for the quantity of items selected")
    public void the_SLA_assigned_to_the_fulfilment_task_is_appropriate_for_the_quantity_of_items_selected() {
        new CatalogTaskPage().verifyTaskSLA1Created();
    }


    @When("^I assign the task to myself '(.*)'")
    public void I_assign_the_task_to_myself(String user) {
        new CatalogTaskPage().AssignToMe(user);
    }


    @When("^I Populate the work notes with '(.*)'")
    public void I_Populate_the_work_notes(String workNotes) {
        new CatalogTaskPage().AddWorkNotes(workNotes);
    }

    @When("^I Populate the Customer Visible Notes with '(.*)'")
    public void I_Populate_the_Customer_Visible_Notes(String workNotes) {
        new CatalogTaskPage().AddCustomerNotes(workNotes);
    }

    @When("^I Populate the Requested Item work notes with '(.*)'")
    public void I_Populate_the_Requested_Item_work_notes(String workNotes) {
        new RequestedItemPage().AddWorkNotes(workNotes);
    }

    @When("^I Populate the Requested Item Customer Visible Notes with '(.*)'")
    public void I_Populate_the_Requested_Item_Customer_Visible_Notes(String workNotes) {
        new RequestedItemPage().AddCustomerNotes(workNotes);
    }

    @When("^I Populate the variables field with details '(.*)','(.*)','(.*)'")
    public void I_Populate_the_Customer_Visible_Notes(String assetNo, String modelNo, String serialNo) {
        new CatalogTaskPage().AddVariableData(assetNo, modelNo, serialNo);
    }


    @When("^I Close the task with Notes '(.*)'")
    public void I_Close_the_task(String notes) {
        new CatalogTaskPage().CloseTask(notes);
    }


    @Then("^an email is sent to the Requester '(.*)' stating worknotes have been added")
    public void an_email_is_sent_to_the_Requester_stating_worknotes_have_been_added(String requester) {

        WaitForEmailsToBeSent();

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        String requestNo = RetrieveData("RITMNo");
        Find_Email1(FormatEmailReceiver(requester), "Additional Comments on Request", requestNo);
    }

    @Then("^an email is sent to the Requester '(.*)' Acceptance of the Item")
    public void an_email_is_sent_to_the_Requester_Acceptance_of_the_Item(String requester) {

        String requestNo = RetrieveData("RITMNo");
        Find_Email1(FormatEmailReceiver(requester), "*awaiting your acceptance", requestNo);
    }


    @Then("^the user can view the customer visible work notes added to the record '(.*)'")
    public void user_can_view_the_customer_visible_work_notes_added_to_the_record(String notes) {
        new ESSMyOpenRequestsPage().verifyCustomerVisibleWorknotes(notes);
    }


    @When("^I Click on Accept")
    public void I_Click_on_Accept() {
        new ESSMyOpenRequestsPage().AcceptRequest();
    }


    @When("^I Populate the comment box with '(.*)'")
    public void I_Populate_the_comment_box(String comments) {
        new ESSMyOpenRequestsPage().ConfirmAcceptComments(comments);
    }


    @Then("^the requested item is not displayed")
    public void the_requested_item_is_not_displayed() {
        String requestNo = RetrieveData("Request");
        new ESSMyOpenRequestsPage().VerifyRequestNotDisplayed(requestNo);
    }

    @Then("^the requested item is displayed")
    public void the_requested_item_is_displayed() {
        String requestNo = RetrieveData("Request");
        new ESSMyClosedRequestsPage().VerifyRequestDisplayed(requestNo);
    }

    @Then("^an email is sent to the Post implementation Fullfiller '(.*)'")
    public void an_email_is_sent_to_the_Post_implementation_Fullfiller(String fulfiller) {
        WaitForEmailsToBeSent();
        new CommonPageObjects().Find_Record("RITMNo");
        String TaskNo = new RequestedItemPage().getUpdateLicenseTaskNo();
        SaveData("TaskNo1", TaskNo);
        Find_Email1(fulfiller, "New Request Task For Your Action", TaskNo);
    }

    @Then("^I Navigate to the Post Implementation Fulfillment Task")
    public void I_Navigate_to_the_Post_Implementation_Fulfillment_Task() {
        String TaskNo = RetrieveData("TaskNo1");
        new CatalogTasksPage().selectTaskItem(TaskNo);
    }


    @When("^Closed Order State displayed as '(.*)'$")
    public void Closed_Order_State_displayed_as(String state)
    {
        new ESSMyClosedRequestsPage().validateState(state);
    }


    @Then("^Closure email is sent to the Requester '(.*)'")
    public void Closure_email_is_sent_to_the_Requester(String user) {
        WaitForEmailsToBeSent();
        String requestNo = RetrieveData("RITMNo");
        Find_Email1(user, "Request Item Closure", requestNo);
    }
}


