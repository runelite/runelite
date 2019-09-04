package net.runelite.client.plugins.slayerarea;

import java.awt.image.BufferedImage;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.worldmap.WorldMapPlugin;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

public class SlayerAreaMapIcons
{
	private static final BufferedImage NOPE_ICON;

	static
	{
		NOPE_ICON = new BufferedImage(17, 17, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage nopeImage = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "nope_icon.png");
		NOPE_ICON.getGraphics().drawImage(nopeImage, 1, 1, null);
	}

	private Client client;
	private SlayerAreaConfig config;
	private WorldMapPointManager worldMapPointManager;
	private ItemManager itemManager;
	private ClientThread clientThread;

	SlayerAreaMapIcons(Client client, SlayerAreaConfig config, WorldMapPointManager worldMapPointManager, ItemManager itemManager, ClientThread clientThread)
	{
		this.client = client;
		this.config = config;
		this.worldMapPointManager = worldMapPointManager;
		this.itemManager = itemManager;
		this.clientThread = clientThread;
		init();
	}

	public void init()
	{
		updateShownIcons();
	}

	public void stop()
	{
		worldMapPointManager.removeIf(SlayerAreaPoint.class::isInstance);
	}

	void gameStateChanged(GameStateChanged event)
	{
		if (event.getGameState().ordinal() >= GameState.LOGIN_SCREEN.ordinal())
		{
			updateShownIcons();
		}
	}

	void configChanged(ConfigChanged event)
	{
		updateShownIcons();
	}

	private void updateShownIcons()
	{
		if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal()) return;
		stop();
		if (!config.removeSlayerIcons()) return;
		Map<Integer, SlayerArea> areas = SlayerAreas.getAreas();
		if (areas == null || areas.size() <= 0) return;
		for (Map.Entry<Integer, SlayerArea> entry : areas.entrySet())
		{
			int id = entry.getKey();
			SlayerArea area = entry.getValue();

			if (area.unlocked) continue;
			if (SlayerAreas.isUnlocked(id)) continue;

			int x = SlayerArea.getX(id) + 32;
			int y = SlayerArea.getY(id) + 32;

			WorldPoint point = new WorldPoint(x, y, 0);
			String tip = area.strongest;
			clientThread.invoke(() ->
			{
				BufferedImage icon = area.getImage(itemManager);
				if (icon == null) icon = NOPE_ICON;
				SlayerAreaPoint sap = new SlayerAreaPoint(point, tip, icon);
				worldMapPointManager.add(sap);
			});
		}
	}


}
