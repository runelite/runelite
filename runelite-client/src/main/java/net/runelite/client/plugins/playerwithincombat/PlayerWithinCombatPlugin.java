package net.runelite.client.plugins.playerwithincombat;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
@PluginDescriptor(
        name = "Player Within Combat finder",
        enabledByDefault = false,
        description = "Shows a infobox on players within combat level",
        tags = {"willem", "pvp","wilderness","player","combat","finder"}
)
public class PlayerWithinCombatPlugin extends Plugin {
    @Inject
    private Client client;
    @Inject
    private OverlayManager overlayManager;
    @Getter(AccessLevel.PACKAGE)
    private List<Player> players = new ArrayList<>();
    @Inject
    private PlayerWithinCombatOverlay playerWithinCombatOverlay;
    @Inject
    private PlayerWithinCombatInfoBox infoBox;

    @Override
    protected void startUp() throws Exception{
        overlayManager.add(playerWithinCombatOverlay);
        overlayManager.add(infoBox);
    }
    @Override
    protected void shutDown() throws Exception{
        overlayManager.remove(playerWithinCombatOverlay);
        overlayManager.remove(infoBox);
        players.clear();
    }
    @Subscribe
    public void onClientTick(ClientTick clientTick){

    }
    @Subscribe
    public void onPlayerSpawned(PlayerSpawned playerSpawned){
        final Player spawnedplayer = playerSpawned.getPlayer();
        if(spawnedplayer != null && spawnedplayer != client.getLocalPlayer()){
            players.add(spawnedplayer);
        }
    }
    @Subscribe
    public void onPlayerDespawned(PlayerDespawned playerDespawned){
        final Player despawn = playerDespawned.getPlayer();
        if(despawn != null){
            players.remove(despawn);
        }
    }
    public int getPlayerLocation(){
        Locations locations = Locations.forPlayerLocation(client);
        int ret = -1;
        if(locations != null) {
            ret = locations.getid();
        }
        return ret;
    }
}
