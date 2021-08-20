/*
 * Copyright (c) 2019, Weird Gloop <admin@weirdgloop.org>
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

package net.runelite.client.plugins.crowdsourcing;

import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.crowdsourcing.cooking.CrowdsourcingCooking;
import net.runelite.client.plugins.crowdsourcing.dialogue.CrowdsourcingDialogue;
import net.runelite.client.plugins.crowdsourcing.movement.CrowdsourcingMovement;
import net.runelite.client.plugins.crowdsourcing.music.CrowdsourcingMusic;
import net.runelite.client.plugins.crowdsourcing.thieving.CrowdsourcingThieving;
import net.runelite.client.plugins.crowdsourcing.woodcutting.CrowdsourcingWoodcutting;
import net.runelite.client.plugins.crowdsourcing.zmi.CrowdsourcingZMI;
import net.runelite.client.task.Schedule;

@Slf4j
@PluginDescriptor(
	name = "OSRS Wiki Crowdsourcing",
	description = "Send data to the wiki to help figure out skilling success rates, burn rates, more. See osrs.wiki/RS:CROWD"
)
public class CrowdsourcingPlugin extends Plugin
{
	// Number of seconds to wait between trying to send data to the wiki.
	private static final int SECONDS_BETWEEN_UPLOADS = 300;

	@Inject
	private EventBus eventBus;

	@Inject
	private CrowdsourcingManager manager;

	@Inject
	private CrowdsourcingCooking cooking;

	@Inject
	private CrowdsourcingDialogue dialogue;

	@Inject
	private CrowdsourcingMovement movement;

	@Inject
	private CrowdsourcingMusic music;

	@Inject
	private CrowdsourcingThieving thieving;

	@Inject
	private CrowdsourcingWoodcutting woodcutting;

	@Inject
	private CrowdsourcingZMI zmi;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.register(cooking);
		eventBus.register(dialogue);
		eventBus.register(movement);
		eventBus.register(music);
		eventBus.register(thieving);
		eventBus.register(woodcutting);
		eventBus.register(zmi);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(cooking);
		eventBus.unregister(dialogue);
		eventBus.unregister(movement);
		eventBus.unregister(music);
		eventBus.unregister(thieving);
		eventBus.unregister(woodcutting);
		eventBus.unregister(zmi);
	}

	@Schedule(
		period = SECONDS_BETWEEN_UPLOADS,
		unit = ChronoUnit.SECONDS,
		asynchronous = true
	)
	public void submitToAPI()
	{
		manager.submitToAPI();
	}
}
