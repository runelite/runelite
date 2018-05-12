/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.hiscore;

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import static net.runelite.http.api.hiscore.HiscoreSkill.AGILITY;
import static net.runelite.http.api.hiscore.HiscoreSkill.ATTACK;
import static net.runelite.http.api.hiscore.HiscoreSkill.BOUNTY_HUNTER_HUNTER;
import static net.runelite.http.api.hiscore.HiscoreSkill.BOUNTY_HUNTER_ROGUE;
import static net.runelite.http.api.hiscore.HiscoreSkill.CLUE_SCROLL_ALL;
import static net.runelite.http.api.hiscore.HiscoreSkill.CONSTRUCTION;
import static net.runelite.http.api.hiscore.HiscoreSkill.COOKING;
import static net.runelite.http.api.hiscore.HiscoreSkill.CRAFTING;
import static net.runelite.http.api.hiscore.HiscoreSkill.DEFENCE;
import static net.runelite.http.api.hiscore.HiscoreSkill.FARMING;
import static net.runelite.http.api.hiscore.HiscoreSkill.FIREMAKING;
import static net.runelite.http.api.hiscore.HiscoreSkill.FISHING;
import static net.runelite.http.api.hiscore.HiscoreSkill.FLETCHING;
import static net.runelite.http.api.hiscore.HiscoreSkill.HERBLORE;
import static net.runelite.http.api.hiscore.HiscoreSkill.HITPOINTS;
import static net.runelite.http.api.hiscore.HiscoreSkill.HUNTER;
import static net.runelite.http.api.hiscore.HiscoreSkill.LAST_MAN_STANDING;
import static net.runelite.http.api.hiscore.HiscoreSkill.MAGIC;
import static net.runelite.http.api.hiscore.HiscoreSkill.MINING;
import static net.runelite.http.api.hiscore.HiscoreSkill.OVERALL;
import static net.runelite.http.api.hiscore.HiscoreSkill.PRAYER;
import static net.runelite.http.api.hiscore.HiscoreSkill.RANGED;
import static net.runelite.http.api.hiscore.HiscoreSkill.RUNECRAFT;
import static net.runelite.http.api.hiscore.HiscoreSkill.SLAYER;
import static net.runelite.http.api.hiscore.HiscoreSkill.SMITHING;
import static net.runelite.http.api.hiscore.HiscoreSkill.STRENGTH;
import static net.runelite.http.api.hiscore.HiscoreSkill.THIEVING;
import static net.runelite.http.api.hiscore.HiscoreSkill.WOODCUTTING;
import net.runelite.http.api.hiscore.Skill;

@Slf4j
public class HiscorePanel extends PluginPanel
{
	private static final String SKILL_NAME = "SKILL_NAME";
	private static final String SKILL = "SKILL";

	/**
	 * Real skills, ordered in the way they should be displayed in the panel.
	 */
	private static final Set<HiscoreSkill> SKILLS = new LinkedHashSet<>(Arrays.asList(
		ATTACK, HITPOINTS, MINING,
		STRENGTH, AGILITY, SMITHING,
		DEFENCE, HERBLORE, FISHING,
		RANGED, THIEVING, COOKING,
		PRAYER, CRAFTING, FIREMAKING,
		MAGIC, FLETCHING, WOODCUTTING,
		RUNECRAFT, SLAYER, FARMING,
		CONSTRUCTION, HUNTER
	));

	@Inject
	ScheduledExecutorService executor;

	@Inject
	@Nullable
	private Client client;

	private final HiscoreConfig config;
	private final IconTextField input;

	private final List<JLabel> skillLabels = new ArrayList<>();

	private final JPanel statsPanel = new JPanel();
	private final ButtonGroup endpointButtonGroup = new ButtonGroup();
	private final JTextArea details = new JTextArea();
	private final JProgressBar progressBar;

	private List<JToggleButton> endpointButtons;

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private HiscoreResult result;

	@Inject
	public HiscorePanel(HiscoreConfig config)
	{
		super();
		this.config = config;

		// Panel "constants"
		// This was an EtchedBorder, but the style would change when the window was maximized.
		Border subPanelBorder = BorderFactory.createLineBorder(this.getBackground().brighter(), 2);

		// Create GBL to arrange sub items
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		// Expand sub items to fit width of panel, align to top of panel
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;

		// Search box
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout(7, 7));
		inputPanel.setBorder(subPanelBorder);

