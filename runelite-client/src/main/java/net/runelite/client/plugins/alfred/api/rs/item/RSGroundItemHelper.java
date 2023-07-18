package net.runelite.client.plugins.alfred.api.rs.item;

import net.runelite.client.plugins.alfred.Alfred;

import java.util.List;
import java.util.stream.Collectors;

public class RSGroundItemHelper {

    public RSGroundItemHelper() {
    }

    private List<RSGroundItem> internalGetGroundItems() {
        return Alfred.api.objects().getItemsFromTiles();
    }

    public List<RSGroundItem> getItemsFromTiles(String name) {
        return internalGetGroundItems().stream().
                filter(rsGroundItem -> rsGroundItem.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int id) {
        return internalGetGroundItems().stream().
                filter(rsGroundItem -> rsGroundItem.getId() == id)
                .collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int radius, String name) {
        return internalGetGroundItems().stream()
                .filter(rsGroundItem -> rsGroundItem.getName().equalsIgnoreCase(name) && rsGroundItem.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()) <= radius)
                .collect(Collectors.toList());
    }

    public List<RSGroundItem> getItemsFromTiles(int radius, int id) {
        return internalGetGroundItems().stream()
                .filter(rsGroundItem -> rsGroundItem.getId() == id && rsGroundItem.getWorldLocation().distanceTo(Alfred.api.players().getLocalPlayer().getWorldLocation()) <= radius)
                .collect(Collectors.toList());
    }
}
