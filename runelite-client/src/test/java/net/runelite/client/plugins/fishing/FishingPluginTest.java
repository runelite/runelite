/*
 * Copyright (c) 2021, Tal <https://github.com/talsk>
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
package net.runelite.client.plugins.fishing;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.events.XpTrackerSkillReset;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FishingPluginTest
{
	static private final String ANGLERFISH_CAUGHT_MESSAGE = "You catch an anglerfish.";
	static private final String EXTRA_FISH_CAUGHT_MESSAGE = "The spirit flakes enabled you to catch an extra fish.";

	@Inject
	FishingPlugin fishingPlugin;

	@Mock
	@Bind
	FishingConfig config;

	@Mock
	@Bind
	FishingOverlay fishingOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	FishingSpotOverlay fishingSpotOverlay;

	@Mock
	@Bind
	FishingSpotMinimapOverlay fishingSpotMinimapOverlay;


	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testFish()
	{
		ChatMessage anglerCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ANGLERFISH_CAUGHT_MESSAGE, "", 0);
		fishingPlugin.onChatMessage(anglerCaughtMessage);

		assertSessionStats(1, 1, 0, 0);
	}

	@Test
	public void testExtraFish()
	{
		ChatMessage anglerCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ANGLERFISH_CAUGHT_MESSAGE, "", 0);
		ChatMessage extraFishCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", EXTRA_FISH_CAUGHT_MESSAGE, "", 0);
		fishingPlugin.onChatMessage(anglerCaughtMessage);
		fishingPlugin.onChatMessage(extraFishCaughtMessage);

		assertSessionStats(1, 1, 1, 1);
	}

	@Test
	public void testFishingSkillReset()
	{
		ChatMessage anglerCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ANGLERFISH_CAUGHT_MESSAGE, "", 0);
		ChatMessage extraFishCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", EXTRA_FISH_CAUGHT_MESSAGE, "", 0);

		fishingPlugin.onChatMessage(anglerCaughtMessage);
		fishingPlugin.onChatMessage(anglerCaughtMessage);
		fishingPlugin.onChatMessage(extraFishCaughtMessage);

		XpTrackerSkillReset magicResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS, Skill.MAGIC);
		fishingPlugin.onXpTrackerSkillReset(magicResetEvent);
		assertSessionStats(2, 2, 1, 1);

		XpTrackerSkillReset fishingResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS, Skill.FISHING);
		fishingPlugin.onXpTrackerSkillReset(fishingResetEvent);
		assertSessionStats(0, 0, 0, 0);
	}

	@Test
	public void testFishingSkillHrReset()
	{
		ChatMessage anglerCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ANGLERFISH_CAUGHT_MESSAGE, "", 0);
		ChatMessage extraFishCaughtMessage = new ChatMessage(null, ChatMessageType.SPAM, "", EXTRA_FISH_CAUGHT_MESSAGE, "", 0);

		fishingPlugin.onChatMessage(anglerCaughtMessage);
		fishingPlugin.onChatMessage(anglerCaughtMessage);
		fishingPlugin.onChatMessage(extraFishCaughtMessage);

		XpTrackerSkillReset magicHrResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS_PER_HR, Skill.MAGIC);
		fishingPlugin.onXpTrackerSkillReset(magicHrResetEvent);
		assertSessionStats(2, 2, 1, 1);

		XpTrackerSkillReset fishingHrResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS_PER_HR, Skill.FISHING);
		fishingPlugin.onXpTrackerSkillReset(fishingHrResetEvent);
		assertSessionStats(2, 0, 1, 0);
	}

	void assertSessionStats(int amountFished, int amountFishedSinceReset, int amountExtraFished, int amountExtraFishedSinceReset)
	{
		assertNotNull(fishingPlugin.getSession().getLastFishCaught());
		assertEquals(fishingPlugin.getSession().getFishCaught(), amountFished);
		assertEquals(fishingPlugin.getSession().getFishCaughtSinceHrReset(), amountFishedSinceReset);
		assertEquals(fishingPlugin.getSession().getExtraFishCaught(), amountExtraFished);
		assertEquals(fishingPlugin.getSession().getExtraFishCaughtSinceHrReset(), amountExtraFishedSinceReset);
	}
}
