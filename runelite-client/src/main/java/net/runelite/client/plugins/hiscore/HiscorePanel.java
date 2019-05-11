/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
<<<<<<< HEAD
=======
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
>>>>>>> upstream/master
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
<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
=======
import com.google.common.collect.ImmutableList;
import java.awt.Dimension;
>>>>>>> upstream/master
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
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
=======
=======
import java.util.EnumSet;
>>>>>>> upstream/master
import java.util.List;
>>>>>>> upstream/master
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
<<<<<<< HEAD
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
=======
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD
import javax.swing.border.MatteBorder;
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
<<<<<<< HEAD
<<<<<<< HEAD
import net.runelite.client.ui.PluginPanel;
=======
=======
import net.runelite.api.WorldType;
>>>>>>> upstream/master
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
<<<<<<< HEAD
import net.runelite.client.util.RunnableExceptionLogger;
>>>>>>> upstream/master
=======
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.util.ImageUtil;
>>>>>>> upstream/master
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
<<<<<<< HEAD
	private static final String SKILL_NAME = "SKILL_NAME";
	private static final String SKILL = "SKILL";
=======
	/* The maximum allowed username length in runescape accounts */
	private static final int MAX_USERNAME_LENGTH = 12;

<<<<<<< HEAD
	private static final ImageIcon SEARCH_ICON;
	private static final ImageIcon LOADING_ICON;
	private static final ImageIcon ERROR_ICON;
>>>>>>> upstream/master

=======
>>>>>>> upstream/master
	/**
	 * Real skills, ordered in the way they should be displayed in the panel.
	 */
<<<<<<< HEAD
	private static final Set<HiscoreSkill> SKILLS = new LinkedHashSet<>(Arrays.asList(
=======
	private static final List<HiscoreSkill> SKILLS = ImmutableList.of(
>>>>>>> upstream/master
		ATTACK, HITPOINTS, MINING,
		STRENGTH, AGILITY, SMITHING,
		DEFENCE, HERBLORE, FISHING,
		RANGED, THIEVING, COOKING,
		PRAYER, CRAFTING, FIREMAKING,
		MAGIC, FLETCHING, WOODCUTTING,
		RUNECRAFT, SLAYER, FARMING,
		CONSTRUCTION, HUNTER
<<<<<<< HEAD
	));
=======
	);
>>>>>>> upstream/master

	@Inject
	ScheduledExecutorService executor;

	@Inject
	@Nullable
	private Client client;

	private final HiscoreConfig config;

	private final IconTextField searchBar;

	private final List<JLabel> skillLabels = new ArrayList<>();

	private final JPanel statsPanel = new JPanel();
<<<<<<< HEAD
	private final ButtonGroup endpointButtonGroup = new ButtonGroup();
	private final JTextArea details = new JTextArea();
	private final JProgressBar progressBar;

	private List<JToggleButton> endpointButtons;

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private HiscoreResult result;

=======

	/* Container of all the selectable endpoints (ironman, deadman, etc) */
	private final MaterialTabGroup tabGroup;

	private final HiscoreClient hiscoreClient = new HiscoreClient();

	private HiscoreResult result;

	/* The currently selected endpoint */
	private HiscoreEndpoint selectedEndPoint;

	/* Used to prevent users from switching endpoint tabs while the results are loading */
	private boolean loading = false;

