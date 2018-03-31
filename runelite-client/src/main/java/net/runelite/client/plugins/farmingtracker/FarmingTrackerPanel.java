/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.Objects;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import net.runelite.client.plugins.farmingtracker.data.PatchType;
import net.runelite.client.ui.PluginPanel;

class FarmingTrackerPanel extends PluginPanel
{
	private final String BTN_CONTAINER = "BTN_CONTAINER";

	private JPanel panel;
	private ButtonGroup patchBtnGroup;

	FarmingTrackerPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 5));

		add(panel);
	}

	void initPanel()
	{
		JPanel buttonContainer = new JPanel();
		buttonContainer.setName(BTN_CONTAINER);
		buttonContainer.setLayout(new GridLayout(0, 4, 3, 3));

		patchBtnGroup = new ButtonGroup();

		for (PatchType patchType : PatchType.values())
		{
			buttonContainer.add(createPatchTypeButton(patchType));
		}

		panel.add(buttonContainer, BorderLayout.NORTH);
	}

	private JToggleButton createPatchTypeButton(PatchType patchType)
	{
		JToggleButton farmingPatchBtn = new JToggleButton(patchType.getShortName());
		farmingPatchBtn.addActionListener(e -> switchTypeInfoView(patchType));

		farmingPatchBtn.setFocusPainted(false);
		farmingPatchBtn.setActionCommand(patchType.getFullName());
		farmingPatchBtn.setToolTipText(patchType.getFullName());

		patchBtnGroup.add(farmingPatchBtn);

		return farmingPatchBtn;
	}

	private void switchTypeInfoView(PatchType patchType)
	{
		for (Component component : panel.getComponents())
		{
			if (Objects.equals(component.getName(), BTN_CONTAINER))
			{
				continue;
			}

			panel.remove(component);
		}

		highlightButton(patchType);

		panel.revalidate();
		panel.repaint();
	}

	private void highlightButton(PatchType patchType)
	{
		for (Enumeration<AbstractButton> buttons = patchBtnGroup.getElements(); buttons.hasMoreElements(); )
		{
			AbstractButton button = buttons.nextElement();

			if (button.getActionCommand().equals(patchType.getFullName()))
			{
				button.setSelected(true);
				button.setBackground(Color.GREEN);
			}
			else
			{
				button.setSelected(false);
				button.setBackground(null);
			}
		}
	}
}
