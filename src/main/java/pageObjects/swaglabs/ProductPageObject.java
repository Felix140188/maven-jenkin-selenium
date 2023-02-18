package pageObjects.swaglabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.swaglabs.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectOptionAtSortDropdown(String optionDropdown) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN, optionDropdown);
	}

	public boolean isProductNameDisplayedAscendingOrder() {
		ArrayList<String> productNameListUI = new ArrayList<String>();

		List<WebElement> itemNames = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement itemName : itemNames) {
			productNameListUI.add(itemName.getText());
		}

		ArrayList<String> productNameSortedList = new ArrayList<String>();
		for (String productName : productNameListUI) {
			productNameSortedList.add(productName);
		}
		Collections.sort(productNameSortedList);

		return productNameSortedList.equals(productNameListUI);
	}
	
	public boolean isDataSortAscendingOrder() {
		List<WebElement> itemNames = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
		List<String> nameList = itemNames.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(nameList);
		Collections.sort(sortedNames);
		return sortedNames.equals(nameList);
	}

	public boolean isProductNameDisplayedDescendingOrder() {
		ArrayList<String> productNameListUI = new ArrayList<String>();

		List<WebElement> itemNames = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement itemName : itemNames) {
			productNameListUI.add(itemName.getText());
		}

		ArrayList<String> productNameSortedList = new ArrayList<String>();
		for (String productName : productNameListUI) {
			productNameSortedList.add(productName);
		}
		Collections.sort(productNameSortedList);
		Collections.reverse(productNameSortedList);

		return productNameSortedList.equals(productNameListUI);
	}

	public boolean isProductPriceDisplayedAscendingOrder() {
		ArrayList<Float> productPriceListUI = new ArrayList<Float>();

		List<WebElement> itemPrices = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement itemPrice : itemPrices) {
			productPriceListUI.add(Float.parseFloat(itemPrice.getText().replace("$", "")));
			System.out.println("UI price sort: " + itemPrice.getText());
		}

		ArrayList<Float> productPriceSortedList = new ArrayList<Float>();
		for (Float productPrice : productPriceListUI) {
			productPriceSortedList.add(productPrice);
		}
		Collections.sort(productPriceSortedList);
		for (Float price : productPriceSortedList) {
			System.out.println("Acs sort list: " + price);
		}
		
		return productPriceSortedList.equals(productPriceListUI);
	}

	public boolean isProductPriceDisplayedDescendingOrder() {
		ArrayList<Float> productPriceListUI = new ArrayList<Float>();

		List<WebElement> itemPrices = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement itemPrice : itemPrices) {
			productPriceListUI.add(Float.parseFloat(itemPrice.getText().replace("$", "")));
			System.out.println("UI price sort: " + itemPrice.getText());
		}

		ArrayList<Float> productPriceSortedList = new ArrayList<Float>();
		for (Float productPrice : productPriceListUI) {
			productPriceSortedList.add(productPrice);
		}
		Collections.sort(productPriceSortedList);
		Collections.reverse(productPriceSortedList);

		for (Float price : productPriceSortedList) {
			System.out.println("Des sort list: " + price);
		}
		return productPriceSortedList.equals(productPriceListUI);
	}
	
	
}
