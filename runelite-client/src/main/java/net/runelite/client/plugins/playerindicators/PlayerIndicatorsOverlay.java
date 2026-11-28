/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.playerindicators;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.Text;

@Singleton
public class PlayerIndicatorsOverlay extends Overlay
{
	private static final int ACTOR_OVERHEAD_TEXT_MARGIN = 40;
	private static final int ACTOR_HORIZONTAL_TEXT_MARGIN = 10;

	private final PlayerIndicatorsService playerIndicatorsService;
	private final PlayerIndicatorsConfig config;
	private final ChatIconManager chatIconManager;

	@Inject
	private PlayerIndicatorsOverlay(PlayerIndicatorsConfig config, PlayerIndicatorsService playerIndicatorsService,
		ChatIconManager chatIconManager)
	{
		this.config = config;
		this.playerIndicatorsService = playerIndicatorsService;
		this.chatIconManager = chatIconManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_MED);
		setPreferPanelGlyphScale(true);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		playerIndicatorsService.forEachPlayer((player, decorations) -> renderPlayerOverlay(graphics, player, decorations));
		return null;
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player actor, PlayerIndicatorsService.Decorations decorations)
	{
		final PlayerNameLocation drawPlayerNamesConfig = config.playerNamePosition();
		if (drawPlayerNamesConfig == PlayerNameLocation.DISABLED)
		{
			return;
		}

		final int zOffset;
		switch (drawPlayerNamesConfig)
		{
			case MODEL_CENTER:
			case MODEL_RIGHT:
				zOffset = actor.getLogicalHeight() / 2;
				break;
			default:
				zOffset = actor.getLogicalHeight() + ACTOR_OVERHEAD_TEXT_MARGIN;
		}

		final String name = Text.sanitize(actor.getName());
		Point textLocation = actor.getCanvasTextLocation(graphics, name, zOffset);

		if (drawPlayerNamesConfig == PlayerNameLocation.MODEL_RIGHT)
		{
			textLocation = actor.getCanvasTextLocation(graphics, "", zOffset);

			if (textLocation == null)
			{
				return;
			}

			textLocation = new Point(textLocation.getX() + ACTOR_HORIZONTAL_TEXT_MARGIN, textLocation.getY());
		}

		if (textLocation == null)
		{
			return;
		}

		BufferedImage rankImage = null;
		if (decorations.getFriendsChatRank() != null && config.showFriendsChatRanks())
		{
			if (decorations.getFriendsChatRank() != FriendsChatRank.UNRANKED)
			{
				rankImage = chatIconManager.getRankImage(decorations.getFriendsChatRank());
			}
		}
		else if (decorations.getClanTitle() != null && config.showClanChatRanks())
		{
			rankImage = chatIconManager.getRankImage(decorations.getClanTitle());
		}

		if (rankImage != null)
		{
			renderRankAndName(graphics, textLocation, name, rankImage, decorations.getColor(), drawPlayerNamesConfig);
			return;
		}

		textLocation = OverlayUtil.adjustLocalTextScaleLocation(graphics, textLocation, name);
		OverlayUtil.renderTextLocation(graphics, textLocation, name, decorations.getColor());
	}

	/**
	 * Packs rank icon + name in unscaled space, then applies panel glyph scale to the
	 * whole plate about the name center so icon and text stay locked under non-uniform stretch.
	 */
	private void renderRankAndName(Graphics2D graphics, Point textLocation, String name, BufferedImage rankImage,
		java.awt.Color color, PlayerNameLocation drawPlayerNamesConfig)
	{
		final boolean localScale = OverlayUtil.isNativeLocalTextScale(graphics);
		final double fx = OverlayUtil.getNativeVisualSizeFactor(graphics);
		final double fy = OverlayUtil.getNativeVisualSizeFactorY(graphics);
		final boolean groupScale = localScale && (fx != 1.0 || fy != 1.0);

		final int imageWidth;
		final int imageHeight;
		final int textHeight;
		if (groupScale)
		{
			// Layout with raw bitmap / font metrics; one shared scale is applied below.
			imageWidth = rankImage.getWidth();
			imageHeight = rankImage.getHeight();
			textHeight = graphics.getFontMetrics().getHeight() - graphics.getFontMetrics().getMaxDescent();
		}
		else
		{
			final Dimension imageSize = OverlayUtil.getImageLayoutSize(graphics, rankImage);
			imageWidth = imageSize.width;
			imageHeight = imageSize.height;
			textHeight = (int) Math.round(
				(graphics.getFontMetrics().getHeight() - graphics.getFontMetrics().getMaxDescent())
					* fy);
		}

		final int imageTextMargin;
		final int imageNegativeMargin;
		if (drawPlayerNamesConfig == PlayerNameLocation.MODEL_RIGHT)
		{
			imageTextMargin = imageWidth;
			imageNegativeMargin = 0;
		}
		else
		{
			imageTextMargin = imageWidth / 2;
			imageNegativeMargin = imageWidth / 2;
		}

		final Point imageLocation = new Point(
			textLocation.getX() - imageNegativeMargin - 1,
			textLocation.getY() - textHeight / 2 - imageHeight / 2);
		final Point nameLocation = new Point(textLocation.getX() + imageTextMargin, textLocation.getY());

		if (!groupScale)
		{
			OverlayUtil.renderImageLocationExact(graphics, imageLocation, rankImage);
			OverlayUtil.renderTextLocation(graphics, nameLocation, name, color);
			return;
		}

		final int anchorX = textLocation.getX() + graphics.getFontMetrics().stringWidth(name) / 2;
		final int anchorY = textLocation.getY();
		final AffineTransform transform = graphics.getTransform();
		graphics.translate(anchorX, anchorY);
		graphics.scale(fx, fy);
		graphics.translate(-anchorX, -anchorY);

		// Factors already applied by the group transform — draw at 1×1 in this space.
		final Object prevLocal = graphics.getRenderingHint(OverlayUtil.KEY_NATIVE_LOCAL_TEXT_SCALE);
		final Object prevFx = graphics.getRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR);
		final Object prevFy = graphics.getRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR_Y);
		graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_LOCAL_TEXT_SCALE, false);
		graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR, 1.0);
		graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR_Y, 1.0);
		try
		{
			graphics.drawImage(rankImage, imageLocation.getX(), imageLocation.getY(), null);
			OverlayUtil.renderTextLocation(graphics, nameLocation, name, color);
		}
		finally
		{
			graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_LOCAL_TEXT_SCALE, prevLocal);
			graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR, prevFx);
			graphics.setRenderingHint(OverlayUtil.KEY_NATIVE_VISUAL_SIZE_FACTOR_Y, prevFy);
			graphics.setTransform(transform);
		}
	}
}
