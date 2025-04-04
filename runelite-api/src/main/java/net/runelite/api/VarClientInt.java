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
package net.runelite.api;

/**
 * Client side only, content-developer integers
 *
 * VarCInts are stored entirely in memory, or locally on a user's
 * machine in the preferences2.dat file depending on how Jagex
 * configured the variable
 */
public final class VarClientInt
{
	public static final int TOOLTIP_TIMEOUT = 1;

	/**
	 * 0 = no tooltip displayed
	 * 1 = tooltip displaying
	 */
	public static final int TOOLTIP_VISIBLE = 2;

	/**
	 * Current message layer mode
	 * @see net.runelite.api.vars.InputType
	 */
	public static final int INPUT_TYPE = 5;

	public static final int BANK_SCROLL = 51;

	/**
	 * The game sets this to the same value as {@link #CAMERA_ZOOM_RESIZABLE_VIEWPORT}
	 */
	public static final int CAMERA_ZOOM_FIXED_VIEWPORT = 73;
	public static final int CAMERA_ZOOM_RESIZABLE_VIEWPORT = 74;

	public static final int MEMBERSHIP_STATUS = 103;

	public static final int INVENTORY_TAB = 171;

	/**
	 * time to block keypresses til
	 */
	public static final int BLOCK_KEYPRESS = 187;

	public static final int WORLD_MAP_SEARCH_FOCUSED = 190;

	/**
	 * The player's special attack regeneration interval in ticks
	 * <p>
	 * Ticks = {@code (VALUE & ((1 << 22) - 1)) >> 11}
	 */
	public static final int SPEC_REGEN_INTERVAL = 987;
}
