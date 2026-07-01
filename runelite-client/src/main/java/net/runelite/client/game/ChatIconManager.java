/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.clan.ClanTitle;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;

@Singleton
public class ChatIconManager
{
	private static final Dimension IMAGE_DIMENSION = new Dimension(11, 11);
	private static final Color IMAGE_OUTLINE_COLOR = new Color(33, 33, 33);

	private final Client client;
	private final SpriteManager spriteManager;
	private final ClientThread clientThread;

	private BufferedImage[] friendsChatRankImages;
	private BufferedImage[] clanRankImages;

	private int friendsChatOffset = -1;
	private int clanOffset = -1;

	private final List<ChatIcon> icons = new ArrayList<>();

	@Inject
	private ChatIconManager(Client client, SpriteManager spriteManager, ClientThread clientThread, EventBus eventBus)
	{
		this.client = client;
		this.spriteManager = spriteManager;
		this.clientThread = clientThread;
		eventBus.register(this);
		clientThread.invokeLater(() ->
		{
			// if the client is not booted yet, this will be picked up by the game state change handler below instead
			if (client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState())
			{
				if (friendsChatOffset == -1)
				{
					loadRankIcons();
				}
				refreshIcons();
			}
		});
	}

	@AllArgsConstructor
	private static class ChatIcon
	{
		int idx;
		IndexedSprite sprite;
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		var state = gameStateChanged.getGameState();
		if (state == GameState.STARTING)
		{
			friendsChatOffset = clanOffset = -1;
			synchronized (this)
			{
				for (var icon : icons)
				{
					icon.idx = -1;
				}
			}
		}
		else if (state == GameState.LOGIN_SCREEN)
		{
			if (friendsChatOffset == -1)
			{
				loadRankIcons();
			}
			refreshIcons();
		}
	}

	public synchronized int registerChatIcon(BufferedImage image)
	{
		if (image == null || image instanceof AsyncBufferedImage)
		{
			throw new IllegalArgumentException("invalid image");
		}
		var i = ImageUtil.getImageIndexedSprite(image, client);
		icons.add(new ChatIcon(-1, i));
		clientThread.invokeLater(this::refreshIcons);
		return icons.size() - 1;
	}

	/**
	 * Reserves a chat icon id with a dummy image
	 */
	public synchronized int reserveChatIcon()
	{
		assert client.isClientThread();

		BufferedImage dummy = new BufferedImage(13, 13, BufferedImage.TYPE_INT_RGB);
		IndexedSprite sprite = ImageUtil.getImageIndexedSprite(dummy, client);

		IndexedSprite[] modicons = client.getModIcons();
		modicons = Arrays.copyOf(modicons, modicons.length + 1);
		modicons[modicons.length - 1] = sprite;
		client.setModIcons(modicons);

		icons.add(new ChatIcon(modicons.length - 1, sprite));
		return icons.size() - 1;
	}

	/**
	 * Update an existing chat icons image
	 */
	public synchronized void updateChatIcon(int iconId, BufferedImage image)
	{
		ChatIcon ci = icons.get(iconId);
		IndexedSprite sprite = ImageUtil.getImageIndexedSprite(image, client);
		int idx = ci.idx;
		if (idx == -1)
		{
			ci.sprite = sprite;
			return;
		}

		IndexedSprite[] modicons = client.getModIcons();
		modicons[idx] = sprite;
	}

	public int chatIconIndex(int iconId)
	{
		if (iconId < 0 || iconId >= icons.size())
		{
			return -1;
		}
		return icons.get(iconId).idx;
	}

	@Nullable
	public BufferedImage getRankImage(final FriendsChatRank friendsChatRank)
	{
		if (friendsChatRank == FriendsChatRank.UNRANKED)
		{
			return null;
		}

		return friendsChatRankImages[friendsChatRank.ordinal() - 1];
	}

	@Nullable
	public BufferedImage getRankImage(final ClanTitle clanTitle)
	{
		int rank = clanTitle.getId();
		int idx = clanRankToIdx(rank);
		return clanRankImages[idx];
	}

