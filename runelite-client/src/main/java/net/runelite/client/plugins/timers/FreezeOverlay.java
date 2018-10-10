package net.runelite.client.plugins.timers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.runelite.api.Point;
//import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import  net.runelite.client.plugins.timers.FreezeManager;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;
import net.runelite.api.Actor;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;


@Singleton
public class FreezeOverlay extends Overlay
{
	private final FreezeManager freezeManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private FreezeOverlay(FreezeManager freezeManager)
	{
		this.freezeManager = freezeManager;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (Map.Entry<String, FreezeInfo> entry : freezeManager.getFreezeInfo())
		{
			FreezeInfo info = entry.getValue();
			Actor actor = info.getActor();

			// TODO: Resize image
			// look at InfoBoxManager

			int offset = actor.getLogicalHeight() - 180;
			BufferedImage freezeImage = info.getGameTimer().getImage(itemManager, spriteManager);
			Point imageLocation = actor.getCanvasImageLocation(freezeImage, offset);

			if (imageLocation != null)
			{
				// Render image
				OverlayUtil.renderImageLocation(graphics, imageLocation, freezeImage);
				// Render caption
				final TextComponent textComponent = new TextComponent();
				textComponent.setColor(Color.WHITE);
				textComponent.setText(info.getTimer().getText());
				textComponent.setPosition(new java.awt.Point(imageLocation.getX(), imageLocation.getY()));
				textComponent.render(graphics);
			}
		}
		return null;

	}

}
