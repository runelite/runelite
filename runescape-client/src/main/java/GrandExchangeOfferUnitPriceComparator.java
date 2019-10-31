import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = -1695293753
	)
	@Export("port3")
	static int port3;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lo;Lo;I)I",
		garbageValue = "-1452765932"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "19"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != Player.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = WorldMapArea.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = WorldMapArea.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = WorldMapArea.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = WorldMapArea.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (0L != var7) {
				var12 = WorldMapArea.scene.getObjectFlags(var0, var2, var3, var7);
				int var39 = UserComparator8.Entity_unpackID(var7);
				int var40 = var12 & 31;
				int var41 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					WorldMapArea.scene.removeBoundaryObject(var0, var2, var3);
					var13 = WorldMapDecorationType.getObjectDefinition(var39);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3690(var2, var3, var40, var41, var13.boolean1);
					}
				}

				if (var1 == 1) {
					WorldMapArea.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					WorldMapArea.scene.removeGameObject(var0, var2, var3);
					var13 = WorldMapDecorationType.getObjectDefinition(var39);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var41, var13.boolean1);
					}
				}

				if (var1 == 3) {
					WorldMapArea.scene.removeFloorDecoration(var0, var2, var3);
					var13 = WorldMapDecorationType.getObjectDefinition(var39);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3693(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				Scene var42 = WorldMapArea.scene;
				CollisionMap var14 = Client.collisionMaps[var0];
				ObjectDefinition var15 = WorldMapDecorationType.getObjectDefinition(var4);
				int var16;
				int var17;
				if (var5 != 1 && var5 != 3) {
					var16 = var15.sizeX;
					var17 = var15.sizeY;
				} else {
					var16 = var15.sizeY;
					var17 = var15.sizeX;
				}

				int var18;
				int var19;
				if (var16 + var2 <= 104) {
					var18 = (var16 >> 1) + var2;
					var19 = var2 + (var16 + 1 >> 1);
				} else {
					var18 = var2;
					var19 = var2 + 1;
				}

				int var20;
				int var21;
				if (var3 + var17 <= 104) {
					var20 = var3 + (var17 >> 1);
					var21 = var3 + (var17 + 1 >> 1);
				} else {
					var20 = var3;
					var21 = var3 + 1;
				}

				int[][] var22 = Tiles.Tiles_heights[var12];
				int var23 = var22[var18][var21] + var22[var18][var20] + var22[var19][var20] + var22[var19][var21] >> 2;
				int var24 = (var2 << 7) + (var16 << 6);
				int var25 = (var3 << 7) + (var17 << 6);
				long var26 = class160.calculateTag(var2, var3, 2, var15.int1 == 0, var4);
				int var28 = (var5 << 6) + var6;
				if (var15.int3 == 1) {
					var28 += 256;
				}

				Object var29;
				if (var6 == 22) {
					if (var15.animationId == -1 && var15.transforms == null) {
						var29 = var15.getModel(22, var5, var22, var24, var23, var25);
					} else {
						var29 = new DynamicObject(var4, 22, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
					}

					var42.newFloorDecoration(var0, var2, var3, var23, (Entity)var29, var26, var28);
					if (var15.interactType == 1) {
						var14.setBlockedByFloorDec(var2, var3);
					}
				} else if (var6 != 10 && var6 != 11) {
					if (var6 >= 12) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(var6, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.method3213(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
						if (var15.interactType != 0) {
							var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
						}
					} else if (var6 == 0) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(0, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, 0, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field489[var5], 0, var26, var28);
						if (var15.interactType != 0) {
							var14.method3685(var2, var3, var6, var5, var15.boolean1);
						}
					} else if (var6 == 1) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(1, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, 1, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field490[var5], 0, var26, var28);
						if (var15.interactType != 0) {
							var14.method3685(var2, var3, var6, var5, var15.boolean1);
						}
					} else {
						int var35;
						if (var6 == 2) {
							var35 = var5 + 1 & 3;
							Object var30;
							Object var31;
							if (var15.animationId == -1 && var15.transforms == null) {
								var30 = var15.getModel(2, var5 + 4, var22, var24, var23, var25);
								var31 = var15.getModel(2, var35, var22, var24, var23, var25);
							} else {
								var30 = new DynamicObject(var4, 2, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								var31 = new DynamicObject(var4, 2, var35, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var30, (Entity)var31, Tiles.field489[var5], Tiles.field489[var35], var26, var28);
							if (var15.interactType != 0) {
								var14.method3685(var2, var3, var6, var5, var15.boolean1);
							}
						} else if (var6 == 3) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(3, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, 3, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field490[var5], 0, var26, var28);
							if (var15.interactType != 0) {
								var14.method3685(var2, var3, var6, var5, var15.boolean1);
							}
						} else if (var6 == 9) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(var6, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.method3213(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
							if (var15.interactType != 0) {
								var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
							}
						} else if (var6 == 4) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(4, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field489[var5], 0, 0, 0, var26, var28);
						} else {
							Object var32;
							long var36;
							if (var6 == 5) {
								var35 = 16;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (var36 != 0L) {
									var35 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var36)).int2;
								}

								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)null, Tiles.field489[var5], 0, var35 * Tiles.field491[var5], var35 * Tiles.field498[var5], var26, var28);
							} else if (var6 == 6) {
								var35 = 8;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (var36 != 0L) {
									var35 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var36)).int2 / 2;
								}

								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5 + 4, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)null, 256, var5, var35 * Tiles.field493[var5], var35 * Tiles.field494[var5], var26, var28);
							} else if (var6 == 7) {
								int var38 = var5 + 2 & 3;
								if (var15.animationId == -1 && var15.transforms == null) {
									var29 = var15.getModel(4, var38 + 4, var22, var24, var23, var25);
								} else {
									var29 = new DynamicObject(var4, 4, var38 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, 256, var38, 0, 0, var26, var28);
							} else if (var6 == 8) {
								var35 = 8;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (0L != var36) {
									var35 = WorldMapDecorationType.getObjectDefinition(UserComparator8.Entity_unpackID(var36)).int2 / 2;
								}

								int var34 = var5 + 2 & 3;
								Object var33;
								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5 + 4, var22, var24, var23, var25);
									var33 = var15.getModel(4, var34 + 4, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
									var33 = new DynamicObject(var4, 4, var34 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)var33, 256, var5, var35 * Tiles.field493[var5], var35 * Tiles.field494[var5], var26, var28);
							}
						}
					}
				} else {
					if (var15.animationId == -1 && var15.transforms == null) {
						var29 = var15.getModel(10, var5, var22, var24, var23, var25);
					} else {
						var29 = new DynamicObject(var4, 10, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
					}

					if (var29 != null) {
						var42.method3213(var0, var2, var3, var23, var16, var17, (Entity)var29, var6 == 11 ? 256 : 0, var26, var28);
					}

					if (var15.interactType != 0) {
						var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
					}
				}
			}
		}

	}
}
