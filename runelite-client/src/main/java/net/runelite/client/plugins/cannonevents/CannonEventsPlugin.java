/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.cannonevents;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import static net.runelite.api.ObjectID.CANNON_BASE;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import static net.runelite.api.ProjectileID.CANNONBALL;
import static net.runelite.api.ProjectileID.GRANITE_CANNONBALL;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CannonChanged;
import net.runelite.api.events.CannonPlaced;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	loadWhenOutdated = true, // prevent users from disabling
	hidden = true, // prevent users from disabling
	name = "Cannon events"
)
@Singleton
@Slf4j
public class CannonEventsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final int MAX_CBALLS = 30;
	private int cballsLeft;
	private WorldPoint cannonPosition;
	private GameObject cannon;
	private boolean cannonPlaced;
	private boolean skipProjectileCheckThisTick;

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			cballsLeft = 0;
			eventBus.post(CannonPlaced.class, new CannonPlaced(true, cannonPosition, cannon));
			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
			cannonPlaced = true;
		}

		if (event.getMessage().contains("You pick up the cannon")
			|| event.getMessage().contains("Your cannon has decayed. Speak to Nulodion to get a new one!"))
		{
			cballsLeft = 0;
			eventBus.post(CannonPlaced.class, new CannonPlaced(false, null, null));
			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
			cannonPlaced = false;
		}

		if (event.getMessage().startsWith("You load the cannon with"))
		{
			Matcher m = NUMBER_PATTERN.matcher(event.getMessage());
			if (m.find())
			{
				// The cannon will usually refill to MAX_CBALLS, but if the
				// player didn't have enough cannonballs in their inventory,
				// it could fill up less than that. Filling the cannon to
				// cballsLeft + amt is not always accurate though because our
				// counter doesn't decrease if the player has been too far away
				// from the cannon due to the projectiels not being in memory,
				// so our counter can be higher than it is supposed to be.
				int amt = Integer.parseInt(m.group());
				if (cballsLeft + amt >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
				}
				else
				{
					cballsLeft += amt;
				}
			}
			else if (event.getMessage().equals("You load the cannon with one cannonball."))
			{
				if (cballsLeft + 1 >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
				}
				else
				{
					cballsLeft++;
				}
			}

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}

		if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			skipProjectileCheckThisTick = true;

			// If the player was out of range of the cannon, some cannonballs
			// may have been used without the client knowing, so having this
			// extra check is a good idea.
			cballsLeft = 0;

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}

		if (event.getMessage().startsWith("You unload your cannon and receive Cannonball")
			|| event.getMessage().startsWith("You unload your cannon and receive Granite cannonball"))
		{
			skipProjectileCheckThisTick = true;

			cballsLeft = 0;

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		skipProjectileCheckThisTick = false;
	}

	@Subscribe
	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();

		final Player localPlayer = client.getLocalPlayer();
		if (gameObject.getId() == CANNON_BASE && !cannonPlaced &&
			localPlayer != null && localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2 &&
			localPlayer.getAnimation() == AnimationID.BURYING_BONES)
		{
			cannonPosition = gameObject.getWorldLocation();
			cannon = gameObject;
		}
	}

	@Subscribe
	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!cannonPlaced)
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		if ((projectile.getId() == CANNONBALL || projectile.getId() == GRANITE_CANNONBALL) && cannonPosition != null)
		{
			final WorldPoint projectileLoc = WorldPoint.fromLocal(client, projectile.getX1(), projectile.getY1(), client.getPlane());

			if (projectileLoc.equals(cannonPosition) && !skipProjectileCheckThisTick)
			{
				cballsLeft--;
				eventBus.post(CannonChanged.class, new CannonChanged(projectile.getId(), cballsLeft));
			}
		}
	}
}