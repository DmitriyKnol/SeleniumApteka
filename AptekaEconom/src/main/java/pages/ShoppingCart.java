package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilClickable;
import static utils.Waiters.waitUntilVisible;

public class ShoppingCart {

    /**
     * Поле для хранения экземляра драйвера
     */
    private final WebDriver driver;

    /**
     * Поле для хранения экземляра драйвер
     */
    private final String price = "0 руб.";

    /**
     * Кнопка "Отложить" для первого товара на странице
     */
    @FindBy(xpath = "(//div[@class = 'wish_item_button'])[1]")
    private WebElement buttonPutInWish;

    /**
     * Цена первого товара на странице
     */
    @FindBy(xpath = "(//span[@class = 'values_wrapper'])[1]/span[@class = 'price_value']")
    private WebElement priceFirstProduct;

    /**
     * Кнопка перехода в "Отложенные"
     */
    @FindBy(xpath = "//div[@class = 'pull-right block-link']/div/a/span/i[@class = 'svg inline  svg-inline-wish big']")
    private WebElement buttonWishList;

    /**
     * Товар в "Отложенных"
     */
    @FindBy(xpath = "//span[@data-entity = 'basket-item-name']")
    private WebElement productInWishList;

    /**
     * Товар в "Отложенных"
     */
    @FindBy(xpath = "//div[@data-entity = 'basket-total-price']")
    private WebElement fullPriceInBasket;

    /**
     * Всплывающая цена при наведении на кнопку "Отложенные"
     */
    @FindBy(xpath = "//div[@class = 'wrap_icon inner-table-block baskets big-padding']/a[@title = 'В отложенных товаров на 40 руб.']")
    private WebElement toolTipPrice;

    /**
     * Метод нажатия на кнопку "Отложить"
     *
     * @return текущий класс
     */
    @Step("Клик на кнопку \"Отложить\" первого товара из списка")
    public ShoppingCart clickToAddWish() {
        waitUntilClickable(driver, (buttonPutInWish));
        buttonPutInWish.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод нажатия на кнопку "Отложить"
     *
     * @return текущий класс
     */
    @Step("Клик на кнопку \"Отложенные\"")
    public ShoppingCart clickToWishList() {
        waitUntilClickable(driver, (buttonWishList));
        buttonWishList.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для проверки товара в корзине в разделе "Отложенные
     *
     * @return текущий класс
     */
    @Step("Проверка, что товар попал в  \"Отложенные\"")
    public ShoppingCart checkProductOnWishList() {
        waitUntilClickable(driver, (buttonWishList));
        buttonWishList.isDisplayed();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для получения цены первого товара из списка
     *
     * @return текущий класс
     */
    @Step("Получение цены первого товара из списка")
    public String getPriceFirstProduct() {
        waitUntilVisible(driver, (priceFirstProduct));
        return priceFirstProduct.getText().toLowerCase();
    }

    /**
     * Метод для получения общей суммы в корзине
     *
     * @return текущий класс
     */
    @Step("Получение суммы корзины")
    public String getFullPriceInBasket() {
        waitUntilClickable(driver, (fullPriceInBasket));
        makeScreenShot(driver);
        return fullPriceInBasket.getText().toLowerCase();
    }

    /**
     * Метод для сравнения цены отложенного товара и цены отображаемой при наведенении
     * на кнопку "Отложенные"
     *
     * @return текущий класс
     */
    private WebElement priceValue(String number) {
        return driver.findElement(By.xpath("//div[@class = 'wrap_icon inner-table-block baskets big-padding']/a[@title = 'В отложенных товаров на " +
                number + " руб.']"));
    }

    /**
     * Метод для сравнения цены отложенного товара и цены отображаемой при наведенении
     * на кнопку "Отложенные"
     *
     * @return текущий класс
     */
    @Step("Проверка корректности отображения цены на иконке \"Отложенные\"")
    public ShoppingCart getPriceOnWishList() {
        priceValue(getPriceFirstProduct()).isDisplayed();
        makeScreenShot(driver);
        return this;
    }


    /**
     * Конструктор класса ShoppingCart
     *
     * @param driver веб драйвер
     */
    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Геттер для получение цены
     *
     * @return возвращает цену
     */
    public String getPrice() {
        return price;
    }
}
