package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DadaTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("7");
		Assert.assertTrue(homePage.isPageActive("7"));
		
		homePage.openPagingByPageNumber("13");
		Assert.assertTrue(homePage.isPageActive("13"));
		
		homePage.openPagingByPageNumber("19");
		Assert.assertTrue(homePage.isPageActive("19"));
		
		homePage.openPagingByPageNumber("24");
		Assert.assertTrue(homePage.isPageActive("24"));
	}

	//@Test
	public void Table_02_Input_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextbox("Females", "5079");
		homePage.inputToHeaderTextbox("Country", "Estonia");
		homePage.inputToHeaderTextbox("Males", "5306");
		homePage.inputToHeaderTextbox("Total", "10385");
		
		homePage.inputToHeaderTextbox("Females", "276880");
		homePage.inputToHeaderTextbox("Country", "Angola");
		homePage.inputToHeaderTextbox("Males", "276472");
		homePage.inputToHeaderTextbox("Total", "553353");
		
	}
	
	//@Test
	public void Table_03_Input_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.getValueEachRowOfAllPage();
	}
	
	@Test
	public void Table_04_Action_To_Table_Row() {
		homePage.clickToLoadButton();
		
		homePage.inputToTextboxByColumnNameAtTargetRow("Company", "1", "ABC");
		homePage.inputToTextboxByColumnNameAtTargetRow("Contact Person", "2", "Felix");
		homePage.inputToTextboxByColumnNameAtTargetRow("Order Placed", "3", "3");
		homePage.inputToTextboxByColumnNameAtTargetRow("Member Since", "3", "2022-12-24");
		
		homePage.selectDropdownByColumnNameAtTargetRow("Country", "1", "Germany");
		homePage.selectDropdownByColumnNameAtTargetRow("Country", "2", "Malaysia");
		homePage.selectDropdownByColumnNameAtTargetRow("Country", "3", "United States");
		
		homePage.checkToCheckboxByColumnNameAtTargetRow("NPO?", "2");
		homePage.checkToCheckboxByColumnNameAtTargetRow("NPO?", "3");
		homePage.checkToCheckboxByColumnNameAtTargetRow("NPO?", "6");
		homePage.checkToCheckboxByColumnNameAtTargetRow("NPO?", "7");
		homePage.checkToCheckboxByColumnNameAtTargetRow("NPO?", "8");
		
		homePage.uncheckToCheckboxByColumnNameAtTargetRow("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtTargetRow("NPO?", "4");
		homePage.uncheckToCheckboxByColumnNameAtTargetRow("NPO?", "5");
		
		homePage.clickToIconAtTargetRow("5", "Insert Row Above");
		homePage.clickToIconAtTargetRow("7", "Remove Current Row");
		homePage.clickToIconAtTargetRow("4", "Move Up");
		homePage.clickToIconAtTargetRow("3", "Move Down");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
