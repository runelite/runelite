/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.cannon;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import static net.runelite.api.ObjectID.CANNON_BASE;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import static net.runelite.api.ProjectileID.CANNONBALL;
import static net.runelite.api.ProjectileID.GRANITE_CANNONBALL;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Cannon plugin"
)
public class CannonPlugin extends Plugin
{
	private static final Pattern LOAD_CANNON_PATTERN = Pattern.compile("([0-9]+)");
	private static final int MAX_CBALLS = 30;

	int cballsLeft = 0;

	boolean cannonPlaced = false;

	net.runelite.api.Point myCannon;

	@Inject
	private Notifier notifier;

	@Inject
	private CannonOverlay cannonOverlay;

	@Inject
	private CannonConfig config;

	@Inject
	private Client client;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(CannonOverlay.class);
	}

	@Provides
	CannonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CannonConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return cannonOverlay;
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		Player localPlayer = client.getLocalPlayer();
		if (gameObject.getId() == CANNON_BASE && !cannonPlaced)
		{
			if (localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2
				&& localPlayer.getAnimation() == AnimationID.BURYING_BONES)
			{
				myCannon = gameObject.getWorldLocation();
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		if ((projectile.getId() == CANNONBALL || projectile.getId() == GRANITE_CANNONBALL) && myCannon != null)
		{
			net.runelite.api.Point projectileLoc = Perspective.localToWorld(client, new net.runelite.api.Point(projectile.getX1(), projectile.getY1()));

			//Check to see if projectile x,y is 0 else it will continuously decrease while ball is flying.
			if (projectileLoc.equals(myCannon) && projectile.getX() == 0 && projectile.getY() == 0)
			{
				cballsLeft--;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED && event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			cannonPlaced = true;
			cballsLeft = 0;
		}

		if (event.getMessage().contains("You pick up the cannon"))
		{
			cannonPlaced = false;
			cballsLeft = 0;
		}

		if (event.getMessage().startsWith("You load the cannon with"))
		{
			Matcher m = LOAD_CANNON_PATTERN.matcher(event.getMessage());
			if (m.find())
			{
				int amt = Integer.valueOf(m.group());
				
				// make sure cballs doesn't go above MAX_CBALLS
				if (amt + cballsLeft > MAX_CBALLS)
				{
					cballsLeft = MAX_CBALLS;
				}
				else
				{
					cballsLeft += amt;
				}
			}
		}

		if (event.getMessage().equals("You load the cannon with one cannonball."))
		{
			cballsLeft++;
		}

		if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			cballsLeft = 0;

			if (config.showEmptyCannonNotification())
			{
				notifier.notify("Your cannon is out of ammo!");
			}
		}
	}
}
