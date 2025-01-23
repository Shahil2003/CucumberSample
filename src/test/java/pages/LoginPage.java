package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void setUsername(String uname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		usernameField.sendKeys("Admin");

	}
	
	
	public void setPassword(String password) {
		WebElement pbox=driver.findElement(By.name("password"));
		pbox.sendKeys(password);
	}
	public String getError() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
		String Exp_Error = errorMessage.getText();
		return Exp_Error;
	}
	
	public String get_Required_Error() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("span")));
		String Exp_Error = errorMessage.getText();
		return Exp_Error;
	}
	
	public void buttonClick() {
		WebElement btn=driver.findElement(By.cssSelector("button[type='submit']"));
		btn.click();
	}
	
	public String getDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));
		String actualTitle = dashboardTitle.getText();
		return actualTitle;

	}
}
