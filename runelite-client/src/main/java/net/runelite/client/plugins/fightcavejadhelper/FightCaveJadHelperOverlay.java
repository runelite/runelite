package net.runelite.client.plugins.fightcavejadhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class FightCaveJadHelperOverlay extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

	private final Client client;
	private final FightCaveJadHelperPlugin plugin;
	private final SpriteManager spriteManager;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private FightCaveJadHelperOverlay(Client client, FightCaveJadHelperPlugin plugin, SpriteManager spriteManager)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.plugin = plugin;
		this.spriteManager = spriteManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final JadAttack attack = plugin.getAttack();

		if (attack == null)
		{
			return null;
		}

		final BufferedImage prayerImage = getPrayerImage(attack);

		imagePanelComponent.getChildren().clear();
		imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
		imagePanelComponent.setBackgroundColor(client.isPrayerActive(attack.getPrayer())
			? ComponentConstants.STANDARD_BACKGROUND_COLOR
			: NOT_ACTIVATED_BACKGROUND_COLOR);

		return imagePanelComponent.render(graphics);
	}

	private BufferedImage getPrayerImage(JadAttack attack)
	{
		final int prayerSpriteID = attack == JadAttack.MAGIC ? SpriteID.PRAYER_PROTECT_FROM_MAGIC : SpriteID.PRAYER_PROTECT_FROM_MISSILES;
		return spriteManager.getSprite(prayerSpriteID, 0);
	}
}