	public int getIconNumber(final FriendsChatRank friendsChatRank)
	{
		return friendsChatOffset == -1 ? -1 : friendsChatOffset + friendsChatRank.ordinal() - 1;
	}

	public int getIconNumber(final ClanTitle clanTitle)
	{
		int rank = clanTitle.getId();
		return clanOffset == -1 ? -1 : clanOffset + clanRankToIdx(rank);
	}

	private synchronized void refreshIcons()
	{
		var chatIcons = client.getModIcons();
		if (chatIcons == null)
		{
			return;
		}

		final var offset = chatIcons.length;

		int newIcons = 0;
		for (var icon : icons)
		{
			assert icon.idx < offset;
			if (icon.idx == -1)
			{
				++newIcons;
			}
		}

		if (newIcons == 0)
		{
			return;
		}

		var newChatIcons = Arrays.copyOf(chatIcons, chatIcons.length + newIcons);

		newIcons = 0;
		for (var icon : icons)
		{
			if (icon.idx == -1)
			{
				icon.idx = offset + newIcons++;
				newChatIcons[icon.idx] = icon.sprite;
			}
		}

		client.setModIcons(newChatIcons);
	}

	private void loadRankIcons()
	{
		final EnumComposition friendsChatIcons = client.getEnum(EnumID.FRIENDS_CHAT_RANK_ICONS);
		final EnumComposition clanIcons = client.getEnum(EnumID.CLAN_RANK_GRAPHIC);

		{
			IndexedSprite[] modIcons = client.getModIcons();
			friendsChatOffset = modIcons.length;
			clanOffset = friendsChatOffset + friendsChatIcons.size();

			IndexedSprite blank = ImageUtil.getImageIndexedSprite(
				new BufferedImage(modIcons[0].getWidth(), modIcons[0].getHeight(), BufferedImage.TYPE_INT_ARGB),
				client);

			modIcons = Arrays.copyOf(modIcons, friendsChatOffset + friendsChatIcons.size() + clanIcons.size());
			Arrays.fill(modIcons, friendsChatOffset, modIcons.length, blank);

			client.setModIcons(modIcons);
		}

		friendsChatRankImages = new BufferedImage[friendsChatIcons.size()];
		clanRankImages = new BufferedImage[clanIcons.size()];

		for (int i = 0; i < friendsChatIcons.size(); i++)
		{
			final int fi = i;

			spriteManager.getSpriteAsync(friendsChatIcons.getIntValue(friendsChatIcons.getKeys()[i]), 0, sprite ->
			{
				final IndexedSprite[] modIcons = client.getModIcons();
				friendsChatRankImages[fi] = friendsChatImageFromSprite(sprite);
				modIcons[friendsChatOffset + fi] = ImageUtil.getImageIndexedSprite(friendsChatRankImages[fi], client);
			});
		}

		for (int i = 0; i < clanIcons.size(); i++)
		{
			final int key = clanIcons.getKeys()[i];
			final int idx = clanRankToIdx(key);

			assert idx >= 0 && idx < clanIcons.size();

			spriteManager.getSpriteAsync(clanIcons.getIntValue(key), 0, sprite ->
			{
				final IndexedSprite[] modIcons = client.getModIcons();
				final BufferedImage img = ImageUtil.resizeCanvas(sprite, IMAGE_DIMENSION.width, IMAGE_DIMENSION.height);
				clanRankImages[idx] = img;
				modIcons[clanOffset + idx] = ImageUtil.getImageIndexedSprite(img, client);
			});
		}
	}

	private static BufferedImage friendsChatImageFromSprite(final BufferedImage sprite)
	{
		final BufferedImage canvas = ImageUtil.resizeCanvas(sprite, IMAGE_DIMENSION.width, IMAGE_DIMENSION.height);
		return ImageUtil.outlineImage(canvas, IMAGE_OUTLINE_COLOR);
	}

	private static int clanRankToIdx(int key)
	{
		// keys are -6 to 265, with no 0
		return key < 0 ? ~key : (key + 5);
	}
}
