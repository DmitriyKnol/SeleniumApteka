import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ShoppingCart;

import static org.testng.Assert.assertEquals;

@Epic("Тесты сайта Aptekaeconom")
public class WishListTest extends BaseTest {

    @Feature("Проверка возможности добавления товара в \"Отложенные\"")
    @Test(description = "Товар добавлен и отображается в корзине в \"Отложенных\" ")
    public void addProductToWishList() {
        mainPage = new MainPage(driver);
        shoppingCart = new ShoppingCart(driver);

        mainPage.enterToAntiseptics();
        shoppingCart.clickToAddWish()
                .clickToWishList()
                .checkProductOnWishList();
    }

    @Feature("Проверка возможности добавления товара в \"Отложенные\"")
    @Test(description = "Товар из \"Отложенных\" не суммируется с товарами в корзине")
    public void checkNoPriceWishListInBasket() {
        mainPage = new MainPage(driver);
        shoppingCart = new ShoppingCart(driver);

        mainPage.enterToAntiseptics();
        shoppingCart.clickToAddWish()
                .clickToWishList();
        assertEquals(shoppingCart.getFullPriceInBasket(), shoppingCart.getPrice());

    }

    @Feature("Проверка возможности добавления товара в \"Отложенные\"")
    @Test(description = "Проверка суммы на иконке Отложенные")
    public void checPriceOnWishListTest() {
        mainPage = new MainPage(driver);
        shoppingCart = new ShoppingCart(driver);

        mainPage.enterToAntiseptics();
        shoppingCart.clickToAddWish()
                .getPriceOnWishList();
    }

}
