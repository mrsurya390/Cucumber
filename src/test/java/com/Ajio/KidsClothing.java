package com.Ajio;

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

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KidsClothing {
	public static WebDriver driver;
	public static Actions action;
	public static List<WebElement> options;
	public static Select select;
	
	
	@Given("Launch the Ajio {string}")
	public void launch_the_ajio(String string) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("start-maximized");
		driver = new EdgeDriver(options);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get(string);
	}

	@Given("Navigate to Kids and click the clothing")
	public void navigate_to_kids_and_click_the_clothing() {
		WebElement kids = driver.findElement(By.xpath("//span[text()='KIDS']"));
	    action.moveToElement(kids).perform();
	    WebElement clothing = driver.findElement(By.xpath("//strong[text()='NEW IN: CLOTHING']"));
		action.click(clothing).perform();
	}

	@When("user click sort dropdown and select option in a dropdown with one dim map")
	public void user_click_sort_dropdown_and_select_option_in_a_dropdown_with_one_dim_map(DataTable dataTable) {
		Map<String,String> map = dataTable.asMap(String.class, String.class);
		String high = map.get("sort3");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='sortBy']"));
		 select = new Select(dropdown);
		 List<WebElement> options = select.getOptions();
		 for(WebElement option: options) {
			 String text = option.getText();
			 if(text.contains(high)) {
				 select.selectByVisibleText(text);
			 }
		 }
	}

	@Then("validate result")
	public void validate_result() {
		System.out.println("complete");
		
		
	  
	}

}
