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
package net.runelite.client.plugins.aprilfools;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.FontID;
import net.runelite.api.GameState;
import net.runelite.api.ScriptEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "April Fools",
	description = ""
)
public class AprilFoolsPlugin extends Plugin
{
	private static final String[] SKILLS = {"Sailing", "Taming", "Shamanism"};
	private static final int[] SPRITE_IDS = {10001, 10002, 10003};

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private final Random random = new Random();

	@Override
	protected void startUp() throws Exception
	{
		for (int i = 0; i < 3; ++i)
		{
			BufferedImage sailing = ImageUtil.loadImageResource(AprilFoolsPlugin.class, SKILLS[i].toLowerCase() + ".png");
			client.getSpriteOverrides().put(SPRITE_IDS[i], ImageUtil.getImageSpritePixels(sailing, client));
		}
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN && isApr1())
			{
				addFakeSkill();
			}
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		for (int i = 0; i < 3; ++i)
		{
			client.getSpriteOverrides().remove(SPRITE_IDS[i]);
		}
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				removeFakeSkill();
			}
		});
	}

	private static boolean isApr1()
	{
		LocalDate now = LocalDate.now();
		return now.getMonth() == Month.APRIL && now.getDayOfMonth() == 1;
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == 393 && isApr1()) // [clientscript,stats_init]
		{
			addFakeSkill();
		}
	}

	private void addFakeSkill()
	{
		int skillId = random.nextInt(3);
		String name = SKILLS[skillId];
		int sprite = SPRITE_IDS[skillId];

		Widget w = client.getWidget(320, 25);
		w.setHidden(true);
		w = client.getWidget(320, 26);
		w.setHidden(true);
		w = client.getWidget(320, 27);
		w.setHidden(true);

		w = client.getWidget(320, 24);

		w.deleteAllChildren();

		w.setHasListener(true);
		w.setOnMouseRepeatListener(992, ScriptEvent.WIDGET_ID, -1, 20971548, name + " XP:|Next level at:|Remaining XP:", "0|83|83", FontID.PLAIN_12, 5);
		w.setOnMouseLeaveListener(40, 20971548);

		Widget w0 = w.createChild(WidgetType.GRAPHIC);
		w0.setSpriteId(174);
		w0.setOriginalX(-2);
		w0.setOriginalY(-2);
		w0.setOriginalWidth(36);
		w0.setOriginalHeight(36);
		w0.revalidate();

		Widget w1 = w.createChild(WidgetType.GRAPHIC);
		w1.setSpriteId(175);
		w1.setOriginalX(28);
		w1.setOriginalY(-2);
		w1.setOriginalWidth(36);
		w1.setOriginalHeight(36);
		w1.revalidate();

		Widget w2 = w.createChild(WidgetType.GRAPHIC);
		w2.setSpriteId(sprite);
		w2.setOriginalX(5);
		w2.setOriginalY(4);
		w2.setOriginalWidth(25);
		w2.setOriginalHeight(25);
		w2.revalidate();

		Widget w3 = w.createChild(WidgetType.TEXT);
		w3.setXTextAlignment(WidgetTextAlignment.CENTER);
		w3.setTextColor(0xffff00);
		w3.setText("1");
		w3.setFontId(FontID.PLAIN_11);
		w3.setOriginalX(32);
		w3.setOriginalY(4);
		w3.setOriginalWidth(15);
		w3.setOriginalHeight(12);
		w3.revalidate();

		Widget w4 = w.createChild(WidgetType.TEXT);
		w4.setXTextAlignment(WidgetTextAlignment.CENTER);
		w4.setTextColor(0xffff00);
		w4.setText("1");
		w4.setFontId(FontID.PLAIN_11);
		w4.setOriginalX(44);
		w4.setOriginalY(16);
		w4.setOriginalWidth(15);
		w4.setOriginalHeight(12);
		w4.revalidate();
	}

	private void removeFakeSkill()
	{
		Widget w = client.getWidget(320, 25);
		if (w != null)
		{
			w.setHidden(false);
		}
		w = client.getWidget(320, 26);
		if (w != null)
		{
			w.setHidden(false);
		}
		w = client.getWidget(320, 27);
		if (w != null)
		{
			w.setHidden(false);
		}

		w = client.getWidget(320, 24);
		if (w != null)
		{
			w.setHasListener(false);
			w.deleteAllChildren();
			w.setOnMouseRepeatListener((Object[]) null);
			w.setOnMouseLeaveListener((Object[]) null);
		}
	}
}
