/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayer;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStats;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Prayer",
	description = "Show various information related to prayer",
	tags = {"combat", "flicking", "overlay"}
)
public class PrayerPlugin extends Plugin
{
	private final PrayerCounter[] prayerCounter = new PrayerCounter[PrayerType.values().length];

	private Instant startOfLastTick = Instant.now();

	@Getter(AccessLevel.PACKAGE)
	private boolean prayersActive = false;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int prayerBonus;

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PrayerFlickOverlay flickOverlay;

	@Inject
	private PrayerDoseOverlay doseOverlay;

	@Inject
	private PrayerBarOverlay barOverlay;

	@Inject
	private PrayerConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private PrayerReorder prayerReorder;

	@Inject
	private EventBus eventBus;

	@Provides
	PrayerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayerConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(flickOverlay);
		overlayManager.add(doseOverlay);
		overlayManager.add(barOverlay);

		prayerReorder.startUp();
		eventBus.register(prayerReorder);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(flickOverlay);
		overlayManager.remove(doseOverlay);
		overlayManager.remove(barOverlay);
		removeIndicators();

		prayerReorder.shutDown();
		eventBus.unregister(prayerReorder);
	}

	@Override
	public void resetConfiguration()
	{
		prayerReorder.reset();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(PrayerConfig.GROUP))
		{
			if (!config.prayerIndicator())
			{
				removeIndicators();
			}
			else if (!config.prayerIndicatorOverheads())
			{
				removeOverheadsIndicators();
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		final int id = event.getContainerId();
		if (id == InventoryID.INVENTORY.getId())
		{
			updatePotionBonus(event.getItemContainer(),
				client.getItemContainer(InventoryID.EQUIPMENT));
		}
		else if (id == InventoryID.EQUIPMENT.getId())
		{
			prayerBonus = totalPrayerBonus(event.getItemContainer().getItems());
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		prayersActive = isAnyPrayerActive();

		if (!config.prayerFlickLocation().equals(PrayerFlickLocation.NONE))
		{
			startOfLastTick = Instant.now();
		}

		if (config.showPrayerDoseIndicator())
		{
			doseOverlay.onTick();
		}

		if (config.showPrayerBar())
		{
			barOverlay.onTick();
		}

		if (config.replaceOrbText() && isAnyPrayerActive())
		{
			setPrayerOrbText(getEstimatedTimeRemaining(true));
		}

		if (!config.prayerIndicator())
		{
			return;
		}

		for (PrayerType prayerType : PrayerType.values())
		{
			int ord = prayerType.ordinal();

			if (prayerType.isActive(client))
			{
				if (prayerType.isOverhead() && !config.prayerIndicatorOverheads())
				{
					continue;
				}

				if (prayerCounter[ord] == null)
				{
					PrayerCounter counter = prayerCounter[ord] = new PrayerCounter(this, prayerType);
					spriteManager.getSpriteAsync(prayerType.getSpriteID(), 0,
						counter::setImage);
					infoBoxManager.addInfoBox(counter);
				}
			}
			else if (prayerCounter[ord] != null)
			{
				infoBoxManager.removeInfoBox(prayerCounter[ord]);
				prayerCounter[ord] = null;
			}
		}
	}

	private int totalPrayerBonus(Item[] items)
	{
		int total = 0;
		for (Item item : items)
		{
			ItemStats is = itemManager.getItemStats(item.getId());
			if (is != null && is.getEquipment() != null)
			{
				total += is.getEquipment().getPrayer();
			}
		}
		return total;
	}

	private void updatePotionBonus(ItemContainer inventory, @Nullable ItemContainer equip)
	{
		boolean hasPrayerPotion = false;
		boolean hasSuperRestore = false;
		boolean hasSanfew = false;
		boolean hasWrench = false;

		for (Item item : inventory.getItems())
		{
			final PrayerRestoreType type = PrayerRestoreType.getType(item.getId());

			if (type != null)
			{
				switch (type)
				{
					case PRAYERPOT:
						hasPrayerPotion = true;
						break;
					case RESTOREPOT:
						hasSuperRestore = true;
						break;
					case SANFEWPOT:
						hasSanfew = true;
						break;
					case HOLYWRENCH:
						hasWrench = true;
						break;
				}
			}
		}

		// Some items providing the holy wrench bonus can also be worn
		if (!hasWrench && equip != null)
		{
			for (Item item : equip.getItems())
			{
				final PrayerRestoreType type = PrayerRestoreType.getType(item.getId());
				if (type == PrayerRestoreType.HOLYWRENCH)
				{
					hasWrench = true;
					break;
				}
			}
		}

		// Prayer potion: floor(7 + 25% of base level) - 27% with holy wrench
		// Super restore: floor(8 + 25% of base level) - 27% with holy wrench
		// Sanfew serum: floor(4 + 30% of base level) - 32% with holy wrench
		final int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);
		int restored = 0;
		if (hasSanfew)
		{
			restored = Math.max(restored, 4 + (int) Math.floor(prayerLevel *  (hasWrench ? .32 : .30)));
		}
		if (hasSuperRestore)
		{
			restored = Math.max(restored, 8 + (int) Math.floor(prayerLevel *  (hasWrench ? .27 : .25)));
		}
		if (hasPrayerPotion)
		{
			restored = Math.max(restored, 7 + (int) Math.floor(prayerLevel *  (hasWrench ? .27 : .25)));
		}

		doseOverlay.setRestoreAmount(restored);
	}

	double getTickProgress()
	{
		long timeSinceLastTick = Duration.between(startOfLastTick, Instant.now()).toMillis();

		float tickProgress = (timeSinceLastTick % Constants.GAME_TICK_LENGTH) / (float) Constants.GAME_TICK_LENGTH;
		return tickProgress * Math.PI;
	}

	private boolean isAnyPrayerActive()
	{
		for (Prayer pray : Prayer.values())//Check if any prayers are active
		{
			if (client.isPrayerActive(pray))
			{
				return true;
			}
		}

		return false;
	}

	private void removeIndicators()
	{
		infoBoxManager.removeIf(entry -> entry instanceof PrayerCounter);
	}

	private void removeOverheadsIndicators()
	{
		infoBoxManager.removeIf(entry -> entry instanceof PrayerCounter
			&& ((PrayerCounter) entry).getPrayerType().isOverhead());
	}

	private void setPrayerOrbText(String text)
	{
		Widget prayerOrbText = client.getWidget(ComponentID.MINIMAP_PRAYER_ORB_TEXT);
		if (prayerOrbText != null)
		{
			prayerOrbText.setText(text);
		}
	}

	private static int getDrainEffect(Client client)
	{
		int drainEffect = 0;

		for (PrayerType prayerType : PrayerType.values())
		{
			if (prayerType.isActive(client))
			{
				drainEffect += prayerType.getDrainEffect();
			}
		}

		return drainEffect;
	}

	String getEstimatedTimeRemaining(boolean formatForOrb)
	{
		final int drainEffect = getDrainEffect(client);

		if (drainEffect == 0)
		{
			return "N/A";
		}

		// Calculate how many seconds each prayer points last so the prayer bonus can be applied
		// https://oldschool.runescape.wiki/w/Prayer#Prayer_drain_mechanics
		final int drainResistance = 2 * prayerBonus + 60;
		final double secondsPerPoint = 0.6 * ((double) drainResistance / drainEffect);

		// Calculate the number of seconds left
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final double secondsLeft = (currentPrayer * secondsPerPoint);

		LocalTime timeLeft = LocalTime.ofSecondOfDay((long) secondsLeft);

		if (formatForOrb && (timeLeft.getHour() > 0 || timeLeft.getMinute() > 9))
		{
			long minutes = Duration.ofSeconds((long) secondsLeft).toMinutes();
			return String.format("%dm", minutes);
		}
		else if (timeLeft.getHour() > 0)
		{
			return timeLeft.format(DateTimeFormatter.ofPattern("H:mm:ss"));
		}
		else
		{
			return timeLeft.format(DateTimeFormatter.ofPattern("m:ss"));
		}
	}
}
