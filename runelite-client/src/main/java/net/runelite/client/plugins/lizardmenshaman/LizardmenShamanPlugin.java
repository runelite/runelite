package net.runelite.client.plugins.lizardmenshaman;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.util.HashMap;
import java.util.Map;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Lizardmen Shaman",
		description = "Configures timer for lizardmen shaman spawns.",
		enabledByDefault = false,
		tags = {"shaman", "lizard", "lizardmen"}
)
@Slf4j
public class LizardmenShamanPlugin extends Plugin
{
	private static final String SHAMAN = "Lizardman shaman";

	@Getter(AccessLevel.PACKAGE)
	private final Map<LocalPoint, LizardmenShamanSpawn> spawns =  new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ShamanSpawnOverlay overlay;

	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		spawns.clear();
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();
		if (actor == null || actor.getName() == null)
		{
			return;
		}
		else if (actor.getName().equals(SHAMAN) && actor.getAnimation() == 7157)
		{
			spawns.put(event.getActor().getLocalLocation(), new LizardmenShamanSpawn(8.4, null));
		}
	}
}
