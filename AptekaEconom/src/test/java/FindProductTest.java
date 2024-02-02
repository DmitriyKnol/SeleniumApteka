import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

@Epic("Тесты сайта Aptekaeconom")
public class FindProductTest extends BaseTest {

    @Feature("Проверка возможности поиска товара")
    @Test(description = "Отображены товару по варианту \"Содержит\"")
    public void viewProductAnCategory() {
        mainPage = new MainPage(driver);
        mainPage.searchProduct();
        Assert.assertTrue(mainPage.getProductDescription().contains(mainPage.getProduct()));
    }

}
