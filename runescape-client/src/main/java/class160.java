import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public enum class160 implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	field1986(2, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	field1987(1, 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	field1982(3, 2),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	field1985(0, 3);

	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1547837327
	)
	public final int field1983;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2121072249
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field1983 = var3;
		this.id = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1766799370"
	)
	static final void method3585(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "-634451931"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class287.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIIZIB)J",
		garbageValue = "-75"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1886858655"
	)
	static final void method3586(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field676; ++var1) {
			int var2 = Client.field677[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			int var6;
			int var7;
			if ((var4 & 2) != 0) {
				var5 = var0.method5646();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.method5639();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = PlayerType.SequenceDefinition_get(var5).field3521;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field960 = 0;
					}

					if (var7 == 2) {
						var3.field960 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || PlayerType.SequenceDefinition_get(var5).field3519 >= PlayerType.SequenceDefinition_get(var3.sequence).field3519) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field960 = 0;
					var3.field983 = var3.pathLength;
				}
			}

			if ((var4 & 1) != 0) {
				var3.targetIndex = var0.method5647();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			if ((var4 & 32) != 0) {
				var3.spotAnimation = var0.method5647();
				var5 = var0.method5603();
				var3.field965 = var5 >> 16;
				var3.field973 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field973 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			int var8;
			if ((var4 & 16) != 0) {
				var5 = var0.method5647();
				var6 = var0.method5648();
				var7 = var3.x - (var5 - UserComparator8.baseX * 64 - UserComparator8.baseX * 64) * 64;
				var8 = var3.y - (var6 - HealthBar.baseY * 64 - HealthBar.baseY * 64) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field934 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 4) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 8) != 0) {
				var3.definition = SecureRandomCallable.getNpcDefinition(var0.readUnsignedShort());
				var3.field927 = var3.definition.size;
				var3.field977 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 64) != 0) {
				var5 = var0.method5639();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.method5697();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.readUnsignedByte();
							int var12 = var9 > 0 ? var0.method5639() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}
		}

	}
}
