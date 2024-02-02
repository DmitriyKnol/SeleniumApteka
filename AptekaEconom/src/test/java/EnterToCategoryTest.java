import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MainPage;

@Epic("Тесты сайта Aptekaeconom")
public class EnterToCategoryTest extends BaseTest {


    @Feature("Проверка возможности перехода по категориям")
    @Test(description = "Отображение хотя бы одного товара в подкатегории")
    public void viewProductAnCategory() {
        mainPage = new MainPage(driver);
        mainPage.enterToAntiseptics();
        mainPage.clickFirstElementAntiseptic();
    }

    @Feature("Проверка возможности перехода по категориям")
    @Test(description = "Тест отображения категории товара в левой части")
    public void CategoryIsVisibleOnLeftTest() {
        mainPage = new MainPage(driver);
        mainPage.enterToAntiseptics();
        mainPage.viewActiveCategoryCosmeticLeft();
    }

    @Feature("Проверка возможности перехода по категориям")
    @Test(description = "Тест отображения категории товара вверху страницы")
    public void CategoryIsVisibleOnTopTest() {
        mainPage = new MainPage(driver);
        mainPage.enterToAntiseptics();
        mainPage.viewActiveCategoryCosmeticTop();
    }

    @Feature("Проверка возможности перехода по категориям")
    @Test(description = "Проверка отображения хлебных крошек")
    public void viewBredTest() {
        mainPage = new MainPage(driver);
        mainPage.enterToAntiseptics();
        mainPage.viewBred();
    }
}