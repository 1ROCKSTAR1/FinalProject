package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ShopsPage {

    SelenideElement marketPlaque = $x("//h1[contains(text(),'Рынок') or contains(text(),'Market')]");

    public boolean checkMarketPlaque() {
        return marketPlaque.is(Condition.visible);
    }
}
