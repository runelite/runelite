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
package net.runelite.client.plugins.farmingtracker.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.Getter;
import net.runelite.client.plugins.farmingtracker.FarmingTimer;
import net.runelite.client.plugins.farmingtracker.data.PatchLocation;
import net.runelite.client.plugins.farmingtracker.data.PatchRowData;
import net.runelite.client.plugins.farmingtracker.data.PatchType;
import net.runelite.client.plugins.farmingtracker.data.Seed;
import net.runelite.client.plugins.farmingtracker.data.SeedStatus;

public class PatchList extends JPanel
{
	@Getter
	private final JPanel container = new JPanel();

	@Getter
	private final Map<String, PatchRow> patchRows = new HashMap<>();

	public PatchList(PatchType patchType, BufferedImage bufferedImage)
	{
		GridBagLayout gridBag = new GridBagLayout();
		container.setLayout(gridBag);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;

		JLabel selectedPatchTypeLbl = new JLabel(patchType.getFullName());
		selectedPatchTypeLbl.setHorizontalAlignment(JLabel.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.insets = new Insets(0, 0, 10, 0);

		gridBag.setConstraints(selectedPatchTypeLbl, gbc);
		container.add(selectedPatchTypeLbl);

		int gridY = 1;
		for (PatchLocation patchLocation : PatchLocation.findByPatchType(patchType))
		{
			gbc.gridx = 0;
			gbc.gridy = gridY;
			gbc.insets = new Insets(0, 0, 0, 0);

			final PatchRow patchRow = new PatchRow(container, gridBag, gbc, patchLocation, bufferedImage);
			patchRows.put(patchLocation.name(), patchRow);

			gridY++;
		}

		add(container);
	}

	public void setPlanted(PatchLocation patchLocation, BufferedImage bufferedImage, PatchRowData patchRowData)
	{
		final PatchRow patchRow = patchRows.get(patchLocation.name());

		patchRow.setPatchRowData(patchRowData);

		patchRow.setPlanted(bufferedImage);
	}

	public void setCleared(PatchLocation patchLocation, BufferedImage bufferedImage)
	{
		final PatchRow patchRow = patchRows.get(patchLocation.name());

		patchRow.setPatchRowData(null);

		patchRow.setCleared(bufferedImage);
	}

	public void updateRemainingTime(PatchLocation patchLocation, int epoch)
	{
		final PatchRow patchRow = patchRows.get(patchLocation.name());

		PatchRowData patchRowData = patchRow.getPatchRowData();

		if (patchRowData == null)
		{
			return;
		}

		if (patchRowData.getSeedStatus().equals(SeedStatus.ALIVE))
		{
			Seed seed = patchRowData.getSeed();
			String remainingTime = FarmingTimer.getGrowthTimeLeft(epoch, seed.getFarmingTick().getTick(), patchRowData.getStagesLeft());

			patchRowData.setTimeLeft(remainingTime);
		}

		patchRow.updateRemainingTime();
	}
}
