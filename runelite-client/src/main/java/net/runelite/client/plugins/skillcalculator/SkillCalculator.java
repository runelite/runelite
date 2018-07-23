/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.skillcalculator.beans.SkillData;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataBonus;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

class SkillCalculator extends JPanel
{
	private static final int MAX_XP = 200_000_000;
	private static final DecimalFormat XP_FORMAT = new DecimalFormat("#.#");
	private static final DecimalFormat XP_FORMAT_COMMA = new DecimalFormat("#,###.#");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");

	static SpriteManager spriteManager;
	static ItemManager itemManager;
	static SkillCalculatorPlugin plugin;

	private Client client;
	private Skill skill;
	private SkillData skillData;
	private List<UIActionSlot> uiActionSlots = new ArrayList<>();
	private UICalculatorInputArea uiInput;

	private CacheSkillData cacheSkillData = new CacheSkillData();

	private UICombinedActionSlot combinedActionSlot = new UICombinedActionSlot();
	private ArrayList<UIActionSlot> combinedActionSlots = new ArrayList<>();

	private int currentLevel = 1;
	private int currentXP = Experience.getXpForLevel(currentLevel);
	private int targetLevel = currentLevel + 1;
	private int targetXP = Experience.getXpForLevel(targetLevel);
	private float xpFactor = 1.0f;

	private String currentTab;

	private double totalPlannerXp = 0.0f;

	// Banked Experience Variables
	private Map<Integer, Integer> bankMap = new HashMap<>();
	private Map<String, Boolean> categoryMap = new HashMap<>();
	private float totalBankedXp = 0.0f;
	private JLabel totalLabel = new JLabel();
	private JPanel detailConfigContainer;
	private JPanel detailContainer;

	// Ignore item ids for banked experience
	private Map<Integer, Boolean> ignoreMap = new HashMap<>();

	SkillCalculator(Client client, UICalculatorInputArea uiInput)
	{
		this.client = client;
		this.uiInput = uiInput;

		setLayout(new DynamicGridLayout(0, 1, 0, 5));

		// Register listeners on the input fields and then move on to the next related text field
		uiInput.uiFieldCurrentLevel.addActionListener(e ->
		{
			onFieldCurrentLevelUpdated();
			uiInput.uiFieldTargetLevel.requestFocusInWindow();
		});

		uiInput.uiFieldCurrentXP.addActionListener(e ->
		{
			onFieldCurrentXPUpdated();
			uiInput.uiFieldTargetXP.requestFocusInWindow();
		});

		uiInput.uiFieldTargetLevel.addActionListener(e -> onFieldTargetLevelUpdated());
		uiInput.uiFieldTargetXP.addActionListener(e -> onFieldTargetXPUpdated());

		detailContainer = new JPanel();
		detailContainer.setLayout(new BoxLayout(detailContainer, BoxLayout.Y_AXIS));

		detailConfigContainer = new JPanel();
		detailConfigContainer.setLayout(new BoxLayout(detailConfigContainer, BoxLayout.Y_AXIS));
	}

	private void updateData(CalculatorType calculatorType)
	{
		// Load the skill data.
		skillData = cacheSkillData.getSkillData(calculatorType.getDataFile());

		// Store the current skill
		skill = calculatorType.getSkill();
		bankMap = plugin.getBankMap();

		// Reset the XP factor, removing bonuses.
		xpFactor = 1.0f;
		totalBankedXp = 0.0f;
		totalPlannerXp = 0.0f;
		ignoreMap.clear();

		// Update internal skill/XP values.
		currentXP = client.getSkillExperience(skill);
		currentLevel = Experience.getLevelForXp(currentXP);
		targetLevel = enforceSkillBounds(currentLevel + 1);
		targetXP = Experience.getXpForLevel(targetLevel);

		if (currentTab.equals("Planner") || currentTab.equals("Banked Xp"))
		{
			uiInput.getUiFieldTargetLevel().setEditable(false);
			uiInput.getUiFieldTargetXP().setEditable(false);
		}
		else
		{
			uiInput.getUiFieldTargetLevel().setEditable(true);
			uiInput.getUiFieldTargetXP().setEditable(true);
		}

	}

