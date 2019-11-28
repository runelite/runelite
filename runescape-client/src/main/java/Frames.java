import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("b")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1770537973
	)
	static int field1880;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Ldg;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.getFile(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1990783363"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lel;[Lfh;B)V",
		garbageValue = "-55"
	)
	static final void method3319(Scene var0, CollisionMap[] var1) {
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

		Tiles.field511 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field511 < -8) {
			Tiles.field511 = -8;
		}

		if (Tiles.field511 > 8) {
			Tiles.field511 = 8;
		}

		Tiles.field503 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field503 < -16) {
			Tiles.field503 = -16;
		}

		if (Tiles.field503 > 16) {
			Tiles.field503 = 16;
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
			byte[][] var42 = class51.field423[var2];
			var9 = (int)Math.sqrt(5100.0D);
			var10 = var9 * 768 >> 8;

			int var19;
			int var20;
			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
					var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
					var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
					var16 = (var13 << 8) / var15;
					var17 = 65536 / var15;
					var18 = (var14 << 8) / var15;
					var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
					var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
					Login.field1207[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				Tiles.Tiles_hue[var11] = 0;
				Tiles.Tiles_saturation[var11] = 0;
				Tiles.Tiles_lightness[var11] = 0;
				class290.Tiles_hueMultiplier[var11] = 0;
				MouseRecorder.field588[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = Tiles.field498[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var43 = WallDecoration.method3339(var14 - 1);
							var10000 = Tiles.Tiles_hue;
							var10000[var12] += var43.hue;
							var10000 = Tiles.Tiles_saturation;
							var10000[var12] += var43.saturation;
							var10000 = Tiles.Tiles_lightness;
							var10000[var12] += var43.lightness;
							var10000 = class290.Tiles_hueMultiplier;
							var10000[var12] += var43.hueMultiplier;
							var10002 = MouseRecorder.field588[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = Tiles.field498[var2][var14][var12] & 255;
						if (var15 > 0) {
							FloorUnderlayDefinition var45 = WallDecoration.method3339(var15 - 1);
							var10000 = Tiles.Tiles_hue;
							var10000[var12] -= var45.hue;
							var10000 = Tiles.Tiles_saturation;
							var10000[var12] -= var45.saturation;
							var10000 = Tiles.Tiles_lightness;
							var10000[var12] -= var45.lightness;
							var10000 = class290.Tiles_hueMultiplier;
							var10000[var12] -= var45.hueMultiplier;
							var10002 = MouseRecorder.field588[var12]--;
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
							var13 += Tiles.Tiles_saturation[var18];
							var14 += Tiles.Tiles_lightness[var18];
							var15 += class290.Tiles_hueMultiplier[var18];
							var16 += MouseRecorder.field588[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= Tiles.Tiles_hue[var19];
							var13 -= Tiles.Tiles_saturation[var19];
							var14 -= Tiles.Tiles_lightness[var19];
							var15 -= class290.Tiles_hueMultiplier[var19];
							var16 -= MouseRecorder.field588[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = Tiles.field498[var2][var11][var17] & 255;
							int var21 = Tiles.field499[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = Login.field1207[var11][var17];
								int var27 = Login.field1207[var11 + 1][var17];
								int var28 = Login.field1207[var11 + 1][var17 + 1];
								int var29 = Login.field1207[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									int var34 = var14 / var16;
									var30 = FriendLoginUpdate.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.field511 & 255;
									var34 += Tiles.field503;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = FriendLoginUpdate.hslToRgb(var32, var33, var34);
								}

								if (var2 > 0) {
									boolean var47 = true;
									if (var20 == 0 && Tiles.field500[var2][var11][var17] != 0) {
										var47 = false;
									}

									if (var21 > 0 && !WorldMapRectangle.FloorUnderlayDefinition_get(var21 - 1).hideUnderlay) {
										var47 = false;
									}

									if (var47 && var23 == var22 && var24 == var22 && var22 == var25) {
										var10000 = WorldMapLabel.field233[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[TriBool.method5255(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, TriBool.method5255(var30, var26), TriBool.method5255(var30, var27), TriBool.method5255(var30, var28), TriBool.method5255(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = Tiles.field500[var2][var11][var17] + 1;
									byte var48 = Tiles.field501[var2][var11][var17];
									FloorOverlayDefinition var35 = WorldMapRectangle.FloorUnderlayDefinition_get(var21 - 1);
									int var36 = var35.texture;
									int var37;
									int var38;
									int var39;
									int var40;
									if (var36 >= 0) {
										var38 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var36);
										var37 = -1;
									} else if (var35.primaryRgb == 16711935) {
										var37 = -2;
										var36 = -1;
										var38 = -2;
									} else {
										var37 = FriendLoginUpdate.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var39 = var35.hue + Tiles.field511 & 255;
										var40 = var35.lightness + Tiles.field503;
										if (var40 < 0) {
											var40 = 0;
										} else if (var40 > 255) {
											var40 = 255;
										}

										var38 = FriendLoginUpdate.hslToRgb(var39, var35.saturation, var40);
									}

									var39 = 0;
									if (var38 != -2) {
										var39 = Rasterizer3D.Rasterizer3D_colorPalette[LoginScreenAnimation.method1832(var38, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var40 = var35.secondaryHue + Tiles.field511 & 255;
										int var41 = var35.secondaryLightness + Tiles.field503;
										if (var41 < 0) {
											var41 = 0;
										} else if (var41 > 255) {
											var41 = 255;
										}

										var38 = FriendLoginUpdate.hslToRgb(var40, var35.secondarySaturation, var41);
										var39 = Rasterizer3D.Rasterizer3D_colorPalette[LoginScreenAnimation.method1832(var38, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, TriBool.method5255(var30, var26), TriBool.method5255(var30, var27), TriBool.method5255(var30, var28), TriBool.method5255(var30, var29), LoginScreenAnimation.method1832(var37, var26), LoginScreenAnimation.method1832(var37, var27), LoginScreenAnimation.method1832(var37, var28), LoginScreenAnimation.method1832(var37, var29), var32, var39);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					if ((Tiles.Tiles_renderFlags[var2][var12][var11] & 8) != 0) {
						var17 = 0;
					} else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var12][var11] & 2) != 0) {
						var17 = var2 - 1;
					} else {
						var17 = var2;
					}

					var0.setTileMinPlane(var2, var12, var11, var17);
				}
			}

			Tiles.field498[var2] = null;
			Tiles.field499[var2] = null;
			Tiles.field500[var2] = null;
			Tiles.field501[var2] = null;
			class51.field423[var2] = null;
		}

		var0.method3165(-50, -10, -50);

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
						short var46;
						if ((WorldMapLabel.field233[var6][var8][var7] & var2) != 0) {
							var9 = var7;
							var10 = var7;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (WorldMapLabel.field233[var6][var8][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (WorldMapLabel.field233[var6][var8][var10 + 1] & var2) != 0) {
								++var10;
							}

							label492:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((WorldMapLabel.field233[var11 - 1][var8][var13] & var2) == 0) {
										break label492;
									}
								}

								--var11;
							}

							label481:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((WorldMapLabel.field233[var12 + 1][var8][var13] & var2) == 0) {
										break label481;
									}
								}

								++var12;
							}

							var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
							if (var13 >= 8) {
								var46 = 240;
								var15 = Tiles.Tiles_heights[var12][var8][var9] - var46;
								var16 = Tiles.Tiles_heights[var11][var8][var9];
								Scene.Scene_addOccluder(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = WorldMapLabel.field233[var17][var8];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((WorldMapLabel.field233[var6][var8][var7] & var3) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (WorldMapLabel.field233[var6][var9 - 1][var7] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (WorldMapLabel.field233[var6][var10 + 1][var7] & var3) != 0) {
								++var10;
							}

							label545:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((WorldMapLabel.field233[var11 - 1][var13][var7] & var3) == 0) {
										break label545;
									}
								}

								--var11;
							}

							label534:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((WorldMapLabel.field233[var12 + 1][var13][var7] & var3) == 0) {
										break label534;
									}
								}

								++var12;
							}

							var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
							if (var13 >= 8) {
								var46 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var7] - var46;
								var16 = Tiles.Tiles_heights[var11][var9][var7];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = WorldMapLabel.field233[var17][var18];
										var10000[var7] &= ~var3;
									}
								}
							}
						}

						if ((WorldMapLabel.field233[var6][var8][var7] & var4) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var7;

							for (var12 = var7; var11 > 0 && (WorldMapLabel.field233[var6][var8][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (WorldMapLabel.field233[var6][var8][var12 + 1] & var4) != 0) {
								++var12;
							}

							label598:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((WorldMapLabel.field233[var6][var9 - 1][var13] & var4) == 0) {
										break label598;
									}
								}

								--var9;
							}

							label587:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((WorldMapLabel.field233[var6][var10 + 1][var13] & var4) == 0) {
										break label587;
									}
								}

								++var10;
							}

							if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var6][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = WorldMapLabel.field233[var6][var14];
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
}
