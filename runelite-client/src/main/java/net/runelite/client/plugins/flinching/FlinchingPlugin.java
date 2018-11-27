package net.runelite.client.plugins.Flinching;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.Player;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.HitsplatApplied;
import com.google.inject.Provides;

@Slf4j
@PluginDescriptor(
        name = "Flinching",
        description = "Flinching Timer",
        tags = {"overlay", "flinching", "timers", "combat"},
        enabledByDefault = false
)
public class FlinchingPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private FlinchingConfig config;

    @Inject
    private FlinchingOverlay overlay;

    private int currentWorld = -1;

    private int currentInteractingId = -1;
    private final Map<Integer, FlinchingTarget> flinchingTargets = new HashMap<Integer, FlinchingTarget>();

    private boolean resetOnHit = true;
    private boolean resetOnHitReceived = true;

    @Provides
    FlinchingConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(FlinchingConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);

        overlay.updateConfig();
        resetOnHit = config.getFlinchResetOnHit();
        resetOnHitReceived = config.getFlinchResetOnHitReceived();

        ClearTargets();
    }

    @Override
    protected void shutDown()
    {
        ClearTargets();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (event.getGroup().equals("flinchingplugin"))
        {
            overlay.updateConfig();
            resetOnHit = config.getFlinchResetOnHit();
            resetOnHitReceived = config.getFlinchResetOnHitReceived();

            Iterator<Map.Entry<Integer, FlinchingTarget>> it = flinchingTargets.entrySet().iterator();
            while (it.hasNext())
            {
                FlinchingTarget target = it.next().getValue();
                if(target != null)
                {
                    target.SetDelayTime(config.getFlinchDelay(), config.getFlinchAttackedDelay());
                }
            }
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGGED_IN)
        {
            if (currentWorld == -1)
            {
                currentWorld = client.getWorld();
            }
            else if (currentWorld != client.getWorld())
            {
                ClearTargets();
            }
        }
    }

    private void ClearTargets()
    {
        Iterator<Map.Entry<Integer, FlinchingTarget>> it = flinchingTargets.entrySet().iterator();

        while (it.hasNext())
        {
            it.remove();
        }
    }

    @Subscribe
    private void onGameTick(GameTick tick)
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {

        }
        else
        {
            TickTargets();
            checkInteracting();
        }
    }

    @Subscribe
    public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
    {
        Actor actor = hitsplatApplied.getActor();

        if (actor instanceof NPC)
        {
            NPC hitTarget = (NPC) actor;

            int hitId = hitTarget.getId();
            if(hitId == currentInteractingId)
            {
                if (!flinchingTargets.containsKey(hitId))
                {
                    TargetGained(hitTarget);
                }
                else
                {
                    FlinchingTarget currentTarget = flinchingTargets.get(hitId);
                    if(currentTarget != null)
                    {
                        if(resetOnHit)
                        {
                            currentTarget.TargetHit();
                        }
                    }
                }
            }
        }
        else if(resetOnHitReceived && actor == client.getLocalPlayer())
        {
            PlayerHit();
        }
    }

    private void checkInteracting()
    {
        Player localPlayer = client.getLocalPlayer();
        Actor interacting = localPlayer.getInteracting();

        if (interacting instanceof NPC)
        {
            NPC newTarget = (NPC) interacting;
            currentInteractingId = newTarget.getId();

            if(newTarget.getHealth() <= 0 || newTarget.isDead())
            {
                if (flinchingTargets.containsKey(currentInteractingId))
                {
                    flinchingTargets.remove(currentInteractingId);
                    currentInteractingId = -1;
                }
            }
        }
    }

    private void TickTargets()
    {
        Iterator<Map.Entry<Integer, FlinchingTarget>> it = flinchingTargets.entrySet().iterator();

        while (it.hasNext())
        {
            FlinchingTarget target = it.next().getValue();
            if(target != null)
            {
                target.Tick();
                if(target.isActive == false)
                {
                    it.remove();
                }
            }
            else
            {
                it.remove();
            }
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned)
    {
        NPC actor = npcDespawned.getNpc();

        int actorId = actor.getId();
        if (actor.isDead() && flinchingTargets.containsKey(actorId))
        {
            TargetLost(actorId);
        }
    }

    private void TargetLost(int targetId)
    {
        flinchingTargets.remove(targetId);
    }

    private void TargetGained(NPC _newTarget)
    {
        FlinchingTarget newTarget = new FlinchingTarget(_newTarget);
        newTarget.SetDelayTime(config.getFlinchDelay(), config.getFlinchAttackedDelay());
        flinchingTargets.put(_newTarget.getId(), newTarget);
    }

    public void PlayerHit()
    {
        Iterator<Map.Entry<Integer, FlinchingTarget>> it = flinchingTargets.entrySet().iterator();
        while (it.hasNext())
        {
            FlinchingTarget target = it.next().getValue();
            if(target != null)
            {
                target.PlayerHit();
            }
        }
    }

    public Map<Integer, FlinchingTarget> GetTargets()
    {
        return(flinchingTargets);
    }
}