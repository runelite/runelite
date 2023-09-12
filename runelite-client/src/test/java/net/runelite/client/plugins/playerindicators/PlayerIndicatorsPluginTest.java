/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.playerindicators;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Color;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerIndicatorsPluginTest
{
	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private PlayerIndicatorsOverlay playerIndicatorsOverlay;

	@Mock
	@Bind
	private PlayerIndicatorsTileOverlay playerIndicatorsTileOverlay;

	@Mock
	@Bind
	private PlayerIndicatorsMinimapOverlay playerIndicatorsMinimapOverlay;

	@Mock
	@Bind
	private ChatIconManager chatIconManager;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private PlayerIndicatorsService playerIndicatorsService;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private PlayerIndicatorsConfig playerIndicatorsConfig;

	@Inject
	private PlayerIndicatorsPlugin plugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testDecorateTarget()
	{
		when(playerIndicatorsConfig.colorPlayerMenu()).thenReturn(true);

		String t0 = "title0";
		String name = "RuneLite";
		String t1 = "title1";
		String t2 = "title2";
		String col = "<col=ff>";

		String cmbLevel =  col + t0 + name + t1 + col + "  (level-126)" + t2;
		String skillTotal = col + t0 + name + t1 + "  (skill-1234)" + t2;

		// widget names contains the col tags
		String useCmb = "<col=ff9040>Earth rune</col>" + col + " -> " + cmbLevel;
		String useSkill = "<col=ff9040>Earth rune</col>" + col + " -> " + skillTotal;

		var deco = new PlayerIndicatorsService.Decorations(null, null, Color.RED);

		assertEquals("<col=ff0000>title0RuneLitetitle1<col=ff>  (level-126)title2", plugin.decorateTarget(cmbLevel, deco));
		assertEquals("<col=ff0000>title0RuneLitetitle1  (skill-1234)title2", plugin.decorateTarget(skillTotal, deco));

		assertEquals("<col=ff9040>Earth rune</col><col=ff> -> <col=ff0000>title0RuneLitetitle1<col=ff>  (level-126)title2", plugin.decorateTarget(useCmb, deco));
		assertEquals("<col=ff9040>Earth rune</col><col=ff> -> <col=ff0000>title0RuneLitetitle1  (skill-1234)title2", plugin.decorateTarget(useSkill, deco));
	}
}