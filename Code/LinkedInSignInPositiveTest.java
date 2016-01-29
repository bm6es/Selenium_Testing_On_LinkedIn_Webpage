/**
* Created by Bo Man on 1/29/16.
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

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
       // 1. Go to the LinkedIn website
	   driver = new FirefoxDriver();
       driver.get("https://www.linkedin.com");
       // 2. Verify Sign In Page is displayed
       // Validate the text "Be great at what you do" is in the HTML
       // for that we get first all the response
       response = driver.getPageSource();
       // Once it fails, return java.lang.AssertionError
       assertTrue("VALIDATION FAILED - Text \'Be great at what you do\' - NOT FOUND",
               response.contains("Be great at what you do"));
       // 3. Find the login email text box
       WebElement login_email = driver.findElement(By.id("login-email"));
       // Clear the textbox before input
       login_email.clear();
       // Send the username to the text box
       login_email.sendKeys("YOU SHOULD TYPE YOUR USERNAME HERE");
       // 4. Find the login password text box
       WebElement login_password = driver.findElement(By.id("login-password"));
       // Clear the textbox before input
       login_password.clear();
       // Send the password to the text box
       login_password.sendKeys("YOU SHOULD TYPE YOUR PASSWORD HERE");
       // 5. Find the sign in button and click
       WebElement signIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
       signIn.click();
       // 6. Get page source
       response = driver.getPageSource();
       assertTrue("Validation FAILED - Text \"Sign in to LinkedIn\" NOT FOUND",
               response.contains("Tip: You can also search by keyword, company, school..."));
       // 7. Wait until the element needed appears
       // Wait for 10 seconds to load the page
       wait = new WebDriverWait(driver,10);
       // Until the Account & Settings button is shown
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-toggle.nav-link")));
       // 8. Click On the Account & Settings button(image at the right top)
       // Find the element by css or xpath
       // Instead of link text to avoid the language issue
       WebElement account_toggle = driver.findElement(By.cssSelector(".account-toggle.nav-link"));
       // Click on the button
       account_toggle.click();
       // 9. Sign Out by click on the Exit button
       WebElement signOut = driver.findElement(By.cssSelector(".account-submenu-split-link"));
       // Click on the button
       signOut.click();
       // 10. Verify Sign Out Page is displayed
       // Give the browser time to response
       // Validate the text "You have signed out" is in the HTML
       wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
       response = driver.getPageSource();
       assertTrue("VALIDATION FAILED - Text \'You have signed out\' - NOT FOUND",
               response.contains("You have signed out"));

   }
   
   @Test
   // Positive path 2 (input password before username)
   // path covered (1) (2) (3) (6) (8) (9) (15) (17) (18) (19) (21) (22)
   public void linkedInSingInPositiveTestTwo (){
       // 1. Go to the LinkedIn website
	   driver = new FirefoxDriver();
       driver.get("https://www.linkedin.com");
       // 2. Verify Sign In Page is displayed
       // Validate the text "Be great at what you do" is in the HTML
       // for that we get first all the response
       response = driver.getPageSource();
       // Once it fails, return java.lang.AssertionError
       assertTrue("VALIDATION FAILED - Text \'Be great at what you do\' - NOT FOUND",
               response.contains("Be great at what you do"));
       // 3. Find the login password text box
       WebElement login_password = driver.findElement(By.id("login-password"));
       // Clear the textbox before input
       login_password.clear();
       // Send the password to the text box
       login_password.sendKeys("YOU SHOULD TYPE YOUR PASSWORD HERE");
       // 4. Find the login email text box
       WebElement login_email = driver.findElement(By.id("login-email"));
       // Clear the textbox before input
       login_email.clear();
       // Send the username to the text box
       login_email.sendKeys("YOU SHOULD TYPE YOUR USERNAME HERE");
       // 5. Find the sign in button and click
       WebElement signIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
       signIn.click();
       // 6. Get page source
       response = driver.getPageSource();
       assertTrue("Validation FAILED - Text \"Sign in to LinkedIn\" NOT FOUND",
               response.contains("Tip: You can also search by keyword, company, school..."));
       // 7. Wait until the element needed appears
       // Wait for 10 seconds to load the page
       wait = new WebDriverWait(driver,10);
       // Until the Account & Settings button is shown
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-toggle.nav-link")));
       // 8. Click On the Account & Settings button(image at the right top)
       // Find the element by css or xpath
       // Instead of link text to avoid the language issue
       WebElement account_toggle = driver.findElement(By.cssSelector(".account-toggle.nav-link"));
       // Click on the button
       account_toggle.click();
       // 9. Sign Out by click on the Exit button
       WebElement signOut = driver.findElement(By.cssSelector(".account-submenu-split-link"));
       // Click on the button
       signOut.click();
       // 10. Verify Sign Out Page is displayed
       // Give the browser time to response
       // Validate the text "You have signed out" is in the HTML
       wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
       response = driver.getPageSource();
       assertTrue("VALIDATION FAILED - Text \'You have signed out\' - NOT FOUND",
               response.contains("You have signed out"));

   }
   
   @After
   public void tearDown(){
       driver.close();
   }
}
