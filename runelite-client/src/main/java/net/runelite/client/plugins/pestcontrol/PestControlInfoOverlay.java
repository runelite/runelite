/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  Copyright (c) 2017, Adam <Adam@sigterm.info>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
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
package net.runelite.client.plugins.pestcontrol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.LineImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QueryRunner;

@Slf4j
public class PestControlInfoOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final Client client;

	// Pest control game
	@Getter(AccessLevel.PACKAGE)
	private Game game;


	private final PanelComponent panelComponent = new PanelComponent();

	private static final Pattern PLAYERS_READY_PATTERN = Pattern.compile("<col=[a-z0-9A-Z]+>(.*)</col>");

	private final BufferedImage hpIcon;
	private final BufferedImage damageIcon;

	@Inject
	public PestControlInfoOverlay(QueryRunner queryRunner, Client client)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPriority(OverlayPriority.LOW);
		this.queryRunner = queryRunner;
		this.client = client;

		this.hpIcon = ImageUtil.getResourceStreamFromClass(PestControlPlugin.class, "knight_hp_icon.png");
		this.damageIcon = ImageUtil.getResourceStreamFromClass(PestControlPlugin.class, "damage_icon.png");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) == null)
		{

			Widget boatWidget = client.getWidget(WidgetInfo.PEST_CONTROL_BOAT_CONTAINER);
			if (boatWidget != null)
			{
				panelComponent.setPreferredSize(new Dimension(200, 100));
				boatWidget.setHidden(true);

				Widget departure = client.getWidget(WidgetInfo.PEST_CONTROL_BOAT_NEXT_DEPARTURE);
				Widget players = client.getWidget(WidgetInfo.PEST_CONTROL_BOAT_PLAYERS_READY);
				Widget points = client.getWidget(WidgetInfo.PEST_CONTROL_BOAT_PEST_POINTS);

				panelComponent.getChildren().add(LineImageComponent.builder()
					.right(hpIcon)
					.right("Text")
					.right(damageIcon)
					.build());

				panelComponent.getChildren().add(LineComponent.builder()
					.left(departure.getText())
					.build());

				Matcher matcher = PLAYERS_READY_PATTERN.matcher(players.getText());

				if (matcher.matches())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(matcher.group(1))
						.leftColor(Color.ORANGE)
						.build());
				}
				else
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(players.getText())
						.leftColor(Color.GREEN)
						.build());
				}

				panelComponent.getChildren().add(LineComponent.builder()
					.left(points.getText())
					.leftColor(Color.CYAN)
					.build());


				return panelComponent.render(graphics);
			}
		}
		else
		{
			Widget gameWidget = client.getWidget(WidgetInfo.PEST_CONTROL_INFO_CONTAINER);
			if (gameWidget != null)
			{
				panelComponent.setPreferredSize(new Dimension(65, 100));
				gameWidget.setHidden(true);

				Widget timeLeft = client.getWidget(WidgetInfo.PEST_CONTROL_TIME_LEFT);
				Widget knightHp = client.getWidget(WidgetInfo.PEST_CONTROL_KNIGHT_HP);
				Widget damage = client.getWidget(WidgetInfo.PEST_CONTROL_DAMAGE);

				panelComponent.getChildren().add(LineImageComponent.builder()
					.left(hpIcon)
					.right(knightHp.getText())
					.rightColor(new Color(knightHp.getTextColor()))
					.build());

				panelComponent.getChildren().add(LineImageComponent.builder()
					.left(damageIcon)
					.right(damage.getText())
					.build());

				panelComponent.getChildren().add(LineComponent.builder()
					.left(timeLeft.getText())
					.build());

				return panelComponent.render(graphics);
			}
		}

		return null;

	}
}
