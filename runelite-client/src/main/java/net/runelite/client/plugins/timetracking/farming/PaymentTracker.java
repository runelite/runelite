/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timetracking.farming;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.ScriptID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetModelType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Slf4j
@RequiredArgsConstructor(
	access = AccessLevel.PRIVATE,
	onConstructor = @__({@Inject})
)
@Singleton
public class PaymentTracker
{
	private static final Set<String> PAYMENT_TEXT = ImmutableSet.of(
		"That'll do nicely, sir. Leave it with me - I'll make sure<br>that patch grows for you.",
		"That'll do nicely, madam. Leave it with me - I'll make<br>sure that patch grows for you.",
		"That'll do nicely. Leave it with me - I'll make sure that<br>patch grows for you.",
		"That'll do nicely, iknami. Leave it with me - I'll make<br>sure that patch grows for you."
	);

	private final Client client;
	private final ConfigManager configManager;
	private final FarmingWorld farmingWorld;

	private int lastSelectedOption;

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		Widget text = client.getWidget(InterfaceID.ChatLeft.TEXT);
		if (text == null || !PAYMENT_TEXT.contains(text.getText()))
		{
			return;
		}

		Widget name = client.getWidget(InterfaceID.ChatLeft.NAME);
		Widget head = client.getWidget(InterfaceID.ChatLeft.HEAD);
		if (name == null || head == null || head.getModelType() != WidgetModelType.NPC_CHATHEAD)
		{
			return;
		}

		final int npcId = head.getModelId();
		final FarmingPatch patch = findPatchForNpc(npcId);
		if (patch == null)
		{
			return;
		}

		if (getProtectedState(patch))
		{
			return;
		}

		log.debug("Detected patch payment for {} ({}) patch {}", name.getText(), npcId, patch);
		setProtectedState(patch, true);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked opt)
	{
		var action = opt.getMenuAction();
		// look for resume_pausebutton from click
		if (action == MenuAction.WIDGET_CONTINUE)
		{
			var w = opt.getWidget();
			if (w != null && w.getId() == InterfaceID.Chatmenu.OPTIONS && w.getIndex() > -1 && isPatchOption(w.getText()))
			{
				lastSelectedOption = w.getIndex() - 1; // subid 0 is "Select an Option"
				log.debug("Selected option via click: {}", lastSelectedOption);
			}
		}
		// look for selecting the Pay NPC option
		else if ((action == MenuAction.NPC_THIRD_OPTION || action == MenuAction.NPC_FOURTH_OPTION) && opt.getMenuOption().startsWith("Pay"))
		{
			lastSelectedOption = action == MenuAction.NPC_THIRD_OPTION ? 0 : 1;
			log.debug("Selected option via npc op: {}", lastSelectedOption);
		}
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		// look for resume_pausebutton from keypress
		if (scriptPreFired.getScriptId() == ScriptID.CHATBOX_KEYINPUT_MATCHED)
		{
			int[] intStack = client.getIntStack();

			int componentId = intStack[0];
			int subId = intStack[1];

			var w = client.getWidget(componentId).getChild(subId);
			if (componentId == InterfaceID.Chatmenu.OPTIONS && subId > -1 && isPatchOption(w.getText()))
			{
				lastSelectedOption = subId - 1; // subid 0 is "Select an Option"
				log.debug("Selected option via keypress: {}", lastSelectedOption);
			}
		}
	}

	private static boolean isPatchOption(String name)
	{
		if (name == null)
		{
			return false;
		}

		return name.contains("Patch") || name.contains("allotment");
	}

	private static String configKey(FarmingPatch fp)
	{
		return fp.configKey() + "." + TimeTrackingConfig.PROTECTED;
	}

	void setProtectedState(FarmingPatch fp, boolean state)
	{
		if (!state)
		{
			configManager.unsetRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey(fp));
		}
		else
		{
			configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey(fp), state);
		}
	}

	boolean getProtectedState(FarmingPatch fp)
	{
		return Boolean.TRUE.equals(configManager.getRSProfileConfiguration(
			TimeTrackingConfig.CONFIG_GROUP,
			configKey(fp),
			Boolean.class));
	}

	private FarmingPatch findPatchForNpc(int npcId)
	{
		FarmingPatch p = null;
		for (FarmingRegion region : farmingWorld.getRegionsForLocation(client.getLocalPlayer().getWorldLocation()))
		{
			for (FarmingPatch patch : region.getPatches())
			{
				if (patch.getFarmer() == npcId)
				{
					// lastSelectedOption is only valid when interacting with multi-patch farmers.
					if (patch.getPatchNumber() == -1 || patch.getPatchNumber() == lastSelectedOption)
					{
						p = patch;
					}
				}
			}
		}
		return p;
	}
}