	// Opens the Calculator tab for the current Skill
	void openCalculator(CalculatorType calculatorType)
	{
		currentTab = "Calculator";

		// clean slate for creating the required panel
		removeAll();
		updateData(calculatorType);

		// Add in checkboxes for available skill bonuses.
		renderBonusOptions();

		// Add the combined action slot.
		add(combinedActionSlot);

		// Create action slots for the skill actions.
		renderActionSlots();

		// Update the input fields.
		updateInputFields();
	}

	// Opens the Planner tab for the current Skill
	void openPlanner(CalculatorType calculatorType)
	{
		currentTab = "Planner";

		// clean slate for creating the required panel
		removeAll();
		updateData(calculatorType);

		// Add in checkboxes for available skill bonuses.
		renderBonusOptions();

		// Create action slots for the skill actions.
		renderActionSlots();

		// Initialize Planner
		calculatePlanner();

		// Update the input fields.
		syncInputFields();
	}

	// Opens the Banked XP tab for the current Skill
	void openBanked(CalculatorType calculatorType)
	{
		currentTab = "Banked Xp";

		// clean slate for creating the required panel
		removeAll();
		updateData(calculatorType);

		// Only adds Banked Experience portion if enabled for this SkillCalc and have seen their bank
		if (!calculatorType.isBankedXpFlag())
		{
			add(new JLabel("<html><div style='text-align: center;'>Banked Experience is not enabled for this skill.</div></html>", JLabel.CENTER));
			revalidate();
			repaint();
		}
		else if (bankMap.size() <= 0)
		{
			add(new JLabel( "Please visit a bank!", JLabel.CENTER));
			revalidate();
			repaint();
		}
		else
		{
			// Now we can actually show the Banked Experience Panel
			// Adds Config Options for this panel
			renderBankedExpOptions();

			// Adds in checkboxes for available skill bonuses, same as Skill Calc
			renderBonusOptions();

			// Adds in the Detail Container config options
			renderBankedConfigOptions();

			// Total banked experience
			calculateBankedExpTotal();

			// Create the banked experience details container
			detailContainer.removeAll();
			refreshBankedExpDetails();

			add(detailConfigContainer);
			add(totalLabel);
			add(detailContainer);
		}

		// Update the input fields.
		syncInputFields();
	}

	private void updateCombinedAction()
	{
		int size = combinedActionSlots.size();
		if (size > 1)
		{
			combinedActionSlot.setTitle(size + " actions selected");
		}
		else if (size == 1)
		{
			combinedActionSlot.setTitle("1 action selected");
		}
		else
		{
			combinedActionSlot.setTitle("No action selected");
			combinedActionSlot.setText("Shift-click to select multiple");
			return;
		}

		int actionCount = 0;
		int neededXP = targetXP - currentXP;
		double xp = 0;

		for (UIActionSlot slot : combinedActionSlots)
			xp += slot.getValue();

		if (neededXP > 0)
			actionCount = (int) Math.ceil(neededXP / xp);

		combinedActionSlot.setText(formatXPActionString(xp, actionCount, "exp - "));
	}

	private void clearCombinedSlots()
	{
		for (UIActionSlot slot : combinedActionSlots)
			slot.setSelected(false);

		combinedActionSlots.clear();
	}

