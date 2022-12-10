package pageObject.saurcelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saurcelab.ProductPageUI;

public class ProductPageObject extends BasePage{
	WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
		
	}

	public boolean isProductNameSortByAscending() {
		// khai báo ra 1 arraylist để chứa các product name trên UI (DEV SORT)
		ArrayList<String> productUIList = new ArrayList<String>();
		
		//lấy ra hết tất cả các test product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		// dùng vòng lặp để getText và add vào Arraylist trên
		for(WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("product name o tren UI: " + productName.getText());
		}
		
		// tạo ra một arraylist mới để sort dữ liệu trong arraylist cũ xem có đúng không
		ArrayList<String> productSortList = new ArrayList<String>();
		for(String product : productUIList) {
			productSortList.add(product);
		}
		
		//sort productsortlist
		Collections.sort(productSortList);
		
		for(String productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}
		
		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}
	
	/*
	 * public boolean isProductNameSortByAscendingLambda() { List<WebElement>
	 * elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
	 * List<String> names = elementLists.stream().map(n ->
	 * n.getText()).collect(Collectors.toList()); List<String> sortedNames = new
	 * ArrayList<String>(names); Collectors.sort(sortedNames); return
	 * names.equals(sortedNames); }
	 */

	public boolean isProductNameSortByDescending() {
		// khai báo ra 1 arraylist để chứa các product name trên UI (DEV SORT)
		ArrayList<String> productUIList = new ArrayList<String>();
		
		//lấy ra hết tất cả các test product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		// dùng vòng lặp để getText và add vào Arraylist trên
		for(WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("product name o tren UI: " + productName.getText());
		}
		
		// tạo ra một arraylist mới để sort dữ liệu trong arraylist cũ xem có đúng không
		ArrayList<String> productSortList = new ArrayList<String>();
		for(String product : productUIList) {
			productSortList.add(product);
		}
		
		//sort productsortlist
		Collections.sort(productSortList);
		
		for(String productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}
		
		// reverse cái productsortlist
		Collections.reverse(productSortList);
		
		for(String productName : productSortList) {
			System.out.println("Product Name sau khi reverse: " + productName);
		}
		
		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// khai báo ra 1 arraylist để chứa các product name trên UI (DEV SORT)
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//lấy ra hết tất cả các test product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		
		// dùng vòng lặp để getText và add vào Arraylist trên
		for(WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$","" )));
			System.out.println("product price o tren UI: " + productPrice.getText());
		}
		
		// tạo ra một arraylist mới để sort dữ liệu trong arraylist cũ xem có đúng không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for(Float product : productUIList) {
			productSortList.add(product);
		}
		
		//sort productsortlist
		Collections.sort(productSortList);
		
		for(Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort: " + productPrice);
		}
		
		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		// khai báo ra 1 arraylist để chứa các product name trên UI (DEV SORT)
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//lấy ra hết tất cả các test product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		
		// dùng vòng lặp để getText và add vào Arraylist trên
		for(WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$","" )));
			System.out.println("product price o tren UI: " + productPrice.getText());
		}
		
		// tạo ra một arraylist mới để sort dữ liệu trong arraylist cũ xem có đúng không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for(Float product : productUIList) {
			productSortList.add(product);
		}
		
		//sort productsortlist
		Collections.sort(productSortList);
		
		for(Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort: " + productPrice);
		}
		
		// reverse cái productsortlist
		Collections.reverse(productSortList);
		
		for(Float productName : productSortList) {
			System.out.println("Product Name sau khi reverse: " + productName);
		}
		
		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	
}
