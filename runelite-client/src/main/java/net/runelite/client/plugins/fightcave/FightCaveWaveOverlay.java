/*
 * Copyright (c) 2018, DrizzyBot <https://github.com/drizzybot>
 * Copyright (c) 2018, DaveInga <https://github.com/daveinga>
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class FightCaveWaveOverlay extends Overlay
{

	private final Client client;

	private final FightCavePlugin plugin;

	private final FightCaveConfig config;

	private PanelComponent panelComponent;

	@Inject
	FightCaveWaveOverlay(Client client, FightCavePlugin plugin, FightCaveConfig config)
	{
		panelComponent = new PanelComponent();
		panelComponent.setPreferredSize(new Dimension(150, 0));
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInFightCaveInstance() || plugin.getCurrentWaveNumber() == 0)
		{
			return null;
		}
		panelComponent.getChildren().clear();

		if (config.showCurrentWave())
		{
			renderWave("Wave " + plugin.getCurrentWaveNumber(),plugin.getThisWave(),plugin.getMonsters());
		}
		if (config.showNextWave() && plugin.isNotFinalWave())
		{
			renderWave("Next Wave:",plugin.getNextWave(),plugin.getMonsters());

		}
		return panelComponent.render(graphics);
	}

	private void renderWave(String header, Map<Integer,Integer> waveMap, Map<Integer,String> nameMap)
	{
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(header)
			.color(config.getWaveOverlayHeaderColor())
			.build());

		for (Map.Entry<Integer, Integer> entry : waveMap.entrySet())
		{
			int monsterID = entry.getKey();
			int quantity = entry.getValue();
			if (quantity <= 0)
			{
				continue;
			}
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(quantity + "x " + nameMap.get(monsterID))
				.color(config.getWaveTextColor())
				.build());
		}
	}
}
