/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.game;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.inject.Inject;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.SpritePixels;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.util.ImageUtil;

@Slf4j
@Singleton
public class SpriteManager
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	public Cache<Long, BufferedImage> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.expireAfterAccess(1, TimeUnit.HOURS)
		.build();

	@Nullable
	public BufferedImage getSprite(int archive, int file)
	{
		assert client.isClientThread();
		if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal())
		{
			return null;
		}

		Long key = (long) archive << 32 | file;
		BufferedImage cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return cached;
		}

		SpritePixels[] sp = client.getSprites(client.getIndexSprites(), archive, 0);
		BufferedImage img = sp[file].toBufferedImage();

		cache.put(key, img);
		return img;
	}

	public void getSpriteAsync(int archive, int file, Consumer<BufferedImage> user)
	{
		BufferedImage cached = cache.getIfPresent((long) archive << 32 | file);
		if (cached != null)
		{
			user.accept(cached);
			return;
		}

		clientThread.invoke(() ->
		{
			BufferedImage img = getSprite(archive, file);
			if (img == null)
			{
				// Cache isn't loaded yet
				return false;
			}
			user.accept(img);
			return true;
		});
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addSpriteTo(JButton c, int archive, int file)
	{
		getSpriteAsync(archive, file, img ->
		{
			SwingUtilities.invokeLater(() ->
			{
				c.setIcon(new ImageIcon(img));
			});
		});
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addSpriteTo(JLabel c, int archive, int file)
	{
		getSpriteAsync(archive, file, img ->
		{
			SwingUtilities.invokeLater(() ->
			{
				c.setIcon(new ImageIcon(img));
			});
		});
	}

	public void addSpriteOverrides(SpriteOverride[] add)
	{
		if (add.length <= 0)
		{
			return;
		}

		clientThread.invokeLater(() ->
		{
			Map<Integer, SpritePixels> overrides = client.getSpriteOverrides();
			Class<?> owner = add[0].getClass();
			for (SpriteOverride o : add)
			{
				BufferedImage image = ImageUtil.getResourceStreamFromClass(owner, o.getFileName());
				SpritePixels sp = ImageUtil.getImageSpritePixels(image, client);
				overrides.put(o.getSpriteId(), sp);
			}
		});
	}

	public void removeSpriteOverrides(SpriteOverride[] remove)
	{
		clientThread.invokeLater(() ->
		{
			Map<Integer, SpritePixels> overrides = client.getSpriteOverrides();
			for (SpriteOverride o : remove)
			{
				overrides.remove(o.getSpriteId());
			}
		});
	}
}