		Icon search;
		try
		{
			BufferedImage icon;
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(HiscorePanel.class.getResourceAsStream("search.png"));
			}
			search = new ImageIcon(icon);
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}

		input = new IconTextField();
		input.setIcon(search);
		input.addActionListener(e -> executor.execute(this::lookup));
		input.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() != 2)
				{
					return;
				}

				if (client == null)
				{
					return;
				}

				Player localPlayer = client.getLocalPlayer();

				if (localPlayer != null)
				{
					executor.execute(() -> lookup(localPlayer.getName()));
				}
			}
		});
		inputPanel.add(input, BorderLayout.CENTER);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.insets = new Insets(0, 0, 3, 0);
		gridBag.setConstraints(inputPanel, c);
		add(inputPanel);

		// Panel that holds skill icons
		GridLayout stats = new GridLayout(8, 3);
		statsPanel.setLayout(stats);
		statsPanel.setBorder(subPanelBorder);

		// For each skill on the ingame skill panel, create a Label and add it to the UI
		for (HiscoreSkill skill : SKILLS)
		{
			JPanel panel = makeSkillPanel(skill.getName(), skill);
			statsPanel.add(panel);
		}

		c.gridx = 0;
		c.gridy = 1;
		gridBag.setConstraints(statsPanel, c);
		add(statsPanel);

		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(subPanelBorder);
		totalPanel.setLayout(new GridLayout(1, 2));

		totalPanel.add(makeSkillPanel(OVERALL.getName(), OVERALL));
		totalPanel.add(makeSkillPanel("Combat", null));

		c.gridx = 0;
		c.gridy = 2;
		gridBag.setConstraints(totalPanel, c);
		add(totalPanel);

		JPanel minigamePanel = new JPanel();
		minigamePanel.setBorder(subPanelBorder);
		// These aren't all on one row because when there's a label with four or more digits it causes the details
		// panel to change its size for some reason...
		minigamePanel.setLayout(new GridLayout(2, 3));

		minigamePanel.add(makeSkillPanel(CLUE_SCROLL_ALL.getName(), CLUE_SCROLL_ALL));
		minigamePanel.add(makeSkillPanel(LAST_MAN_STANDING.getName(), LAST_MAN_STANDING));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_ROGUE.getName(), BOUNTY_HUNTER_ROGUE));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_HUNTER.getName(), BOUNTY_HUNTER_HUNTER));

		c.gridx = 0;
		c.gridy = 3;
		gridBag.setConstraints(minigamePanel, c);
		add(minigamePanel);

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(subPanelBorder);
		detailsPanel.setLayout(new BorderLayout());

		// Rather than using one JLabel for each line, make a JTextArea look and act like a JLabel
		details.setEditable(false);
		details.setCursor(null);
		details.setOpaque(false);
		details.setFocusable(false);
		details.setWrapStyleWord(true);
		details.setLineWrap(true);
		details.setMargin(new Insets(2, 4, 4, 4));
		details.setRows(6);
		details.setText("");

		detailsPanel.add(details, BorderLayout.CENTER);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(Color.RED);
		progressBar.setVisible(false);

		detailsPanel.add(progressBar, BorderLayout.SOUTH);

		c.gridx = 0;
		c.gridy = 4;
		gridBag.setConstraints(detailsPanel, c);
		add(detailsPanel);

		JPanel endpointPanel = new JPanel();
		endpointPanel.setBorder(subPanelBorder);

		endpointButtons = new ArrayList<>();
		for (HiscoreEndpoint endpoint : HiscoreEndpoint.values())
		{
			try
			{
				BufferedImage iconImage;
				synchronized (ImageIO.class)
				{
					iconImage = ImageIO.read(HiscorePanel.class.getResourceAsStream(
						endpoint.name().toLowerCase() + ".png"));
				}
				JToggleButton button = new JToggleButton();
				button.setIcon(new ImageIcon(iconImage));
				button.setPreferredSize(new Dimension(24, 24));
				button.setBackground(Color.WHITE);
				button.setFocusPainted(false);
				button.setActionCommand(endpoint.name());
				button.setToolTipText(endpoint.getName() + " Hiscores");
				button.addActionListener((e -> executor.execute(this::lookup)));
				button.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseReleased(MouseEvent e)
					{
						updateButtons();
					}
				});
				endpointButtons.add(button);
				endpointButtonGroup.add(button);
				endpointPanel.add(button);
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		}

		endpointButtons.get(0).setSelected(true);
		endpointButtons.get(0).setBackground(Color.CYAN);

		c.gridx = 0;
		c.gridy = 5;
		// Last item has a nonzero weighty so it will expand to fill vertical space
		c.weighty = 1;
		gridBag.setConstraints(endpointPanel, c);
		add(endpointPanel);
	}

	void addInputKeyListener(KeyListener l)
	{
		this.input.addKeyListener(l);
	}

	void removeInputKeyListener(KeyListener l)
	{
		this.input.removeKeyListener(l);
	}

	private void changeDetail(String skillName, HiscoreSkill skill)
	{
		if (result == null || result.getPlayer() == null)
		{
			return;
		}

		String text;
		int progress = -1;
		switch (skillName)
		{
			case "Combat":
			{
				double combatLevel = Experience.getCombatLevelPrecise(
					result.getAttack().getLevel(),
					result.getStrength().getLevel(),
					result.getDefence().getLevel(),
					result.getHitpoints().getLevel(),
					result.getMagic().getLevel(),
					result.getRanged().getLevel(),
					result.getPrayer().getLevel()
				);
				text = "Skill: Combat" + System.lineSeparator()
					+ "Exact Combat Level: " + StackFormatter.formatNumber(combatLevel) + System.lineSeparator()
					+ "Experience: " + StackFormatter.formatNumber(result.getAttack().getExperience()
					+ result.getStrength().getExperience() + result.getDefence().getExperience()
					+ result.getHitpoints().getExperience() + result.getMagic().getExperience()
					+ result.getRanged().getExperience() + result.getPrayer().getExperience());
				break;
			}
			case "Clue Scrolls (all)":
			{
				String allRank = (result.getClueScrollAll().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollAll().getRank());
				String easyRank = (result.getClueScrollEasy().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollEasy().getRank());
				String mediumRank = (result.getClueScrollMedium().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollMedium().getRank());
				String hardRank = (result.getClueScrollHard().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollHard().getRank());
				String eliteRank = (result.getClueScrollElite().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollElite().getRank());
				String masterRank = (result.getClueScrollMaster().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollMaster().getRank());
				String all = (result.getClueScrollAll().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollAll().getLevel()));
				String easy = (result.getClueScrollEasy().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollEasy().getLevel()));
				String medium = (result.getClueScrollMedium().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollMedium().getLevel()));
				String hard = (result.getClueScrollHard().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollHard().getLevel()));
				String elite = (result.getClueScrollElite().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollElite().getLevel()));
				String master = (result.getClueScrollMaster().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollMaster().getLevel()));
				text = "All clues: " + all + " | Rank: " + allRank + System.lineSeparator()
					+ "Easy: " + easy + " | Rank: " + easyRank + System.lineSeparator()
					+ "Medium: " + medium + " | Rank: " + mediumRank + System.lineSeparator()
					+ "Hard: " + hard + " | Rank: " + hardRank + System.lineSeparator()
					+ "Elite: " + elite + " | Rank: " + eliteRank + System.lineSeparator()
					+ "Master: " + master + " | Rank: " + masterRank;
				break;
			}
			case "Bounty Hunter - Rogue":
			{
				String rank = (result.getBountyHunterRogue().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getBountyHunterRogue().getRank());
				text = "Bounty Hunter - Rogue Kills" + System.lineSeparator()
					+ "Rank: " + rank;
				break;
			}
			case "Bounty Hunter - Hunter":
			{
				String rank = (result.getBountyHunterHunter().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getBountyHunterHunter().getRank());
				text = "Bounty Hunter - Hunter Kills" + System.lineSeparator()
						+ "Rank: " + rank;
				break;
			}
			case "Last Man Standing":
			{
				String rank = (result.getLastManStanding().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getLastManStanding().getRank());
				text = "Last Man Standing" + System.lineSeparator()
						+ "Rank: " + rank;
				break;
			}
			case "Overall":
			{
				Skill requestedSkill = result.getSkill(skill);
				String rank = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getRank());
				String exp = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getExperience());
				text = "Skill: " + skillName + System.lineSeparator()
					+ "Rank: " + rank + System.lineSeparator()
					+ "Experience: " + exp;
				break;
			}
			default:
			{
				Skill requestedSkill = result.getSkill(skill);
				String rank = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getRank());
				String exp = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getExperience());
				String remainingXp;
				if (requestedSkill.getRank() == -1)
				{
					remainingXp = "Unranked";
				}
				else
				{
					int currentLevel = Experience.getLevelForXp((int) requestedSkill.getExperience());
					int currentXp = (int) requestedSkill.getExperience();
					int xpForCurrentLevel = Experience.getXpForLevel(currentLevel);
					int xpForNextLevel = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

					remainingXp = xpForNextLevel != -1 ? StackFormatter.formatNumber(xpForNextLevel - currentXp) : "0";

					double xpGained = currentXp - xpForCurrentLevel;
					double xpGoal = xpForNextLevel != -1 ? xpForNextLevel - xpForCurrentLevel : 100;
					progress = (int) ((xpGained / xpGoal) * 100f);

				}
				text = "Skill: " + skillName + System.lineSeparator()
					+ "Rank: " + rank + System.lineSeparator()
					+ "Experience: " + exp + System.lineSeparator()
					+ "Remaining XP: " + remainingXp;
				break;
			}
		}

		details.setFont(UIManager.getFont("Label.font"));
		details.setText(text);

		if (progress >= 0)
		{
			progressBar.setVisible(true);
			progressBar.setValue(progress);
			progressBar.setBackground(Color.getHSBColor((progress / 100.f) * (120.f / 360.f), 1, 1));
		}
		else
		{
			progressBar.setVisible(false);
		}

	}

	@Override
	public void onActivate()
	{
		super.onActivate();
		input.requestFocusInWindow();
	}

	private JPanel makeSkillPanel(String skillName, HiscoreSkill skill)
	{
		JLabel label = new JLabel();
		label.setText("--");

		// Store the skill that the label displays so we can tell them apart
		label.putClientProperty(SKILL_NAME, skillName);
		label.putClientProperty(SKILL, skill);

		String skillIcon = "skill_icons_small/" + skillName.toLowerCase() + ".png";
		log.debug("Loading skill icon from {}", skillIcon);

		try
		{
			BufferedImage icon;
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(HiscorePanel.class.getResourceAsStream(skillIcon));
			}
			label.setIcon(new ImageIcon(icon));
		}
		catch (IOException ex)
		{
			log.warn(null, ex);
		}

		// Show skill details on hover
		label.addMouseListener(new MouseInputAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				JLabel source = (JLabel) e.getSource();
				String skillName = (String) source.getClientProperty(SKILL_NAME);
				HiscoreSkill skill = (HiscoreSkill) label.getClientProperty(SKILL);
				changeDetail(skillName, skill);
			}
		});
		skillLabels.add(label);

		JPanel skillPanel = new JPanel();
		skillPanel.add(skillLabels.get(skillLabels.size() - 1));
		return skillPanel;
	}

	public void lookup(String username)
	{
		input.setText(username);
		lookup();
	}

	private void lookup()
	{
		String lookup = input.getText();
		details.setText("Loading...");
		progressBar.setVisible(false);

		lookup = sanitize(lookup);

		if (Strings.isNullOrEmpty(lookup))
		{
			return;
		}

		for (JLabel label : skillLabels)
		{
			label.setText("--");
		}

		try
		{
			HiscoreEndpoint endpoint = HiscoreEndpoint.valueOf(endpointButtonGroup.getSelection().getActionCommand());
			log.debug("Hiscore endpoint " + endpoint.name() + " selected");

			result = hiscoreClient.lookup(lookup, endpoint);
		}
		catch (IOException ex)
		{
			log.warn("Error fetching Hiscore data " + ex.getMessage());
			details.setText("Error fetching Hiscore data");
			progressBar.setVisible(false);
			return;
		}

		for (JLabel label : skillLabels)
		{
			String skillName = (String) label.getClientProperty(SKILL_NAME);
			HiscoreSkill skill = (HiscoreSkill) label.getClientProperty(SKILL);

			if (skillName.equals("Combat"))
			{
				if (result.getPlayer() != null)
				{
					int combatLevel = Experience.getCombatLevel(
							result.getAttack().getLevel(),
							result.getStrength().getLevel(),
							result.getDefence().getLevel(),
							result.getHitpoints().getLevel(),
							result.getMagic().getLevel(),
							result.getRanged().getLevel(),
							result.getPrayer().getLevel()
					);
					label.setText(Integer.toString(combatLevel));
				}
			}
			else if (result.getSkill(skill) != null && result.getSkill(skill).getRank() != -1)
			{
				Skill s = result.getSkill(skill);

				int level;
				if (config.virtualLevels() && SKILLS.contains(skill))
				{
					level = Experience.getLevelForXp((int) s.getExperience());
				}
				else
				{
					level = s.getLevel();
				}

				label.setText(Integer.toString(level));
			}
		}

		// Clear details panel
		details.setFont(UIManager.getFont("Label.font").deriveFont(Font.ITALIC));
		details.setText("Hover over a skill for details");
		progressBar.setVisible(false);
	}

	private static String sanitize(String lookup)
	{
		return lookup.replace('\u00A0', ' ');
	}

	private void updateButtons()
	{
		for (JToggleButton button : endpointButtons)
		{
			Color color;
			if (button.isSelected())
			{
				color = Color.CYAN;
			}
			else
			{
				color = Color.WHITE;
			}
			button.setBackground(color);
		}
	}
}
