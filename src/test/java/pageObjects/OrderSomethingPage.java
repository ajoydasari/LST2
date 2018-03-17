package pageObjects;

import Utilities.Util;
import dataObjects.OrderSomethingData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderSomethingPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h4[text()='User Access']/..")
    private WebElement userAccess;

    @FindBy(how = How.XPATH, using = ".//h4[text()='Hardware']/..")
    private WebElement hardware;

    @FindBy(how = How.XPATH, using = ".//h4[text()='Removable Storage']/..")
    private WebElement removableStorage;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Encrypted USB Memory Stick']/..")
    private WebElement encryptedUSB;

    @FindBy(how = How.XPATH, using = ".//h4[text()='User Access Software']/..")
    private WebElement userAccessSoftware;

    @FindBy(how = How.XPATH, using = ".//h2[text()='ASYS Access']/..")
    private WebElement asysAccess;

    @FindBy(how = How.XPATH, using = ".//*[text()='What do you want to do?']/..//a")
    private WebElement whatDoYouWantToDo;

    @FindBy(how = How.ID, using = "s2id_autogen3_search")
    private WebElement whatDoYouWantToDoEdit;

    @FindBy(how = How.XPATH, using = ".//*[text()='POISE ID']/..//a")
    private WebElement POISEID;

    @FindBy(how = How.ID, using = "s2id_autogen5_search")
    private WebElement POISEIDEdit;

    @FindBy(how = How.XPATH, using = ".//*[text()='Asset Number Prefix']/..//a")
    private WebElement assetNumberPrefix;

    @FindBy(how = How.ID, using = "s2id_autogen1_search")
    private WebElement assetNumberPrefixEdit;

    @FindBy(how = How.XPATH, using = ".//*[text()='Asset Number']/..//input")
    private WebElement assetNumber;

    @FindBy(how = How.XPATH, using = ".//*[text()='Asset Number']/..//input")
    private WebElement asysAccessRequired;

    @FindBy(how = How.XPATH, using = ".//*[text()='Level of Access required']/..//input")
    private WebElement levelOfAccessRequired;

    @FindBy(how = How.XPATH, using = ".//*[text()='ASYS Scanning Capability required']/..//a")
    private WebElement scanningCapability;

    @FindBy(how = How.ID, using = "s2id_autogen2_search")
    private WebElement scanningCapabilityEdit;

    @FindBy(how = How.XPATH, using = ".//button[text()='Add to Cart']")
    private WebElement addToCart;

    @FindBy(how = How.XPATH, using = ".//span[text()='Checkout']/..")
    private WebElement checkout;

    @FindBy(how = How.XPATH, using = ".//button[contains(@ng-click,'editItem')]")
    private WebElement editItem;

    @FindBy(how = How.XPATH, using = ".//button[contains(@ng-click,'editItem')]/.././button[contains(@ng-click,'removeItem')]")
    private WebElement removeItem;

    @FindBy(how = How.XPATH, using = ".//*[text()='Save']")
    private WebElement save;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Your shopping cart is empty']")
    private WebElement emptyCart;

    @FindBy(how = How.XPATH, using = ".//*[text()='Please select from the following']/..//a")
    private WebElement selectFromFollowing;

    @FindBy(how = How.ID, using = "s2id_autogen24_search")
    private WebElement selectFromFollowingEdit;

    @FindBy(how = How.XPATH, using = ".//*[@id='select2-chosen-21']/..")
    private WebElement permissionsType;

    @FindBy(how = How.ID, using = "s2id_autogen21_search")
    private WebElement permissionsTypeEdit;

    @FindBy(how = How.XPATH, using = ".//div[@aria-hidden='false']/*[text()='What is the information you are moving?']/..//input")
    private WebElement whatInfoIsMoving;

    @FindBy(how = How.XPATH, using = ".//div[@aria-hidden='false']/*[text()='What is the business benefit of moving it?']/..//input")
    private WebElement businessBenefitOfMove;

    @FindBy(how = How.XPATH, using = ".//div[@aria-hidden='false']/*[text()='Where is the information moving to and from']/..//input")
    private WebElement whereToAndFrom;

    @FindBy(how = How.XPATH, using = ".//div[@aria-hidden='false']/*[text()='Deskside']/..//a")
    private WebElement deskside;

    @FindBy(how = How.ID, using = "s2id_autogen26_search")
    private WebElement desksideEdit;

    @FindBy(how = How.XPATH, using = ".//*[text()='Business Justification']/..//textarea")
    private WebElement businessJustification;

    @FindBy(how = How.XPATH, using = ".//input[@ng-model='c.quantity']")
    private WebElement quantity;

    @FindBy(how = How.XPATH, using = ".//input[@ng-model='item.quantity']")
    private WebElement showQuantity;

    @FindBy(how = How.XPATH, using = ".//span[text()='The quantity cap for this item is 20. Your cart has been adjusted to reflect this']")
    private WebElement quantityCap20;

    @FindBy(how = How.XPATH, using = ".//a[text()='Save to Regular Orders']")
    private WebElement saveToRegularOrders;

    @FindBy(how = How.XPATH, using = ".//input[@ng-model='c.data.newCartName']")
    private WebElement nameRegularOrder;




    public void WaitForPageLoad()
    {
        WaitForElement(userAccess);
    }

    public OrderSomethingPage()
    {
        PageFactory.initElements(driver,this);
    }



    public void selectUserAccess()
    {
        click(userAccess);
        WaitForElement(userAccessSoftware);
    }


    public void Checkout()
    {
        click(checkout);
        WaitForElement(userAccessSoftware);
    }


    public void selectHardware()
    {
        click(hardware);
        WaitForElement(userAccessSoftware);
    }


    public void selectRemovableStorage()
    {
        click(removableStorage);
        WaitForElement(userAccessSoftware);
    }

    public void selectEncryptedUSB()
    {
        click(encryptedUSB);
        WaitForElement(whatDoYouWantToDo);
    }


    public void selectUserAccessSoftware()
    {
        click(userAccessSoftware);
        WaitForElement(asysAccess);
    }


    public void selectASYSAccess()
    {
        click(asysAccess);
        WaitForElement(whatDoYouWantToDo);
    }


    public void addToCart()
    {
        click(asysAccess);
        WaitForElement(checkout);
    }


    public void editItem()
    {
        click(editItem);
        WaitForElement(POISEID);
    }

    public void editItemSave()
    {
        click(save);
        WaitForElementToDisappear(save);
    }


    public void validateQty(String qty)
    {
        AssertElementValue(showQuantity,qty);
    }

    public void messageDisplayed(String qty)
    {
        AssertDisplayed(quantityCap20);
    }


    public void saveToRegularOrders()
    {
        click(saveToRegularOrders);
        WaitForElement(nameRegularOrder);
    }

    public void nameRegularOrder(OrderSomethingData orderSomethingData)
    {
        sendKeys(nameRegularOrder,orderSomethingData.RegularOrderName);
        click(save);
        WaitForElementToBeClicable(saveToRegularOrders);
    }


    public void editQty(String qty)
    {
        sendKeys(showQuantity,qty);
    }

    public void removeItem()
    {
        click(removeItem);
        WaitForElement(emptyCart);
    }


    public void selectDropDownOption(String optionText)
    {
        ClickElementByXPath(".//ul/li//div[contains(text(),'"+optionText+"')]");
        sleep(3);
    }


    public void selectDropDownOption1(String optionText)
    {
        ClickElementByXPath(".//ul/li//div/span[contains(text(),'"+optionText+"')]");
        sleep(3);
    }


    public void CompleteASYSAccessDetails(OrderSomethingData orderSomethingData)
    {
        click(whatDoYouWantToDo);
        sendKeys(whatDoYouWantToDoEdit, orderSomethingData.WhatDoYouWantToDo);
        selectDropDownOption(orderSomethingData.WhatDoYouWantToDo);

        click(POISEID);
        sendKeys(POISEIDEdit, orderSomethingData.PoiseID);
        selectDropDownOption(orderSomethingData.PoiseID);

        click(assetNumberPrefix);
        sendKeys(assetNumberPrefixEdit, orderSomethingData.AssetNumberPrefix);
        selectDropDownOption(orderSomethingData.AssetNumberPrefix);

        sendKeys(assetNumber, orderSomethingData.AssetNumber);
        sendKeys(asysAccessRequired, orderSomethingData.AsysAccessRequired);
        sendKeys(levelOfAccessRequired, orderSomethingData.LevelOfAccessRequired);

        click(scanningCapability);
        sendKeys(scanningCapabilityEdit, orderSomethingData.ASYSScanningCapabilityRequired);
        selectDropDownOption(orderSomethingData.ASYSScanningCapabilityRequired);

    }


    public void UpdateASYSAccessDetails(OrderSomethingData orderSomethingData)
    {
        sendKeys(asysAccessRequired, orderSomethingData.AsysAccessRequired);
        sendKeys(levelOfAccessRequired, orderSomethingData.LevelOfAccessRequired);
        click(save);
        WaitForElementToDisappear(save);
    }


    public void CompleteUSBMemoryStickDetails(OrderSomethingData orderSomethingData)
    {
        click(whatDoYouWantToDo);
        sendKeys(whatDoYouWantToDoEdit, orderSomethingData.WhatDoYouWantToDo);
        selectDropDownOption(orderSomethingData.WhatDoYouWantToDo);

        click(selectFromFollowing);
        sendKeys(selectFromFollowingEdit, orderSomethingData.PleaseSelectFromTheFollowing);
        selectDropDownOption(orderSomethingData.PleaseSelectFromTheFollowing);

        click(POISEID);
        sendKeys(POISEIDEdit, orderSomethingData.PoiseID);
        selectDropDownOption(orderSomethingData.PoiseID);

        click(permissionsType);
        sendKeys(permissionsTypeEdit, orderSomethingData.PermissionType);
        selectDropDownOption(orderSomethingData.PermissionType);

        sendKeys(whatInfoIsMoving, orderSomethingData.WhatInfoIsMoving);
        sendKeys(businessBenefitOfMove, orderSomethingData.BusinessBenefitOfMove);
        sendKeys(whereToAndFrom, orderSomethingData.WhereFromAndTo);

        click(deskside);
        sendKeys(desksideEdit, orderSomethingData.Deskside);
        selectDropDownOption(orderSomethingData.Deskside);

        sendKeys(businessJustification, orderSomethingData.BusinessJustification);
        sendKeys(quantity, orderSomethingData.Quantity);
    }
}