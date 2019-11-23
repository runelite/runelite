/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.grotesqueguardians;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class GrotesqueGuardiansPrayerOverlay extends Overlay
{
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
	private final Client client;
	private final GrotesqueGuardiansPlugin plugin;
	private final SpriteManager spriteManager;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private GrotesqueGuardiansPrayerOverlay(final Client client, final GrotesqueGuardiansPlugin plugin, final SpriteManager spriteManager)
	{
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.spriteManager = spriteManager;
	}

	public Dimension render(Graphics2D graphics)
	{
		imagePanelComponent.getChildren().clear();
		if ((plugin.isInGargs()) && (plugin.getPrayAgainst() != null) && (plugin.getDusk() != null))
		{
			DuskAttack attack = plugin.getPrayAgainst();
			BufferedImage prayerImage;
			prayerImage = getPrayerImage(attack);
			imagePanelComponent.setBackgroundColor(client
				.isPrayerActive(attack.getPrayer()) ? ComponentConstants.STANDARD_BACKGROUND_COLOR : NOT_ACTIVATED_BACKGROUND_COLOR);

			NPC dusk = plugin.getDusk();
			imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));


			LocalPoint duskPoint = new LocalPoint(dusk.getLocalLocation().getX() + 128 * (Objects.requireNonNull(dusk.getTransformedDefinition()).getSize() - 1) / 2, dusk.getLocalLocation().getY() + 128 * (dusk.getTransformedDefinition().getSize() - 1) / 2);
			net.runelite.api.Point duskLoc = Perspective.getCanvasImageLocation(client, duskPoint, prayerImage, 400);
			if (duskLoc != null)
			{
				imagePanelComponent.setPreferredLocation(new java.awt.Point(duskLoc.getX(), duskLoc.getY()));
			}
			return imagePanelComponent.render(graphics);
		}
		return null;
	}

	private BufferedImage getPrayerImage(DuskAttack attack)
	{
		int prayerSpriteID = attack == DuskAttack.MELEE ? 129 : 128;

		return spriteManager.getSprite(prayerSpriteID, 0);
	}
}
