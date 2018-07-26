/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.api.ObjectID.*;
import static net.runelite.api.NullObjectID.*;

@Slf4j
public enum PohIcons
{
	EXITPORTAL("exitportal", PORTAL_4525),
	VARROCK("varrock", NULL_13615, NULL_13622, NULL_13629),
	FALADOR("falador", FALADOR_PORTAL, FALADOR_PORTAL_13624, FALADOR_PORTAL_13631),
	LUMBRIDGE("lumbridge", LUMBRIDGE_PORTAL, LUMBRIDGE_PORTAL_13623, LUMBRIDGE_PORTAL_13630),
	ARDOUGNE("ardougne", ARDOUGNE_PORTAL, ARDOUGNE_PORTAL_13626, ARDOUGNE_PORTAL_13633),
	YANILLE("yanille", NULL_13620, NULL_13627, NULL_13634),
	CAMELOT("camelot", NULL_13618, NULL_13625, NULL_13632),
	LUNARISLE("lunarisle", LUNAR_ISLE_PORTAL, LUNAR_ISLE_PORTAL_29347, LUNAR_ISLE_PORTAL_29355),
	WATERBIRTH("waterbirth", WATERBIRTH_ISLAND_PORTAL, WATERBIRTH_ISLAND_PORTAL_29350, WATERBIRTH_ISLAND_PORTAL_29358),
	FISHINGGUILD("fishingguild", FISHING_GUILD_PORTAL, FISHING_GUILD_PORTAL_29351, FISHING_GUILD_PORTAL_29359),
	SENNTISTEN("senntisten", SENNTISTEN_PORTAL, SENNTISTEN_PORTAL_29348, SENNTISTEN_PORTAL_29356),
	KHARYLL("kharyll", KHARYRLL_PORTAL, KHARYRLL_PORTAL_29346, KHARYRLL_PORTAL_29354),
	ANNAKARL("annakarl", ANNAKARL_PORTAL, ANNAKARL_PORTAL_29349, ANNAKARL_PORTAL_29357),
	KOUREND("kourend", KOUREND_PORTAL, KOUREND_PORTAL_29353, KOUREND_PORTAL_29361),
	MARIM("marim", MARIM_PORTAL, MARIM_PORTAL_29352, MARIM_PORTAL_29360),
	ALTAR("altar",
		ALTAR_13179, ALTAR_13180, ALTAR_13181, ALTAR_13182, ALTAR_13183, ALTAR_13184, ALTAR_13185, ALTAR_13186,
		ALTAR_13187, ALTAR_13188, ALTAR_13189, ALTAR_13190, ALTAR_13191, ALTAR_13192, ALTAR_13193, ALTAR_13194,
		ALTAR_13194, ALTAR_13196, ALTAR_13197, ALTAR_13198, ALTAR_13199
	),
	POOLS("pool", POOL_OF_RESTORATION, POOL_OF_REVITALISATION, POOL_OF_REJUVENATION, FANCY_REJUVENATION_POOL, ORNATE_REJUVENATION_POOL),
	GLORY("glory", AMULET_OF_GLORY),
	REPAIR("repair", ARMOUR_REPAIR_STAND),
	SPELLBOOKALTAR("spellbook", ANCIENT_ALTAR, LUNAR_ALTAR, DARK_ALTAR, ALTAR_OF_THE_OCCULT),
	JEWELLERYBOX("jewellery", BASIC_JEWELLERY_BOX, FANCY_JEWELLERY_BOX, ORNATE_JEWELLERY_BOX),
	MAGICTRAVEL("transportation", SPIRIT_TREE_29227, NULL_29228, NULL_29229, OBELISK_31554);


	private static final Map<Integer, PohIcons> minimapIcons = new HashMap<>();

	@Getter
	private final String imageResource;
	@Getter
	private final int[] Ids;

	private BufferedImage image;

	static
	{
		PohIcons[] icons = values();

		for (PohIcons icon : icons)
		{
			for (Integer spotId : icon.getIds())
			{
				minimapIcons.put(spotId, icon);
			}
		}
	}

	PohIcons(String imageResource, int... ids)
	{
		this.imageResource = imageResource;
		this.Ids = ids;
	}

	public static PohIcons getIcon(int id)
	{
		return minimapIcons.get(id);
	}

	public BufferedImage getImage()
	{
		if (image != null)
		{
			return image;
		}

		try
		{
			synchronized (ImageIO.class)
			{
				image = ImageIO.read(PohIcons.class.getResourceAsStream(getImageResource() + ".png"));
			}
		}
		catch (IOException ex)
		{
			log.warn("unable to load image", ex);
		}

		return image;
	}
}
