package qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("��������� ������� �������")
    public void openMainPage() {
        open("https://www.film.ru");
    }

    @Step("���� ������ ����")
    public void searchFilm() {
        $("#quick_search_input").setValue("book").pressEnter();
    }

    @Step("���������, ��� ����� ��������� ������� ������� Green Book")
    public void checkFilm() {
        $$("#movies_list").find(text("Green book")).shouldBe(visible);
    }

    @Step("��������� �� �������� ������")
    public void cardFilm() {
        $(By.cssSelector("#movies_list > a:nth-child(1)")).click();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
