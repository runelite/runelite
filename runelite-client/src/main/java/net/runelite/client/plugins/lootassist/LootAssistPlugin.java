package net.runelite.client.plugins.lootassist;

import com.google.inject.Provides;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Loot Assist Plugin",
	description = "Creates a tile overlay with a timer that counts down to when the loot will appear to you",
	tags = {"pklite", "loot", "looting", "loot assist", "assist", "loot assist"},
	type = PluginType.PVP,
	enabledByDefault = false
)

public class LootAssistPlugin extends Plugin
{
	@Inject
	OverlayManager overlayManager;

	@Inject
	LootAssistOverlay lootAssistOverlay;

	static ConcurrentHashMap<WorldPoint, LootPile> lootPiles = new ConcurrentHashMap<>();

	@Provides
	LootAssitConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LootAssitConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(lootAssistOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		lootPiles.clear();
		overlayManager.remove(lootAssistOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		lootPiles.clear();
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();
		if (actor.getAnimation() == AnimationID.DEATH && actor instanceof Player)
		{
			LootPile pile = new LootPile(actor.getWorldLocation(), actor.getName());
			lootPiles.put(pile.getLocation(), pile);
		}
	}


}
