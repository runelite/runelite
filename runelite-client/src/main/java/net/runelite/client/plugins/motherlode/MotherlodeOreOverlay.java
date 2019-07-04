/*
 * Copyright (c) 2019, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
@Singleton
public class MotherlodeOreOverlay extends Overlay
{
	private final MotherlodePlugin plugin;
	private final MotherlodeSession motherlodeSession;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeOreOverlay(final MotherlodePlugin plugin, final MotherlodeSession motherlodeSession)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.motherlodeSession = motherlodeSession;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !plugin.isShowOresFound())
		{
			return null;
		}

		MotherlodeSession session = motherlodeSession;

		int nuggetsFound = session.getNuggetsFound();
		int coalFound = session.getCoalFound();
		int goldFound = session.getGoldFound();
		int mithrilFound = session.getMithrilFound();
		int adamantiteFound = session.getAdamantiteFound();
		int runiteFound = session.getRuniteFound();

		// If no ores have even been collected, don't bother showing anything
		if (nuggetsFound == 0 && coalFound == 0 && goldFound == 0 && mithrilFound == 0
			&& adamantiteFound == 0 && runiteFound == 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().text("Ores found").build());

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		if (nuggetsFound > 0)
		{
			tableComponent.addRow("Nuggets:", Integer.toString(nuggetsFound));
		}

		if (coalFound > 0)
		{
			tableComponent.addRow("Coal:", Integer.toString(coalFound));
		}

		if (goldFound > 0)
		{
			tableComponent.addRow("Gold:", Integer.toString(goldFound));
		}

		if (mithrilFound > 0)
		{
			tableComponent.addRow("Mithril:", Integer.toString(mithrilFound));
		}

		if (adamantiteFound > 0)
		{
			tableComponent.addRow("Adamantite:", Integer.toString(adamantiteFound));
		}

		if (runiteFound > 0)
		{
			tableComponent.addRow("Runite:", Integer.toString(runiteFound));
		}

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}