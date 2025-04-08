/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
@Slf4j
public class ItemChargePlugin extends Plugin
{
	private static final Pattern DODGY_CHECK_PATTERN = Pattern.compile(
		"Your dodgy necklace has (\\d+) charges? left\\.");
	private static final Pattern DODGY_PROTECT_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It has (\\d+) charges? left\\.");
	private static final Pattern DODGY_BREAK_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It then crumbles to dust\\.");
	private static final String RING_OF_RECOIL_BREAK_MESSAGE = "Your Ring of Recoil has shattered.";
	private static final Pattern BINDING_CHECK_PATTERN = Pattern.compile(
		"You have ([0-9]+|one) charges? left before your Binding necklace disintegrates\\.");
	private static final Pattern BINDING_USED_PATTERN = Pattern.compile(
		"You (partially succeed to )?bind the temple's power into (mud|lava|steam|dust|smoke|mist) runes\\.");
	private static final String BINDING_BREAK_TEXT = "Your Binding necklace has disintegrated.";
	private static final Pattern RING_OF_FORGING_CHECK_PATTERN = Pattern.compile(
		"You can smelt ([0-9]+|one) more pieces? of iron ore before a ring melts\\.");
	private static final String RING_OF_FORGING_USED_TEXT = "You retrieve a bar of iron.";
	private static final String RING_OF_FORGING_BREAK_TEXT = "Your Ring of Forging has melted.";
	private static final String RING_OF_FORGING_VARROCK_PLATEBODY = "The Varrock platebody enabled you to smelt your next ore simultaneously.";
	private static final Pattern AMULET_OF_CHEMISTRY_CHECK_PATTERN = Pattern.compile(
		"Your amulet of chemistry has (\\d) charges? left\\."
	);
	private static final Pattern AMULET_OF_CHEMISTRY_USED_PATTERN = Pattern.compile(
		"Your amulet of chemistry helps you create a \\d-dose potion\\. It has (\\d|one) charges? left\\."
	);
	private static final Pattern AMULET_OF_CHEMISTRY_BREAK_PATTERN = Pattern.compile(
		"Your amulet of chemistry helps you create a \\d-dose potion\\. It then crumbles to dust\\."
	);
	private static final Pattern AMULET_OF_BOUNTY_CHECK_PATTERN = Pattern.compile(
		"Your amulet of bounty has (\\d+) charges? left\\."
	);
	private static final Pattern AMULET_OF_BOUNTY_USED_PATTERN = Pattern.compile(
		"Your amulet of bounty saves some seeds for you\\. It has (\\d) charges? left\\."
	);
	private static final String AMULET_OF_BOUNTY_BREAK_TEXT = "Your amulet of bounty saves some seeds for you. It then crumbles to dust.";
	private static final Pattern CHRONICLE_ADD_PATTERN = Pattern.compile(
		"You add (?:\\d+|a single) charges? to your book\\. It now has (\\d+|one) charges?\\."
	);
	private static final Pattern CHRONICLE_USE_AND_CHECK_PATTERN = Pattern.compile(
		"Your book has (\\d+) charges left\\."
	);
	private static final String CHRONICLE_FULL_TEXT = "Your book is fully charged! It has 1,000 charges already.";
	private static final String CHRONICLE_ONE_CHARGE_TEXT = "You have one charge left in your book.";
	private static final String CHRONICLE_EMPTY_TEXT = "Your book has run out of charges.";
	private static final String CHRONICLE_NO_CHARGES_TEXT = "Your book does not have any charges. Purchase some Teleport Cards from Diango.";
	private static final Pattern BRACELET_OF_SLAUGHTER_ACTIVATE_PATTERN = Pattern.compile(
		"Your bracelet of slaughter prevents your slayer count from decreasing. (?:It has (\\d{1,2}) charges? left\\.|It then crumbles to dust\\.|It then regenerates itself to full charge!)"
	);
	private static final Pattern BRACELET_OF_SLAUGHTER_CHECK_PATTERN = Pattern.compile(
		"Your bracelet of slaughter has (\\d{1,2}) charges? left\\."
	);
	private static final String BRACELET_OF_SLAUGHTER_BREAK_TEXT = "Your Bracelet of Slaughter has crumbled to dust.";
	private static final Pattern EXPEDITIOUS_BRACELET_ACTIVATE_PATTERN = Pattern.compile(
		"Your expeditious bracelet helps you progress your slayer (?:task )?faster. (?:It has (\\d{1,2}) charges? left\\.|It then crumbles to dust\\.|It then regenerates itself to full charge!)"
	);
	private static final Pattern EXPEDITIOUS_BRACELET_CHECK_PATTERN = Pattern.compile(
		"Your expeditious bracelet has (\\d{1,2}) charges? left\\."
	);
	private static final String EXPEDITIOUS_BRACELET_BREAK_TEXT = "Your Expeditious Bracelet has crumbled to dust.";
	private static final Pattern BLOOD_ESSENCE_CHECK_PATTERN = Pattern.compile(
		"Your blood essence has (\\d{1,4}) charges? remaining"
	);
	private static final Pattern BLOOD_ESSENCE_EXTRACT_PATTERN = Pattern.compile(
		"You manage to extract power from the Blood Essence and craft (\\d{1,3}) extra runes?\\."
	);
	private static final String BLOOD_ESSENCE_ACTIVATE_TEXT = "You activate the blood essence.";
	private static final String BRACELET_OF_CLAY_USE_TEXT = "You manage to mine some clay.";
	private static final String BRACELET_OF_CLAY_USE_TEXT_TRAHAEARN = "You manage to mine some soft clay.";
	private static final String BRACELET_OF_CLAY_BREAK_TEXT = "Your bracelet of clay crumbles to dust.";
	private static final Pattern BRACELET_OF_CLAY_CHECK_PATTERN = Pattern.compile(
		"You can mine (\\d{1,2}) more pieces? of soft clay before your bracelet crumbles to dust\\."
	);

