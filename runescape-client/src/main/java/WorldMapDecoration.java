import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2038989741
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1678601373
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1725461175
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIILfk;Lfv;I)Z",
		garbageValue = "-802024285"
	)
	public static final boolean method346(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
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
			label310:
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
							label287:
							do {
								if (var12 == var20) {
									ChatChannel.field1289 = var5;
									class173.field2093 = var6;
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
									ChatChannel.field1289 = var5;
									class173.field2093 = var6;
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

										if ((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
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
											continue label287;
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
					if ((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
						continue label310;
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IZIZB)V",
		garbageValue = "58"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class96.World_worlds != null) {
			InterfaceParent.doWorldSorting(0, class96.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(Lbs;I)V",
		garbageValue = "447315853"
	)
	static final void method347(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = ServerBuild.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = ServerBuild.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = ServerBuild.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = ServerBuild.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var1 != 0L) {
			int var6 = ServerBuild.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = GrandExchangeEvents.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field924 = var4;
		var0.field935 = var5;
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "-22"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (ScriptFrame.loadInterface(var0)) {
			GrandExchangeOfferAgeComparator.updateInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}
