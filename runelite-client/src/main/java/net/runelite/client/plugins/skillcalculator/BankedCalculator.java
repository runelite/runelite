/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.skillcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.skillcalculator.banked.CriticalItem;
import net.runelite.client.plugins.skillcalculator.banked.beans.Activity;
import net.runelite.client.plugins.skillcalculator.banked.beans.SecondaryItem;
import net.runelite.client.plugins.skillcalculator.banked.ui.CriticalItemPanel;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataBonus;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;

@Slf4j
public class BankedCalculator extends JPanel
{
	private static final DecimalFormat XP_FORMAT_COMMA = new DecimalFormat("#,###.#");

	private final SkillCalculatorPanel parent;
	private final Client client;
	private final UICalculatorInputArea uiInput;
	private final SkillCalculatorConfig config;
	private final ItemManager itemManager;

	private final CacheSkillData skillData = new CacheSkillData();
	private final List<JCheckBox> bonusCheckBoxes = new ArrayList<>();

	// UI Input data
	private float xpFactor = 1.0f;
	private CalculatorType currentCalc;
	private Skill currentSkill;

	private double totalBankedXp = 0.0f;
	private JLabel totalLabel = new JLabel();
	private JPanel detailConfigContainer;
	private JPanel detailContainer;

	// Banked Experience magic
	private Map<Integer, Integer> bankMap = new HashMap<>();
	private Map<String, Boolean> categoryMap = new HashMap<>();            // Check if CriticalItem Category is enabled
	private Map<CriticalItem, CriticalItemPanel> panelMap = new HashMap<>();
	private Map<CriticalItem, Integer> criticalMap = new HashMap<>();    // Quantity of CriticalItem inside bankMap
	private Map<CriticalItem, Activity> activityMap = new HashMap<>();    // Selected Activity used for calculating xp
	private Map<CriticalItem, Integer> linkedMap = new HashMap<>();        // ItemID of item that links to the CriticalItem

	BankedCalculator(
		SkillCalculatorPanel parent,
		Client client,
		UICalculatorInputArea uiInput,
		SkillCalculatorConfig config,
		ItemManager itemManager)
	{
		this.parent = parent;
		this.client = client;
		this.uiInput = uiInput;
		this.config = config;
		this.itemManager = itemManager;

		setLayout(new DynamicGridLayout(0, 1, 0, 5));

		detailContainer = new JPanel();
		detailContainer.setLayout(new BoxLayout(detailContainer, BoxLayout.Y_AXIS));

		detailConfigContainer = new JPanel();
		detailConfigContainer.setLayout(new BoxLayout(detailConfigContainer, BoxLayout.Y_AXIS));
	}

	private void reset()
	{
		criticalMap.clear();
		linkedMap.clear();
		xpFactor = 1f;
	}

	/**
	 * Update target Xp and Level inputs to match current Xp + total banked XP
	 */
	private void syncInputFields()
	{
		// Update Target XP & Level to include total banked xp
		int newTotal = (int) (uiInput.getCurrentXPInput() + totalBankedXp);
		uiInput.setTargetXPInput(newTotal);
		uiInput.setTargetLevelInput(Experience.getLevelForXp(newTotal));
	}

	/*
	 * Banked Experience Logic
	 */

	/**
	 * Shows the Banked Xp tab for the CalculatorType
	 *
	 * @param calculatorType Selected Calculator Type
	 */
	void openBanked(CalculatorType calculatorType)
	{
		// clean slate for creating the required panel
		removeAll();
		reset();
		if (calculatorType.getSkill() != currentSkill)
		{
			// Only clear Category and Activity map on skill change.
			activityMap.clear();
			categoryMap.clear();
		}
		currentCalc = calculatorType;
		currentSkill = calculatorType.getSkill();
		bankMap = parent.getBankMap();

		uiInput.setCurrentLevelInput(client.getRealSkillLevel(currentSkill));
		uiInput.setCurrentXPInput(client.getSkillExperience(currentSkill));

		// Only adds Banked Experience portion if enabled for this SkillCalc and have seen their bank
		if (!calculatorType.isBankedXpFlag())
		{
			add(new JLabel("<html><div style='text-align: center;'>Banked Experience is not enabled for this skill.</div></html>", JLabel.CENTER));
		}
		else if (bankMap.size() <= 0)
		{
			add(new JLabel("Please visit a bank!", JLabel.CENTER));
		}
		else
		{
			// Prevent editing of the target level/exp since we automagically adjust them
			uiInput.getUiFieldTargetLevel().setEditable(false);
			uiInput.getUiFieldTargetXP().setEditable(false);

			// Now we can actually show the Banked Experience Panel
			// Adds Config Options for this panel
			renderBankedXpOptions();

			renderBonusXpOptions();

			// sprite 202
			calculatedBankedMaps();

			// Calculate total banked experience and create detail container
			refreshDetailContainer();

			// Add back all necessary content
			add(detailConfigContainer);
			add(totalLabel);
			add(detailContainer);
		}

		revalidate();
		repaint();

		// Update the input fields.
		syncInputFields();
	}

