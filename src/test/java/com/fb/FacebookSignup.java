package com.fb;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.facebook.basefunctions.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignup {
     	public static BaseClass base = new BaseClass();
		
		@Given("Launch the facebook {string}")
		public void launch_the_facebook(String string) {
			BaseClass.browserLaunch(string);
			
		}
		   
		

		@Given("Navigate to facebook")
		public void navigate_to_facebook() {
			WebElement element = BaseClass.driver.findElement(By.xpath("//div/a[@rel='async']"));
			base.button(element);
		}
		   

		@When("enter the name {string}")
		public void enter_the_name(String name) {
			WebElement firstname= BaseClass.driver.findElement(By.xpath("//div/input[@name='firstname']"));
			base.sendText(firstname, name);
		}

		@When("enter the surname {string}")
		public void enter_the_surname(String surname) {
			WebElement lastname = BaseClass.driver.findElement(By.xpath("//div/input[@name='lastname']"));
			base.sendText(lastname, surname);
		    
		}

		@When("enter the gamil {string}")
		public void enter_the_gamil(String gmail) {
			WebElement mail= BaseClass.driver.findElement(By.xpath("//div/input[starts-with(@aria-label,'Mobile')]"));
			base.sendText(mail, gmail);
		}

		@When("enter the reenter {string}")
		public void enter_the_reenter(String reenter) {
			  WebElement gmailreenter = BaseClass.driver.findElement(By.xpath("//div/input[starts-with(@aria-label,'Re')]"));
			  base.sendText(gmailreenter, reenter);
			  
			 
		}

		@When("enter the password {string}")
		public void enter_the_password(String word) {
			 WebElement password = BaseClass.driver.findElement(By.xpath("//div/input[@aria-label='New password']"));
			 base.sendText(password, word);
			  
	
		}

		@When("enter the date {string}")
		public void enter_the_date(String day) {
			WebElement dropdown1 = BaseClass.driver.findElement(By.xpath("//select[@id='day']"));
			List<WebElement> options = base.selectAllOptions(dropdown1);
			  for(WebElement option : options) {
				  String text = base.returnText(option);
				  if(text.contains(day.substring(1))) {
					  base.selectVisibleText(dropdown1, text);
				  }
			  }
		}

		@When("enter the month {string}")
		public void enter_the_month(String month) {
			WebElement mon = BaseClass.driver.findElement(By.xpath("//select[@id='month']"));
			base.sendText(mon, month);
		}

		@When("enter the year {string}")
		public void enter_the_year(String year) {
			WebElement dropdown2 = BaseClass.driver.findElement(By.xpath("//select[@id='year']"));
			List<WebElement> options = base.selectAllOptions(dropdown2);
			  for(WebElement option : options) {
				  String text = base.returnText(option);
				  if(text.contains(year.substring(1))) {
					 base.selectVisibleText(dropdown2, text);
				  }
			  }
		}

		@When("select the gender {string}")
		public void select_the_gender(String gender) {
			WebElement gen = BaseClass.driver.findElement(By.xpath("//label[text()='"+gender+"']"));
			base.button(gen);
		}

		@Then("create new account")
		public void create_new_account() throws Exception  {
			WebElement submit = BaseClass.driver.findElement(By.xpath("//button[@name='websubmit']"));
			base.button(submit);
			Thread.sleep(15000);
			
		}
		@Then("take the screenshot {string}")
		public void take_the_screenshot(String name) throws Exception  {
			base.screenshot(name);
			Thread.sleep(4000);			
			BaseClass.browserQuit();;
		}
		
}
