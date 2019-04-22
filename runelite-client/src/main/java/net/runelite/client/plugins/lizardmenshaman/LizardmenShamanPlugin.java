package net.runelite.client.plugins.lizardmenshaman;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.util.HashMap;
import java.util.Map;

import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Lizard Shamans",
		description = "Configures timer for lizardmen shaman spawns.",
		enabledByDefault = false,
		tags = {"shaman", "lizard", "lizardmen"},
		type = PluginType.PVM
)
@Slf4j
public class LizardmenShamanPlugin extends Plugin
{
	private static final String SHAMAN = "Lizardman shaman";
	private static final String MESSAGE = "A Lizardman shaman has summoned his spawn!";

	@Getter(AccessLevel.PACKAGE)
	private final Map<LocalPoint, LizardmenShamanSpawn> spawns =  new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ShamanSpawnOverlay overlay;

	@Inject
	private LizardmenShamanConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Provides
	LizardmenShamanConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LizardmenShamanConfig.class);
	}

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
			if (config.showTimer())
			{
				spawns.put(event.getActor().getLocalLocation(), new LizardmenShamanSpawn(8.4, null));
			}

			if (config.notifyOnSpawn())
			{
				notifier.notify(MESSAGE);
			}
		}
	}
}