	private static final int MAX_DODGY_CHARGES = 10;
	private static final int MAX_BINDING_CHARGES = 16;
	private static final int MAX_EXPLORER_RING_CHARGES = 30;
	private static final int MAX_RING_OF_FORGING_CHARGES = 140;
	private static final int MAX_AMULET_OF_CHEMISTRY_CHARGES = 5;
	private static final int MAX_AMULET_OF_BOUNTY_CHARGES = 10;
	private static final int MAX_SLAYER_BRACELET_CHARGES = 30;
	private static final int MAX_BLOOD_ESSENCE_CHARGES = 1000;
	private static final int MAX_BRACELET_OF_CLAY_CHARGES = 28;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemChargeOverlay overlay;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemChargeConfig config;

	// Limits destroy callback to once per tick
	private int lastCheckTick;
	private final Map<EquipmentInventorySlot, ItemChargeInfobox> infoboxes = new EnumMap<>(EquipmentInventorySlot.class);
	private boolean loginFlag;

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(() -> updateExplorerRingCharges(client.getVarbitValue(VarbitID.LUMBRIDGE_FREE_ALCHS)));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		infoBoxManager.removeIf(ItemChargeInfobox.class::isInstance);
		infoboxes.clear();
		lastCheckTick = -1;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		// No VarbitChanged event fires on login if the explorer's ring is full (varbit value 0).
		// So, set the value to 0 when LOGGED_IN. This is before the VarbitChanged event would fire,
		// so if it shouldn't be 0 it will be updated later.
		switch (e.getGameState())
		{
			case LOGGING_IN:
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (loginFlag)
				{
					loginFlag = false;
					updateExplorerRingCharges(0);
				}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(ItemChargeConfig.GROUP))
		{
			return;
		}

