package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
  @Test
  public void verifyUserLoginWithValidCredentials() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameonUsernameField("carol");
	  login.enterPasswordOnpasswordField("1q2w3e4r");
	  login.loginButtonClick();
	  
	 boolean ishomepageLoaded = login.ishomePageLoded();
	 Assert.assertTrue(ishomepageLoaded,"Login Failed for valid credentials");
  }
  @Test
  public void verifyUserLoginWithValidUsernameAndInvalidPassword() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameonUsernameField("carol");
	  login.enterPasswordOnpasswordField("1admin");
	  login.loginButtonClick();
	  
	  boolean isalertdisplayed = login.isalertdisplayed();
	  Assert.assertTrue(isalertdisplayed,"Alert not displayed");
  }
  @Test(dataProvider="dpmethod")
  public void verifyUserloginwithinvalidUsernameAndValidPassword(String userName,String passWord) {
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameonUsernameField(userName);
	  login.enterPasswordOnpasswordField(passWord);
	  login.loginButtonClick();
	  
	  boolean isalertdisplayed = login.isalertdisplayed();
	  Assert.assertTrue(isalertdisplayed,"Alert not displayed");
	  
  }
  @DataProvider
  public Object[][] dpmethod(){
	  return new  Object[][] {{"rohan","1q2w3e4r"},{"carl","12345"}};
  }
  @Test
  public void verifyUserLoginwithInvalid_Credentials() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameonUsernameField("carol23");
	  login.enterPasswordOnpasswordField("1admin");
	  login.loginButtonClick();
	  
	  boolean isalertdisplayed = login.isalertdisplayed();
	  Assert.assertTrue(isalertdisplayed,"Alert not displayed");
  }
}