	private void renderBonusOptions()
	{
		if (skillData.getBonuses() != null)
		{
			add(new JLabel("Bonus Experience Configuration:"));

			for (SkillDataBonus bonus : skillData.getBonuses())
			{
				JPanel uiOption = new JPanel(new BorderLayout());
				JLabel uiLabel = new JLabel(bonus.getName());
				JCheckBox uiCheckbox = new JCheckBox();

				uiLabel.setForeground(Color.WHITE);
				uiLabel.setFont(FontManager.getRunescapeSmallFont());

				uiOption.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 0));
				uiOption.setBackground(ColorScheme.DARKER_GRAY_COLOR);

				// Adjust XP bonus depending on check-state of the boxes.
				uiCheckbox.addActionListener(e -> adjustXPBonus(uiCheckbox.isSelected(), bonus.getValue()));
				uiCheckbox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

				uiOption.add(uiLabel, BorderLayout.WEST);
				uiOption.add(uiCheckbox, BorderLayout.EAST);

				add(uiOption);
				add(Box.createRigidArea(new Dimension(0, 5)));
			}
		}
	}

	// Adds the Configuration options for Banked Experience to the panel
	private void renderBankedExpOptions()
	{
		Set<String> categories = BankedItems.getSkillCategories(skill);
		if (categories == null)
			return;

		add(new JLabel("Banked Experience Configuration:"));

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
			uiCheckbox.addActionListener(e -> adjustBankedXp(uiCheckbox.isSelected(), category));
			uiCheckbox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

			uiOption.add(uiLabel, BorderLayout.WEST);
			uiOption.add(uiCheckbox, BorderLayout.EAST);

			add(uiOption);
			add(Box.createRigidArea(new Dimension(0, 5)));
		}
	}


	private void renderBankedConfigOptions()
	{
		detailConfigContainer.removeAll();

		ArrayList<BankedItemOptions> options = BankedItemOptions.getBySkill(skill);
		if (options != null)
		{
			Map<Integer, ArrayList<BankedItemOptions>> dropdown = BankedItemOptions.resourceSetMap(options);
			for (Map.Entry<Integer, ArrayList<BankedItemOptions>> entry : dropdown.entrySet())
			{
				JPanel panel = createBankedOptionDropdown(entry);

				if (panel != null)
					detailConfigContainer.add(panel);
			}
		}
	}

	// Creates the Options for changing xp rates
	private JPanel createBankedOptionDropdown(Map.Entry<Integer, ArrayList<BankedItemOptions>> entry)
	{
		ArrayList<BankedItemOptions> options = entry.getValue();

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel(itemManager.getItemComposition(entry.getKey()).getName());

		MaterialTabGroup group = new MaterialTabGroup();
		group.setLayout(new GridLayout(0, 3, 0, 2));
		group.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

		for (BankedItemOptions option : options)
		{
			final double newxp = option.getBasexp();
			final int[] itemIds = option.getItemOption().getItems();

			// If all items this effects are ignored or not available in bank map don't add this option
			boolean dontAddFlag = true;
			for (int itemID : itemIds)
			{
				Integer amount = bankMap.get(itemID);
				if ((amount != null && amount > 0) && (!ignoreMap.containsKey(itemID)))
				{
					dontAddFlag = false;
					break;
				}
			}
			if (dontAddFlag)
				continue;

			AsyncBufferedImage icon = itemManager.getImage(option.getItemID());
			MaterialTab matTab = new MaterialTab("", group, null);
			matTab.setHorizontalAlignment(SwingUtilities.RIGHT);
			matTab.setToolTipText(option.getName());

			matTab.setOnSelectEvent(() ->
			{
				newBankedXpValue(newxp, itemIds);
				return true;
			});

			Runnable resize = () ->
					matTab.setIcon(new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
			icon.onChanged(resize);
			resize.run();

			group.addTab(matTab);
		}

		if (group.getComponentCount() > 0)
		{
			group.select(group.getTab(0)); // Select first option;

			panel.add(label, BorderLayout.WEST);
			panel.add(group, BorderLayout.EAST);

			return panel;
		}
		else
		{
			return null;
		}
	}

	// Used to adjust base xp rate for certain item ids
	private void newBankedXpValue(double xp, int[] itemIDs)
	{
		for (int id : itemIDs)
		{
			BankedItems item = BankedItems.getByItemId(id);
			if (item != null)
			{
				item.setBasexp(xp);
			}
		}

		// Only recalculate if banked experience has already been calculated
		if (totalBankedXp > 0.0f)
		{
			calculateBankedExpTotal();
			refreshBankedExpDetails();
		}
	}

	// Creates uiActionSlots for Calculator and Planner tabs
	private void renderActionSlots()
	{
		// Wipe the list of references to the slot components.
		uiActionSlots.clear();

		// Create new components for the action slots.
		for (SkillDataEntry action : skillData.getActions())
		{
			UIActionSlot slot = new UIActionSlot(action);
			uiActionSlots.add(slot); // Keep our own reference.
			add(slot); // Add component to the panel.

			if (currentTab.equals("Calculator"))
			{
				slot.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						if (!e.isShiftDown())
							clearCombinedSlots();

						if (slot.isSelected())
							combinedActionSlots.remove(slot);
						else
							combinedActionSlots.add(slot);

						slot.setSelected(!slot.isSelected());
						updateCombinedAction();
					}
				});
			}
			else if (currentTab.equals("Planner"))
			{
				// Right-Click Menu
				JPopupMenu menu = new JPopupMenu("");
				JMenuItem item = new JMenuItem("Input Amount");
				item.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						specifyPlannerSlotAmount(slot);
					}
				});

				JMenuItem clearItem = new JMenuItem("Clear Amount");
				clearItem.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						clearSlot(slot);
					}
				});

				JMenuItem clearAllItem = new JMenuItem("Clear All Amounts");
				clearAllItem.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						clearAllSlots();
					}
				});

				menu.add(item);
				menu.add(clearItem);
				menu.add(clearAllItem);

				slot.setComponentPopupMenu(menu);
			}
		}

		// Refresh the rendering of this panel.
		revalidate();
		repaint();
	}

	// Recreates the Banked Experience Detail container
	private void refreshBankedExpDetails()
	{
		detailContainer.removeAll();

		Map<BankedItems, Integer> map = getBankedExpBreakdown();
		for (Map.Entry<BankedItems, Integer> entry : map.entrySet())
		{
			BankedItems item = entry.getKey();
			Boolean flag = categoryMap.get(item.getCategory());
			boolean ignoreFlag = ignoreMap.containsKey(item.getItemID());
			// Category Included and Not ignoring this item ID?
			if ((flag != null && flag) && (!ignoreFlag))
			{
				double xp = item.getBasexp();
				if (!item.isBonusExempt())
					xp = xp * xpFactor;
				double total = entry.getValue() * xp;

				// Right-Click Menu
				JPopupMenu menu = new JPopupMenu("");
				JMenuItem ignore = new JMenuItem("Ignore Item");
				ignore.addActionListener(e -> ignoreItemID(item.getItemID()));
				menu.add(ignore);

				// Exp panel
				BankedExpPanel panel = new BankedExpPanel(itemManager, item, entry.getValue(), total);
				panel.setComponentPopupMenu(menu);

				detailContainer.add(panel);
			}
		}

		detailContainer.revalidate();
		detailContainer.repaint();
	}

	// Updates the UI Actions for the Calculator Tab
	private void calculate()
	{
		if (!currentTab.equals("Calculator"))
			return;

		for (UIActionSlot slot : uiActionSlots)
		{
			int actionCount = 0;
			int neededXP = targetXP - currentXP;
			SkillDataEntry action = slot.getAction();
			double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;

			if (neededXP > 0)
				actionCount = (int) Math.ceil(neededXP / xp);

			slot.setText("Lvl. " + action.getLevel() + " (" + formatXPActionString(xp, actionCount, "exp) - "));
			slot.setAvailable(currentLevel >= action.getLevel());
			slot.setOverlapping(action.getLevel() < targetLevel);
			slot.setValue(xp);
		}

		updateCombinedAction();
	}

	private void calculatePlanner()
	{
		if (!currentTab.equals("Planner"))
			return;

		totalPlannerXp = 0.0f;

		for (UIActionSlot slot : uiActionSlots)
		{
			SkillDataEntry action = slot.getAction();
			double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;
			updatePlannerSlot(slot);
			totalPlannerXp += slot.getValue() * xp;
		}

		updatePlannerXP();
	}

	// Calculate the total banked experience and display it in the panel
	private void calculateBankedExpTotal()
	{
		if (!currentTab.equals("Banked Xp"))
			return;

		totalBankedXp = 0.0f;

		Set<String> categories = BankedItems.getSkillCategories(skill);
		if (categories == null)
			return;

		for (String category : categories)
		{
			Boolean flag = categoryMap.get(category);
			if (flag != null && flag)
			{
				totalBankedXp += getSkillCategoryTotal(skill, category);
			}
		}

		totalLabel.setText("Banked Exp: " + XP_FORMAT_COMMA.format(totalBankedXp));

		// Update Target XP & Level to include total banked xp
		targetXP = (int) (currentXP + totalBankedXp);
		targetLevel = Experience.getLevelForXp(targetXP);
		syncInputFields();

		revalidate();
		repaint();
	}

	// Returns a Map of Items with the amount inside the bank as the value. Items added by category.
	private Map<BankedItems, Integer> getBankedExpBreakdown()
	{
		Map<BankedItems, Integer> map = new LinkedHashMap<>();

		for (String category : BankedItems.getSkillCategories(skill))
		{
			ArrayList<BankedItems> items = BankedItems.getItemsForSkillCategories(skill, category);
			for (BankedItems item : items)
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

	// Calculates Total Banked XP for this Skill Category
	private int getSkillCategoryTotal(Skill skill, String category)
	{
		ArrayList<BankedItems> items = BankedItems.getItemsForSkillCategories(skill, category);
		int total = 0;

		for (BankedItems item : items)
		{
			Integer amount = bankMap.get(item.getItemID());
			boolean ignoreFlag = ignoreMap.containsKey(item.getItemID());
			if ((amount != null && amount > 0) && !ignoreFlag)
			{
				// Find out xp for this stack (including any xp factors that should be applied)
				double xp = item.getBasexp();
				if (!item.isBonusExempt())
				{
					xp = xp * xpFactor;
				}
				total += amount * xp;
			}
		}

		return total;
	}

	// Updates an individual Planner action panels
	private void updatePlannerSlot(UIActionSlot slot)
	{
		int actionCount = 0;
		SkillDataEntry action = slot.getAction();

		if (slot.getValue() > 0)
			actionCount = slot.getValue();

		double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;
		int actionXP = (int) (actionCount * xp);

		// Update Icon
		slot.setIconAmount(actionCount);

		// Update Displayed Text
		slot.setText("Lvl. " + action.getLevel() + " - " + XP_FORMAT_COMMA.format(actionXP) + " xp");
		slot.setAvailable(currentLevel >= action.getLevel());
		slot.setValue(actionCount);
	}

	// Requests user input for Planner Amount and updates the UI
	private void specifyPlannerSlotAmount(UIActionSlot slot)
	{
		// Ask for input if high enough level
		if (currentLevel < slot.getAction().getLevel())
		{
			JOptionPane.showMessageDialog(slot, "You don't have a high enough level for this action!");
			return;
		}
		
		int oldVal = slot.getValue();

		String result = JOptionPane.showInputDialog(slot, "Requested Action Amount:", oldVal);

		// Clicked Cancel Button?
		if (result == null)
			return;

		// Parse number from input
		Matcher m = NUMBER_PATTERN.matcher(result);
		if (m.find())
		{
			slot.setValue(Integer.valueOf(m.group()));
		}
		else
		{
			JOptionPane.showMessageDialog(slot, "Error parsing number, nothing changed!");
			return;
		}

		// Specified a new
		SkillDataEntry action = slot.getAction();

		// adjust total planner xp value
		double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;
		// Remove old xp total
		if (oldVal > 0)
			totalPlannerXp -= oldVal * xp;
		// Add new XP total
		totalPlannerXp = totalPlannerXp + (slot.getValue() * xp);

		updatePlannerXP();

		// Update Slot UI
		updatePlannerSlot(slot);
	}

	private void updatePlannerXP()
	{
		// Update UI inputs to account for new XP
		targetXP = (int) (currentXP + totalPlannerXp);
		targetLevel = Experience.getLevelForXp(targetXP);
		syncInputFields();
	}

	private void clearSlot(UIActionSlot slot)
	{
		// Remove value from totalPlannerXp
		if (slot.getValue() > 0)
		{
			SkillDataEntry action = slot.getAction();
			double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;
			totalPlannerXp -= xp * slot.getValue();
		}
		slot.setValue(0);

		updatePlannerSlot(slot);

		updatePlannerXP();
	}

	// Used for the planner right-click option
	private void clearAllSlots()
	{
		for (UIActionSlot slot : uiActionSlots)
		{
			clearSlot(slot);
		}

		totalPlannerXp = 0.0f;
		updatePlannerXP();
	}

	private String formatXPActionString(double xp, int actionCount, String expExpression)
	{
		return XP_FORMAT.format(xp) + expExpression + NumberFormat.getIntegerInstance().format(actionCount) + (actionCount > 1 ? " actions" : " action");
	}

	private void updateInputFields()
	{
		if (targetXP < currentXP)
		{
			targetLevel = enforceSkillBounds(currentLevel + 1);
			targetXP = Experience.getXpForLevel(targetLevel);
		}

		syncInputFields();

		if (currentTab.equals("Calculator"))
			calculate();
	}

	private void syncInputFields()
	{
		uiInput.setCurrentLevelInput(currentLevel);
		uiInput.setCurrentXPInput(currentXP);
		uiInput.setTargetLevelInput(targetLevel);
		uiInput.setTargetXPInput(targetXP);

		// Can only edit input fields when on Calculator tab
		if (currentTab.equals("Calculator"))
		{
			calculate();
		}
	}

	private void adjustXPBonus(boolean addBonus, float value)
	{
		xpFactor += addBonus ? value : -value;
		switch (currentTab)
		{
			case "Calculator":
				calculate();
				break;
			case "Planner":
				calculatePlanner();
				break;
			case "Banked Xp":
				calculateBankedExpTotal();
				refreshBankedExpDetails();
				break;
		}
	}

	private void adjustBankedXp(boolean removeBonus, String category)
	{
		categoryMap.put(category, removeBonus);
		calculateBankedExpTotal();
		refreshBankedExpDetails();
	}

	private void onFieldCurrentLevelUpdated()
	{
		currentLevel = enforceSkillBounds(uiInput.getCurrentLevelInput());
		currentXP = Experience.getXpForLevel(currentLevel);
		updateInputFields();
	}

	private void onFieldCurrentXPUpdated()
	{
		currentXP = enforceXPBounds(uiInput.getCurrentXPInput());
		currentLevel = Experience.getLevelForXp(currentXP);
		updateInputFields();
	}

	private void onFieldTargetLevelUpdated()
	{
		targetLevel = enforceSkillBounds(uiInput.getTargetLevelInput());
		targetXP = Experience.getXpForLevel(targetLevel);
		updateInputFields();
	}

	private void onFieldTargetXPUpdated()
	{
		targetXP = enforceXPBounds(uiInput.getTargetXPInput());
		targetLevel = Experience.getLevelForXp(targetXP);
		updateInputFields();
	}

	private static int enforceSkillBounds(int input)
	{
		return Math.min(Experience.MAX_VIRT_LEVEL, Math.max(1, input));
	}

	private static int enforceXPBounds(int input)
	{
		return Math.min(MAX_XP, Math.max(0, input));
	}

	void setBankMap(Map<Integer, Integer> map)
	{
		boolean oldMapFlag = (bankMap.size() <= 0);
		bankMap = map;

		if (currentTab.equals("Banked Xp"))
		{
			// Refresh entire panel if old map was empty
			if (oldMapFlag)
			{
				CalculatorType calc = CalculatorType.getBySkill(skill);
				SwingUtilities.invokeLater(() -> openBanked(calc));
				return;
			}

			// Otherwise just update the Total XP banked and the details panel
			SwingUtilities.invokeLater(this::calculateBankedExpTotal);
			SwingUtilities.invokeLater(this::refreshBankedExpDetails);
		}
	}

	private void ignoreItemID(int id)
	{
		ignoreMap.put(id, true);

		// Update bonus experience calculations
		renderBankedConfigOptions();
		calculateBankedExpTotal();
		refreshBankedExpDetails();
	}
}