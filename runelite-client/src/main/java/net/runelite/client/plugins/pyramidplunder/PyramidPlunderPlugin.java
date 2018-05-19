package net.runelite.client.plugins.pyramidplunder;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;

import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;

@PluginDescriptor(
		name = "Pyramid plunder",
		enabledByDefault = false
)

public class PyramidPlunderPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private InfoBoxManager infoBoxManager;
	@Inject
	private GameObjectQuery gameObjectQuery;
	private boolean plundering;
	private Timer plunderTimer;
	private SkillIconManager skillIconManager = new SkillIconManager();
	private BufferedImage icon = skillIconManager.getSkillImage(Skill.THIEVING);

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().matches("Start-minigame"))
		{
			for (NPC NPClist: client.getNpcs())
			{
				if (NPClist.getName().matches("Guardian mummy"))
				{
					plundering = true;
					break;
				}
			}
		}
		else
		{
			if (event.getMenuOption().matches("Leave Tomb") || event.getMenuOption().matches("Quick-leave"))
			{
				plundering = false;
			}
		}
	}
	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{

			if (plundering)
			{
				if (!infoBoxManager.getInfoBoxes().contains(plunderTimer))
				{
					plunderTimer = new Timer(5, ChronoUnit.MINUTES, icon, this);
					infoBoxManager.addInfoBox(plunderTimer);
				}
			}
			else
			{
				infoBoxManager.removeInfoBox(plunderTimer);
			}
		}
	}
}