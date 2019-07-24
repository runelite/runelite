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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
public class CoxInfoBox extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private final CoxPlugin plugin;
	private final Client client;
	private final SpriteManager spriteManager;
	private final PanelComponent prayAgainstPanel = new PanelComponent();
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	CoxInfoBox(CoxPlugin plugin, Client client, SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);

	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		if (plugin.inRaid())
		{
			prayAgainstPanel.getChildren().clear();

			final PrayAgainst prayAgainst = plugin.getPrayAgainstOlm();

			if (plugin.getPrayAgainstOlm() == null && !plugin.isConfigPrayAgainstOlm())
			{
				return null;
			}

			if (System.currentTimeMillis() < (plugin.getLastPrayTime() + 120000) && plugin.getPrayAgainstOlm() != null)
			{
				InfoBoxComponent prayComponent = new InfoBoxComponent();
				BufferedImage prayImg = scaleImg(getPrayerImage(plugin.prayAgainstOlm));
				prayComponent.setImage(prayImg);
				prayComponent.setColor(Color.WHITE);
				prayComponent.setBackgroundColor(client.isPrayerActive(prayAgainst.getPrayer())
					? ComponentConstants.STANDARD_BACKGROUND_COLOR
					: NOT_ACTIVATED_BACKGROUND_COLOR);
				prayComponent.setPreferredSize(new Dimension(40, 40));
				prayAgainstPanel.getChildren().add(prayComponent);

				prayAgainstPanel.setPreferredSize(new Dimension(40, 40));
				prayAgainstPanel.setBorder(new Rectangle(0, 0, 0, 0));
				return prayAgainstPanel.render(graphics);
			}
			else
			{
				plugin.setPrayAgainstOlm(null);
			}

			if (plugin.isVangHealth() && plugin.getVanguards() > 0)
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("Vanguards")
					.color(Color.pink)
					.build());

				TableComponent tableComponent = new TableComponent();
				tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
				for (NPCContainer npcs : plugin.getNpcContainer().values())
				{
					float percent = (float) npcs.getNpc().getHealthRatio() / npcs.getNpc().getHealth() * 100;
					switch (npcs.getNpc().getId())
					{
						case NpcID.VANGUARD_7527:
							tableComponent.addRow(ColorUtil.prependColorTag("Melee", npcs.getAttackStyle().getColor()),
								Integer.toString((int) percent));
							break;
						case NpcID.VANGUARD_7528:
							tableComponent.addRow(ColorUtil.prependColorTag("Range", npcs.getAttackStyle().getColor()),
								Integer.toString((int) percent));
							break;
						case NpcID.VANGUARD_7529:
							tableComponent.addRow(ColorUtil.prependColorTag("Mage", npcs.getAttackStyle().getColor()),
								Integer.toString((int) percent));
							break;
					}
				}

				panelComponent.getChildren().add(tableComponent);

				return panelComponent.render(graphics);
			}
		}
		if (client.getLocalPlayer().getWorldLocation().getRegionID() == 4919)
		{
			plugin.setPrayAgainstOlm(null);
		}
		return null;
	}

	private BufferedImage getPrayerImage(PrayAgainst prayAgainst)
	{
		switch (prayAgainst)
		{
			case MAGIC:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
			case MELEE:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0);
			case RANGED:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
		}
		return null;
	}

	private BufferedImage scaleImg(final BufferedImage img)
	{
		if (img == null)
		{
			return null;
		}
		final double width = img.getWidth(null);
		final double height = img.getHeight(null);
		final double size = 36; // Limit size to 2 as that is minimum size not causing breakage
		final double scalex = size / width;
		final double scaley = size / height;
		final double scale = Math.min(scalex, scaley);
		final int newWidth = (int) (width * scale);
		final int newHeight = (int) (height * scale);
		final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		final Graphics g = scaledImage.createGraphics();
		g.drawImage(img, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return scaledImage;
	}
}
