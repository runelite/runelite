/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.equipmentinspector;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.kit.KitType;
import net.runelite.api.util.Text;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.PlayerContainer;
import net.runelite.client.game.PlayerManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;

@PluginDescriptor(
	name = "Equipment Inspector",
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class EquipmentInspectorPlugin extends Plugin
{
	private static final String INSPECT_EQUIPMENT = "Gear";

	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private EquipmentInspectorConfig config;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private MenuManager menuManager;
	@Inject
	private ScheduledExecutorService executor;
	@Inject
	private ClientToolbar pluginToolbar;
	@Inject
	private PlayerManager playerManager;

	private NavigationButton navButton;
	private EquipmentInspectorPanel equipmentInspectorPanel;
	private boolean showValue;
	private int protectedItems;
	private boolean exactValue;

	@Provides
	EquipmentInspectorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EquipmentInspectorConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		equipmentInspectorPanel = injector.getInstance(EquipmentInspectorPanel.class);
		if (client != null)
		{
			menuManager.addPlayerMenuItem(INSPECT_EQUIPMENT);
		}

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(this.getClass(), "normal.png");

		navButton = NavigationButton.builder()
			.tooltip("Equipment Inspector")
			.icon(icon)
			.priority(5)
			.panel(equipmentInspectorPanel)
			.build();

		pluginToolbar.addNavigation(navButton);

	}

	@Override
	protected void shutDown()
	{
		menuManager.removePlayerMenuItem(INSPECT_EQUIPMENT);
		pluginToolbar.removeNavigation(navButton);
	}

	@Subscribe
	private void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (!event.getMenuOption().equals(INSPECT_EQUIPMENT))
		{
			return;
		}

		executor.execute(() ->
		{
			try
			{
				SwingUtilities.invokeAndWait(() ->
				{
					if (!navButton.isSelected())
					{
						navButton.getOnSelect().run();
					}
				});
			}
			catch (InterruptedException | InvocationTargetException e)
			{
				throw new RuntimeException(e);
			}

			String playerName = Text.removeTags(event.getMenuTarget()).replace('\u00A0', ' ');
			final PlayerContainer player = playerManager.getPlayer(playerName);
			final Map<KitType, ItemDefinition> playerEquipment = new HashMap<>();

			if (player == null)
			{
				return;
			}

			for (KitType kitType : KitType.values())
			{
				if (kitType == KitType.RING || kitType == KitType.AMMUNITION ||
					player.getPlayer().getPlayerAppearance() == null)
				{
					continue;
				}

				final int itemId = player.getPlayer().getPlayerAppearance().getEquipmentId(kitType);

				if (itemId != -1)
				{
					ItemDefinition itemComposition = client.getItemDefinition(itemId);
					playerEquipment.put(kitType, itemComposition);
				}
			}

			if (this.showValue)
			{
				final LinkedHashMap<Integer, Integer> gear = new LinkedHashMap<>(player.getGear());
				removeEntries(gear, this.protectedItems);

				int risk = 0;
				for (int value : gear.values())
				{
					risk += value;
				}

				String price;

				if (!this.exactValue)
				{
					price = QuantityFormatter.quantityToRSDecimalStack(risk);
				}
				else
				{
					price = NumberFormat.getIntegerInstance().format(risk);
				}

				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(new ChatMessageBuilder()
						.append(ChatColorType.HIGHLIGHT)
						.append("Risked Value: ")
						.append(ChatColorType.NORMAL)
						.append(price)
						.build())
					.build());
			}
			equipmentInspectorPanel.update(playerEquipment, playerName);
		});
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equalsIgnoreCase("equipmentinspector"))
		{
			updateConfig();
		}
	}

	private static void removeEntries(LinkedHashMap<Integer, Integer> map, int quantity)
	{
		for (int i = 0; i < quantity; i++)
		{
			if (!map.entrySet().iterator().hasNext())
			{
				return;
			}
			map.entrySet().remove(map.entrySet().iterator().next());
		}
	}

	private void updateConfig()
	{
		this.showValue = config.showValue();
		this.protectedItems = config.protectedItems();
		this.exactValue = config.exactValue();
	}
}
