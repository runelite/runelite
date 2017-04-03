/*
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
package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.TrackDefinition;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;

public class TrackLoader
{
	public TrackDefinition load(byte[] b)
	{
		TrackDefinition def = new TrackDefinition();
		load(def, new InputStream(b));
		return def;
	}

	private void load(TrackDefinition def, InputStream var1)
	{
		// Some of the names are from https://www.rune-server.ee/runescape-development/rs-503-client-server/snippets/311669-rs-music-file-structure-conversion.html
		var1.setOffset(var1.getLength() - 3);
		int tracks = var1.readUnsignedByte();
		int division = var1.readUnsignedShort();
		int offset = 14 + tracks * 10;
		var1.setOffset(0);
		int tempoOpcodes = 0;
		int ctrlChangeOpcodes = 0;
		int noteOnOpcodes = 0;
		int noteOffOpcodes = 0;
		int wheelChangeOpcodes = 0;
		int chnnlAfterTchOpcodes = 0;
		int keyAfterTchOpcodes = 0;
		int progmChangeOpcodes = 0;

		int var13;
		int opcode;
		int var15;
		for (var13 = 0; var13 < tracks; ++var13)
		{
			opcode = -1;

			while (true)
			{
				var15 = var1.readUnsignedByte();
				if (var15 != opcode)
				{
					++offset;
				}

				opcode = var15 & 15;
				if (var15 == 7)
				{
					break;
				}

				if (var15 == 23)
				{
					++tempoOpcodes;
				}
				else if (opcode == 0)
				{
					++noteOnOpcodes;
				}
				else if (opcode == 1)
				{
					++noteOffOpcodes;
				}
				else if (opcode == 2)
				{
					++ctrlChangeOpcodes;
				}
				else if (opcode == 3)
				{
					++wheelChangeOpcodes;
				}
				else if (opcode == 4)
				{
					++chnnlAfterTchOpcodes;
				}
				else if (opcode == 5)
				{
					++keyAfterTchOpcodes;
				}
				else
				{
					if (opcode != 6)
					{
						throw new RuntimeException();
					}

					++progmChangeOpcodes;
				}
			}
		}

		offset += 5 * tempoOpcodes;
		offset += 2 * (noteOnOpcodes + noteOffOpcodes + ctrlChangeOpcodes + wheelChangeOpcodes + keyAfterTchOpcodes);
		offset += chnnlAfterTchOpcodes + progmChangeOpcodes;
		var13 = var1.getOffset();
		opcode = tracks + tempoOpcodes + ctrlChangeOpcodes + noteOnOpcodes + noteOffOpcodes + wheelChangeOpcodes + chnnlAfterTchOpcodes + keyAfterTchOpcodes + progmChangeOpcodes;

		for (var15 = 0; var15 < opcode; ++var15)
		{
			var1.readVarInt();
		}

		offset += var1.getOffset() - var13;
		var15 = var1.getOffset();
		int var16 = 0;
		int var17 = 0;
		int var18 = 0;
		int var19 = 0;
		int var20 = 0;
		int var21 = 0;
		int var22 = 0;
		int var23 = 0;
		int var24 = 0;
		int var25 = 0;
		int var26 = 0;
		int var27 = 0;
		int var28 = 0;

		int var29;
		for (var29 = 0; var29 < ctrlChangeOpcodes; ++var29)
		{
			var28 = var28 + var1.readUnsignedByte() & 127;
			if (var28 != 0 && var28 != 32)
			{
				if (var28 == 1)
				{
					++var16;
				}
				else if (var28 == 33)
				{
					++var17;
				}
				else if (var28 == 7)
				{
					++var18;
				}
				else if (var28 == 39)
				{
					++var19;
				}
				else if (var28 == 10)
				{
					++var20;
				}
				else if (var28 == 42)
				{
					++var21;
				}
				else if (var28 == 99)
				{
					++var22;
				}
				else if (var28 == 98)
				{
					++var23;
				}
				else if (var28 == 101)
				{
					++var24;
				}
				else if (var28 == 100)
				{
					++var25;
				}
				else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123)
				{
					++var27;
				}
				else
				{
					++var26;
				}
			}
			else
			{
				++progmChangeOpcodes;
			}
		}

		var29 = 0;
		int var30 = var1.getOffset();
		var1.skip(var26);
		int var31 = var1.getOffset();
		var1.skip(keyAfterTchOpcodes);
		int var32 = var1.getOffset();
		var1.skip(chnnlAfterTchOpcodes);
		int var33 = var1.getOffset();
		var1.skip(wheelChangeOpcodes);
		int var34 = var1.getOffset();
		var1.skip(var16);
		int var35 = var1.getOffset();
		var1.skip(var18);
		int var36 = var1.getOffset();
		var1.skip(var20);
		int var37 = var1.getOffset();
		var1.skip(noteOnOpcodes + noteOffOpcodes + keyAfterTchOpcodes);
		int var38 = var1.getOffset();
		var1.skip(noteOnOpcodes);
		int var39 = var1.getOffset();
		var1.skip(var27);
		int var40 = var1.getOffset();
		var1.skip(noteOffOpcodes);
		int var41 = var1.getOffset();
		var1.skip(var17);
		int var42 = var1.getOffset();
		var1.skip(var19);
		int var43 = var1.getOffset();
		var1.skip(var21);
		int var44 = var1.getOffset();
		var1.skip(progmChangeOpcodes);
		int var45 = var1.getOffset();
		var1.skip(wheelChangeOpcodes);
		int var46 = var1.getOffset();
		var1.skip(var22);
		int var47 = var1.getOffset();
		var1.skip(var23);
		int var48 = var1.getOffset();
		var1.skip(var24);
		int var49 = var1.getOffset();
		var1.skip(var25);
		int var50 = var1.getOffset();
		var1.skip(tempoOpcodes * 3);
		def.midi = new byte[offset];
		OutputStream var51 = new OutputStream(def.midi);
		var51.writeInt(1297377380); // MThd header
		var51.writeInt(6); // length of header
		var51.writeShort(tracks > 1 ? 1 : 0); // format
		var51.writeShort(tracks); // tracks
		var51.writeShort(division); // division
		var1.setOffset(var13);
		int var52 = 0;
		int var53 = 0;
		int var54 = 0;
		int var55 = 0;
		int var56 = 0;
		int var57 = 0;
		int var58 = 0;
		int[] var59 = new int[128];
		var28 = 0;

		label361:
		for (int var60 = 0; var60 < tracks; ++var60)
		{
			var51.writeInt(1297379947); // MTrk
			var51.skip(4); // length gets written here later
			int var61 = var51.getOffset();
			int var62 = -1;

			while (true)
			{
				while (true)
				{
					int var63 = var1.readVarInt();
					var51.writeVarInt(var63); // delta time
					int var64 = var1.getArray()[var29++] & 255;
					boolean var65 = var64 != var62;
					var62 = var64 & 15;
					if (var64 == 7)
					{
						//if (var65) -- client has this if, but it causes broken midi to be produced
						{
							var51.writeByte(255);
						}

						var51.writeByte(47); // type - end of track
						var51.writeByte(0); // length
						var51.writeLengthFromMark(var51.getOffset() - var61);
						continue label361;
					}

					if (var64 == 23)
					{
						//if (var65) -- client has this if, but it causes broken midi to be produced
						{
							var51.writeByte(255); // meta event FF
						}

						var51.writeByte(81); // type - set tempo
						var51.writeByte(3); // length
						var51.writeByte(var1.getArray()[var50++]);
						var51.writeByte(var1.getArray()[var50++]);
						var51.writeByte(var1.getArray()[var50++]);
					}
					else
					{
						var52 ^= var64 >> 4;
						if (var62 == 0)
						{
							if (var65)
							{
								var51.writeByte(144 + var52);
							}

							var53 += var1.getArray()[var37++];
							var54 += var1.getArray()[var38++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var54 & 127);
						}
						else if (var62 == 1)
						{
							if (var65)
							{
								var51.writeByte(128 + var52);
							}

							var53 += var1.getArray()[var37++];
							var55 += var1.getArray()[var40++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var55 & 127);
						}
						else if (var62 == 2)
						{
							if (var65)
							{
								var51.writeByte(176 + var52);
							}

							var28 = var28 + var1.getArray()[var15++] & 127;
							var51.writeByte(var28);
							byte var66;
							if (var28 != 0 && var28 != 32)
							{
								if (var28 == 1)
								{
									var66 = var1.getArray()[var34++];
								}
								else if (var28 == 33)
								{
									var66 = var1.getArray()[var41++];
								}
								else if (var28 == 7)
								{
									var66 = var1.getArray()[var35++];
								}
								else if (var28 == 39)
								{
									var66 = var1.getArray()[var42++];
								}
								else if (var28 == 10)
								{
									var66 = var1.getArray()[var36++];
								}
								else if (var28 == 42)
								{
									var66 = var1.getArray()[var43++];
								}
								else if (var28 == 99)
								{
									var66 = var1.getArray()[var46++];
								}
								else if (var28 == 98)
								{
									var66 = var1.getArray()[var47++];
								}
								else if (var28 == 101)
								{
									var66 = var1.getArray()[var48++];
								}
								else if (var28 == 100)
								{
									var66 = var1.getArray()[var49++];
								}
								else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123)
								{
									var66 = var1.getArray()[var39++];
								}
								else
								{
									var66 = var1.getArray()[var30++];
								}
							}
							else
							{
								var66 = var1.getArray()[var44++];
							}

							int var67 = var66 + var59[var28];
							var59[var28] = var67;
							var51.writeByte(var67 & 127);
						}
						else if (var62 == 3)
						{
							if (var65)
							{
								var51.writeByte(224 + var52);
							}

							var56 += var1.getArray()[var45++];
							var56 += var1.getArray()[var33++] << 7;
							var51.writeByte(var56 & 127);
							var51.writeByte(var56 >> 7 & 127);
						}
						else if (var62 == 4)
						{
							if (var65)
							{
								var51.writeByte(208 + var52);
							}

							var57 += var1.getArray()[var32++];
							var51.writeByte(var57 & 127);
						}
						else if (var62 == 5)
						{
							if (var65)
							{
								var51.writeByte(160 + var52);
							}

							var53 += var1.getArray()[var37++];
							var58 += var1.getArray()[var31++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var58 & 127);
						}
						else
						{
							if (var62 != 6)
							{
								throw new RuntimeException();
							}

							if (var65)
							{
								var51.writeByte(192 + var52);
							}

							var51.writeByte(var1.getArray()[var44++]);
						}
					}
				}
			}
		}

	}
}
