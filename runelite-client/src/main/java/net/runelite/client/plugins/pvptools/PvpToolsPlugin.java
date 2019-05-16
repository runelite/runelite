/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.pvptools;

import com.google.inject.Provides;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.SkullIcon;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.clanchat.ClanChatPlugin;
import static net.runelite.client.plugins.pvptools.PvpToolsPanel.htmlLabel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.PvPUtil;
import static net.runelite.client.util.StackFormatter.quantityToRSDecimalStack;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "PvP Tools",
	description = "Enable the PvP Tools panel",
	tags = {"panel", "pvp", "pk", "pklite", "renderself"},
	type = PluginType.PVP
)
public class PvpToolsPlugin extends Plugin
{
	@Inject
	PvpToolsOverlay pvpToolsOverlay;

	boolean fallinHelperEnabled = false;
	private PvpToolsPanel panel;
	private MissingPlayersJFrame missingPlayersJFrame;
	private CurrentPlayersJFrame currentPlayersJFrame;
	private NavigationButton navButton;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean attackHotKeyPressed;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hideAll;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	private PvpToolsPlugin uhPvpToolsPlugin = this;

	/**
	 * ActionListener for the missing cc members and refresh buttons
	 */
	final ActionListener playersButtonActionListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (missingPlayersJFrame != null)
			{
				missingPlayersJFrame.dispose();
				missingPlayersJFrame = null;
				missingPlayersJFrame = new MissingPlayersJFrame(client, uhPvpToolsPlugin, getMissingMembers());
			}
			else
			{
				missingPlayersJFrame = new MissingPlayersJFrame(client, uhPvpToolsPlugin, getMissingMembers());
			}
		}
	};

	final ActionListener currentPlayersActionListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (currentPlayersJFrame != null)
			{
				currentPlayersJFrame.dispose();
				currentPlayersJFrame = null;
				currentPlayersJFrame = new CurrentPlayersJFrame(client, uhPvpToolsPlugin, getCurrentMembers());
			}
			else
			{
				currentPlayersJFrame = new CurrentPlayersJFrame(client, uhPvpToolsPlugin, getCurrentMembers());
			}
		}
	};


	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private KeyManager keyManager;

	@Inject
	private PvpToolsConfig config;

	/**
	 * The HotKeyListener for the hot key assigned in the config that triggers the Fall In Helper feature
	 */
	private final HotkeyListener fallinHotkeyListener = new HotkeyListener(() -> config.hotkey())
	{
		public void hotkeyPressed()
		{
			toggleFallinHelper();
		}
	};

	private final HotkeyListener renderselfHotkeyListener = new HotkeyListener(() -> config.renderSelf())
	{
		public void hotkeyPressed()
		{
			client.toggleRenderSelf();
		}
	};

	private int[] overheadCount = new int[]{0, 0, 0};

	private List<String> getMissingMembers()
	{
		CopyOnWriteArrayList<Player> ccMembers = ClanChatPlugin.getClanMembers();
		ArrayList<String> missingMembers = new ArrayList<>();
		for (ClanMember clanMember : client.getClanMembers())
		{
			if (!Objects.isNull(clanMember))
			{
				List<String> arrayList = ccMembers.stream().map(player -> Text.removeTags(Text.standardize(player.getName()))).collect(Collectors.toList());
				if (!arrayList.contains(Text.removeTags(Text.standardize(clanMember.getUsername()))))
				{
					if (!missingMembers.contains(clanMember.getUsername()))
					{
						missingMembers.add("[W" + clanMember.getWorld() + "] - " + clanMember.getUsername());
					}
				}
			}
		}

		return missingMembers;
	}

	private List<String> getCurrentMembers()
	{
		CopyOnWriteArrayList<Player> ccMembers = ClanChatPlugin.getClanMembers();
		ArrayList<String> currentMembers = new ArrayList<>();
		for (ClanMember clanMember : client.getClanMembers())
		{
			if (!Objects.isNull(clanMember))
			{
				List<String> arrayList = ccMembers.stream().map(player -> Text.removeTags(Text.standardize(player.getName()))).collect(Collectors.toList());
				if (arrayList.contains(Text.removeTags(Text.standardize(clanMember.getUsername()))))
				{
					if (!currentMembers.contains(clanMember.getUsername()))
					{
						currentMembers.add(clanMember.getUsername());
					}
				}
			}
		}

		return currentMembers;
	}


	@Provides
	PvpToolsConfig config(ConfigManager configManager)
	{
		return configManager.getConfig(PvpToolsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(pvpToolsOverlay);

		keyManager.registerKeyListener(fallinHotkeyListener);
		keyManager.registerKeyListener(renderselfHotkeyListener);
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "skull.png");

		panel = new PvpToolsPanel();
		panel.init();

		navButton = NavigationButton.builder()
			.tooltip("PvP Tools")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		panel.missingPlayers.addActionListener(playersButtonActionListener);
		panel.currentPlayers.addActionListener(currentPlayersActionListener);
		clientToolbar.addNavigation(navButton);


		if (config.missingPlayersEnabled())
		{
			panel.missingPlayers.setVisible(true);
		}

		if (config.currentPlayersEnabled())
		{
			panel.currentPlayers.setVisible(true);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(pvpToolsOverlay);
		keyManager.unregisterKeyListener(fallinHotkeyListener);
		keyManager.unregisterKeyListener(renderselfHotkeyListener);
		clientToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("pvptools"))
		{
			switch (configChanged.getKey())
			{
				case "countPlayers":
					if (config.countPlayers())
					{
						updatePlayers();
					}
					if (!config.countPlayers())
					{
						panel.disablePlayerCount();
					}
					break;
				case "countOverHeads":
					if (config.countOverHeads())
					{
						countOverHeads();
					}
					if (!config.countOverHeads())
					{
						panel.disablePrayerCount();
					}
					break;
				case "riskCalculator":
					if (config.riskCalculatorEnabled())
					{
						getCarriedWealth();
					}
					if (!config.riskCalculatorEnabled())
					{
						panel.disableRiskCalculator();
					}
					break;
				case "missingPlayers":
					if (config.missingPlayersEnabled())
					{
						panel.missingPlayers.setVisible(true);
					}
					break;
				case "currentPlayers":
					if (config.currentPlayersEnabled())
					{
						panel.currentPlayers.setVisible(true);
					}
					break;
				default:
					break;
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer().equals(client.getItemContainer(InventoryID.INVENTORY)) &&
			config.riskCalculatorEnabled())
		{
			getCarriedWealth();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState().equals(GameState.LOGGED_IN) && config.riskCalculatorEnabled())
		{
			getCarriedWealth();
		}
		if (event.getGameState().equals(GameState.LOGGED_IN))
		{
			if (config.countPlayers())
			{
				updatePlayers();
			}
		}
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		if (config.countPlayers() && PvPUtil.isAttackable(client, event.getPlayer()))
		{
			updatePlayers();
		}
		if (config.countOverHeads())
		{
			countOverHeads();
		}
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned event)
	{
		if (config.countPlayers() && PvPUtil.isAttackable(client, event.getPlayer()))
		{
			updatePlayers();
		}
		if (config.countOverHeads())
		{
			countOverHeads();
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		if (config.attackOptionsFriend() || config.attackOptionsClan() || config.levelRangeAttackOptions())
		{
			if (client.getGameState() != GameState.LOGGED_IN)
			{
				return;
			}
			Player[] players = client.getCachedPlayers();
			Player player = null;
			int identifier = menuEntryAdded.getIdentifier();
			if (identifier >= 0 && identifier < players.length)
			{
				player = players[identifier];
			}
			if (player == null)
			{
				return;
			}
			if (attackHotKeyPressed && config.attackOptionsClan() || config.attackOptionsFriend() ||
				config.levelRangeAttackOptions())
			{
				if (config.attackOptionsFriend() && player.isFriend())
				{
					moveEntry();
				}
				if (config.attackOptionsClan() && player.isClanMember())
				{
					moveEntry();
				}
				if (config.levelRangeAttackOptions() && !PvPUtil.isAttackable(client, player))
				{
					moveEntry();
				}
			}
		}
	}

	private void moveEntry()
	{
		MenuEntry[] menuEntries = client.getMenuEntries();
		MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

		if (lastEntry.getOption().contains("attack".toLowerCase()))
		{
			ArrayUtils.shift(menuEntries, 1);
			//ArrayUtils.add(menuEntries, menuEntries.length - 2);
			//menuEntries = ArrayUtils.remove(menuEntries, menuEntries.length - 1);
			//menuEntrySwapperPlugin.swap("attack", option, mtarget, false); TODO: Make sure to use menuutil when uncommenting this
		}
		if (lastEntry.getOption().equals("Attack"))
		{
			ArrayUtils.shift(menuEntries, 1);
		}

		client.setMenuEntries(menuEntries);

	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setAttackHotKeyPressed(false);
		}
	}

	/**
	 * Enables or disables the fall in helper feature
	 */
	private void toggleFallinHelper()
	{
		if (!fallinHelperEnabled)
		{
			client.setIsHidingEntities(true);
			client.setPlayersHidden(true);
			fallinHelperEnabled = true;
		}
		else
		{
			client.setIsHidingEntities(false);
			client.setPlayersHidden(false);
			fallinHelperEnabled = false;
		}

	}

	/**
	 * Updates the PvP Tools panel with the numbers for enemy protection prayers
	 */
	private void updatePrayerNumbers()
	{
		panel.numMageJLabel.setText(htmlLabel("Enemies Praying Mage: ", String.valueOf(overheadCount[0])));
		panel.numRangeJLabel.setText(htmlLabel("Enemies Praying Range: ", String.valueOf(overheadCount[1])));
		panel.numMeleeJLabel.setText(htmlLabel("Enemies Praying Melee: ", String.valueOf(overheadCount[2])));
		panel.numMageJLabel.repaint();
		panel.numRangeJLabel.repaint();
		panel.numMeleeJLabel.repaint();
	}

	/**
	 *
	 */
	private void updatePlayers()
	{
		if (config.countPlayers())
		{
			int cc = 0;
			int other = 0;
			for (Player p : client.getPlayers())
			{
				if (Objects.nonNull(p))
				{
					if (PvPUtil.isAttackable(client, p))
					{
						if (p.isClanMember())
						{
							cc++;
						}
						else
						{
							other++;
						}
					}
				}
			}

			panel.numOther.setText(htmlLabel("Other Player Count: ", String.valueOf(other)));
			panel.numCC.setText(htmlLabel("Friendly Player Count: ", String.valueOf(cc)));
			panel.numCC.repaint();
			panel.numOther.repaint();
		}
	}

	private void countOverHeads()
	{
		overheadCount = new int[]{0, 0, 0};
		for (Player p : client.getPlayers())
		{
			if (Objects.nonNull(p))
			{
				if (PvPUtil.isAttackable(client, p))
				{
					if (!p.isClanMember() && !(p.getOverheadIcon() == null))
					{
						switch (p.getOverheadIcon())
						{
							case MAGIC:
								overheadCount[0]++;
								break;
							case RANGED:
								overheadCount[1]++;
								break;
							case MELEE:
								overheadCount[2]++;
								break;
						}
					}
				}
			}
		}
		updatePrayerNumbers();
	}

	/**
	 * Calculates the player's risk based on Item Price of all items in their inventory and equipment
	 */
	private void getCarriedWealth()
	{
		if (!config.riskCalculatorEnabled())
		{
			return;
		}
		if (client.getItemContainer(InventoryID.EQUIPMENT) == null)
		{
			return;
		}
		if (client.getItemContainer(InventoryID.INVENTORY).getItems() == null)
		{
			return;
		}
		Item[] items = ArrayUtils.addAll(Objects.requireNonNull(client.getItemContainer(InventoryID.EQUIPMENT)).getItems(),
			Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems());
		TreeMap<Integer, Item> priceMap = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
		int wealth = 0;
		for (Item i : items)
		{
			int value = (itemManager.getItemPrice(i.getId()) * i.getQuantity());

			final ItemComposition itemComposition = itemManager.getItemComposition(i.getId());
			if (!itemComposition.isTradeable() && value == 0)
			{
				value = itemComposition.getPrice() * i.getQuantity();
				priceMap.put(value, i);
			}
			else
			{
				value = itemManager.getItemPrice(i.getId()) * i.getQuantity();
				if (i.getId() > 0 && value > 0)
				{
					priceMap.put(value, i);
				}
			}
			wealth += value;
		}
		panel.totalRiskLabel.setText(htmlLabel("Total risk: ", quantityToRSDecimalStack(wealth)));
		panel.totalRiskLabel.repaint();

		int itemLimit = 0;
		if (client.getLocalPlayer().getSkullIcon() != null)
		{
			if (client.getLocalPlayer().getSkullIcon() == SkullIcon.SKULL)
			{
				itemLimit = 1;
			}
		}
		if (client.getLocalPlayer().getSkullIcon() == null)
		{
			itemLimit = 4;
		}

		AsyncBufferedImage itemImage = null;

		NavigableMap<Integer, Item> descendingMap = priceMap.descendingMap();

		for (int i = 0; i < itemLimit; i++)
		{
			if (i == 0)
			{
				if (!descendingMap.isEmpty())
				{
					itemImage = itemManager.getImage(descendingMap.pollFirstEntry().getValue().getId());
				}
			}
			else
			{
				if (!descendingMap.isEmpty())
				{
					itemManager.getItemComposition(priceMap.descendingMap().pollFirstEntry().getValue().getId())
						.getName();
				}
			}
		}
		panel.riskProtectingItem.setText(htmlLabel("Risk Protecting Item: ",
			quantityToRSDecimalStack(descendingMap.keySet().stream().mapToInt(Integer::intValue).sum())));
		panel.riskProtectingItem.repaint();

		panel.biggestItemLabel.setText("Most Valuable Item: ");
		if (itemImage != null)
		{
			itemImage.addTo(panel.biggestItemLabel);
		}
		panel.biggestItemLabel.repaint();
	}

}
