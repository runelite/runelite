/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.theatre.rooms.BloatHandler;
import net.runelite.client.plugins.theatre.rooms.MaidenHandler;
import net.runelite.client.plugins.theatre.rooms.SotetsegHandler;
import net.runelite.client.plugins.theatre.rooms.VerzikHandler;
import net.runelite.client.plugins.theatre.rooms.xarpus.XarpusHandler;
import net.runelite.client.plugins.theatre.rooms.nylocas.NyloHandler;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Theatre of Blood",
	description = "All-in-one plugin for Theatre of Blood.",
	tags = {"ToB", "Theatre", "Theatre of Blood", "Lyzrd"},
	type = PluginType.PVM,
	enabledByDefault = false
)

public class TheatrePlugin extends Plugin 
{

	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private TheatreRoom room;

	@Getter(AccessLevel.PUBLIC)
	private MaidenHandler maidenHandler;

	@Getter(AccessLevel.PUBLIC)
	private BloatHandler bloatHandler;

	@Getter(AccessLevel.PUBLIC)
	private NyloHandler nyloHandler;

	@Getter(AccessLevel.PUBLIC)
	private SotetsegHandler sotetsegHandler;

	@Getter(AccessLevel.PUBLIC)
	private XarpusHandler xarpusHandler;

	@Getter(AccessLevel.PUBLIC)
	private VerzikHandler verzikHandler;

	@Inject
	private Client client;

	@Getter(AccessLevel.PUBLIC)
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TheatreOverlay overlay;

	@Inject
	private TheatreConfig config;

	@Provides
	TheatreConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TheatreConfig.class);
	}

	@Override
	protected void startUp()
	{
		room = TheatreRoom.UNKNOWN;

		maidenHandler = new MaidenHandler(client, this, config);
		bloatHandler = new BloatHandler(client, this, config);
		nyloHandler = new NyloHandler(client, this, config);
		sotetsegHandler = new SotetsegHandler(client, this, config);
		xarpusHandler = new XarpusHandler(client, this, config);
		verzikHandler = new VerzikHandler(client, this, config);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		maidenHandler.onStop();
		maidenHandler = null;

		bloatHandler.onStop();
		bloatHandler = null;

		nyloHandler.startTime = 0L;
		nyloHandler.onStop();
		nyloHandler = null;

		sotetsegHandler.onStop();
		sotetsegHandler = null;

		xarpusHandler.onStop();
		xarpusHandler = null;

		verzikHandler.onStop();
		verzikHandler = null;

		room = TheatreRoom.UNKNOWN;

		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (maidenHandler != null)
			maidenHandler.onNpcSpawned(event);

		if (bloatHandler != null)
			bloatHandler.onNpcSpawned(event);

		if (nyloHandler != null)
			nyloHandler.onNpcSpawned(event);

		if (sotetsegHandler != null)
			sotetsegHandler.onNpcSpawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onNpcSpawned(event);

		if (verzikHandler != null)
			verzikHandler.onNpcSpawned(event);

	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (maidenHandler != null)
			maidenHandler.onNpcDespawned(event);

		if (bloatHandler != null)
			bloatHandler.onNpcDespawned(event);

		if (nyloHandler != null)
			nyloHandler.onNpcDespawned(event);

		if (sotetsegHandler != null)
			sotetsegHandler.onNpcDespawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onNpcDespawned(event);

	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (verzikHandler != null)
			verzikHandler.onAnimationChanged(event);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (maidenHandler != null)
			maidenHandler.onGameTick();

		if (bloatHandler != null)
			bloatHandler.onGameTick();

		if (nyloHandler != null)
			nyloHandler.onGameTick();

		if (sotetsegHandler != null)
			sotetsegHandler.onGameTick();

		if (xarpusHandler != null)
			xarpusHandler.onGameTick();

		if (verzikHandler != null)
			verzikHandler.onGameTick();
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		if (sotetsegHandler != null)
			sotetsegHandler.onGroundObjectSpawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onGroundObjectSpawned(event);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (nyloHandler != null)
			nyloHandler.onConfigChanged();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (bloatHandler != null)
			bloatHandler.onVarbitChanged(event);

		if (xarpusHandler != null)
			xarpusHandler.onVarbitChanged(event);
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (sotetsegHandler != null)
		{
			sotetsegHandler.onProjectileMoved(event);

		}
		if (verzikHandler != null)
		{
			verzikHandler.onProjectileMoved(event);
		}
	}
}