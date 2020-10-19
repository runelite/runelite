/*
 * Copyright (c) 2020 Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.kourendlibrary;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.coords.WorldPoint;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest
{
	@Inject
	private Library library;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testVarlamoreEnvoyFindingProcess()
	{
		library.mark(new WorldPoint(1610, 3799, 1), null);
		library.mark(new WorldPoint(1608, 3799, 1), null);
		library.mark(new WorldPoint(1615, 3799, 1), null);
		library.mark(new WorldPoint(1616, 3799, 1), null);
		library.mark(new WorldPoint(1621, 3799, 1), null);
		library.mark(new WorldPoint(1624, 3796, 1), null);
		library.mark(new WorldPoint(1624, 3792, 1), null);
		library.mark(new WorldPoint(1624, 3791, 1), null);
		library.mark(new WorldPoint(1623, 3789, 1), null);

		assertEquals(SolvedState.NO_DATA, library.getState());

		library.mark(new WorldPoint(1621, 3789, 1), Book.WINTERTODT_PARABLE);

		assertEquals(SolvedState.INCOMPLETE, library.getState());

		library.mark(new WorldPoint(1618, 3799, 2), null);
		library.mark(new WorldPoint(1613, 3792, 2), null);
		library.mark(new WorldPoint(1618, 3790, 2), Book.TRANSPORTATION_INCANTATIONS);
		library.mark(new WorldPoint(1609, 3816, 2), Book.RICKTORS_DIARY_7);

		assertEquals(SolvedState.COMPLETE, library.getState());

		// The Varlamore Envoy book can be found in this bookcase, but should not cause a state reset if not found
		library.mark(new WorldPoint(1622, 3816, 2), null);

		assertEquals(SolvedState.COMPLETE, library.getState());
	}
}
