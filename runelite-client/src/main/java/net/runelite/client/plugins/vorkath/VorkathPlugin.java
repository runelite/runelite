package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.*;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.demonicgorilla.DemonicGorilla;
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

    private static final int POISON_PHASE = 1;
    private static final int SPIDER_PHASE = 2;

    private static final int VORKATH_ID = 8059;
    private static final int VORKATH_ATTACK_TIOKS = 5;

    private Projectile currentProjectile;
    private LocalPoint currentProjectileLocation = null;

    @Getter(AccessLevel.PACKAGE)
    private int attacksInARow = 0;
    @Getter(AccessLevel.PACKAGE)
    private int nextPhase = -1;

    private boolean stall = false;
    private int ticks;

    private int mapRegionId = 0;

    @Getter(AccessLevel.PACKAGE)
    private boolean atVorkath = false;

    private NPC vorkath = null;

    @Subscribe
    public void onGameTick(GameTick event) {

        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        if (!atVorkath)
            return;

        if (stall) {
            if (client.getTickCount() >= ticks)
                stall = false;
        }

        currentPlayerLocation = client.getLocalPlayer().getLocalLocation();
    }

    @Subscribe
    public void onRegionChanged(MapRegionChanged event) {
        if (client.isInInstancedRegion()) {
            atVorkath = true;
            mapRegionId = client.getLocalPlayer().getWorldLocation().getRegionID();
        } else
            onLeaveInstance();
    }

    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned event)
    {
        GameObject gameObject = event.getGameObject();
        if (gameObject.getId() == 4525)
            onLeaveInstance();
    }

    @Subscribe
    public void onProjectile(ProjectileMoved event) {
        if (stall)
            return;

        currentProjectile = event.getProjectile();
        currentProjectileLocation = event.getPosition();


        if (currentProjectile.getId() == ProjectileID.VORKATH_SPAWN_AOE) {
            stall = true;
            ticks = client.getTickCount() + 3;
        }

        if (currentProjectile.getId() == ProjectileID.VORKATH_FREEZE) {
            attacksInARow = 0;
            nextPhase = POISON_PHASE;
        } else if (currentProjectile.getId() == ProjectileID.VORKATH_POISON_POOL_AOE) {
            attacksInARow = 0;
            nextPhase = SPIDER_PHASE;
        } else if (currentProjectile.getId() == ProjectileID.VORKATH_TICK_FIRE_AOE || currentProjectile.getId() == ProjectileID.VORKATH_SPAWN_AOE) {

        } else {
            if (client.getGameCycle() == currentProjectile.getStartMovementCycle())
                attacksInARow++;
        }
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event) {
        NPC npc = event.getNpc();
        if (npc.getId() == VORKATH_ID)
            vorkath = npc;
    }

    private void reset() {
        vorkath = null;
        attacksInARow = 0;
        nextPhase = -1;
        mapRegionId = 0;
        stall = false;
        atVorkath = false;
    }

    private void onLeaveInstance() {
        reset();
    }

    @Override
    public Collection<Overlay> getOverlays() {
        return Arrays.asList(vorkathOverlay);
    }

    public LocalPoint getPlayerCurrentLocation() {
        return currentPlayerLocation;
    }

    public Projectile getCurrentProjectile() {
        return currentProjectile;
    }

    public LocalPoint getCurrentProjectileLocation() {
        return currentProjectileLocation;
    }

    public int getAttacksInARow() {
        return attacksInARow;
    }

    public int getNextPhase() {
        return nextPhase;
    }
}
