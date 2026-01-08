/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.entityhider;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Ignore;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NameableContainer;
import net.runelite.api.Player;
import net.runelite.client.callback.Hooks;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EntityHiderPluginTest
{
	@Inject
	EntityHiderPlugin plugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	EntityHiderConfig config;

	@Mock
	@Bind
	Hooks hooks;

	@Mock
	@Bind
	PartyService partyService;

	@Mock
	NameableContainer<Ignore> ignoreNameableContainer;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getIgnoreContainer()).thenReturn(ignoreNameableContainer);
	}

	@Test
	public void testHideFriendsPositive()
	{
		when(config.hideOthers()).thenReturn(true);
		when(config.hideFriends()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriend()).thenReturn(true);

		assertFalse(plugin.shouldDraw(player, false));

		player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriend()).thenReturn(false);

		assertFalse(plugin.shouldDraw(player, false));
	}

	@Test
	public void testHideFriendsNegative()
	{
		when(config.hideOthers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriend()).thenReturn(false);

		assertFalse(plugin.shouldDraw(player, false));

		player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriend()).thenReturn(true);

		assertTrue(plugin.shouldDraw(player, false));
	}

	@Test
	public void testHideClansPositivie()
	{
		when(config.hideOthers()).thenReturn(true);
		when(config.hideFriendsChatMembers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriendsChatMember()).thenReturn(true);

		assertFalse(plugin.shouldDraw(player, false));

		player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriendsChatMember()).thenReturn(false);

		assertFalse(plugin.shouldDraw(player, false));
	}

	@Test
	public void testHideClansNegative()
	{
		when(config.hideOthers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriendsChatMember()).thenReturn(false);

		assertFalse(plugin.shouldDraw(player, false));

		player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(player.isFriendsChatMember()).thenReturn(true);

		assertTrue(plugin.shouldDraw(player, false));
	}

	//	hidenpc hideattacker hidden?
	//	t       t            t iif attacker would be hidden
	//	t       f            f
	//	f       t            t
	//	f       f            f
	@Test
	public void testHideAndAttacker()
	{
		when(config.hideNPCs2D()).thenReturn(true);
		when(config.hideAttackers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		NPCComposition composition = mock(NPCComposition.class);

		NPC npc = mock(NPC.class);
		when(npc.getComposition()).thenReturn(composition);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		when(npc.getInteracting()).thenReturn(player);

		assertFalse(plugin.shouldDraw(npc, true));
		assertTrue(plugin.shouldDraw(npc, false));
	}

	@Test
	public void testHideAndNoAttacker()
	{
		when(config.hideNPCs2D()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		NPCComposition composition = mock(NPCComposition.class);

		NPC npc = mock(NPC.class);
		when(npc.getComposition()).thenReturn(composition);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		when(npc.getInteracting()).thenReturn(player);

		assertTrue(plugin.shouldDraw(npc, true));
		assertTrue(plugin.shouldDraw(npc, false));
	}

	@Test
	public void testHideAttacker()
	{
		when(config.hideAttackers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		NPCComposition composition = mock(NPCComposition.class);

		NPC npc = mock(NPC.class);
		when(npc.getComposition()).thenReturn(composition);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		when(npc.getInteracting()).thenReturn(player);

		assertFalse(plugin.shouldDraw(npc, true));
		assertFalse(plugin.shouldDraw(npc, false));
	}

	@Test
	public void testHidePartyMembersPositive()
	{
		when(config.hidePartyMembers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("test player");

		PartyMember partyMember = mock(PartyMember.class);
		when(partyService.isInParty()).thenReturn(true);
		when(partyService.getMemberByDisplayName(eq("test player"))).thenReturn(partyMember);

		assertFalse(plugin.shouldDraw(player, true));
		assertFalse(plugin.shouldDraw(player, false));
	}

	@Test
	public void testHidePartyMembersNegative()
	{
		when(config.hidePartyMembers()).thenReturn(true);

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(EntityHiderConfig.GROUP);
		plugin.onConfigChanged(configChanged);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("test player");

		when(partyService.isInParty()).thenReturn(true);
		when(partyService.getMemberByDisplayName("test player")).thenReturn(null);

		assertTrue(plugin.shouldDraw(player, true));
		assertTrue(plugin.shouldDraw(player, false));
	}
}