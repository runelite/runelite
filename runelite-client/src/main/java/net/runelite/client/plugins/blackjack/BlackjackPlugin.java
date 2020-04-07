package net.runelite.client.plugins.blackjack;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WildcardMatcher;
import org.apache.commons.lang3.RandomUtils;

import javax.inject.Inject;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
        name = "Blackjack",
        description = "Help show whether a blackjack target is knocked out or not",
        tags = {"blackjack", "thieve", "thieving"}
)
public class BlackjackPlugin extends Plugin {
    private static final String SUCCESS_BLACKJACK = "You smack the bandit over the head and render them unconscious.";
    private static final String FAILED_BLACKJACK = "Your blow only glances off the bandit's head.";

    @Inject
    private BlackjackConfig blackjackConfig;

    @Inject
    private BlackjackOverlay blackjackOverlay;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ClientThread clientThread;

    @Inject
    private Client client;

    /**
     * NPCs to highlight
     */
    @Getter(AccessLevel.PACKAGE)
    private final Set<NPC> highlightedNpcs = new HashSet<>();

    /**
     * Stores state of if NPC is knocked out or not.
     */
    @Getter(AccessLevel.PACKAGE)
    private boolean knockedOut = false;

    private String highlight = "";
    private long nextKnockOutTick = 0;

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(blackjackOverlay);
        highlight = npcToHighlight();
        clientThread.invoke(() ->
        {
            rebuildAllNpcs();
        });
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(blackjackOverlay);
        highlightedNpcs.clear();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGIN_SCREEN ||
                event.getGameState() == GameState.HOPPING)
        {
            highlightedNpcs.clear();
        }
    }

    @Subscribe
    private void onConfigChanged(ConfigChanged event) {

        if (!event.getGroup().equals("blackjack")) {
            return;
        }

        highlight = npcToHighlight();
        rebuildAllNpcs();
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned)
    {
        final NPC npc = npcSpawned.getNpc();
        final String npcName = npc.getName();

        if (npcName == null)
        {
            return;
        }

        if (WildcardMatcher.matches(highlight, npcName))
        {
            highlightedNpcs.add(npc);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned)
    {
        final NPC npc = npcDespawned.getNpc();

        highlightedNpcs.remove(npc);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (client.getTickCount() >= nextKnockOutTick)
        {
            knockedOut = false;
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        final String msg = event.getMessage();

        if (event.getType() == ChatMessageType.SPAM && msg.equals(SUCCESS_BLACKJACK))
        {
            knockedOut = true;
            nextKnockOutTick = client.getTickCount() + 4;
        }
    }

    public Color getHighlightColor() {
        return knockedOut ? blackjackConfig.knockedOutStateColor() : blackjackConfig.awakeStateColor();
    }

    private String npcToHighlight()
    {
        switch (blackjackConfig.npcToBlackjack()) {
            case BANDIT:
                return "Bandit";
            case MENAPHITE_THUG:
                return "Menaphite Thug";
            default:
                throw new IllegalStateException("Unexpected value: " + blackjackConfig.npcToBlackjack());
        }
    }

    private void rebuildAllNpcs()
    {
        highlightedNpcs.clear();

        if (client.getGameState() != GameState.LOGGED_IN &&
                client.getGameState() != GameState.LOADING)
        {
            // NPCs are still in the client after logging out,
            // but we don't want to highlight those.
            return;
        }

        outer:
        for (NPC npc : client.getNpcs())
        {
            final String npcName = npc.getName();

            if (npcName == null)
            {
                continue;
            }

            if (WildcardMatcher.matches(highlight, npcName))
            {
                highlightedNpcs.add(npc);
                continue outer;
            }
        }
    }
}
