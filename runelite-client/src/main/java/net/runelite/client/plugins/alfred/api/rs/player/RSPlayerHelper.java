package net.runelite.client.plugins.alfred.api.rs.player;

import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.List;

public class RSPlayerHelper {
    public RSPlayerHelper() {
    }

    public List<RSPlayer> getPlayers() {
        List<RSPlayer> rsPlayerList = new ArrayList<>();
        Alfred.getClient().getPlayers().forEach(player -> rsPlayerList.add(new RSPlayer(player)));
        return rsPlayerList;
    }
}
