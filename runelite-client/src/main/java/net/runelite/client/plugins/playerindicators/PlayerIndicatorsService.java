/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.Player;
import net.runelite.api.PlayerNameMask;
import net.runelite.api.events.SetMessage;
import net.runelite.api.Text;

@Singleton
@Slf4j
public class PlayerIndicatorsService
{
	private static final String[] CLANCHAT_IMAGES =
		{
			"Friend_clan_rank.png", "Recruit_clan_rank.png",
			"Corporal_clan_rank.png", "Sergeant_clan_rank.png",
			"Lieutenant_clan_rank.png", "Captain_clan_rank.png",
			"General_clan_rank.png", "Owner_clan_rank.png"
		};

	private final LoadingCache<String, ClanMemberRank> clanRanksCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, ClanMemberRank>()
		{
			@Override
			public ClanMemberRank load(@Nonnull String key)
			{
				final ClanMember[] clanMembersArr = client.getClanMembers();

				if (clanMembersArr == null || clanMembersArr.length == 0)
				{
					return ClanMemberRank.UNRANKED;
				}

				return Arrays.stream(clanMembersArr)
					.filter(Objects::nonNull)
					.filter(clanMember -> clanMember.getUsername().equals(key))
					.map(ClanMember::getRank)
					.findAny()
					.orElse(ClanMemberRank.UNRANKED);
			}
		});

	private final Client client;
	private final PlayerIndicatorsConfig config;
	private int modIconsLength;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config)
	{
		this.config = config;
		this.client = client;
	}

	public void invalidatePlayerNames()
	{
		// Reset player names
		for (Player player : client.getPlayers())
		{
			if (player != null && player.getName() != null)
			{
				player.setName(player.getName());
			}
		}

		// Refresh chat box
		client.refreshChat();
	}

	public void invalidateClanRanksCache()
	{
		// Invalidate clan cache
		clanRanksCache.invalidateAll();
	}

	public void updateConfig()
	{
		// Update mod icons
		if (modIconsLength == 0 && client.getGameState().compareTo(GameState.LOGGED_IN) >= 0)
		{
			loadClanChatIcons();
		}

		// Update mask
		int baseMask = 0;

		if (config.drawFriendNames())
		{
			baseMask |= PlayerNameMask.DRAW_FRIEND_NAME;
		}

		if (config.drawClanMemberNames())
		{
			baseMask |= PlayerNameMask.DRAW_CLAN_NAME;
		}

		if (config.drawOwnName())
		{
			baseMask |= PlayerNameMask.DRAW_OWN_NAME;
		}

		if (config.drawNonOwnNames())
		{
			baseMask |= PlayerNameMask.DRAW_ALL_EXCEPT_OWN_NAME;
		}

		client.setPlayerNameMask(baseMask);
	}

	public void updatePlayers()
	{
		// Update player names
		forEachPlayer(this::injectData);
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		final Player localPlayer = client.getLocalPlayer();

		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null)
			{
				continue;
			}

			boolean isClanMember = player.isClanMember();

			if (player == localPlayer)
			{
				if (config.drawOwnName())
				{
					consumer.accept(player, config.getOwnNameColor());
				}
			}
			else if (config.drawFriendNames() && player.isFriend())
			{
				consumer.accept(player, config.getFriendNameColor());
			}
			else if (config.drawClanMemberNames() && isClanMember)
			{
				consumer.accept(player, config.getClanMemberColor());
			}
			else if (config.drawTeamMemberNames() && localPlayer.getTeam() > 0 && localPlayer.getTeam() == player.getTeam())
			{
				consumer.accept(player, config.getTeamMemberColor());
			}
			else if (config.drawNonOwnNames())
			{
				consumer.accept(player, config.getNonOwnColor());
			}
		}
	}

	public void insertClanRankIcon(final SetMessage message)
	{
		if (!config.showClanRankIcons())
		{
			return;
		}

		final String playerName = Text.removeTags(message.getName());
		final ClanMemberRank rank = clanRanksCache.getUnchecked(playerName);

		if (rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = getIconNumber(rank);
			message.getMessageNode()
				.setSender(message.getMessageNode().getSender() + " <img=" + iconNumber + ">");
			client.refreshChat();
		}
	}

	private void injectData(final Player player, final Color color)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		final String playerName = player.getName();

		if (config.showClanRankIcons() && player.isClanMember())
		{
			final ClanMemberRank clanMemberRank = clanRanksCache.getUnchecked(playerName);

			if (clanMemberRank != ClanMemberRank.UNRANKED)
			{
				stringBuilder
					.append("<img=")
					.append(getIconNumber(clanMemberRank))
					.append(">");
			}
		}
		
		stringBuilder.append("<col=").append(parseColor(color)).append(">");
		player.setName(stringBuilder.toString() + playerName);
	}

	private static String parseColor(final Color color)
	{
		return String.format("%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
	}

	private void loadClanChatIcons()
	{
		try
		{
			final IndexedSprite[] modIcons = client.getModIcons();
			final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + CLANCHAT_IMAGES.length);
			int curPosition = newModIcons.length - CLANCHAT_IMAGES.length;

			for (String resource : CLANCHAT_IMAGES)
			{
				IndexedSprite sprite = createIndexedSprite(resource);
				newModIcons[curPosition++] = sprite;
			}

			client.setModIcons(newModIcons);
			modIconsLength = newModIcons.length;
		}
		catch (IOException e)
		{
			log.warn("Failed loading of clan chat icons", e);
		}
	}

	private IndexedSprite createIndexedSprite(final String imagePath) throws IOException
	{
		final BufferedImage bufferedImage = rgbaToIndexedBufferedImage(ImageIO
			.read(this.getClass().getResource(imagePath)));

		final IndexColorModel indexedCM = (IndexColorModel) bufferedImage.getColorModel();

		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();
		final byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
		final int[] palette = new int[indexedCM.getMapSize()];
		indexedCM.getRGBs(palette);

		final IndexedSprite newIndexedSprite = client.createIndexedSprite();
		newIndexedSprite.setPixels(pixels);
		newIndexedSprite.setPalette(palette);
		newIndexedSprite.setWidth(width);
		newIndexedSprite.setHeight(height);
		newIndexedSprite.setOriginalWidth(width);
		newIndexedSprite.setOriginalHeight(height);
		newIndexedSprite.setOffsetX(0);
		newIndexedSprite.setOffsetY(0);
		return newIndexedSprite;
	}

	private static BufferedImage rgbaToIndexedBufferedImage(final BufferedImage sourceBufferedImage)
	{
		final BufferedImage indexedImage = new BufferedImage(
			sourceBufferedImage.getWidth(),
			sourceBufferedImage.getHeight(),
			BufferedImage.TYPE_BYTE_INDEXED);

		final ColorModel cm = indexedImage.getColorModel();
		final IndexColorModel icm = (IndexColorModel) cm;

		final int size = icm.getMapSize();
		final byte[] reds = new byte[size];
		final byte[] greens = new byte[size];
		final byte[] blues = new byte[size];
		icm.getReds(reds);
		icm.getGreens(greens);
		icm.getBlues(blues);

		final WritableRaster raster = indexedImage.getRaster();
		final int pixel = raster.getSample(0, 0, 0);
		final IndexColorModel resultIcm = new IndexColorModel(8, size, reds, greens, blues, pixel);
		final BufferedImage resultIndexedImage = new BufferedImage(resultIcm, raster, sourceBufferedImage.isAlphaPremultiplied(), null);
		resultIndexedImage.getGraphics().drawImage(sourceBufferedImage, 0, 0, null);
		return resultIndexedImage;
	}

	private int getIconNumber(final ClanMemberRank clanMemberRank)
	{
		return modIconsLength - CLANCHAT_IMAGES.length + clanMemberRank.getValue();
	}
}
