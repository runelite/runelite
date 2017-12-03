/*
 * Copyright (c) 2016-2017, Cameron Moberg <Moberg@tuta.io>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.bosstimer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
enum Boss
{
	GENERAL_GRAARDOR("General Graardor", 90, ChronoUnit.SECONDS, "bando"),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", 90, ChronoUnit.SECONDS, "zammy"),
	KREEARRA("Kree'arra", 90, ChronoUnit.SECONDS, "arma"),
	COMMANDER_ZILYANA("Commander Zilyana", 90, ChronoUnit.SECONDS, "sara"),
	CALLISTO("Callisto", 30, ChronoUnit.SECONDS, "callisto"),
	CHAOS_FANATIC("Chaos fanatic", 30, ChronoUnit.SECONDS, "chaos_fanatic"),
	CRAZY_ARCHAEOLOGIST("Crazy archaeologist", 30, ChronoUnit.SECONDS, "crazy_arch"),
	KING_BLACK_DRAGON("King Black Dragon", 10, ChronoUnit.SECONDS, "kbd"),
	SCORPIA("Scorpia", 10, ChronoUnit.SECONDS, "scorpia"),
	VENENATIS("Venenatis", 30, ChronoUnit.SECONDS, "venenatis"),
	VETION("Vet'ion", 30, ChronoUnit.SECONDS, "vetion"),
	DAGANNOTH_PRIME("Dagannoth Prime", 90, ChronoUnit.SECONDS, "prime"),
	DAGANNOTH_REX("Dagannoth Rex", 90, ChronoUnit.SECONDS, "rex"),
	DAGANNOTH_SUPREME("Dagannoth Supreme", 90, ChronoUnit.SECONDS, "supreme"),
	CORPOREAL_BEAST("Corporeal Beast", 30, ChronoUnit.SECONDS, "corp"),
	GIANT_MOLE("Giant Mole", 10, ChronoUnit.SECONDS, "mole");

	private static final Map<String, Boss> bosses = new HashMap<>();

	private final String name;
	private final Duration spawnTime;
	private final String imageResource;

	private BufferedImage image;

	static
	{
		for (Boss boss : values())
		{
			bosses.put(boss.getName(), boss);
		}
	}

	private Boss(String name, long period, ChronoUnit unit, String imageResource)
	{
		this.name = name;
		this.spawnTime = Duration.of(period, unit);
		this.imageResource = imageResource;
	}

	public String getName()
	{
		return name;
	}

	public Duration getSpawnTime()
	{
		return spawnTime;
	}

	public BufferedImage getImage()
	{
		if (image != null)
		{
			return image;
		}

		InputStream in = Boss.class.getResourceAsStream(imageResource + ".png");
		try
		{
			image = ImageIO.read(in);
		}
		catch (IOException ex)
		{
			log.warn("unable to load image", ex);
		}

		return image;
	}

	public static Boss find(String name)
	{
		return bosses.get(name);
	}
}
