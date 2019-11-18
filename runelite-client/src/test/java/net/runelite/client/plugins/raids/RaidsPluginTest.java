/*
 * Copyright (c) 2019, Alexsuperfly <github.com/Alexsuperfly>
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
package net.runelite.client.plugins.raids;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.raids.solver.Layout;
import net.runelite.client.plugins.raids.solver.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.concurrent.ScheduledExecutorService;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RaidsPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	ChatColorConfig chatColorConfig;

	@Mock
	@Bind
	RuneLiteConfig runeliteConfig;

	@Mock
	@Bind
	RaidsConfig raidsConfig;

	@Inject
	RaidsPlugin raidsPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(raidsConfig.whitelistedRooms()).thenReturn("");
		when(raidsConfig.blacklistedRooms()).thenReturn("");
		when(raidsConfig.whitelistedRotations()).thenReturn("");
		when(raidsConfig.whitelistedLayouts()).thenReturn("");
	}

	@Test
	public void testRotationWhitelistSpaces()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("[Muttadiles, Tekton, Mystics]");
		raidsPlugin.updateLists();
		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Layout raidLayout = new Layout();
		raidLayout.add(new Room(0, 'c'));
		raidLayout.add(new Room(1, 'c'));
		raidLayout.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms);
		raidsPlugin.getRaid().setLayout(raidLayout);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistQuotes()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("[\"Muttadiles\",\"Tekton\",\"Mystics\"]");
		raidsPlugin.updateLists();
		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Layout raidLayout = new Layout();
		raidLayout.add(new Room(0, 'c'));
		raidLayout.add(new Room(1, 'c'));
		raidLayout.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms);
		raidsPlugin.getRaid().setLayout(raidLayout);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistSpacesAndQuotes()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("[\"Muttadiles\", \"Tekton\", \"Mystics\"]");
		raidsPlugin.updateLists();
		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Layout raidLayout = new Layout();
		raidLayout.add(new Room(0, 'c'));
		raidLayout.add(new Room(1, 'c'));
		raidLayout.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms);
		raidsPlugin.getRaid().setLayout(raidLayout);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistGarbled()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("  [\"Mu   tta    di    les\"   ,    \"   Te   kt   on\"  ,  \"Mysti   cs\"   ]   ");
		raidsPlugin.updateLists();
		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Layout raidLayout = new Layout();
		raidLayout.add(new Room(0, 'c'));
		raidLayout.add(new Room(1, 'c'));
		raidLayout.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms);
		raidsPlugin.getRaid().setLayout(raidLayout);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testLargeRotationWhitelist()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("[\"Muttadiles\",\"Tekton\",\"Mystics\"], " +
				"[\"Vespula\", \"guardians\", \"muttadiles\", \"tekton\"], " +
				"[\"muttadiles\",\"guardians\", \"vespula\"], " +
				"[vanguards,mystics,tekton,muttadiles]," +
				"[vasa, vanguards, mystics, tekton]," +
				"[guardians ,mystics,  SHAMANS,  muttadiles]," +
				"[shamans, mystics, guardians, vasa]," +
				"[vasa,guardians,mystics,shamans]," +
				"[shamans,muttadiles,vanguards,vespula]," +
				"[mystics,tekton,muttadiles,guardians]");
		raidsPlugin.updateLists();

		final RaidRoom[] raidRooms1 = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Layout raidLayout1 = new Layout();
		raidLayout1.add(new Room(0, 'c'));
		raidLayout1.add(new Room(1, 'c'));
		raidLayout1.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms1);
		raidsPlugin.getRaid().setLayout(raidLayout1);
		assertTrue(raidsPlugin.getRotationMatches());

		final RaidRoom[] raidRooms2 = new RaidRoom[]{RaidRoom.VASA, RaidRoom.VANGUARDS, RaidRoom.MYSTICS, RaidRoom.TEKTON};
		Layout raidLayout2 = new Layout();
		raidLayout2.add(new Room(0, 'c'));
		raidLayout2.add(new Room(1, 'c'));
		raidLayout2.add(new Room(2, 'c'));
		raidLayout2.add(new Room(3, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms2);
		raidsPlugin.getRaid().setLayout(raidLayout2);
		assertTrue(raidsPlugin.getRotationMatches());

		final RaidRoom[] raidRooms3 = new RaidRoom[]{RaidRoom.SHAMANS, RaidRoom.MUTTADILES, RaidRoom.VANGUARDS, RaidRoom.VESPULA};
		Layout raidLayout3 = new Layout();
		raidLayout3.add(new Room(0, 'c'));
		raidLayout3.add(new Room(1, 'c'));
		raidLayout3.add(new Room(2, 'c'));
		raidLayout3.add(new Room(3, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms3);
		raidsPlugin.getRaid().setLayout(raidLayout3);
		assertTrue(raidsPlugin.getRotationMatches());

		final RaidRoom[] raidRooms4 = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.GUARDIANS, RaidRoom.VESPULA};
		Layout raidLayout4 = new Layout();
		raidLayout4.add(new Room(0, 'c'));
		raidLayout4.add(new Room(1, 'c'));
		raidLayout4.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms4);
		raidsPlugin.getRaid().setLayout(raidLayout4);
		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistBackwards()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("[muttadiles, tekton, mystics]");
		raidsPlugin.updateLists();
		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MYSTICS, RaidRoom.TEKTON, RaidRoom.MUTTADILES};
		Layout raidLayout = new Layout();
		raidLayout.add(new Room(0, 'c'));
		raidLayout.add(new Room(1, 'c'));
		raidLayout.add(new Room(2, 'c'));
		raidsPlugin.setRaid(new Raid());
		raidsPlugin.getRaid().setRooms(raidRooms);
		raidsPlugin.getRaid().setLayout(raidLayout);

		assertFalse(raidsPlugin.getRotationMatches());
	}
}
