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
package net.runelite.cache.definitions.loaders;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.SequenceDefinition;
import net.runelite.cache.io.InputStream;

@Accessors(chain = true)
@Data
@Slf4j
public class SequenceLoader
{
	public static final int REV_220_SEQ_ARCHIVE_REV = 1141;
	public static final int REV_226_SEQ_ARCHIVE_REV = 1268;

	private boolean rev220FrameSounds = true;
	private boolean rev226 = true;

	public SequenceLoader configureForRevision(int rev)
	{
		this.rev220FrameSounds = rev > REV_220_SEQ_ARCHIVE_REV;
		this.rev226 = rev > REV_226_SEQ_ARCHIVE_REV;
		return this;
	}

	public SequenceDefinition load(int id, byte[] b)
	{
		SequenceDefinition def = new SequenceDefinition(id);
		InputStream is = new InputStream(b);

		while (true)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			this.decodeValues(opcode, def, is);
		}

		return def;
	}

	private void decodeValues(int opcode, SequenceDefinition def, InputStream stream)
	{
		int var3;
		int var4;
		if (opcode == 1)
		{
			var3 = stream.readUnsignedShort();
			def.frameLengths = new int[var3];

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.frameLengths[var4] = stream.readUnsignedShort();
			}

			def.frameIDs = new int[var3];

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.frameIDs[var4] = stream.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.frameIDs[var4] += stream.readUnsignedShort() << 16;
			}
		}
		else if (opcode == 2)
		{
			def.frameStep = stream.readUnsignedShort();
		}
		else if (opcode == 3)
		{
			var3 = stream.readUnsignedByte();
			def.interleaveLeave = new int[1 + var3];

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.interleaveLeave[var4] = stream.readUnsignedByte();
			}

			def.interleaveLeave[var3] = 9999999;
		}
		else if (opcode == 4)
		{
			def.stretches = true;
		}
		else if (opcode == 5)
		{
			def.forcedPriority = stream.readUnsignedByte();
		}
		else if (opcode == 6)
		{
			def.leftHandItem = stream.readUnsignedShort();
		}
		else if (opcode == 7)
		{
			def.rightHandItem = stream.readUnsignedShort();
		}
		else if (opcode == 8)
		{
			def.maxLoops = stream.readUnsignedByte();
		}
		else if (opcode == 9)
		{
			def.precedenceAnimating = stream.readUnsignedByte();
		}
		else if (opcode == 10)
		{
			def.priority = stream.readUnsignedByte();
		}
		else if (opcode == 11)
		{
			def.replyMode = stream.readUnsignedByte();
		}
		else if (opcode == 12)
		{
			var3 = stream.readUnsignedByte();
			def.chatFrameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.chatFrameIds[var4] = stream.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.chatFrameIds[var4] += stream.readUnsignedShort() << 16;
			}
		}
		else if (opcode == 13 && !rev226)
		{
			var3 = stream.readUnsignedByte();

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.frameSounds.put(var4, this.readFrameSound(stream));
			}
		}
		else if (opcode == (rev226 ? 13 : 14))
		{
			def.animMayaID = stream.readInt();
		}
		else if (opcode == (rev226 ? 14 : 15))
		{
			var3 = stream.readUnsignedShort();

			for (var4 = 0; var4 < var3; ++var4)
			{
				int frame = stream.readUnsignedShort();
				def.frameSounds.put(frame, this.readFrameSound(stream));
			}
		}
		else if (opcode == (rev226 ? 15 : 16))
		{
			def.animMayaStart = stream.readUnsignedShort();
			def.animMayaEnd = stream.readUnsignedShort();
		}
		else if (opcode == 17)
		{
			def.animMayaMasks = new boolean[256];

			var3 = stream.readUnsignedByte();

			for (var4 = 0; var4 < var3; ++var4)
			{
				def.animMayaMasks[stream.readUnsignedByte()] = true;
			}
		}
		else
		{
			log.warn("Unrecognized opcode {}", opcode);
		}
	}

	private SequenceDefinition.Sound readFrameSound(InputStream stream)
	{
		int id;
		int loops;
		int location;
		int retain;
		int weight = -1;
		if (!rev220FrameSounds)
		{
			int bits = stream.read24BitInt();
			location = bits & 15;
			id = bits >> 8;
			loops = bits >> 4 & 7;
			retain = 0;
		}
		else
		{
			id = stream.readUnsignedShort();
			if (rev226)
			{
				weight = stream.readUnsignedByte();
			}
			loops = stream.readUnsignedByte();
			location = stream.readUnsignedByte();
			retain = stream.readUnsignedByte();
		}

		if (id >= 1 && loops >= 1 && location >= 0 && retain >= 0)
		{
			return new SequenceDefinition.Sound(id, loops, location, retain, weight);
		}
		else
		{
			return null;
		}
	}
}
