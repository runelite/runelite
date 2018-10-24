/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.theatreofblood;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.theatreofblood.data.Attempt;
import net.runelite.client.plugins.theatreofblood.data.AttemptTotal;
import net.runelite.client.plugins.theatreofblood.data.RoomStat;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;


@Slf4j
public class StatOverlay extends Overlay
{
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();
	private final TheatreOfBloodPlugin plugin;

	private AttemptTotal total;

	@Inject
	StatOverlay(Client client, TheatreOfBloodPlugin plugin)
	{
		setPosition(OverlayPosition.BOTTOM_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;

		calculateTotal();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		int state = client.getVar(Varbits.THEATRE_OF_BLOOD);
		Attempt current = plugin.getCurrent();
		RoomStat room = plugin.getRoom();

		// Only display if in a party
		if (state >= 1)
		{
			reset();
			graphics.setColor(Color.WHITE);

			LayoutableRenderableEntity title = LineComponent.builder().left("ToB Session Stats").build();
			add(title);

			if (room != null)
			{
				LayoutableRenderableEntity room_title = LineComponent.builder().left("Current Room").build();
				LayoutableRenderableEntity room_dealt = LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(room.getDamageDealt()))).build();
				LayoutableRenderableEntity room_taken = LineComponent.builder().left("Dmg Taken").right(String.valueOf(room.getDamageTaken())).build();
				LayoutableRenderableEntity room_died = LineComponent.builder().left("Died").right(String.valueOf(room.isDied())).build();
				add(room_title);
				add(room_dealt);
				add(room_taken);
				add(room_died);
			}


			LayoutableRenderableEntity spacer = LineComponent.builder().left("Current Raid").build();
			LayoutableRenderableEntity dealt = LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(current.getDamageDealt()))).build();
			LayoutableRenderableEntity taken = LineComponent.builder().left("Dmg Taken").right(String.valueOf(current.getDamageTaken())).build();
			LayoutableRenderableEntity deaths = LineComponent.builder().left("Deaths").right(String.valueOf(current.getDeathCount())).build();
			add(spacer);
			add(dealt);
			add(taken);
			add(deaths);

			LayoutableRenderableEntity spacer2 = LineComponent.builder().left("Overall Totals").build();
			LayoutableRenderableEntity totalDealt = LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(total.getDamageDealt() + current.getDamageDealt()))).build();
			LayoutableRenderableEntity totalTaken = LineComponent.builder().left("Dmg Taken").right(String.valueOf(total.getDamageTaken() + current.getDamageTaken())).build();
			LayoutableRenderableEntity totalDeaths = LineComponent.builder().left("Deaths").right(String.valueOf((total.getDeathCount() + current.getDeathCount()))).build();
			String successRateText = String.valueOf(total.getCompletions()) + "/" + String.valueOf(total.getAttempts());
			LayoutableRenderableEntity successRate = LineComponent.builder().left("Fin/Att").right(successRateText).build();
			add(spacer2);
			add(totalDealt);
			add(totalTaken);
			add(totalDeaths);
			add(successRate);
		}

		return panelComponent.render(graphics);
	}

	private void add(LayoutableRenderableEntity a)
	{
		panelComponent.getChildren().add(a);
	}

	void calculateTotal()
	{
		List<Attempt> attempts = plugin.getAttempts();
		total = new AttemptTotal(attempts);
	}

	public void reset()
	{
		panelComponent.getChildren().clear();
	}
}
