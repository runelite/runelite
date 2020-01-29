/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.tmorph.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.tmorph.TMorph;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.ComboBoxIconEntry;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;
import org.pushingpixels.substance.internal.utils.SubstanceDropDownButton;

@Getter
public class EquipSlot extends JComboBox<ComboBoxIconEntry>
{
	private final ComboBoxIconEntry original;
	private Map<Integer, ComboBoxIconEntry> boxMap;
	private KitType kitType;

	EquipSlot(KitType kitType)
	{
		super();
		this.kitType = kitType;
		this.boxMap = new LinkedHashMap<>();
		setPreferredSize(new Dimension(200, 42));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setRenderer(new ComboBoxListRenderer());
		original = new ComboBoxIconEntry(
			new ImageIcon(ImageUtil.getResourceStreamFromClass(TMorph.class, kitType.getName().toLowerCase() + ".png")),
			kitType.getName(),
			null
		);
		addItem(original);
		setSelectedIndex(0);
		for (Component component : getComponents())
		{
			if (component instanceof SubstanceDropDownButton)
			{
				remove(component);
			}
		}
	}

	public void populate(Client client, ItemManager itemManager)
	{
		assert client.isClientThread() : "Populate must be called on client thread";

		for (int i = 0; i < client.getItemCount(); i++)
		{
			ItemStats stats = itemManager.getItemStats(i, false);

			if (stats == null)
			{
				continue;
			}

			if (!stats.isEquipable())
			{
				continue;
			}

			ItemEquipmentStats equipment = stats.getEquipment();

			if (equipment == null)
			{
				continue;
			}

			if (equipment.getSlot() != kitType.getIndex())
			{
				continue;
			}

			AsyncBufferedImage image = itemManager.getImage(i);

			if (image == null)
			{
				continue;
			}

			final ComboBoxIconEntry entry = new ComboBoxIconEntry(
				new ImageIcon(image),
				client.getItemDefinition(i).getName(),
				client.getItemDefinition(i)
			);
			boxMap.put(i, entry);
			addItem(entry);
		}
	}
}
