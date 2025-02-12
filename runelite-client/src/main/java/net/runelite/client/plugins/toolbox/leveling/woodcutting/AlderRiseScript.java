package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

enum State {
    RESETTING,
    WOODCUTTING,
    BANKING,
    MOVING
}

public class AlderRiseScript {

    private static final Map<String, Integer> treeObjectIds =  new HashMap<>();

    static {
        // Populate the map with tree names and their corresponding object IDs
        treeObjectIds.put("Tree", 1278);  // Example ID, replace with actual Regular Tree ID
        treeObjectIds.put("Oak Tree", 10820);  // Example ID, replace with actual Oak Tree ID

        //treeObjectIds.put("Maple Tree", 300);  // Example ID, replace with actual Maple Tree ID
        //treeObjectIds.put("Yew Tree", 400);  // Example ID, replace with actual Yew Tree ID
        //treeObjectIds.put("Magic Tree", 500);  // Example ID, replace with actual Magic Tree ID
    }


    // Checks if a given GraphicsObject is a tree
    public boolean isTree(GameObject gameObject, String treeName) {
        // For simplicity, assume each tree object has a specific ID or model ID
        int objectId = gameObject.getId();
        // Here you would match the objectId against tree object IDs (e.g., Oak Tree, Maple Tree)

        int treeId =  treeObjectIds.get(treeName);

        if (objectId == treeId) {
            return true;  // It's a tree!
        }

        return false;  // Not a tree
    }
}
