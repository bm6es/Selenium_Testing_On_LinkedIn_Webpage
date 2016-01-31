/**
* Created by Bo Man on 1/29/16.
* Latest Revised by Bo MAN on 1/31/16
* This test is used to verify that
*      LinkedIn can be signed in and out with correct username and password
*      with the link "https://www.linkedin.com".
* All of the process are executed correctly without error message.
* Two test cases are included here.
*      -- the first one is the most common sign in and out process
*      -- the second one is in reverse precedence when inputting the username and password
* Technique here:
*      WebDriver, WebDriverWait and WebElement.findElement By id, xpath and cssSelector, Encapsulation.
*/

package com.LinkedIn.linkedin_webui_test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInSignInPositiveTest {
   public WebDriver driver;
   public String response;
   public WebDriverWait wait;

   // WebDriver Initialization
   public LinkedInSignInPositiveTest(){
       driver = new FirefoxDriver();
       response = "";
       wait = new WebDriverWait(driver, 1);
   }

   @Test
   // Positive path 1 (the most common path)
   // path covered (1) (2) (3) (5) (7) (10) (15) (17) (18) (19) (21) (22)
   public void linkedInSingInPositiveTestOne (){
       // 1. Show Sign In page -- PATH (1) (2) (3)
       LinkedInStaticMethod.linkedInSignIn(driver, response);
       // 2. Send Username -- PATH (5)
       LinkedInStaticMethod.linkedInSendUsername(driver, Constants.username);
       // 3. Send Password -- PATH (7)
       LinkedInStaticMethod.linkedInSendPassword(driver, Constants.password);
       // 4. Click the sign in button -- PATH (10)
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 5. Sign Out -- PATH (15) (17) (18) (19) (21) (22)
       LinkedInStaticMethod.linkedInSignOut(driver, response, wait);

   }

   @Test
   // Positive path 2 (input password before username)
   // path covered (1) (2) (3) (6) (8) (9) (15) (17) (18) (19) (21) (22)
   public void linkedInSingInPositiveTestTwo (){
       // 1. Show Sign In page -- PATH (1) (2) (3)
       LinkedInStaticMethod.linkedInSignIn(driver, response);
       // 2. Send Password -- PATH (6)
       LinkedInStaticMethod.linkedInSendPassword(driver, Constants.password);
       // 3. Send Username -- PATH (8)
       LinkedInStaticMethod.linkedInSendUsername(driver, Constants.username);
       // 4. Click the sign in button -- PATH (9)
       LinkedInStaticMethod.linkedInClickSignIn(driver);
       // 5. Sign Out -- PATH (15) (17) (18) (19) (21) (22)
       LinkedInStaticMethod.linkedInSignOut(driver, response, wait);

   }

   // -- PATH (22)
   @After
   public void tearDown(){
       driver.close();
   }

}
