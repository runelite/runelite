/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

package net.runelite.client.plugins.fairyring;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.SoundEffectID;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.DBTableID;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Fairy Rings",
	description = "Show the location of the fairy ring teleport",
	tags = {"teleportation"}
)
public class FairyRingPlugin extends Plugin
{
	private static final String[] leftDial = {"A", "D", "C", "B"};
	private static final String[] middleDial = {"I", "L", "K", "J"};
	private static final String[] rightDial = {"P", "S", "R", "Q"};

	private static final String EDIT_TAGS_MENU_OPTION = "Edit Tags";

	@Inject
	private Client client;

	@Inject
	private FairyRingConfig config;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	private ChatboxTextInput tagInput;

	@Provides
	FairyRingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FairyRingConfig.class);
	}

	@Override
	public void resetConfiguration()
	{
		List<String> extraKeys = configManager.getConfigurationKeys(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS);
		for (String prefix : extraKeys)
		{
			List<String> keys = configManager.getConfigurationKeys(prefix);
			for (String key : keys)
			{
				String[] str = key.split("\\.", 2);
				if (str.length == 2)
				{
					configManager.unsetConfiguration(str[0], str[1]);
				}
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setWidgetTextToDestination();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == InterfaceID.FAIRYRINGS_LOG)
		{
			setWidgetTextToDestination();
		}
	}

	private void setWidgetTextToDestination()
	{
		Widget fairyRingTeleportButton = client.getWidget(InterfaceID.Fairyrings.CONFIRM);
		if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden())
		{
			String destination;
			try
			{
				FairyRing fairyRingDestination = getFairyRingDestination(client.getVarbitValue(VarbitID.FAIRYRING_1),
					client.getVarbitValue(VarbitID.FAIRYRING_2), client.getVarbitValue(VarbitID.FAIRYRING_3));
				destination = fairyRingDestination.getDestination();
			}
			catch (IllegalArgumentException ex)
			{
				destination = "Invalid location";
			}

			fairyRingTeleportButton.setText(destination);
		}
	}

	private void openSearch()
	{
		var widget = client.getWidget(InterfaceID.FairyringsLog.SEARCH);
		if (widget != null)
		{
			client.setVarcStrValue(VarClientID.MESLAYERINPUT, "");
			client.createScriptEvent(widget.getOnOpListener())
				.setOp(1)
				.run();
		}
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent ev)
	{
		String code = null;
		if ("fairyringFilterFavorite".equals(ev.getEventName()))
		{
			var widget = client.getWidget(client.getIntStack()[client.getIntStackSize() - 2]);
			if (widget != null)
			{
				code = widget.getText();
			}
		}
		else if ("fairyringFilterDbrow".equals(ev.getEventName()))
		{
			code = (String) client.getDBTableField(client.getIntStack()[client.getIntStackSize() - 2], DBTableID.Fairyring.COL_CODE, 0)[0];
		}

		if (code != null && !code.isEmpty())
		{
			code = code.replace(" ", "");
			String tags = null;

			var ring = FairyRing.forCode(code);
			if (ring != null)
			{
				tags = ring.getTags();
			}

			var filter = client.getVarcStrValue(VarClientID.FAIRYRINGS_SEARCHSTRING).toLowerCase();

			if (code.toLowerCase().contains(filter)
				|| tags != null && tags.contains(filter)
				|| getConfigTags(code).stream().anyMatch(s -> s.contains(filter))
			)
			{
				client.getIntStack()[client.getIntStackSize() - 1] = 1;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		// This has to happen because the only widget that gets hidden is the tli one
		Widget fairyRingTeleportButton = client.getWidget(InterfaceID.Fairyrings.CONFIRM);
		boolean fairyRingWidgetOpen = fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden();
		boolean tagInputBoxOpen = tagInput != null && chatboxPanelManager.getCurrentInput() == tagInput;

		if (!fairyRingWidgetOpen && tagInputBoxOpen)
		{
			chatboxPanelManager.close();
		}
	}

	private FairyRing getFairyRingDestination(int varbitValueDialLeft, int varbitValueDialMiddle, int varbitValueDialRight)
	{
		return FairyRing.valueOf(leftDial[varbitValueDialLeft] + middleDial[varbitValueDialMiddle] + rightDial[varbitValueDialRight]);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (WidgetUtil.componentToInterface(event.getActionParam1()) == InterfaceID.FAIRYRINGS_LOG
			&& event.getOption().equals("Use code")
			&& !event.getTarget().isEmpty())
		{
			client.getMenu().createMenuEntry(-1)
				.setParam0(event.getActionParam0())
				.setParam1(event.getActionParam1())
				.setTarget(event.getTarget())
				.setOption(EDIT_TAGS_MENU_OPTION)
				.setType(MenuAction.RUNELITE)
				.setIdentifier(event.getIdentifier())
				.onClick(this::setTagMenuOpen);
		}
	}

	private List<String> getConfigTags(String fairyRingCode)
	{
		String config = Optional.ofNullable(configManager.getConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode)).orElse("").toLowerCase();
		return Text.fromCSV(config);
	}

	private void setConfigTags(String fairyRingCode, String tags)
	{
		if (Strings.isNullOrEmpty(tags))
		{
			configManager.unsetConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode);
		}
		else
		{
			configManager.setConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode, tags);
		}
	}

	private void setTagMenuOpen(MenuEntry menuEntry)
	{
		String code = Text.removeTags(menuEntry.getTarget()).replaceAll(" ", "");
		String initialValue = Text.toCSV(getConfigTags(code));
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		tagInput = chatboxPanelManager.openTextInput("Code " + code + " tags:")
			.value(initialValue)
			.onDone(s ->
			{
				setConfigTags(code, s);
				clientThread.invokeLater(() -> clientThread.invokeLater(this::openSearch));
			})
			.build();
	}
}
