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

package net.runelite.cache.definitions;

import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class NpcDefinition
{

	public final int id;
	public short[] recolorToFind;
	public int rotation = 32;
	public String name = "null";
	public short[] recolorToReplace;
	public int[] models;
	public int[] models_2;
	public int stanceAnimation = -1;
	public int anInt2165 = -1;
	public int tileSpacesOccupied = 1;
	public int walkAnimation = -1;
	public short[] retextureToReplace;
	public int rotate90RightAnimation = -1;
	public boolean aBool2170 = true;
	public int resizeX = 128;
	public int contrast = 0;
	public int rotate180Animation = -1;
	public int varbitIndex = -1;
	public String[] options = new String[5];
	public boolean renderOnMinimap = true;
	public int combatLevel = -1;
	public int rotate90LeftAnimation = -1;
	public int resizeY = 128;
	public boolean hasRenderPriority = false;
	public int ambient = 0;
	public int headIcon = -1;
	public int[] configs;
	public short[] retextureToFind;
	public int varpIndex = -1;
	public boolean isClickable = true;
	public int anInt2189 = -1;
	public boolean aBool2190 = false;
	public Map<Integer, Object> params = null;
}
