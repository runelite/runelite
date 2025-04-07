/*
 * Copyright (c) 2025 Abex
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
package net.runelite.cache.definitions.loaders;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import net.runelite.cache.definitions.GameValDefinition;
import net.runelite.cache.io.InputStream;

public class GameValLoader
{
	public static final int ITEMS = 0;
	public static final int NPCS = 1;
	public static final int INVENTORIES = 2;
	public static final int VARPS = 3;
	public static final int VARBITS = 4;
	public static final int OBJECTS = 6;
	public static final int ANIMATIONS = 7;
	public static final int SPOTANIMS = 8;
	public static final int DBROWS = 9;
	public static final int DBTABLES = 10;
	public static final int JINGLES = 11;
	public static final int SPRITES = 12;
	public static final int INTERFACES = 13;

	public GameValDefinition load(int gameValId, int id, byte[] data)
	{
		var v = new GameValDefinition();
		v.setGameValId(gameValId);
		v.setId(id);

		if (gameValId == 10)
		{
			var is = new InputStream(data);

			is.readUnsignedByte();
			v.setName(is.readString());
			v.setFiles(new HashMap<>());

			for (int iid = 0; ; iid++)
			{
				int counter = is.readUnsignedByte();
				if (counter == 0)
				{
					break;
				}

				v.getFiles().put(iid, is.readString());
			}
		}
		else if (gameValId == 13)
		{
			var is = new InputStream(data);

			v.setName(is.readString());
			v.setFiles(new HashMap<>());

			for (; ; )
			{
				int iid = is.readUnsignedByte();
				if (iid == 0xFF)
				{
					break;
				}

				v.getFiles().put(iid, is.readString());
			}
		}
		else
		{
			v.setName(new String(data, StandardCharsets.UTF_8));
		}

		return v;
	}
}
