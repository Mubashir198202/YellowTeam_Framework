package com.uk.zoopla.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uk.zoopla.baseclass.Zoopla_SuperClass;

public class Zoopla_MasterPageFactory extends Zoopla_SuperClass {

	public Zoopla_MasterPageFactory() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	@CacheLookup
	private WebElement acceptCookis;

	public WebElement getAcceptCookis() {
		return acceptCookis;
	}

	@FindBy(linkText = "Sign in")
	@CacheLookup
	private WebElement clickSignInButton;

	public WebElement getClickSignInButton() {
		return clickSignInButton;
	}

	@FindBy(id = "signin_email")
	@CacheLookup
	private WebElement enterusername;

	public WebElement getEnterusername() {
		enterusername.click();
		return enterusername;
	}

	@FindBy(id = "signin_password")
	@CacheLookup
	private WebElement enterpassword;

	public WebElement getEnterpassword() {
		enterpassword.click();
		return enterpassword;
	}

	@FindBy(id = "signin_submit")
	@CacheLookup
	private WebElement clickloginbutton;

	public WebElement getClickloginbutton() {
		return clickloginbutton;
	}

	@FindBy(id = "search-input-location")
	@CacheLookup
	private WebElement enternewyork;

	public WebElement getEnternewyork() {
		return enternewyork;
	}

	@FindBy(id = "search-submit")
	@CacheLookup
	private WebElement clicksearch;

	public WebElement getClicksearch() {
		return clicksearch;
	}
	@FindBy(xpath="//*[contains(@class,'css-1e28vvi-PriceContainer e2uk8e8')]")
	@CacheLookup
	private List <WebElement>printallprice;
	
	
	public List<WebElement> getPrintallprice() {
		return printallprice;
	}
	
	
	@FindBy(xpath = "//*[@class='e2uk8e4 css-16zqmgg-StyledLink-Link-FullCardLink e33dvwd0']")
	@CacheLookup
	private List<WebElement>clickfifthproperty;

	public List<WebElement> getClickfifthproperty() {
		return clickfifthproperty;
	}

    @FindBy(xpath ="(//*[@class='css-jm7194 el4rvi44'])[1]")
	private WebElement mouseHovermyzoopla;

	public WebElement getMouseHovermyzoopla() {
		return mouseHovermyzoopla;
	}
	
	@FindBy(xpath = "(//*[@content='Sign out'])[1]")
   private WebElement clicksignout;

	public WebElement getClicksignout() {
		return clicksignout;
	}
	
	
	
	
}
