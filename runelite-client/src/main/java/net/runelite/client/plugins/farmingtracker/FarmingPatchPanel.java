/*
 * Copyright (c) 2018 Abex
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

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import lombok.Getter;
import net.runelite.client.ui.FontManager;

@Getter
class FarmingPatchPanel extends JPanel
{
	private final FarmingPatch patch;
	private final JLabel icon = new JLabel();
	private final JLabel estimate = new JLabel();
	private final JProgressBar progress = new JProgressBar();

	FarmingPatchPanel(FarmingPatch patch)
	{
		this.patch = patch;

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		final JLabel location = new JLabel(patch.getRegion().getName() + " " + patch.getName());
		location.setFont(FontManager.getRunescapeSmallFont());
		icon.setMinimumSize(new Dimension(36, 32));

		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(icon)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addComponent(location)
					.addGap(1)
					.addComponent(estimate)
				)
			)
			.addComponent(progress, 8, 8, 8)
			.addGap(4)
		);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
				.addComponent(icon)
				.addGroup(layout.createParallelGroup()
					.addComponent(location)
					.addComponent(estimate)
				)
			)
			.addComponent(progress)
		);
	}
}
