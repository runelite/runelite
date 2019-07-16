/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.freezetimers;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Freeze Timers",
	description = "Shows a freeze timer overlay on players",
	tags = {"freeze", "timers", "barrage", "teleblock", "pklite"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
public class FreezeTimersPlugin extends Plugin
{
	private static final int VORKATH_REGION = 9023;

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

	@Inject
	private FreezeTimersConfig config;

	@Getter(AccessLevel.PACKAGE)
	private boolean showPlayers;
	@Getter(AccessLevel.PACKAGE)
	private boolean showNpcs;
	@Getter(AccessLevel.PACKAGE)
	private boolean FreezeTimers;
	@Getter(AccessLevel.PACKAGE)
	private boolean TB;
	@Getter(AccessLevel.PACKAGE)
	private boolean Veng;
	@Getter(AccessLevel.PACKAGE)
	private int offset;
	@Getter(AccessLevel.PACKAGE)
	private boolean noImage;
	@Getter(AccessLevel.PACKAGE)
	private FontStyle fontStyle;
	@Getter(AccessLevel.PACKAGE)
	private int textSize;

	public void startUp()
	{
		updateConfig();
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
	public void onSpotAnimationChanged(SpotAnimationChanged graphicChanged)
	{
		int oldGraphic = prayerTracker.getSpotanimLastTick(graphicChanged.getActor());
		int newGraphic = graphicChanged.getActor().getSpotAnimation();
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
		for (Actor actor : client.getPlayers())
		{
			if (prayerTracker.getSpotanimLastTick(actor) != actor.getSpotAnimation())
			{
				SpotAnimationChanged callback = new SpotAnimationChanged();
				callback.setActor(actor);
				client.getCallbacks().post(callback);
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final NPC npc = event.getNpc();

		if (npc.getName() == null)
		{
			return;
		}

		if (npc.getName().equals("Zombified Spawn"))
		{
			timers.setTimerEnd(client.getLocalPlayer(), TimerType.FREEZE,
					System.currentTimeMillis());
		}
	}

	private boolean isAtVorkath()
	{
		return ArrayUtils.contains(client.getMapRegions(), VORKATH_REGION);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("freezetimers"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.showPlayers = config.showPlayers();
		this.showNpcs = config.showNpcs();
		this.FreezeTimers = config.FreezeTimers();
		this.TB = config.TB();
		this.Veng = config.Veng();
		this.offset = config.offset();
		this.noImage = config.noImage();
		this.fontStyle = config.fontStyle();
		this.textSize = config.textSize();
	}
}
