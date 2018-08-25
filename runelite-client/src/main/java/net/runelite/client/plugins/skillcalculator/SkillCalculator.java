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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
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
	private static final DecimalFormat XP_FORMAT = new DecimalFormat("#,###.#");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");

	static SpriteManager spriteManager;
	static ItemManager itemManager;

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

	private double totalPlannerXp = 0.0f;
	private String currentTab;

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

	void updateData(CalculatorType calculatorType)
	{
		// Load the skill data.
		skillData = cacheSkillData.getSkillData(calculatorType.getDataFile());

		skill = calculatorType.getSkill();

		// Reset the XP factor, removing bonuses.
		xpFactor = 1.0f;
		totalPlannerXp = 0.0f;

		// Update internal skill/XP values.
		currentXP = client.getSkillExperience(skill);
		currentLevel = Experience.getLevelForXp(currentXP);
		targetLevel = enforceSkillBounds(currentLevel + 1);
		targetXP = Experience.getXpForLevel(targetLevel);

		if (currentTab.equals("Planner"))
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

	void openCalculator(CalculatorType calculatorType)
	{
		currentTab = "Calculator";

		// Remove all components (action slots) from this panel.
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


	// Requests user input for Planner Amount and updates the UI
	private void specifyPlannerSlotAmount(UIActionSlot slot)
	{
		// Ask for input if high enough level
		if (currentLevel < slot.getAction().getLevel())
		{
			JOptionPane.showMessageDialog(slot, "You don't have a high enough level for this action!");
			return;
		}

		int oldVal = (int) slot.getValue();

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

		// Specified a new number
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

	private void calculate()
	{
		if (currentTab.equals("Planner"))
		{
			calculatePlanner();
			return;
		}

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

	// Updates an individual Planner action panels
	private void updatePlannerSlot(UIActionSlot slot)
	{
		int actionCount = 0;
		SkillDataEntry action = slot.getAction();

		if (slot.getValue() > 0)
		{
			actionCount = (int) slot.getValue();
		}

		double xp = (action.isIgnoreBonus()) ? action.getXp() : action.getXp() * xpFactor;
		int actionXP = (int) (actionCount * xp);

		// Update Icon
		slot.setIconAmount(actionCount);

		// Update Displayed Text
		slot.setText("Lvl. " + action.getLevel() + " - " + XP_FORMAT.format(actionXP) + " xp");
		slot.setAvailable(currentLevel >= action.getLevel());
		slot.setValue(actionCount);
	}

	private void updatePlannerXP()
	{
		// Update UI inputs to account for new XP
		targetXP = (int) (currentXP + totalPlannerXp);
		targetLevel = Experience.getLevelForXp(targetXP);
		syncInputFields();
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
		calculate();
	}

	private void syncInputFields()
	{
		uiInput.setCurrentLevelInput(currentLevel);
		uiInput.setCurrentXPInput(currentXP);
		uiInput.setTargetLevelInput(targetLevel);
		uiInput.setTargetXPInput(targetXP);
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
		}
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