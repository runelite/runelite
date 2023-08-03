package net.runelite.client.plugins.alfred.api.rs.player;


import net.runelite.api.Player;
import net.runelite.api.PlayerComposition;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSPlayer {
    private int ANIMATION_IDLE = 808;
    private int ANIMATION_WALKING = 819;
    private int ANIMATION_RUNNING = 824;
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

    public int getRunEnergy() {
        return Alfred.getClient().getEnergy() / 100;
    }

    public boolean isWalking() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() != ANIMATION_WALKING);
    }

    public boolean isRunning() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() == ANIMATION_RUNNING);
    }

    public boolean isIdle() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() == 813 || runelitePlayer.getPoseAnimation() == ANIMATION_IDLE);
    }

    public boolean isMoving() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() == ANIMATION_WALKING || runelitePlayer.getPoseAnimation() == ANIMATION_RUNNING);
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
            Alfred.api.widgets().leftClickWidget(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB);
        }
    }

    public void toggleQuickPrayer(boolean value) {
        boolean isOn = isQuickPrayerActive();
        if (value != isOn) {
            Alfred.api.widgets().leftClickWidget(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB);
        }
    }

    public void toggleXpDisplay(boolean value) {
        boolean isOn = isXpDisplayActive();
        if (value != isOn) {
            Alfred.api.widgets().leftClickWidget(WidgetInfo.MINIMAP_XP_ORB);
        }
    }

    public int getSkillLevel(Skill skill) {
        return Alfred.getClient().getRealSkillLevel(skill);
    }

//    public int getHealth() {
//    }

}
