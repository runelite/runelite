/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.animation;

import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.animation.AnimationClient;
import net.runelite.http.api.animation.AnimationKey;
import net.runelite.http.api.animation.AnimationRequest;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Animation",
	hidden = true
)
@Slf4j
public class AnimationPlugin extends Plugin
{
	private final AnimationClient animationClient = new AnimationClient();

	@Inject
	private Client client;

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		int revision = client.getRevision();

		AnimationRequest animationRequest = new AnimationRequest();
		animationRequest.setRevision(revision);

		if (event.getActor() instanceof NPC)
		{
			NPC npc = (NPC) event.getActor();

			int npcid = npc.getId();
			int[] animations = null;
			try
			{
				animations = animationClient.get(npcid).getAnimations();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			int animation = event.getActor().getAnimation();

			//First POST?
			if (animations == null)
			{
				animations = new int[10];
				AnimationKey animationKey = new AnimationKey();
				animationKey.setNPCId(npcid);
				animations[0] = animation;
				animationKey.setAnimations(animations);
				animationRequest.addKey(animationKey);
				animationClient.submit(animationRequest);
				return;
			}

			//Doesn't contain animation
			if (!ArrayUtils.contains(animations, animation))
			{
				ArrayUtils.add(animations, animation);
			}
			log.debug("NPC {} anims {}, {}, {}, {}, {}, {}, {}, {}, {}, {}", npcid, animations[0], animations[1], animations[2], animations[3], animations[4], animations[5], animations[6], animations[7], animations[8], animations[9]);

			AnimationKey animationKey = new AnimationKey();
			animationKey.setNPCId(npcid);
			animationKey.setAnimations(animations);
			animationRequest.addKey(animationKey);
		}

		if (animationRequest.getKeys().isEmpty())
		{
			return;
		}

		animationClient.submit(animationRequest);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

	}

	public void addAnimation(int[] animations, int animation)
	{
		int i = 0;
		for (int j : animations)
		{
			if (j == -1)
			{
				animations[i] = animation;
				return;
			}
			i++;
		}
	}
}
