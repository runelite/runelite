/*
 * Copyright (c) 2018, PallasDieKatze (Pallas Cat)
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
package net.runelite.client.plugins.raids.bombs;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raids.RaidsConfig;
import net.runelite.client.plugins.raids.RaidsPlugin;
import net.runelite.client.ui.overlay.*;
import javax.inject.Inject;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class BombOverlay extends Overlay
{

	public enum Normal_Color
	{
		SAFE("#00cc00"), //safe
		CAUTION("#ffff00"), //1 tile in range (minor damage)
		WARNING("#ff9933"), //2 tiles in range (moderate damage)
		DANGER("#ff6600"), //3 tiles in range/adjacent to bomg (major damage)
		LETHAL("#cc0000"); //On the bomb, using it as a makeshift space launch vehicle. (massive damage)

		private String hex;

		Normal_Color(String hex_value)
		{
			this.hex = hex_value;
		}

		public Color getColor()
		{
			return Color.decode(hex);
		}
	}

	private static final int BOMB_AOE = 7;
	private static final int BOMB_DETONATE_TIME = 8; //This is in ticks. It should be 10, but it varies from 8 to 11.
	private static final double ESTIMATED_TICK_LENGTH = .6; //Thank you Woox & co. for this assumption. .6 seconds/tick.


	//Utilized from the npc highlight code for formatting text being displayed on the client canvas.
	private static final NumberFormat TIME_LEFT_FORMATTER =
			DecimalFormat.getInstance(Locale.US);

	static
	{
		((DecimalFormat) TIME_LEFT_FORMATTER).applyPattern("#0.0");
	}

	private final Client client;
	private final RaidsConfig config;
	private final RaidsPlugin plugin;

	@Inject
	public BombOverlay(Client client, RaidsPlugin plugin, RaidsConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		drawBombs(graphics);
		return null;
	}

	private void drawBombs(Graphics2D graphics) //I can condense drawDangerZone into this. Ambivalent though.
	{
		Iterator<Map.Entry<WorldPoint, CrystalBomb>> it = plugin.getBombs().entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<WorldPoint, CrystalBomb> entry = it.next();
			CrystalBomb bomb = entry.getValue();

			if (!config.bombDisplay())
			{
				return;
			}

			switch (bomb.getState())
			{
				case ACTIVE:
					drawDangerZone(graphics, bomb);
					break;
			}
		}
	}

	private void drawDangerZone(Graphics2D graphics, CrystalBomb bomb)
	{
		final Player localPlayer = client.getLocalPlayer();
		LocalPoint localLoc = LocalPoint.fromWorld(client, bomb.getWorldLocation());
		double distance_x = Math.abs(bomb.getWorldLocation().getX() - localPlayer.getWorldLocation().getX());
		double distance_y = Math.abs(bomb.getWorldLocation().getY() - localPlayer.getWorldLocation().getY());
		Color color_code = Normal_Color.SAFE.getColor(); //defaults to this unless conditionals met below.

		if (distance_x < 1 && distance_y < 1)
		{
			color_code = Normal_Color.LETHAL.getColor();
		}
		else if (distance_x < 2 && distance_y < 2)
		{
			color_code = Normal_Color.DANGER.getColor();
		}
		else if (distance_x < 3 && distance_y < 3)
		{
			color_code = Normal_Color.WARNING.getColor();
		}
		else if (distance_x < 4 && distance_y < 4)
		{
			color_code = Normal_Color.CAUTION.getColor();
		}
		LocalPoint CenterPoint = new LocalPoint(localLoc.getX() + 0, localLoc.getY() + 0);
		Polygon poly = Perspective.getCanvasTileAreaPoly(client, CenterPoint, BOMB_AOE);

		if (poly != null)
		{
//manually generating the polygon so as to assign a custom alpha value. Request adtl' arg for alpha maybe?
			graphics.setColor(color_code);
			graphics.setStroke(new BasicStroke(1));
			graphics.drawPolygon(poly);
			graphics.setColor(new Color(0, 0, 0, 10));
			graphics.fillPolygon(poly);
		}

		Instant now = Instant.now();
		double timeLeft = ((BOMB_DETONATE_TIME - bomb.getTicksAlive()) * ESTIMATED_TICK_LENGTH) -
				(now.toEpochMilli() - bomb.getLastClockUpdate().toEpochMilli()) / 1000.0;
//divided by 1000.00 because of milliseconds :)
//log.info("Current timeLeft value: {} .", bomb.getTicksAlive());

		timeLeft = Math.max(0.0, timeLeft);
		String bombTimerString = TIME_LEFT_FORMATTER.format(timeLeft);
		int textWidth = graphics.getFontMetrics().stringWidth(bombTimerString);
		int textHeight = graphics.getFontMetrics().getAscent();
		Point canvasPoint = Perspective.worldToCanvas(client, localLoc.getX(),
				localLoc.getY(), bomb.getWorldLocation().getPlane());

		if (canvasPoint != null)
		{
			Point canvasCenterPoint = new Point(
					canvasPoint.getX() - textWidth / 2,
					canvasPoint.getY() + textHeight / 2);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, bombTimerString, color_code);
		}

	}

}
