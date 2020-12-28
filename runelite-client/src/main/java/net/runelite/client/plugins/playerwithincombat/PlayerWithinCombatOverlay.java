package net.runelite.client.plugins.playerwithincombat;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class PlayerWithinCombatOverlay extends Overlay {
    private final PlayerWithinCombatPlugin plugin;
    private final Client client;
    private final PlayerWithinCombatInfoBox infoBox;

    @Inject
    public PlayerWithinCombatOverlay(PlayerWithinCombatPlugin plugin, Client client, PlayerWithinCombatInfoBox infoBox){
        setPosition(OverlayPosition.DYNAMIC);
        this.plugin = plugin;
        this.client = client;
        this.infoBox = infoBox;
    }
    @Override
    public Dimension render(Graphics2D graphics){
        if(!plugin.getPlayers().isEmpty()) {
            for (Player player : plugin.getPlayers()) {
                if(player != null) {
                    Player localplayer = client.getLocalPlayer();
                    Locations locations = Locations.forPlayerLocation(client);
                    int Wildernesslevel = locations.getid();
                    int lowest = localplayer.getCombatLevel() - Wildernesslevel;
                    int highest = localplayer.getCombatLevel() + Wildernesslevel;
                    if (highest > 126 && Wildernesslevel > 0) {
                        highest = 126;
                    }
                    if (player.getCombatLevel() >= lowest && player.getCombatLevel() <= highest && Wildernesslevel > 0) {
                        OverlayUtil.renderActorOverlay(graphics, player, player.getName(), Color.PINK);
                    } else if (player.getCombatLevel() < lowest || player.getCombatLevel() > highest && Wildernesslevel > 0) {
                        OverlayUtil.renderActorOverlay(graphics, player, player.getName(), Color.GREEN);
                    }
                }
            }
        }
        return null;
    }
}

