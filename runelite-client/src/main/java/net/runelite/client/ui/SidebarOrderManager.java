/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
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
package net.runelite.client.ui;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;

/**
 * Manages the sidebar icon ordering using ConfigManager.
 *
 * Stores two types of data:
 * 1. Original priorities: The default priority of each plugin icon (from NavigationButton.getPriority())
 * 2. Custom order: The user-defined order after drag-and-drop reordering
 *
 * This allows:
 * - Restoring default order at any time
 * - Inserting new plugins in the correct position based on their original priority
 * - Maintaining user's custom order across restarts
 */
@Singleton
@Slf4j
public class SidebarOrderManager
{
	private static final String CONFIG_GROUP = "sidebar";
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";
	private static final String CONFIG_KEY_ORIGINAL_PRIORITIES = "originalPriorities";
	private static final String ENTRY_SEPARATOR = ",";
	private static final String PRIORITY_SEPARATOR = ":";

	private final ConfigManager configManager;

	// Cache of original priorities (tooltip -> priority)
	private final Map<String, Integer> originalPriorities = new HashMap<>();

	// Cache of custom order (list of tooltips in display order)
	private List<String> customOrder = new ArrayList<>();

	// Flag to track if custom order has been modified
	private boolean hasCustomOrder = false;

	// Flag to track if config has been loaded
	private boolean configLoaded = false;

	@Inject
	public SidebarOrderManager(ConfigManager configManager)
	{
		this.configManager = configManager;
		// Don't load config here - ConfigManager may not be fully initialized yet
		// Config will be loaded lazily on first access
	}

	/**
	 * Ensures configuration is loaded. Called lazily on first access.
	 */
	private void ensureConfigLoaded()
	{
		if (!configLoaded)
		{
			loadFromConfig();
			configLoaded = true;
		}
	}

