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

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;

@Getter
class LootRecordPanel extends JPanel
{
	private LootRecord record;

	LootRecordPanel(LootRecord record)
	{
		this.record = record;

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		JPanel panel = new JPanel();

		JLabel icon = new JLabel();
		this.record.getIcon().addTo(icon);
		JLabel item_name = new JLabel(this.record.getItem_name());
		JLabel amount = new JLabel(String.valueOf(this.record.getAmount()));



		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(icon)
				.addGroup(layout.createSequentialGroup()
						.addComponent(item_name)
						.addComponent(amount)
				)
		);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(icon)
				.addGap(8)
				.addGroup(layout.createParallelGroup()
						.addComponent(item_name)
						.addComponent(amount)
				)
		);

		setComponentZOrder(icon, getComponentCount() - 1);
	}
}