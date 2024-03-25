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
		assertEquals(SolvedState.NO_DATA, library.getState());
		library.mark(0, Book.RADAS_JOURNEY);
		assertEquals(SolvedState.INCOMPLETE, library.getState());
		library.mark(library.step, Book.KILLING_OF_A_KING);
		assertEquals(SolvedState.COMPLETE, library.getState());

		// The Varlamore Envoy book can be found in this bookcase, but should not cause a state reset if not found
		library.mark(library.step * 2, null);
		assertEquals(SolvedState.COMPLETE, library.getState());
		library.mark(library.step * 2, Book.VARLAMORE_ENVOY);
		assertEquals(SolvedState.COMPLETE, library.getState());

		// not valid, should reset
		library.mark(library.step * 2, Book.TRANSPORTATION_INCANTATIONS);
		assertEquals(SolvedState.INCOMPLETE, library.getState());
	}
}
