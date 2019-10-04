/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.pyramidplunder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ObjectDefinition;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.CLOSED_DOOR;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.OPENED_DOOR;
import static net.runelite.client.plugins.pyramidplunder.PyramidPlunderPlugin.TRAP;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
public class PyramidPlunderOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2400;
	private static final Color COLOR_DOOR = Color.GREEN;
	private static final Color COLOR_SPEAR_TRAP = Color.ORANGE;

	private final Client client;
	private final PyramidPlunderPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	private static final int MAX_TICK_COUNT = 500;
	private static final double TICK_LENGTH = 0.6;

	private static final NumberFormat TIME_LEFT_FORMATTER = DecimalFormat.getInstance(Locale.US);

	static
	{
		((DecimalFormat) TIME_LEFT_FORMATTER).applyPattern("#0.0");
	}

	@Inject
	private PyramidPlunderOverlay(final Client client, final PyramidPlunderPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInGame())
		{
			return null;
		}

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();

		for (Map.Entry<TileObject, Tile> entry : plugin.getHighlighted().entrySet())
		{
			TileObject object = entry.getKey();
			Tile tile = entry.getValue();

			if (tile.getPlane() == client.getPlane() &&
				object.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				int objectID = object.getId();
				if (object.getId() == CLOSED_DOOR || object.getId() == OPENED_DOOR)
				{
					//Impostor
					ObjectDefinition comp = client.getObjectDefinition(objectID);
					ObjectDefinition impostor = comp.getImpostor();

					if (impostor == null)
					{
						continue;
					}
					objectID = impostor.getId();
				}

				Shape objectClickbox = object.getClickbox();
				if (objectClickbox != null)
				{
					Color configColor = Color.GREEN;
					switch (objectID)
					{
						case TRAP:
							configColor = COLOR_SPEAR_TRAP;
							break;
						case OPENED_DOOR: // Does this need a overlay?
						case CLOSED_DOOR:
							configColor = COLOR_DOOR;
							break;
					}

					OverlayUtil.renderClickBox(graphics, mousePosition, objectClickbox, configColor);
				}
			}
		}

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		if (plugin.isShowPlunderStatus())
		{
			final Widget widget = client.getWidget(WidgetInfo.PYRAMID_PLUNDER_DATA);
			if (widget == null)
			{
				return null;
			}

			toggleDefaultWidget(plugin.isHideWidget());

			panelComponent.getChildren().clear();

			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Pyramid Plunder")
				.build());

			//Calculate time based on current pp timer tick
			final int currentTick = client.getVar(Varbits.PYRAMID_PLUNDER_TIMER);
			final double baseTick = (MAX_TICK_COUNT - currentTick) * TICK_LENGTH;
			final double timeLeft = Math.max(0.0, baseTick);
			final String timeLeftStr = TIME_LEFT_FORMATTER.format(timeLeft);

			tableComponent.addRow("Time left:", ColorUtil.prependColorTag(timeLeftStr, getColor(currentTick)));
			tableComponent.addRow("Room:", client.getVar(Varbits.PYRAMID_PLUNDER_ROOM) + "/8");

			panelComponent.getChildren().add(tableComponent);

			return panelComponent.render(graphics);
		}
		return null;
	}

	private void toggleDefaultWidget(boolean hide)
	{
		final Widget widget = client.getWidget(WidgetInfo.PYRAMID_PLUNDER_DATA);

		if (widget == null)
		{
			return;
		}

		widget.setHidden(hide);
	}

	private Color getColor(int timeLeft)
	{
		if (timeLeft < plugin.getSecondWarningTime())
		{
			return Color.RED;
		}
		else if (timeLeft < plugin.getFirstWarningTime())
		{
			return Color.YELLOW;
		}

		return Color.WHITE;
	}

}
