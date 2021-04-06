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
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.item.ItemStats;

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
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(flickOverlay);
		overlayManager.remove(doseOverlay);
		overlayManager.remove(barOverlay);
		removeIndicators();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("prayer"))
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
		final ItemContainer container = event.getItemContainer();
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

		if (container == inventory || container == equipment)
		{
			doseOverlay.setHasHolyWrench(false);
			doseOverlay.setHasPrayerRestore(false);
			doseOverlay.setBonusPrayer(0);

			if (inventory != null)
			{
				checkContainerForPrayer(inventory.getItems());
			}

			if (equipment != null)
			{
				prayerBonus = checkContainerForPrayer(equipment.getItems());
			}

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
			Prayer prayer = prayerType.getPrayer();
			int ord = prayerType.ordinal();

			if (client.isPrayerActive(prayer))
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

	private int checkContainerForPrayer(Item[] items)
	{
		if (items == null)
		{
			return 0;
		}

		int total = 0;

		boolean hasPrayerPotion = false;
		boolean hasSuperRestore = false;
		boolean hasSanfew = false;

		for (Item item : items)
		{
			if (item == null)
			{
				continue;
			}

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
						doseOverlay.setHasHolyWrench(true);
						break;
				}
			}

			ItemStats is = itemManager.getItemStats(item.getId(), false);
			if (is != null && is.getEquipment() != null)
			{
				total += is.getEquipment().getPrayer();
			}
		}

		if (hasSanfew || hasSuperRestore || hasPrayerPotion)
		{
			doseOverlay.setHasPrayerRestore(true);
			if (hasSanfew)
			{
				doseOverlay.setBonusPrayer(2);
			}
			else if (hasSuperRestore)
			{
				doseOverlay.setBonusPrayer(1);
			}
		}

		return total;
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
		Widget prayerOrbText = client.getWidget(WidgetInfo.MINIMAP_PRAYER_ORB_TEXT);
		if (prayerOrbText != null)
		{
			prayerOrbText.setText(text);
		}
	}

	private static double getPrayerDrainRate(Client client)
	{
		double drainRate = 0.0;

		for (Prayer prayer : Prayer.values())
		{
			if (client.isPrayerActive(prayer))
			{
				drainRate += prayer.getDrainRate();
			}
		}

		return drainRate;
	}

	String getEstimatedTimeRemaining(boolean formatForOrb)
	{
		final double drainRate = getPrayerDrainRate(client);

		if (drainRate == 0)
		{
			return "N/A";
		}

		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);

		// Calculate how many seconds each prayer points last so the prayer bonus can be applied
		final double secondsPerPoint = (60.0 / drainRate) * (1.0 + (prayerBonus / 30.0));

		// Calculate the number of seconds left
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
