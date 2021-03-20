/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
 *
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
package net.runelite.client.plugins.starlink;

import com.google.common.primitives.Ints;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.starlink.event.StarCrashEvent;
import net.runelite.client.plugins.starlink.event.StarDowngradeEvent;
import net.runelite.client.plugins.starlink.event.StarScoutEvent;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Shooting Stars",
	description = "Helps you track shooting stars",
	enabledByDefault = false
)
public class ShootingStars extends Plugin
{

	private static final int HINT_ARROW_CLEAR_DISTANCE = 6;
	private static final int CHATBOX_MESSAGE_INTERFACE = 229;
	private static final int CHATBOX_MESSAGE_COMPONENT = 1;
	private static final int[] CRASHED_STARS = {
		41229,
		41228,
		41227,
		41226,
		41225,
		41224,
		41223,
		41021,
		41020
	};

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StarlinkOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Getter
	private CrashedStar crashedStar;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Player localPlayer = client.getLocalPlayer();
		if (crashedStar != null && localPlayer != null
			&& client.hasHintArrow() && localPlayer.getWorldLocation().distanceTo(crashedStar.getWorldPoint()) < HINT_ARROW_CLEAR_DISTANCE)
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == CHATBOX_MESSAGE_INTERFACE)
		{
			clientThread.invokeLater(() -> {
				int world = client.getWorld();
				Widget widget = client.getWidget(CHATBOX_MESSAGE_INTERFACE, CHATBOX_MESSAGE_COMPONENT);

				if (widget == null)
				{
					return;
				}
				eventBus.post(new StarScoutEvent());
			});
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		int locId = event.getGameObject().getId();
		int starTier = Ints.indexOf(CRASHED_STARS, locId) + 1;
		WorldPoint worldLocation = event.getTile().getWorldLocation();
		int world = client.getWorld();

		CrashedStar newStar = new CrashedStar(world, worldLocation, starTier);

		if (starTier > 0)
		{
			if (crashedStar == null || crashedStar.depleted() || !crashedStar.isSame(newStar))
			{
				System.out.println("NEW STAR TIER " + starTier);
				System.out.println(newStar);
				this.crashedStar = newStar;
				client.setHintArrow(newStar.getWorldPoint());
				eventBus.post(new StarCrashEvent());
			}
			else if (starTier != this.crashedStar.getTier() && newStar.isSame(crashedStar))
			{
				this.crashedStar = this.crashedStar.reduceTier();
				System.out.println("STAR REDUCED TIER TO " + this.crashedStar.getTier());
				eventBus.post(new StarDowngradeEvent());
			}
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		int locId = event.getGameObject().getId();
		if (Ints.contains(CRASHED_STARS, locId) && crashedStar.getTier() == CrashedStar.MIN_TIER)
		{
			System.out.println("STAR DEPLETED");
			crashedStar = null;
			eventBus.post(new StarCrashEvent());
		}
	}
}
