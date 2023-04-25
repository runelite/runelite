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
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.timetracking.ContractStateText;
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
		if (config.farmingContractInfoBoxStateText() == ContractStateText.NEVER)
		{
			return null;
		}

		return getInfoboxInfo().getShortDescription();
	}

	@Override
	public Color getTextColor()
	{
		if (config.farmingContractInfoBoxStateText() == ContractStateText.NEVER)
		{
			return null;
		}

		return getInfoboxInfo().getShortColor();
	}

	@Override
	public String getTooltip()
	{
		SummaryInfo info = getInfoboxInfo();

		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Farming Contract", Color.WHITE));
		sb.append("</br>");
		sb.append(ColorUtil.wrapWithColorTag(contract.getName(), info.getTooltipColor()));

		if (info.getTooltipDescription() != null)
		{
			sb.append("</br>");
			sb.append(ColorUtil.wrapWithColorTag(info.getTooltipDescription(), info.getTooltipColor()));
		}

		return sb.toString();
	}

	@Override
	public boolean render()
	{
		return config.farmingContractInfoBox();
	}

	@Value
	@Builder
	private static class SummaryInfo
	{
		String tooltipDescription;
		String shortDescription;
		Color tooltipColor;
		Color shortColor;
	}

	private SummaryInfo getInfoboxInfo()
	{
		SummaryState summary = manager.getSummary();

		Color tooltipColor;
		Color shortColor;
		String tooltipDescription;
		String shortDescription;
		switch (summary)
		{
			case COMPLETED:
				tooltipDescription = shortDescription = "Ready";
				tooltipColor = shortColor = ColorScheme.PROGRESS_COMPLETE_COLOR;
				break;
			case OCCUPIED:
				tooltipDescription = "Occupied";
				shortDescription = "Occ.";
				tooltipColor = shortColor = ColorScheme.PROGRESS_ERROR_COLOR;
				break;
			case IN_PROGRESS:
				CropState cropState = manager.getContractCropState();
				switch (cropState)
				{
					case DISEASED:
						tooltipDescription = "Diseased";
						shortDescription = "Dis.";
						tooltipColor = shortColor = cropState.getColor();
						break;
					case DEAD:
						tooltipDescription = shortDescription = "Dead";
						tooltipColor = shortColor = cropState.getColor();
						break;
					default:
						long remainingSeconds = manager.getCompletionTime() - Instant.now().getEpochSecond();
						tooltipDescription = "Ready " + TabContentPanel.getFormattedEstimate(remainingSeconds, config.timeFormatMode());

						switch (config.farmingContractInfoBoxStateText())
						{
							case GROWTH_STAGES:
								// Stages are 0-indexed
								shortDescription = (manager.getContractCropStage() + 1) + "/" + contract.getStages();
								break;
							case TIME_REMAINING:
								int remainingMinutes = (int) ((remainingSeconds + 59) / 60);
								if (remainingMinutes < 60)
								{
									shortDescription = Math.max(remainingMinutes, 0) + "m";
								}
								else
								{
									shortDescription = String.format("%d:%02d",
										remainingMinutes / 60,
										remainingMinutes % 60);
								}
								break;
							default:
								shortDescription = null;
								break;
						}
						tooltipColor = Color.GRAY;
						shortColor = Color.WHITE;
						break;
				}
				break;
			case EMPTY:
				tooltipDescription = null;
				shortDescription = "Empty";
				tooltipColor = Color.GRAY;
				shortColor = ColorScheme.PROGRESS_INPROGRESS_COLOR;
				break;
			case UNKNOWN:
			default:
				tooltipDescription = null;
				shortDescription = "Unk.";
				tooltipColor = Color.GRAY;
				shortColor = Color.LIGHT_GRAY;
				break;
		}

		return SummaryInfo.builder()
			.tooltipDescription(tooltipDescription)
			.tooltipColor(tooltipColor)
			.shortDescription(shortDescription)
			.shortColor(shortColor)
			.build();
	}
}
