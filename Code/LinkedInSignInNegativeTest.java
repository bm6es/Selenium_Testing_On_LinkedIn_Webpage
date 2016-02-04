/**
* Created by Bo Man on 2/3/16.
* Latest Revised by Bo Man on 2/4/16.
* This test is used to verify that
*      LinkedIn can not be signed in correctly once the user gives error inputs and
*      error message will be correspondingly shown to user reminding him/her to try again.
* There are ten negative testings, including:
* // Unsuccessfully SignIn without error message
*      (1) only password
*      (2) only username
* // Unsuccessfully SignIn with error message
*      (3) illegal username and illegal password
*      (4) invalid username and illegal password
*      (5) illegal username but legal password
*      (6) invalid username but legal password
*      (7) incorrect username and illegal password
*      (8) correct username but illegal password
*      (9) incorrect username but legal password
*      (10) correct username but incorrect password
* Technique here:
*      WebDriver, WebDriverWait and WebElement.findElement By id, xpath and cssSelector, Encapsulation
*/

package com.LinkedIn.linkedin_webui_test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class LinkedInSignInNegativeTest {

   public WebDriver driver;
   public String response;
   public WebDriverWait wait;

   // WebDriver Initialization
   public LinkedInSignInNegativeTest(){
       driver = new FirefoxDriver();
       response = "";
       wait = new WebDriverWait(driver, 1);
   }

   /******************************* NEGATIVE TESTING ONE ******************************/
   // Unsuccessfully SignIn without error message in the process (sign in button can not be clicked)
   // Negative path (only password, without username at first, then with username and password re-inputting)
   // path covered (1) (2) (3) (6) (12) (10) (13) (11) (9) (15) (17) (18) (19) (21) (22)
   @Test
   public void linkedInSingInNegativeTestOne (){
       // 1. Show Sign In page -- PATH (1) (2) (3)
       LinkedInStaticMethod.linkedInSignIn(driver, response);
       // 2. Send Password -- PATH (6)
       LinkedInStaticMethod.linkedInSendPassword(driver, Constants.incorrectPassword);
       // 3. Clear and re-input the password -- PATH (12)
       LinkedInStaticMethod.linkedInSendPassword(driver, Constants.password);
       // 4. Click on Sign In button -- PATH (10)
       // But it doesn't work here since no username is input
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 5. Send Username -- PATH (13)
       LinkedInStaticMethod.linkedInSendUsername(driver, Constants.incorrectUsername);
       // 6. Clear and re-input the username -- PATH (11)
       LinkedInStaticMethod.linkedInSendUsername(driver, Constants.username);
       // 7. Click the sign in button again -- PATH (9)
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 8. Sign Out -- PATH (15) (17) (18) (19) (21) (22)
       LinkedInStaticMethod.linkedInSignOut(driver, response, wait);

   }

   /******************************* NEGATIVE TESTING TWO ******************************/
   // Unsuccessfully SignIn without error message in the process (sign in button can not be clicked)
   // Negative path (only username, without password at first)
   // path covered (1) (2) (3) (5) (9) (14) (10) (15) (17) (18) (19) (21) (22)
   @Test
   public void linkedInSingInNegativeTestTwo (){
       // 1. Show Sign In page -- PATH (1) (2) (3)
       LinkedInStaticMethod.linkedInSignIn(driver, response);
       // 2. Send Username -- PATH (5)
       LinkedInStaticMethod.linkedInSendUsername(driver, Constants.username);
       // 3. Click on Sign In button -- PATH (9)
       // But it doesn't work here since no username is input
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 4. Send Password -- PATH (14)
       LinkedInStaticMethod.linkedInSendPassword(driver, Constants.password);
       // 5. Click the sign in button again -- PATH (10)
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 6. Sign Out -- PATH (15) (17) (18) (19) (21) (22)
       LinkedInStaticMethod.linkedInSignOut(driver,response,wait);

   }

   /******************************* NEGATIVE TESTING THREE ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (illegal username and illegal password)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination B + Q
   @Test
   public void linkedInSingInNegativeTestThree (){
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.illegalUsername, Constants.illegalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, illegal username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalUsernameErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalUsernameInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalPasswordErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalPasswordInfo));
   }

   /******************************* NEGATIVE TESTING FOUR ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (invalid username and illegal password)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination D + Q
   @Test
   public void linkedInSingInNegativeTestFour (){
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.invalidUsername, Constants.illegalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.invalidUsernameErrorMessage + "\" NOT FOUND",
               response.contains(Constants.invalidUsernameInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalPasswordErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalPasswordInfo));
   }

   /******************************* NEGATIVE TESTING FIVE ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (illegal username but legal password)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination B + R
   @Test
   public void linkedInSingInNegativeTestFive (){
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.illegalUsername, Constants.legalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalUsernameErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalUsernameInfo));
   }

   /******************************* NEGATIVE TESTING SIX ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (invalid username but legal password)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination D + R
   @Test
   public void linkedInSingInNegativeTestSix (){
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.invalidUsername, Constants.legalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.invalidUsernameErrorMessage + "\" NOT FOUND",
               response.contains(Constants.invalidUsernameInfo));
   }

   /******************************* NEGATIVE TESTING SEVEN ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (incorrect username and illegal password)
   // ONLY RETURN ILLEGAL PASSWORD ERROR MESSAGE (SINCE PRIORITY: ILLEGAL > INCORRECT)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination F + Q
   @Test
   public void linkedInSingInNegativeTestSeven () {
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.incorrectUsername, Constants.illegalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalPasswordErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalPasswordInfo));
   }

   /******************************* NEGATIVE TESTING EIGHT ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (correct username but illegal password)
   // ONLY RETURN ILLEGAL PASSWORD ERROR MESSAGE (SINCE PRIORITY: ILLEGAL > CORRECT)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination G + Q
   @Test
   public void linkedInSingInNegativeTestEight () {
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.username, Constants.illegalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.illegalPasswordErrorMessage + "\" NOT FOUND",
               response.contains(Constants.illegalPasswordInfo));
   }

   /******************************* NEGATIVE TESTING NINE ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (incorrect username but legal password)
   // ONLY RETURN INCORRECT USERNAME ERROR MESSAGE
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination F + R
   @Test
   public void linkedInSingInNegativeTestNine () {
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.incorrectUsername, Constants.legalPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.incorrectUsernameErrorMessage + "\" NOT FOUND",
               response.contains(Constants.incorrectUsernameInfo));
   }

   /******************************* NEGATIVE TESTING TEN ******************************/
   // Unsuccessfully SignIn with error message
   // Negative path (correct username but incorrect password)
   // path covered (1) (2) (3) (5) (7) (10) (15) (23) (24) (25)
   // Conditional Combination G + S
   @Test
   public void linkedInSingInNegativeTestTen () {
       // 1. path covered (1) (2)(3) (5) (7) (10) (15)
       LinkedInStaticMethod.linkedInSignIn(driver, response, Constants.username, Constants.incorrectPassword);
       // 2. Get Sign In Failure Page -- PATH (23)
       String response = driver.getPageSource();
       // 3. Validate error info -- PATH (24)
       // including error message, invalid username and illegal password
       assertTrue("Validation FAILED - Text \"" + Constants.errorMessageInfoErrorMessage + "\" NOT FOUND",
               response.contains(Constants.errorMessageInfo));
       assertTrue("Validation FAILED - Text \"" + Constants.incorrectPasswordErrorMessage + "\" NOT FOUND",
               response.contains(Constants.incorrectPasswordInfo));
   }

   // -- PATH (22) & (25)
   @After
   public void tearDown(){
       driver.close();
   }
}
