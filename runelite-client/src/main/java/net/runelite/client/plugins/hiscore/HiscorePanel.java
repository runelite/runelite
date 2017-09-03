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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import net.runelite.api.Experience;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.IconTextField;
import net.runelite.client.ui.PluginPanel;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import static net.runelite.http.api.hiscore.HiscoreSkill.*;
import net.runelite.http.api.hiscore.Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiscorePanel extends PluginPanel
{
	private static final Logger logger = LoggerFactory.getLogger(HiscorePanel.class);

	private static final String SKILL_NAME = "SKILL_NAME";
	private static final String SKILL = "SKILL";

	private static final HiscoreSkill[] SKILL_PANEL_ORDER = new HiscoreSkill[]
	{
		ATTACK, HITPOINTS, MINING,
		STRENGTH, AGILITY, SMITHING,
		DEFENCE, HERBLORE, FISHING,
		RANGED, THIEVING, COOKING,
		PRAYER, CRAFTING, FIREMAKING,
		MAGIC, FLETCHING, WOODCUTTING,
		RUNECRAFT, SLAYER, FARMING,
		CONSTRUCTION, HUNTER
	};

	private final RuneLite runelite;

	private final IconTextField input;

	private final List<JLabel> skillLabels = new ArrayList<>();

	private final JPanel statsPanel = new JPanel();
	private final JTextArea details = new JTextArea();

	private final HiscoreClient client = new HiscoreClient();
	private HiscoreResult result;

	public HiscorePanel(RuneLite runelite)
	{
		this.runelite = runelite;

		// Panel "constants"
		// This was an EtchedBorder, but the style would change when the window was maximized.
		Border subPanelBorder = BorderFactory.createLineBorder(this.getBackground().brighter(), 2);
		Insets subPanelInsets = new Insets(2, 4, 2, 4);
		Font labelFont = UIManager.getFont("Label.font");

		// Setting base panel size
		Dimension panelSize = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
		setMinimumSize(panelSize);
		setPreferredSize(panelSize);
		setSize(panelSize);
		setVisible(true);

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

		Icon search = null;
		try
		{
			search = new ImageIcon(ImageIO.read(HiscorePanel.class.getResourceAsStream("search.png")));
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		input = new IconTextField();
		input.setIcon(search);
		input.addActionListener(e ->
		{
			ScheduledExecutorService executor = runelite.getExecutor();
			executor.execute(this::lookup);
		});
		inputPanel.add(input, BorderLayout.CENTER);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.insets = subPanelInsets;
		gridBag.setConstraints(inputPanel, c);
		add(inputPanel);

		// Panel that holds skill icons
		GridLayout stats = new GridLayout(8, 3);
		statsPanel.setLayout(stats);
		statsPanel.setBorder(subPanelBorder);

		// For each skill on the ingame skill panel, create a Label and add it to the UI
		for (HiscoreSkill skill : SKILL_PANEL_ORDER)
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
		minigamePanel.setLayout(new GridLayout(1, 4));

		minigamePanel.add(makeSkillPanel(CLUE_SCROLL_ALL.getName(), CLUE_SCROLL_ALL));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_ROGUE.getName(), BOUNTY_HUNTER_ROGUE));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_HUNTER.getName(), BOUNTY_HUNTER_HUNTER));
		minigamePanel.add(makeSkillPanel(LAST_MAN_STANDING.getName(), LAST_MAN_STANDING));

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
		details.setFont(labelFont);
		details.setWrapStyleWord(true);
		details.setLineWrap(true);
		details.setMargin(new Insets(2, 4, 4, 4));
		details.setRows(4);
		details.setText("");

		detailsPanel.add(details, BorderLayout.CENTER);

		c.gridx = 0;
		c.gridy = 4;
		// Last item has a nonzero weighty so it will expand to fill vertical space
		c.weighty = 1;
		gridBag.setConstraints(detailsPanel, c);
		add(detailsPanel);
	}

	private void changeDetail(String skillName, HiscoreSkill skill)
	{
		if (result == null)
		{
			return;
		}

		NumberFormat formatter = NumberFormat.getInstance();

		String text;
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
					+ "Exact Combat Level: " + formatter.format(combatLevel) + System.lineSeparator()
					+ "Experience: " + formatter.format(result.getAttack().getExperience()
					+ result.getStrength().getExperience() + result.getDefence().getExperience()
					+ result.getHitpoints().getExperience() + result.getMagic().getExperience()
					+ result.getRanged().getExperience() + result.getPrayer().getExperience());
				break;
			}
			case "Clue Scrolls (all)":
			{
				text = "Total Clue Scrolls completed: " + formatter.format(result.getClueScrollAll().getLevel()) + System.lineSeparator()
					+ "Rank: " + formatter.format(result.getClueScrollAll().getRank());
				break;
			}
			case "Bounty Hunter - Rogue":
			{
				text = "Bounty Hunter - Rogue Kills" + System.lineSeparator()
					+ "Rank: " + formatter.format(result.getBountyHunterRogue().getRank());
				break;
			}
			case "Bounty Hunter - Hunter":
			{
				text = "Bounty Hunter - Hunter Kills" + System.lineSeparator()
						+ "Rank: " + formatter.format(result.getBountyHunterHunter().getRank());
				break;
			}
			case "Last Man Standing":
			{
				text = "Last Man Standing" + System.lineSeparator()
						+ "Rank: " + formatter.format(result.getLastManStanding().getRank());
				break;
			}
			default:
			{
				Skill requestedSkill = result.getSkill(skill);
				text = "Skill: " + skillName + System.lineSeparator()
					+ "Rank: " + formatter.format(requestedSkill.getRank()) + System.lineSeparator()
					+ "Experience: " + formatter.format(requestedSkill.getExperience());
				break;
			}
		}

		details.setFont(UIManager.getFont("Label.font"));
		details.setText(text);
	}

	private JPanel makeSkillPanel(String skillName, HiscoreSkill skill)
	{
		JLabel label = new JLabel();
		label.setText("--");

		// Store the skill that the label displays so we can tell them apart
		label.putClientProperty(SKILL_NAME, skillName);
		label.putClientProperty(SKILL, skill);

		String skillIcon = "/skill_icons/" + skillName.toLowerCase() + ".png";
		logger.debug("Loading skill icon from {}", skillIcon);

		try
		{
			label.setIcon(new ImageIcon(ImageIO.read(HiscorePanel.class.getResourceAsStream(skillIcon))));
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		// Show skill details on click
		label.addMouseListener(new MouseInputAdapter()
		{
			// mouseReleased feels better than mouseClick UX-wise
			@Override
			public void mouseReleased(MouseEvent e)
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

		lookup = sanitize(lookup);

		if (Strings.isNullOrEmpty(lookup))
		{
			return;
		}

		try
		{
			result = client.lookup(lookup);
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return;
		}

		// Clear details panel
		details.setFont(UIManager.getFont("Label.font").deriveFont(Font.ITALIC));
		details.setText("Click a skill for details");

		for (JLabel label : skillLabels)
		{
			String skillName = (String) label.getClientProperty(SKILL_NAME);
			HiscoreSkill skill = (HiscoreSkill) label.getClientProperty(SKILL);

			if (skillName.equals("Combat"))
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
			else if (skill != null)
			{
				label.setText(Integer.toString(result.getSkill(skill).getLevel()));
			}
		}
	}

	private static String sanitize(String lookup)
	{
		return lookup.replace('\u00A0', ' ');
	}
}