<<<<<<< HEAD
	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
				LOADING_ICON = new ImageIcon(IconTextField.class.getResource("loading_spinner_darker.gif"));
				ERROR_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("error.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

>>>>>>> upstream/master
=======
>>>>>>> upstream/master
	@Inject
	public HiscorePanel(HiscoreConfig config)
	{
		super();
		this.config = config;

<<<<<<< HEAD
<<<<<<< HEAD
		// Panel "constants"
		// This was an EtchedBorder, but the style would change when the window was maximized.
		Border subPanelBorder = BorderFactory.createLineBorder(this.getBackground().brighter(), 2);
=======
		setBorder(new EmptyBorder(10, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
>>>>>>> upstream/master

		// Create GBL to arrange sub items
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);
=======
		// The layout seems to be ignoring the top margin and only gives it
		// a 2-3 pixel margin, so I set the value to 18 to compensate
		// TODO: Figure out why this layout is ignoring most of the top margin
		setBorder(new EmptyBorder(18, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new GridBagLayout());
>>>>>>> upstream/master

		// Expand sub items to fit width of panel, align to top of panel
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
<<<<<<< HEAD
		c.anchor = GridBagConstraints.NORTH;

<<<<<<< HEAD
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
=======
		input = new IconTextField();
		input.setPreferredSize(new Dimension(100, 30));
		input.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		input.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		input.setIcon(SEARCH_ICON);
		input.addActionListener(e -> executor.execute(RunnableExceptionLogger.wrap(this::lookup)));
>>>>>>> upstream/master
		input.addMouseListener(new MouseAdapter()
=======
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.insets = new Insets(0, 0, 10, 0);

		searchBar = new IconTextField();
		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.setMinimumSize(new Dimension(0, 30));
		searchBar.addActionListener(e -> executor.execute(this::lookup));
		searchBar.addMouseListener(new MouseAdapter()
>>>>>>> upstream/master
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() != 2)
				{
					return;
				}
<<<<<<< HEAD

=======
>>>>>>> upstream/master
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
<<<<<<< HEAD
		inputPanel.add(input, BorderLayout.CENTER);
=======
>>>>>>> upstream/master

<<<<<<< HEAD
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
<<<<<<< HEAD
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
=======
		c.insets = new Insets(0, 0, 10, 0);
		gridBag.setConstraints(input, c);
		add(input);
=======
		add(searchBar, c);
		c.gridy++;
>>>>>>> upstream/master

		tabGroup = new MaterialTabGroup();
		tabGroup.setLayout(new GridLayout(1, 5, 7, 7));

>>>>>>> upstream/master
		for (HiscoreEndpoint endpoint : HiscoreEndpoint.values())
		{
			final BufferedImage iconImage = ImageUtil.getResourceStreamFromClass(getClass(), endpoint.name().toLowerCase() + ".png");

			MaterialTab tab = new MaterialTab(new ImageIcon(iconImage), tabGroup, null);
			tab.setToolTipText(endpoint.getName() + " Hiscores");
			tab.setOnSelectEvent(() ->
			{
				if (loading)
				{
					return false;
				}
<<<<<<< HEAD
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
=======

				selectedEndPoint = endpoint;
				return true;
			});

			// Adding the lookup method to a mouseListener instead of the above onSelectedEvent
			// Because sometimes you might want to switch the tab, without calling for lookup
			// Ex: selecting the normal hiscores as default
			tab.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent mouseEvent)
				{
					if (loading)
					{
						return;
					}

					executor.execute(HiscorePanel.this::lookup);
				}
			});

<<<<<<< HEAD
				endPoints.add(panel);
				endpointPanel.add(panel);
>>>>>>> upstream/master
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		}

<<<<<<< HEAD
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

=======
		/* Default endpoint is the general (normal) endpoint */
		selectedEndPoint = HiscoreEndpoint.NORMAL;
		updateButtons();
=======
			tabGroup.addTab(tab);
		}

		// Default selected tab is normal hiscores
		resetEndpoints();
>>>>>>> upstream/master

		add(tabGroup, c);
		c.gridy++;

		// Panel that holds skill icons
		GridLayout stats = new GridLayout(8, 3);
		statsPanel.setLayout(stats);
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(5, 0, 5, 0));

		// For each skill on the ingame skill panel, create a Label and add it to the UI
		for (HiscoreSkill skill : SKILLS)
		{
			JPanel panel = makeSkillPanel(skill);
			statsPanel.add(panel);
		}

		add(statsPanel, c);
		c.gridy++;

		JPanel totalPanel = new JPanel();
		totalPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		totalPanel.setLayout(new GridLayout(1, 2));

		totalPanel.add(makeSkillPanel(null)); //combat has no hiscore skill, refered to as null
		totalPanel.add(makeSkillPanel(OVERALL));

		add(totalPanel, c);
		c.gridy++;

		JPanel minigamePanel = new JPanel();
		// These aren't all on one row because when there's a label with four or more digits it causes the details
		// panel to change its size for some reason...
		minigamePanel.setLayout(new GridLayout(2, 3));
		minigamePanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		minigamePanel.add(makeSkillPanel(CLUE_SCROLL_ALL));
		minigamePanel.add(makeSkillPanel(LAST_MAN_STANDING));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_ROGUE));
		minigamePanel.add(makeSkillPanel(BOUNTY_HUNTER_HUNTER));

