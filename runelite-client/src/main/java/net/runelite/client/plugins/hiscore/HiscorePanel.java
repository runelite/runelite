/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2019, Bram91 <https://github.com/bram91>
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.hiscore.HiscoreClient;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.HiscoreSkill;
import static net.runelite.client.hiscore.HiscoreSkill.*;
import net.runelite.client.hiscore.HiscoreSkillType;
import net.runelite.client.hiscore.Skill;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class HiscorePanel extends PluginPanel
{
	/* The maximum allowed username length in RuneScape accounts */
	private static final int MAX_USERNAME_LENGTH = 12;

	/**
	 * Real skills, ordered in the way they should be displayed in the panel.
	 */
	private static final List<HiscoreSkill> SKILLS = ImmutableList.of(
		ATTACK, HITPOINTS, MINING,
		STRENGTH, AGILITY, SMITHING,
		DEFENCE, HERBLORE, FISHING,
		RANGED, THIEVING, COOKING,
		PRAYER, CRAFTING, FIREMAKING,
		MAGIC, FLETCHING, WOODCUTTING,
		RUNECRAFT, SLAYER, FARMING,
		CONSTRUCTION, HUNTER
	);

	/**
	 * Bosses, ordered in the way they should be displayed in the panel.
	 */
	private static final List<HiscoreSkill> BOSSES = ImmutableList.of(
		ABYSSAL_SIRE, ALCHEMICAL_HYDRA, BARROWS_CHESTS,
		BRYOPHYTA, CALLISTO, CERBERUS,
		CHAMBERS_OF_XERIC, CHAMBERS_OF_XERIC_CHALLENGE_MODE, CHAOS_ELEMENTAL,
		CHAOS_FANATIC, COMMANDER_ZILYANA, CORPOREAL_BEAST,
		DAGANNOTH_PRIME, DAGANNOTH_REX, DAGANNOTH_SUPREME,
		CRAZY_ARCHAEOLOGIST, DERANGED_ARCHAEOLOGIST, GENERAL_GRAARDOR,
		GIANT_MOLE, GROTESQUE_GUARDIANS, HESPORI,
		KALPHITE_QUEEN, KING_BLACK_DRAGON, KRAKEN,
		KREEARRA, KRIL_TSUTSAROTH, MIMIC,
		NEX, NIGHTMARE, PHOSANIS_NIGHTMARE,
		OBOR, PHANTOM_MUSPAH, SARACHNIS,
		SCORPIA, SKOTIZO, TEMPOROSS,
		THE_GAUNTLET, THE_CORRUPTED_GAUNTLET, THEATRE_OF_BLOOD,
		THEATRE_OF_BLOOD_HARD_MODE, THERMONUCLEAR_SMOKE_DEVIL, TOMBS_OF_AMASCUT,
		TOMBS_OF_AMASCUT_EXPERT, TZKAL_ZUK, TZTOK_JAD,
		VENENATIS, VETION, VORKATH,
		WINTERTODT, ZALCANO, ZULRAH
	);

	private static final HiscoreEndpoint[] ENDPOINTS = {
		HiscoreEndpoint.NORMAL, HiscoreEndpoint.IRONMAN, HiscoreEndpoint.HARDCORE_IRONMAN, HiscoreEndpoint.ULTIMATE_IRONMAN,
		HiscoreEndpoint.DEADMAN, HiscoreEndpoint.PURE, HiscoreEndpoint.LEVEL_3_SKILLER, HiscoreEndpoint.FRESH_START_WORLD
	};

	private final HiscorePlugin plugin;
	private final HiscoreConfig config;
	private final NameAutocompleter nameAutocompleter;
	private final HiscoreClient hiscoreClient;

	private final IconTextField searchBar;

	// Not an enummap because we need null keys for combat
	private final Map<HiscoreSkill, JLabel> skillLabels = new HashMap<>();

	/* Container of all the selectable endpoints (ironman, deadman, etc) */
	private final MaterialTabGroup tabGroup;

	/* The currently selected endpoint */
	private HiscoreEndpoint selectedEndPoint;

	/* Used to prevent users from switching endpoint tabs while the results are loading */
	private boolean loading = false;

	@Inject
	public HiscorePanel(@Nullable Client client, HiscorePlugin plugin, HiscoreConfig config,
		NameAutocompleter nameAutocompleter, HiscoreClient hiscoreClient)
	{
		this.plugin = plugin;
		this.config = config;
		this.nameAutocompleter = nameAutocompleter;
		this.hiscoreClient = hiscoreClient;

		setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new GridBagLayout());

		// Expand sub items to fit width of panel, align to top of panel
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
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
		searchBar.addActionListener(e -> lookup());
		searchBar.addMouseListener(new MouseAdapter()
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
					lookup(localPlayer.getName(), plugin.getLocalHiscoreEndpoint());
				}
			}
		});
		searchBar.addClearListener(() ->
		{
			searchBar.setIcon(IconTextField.Icon.SEARCH);
			searchBar.setEditable(true);
			loading = false;
		});

		add(searchBar, c);
		c.gridy++;

		tabGroup = new MaterialTabGroup();
		tabGroup.setLayout(new GridLayout(2, 4, 7, 7));

		for (HiscoreEndpoint endpoint : ENDPOINTS)
		{
			final BufferedImage iconImage = ImageUtil.loadImageResource(getClass(), endpoint.name().toLowerCase() + ".png");

			MaterialTab tab = new MaterialTab(new ImageIcon(iconImage), tabGroup, null);
			tab.setToolTipText(endpoint.getName() + " Hiscores");
			tab.setOnSelectEvent(() ->
			{
				if (loading)
				{
					return false;
				}

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

					lookup();
				}
			});

			tabGroup.addTab(tab);
		}

		// Default selected tab is normal hiscores
		resetEndpoints();

		add(tabGroup, c);
		c.gridy++;

		// Panel that holds skill icons
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(8, 3));
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(5, 0, 5, 0));

		// For each skill on the ingame skill panel, create a Label and add it to the UI
		for (HiscoreSkill skill : SKILLS)
		{
			JPanel panel = makeHiscorePanel(skill);
			statsPanel.add(panel);
		}

		add(statsPanel, c);
		c.gridy++;

		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(1, 2));
		totalPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		totalPanel.add(makeHiscorePanel(null)); //combat has no hiscore skill, referred to as null
		totalPanel.add(makeHiscorePanel(OVERALL));

		add(totalPanel, c);
		c.gridy++;

		JPanel minigamePanel = new JPanel();
		// These aren't all on one row because when there's a label with four or more digits it causes the details
		// panel to change its size for some reason...
		minigamePanel.setLayout(new GridLayout(2, 3));
		minigamePanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		minigamePanel.add(makeHiscorePanel(CLUE_SCROLL_ALL));
		minigamePanel.add(makeHiscorePanel(LEAGUE_POINTS));
		minigamePanel.add(makeHiscorePanel(LAST_MAN_STANDING));
		minigamePanel.add(makeHiscorePanel(SOUL_WARS_ZEAL));
		minigamePanel.add(makeHiscorePanel(RIFTS_CLOSED));
		minigamePanel.add(makeHiscorePanel(BOUNTY_HUNTER_ROGUE));
		minigamePanel.add(makeHiscorePanel(BOUNTY_HUNTER_HUNTER));
		minigamePanel.add(makeHiscorePanel(PVP_ARENA_RANK));

		add(minigamePanel, c);
		c.gridy++;

		JPanel bossPanel = new JPanel();
		bossPanel.setLayout(new GridLayout(0, 3));
		bossPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// For each boss on the hi-scores, create a Label and add it to the UI
		for (HiscoreSkill skill : BOSSES)
		{
			JPanel panel = makeHiscorePanel(skill);
			bossPanel.add(panel);
		}

		add(bossPanel, c);
		c.gridy++;

		addInputKeyListener(nameAutocompleter);
	}

	void shutdown()
	{
		removeInputKeyListener(nameAutocompleter);
	}

	@Override
	public void onActivate()
	{
		super.onActivate();
		searchBar.requestFocusInWindow();
	}

	/* Builds a JPanel displaying an icon and level/number associated with it */
	private JPanel makeHiscorePanel(HiscoreSkill skill)
	{
		HiscoreSkillType skillType = skill == null ? HiscoreSkillType.SKILL : skill.getType();

		JLabel label = new JLabel();
		label.setToolTipText(skill == null ? "Combat" : skill.getName());
		label.setFont(FontManager.getRunescapeSmallFont());
		label.setText(pad("--", skillType));

		String directory;
		if (skill == null || skill == OVERALL)
		{
			directory = "/skill_icons/";
		}
		else if (skill.getType() == HiscoreSkillType.BOSS)
		{
			directory = "bosses/";
		}
		else
		{
			directory = "/skill_icons_small/";
		}

		String skillName = (skill == null ? "combat" : skill.name().toLowerCase());
		String skillIcon = directory + skillName + ".png";
		log.debug("Loading skill icon from {}", skillIcon);

		label.setIcon(new ImageIcon(ImageUtil.loadImageResource(getClass(), skillIcon)));

		boolean totalLabel = skill == OVERALL || skill == null; //overall or combat
		label.setIconTextGap(totalLabel ? 10 : 4);

		JPanel skillPanel = new JPanel();
		skillPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		skillPanel.setBorder(new EmptyBorder(2, 0, 2, 0));
		skillLabels.put(skill, label);
		skillPanel.add(label);

		return skillPanel;
	}

	public void lookup(String username, HiscoreEndpoint endpoint)
	{
		searchBar.setText(username);
		tabGroup.select(tabGroup.getTab(ArrayUtils.indexOf(ENDPOINTS, endpoint)));
		lookup();
	}

	private void lookup()
	{
		final String lookup = sanitize(searchBar.getText());

		if (Strings.isNullOrEmpty(lookup))
		{
			return;
		}

		/* RuneScape usernames can't be longer than 12 characters long */
		if (lookup.length() > MAX_USERNAME_LENGTH)
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			loading = false;
			return;
		}

		repaint();

		searchBar.setEditable(false);
		searchBar.setIcon(IconTextField.Icon.LOADING_DARKER);
		loading = true;

		for (Map.Entry<HiscoreSkill, JLabel> entry : skillLabels.entrySet())
		{
			HiscoreSkill skill = entry.getKey();
			JLabel label = entry.getValue();
			HiscoreSkillType skillType = skill == null ? HiscoreSkillType.SKILL : skill.getType();

			label.setText(pad("--", skillType));
			label.setToolTipText(skill == null ? "Combat" : skill.getName());
		}

		// if for some reason no endpoint was selected, default to normal
		if (selectedEndPoint == null)
		{
			selectedEndPoint = HiscoreEndpoint.NORMAL;
		}

		hiscoreClient.lookupAsync(lookup, selectedEndPoint).whenCompleteAsync((result, ex) ->
			SwingUtilities.invokeLater(() ->
			{
				if (!sanitize(searchBar.getText()).equals(lookup))
				{
					// search has changed in the meantime
					return;
				}

				if (result == null || ex != null)
				{
					if (ex != null)
					{
						log.warn("Error fetching Hiscore data " + ex.getMessage());
					}

					searchBar.setIcon(IconTextField.Icon.ERROR);
					searchBar.setEditable(true);
					loading = false;
					return;
				}

				//successful player search
				searchBar.setIcon(IconTextField.Icon.SEARCH);
				searchBar.setEditable(true);
				loading = false;

				applyHiscoreResult(result);
			}));
	}

	private void applyHiscoreResult(HiscoreResult result)
	{
		assert SwingUtilities.isEventDispatchThread();
		repaint();

		nameAutocompleter.addToSearchHistory(result.getPlayer().toLowerCase());

		for (Map.Entry<HiscoreSkill, JLabel> entry : skillLabels.entrySet())
		{
			HiscoreSkill skill = entry.getKey();
			JLabel label = entry.getValue();
			Skill s;

			if (skill == null)
			{
				if (result.getPlayer() != null)
				{
					int combatLevel = Experience.getCombatLevel(
						result.getSkill(ATTACK).getLevel(),
						result.getSkill(STRENGTH).getLevel(),
						result.getSkill(DEFENCE).getLevel(),
						result.getSkill(HITPOINTS).getLevel(),
						result.getSkill(MAGIC).getLevel(),
						result.getSkill(RANGED).getLevel(),
						result.getSkill(PRAYER).getLevel()
					);
					label.setText(Integer.toString(combatLevel));
				}
			}
			else if ((s = result.getSkill(skill)) != null)
			{
				final long exp = s.getExperience();
				final boolean isSkill = skill.getType() == HiscoreSkillType.SKILL;
				int level = -1;
				if (config.virtualLevels() && isSkill && exp > -1L)
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
					label.setText(pad(formatLevel(level), skill.getType()));
				}
			}

			label.setToolTipText(detailsHtml(result, skill));
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
				result.getSkill(ATTACK).getLevel(),
				result.getSkill(STRENGTH).getLevel(),
				result.getSkill(DEFENCE).getLevel(),
				result.getSkill(HITPOINTS).getLevel(),
				result.getSkill(MAGIC).getLevel(),
				result.getSkill(RANGED).getLevel(),
				result.getSkill(PRAYER).getLevel()
			);

			double combatExperience = result.getSkill(ATTACK).getExperience()
				+ result.getSkill(STRENGTH).getExperience() + result.getSkill(DEFENCE).getExperience()
				+ result.getSkill(HITPOINTS).getExperience() + result.getSkill(MAGIC).getExperience()
				+ result.getSkill(RANGED).getExperience() + result.getSkill(PRAYER).getExperience();

			content += "<p><span style = 'color:white'>Combat</span></p>";
			content += "<p><span style = 'color:white'>Exact Combat Level:</span> " + QuantityFormatter.formatNumber(combatLevel) + "</p>";
			content += "<p><span style = 'color:white'>Experience:</span> " + QuantityFormatter.formatNumber(combatExperience) + "</p>";
		}
		else
		{
			switch (skill)
			{
				case CLUE_SCROLL_ALL:
				{
					content += "<p><span style = 'color:white'>Clues</span></p>";
					content += buildClueLine(result, "All", CLUE_SCROLL_ALL);
					content += buildClueLine(result, "Beginner", CLUE_SCROLL_BEGINNER);
					content += buildClueLine(result, "Easy", CLUE_SCROLL_EASY);
					content += buildClueLine(result, "Medium", CLUE_SCROLL_MEDIUM);
					content += buildClueLine(result, "Hard", CLUE_SCROLL_HARD);
					content += buildClueLine(result, "Elite", CLUE_SCROLL_ELITE);
					content += buildClueLine(result, "Master", CLUE_SCROLL_MASTER);
					break;
				}
				case BOUNTY_HUNTER_ROGUE:
				case BOUNTY_HUNTER_HUNTER:
				case PVP_ARENA_RANK:
				case LAST_MAN_STANDING:
				case SOUL_WARS_ZEAL:
				case RIFTS_CLOSED:
				{
					content += buildMinigameTooltip(result.getSkill(skill), skill);
					break;
				}
				case LEAGUE_POINTS:
				{
					Skill leaguePoints = result.getSkill(LEAGUE_POINTS);
					String rank = (leaguePoints.getRank() == -1) ? "Unranked" : QuantityFormatter.formatNumber(leaguePoints.getRank());
					content += "<p><span style = 'color:white'>League Points</span></p>";
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					if (leaguePoints.getLevel() > -1)
					{
						content += "<p><span style = 'color:white'>Points:</span> " + QuantityFormatter.formatNumber(leaguePoints.getLevel()) + "</p>";
					}
					break;
				}
				case OVERALL:
				{
					Skill requestedSkill = result.getSkill(skill);
					String rank = (requestedSkill.getRank() == -1) ? "Unranked" : QuantityFormatter.formatNumber(requestedSkill.getRank());
					String exp = (requestedSkill.getExperience() == -1L) ? "Unranked" : QuantityFormatter.formatNumber(requestedSkill.getExperience());
					content += "<p><span style = 'color:white'>" + skill.getName() + "</span></p>";
					content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
					content += "<p><span style = 'color:white'>Experience:</span> " + exp + "</p>";
					break;
				}
				default:
				{
					if (skill.getType() == HiscoreSkillType.BOSS)
					{
						String rank = "Unranked";
						String lvl = null;
						Skill requestedSkill = result.getSkill(skill);
						if (requestedSkill != null)
						{
							if (requestedSkill.getRank() > -1)
							{
								rank = QuantityFormatter.formatNumber(requestedSkill.getRank());
							}
							if (requestedSkill.getLevel() > -1)
							{
								lvl = QuantityFormatter.formatNumber(requestedSkill.getLevel());
							}
						}

						content += "<p><span style = 'color:white'>Boss:</span> " + skill.getName() + "</p>";
						content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
						if (lvl != null)
						{
							content += "<p><span style = 'color:white'>KC:</span> " + lvl + "</p>";
						}
					}
					else
					{
						Skill requestedSkill = result.getSkill(skill);
						final long experience = requestedSkill.getExperience();

						String rank = (requestedSkill.getRank() == -1) ? "Unranked" : QuantityFormatter.formatNumber(requestedSkill.getRank());
						String exp = (experience == -1L) ? "Unranked" : QuantityFormatter.formatNumber(experience);
						String remainingXp;
						if (experience == -1L)
						{
							remainingXp = "Unranked";
						}
						else
						{
							int currentLevel = Experience.getLevelForXp((int) experience);
							remainingXp = (currentLevel + 1 <= Experience.MAX_VIRT_LEVEL) ? QuantityFormatter.formatNumber(Experience.getXpForLevel(currentLevel + 1) - experience) : "0";
						}

						content += "<p><span style = 'color:white'>Skill:</span> " + skill.getName() + "</p>";
						content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
						content += "<p><span style = 'color:white'>Experience:</span> " + exp + "</p>";
						content += "<p><span style = 'color:white'>Remaining XP:</span> " + remainingXp + "</p>";
					}
					break;
				}
			}
		}

		// Add a html progress bar to the hover information
		if (skill != null && skill.getType() == HiscoreSkillType.SKILL)
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

	private static String buildMinigameTooltip(Skill s, HiscoreSkill hiscoreSkill)
	{
		String rank = (s.getRank() == -1) ? "Unranked" : QuantityFormatter.formatNumber(s.getRank());
		String content = "";
		content += "<p><span style = 'color:white'>" + hiscoreSkill.getName() + "</span></p>";
		content += "<p><span style = 'color:white'>Rank:</span> " + rank + "</p>";
		if (s.getLevel() > -1)
		{
			content += "<p><span style = 'color:white'>Score:</span> " + QuantityFormatter.formatNumber(s.getLevel()) + "</p>";
		}
		return content;
	}

	private static String buildClueLine(HiscoreResult result, String name, HiscoreSkill skill)
	{
		Skill sk = result.getSkill(skill);
		String count = sk.getLevel() == -1
			? "0"
			: QuantityFormatter.formatNumber(sk.getLevel());
		String rank = sk.getRank() == -1
			? "Unranked"
			: QuantityFormatter.formatNumber(sk.getRank());
		return "<p><span style = 'color:white'>" + name + ":</span> " + count + " <span style = 'color:white'>Rank:</span> " + rank + "</p>";
	}

	private static String sanitize(String lookup)
	{
		return lookup.replace('\u00A0', ' ');
	}

	private void resetEndpoints()
	{
		// Select the correct tab based on the world type.
		HiscoreEndpoint endpoint = plugin.getWorldEndpoint();
		int idx = ArrayUtils.indexOf(ENDPOINTS, endpoint);
		tabGroup.select(tabGroup.getTab(idx));
	}

	@VisibleForTesting
	static String formatLevel(int level)
	{
		if (level < 10000)
		{
			return Integer.toString(level);
		}
		else
		{
			return (level / 1000) + "k";
		}
	}

	private static String pad(String str, HiscoreSkillType type)
	{
		// Left pad label text to keep labels aligned
		int pad = type == HiscoreSkillType.BOSS ? 4 : 2;
		return StringUtils.leftPad(str, pad);
	}
}
