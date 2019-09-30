/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;


@AllArgsConstructor
enum Role
{
	ATTACKER(WidgetInfo.BA_ATK_WAVE_TEXT, WidgetInfo.BA_ATK_LISTEN_TOP_TEXT, WidgetInfo.BA_ATK_HORN_LISTEN_TEXT,
			WidgetInfo.BA_ATK_CALL_TEXT, WidgetInfo.BA_COLL_HORN_LISTEN_TEXT, WidgetInfo.BA_ATK_ROLE_TEXT,
			WidgetInfo.BA_ATK_ROLE_SPRITE),
	DEFENDER(WidgetInfo.BA_DEF_WAVE_TEXT, WidgetInfo.BA_DEF_LISTEN_TEXT, WidgetInfo.BA_DEF_HORN_LISTEN_TEXT,
			WidgetInfo.BA_DEF_CALL_TEXT, WidgetInfo.BA_HEAL_HORN_LISTEN_TEXT, WidgetInfo.BA_DEF_ROLE_TEXT,
			WidgetInfo.BA_DEF_ROLE_SPRITE),
	COLLECTOR(WidgetInfo.BA_COLL_WAVE_TEXT, WidgetInfo.BA_COLL_LISTEN_TEXT, WidgetInfo.BA_COLL_HORN_LISTEN_TEXT,
			WidgetInfo.BA_COLL_CALL_TEXT, WidgetInfo.BA_ATK_HORN_LISTEN_TEXT, WidgetInfo.BA_COLL_ROLE_TEXT,
			WidgetInfo.BA_COLL_ROLE_SPRITE),
	HEALER(WidgetInfo.BA_HEAL_WAVE_TEXT, WidgetInfo.BA_HEAL_LISTEN_TEXT, WidgetInfo.BA_DEF_HORN_LISTEN_TEXT,
			WidgetInfo.BA_HEAL_CALL_TEXT, WidgetInfo.BA_DEF_HORN_LISTEN_TEXT, WidgetInfo.BA_HEAL_ROLE_TEXT,
			WidgetInfo.BA_HEAL_ROLE_SPRITE);

	@Getter
	private final WidgetInfo wave;
	@Getter
	private final WidgetInfo listen;
	@Getter
	private final WidgetInfo gloryListen;
	@Getter
	private final WidgetInfo call;
	@Getter
	private final WidgetInfo gloryCall;
	@Getter
	private final WidgetInfo roleText;
	@Getter
	private final WidgetInfo roleSprite;

	// Duplicate* entries are to catch instances where the horn of glory has
	// text different than the normal horn
	private static final ImmutableMap<String, String> TELLS = ImmutableMap.<String, String>builder()
			.put("Red egg", "Tell-red")
			.put("Green egg", "Tell-green")
			.put("Blue egg", "Tell-blue")
			.put("Controlled/Bullet/Wind", "Tell-controlled")
			.put("Accurate/Field/Water", "Tell-accurate")
			.put("Aggressive/Blunt/Earth", "Tell-aggressive")
			.put("Defensive/Barbed/Fire", "Tell-defensive")
			.put("Tofu", "Tell-tofu")
			.put("Crackers", "Tell-crackers")
			.put("Worms", "Tell-worms")
			.put("Poison Worms", "Tell-worms")
			.put("Pois. Worms", "Tell-worms")
			.put("Poison Tofu", "Tell-tofu")
			.put("Pois. Tofu", "Tell-tofu")
			.put("Poison Meat", "Tell-meat")
			.put("Pois. Meat", "Tell-meat")
			.build();
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
			.put("Defensive/", ItemID.BARBED_ARROW)
			.put("Aggressive/", ItemID.BLUNT_ARROW)
			.put("Accurate/", ItemID.FIELD_ARROW)
			.put("Controlled/", ItemID.BULLET_ARROW)
			.build();
	private static final ImmutableMap<String, String> SPLIT_LISTENS = ImmutableMap.<String, String>builder()
			.put("Controlled/", "Bullet/Wind")
			.put("Bullet/Wind", "Controlled/")
			.put("Accurate/", "Field/Water")
			.put("Field/Water", "Accurate/")
			.put("Aggressive/", "Blunt/Earth")
			.put("Blunt/Earth", "Aggressive/")
			.put("Defensive/", "Barbed/Fire")
			.put("Barbed/Fire", "Defensive/")
			.build();


	int getListenItem(String listen)
	{
		return ITEMS.getOrDefault(listen, -1);
	}

	String getTell(String call)
	{
		return TELLS.getOrDefault(call, "");
	}

	String getCall(Client client)
	{
		// Do not reverse these if statements to be more efficient
		// The normal widgets are no longer null/hidden after you
		// click one time in the horn, and the values are incorrect
		Widget callWidget = client.getWidget(getGloryCall());
		if (callWidget != null)
		{
			return GLORY_CALLS.get(callWidget.getText());
		}

		callWidget = client.getWidget(getCall());
		if (callWidget != null)
		{
			return callWidget.getText();
		}

		return null;
	}

	String getListen(Client client)
	{
		// See the comment in getCall(Client client), before editing
		Widget listenWidget = client.getWidget(getGloryListen());
		if (listenWidget != null)
		{
			return GLORY_CALLS.get(listenWidget.getText());
		}

		listenWidget = client.getWidget(getListen());
		if (listenWidget != null)
		{
			return listenWidget.getText();
		}

		return null;
	}

	static String getMissingListen(String listen)
	{
		return SPLIT_LISTENS.getOrDefault(listen, "- - -");
	}

	// I call it "Switchception" :wutwedoin:
	// Should probably switch to using an interface instead of an enum at this point
	String getCallFromTell(String listen)
	{
		switch (this)
		{
			case COLLECTOR:
				switch (listen)
				{
					case "Tell-controlled":
						return "Controlled/";
					case "Tell-accurate":
						return "Accurate/";
					case "Tell-aggressive":
						return "Aggressive/";
					case "Tell-defensive":
						return "Defensive/";
				}
				break;
			case ATTACKER:
				switch (listen)
				{
					case "Tell-red":
						return "Red egg";
					case "Tell-green":
						return "Green egg";
					case "Tell-blue":
						return "Blue egg";
				}
				break;
			case HEALER:
				switch (listen)
				{
					case "Tell-tofu":
						return "Tofu";
					case "Tell-crackers":
						return "Crackers";
					case "Tell-worms":
						return "Worms";
				}
				break;
			case DEFENDER:
				switch (listen)
				{
					case "Tell-meat":
						return "Pois. Meat";
					case "Tell-tofu":
						return "Pois. Tofu";
					case "Tell-worms":
						return "Pois. Worms";
				}
				break;
		}
		return null;
	}
}
