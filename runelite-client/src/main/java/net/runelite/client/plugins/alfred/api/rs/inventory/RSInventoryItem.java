package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.ItemComposition;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RSInventoryItem {
    private final Widget item;

    public RSInventoryItem(Widget item) {
        this.item = item;
    }

    public int getId() {
        return item.getItemId();
    }

    public int getQuantity() {
        return ((Widget) item).getItemQuantity();
    }

    public String getName() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getName();
        });
    }

    public String getMembersName() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getMembersName();
        });
    }

    public int getPrice() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getPrice();
        });
    }

    public int getHighAlchemyPrice() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getHaPrice();
        });
    }

    public boolean isTradeable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isTradeable();
        });
    }

    public boolean isMembers() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isMembers();
        });
    }

    public boolean isStackable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isStackable();
        });
    }

    public List<String> getInventoryActions() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return Arrays.stream(itemComposition.getInventoryActions()).filter(action -> action != null).collect(Collectors.toList());
        });
    }

    public Rectangle getBounds() {
        return item.getBounds();
    }

    public boolean drop() {
        return Alfred.api.inventory().drop(this);
    }

    public boolean leftClick() {
        Alfred.getMouse().leftClick(this.getBounds());
        return true;
    }

    public boolean rightClick() {
        Alfred.getMouse().rightClick(this.getBounds());
        return true;
    }

    public boolean interact(String action) {
        if (!rightClick()) {
            return false;
        }
        if (!Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction(action), 200, 2000)) {
            return false;
        }
        RSMenu rsMenu = Alfred.api.menu().getMenu();
        return rsMenu.clickAction(action);
    }

}
