package net.runelite.client.plugins.hptray;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.SessionClose;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.OSType;
import net.runelite.client.util.SwingUtil;

@PluginDescriptor(
	name = "HP Tray Icon",
	description = "Shows current HP on the system tray",
	tags = {"combat", "hp", "tray", "notifier"}
)
@Slf4j
public class HpTrayIconPlugin extends Plugin
{
	private static final Color REMAINING_HEALTH_COLOR = new Color(0, 220, 0);
	private static final Color MISSING_HEALTH_COLOR = new Color(255, 0, 0);
	private static final Color TEXT_COLOR = new Color(0, 0, 0);
	private static final Font HP_FONT = FontManager.getRunescapeBoldFont().deriveFont(32f);

	private static final int MAC_HEIGHT_OFFSET = 4;
	private static final int HEIGHT = 42;
	private static final int WIDTH = 42;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUI;

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);

		// Ceiling needed here so that any missing health will lower the bar
		final int scaledMissingHealth = (int) Math.ceil((Math.max(maxHealth - currentHealth, 0) * HEIGHT * 1.0) / currentHealth);


		final BufferedImage hpImage = new BufferedImage(WIDTH, HEIGHT + getOffset(), BufferedImage.TYPE_4BYTE_ABGR);
		final Graphics2D g = hpImage.createGraphics();
		g.setFont(HP_FONT);
		g.setBackground(REMAINING_HEALTH_COLOR);

		g.clearRect(0, getOffset(), WIDTH, HEIGHT);

		g.setColor(MISSING_HEALTH_COLOR);
		g.fillRect(0, getOffset(), WIDTH, scaledMissingHealth);

		g.setColor(TEXT_COLOR);
		g.drawString(String.valueOf(currentHealth), 2, 34 + getOffset());

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

	private void resetTrayIcon() {
		clientUI.getTrayIcon().setImage(ClientUI.ICON);

	}

	private int getOffset() {
		return OSType.getOSType() == OSType.MacOS ? MAC_HEIGHT_OFFSET : 0;
	}
}
