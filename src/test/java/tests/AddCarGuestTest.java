package tests;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddCarModal;
import pages.GaragePage;
import pages.LoginPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Epic("Guest Functionality")
@Feature("Add Car as Guest")
@Owner("sergey")
@Link(name = "QAuto", url = "https://qauto.forstudy.space/")
@Severity(SeverityLevel.CRITICAL)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddCarGuestTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private GaragePage garagePage;
    private AddCarModal addCarModal;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        loginPage = new LoginPage(driver);
        garagePage = new GaragePage(driver);
        addCarModal = new AddCarModal(driver);
    }

    @Test
    @Order(1)
    void addCarAsGuestTest() {
        loginPage.clickGuestLogin();

        Assertions.assertEquals("https://guest:welcome2qauto@qauto.forstudy.space/panel/garage", driver.getCurrentUrl());

        garagePage.clickAddCar();
        addCarModal.selectBrand("Audi");
        addCarModal.selectModel("TT");
        addCarModal.setMileage("20");
        addCarModal.clickAdd();

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(garagePage.getCarTitle()).isEqualTo("Audi TT");

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        soft.assertThat(garagePage.getMileageText()).contains(today);

        soft.assertThat(garagePage.getMileageValue()).isEqualTo("20");
        soft.assertThat(garagePage.isCarImageDisplayed()).isTrue();
        soft.assertThat(garagePage.getCarImageSrc()).endsWith("audi.png");

        soft.assertAll();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
