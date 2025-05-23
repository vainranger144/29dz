package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private final By guestLoginBtn = By.xpath("//button[text()='Guest log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGuestLogin() {
        driver.findElement(guestLoginBtn).click();
    }
}
