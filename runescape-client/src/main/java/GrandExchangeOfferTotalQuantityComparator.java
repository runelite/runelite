import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("GrandExchangeOfferTotalQuantityComparator")
final class GrandExchangeOfferTotalQuantityComparator implements Comparator {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_spritesArchive")
	public static AbstractArchive HitSplatDefinition_spritesArchive;
	@ObfuscatedName("ep")
	@ObfuscatedGetter(
		intValue = 349503159
	)
	static int field59;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lq;Lq;I)I",
		garbageValue = "-1907717670"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lea;[Lfm;I)V",
		garbageValue = "-207613599"
	)
	static final void method98(Scene var0, CollisionMap[] var1) {
		int var2;
		int var3;
		int var4;
		int var5;
		for (var2 = 0; var2 < 4; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				for (var4 = 0; var4 < 104; ++var4) {
					if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
						var5 = var2;
						if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
							var5 = var2 - 1;
						}

						if (var5 >= 0) {
							var1[var5].setBlockedByFloor(var3, var4);
						}
					}
				}
			}
		}

		Tiles.field477 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field477 < -8) {
			Tiles.field477 = -8;
		}

		if (Tiles.field477 > 8) {
			Tiles.field477 = 8;
		}

		Tiles.field486 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field486 < -16) {
			Tiles.field486 = -16;
		}

		if (Tiles.field486 > 16) {
			Tiles.field486 = 16;
		}

		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var16;
		int[] var10000;
		int var17;
		int var18;
		for (var2 = 0; var2 < 4; ++var2) {
			byte[][] var44 = class188.field2321[var2];
			var9 = (int)Math.sqrt(5100.0D);
			var10 = var9 * 768 >> 8;

			int var19;
			int var20;
			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
					var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
					var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
					var16 = (var13 << 8) / var15;
					var17 = 65536 / var15;
					var18 = (var14 << 8) / var15;
					var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
					var20 = (var44[var12][var11 + 1] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2) + (var44[var12 + 1][var11] >> 3) + (var44[var12][var11] >> 1);
					class4.field31[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				Tiles.Tiles_hue[var11] = 0;
				class3.Tiles_saturation[var11] = 0;
				Buddy.Tiles_lightness[var11] = 0;
				class49.Tiles_hueMultiplier[var11] = 0;
				MenuAction.field1129[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = Tiles.field485[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var45 = StudioGame.FloorUnderlayDefinition_get(var14 - 1);
							var10000 = Tiles.Tiles_hue;
							var10000[var12] += var45.hue;
							var10000 = class3.Tiles_saturation;
							var10000[var12] += var45.saturation;
							var10000 = Buddy.Tiles_lightness;
							var10000[var12] += var45.lightness;
							var10000 = class49.Tiles_hueMultiplier;
							var10000[var12] += var45.hueMultiplier;
							var10002 = MenuAction.field1129[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = Tiles.field485[var2][var14][var12] & 255;
						if (var15 > 0) {
							FloorUnderlayDefinition var46 = StudioGame.FloorUnderlayDefinition_get(var15 - 1);
							var10000 = Tiles.Tiles_hue;
							var10000[var12] -= var46.hue;
							var10000 = class3.Tiles_saturation;
							var10000[var12] -= var46.saturation;
							var10000 = Buddy.Tiles_lightness;
							var10000[var12] -= var46.lightness;
							var10000 = class49.Tiles_hueMultiplier;
							var10000[var12] -= var46.hueMultiplier;
							var10002 = MenuAction.field1129[var12]--;
						}
					}
				}

				if (var11 >= 1 && var11 < 103) {
					var12 = 0;
					var13 = 0;
					var14 = 0;
					var15 = 0;
					var16 = 0;

					for (var17 = -5; var17 < 109; ++var17) {
						var18 = var17 + 5;
						if (var18 >= 0 && var18 < 104) {
							var12 += Tiles.Tiles_hue[var18];
							var13 += class3.Tiles_saturation[var18];
							var14 += Buddy.Tiles_lightness[var18];
							var15 += class49.Tiles_hueMultiplier[var18];
							var16 += MenuAction.field1129[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= Tiles.Tiles_hue[var19];
							var13 -= class3.Tiles_saturation[var19];
							var14 -= Buddy.Tiles_lightness[var19];
							var15 -= class49.Tiles_hueMultiplier[var19];
							var16 -= MenuAction.field1129[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = Tiles.field485[var2][var11][var17] & 255;
							int var21 = AccessFile.field4061[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = class4.field31[var11][var17];
								int var27 = class4.field31[var11 + 1][var17];
								int var28 = class4.field31[var11 + 1][var17 + 1];
								int var29 = class4.field31[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								int var34;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									var34 = var14 / var16;
									var30 = BoundaryObject.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.field477 & 255;
									var34 += Tiles.field486;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = BoundaryObject.hslToRgb(var32, var33, var34);
								}

								FloorOverlayDefinition var35;
								if (var2 > 0) {
									boolean var51 = true;
									if (var20 == 0 && class210.field2492[var2][var11][var17] != 0) {
										var51 = false;
									}

									if (var21 > 0) {
										var34 = var21 - 1;
										var35 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var34);
										FloorOverlayDefinition var47;
										if (var35 != null) {
											var47 = var35;
										} else {
											byte[] var49 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var34);
											var35 = new FloorOverlayDefinition();
											if (var49 != null) {
												var35.decode(new Buffer(var49), var34);
											}

											var35.postDecode();
											FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var35, (long)var34);
											var47 = var35;
										}

										if (!var47.hideUnderlay) {
											var51 = false;
										}
									}

									if (var51 && var23 == var22 && var24 == var22 && var22 == var25) {
										var10000 = Tiles.field483[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[class197.method3645(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class197.method3645(var30, var26), class197.method3645(var30, var27), class197.method3645(var30, var28), class197.method3645(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = class210.field2492[var2][var11][var17] + 1;
									byte var52 = Tiles.field475[var2][var11][var17];
									int var36 = var21 - 1;
									FloorOverlayDefinition var37 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var36);
									if (var37 != null) {
										var35 = var37;
									} else {
										byte[] var48 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var36);
										var37 = new FloorOverlayDefinition();
										if (var48 != null) {
											var37.decode(new Buffer(var48), var36);
										}

										var37.postDecode();
										FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var37, (long)var36);
										var35 = var37;
									}

									int var38 = var35.texture;
									int var39;
									int var40;
									int var41;
									int var42;
									if (var38 >= 0) {
										var40 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var38);
										var39 = -1;
									} else if (var35.primaryRgb == 16711935) {
										var39 = -2;
										var38 = -1;
										var40 = -2;
									} else {
										var39 = BoundaryObject.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var41 = var35.hue + Tiles.field477 & 255;
										var42 = var35.lightness + Tiles.field486;
										if (var42 < 0) {
											var42 = 0;
										} else if (var42 > 255) {
											var42 = 255;
										}

										var40 = BoundaryObject.hslToRgb(var41, var35.saturation, var42);
									}

									var41 = 0;
									if (var40 != -2) {
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[RouteStrategy.method3533(var40, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var42 = var35.secondaryHue + Tiles.field477 & 255;
										int var43 = var35.secondaryLightness + Tiles.field486;
										if (var43 < 0) {
											var43 = 0;
										} else if (var43 > 255) {
											var43 = 255;
										}

										var40 = BoundaryObject.hslToRgb(var42, var35.secondarySaturation, var43);
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[RouteStrategy.method3533(var40, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var52, var38, var22, var23, var24, var25, class197.method3645(var30, var26), class197.method3645(var30, var27), class197.method3645(var30, var28), class197.method3645(var30, var29), RouteStrategy.method3533(var39, var26), RouteStrategy.method3533(var39, var27), RouteStrategy.method3533(var39, var28), RouteStrategy.method3533(var39, var29), var32, var41);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var0.setTileMinPlane(var2, var12, var11, ObjectDefinition.method4545(var2, var12, var11));
				}
			}

			Tiles.field485[var2] = null;
			AccessFile.field4061[var2] = null;
			class210.field2492[var2] = null;
			Tiles.field475[var2] = null;
			class188.field2321[var2] = null;
		}

		var0.method3100(-50, -10, -50);

		for (var2 = 0; var2 < 104; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var0.setLinkBelow(var2, var3);
				}
			}
		}

		var2 = 1;
		var3 = 2;
		var4 = 4;

		for (var5 = 0; var5 < 4; ++var5) {
			if (var5 > 0) {
				var2 <<= 3;
				var3 <<= 3;
				var4 <<= 3;
			}

			for (int var6 = 0; var6 <= var5; ++var6) {
				for (int var7 = 0; var7 <= 104; ++var7) {
					for (int var8 = 0; var8 <= 104; ++var8) {
						short var50;
						if ((Tiles.field483[var6][var8][var7] & var2) != 0) {
							var9 = var7;
							var10 = var7;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (Tiles.field483[var6][var8][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (Tiles.field483[var6][var8][var10 + 1] & var2) != 0) {
								++var10;
							}

							label483:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field483[var11 - 1][var8][var13] & var2) == 0) {
										break label483;
									}
								}

								--var11;
							}

							label472:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field483[var12 + 1][var8][var13] & var2) == 0) {
										break label472;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var50 = 240;
								var15 = Tiles.Tiles_heights[var12][var8][var9] - var50;
								var16 = Tiles.Tiles_heights[var11][var8][var9];
								Scene.Scene_addOccluder(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = Tiles.field483[var17][var8];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((Tiles.field483[var6][var8][var7] & var3) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (Tiles.field483[var6][var9 - 1][var7] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (Tiles.field483[var6][var10 + 1][var7] & var3) != 0) {
								++var10;
							}

							label536:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field483[var11 - 1][var13][var7] & var3) == 0) {
										break label536;
									}
								}

								--var11;
							}

							label525:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field483[var12 + 1][var13][var7] & var3) == 0) {
										break label525;
									}
								}

								++var12;
							}

							var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
							if (var13 >= 8) {
								var50 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var7] - var50;
								var16 = Tiles.Tiles_heights[var11][var9][var7];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = Tiles.field483[var17][var18];
										var10000[var7] &= ~var3;
									}
								}
							}
						}

						if ((Tiles.field483[var6][var8][var7] & var4) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var7;

							for (var12 = var7; var11 > 0 && (Tiles.field483[var6][var8][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (Tiles.field483[var6][var8][var12 + 1] & var4) != 0) {
								++var12;
							}

							label589:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((Tiles.field483[var6][var9 - 1][var13] & var4) == 0) {
										break label589;
									}
								}

								--var9;
							}

							label578:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((Tiles.field483[var6][var10 + 1][var13] & var4) == 0) {
										break label578;
									}
								}

								++var10;
							}

							if ((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var6][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = Tiles.field483[var6][var14];
										var10000[var15] &= ~var4;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "510477713"
	)
	static final int method101(int var0, int var1) {
		int var2 = User.method4969(var0 + 45365, var1 + 91923, 4) - 128 + (User.method4969(var0 + 10294, 37821 + var1, 2) - 128 >> 1) + (User.method4969(var0, var1, 1) - 128 >> 2);
		var2 = (int)(0.3D * (double)var2) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "-30"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) + Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] * var6 >> 7;
			return var8 * (128 - var7) + var9 * var7 >> 7;
		} else {
			return 0;
		}
	}
}
