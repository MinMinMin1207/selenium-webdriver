package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;

    By myAccountLink = By.linkText("MY ACCOUNT");
    By createAccountLink = By.linkText("CREATE AN ACCOUNT");
    By firstNameInputLocator = By.id("firstname");
    By lastnameInputLocator = By.id("lastname");
    By emailInputLocator = By.id("email_address");
    By passwordInputLocator = By.id("password");
    By confirmPasswordInputLocator = By.id("confirmation");
    By registerButton = By.xpath("//span[contains(text(),'Register')]");



    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink(){
        driver.findElement(myAccountLink).click();
    }
    public void clickCreateAccountLink(){
        driver.findElement(createAccountLink).click();
    }

    public void enterFirstName(String firstName){
        WebElement firstNameElement = driver.findElement(firstNameInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

}
    public void enterLastName(String lastName){
        WebElement lastNameElement = driver.findElement(lastnameInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

    }

    public void enterEmail(String email){
        WebElement emailElement = driver.findElement(emailInputLocator);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordInputLocator);
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

}