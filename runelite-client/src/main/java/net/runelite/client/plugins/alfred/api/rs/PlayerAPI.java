package net.runelite.client.plugins.alfred.api.rs;


import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.device.Mouse;

public class PlayerAPI {

    private final Client client = Alfred.getClient();
    private final Mouse mouse = Alfred.getMouse();

    private final Player runelitePlayer;

    public PlayerAPI(Player player) {
        this.runelitePlayer = player;
    }


    public boolean isWalking() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getPoseAnimation() != 813 && runelitePlayer.getPoseAnimation() != 808);
    }

    public boolean isAnimating() {
        return Alfred.getClientThread().invokeOnClientThread(() -> runelitePlayer.getAnimation() != -1);
    }

}
