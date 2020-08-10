package stepdefs;

import java.awt.*;
import java.awt.event.KeyEvent;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginDefinitions {

    WebDriver driver;

    @Given("^I am on the Login page$")
    public void i_am_on_the_Login_page() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.hospitalrun.io/#/login");
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("identification")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^I click Sign in button$")
    public void i_click_Sign_in_button() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    @Then("^I should go to Dashboard page$")
    public void i_should_go_to_Dashboard_page() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlContains("http://demo.hospitalrun.io/#/patients"));
        String title = driver.getTitle();
        System.out.println("The Page's title is: " + title);
    }

    @Then("^Close the browser$")
    public void close_the_browser() {
        driver.quit();
    }
}
