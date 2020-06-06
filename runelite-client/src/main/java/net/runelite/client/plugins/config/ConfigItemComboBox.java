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

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.util.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

@Slf4j
class ConfigItemComboBox extends JComboBox
{
	private final ConfigManager configManager;

	public ConfigItemComboBox(ConfigManager configManager, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		this.configManager = configManager;

		Class<? extends Enum> type = (Class<? extends Enum>) cid.getType();
		this.setModel(new DefaultComboBoxModel(type.getEnumConstants()));
		this.setPreferredSize(new Dimension(this.getPreferredSize().width, 25));
		this.setRenderer(new ComboBoxListRenderer());
		this.setForeground(Color.WHITE);
		this.setFocusable(false);
		this.setPrototypeDisplayValue("XXXXXXXX"); //sorry but this is the way to keep the size of the combobox in check.
		try
		{
			Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
			this.setSelectedItem(selectedItem);
			this.setToolTipText(Text.titleCase(selectedItem));
		}
		catch (IllegalArgumentException ex)
		{
			log.debug("Invalid selected item", ex);
		}
		this.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				changeConfiguration(cd, cid);
				this.setToolTipText(Text.titleCase((Enum) this.getSelectedItem()));
			}
		});
	}

	public void changeConfiguration(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), ((Enum) this.getSelectedItem()).name());
	}
}
