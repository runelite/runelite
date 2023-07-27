package net.runelite.client.plugins.alfred.api.rs.bank;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;

import java.awt.*;


@Slf4j(topic = "RSBank")
public class RSBank {
    private final int WIDGET_REARRANGE_SWAP = 786450;
    private final int WIDGET_REARRANGE_INSERT = 786452;
    private final int VARBIT_WITHDRAW_AS = 3958;

    private final GameObject bankObject;

    public RSBank(GameObject gameObject) {
        this.bankObject = gameObject;
    }

    public WorldPoint getWorldLocation() {
        return bankObject.getWorldLocation();
    }

    public Shape getClickbox() {
        return bankObject.getClickbox();
    }

    public boolean isOpen() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
            if (widget == null) {
                return false;
            }

            return !widget.isHidden() && !widget.isSelfHidden();
        });
    }

    public boolean isClosed() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
            return widget == null;
        });
    }

    public boolean open() {
        Alfred.setStatus("Opening bank");

        if (getWorldLocation() == null) {
            log.warn("Could not find bank world location");
            return false;
        }

        Alfred.api.camera().lookAt(getWorldLocation());

        if (getClickbox() == null) {
            log.warn("Could not find bank clickbox");
            return false;
        }

        if (getClickbox().getBounds() == null) {
            log.warn("Could not find bank clickbox bounds");
            return false;
        }

        if (isOpen()) {
            return false;
        }

        Alfred.getMouse().rightClick(getClickbox().getBounds());

        if (!Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction("bank"), 200, 2000)) {
            log.warn("Could not find bank action");
            return false;
        }

        Alfred.api.menu().getMenu().clickAction("bank");
        if (!Alfred.sleepUntil(this::isOpen, 200, 1000 * 10)) {
            log.warn("Could not open bank");
            return false;
        }

        Alfred.setStatus("Opened bank");
        return true;
    }

    public boolean close() {
        Alfred.setStatus("Closing bank");

        Widget widget = Alfred.api.widgets().getChildWidget(786434, 11);
        if (widget == null) {
            log.warn("Could not find bank close button widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());


        if (!Alfred.sleepUntil(() -> !isOpen(), 200, 1000 * 10)) {
            log.warn("Could not close bank");
            return false;
        }

        Alfred.setStatus("Closed bank");
        return true;
    }

    public void depositAll(RSGroundItem rsGroundItem) {
        Alfred.api.inventory().getItems(rsGroundItem.getId()).forEach(item -> {
            item.clickAction("deposit-all");
        });
    }

    public void depositAll(String itemName) {
        Alfred.api.inventory().getItems(itemName).forEach(item -> {
            System.out.println(item.getClass().toString());
            item.clickAction("deposit-all");
        });
    }

    public boolean clickViewAllItems() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_TAB_CONTAINER);
        if (widget == null) {
            log.warn("Could not find bank container widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean isRearrangeSwapSelected() {
        return Alfred.getClient().getVarbitValue(Varbits.BANK_REARRANGE_MODE) == 0;
    }

    public boolean isRearrangeInsertSelected() {
        return Alfred.getClient().getVarbitValue(Varbits.BANK_REARRANGE_MODE) == 0;
    }

    public boolean clickRearrangeSwap() {
        Widget widget = Alfred.api.widgets().getWidget(WIDGET_REARRANGE_SWAP);
        if (widget == null) {
            log.warn("Could not find bank withdraw as item widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean clickRearrangeInsert() {
        Widget widget = Alfred.api.widgets().getWidget(WIDGET_REARRANGE_INSERT);
        if (widget == null) {
            log.warn("Could not find bank withdraw as note widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean isWithdrawAsItemSelected() {
        return Alfred.getClient().getVarbitValue(VARBIT_WITHDRAW_AS) == 0;
    }

    public boolean isWithdrawAsNoteSelected() {
        return Alfred.getClient().getVarbitValue(VARBIT_WITHDRAW_AS) == 1;
    }

    public boolean clickWithdrawAsItem() {
        Widget widget = Alfred.api.widgets().getWidget(786454);
        if (widget == null) {
            log.warn("Could not find bank withdraw as item widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean clickWithdrawAsNote() {
        Widget widget = Alfred.api.widgets().getWidget(786456);
        if (widget == null) {
            log.warn("Could not find bank withdraw as note widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean clickSearch() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
        if (widget == null) {
            log.warn("Could not find bank search widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean clickDepositInventory() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
        if (widget == null) {
            log.warn("Could not find bank deposit inventory widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean clickDepositEquipment() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
        if (widget == null) {
            log.warn("Could not find bank deposit equipment widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

}
