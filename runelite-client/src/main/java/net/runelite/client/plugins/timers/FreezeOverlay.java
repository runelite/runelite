package net.runelite.client.plugins.timers;

import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Point;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayUtil;
import  net.runelite.client.plugins.timers.FreezeManager;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;
import net.runelite.api.Actor;


@Singleton
public class FreezeOverlay extends Overlay
{
	private final ItemManager itemManager;
	private final SpriteManager spriteManager;
	private final FreezeManager freezeManager;
	private final Client client;

	@Inject
	private InfoBoxOverlay(
		FreezeManager freezeManager,
		Client client,
		SpriteManager spriteManager,
		ItemManager itemManager)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.spriteManager = spriteManager;
		this.freezeManager = freezeManager;
	}

	@Override
	public void render(Graphics2D graphics)
	{
		final ConcurrentMap<String, FreezeInfo> freezeInfos = freezeManager.getFreezeInfo();

		if (freezeInfos.size() == 0)
		{
			return null;
		}


		for (Map.Entry<String, FreezeInfo> entry : freezeInfos.entrySet())
		{
			String username = entry.getKey();
			FreezeInfo info = entry.getValue();
			Actor actor = info.getActor();

			int offset = actor.getLogicalHeight() - 80;
			BufferedImage freezeImage = info.getTimer().getImage(itemManager, spriteManager);
			Point imageLocation = actor.getCanvasImageLocation(freezeImage, offset);

			if (imageLocation != null)
			{
				OverlayUtil.renderImageLocation(graphics, imageLocation, freezeImage);
			}
		}

	}

}
