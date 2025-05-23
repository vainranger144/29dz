package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GaragePage {
    private WebDriver driver;

    private final By addCarBtn = By.xpath("//button[@class='btn btn-primary']");
    private final By carTitle = By.cssSelector(".car_name");
    private final By mileageText = By.cssSelector(".car_update-mileage");
    private final By mileageInput = By.cssSelector("input[name='miles']");
    private final By carImage = By.cssSelector(".car_logo.car-logo img");

    public GaragePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddCar() {
        driver.findElement(addCarBtn).click();
    }

    public String getCarTitle() {
        return driver.findElement(carTitle).getText();
    }

    public String getMileageText() {
        return driver.findElement(mileageText).getText();
    }

    public String getMileageValue() {
        return driver.findElement(mileageInput).getAttribute("value");
    }

    public boolean isCarImageDisplayed() {
        return driver.findElement(carImage).isDisplayed();
    }

    public String getCarImageSrc() {
        return driver.findElement(carImage).getAttribute("src");
    }
}
