package net.runelite.client.plugins.playerinfo;

import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.awt.image.BufferedImage;

import static net.runelite.client.plugins.playerinfo.PlayerInfoCustomIndicator.*;

@PluginDescriptor(
        name = "Player Information",
        description = "An alternative to the Minimap Orbs",
        tags = {"combat", "overlay"},
        enabledByDefault = false
)
@Singleton
public class PlayerInfoPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private InfoBoxManager infoBoxManager;

    @Inject
    private PlayerInfoConfig config;

    @Inject
    private SpriteManager spriteManager;

    @Inject
    private SkillIconManager skillIconManager;

    @Provides
    PlayerInfoConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PlayerInfoConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        clientThread.invoke(() ->
        {
            if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal())
            {
                return false;
            }

            BufferedImage healthImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, 0);
            BufferedImage prayerImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_PRAYER_ICON, 0);
            BufferedImage energyImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_RUN_ICON, 0);
            BufferedImage combatImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_SPECIAL_ICON, 0);

            infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(healthImg, this, config, client, IndicatorType.HEALTH));
            infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(prayerImg, this, config, client, IndicatorType.PRAYER));
            infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(energyImg, this, config, client, IndicatorType.ENERGY));
            infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(combatImg, this, config, client, IndicatorType.SPECIAL));

            return true;
        });
    }

    @Override
    protected void shutDown() throws Exception
    {
        infoBoxManager.removeIf(i -> i instanceof PlayerInfoCustomIndicator);
    }
}
