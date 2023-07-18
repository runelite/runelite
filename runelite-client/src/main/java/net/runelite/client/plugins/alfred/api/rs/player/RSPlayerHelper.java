package net.runelite.client.plugins.alfred.api.rs.player;

import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.List;

public class RSPlayerHelper {
    public RSPlayerHelper() {
    }

    private List<RSPlayer> internalGetPlayers() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            List<RSPlayer> rsPlayerList = new ArrayList<>();
            Alfred.getClient().getPlayers().forEach(player -> rsPlayerList.add(new RSPlayer(player)));
            return rsPlayerList;
        });
    }

    public List<RSPlayer> getPlayers() {
        return internalGetPlayers();
    }

    public RSPlayer getPlayerByName(String name) {
        return internalGetPlayers().stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }

    public RSPlayer getLocalPlayer() {
        return new RSPlayer(Alfred.getClient().getLocalPlayer());
    }
}
