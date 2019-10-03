/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.fightcave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
class WaveOverlay extends Overlay
{
	private static final Color HEADER_COLOR = ColorScheme.BRAND_BLUE;

	private final FightCaveConfig config;
	private final FightCavePlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private WaveOverlay(final FightCaveConfig config, final FightCavePlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_RIGHT);
	}

	private static Collection<String> buildWaveLines(final Map<WaveMonster, Integer> wave)
	{
		final List<Map.Entry<WaveMonster, Integer>> monsters = new ArrayList<>(wave.entrySet());
		monsters.sort(Map.Entry.comparingByKey());
		final List<String> outputLines = new ArrayList<>();

		for (Map.Entry<WaveMonster, Integer> monsterEntry : monsters)
		{
			final WaveMonster monster = monsterEntry.getKey();
			final int quantity = monsterEntry.getValue();
			final String line = FightCavePlugin.formatMonsterQuantity(monster, quantity);

			outputLines.add(line);
		}

		return outputLines;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isValidRegion() || plugin.getCurrentWave() < 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		final int currentWave = plugin.getCurrentWave();
		final int waveIndex = currentWave - 1;

		if (config.waveDisplay() == WaveDisplayMode.CURRENT
			|| config.waveDisplay() == WaveDisplayMode.BOTH)
		{
			final Map<WaveMonster, Integer> waveContents = FightCavePlugin.getWAVES().get(waveIndex);

			addWaveInfo("Wave " + plugin.getCurrentWave(), waveContents);
		}

		if ((config.waveDisplay() == WaveDisplayMode.NEXT
			|| config.waveDisplay() == WaveDisplayMode.BOTH)
			&& currentWave != FightCavePlugin.MAX_WAVE)
		{
			final Map<WaveMonster, Integer> waveContents = FightCavePlugin.getWAVES().get(waveIndex + 1);

			addWaveInfo("Next wave", waveContents);
		}

		return panelComponent.render(graphics);
	}

	private void addWaveInfo(final String headerText, final Map<WaveMonster, Integer> waveContents)
	{
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(headerText)
			.color(HEADER_COLOR)
			.build());


		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.CENTER);

		for (String line : buildWaveLines(waveContents))
		{
			tableComponent.addRow(line);
		}

		if (!tableComponent.isEmpty())
		{
			panelComponent.getChildren().add(tableComponent);
		}
	}
}
