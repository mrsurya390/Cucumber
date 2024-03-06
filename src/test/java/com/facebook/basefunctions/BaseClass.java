package com.facebook.basefunctions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver driver;
		public static JavascriptExecutor js ;
		public static Actions action;
		public static Select select;
		public static WebDriverWait webdriverWait;
		
		public static void browserLaunch(String string) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			driver = new EdgeDriver(options);
			js = (JavascriptExecutor) driver;
			action = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(string);
		}
		
		public void pageRefresh() {
        	driver.navigate().refresh();
        }
        
        public void pageForward() {
        	driver.navigate().forward();
        }
        
        public void pageBackward() {
        	driver.navigate().back();
        }

        public String returnCurrentUrl() {
    		String url = driver.getCurrentUrl();
    		return url;
    	}
        
        public String returnPageTitle() {
			String title = driver.getTitle();
			return title;
		}
        
		public static void browserClose() {
			driver.close();
		}
		public static void browserQuit() {
			driver.quit();
		}
        
    	public boolean displayed(WebElement element ) {
    		boolean displayed = element.isDisplayed();
    		return displayed;
    	}
    	
    	public boolean selected(WebElement element ) {
    		boolean selected = element.isSelected();
    		return selected;
    	}
    	
    	public boolean enabled(WebElement element) {
    		boolean enabled = element.isEnabled();  
    		return enabled;
    	}
    	
		public void sendText(WebElement element, String value) {
			element.sendKeys(value);
		}
		
		public void button(WebElement element) {
			element.click();
		}
		
		public String returnText(WebElement element) {
			String text = element.getText();
			return text;
		}
		
		public String returnAttribute(WebElement element, String value) {
			String attribute = element.getAttribute(value);
			return attribute;
		}
		
		public String returnAttributeValue(WebElement element) {
			String attribute = element.getAttribute("value");
			return attribute;
		}
		
		public String returnCssValue(WebElement element, String value) {
			String attribute = element.getCssValue(value);
			return attribute;
		}
		
		public void goToElement(WebElement element) {
			action.moveToElement(element).build().perform();
		}
		
		public void moveOneElementToAnother(WebElement dragElement, WebElement dropElement) {
			action.dragAndDrop(dragElement, dropElement).build().perform();
		}
		
		public void rightClick(WebElement element) {
			action.contextClick(element).build().perform();
		}
		
		public void twoClick(WebElement element) {
			action.doubleClick(element).build().perform();
		}
		
		public void sendText(String value, String actions) {
			action.sendKeys(value).build().perform();
		}
		
		public void button(WebElement element, String actions) {
			element.click();
		}
		
		public Alert alert() {
			Alert alert = driver.switchTo().alert();
			return alert;
		}
		
		public void acceptAlert(Alert alert) {
			alert.accept();
		}
		
		public void dismissAlert(Alert alert) {
			alert.dismiss();
		}
		
		public String returnText(Alert alert) {
			String text = alert.getText();
			return text;
		}
		
		public void sendText(String value, Alert alert) {
			alert.sendKeys(value);
		}
		
		public void sendText(WebElement element, String value, String javaScript) {
			js.executeScript("arguments[0].setAttribute('value',"+value+")", element);
		}
		
		public Object returnAttribute(WebElement element) {
			Object object = js.executeScript("arguments[0].getAttribute('value')", element);
			return object;
		}
		
		public void button(String javaScript, WebElement element) {
			js.executeScript("arguments[0].click()", element);
		}
		
		public void scrollDown(WebElement element) {
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		
		public void scrollUp(WebElement element) {
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		
		public void screenshot(String value){
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File source = screenshot.getScreenshotAs(OutputType.FILE);
				File target = new File(".\\target\\"+value+".png");
				FileUtils.copyFile(source, target);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void previousFrame(){
			driver.switchTo().parentFrame();
		}
		
		public void defaultFrame(){
			driver.switchTo().defaultContent();
		}
		
		public void frameByIndex(int index){
			driver.switchTo().frame(index);
		}
		
		public void frameByWebelement(WebElement element){
			driver.switchTo().frame(element);
		}
		
		public void frameById(String id){
			driver.switchTo().frame(id);
		}
		
		public void frameByName(String name){
			driver.switchTo().frame(name);
		}
		
		public void handleWindowsByUrl(String url) {
			driver.switchTo().window(url);
		}
		
		public void handleWindowsByTitle(String title) {
			driver.switchTo().window(title);
		}
		
		public void handleWindowsById(String id) {
			driver.switchTo().window(id);
		}
		
		public void parentWindow() {
			driver.switchTo().defaultContent();
		}
		
		public String returnGetWindowId() {
			String windowId = driver.getWindowHandle();
			return windowId;
		}
		
		public Set<String> returnGetWindowIds(String id) {
			Set<String> windowIds = driver.getWindowHandles();
			return windowIds;
		}
		
		public void selectIndex(WebElement element, int value) {
			select = new Select(element);
			select.selectByIndex(value);
		}

		public void selectVisibleText(WebElement element, String value) {	
			select = new Select(element);
			select.selectByVisibleText(value);
		}
		
		public void selectValue(WebElement element, String value) {	
			select = new Select(element);
			select.selectByValue(value);
		}
		
		public void deselectIndex(WebElement element, int value) {	
			select = new Select(element);
			select.deselectByIndex(value);
		}
		
		public void deselectVisibleText(WebElement element, String value) {	
			select = new Select(element);
			select.deselectByVisibleText(value);
		}
		
		public void deselectValue(WebElement element, String value) {	
			select = new Select(element);
			select.deselectByValue(value);
		}
		
		public void deselectAllValues(WebElement element) {	
			select = new Select(element);
			select.deselectAll();
		}
		
		public boolean multiple(WebElement element) {	
			select = new Select(element);
			boolean multiple = select.isMultiple();
			return multiple;
		}
		
		public List<WebElement> selectAllOptions(WebElement element) {	
			select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}
		
		public List<WebElement> selectAllSelectedOptions(WebElement element) {	
			select = new Select(element);
			List<WebElement> options = select.getAllSelectedOptions();
			return options;
		}
		
		public WebElement selectFirstSelectedOption(WebElement element) {	
			select = new Select(element);
			WebElement option = select.getFirstSelectedOption();
			return option;
		}
		
		public void implicitWait(int value) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
		}
		
		public void webdriverWait(int value) {
			webdriverWait = new WebDriverWait(driver, Duration.ofSeconds(value));
		}
}