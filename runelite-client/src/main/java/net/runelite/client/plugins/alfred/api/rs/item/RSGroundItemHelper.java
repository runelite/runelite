package net.runelite.client.plugins.alfred.api.rs.item;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RSGroundItemHelper {

    public RSGroundItemHelper() {
    }

    private List<RSGroundItem> internalGetGroundItems() {
        return Alfred.api.objects().getItemsFromTiles();
    }

    public List<RSGroundItem> getItemsFromTiles(String name) {
        return internalGetGroundItems().stream().filter(rsGroundItem -> rsGroundItem.getName().strip().equalsIgnoreCase(name.strip())).collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int id) {
        return internalGetGroundItems().stream().filter(rsGroundItem -> rsGroundItem.getId() == id).collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int radius, String name) {
        return getItemsFromTiles(name).stream().filter(rsGroundItem -> rsGroundItem.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()) <= radius).collect(Collectors.toList());
//        return items.stream().filter(rsGroundItem -> rsGroundItem.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()) <= radius).sorted(Comparator.comparingInt(item -> item.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()))).collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int radius, int id) {
        return internalGetGroundItems().stream().filter(rsGroundItem -> rsGroundItem.getId() == id && rsGroundItem.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()) <= radius).sorted(Comparator.comparingInt(item -> item.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()))).collect(Collectors.toList());
    }

    public boolean isItemOnGround(int id, WorldPoint worldPoint) {
        return internalGetGroundItems().stream().anyMatch(rsGroundItem -> rsGroundItem.getId() == id && rsGroundItem.getWorldLocation().equals(worldPoint));
    }
}
