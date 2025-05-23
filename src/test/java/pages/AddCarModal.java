package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCarModal {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By brandDropdown = By.id("addCarBrand");
    private final By modelDropdown = By.id("addCarModel");
    private final By mileageInput = By.id("addCarMileage");
    private final By addButton = By.xpath("//button[text()='Add']");

    public AddCarModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectBrand(String brand) {
        WebElement brandSelect = wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void selectModel(String model) {
        WebElement modelSelect = wait.until(ExpectedConditions.elementToBeClickable(modelDropdown));
        new Select(modelSelect).selectByVisibleText(model);
    }

    public void setMileage(String mileage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mileageInput)).sendKeys(mileage);
    }

    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }
}
