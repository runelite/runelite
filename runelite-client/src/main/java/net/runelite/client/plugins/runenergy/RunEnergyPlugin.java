/*
 * Copyright (c) 2018, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.runenergy;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.*;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Run Energy",
	description = "Show various information related to run energy",
	tags = {"overlay", "stamina"}
)
@Slf4j
public class RunEnergyPlugin extends Plugin
{
	@Getter
	private enum GracefulEquipmentSlot
	{
		HEAD(EquipmentInventorySlot.HEAD.getSlotIdx(), 3, GRACEFUL_HOOD),
		BODY(EquipmentInventorySlot.BODY.getSlotIdx(), 4, GRACEFUL_TOP),
		LEGS(EquipmentInventorySlot.LEGS.getSlotIdx(), 4, GRACEFUL_LEGS),
		GLOVES(EquipmentInventorySlot.GLOVES.getSlotIdx(), 3, GRACEFUL_GLOVES),
		BOOTS(EquipmentInventorySlot.BOOTS.getSlotIdx(), 3, GRACEFUL_BOOTS),
		// Agility skill capes and the non-cosmetic Max capes also count for the Graceful set effect
		CAPE(EquipmentInventorySlot.CAPE.getSlotIdx(), 3, GRACEFUL_CAPE, AGILITY_CAPE, MAX_CAPE_13342);

		private final int index;
		private final int boost;
		private final Set<Integer> items;

		GracefulEquipmentSlot(int index, int boost, int... baseItems)
		{
			this.index = index;
			this.boost = boost;

			final ImmutableSet.Builder<Integer> itemsBuilder = ImmutableSet.builder();
			for (int item : baseItems)
			{
				itemsBuilder.addAll(ItemVariationMapping.getVariations(item));
			}
			items = itemsBuilder.build();
		}

		private static final int TOTAL_BOOSTS = Arrays.stream(values()).mapToInt(GracefulEquipmentSlot::getBoost).sum();
	}

	// Full set grants an extra 10% boost to recovery rate
	private static final int GRACEFUL_FULL_SET_BOOST_BONUS = 10;
	// number of charges for roe passive effect
	private static final int RING_OF_ENDURANCE_PASSIVE_EFFECT = 500;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RunEnergyOverlay energyOverlay;

	@Inject
	private RunEnergyConfig energyConfig;

	@Inject
	private ConfigManager configManager;

	private int lastCheckTick;
	private boolean roeWarningSent;
	private boolean localPlayerRunningToDestination;
	private WorldPoint prevLocalPlayerLocation;

	@Provides
	RunEnergyConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunEnergyConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(energyOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(energyOverlay);
		localPlayerRunningToDestination = false;
		prevLocalPlayerLocation = null;
		lastCheckTick = -1;
		roeWarningSent = false;
		resetRunOrbText();
	}

	Integer getRingOfEnduranceCharges()
	{
		return configManager.getRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", Integer.class);
	}

	void setRingOfEnduranceCharges(int charges)
	{
		configManager.setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", charges);
	}

	boolean isRingOfEnduranceEquipped()
	{
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		return equipment != null && equipment.count(RING_OF_ENDURANCE) == 1;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		localPlayerRunningToDestination =
			prevLocalPlayerLocation != null &&
			client.getLocalDestinationLocation() != null &&
			prevLocalPlayerLocation.distanceTo(client.getLocalPlayer().getWorldLocation()) > 1;

		prevLocalPlayerLocation = client.getLocalPlayer().getWorldLocation();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.ORBS_UPDATE_RUNENERGY && energyConfig.replaceOrbText())
		{
			setRunOrbText(getEstimatedRunTimeRemaining(true));
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(RunEnergyConfig.GROUP_NAME) && !energyConfig.replaceOrbText())
		{
			resetRunOrbText();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String message = event.getMessage();

		if (message.equals("Your Ring of endurance doubles the duration of your stamina potion's effect."))
		{
			Integer charges = getRingOfEnduranceCharges();
			if (charges == null)
			{
				log.debug("Ring of endurance charge with no known charges");
				return;
			}

			// subtract the used charge
			charges--;
			setRingOfEnduranceCharges(charges);

			if (!roeWarningSent && charges < RING_OF_ENDURANCE_PASSIVE_EFFECT && energyConfig.ringOfEnduranceChargeMessage())
			{
				String chatMessage = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Your Ring of endurance now has less than " + RING_OF_ENDURANCE_PASSIVE_EFFECT + " charges. Add more charges to regain its passive stamina effect.")
					.build();

				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(chatMessage)
					.build());

				roeWarningSent = true;
			}
		}
		else if (message.startsWith("Your Ring of endurance is charged with") || message.startsWith("You load your Ring of endurance with"))
		{
			Matcher matcher = Pattern.compile("([0-9,]+)").matcher(message);
			int charges = -1;
			while (matcher.find())
			{
				charges = Integer.parseInt(matcher.group(1).replace(",", ""));
			}

			setRingOfEnduranceCharges(charges);
			if (charges >= RING_OF_ENDURANCE_PASSIVE_EFFECT)
			{
				roeWarningSent = false;
			}
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		// ROE uncharge uses the same script as destroy
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

	private void setRunOrbText(String text)
	{
		Widget runOrbText = client.getWidget(ComponentID.MINIMAP_RUN_ORB_TEXT);

		if (runOrbText != null)
		{
			runOrbText.setText(text);
		}
	}

	private void resetRunOrbText()
	{
		setRunOrbText(Integer.toString(client.getEnergy() / 100));
	}

	String getEstimatedRunTimeRemaining(boolean inSeconds)
	{
		// Calculate the amount of energy lost every tick.
		// Negative weight has the same depletion effect as 0 kg. >64kg counts as 64kg.
		final int effectiveWeight = Math.min(Math.max(client.getWeight(), 0), 64);

		// 100% energy is 10000 energy units
		int energyUnitsLost = (int) ((60 + (67 * effectiveWeight / 64)) * (1 - client.getBoostedSkillLevel(Skill.AGILITY) / 300.0));

		if (client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
		{
			energyUnitsLost *= 0.3; // Stamina effect reduces energy depletion to 30%
		}
		else if (isRingOfEnduranceEquipped()) // Ring of Endurance passive effect does not stack with stamina potion
		{
			Integer charges = getRingOfEnduranceCharges();
			if (charges == null)
			{
				return "?";
			}

			if (charges >= RING_OF_ENDURANCE_PASSIVE_EFFECT)
			{
				energyUnitsLost *= 0.85; // Ring of Endurance passive effect reduces energy depletion to 85%
			}
		}

		// Math.ceil is correct here - only need 1 energy unit to run
		final double ticksLeft = Math.ceil(client.getEnergy() / (double) energyUnitsLost);
		final double secondsLeft = ticksLeft * Constants.GAME_TICK_LENGTH / 1000.0;

		// Return the text
		if (inSeconds)
		{
			return (int) Math.floor(secondsLeft) + "s";
		}
		else
		{
			final int minutes = (int) Math.floor(secondsLeft / 60.0);
			final int seconds = (int) Math.floor(secondsLeft - (minutes * 60.0));
			return minutes + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, "0");
		}
	}

	private int getGracefulRecoveryBoost()
	{
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

		if (equipment == null)
		{
			return 0;
		}

		final Item[] items = equipment.getItems();

		int boost = 0;

		for (final GracefulEquipmentSlot slot : GracefulEquipmentSlot.values())
		{
			if (items.length <= slot.getIndex())
			{
				continue;
			}

			final Item wornItem = items[slot.getIndex()];

			if (wornItem != null && slot.getItems().contains(wornItem.getId()))
			{
				boost += slot.getBoost();
			}
		}

		if (boost == GracefulEquipmentSlot.TOTAL_BOOSTS)
		{
			boost += GRACEFUL_FULL_SET_BOOST_BONUS;
		}

		return boost;
	}

	int getEstimatedRecoverTimeRemaining()
	{
		if (localPlayerRunningToDestination)
		{
			return -1;
		}

		// Calculate the amount of energy recovered every second
		double recoverRate = 25 + client.getBoostedSkillLevel(Skill.AGILITY) / 6.0;
		recoverRate *= 1.0 + getGracefulRecoveryBoost() / 100.0;

		// Calculate the number of seconds left
		final double secondsLeft = (10000 - client.getEnergy()) / recoverRate;
		return (int) secondsLeft;
	}

	private void checkDestroyWidget()
	{
		final int currentTick = client.getTickCount();
		if (lastCheckTick == currentTick)
		{
			return;
		}
		lastCheckTick = currentTick;

		final Widget widgetDestroyItemName = client.getWidget(ComponentID.DESTROY_ITEM_NAME);
		if (widgetDestroyItemName == null)
		{
			return;
		}

		if (widgetDestroyItemName.getText().equals("Ring of endurance"))
		{
			setRingOfEnduranceCharges(0);
		}
	}
}
