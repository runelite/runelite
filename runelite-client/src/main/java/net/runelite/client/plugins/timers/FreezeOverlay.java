package net.runelite.client.plugins.timers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Point;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
//import net.runelite.api.Client;
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


@Singleton
public class FreezeOverlay extends Overlay
{
	private final ItemManager itemManager;
	private final SpriteManager spriteManager;
	private final FreezeManager freezeManager;
//	private final Client client;

	@Inject
	private FreezeOverlay(
		FreezeManager freezeManager,
//		Client client,
		SpriteManager spriteManager,
		ItemManager itemManager)
	{
		System.out.println("HERE1");
//		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.MED);

		this.itemManager = itemManager;
		this.spriteManager = spriteManager;
		this.freezeManager = freezeManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ConcurrentMap<String, FreezeInfo> freezeInfos = freezeManager.getFreezeInfo();
		for (Map.Entry<String, FreezeInfo> entry : freezeInfos.entrySet())
		{
			String username = entry.getKey();
			FreezeInfo info = entry.getValue();
			Actor actor = info.getActor();

			// TODO: Resize image
			// TODO: Add timer

			int offset = actor.getLogicalHeight() - 40;
			BufferedImage freezeImage = info.getTimer().getImage(itemManager, spriteManager);
			Point imageLocation = actor.getCanvasImageLocation(freezeImage, offset);

			if (imageLocation != null)
			{
				OverlayUtil.renderImageLocation(graphics, imageLocation, freezeImage);
			}
		}
		return null;

	}

}
