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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
public class CoxInfoBox extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private final CoxPlugin plugin;
	private final CoxConfig config;
	private final Client client;
	private final Olm olm;
	private final SpriteManager spriteManager;
	private final PanelComponent prayAgainstPanel = new PanelComponent();
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	CoxInfoBox(CoxPlugin plugin, CoxConfig config, Client client, Olm olm, SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.olm = olm;
		this.spriteManager = spriteManager;
		this.setPosition(OverlayPosition.BOTTOM_RIGHT);
		this.determineLayer();
		this.setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		this.panelComponent.getChildren().clear();
		if (this.plugin.inRaid())
		{
			this.prayAgainstPanel.getChildren().clear();

			final PrayAgainst prayAgainst = this.olm.getPrayer();

			if (System.currentTimeMillis() < this.olm.getLastPrayTime() + 120000 && prayAgainst != null && this.config.prayAgainstOlm())
			{
				final int scale = this.config.prayAgainstOlmSize();
				InfoBoxComponent prayComponent = new InfoBoxComponent();
				BufferedImage prayImg = ImageUtil.resizeImage(
					this.getPrayerImage(this.olm.getPrayer()), scale, scale
				);
				prayComponent.setImage(prayImg);
				prayComponent.setColor(Color.WHITE);
				prayComponent.setBackgroundColor(this.client.isPrayerActive(prayAgainst.getPrayer())
					? ComponentConstants.STANDARD_BACKGROUND_COLOR
					: NOT_ACTIVATED_BACKGROUND_COLOR
				);
				prayComponent.setPreferredSize(new Dimension(scale + 4, scale + 4));
				this.prayAgainstPanel.getChildren().add(prayComponent);

				this.prayAgainstPanel.setPreferredSize(new Dimension(scale + 4, scale + 4));
				this.prayAgainstPanel.setBorder(new Rectangle(0, 0, 0, 0));
				return this.prayAgainstPanel.render(graphics);
			}
			else
			{
				this.olm.setPrayer(null);
			}

			if (this.config.vangHealth() && this.plugin.getVanguards() > 0)
			{
				this.panelComponent.getChildren().add(TitleComponent.builder()
					.text("Vanguards")
					.color(Color.pink)
					.build());

				TableComponent tableComponent = new TableComponent();
				tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
				for (NPCContainer npcs : this.plugin.getNpcContainers().values())
				{
					float percent = (float) npcs.getNpc().getHealthRatio() / npcs.getNpc().getHealthScale() * 100;
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

				this.panelComponent.getChildren().add(tableComponent);

				return this.panelComponent.render(graphics);
			}
		}
		if (this.client.getLocalPlayer().getWorldLocation().getRegionID() == 4919)
		{
			this.olm.setPrayer(null);
		}
		return null;
	}

	private BufferedImage getPrayerImage(PrayAgainst prayAgainst)
	{
		switch (prayAgainst)
		{
			case MAGIC:
				return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
			case MELEE:
				return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0);
			case RANGED:
				return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
			default:
				return this.spriteManager.getSprite(SpriteID.BARBARIAN_ASSAULT_EAR_ICON, 0);
		}
	}

	public void determineLayer()
	{
	}
}
