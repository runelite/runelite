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

import com.google.common.annotations.VisibleForTesting;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.WorldType;
import net.runelite.api.annotations.Varp;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.skillcalculator.skills.SkillAction;
import net.runelite.client.plugins.skillcalculator.skills.SkillBonus;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;

class SkillCalculator extends JPanel
{
	static final int MAX_XP_MULTIPLIER = 32;
	private static final JLabel EMPTY_PANEL = new JLabel("No F2P actions to show.");

	static
	{
		EMPTY_PANEL.setHorizontalAlignment(SwingConstants.CENTER);
		EMPTY_PANEL.setBorder(new EmptyBorder(50, 0, 0, 0));
	}

	private final UICalculatorInputArea uiInput;
	private final Client client;
	private final ClientThread clientThread;
	private final SpriteManager spriteManager;
	private final ItemManager itemManager;
	private final List<UIActionSlot> uiActionSlots = new ArrayList<>();
	private final UICombinedActionSlot combinedActionSlot;
	private final ArrayList<UIActionSlot> combinedActionSlots = new ArrayList<>();
	private final Map<SkillBonus, JCheckBox> bonusCheckBoxes = new HashMap<>();
	private final IconTextField searchBar = new IconTextField();

	private CalculatorType currentCalculator;
	private int currentLevel = 1;
	private int currentXP = Experience.getXpForLevel(currentLevel);
	private int targetLevel = currentLevel + 1;
	private int targetXP = Experience.getXpForLevel(targetLevel);
	private int xpMultiplier = 1;
	private final Set<SkillBonus> currentBonuses = new HashSet<>();

	@Inject
	SkillCalculator(Client client, ClientThread clientThread, UICalculatorInputArea uiInput, SpriteManager spriteManager, ItemManager itemManager)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.uiInput = uiInput;
		this.spriteManager = spriteManager;
		this.itemManager = itemManager;

