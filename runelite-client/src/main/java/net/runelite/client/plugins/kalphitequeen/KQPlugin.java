package net.runelite.client.plugins.kalphitequeen;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
        name = "Kalphite Queen",
        enabledByDefault = false,
        description = "Kalphite Queen plugin.",
        tags = {"kalphite", "queen", "kq", "willem", "fun", "Willem", "fun"}
)
@Singleton
public class KQPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private KQSceneOverlay sceneOverlay;

    @Getter
    private KQNpc kalphiteQueen;

    @Getter
    @Setter
    private boolean flashVeng;

    private int lastVengActive;
    private int lastVengCooldown;

    @Provides
    KQConfig getConfig(final ConfigManager configManager)
    {
        return configManager.getConfig(KQConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(sceneOverlay);

        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        for (final NPC npc : client.getNpcs())
        {
            addNpc(npc);
        }
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(sceneOverlay);

        flashVeng = false;
        lastVengActive = 0;
        lastVengCooldown = 0;

        kalphiteQueen = null;
    }

    @Subscribe
    private void onConfigChanged(final ConfigChanged event)
    {
        if (!event.getGroup().equals("kalphitequeen"))
        {
            return;
        }
    }

    @Subscribe
    private void onGameTick(final GameTick event)
    {
        if (kalphiteQueen != null)
        {
            kalphiteQueen.updateTicksUntilNextAnimation();
        }
    }

    @Subscribe
    private void onVarbitChanged(final VarbitChanged event)
    {
        final int vengCoolDown = client.getVar(Varbits.VENGEANCE_COOLDOWN);
        final int vengActive = client.getVar(Varbits.VENGEANCE_ACTIVE);

        if (lastVengCooldown != vengCoolDown)
        {
            if (vengCoolDown == 0 && vengActive == 0)
            {
                flashVeng = true;
            }

            lastVengCooldown = vengCoolDown;
        }

        if (lastVengActive != vengActive)
        {
            if (vengActive == 0 && vengCoolDown == 0)
            {
                flashVeng = true;
            }

            lastVengActive = vengActive;
        }
    }

    @Subscribe
    private void onNpcSpawned(final NpcSpawned event)
    {
        final NPC npc = event.getNpc();

        addNpc(npc);
    }

    @Subscribe
    private void onNpcDespawned(final NpcDespawned event)
    {
        final NPC npc = event.getNpc();

        removeNpc(npc);
    }

    private void addNpc(final NPC npc)
    {
        if (KQNpc.NPC_IDS.contains(npc.getId()))
        {
            kalphiteQueen = new KQNpc(npc);
        }
    }

    private void removeNpc(final NPC npc)
    {
        if (KQNpc.NPC_IDS.contains(npc.getId()))
        {
            kalphiteQueen = null;
        }
    }
}