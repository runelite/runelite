/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.equipmentinspector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemDefinition;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.AsyncBufferedImage;

@Slf4j
@Singleton
class EquipmentInspectorPanel extends PluginPanel
{
	private final static String NO_PLAYER_SELECTED = "No player selected";

	private final GridBagConstraints c;
	private final JPanel equipmentPanels;
	private final JPanel header;
	private final JLabel nameLabel;

	@Inject
	private ItemManager itemManager;

	public EquipmentInspectorPanel()
	{
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		equipmentPanels = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBorder(new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(58, 58, 58)),
			BorderFactory.createEmptyBorder(0, 0, 10, 0)));

		nameLabel = new JLabel(NO_PLAYER_SELECTED);
		nameLabel.setForeground(Color.WHITE);
		header.add(nameLabel, BorderLayout.CENTER);
		layout.setHorizontalGroup(layout.createParallelGroup()
			.addComponent(equipmentPanels)
			.addComponent(header)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(header)
			.addGap(10)
			.addComponent(equipmentPanels)
		);
		update(new HashMap<>(), "");
	}

	public void update(Map<KitType, ItemDefinition> playerEquipment, String playerName)
	{
		if (playerName.isEmpty())
		{
			nameLabel.setText(NO_PLAYER_SELECTED);
		}
		else
		{
			nameLabel.setText("Player: " + playerName);
		}
		SwingUtilities.invokeLater(() ->
			{
				equipmentPanels.removeAll();
				playerEquipment.forEach((kitType, itemComposition) ->
				{
					AsyncBufferedImage itemImage = itemManager.getImage(itemComposition.getId());
					equipmentPanels.add(new ItemPanel(itemComposition, kitType, itemImage), c);
					c.gridy++;

				});
				header.revalidate();
				header.repaint();
			}
		);
	}
}