/*
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class MotherlodeGemOverlay extends OverlayPanel
{
	private final MotherlodePlugin plugin;
	private final MotherlodeSession motherlodeSession;
	private final MotherlodeConfig config;
	private final ItemManager itemManager;

	@Inject
	MotherlodeGemOverlay(MotherlodePlugin plugin, MotherlodeSession motherlodeSession, MotherlodeConfig config, ItemManager itemManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.motherlodeSession = motherlodeSession;
		this.config = config;
		this.itemManager = itemManager;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Gem overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		MotherlodeSession session = motherlodeSession;

		if (session.getLastGemFound() == null || !plugin.isInMlm() || !config.showGemsFound())
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceLastGem = Duration.between(session.getLastGemFound(), Instant.now());

		if (sinceLastGem.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		int diamondsFound = session.getDiamondsFound();
		int rubiesFound = session.getRubiesFound();
		int emeraldsFound = session.getEmeraldsFound();
		int sapphiresFound = session.getSapphiresFound();

		if (config.showLootIcons())
		{
			panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
			if (diamondsFound > 0)
			{
				panelComponent.getChildren().add(new ImageComponent(itemManager.getImage(ItemID.UNCUT_DIAMOND, diamondsFound, true)));
			}
			if (rubiesFound > 0)
			{
				panelComponent.getChildren().add(new ImageComponent(itemManager.getImage(ItemID.UNCUT_RUBY, rubiesFound, true)));
			}
			if (emeraldsFound > 0)
			{
				panelComponent.getChildren().add(new ImageComponent(itemManager.getImage(ItemID.UNCUT_EMERALD, emeraldsFound, true)));
			}
			if (sapphiresFound > 0)
			{
				panelComponent.getChildren().add(new ImageComponent(itemManager.getImage(ItemID.UNCUT_SAPPHIRE, sapphiresFound, true)));
			}
		}
		else
		{
			panelComponent.setOrientation(ComponentOrientation.VERTICAL);
			panelComponent.getChildren().add(TitleComponent.builder().text("Gems found").build());
			if (diamondsFound > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Diamonds:")
					.right(Integer.toString(diamondsFound))
					.build());
			}

			if (rubiesFound > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Rubies:")
					.right(Integer.toString(rubiesFound))
					.build());
			}

			if (emeraldsFound > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Emeralds:")
					.right(Integer.toString(emeraldsFound))
					.build());
			}

			if (sapphiresFound > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Sapphires:")
					.right(Integer.toString(sapphiresFound))
					.build());
			}
		}

		return super.render(graphics);
	}
}
