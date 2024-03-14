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
import lombok.Value;

@Data
public class SequenceDefinition
{
	private final int id;
	public int[] frameIDs; // top 16 bits are FrameDefinition ids
	public int[] chatFrameIds;
	public int[] frameLenghts;
	public Sound[] frameSounds;
	public int frameStep = -1;
	public int[] interleaveLeave;
	public boolean stretches = false;
	public int forcedPriority = 5;
	public int leftHandItem = -1;
	public int rightHandItem = -1;
	public int maxLoops = 99;
	public int precedenceAnimating = -1;
	public int priority = -1;
	public int replyMode = 2;
	public int animMayaID = -1;
	public Map<Integer, Sound> animMayaFrameSounds;
	public int animMayaStart;
	public int animMayaEnd;
	public boolean[] animMayaMasks;

	@Value
	public static class Sound
	{
		public int id;
		public int loops;
		public int location;
		public int retain;
	}
}
