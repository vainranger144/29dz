package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddCarModal {
    private WebDriver driver;

    private final By brandDropdown = By.id("addCarBrand");
    private final By modelDropdown = By.id("addCarModel");
    private final By mileageInput = By.id("addCarMileage");
    private final By addButton = By.xpath("//button[text()='Add']");

    public AddCarModal(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBrand(String brand) {
        new Select(driver.findElement(brandDropdown)).selectByVisibleText(brand);
    }

    public void selectModel(String model) {
        new Select(driver.findElement(modelDropdown)).selectByVisibleText(model);
    }

    public void setMileage(String mileage) {
        driver.findElement(mileageInput).sendKeys(mileage);
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
    }
}
