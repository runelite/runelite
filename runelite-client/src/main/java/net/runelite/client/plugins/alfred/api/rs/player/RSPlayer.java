package net.runelite.client.plugins.alfred.api.rs.player;


import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSPlayer {

    private final Player runelitePlayer;

    public RSPlayer(Player player) {
        this.runelitePlayer = player;
    }

    public String getName() {
        return runelitePlayer.getName();
    }

    public WorldPoint getWorldLocation() {
        return runelitePlayer.getWorldLocation();
    }

    public WorldArea getWorldArea() {
        return runelitePlayer.getWorldArea();
    }

    public Rectangle getClickBox() {
        return runelitePlayer.getConvexHull().getBounds();
    }

    public Shape getConvexHull() {
        return runelitePlayer.getConvexHull();
    }


    public boolean isWalking() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() != 813 && runelitePlayer.getPoseAnimation() != 808);
    }

    public boolean isAnimating() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getAnimation() != -1);
    }

    public boolean isInteracting() {
        return Alfred.getClientThread().invokeOnClientThread(runelitePlayer::isInteracting);
    }

    public boolean isRunningActive() {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getVarpValue(173) == 1);
    }

    public boolean isQuickPrayerActive() {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getVarbitValue(Varbits.QUICK_PRAYER) == 1);
    }

    public boolean isXpDisplayActive() {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getVarbitValue(4702) == 1);
    }

    public void toggleRunning(boolean value) {
        boolean isRunning = isRunningActive();
        if (value != isRunning) {
            Alfred.api.tabs().clickTab(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB);
        }
    }

    public void toggleQuickPrayer(boolean value) {
        boolean isOn = isQuickPrayerActive();
        if (value != isOn) {
            Alfred.api.tabs().clickTab(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB);
        }
    }

    public void toggleXpDisplay(boolean value) {
        boolean isOn = isXpDisplayActive();
        if (value != isOn) {
            Alfred.api.tabs().clickTab(WidgetInfo.MINIMAP_XP_ORB);
        }
    }

//    public int getHealth() {
//    }

}
