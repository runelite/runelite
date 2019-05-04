/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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
package net.runelite.client.plugins.olmprayagainst;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Projectile;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

/*
 * Tells you what to pray against Olm (Not to be confused with ganoms swapper)
 * Most of the code is from Haha Kut's Alchemical Hydra plugin. (See OlmPrayAgainstOverlay)
 */

@PluginDescriptor(
	name = "Olm Pray Against",
	description = "Tells you what to pray against Olm",
	tags = {"prayer", "olm", "raids", "pray against", "cox"},
	type = PluginType.PVM
)
@Slf4j
@Singleton
public class OlmPrayAgainstPlugin extends Plugin
{
	@Setter
	@Getter
	protected PrayAgainst prayAgainstOlm;
	@Getter
	protected long lastPrayTime;
	@Inject
	private Client client;
	@Inject
	private OlmPrayAgainstOverlay overlay;
	@Inject
	private OverlayManager overlayManager;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		final String msg = event.getMessage();
		if (event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (msg.toLowerCase().contains("aggression"))
			{
				log.debug("Melee Detected");
				prayAgainstOlm = PrayAgainst.MELEE;
				lastPrayTime = System.currentTimeMillis();
			}
			if (msg.toLowerCase().contains("of magical power"))
			{
				log.debug("Mage Detected");
				prayAgainstOlm = PrayAgainst.MAGIC;
				lastPrayTime = System.currentTimeMillis();
			}
			if (msg.toLowerCase().contains("accuracy and dexterity"))
			{
				log.debug("Missile Detected");
				prayAgainstOlm = PrayAgainst.RANGED;
				lastPrayTime = System.currentTimeMillis();
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();
		if (projectile.getId() == 1339)
		{
			log.debug("Mage Detected");
			prayAgainstOlm = PrayAgainst.MAGIC;
			lastPrayTime = System.currentTimeMillis();
		}
		if (projectile.getId() == 1340)
		{
			log.debug("Range Detected");
			prayAgainstOlm = PrayAgainst.RANGED;
			lastPrayTime = System.currentTimeMillis();
		}
	}

}
