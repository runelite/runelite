package net.runelite.client.plugins.vorkath;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.fightcave.JadAttack;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(name = "Vorkath")
@Singleton
public class VorkathPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private VorkathOverlay vorkathOverlay;

    @Getter
    private Player player;

    private LocalPoint currentPlayerLocation;

    @Schedule(
            period = 600,
            unit = ChronoUnit.MILLIS
    )
    public void update() {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }
        currentPlayerLocation = client.getLocalPlayer().getLocalLocation();
    }

    @Override
    public Collection<Overlay> getOverlays()
    {
        return Arrays.asList(vorkathOverlay);
    }

    public LocalPoint getPlayerCurrentLocation() {
        return currentPlayerLocation;
    }
}
