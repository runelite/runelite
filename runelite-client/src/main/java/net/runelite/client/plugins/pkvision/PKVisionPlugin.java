package net.runelite.client.plugins.pkvision;

import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.*;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.Text;

@PluginDescriptor(
        name = "PK Vision Plugin",
        description = "Highlight players on-screen and/or on the minimap",
        tags = {"highlight", "minimap", "overlay", "players", "pk", "helper", "vision", "bogla"},
        enabledByDefault = false
)
public class PKVisionPlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private PKVisionConfig config;

    @Inject
    private PKVisionOverlay pkVisionOverlay;

    @Inject
    private PKVisionTileOverlay pkVisionTileOverlay;

    @Inject
    private PKVisionMinimapOverlay pkVisionMinimapOverlay;

    @Inject
    private Client client;

    @Provides
    PKVisionConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PKVisionConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(pkVisionOverlay);
        overlayManager.add(pkVisionTileOverlay);
        overlayManager.add(pkVisionMinimapOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(pkVisionOverlay);
        overlayManager.remove(pkVisionTileOverlay);
        overlayManager.remove(pkVisionMinimapOverlay);
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
    {
        int type = menuEntryAdded.getType();
        String option = Text.removeTags(menuEntryAdded.getOption()).toLowerCase();

        if (type >= 2000)
            type -= 2000;

        int identifier = menuEntryAdded.getIdentifier();
        if (type == FOLLOW.getId() || type == TRADE.getId()
                || type == ITEM_USE_ON_PLAYER.getId() || type == PLAYER_FIRST_OPTION.getId()
                || type == PLAYER_SECOND_OPTION.getId() || type == PLAYER_THIRD_OPTION.getId()
                || type == PLAYER_FOURTH_OPTION.getId() || type == PLAYER_FIFTH_OPTION.getId()
                || type == PLAYER_SIXTH_OPTION.getId() || type == PLAYER_SEVENTH_OPTION.getId()
                || type == PLAYER_EIGTH_OPTION.getId() || type == SPELL_CAST_ON_PLAYER.getId()
                || type == RUNELITE.getId())
        {
            final Player localPlayer = client.getLocalPlayer();
            Player[] players = client.getCachedPlayers();
            Player player = null;

            if (identifier >= 0 && identifier < players.length)
                player = players[identifier];

            if (player == null)
                return;

            Color color = null;

            if (config.highlightFriends() && (player.isFriend() || player.isClanMember()))
            {
                color = config.getFriendColor();
            }
            else if (!player.isFriend() && !player.isClanMember())
            {
                int lvlDelta =  player.getCombatLevel() - localPlayer.getCombatLevel();
                int wildyLvl = MiscUtils.getWildernessLevelFrom(client, player.getWorldLocation());

                if (wildyLvl <= 0)
                    return;

                int R = MiscUtils.clamp((int)(((float)(lvlDelta + wildyLvl) / (float)(wildyLvl * 2)) * 255.f), 0, 255);
                int G = MiscUtils.clamp(255 - R, 0, 255);

                if (Math.abs(lvlDelta) <= wildyLvl)
                    color = Color.getHSBColor(Color.RGBtoHSB(R, G, 0, null)[0], 1.f, 1.f);
            }

            if (color != null)
            {
                MenuEntry[] menuEntries = client.getMenuEntries();
                MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

                // strip out existing <col...
                String target = lastEntry.getTarget();
                int idx = target.indexOf('>');
                if (idx != -1)
                    target = target.substring(idx + 1);

                lastEntry.setTarget(ColorUtil.prependColorTag(target, color));


                client.setMenuEntries(menuEntries);
            }
        }
    }
}
