package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LoginSteps {

    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver"); // Replace with your chromedriver path
        this.driver = new ChromeDriver();
        driver.get("https://www.boomplay.com/");
    }

    @When("I enter credentials {string} and {string}")
    public void iEnterCredentials(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/article[1]/article/div/div/strong/button[1]")).click();
        driver.findElement(By.xpath("/html/body/article[2]/form[1]/div[1]/label[2]")).click();
        driver.findElement(By.xpath("/html/body/article[2]/form[1]/div[3]/label/input")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/article[2]/form[1]/div[4]/label/input")).sendKeys(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("/html/body/article[2]/form[1]/div[6]/input")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        WebElement loginForm = driver.findElement(By.xpath("/html/body/article[2]"));
        assertFalse(loginForm.getAttribute("class").contains("show"));
    }

    @Then("I should see a welcome message {string}")
    public void iShouldSeeAWelcomeMessage(String message) {
        assertEquals(driver.findElement(By.xpath("/html/body/article[1]/article/a/div[2]/strong")).getText(), message);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String message) {
        WebElement loginForm = driver.findElement(By.xpath("/html/body/article[2]"));
        assertTrue(loginForm.getAttribute("class").contains("show"));
    }

    @And("Wait for {int}")
    public void waitFor(int arg0) throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("close")
    public void close() {
        driver.quit();
    }
}