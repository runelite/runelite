/*
 * Copyright (c) 2019, Royce Mathews <mathewsr23@gmail.com>
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

package net.runelite.client.plugins.worldhopper.filter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.runelite.client.plugins.worldhopper.WorldHopperPlugin;
import net.runelite.client.util.ImageUtil;

public class WorldFilterPanel extends JPanel
{
	private static final ImageIcon ARROW_UP;
	private static final ImageIcon ARROW_DOWN;

	static
	{
		final BufferedImage arrowDown = ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "arrow_down.png");
		final BufferedImage arrowDownFaded = ImageUtil.grayscaleOffset(arrowDown, -80);
		final BufferedImage arrowUpFaded = ImageUtil.rotateImage(arrowDownFaded, Math.PI);
		ARROW_UP = new ImageIcon(arrowUpFaded);
		ARROW_DOWN = new ImageIcon(arrowDownFaded);
	}

	private JCheckBoxMenuItem hideF2PCheckbox;
	private JCheckBoxMenuItem hideP2PCheckbox;
	private JCheckBoxMenuItem hideSkillTotalCheckbox;
	private JCheckBoxMenuItem hidePvPCheckbox;
	private JCheckBoxMenuItem hideDeadmanCheckbox;
	private JCheckBoxMenuItem hideUnrestrictedCheckbox;

	public WorldFilterPanel(WorldHopperPlugin plugin)
	{
		super(new BorderLayout(), true);

		JPanel filtersContainer = new JPanel();
		filtersContainer.setVisible(false);
		filtersContainer.setLayout(new GridLayout(0, 1));

		createFilterCheckBoxes(plugin);

		filtersContainer.add(hideF2PCheckbox);
		filtersContainer.add(hideP2PCheckbox);
		filtersContainer.add(hideSkillTotalCheckbox);
		filtersContainer.add(hidePvPCheckbox);
		filtersContainer.add(hideDeadmanCheckbox);
		filtersContainer.add(hideUnrestrictedCheckbox);

		JButton filtersButton = new JButton("Filters", ARROW_DOWN);
		filtersButton.setBorder(BorderFactory.createEmptyBorder());
		filtersButton.setFocusPainted(false);
		filtersButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					return;
				}

				if (!filtersContainer.isVisible())
				{
					filtersButton.setIcon(ARROW_UP);
					filtersContainer.setVisible(true);
				}
				else
				{
					filtersButton.setIcon(ARROW_DOWN);
					filtersContainer.setVisible(false);
				}
			}
		});

		add(filtersButton, BorderLayout.NORTH);
		add(filtersContainer, BorderLayout.CENTER);
	}

	private void createFilterCheckBoxes(WorldHopperPlugin plugin)
	{
		ActionListener updateListListener = e -> plugin.updateList();

		hideF2PCheckbox = new JCheckBoxMenuItem("Hide F2P Worlds");
		hideF2PCheckbox.addActionListener(updateListListener);

		hideP2PCheckbox = new JCheckBoxMenuItem("Hide P2P Worlds");
		hideP2PCheckbox.addActionListener(updateListListener);

		hideSkillTotalCheckbox = new JCheckBoxMenuItem("Hide Skill Total Worlds");
		hideSkillTotalCheckbox.addActionListener(updateListListener);

		hidePvPCheckbox = new JCheckBoxMenuItem("Hide PVP Worlds");
		hidePvPCheckbox.addActionListener(updateListListener);

		hideDeadmanCheckbox = new JCheckBoxMenuItem("Hide Deadman Worlds");
		hideDeadmanCheckbox.addActionListener(updateListListener);

		hideUnrestrictedCheckbox = new JCheckBoxMenuItem("Hide Unrestricted Worlds");
		hideUnrestrictedCheckbox.addActionListener(updateListListener);
	}

	public WorldFilterDefinition getWorldFilterDefinition()
	{
		return new WorldFilterDefinition()
			.hideF2P(hideF2PCheckbox.getState())
			.hideP2P(hideP2PCheckbox.getState())
			.hideSkillWorld(hideSkillTotalCheckbox.getState())
			.hidePvP(hidePvPCheckbox.getState())
			.hideDeadman(hideDeadmanCheckbox.getState())
			.hideUnrestricted(hideUnrestrictedCheckbox.getState());
	}
}
