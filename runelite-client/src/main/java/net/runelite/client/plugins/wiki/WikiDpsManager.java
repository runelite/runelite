/*
 * Copyright (c) 2024 LlemonDuck
 * Copyright (c) 2024, Jayden Bailey <jayden@weirdgloop.org>
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.wiki;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.LinkBrowser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Singleton
class WikiDpsManager
{
	private static final int[] SPRITE_IDS_INACTIVE = {
		SpriteID.TRADEBACKING_LIGHT,
		SpriteID.V2StoneButtonOut.A_TOP_LEFT,
		SpriteID.V2StoneButtonOut.A_TOP_RIGHT,
		SpriteID.V2StoneButtonOut.A_BOTTOM_LEFT,
		SpriteID.V2StoneButtonOut.A_BOTTOM_RIGHT,
		SpriteID.V2StoneButtonOut.A_MAP_EDGE_LEFT,
		SpriteID.V2StoneButtonOut.A_MAP_EDGE_TOP,
		SpriteID.V2StoneButtonOut.A_MAP_EDGE_RIGHT,
		SpriteID.V2StoneButtonOut.A_MAP_EDGE_BOTTOM,
	};

	private static final int[] SPRITE_IDS_ACTIVE = {
		SpriteID.TRADEBACKING_DARK,
		SpriteID.V2StoneButtonIn.A_TOP_LEFT,
		SpriteID.V2StoneButtonIn.A_TOP_RIGHT,
		SpriteID.V2StoneButtonIn.A_BOTTOM_LEFT,
		SpriteID.V2StoneButtonIn.A_BOTTOM_RIGHT,
		SpriteID.V2StoneButtonIn.A_LEFT,
		SpriteID.V2StoneButtonIn.A_TOP,
		SpriteID.V2StoneButtonIn.A_RIGHT,
		SpriteID.V2StoneButtonIn.A_BOTTOM,
	};

	private static final int FONT_COLOUR_INACTIVE = 0xff981f;
	private static final int FONT_COLOUR_ACTIVE = 0xffffff;

	private static final String UI_ENDPOINT = "https://tools.runescape.wiki/osrs-dps/";
	private static final String SHORTLINK_ENDPOINT = "https://tools.runescape.wiki/osrs-dps/shortlink";

	private final Client client;
	private final ClientThread clientThread;
	private final EventBus eventBus;
	private final OkHttpClient okHttpClient;
	private final Gson gson;

	@Inject
	private WikiDpsManager(
		Client client,
		ClientThread clientThread,
		EventBus eventBus,
		OkHttpClient okHttpClient,
		Gson gson
	)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.eventBus = eventBus;
		this.okHttpClient = okHttpClient;
		this.gson = gson;
	}

	public void startUp()
	{
		eventBus.register(this);
		clientThread.invokeLater(this::rebuild);
	}

	public void shutDown()
	{
		eventBus.unregister(this);
		clientThread.invokeLater(this::rebuild);
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.EQUIPMENT_SET_STAT_BONUS_SETUP)
		{
			var args = event.getScriptEvent().getArguments();
			int layer = (int) args[1]; // the button to the next page

			log.debug("EQUIPMENT_SET_STAT_BONUS_SETUP: layer {}.{}",
				WidgetUtil.componentToInterface(layer), WidgetUtil.componentToId(layer));

			clientThread.invokeLater(() -> addButton(layer, this::launch));
		}
	}

	/**
	 * Shifts over the Set Bonus / Stat Bonus buttons
	 * and adds new widgets to make a visually equal button with a different name.
	 */
	private void addButton(int btnLayer, Runnable onClick)
	{
		Widget setBonus = client.getWidget(btnLayer);
		Widget parent = setBonus.getParent();
		Widget[] btnChld = setBonus.getChildren();

		final int padding = 4;
		// now shift the Equipment Effects/Stats button over a bit to make room
		setBonus.setOriginalX(Math.max(setBonus.getOriginalX() - (setBonus.getOriginalWidth() / 2) - padding, padding))
			.revalidate();

		// Since the Set Bonus button uses absolute positioning,
		// we must also use absolute for all the children below,
		// which means it's necessary to offset the values by simulating corresponding pos/size modes.
		final int w = setBonus.getOriginalWidth();
		final int h = setBonus.getOriginalHeight();
		final int x = setBonus.getOriginalX() + setBonus.getOriginalWidth() + padding;
		final int y = setBonus.getOriginalY();

		final Widget[] spriteWidgets = new Widget[9];

		// the background uses ABSOLUTE_CENTER and MINUS sizing
		int bgWidth = w - btnChld[0].getOriginalWidth();
		int bgHeight = h - btnChld[0].getOriginalHeight();
		int bgX = (x + btnChld[0].getOriginalX()) + (w - bgWidth) / 2;
		int bgY = (y + btnChld[0].getOriginalY()) + (h - bgHeight) / 2;
		spriteWidgets[0] = parent.createChild(-1, WidgetType.GRAPHIC)
			.setSpriteId(btnChld[0].getSpriteId())
			.setPos(bgX, bgY)
			.setSize(bgWidth, bgHeight)
			.setYPositionMode(setBonus.getYPositionMode());
		spriteWidgets[0].revalidate();

		// borders and corners
		for (int i = 1; i < 9; i++)
		{
			Widget c = spriteWidgets[i] = parent.createChild(-1, WidgetType.GRAPHIC)
				.setSpriteId(btnChld[i].getSpriteId())
				.setSize(btnChld[i].getOriginalWidth(), btnChld[i].getOriginalHeight());
			if (setBonus.getYPositionMode() == WidgetPositionMode.ABSOLUTE_CENTER)
			{
				// Convert x/y from the reference component's, whose parent is the Set Bonus layer,
				// to our components whose parent is the bank equipment parent.
				// For y we have to reverse the ABSOLUTE_CENTER y calculation to convert
				// the reference component original y into an offset from where the client will
				// compute the ABSOLUTE_CENTER y to be.
				c.setPos(x + btnChld[i].getOriginalX(), y - (setBonus.getHeight() - btnChld[i].getHeight() + 1) / 2 + btnChld[i].getOriginalY())
					.setYPositionMode(setBonus.getYPositionMode());
			}
			else
			{
				c.setPos(x + btnChld[i].getOriginalX(), y + btnChld[i].getOriginalY());
			}

			spriteWidgets[i].revalidate();
		}

		// text label uses ABSOLUTE_CENTER positioning and MINUS sizing,
		// but matches size of parent so effectively no-op
		final Widget text = parent.createChild(-1, WidgetType.TEXT)
			.setText("View DPS")
			.setTextColor(FONT_COLOUR_INACTIVE)
			.setFontId(btnChld[9].getFontId())
			.setTextShadowed(btnChld[9].getTextShadowed())
			.setXTextAlignment(btnChld[9].getXTextAlignment())
			.setYTextAlignment(btnChld[9].getYTextAlignment())
			.setPos(x, y)
			.setSize(w, h)
			.setYPositionMode(setBonus.getYPositionMode());
		text.revalidate();

		// we'll give the text layer the listeners since it covers the whole area
		text.setHasListener(true);
		text.setOnMouseOverListener((JavaScriptCallback) ev ->
		{
			for (int i = 0; i <= 8; i++)
			{
				spriteWidgets[i].setSpriteId(SPRITE_IDS_ACTIVE[i]);
			}
			text.setTextColor(FONT_COLOUR_ACTIVE);
		});
		text.setOnMouseLeaveListener((JavaScriptCallback) ev ->
		{
			for (int i = 0; i <= 8; i++)
			{
				spriteWidgets[i].setSpriteId(SPRITE_IDS_INACTIVE[i]);
			}
			text.setTextColor(FONT_COLOUR_INACTIVE);
		});

		// register a click listener
		text.setAction(0, "View DPS on OSRS Wiki");
		text.setOnOpListener((JavaScriptCallback) ev -> onClick.run());

		// recompute locations / sizes on parent
		parent.revalidate();
	}

	private void rebuild()
	{
		Widget w = client.getWidget(InterfaceID.Equipment.NEXT_PAGE);
		if (w != null)
		{
			var listener = w.getOnLoadListener();
			client.runScript(listener);

			w.getParent().deleteAllChildren();
		}

		w = client.getWidget(InterfaceID.Bankmain.NEXT_PAGE);
		if (w != null)
		{
			var listener = w.getOnLoadListener();
			client.runScript(listener);

			w.getParent().deleteAllChildren();
		}
	}

	@Nullable
	private JsonObject createEquipmentObject(ItemContainer itemContainer, EquipmentInventorySlot slot)
	{
		if (itemContainer == null)
		{
			return null;
		}

		if (slot == EquipmentInventorySlot.BOOTS && itemContainer.count() == 1 && itemContainer.contains(ItemID.CHEFS_HAT))
		{
			JsonObject o = new JsonObject();
			o.addProperty("id", ItemID.TEMPLETREK_SNAIL_SHELL);
			return o;
		}

		Item item = itemContainer.getItem(slot.getSlotIdx());
		if (item != null)
		{
			JsonObject o = new JsonObject();
			o.addProperty("id", item.getId());
			return o;
		}
		return null;
	}

	private JsonObject buildShortlinkData()
	{
		JsonObject j = new JsonObject();

		// Build the player's loadout data
		JsonArray loadouts = new JsonArray();
		ItemContainer eqContainer = client.getItemContainer(InventoryID.WORN);

		JsonObject l = new JsonObject();
		JsonObject eq = new JsonObject();

		eq.add("ammo", createEquipmentObject(eqContainer, EquipmentInventorySlot.AMMO));
		eq.add("body", createEquipmentObject(eqContainer, EquipmentInventorySlot.BODY));
		eq.add("cape", createEquipmentObject(eqContainer, EquipmentInventorySlot.CAPE));
		eq.add("feet", createEquipmentObject(eqContainer, EquipmentInventorySlot.BOOTS));
		eq.add("hands", createEquipmentObject(eqContainer, EquipmentInventorySlot.GLOVES));
		eq.add("head", createEquipmentObject(eqContainer, EquipmentInventorySlot.HEAD));
		eq.add("legs", createEquipmentObject(eqContainer, EquipmentInventorySlot.LEGS));
		eq.add("neck", createEquipmentObject(eqContainer, EquipmentInventorySlot.AMULET));
		eq.add("ring", createEquipmentObject(eqContainer, EquipmentInventorySlot.RING));
		eq.add("shield", createEquipmentObject(eqContainer, EquipmentInventorySlot.SHIELD));
		eq.add("weapon", createEquipmentObject(eqContainer, EquipmentInventorySlot.WEAPON));
		l.add("equipment", eq);

		JsonObject skills = new JsonObject();
		skills.addProperty("atk", client.getRealSkillLevel(Skill.ATTACK));
		skills.addProperty("def", client.getRealSkillLevel(Skill.DEFENCE));
		skills.addProperty("hp", client.getRealSkillLevel(Skill.HITPOINTS));
		skills.addProperty("magic", client.getRealSkillLevel(Skill.MAGIC));
		skills.addProperty("mining", client.getRealSkillLevel(Skill.MINING));
		skills.addProperty("prayer", client.getRealSkillLevel(Skill.PRAYER));
		skills.addProperty("ranged", client.getRealSkillLevel(Skill.RANGED));
		skills.addProperty("str", client.getRealSkillLevel(Skill.STRENGTH));
		l.add("skills", skills);

		JsonObject buffs = new JsonObject();
		buffs.addProperty("inWilderness", client.getVarbitValue(VarbitID.INSIDE_WILDERNESS) == 1);
		buffs.addProperty("kandarinDiary", client.getVarbitValue(VarbitID.KANDARIN_DIARY_HARD_COMPLETE) == 1);
		buffs.addProperty("onSlayerTask", client.getVarpValue(VarPlayerID.SLAYER_COUNT) > 0);
		buffs.addProperty("chargeSpell", client.getVarpValue(VarPlayerID.MAGEARENA_CHARGE) > 0);
		l.add("buffs", buffs);

		l.addProperty("name", client.getLocalPlayer().getName());

		loadouts.add(l);
		j.add("loadouts", loadouts);

		return j;
	}

	private static class ShortlinkResponse
	{
		String data;
	}

	void launch()
	{
		JsonObject jsonBody = buildShortlinkData();
		Request request = new Request.Builder()
			.url(SHORTLINK_ENDPOINT)
			.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody.toString()))
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Failed to create shortlink for DPS calculator", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				try (response)
				{
					if (response.isSuccessful() && response.body() != null)
					{
						ShortlinkResponse resp = gson.fromJson(response.body().charStream(), ShortlinkResponse.class);
						LinkBrowser.browse(UI_ENDPOINT + "?id=" + resp.data);
					}
					else
					{
						log.warn("Failed to create shortlink for DPS calculator: http status {}", response.code());
					}
				}
			}
		});
	}
}
