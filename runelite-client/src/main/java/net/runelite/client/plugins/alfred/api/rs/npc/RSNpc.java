package net.runelite.client.plugins.alfred.api.rs.npc;

import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RSNpc {

    private final NPC npc;

    public RSNpc(NPC npc) {
        this.npc = npc;
    }

    public int getId() {
        return npc.getId();
    }

    public String getName() {
        return npc.getName();
    }

    public LocalPoint getLocalLocation() {
        return npc.getLocalLocation();
    }

    public WorldPoint getWorldLocation() {
        return npc.getWorldLocation();
    }

    public WorldArea getWorldArea() {
        return npc.getWorldArea();
    }

    public Shape getConvexHull() {
        return npc.getConvexHull();
    }

    public Rectangle getClickBox() {
        return npc.getConvexHull().getBounds();
    }

    public List<String> getActions() {
        List<String> actions = new ArrayList<>();

        for (String action : npc.getComposition().getActions()) {
            if (action != null) {
                actions.add(action);
            }
        }

        return actions;
    }

    public boolean hasAction(String action) {
        return getActions().contains(action);
    }

    public int getCombatLevel() {
        return npc.getCombatLevel();
    }

    public boolean isAnimating() {
        return npc.getAnimation() != -1;
    }

    public boolean isVisible() {
        return npc.getComposition().isVisible();
    }

    public boolean isClickable() {
        return npc.getComposition().isClickable();
    }

    public boolean isDead() {
        return npc.isDead();
    }

    public boolean isInteracting() {
        return npc.isInteracting();
    }

    public boolean attack() {
        if (npc.isInteracting() || npc.isDead()) {
            return false;
        }

        Rectangle clickBox = getClickBox();
        if (clickBox == null) {
            return false;
        }

        Alfred.getMouse().leftClick(clickBox);
        return Alfred.sleepUntil(() -> {
            Actor interactingActor = npc.getInteracting();
            if (interactingActor == null) {
                return false;
            }

            if (interactingActor.getName() != null) {
                return interactingActor.getName().equals(Alfred.getClient().getLocalPlayer().getName());
            }

            return false;
        }, 100, 3000);
    }

    public boolean interact(String action) {
        Alfred.setStatus("Interacting with " + getName());

        if (!getActions().contains(action)) {
            return false;
        }

        Rectangle clickBox = getClickBox();
        if (clickBox == null) {
            return false;
        }

        Alfred.getMouse().rightClick(clickBox);
        Alfred.sleep(200, 600);

        RSMenu menu = Alfred.api.menu().getMenu();
        return menu.clickAction(action);
    }

}

