package com.bank.testsuite;

import com.bank.pages.AccountPage;
import com.bank.testbase.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    AccountPage accountPage = new AccountPage();
    @Test
    //1.bankManagerShouldAddCustomerSuccessfully.
    public void  bankManagerShouldAddCustomerSuccessfully()throws InterruptedException {

        // click On "Bank Manager Login" Tab
        accountPage.clickOnBankManagerLoginButton();
        // click On "Add Customer" Tab
        accountPage.clickOnAddCustomerTab();
        //enter FirstName
        accountPage.sendFirstName("Heena");
        //enter LastName
        accountPage.sendLastName("patel");
        //enter PostCode
        accountPage.sendPostCode("ha7 3hu");
        //click On "Add Customer" Button
        accountPage.clickOnAddCustomerButton();
        //popup display
        //verify message "Customer added successfully"
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println(actualMessage);
        String expectedMessage ="Customer added successfully with customer id :6";
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);
        Thread.sleep(2000);
        //click on "ok" button on popup.
        alert.accept();
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    //2. bankManagerShouldOpenAccountSuccessfully.
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException{
        //	click On "Bank Manager Login" Tab
        accountPage.clickOnBankManagerLoginButton();
        //	click On "Open Account" Tab
        accountPage.clickOnOpenAccountTab();
        //	Search customer that created in first test
        Thread.sleep(2000);
        accountPage.searchForCustomerNameOpenAccount("Harry Potter");
        Thread.sleep(2000);
        accountPage.selectCurrencyOpenAccount("Pound");
       // accountPage.selectCurrency("Pound");
        //	click on "process" button
        accountPage.clickProcessButtonOpenAccount();
        //	popup displayed//	verify message "Account created successfully"
        Thread.sleep(2000);
         Alert alert =driver.switchTo().alert();
        String actualMessage= alert.getText();
        String expectedMessage ="Account created successfully with account Number :1016";
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);
        Thread.sleep(2000);
        //	click on "ok" button on popup.
        alert.accept();
    }
    @Test
    //3. customerShouldLoginAndLogoutSuceessfully.
    public void customerShouldLoginAndLogoutSuceessfully()throws InterruptedException {

        //	click on "Customer Login" Tab
        accountPage.clickOnCustomerTab();
        //	search customer that you created.
        accountPage.searchForCustomer("Harry Potter");
        //	click on "Login" Button
        accountPage.clickOnLoginButton();
        Thread.sleep(2000);
        //	verify "Your Name" text displayed.
        String actualMessage = accountPage.getLoginVerifyText();
        System.out.println(actualMessage);
        //	verify "Logout" Tab displayed.
        accountPage.isLogoutButtonVisible();
        //	click on "Logout"
        accountPage.clickLogoutButton();

    }
    @Test
    //4. customerShouldDepositMoneySuccessfully.
    public void customerShouldDepositMoneySuccessfully(){
    //	click on "Customer Login" Tab
        accountPage.clickOnCustomerTab();
    //	search customer that you created.
        accountPage.searchForCustomer("Harry Potter");
    //	click on "Login" Button
        accountPage.clickOnLoginButton();
    //	click on "Deposit" Tab
        accountPage.clickOnDepositButton();
    //	Enter amount 100
        accountPage.sendAmountForDeposit("20000");
    //	click on "Deposit" Button
        accountPage.clickOnDeposit();
    //	verify message "Deposit Successful"
        String actualMessage = accountPage.getDepositSuccessText();
        String expectedMessage ="Deposit Successful";
        Assert.assertEquals(actualMessage,expectedMessage,"Not Successful");
    }
    @Test
    //5. customerShouldWithdrawMoneySuccessfully
    public void customerShouldWithdrawMoneySuccessfully()throws InterruptedException {
        //	click on "Customer Login" Tab
        accountPage.clickOnCustomerTab();
        //	search customer that you created.
        accountPage.searchForCustomer("Harry Potter");
        //	click on "Login" Button
        accountPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.sendAmountForDeposit("20000");
        accountPage.clickOnDeposit();
        Thread.sleep(2000);
        //	click on "Withdrawl" Tab
        accountPage.clickWithdrawl();
        //	Enter amount 50
        Thread.sleep(2000);
        accountPage.sendWithdrawalAmount("100");
        //	click on "Deposit" Button
        accountPage.clickOnWithdrawButton();
        //	verify message "Transaction Successful"
        String actualMessage = accountPage.verifyWithdrawTransaction();
        String expectedMessage ="Transaction successful";
        Assert.assertEquals(actualMessage,expectedMessage,"Transaction Not successful");
    }
}
