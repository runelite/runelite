package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;


@PluginDescriptor(
        name = "Vorkath Counter",
        description = "Counts the number of Vorkath attacks",
        tags = {"combat", "boss", "vorkath", "loudpacks"}
)

public class VorkathPlugin extends Plugin {

    @Getter
    private int attackCount = 0;
    @Getter
    private int animationID = -1;
    @Getter
    private int projectileID = -1;

    private int cachedAnimationID = -1;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private VorkathOverlay overlay;

    @Override
    protected void startUp() throws Exception {
        reset();
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        reset();
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event) {
        try {
            Actor actor = event.getActor();
            if (actor != null && actor instanceof NPC && ((NPC) actor).getName().toLowerCase().contains("vorkath")) {
                animationID = actor.getAnimation();
                if(animationID == 7960 || animationID == 7952) {
                    attackCount++;
                }
                if(cachedAnimationID == 7957 && animationID == -1)
                    attackCount = 0;
                cachedAnimationID = (animationID != -1) ? animationID : cachedAnimationID;
            }
        } catch (Exception e) {

        }
    }


    @Subscribe
    public void onProjectile(ProjectileMoved event) {
        Projectile projectile = event.getProjectile();
        int projectileId = projectile.getId();

        projectileID = projectileId;

        if (client.getGameCycle() >= projectile.getStartMovementCycle()) {
            return;
        }

    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned) {
        try {
            NPC actor = npcSpawned.getNpc();
            if (actor != null && actor.getName().toLowerCase().contains("zombified")) {
                attackCount = 0;
            }
        } catch (Exception e) {

        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned) {
        try {
            NPC actor = npcDespawned.getNpc();
            if (actor != null && actor.getName().toLowerCase().contains("vorkath") && actor.isDead()) {
                reset();
            }
        } catch (Exception e) {

        }
    }

    @Subscribe
    public void onGameState(GameStateChanged event) {
        GameState gs = event.getGameState();
        if (gs == GameState.LOGGING_IN ||
                gs == GameState.CONNECTION_LOST ||
                gs == GameState.HOPPING) {
            reset();
        }
    }

    private void reset() {
        attackCount = 0;
        animationID = -1;
        projectileID = -1;
    }

}


