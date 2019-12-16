/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.game.PlayerContainer;
import net.runelite.client.game.PlayerManager;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
class PrayAgainstPlayerOverlay extends Overlay
{
	private final PrayAgainstPlayerPlugin plugin;
	private final PlayerManager playerManager;
	private final ModelOutlineRenderer outlineRenderer;

	@Inject
	private PrayAgainstPlayerOverlay(
		final PrayAgainstPlayerPlugin plugin,
		final PlayerManager playerManager,
		final ModelOutlineRenderer outlineRenderer
	)
	{
		this.plugin = plugin;
		this.playerManager = playerManager;
		this.outlineRenderer = outlineRenderer;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (PlayerContainer player : playerManager.getAllAttackers())
		{
			if (player.getPlayer() == null
				|| (plugin.isIgnoreFriends() && player.isFriend()
				|| (plugin.isIgnoreClanMates() && player.isClan()))
			)
			{
				continue;
			}
			
			if (plugin.isHighlightAttackers())
			{
				outlineRenderer.drawOutline(player.getPlayer(), plugin.getHighlightWidth(), player.getAttackStyle().getColor());
			}
		}
		return null;
	}
}
