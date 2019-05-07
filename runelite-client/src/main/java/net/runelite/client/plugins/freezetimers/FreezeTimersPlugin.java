package net.runelite.client.plugins.freezetimers;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Freeze Timers",
	description = "Shows a freeze timer overlay on players",
	tags = {"freeze", "timers", "barrage", "teleblock", "pklite"},
	type = PluginType.PVP
)
public class FreezeTimersPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Timers timers;

	@Inject
	private PrayerTracker prayerTracker;

	@Inject
	private FreezeTimersOverlay overlay;

	public void startUp()
	{
		overlayManager.add(overlay);
	}

	public void shutDown()
	{
		overlayManager.remove(overlay);
	}

	@Provides
	public FreezeTimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FreezeTimersConfig.class);
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged graphicChanged)
	{
		int oldGraphic = prayerTracker.getSpotanimLastTick(graphicChanged.getActor());
		int newGraphic = graphicChanged.getActor().getGraphic();
		if (oldGraphic == newGraphic)
		{
			return;
		}
		PlayerSpellEffect effect = PlayerSpellEffect.getFromSpotAnim(newGraphic);
		if (effect == PlayerSpellEffect.NONE)
		{
			return;
		}
		long length = effect.getTimerLengthTicks();
		if (effect.isHalvable() && prayerTracker.getPrayerIconLastTick(graphicChanged.getActor()) == 2)
		{
			length /= 2;
		}
		if (timers.getTimerEnd(graphicChanged.getActor(), effect.getType()) > System.currentTimeMillis())
		{
			return;
		}
		timers.setTimerEnd(graphicChanged.getActor(), effect.getType(),
			System.currentTimeMillis() + length);
	}

	@Subscribe
	public void onGameTick(GameTick tickEvent)
	{
		timers.gameTick();
		prayerTracker.gameTick();
	}

}
