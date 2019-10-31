import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("cf")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1635893433
	)
	final int field107;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2014833765
	)
	final int field104;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1256789949
	)
	final int field105;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(2, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field107 = var1;
		this.field104 = var2;
		this.field105 = var3;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(FB)Z",
		garbageValue = "16"
	)
	boolean method234(float var1) {
		return var1 >= (float)this.field105;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Le;",
		garbageValue = "-2025781549"
	)
	static WorldMapLabelSize method228(int var0) {
		WorldMapLabelSize[] var1 = new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_medium, WorldMapLabelSize_large};
		WorldMapLabelSize[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			WorldMapLabelSize var4 = var2[var3];
			if (var0 == var4.field104) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIILfc;Lfm;I)Z",
		garbageValue = "-1328272640"
	)
	static final boolean method236(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
		int var5 = var0;
		int var6 = var1;
		byte var7 = 64;
		byte var8 = 64;
		int var9 = var0 - var7;
		int var10 = var1 - var8;
		class173.directions[var7][var8] = 99;
		class173.distances[var7][var8] = 0;
		byte var11 = 0;
		int var12 = 0;
		class173.bufferX[var11] = var0;
		int var20 = var11 + 1;
		class173.bufferY[var11] = var1;
		int[][] var13 = var4.flags;

		while (true) {
			label313:
			while (true) {
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				do {
					do {
						do {
							label290:
							do {
								if (var12 == var20) {
									class173.field2070 = var5;
									LoginScreenAnimation.field1029 = var6;
									return false;
								}

								var5 = class173.bufferX[var12];
								var6 = class173.bufferY[var12];
								var12 = var12 + 1 & 4095;
								var18 = var5 - var9;
								var19 = var6 - var10;
								var14 = var5 - var4.xInset;
								var15 = var6 - var4.yInset;
								if (var3.hasArrived(var2, var5, var6, var4)) {
									class173.field2070 = var5;
									LoginScreenAnimation.field1029 = var6;
									return true;
								}

								var16 = class173.distances[var18][var19] + 1;
								if (var18 > 0 && class173.directions[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2 - 1) {
											class173.bufferX[var20] = var5 - 1;
											class173.bufferY[var20] = var6;
											var20 = var20 + 1 & 4095;
											class173.directions[var18 - 1][var19] = 2;
											class173.distances[var18 - 1][var19] = var16;
											break;
										}

										if ((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var18 < 128 - var2 && class173.directions[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2 - 1) {
											class173.bufferX[var20] = var5 + 1;
											class173.bufferY[var20] = var6;
											var20 = var20 + 1 & 4095;
											class173.directions[var18 + 1][var19] = 8;
											class173.distances[var18 + 1][var19] = var16;
											break;
										}

										if ((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var19 > 0 && class173.directions[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2 - 1) {
											class173.bufferX[var20] = var5;
											class173.bufferY[var20] = var6 - 1;
											var20 = var20 + 1 & 4095;
											class173.directions[var18][var19 - 1] = 1;
											class173.distances[var18][var19 - 1] = var16;
											break;
										}

										if ((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var19 < 128 - var2 && class173.directions[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2 - 1) {
											class173.bufferX[var20] = var5;
											class173.bufferY[var20] = var6 + 1;
											var20 = var20 + 1 & 4095;
											class173.directions[var18][var19 + 1] = 4;
											class173.distances[var18][var19 + 1] = var16;
											break;
										}

										if ((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var18 > 0 && var19 > 0 && class173.directions[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2) {
											class173.bufferX[var20] = var5 - 1;
											class173.bufferY[var20] = var6 - 1;
											var20 = var20 + 1 & 4095;
											class173.directions[var18 - 1][var19 - 1] = 3;
											class173.distances[var18 - 1][var19 - 1] = var16;
											break;
										}

										if ((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var18 < 128 - var2 && var19 > 0 && class173.directions[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
									var17 = 1;

									while (true) {
										if (var17 >= var2) {
											class173.bufferX[var20] = var5 + 1;
											class173.bufferY[var20] = var6 - 1;
											var20 = var20 + 1 & 4095;
											class173.directions[var18 + 1][var19 - 1] = 9;
											class173.distances[var18 + 1][var19 - 1] = var16;
											break;
										}

										if ((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
											break;
										}

										++var17;
									}
								}

								if (var18 > 0 && var19 < 128 - var2 && class173.directions[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
									for (var17 = 1; var17 < var2; ++var17) {
										if ((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
											continue label290;
										}
									}

									class173.bufferX[var20] = var5 - 1;
									class173.bufferY[var20] = var6 + 1;
									var20 = var20 + 1 & 4095;
									class173.directions[var18 - 1][var19 + 1] = 6;
									class173.distances[var18 - 1][var19 + 1] = var16;
								}
							} while(var18 >= 128 - var2);
						} while(var19 >= 128 - var2);
					} while(class173.directions[var18 + 1][var19 + 1] != 0);
				} while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

				for (var17 = 1; var17 < var2; ++var17) {
					if ((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
						continue label313;
					}
				}

				class173.bufferX[var20] = var5 + 1;
				class173.bufferY[var20] = var6 + 1;
				var20 = var20 + 1 & 4095;
				class173.directions[var18 + 1][var19 + 1] = 12;
				class173.distances[var18 + 1][var19 + 1] = var16;
			}
		}
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-93"
	)
	static final void method235(boolean var0) {
		if (var0) {
			Client.field850 = Login.field1177 ? class160.field1987 : class160.field1985;
		} else {
			Client.field850 = ScriptEvent.clientPreferences.parameters.containsKey(GrandExchangeEvents.method108(Login.Login_username)) ? class160.field1986 : class160.field1982;
		}

	}
}
