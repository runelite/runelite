import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("MusicTrack")
public class MusicTrack extends Node {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("table")
	NodeHashTable table;
	@ObfuscatedName("n")
	@Export("midi")
	byte[] midi;

	@ObfuscatedSignature(
		signature = "(Lkl;)V"
	)
	MusicTrack(Buffer var1) {
		var1.offset = var1.array.length - 3;
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		int var4 = var2 * 10 + 14;
		var1.offset = 0;
		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;
		int var9 = 0;
		int var10 = 0;
		int var11 = 0;
		int var12 = 0;

		int var13;
		int var14;
		int var15;
		for (var13 = 0; var13 < var2; ++var13) {
			var14 = -1;

			while (true) {
				var15 = var1.readUnsignedByte();
				if (var15 != var14) {
					++var4;
				}

				var14 = var15 & 15;
				if (var15 == 7) {
					break;
				}

				if (var15 == 23) {
					++var5;
				} else if (var14 == 0) {
					++var7;
				} else if (var14 == 1) {
					++var8;
				} else if (var14 == 2) {
					++var6;
				} else if (var14 == 3) {
					++var9;
				} else if (var14 == 4) {
					++var10;
				} else if (var14 == 5) {
					++var11;
				} else {
					if (var14 != 6) {
						throw new RuntimeException();
					}

					++var12;
				}
			}
		}

		var4 += var5 * 5;
		var4 += (var7 + var8 + var6 + var9 + var11) * 2;
		var4 = var4 + var10 + var12;
		var13 = var1.offset;
		var14 = var2 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12;

		for (var15 = 0; var15 < var14; ++var15) {
			var1.readVarInt();
		}

		var4 += var1.offset - var13;
		var15 = var1.offset;
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
		for (var29 = 0; var29 < var6; ++var29) {
			var28 = var28 + var1.readUnsignedByte() & 127;
			if (var28 != 0 && var28 != 32) {
				if (var28 == 1) {
					++var16;
				} else if (var28 == 33) {
					++var17;
				} else if (var28 == 7) {
					++var18;
				} else if (var28 == 39) {
					++var19;
				} else if (var28 == 10) {
					++var20;
				} else if (var28 == 42) {
					++var21;
				} else if (var28 == 99) {
					++var22;
				} else if (var28 == 98) {
					++var23;
				} else if (var28 == 101) {
					++var24;
				} else if (var28 == 100) {
					++var25;
				} else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
					++var27;
				} else {
					++var26;
				}
			} else {
				++var12;
			}
		}

		var29 = 0;
		int var30 = var1.offset;
		var1.offset += var26;
		int var31 = var1.offset;
		var1.offset += var11;
		int var32 = var1.offset;
		var1.offset += var10;
		int var33 = var1.offset;
		var1.offset += var9;
		int var34 = var1.offset;
		var1.offset += var16;
		int var35 = var1.offset;
		var1.offset += var18;
		int var36 = var1.offset;
		var1.offset += var20;
		int var37 = var1.offset;
		var1.offset += var7 + var8 + var11;
		int var38 = var1.offset;
		var1.offset += var7;
		int var39 = var1.offset;
		var1.offset += var27;
		int var40 = var1.offset;
		var1.offset += var8;
		int var41 = var1.offset;
		var1.offset += var17;
		int var42 = var1.offset;
		var1.offset += var19;
		int var43 = var1.offset;
		var1.offset += var21;
		int var44 = var1.offset;
		var1.offset += var12;
		int var45 = var1.offset;
		var1.offset += var9;
		int var46 = var1.offset;
		var1.offset += var22;
		int var47 = var1.offset;
		var1.offset += var23;
		int var48 = var1.offset;
		var1.offset += var24;
		int var49 = var1.offset;
		var1.offset += var25;
		int var50 = var1.offset;
		var1.offset += var5 * 3;
		this.midi = new byte[var4];
		Buffer var51 = new Buffer(this.midi);
		var51.writeInt(1297377380);
		var51.writeInt(6);
		var51.writeShort(var2 > 1 ? 1 : 0);
		var51.writeShort(var2);
		var51.writeShort(var3);
		var1.offset = var13;
		int var52 = 0;
		int var53 = 0;
		int var54 = 0;
		int var55 = 0;
		int var56 = 0;
		int var57 = 0;
		int var58 = 0;
		int[] var59 = new int[128];
		var28 = 0;

