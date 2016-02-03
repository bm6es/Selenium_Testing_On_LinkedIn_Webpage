/**
* Created by Bo Man on 2/3/16.
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

   // -- PATH (22)
   @After
   public void tearDown(){
       driver.close();
   }
}
