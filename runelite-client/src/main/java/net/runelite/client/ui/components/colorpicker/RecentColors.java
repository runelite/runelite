/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.ui.components.colorpicker;

import com.google.common.collect.EvictingQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.JPanel;
import net.runelite.client.config.ConfigManager;
import static net.runelite.client.ui.components.colorpicker.RuneliteColorPicker.CONFIG_GROUP;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

final class RecentColors
{
	private static final String CONFIG_KEY = "recentColors";
	private static final int MAX = 16;
	private static final int BOX_SIZE = 16;

	private final EvictingQueue<String> recentColors = EvictingQueue.create(MAX);
	private final ConfigManager configManager;

	RecentColors(final ConfigManager configManager)
	{
		this.configManager = configManager;
	}

	private void load()
	{
		String str = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY);
		if (str != null)
		{
			recentColors.addAll(Text.fromCSV(str));
		}
	}

	void add(final String color)
	{
		if (ColorUtil.fromString(color) == null)
		{
			return;
		}

		recentColors.remove(color);
		recentColors.add(color);

		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, Text.toCSV(recentColors));
	}

	JPanel build(final Consumer<Color> consumer, final boolean alphaHidden)
	{
		load();

		JPanel container = new JPanel(new GridBagLayout());

		GridBagConstraints cx = new GridBagConstraints();
		cx.insets = new Insets(0, 1, 4, 2);
		cx.gridy = 0;
		cx.gridx = 0;
		cx.anchor = GridBagConstraints.WEST;

		for (String s : recentColors)
		{
			if (cx.gridx == MAX / 2)
			{
				cx.gridy++;
				cx.gridx = 0;
			}

			// Make sure the last element stays in line with all of the others
			if (container.getComponentCount() == recentColors.size() - 1)
			{
				cx.weightx = 1;
				cx.gridwidth = MAX / 2 - cx.gridx;
			}

			container.add(createBox(ColorUtil.fromString(s), consumer, alphaHidden), cx);
			cx.gridx++;
		}

		return container;
	}

	private static JPanel createBox(final Color color, final Consumer<Color> consumer, final boolean alphaHidden)
	{
		final JPanel box = new JPanel();
		String hex = alphaHidden ? ColorUtil.colorToHexCode(color) : ColorUtil.colorToAlphaHexCode(color);

		box.setBackground(color);
		box.setOpaque(true);
		box.setPreferredSize(new Dimension(BOX_SIZE, BOX_SIZE));
		box.setToolTipText("#" + hex.toUpperCase());
		box.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				consumer.accept(color);
			}
		});

		return box;
	}
}
