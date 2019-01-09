package net.runelite.client.plugins.mining;

import net.runelite.api.Client;
import net.runelite.api.TileObject;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Displays respawn timers on a per-world base for any rock recently mined by the player as they're hopping worlds
 */
public class MiningWorldHopperOverlay extends Overlay
{

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MiningWorldHopperOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.trackWorldRock() == MiningRockType.WorldRock.None)
		{ // Check if user is tracking a rock across worlds
			return null;
		}
		MiningWorldTracker tracker = plugin.getMiningTracker();
		for (int worldID : new ArrayList<>(tracker.getTrackedWorlds().keySet()))
		{ // Go through every world stored in the tracker
			MiningWorld world = tracker.getTrackedWorlds().get(worldID);
			for (TileObject o : new ArrayList<>(world.getRocks().keySet()))
			{ // Go through every rock stored in this world
				MinedRock rock = world.getRocks().get(o);
				if (rock.asSecondsNegative() < 0 - config.trackTimeout())
				{ // If this rock has respawned & we've passed the config defined timeout, then remove this rock
					world.getRocks().remove(o);
				}
			}
			if (world.getRocks().size() == 0)
			{ // If every rock mined has respawned & the timeout passed, remove this world from the overlay
				tracker.getTrackedWorlds().remove(worldID);
			}
		}

		if (tracker.getTrackedWorlds().size() == 0)
		{ // Exit here if there are no worlds to display
			return null;
		}

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(TitleComponent.builder()
				.text("Respawn Tracker")
				.build());

		for (MiningWorld world : tracker.getTrackedWorlds().values().stream().sorted(Comparator.comparing(MiningWorld::asSeconds)).collect(Collectors.toList()))
		{ // Go through every remaining world, if they're here it means they have a rock that has not yet respawned (or timeout not yet passed)
			int id = world.getWorld();
			int seconds = world.asSeconds(); // Gets the time left until the first rock respawns in this world
			if (seconds < 0)
			{ // If it's less than zero, but not been cleared yet, we'll display 0. Default Clear time(timeout) is at -60
				seconds = 0;
			}

			panelComponent.getChildren().add(LineComponent.builder()
				.left("World " + id)
				.right(Integer.toString(seconds))
				.rightColor(seconds == 0 ? Color.GREEN : Color.ORANGE)
				.build()); // Display the world & the time left until the first rock respawns

		}

		return panelComponent.render(graphics);
	}

}
