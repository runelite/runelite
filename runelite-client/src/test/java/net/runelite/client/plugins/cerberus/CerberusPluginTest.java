/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.cerberus;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GameTick;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CerberusPluginTest
{
	@Mock
	@Bind
	OverlayManager overlayManager;

	@Inject
	CerberusPlugin cerberusPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testOnGameTick()
	{
		List<NPC> ghosts = cerberusPlugin.getGhosts();
		ghosts.addAll(Arrays.asList(
			mockNpc(new LocalPoint(0, 0)),
			mockNpc(new LocalPoint(1, 0)),
			mockNpc(new LocalPoint(0, 5)),
			mockNpc(new LocalPoint(2, 0)),
			mockNpc(new LocalPoint(2, 5)),
			mockNpc(new LocalPoint(1, 5))
		));
		cerberusPlugin.onGameTick(new GameTick());

		// Expected sort is by lowest y first, then by lowest x
		assertEquals(ghosts.get(0).getLocalLocation(), new LocalPoint(0, 0));
		assertEquals(ghosts.get(1).getLocalLocation(), new LocalPoint(1, 0));
		assertEquals(ghosts.get(2).getLocalLocation(), new LocalPoint(2, 0));

		assertEquals(ghosts.get(3).getLocalLocation(), new LocalPoint(0, 5));
		assertEquals(ghosts.get(4).getLocalLocation(), new LocalPoint(1, 5));
		assertEquals(ghosts.get(5).getLocalLocation(), new LocalPoint(2, 5));
	}

	private static NPC mockNpc(LocalPoint localPoint)
	{
		NPC npc = mock(NPC.class);
		when(npc.getLocalLocation()).thenReturn(localPoint);
		return npc;
	}
}