package net.runelite.client.plugins.alfred.api.rs.item;

import net.runelite.api.ItemComposition;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

import java.util.ArrayList;
import java.util.List;

public class RSGroundItem {

    private final TileItem tileItem;
    private final Tile tile;

    public RSGroundItem(TileItem item, Tile tile) {
        this.tileItem = item;
        this.tile = tile;
    }

    public int getId() {
        return tileItem.getId();
    }

    public int getQuantity() {
        return tileItem.getQuantity();
    }

    public WorldPoint getWorldLocation() {
        return tile.getWorldLocation();
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

    public boolean leftClick() {
        LocalPoint localPoint = tile.getLocalLocation();
        int plane = tile.getPlane();

        if (Alfred.api.screen().isPointOnScreen(localPoint, plane)) {
            Point screenPoint = Alfred.api.screen().getLocalPointToScreenPoint(localPoint, plane);
            Alfred.getMouse().leftClick(screenPoint);
            return true;
        }

        return false;
    }

    public boolean rightClick() {
        LocalPoint localPoint = tile.getLocalLocation();
        int plane = tile.getPlane();

        if (Alfred.api.screen().isPointOnScreen(localPoint, plane)) {
            Point screenPoint = Alfred.api.screen().getLocalPointToScreenPoint(localPoint, plane);
            Alfred.getMouse().rightClick(screenPoint);
            return true;
        }

        return false;
    }

    public boolean clickAction(String action) {
        Alfred.setStatus("Clicking " + action + " on " + getName());

        if (!rightClick()) {
            return false;
        }

        Alfred.sleep(200, 400);
        RSMenu rsMenu = Alfred.api.menu().getMenu();

        if (rsMenu == null) {
            return false;
        }

        return rsMenu.clickAction(action, getName());
    }
}
