/*
 * Copyright (c) 2019, Shaun Dreclin <https://github.com/ShaunDreclin>
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
package net.runelite.api;

/**
 * Utility class used for mapping enum IDs.
 * <p>
 * Note: This class is not complete and may be missing mapped IDs.
 */
public final class EnumID
{
	/**
	 * key: int
	 * val: string creature name
	 */
	public static final int SLAYER_TASK_CREATURE = 693;

	public static final int MUSIC_TRACK_NAMES = 812;
	public static final int MUSIC_TRACK_IDS = 819;
	/**
	 * key: int 1-n+1
	 * val: namedobj
	 */
	public static final int RUNEPOUCH_RUNE = 982;
	public static final int XPDROP_COLORS = 1169;
	/**
	 * key: int
	 * val: string boss name
	 */
	public static final int SLAYER_TASK_BOSS = 1174;
	public static final int FRIENDS_CHAT_RANK_ICONS = 1543;
	/**
	 * key: int 0-n
	 * val: namedobj
	 */
	public static final int PETS = 2158;
	public static final int CLAN_RANK_NAME = 3797;
	public static final int CLAN_RANK_GRAPHIC = 3798;

	/**
	 * key: int
	 * val: string location name
	 */
	public static final int SLAYER_TASK_LOCATION = 4064;

	/**
	 * key: mapelement
	 * val: dbrow
	 */
	public static final int MAPELEMENT_TO_QUEST = 4385;
}
