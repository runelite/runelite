package net.runelite.client.plugins.timers;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.timers.FreezeInfo;

@Singleton
public class FreezeManager
{
	private final Map<String, FreezeInfo> freezes = new HashMap<>();

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TimersPlugin timersPlugin;

	public void put(Actor actor, GameTimer gameTimer)
	{
		FreezeInfo previousFreezeInfo = freezes.get(actor.getName());
		BufferedImage image = gameTimer.getImage(itemManager, spriteManager);
		TimerTimer timer = new TimerTimer(gameTimer, timersPlugin, image);

		if (previousFreezeInfo == null)
		{
			FreezeInfo freezeInfo = new FreezeInfo(gameTimer, timer, actor, actor.getLocalLocation());
			freezes.put(actor.getName(), freezeInfo);
		}

	}

	public void remove(Actor actor)
	{
		freezes.remove(actor.getName());
	}

	public void prune()
	{
		// Conditions for pruning
		// 1. worldPoint has changed
		// 2. timer has run out
		// 3. any players that are no longer renderable (handled in TimersPlugin, included deaths)

		freezes.entrySet().removeIf(e ->
			!e.getValue().getFreezePoint().equals(e.getValue().getActor().getLocalLocation()) ||
			!e.getValue().getTimer().render()
		);
	}

	public Set<Map.Entry<String, FreezeInfo>> getFreezeInfo()
	{
		return freezes.entrySet();
	}

}

