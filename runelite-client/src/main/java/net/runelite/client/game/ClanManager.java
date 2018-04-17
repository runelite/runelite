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
import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.util.Text;

@Singleton
@Slf4j
public class ClanManager
{
	private static final String[] CLANCHAT_IMAGES =
		{
			"Friend_clan_rank.png", "Recruit_clan_rank.png",
			"Corporal_clan_rank.png", "Sergeant_clan_rank.png",
			"Lieutenant_clan_rank.png", "Captain_clan_rank.png",
			"General_clan_rank.png", "Owner_clan_rank.png"
		};

	private int modIconsLength;

	private final Provider<Client> clientProvider;
	private final BufferedImage[] clanChatImages = new BufferedImage[CLANCHAT_IMAGES.length];

	private final LoadingCache<String, ClanMemberRank> clanRanksCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, ClanMemberRank>()
		{
			@Override
			public ClanMemberRank load(String key) throws Exception
			{
				final Client client = clientProvider.get();
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

	@Inject
	public ClanManager(Provider<Client> clientProvider)
	{
		this.clientProvider = clientProvider;

		int i = 0;
		for (String resource : CLANCHAT_IMAGES)
		{
			try
			{
				final BufferedImage bufferedImage = rgbaToIndexedBufferedImage(ImageIO
					.read(ClanManager.class.getResource(resource)));
				clanChatImages[i] = bufferedImage;
			}
			catch (IOException e)
			{
				log.warn("unable to load clan image", e);
			}

			++i;
		}
	}

	public ClanMemberRank getRank(String playerName)
	{
		return clanRanksCache.getUnchecked(playerName);
	}

	public BufferedImage getClanImage(final ClanMemberRank clanMemberRank)
	{
		if (clanMemberRank == ClanMemberRank.UNRANKED)
		{
			return null;
		}
		return clanChatImages[clanMemberRank.getValue()];
	}

	public int getIconNumber(final ClanMemberRank clanMemberRank)
	{
		return modIconsLength - CLANCHAT_IMAGES.length + clanMemberRank.getValue();
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

	@Subscribe
	public void onClanChange(ClanChanged clanChanged)
	{
		clanRanksCache.invalidateAll();
	}

	private void loadClanChatIcons()
	{
		try
		{
			final Client client = clientProvider.get();
			final IndexedSprite[] modIcons = client.getModIcons();
			final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + CLANCHAT_IMAGES.length);
			int curPosition = newModIcons.length - CLANCHAT_IMAGES.length;

			for (BufferedImage image : clanChatImages)
			{
				IndexedSprite sprite = createIndexedSprite(client, image);
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

	private static String sanitize(String lookup)
	{
		final String cleaned = Text.removeTags(lookup);
		return cleaned.replace('\u00A0', ' ');
	}

	private static IndexedSprite createIndexedSprite(final Client client, final BufferedImage bufferedImage) throws IOException
	{
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
}
