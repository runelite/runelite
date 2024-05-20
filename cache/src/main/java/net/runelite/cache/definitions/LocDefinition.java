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
public class LocDefinition
{
	private int id;
	private short[] retex_s;
	private int wallwidth = 16;
	private boolean breakroutefinding = false;
	private String name = "null";
	private int[] models;
	private int[] shapes;
	private short[] recol_s;
	private int mapAreaId = -1;
	private short[] retex_d;
	private int width = 1;
	private int length = 1;
	private int bgsound_range = 0;
	private int[] bgsound_random;
	private int ambientSoundRetain;
	private int xoff = 0;
	private boolean sharelight = false;
	private int active = -1;
	private int anim = -1;
	private int multivarbit = -1;
	private int ambient = 0;
	private int contrast = 0;
	private String[] op = new String[5];
	private int blockwalk = 2;
	private int mapscene = -1;
	private int forceapproach = 0;
	private short[] recol_d;
	private boolean shadow = true;
	private int resizex = 128;
	private int resizey = 128;
	private int resizez = 128;
	private int objectID;
	private int yoff = 0;
	private int zoff = 0;
	private boolean forcedecor = false;
	private int hillchange = -1;
	private int raiseobject = -1;
	private int[] multiloc;
	private int category;
	private boolean mirror = false;
	private int multivarp = -1;
	private int bgsound_sound = -1;
	private boolean occlude = false;
	private int bgsound_mindelay = 0;
	private int bgsound_maxdelay = 0;
	private boolean blockrange = true;
	private boolean randomanimframe;
	private Map<Integer, Object> params = null;
}
