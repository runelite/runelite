/*
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.coxhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

public class VanguardsOverlay extends Overlay
{

	private final CoxPlugin plugin;
	private final CoxConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	VanguardsOverlay(CoxPlugin plugin, CoxConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setPosition(OverlayPosition.DETACHED);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isRunVanguards())
		{
			panelComponent.getChildren().clear();

			if (config.vangHealth())
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("Vanguards")
					.color(Color.pink)
					.build());

				TableComponent tableComponent = new TableComponent();
				tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

				tableComponent.addRow(ColorUtil.prependColorTag("Range", Color.GREEN), Integer.toString(plugin.getRangeVangHP()));
				tableComponent.addRow(ColorUtil.prependColorTag("Mage", Color.BLUE), Integer.toString(plugin.getMageVangHP()));
				tableComponent.addRow(ColorUtil.prependColorTag("Melee", Color.RED), Integer.toString(plugin.getMeleeVangHP()));

				panelComponent.getChildren().add(tableComponent);

				return panelComponent.render(graphics);
			}
		}
		return null;
	}
}
