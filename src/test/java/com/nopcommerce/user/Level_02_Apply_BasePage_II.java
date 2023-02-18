//package com.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Apply_BasePage_II {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String emailAddress = "test" + generationNumber() + "@mail.com";
//	BasePage basePage;
//	
//  @BeforeClass
//  public void beforeClass() {
//	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//	  driver = new FirefoxDriver();
//	  basePage = BasePage.getBasePageObject();
//	  
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
//  }
//  
//  @Test
//  public void TC_01_Register_Empty_Data() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//	  
//  }
//  
//  @Test
//  public void TC_02_Register_Invalid_Email() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//	  basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
//	  basePage.sendkeyToElement(driver, "//input[@id='Email']", "abc@123%^&#");
//	  basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//	  basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//	  
//  }
//
//  @Test
//  public void TC_03_Register_Success() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//	  basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
//	  basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//	  basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//	  basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//	  basePage.clickToElement(driver, "//a[@class='ico-logout']");
//	  
//  }
//  
//  @Test
//  public void TC_04_Register_Existed_Email() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//	  basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
//	  basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//	  basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//	  basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
//
//  }
//
//  @Test
//  public void TC_05_Register_Password_LessThan_6_Digits() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//	  basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
//	  basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//	  basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
//	  basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	 
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//
//  }
//  
//  @Test
//  public void TC_06_Register_Confirm_Password_Unmatch() {
//	  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  
//	  basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//	  basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
//	  basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//	  basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//	  basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "456789");
//	  
//	  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  basePage.clickToElement(driver, "//button[@id='register-button']");
//	  
//	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }
//  
//  public int generationNumber() {
//	  Random rand = new Random();
//	  return rand.nextInt(9999);
//  }
//
//}