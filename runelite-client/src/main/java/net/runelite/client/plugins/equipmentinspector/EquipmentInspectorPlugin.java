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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.kit.KitType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.api.util.Text;

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
	@Nullable
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
	private EventBus eventBus;

	private NavigationButton navButton;
	private EquipmentInspectorPanel equipmentInspectorPanel;
	private int TotalPrice = 0;
	private int Prot1 = 0;
	private int Prot2 = 0;
	private int Prot3 = 0;
	private int Prot4 = 0;

	private boolean ShowValue;
	private int protecteditems;
	private boolean ExactValue;

	@Provides
	EquipmentInspectorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EquipmentInspectorConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

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
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		menuManager.removePlayerMenuItem(INSPECT_EQUIPMENT);
		pluginToolbar.removeNavigation(navButton);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(PlayerMenuOptionClicked.class, this, this::onPlayerMenuOptionClicked);
	}

	private void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(INSPECT_EQUIPMENT))
		{
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
				String playerName = Text.removeTags(event.getMenuTarget());
				// The player menu uses a non-breaking space in the player name, we need to replace this to compare
				// against the playerName in the player cache.
				String finalPlayerName = playerName.replace('\u00A0', ' ');
				List<Player> players = null;
				if (client != null)
				{
					players = client.getPlayers();
				}
				Optional<Player> targetPlayer = Optional.empty();
				if (players != null)
				{
					targetPlayer = players.stream()
						.filter(Objects::nonNull)
						.filter(p -> p.getName().equals(finalPlayerName)).findFirst();
				}

				if (targetPlayer.isPresent())
				{
					TotalPrice = 0;
					Prot1 = 0;
					Prot2 = 0;
					Prot3 = 0;
					Prot4 = 0;
					Player p = targetPlayer.get();
					Map<KitType, ItemDefinition> playerEquipment = new HashMap<>();

					for (KitType kitType : KitType.values())
					{
						if (kitType == KitType.RING)
						{
							continue; //prevents the equipment inspector from breaking
						}
						if (kitType == KitType.AMMUNITION)
						{
							continue;
						}

						int itemId = p.getPlayerAppearance().getEquipmentId(kitType);
						if (itemId != -1)
						{
							ItemDefinition itemComposition = client.getItemDefinition(itemId);
							playerEquipment.put(kitType, itemComposition);
							int ItemPrice = itemManager.getItemPrice(itemId);
							TotalPrice += ItemPrice;
							if (ItemPrice > Prot1)
							{
								Prot4 = Prot3;
								Prot3 = Prot2;
								Prot2 = Prot1;

								Prot1 = ItemPrice;
							}
							else if (ItemPrice > Prot2)
							{
								Prot4 = Prot3;
								Prot3 = Prot2;
								Prot2 = ItemPrice;
							}
							else if (ItemPrice > Prot3)
							{
								Prot4 = Prot3;
								Prot3 = ItemPrice;
							}
							else if (ItemPrice > Prot4)
							{
								Prot4 = ItemPrice;
							}
						}
					}
					int IgnoredItems = this.protecteditems;
					if (IgnoredItems != 0 && IgnoredItems != 1 && IgnoredItems != 2 && IgnoredItems != 3)
					{
						IgnoredItems = 4;

					}
					if (this.ShowValue)
					{
						switch (IgnoredItems)
						{
							case 1:
								TotalPrice = TotalPrice - Prot1;
								break;
							case 2:
								TotalPrice = TotalPrice - Prot1;
								TotalPrice = TotalPrice - Prot2;

								break;
							case 3:
								TotalPrice = TotalPrice - Prot1;
								TotalPrice = TotalPrice - Prot2;
								TotalPrice = TotalPrice - Prot3;
								break;
							case 4:
								TotalPrice = TotalPrice - Prot1;
								TotalPrice = TotalPrice - Prot2;
								TotalPrice = TotalPrice - Prot3;
								TotalPrice = TotalPrice - Prot4;
								break;
						}
						String StringPrice = "";
						if (!this.ExactValue)
						{
							TotalPrice = TotalPrice / 1000;
							StringPrice = NumberFormat.getIntegerInstance().format(TotalPrice);
							StringPrice = StringPrice + 'K';
						}
						if (this.ExactValue)
						{
							StringPrice = NumberFormat.getIntegerInstance().format(TotalPrice);
						}
						chatMessageManager.queue(QueuedMessage.builder()
							.type(ChatMessageType.CONSOLE)
							.runeLiteFormattedMessage(new ChatMessageBuilder()
								.append(ChatColorType.HIGHLIGHT)
								.append("Risked Value: ")
								.append(ChatColorType.NORMAL)
								.append(StringPrice)
								.build())
							.build());
					}
					equipmentInspectorPanel.update(playerEquipment, playerName);

				}
			});
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equalsIgnoreCase("equipmentinspector"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.ShowValue = config.ShowValue();
		this.protecteditems = config.protecteditems();
		this.ExactValue = config.ExactValue();
	}
}
