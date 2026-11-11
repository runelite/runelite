/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu;

import net.runelite.api.Scene;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZoneTest
{
	@Test
	public void sharesStaticFaceOrderWithNeighboringZoneAndReleasesTemporaryCopy()
	{
		Zone source = new Zone();
		Zone destination = new Zone();
		Zone[][] zones = {{source}, {destination}};
		Zone.AlphaModel model = new Zone.AlphaModel();
		model.faceSorter = new AlphaFaceSorter(2, new int[]{0});
		model.lx = model.lz = 0;
		model.ux = 15;
		model.uz = 7;
		source.alphaModels.add(model);

		// A non-toplevel scene has no extended-scene coordinate offset.
		Scene scene = mock(Scene.class);
		when(scene.getWorldViewId()).thenReturn(1);
		source.multizoneLocs(scene, 0, 0, 1536, 512, zones);

		assertEquals(1, destination.alphaModels.size());
		Zone.AlphaModel copy = destination.alphaModels.get(0);
		try
		{
			assertSame(model.faceSorter, copy.faceSorter);
			assertFalse(copy.isTemp());
			assertEquals(Zone.AlphaModel.TEMP, copy.flags);
			assertEquals(Zone.AlphaModel.SKIP, model.flags);

			destination.removeTemp();
			source.removeTemp();

			assertTrue(destination.alphaModels.isEmpty());
			assertNull(copy.faceSorter);
			assertTrue(copy.isTemp());
			assertEquals(0, model.flags);
			assertEquals(1, source.alphaModels.size());
		}
		finally
		{
			Zone.modelCache.remove(copy);
		}
	}
}
