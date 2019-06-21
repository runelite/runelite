/*
 * ******************************************************************************
 *  * Copyright (c) 2019 RuneLitePlus
 *  *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 *  *  ST0NEWALL#9112
 *  *   RuneLitePlus Discord: https://discord.gg/Q7wFtCe
 *  *   RuneLitePlus website: https://runelitepl.us
 *  *****************************************************************************
 */

package net.runelite.client.plugins.pvptools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.ui.overlay.components.table.TableElement;
import net.runelite.client.ui.overlay.components.table.TableRow;

public class PlayerCountOverlay extends Overlay
{

	private final PvpToolsPlugin pvpToolsPlugin;
	private final PvpToolsConfig config;

	@Inject
	public PlayerCountOverlay(PvpToolsPlugin pvpToolsPlugin, PvpToolsConfig pvpToolsConfig)
	{
		this.pvpToolsPlugin = pvpToolsPlugin;
		this.config = pvpToolsConfig;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.TOP_LEFT);
		this.setPreferredPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.countPlayers())
		{
			TableComponent tableComponent = new TableComponent();
			TableElement[] firstRowElements = {
					TableElement.builder().content("Friendly").color(Color.GREEN).build(),
				TableElement.builder().content(String.valueOf(pvpToolsPlugin.getFriendlyPlayerCount())).build()};
			TableRow firstRow = TableRow.builder().elements(Arrays.asList(firstRowElements)).build();
			TableElement[] secondRowElements = {
				TableElement.builder().content("Enemy").color(Color.RED).build(),
				TableElement.builder().content(String.valueOf(pvpToolsPlugin.getEnemyPlayerCount())).build()};
			TableRow secondRow = TableRow.builder().elements(Arrays.asList(secondRowElements)).build();
			tableComponent.addRows(firstRow, secondRow);
			return tableComponent.render(graphics);
		}
		return null;
	}
}
