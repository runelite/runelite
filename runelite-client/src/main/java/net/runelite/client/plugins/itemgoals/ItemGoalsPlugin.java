/*
 * Copyright (c) 2019, halworsen <mwh@halvorsenfamilien.com>
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
package net.runelite.client.plugins.itemgoals;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor
(
	name = "Item Goals",
	description = "Keeps track of item goals you've set",
	tags = {"drops", "achievements"},
	enabledByDefault = false
)
@Singleton
public class ItemGoalsPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private ItemGoalsConfig config;

	@Getter(AccessLevel.PACKAGE)
	private NavigationButton navButton;

	@Getter(AccessLevel.PACKAGE)
	private ItemGoalsPanel goalsPanel;

	@Getter
	private ArrayList<ItemGoal> userGoals = new ArrayList<>();

	private Map<Integer, Integer> previousInventory = new HashMap<>();
	private String loggedInAs = "";

	@Provides
	ItemGoalsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemGoalsConfig.class);
	}

	@Override
	protected void startUp()
	{
		goalsPanel = injector.getInstance(ItemGoalsPanel.class);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
				.tooltip("Item Goals")
				.icon(icon)
				.priority(6)
				.panel(goalsPanel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}

	protected void addNewGoal(ItemGoal newGoal)
	{
		userGoals.add(newGoal);
		// addNewGoal and updateGoal are called by ItemGoalsResultPanels and are therefore already in the proper context
		goalsPanel.rebuildGoals();
	}

	protected void updateGoal(ItemGoal updatedGoal)
	{
		for (ItemGoal goal : userGoals)
		{
			if (goal.getItemID() == updatedGoal.getItemID())
			{
				// Only bother with updating amount and progress. Doesn't make sense for itemID/name to change
				goal.setAmount(updatedGoal.getAmount());
				goal.setProgress(updatedGoal.getProgress());
				break;
			}
		}

		goalsPanel.rebuildGoals();
	}

	private void progressGoal(int itemId, int amount)
	{
		for (ItemGoal goal : userGoals)
		{
			if (goal.getItemID() == itemId)
			{
				int newProgress = Math.min(goal.getProgress() + amount, goal.getAmount());
				goal.setProgress(newProgress);
				break;
			}
		}

		// Invoke later because this is called on an inventory change event
		SwingUtilities.invokeLater(() -> goalsPanel.rebuildGoals());
	}

	protected void removeGoal(ItemGoal goalToDelete)
	{
		for (ItemGoal goal : userGoals)
		{
			if (goal.getItemID() == goalToDelete.getItemID())
			{
				userGoals.remove(goal);
				break;
			}
		}

		// Again, this is only called by ItemGoalsResultPanels
		goalsPanel.rebuildGoals();
	}

	protected boolean hasNoGoals()
	{
		return getUserGoals().isEmpty();
	}

	private boolean isBanking()
	{
		Widget widget = client.getWidget(WidgetInfo.BANK_CONTAINER);

		if (widget == null)
		{
			return false;
		}

		return true;
	}

	// Returns a map describing how the quantity of each itemID in the inventory has changed since the last call
	private Map<Integer, Integer> getInventoryDeltas(Item[] items)
	{
		Map<Integer, Integer> deltas = new HashMap<>();
		Map<Integer, Integer> consolidatedInventory = new HashMap<>();

		// First, stack every item to deal with unstackables
		for (Item invItem : items)
		{
			int baseId = ItemVariationMapping.map(invItem.getId());

			if (consolidatedInventory.containsKey(baseId))
			{
				consolidatedInventory.put(baseId, consolidatedInventory.get(baseId) + invItem.getQuantity());
			}
			else
			{
				consolidatedInventory.put(baseId, invItem.getQuantity());
			}
		}

		/*
		 * Remove items that were removed from the inventory, or the deltas will be messed up the next time the item enters the inventory
		 * E.g. take 5mil out of the bank, deposit it. On the deposit, there's no coins in the inventory, so the previous
		 * inventory isn't updated. Then pick up 1 coin and the delta will be -4.999999mil.
		 *
		 * Note that progress can never go backwards, so we're not worried about negative quantity changes anyways.
		*/
		previousInventory.keySet().retainAll(consolidatedInventory.keySet());

		// Now we can go through the inventory and find how much each item quantity changed
		for (Map.Entry<Integer, Integer> item : consolidatedInventory.entrySet())
		{
			if (previousInventory.containsKey(item.getKey()))
			{
				int delta = item.getValue() - previousInventory.get(item.getKey());
				deltas.put(item.getKey(), delta);
			}
			else
			{
				deltas.put(item.getKey(), item.getValue());
			}

			// Update the stored inventory
			previousInventory.put(item.getKey(), item.getValue());
		}

		return deltas;
	}

	private boolean hasGoalForItem(int itemId)
	{
		for (ItemGoal itemGoal : userGoals)
		{
			if (itemId == itemGoal.getItemID())
			{
				return true;
			}
		}

		return false;
	}

	private void updateGoalProgress(Item[] items)
	{
		if (items == null)
		{
			return;
		}

		Map<Integer, Integer> deltas = getInventoryDeltas(items);
		for (Map.Entry<Integer, Integer> pair : deltas.entrySet())
		{
			int itemId = pair.getKey();
			int delta = pair.getValue();

			/*
			 * Don't work with items we haven't set goals for
			 * Don't remove progress for items going out
			 * Don't progress the goals when banking
			*/
			if (!hasGoalForItem(itemId) || delta <= 0 || isBanking())
			{
				continue;
			}

			progressGoal(itemId, delta);
		}
	}

	private void fetchUserGoals(String username)
	{
		final Gson gson = new Gson();
		String dataJSON = config.itemGoalsData();
		Map<String, ArrayList<ItemGoal>> goals = gson.fromJson(
				dataJSON,
				new TypeToken<Map<String, ArrayList<ItemGoal>>>()
				{ }.getType()
		);

		if (goals == null)
		{
			return;
		}

		if (goals.containsKey(username))
		{
			userGoals = goals.get(username);
			return;
		}
	}

	private void storeUserGoals(String username)
	{
		final Gson gson = new Gson();
		// Fetch the entire config to avoid overwriting other users' goals
		String dataJSON = config.itemGoalsData();
		Map<String, ArrayList<ItemGoal>> goals = gson.fromJson(
				dataJSON,
				new TypeToken<Map<String, ArrayList<ItemGoal>>>()
				{ }.getType()
		);

		if (goals == null || goals.isEmpty())
		{
			goals = new HashMap<>();
		}

		goals.put(username, userGoals);
		String goalsJSON = gson.toJson(goals);
		config.itemGoalsData(goalsJSON);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState state = gameStateChanged.getGameState();

		if (state == GameState.LOGGED_IN)
		{
			// Store the username because there's no way to get it when the gamestate changes to LOGIN_SCREEN
			loggedInAs = client.getUsername();

			// Retrieve this user's goals from config
			fetchUserGoals(loggedInAs);

			SwingUtilities.invokeLater(() ->
			{
				goalsPanel.rebuildGoals();
				goalsPanel.setLoggedIn(true);
			});
		}
		else if (state == GameState.LOGIN_SCREEN)
		{
			/*
			 * loggedInAs will only contain a username if the player logged in first,
			 * so this is to check if the gamestate change was a logout.
			*/
			if (loggedInAs.isEmpty())
			{
				return;
			}

			// Store this user's goals in config
			storeUserGoals(loggedInAs);
			// Clear the goals
			userGoals = new ArrayList<>();
			// Clear the goals panel
			SwingUtilities.invokeLater(() ->
			{
				goalsPanel.fullReset();
				goalsPanel.setLoggedIn(false);
			});

			// If you fail login, onGameStateChanged is called again. So we reset loggedInAs to prevent overwriting saves
			loggedInAs = "";
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		/*
		 * onItemContainerChanged is called when the player logs in.
		 * We don't want to track progress on the inventory the player has when they log in,
		 * since it could lead to counting items twice.
		 */
		if (loggedInAs.isEmpty())
		{
			return;
		}

		final ItemContainer container = event.getItemContainer();
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

		if (container == inventory)
		{
			updateGoalProgress(inventory.getItems());
		}
	}
}
