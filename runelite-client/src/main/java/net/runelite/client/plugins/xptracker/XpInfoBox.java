/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package net.runelite.client.plugins.xptracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.SkillColor;
import net.runelite.client.ui.components.MouseDragEventForwarder;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.QuantityFormatter;

class XpInfoBox extends JPanel
{
	static final DecimalFormat TWO_DECIMAL_FORMAT = new DecimalFormat("0.00");

	static
	{
		TWO_DECIMAL_FORMAT.setRoundingMode(RoundingMode.DOWN);
	}

	// Templates
	private static final String PROGRESS_BAR_TOOLTIP =
		"<html>%s Actions done<br/>"
			+ "%s Actions/hr<br/>"
			+ "%s %s</html>";
	private static final String PROGRESS_BAR_TOOLTIP_NO_ACTIONS =
		"<html>%s %s</html>";
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	private static final String REMOVE_STATE = "Remove from canvas";
	private static final String ADD_STATE = "Add to canvas";

	private static final EmptyBorder DEFAULT_PROGRESS_WRAPPER_BORDER = new EmptyBorder(0, 7, 7, 7);
	private static final EmptyBorder COMPACT_PROGRESS_WRAPPER_BORDER = new EmptyBorder(5, 1, 5, 5);

	// Instance members
	private final JComponent panel;

	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;

	/* The tracker's wrapping container */
	private final JPanel container = new JPanel();

	/* Contains the skill icon and the stats panel */
	private final JPanel headerPanel = new JPanel();

	/* Contains all the skill information (exp gained, per hour, etc) */
	private final JPanel statsPanel = new JPanel();

	// Contains progress bar and compact-view icon
	private final JPanel progressWrapper = new JPanel();

	// Contains skill icon
	private final JLabel compactSkillIcon;

	private final ProgressBar progressBar = new ProgressBar();

	private final JLabel topLeftStat = new JLabel();
	private final JLabel bottomLeftStat = new JLabel();
	private final JLabel topRightStat = new JLabel();
	private final JLabel bottomRightStat = new JLabel();
	private final JMenuItem pauseSkill = new JMenuItem("Pause");
	private final JMenuItem canvasItem = new JMenuItem(ADD_STATE);

	private final XpTrackerConfig xpTrackerConfig;

