package net.runelite.client.plugins.nightmare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class NightmarePrayerInfoBox extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private final Client client;
	private final NightmarePlugin plugin;
	private final NightmareConfig config;
	private final SpriteManager spriteManager;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private NightmarePrayerInfoBox(final Client client, final NightmarePlugin plugin, final SpriteManager spriteManager, final NightmareConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.spriteManager = spriteManager;
		this.config = config;

		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
	}

	public Dimension render(Graphics2D graphics)
	{
		imagePanelComponent.getChildren().clear();

		if (!plugin.isInFight() || plugin.getNm() == null)
		{
			return null;
		}

		NightmareAttack attack = plugin.getPendingNightmareAttack();

		if (attack == null)
		{
			return null;
		}

		if (!config.prayerHelper().showInfoBox())
		{
			return null;
		}

		BufferedImage prayerImage;
		prayerImage = getPrayerImage(attack);
		imagePanelComponent.setBackgroundColor(client.isPrayerActive(attack.getPrayer()) ? ComponentConstants.STANDARD_BACKGROUND_COLOR : NOT_ACTIVATED_BACKGROUND_COLOR);

		imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
		return imagePanelComponent.render(graphics);
	}

	private BufferedImage getPrayerImage(NightmareAttack attack)
	{
		return spriteManager.getSprite(attack.getPrayerSpriteId(), 0);
	}
}
