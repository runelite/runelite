/*
 * Copyright (c) 2020, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.Plugin;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InfoBoxManagerTest
{
	@Inject
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	private static class TestInfobox extends InfoBox
	{
		public TestInfobox(InfoBoxPriority infoBoxPriority)
		{
			super(null, mock(Plugin.class));
			setPriority(infoBoxPriority);
		}

		@Override
		public String getText()
		{
			return null;
		}

		@Override
		public Color getTextColor()
		{
			return null;
		}
	}

	@Test
	public void testSorting()
	{
		infoBoxManager.addInfoBox(new TestInfobox(InfoBoxPriority.LOW));
		infoBoxManager.addInfoBox(new TestInfobox(InfoBoxPriority.HIGH));
		infoBoxManager.addInfoBox(new TestInfobox(InfoBoxPriority.MED));

		List<InfoBoxPriority> order = infoBoxManager.getInfoBoxes().stream().map(InfoBox::getPriority).collect(Collectors.toList());
		assertEquals(Arrays.asList(InfoBoxPriority.HIGH, InfoBoxPriority.MED, InfoBoxPriority.LOW), order);
	}
}