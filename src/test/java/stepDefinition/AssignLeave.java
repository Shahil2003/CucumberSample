package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AssignLeavePage;
import pages.LoginPage;

public class AssignLeave {
	WebDriver driver;
    LoginPage login;
    AssignLeavePage assign;
    
	@Given("I am logged in as an admin on the OrangeHRM dashboard")
    public void i_am_logged_in_as_an_admin_on_the_orange_hrm_dashboard() {
    	driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login = new LoginPage(driver);
        assign = new AssignLeavePage(driver);
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.buttonClick();
    }

    @When("I click on the Assign Leave button")
    public void i_click_on_the_assign_leave_button() {
        assign.AssignLeaveButton();
    }

    @Then("I should be navigated to the Assign Leave page with URL {string}")
    public void i_should_be_navigated_to_the_assign_leave_page_with_url(String expectedUrl) {
        String actualUrl = assign.getUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Then("the user enters {string} as the employee name in the text box")
    public void the_user_enters_as_the_employee_name_in_the_text_box(String name) {
        assign.setName(name);
    }

    @Then("the input field should highlight the {string} error in red color")
    public void the_input_field_should_highlight_the_error_in_red_color(String expectedError) {
        String actualError = assign.getInvalidError();
        Assert.assertEquals(actualError, expectedError);
    }
    
//    @When("I select {string} from the dropdown menu")
//    public void i_select_from_the_dropdown_menu(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I click on the leave type dropdown menu")
//    public void i_click_on_the_leave_type_dropdown_menu() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("{string} should be displayed in the leave type input field")
//    public void should_be_displayed_in_the_leave_type_input_field(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