	/**
	 * Add the config options for toggling each Item Category
	 */
	private void renderBankedXpOptions()
	{
		Set<String> categories = CriticalItem.getSkillCategories(currentSkill);
		if (categories == null)
		{
			return;
		}

		add(new JLabel("Configs:"));

		for (String category : categories)
		{
			JPanel uiOption = new JPanel(new BorderLayout());
			JLabel uiLabel = new JLabel(category);
			JCheckBox uiCheckbox = new JCheckBox();

			uiLabel.setForeground(Color.WHITE);
			uiLabel.setFont(FontManager.getRunescapeSmallFont());

			uiOption.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 0));
			uiOption.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			// Everything is enabled by default
			uiCheckbox.setSelected(true);
			categoryMap.put(category, true);

			// Adjust Total Banked XP check-state of the box.
			uiCheckbox.addActionListener(e -> toggleCategory(category, uiCheckbox.isSelected()));
			uiCheckbox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

			uiOption.add(uiLabel, BorderLayout.WEST);
			uiOption.add(uiCheckbox, BorderLayout.EAST);

			add(uiOption);
			add(Box.createRigidArea(new Dimension(0, 5)));
		}
	}

	/**
	 * Used to toggle Categories of Items inside the Banked Xp tab
	 *
	 * @param category Category Name
	 * @param enabled  is enabled
	 */
	private void toggleCategory(String category, boolean enabled)
	{
		categoryMap.put(category, enabled);
		refreshDetailContainer();
	}


	/**
	 * Creates the Maps used for easy access when calculating Banked Xp
	 */
	private void calculatedBankedMaps()
	{
		// Grab all CriticalItems for this skill
		ArrayList<CriticalItem> items = CriticalItem.getBySkillName(currentSkill);

		// Loop over all Critical Items for this skill and determine how many are in the bank
		for (CriticalItem item : items)
		{
			Integer qty = bankMap.get(item.getItemID());
			if (qty != null && qty > 0)
			{
				if (criticalMap.containsKey(item))
				{
					criticalMap.put(item, criticalMap.get(item) + qty);
				}
				else
				{
					criticalMap.put(item, qty);
				}

				// Ensure the item this is linked to maps back to us.
				if (item.getLinkedItemId() != -1)
				{
					CriticalItem i = CriticalItem.getByItemId(item.getLinkedItemId());
					if (i != null)
					{
						linkedMap.put(i, item.getItemID());
					}
				}
			}
		}
	}

	/**
	 * Populates the detailContainer with the necessary CriticalItemPanels
	 */
	private void refreshDetailContainer()
	{
		detailContainer.removeAll();
		panelMap.clear();

		Map<CriticalItem, Integer> map = getBankedXpBreakdown();
		for (Map.Entry<CriticalItem, Integer> entry : map.entrySet())
		{
			CriticalItem item = entry.getKey();
			createItemPanel(item);
		}

		detailContainer.revalidate();
		detailContainer.repaint();

		calculateBankedXpTotal();
	}

	/**
	 * Creates an Individual Item Panel if it should be displayed
	 *
	 * @param item CriticalItem this information is tied too
	 */
	private void createItemPanel(CriticalItem item)
	{
		// Category Included?
		if (categoryMap.get(item.getCategory()))
		{
			// Get possible activities limited to current level
			List<Activity> activities = Activity.getByCriticalItem(item, uiInput.getCurrentLevelInput());

			// Check if this should count as another item.
			if (item.getLinkedItemId() != -1)
			{
				// Ensure the linked item panel is created even if there are none in bank.
				CriticalItem linked = CriticalItem.getByItemId(item.getLinkedItemId());
				if (!criticalMap.containsKey(linked))
				{
					createItemPanel(linked);
				}

				// One activity and rewards no xp ignore.
				if (activities.size() == 1)
				{
					if (activities.get(0).getXp() <= 0)
					{
						return;
					}
				}
			}

			// If it doesn't have any activities ignore it in the breakdown.
			if (activities.size() <= 0)
			{
				return;
			}
			// Either this item has multiple activities or the single activity rewards xp, create the item panel.

			// Determine xp rate for this item
			Activity a = getSelectedActivity(item);
			double activityXp = a == null ? 0 : a.getXp();
			double xp = activityXp * (item.isIgnoreBonus() ? 1.0f : xpFactor);
			int amount = 0;

			// If it has linked items figure out the working total.
			Map<CriticalItem, Integer> links = getLinkedTotalMap(item);
			for (Integer num : links.values())
			{
				amount += num;
			}

			// Actually create the panel displaying banked experience for this item
			CriticalItemPanel panel = new CriticalItemPanel(this, itemManager, item, xp, amount, links);

			// Limit to Banked Secondaries
			if (config.limitedBankedSecondaries() && a != null)
			{
				panel.updateAmount(limitToActivitySecondaries(a, amount), true);
				panel.recalculate();
			}
			panelMap.put(item, panel);
			detailContainer.add(panel);
		}

	}

	/**
	 * Return the Activity the player selected for this Item. Defaults to First activity
	 *
	 * @param i CriticalItem to check for
	 * @return selected Activity
	 */
	public Activity getSelectedActivity(CriticalItem i)
	{
		// Pull from memory if available
		Activity a = activityMap.get(i);
		if (a != null)
		{
			return a;
		}

		// If not in memory select the first Activity and add to memory
		List<Activity> activities = Activity.getByCriticalItem(i);
		if (activities.size() == 0)
		{
			// If you can't find an activity it means this item must link to one and give 0 xp
			return null;
		}

		Activity selected = activities.get(0);
		activityMap.put(i, selected);
		return selected;
	}

	/**
	 * Creates a Map of Item ID and QTY for this Skill by Category. Keeps order for better UI display
	 *
	 * @return Map of Item ID and QTY for this Skill by Category
	 */
	private Map<CriticalItem, Integer> getBankedXpBreakdown()
	{
		Map<CriticalItem, Integer> map = new LinkedHashMap<>();

		for (String category : CriticalItem.getSkillCategories(currentSkill))
		{
			ArrayList<CriticalItem> items = CriticalItem.getItemsForSkillCategories(currentSkill, category);
			for (CriticalItem item : items)
			{
				Integer amount = bankMap.get(item.getItemID());
				if (amount != null && amount > 0)
				{
					map.put(item, amount);
				}
			}
		}

		return map;
	}

	/**
	 * Used to select an Activity for an item
	 *
	 * @param i CriticalItem
	 * @param a Activity selected
	 */
	public void activitySelected(CriticalItem i, Activity a)
	{
		// This is triggered on every click so don't update if activity didn't actually change
		Activity cur = activityMap.get(i);
		if (cur == a)
		{
			return;
		}

		// Update selected activity in map
		activityMap.put(i, a);

		// If had a previous selection and this item links to another check for item prevention change.
		// If there are changes adjust the Linked panel quantity as well
		if (cur != null && i.getLinkedItemId() != -1)
		{
			if (cur.isPreventLinked() != a.isPreventLinked())
			{
				CriticalItem linked = CriticalItem.getByItemId(i.getLinkedItemId());
				CriticalItemPanel l = panelMap.get(linked);
				if (l != null)
				{
					l.updateLinkedMap(getLinkedTotalMap(linked));
					int amount = config.limitedBankedSecondaries() ? limitToActivitySecondaries(a, l.getAmount()) : l.getAmount();
					l.updateAmount(amount, false);
					l.recalculate();
				}
			}
		}

		// Total banked experience
		CriticalItemPanel p = panelMap.get(i);
		if (p != null)
		{
			p.updateLinkedMap(getLinkedTotalMap(i));
			int amount = config.limitedBankedSecondaries() ? limitToActivitySecondaries(a, p.getAmount()) : p.getAmount();
			p.updateAmount(amount, true);
			p.updateXp(a.getXp() * (i.isIgnoreBonus() ? 1.0f : xpFactor));
		}

		// Update total banked xp value based on updated panels
		calculateBankedXpTotal();
	}

	private Map<CriticalItem, Integer> getLinkedTotalMap(CriticalItem i)
	{
		return getLinkedTotalMap(i, true);
	}

	/**
	 * Creates a Map of CriticalItem and Qty for all items that link to the passed CriticalItem
	 *
	 * @param i     CriticalItem to base Map off of
	 * @param first Since this is called recursively we want to ensure the original CriticalItem is always added
	 * @return Map of Linked CriticalItems and their Qty
	 */
	private Map<CriticalItem, Integer> getLinkedTotalMap(CriticalItem i, boolean first)
	{
		Map<CriticalItem, Integer> map = new LinkedHashMap<>();
		if (!categoryMap.get(i.getCategory()))
		{
			return map;
		}

		// This item has an activity selected and its preventing linked functionality?
		Activity selected = activityMap.get(i);
		if (selected != null && selected.isPreventLinked())
		{
			// If initial request is for this item
			if (!first)
			{
				return map;
			}
		}

		// Add self to map
		int amount = criticalMap.getOrDefault(i, 0);
		if (amount > 0)
		{
			map.put(i, amount);
		}

		// This item doesn't link to anything, all done.
		if (linkedMap.get(i) == null)
		{
			return map;
		}

		CriticalItem item = CriticalItem.getByItemId(linkedMap.get(i));
		if (item == null)
		{
			log.warn("Error finding Critical Item for Item ID: {}", linkedMap.get(i));
			return map;
		}

		map.putAll(getLinkedTotalMap(item, false));

		return map;
	}

	/**
	 * SkillCalculatorPlugin sends the Bank Map when the bank contents change
	 *
	 * @param map Map of Item IDs and Quantity
	 */
	void updateBankMap(Map<Integer, Integer> map)
	{
		boolean oldMapFlag = (bankMap.size() <= 0);
		bankMap = map;
		// Refresh entire panel if old map was empty
		if (oldMapFlag)
		{
			CalculatorType calc = CalculatorType.getBySkill(currentSkill);
			SwingUtilities.invokeLater(() -> openBanked(calc));
			return;
		}

		// recalculate all data related to banked experience except for activity selections
		criticalMap.clear();
		linkedMap.clear();
		calculatedBankedMaps();

		// Update the Total XP banked and the details panel
		SwingUtilities.invokeLater(this::refreshDetailContainer);
	}

	/**
	 * Loops over all ItemPanels too sum their total xp and updates the label with the new value
	 */
	private void calculateBankedXpTotal()
	{
		double total = 0.0;
		for (CriticalItemPanel p : panelMap.values())
		{
			total += p.getTotal();
		}

		totalBankedXp = total;

		syncBankedXp();
	}

	/**
	 * Used to update the UI to reflect the new Banked XP amount
	 */
	private void syncBankedXp()
	{
		totalLabel.setText("Total Banked xp: " + XP_FORMAT_COMMA.format(totalBankedXp));

		syncInputFields();

		revalidate();
		repaint();
	}

	/**
	 * Check Bank for Activity Secondaries and Limits to possible Activity amounts
	 *
	 * @param a        Selected Activity
	 * @param possible Amount of Critical Item available
	 * @return possible Limited to Banked Secondaries
	 */
	private int limitToActivitySecondaries(Activity a, int possible)
	{
		for (SecondaryItem i : a.getSecondaries())
		{
			int banked = bankMap.getOrDefault(i.getId(), 0);
			int newPossible = banked / i.getQty();
			possible = newPossible < possible ? newPossible : possible;
		}

		return possible;
	}

	/**
	 * Renders the Xp Modifier options
	 */

	private void renderBonusXpOptions()
	{
		SkillDataBonus[] bonuses = skillData.getSkillData(currentCalc.getDataFile()).getBonuses();
		if (bonuses != null)
		{
			add(new JLabel("Bonus Experience:"));
			for (SkillDataBonus bonus : bonuses)
			{
				JPanel checkboxPanel = buildCheckboxPanel(bonus);

				add(checkboxPanel);
				add(Box.createRigidArea(new Dimension(0, 5)));
			}
		}
	}

	private JPanel buildCheckboxPanel(SkillDataBonus bonus)
	{
		JPanel uiOption = new JPanel(new BorderLayout());
		JLabel uiLabel = new JLabel(bonus.getName());
		JCheckBox uiCheckbox = new JCheckBox();

		uiLabel.setForeground(Color.WHITE);
		uiLabel.setFont(FontManager.getRunescapeSmallFont());

		uiOption.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 0));
		uiOption.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Adjust XP bonus depending on check-state of the boxes.
		uiCheckbox.addActionListener(event -> adjustCheckboxes(uiCheckbox, bonus));

		uiCheckbox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

		uiOption.add(uiLabel, BorderLayout.WEST);
		uiOption.add(uiCheckbox, BorderLayout.EAST);
		bonusCheckBoxes.add(uiCheckbox);

		return uiOption;
	}

	private void adjustCheckboxes(JCheckBox target, SkillDataBonus bonus)
	{
		adjustXPBonus(0);
		bonusCheckBoxes.forEach(otherSelectedCheckbox ->
		{
			if (otherSelectedCheckbox != target)
			{
				otherSelectedCheckbox.setSelected(false);
			}
		});

		if (target.isSelected())
		{
			adjustXPBonus(bonus.getValue());
		}
	}

	private void adjustXPBonus(float value)
	{
		xpFactor = 1f + value;
		refreshDetailContainer();
	}
}