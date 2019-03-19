package net.runelite.client.plugins.statustrayicon;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.OSType;

@PluginDescriptor(
	name = "Status Tray Icon",
	description = "Shows current Hitpoints and Prayer on the system tray",
	tags = {"combat", "hp", "prayer", "tray", "notifier", "status"},
	enabledByDefault = false
)
@Slf4j
public class StatusTrayIconPlugin extends Plugin
{
	private static final Color REMAINING_HEALTH_COLOR = new Color(0, 220, 0);
	private static final Color MISSING_HEALTH_COLOR = new Color(255, 0, 0);
	private static final Color REMAINING_PRAYER_COLOR = new Color(57, 255, 186);
	private static final Color MISSING_PRAYER_COLOR = new Color(28, 128, 93);
	private static final Color TEXT_COLOR = Color.BLACK;
	private static final Font STATUS_FONT = FontManager.getRunescapeBoldFont().deriveFont(32f);
	private static final Font STATUS_FONT_SMALL = FontManager.getRunescapeBoldFont().deriveFont(24f);

	private static final int HEIGHT = 42;
	private static final int WIDTH = 42;
	private static final int HALF_WIDTH = WIDTH / 2;
	private static final int MAC_HEIGHT_OFFSET = 4;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUI;

	@Inject
	private StatusTrayIconConfig config;

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !(config.showHitpoints() || config.showPrayer()))
		{
			return;
		}

		final int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int scaledMissingHealth = (int) Math.ceil((Math.max(maxHealth - currentHealth, 0) * HEIGHT * 1.0) / maxHealth);

		final int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int scaledMissingPrayer = (int) Math.ceil((Math.max(maxPrayer - currentPrayer, 0) * HEIGHT * 1.0) / maxPrayer);

		final BufferedImage hpImage = new BufferedImage(WIDTH, HEIGHT + getYOffset(), BufferedImage.TYPE_4BYTE_ABGR);
		final Graphics2D g = hpImage.createGraphics();

		if (config.showHitpoints())
		{
			g.setColor(REMAINING_HEALTH_COLOR);
			g.fillRect(0, getYOffset(), config.showPrayer() ? HALF_WIDTH : WIDTH, HEIGHT);

			g.setColor(MISSING_HEALTH_COLOR);
			g.fillRect(0, getYOffset(), config.showPrayer() ? HALF_WIDTH : WIDTH, scaledMissingHealth);
		}

		if (config.showPrayer())
		{
			g.setColor(REMAINING_PRAYER_COLOR);

			int prayerX = config.showHitpoints() ? HALF_WIDTH : 0;
			int prayerWidth = config.showHitpoints() ? HALF_WIDTH : WIDTH;

			g.fillRect(prayerX, getYOffset(), prayerWidth, HEIGHT);

			g.setColor(MISSING_PRAYER_COLOR);
			g.fillRect(prayerX, getYOffset(), prayerWidth, scaledMissingPrayer);
		}

		if (config.numberToDisplay() !=  StatusNumberMode.NONE) {
			int numberToDisplay = config.numberToDisplay() == StatusNumberMode.HITPOINTS ? currentHealth : currentPrayer;
			g.setFont(numberToDisplay < 100 ? STATUS_FONT : STATUS_FONT_SMALL);
			g.setColor(TEXT_COLOR);
			int numberDrawY = (numberToDisplay < 100 ? 34 : 30) +  getYOffset();
			g.drawString(String.valueOf(numberToDisplay), 2, numberDrawY);
		}

		g.dispose();

		clientUI.getTrayIcon().setImage(hpImage);
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			resetTrayIcon();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		resetTrayIcon();
	}

	@Provides
	StatusTrayIconConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusTrayIconConfig.class);
	}

	private void resetTrayIcon() {
		clientUI.getTrayIcon().setImage(ClientUI.ICON);

	}

	private int getYOffset() {
		return OSType.getOSType() == OSType.MacOS ? MAC_HEIGHT_OFFSET : 0;
	}
}
