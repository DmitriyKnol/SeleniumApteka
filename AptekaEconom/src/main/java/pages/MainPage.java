package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilClickable;
import static utils.Waiters.waitUntilVisible;

public class MainPage {

    /**
     * Поле для хранения названия искомого продукта
     */
    private final String product = "парацетамол";

    /**
     * Поле для хранения экземляра драйвера
     */
    private final WebDriver driver;

    /**
     * Кнопка перехода в категорию Косметика
     */
    @FindBy(xpath = ".//div/a[@href = '/catalog/kosmetika/']")
    private WebElement buttonKosmetika;

    /**
     * Кнопка перехода в подкатегорию Антисептики, дезсредства
     */
    @FindBy(xpath = ".//div/a[text() = 'Антисептики, дезсредства']")
    private WebElement buttonAntiseptic;

    /**
     * Первый элемент из списка в подкатегории Антисептики, дезсредства
     */
    @FindBy(xpath = "(.//div[@class = 'image_wrapper_block'])[1]")
    private WebElement firstElementInAntiseptics;

    /**
     * Активный элемент вкладки Косметика в левой части страницы
     */
    @FindBy(xpath = ".//li[@class = 'full has-child current opened m_line v_hover']/a/span[text()='Косметика']")
    private WebElement activeCategoryCosmeticLeft;

    /**
     * Активный элемент вкладки Косметика вверху страницы
     */
    @FindBy(xpath = ".//td[@class = 'menu-item dropdown wide_menu   active']/div/a[@href = '/catalog/kosmetika/']")
    private WebElement activeCategoryCosmeticTop;

    /**
     * Хлебные крошки подкатегория Антисептики, дезсредства
     */
    @FindBy(xpath = ".//span[@itemprop = 'itemListElement']/span/span[text() = 'Антисептики, дезсредства']")
    private WebElement bredAntiseptics;

    /**
     * Хлебные крошки категория Косметика
     */
    @FindBy(xpath = ".//div[@class = 'wrap']")
    private WebElement bredCosmetic;

    /**
     * Хлебные крошки Каталог
     */
    @FindBy(xpath = ".//div[@itemprop = 'itemListElement']/a/span[text() = 'Каталог']")
    private WebElement bredCatalog;

    /**
     * Хлебные крошки Главная
     */
    @FindBy(xpath = ".//div[@itemprop = 'itemListElement']/a/span[text() = 'Главная']")
    private WebElement bredMain;

    /**
     * Элемент "Поисковая строка"
     */
    @FindBy(id = "title-search-input_fixed")
    private WebElement searchInput;

    /**
     * Элемент "Поисковая строка"
     */
    @FindBy(xpath = ".//button[@class = 'btn btn-search']")
    private WebElement searchButton;

    /**
     * Первый товар из списка, после поиска
     */
    @FindBy(xpath = "(.//div[@class = 'item-title'])[1]/a/span")
    private WebElement searchProductText;

    /**
     * Конструктор класса MainPage
     *
     * @param driver веб драйвер
     */
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Геттер для получения названия продукта
     *
     * @return возвращает название продукта
     */
    public String getProduct() {
        return product;
    }

    /**
     * Метод нажатия на кнопку категории Косметика
     *
     * @return текущий класс
     */
    @Step("Клик на категорию Косметика")
    public MainPage clickToCosmetic() {
        waitUntilClickable(driver, (buttonKosmetika));
        buttonKosmetika.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод нажатия на кнопку подкатегории Антисептики, дезсредства
     *
     * @return текущий класс
     */
    @Step("Клик на подкатегорию Антисептики, дезсредства")
    public MainPage clickToAntiseptic() {
        waitUntilClickable(driver, (buttonAntiseptic));
        buttonAntiseptic.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки, что с левой стороны категория Косметика - активна
     *
     * @return текущий класс
     */
    @Step("Проверка, что категория Косметика - активна")
    public MainPage viewActiveCategoryCosmeticLeft() {
        waitUntilClickable(driver, (activeCategoryCosmeticLeft));
        activeCategoryCosmeticLeft.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки, что вверху страницы категория Косметика - активна
     *
     * @return текущий класс
     */
    @Step("Проверка, что категория Косметика - активна")
    public MainPage viewActiveCategoryCosmeticTop() {
        waitUntilClickable(driver, (activeCategoryCosmeticTop));
        activeCategoryCosmeticTop.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки, что в подкатегории присутствует хотя бы 1 товар
     *
     * @return текущий класс
     */
    @Step("Клик на первый товар из подкатегории Антисептики, дезсредства")
    public MainPage clickFirstElementAntiseptic() {
        waitUntilClickable(driver, (firstElementInAntiseptics));
        firstElementInAntiseptics.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки хлебных крошек, проверка подкатегории Антисептики, дезсредства
     *
     * @return текущий класс
     */
    @Step("Проверка наличия хлебной крошки Антисептики, дезсредства")
    public MainPage viewBredAntiseptic() {
        waitUntilClickable(driver, (bredAntiseptics));
        bredAntiseptics.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки хлебных крошек, проверка категории Косметика
     *
     * @return текущий класс
     */
    @Step("Проверка наличия хлебной крошки Косметика")
    public MainPage viewBredCosmetic() {
        waitUntilClickable(driver, (bredCosmetic));
        bredCosmetic.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки хлебных крошек, проверка крошки Каталог
     *
     * @return текущий класс
     */
    @Step("Проверка наличия хлебной крошки Каталог")
    public MainPage viewBredCatalog() {
        waitUntilClickable(driver, (bredCatalog));
        bredCatalog.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки хлебных крошек, проверка крошки Главная
     *
     * @return текущий класс
     */
    @Step("Проверка наличия хлебной крошки Главная")
    public MainPage viewBredMain() {
        waitUntilClickable(driver, (bredMain));
        bredMain.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для поиска товара через поисковую строку
     *
     * @return текущий класс
     */
    @Step("Ввод в поисковую строку")
    public MainPage inputIntoSearch() {
        waitUntilClickable(driver, (searchInput));
        searchInput.sendKeys(getProduct());
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод нажатия на кнопку поиска
     *
     * @return текущий класс
     */
    @Step("Клик на кнопку поиска")
    public MainPage clickToSearch() {
        waitUntilClickable(driver, (searchButton));
        searchButton.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод нажатия на кнопку поиска
     *
     * @return текущий класс
     */
    @Step("Получение описания первого товара из списка")
    public String getProductDescription() {
        waitUntilVisible(driver, (searchProductText));
        makeScreenShot(driver);
        return searchProductText.getText().toLowerCase();

    }

    /**
     * Метод для перехода в подкатегорию
     * Последовательно использует методы для выбора категории
     * и выбора подкатегории
     */
    public void enterToAntiseptics() {
        clickToCosmetic();
        clickToAntiseptic();
    }

    /**
     * Метод для последовательной проверки отображения хлебных крошек
     */
    public void viewBred() {
        viewBredAntiseptic();
        viewBredCosmetic();
        viewBredCatalog();
        viewBredMain();
    }

    /**
     * Метод для поиска товара
     */
    public void searchProduct() {
        inputIntoSearch();
        clickToSearch();
    }
}
