package com.fb;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.facebook.basefunctions.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KidsClothing {
	public static BaseClass base = new BaseClass();
	
	
	@Given("Launch the Ajio {string}")
	public void launch_the_ajio(String string) {
		BaseClass.browserLaunch(string);
	}

	@Given("Navigate to Kids and click the clothing")
	public void navigate_to_kids_and_click_the_clothing() {
		WebElement kids = BaseClass.driver.findElement(By.xpath("//span[text()='KIDS']"));
		base.goToElement(kids);
	    WebElement clothing = BaseClass.driver.findElement(By.xpath("//strong[text()='NEW IN: CLOTHING']"));
		base.button(clothing, null);
	}

	@When("user click sort dropdown and select option in a dropdown with one dim map")
	public void user_click_sort_dropdown_and_select_option_in_a_dropdown_with_one_dim_map(DataTable dataTable) {
		Map<String,String> map = dataTable.asMap(String.class, String.class);
		String high = map.get("sort3");
		WebElement dropdown = BaseClass.driver.findElement(By.xpath("//select[@id='sortBy']"));
		List<WebElement> options = base.selectAllOptions(dropdown);
		 for(WebElement option: options) {
			 String text = base.returnText(option);
			 if(text.contains(high)) {
				 base.selectVisibleText(dropdown, text);
			 }
		 }
	}

	@Then("validate result")
	public void validate_result() {
		System.out.println("complete");
		
		
	  
	}

}