<<<<<<< HEAD
		c.gridx = 0;
		c.gridy = 4;
		gridBag.setConstraints(minigamePanel, c);
		add(minigamePanel);
>>>>>>> upstream/master
=======
		add(minigamePanel, c);
		c.gridy++;
>>>>>>> upstream/master
	}

	@Override
	public void onActivate()
	{
		super.onActivate();
		searchBar.requestFocusInWindow();
	}

<<<<<<< HEAD
	private JPanel makeSkillPanel(String skillName, HiscoreSkill skill)
	{
		JLabel label = new JLabel();
		label.setText("--");

		// Store the skill that the label displays so we can tell them apart
		label.putClientProperty(SKILL_NAME, skillName);
		label.putClientProperty(SKILL, skill);

		String skillIcon = "skill_icons_small/" + skillName.toLowerCase() + ".png";
=======
	/* Builds a JPanel displaying an icon and level/number associated with it */
	private JPanel makeSkillPanel(HiscoreSkill skill)
	{
		JLabel label = new JLabel();
		label.setFont(FontManager.getRunescapeSmallFont());
		label.setText("--");

<<<<<<< HEAD
		String skillIcon = "skill_icons_small/" + (skill == null ? "combat" : skill.getName().toLowerCase()) + ".png";
>>>>>>> upstream/master
		log.debug("Loading skill icon from {}", skillIcon);

		try
=======
		String skillName = (skill == null ? "combat" : skill.getName().toLowerCase());
		String directory = "/skill_icons";
		if (skillName.equals("combat") || skillName.equals("overall"))
>>>>>>> upstream/master
		{
			// Cannot use SpriteManager as HiscorePlugin loads before a Client is available
			directory += "/";
		}
		else
		{
			directory += "_small/";
		}

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
		String skillIcon = directory + skillName + ".png";
		log.debug("Loading skill icon from {}", skillIcon);

		label.setIcon(new ImageIcon(ImageUtil.getResourceStreamFromClass(getClass(), skillIcon)));

>>>>>>> upstream/master
		boolean totalLabel = skill == HiscoreSkill.OVERALL || skill == null; //overall or combat
		label.setIconTextGap(totalLabel ? 10 : 4);

		JPanel skillPanel = new JPanel();
		skillPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		skillPanel.setBorder(new EmptyBorder(2, 0, 2, 0));
		skillLabels.add(label);
		skillPanel.add(skillLabels.get(skillLabels.size() - 1));

>>>>>>> upstream/master
		return skillPanel;
	}

	public void lookup(String username)
	{
<<<<<<< HEAD
		input.setText(username);
<<<<<<< HEAD
=======

		selectedEndPoint = HiscoreEndpoint.NORMAL; //reset the endpoint to regular player
		updateButtons();

>>>>>>> upstream/master
=======
		searchBar.setText(username);
		resetEndpoints();
>>>>>>> upstream/master
		lookup();
	}

	private void lookup()
	{
<<<<<<< HEAD
		String lookup = input.getText();
<<<<<<< HEAD
		details.setText("Loading...");
		progressBar.setVisible(false);
=======
>>>>>>> upstream/master
=======
		String lookup = searchBar.getText();
>>>>>>> upstream/master

		lookup = sanitize(lookup);

		if (Strings.isNullOrEmpty(lookup))
		{
			return;
		}

<<<<<<< HEAD
		for (JLabel label : skillLabels)
		{
			label.setText("--");
		}

		try
		{
			HiscoreEndpoint endpoint = HiscoreEndpoint.valueOf(endpointButtonGroup.getSelection().getActionCommand());
			log.debug("Hiscore endpoint " + endpoint.name() + " selected");

			result = hiscoreClient.lookup(lookup, endpoint);
=======
		/* Runescape usernames can't be longer than 12 characters long */
		if (lookup.length() > MAX_USERNAME_LENGTH)
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			loading = false;
			return;
		}

		searchBar.setEditable(false);
		searchBar.setIcon(IconTextField.Icon.LOADING_DARKER);
		loading = true;

		for (JLabel label : skillLabels)
		{
			label.setText("--");
			label.setToolTipText(null);
		}

		// if for some reason no endpoint was selected, default to normal
		if (selectedEndPoint == null)
		{
			selectedEndPoint = HiscoreEndpoint.NORMAL;
		}

		try
		{
			log.debug("Hiscore endpoint " + selectedEndPoint.name() + " selected");
			result = hiscoreClient.lookup(lookup, selectedEndPoint);
>>>>>>> upstream/master
		}
		catch (IOException ex)
		{
			log.warn("Error fetching Hiscore data " + ex.getMessage());
<<<<<<< HEAD
<<<<<<< HEAD
			details.setText("Error fetching Hiscore data");
			progressBar.setVisible(false);
			return;
		}

		for (JLabel label : skillLabels)
		{
			String skillName = (String) label.getClientProperty(SKILL_NAME);
			HiscoreSkill skill = (HiscoreSkill) label.getClientProperty(SKILL);

			if (skillName.equals("Combat"))
=======
			input.setIcon(ERROR_ICON);
			input.setEditable(true);
=======
			searchBar.setIcon(IconTextField.Icon.ERROR);
			searchBar.setEditable(true);
>>>>>>> upstream/master
			loading = false;
			return;
		}

		if (result == null)
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			searchBar.setEditable(true);
			loading = false;
			return;
		}

		//successful player search
		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setEditable(true);
		loading = false;

		int index = 0;
		for (JLabel label : skillLabels)
		{
			HiscoreSkill skill = find(index);
			Skill s;

			if (skill == null)
>>>>>>> upstream/master
			{
				if (result.getPlayer() != null)
				{
					int combatLevel = Experience.getCombatLevel(
<<<<<<< HEAD
							result.getAttack().getLevel(),
							result.getStrength().getLevel(),
							result.getDefence().getLevel(),
							result.getHitpoints().getLevel(),
							result.getMagic().getLevel(),
							result.getRanged().getLevel(),
							result.getPrayer().getLevel()
=======
						result.getAttack().getLevel(),
						result.getStrength().getLevel(),
						result.getDefence().getLevel(),
						result.getHitpoints().getLevel(),
						result.getMagic().getLevel(),
						result.getRanged().getLevel(),
						result.getPrayer().getLevel()
>>>>>>> upstream/master
					);
					label.setText(Integer.toString(combatLevel));
				}
			}
			else if ((s = result.getSkill(skill)) != null)
			{
<<<<<<< HEAD
				Skill s = result.getSkill(skill);
<<<<<<< HEAD

=======
>>>>>>> upstream/master
				int level;
				if (config.virtualLevels() && SKILLS.contains(skill))
=======
				final long exp = s.getExperience();
				final boolean isSkill = SKILLS.contains(skill);
				int level = -1;
				if (config.virtualLevels() && isSkill && exp > -1L)
>>>>>>> upstream/master
				{
					level = Experience.getLevelForXp((int) exp);
				}
				else if (!isSkill || exp != -1L)
				{
					// for skills, level is only valid if exp is not -1
					// otherwise level is always valid
					level = s.getLevel();
				}

				if (level != -1)
				{
					label.setText(Integer.toString(level));
				}
			}
<<<<<<< HEAD
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
=======

			label.setToolTipText(detailsHtml(result, skill));
			index++;
		}
	}

	void addInputKeyListener(KeyListener l)
	{
		this.searchBar.addKeyListener(l);
	}

	void removeInputKeyListener(KeyListener l)
	{
		this.searchBar.removeKeyListener(l);
	}

	/*
		Returns a hiscore skill based on it's display order.
	 */
	private HiscoreSkill find(int index)
	{
		if (index < SKILLS.size())
		{
			return SKILLS.get(index);
		}

		switch (index - SKILLS.size())
		{
			case 0:
				return null;
			case 1:
				return HiscoreSkill.OVERALL;
			case 2:
				return HiscoreSkill.CLUE_SCROLL_ALL;
			case 3:
				return HiscoreSkill.LAST_MAN_STANDING;
			case 4:
				return HiscoreSkill.BOUNTY_HUNTER_ROGUE;
			case 5:
				return HiscoreSkill.BOUNTY_HUNTER_HUNTER;
		}

		return null;
	}

	/*
		Builds a html string to display on tooltip (when hovering a skill).
	 */
	private String detailsHtml(HiscoreResult result, HiscoreSkill skill)
	{
		String openingTags = "<html><body style = 'padding: 5px;color:#989898'>";
		String closingTags = "</html><body>";

		String content = "";

		if (skill == null)
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

			double combatExperience = result.getAttack().getExperience()
				+ result.getStrength().getExperience() + result.getDefence().getExperience()
				+ result.getHitpoints().getExperience() + result.getMagic().getExperience()
				+ result.getRanged().getExperience() + result.getPrayer().getExperience();

			content += "<p><span style = 'color:white'>Skill:</span> Combat</p>";
			content += "<p><span style = 'color:white'>Exact Combat Level:</span> " + StackFormatter.formatNumber(combatLevel) + "</p>";
			content += "<p><span style = 'color:white'>Experience:</span> " + StackFormatter.formatNumber(combatExperience) + "</p>";
		}
		else
		{
			switch (skill)
			{
				case CLUE_SCROLL_ALL:
				{
					String allRank = (result.getClueScrollAll().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollAll().getRank());
					String beginnerRank = (result.getClueScrollBeginner().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollBeginner().getRank());
					String easyRank = (result.getClueScrollEasy().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollEasy().getRank());
					String mediumRank = (result.getClueScrollMedium().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollMedium().getRank());
					String hardRank = (result.getClueScrollHard().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollHard().getRank());
					String eliteRank = (result.getClueScrollElite().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollElite().getRank());
					String masterRank = (result.getClueScrollMaster().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getClueScrollMaster().getRank());
					String all = (result.getClueScrollAll().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollAll().getLevel()));
					String beginner = (result.getClueScrollBeginner().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollBeginner().getLevel()));
					String easy = (result.getClueScrollEasy().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollEasy().getLevel()));
					String medium = (result.getClueScrollMedium().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollMedium().getLevel()));
					String hard = (result.getClueScrollHard().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollHard().getLevel()));
					String elite = (result.getClueScrollElite().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollElite().getLevel()));
					String master = (result.getClueScrollMaster().getLevel() == -1 ? "0" : StackFormatter.formatNumber(result.getClueScrollMaster().getLevel()));
					content += "<p><span style = 'color:white'>All:</span> " + all + " <span style = 'color:white'>Rank:</span> " + allRank + "</p>";
					content += "<p><span style = 'color:white'>Beginner:</span> " + beginner + " <span style = 'color:white'>Rank:</span> " + beginnerRank + "</p>";
					content += "<p><span style = 'color:white'>Easy:</span> " + easy + " <span style = 'color:white'>Rank:</span> " + easyRank + "</p>";
					content += "<p><span style = 'color:white'>Medium:</span> " + medium + " <span style = 'color:white'>Rank:</span> " + mediumRank + "</p>";
					content += "<p><span style = 'color:white'>Hard:</span> " + hard + " <span style = 'color:white'>Rank:</span> " + hardRank + "</p>";
					content += "<p><span style = 'color:white'>Elite:</span> " + elite + " <span style = 'color:white'>Rank:</span> " + eliteRank + "</p>";
					content += "<p><span style = 'color:white'>Master:</span> " + master + " <span style = 'color:white'>Rank:</span> " + masterRank + "</p>";
					break;
				}
				case BOUNTY_HUNTER_ROGUE:
				{
					String rank = (result.getBountyHunterRogue().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getBountyHunterRogue().getRank());
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					break;
				}
				case BOUNTY_HUNTER_HUNTER:
				{
					String rank = (result.getBountyHunterHunter().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getBountyHunterHunter().getRank());
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					break;
				}
				case LAST_MAN_STANDING:
				{
					String rank = (result.getLastManStanding().getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(result.getLastManStanding().getRank());
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					break;
				}
				case OVERALL:
				{
					Skill requestedSkill = result.getSkill(skill);
					String rank = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getRank());
					String exp = (requestedSkill.getExperience() == -1L) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getExperience());
					content += "<p><span style = 'color:white'>Skill:</span> " + skill.getName() + "</p>";
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					content += "<p><span style = 'color:white'>Experience:</span> " + exp + "</p>";
					break;
				}
				default:
				{
					Skill requestedSkill = result.getSkill(skill);
					final long experience = requestedSkill.getExperience();

					String rank = (requestedSkill.getRank() == -1) ? "Unranked" : StackFormatter.formatNumber(requestedSkill.getRank());
					String exp = (experience == -1L) ? "Unranked" : StackFormatter.formatNumber(experience);
					String remainingXp;
					if (experience == -1L)
					{
						remainingXp = "Unranked";
					}
					else
					{
						int currentLevel = Experience.getLevelForXp((int) experience);
						remainingXp = (currentLevel + 1 <= Experience.MAX_VIRT_LEVEL) ? StackFormatter.formatNumber(Experience.getXpForLevel(currentLevel + 1) - experience) : "0";
					}

					content += "<p><span style = 'color:white'>Skill:</span> " + skill.getName() + "</p>";
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					content += "<p><span style = 'color:white'>Experience:</span> " + exp + "</p>";
					content += "<p><span style = 'color:white'>Remaining XP:</span> " + remainingXp + "</p>";

					break;
				}
			}
		}

		/**
		 * Adds a html progress bar to the hover information
		 */
		if (SKILLS.contains(skill))
		{
			long experience = result.getSkill(skill).getExperience();
			if (experience >= 0)
			{
				int currentXp = (int) experience;
				int currentLevel = Experience.getLevelForXp(currentXp);
				int xpForCurrentLevel = Experience.getXpForLevel(currentLevel);
				int xpForNextLevel = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

				double xpGained = currentXp - xpForCurrentLevel;
				double xpGoal = xpForNextLevel != -1 ? xpForNextLevel - xpForCurrentLevel : 100;
				int progress = (int) ((xpGained / xpGoal) * 100f);

				// had to wrap the bar with an empty div, if i added the margin directly to the bar, it would mess up
				content += "<div style = 'margin-top:3px'>"
					+ "<div style = 'background: #070707; border: 1px solid #070707; height: 6px; width: 100%;'>"
					+ "<div style = 'height: 6px; width: " + progress + "%; background: #dc8a00;'>"
					+ "</div>"
					+ "</div>"
					+ "</div>";
			}
		}

		return openingTags + content + closingTags;
	}

	private static String sanitize(String lookup)
	{
		return lookup.replace('\u00A0', ' ');
	}

	private void resetEndpoints()
	{
		// Select the correct tab based on the world type.
		tabGroup.select(tabGroup.getTab(selectWorldEndpoint().ordinal()));
	}

	private HiscoreEndpoint selectWorldEndpoint()
	{
		if (client != null)
		{
			EnumSet<WorldType> wTypes = client.getWorldType();

			if (wTypes.contains(WorldType.DEADMAN_TOURNAMENT))
			{
				return HiscoreEndpoint.DEADMAN_TOURNAMENT;
			}
			else if (wTypes.contains(WorldType.SEASONAL_DEADMAN))
			{
				return HiscoreEndpoint.SEASONAL_DEADMAN;
			}
			else if (wTypes.contains(WorldType.DEADMAN))
			{
				return HiscoreEndpoint.DEADMAN;
			}
		}
		return HiscoreEndpoint.NORMAL;
	}
}
<<<<<<< HEAD
>>>>>>> upstream/master
=======
>>>>>>> upstream/master
