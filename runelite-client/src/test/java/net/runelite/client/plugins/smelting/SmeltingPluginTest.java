/*
 * Copyright (c) 2019, Stephen <stepzhu@umich.edu>
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
package net.runelite.client.plugins.smelting;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
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
public class SmeltingPluginTest
{
	private static final String SMELT_CANNONBALL = "You remove the cannonballs from the mould";
	private static final String SMELT_BAR = "You retrieve a bar of steel.";
	private static final String SMELT_EXTRA_BAR = "The Varrock platebody enabled you to smelt your next ore simultaneously.";

	@Inject
	SmeltingPlugin smeltingPlugin;

	@Mock
	@Bind
	SmeltingConfig config;

	@Mock
	@Bind
	SmeltingOverlay smeltingOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCannonballs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_CANNONBALL, "", 0);
		smeltingPlugin.onChatMessage(chatMessage);

		assertSessionStats(0, 0, 0, 0, 4);
	}

	@Test
	public void testBars()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_BAR, "", 0);
		smeltingPlugin.onChatMessage(chatMessage);

		assertSessionStats(1, 1, 0, 0, 0);
	}

	@Test
	public void testExtraBars()
	{
		ChatMessage barMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_BAR, "", 0);
		ChatMessage extraBarMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_EXTRA_BAR, "", 0);
		smeltingPlugin.onChatMessage(barMessage);
		smeltingPlugin.onChatMessage(extraBarMessage);

		assertSessionStats(1, 1, 1, 1, 0);
	}

	@Test
	public void testSmeltingSkillReset()
	{
		ChatMessage barMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_BAR, "", 0);
		ChatMessage extraBarMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_EXTRA_BAR, "", 0);

		smeltingPlugin.onChatMessage(barMessage);
		smeltingPlugin.onChatMessage(barMessage);
		smeltingPlugin.onChatMessage(extraBarMessage);

		XpTrackerSkillReset magicResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS, Skill.MAGIC);
		smeltingPlugin.onXpTrackerSkillReset(magicResetEvent);
		assertSessionStats(2, 2, 1, 1, 0);

		XpTrackerSkillReset smeltingResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS, Skill.SMITHING);
		smeltingPlugin.onXpTrackerSkillReset(smeltingResetEvent);
		assertSessionStats(0, 0, 0, 0, 0);
	}

	@Test
	public void testSmeltingSkillHrReset()
	{
		ChatMessage barMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_BAR, "", 0);
		ChatMessage extraBarMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_EXTRA_BAR, "", 0);

		smeltingPlugin.onChatMessage(barMessage);
		smeltingPlugin.onChatMessage(barMessage);
		smeltingPlugin.onChatMessage(extraBarMessage);

		XpTrackerSkillReset magicHrResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS_PER_HR, Skill.MAGIC);
		smeltingPlugin.onXpTrackerSkillReset(magicHrResetEvent);
		assertSessionStats(2, 2, 1, 1, 0);

		XpTrackerSkillReset smeltingHrResetEvent = new XpTrackerSkillReset(XpTrackerSkillReset.ResetType.ACTIONS_PER_HR, Skill.SMITHING);
		smeltingPlugin.onXpTrackerSkillReset(smeltingHrResetEvent);
		assertSessionStats(2, 0, 1, 0, 0);
	}

	void assertSessionStats(int amountSmelted, int amountSmeltedSinceReset, int amountExtraSmelted, int amountExtraSmeltedSinceReset, int amountCannonballs)
	{
		assertNotNull(smeltingPlugin.getSession().getLastItemSmelted());
		assertEquals(smeltingPlugin.getSession().getBarsSmelted(), amountSmelted);
		assertEquals(smeltingPlugin.getSession().getBarsSmeltedSinceHrReset(), amountSmeltedSinceReset);
		assertEquals(smeltingPlugin.getSession().getExtraBarsSmelted(), amountExtraSmelted);
		assertEquals(smeltingPlugin.getSession().getExtraBarsSmeltedSinceHrReset(), amountExtraSmeltedSinceReset);
		assertEquals(smeltingPlugin.getSession().getCannonBallsSmelted(), amountCannonballs);
	}
}
