package net.runelite.client.plugins.vorkath;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Vorkath",
        description = "Count vorkath attacks, and which phase is coming next",
        tags = {"combat", "overlay", "pve", "pvm"}
)
public class VorkathPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private VorkathOverlay overlay;

    @Inject
    private ZombifiedSpawnOverlay SpawnOverlay;

    @Inject
    private ClientThread clientThread;

    @Getter
    private Vorkath vorkath;

    @Getter
    private ZombifiedSpawn spawn;


    @Override
    protected void startUp() {
        overlayManager.add(overlay);
        overlayManager.add(SpawnOverlay);
        clientThread.invoke(this::reset);
    }

    @Override
    protected void shutDown() {
        overlayManager.remove(overlay);
        overlayManager.remove(SpawnOverlay);
    }

    private void reset() {
        this.vorkath = null;
        for (NPC npc : client.getNpcs()) {
            if (isNpcVorkath(npc.getId())) {
                this.vorkath = new Vorkath(npc);
            } else if (isNpcZombifiedSpawn(npc.getId())) {
                this.spawn = new ZombifiedSpawn(npc);
            }
        }
    }

    private static boolean isNpcVorkath(int npcId) {
        return npcId == NpcID.VORKATH ||
                npcId == NpcID.VORKATH_8058 ||
                npcId == NpcID.VORKATH_8059 ||
                npcId == NpcID.VORKATH_8060 ||
                npcId == NpcID.VORKATH_8061;
    }

    private static boolean isNpcZombifiedSpawn(int id) {
        return id == NpcID.ZOMBIFIED_SPAWN || id == NpcID.ZOMBIFIED_SPAWN_8063;
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event) {
        NPC npc = event.getNpc();
        if (isNpcVorkath(npc.getId())) {
            this.vorkath = new Vorkath(npc);
        } else if (isNpcZombifiedSpawn(npc.getId())) {
            this.spawn = new ZombifiedSpawn(npc);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned) {
        final NPC npc = npcDespawned.getNpc();
        if(this.vorkath != null || this.spawn != null){
            if (npc.getId() == this.vorkath.getNpc().getId()) {
                this.vorkath = null;
            } else if (npc.getId() == this.spawn.getNpc().getId()) {
                this.spawn = null;
            }
        }
    }


    @Subscribe
    public void onGameStateChanged(GameStateChanged event) {
        GameState gs = event.getGameState();
        if (gs == GameState.LOGGING_IN ||
                gs == GameState.CONNECTION_LOST ||
                gs == GameState.HOPPING) {
            reset();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {

        if (vorkath != null) {

            int animationId = vorkath.getNpc().getAnimation();

            if (animationId != vorkath.getLastTickAnimation()) {

                if (animationId == AnimationID.VORKATH_ACID_ATTACK) {

                    vorkath.setPhase(2);
                    vorkath.setAttacksUntilSwitch(Vorkath.ATTACKS_PER_SWITCH);

                } else if (animationId == AnimationID.VORKATH_ATTACK && vorkath.getAttacksUntilSwitch() == 0) {

                    vorkath.setPhase(1);
                    vorkath.setAttacksUntilSwitch(Vorkath.ATTACKS_PER_SWITCH);
                    //Vorkath does a bomb animation after the ice dragon breathe, we need to account for it
                    vorkath.setIcePhaseAttack(true);

                } else if (animationId == AnimationID.VORKATH_ATTACK || animationId == AnimationID.VORKATH_FIRE_BOMB_ATTACK) {

                    if (vorkath.isIcePhaseAttack()) {
                        vorkath.setIcePhaseAttack(false);
                    } else {
                        vorkath.setAttacksUntilSwitch(vorkath.getAttacksUntilSwitch() - 1);
                    }

                }

            }

            vorkath.setLastTickAnimation(animationId);
        }
    }
}
