package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.api.GameObject;
import net.runelite.api.MenuEntry;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BankAPI {

    private final GameObject bankObject;

    public BankAPI(GameObject gameObject) {
        this.bankObject = gameObject;
    }

    private static boolean clickWidget(int widgetID) {
        Rectangle bounds = Utility.getTabBounds(widgetID);
        if (bounds == null) {
            return false;
        }

        Alfred.getMouse().leftClick(bounds);
        return true;
    }

    private static boolean clickWidget(WidgetInfo widgetInfo) {
        Rectangle bounds = Utility.getTabBounds(widgetInfo);
        if (bounds == null) {
            return false;
        }

        Alfred.getMouse().leftClick(bounds);
        return true;
    }

    public static List<BankAPI> getNearestBanks() {
        List<BankAPI> bankAPIList = new ArrayList<>();
        GameObjectAPI.getGameObjects().forEach(gameObject -> {
            if (gameObject.getId() == ObjectID.BANK_BOOTH_10583) {
//            if (gameObject.getId() == 10583) {
                bankAPIList.add(new BankAPI(gameObject));
            }
        });
        return bankAPIList;
    }

    public static boolean isOpen() {
        Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
        return widget != null && !widget.isHidden();
    }

    public WorldPoint getBankLocation() {
        if (bankObject == null) {
            return null;
        }
        return bankObject.getWorldLocation();
    }

    public void openBank() {
        if (bankObject.getClickbox() == null) {
            return;
        }

        Rectangle bankBounds = bankObject.getClickbox().getBounds();
        if (bankBounds == null) {
            return;
        }
        Alfred.getMouse().rightClick(bankBounds);
        Alfred.sleep(100, 200);

        for (MenuEntry menuEntry : Alfred.getClient().getMenuEntries()) {
            if (!menuEntry.getOption().equals("Bank")) {
                continue;
            }
            System.out.println(String.format("Action: %s, Other %s", menuEntry.getOption(), menuEntry.getTarget()));

            if (menuEntry.getParent() != null) {
                System.out.println(String.format("Parent: %s", menuEntry.getParent().getOption()));
            }

            Alfred.sleep(300, 800);
            if (menuEntry.getWidget() == null) {
                System.out.println("No menu entry widget");
                continue;
            }

            WidgetAPI.clickWidget(menuEntry.getWidget().getId());
            System.out.println("Found widget");
            return;
        }
    }

    public static boolean clickViewAllItems() {
        return clickWidget(WidgetInfo.BANK_TAB_CONTAINER);
    }

    public static boolean clickSearch() {
        return clickWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
    }

    public static boolean clickDepositInventory() {
        return clickWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
    }

    public static boolean clickDepositEquipment() {
        return clickWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
    }

    public static boolean clickWithdrawAsItem() {
        return clickWidget(786454);
    }

    public static boolean clickWithdrawAsNote() {
        return clickWidget(786456);
    }

    public static boolean clickClose() {
        return clickWidget(786434);
    }

    public static void test() {
        int delay = 1000;

        clickViewAllItems();
        Alfred.sleep(delay);

        clickSearch();
        Alfred.sleep(delay);

        clickDepositInventory();
        Alfred.sleep(delay);

        clickDepositEquipment();
        Alfred.sleep(delay);

        clickWithdrawAsItem();
        Alfred.sleep(delay);

        clickWithdrawAsNote();
        Alfred.sleep(delay);
    }
}