	/**
	 * Load saved configuration from ConfigManager.
	 */
	private void loadFromConfig()
	{
		try
		{
			// Load original priorities
			String prioritiesStr = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_ORIGINAL_PRIORITIES);
			if (!Strings.isNullOrEmpty(prioritiesStr))
			{
				for (String entry : Splitter.on(ENTRY_SEPARATOR).omitEmptyStrings().split(prioritiesStr))
				{
					int separatorIndex = entry.lastIndexOf(PRIORITY_SEPARATOR);
					if (separatorIndex > 0)
					{
						String tooltip = entry.substring(0, separatorIndex);
						try
						{
							int priority = Integer.parseInt(entry.substring(separatorIndex + 1));
							originalPriorities.put(tooltip, priority);
						}
						catch (NumberFormatException e)
						{
							log.warn("Invalid priority format in sidebar config: {}", entry);
						}
					}
				}
			}

			// Load custom order
			String orderStr = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			if (!Strings.isNullOrEmpty(orderStr))
			{
				customOrder = new ArrayList<>(Splitter.on(ENTRY_SEPARATOR).omitEmptyStrings().splitToList(orderStr));
				hasCustomOrder = !customOrder.isEmpty();
			}

			log.debug("Loaded sidebar order: {} original priorities, {} custom order entries, hasCustomOrder={}",
				originalPriorities.size(), customOrder.size(), hasCustomOrder);
		}
		catch (Exception e)
		{
			log.warn("Failed to load sidebar order config, using defaults", e);
		}
	}

	/**
	 * Register a navigation button's original priority.
	 * This should be called when a button is first added to track its default priority.
	 *
	 * @param navBtn the navigation button to register
	 */
	public void registerOriginalPriority(NavigationButton navBtn)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();
		if (!originalPriorities.containsKey(tooltip))
		{
			originalPriorities.put(tooltip, navBtn.getPriority());
			saveOriginalPriorities();
		}
	}

	/**
	 * Get the index where a new navigation button should be inserted.
	 *
	 * If custom order exists, inserts based on original priority relative to existing items.
	 * If no custom order exists, returns -1 to indicate default ordering should be used.
	 *
	 * @param navBtn the navigation button to get insertion index for
	 * @param currentButtons the current list of buttons in display order
	 * @return the index to insert at, or -1 if default ordering should be used
	 */
	public int getInsertionIndex(NavigationButton navBtn, List<NavigationButton> currentButtons)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();

		// Check if this button already has a position in the custom order
		int existingIndex = customOrder.indexOf(tooltip);
		if (existingIndex >= 0)
		{
			// Find the correct position based on what buttons are currently present
			int adjustedIndex = 0;
			for (int i = 0; i < existingIndex && i < customOrder.size(); i++)
			{
				String orderTooltip = customOrder.get(i);
				for (NavigationButton btn : currentButtons)
				{
					if (btn.getTooltip().equals(orderTooltip))
					{
						adjustedIndex++;
						break;
					}
				}
			}
			return Math.min(adjustedIndex, currentButtons.size());
		}

		// If no custom order or button not in custom order, use priority-based insertion
		if (!hasCustomOrder)
		{
			return -1; // Use default TreeSet ordering
		}

		// Insert new button based on its original priority relative to existing buttons
		int btnPriority = navBtn.getPriority();
		for (int i = 0; i < currentButtons.size(); i++)
		{
			NavigationButton existing = currentButtons.get(i);
			int existingPriority = originalPriorities.getOrDefault(existing.getTooltip(), existing.getPriority());
			if (btnPriority < existingPriority)
			{
				return i;
			}
			else if (btnPriority == existingPriority)
			{
				// Same priority, compare by tooltip
				if (tooltip.compareTo(existing.getTooltip()) < 0)
				{
					return i;
				}
			}
		}

		return currentButtons.size();
	}

	/**
	 * Save the current custom order of navigation buttons.
	 *
	 * @param orderedButtons the buttons in their current display order
	 */
	public void saveCustomOrder(List<NavigationButton> orderedButtons)
	{
		ensureConfigLoaded();
		customOrder = orderedButtons.stream()
			.map(NavigationButton::getTooltip)
			.collect(Collectors.toList());

		hasCustomOrder = true;

		String orderStr = String.join(ENTRY_SEPARATOR, customOrder);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, orderStr);

		log.debug("Saved custom sidebar order: {} entries", customOrder.size());
	}

	/**
	 * Save the original priorities to ConfigManager.
	 */
	private void saveOriginalPriorities()
	{
		String prioritiesStr = originalPriorities.entrySet().stream()
			.map(e -> e.getKey() + PRIORITY_SEPARATOR + e.getValue())
			.collect(Collectors.joining(ENTRY_SEPARATOR));

		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_ORIGINAL_PRIORITIES, prioritiesStr);
	}

	/**
	 * Check if a custom order has been set.
	 *
	 * @return true if the user has customized the sidebar order
	 */
	public boolean hasCustomOrder()
	{
		ensureConfigLoaded();
		return hasCustomOrder;
	}

	/**
	 * Reset to default ordering.
	 * Clears the custom order and reverts to priority-based ordering.
	 */
	public void resetToDefaultOrder()
	{
		ensureConfigLoaded();
		customOrder.clear();
		hasCustomOrder = false;
		configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		log.debug("Reset sidebar to default order");
	}

	/**
	 * Remove a navigation button from the stored order.
	 * Called when a plugin is removed.
	 *
	 * @param navBtn the button to remove
	 */
	public void removeButton(NavigationButton navBtn)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();
		customOrder.remove(tooltip);
		// Note: We keep the original priority in case the plugin is re-added

		if (hasCustomOrder)
		{
			String orderStr = String.join(ENTRY_SEPARATOR, customOrder);
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, orderStr);
		}
	}

	/**
	 * Get the original priority of a navigation button.
	 *
	 * @param tooltip the tooltip of the button
	 * @return the original priority, or Integer.MAX_VALUE if not found
	 */
	public int getOriginalPriority(String tooltip)
	{
		ensureConfigLoaded();
		return originalPriorities.getOrDefault(tooltip, Integer.MAX_VALUE);
	}

	/**
	 * Build an ordered list of navigation buttons from the given collection.
	 * Uses custom order if available, otherwise uses default priority ordering.
	 *
	 * @param buttons the collection of buttons to order
	 * @return a new list with buttons in the correct display order
	 */
	public List<NavigationButton> getOrderedButtons(Collection<NavigationButton> buttons)
	{
		ensureConfigLoaded();
		if (!hasCustomOrder || customOrder.isEmpty())
		{
			// Return in default order (TreeSet order)
			return new ArrayList<>(buttons);
		}

		List<NavigationButton> ordered = new ArrayList<>();
		Map<String, NavigationButton> buttonMap = new HashMap<>();
		for (NavigationButton btn : buttons)
		{
			buttonMap.put(btn.getTooltip(), btn);
		}

		// Add buttons in custom order
		for (String tooltip : customOrder)
		{
			NavigationButton btn = buttonMap.remove(tooltip);
			if (btn != null)
			{
				ordered.add(btn);
			}
		}

		// Add any remaining buttons (new plugins) in priority order
		List<NavigationButton> remaining = new ArrayList<>(buttonMap.values());
		remaining.sort((a, b) ->
		{
			int cmp = Integer.compare(a.getPriority(), b.getPriority());
			if (cmp != 0)
			{
				return cmp;
			}
			return a.getTooltip().compareTo(b.getTooltip());
		});

		// Insert remaining buttons at appropriate positions based on priority
		for (NavigationButton btn : remaining)
		{
			int insertIndex = getInsertionIndex(btn, ordered);
			if (insertIndex < 0 || insertIndex >= ordered.size())
			{
				ordered.add(btn);
			}
			else
			{
				ordered.add(insertIndex, btn);
			}
		}

		return ordered;
	}
}