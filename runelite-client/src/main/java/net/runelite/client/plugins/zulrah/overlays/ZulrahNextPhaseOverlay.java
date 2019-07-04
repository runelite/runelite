/*
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
package net.runelite.client.plugins.zulrah.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.plugins.zulrah.ImagePanelComponent;
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class ZulrahNextPhaseOverlay extends Overlay
{
	private final ZulrahPlugin plugin;

	@Inject
	ZulrahNextPhaseOverlay(final ZulrahPlugin plugin)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ZulrahInstance instance = plugin.getInstance();

		if (instance == null)
		{
			return null;
		}

		ZulrahPhase nextPhase = instance.getNextPhase();
		if (nextPhase == null)
		{
			return null;
		}

		Color backgroundColor = nextPhase.getColor();
		BufferedImage zulrahImage = ZulrahImageManager.getSmallZulrahBufferedImage(nextPhase.getType());
		ImagePanelComponent imagePanelComponent = new ImagePanelComponent();
		imagePanelComponent.setTitle("Next");
		imagePanelComponent.setBackgroundColor(backgroundColor);
		imagePanelComponent.setImage(zulrahImage);
		return imagePanelComponent.render(graphics);
	}
}
