/*
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
package net.runelite.client.plugins.clanchat;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Clan chat"
)
@Slf4j
public class ClanChatPlugin extends Plugin
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
		.expireAfterAccess(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, ClanMemberRank>()
		{
			@Override
			public ClanMemberRank load(String key) throws Exception
			{
				final ClanMember[] clanMembersArr = client.getClanMembers();

				if (clanMembersArr == null || clanMembersArr.length == 0)
				{
					return ClanMemberRank.UNRANKED;
				}

				return Arrays.stream(clanMembersArr)
					.filter(Objects::nonNull)
					.filter(clanMember -> sanitize(clanMember.getUsername()).equals(sanitize(key)))
					.map(ClanMember::getRank)
					.findAny()
					.orElse(ClanMemberRank.UNRANKED);
			}
		});

	private int modIconsLength;

	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
		if (modIconsLength == 0 && client.getGameState().compareTo(GameState.LOGIN_SCREEN) >= 0)
		{
			loadClanChatIcons();
		}
	}

	@Override
	protected void shutDown()
	{
		clanRanksCache.invalidateAll();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN
			&& modIconsLength == 0)
		{
			// this is after "Loading sprites" so we can modify modicons now
			loadClanChatIcons();
		}
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void updateClanChatTitle()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null)
		{
			clanChatTitleWidget.setText("Clan Chat (" + client.getClanChatCount() + "/100)");
		}
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (setMessage.getType() == ChatMessageType.CLANCHAT && client.getClanChatCount() > 0)
		{
			insertClanRankIcon(setMessage);
		}
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

	private void insertClanRankIcon(final SetMessage message)
	{
		final String playerName = sanitize(message.getName());
		final ClanMemberRank rank = clanRanksCache.getUnchecked(playerName);

		if (rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = getIconNumber(rank);
			message.getMessageNode()
				.setSender(message.getMessageNode().getSender() + " <img=" + iconNumber + ">");
			client.refreshChat();
		}
	}

	private int getIconNumber(final ClanMemberRank clanMemberRank)
	{
		return modIconsLength - CLANCHAT_IMAGES.length + clanMemberRank.getValue();
	}

	private static String sanitize(String lookup)
	{
		final String cleaned = lookup.contains("<img") ? lookup.substring(lookup.lastIndexOf('>') + 1) : lookup;
		return cleaned.replace('\u00A0', ' ');
	}
}
