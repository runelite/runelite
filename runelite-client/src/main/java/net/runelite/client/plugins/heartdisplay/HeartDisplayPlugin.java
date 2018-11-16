/*
 * Copyright (c) 2018 TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.heartdisplay;

import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.SpritePixels;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Dynamic HP heart",
	description = "Changes the HP heart color to reflect background color.",
	tags = {"hp", "heart", "replace"}
)
@Slf4j
public class HeartDisplayPlugin extends Plugin
{
	private static final BufferedImage HEART_NORMAL;
	private static final BufferedImage HEART_DISEASE;
	private static final BufferedImage HEART_POISON;
	private static final BufferedImage HEART_VENOM;
	static
	{
		HEART_NORMAL = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(HeartDisplayPlugin.class, "1067-NORMAL.png"), 26, 26);
		HEART_DISEASE = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(HeartDisplayPlugin.class, "1067-DISEASE.png"), 26, 26);
		HEART_POISON = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(HeartDisplayPlugin.class, "1067-POISON.png"), 26, 26);
		HEART_VENOM = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(HeartDisplayPlugin.class, "1067-VENOM.png"), 26, 26);
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private BufferedImage currentHeart;

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invoke(this::checkHealthIcon);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(this::resetHeathIcon);
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged e)
	{
		checkHealthIcon();
	}

	private void resetHeathIcon()
	{
		client.getWidgetSpriteCache().reset();
		client.getSpriteOverrides().remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON);
		currentHeart = null;
	}

	private void checkHealthIcon()
	{
		int poison = client.getVar(VarPlayer.IS_POISONED);
		boolean isVenomed = poison >= 1000000;
		boolean isPoisoned = !isVenomed && poison > 0;
		boolean isDiseased = client.getVar(VarPlayer.DISEASE_VALUE) > 0;

		BufferedImage old = currentHeart;

		currentHeart = isVenomed ? HEART_VENOM : isPoisoned ? HEART_POISON : isDiseased ? HEART_DISEASE : HEART_NORMAL;

		if (old != currentHeart)
		{
			client.getWidgetSpriteCache().reset();
			client.getSpriteOverrides().put(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, getImageSpritePixels(currentHeart));
		}
	}

	// Pulled from InterfaceStylesPlugin
	private SpritePixels getImageSpritePixels(BufferedImage image)
	{
		int[] pixels = new int[image.getWidth() * image.getHeight()];

		try
		{
			new PixelGrabber(image, 0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth())
				.grabPixels();
		}
		catch (InterruptedException ex)
		{
			log.debug("PixelGrabber was interrupted: ", ex);
		}

		return client.createSpritePixels(pixels, image.getWidth(), image.getHeight());
	}
}
