package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

/**
 * 7.AccountPage - store Transaction, deposit and withdraw.
 */
public class AccountPage extends Utility {
    By bankManagerLoginButton = By.cssSelector("button[ng-click='manager()']");
    By addCustomerTab = By.xpath("//button[normalize-space()='Add Customer']");
    By firstName = By.cssSelector("input[placeholder='First Name']");
    By lastName = By.xpath("//input[@placeholder='Last Name']");
    By postCode = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
    By openAccountTab = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]");
    By customerDropdownOpenAccount =By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/select[1]");
    By currencyDropdown = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/select[1]");//body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/select[1]");
    By processButton =By.xpath("//button[normalize-space()='Process']");
    By customerLoginTab = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");
    By searchCustomer = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/select[1]");
    By login =By.xpath("(//button[normalize-space()='Login'])[1]");
    By loginVerifyText = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/strong[1]/span[1]");
    By logoutButton =By.xpath("//button[normalize-space()='Logout']");
    By depositButton = By.xpath("//button[normalize-space()='Deposit']");
    By amount = By.xpath("//input[@placeholder='amount']");
    By deposit= By.xpath("(//button[@type='submit'])[1]");
    By depositSuccessText = By.xpath("//span[@class='error ng-binding']");
    By withdrawl = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]");
    By amountWithdraw = By.xpath("//input[@placeholder='amount']");
    By withdrawButton = By.xpath("(//button[normalize-space()='Withdraw'])[1]");
    By transactionSuccessText = By.xpath("//span[@class='error ng-binding']");



    public void clickOnBankManagerLoginButton(){clickOnElement(bankManagerLoginButton);}
    public void clickOnAddCustomerTab(){ clickOnElement(addCustomerTab); }
    public void sendFirstName(String firstname){sendTextToElement(firstName,firstname);}
    public void sendLastName(String lastname){sendTextToElement(lastName,lastname);}
    public void sendPostCode(String postcode){sendTextToElement(postCode,postcode);}
    public void clickOnAddCustomerButton(){clickOnElement(addCustomerButton);}
    public void clickOnOpenAccountTab(){clickOnElement(openAccountTab);}
    public void searchForCustomerNameOpenAccount(String customerName){
        selectByContainsTextFromDropDown(customerDropdownOpenAccount,customerName);}
    public void selectCurrencyOpenAccount(String currency){
        selectByContainsTextFromDropDown(currencyDropdown,currency);}
    public void clickProcessButtonOpenAccount(){
        clickOnElement(processButton);
    }
    public void clickOnCustomerTab(){
        clickOnElement(customerLoginTab);
    }
    public void searchForCustomer(String text){
        selectByContainsTextFromDropDown(searchCustomer,text);
    }
    public void clickOnLoginButton(){
  clickOnElement(login);
    }
    public String getLoginVerifyText(){
        String text= getTextFromElement(loginVerifyText);
        System.out.println(text);
        return text;
    }
    public boolean isLogoutButtonVisible(){
        return driver.findElement(logoutButton).isDisplayed();
    }
    public void clickLogoutButton(){
        clickOnElement(logoutButton);
    }
    public void clickOnDepositButton(){
        clickOnElement(depositButton);
    }
    public void sendAmountForDeposit(String amount1){
        sendTextToElement(amount,amount1);
    }
    public void clickOnDeposit(){
        clickOnElement(deposit);
    }
    public void clickWithdrawl(){
        clickOnElement(withdrawl);
    }
    public String getDepositSuccessText(){
        return getTextFromElement(depositSuccessText);
    }
    public void sendWithdrawalAmount(String amount){
        sendTextToElement(amountWithdraw,amount);
    }
    public void clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
    }
public String verifyWithdrawTransaction(){
        return getTextFromElement(transactionSuccessText);
}

}

