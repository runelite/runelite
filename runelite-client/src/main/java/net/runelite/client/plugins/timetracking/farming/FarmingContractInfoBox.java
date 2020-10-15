/*
 * Copyright (c) 2019, Koekkruimels <https://github.com/koekkruimels>
 * Copyright (c) 2020, melky <https://github.com/melkypie>
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
package net.runelite.client.plugins.timetracking.farming;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Instant;
import lombok.Getter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.TabContentPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.util.ColorUtil;

class FarmingContractInfoBox extends InfoBox
{
	@Getter
	private final Produce contract;
	private final FarmingContractManager manager;
	private final TimeTrackingConfig config;

	FarmingContractInfoBox(BufferedImage image, Plugin plugin, Produce contract, TimeTrackingConfig config, FarmingContractManager manager)
	{
		super(image, plugin);
		this.contract = contract;
		this.config = config;
		this.manager = manager;
	}

	@Override
	public String getText()
	{
		return null;
	}

	@Override
	public Color getTextColor()
	{
		return null;
	}

	@Override
	public String getTooltip()
	{
		SummaryState summary = manager.getSummary();

		Color contractColor;
		String contractDescription;
		switch (summary)
		{
			case COMPLETED:
				contractDescription = "Ready";
				contractColor = ColorScheme.PROGRESS_COMPLETE_COLOR;
				break;
			case OCCUPIED:
				contractDescription = "Occupied";
				contractColor = ColorScheme.PROGRESS_ERROR_COLOR;
				break;
			case IN_PROGRESS:
				CropState cropState = manager.getContractCropState();
				switch (cropState)
				{
					case DISEASED:
						contractDescription = "Diseased";
						contractColor = cropState.getColor();
						break;
					case DEAD:
						contractDescription = "Dead";
						contractColor = cropState.getColor();
						break;
					default:
						contractDescription = "Ready " + TabContentPanel.getFormattedEstimate(manager.getCompletionTime() - Instant.now().getEpochSecond(),
							config.timeFormatMode());
						contractColor = Color.GRAY;
						break;
				}
				break;
			case EMPTY:
			case UNKNOWN:
			default:
				contractDescription = null;
				contractColor = Color.GRAY;
				break;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Farming Contract", Color.WHITE));
		sb.append("</br>");
		sb.append(ColorUtil.wrapWithColorTag(contract.getName(), contractColor));

		if (contractDescription != null)
		{
			sb.append("</br>");
			sb.append(ColorUtil.wrapWithColorTag(contractDescription, contractColor));
		}

		return sb.toString();
	}

	@Override
	public boolean render()
	{
		return config.farmingContractInfoBox();
	}
}
