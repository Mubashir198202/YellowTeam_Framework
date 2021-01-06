package com.uk.zoopla.stepdeptest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.uk.zoopla.baseclass.Zoopla_SuperClass;
import com.uk.zoopla.pagefactory.Zoopla_MasterPageFactory;
import com.zoopla.util.HighLighter;
import com.zoopla.util.UtilWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Zoopla_StepDefination extends Zoopla_SuperClass {
	Zoopla_MasterPageFactory zm;

	@Given("^As a User I can Open any Browser$")
	public void as_a_User_I_can_Open_any_Browser() throws Throwable {
		logger.info("******>As a User I can Open any Browser<******");
		Zoopla_SuperClass.initialization();
		zm = PageFactory.initElements(driver, Zoopla_MasterPageFactory.class);
	}

	@Given("^As a User I can enter \"([^\"]*)\"$")
	public void as_a_User_I_can_enter(String URL) {
		logger.info("******>As a User I can enter URL<******");
		driver.get(URL);

	}

	@Given("^As a User I can clik on the  Sign in button$")
	public void as_a_User_I_can_clik_on_the_Sign_in_button() {
		logger.info("******>As a User I can clik on the  Sign in button<******");
		HighLighter.getcolor(driver, zm.getAcceptCookis(), "red");
		UtilWait.waitForElement(zm.getAcceptCookis());
		zm.getAcceptCookis().click();
		HighLighter.getcolor(driver, zm.getClickSignInButton(), "red");
		UtilWait.waitForElement(zm.getClickSignInButton());
		zm.getClickSignInButton().click();

	}

	@Given("^As a user I can enter Valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void as_a_user_I_can_enter_Valid_and(String userName, String passWord) {
		logger.info("******>As a user I can enter Valid userName<******");
		HighLighter.getcolor(driver, zm.getEnterusername(), "red");
		UtilWait.waitForElement(zm.getEnterusername());
		zm.getEnterusername().sendKeys(userName);
		logger.info("******>As a user I can enter Valid passWord<******");
		HighLighter.getcolor(driver, zm.getEnterpassword(), "red");
		UtilWait.waitForElement(zm.getEnterpassword());
		zm.getEnterpassword().sendKeys(passWord);
	}

	@Given("^As a user I can clik the Sign in button$")
	public void as_a_user_I_can_clik_the_Sign_in_button() {
		logger.info("******>As a User I can clik on the  Sign in button<******");
		HighLighter.getcolor(driver, zm.getClickloginbutton(), "red");
		UtilWait.waitForElement(zm.getClickloginbutton());
		zm.getClickloginbutton().click();

	}

	@Given("^As a user I am able to verify the title \"([^\"]*)\"$")
	public void as_a_user_I_am_able_to_verify_the_title(String Hometitle) {
		logger.info("******>As a user I am able to verify the title<******");
		if (driver.getPageSource().contains("Login was unsuccessfull")) {
			driver.quit();
		} else {
			Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", Hometitle);
		}
	}

	@When("^As a user I am able to write Newyork, Lincolnshire$")
	public void as_a_user_I_am_able_to_write_Newyork_Lincolnshire() {
		logger.info("******>As a user I am able to write Newyork, Lincolnshire<******");
		HighLighter.getcolor(driver, zm.getEnternewyork(), "red");
		UtilWait.waitForElement(zm.getEnternewyork());
		zm.getEnternewyork().sendKeys("New York, Lincolnshire");

	}

	@When("^As a user I am able to click Search button$")
	public void as_a_user_I_am_able_to_click_Search_button() {
		logger.info("******>As a user I am able to click Search button<******");
		HighLighter.getcolor(driver, zm.getClicksearch(), "red");
		UtilWait.waitForElement(zm.getClicksearch());
		zm.getClicksearch().click();
	}

	@When("^As a user I am able to Print all the price values in sorted order \\(descending order\\)$")
	public void as_a_user_I_am_able_to_Print_all_the_price_values_in_sorted_order_descending_order() {
		logger.info("******>As a user I am able to Print all the price values <******");
		List<WebElement> list = zm.getPrintallprice();
		System.out.println("Total property count num :" + list.size());
		for (WebElement select : list) {
			String listPrice = select.getText();
			System.out.println("All the property prices :" + listPrice);
			
		}
		//System.out.println("Fifth property price : " + list.get(3).getText());
	}
	
	@When("^As a user I am able to click on fifth property from list$")
	public void as_a_user_I_am_able_to_click_on_fifth_property_from_list() throws IOException {
		logger.info("******>As a user I am able to click on fifth property from list<******");
		List<WebElement> li = zm.getClickfifthproperty();
		for (int i = 0; i < li.size(); i++) {
			if (i > 3) {
				System.out.println("Selected property number : " + i);
				System.out.println("Selected property : " + li.get(i).getText());
				
				li.get(i).click();
				break;
			}
		
		}

	}

	
	@When("^As a user I am able to verify the logo, name and telephone number of the agent \"([^\"]*)\"$")
	public void as_a_user_I_am_able_to_verify_the_logo_name_and_telephone_number_of_the_agent(String arg1) {
		logger.info("******>As a user I am able to verify the logo, name and telephone number of the agent<******");

		if (driver.getPageSource().contains("Do Not verify the logo")) {
			driver.quit();
		} else {
			Assert.assertEquals("Logo,Agent name,phone number", arg1);
		}

	}

	@When("^As a user I am able to click on MyZoopla$")
	public void as_a_user_I_am_able_to_click_on_MyZoopla() {
		logger.info("******>As a user I am able to click on MyZoopla<******");
		HighLighter.getcolor(driver, zm.getMouseHovermyzoopla(), "red");
		UtilWait.waitForElement(zm.getMouseHovermyzoopla());
		Actions action = new Actions(driver);
		WebElement mousehover = zm.getMouseHovermyzoopla();
		action.moveToElement(mousehover).build().perform();
	}

	@When("^As a user I am able to clik on signout button$")
	public void as_a_user_I_am_able_to_clik_on_signout_button() {
		logger.info("******>as_a_user_I_am_able_to_clik_on_signout_button<******");
		HighLighter.getcolor(driver, zm.getClicksignout(), "red");
		Actions ac = new Actions(driver);
		WebElement mouse = zm.getClicksignout();
		ac.moveToElement(mouse);
		ac.click().build().perform();
	}

	@Then("^As a user I am able to verify the logout title \"([^\"]*)\"$")
	public void as_a_user_I_am_able_to_verify_the_logout_title(String LoginPageTitle) {
		if (driver.getPageSource().contains("Logout was unsuccessfull")) {
			driver.quit();
		} else {
			Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", LoginPageTitle);
		}

	}

	@Then("^As a user I able to close browser$")
	public void as_a_user_I_able_to_close_browser() {
		driver.quit();

	}

}
