/**
* Created by Bo Man on 1/31/16.
*/

package com.LinkedIn.linkedin_webui_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class LinkedInStaticMethod {

   /* * * * * * * * * * * * * * * only show Sign In page * * * * * * * * * * * * * *  * * * */
   public static void linkedInSignIn(WebDriver driver, String response){
       // 1. Go to the LinkedIn website
       driver.get("https://www.linkedin.com");

       // 2. Verify Sign In Page is displayed
       // Validate the text "Be great at what you do" is in the HTML
       // for that we get first all the response
       response = driver.getPageSource();
       // Once it fails, return java.lang.AssertionError
       assertTrue("VALIDATION FAILED - Text \'Be great at what you do\' - NOT FOUND",
               response.contains("Be great at what you do"));
   }

   /* * * * * * * * * * * * * * * send username to textbox * * * * * * * * * * * * * *  * * * */
   public static void linkedInSendUsername(WebDriver driver, String username){
       // Find the login email text box
       WebElement login_email = driver.findElement(By.id("login-email"));
       // Clear the textbox before input
       login_email.clear();
       // Send the username to the text box
       login_email.sendKeys(username);
   }

   /* * * * * * * * * * * * * * * send password to textbox * * * * * * * * * * * * * *  * * * */
   public static void linkedInSendPassword(WebDriver driver, String password){
       // Find the login password text box
       WebElement login_password = driver.findElement(By.id("login-password"));
       // Clear the textbox before input
       login_password.clear();
       // Send the password to the text box
       login_password.sendKeys(password);
   }

   /* * * * * * * * * * * * * * * click on sign in button * * * * * * * * * * * * * *  * * * */
   public static void linkedInClickSignIn(WebDriver driver){
       // Find the sign in button and click
       WebElement signIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
       signIn.click();
   }

   /* * * * * * * * * * * * * * * Sign In completely * * * * * * * * * * * * * *  * * * */
   public static void linkedInSignIn(WebDriver driver, String response, String username, String password){
       // 1. Show Sign In page
       linkedInSignIn(driver, response);
       // 2. Send Username to textbox
       linkedInSendUsername(driver, username);
       // 3. Send Password to textbox
       linkedInSendPassword(driver, password);
       // 4. Click on Sign In button
       linkedInClickSignIn(driver);
   }

   /* * * * * * * * * * * * * * * Sign Out completely * * * * * * * * * * * * * *  * * * */
   public static void linkedInSignOut(WebDriver driver, String response, WebDriverWait wait){
       // 1. Get page source
       response = driver.getPageSource();
       assertTrue("Validation FAILED - Text \"Sign in to LinkedIn\" NOT FOUND",
               response.contains("Tip: You can also search by keyword, company, school..."));

       // 2. Wait until the element needed appears
       // Wait for 10 seconds to load the page
       wait = new WebDriverWait(driver,10);
       // Until the Account & Settings button is shown
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-toggle.nav-link")));

       // 3. Click On the Account & Settings button(image at the right top)
       // Find the element by css or xpath
       // Instead of link text to avoid the language issue
       WebElement account_toggle = driver.findElement(By.cssSelector(".account-toggle.nav-link"));
       // Click on the button
       account_toggle.click();

       // 4. Sign Out by click on the Exit button
       WebElement signOut = driver.findElement(By.cssSelector(".account-submenu-split-link"));
       // Click on the button
       signOut.click();

       // 5. Verify Sign Out Page is displayed
       // Give the browser time to response
       // Validate the text "You have signed out" is in the HTML
       wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
       response = driver.getPageSource();
       assertTrue("VALIDATION FAILED - Text \'You have signed out\' - NOT FOUND",
               response.contains("You have signed out"));
   }


}
