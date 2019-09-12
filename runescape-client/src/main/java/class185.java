import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class185 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2298;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2300;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2297;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2299;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2304;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2296;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2302;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2301;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2303;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final class185 field2305;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1998851903
	)
	static int field2306;

	static {
		field2298 = new class185(3);
		field2300 = new class185(7);
		field2297 = new class185(14);
		field2299 = new class185(6);
		field2304 = new class185(4);
		field2296 = new class185(15);
		field2302 = new class185(5);
		field2301 = new class185(4);
		field2303 = new class185(2);
		field2305 = new class185(5);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "3"
	)
	class185(int var1) {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIIIIILep;Lfj;I)V",
		garbageValue = "-1241420469"
	)
	static final void method3602(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectDefinition var8 = WallDecoration.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = WorldMapIcon_1.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			int var23;
			int var24;
			if (var8.hasSound()) {
				ObjectSound var22 = new ObjectSound();
				var22.plane = var0;
				var22.x = var1 * 128;
				var22.y = var2 * 128;
				var23 = var8.sizeX;
				var24 = var8.sizeY;
				if (var4 == 1 || var4 == 3) {
					var23 = var8.sizeY;
					var24 = var8.sizeX;
				}

				var22.field1043 = (var23 + var1) * 128;
				var22.field1051 = (var24 + var2) * 128;
				var22.soundEffectId = var8.ambientSoundId;
				var22.field1039 = var8.int4 * 128;
				var22.field1048 = var8.int5;
				var22.field1049 = var8.int6;
				var22.soundEffectIds = var8.soundEffectIds;
				if (var8.transforms != null) {
					var22.obj = var8;
					var22.set();
				}

				ObjectSound.objectSounds.addFirst(var22);
				if (var22.soundEffectIds != null) {
					var22.field1042 = var22.field1048 + (int)(Math.random() * (double)(var22.field1049 - var22.field1048));
				}
			}

			Object var34;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var34, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else if (var5 != 10 && var5 != 11) {
				int[] var10000;
				if (var5 >= 12) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.method3051(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
					if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
						var10000 = UserComparator3.field1961[var0][var1];
						var10000[var2] |= 2340;
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				} else if (var5 == 0) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(0, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field480[var4], 0, var19, var21);
					if (var4 == 0) {
						if (var8.clipped) {
							Tiles.field473[var0][var1][var2] = 50;
							Tiles.field473[var0][var1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = UserComparator3.field1961[var0][var1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 1) {
						if (var8.clipped) {
							Tiles.field473[var0][var1][var2 + 1] = 50;
							Tiles.field473[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = UserComparator3.field1961[var0][var1];
							var10000[var2 + 1] |= 1170;
						}
					} else if (var4 == 2) {
						if (var8.clipped) {
							Tiles.field473[var0][var1 + 1][var2] = 50;
							Tiles.field473[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = UserComparator3.field1961[var0][var1 + 1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 3) {
						if (var8.clipped) {
							Tiles.field473[var0][var1][var2] = 50;
							Tiles.field473[var0][var1 + 1][var2] = 50;
						}

						if (var8.modelClipped) {
							var10000 = UserComparator3.field1961[var0][var1];
							var10000[var2] |= 1170;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3534(var1, var2, var5, var4, var8.boolean1);
					}

					if (var8.int2 != 16) {
						var6.method3057(var0, var1, var2, var8.int2);
					}

				} else if (var5 == 1) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(1, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field481[var4], 0, var19, var21);
					if (var8.clipped) {
						if (var4 == 0) {
							Tiles.field473[var0][var1][var2 + 1] = 50;
						} else if (var4 == 1) {
							Tiles.field473[var0][var1 + 1][var2 + 1] = 50;
						} else if (var4 == 2) {
							Tiles.field473[var0][var1 + 1][var2] = 50;
						} else if (var4 == 3) {
							Tiles.field473[var0][var1][var2] = 50;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3534(var1, var2, var5, var4, var8.boolean1);
					}

				} else {
					int var28;
					if (var5 == 2) {
						var28 = var4 + 1 & 3;
						Object var29;
						Object var30;
						if (var8.animationId == -1 && var8.transforms == null) {
							var29 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
							var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
						} else {
							var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var29, (Entity)var30, Tiles.field480[var4], Tiles.field480[var28], var19, var21);
						if (var8.modelClipped) {
							if (var4 == 0) {
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[var2] |= 585;
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[var2 + 1] |= 1170;
							} else if (var4 == 1) {
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[1 + var2] |= 1170;
								var10000 = UserComparator3.field1961[var0][var1 + 1];
								var10000[var2] |= 585;
							} else if (var4 == 2) {
								var10000 = UserComparator3.field1961[var0][var1 + 1];
								var10000[var2] |= 585;
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[var2] |= 1170;
							} else if (var4 == 3) {
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[var2] |= 1170;
								var10000 = UserComparator3.field1961[var0][var1];
								var10000[var2] |= 585;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3534(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3057(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 3) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(3, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field481[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								Tiles.field473[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								Tiles.field473[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								Tiles.field473[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								Tiles.field473[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3534(var1, var2, var5, var4, var8.boolean1);
						}

					} else if (var5 == 9) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.method3051(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3057(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 4) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(4, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field480[var4], 0, 0, 0, var19, var21);
					} else {
						long var31;
						Object var33;
						if (var5 == 5) {
							var28 = 16;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = WallDecoration.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var31)).int2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, Tiles.field480[var4], 0, var28 * Tiles.field482[var4], var28 * Tiles.field487[var4], var19, var21);
						} else if (var5 == 6) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (var31 != 0L) {
								var28 = WallDecoration.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var31)).int2 / 2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, 256, var4, var28 * Tiles.field484[var4], var28 * Tiles.field485[var4], var19, var21);
						} else if (var5 == 7) {
							var23 = var4 + 2 & 3;
							if (var8.animationId == -1 && var8.transforms == null) {
								var34 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
							} else {
								var34 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, 256, var23, 0, 0, var19, var21);
						} else if (var5 == 8) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = WallDecoration.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var31)).int2 / 2;
							}

							int var27 = var4 + 2 & 3;
							Object var26;
							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)var26, 256, var4, var28 * Tiles.field484[var4], var28 * Tiles.field485[var4], var19, var21);
						}
					}
				}
			} else {
				if (var8.animationId == -1 && var8.transforms == null) {
					var34 = var8.getEntity(10, var4, var15, var17, var16, var18);
				} else {
					var34 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
				}

				if (var34 != null && var6.method3051(var0, var1, var2, var16, var9, var10, (Entity)var34, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
					var23 = 15;
					if (var34 instanceof Model) {
						var23 = ((Model)var34).method2849() / 4;
						if (var23 > 30) {
							var23 = 30;
						}
					}

					for (var24 = 0; var24 <= var9; ++var24) {
						for (int var25 = 0; var25 <= var10; ++var25) {
							if (var23 > Tiles.field473[var0][var24 + var1][var25 + var2]) {
								Tiles.field473[var0][var24 + var1][var25 + var2] = (byte)var23;
							}
						}
					}
				}

				if (var8.interactType != 0 && var7 != null) {
					var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
				}

			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Lbb;",
		garbageValue = "0"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return Frames.getNextWorldListWorld();
	}

	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2142685400"
	)
	static final void method3607() {
		if (Client.logoutTimer > 0) {
			class40.method736();
		} else {
			Client.timer.method4985();
			WorldMapIcon_0.updateGameState(40);
			ArchiveLoader.field512 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}
}
