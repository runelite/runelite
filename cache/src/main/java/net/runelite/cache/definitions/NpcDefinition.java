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
import lombok.Data;

@Data
public class NpcDefinition
{
	public final int id;
	public String name = "null";
	public int size = 1;
	public int[] models;
	public int[] heads;
	public int readyanim = -1;
	public int idleRotateLeftAnimation = -1;
	public int idleRotateRightAnimation = -1;
	public int walkanim = -1;
	public int walkanim_b = -1;
	public int walkanim_r = -1;
	public int walkanim_l = -1;
	public int runanim = -1;
	public int runanim_b = -1;
	public int runanim_r = -1;
	public int runanim_l = -1;
	public int crawlanim = -1;
	public int crawlanim_b = -1;
	public int crawlanim_r = -1;
	public int crawlanim_l = -1;
	public short[] recol_s;
	public short[] recol_d;
	public short[] retex_s;
	public short[] retex_d;
	public String[] op = new String[5];
	public boolean minimap = true;
	public int vislevel = -1;
	public int resizeh = 128;
	public int resizev = 128;
	public boolean drawabove;
	public int ambient;
	public int contrast;
	public int[] headIconArchiveIds;
	public short[] headIconSpriteIndex;
	public int turnspeed = 32;
	public int[] multinpc;
	public int multivarbit = -1;
	public int multivarp = -1;
	public boolean active = true;
	public boolean walksmoothing = true;
	public boolean follower;
	public boolean lowPriorityFollowerOps;
	public Map<Integer, Object> params;
	public int category;
}
