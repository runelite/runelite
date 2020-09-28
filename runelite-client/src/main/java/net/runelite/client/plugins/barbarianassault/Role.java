/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@AllArgsConstructor
enum Role
{
	ATTACKER("Attacker", Color.RED,
		WidgetInfo.BA_ATTACKER_WAVE_TEXT, WidgetInfo.BA_ATTACKER_LISTEN_TOP_TEXT, WidgetInfo.BA_HORN_OF_GLORY_ATTACKER_LISTEN_TEXT,
		WidgetInfo.BA_ATTACKER_CALL_TEXT, WidgetInfo.BA_HORN_OF_GLORY_COLLECTOR_LISTEN_TEXT, WidgetInfo.BA_ATTACKER_ROLE_TEXT,
		WidgetInfo.BA_ATTACKER_ROLE_SPRITE),
	DEFENDER("Defender", BarbarianAssaultPlugin.LIGHT_BLUE,
		WidgetInfo.BA_DEFENDER_WAVE_TEXT, WidgetInfo.BA_DEFENDER_LISTEN_TEXT, WidgetInfo.BA_HORN_OF_GLORY_DEFENDER_LISTEN_TEXT,
		WidgetInfo.BA_DEFENDER_CALL_TEXT, WidgetInfo.BA_HORN_OF_GLORY_HEALER_LISTEN_TEXT, WidgetInfo.BA_DEFENDER_ROLE_TEXT,
		WidgetInfo.BA_DEFENDER_ROLE_SPRITE),
	COLLECTOR("Collector", Color.YELLOW,
		WidgetInfo.BA_COLLECTOR_WAVE_TEXT, WidgetInfo.BA_COLLECTOR_LISTEN_TEXT, WidgetInfo.BA_HORN_OF_GLORY_COLLECTOR_LISTEN_TEXT,
		WidgetInfo.BA_COLLECTOR_CALL_TEXT, WidgetInfo.BA_HORN_OF_GLORY_ATTACKER_LISTEN_TEXT, WidgetInfo.BA_COLLECTOR_ROLE_TEXT,
		WidgetInfo.BA_COLLECTOR_ROLE_SPRITE),
	HEALER("Healer", BarbarianAssaultPlugin.DARK_GREEN,
		WidgetInfo.BA_HEALER_WAVE_TEXT, WidgetInfo.BA_HEALER_LISTEN_TEXT, WidgetInfo.BA_HORN_OF_GLORY_DEFENDER_LISTEN_TEXT,
		WidgetInfo.BA_HEALER_CALL_TEXT, WidgetInfo.BA_HORN_OF_GLORY_DEFENDER_LISTEN_TEXT, WidgetInfo.BA_HEALER_ROLE_TEXT,
		WidgetInfo.BA_HEALER_ROLE_SPRITE);

	@Getter
	private final String name;
	@Getter
	private final Color color;
	@Getter
	private final WidgetInfo wave;
	@Getter
	private final WidgetInfo listen;
	@Getter
	private final WidgetInfo hornOfGloryListen;
	@Getter
	private final WidgetInfo call;
	@Getter
	private final WidgetInfo hornOfGloryCall;
	@Getter
	private final WidgetInfo roleText;
	@Getter
	private final WidgetInfo roleSprite;

	@Override
	public String toString()
	{
		return name();
	}

	private static final ImmutableMap<String, String> GLORY_CALLS = ImmutableMap.<String, String>builder()
		.put("Controlled/Bullet/Wind", "Controlled/")
		.put("Accurate/Field/Water", "Accurate/")
		.put("Aggressive/Blunt/Earth", "Aggressive/")
		.put("Defensive/Barbed/Fire", "Defensive/")
		.put("Tofu", "Tofu")
		.put("Crackers", "Crackers")
		.put("Worms", "Worms")
		.put("Poison worms", "Pois. Worms")
		.put("Poison tofu", "Pois. Tofu")
		.put("Poison meat", "Pois. Meat")
		.put("Red egg", "Red egg")
		.put("Green egg", "Green egg")
		.put("Blue egg", "Blue egg")
		.build();

	private static final ImmutableMap<String, Integer> ITEMS = ImmutableMap.<String, Integer>builder()
		.put("Tofu", ItemID.TOFU)
		.put("Crackers", ItemID.CRACKERS)
		.put("Worms", ItemID.WORMS)
		.put("Pois. Worms", ItemID.POISONED_WORMS)
		.put("Pois. Tofu", ItemID.POISONED_TOFU)
		.put("Pois. Meat", ItemID.POISONED_MEAT)
		.put("Controlled/", ItemID.BULLET_ARROW)
		.put("Accurate/", ItemID.FIELD_ARROW)
		.put("Aggressive/", ItemID.BLUNT_ARROW)
		.put("Defensive/", ItemID.BARBED_ARROW)
		.put("Red eggs", ItemID.RED_EGG)
		.put("Green eggs", ItemID.GREEN_EGG)
		.put("Blue eggs", ItemID.BLUE_EGG)
		.build();

	int getListenItemId(Client client)
	{
		final String listen = getListenText(client);
		return ITEMS.getOrDefault(listen, -1);
	}

	String getListenText(Client client)
	{
		return getWidgetText(client, hornOfGloryListen, listen);
	}

	String getCallText(Client client)
	{
		return getWidgetText(client, hornOfGloryCall, call);
	}

	private String getWidgetText(Client client, WidgetInfo hornOfGlory, WidgetInfo widgetInfo)
	{
		Widget widget = client.getWidget(hornOfGlory);
		if (widget != null)
		{
			return GLORY_CALLS.get(widget.getText());
		}

		widget = client.getWidget(widgetInfo);
		if (widget != null)
		{
			return widget.getText();
		}

		return null;
	}
}
