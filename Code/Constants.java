/**
* Created by Bo Man on 1/29/16.
* Latest Revised by Bo Man on 2/4/16.
*/

package com.LinkedIn.linkedin_webui_test;

public class Constants {
	
   public static final String username = "YOU SHOULD TYPE YOUR USERNAME HERE";
   public static final String password = "YOU SHOULD TYPE YOUR PASSWORD HERE";
   public static final String incorrectUsername = "boflexton@gmail.com";
   public static final String incorrectPassword = "********";
   
   public static final String illegalUsername = "pp"; //length < 3
   public static final String invalidUsername = "abcd"; //not contain @
   public static final String illegalPassword = "cdefg"; //length < 6
   public static final String legalPassword = "afel3g%";

   public static final String illegalUsernameInfo = "The text you provided is too short";
   public static final String illegalUsernameErrorMessage = "Illegal Username Error Message";

   public static final String invalidUsernameInfo = "Please enter a valid email address";
   public static final String invalidUsernameErrorMessage = "Invalid Username Error Message";

   public static final String incorrectUsernameInfo = "Hmm, we don't recognize that email. Please try again";
   public static final String incorrectUsernameErrorMessage = "Incorrect Username Error Message";

   public static final String illegalPasswordInfo = "The password you provided must have at least 6 characters";
   public static final String illegalPasswordErrorMessage = "Illegal Password Error Message";

   public static final String incorrectPasswordInfo = "Hmm, that's not the right password. Please try again";
   public static final String incorrectPasswordErrorMessage = "Incorrect Password Error Message";

   public static final String errorMessageInfo = "There were one or more errors in your submission.";
   public static final String errorMessageInfoErrorMessage = "Sign In Error Message";

}