		combinedActionSlot = new UICombinedActionSlot(spriteManager);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addClearListener(this::onSearch);
		searchBar.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				onSearch();
			}
		});

		setLayout(new DynamicGridLayout(0, 1, 0, 5));

		// Register listeners on the input fields and then move on to the next related text field
		uiInput.getUiFieldCurrentLevel().addActionListener(e ->
		{
			onFieldCurrentLevelUpdated();
			uiInput.getUiFieldTargetLevel().requestFocusInWindow();
		});

		uiInput.getUiFieldCurrentXP().addActionListener(e ->
		{
			onFieldCurrentXPUpdated();
			uiInput.getUiFieldTargetXP().requestFocusInWindow();
		});

		uiInput.getUiFieldTargetLevel().addActionListener(e -> onFieldTargetLevelUpdated());
		uiInput.getUiFieldTargetXP().addActionListener(e -> onFieldTargetXPUpdated());
		uiInput.getUiFieldXPMultiplier().addChangeListener(e -> onFieldXPMultiplierUpdated());

		// Register focus listeners to calculate xp when exiting a text field
		uiInput.getUiFieldCurrentLevel().addFocusListener(buildFocusAdapter(e -> onFieldCurrentLevelUpdated()));
		uiInput.getUiFieldCurrentXP().addFocusListener(buildFocusAdapter(e -> onFieldCurrentXPUpdated()));
		uiInput.getUiFieldTargetLevel().addFocusListener(buildFocusAdapter(e -> onFieldTargetLevelUpdated()));
		uiInput.getUiFieldTargetXP().addFocusListener(buildFocusAdapter(e -> onFieldTargetXPUpdated()));
		uiInput.getUiFieldXPMultiplier().addFocusListener(buildFocusAdapter(e -> onFieldXPMultiplierUpdated()));
	}

	void openCalculator(CalculatorType calculatorType, boolean forceReload)
	{
		// Update internal skill/XP values.
		currentXP = client.getSkillExperience(calculatorType.getSkill());
		currentLevel = Experience.getLevelForXp(currentXP);

		if (forceReload || currentCalculator != calculatorType)
		{
			currentCalculator = calculatorType;
			currentBonuses.clear();

			@Varp int endGoalVarp = endGoalVarpForSkill(calculatorType.getSkill());
			int endGoal = client.getVarpValue(endGoalVarp);
			if (endGoal != -1)
			{
				targetLevel = Experience.getLevelForXp(endGoal);
				targetXP = endGoal;
			}
			else
			{
				targetLevel = enforceSkillBounds(currentLevel + 1);
				targetXP = Experience.getXpForLevel(targetLevel);
			}

			// Remove all components (action slots) from this panel.
			removeAll();

			// Clear the search bar
			searchBar.setText(null);

			// Clear the combined action slots
			clearCombinedSlots();

			// Add in checkboxes for available skill bonuses if we're not on a F2P world.
			if (client.getWorldType().contains(WorldType.MEMBERS))
			{
				renderBonusOptions();
			}

			// Add the combined action slot.
			add(combinedActionSlot);

			// Add the search bar
			add(searchBar);

			// Create action slots for the skill actions.
			renderActionSlots();
		}

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
		int xp = 0;

		for (UIActionSlot slot : combinedActionSlots)
		{
			xp += slot.getValue();
		}

		if (neededXP > 0)
		{
			assert xp != 0;
			neededXP *= 10;
			actionCount = (neededXP - 1) / xp + 1;
		}

		combinedActionSlot.setText(formatXPActionString(xp, actionCount, "exp - "));
	}

	private void clearCombinedSlots()
	{
		for (UIActionSlot slot : combinedActionSlots)
		{
			slot.setSelected(false);
		}

		combinedActionSlots.clear();
	}

	private void renderBonusOptions()
	{
		final SkillBonus[] skillBonuses = currentCalculator.getSkillBonuses();
		if (skillBonuses == null)
		{
			return;
		}

		for (SkillBonus bonus : skillBonuses)
		{
			JPanel checkboxPanel = buildCheckboxPanel(bonus);

			add(checkboxPanel);
		}

		if (skillBonuses.length > 0)
		{
			add(Box.createRigidArea(new Dimension(0, 4)));
		}
	}

	private JPanel buildCheckboxPanel(SkillBonus bonus)
	{
		JPanel uiOption = new JPanel(new BorderLayout());
		JLabel uiLabel = new JLabel(generateDisplayNameForBonus(bonus));
		JCheckBox uiCheckbox = new JCheckBox();

		uiLabel.setForeground(Color.WHITE);
		uiLabel.setFont(FontManager.getRunescapeSmallFont());

		uiOption.setBorder(BorderFactory.createEmptyBorder(1, 7, 1, 0));

		// Adjust XP bonus depending on check-state of the boxes.
		uiCheckbox.addActionListener(event -> adjustCheckboxes(uiCheckbox, bonus));

		uiOption.add(uiLabel, BorderLayout.WEST);
		uiOption.add(uiCheckbox, BorderLayout.EAST);
		bonusCheckBoxes.put(bonus, uiCheckbox);

		return uiOption;
	}

	private static String generateDisplayNameForBonus(SkillBonus bonus)
	{
		return bonus.getName() + " (" + formatBonusPercentage(bonus.getValue()) + "%)";
	}

	@VisibleForTesting
	static String formatBonusPercentage(float bonus)
	{
		final int bonusValue = Math.round(10_000 * bonus);
		final float bonusPercent = bonusValue / 100f;
		final int bonusPercentInt = (int) bonusPercent;

		if (bonusPercent == bonusPercentInt)
		{
			return String.valueOf(bonusPercentInt);
		}
		else
		{
			return String.valueOf(bonusPercent);
		}
	}

	private void adjustCheckboxes(JCheckBox target, SkillBonus bonus)
	{
		// Check if target is stackable with any other bonuses
		for (Map.Entry<SkillBonus, JCheckBox> entry : bonusCheckBoxes.entrySet())
		{
			if (entry.getValue() != target && !entry.getKey().getCanBeStackedWith().contains(bonus))
			{
				currentBonuses.remove(entry.getKey());
				entry.getValue().setSelected(false);
			}
		}

		if (target.isSelected())
		{
			currentBonuses.add(bonus);
		}
		else
		{
			currentBonuses.remove(bonus);
		}
		calculate();
	}

	private void renderActionSlots()
	{
		// Wipe the list of references to the slot components.
		uiActionSlots.clear();

		// Create new components for the action slots.
		for (SkillAction action : currentCalculator.getSkillActions())
		{
			JLabel uiIcon = new JLabel();

			if (action.getIcon() != -1)
			{
				itemManager.getImage(action.getIcon()).addTo(uiIcon);
			}
			else if (action.getSprite() != -1)
			{
				spriteManager.addSpriteTo(uiIcon, action.getSprite(), 0);
			}

			UIActionSlot slot = new UIActionSlot(action, clientThread, itemManager, uiIcon);
			uiActionSlots.add(slot); // Keep our own reference.

			slot.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					if (!e.isShiftDown())
					{
						clearCombinedSlots();
					}

					if (slot.isSelected())
					{
						combinedActionSlots.remove(slot);
					}
					else
					{
						combinedActionSlots.add(slot);
					}

					slot.setSelected(!slot.isSelected());
					updateCombinedAction();
				}
			});
		}

		if (client.getWorldType().contains(WorldType.MEMBERS))
		{
			// All actions should be visible, so no need to filter; just refresh the rendering of this panel.
			uiActionSlots.forEach(this::add);
			revalidate();
			repaint();
		}
		else
		{
			// Filter out members actions due to being on F2P, then refresh the rendering
			clientThread.invokeLater(() ->
			{
				List<UIActionSlot> membersActions = uiActionSlots.stream()
					.filter(slot -> !slot.getAction().isMembers(itemManager))
					.collect(Collectors.toList());

				SwingUtilities.invokeLater(() ->
				{
					if (membersActions.isEmpty())
					{
						add(EMPTY_PANEL);
					}
					else
					{
						membersActions.forEach(this::add);
					}
					revalidate();
					repaint();
				});
			});
		}
	}

	private void calculate()
	{
		for (UIActionSlot slot : uiActionSlots)
		{
			int actionCount = 0;
			int neededXP = targetXP - currentXP;
			SkillAction action = slot.getAction();
			float bonus = 1f;
			for (SkillBonus skillBonus : currentBonuses)
			{
				if (action.isBonusApplicable(skillBonus))
				{
					bonus *= skillBonus.getValue();
				}
			}
			final int xp = (int) Math.floor(action.getXp() * 10f * bonus * xpMultiplier);

			if (neededXP > 0)
			{
				neededXP *= 10;
				actionCount = (neededXP - 1) / xp + 1;
			}

			slot.setText("Lvl. " + action.getLevel() + " (" + formatXPActionString(xp, actionCount, "exp) - "));
			slot.setAvailable(currentLevel >= action.getLevel());
			slot.setOverlapping(action.getLevel() < targetLevel);
			slot.setValue(xp);
		}

		updateCombinedAction();
	}

	private static String formatXPActionString(int xp, int actionCount, String expExpression)
	{
		int integer = xp / 10;
		int frac = xp % 10;
		return (frac != 0 ? (integer + "." + frac) : integer) + expExpression + NumberFormat.getIntegerInstance().format(actionCount) + (actionCount == 1 ? " action" : " actions");
	}

	private void updateInputFields()
	{
		if (targetXP < currentXP)
		{
			targetLevel = enforceSkillBounds(currentLevel + 1);
			targetXP = Experience.getXpForLevel(targetLevel);
		}

		final String cXP = String.format("%,d", currentXP);
		final String tXP = String.format("%,d", targetXP);
		final String nXP = String.format("%,d", targetXP - currentXP);
		uiInput.setCurrentLevelInput(currentLevel);
		uiInput.setCurrentXPInput(cXP);
		uiInput.setTargetLevelInput(targetLevel);
		uiInput.setTargetXPInput(tXP);
		uiInput.setNeededXP(nXP + " XP required to reach target XP");
		uiInput.setXPMultiplier(xpMultiplier);
		calculate();
	}

	private void onFieldCurrentLevelUpdated()
	{
		currentLevel = enforceSkillBounds(uiInput.getCurrentLevelInput());
		currentXP = Experience.getXpForLevel(currentLevel);
		updateInputFields();
	}

	private void onFieldXPMultiplierUpdated()
	{
		xpMultiplier = enforceMultiplierBounds(uiInput.getXPMultiplierInput());
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
		return Math.min(Experience.MAX_SKILL_XP, Math.max(0, input));
	}

	private static int enforceMultiplierBounds(int input)
	{
		return Math.min(MAX_XP_MULTIPLIER, Math.max(1, input));
	}

	private void onSearch()
	{
		//only show slots that match our search text
		uiActionSlots.forEach(slot ->
		{
			if (slotContainsText(slot, searchBar.getText()))
			{
				super.add(slot);
			}
			else
			{
				super.remove(slot);
			}

			revalidate();
		});
	}

	private static boolean slotContainsText(UIActionSlot slot, String text)
	{
		return slot.getActionName().toLowerCase().contains(text.toLowerCase());
	}

	private static FocusAdapter buildFocusAdapter(Consumer<FocusEvent> focusLostConsumer)
	{
		return new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				focusLostConsumer.accept(e);
			}
		};
	}

	private static @Varp int endGoalVarpForSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return VarPlayer.ATTACK_GOAL_END;
			case MINING:
				return VarPlayer.MINING_GOAL_END;
			case WOODCUTTING:
				return VarPlayer.WOODCUTTING_GOAL_END;
			case DEFENCE:
				return VarPlayer.DEFENCE_GOAL_END;
			case MAGIC:
				return VarPlayer.MAGIC_GOAL_END;
			case RANGED:
				return VarPlayer.RANGED_GOAL_END;
			case HITPOINTS:
				return VarPlayer.HITPOINTS_GOAL_END;
			case AGILITY:
				return VarPlayer.AGILITY_GOAL_END;
			case STRENGTH:
				return VarPlayer.STRENGTH_GOAL_END;
			case PRAYER:
				return VarPlayer.PRAYER_GOAL_END;
			case SLAYER:
				return VarPlayer.SLAYER_GOAL_END;
			case FISHING:
				return VarPlayer.FISHING_GOAL_END;
			case RUNECRAFT:
				return VarPlayer.RUNECRAFT_GOAL_END;
			case HERBLORE:
				return VarPlayer.HERBLORE_GOAL_END;
			case FIREMAKING:
				return VarPlayer.FIREMAKING_GOAL_END;
			case CONSTRUCTION:
				return VarPlayer.CONSTRUCTION_GOAL_END;
			case HUNTER:
				return VarPlayer.HUNTER_GOAL_END;
			case COOKING:
				return VarPlayer.COOKING_GOAL_END;
			case FARMING:
				return VarPlayer.FARMING_GOAL_END;
			case CRAFTING:
				return VarPlayer.CRAFTING_GOAL_END;
			case SMITHING:
				return VarPlayer.SMITHING_GOAL_END;
			case THIEVING:
				return VarPlayer.THIEVING_GOAL_END;
			case FLETCHING:
				return VarPlayer.FLETCHING_GOAL_END;
			default:
				throw new IllegalArgumentException();
		}
	}
}
