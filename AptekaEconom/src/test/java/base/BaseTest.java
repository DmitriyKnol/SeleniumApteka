package base;

import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import pages.ShoppingCart;

import static utils.ScreenHelper.makeScreenShot;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Поле, для хранения экземпляра драйвера
     */
    protected WebDriver driver;

    /**
     * Поле, для хранения экземпляра MainPage
     */
    protected MainPage mainPage;

    /**
     * Поле, для хранения экземпляра ShoppingCart
     */
    protected ShoppingCart shoppingCart;

    /**
     * Экземпляр класса конфигурации
     */
    private final config.BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов, перед выполнением каждого
     */
    @BeforeMethod
    public void setUp() {

        // Установка настройки с путем к google драйверу
        System.setProperty(config.driverProperty(), config.driverPath());

        // Создание экземпляра драйвера
        driver = new ChromeDriver();

        // Переход на сайт
        driver.get(config.url());

        // Развернуть браузер во все окно
        driver.manage().window().maximize();

        // Установка города в куки
        Cookie getCookie = new Cookie("current_region", "119218");
        driver.manage().addCookie(getCookie);

        // Обновление страницы, для загрузки с куки
        driver.navigate().refresh();

        // Создание скриншота
        makeScreenShot(driver);


    }

    /**
     * Общие настройки для всех тестов, после выполнения каждого
     */
    @AfterMethod
    public void tearDown() {
        // Остановка работы драйвера
        driver.close();
    }

}