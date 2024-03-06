package com.facebook;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Cucumber {
	public static WebDriver driver;
	public static List<WebElement> options;
	public static Select select;
	public static TakesScreenshot Screenshot;
	public static File sourcefile;
	public static File targetfile;
	
	//public static Actions action;

	@Given("Launch the facebook {string}")
	public void launch_the_facebook(String string) {
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.addArguments("start-maximized");
	driver = new EdgeDriver(options);
	//action = new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	driver.get(string);
	
	}
	@Given("Navigate to facebook")
	public void navigate_to_facebook() {
		driver.findElement(By.xpath("//div/a[@rel='async']")).click();
	}

	@When("enter the first name {string}")
	public void enter_the_first_name(String first) {
		driver.findElement(By.xpath("//div/input[@name='firstname']")).sendKeys(first);
	}

	@When("enter the surname {string}")
	public void enter_the_surname(String surname) {
		driver.findElement(By.xpath("//div/input[@name='lastname']")).sendKeys(surname);
	}

	@When("enter the mail {string}")
	public void enter_the_mail(String mail) {
		driver.findElement(By.xpath("//div/input[starts-with(@aria-label,'Mobile')]")).sendKeys(mail);
	}

	@When("enter the reenter {string}")
	public void enter_the_reenter(String reenter) {
		 driver.findElement(By.xpath("//div/input[starts-with(@aria-label,'Re')]")).sendKeys(reenter);
	}

	@When("enter the newpassword {string}")
	public void enter_the_newpassword(String password) {
		driver.findElement(By.xpath("//div/input[@aria-label='New password']")).sendKeys(password);
	}
	
	@When("enter the date {string}")
	public void enter_the_date(String string) {
		WebElement dateDropdown = driver.findElement(By.xpath("//select[@id='day']"));
		select = new Select(dateDropdown);
		options = select.getOptions();
		  for(WebElement option : options) {
			  String date = option.getText();
			  if(date.contains(date.substring(1))) {
				  select.selectByVisibleText(date);
			  }
		  }
	}

	@When("enter the month {string}")
	public void enter_the_month(String string) {
		WebElement monthdropdown = driver.findElement(By.xpath("//select[@id='month']"));
		monthdropdown.sendKeys(string);
		select = new Select(monthdropdown);
		  options = select.getOptions();
		  for(WebElement option : options) {
			  String month = option.getText();
			  if(month.contains(string.substring(1))) {
				  select.selectByVisibleText(month);
			  }
		  }
	}

	@When("enter the year {string}")
	public void enter_the_year(String string) {
		  WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='year']"));
		  select = new Select(yearDropdown);
		  options = select.getOptions();
		  for(WebElement option : options) {
			  String year = option.getText();
			  if(year.contains(string.substring(1))) {
				  select.selectByVisibleText(year);
			  }
		  }
	}
	
		@Then("create new account")
		public void create_new_account() throws Exception {	
		 driver.findElement(By.xpath("//button[@name='websubmit']")).click();
			Thread.sleep(15000);
		
	}
	@Then("Take a Screenshot {string}")
	public void take_a_screenshot(String first) throws Exception {
		targetfile = new File("C:\\Users\\SureshAdmin\\eclipse-workspace\\cucu\\target\\"+first+".png");
		Screenshot = (TakesScreenshot) driver;
		sourcefile = Screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile,targetfile);
		
		driver.quit();
	   
	}

}
