package net.runelite.client.plugins.mining;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import javax.inject.Inject;
import java.awt.*;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 * Displays respawn timers over rocks
 */
public class MiningRockOverlay extends Overlay
{

	private static final int MAX_DISTANCE = 2350;

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;

	@Inject
	MiningRockOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Player local = client.getLocalPlayer();
		if (config.showRespawnTimer())
		{ // Check if respawn timers are enabled in the config
			renderRespawnTimers(graphics, local);
		}
		return null;
	}

	/**
	 * Renders the respawn times for the rocks
	 */
	private void renderRespawnTimers(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();
		for (TileObject ore : plugin.getOres().keySet())
		{ // Go through every rock that currently has a stored respawn timer
			MinedRock rock = plugin.getOres().get(ore);
			if ((config.showAllRespawnTimers() || plugin.getSession().showOreRespawns(rock.getType())) && localLocation.distanceTo(ore.getLocalLocation()) <= MAX_DISTANCE)
			{ // Check if we should display this rock to the user. Checks if the user has mined the rock within this session (or has all on within config) & is within range
				renderRespawnTimerRock(graphics, ore, rock.asSeconds(), rock.asSecondsMax(), rock.getType().isGround());
			}
		}
	}

	/**
	 * Renders a rocks respawn time
	 * @param rock		The rock
	 * @param time		Time until the rock respawns (minimum)
	 * @param max		Maximum time until the rock respawns (-1 = no range)
	 * @param ground	If the rock is on the ground (true = ground, false = wall) - used to offset the respawn time text
	 */
	private void renderRespawnTimerRock(Graphics2D graphics, TileObject rock, int time, int max, boolean ground)
	{
		Point canvasLoc = Perspective.getCanvasTextLocation(client, graphics, rock.getLocalLocation(), "" + time, ground ? 0 : 150);
		if (canvasLoc != null)
		{
			String timeMessage = "" + time;
			if (max != -1)
			{ // Check if this rock has a respawn time range
				if (time <= 0)
				{ // Check if the rock has reached the minimum respawn time
					timeMessage = "~" + max; // Display the maximum possible time
					graphics.setColor(Color.CYAN);
				}
				else
				{ // Rock has not yet reached the minimum respawn time
					timeMessage += "~";
				}

			}
			graphics.drawString(timeMessage, canvasLoc.getX(), canvasLoc.getY());
			graphics.setColor(Color.WHITE); // Restore colour
		}
	}

}
