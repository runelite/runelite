/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import net.runelite.client.ui.FontManager;

@Getter
class LootRecordPanel extends JPanel
{
	private LootRecord record;

	LootRecordPanel(LootRecord record, int gridy)
	{
		this.record = record;
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		final JLabel item_name = new JLabel("Item Name");
		final JLabel amount = new JLabel(String.valueOf(this.record.getAmount()));
		final JLabel icon = new JLabel();
		this.record.getIcon().addTo(icon);
		icon.setMinimumSize(new Dimension(36, 32));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(icon)
						.addComponent(item_name)
						.addGroup(layout.createSequentialGroup()
								.addGap(4)
								.addComponent(amount)
						)
				)
		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addComponent(icon)
						.addComponent(item_name)
						.addGroup(layout.createParallelGroup()
								.addComponent(amount)
						)
				)
		);
	}
}