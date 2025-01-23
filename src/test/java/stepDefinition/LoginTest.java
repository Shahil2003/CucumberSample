package stepDefinition;


import pages.LoginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class LoginTest {
    WebDriver driver;
    LoginPage login;

    @Given("I open the OrangeHRM login page")
    public void i_open_the_orangehrm_login_page() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        login.setUsername(username);
        login.setPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        login.buttonClick();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedError) {
        String actualError = login.getError();
        Assert.assertEquals(actualError, expectedError);
    }
    
    @Then("I should see an error message {string}")
    public void i_should_see_another_error_message(String expectedError) {
        String actualError = login.getError();
        Assert.assertEquals(actualError, expectedError);
    }

    @Then("I should see the dashboard page with title {string}")
    public void i_should_see_the_dashboard_page_with_title(String expectedTitle) {
        String actualTitle = login.getDashboard();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
//    @Given("I am logged in as an admin on the OrangeHRM dashboard")
//    public void i_am_logged_in_as_an_admin_on_the_orange_hrm_dashboard() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I click on the Assign Leave button")
//    public void i_click_on_the_assign_leave_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("I should be navigated to the Assign Leave page with URL {string}")
//    public void i_should_be_navigated_to_the_assign_leave_page_with_url(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
