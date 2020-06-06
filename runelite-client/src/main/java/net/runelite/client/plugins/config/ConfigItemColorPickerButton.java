/*
 * Copyright (c) 2020, Copy Pasta <https://github.com/CopyPastaOSRS>
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
package net.runelite.client.plugins.config;

import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.config.ConfigPanel;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ConfigItemColorPickerButton extends JButton
{
	private final ConfigManager configManager;

	public ConfigItemColorPickerButton(ConfigManager configManager, ConfigDescriptor cd, ConfigItemDescriptor cid,
			ColorPickerManager colorPickerManager, ConfigPanel configPanel)
	{
		this.configManager = configManager;

		Color existingColor;
		JButton colorPickerBtn = this;

		String existing = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());
		if (existing == null)
		{
			existingColor = Color.BLACK;
			colorPickerBtn.setText("Pick a color");
		}
		else
		{
			existingColor = ColorUtil.fromString(existing);
			colorPickerBtn.setText(ColorUtil.toHexColor(existingColor).toUpperCase());
		}

		colorPickerBtn.setFocusable(false);
		colorPickerBtn.setBackground(existingColor);
		colorPickerBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RuneliteColorPicker colorPicker = colorPickerManager.create(
						SwingUtilities.windowForComponent(configPanel),
						colorPickerBtn.getBackground(),
						cid.getItem().name(),
						cid.getAlpha() == null);
				colorPicker.setLocation(getLocationOnScreen());
				colorPicker.setOnColorChange(c ->
				{
					colorPickerBtn.setBackground(c);
					colorPickerBtn.setText(ColorUtil.toHexColor(c).toUpperCase());
				});
				colorPicker.setOnClose(c -> changeConfiguration(colorPicker, cd, cid));
				colorPicker.setVisible(true);
			}
		});
	}

	public void changeConfiguration(RuneliteColorPicker colorPicker, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), colorPicker.getSelectedColor().getRGB() + "");
	}
}
