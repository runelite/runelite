/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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

package net.runelite.client.plugins.cerberus.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.cerberus.CerberusConfig;
import net.runelite.client.plugins.cerberus.CerberusPlugin;
import net.runelite.client.plugins.cerberus.domain.Cerberus;
import net.runelite.client.plugins.cerberus.domain.CerberusAttack;
import net.runelite.client.plugins.cerberus.domain.Phase;
import net.runelite.client.plugins.cerberus.util.ImageManager;
import net.runelite.client.plugins.cerberus.util.InfoBoxComponent;
import net.runelite.client.plugins.cerberus.util.Utility;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public final class CurrentAttackOverlay extends Overlay
{
	private static final Color COLOR_BORDER = Color.WHITE;
	private static final Color COLOR_PRAYER_ENABLED = new Color(70, 61, 50, 225);
	private static final Color COLOR_PRAYER_DISABLED = new Color(150, 0, 0, 225);

	private static final int GAME_TICK_THRESHOLD = 6;

	private final Client client;
	private final CerberusPlugin plugin;
	private final CerberusConfig config;

	private final InfoBoxComponent infoBoxComponent;

	@Inject
	CurrentAttackOverlay(final Client client, final CerberusPlugin plugin, final CerberusConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;

		infoBoxComponent = new InfoBoxComponent();
		infoBoxComponent.setTextColor(Color.WHITE);

		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		if (!config.showCurrentAttack() || plugin.getCerberus() == null)
		{
			return null;
		}

		final List<CerberusAttack> upcomingAttacks = plugin.getUpcomingAttacks();

		if (upcomingAttacks.isEmpty())
		{
			return null;
		}

		final CerberusAttack cerberusAttack = plugin.getUpcomingAttacks().get(0);

		if (cerberusAttack.getTick() > (plugin.getGameTick() + GAME_TICK_THRESHOLD))
		{
			return null;
		}

		final Prayer prayer;

		if (cerberusAttack.getAttack() == Cerberus.Attack.AUTO)
		{
			prayer = plugin.getPrayer();
		}
		else
		{
			prayer = cerberusAttack.getAttack().getPrayer();
		}

		if (prayer == null)
		{
			return null;
		}

		final CerberusConfig.InfoBoxComponentSize infoBoxComponentSize = config.infoBoxComponentSize();

		final int size = infoBoxComponentSize.getSize();

		infoBoxComponent.setPreferredSize(new Dimension(size, size));

		final BufferedImage image = ImageManager.getCerberusBufferedImage(Phase.AUTO, prayer, infoBoxComponentSize);

		infoBoxComponent.setImage(image);

		final Color backgroundColor = client.isPrayerActive(prayer) ? COLOR_PRAYER_ENABLED : COLOR_PRAYER_DISABLED;

		infoBoxComponent.setBackgroundColor(backgroundColor);
		infoBoxComponent.setFont(Utility.getFontFromInfoboxComponentSize(infoBoxComponentSize));

		if (config.showCurrentAttackTimer())
		{
			final double timeUntilAttack = Math.max((double) ((cerberusAttack.getTick() - plugin.getGameTick()) * 600 - (System.currentTimeMillis() - plugin.getLastTick())) / 1000, 0);

			infoBoxComponent.setText(String.format("+%.1fs", timeUntilAttack));
		}
		else
		{
			infoBoxComponent.setText(null);
		}

		renderOutlineBorder(graphics2D, size);

		return infoBoxComponent.render(graphics2D);
	}

	private void renderOutlineBorder(final Graphics2D graphics2D, final int size)
	{
		final int x = -1;
		final int y = -1;

		final Rectangle rectangle = new Rectangle();

		rectangle.setLocation(x, y);
		rectangle.setSize(size + 1, size + 1);

		graphics2D.setColor(COLOR_BORDER);
		graphics2D.draw(rectangle);
	}
}