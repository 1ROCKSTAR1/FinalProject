package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {

    SelenideElement itemsPlaque = $x("//h1[contains(text(),'Предметы') or contains(text(),'Items')]");

    public boolean checkItemsPlaque() {
        return itemsPlaque.is(Condition.visible);
    }
}
