/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.demonicgorilla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class DemonicGorillaOverlay extends Overlay
{
	private static final Color COLOR_ICON_BACKGROUND = new Color(0, 0, 0, 128);
	private static final Color COLOR_ICON_BORDER = new Color(0, 0, 0, 255);
	private static final Color COLOR_ICON_BORDER_FILL = new Color(219, 175, 0, 255);
	private static final int OVERLAY_ICON_DISTANCE = 50;
	private static final int OVERLAY_ICON_MARGIN = 8;

	private final Client client;
	private final DemonicGorillaPlugin plugin;

	@Inject
	private SkillIconManager iconManager;

	@Inject
	public DemonicGorillaOverlay(final Client client, final DemonicGorillaPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	private BufferedImage getIcon(DemonicGorilla.AttackStyle attackStyle)
	{
		switch (attackStyle)
		{
			case MELEE:
				return iconManager.getSkillImage(Skill.ATTACK);
			case RANGED:
				return iconManager.getSkillImage(Skill.RANGED);
			case MAGIC:
				return iconManager.getSkillImage(Skill.MAGIC);
		}
		return null;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (DemonicGorilla gorilla : plugin.getGorillas().values())
		{
			if (gorilla.getNpc().getInteracting() == null)
			{
				continue;
			}

			LocalPoint lp = gorilla.getNpc().getLocalLocation();
			if (lp != null)
			{
				Point point = Perspective.localToCanvas(client, lp, client.getPlane(),
					gorilla.getNpc().getLogicalHeight() + 16);
				if (point != null)
				{
					point = new Point(point.getX(), point.getY());

					List<DemonicGorilla.AttackStyle> attackStyles = gorilla.getNextPosibleAttackStyles();
					List<BufferedImage> icons = new ArrayList<>();
					int totalWidth = (attackStyles.size() - 1) * OVERLAY_ICON_MARGIN;
					for (DemonicGorilla.AttackStyle attackStyle : attackStyles)
					{
						BufferedImage icon = getIcon(attackStyle);
						icons.add(icon);
						if (icon != null)
						{
							totalWidth += icon.getWidth();
						}
					}

					int bgPadding = 4;
					int currentPosX = 0;
					for (BufferedImage icon : icons)
					{
						OverlayUtil.setProgressIcon(graphics, point, icon, totalWidth, bgPadding, currentPosX,
							COLOR_ICON_BACKGROUND, OVERLAY_ICON_DISTANCE, COLOR_ICON_BORDER, COLOR_ICON_BORDER_FILL);
						Arc2D.Double arc = new Arc2D.Double(
							point.getX() - totalWidth / 2 + currentPosX - bgPadding,
							point.getY() - (float) (icon.getHeight() / 2) - OVERLAY_ICON_DISTANCE - bgPadding,
							icon.getWidth() + bgPadding * 2,
							icon.getHeight() + bgPadding * 2,
							90.0,
							-360.0 * (DemonicGorilla.ATTACKS_PER_SWITCH -
								gorilla.getAttacksUntilSwitch()) / DemonicGorilla.ATTACKS_PER_SWITCH,
							Arc2D.OPEN);
						graphics.draw(arc);

						currentPosX += icon.getWidth() + OVERLAY_ICON_MARGIN;
					}
				}
			}
		}

		return null;
	}
}