		clientThread.invoke(this::updateInfoboxes);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.GAMEMESSAGE || event.getType() == ChatMessageType.SPAM)
		{
			String message = Text.removeTags(event.getMessage());
			Matcher dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message);
			Matcher dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message);
			Matcher dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message);
			Matcher bindingNecklaceCheckMatcher = BINDING_CHECK_PATTERN.matcher(message);
			Matcher bindingNecklaceUsedMatcher = BINDING_USED_PATTERN.matcher(message);
			Matcher ringOfForgingCheckMatcher = RING_OF_FORGING_CHECK_PATTERN.matcher(message);
			Matcher amuletOfChemistryCheckMatcher = AMULET_OF_CHEMISTRY_CHECK_PATTERN.matcher(message);
			Matcher amuletOfChemistryUsedMatcher = AMULET_OF_CHEMISTRY_USED_PATTERN.matcher(message);
			Matcher amuletOfChemistryBreakMatcher = AMULET_OF_CHEMISTRY_BREAK_PATTERN.matcher(message);
			Matcher amuletOfBountyCheckMatcher = AMULET_OF_BOUNTY_CHECK_PATTERN.matcher(message);
			Matcher amuletOfBountyUsedMatcher = AMULET_OF_BOUNTY_USED_PATTERN.matcher(message);
			Matcher chronicleAddMatcher = CHRONICLE_ADD_PATTERN.matcher(message);
			Matcher chronicleUseAndCheckMatcher = CHRONICLE_USE_AND_CHECK_PATTERN.matcher(message);
			Matcher slaughterActivateMatcher = BRACELET_OF_SLAUGHTER_ACTIVATE_PATTERN.matcher(message);
			Matcher slaughterCheckMatcher = BRACELET_OF_SLAUGHTER_CHECK_PATTERN.matcher(message);
			Matcher expeditiousActivateMatcher = EXPEDITIOUS_BRACELET_ACTIVATE_PATTERN.matcher(message);
			Matcher expeditiousCheckMatcher = EXPEDITIOUS_BRACELET_CHECK_PATTERN.matcher(message);
			Matcher bloodEssenceCheckMatcher = BLOOD_ESSENCE_CHECK_PATTERN.matcher(message);
			Matcher bloodEssenceExtractMatcher = BLOOD_ESSENCE_EXTRACT_PATTERN.matcher(message);
			Matcher braceletOfClayCheckMatcher = BRACELET_OF_CLAY_CHECK_PATTERN.matcher(message);

			if (message.contains(RING_OF_RECOIL_BREAK_MESSAGE))
			{
				notifier.notify(config.recoilNotification(), "Your Ring of Recoil has shattered");
			}
			else if (dodgyBreakMatcher.find())
			{
				notifier.notify(config.dodgyNotification(), "Your dodgy necklace has crumbled to dust.");

				updateDodgyNecklaceCharges(MAX_DODGY_CHARGES);
			}
			else if (dodgyCheckMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyCheckMatcher.group(1)));
			}
			else if (dodgyProtectMatcher.find())
			{
				updateDodgyNecklaceCharges(Integer.parseInt(dodgyProtectMatcher.group(1)));
			}
			else if (amuletOfChemistryCheckMatcher.find())
			{
				updateAmuletOfChemistryCharges(Integer.parseInt(amuletOfChemistryCheckMatcher.group(1)));
			}
			else if (amuletOfChemistryUsedMatcher.find())
			{
				final String match = amuletOfChemistryUsedMatcher.group(1);

				int charges = 1;
				if (!match.equals("one"))
				{
					charges = Integer.parseInt(match);
				}

				updateAmuletOfChemistryCharges(charges);
			}
			else if (amuletOfChemistryBreakMatcher.find())
			{
				notifier.notify(config.amuletOfChemistryNotification(), "Your amulet of chemistry has crumbled to dust.");

				updateAmuletOfChemistryCharges(MAX_AMULET_OF_CHEMISTRY_CHARGES);
			}
			else if (amuletOfBountyCheckMatcher.find())
			{
				updateAmuletOfBountyCharges(Integer.parseInt(amuletOfBountyCheckMatcher.group(1)));
			}
			else if (amuletOfBountyUsedMatcher.find())
			{
				updateAmuletOfBountyCharges(Integer.parseInt(amuletOfBountyUsedMatcher.group(1)));
			}
			else if (message.equals(AMULET_OF_BOUNTY_BREAK_TEXT))
			{
				updateAmuletOfBountyCharges(MAX_AMULET_OF_BOUNTY_CHARGES);
			}
			else if (message.contains(BINDING_BREAK_TEXT))
			{
				notifier.notify(config.bindingNotification(), BINDING_BREAK_TEXT);

				// This chat message triggers before the used message so add 1 to the max charges to ensure proper sync
				updateBindingNecklaceCharges(MAX_BINDING_CHARGES + 1);
			}
			else if (bindingNecklaceUsedMatcher.find())
			{
				final ItemContainer equipment = client.getItemContainer(InventoryID.WORN);
				if (equipment.contains(ItemID.MAGIC_EMERALD_NECKLACE))
				{
					updateBindingNecklaceCharges(getItemCharges(ItemChargeConfig.KEY_BINDING_NECKLACE) - 1);
				}
			}
			else if (bindingNecklaceCheckMatcher.find())
			{
				final String match = bindingNecklaceCheckMatcher.group(1);

				int charges = 1;
				if (!match.equals("one"))
				{
					charges = Integer.parseInt(match);
				}

				updateBindingNecklaceCharges(charges);
			}
			else if (ringOfForgingCheckMatcher.find())
			{
				final String match = ringOfForgingCheckMatcher.group(1);

				int charges = 1;
				if (!match.equals("one"))
				{
					charges = Integer.parseInt(match);
				}
				updateRingOfForgingCharges(charges);
			}
			else if (message.equals(RING_OF_FORGING_USED_TEXT) || message.equals(RING_OF_FORGING_VARROCK_PLATEBODY))
			{
				final ItemContainer inventory = client.getItemContainer(InventoryID.INV);
				final ItemContainer equipment = client.getItemContainer(InventoryID.WORN);

				// Determine if the player smelted with a Ring of Forging equipped.
				if (equipment == null)
				{
					return;
				}

				if (equipment.contains(ItemID.RING_OF_FORGING) && (message.equals(RING_OF_FORGING_USED_TEXT) || inventory.count(ItemID.IRON_ORE) > 1))
				{
					int charges = Ints.constrainToRange(getItemCharges(ItemChargeConfig.KEY_RING_OF_FORGING) - 1, 0, MAX_RING_OF_FORGING_CHARGES);
					updateRingOfForgingCharges(charges);
				}
			}
			else if (message.equals(RING_OF_FORGING_BREAK_TEXT))
			{
				notifier.notify(config.ringOfForgingNotification(), "Your ring of forging has melted.");

				// This chat message triggers before the used message so add 1 to the max charges to ensure proper sync
				updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES + 1);
			}
			else if (chronicleAddMatcher.find())
			{
				final String match = chronicleAddMatcher.group(1);

				if (match.equals("one"))
				{
					setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1);
				}
				else
				{
					setItemCharges(ItemChargeConfig.KEY_CHRONICLE, Integer.parseInt(match));
				}
			}
			else if (chronicleUseAndCheckMatcher.find())
			{
				setItemCharges(ItemChargeConfig.KEY_CHRONICLE, Integer.parseInt(chronicleUseAndCheckMatcher.group(1)));
			}
			else if (message.equals(CHRONICLE_ONE_CHARGE_TEXT))
			{
				setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1);
			}
			else if (message.equals(CHRONICLE_EMPTY_TEXT) || message.equals(CHRONICLE_NO_CHARGES_TEXT))
			{
				setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 0);
			}
			else if (message.equals(CHRONICLE_FULL_TEXT))
			{
				setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1000);
			}
			else if (slaughterActivateMatcher.find())
			{
				final String found = slaughterActivateMatcher.group(1);
				if (found == null)
				{
					updateBraceletOfSlaughterCharges(MAX_SLAYER_BRACELET_CHARGES);
					notifier.notify(config.slaughterNotification(), BRACELET_OF_SLAUGHTER_BREAK_TEXT);
				}
				else
				{
					updateBraceletOfSlaughterCharges(Integer.parseInt(found));
				}
			}
			else if (slaughterCheckMatcher.find())
			{
				updateBraceletOfSlaughterCharges(Integer.parseInt(slaughterCheckMatcher.group(1)));
			}
			else if (expeditiousActivateMatcher.find())
			{
				final String found = expeditiousActivateMatcher.group(1);
				if (found == null)
				{
					updateExpeditiousBraceletCharges(MAX_SLAYER_BRACELET_CHARGES);
					notifier.notify(config.expeditiousNotification(), EXPEDITIOUS_BRACELET_BREAK_TEXT);
				}
				else
				{
					updateExpeditiousBraceletCharges(Integer.parseInt(found));
				}
			}
			else if (expeditiousCheckMatcher.find())
			{
				updateExpeditiousBraceletCharges(Integer.parseInt(expeditiousCheckMatcher.group(1)));
			}
			else if (bloodEssenceCheckMatcher.find())
			{
				updateBloodEssenceCharges(Integer.parseInt(bloodEssenceCheckMatcher.group(1)));
			}
			else if (bloodEssenceExtractMatcher.find())
			{
				updateBloodEssenceCharges(getItemCharges(ItemChargeConfig.KEY_BLOOD_ESSENCE) - Integer.parseInt(bloodEssenceExtractMatcher.group(1)));
			}
			else if (message.contains(BLOOD_ESSENCE_ACTIVATE_TEXT))
			{
				updateBloodEssenceCharges(MAX_BLOOD_ESSENCE_CHARGES);
			}
			else if (braceletOfClayCheckMatcher.find())
			{
				updateBraceletOfClayCharges(Integer.parseInt(braceletOfClayCheckMatcher.group(1)));
			}
			else if (message.equals(BRACELET_OF_CLAY_USE_TEXT) || message.equals(BRACELET_OF_CLAY_USE_TEXT_TRAHAEARN))
			{
				final ItemContainer equipment = client.getItemContainer(InventoryID.WORN);

				// Determine if the player mined with a Bracelet of Clay equipped.
				if (equipment != null && equipment.contains(ItemID.JEWL_BRACELET_OF_CLAY))
				{
					final ItemContainer inventory = client.getItemContainer(InventoryID.INV);

					// Charge is not used if only 1 inventory slot is available when mining in Prifddinas
					boolean ignore = inventory != null
						&& inventory.count() == 27
						&& message.equals(BRACELET_OF_CLAY_USE_TEXT_TRAHAEARN);

					if (!ignore)
					{
						int charges = Ints.constrainToRange(getItemCharges(ItemChargeConfig.KEY_BRACELET_OF_CLAY) - 1, 0, MAX_BRACELET_OF_CLAY_CHARGES);
						updateBraceletOfClayCharges(charges);
					}
				}
			}
			else if (message.equals(BRACELET_OF_CLAY_BREAK_TEXT))
			{
				notifier.notify(config.braceletOfClayNotification(), "Your bracelet of clay has crumbled to dust");
				updateBraceletOfClayCharges(MAX_BRACELET_OF_CLAY_CHARGES);
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.WORN)
		{
			return;
		}

		updateInfoboxes();
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"destroyOnOpKey".equals(event.getEventName()))
		{
			return;
		}

		final int yesOption = client.getIntStack()[client.getIntStackSize() - 1];
		if (yesOption == 1)
		{
			checkDestroyWidget();
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarbitId() == VarbitID.LUMBRIDGE_FREE_ALCHS)
		{
			updateExplorerRingCharges(event.getValue());
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == InterfaceID.OBJECTBOX)
		{
			clientThread.invokeLater(() ->
			{
				Widget sprite = client.getWidget(InterfaceID.Objectbox.ITEM);
				if (sprite != null)
				{
					switch (sprite.getItemId())
					{
						case ItemID.DODGY_NECKLACE:
							log.debug("Reset dodgy necklace");
							updateDodgyNecklaceCharges(MAX_DODGY_CHARGES);
							break;
						case ItemID.RING_OF_FORGING:
							log.debug("Reset ring of forging");
							updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES);
							break;
						case ItemID.AMULET_OF_CHEMISTRY:
							log.debug("Reset amulet of chemistry");
							updateAmuletOfChemistryCharges(MAX_AMULET_OF_CHEMISTRY_CHARGES);
							break;
						case ItemID.BRACELET_OF_SLAUGHTER:
							log.debug("Reset bracelet of slaughter");
							updateBraceletOfSlaughterCharges(MAX_SLAYER_BRACELET_CHARGES);
							break;
						case ItemID.EXPEDITIOUS_BRACELET:
							log.debug("Reset expeditious bracelet");
							updateExpeditiousBraceletCharges(MAX_SLAYER_BRACELET_CHARGES);
							break;
					}
				}
			});
		}
	}

	private void updateDodgyNecklaceCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_DODGY_NECKLACE, value);
		updateInfoboxes();
	}

	private void updateAmuletOfChemistryCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, value);
		updateInfoboxes();
	}

	private void updateAmuletOfBountyCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_AMULET_OF_BOUNTY, value);
		updateInfoboxes();
	}

	private void updateBindingNecklaceCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_BINDING_NECKLACE, value);
		updateInfoboxes();
	}

	private void updateExplorerRingCharges(final int value)
	{
		// Note: Varbit counts upwards. We count down from the maximum charges.
		setItemCharges(ItemChargeConfig.KEY_EXPLORERS_RING, MAX_EXPLORER_RING_CHARGES - value);
		updateInfoboxes();
	}

	private void updateRingOfForgingCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_RING_OF_FORGING, value);
		updateInfoboxes();
	}

	private void updateBraceletOfSlaughterCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, value);
		updateInfoboxes();
	}

	private void updateExpeditiousBraceletCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, value);
		updateInfoboxes();
	}

	private void updateBloodEssenceCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_BLOOD_ESSENCE, value);
		updateInfoboxes();
	}

	private void updateBraceletOfClayCharges(final int value)
	{
		setItemCharges(ItemChargeConfig.KEY_BRACELET_OF_CLAY, value);
		updateInfoboxes();
	}

	private void checkDestroyWidget()
	{
		final int currentTick = client.getTickCount();
		if (lastCheckTick == currentTick)
		{
			return;
		}
		lastCheckTick = currentTick;

		final Widget widgetDestroyItemName = client.getWidget(InterfaceID.Confirmdestroy.NAME);
		if (widgetDestroyItemName == null)
		{
			return;
		}

		if (widgetDestroyItemName.getText().equals("Binding necklace"))
		{
			log.debug("Reset binding necklace");
			updateBindingNecklaceCharges(MAX_BINDING_CHARGES);
		}
	}

	private void updateInfoboxes()
	{
		final ItemContainer itemContainer = client.getItemContainer(InventoryID.WORN);

		if (itemContainer == null)
		{
			return;
		}

		final Item[] items = itemContainer.getItems();
		boolean showInfoboxes = config.showInfoboxes();
		for (EquipmentInventorySlot slot : EquipmentInventorySlot.values())
		{
			if (slot.getSlotIdx() >= items.length)
			{
				break;
			}

			Item i = items[slot.getSlotIdx()];
			int id = i.getId();
			ItemChargeType type = null;
			int charges = -1;

			final ItemWithCharge itemWithCharge = ItemWithCharge.findItem(id);
			if (itemWithCharge != null)
			{
				type = itemWithCharge.getType();
				charges = itemWithCharge.getCharges();
			}
			else
			{
				final ItemWithConfig itemWithConfig = ItemWithConfig.findItem(id);
				if (itemWithConfig != null)
				{
					type = itemWithConfig.getType();
					charges = getItemCharges(itemWithConfig.getConfigKey());
				}
			}

			boolean enabled = type != null && type.getEnabled().test(config);

			if (showInfoboxes && enabled && charges > 0)
			{
				ItemChargeInfobox infobox = infoboxes.get(slot);
				if (infobox != null)
				{
					if (infobox.getItem() == id)
					{
						if (infobox.getCount() == charges)
						{
							continue;
						}

						log.debug("Updating infobox count for {}", infobox);
						infobox.setCount(charges);
						continue;
					}

					log.debug("Rebuilding infobox {}", infobox);
					infoBoxManager.removeInfoBox(infobox);
					infoboxes.remove(slot);
				}

				final String name = itemManager.getItemComposition(id).getName();
				final BufferedImage image = itemManager.getImage(id);
				infobox = new ItemChargeInfobox(this, image, name, charges, id);
				infoBoxManager.addInfoBox(infobox);
				infoboxes.put(slot, infobox);
			}
			else
			{
				ItemChargeInfobox infobox = infoboxes.remove(slot);
				if (infobox != null)
				{
					log.debug("Removing infobox {}", infobox);
					infoBoxManager.removeInfoBox(infobox);
				}
			}
		}
	}

	int getItemCharges(String key)
	{
		// Migrate old non-profile configurations
		Integer i = configManager.getConfiguration(ItemChargeConfig.GROUP, key, Integer.class);
		if (i != null)
		{
			configManager.unsetConfiguration(ItemChargeConfig.GROUP, key);
			configManager.setRSProfileConfiguration(ItemChargeConfig.GROUP, key, i);
			return i;
		}

		i = configManager.getRSProfileConfiguration(ItemChargeConfig.GROUP, key, Integer.class);
		return i == null ? -1 : i;
	}

	private void setItemCharges(String key, int value)
	{
		configManager.setRSProfileConfiguration(ItemChargeConfig.GROUP, key, value);
	}

	Color getColor(int charges)
	{
		Color color = Color.WHITE;
		if (charges <= config.veryLowWarning())
		{
			color = config.veryLowWarningColor();
		}
		else if (charges <= config.lowWarning())
		{
			color = config.lowWarningolor();
		}
		return color;
	}
}
