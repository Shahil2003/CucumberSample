package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignLeavePage {
	WebDriver driver;
	public AssignLeavePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void AssignLeaveButton() {
		WebElement btn=driver.findElement(By.xpath("//button[@title='Assign Leave']"));
		btn.click();
	}
	
	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void setName(String name) {
		WebElement nameObj=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		nameObj.sendKeys(name);
	}
	
	public String getInvalidError() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement bdy = driver.findElement(By.tagName("body"));
		bdy.click();
		WebElement errorObj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")));
		String error = errorObj.getText();
		return error;
	}
	
	public void AssignButton() {
		WebElement btn=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		btn.click();
	}
	
	

}
