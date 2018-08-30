/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.SearchResult;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.skillcalculator.beans.SkillData;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataBonus;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;


class SkillCalculator extends JPanel
{
	private static final int MAX_XP = 200_000_000;
	private static final DecimalFormat XP_FORMAT = new DecimalFormat("#.#");
	private static final String[] buyables = {"Prayer", "Firemaking", "Construction", "Smithing", "Cooking", "Herblore"}; //, "Crafting", "Magic", "Fletching", "Farming",

	static SpriteManager spriteManager;
	static ItemManager itemManager;

	private Client client;
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
	private String skillName = null;

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
	}

	void openCalculator(CalculatorType calculatorType)
	{
		// Load the skill data.
		skillData = cacheSkillData.getSkillData(calculatorType.getDataFile());

		// Reset the XP factor, removing bonuses.
		xpFactor = 1.0f;

		// Update internal skill/XP values.
		Skill skill = calculatorType.getSkill();
		currentXP = client.getSkillExperience(skill);
		currentLevel = Experience.getLevelForXp(currentXP);
		targetLevel = enforceSkillBounds(currentLevel + 1);
		targetXP = Experience.getXpForLevel(targetLevel);
		skillName = skill.getName();

		// Remove all components (action slots) from this panel.
		removeAll();

		// Add in checkboxes for available skill bonuses.
		renderBonusOptions();

		// Add the combined action slot.
		add(combinedActionSlot);

		// Create action slots for the skill actions.
		renderActionSlots();

		// Update the input fields.
		updateInputFields();
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

		// Refresh the rendering of this panel.
		revalidate();
		repaint();
	}

	private void calculate()
	{
		boolean buyable = false;
		for (String skill : buyables)
		{
			if (skillName == skill)
			{
				buyable = true;
				break;
			}
		}
		for (UIActionSlot slot : uiActionSlots)
		{
			int actionCount = 0;
			int neededXP = targetXP - currentXP;
			SkillDataEntry action = slot.getAction();
			double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;

			if (neededXP > 0)
				actionCount = (int) Math.ceil(neededXP / xp);

			slot.setText("Lvl. " + action.getLevel() + " (" + formatXPActionString(xp, actionCount, "exp) - "), true);
			slot.setAvailable(currentLevel >= action.getLevel());
			slot.setOverlapping(action.getLevel() < targetLevel);
			slot.setValue(xp);

			String actionName = action.getName();

			if (buyable)
			{
				if (skillName.equals("Construction") && !actionName.contains("Plank")) continue;
				if (skillName.equals("Prayer") && actionName.contains("Ensouled")) continue;
				if (skillName.equals("Smithing") && !actionName.contains("Silver") && !actionName.contains("Gold")) continue;
				if (skillName.equals("Cooking") && (actionName.contains("Potato") || actionName.contains("Pizza") || actionName.contains("Batta") || actionName.contains("Snail") || actionName.contains("Cake") || actionName.contains("Roast"))) continue;
				if (actionName.equals("Gold Bar (Goldsmith Gauntlets)")) actionName = "Gold Bar";

				SearchResult result;
				try
				{
					result = itemManager.searchForItem(actionName);
				}
				catch (ExecutionException ex)
				{
					return;
				}
				if (result == null || result.getItems().isEmpty()) continue;
				//System.out.println(result.getItems());
				Item item = retrieveFromList(result.getItems(), actionName);
				if (item == null) continue;
				int itemPrice = itemManager.getItemPrice(item.getId());

				double gpPerXp;
				if (skillName.equals("Herblore"))
				{
					String[] ingredients = action.getIngredients();
					if (ingredients == null) continue;
					String primary = ingredients[0];
					int seconPrice = 0;
					try
					{
						result = itemManager.searchForItem(primary);
					}
					catch (ExecutionException ex)
					{
						return;
					}
					if (result == null || result.getItems().isEmpty()) continue;
					//System.out.println("a " + result.getItems());
					Item primItem = retrieveFromList(result.getItems(), primary);
					if (primItem == null) continue;
					int primPrice = itemManager.getItemPrice(primItem.getId());
					//System.out.println("primPrice: "+primPrice);

					if (ingredients.length == 2)
					{
						String secondary = ingredients[1];
						try
						{
							result = itemManager.searchForItem(secondary);
						}
						catch (ExecutionException ex)
						{
							return;
						}
						if (result == null || result.getItems().isEmpty()) continue;
						//System.out.println("b "+result.getItems());
						Item seconItem = retrieveFromList(result.getItems(), secondary);
						if (seconItem == null) continue;
						seconPrice = itemManager.getItemPrice(seconItem.getId());
						if (secondary.equals("Lava scale shard") || secondary.equals("Amylase crystal")) seconPrice *= 4;
						if (secondary.equals("Zulrah scales")) seconPrice *= 20;
					}
					gpPerXp = (primPrice + seconPrice - itemPrice) / xp;


				}
				else if (skillName.equals("Smithing"))
				{
					String ore = actionName.substring(0, actionName.length() - 3) + "Ore";
					try
					{
						result = itemManager.searchForItem(ore);
					}
					catch (ExecutionException ex)
					{
						return;
					}
					if (result == null || result.getItems().isEmpty()) continue;

					Item oreItem = retrieveFromList(result.getItems(), ore);
					if (oreItem == null) continue;
					int orePrice = itemManager.getItemPrice(oreItem.getId());
					gpPerXp = (orePrice - itemPrice) / xp;
				}
				else if (skillName.equals("Cooking"))
				{
					if (actionName.contains("Cooked")) actionName = actionName.substring(7);
					String raw = "Raw " + actionName;
					try
					{
						result = itemManager.searchForItem(raw);
					}
					catch (ExecutionException ex)
					{
						return;
					}
					if (result == null || result.getItems().isEmpty()) continue;

					Item rawItem = retrieveFromList(result.getItems(), raw);
					if (rawItem == null) continue;
					int rawPrice = itemManager.getItemPrice(rawItem.getId());
					gpPerXp = (rawPrice - itemPrice) / xp;
				}
				else
				{
					gpPerXp = itemPrice / xp;
				}
				slot.setText(String.format("%.2f", gpPerXp) + " gp/exp", false);
			}
		}

		updateCombinedAction();
	}

	/**
	 * Compares the names of the items in the list with the original input.
	 * Returns the item if its name is equal to the original input or null
	 * if it can't find the item.
	 *
	 * @param items         List of items.
	 * @param originalInput String with the original input.
	 * @return Item which has a name equal to the original input.
	 */
	private Item retrieveFromList(List<Item> items, String originalInput)
	{
		for (Item item : items)
		{
			if (item.getName().toLowerCase().equals(originalInput.toLowerCase()))
			{
				return item;
			}
		}
		return null;
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

		uiInput.setCurrentLevelInput(currentLevel);
		uiInput.setCurrentXPInput(currentXP);
		uiInput.setTargetLevelInput(targetLevel);
		uiInput.setTargetXPInput(targetXP);
		calculate();
	}

	private void adjustXPBonus(boolean addBonus, float value)
	{
		xpFactor += addBonus ? value : -value;
		calculate();
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
}