		label221:
		for (int var60 = 0; var60 < var2; ++var60) {
			var51.writeInt(1297379947);
			var51.offset += 4;
			int var61 = var51.offset;
			int var62 = -1;

			while (true) {
				while (true) {
					int var63 = var1.readVarInt();
					var51.writeVarInt(var63);
					int var64 = var1.array[var29++] & 255;
					boolean var65 = var64 != var62;
					var62 = var64 & 15;
					if (var64 == 7) {
						if (var65) {
							var51.writeByte(255);
						}

						var51.writeByte(47);
						var51.writeByte(0);
						var51.writeLengthInt(var51.offset - var61);
						continue label221;
					}

					if (var64 == 23) {
						if (var65) {
							var51.writeByte(255);
						}

						var51.writeByte(81);
						var51.writeByte(3);
						var51.writeByte(var1.array[var50++]);
						var51.writeByte(var1.array[var50++]);
						var51.writeByte(var1.array[var50++]);
					} else {
						var52 ^= var64 >> 4;
						if (var62 == 0) {
							if (var65) {
								var51.writeByte(var52 + 144);
							}

							var53 += var1.array[var37++];
							var54 += var1.array[var38++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var54 & 127);
						} else if (var62 == 1) {
							if (var65) {
								var51.writeByte(var52 + 128);
							}

							var53 += var1.array[var37++];
							var55 += var1.array[var40++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var55 & 127);
						} else if (var62 == 2) {
							if (var65) {
								var51.writeByte(var52 + 176);
							}

							var28 = var28 + var1.array[var15++] & 127;
							var51.writeByte(var28);
							byte var66;
							if (var28 != 0 && var28 != 32) {
								if (var28 == 1) {
									var66 = var1.array[var34++];
								} else if (var28 == 33) {
									var66 = var1.array[var41++];
								} else if (var28 == 7) {
									var66 = var1.array[var35++];
								} else if (var28 == 39) {
									var66 = var1.array[var42++];
								} else if (var28 == 10) {
									var66 = var1.array[var36++];
								} else if (var28 == 42) {
									var66 = var1.array[var43++];
								} else if (var28 == 99) {
									var66 = var1.array[var46++];
								} else if (var28 == 98) {
									var66 = var1.array[var47++];
								} else if (var28 == 101) {
									var66 = var1.array[var48++];
								} else if (var28 == 100) {
									var66 = var1.array[var49++];
								} else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
									var66 = var1.array[var39++];
								} else {
									var66 = var1.array[var30++];
								}
							} else {
								var66 = var1.array[var44++];
							}

							int var67 = var66 + var59[var28];
							var59[var28] = var67;
							var51.writeByte(var67 & 127);
						} else if (var62 == 3) {
							if (var65) {
								var51.writeByte(var52 + 224);
							}

							var56 += var1.array[var45++];
							var56 += var1.array[var33++] << 7;
							var51.writeByte(var56 & 127);
							var51.writeByte(var56 >> 7 & 127);
						} else if (var62 == 4) {
							if (var65) {
								var51.writeByte(var52 + 208);
							}

							var57 += var1.array[var32++];
							var51.writeByte(var57 & 127);
						} else if (var62 == 5) {
							if (var65) {
								var51.writeByte(var52 + 160);
							}

							var53 += var1.array[var37++];
							var58 += var1.array[var31++];
							var51.writeByte(var53 & 127);
							var51.writeByte(var58 & 127);
						} else {
							if (var62 != 6) {
								throw new RuntimeException();
							}

							if (var65) {
								var51.writeByte(var52 + 192);
							}

							var51.writeByte(var1.array[var44++]);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("n")
	void method3895() {
		if (this.table == null) {
			this.table = new NodeHashTable(16);
			int[] var1 = new int[16];
			int[] var2 = new int[16];
			var2[9] = 128;
			var1[9] = 128;
			MidiFileReader var4 = new MidiFileReader(this.midi);
			int var5 = var4.trackCount();

			int var6;
			for (var6 = 0; var6 < var5; ++var6) {
				var4.gotoTrack(var6);
				var4.readTrackLength(var6);
				var4.markTrackPosition(var6);
			}

			label56:
			do {
				while (true) {
					var6 = var4.getPrioritizedTrack();
					int var7 = var4.trackLengths[var6];

					while (var7 == var4.trackLengths[var6]) {
						var4.gotoTrack(var6);
						int var8 = var4.readMessage(var6);
						if (var8 == 1) {
							var4.setTrackDone();
							var4.markTrackPosition(var6);
							continue label56;
						}

						int var9 = var8 & 240;
						int var10;
						int var11;
						int var12;
						if (var9 == 176) {
							var10 = var8 & 15;
							var11 = var8 >> 8 & 127;
							var12 = var8 >> 16 & 127;
							if (var11 == 0) {
								var1[var10] = (var12 << 14) + (var1[var10] & -2080769);
							}

							if (var11 == 32) {
								var1[var10] = (var1[var10] & -16257) + (var12 << 7);
							}
						}

						if (var9 == 192) {
							var10 = var8 & 15;
							var11 = var8 >> 8 & 127;
							var2[var10] = var11 + var1[var10];
						}

						if (var9 == 144) {
							var10 = var8 & 15;
							var11 = var8 >> 8 & 127;
							var12 = var8 >> 16 & 127;
							if (var12 > 0) {
								int var13 = var2[var10];
								ByteArrayNode var14 = (ByteArrayNode)this.table.get((long)var13);
								if (var14 == null) {
									var14 = new ByteArrayNode(new byte[128]);
									this.table.put(var14, (long)var13);
								}

								var14.byteArray[var11] = 1;
							}
						}

						var4.readTrackLength(var6);
						var4.markTrackPosition(var6);
					}
				}
			} while(!var4.isDone());

		}
	}

	@ObfuscatedName("v")
	@Export("clear")
	void clear() {
		this.table = null;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;II)Lgh;"
	)
	@Export("readTrack")
	public static MusicTrack readTrack(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		return var3 == null ? null : new MusicTrack(new Buffer(var3));
	}
}
