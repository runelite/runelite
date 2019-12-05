/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.timestamp;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.TimeZone;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.events.ConfigChanged;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimestampPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	TimestampConfig config;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Inject
	TimestampPlugin plugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testGenerateTimestamp()
	{
		when(config.timestampFormat()).thenReturn("[yyyy:MM:dd:HH:hh:mm:ss]");

		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("timestamp");
		configChanged.setKey("format");
		configChanged.setNewValue("true");
		plugin.onConfigChanged(configChanged);

		int testInput = 1554667116;
		String testOutput = "[2019:04:07:15:03:58:36]";
		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		plugin.getFormatter().setTimeZone(timeZone);
		assertEquals(plugin.generateTimestamp(testInput, timeZone.toZoneId()), testOutput);
	}
}