	private boolean paused = false;

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, XpTrackerConfig xpTrackerConfig, Client client, JComponent panel, Skill skill, SkillIconManager iconManager)
	{
		this.xpTrackerConfig = xpTrackerConfig;
		this.panel = panel;
		this.skill = skill;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open Wise Old Man");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(
			client.getWorldType(), client.getLocalPlayer(), skill)));

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e -> xpTrackerPlugin.resetSkillState(skill));

		// Create reset others menu
		final JMenuItem resetOthers = new JMenuItem("Reset others");
		resetOthers.addActionListener(e -> xpTrackerPlugin.resetOtherSkillState(skill));

		// Create reset per hour menu
		final JMenuItem resetPerHour = new JMenuItem("Reset/hr");
		resetPerHour.addActionListener(e -> xpTrackerPlugin.resetSkillPerHourState(skill));

		// Create reset others menu
		pauseSkill.addActionListener(e -> xpTrackerPlugin.pauseSkill(skill, !paused));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(openXpTracker);
		popupMenu.add(reset);
		popupMenu.add(resetOthers);
		popupMenu.add(resetPerHour);
		popupMenu.add(pauseSkill);
		popupMenu.add(canvasItem);
		popupMenu.addPopupMenuListener(new PopupMenuListener()
		{
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent)
			{
				openXpTracker.setVisible(xpTrackerConfig.wiseOldManOpenOption());
				canvasItem.setText(xpTrackerPlugin.hasOverlay(skill) ? REMOVE_STATE : ADD_STATE);
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent)
			{
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent popupMenuEvent)
			{
			}
		});

		canvasItem.addActionListener(e ->
		{
			if (canvasItem.getText().equals(REMOVE_STATE))
			{
				xpTrackerPlugin.removeOverlay(skill);
			}
			else
			{
				xpTrackerPlugin.addOverlay(skill);
			}
		});

		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());

		statsPanel.setLayout(new DynamicGridLayout(2, 2));
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(9, 2, 9, 2));

		topLeftStat.setFont(FontManager.getRunescapeSmallFont());
		bottomLeftStat.setFont(FontManager.getRunescapeSmallFont());
		topRightStat.setFont(FontManager.getRunescapeSmallFont());
		bottomRightStat.setFont(FontManager.getRunescapeSmallFont());

		statsPanel.add(topLeftStat);     // top left
		statsPanel.add(topRightStat);    // top right
		statsPanel.add(bottomLeftStat);  // bottom left
		statsPanel.add(bottomRightStat); // bottom right

		JLabel headerSkillIcon = getSkillIcon(iconManager, skill, 35, 35, false);
		headerPanel.add(headerSkillIcon, BorderLayout.WEST);
		headerPanel.add(statsPanel, BorderLayout.CENTER);

		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(DEFAULT_PROGRESS_WRAPPER_BORDER);

		progressBar.setMaximumValue(100);
		progressBar.setBackground(new Color(61, 56, 49));
		progressBar.setForeground(SkillColor.find(skill).getColor());
		progressBar.setDimmedText("Paused");

		compactSkillIcon = getSkillIcon(iconManager, skill, 25, 16, true);
		compactSkillIcon.setVisible(false);

		progressWrapper.add(compactSkillIcon, BorderLayout.WEST);
		progressWrapper.add(progressBar, BorderLayout.CENTER);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);

		container.setComponentPopupMenu(popupMenu);
		progressBar.setComponentPopupMenu(popupMenu);

		// forward mouse drag events to parent panel for drag and drop reordering
		MouseDragEventForwarder mouseDragEventForwarder = new MouseDragEventForwarder(panel);
		container.addMouseListener(mouseDragEventForwarder);
		container.addMouseMotionListener(mouseDragEventForwarder);
		progressBar.addMouseListener(mouseDragEventForwarder);
		progressBar.addMouseMotionListener(mouseDragEventForwarder);

		// collapse/expand on mouse click
		final MouseAdapter clickToggleCompact = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					xpTrackerPlugin.setSkillCompactViewState(skill, toggleCompactView());
				}
			}
		};
		container.addMouseListener(clickToggleCompact);
		progressBar.addMouseListener(clickToggleCompact);

		add(container, BorderLayout.NORTH);
	}

	void reset()
	{
		canvasItem.setText(ADD_STATE);
		setCompactView(false);
		panel.remove(this);
		panel.revalidate();
	}

	void update(boolean updated, boolean paused, XpSnapshotSingle xpSnapshotSingle)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, paused, xpSnapshotSingle));
	}

	private boolean toggleCompactView()
	{
		final boolean isCompact = !headerPanel.isVisible();
		setCompactView(!isCompact);
		return !isCompact;
	}

	private void setCompactView(final boolean compact)
	{
		progressWrapper.setBorder(compact ? COMPACT_PROGRESS_WRAPPER_BORDER : DEFAULT_PROGRESS_WRAPPER_BORDER);
		headerPanel.setVisible(!compact);
		compactSkillIcon.setVisible(compact);
	}

	private static JLabel getSkillIcon(SkillIconManager iconManager, Skill skill, int width, int height, boolean small)
	{
		JLabel skillIcon = new JLabel();

		skillIcon.setIcon(new ImageIcon(iconManager.getSkillImage(skill, small)));
		skillIcon.setPreferredSize(new Dimension(width, height));
		skillIcon.setHorizontalAlignment(SwingConstants.CENTER);
		skillIcon.setVerticalAlignment(SwingConstants.CENTER);

		return skillIcon;
	}

	private void rebuildAsync(boolean updated, boolean skillPaused, XpSnapshotSingle xpSnapshotSingle)
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this);
				panel.revalidate();
			}

			if (xpTrackerConfig.prioritizeRecentXpSkills())
			{
				panel.setComponentZOrder(this, 0);
			}

			paused = skillPaused;

			// Update progress bar
			progressBar.setValue((int) xpSnapshotSingle.getSkillProgressToGoal());
			progressBar.setCenterLabel(xpTrackerConfig.progressBarLabel().getValueFunc().apply(xpSnapshotSingle));
			progressBar.setLeftLabel("Lvl. " + xpSnapshotSingle.getStartLevel());
			progressBar.setRightLabel(xpSnapshotSingle.getEndGoalXp() == Experience.MAX_SKILL_XP
				? "200M"
				: "Lvl. " + xpSnapshotSingle.getEndLevel());

			// Add intermediate level positions to progressBar
			if (xpTrackerConfig.showIntermediateLevels() && xpSnapshotSingle.getEndLevel() - xpSnapshotSingle.getStartLevel() > 1)
			{
				final List<Integer> positions = new ArrayList<>();

				for (int level = xpSnapshotSingle.getStartLevel() + 1; level <= xpSnapshotSingle.getEndLevel(); level++)
				{
					double relativeStartExperience = Experience.getXpForLevel(level) - xpSnapshotSingle.getStartGoalXp();
					double relativeEndExperience = xpSnapshotSingle.getEndGoalXp() - xpSnapshotSingle.getStartGoalXp();
					positions.add((int) (relativeStartExperience / relativeEndExperience * 100));
				}

				progressBar.setPositions(positions);
			}
			else
			{
				progressBar.setPositions(Collections.emptyList());
			}

			XpProgressBarLabel tooltipLabel = xpTrackerConfig.progressBarTooltipLabel();

			if (isCombatSkill(skill))
			{
				progressBar.setToolTipText(String.format(
					PROGRESS_BAR_TOOLTIP_NO_ACTIONS,
					tooltipLabel.getValueFunc().apply(xpSnapshotSingle),
					tooltipLabel == XpProgressBarLabel.PERCENTAGE ? "of goal" : "till goal lvl"));
			}
			else
			{
				progressBar.setToolTipText(String.format(
					PROGRESS_BAR_TOOLTIP,
					xpSnapshotSingle.getActionsInSession(),
					xpSnapshotSingle.getActionsPerHour(),
					tooltipLabel.getValueFunc().apply(xpSnapshotSingle),
					tooltipLabel == XpProgressBarLabel.PERCENTAGE ? "of goal" : "till goal lvl"));
			}

			progressBar.setDimmed(skillPaused);

			setCompactView(xpSnapshotSingle.isCompactView());
		}
		else if (!paused && skillPaused)
		{
			// React to the skill state now being paused
			progressBar.setDimmed(true);
			paused = true;
			pauseSkill.setText("Unpause");
		}
		else if (paused && !skillPaused)
		{
			// React to the skill being unpaused (without update)
			progressBar.setDimmed(false);
			paused = false;
			pauseSkill.setText("Pause");
		}

		// Update information labels
		// Update exp per hour separately, every time (not only when there's an update)
		topLeftStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel1(), xpSnapshotSingle));
		topRightStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel2(), xpSnapshotSingle));
		bottomLeftStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel3(), xpSnapshotSingle));
		bottomRightStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel4(), xpSnapshotSingle));
	}

	private String htmlLabel(XpPanelLabel panelLabel, XpSnapshotSingle xpSnapshotSingle)
	{
		// hide actions for combat skills
		if (isActions(panelLabel) && isCombatSkill(skill))
		{
			return "";
		}

		String key = panelLabel.getKey() + ": ";
		String value = panelLabel.getValueFunc().apply(xpSnapshotSingle);
		return htmlLabel(key, value);
	}

	private static boolean isActions(XpPanelLabel panelLabel)
	{
		return panelLabel == XpPanelLabel.ACTIONS_LEFT || panelLabel == XpPanelLabel.ACTIONS_HOUR || panelLabel == XpPanelLabel.ACTIONS_DONE;
	}

	private static boolean isCombatSkill(Skill skill)
	{
		return skill == Skill.ATTACK || skill == Skill.STRENGTH || skill == Skill.DEFENCE || skill == Skill.HITPOINTS || skill == Skill.RANGED;
	}

	static String htmlLabel(String key, int value)
	{
		String valueStr = QuantityFormatter.quantityToRSDecimalStack(value, true);
		return htmlLabel(key, valueStr);
	}

	static String htmlLabel(String key, String valueStr)
	{
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}
}
