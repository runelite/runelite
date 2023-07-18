package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.ItemComposition;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RSInvetoryItem {

    private final Widget item;

    public RSInvetoryItem(Widget item) {
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
            List<String> actions = new ArrayList<>();
            for (String action : itemComposition.getInventoryActions()) {
                if (action != null) {
                    actions.add(action);
                }
            }
            return actions;
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

    public boolean clickAction(String action) {
        if (!rightClick()) {
            return false;
        }
        Alfred.sleep(200, 600);
        return Alfred.api.inventory().clickAction(action);
    }

}
