import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("ParamDefinition_archive")
	public static AbstractArchive ParamDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("ParamDefinition_cached")
	static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("b")
	@Export("type")
	char type;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1135873659
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("z")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("p")
	@Export("autoDisable")
	boolean autoDisable;

	static {
		ParamDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	ParamDefinition() {
		this.autoDisable = true;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "127"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "17"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "-1607275245"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			byte var4 = var1.readByte();
			int var5 = var4 & 255;
			if (var5 == 0) {
				throw new IllegalArgumentException("" + Integer.toString(var5, 16));
			}

			if (var5 >= 128 && var5 < 160) {
				char var6 = class287.cp1252AsciiExtension[var5 - 128];
				if (var6 == 0) {
					var6 = '?';
				}

				var5 = var6;
			}

			char var3 = (char)var5;
			this.type = var3;
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1761356775"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIILfg;Lfh;Z[I[II)I",
		garbageValue = "1370585226"
	)
	public static int method4612(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4, boolean var5, int[] var6, int[] var7) {
		int var9;
		for (int var8 = 0; var8 < 128; ++var8) {
			for (var9 = 0; var9 < 128; ++var9) {
				class173.directions[var8][var9] = 0;
				class173.distances[var8][var9] = 99999999;
			}
		}

		int var10;
		int var11;
		byte var13;
		int var14;
		int var15;
		int var17;
		int var19;
		int var20;
		int var21;
		int var22;
		boolean var28;
		int var30;
		int var31;
		int var33;
		if (var2 == 1) {
			var28 = WorldMapLabel.method434(var0, var1, var3, var4);
		} else if (var2 == 2) {
			var28 = GameObject.method3342(var0, var1, var3, var4);
		} else {
			var10 = var0;
			var11 = var1;
			byte var12 = 64;
			var13 = 64;
			var14 = var0 - var12;
			var15 = var1 - var13;
			class173.directions[var12][var13] = 99;
			class173.distances[var12][var13] = 0;
			byte var16 = 0;
			var17 = 0;
			class173.bufferX[var16] = var0;
			var33 = var16 + 1;
			class173.bufferY[var16] = var1;
			int[][] var27 = var4.flags;

			boolean var29;
			label454:
			while (true) {
				label452:
				while (true) {
					do {
						do {
							do {
								label429:
								do {
									if (var33 == var17) {
										class173.field2103 = var10;
										class173.field2100 = var11;
										var29 = false;
										break label454;
									}

									var10 = class173.bufferX[var17];
									var11 = class173.bufferY[var17];
									var17 = var17 + 1 & 4095;
									var30 = var10 - var14;
									var31 = var11 - var15;
									var19 = var10 - var4.xInset;
									var20 = var11 - var4.yInset;
									if (var3.hasArrived(var2, var10, var11, var4)) {
										class173.field2103 = var10;
										class173.field2100 = var11;
										var29 = true;
										break label454;
									}

									var21 = class173.distances[var30][var31] + 1;
									if (var30 > 0 && class173.directions[var30 - 1][var31] == 0 && (var27[var19 - 1][var20] & 19136782) == 0 && (var27[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2 - 1) {
												class173.bufferX[var33] = var10 - 1;
												class173.bufferY[var33] = var11;
												var33 = var33 + 1 & 4095;
												class173.directions[var30 - 1][var31] = 2;
												class173.distances[var30 - 1][var31] = var21;
												break;
											}

											if ((var27[var19 - 1][var20 + var22] & 19136830) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var30 < 128 - var2 && class173.directions[var30 + 1][var31] == 0 && (var27[var19 + var2][var20] & 19136899) == 0 && (var27[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2 - 1) {
												class173.bufferX[var33] = var10 + 1;
												class173.bufferY[var33] = var11;
												var33 = var33 + 1 & 4095;
												class173.directions[var30 + 1][var31] = 8;
												class173.distances[var30 + 1][var31] = var21;
												break;
											}

											if ((var27[var19 + var2][var22 + var20] & 19136995) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var31 > 0 && class173.directions[var30][var31 - 1] == 0 && (var27[var19][var20 - 1] & 19136782) == 0 && (var27[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2 - 1) {
												class173.bufferX[var33] = var10;
												class173.bufferY[var33] = var11 - 1;
												var33 = var33 + 1 & 4095;
												class173.directions[var30][var31 - 1] = 1;
												class173.distances[var30][var31 - 1] = var21;
												break;
											}

											if ((var27[var19 + var22][var20 - 1] & 19136911) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var31 < 128 - var2 && class173.directions[var30][var31 + 1] == 0 && (var27[var19][var20 + var2] & 19136824) == 0 && (var27[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2 - 1) {
												class173.bufferX[var33] = var10;
												class173.bufferY[var33] = var11 + 1;
												var33 = var33 + 1 & 4095;
												class173.directions[var30][var31 + 1] = 4;
												class173.distances[var30][var31 + 1] = var21;
												break;
											}

											if ((var27[var19 + var22][var20 + var2] & 19137016) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var30 > 0 && var31 > 0 && class173.directions[var30 - 1][var31 - 1] == 0 && (var27[var19 - 1][var20 - 1] & 19136782) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2) {
												class173.bufferX[var33] = var10 - 1;
												class173.bufferY[var33] = var11 - 1;
												var33 = var33 + 1 & 4095;
												class173.directions[var30 - 1][var31 - 1] = 3;
												class173.distances[var30 - 1][var31 - 1] = var21;
												break;
											}

											if ((var27[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var27[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var30 < 128 - var2 && var31 > 0 && class173.directions[var30 + 1][var31 - 1] == 0 && (var27[var19 + var2][var20 - 1] & 19136899) == 0) {
										var22 = 1;

										while (true) {
											if (var22 >= var2) {
												class173.bufferX[var33] = var10 + 1;
												class173.bufferY[var33] = var11 - 1;
												var33 = var33 + 1 & 4095;
												class173.directions[var30 + 1][var31 - 1] = 9;
												class173.distances[var30 + 1][var31 - 1] = var21;
												break;
											}

											if ((var27[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || (var27[var19 + var22][var20 - 1] & 19136911) != 0) {
												break;
											}

											++var22;
										}
									}

									if (var30 > 0 && var31 < 128 - var2 && class173.directions[var30 - 1][var31 + 1] == 0 && (var27[var19 - 1][var20 + var2] & 19136824) == 0) {
										for (var22 = 1; var22 < var2; ++var22) {
											if ((var27[var19 - 1][var20 + var22] & 19136830) != 0 || (var27[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
												continue label429;
											}
										}

										class173.bufferX[var33] = var10 - 1;
										class173.bufferY[var33] = var11 + 1;
										var33 = var33 + 1 & 4095;
										class173.directions[var30 - 1][var31 + 1] = 6;
										class173.distances[var30 - 1][var31 + 1] = var21;
									}
								} while(var30 >= 128 - var2);
							} while(var31 >= 128 - var2);
						} while(class173.directions[var30 + 1][var31 + 1] != 0);
					} while((var27[var19 + var2][var20 + var2] & 19136992) != 0);

					for (var22 = 1; var22 < var2; ++var22) {
						if ((var27[var22 + var19][var20 + var2] & 19137016) != 0 || (var27[var19 + var2][var22 + var20] & 19136995) != 0) {
							continue label452;
						}
					}

					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31 + 1] = 12;
					class173.distances[var30 + 1][var31 + 1] = var21;
				}
			}

			var28 = var29;
		}

		var9 = var0 - 64;
		var10 = var1 - 64;
		var11 = class173.field2103;
		var30 = class173.field2100;
		if (!var28) {
			var31 = Integer.MAX_VALUE;
			var14 = Integer.MAX_VALUE;
			byte var32 = 10;
			var33 = var3.approxDestinationX;
			var17 = var3.approxDestinationY;
			int var18 = var3.approxDestinationSizeX;
			var19 = var3.approxDestinationSizeY;

			for (var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
				for (var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
					var22 = var20 - var9;
					int var23 = var21 - var10;
					if (var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class173.distances[var22][var23] < 100) {
						int var24 = 0;
						if (var20 < var33) {
							var24 = var33 - var20;
						} else if (var20 > var18 + var33 - 1) {
							var24 = var20 - (var18 + var33 - 1);
						}

						int var25 = 0;
						if (var21 < var17) {
							var25 = var17 - var21;
						} else if (var21 > var17 + var19 - 1) {
							var25 = var21 - (var19 + var17 - 1);
						}

						int var26 = var24 * var24 + var25 * var25;
						if (var26 < var31 || var26 == var31 && class173.distances[var22][var23] < var14) {
							var31 = var26;
							var14 = class173.distances[var22][var23];
							var11 = var20;
							var30 = var21;
						}
					}
				}
			}

			if (var31 == Integer.MAX_VALUE) {
				return -1;
			}
		}

		if (var0 == var11 && var30 == var1) {
			return 0;
		} else {
			var13 = 0;
			class173.bufferX[var13] = var11;
			var31 = var13 + 1;
			class173.bufferY[var13] = var30;

			for (var14 = var15 = class173.directions[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class173.directions[var11 - var9][var30 - var10]) {
				if (var14 != var15) {
					var15 = var14;
					class173.bufferX[var31] = var11;
					class173.bufferY[var31++] = var30;
				}

				if ((var14 & 2) != 0) {
					++var11;
				} else if ((var14 & 8) != 0) {
					--var11;
				}

				if ((var14 & 1) != 0) {
					++var30;
				} else if ((var14 & 4) != 0) {
					--var30;
				}
			}

			var33 = 0;

			while (var31-- > 0) {
				var6[var33] = class173.bufferX[var31];
				var7[var33++] = class173.bufferY[var31];
				if (var33 >= var6.length) {
					break;
				}
			}

			return var33;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1049391968"
	)
	public static final void method4611() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}
}
