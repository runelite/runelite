/*
 * Copyright (c) 2020, Plondrein <plondrein@gmail.com>
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
package net.runelite.client.plugins.construction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Construction",
	description = "Show how many items your servant is holding",
	tags = {"construction", "overlay"}
)
public class ConstructionPlugin extends Plugin
{
	private static final Pattern X_HELD_ITEMS_PATTERN = Pattern.compile("(\\d{1,2}) items");

	@Getter(AccessLevel.PACKAGE)
	private int itemsCount;

	@Getter(AccessLevel.PACKAGE)
	private NPC servant;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ServantOverlay overlay;

	@Inject
	private Client client;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		servant = null;
		itemsCount = 0;
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();

		if (isServant(npc))
		{
			this.servant = npc;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			servant = null;
			itemsCount = 0;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		if (npcDespawned.getNpc() == servant)
		{
			servant = null;
			itemsCount = 0;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog == null)
		{
			return;
		}

		Widget npcHead = client.getWidget(WidgetInfo.DIALOG_NPC_HEAD_MODEL);
		if (!isServantSpeaking(npcHead.getModelId()))
		{
			return;
		}

		String npcText = Text.sanitizeMultilineText(npcDialog.getText());

		itemsCount = extractItemCount(npcText);
	}

	private boolean isServantSpeaking(int npcId)
	{
		return servant != null && servant.getId() == npcId;
	}

	private boolean isServant(NPC npc)
	{
		return Servant.findServant(npc.getId()) != null;
	}

	private int extractItemCount(String npcText)
	{
		Matcher mXItems = X_HELD_ITEMS_PATTERN.matcher(npcText);
		if (mXItems.find())
		{
			return Integer.parseInt(mXItems.group(1));
		}

		String lastItemTextPart = Servant.findServant(servant.getId()).getLastHeldItemTextPart();

		if (npcText.contains(lastItemTextPart))
		{
			return 1;
		}

		return 0;
	}
}
