package CucumbeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefination {

	
	WebDriver driver;
	
	@Given("Im sign in page")
	public void im_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("lauching page");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
}

	@When("I enter user")
	public void i_enter_user() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter user");
driver.manage().window().maximize();
	System.out.println(driver.getTitle());}

	@When("I enter pass")
	public void i_enter_pass() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter pass");	}

	@When("I click login")
	public void i_click_login() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click button");}

	@Then("I verify message")
	public void i_verify_message() {
	    // Write code here that turns the phrase above into concrete actions
	System.out.println("verify home");
	driver.quit();
}
}
