package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageSimple {
    private WebDriver driver;

    // Declare element selector value here
    private By usernameSelector = By.id("username");
    private By passwordSelector = By.id("password");
    private By loginBtnSelector = By.cssSelector("[type='submit']");

    // Constructor with required parameter as a WebDriver instance
    public LoginPageSimple(WebDriver driver) {
        this.driver = driver;
    }

    // Getter to return element on the page
    public WebElement username() {
        return driver.findElement(usernameSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public WebElement loginBtn() {
        return driver.findElement(loginBtnSelector);
    }

    public void inputUsername(String username){
        WebElement usernameElem = driver.findElement(usernameSelector);
        usernameElem.sendKeys(username);
    }

    public void inputPassword(String password){
        password().sendKeys(password);
    }

    public void clickOnLoginBtn(){
        loginBtn().click();
    }
}
