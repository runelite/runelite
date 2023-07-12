package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;


public class RSBank {

    private final GameObject bankObject;

    public RSBank(GameObject gameObject) {
        this.bankObject = gameObject;
    }

    public boolean isOpen() {
        Widget widget = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER));
        return widget != null && !widget.isHidden();
    }

    public WorldPoint getWorldLocation() {
        if (bankObject == null) {
            return null;
        }
        return bankObject.getWorldLocation();
    }

    public boolean open() {
        if (bankObject.getClickbox() == null) {
            return false;
        }

        Rectangle bankBounds = bankObject.getClickbox().getBounds();
        if (bankBounds == null) {
            return false;
        }

        Alfred.getMouse().rightClick(bankBounds);
        Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction("bank"), 200, 10);

        Alfred.api.menu().getMenu().clickAction("bank");
        return Alfred.sleepUntil(this::isOpen, 1000, 10);
    }

    public boolean clickViewAllItems() {
        return Alfred.api.widgets().leftClickWidget(WidgetInfo.BANK_TAB_CONTAINER);
    }

    public boolean clickSearch() {
        return Alfred.api.widgets().leftClickWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
    }

    public boolean clickDepositInventory() {
        return Alfred.api.widgets().leftClickWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
    }

    public boolean clickDepositEquipment() {
        return Alfred.api.widgets().leftClickWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
    }

    public boolean clickWithdrawAsItem() {
        return Alfred.api.widgets().leftClickWidget(786454);
    }

    public boolean clickWithdrawAsNote() {
        return Alfred.api.widgets().leftClickWidget(786456);
    }

    public boolean close() {
        Widget widget = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(786434));
        Widget childWidget = Alfred.api.widgets().getChildWidget(widget, 11);
        Alfred.api.widgets().leftClickWidget(childWidget);
        return Alfred.sleepUntil(() -> !isOpen(), 200, 10);
    }
}
