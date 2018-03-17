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
}
