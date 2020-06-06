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

import com.google.common.primitives.Ints;
import net.runelite.client.config.*;

import javax.swing.*;
import java.awt.*;

class ConfigItemSpinner extends JSpinner
{
	private static final int SPINNER_FIELD_WIDTH = 6;
	private final ConfigManager configManager;

	public ConfigItemSpinner(ConfigManager configManager, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		this.configManager = configManager;

		int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));

		Range range = cid.getRange();
		int min = 0, max = Integer.MAX_VALUE;
		if (range != null)
		{
			min = range.min();
			max = range.max();
		}

		// Config may previously have been out of range
		value = Ints.constrainToRange(value, min, max);

		SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
		this.setModel(model);
		Component editor = this.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
		this.addChangeListener(ce -> changeConfiguration(cd, cid));

		Units units = cid.getUnits();
		if (units != null)
		{
			spinnerTextField.setFormatterFactory(new UnitFormatterFactory(units));
		}
	}

	public void changeConfiguration(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + this.getValue());
	}
}
