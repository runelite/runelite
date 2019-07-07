package net.runelite.client.plugins.customdevtool;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;

import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;

import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.NPCManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatcher;

@PluginDescriptor(
        name = "Custom Dev Tool",
        description = "Gets various IDs from the game for use in development"
)
@Slf4j
public class CustomDevToolPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private CustomDevToolConfig config;

    @Inject
    private CustomDevToolOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private KeyManager keyManager;

    @Inject
    private ClientThread clientThread;

    @Setter(AccessLevel.PACKAGE)
    private boolean hotKeyPressed = false;

    public int animationID;
    public int graphicID;
    public int tickCount = 0;
    public int targetAnimation = 0;
    public int targetID = 0;
    public Integer test;
    private Graphics2D g;

    @Provides
    CustomDevToolConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(CustomDevToolConfig.class);
    }

    @Override
    public void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    public void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        tickCount++;
        animationID = client.getLocalPlayer().getAnimation();
        if (isInCombat()){
            //we know it is an npc or else we wouldnt be in this fn
            Player local = client.getLocalPlayer();
            Actor target = local.getInteracting();
            final NPC npc = (NPC) target;
            targetAnimation = npc.getAnimation();
            targetID = npc.getId();
        }
        else{targetAnimation = -1;
        targetID = -1;
        }

    }

    private boolean isInCombat(){
        //boolean inCombat;
        Player local = client.getLocalPlayer();
        Actor target = local.getInteracting();
        final boolean isNpc = target instanceof NPC;
        if (!isNpc)
        {
            System.out.println("not in combat");
            return false;
        }
        final NPC npc = (NPC) target;
        final NPCComposition npcComposition = npc.getComposition();
        final List<String> npcMenuActions = Arrays.asList(npcComposition.getActions());
        if (npcMenuActions.contains("Attack"))
        {
            System.out.println("in combat");
            return true;
        }
        return false;
    }

}
