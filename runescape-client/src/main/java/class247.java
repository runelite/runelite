import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class247 {
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -896528309
	)
	@Export("cameraPitch")
	static int cameraPitch;

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)Z",
		garbageValue = "-45"
	)
	@Export("updateExternalPlayer")
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2);
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) {
			if (var0.readBits(1) != 0) {
				updateExternalPlayer(var0, var1);
			}

			var3 = var0.readBits(13);
			var4 = var0.readBits(13);
			boolean var12 = var0.readBits(1) == 1;
			if (var12) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (Client.players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var6 = Client.players[var1] = new Player();
				var6.index = var1;
				if (Players.field1229[var1] != null) {
					var6.read(Players.field1229[var1]);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1228[var1];
				var6.plane = (byte)var8;
				var6.resetPath((var9 << 13) + var3 - UserComparator8.baseX * 64, (var10 << 13) + var4 - HealthBar.baseY * 64);
				var6.field606 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.readBits(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
			return false;
		} else {
			int var5;
			int var11;
			if (var2 == 2) {
				var3 = var0.readBits(5);
				var4 = var3 >> 3;
				var5 = var3 & 7;
				var11 = Players.Players_regions[var1];
				var7 = (var11 >> 28) + var4 & 3;
				var8 = var11 >> 14 & 255;
				var9 = var11 & 255;
				if (var5 == 0) {
					--var8;
					--var9;
				}

				if (var5 == 1) {
					--var9;
				}

				if (var5 == 2) {
					++var8;
					--var9;
				}

				if (var5 == 3) {
					--var8;
				}

				if (var5 == 4) {
					++var8;
				}

				if (var5 == 5) {
					--var8;
					++var9;
				}

				if (var5 == 6) {
					++var9;
				}

				if (var5 == 7) {
					++var8;
					++var9;
				}

				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
				return false;
			} else {
				var3 = var0.readBits(18);
				var4 = var3 >> 16;
				var5 = var3 >> 8 & 255;
				var11 = var3 & 255;
				var7 = Players.Players_regions[var1];
				var8 = (var7 >> 28) + var4 & 3;
				var9 = var5 + (var7 >> 14) & 255;
				var10 = var7 + var11 & 255;
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
				return false;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIIIILek;Lfm;B)V",
		garbageValue = "-74"
	)
	static final void method4637(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectDefinition var8 = WorldMapDecorationType.getObjectDefinition(var3);
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
			int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = class160.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			if (var8.hasSound()) {
				ScriptEvent.method1274(var0, var1, var2, var8, var4);
			}

			Object var22;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var22, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else {
				int var23;
				if (var5 != 10 && var5 != 11) {
					int[] var10000;
					if (var5 >= 12) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.method3213(var0, var1, var2, var16, 1, 1, (Entity)var22, 0, var19, var21);
						if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
							var10000 = Tiles.field488[var0][var1];
							var10000[var2] |= 2340;
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

					} else if (var5 == 0) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field489[var4], 0, var19, var21);
						if (var4 == 0) {
							if (var8.clipped) {
								class96.field1300[var0][var1][var2] = 50;
								class96.field1300[var0][var1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 1) {
							if (var8.clipped) {
								class96.field1300[var0][var1][var2 + 1] = 50;
								class96.field1300[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = Tiles.field488[var0][var1];
								var10000[1 + var2] |= 1170;
							}
						} else if (var4 == 2) {
							if (var8.clipped) {
								class96.field1300[var0][var1 + 1][var2] = 50;
								class96.field1300[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = Tiles.field488[var0][var1 + 1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 3) {
							if (var8.clipped) {
								class96.field1300[var0][var1][var2] = 50;
								class96.field1300[var0][var1 + 1][var2] = 50;
							}

							if (var8.modelClipped) {
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 1170;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3685(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3327(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 1) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field490[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								class96.field1300[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								class96.field1300[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								class96.field1300[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								class96.field1300[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3685(var1, var2, var5, var4, var8.boolean1);
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

							var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var29, (Entity)var30, Tiles.field489[var4], Tiles.field489[var28], var19, var21);
							if (var8.modelClipped) {
								if (var4 == 0) {
									var10000 = Tiles.field488[var0][var1];
									var10000[var2] |= 585;
									var10000 = Tiles.field488[var0][var1];
									var10000[1 + var2] |= 1170;
								} else if (var4 == 1) {
									var10000 = Tiles.field488[var0][var1];
									var10000[1 + var2] |= 1170;
									var10000 = Tiles.field488[var0][var1 + 1];
									var10000[var2] |= 585;
								} else if (var4 == 2) {
									var10000 = Tiles.field488[var0][var1 + 1];
									var10000[var2] |= 585;
									var10000 = Tiles.field488[var0][var1];
									var10000[var2] |= 1170;
								} else if (var4 == 3) {
									var10000 = Tiles.field488[var0][var1];
									var10000[var2] |= 1170;
									var10000 = Tiles.field488[var0][var1];
									var10000[var2] |= 585;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method3685(var1, var2, var5, var4, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method3327(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 3) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field490[var4], 0, var19, var21);
							if (var8.clipped) {
								if (var4 == 0) {
									class96.field1300[var0][var1][var2 + 1] = 50;
								} else if (var4 == 1) {
									class96.field1300[var0][var1 + 1][var2 + 1] = 50;
								} else if (var4 == 2) {
									class96.field1300[var0][var1 + 1][var2] = 50;
								} else if (var4 == 3) {
									class96.field1300[var0][var1][var2] = 50;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method3685(var1, var2, var5, var4, var8.boolean1);
							}

						} else if (var5 == 9) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.method3213(var0, var1, var2, var16, 1, 1, (Entity)var22, 0, var19, var21);
							if (var8.interactType != 0 && var7 != null) {
								var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method3327(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 4) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field489[var4], 0, 0, 0, var19, var21);
						} else {
							long var31;
							Object var33;
							if (var5 == 5) {
								var28 = 16;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (0L != var31) {
									var28 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var31)).int2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var33 = var8.getEntity(4, var4, var15, var17, var16, var18);
								} else {
									var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, Tiles.field489[var4], 0, var28 * Tiles.field491[var4], var28 * Tiles.field498[var4], var19, var21);
							} else if (var5 == 6) {
								var28 = 8;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var31 != 0L) {
									var28 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var31)).int2 / 2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								} else {
									var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, 256, var4, var28 * Tiles.field493[var4], var28 * Tiles.field494[var4], var19, var21);
							} else if (var5 == 7) {
								var23 = var4 + 2 & 3;
								if (var8.animationId == -1 && var8.transforms == null) {
									var22 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
								} else {
									var22 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var22, (Entity)null, 256, var23, 0, 0, var19, var21);
							} else if (var5 == 8) {
								var28 = 8;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var31 != 0L) {
									var28 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var31)).int2 / 2;
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

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)var26, 256, var4, var28 * Tiles.field493[var4], var28 * Tiles.field494[var4], var19, var21);
							}
						}
					}
				} else {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					if (var22 != null && var6.method3213(var0, var1, var2, var16, var9, var10, (Entity)var22, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
						var23 = 15;
						if (var22 instanceof Model) {
							var23 = ((Model)var22).method3027() / 4;
							if (var23 > 30) {
								var23 = 30;
							}
						}

						for (int var24 = 0; var24 <= var9; ++var24) {
							for (int var25 = 0; var25 <= var10; ++var25) {
								if (var23 > class96.field1300[var0][var24 + var1][var25 + var2]) {
									class96.field1300[var0][var24 + var1][var25 + var2] = (byte)var23;
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
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1946170477"
	)
	static final void method4642() {
		Object var10000 = null;
		String var0 = "You can't add yourself to your own ignore list";
		class30.addGameMessage(30, "", var0);
	}
}
