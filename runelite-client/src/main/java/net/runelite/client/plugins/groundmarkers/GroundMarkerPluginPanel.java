/*
 * Copyright (c) 2024, Pine <https://github.com/tylerwgrass>
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
package net.runelite.client.plugins.groundmarkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;
import javax.inject.Inject;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;

@Slf4j
public class GroundMarkerPluginPanel extends PluginPanel
{
	private static final String NO_GROUPS_TEXT = "No Ground Marker Groups";
	private static final String NO_GROUPS_SUBTEXT = "Create a group by selecting an existing marker";
	private final GroundMarkerPlugin plugin;
	private final JPanel container = new JPanel(new BorderLayout());
	private final PluginErrorPanel noGroupsPanel = new PluginErrorPanel();

	@Inject
	GroundMarkerPluginPanel(GroundMarkerPlugin plugin)
	{
		this.plugin = plugin;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		Collection<GroundMarkerGroup> groups = plugin.getGroups();

		noGroupsPanel.setContent(NO_GROUPS_TEXT, NO_GROUPS_SUBTEXT);
		noGroupsPanel.setVisible(groups.isEmpty());

		container.add(buildHeaderPanel(), BorderLayout.NORTH);
		container.add(buildGroupContentPanel(groups), BorderLayout.CENTER);
		if (noGroupsPanel.isVisible())
		{
			container.add(noGroupsPanel);
		}

		add(container);
	}

	private JPanel buildHeaderPanel()
	{
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		JLabel titleText = new JLabel("Ground Markers");
		titleText.setForeground(Color.WHITE);
		headerPanel.add(titleText, BorderLayout.WEST);

		return headerPanel;
	}

	private JPanel buildGroupContentPanel(Collection<GroundMarkerGroup> groups)
	{
		final JPanel groupContainer = new JPanel();
		groupContainer.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		for (GroundMarkerGroup group : groups)
		{
			groupContainer.add(new GroundMarkerGroupPanel(plugin, group), constraints);
			constraints.gridy++;

			groupContainer.add(Box.createRigidArea(new Dimension(0, 5)), constraints);
			constraints.gridy++;
		}
		return groupContainer;
	}

	void rebuild()
	{
		Collection<GroundMarkerGroup> groups = plugin.getGroups();

		container.removeAll();
		container.add(buildHeaderPanel(), BorderLayout.NORTH);
		container.add(buildGroupContentPanel(groups), BorderLayout.CENTER);

		noGroupsPanel.setVisible(groups.isEmpty());
		if (noGroupsPanel.isVisible())
		{
			container.add(noGroupsPanel, BorderLayout.CENTER);
		}

		repaint();
		revalidate();
	}
}
