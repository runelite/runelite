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
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
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
@Singleton
public class PrayerPlugin extends Plugin
{
	private final PrayerCounter[] prayerCounter = new PrayerCounter[PrayerType.values().length];

	private Instant startOfLastTick = Instant.now();

	@Getter(AccessLevel.PACKAGE)
	private boolean prayersActive = false;

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
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private PrayerFlickLocation prayerFlickLocation;
	@Getter(AccessLevel.PACKAGE)
	private boolean prayerFlickAlwaysOn;
	private boolean prayerIndicator;
	private boolean prayerIndicatorOverheads;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPrayerDoseIndicator;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPrayerStatistics;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPrayerBar;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideIfNotPraying;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideIfOutOfCombat;

	@Provides
	PrayerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayerConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(flickOverlay);
		overlayManager.add(doseOverlay);
		overlayManager.add(barOverlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(flickOverlay);
		overlayManager.remove(doseOverlay);
		overlayManager.remove(barOverlay);
		removeIndicators();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("prayer"))
		{
			updateConfig();
			if (!this.prayerIndicator)
			{
				removeIndicators();
			}
			else if (!this.prayerIndicatorOverheads)
			{
				removeOverheadsIndicators();
			}
		}
	}

	private void onItemContainerChanged(final ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

		if (container != null && (container.equals(inventory) || container.equals(equipment)))
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
				doseOverlay.setPrayerBonus(checkContainerForPrayer(equipment.getItems()));
			}

		}
	}

	private void onGameTick(GameTick tick)
	{
		prayersActive = isAnyPrayerActive();

		if (!this.prayerFlickLocation.equals(PrayerFlickLocation.NONE))
		{
			startOfLastTick = Instant.now();
		}

		if (this.showPrayerDoseIndicator)
		{
			doseOverlay.onTick();
		}

		if (this.showPrayerBar)
		{
			barOverlay.onTick();
		}

		if (!this.prayerIndicator)
		{
			return;
		}

		for (PrayerType prayerType : PrayerType.values())
		{
			Prayer prayer = prayerType.getPrayer();
			int ord = prayerType.ordinal();

			if (client.isPrayerActive(prayer))
			{
				if (prayerType.isOverhead() && !this.prayerIndicatorOverheads)
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

			int bonus = PrayerItems.getItemPrayerBonus(item.getId());
			total += bonus;
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

	private void updateConfig()
	{
		this.prayerFlickLocation = config.prayerFlickLocation();
		this.prayerFlickAlwaysOn = config.prayerFlickAlwaysOn();
		this.prayerIndicator = config.prayerIndicator();
		this.prayerIndicatorOverheads = config.prayerIndicatorOverheads();
		this.showPrayerDoseIndicator = config.showPrayerDoseIndicator();
		this.showPrayerStatistics = config.showPrayerStatistics();
		this.showPrayerBar = config.showPrayerBar();
		this.hideIfNotPraying = config.hideIfNotPraying();
		this.hideIfOutOfCombat = config.hideIfOutOfCombat();
	}
}
