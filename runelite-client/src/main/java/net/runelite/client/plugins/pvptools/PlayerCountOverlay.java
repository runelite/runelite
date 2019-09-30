/*
 * ******************************************************************************
 *  * Copyright (c) 2019 openosrs
 *  *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 *  *  ST0NEWALL#9112
 *  *   openosrs Discord: https://discord.gg/Q7wFtCe
 *  *   openosrs website: https://openosrs.com
 *  *****************************************************************************
 */

package net.runelite.client.plugins.pvptools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.ui.overlay.components.table.TableElement;
import net.runelite.client.ui.overlay.components.table.TableRow;
import org.apache.commons.lang3.ArrayUtils;

@Singleton
public class PlayerCountOverlay extends Overlay
{
	private static final int[] CLAN_WARS_REGIONS = {9520, 13135, 13134, 13133, 13131, 13130, 13387, 13386};

	private final PvpToolsPlugin pvpToolsPlugin;
	private final Client client;


	@Inject
	public PlayerCountOverlay(final PvpToolsPlugin pvpToolsPlugin, final Client client)
	{
		this.pvpToolsPlugin = pvpToolsPlugin;
		this.client = client;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.TOP_LEFT);
		this.setPreferredPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (pvpToolsPlugin.isCountPlayers() &&
			(client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(client.getWorldType())
				|| ArrayUtils.contains(CLAN_WARS_REGIONS, client.getMapRegions()[0]) ||
				WorldType.isDeadmanWorld(client.getWorldType())))
		{
			// Make this stop showing up when its not relevant
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
