/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.cache;

import net.runelite.cache.definitions.loaders.*;

import java.util.Arrays;
import java.util.Optional;

public enum ConfigType
{
	// types from https://github.com/im-frizzy/OpenRS/blob/master/source/net/openrs/cache/type/ConfigArchive.java
	UNDERLAY(1, UnderlayLoader.class),
	IDENTKIT(3, KitLoader.class),
	OVERLAY(4, OverlayLoader.class),
	INV(5, InventoryLoader.class),
	OBJECT(6, ObjectLoader.class),
	ENUM(8, EnumLoader.class),
	NPC(9, NpcLoader.class),
	ITEM(10, NpcLoader.class),
	PARAMS(11, ParamLoader.class),
	SEQUENCE(12, SequenceLoader.class),
	SPOTANIM(13, SpotAnimLoader.class),
	VARBIT(14, VarbitLoader.class),
	VARCLIENT(19, DefaultLoader.class),
	VARCLIENTSTRING(15, DefaultLoader.class),
	VARPLAYER(16, DefaultLoader.class),
	HITSPLAT(32, HitSplatLoader.class),
	HEALTHBAR(33, HealthBarLoader.class),
	STRUCT(34, StructLoader.class),
	AREA(35, AreaLoader.class);

	private final int id;
	private final Class loaderClass;

	ConfigType(int id, Class loaderClass)
	{
		this.id = id;
		this.loaderClass = loaderClass;
	}

	public int getId()
	{
		return id;
	}

	public Class getLoader()
	{
		return loaderClass;
	}

	public static Optional<ConfigType> valueOf(int value)
	{
		return Arrays.stream(values())
				.filter(configType -> configType.id == value)
				.findFirst();
	}
}
