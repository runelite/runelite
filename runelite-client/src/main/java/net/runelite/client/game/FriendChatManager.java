/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.SpriteID;
import net.runelite.api.events.FriendsChatChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Singleton
public class FriendChatManager
{
	private static final int[] RANK_IMAGES =
		{
			SpriteID.FRIENDS_CHAT_RANK_SMILEY_FRIEND,
			SpriteID.FRIENDS_CHAT_RANK_SINGLE_CHEVRON_RECRUIT,
			SpriteID.FRIENDS_CHAT_RANK_DOUBLE_CHEVRON_CORPORAL,
			SpriteID.FRIENDS_CHAT_RANK_TRIPLE_CHEVRON_SERGEANT,
			SpriteID.FRIENDS_CHAT_RANK_BRONZE_STAR_LIEUTENANT,
			SpriteID.FRIENDS_CHAT_RANK_SILVER_STAR_CAPTAIN,
			SpriteID.FRIENDS_CHAT_RANK_GOLD_STAR_GENERAL,
			SpriteID.FRIENDS_CHAT_RANK_KEY_CHANNEL_OWNER,
			SpriteID.FRIENDS_CHAT_RANK_CROWN_JAGEX_MODERATOR,
		};
	private static final Dimension IMAGE_DIMENSION = new Dimension(11, 11);
	private static final Color IMAGE_OUTLINE_COLOR = new Color(33, 33, 33);

	private final Client client;
	private final SpriteManager spriteManager;
	private final BufferedImage[] rankImages = new BufferedImage[RANK_IMAGES.length];

	private final LoadingCache<String, FriendsChatRank> ranksCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, FriendsChatRank>()
		{
			@Override
			public FriendsChatRank load(@Nonnull String key)
			{
				final FriendsChatManager friendsChatManager = client.getFriendsChatManager();
				if (friendsChatManager == null)
				{
					return FriendsChatRank.UNRANKED;
				}

				FriendsChatMember friendsChatMember = friendsChatManager.findByName(sanitize(key));
				return friendsChatMember != null ? friendsChatMember.getRank() : FriendsChatRank.UNRANKED;
			}
		});

	private int offset;

	@Inject
	private FriendChatManager(Client client, SpriteManager spriteManager, EventBus eventBus)
	{
		this.client = client;
		this.spriteManager = spriteManager;
		eventBus.register(this);
	}

	public boolean isMember(String name)
	{
		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		return friendsChatManager != null && friendsChatManager.findByName(name) != null;
	}

	public FriendsChatRank getRank(String playerName)
	{
		return ranksCache.getUnchecked(playerName);
	}

	@Nullable
	public BufferedImage getRankImage(final FriendsChatRank friendsChatRank)
	{
		if (friendsChatRank == FriendsChatRank.UNRANKED)
		{
			return null;
		}

		return rankImages[friendsChatRank.ordinal() - 1];
	}

	public int getIconNumber(final FriendsChatRank friendsChatRank)
	{
		return offset + friendsChatRank.ordinal() - 1;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN && offset == 0)
		{
			loadRankIcons();
		}
	}

	@Subscribe
	public void onFriendsChatChanged(FriendsChatChanged friendsChatChanged)
	{
		ranksCache.invalidateAll();
	}

	private void loadRankIcons()
	{
		{
			IndexedSprite[] modIcons = client.getModIcons();
			offset = modIcons.length;

			IndexedSprite blank = ImageUtil.getImageIndexedSprite(
				new BufferedImage(modIcons[0].getWidth(), modIcons[0].getHeight(), BufferedImage.TYPE_INT_ARGB),
				client);

			modIcons = Arrays.copyOf(modIcons, offset + RANK_IMAGES.length);
			Arrays.fill(modIcons, offset, modIcons.length, blank);

			client.setModIcons(modIcons);
		}

		for (int i = 0; i < RANK_IMAGES.length; i++)
		{
			final int fi = i;

			spriteManager.getSpriteAsync(RANK_IMAGES[i], 0, sprite ->
			{
				IndexedSprite[] modIcons = client.getModIcons();
				rankImages[fi] = friendsChatImageFromSprite(sprite);
				modIcons[offset + fi] = ImageUtil.getImageIndexedSprite(rankImages[fi], client);
			});
		}
	}

	private static String sanitize(String lookup)
	{
		final String cleaned = Text.removeTags(lookup);
		return cleaned.replace('\u00A0', ' ');
	}

	private static BufferedImage friendsChatImageFromSprite(final BufferedImage sprite)
	{
		final BufferedImage canvas = ImageUtil.resizeCanvas(sprite, IMAGE_DIMENSION.width, IMAGE_DIMENSION.height);
		return ImageUtil.outlineImage(canvas, IMAGE_OUTLINE_COLOR);
	}
}
