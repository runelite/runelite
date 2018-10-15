/*
 * Copyright (c) 2018, DrizzyBot <https://github.com/drizzybot>
 *               2018, DaveInga <https://github.com/daveinga>
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

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Slf4j
public class FightCaveWaveOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private FightCavePlugin plugin;

	@Inject
	private FightCaveConfig config;

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
			renderCurrentWave();
		}
		if (config.showNextWave() && plugin.getCurrentWaveNumber() <= 62)
		{
			renderNextWave();
		}
		return panelComponent.render(graphics);
	}

	private void renderCurrentWave()
	{
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Wave " + plugin.getCurrentWaveNumber())
			.color(Color.orange)
			.build());
		for (Map.Entry<Integer, Integer> entry : plugin.getThisWave().entrySet())
		{
			int monsterID = entry.getKey();
			int quantity = entry.getValue();
			if (quantity <= 0)
			{
				continue;
			}

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(quantity + "x " + plugin.getMonsters().get(monsterID))
				.color(Color.white)
				.build());
		}
	}

	private void renderNextWave()
	{
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Next Wave:")
			.color(Color.orange)
			.build());
		for (Map.Entry<Integer, Integer> entry : plugin.getNextWave().entrySet())
		{
			int monsterID = entry.getKey();
			int quantity = entry.getValue();
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(quantity + "x " + plugin.getMonsters().get(monsterID))
				.color(Color.white)
				.build());
		}
	}
}
