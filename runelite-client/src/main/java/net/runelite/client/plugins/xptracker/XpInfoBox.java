/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.WeaponType;
import net.runelite.client.plugins.opponentinfo.OpponentInfoPlugin;
import net.runelite.client.ui.JShadowedLabel;
import net.runelite.client.util.LinkBrowser;
import org.pushingpixels.substance.internal.SubstanceSynapse;

@Slf4j
class XpInfoBox extends JPanel
{
	private static final Rectangle ICON_BOUNDS = new Rectangle(0, 0, 26, 26);

	private final Client client;
	private final JPanel panel;
	private final Skill skill;

	private final JPanel container = new JPanel();
	private final JPanel statsPanel = new JPanel();
	private final JProgressBar progressBar = new JProgressBar();
	private final JLabel xpHr = new JLabel();
	private final JLabel xpGained = new JLabel();
	private final JLabel xpLeft = new JLabel();
	private final JLabel actionsLeft = new JLabel();
	private final JLabel levelLabel = new JShadowedLabel();

	private Map<String, Integer> oppInfoHealth = OpponentInfoPlugin.loadNpcHealth();
	private static final Skill[] COMBAT = new Skill[]
			{
					Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.HITPOINTS
			};

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, Client client, JPanel panel, Skill skill, SkillIconManager iconManager) throws IOException
	{
		this.client = client;
		this.panel = panel;
		this.skill = skill;

		setLayout(new BorderLayout());
		setBorder(new CompoundBorder
		(
			new EmptyBorder(2, 0, 2, 0),
			new LineBorder(getBackground().brighter(), 1)
		));

		// Expand stats panel on click
		Color backgroundColor = getBackground();

		MouseListener panelMouseListener = new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				container.setBackground(backgroundColor.darker().darker());
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				container.setBackground(backgroundColor);
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				if (SwingUtilities.isLeftMouseButton(e))
				{
					showStatsPanel();
				}
			}
		};

		container.setLayout(new BorderLayout());
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.addMouseListener(panelMouseListener);

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open XP tracker");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(client.getLocalPlayer(), skill)));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(openXpTracker);
		container.setComponentPopupMenu(popupMenu);

		// Create icon panel
		final JPanel iconBarPanel = new JPanel();
		iconBarPanel.setLayout(new BorderLayout(5, 0));
		iconBarPanel.setOpaque(false);

		// Create skill/reset icon
		final BufferedImage skillImage = iconManager.getSkillImage(skill);
		final JButton skillIcon = new JButton();

		skillIcon.putClientProperty(SubstanceSynapse.FLAT_LOOK, Boolean.TRUE);
		skillIcon.putClientProperty(SubstanceSynapse.BUTTON_NEVER_PAINT_BACKGROUND, Boolean.TRUE);
		skillIcon.setIcon(new ImageIcon(skillImage));
		skillIcon.setRolloverIcon(new ImageIcon(createHoverImage(skillImage)));

		skillIcon.setToolTipText("Reset " + skill.getName() + " tracker");
		skillIcon.addActionListener(e -> xpTrackerPlugin.resetSkillState(skill));
		skillIcon.setBounds(ICON_BOUNDS);
		skillIcon.setOpaque(false);
		skillIcon.setFocusPainted(false);

		// Create level label
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setForeground(Color.YELLOW);
		levelLabel.setBounds(ICON_BOUNDS);
		levelLabel.setOpaque(false);

		// Create pane for grouping skill icon and level label
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(skillIcon, new Integer(1));
		layeredPane.add(levelLabel, new Integer(2));
		layeredPane.setPreferredSize(ICON_BOUNDS.getSize());
		iconBarPanel.add(layeredPane, BorderLayout.LINE_START);

		// Create progress bar
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(Color.RED);
		progressBar.addMouseListener(panelMouseListener);
		iconBarPanel.add(progressBar, BorderLayout.CENTER);

		container.add(iconBarPanel, BorderLayout.NORTH);

		// Stats panel
		statsPanel.setLayout(new GridLayout(2, 2));
		statsPanel.setBorder(new EmptyBorder(3, 0, 0, 0));
		statsPanel.setOpaque(false);

		statsPanel.add(xpGained);
		xpHr.setHorizontalAlignment(SwingConstants.RIGHT);
		statsPanel.add(xpHr);
		statsPanel.add(xpLeft);
		actionsLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		statsPanel.add(actionsLeft);

		add(container, BorderLayout.CENTER);
	}

	private void showStatsPanel()
	{
		if (statsPanel.isShowing())
		{
			container.remove(statsPanel);
			revalidate();
		}
		else
		{
			container.add(statsPanel, BorderLayout.SOUTH);
			revalidate();
		}
	}

	void reset()
	{
		container.remove(statsPanel);
		panel.remove(this);
		panel.revalidate();
	}

	void update(boolean updated, XpSnapshotSingle xpSnapshotSingle)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, xpSnapshotSingle));
	}

	private void rebuildAsync(boolean updated, XpSnapshotSingle xpSnapshotSingle)
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this);
				panel.revalidate();
			}
			levelLabel.setText(String.valueOf(xpSnapshotSingle.getCurrentLevel()));
			xpGained.setText(XpPanel.formatLine(xpSnapshotSingle.getXpGainedInSession(), "xp gained"));
			xpLeft.setText(XpPanel.formatLine(xpSnapshotSingle.getXpRemainingToGoal(), "xp left"));
			if (Arrays.asList(COMBAT).contains(skill))
			{
				actionsLeft.setText(XpPanel.formatLine(getKillsRemaining(xpSnapshotSingle), getTextActionKills()));
			}
			else
			{
				actionsLeft.setText(XpPanel.formatLine(xpSnapshotSingle.getActionsRemainingToGoal(), getTextActionKills()));
			}

			final int progress = xpSnapshotSingle.getSkillProgressToGoal();

			progressBar.setValue(progress);
			progressBar.setBackground(Color.getHSBColor((progress / 100.f) * (120.f / 360.f), 1, 1));

			progressBar.setToolTipText("<html>"
				+ XpPanel.formatLine(xpSnapshotSingle.getActionsInSession(), "actions")
				+ "<br/>"
				+ XpPanel.formatLine(xpSnapshotSingle.getActionsPerHour(), "actions/hr")
				+ "<br/>"
				+ xpSnapshotSingle.getTimeTillGoal() + " till next lvl"
				+ "</html>");
		}

		// Always update xp/hr as time always changes
		xpHr.setText(XpPanel.formatLine(xpSnapshotSingle.getXpPerHour(), "xp/hr"));
	}

	// Replaces the actions remaining with kills remaining
	private int getKillsRemaining(XpSnapshotSingle xpSnapshotSingle)
	{
		int killsRemaining = Integer.MAX_VALUE;
		Actor opponent = client.getLocalPlayer().getInteracting();
		if (opponent != null)
		{
			int opponentHealth = oppInfoHealth.get(opponent.getName() + "_" + opponent.getCombatLevel());
			double modifier = getCombatXPModifier(skill);
			double actionExp = (opponentHealth * modifier);
			killsRemaining = (int)(xpSnapshotSingle.getXpRemainingToGoal() / actionExp);
		}
		return killsRemaining;
	}

	// Calculates the xp modifier based on combat style
	private double getCombatXPModifier(Skill skill)
	{
		final double sharedXPModifier = 4.0 / 3.0;
		final double longRangedXPModifier = 2.0;
		final double defaultModifier = 4;
		if (skill.equals(Skill.HITPOINTS))
		{
			return sharedXPModifier;
		}
		int styleIndex = client.getVar(VarPlayer.ATTACK_STYLE);
		WeaponType weaponType = WeaponType.getWeaponType(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE));
		return weaponType.getAttackStyles()[styleIndex].equals(AttackStyle.CONTROLLED) ? sharedXPModifier :
				weaponType.getAttackStyles()[styleIndex].equals(AttackStyle.LONGRANGE) ? longRangedXPModifier : defaultModifier;
	}

	// Return the text of the action, depending if it's a combat skill.
	private String getTextActionKills()
	{
		return Arrays.asList(COMBAT).contains(skill) ? "kills left" : "actions left";
	}

	private static BufferedImage createHoverImage(BufferedImage image)
	{
		LookupTable lookup = new LookupTable(0, 4)
		{
			@Override
			public int[] lookupPixel(int[] src, int[] dest)
			{
				if (dest[3] != 0)
				{
					dest[3] = 60;
				}

				return dest;
			}
		};

		LookupOp op = new LookupOp(lookup, new RenderingHints(null));
		return op.filter(image, null);
	}
}
