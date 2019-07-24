import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("w")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("e")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("p")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("k")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;
	@ObfuscatedName("q")
	@Export("events")
	public final List events;

	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	}

	@ObfuscatedSignature(
		signature = "(Lkf;Z)V",
		garbageValue = "1"
	)
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.events = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.events.add(new GrandExchangeEvent(var1, var5, var3));
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZS)V",
		garbageValue = "128"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lgw;",
		garbageValue = "-249126537"
	)
	public static class185[] method70() {
		return new class185[]{class185.field2322, class185.field2316, class185.field2318, class185.field2317, class185.field2324, class185.field2319, class185.field2320, class185.field2321, class185.field2315, class185.field2323};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;B)V",
		garbageValue = "-127"
	)
	public static void method66(AbstractArchive var0, AbstractArchive var1) {
		KitDefinition.KitDefinition_archive = var0;
		class288.KitDefinition_modelsArchive = var1;
		KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "1"
	)
	public static void method68(AbstractArchive var0) {
		VarpDefinition.VarpDefinition_archive = var0;
		VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ler;[Lfv;I)V",
		garbageValue = "-1548454076"
	)
	static final void method72(Scene var0, CollisionMap[] var1) {
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
							var1[var5].method3561(var3, var4);
						}
					}
				}
			}
		}

		Tiles.field519 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field519 < -8) {
			Tiles.field519 = -8;
		}

		if (Tiles.field519 > 8) {
			Tiles.field519 = 8;
		}

		Tiles.field510 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field510 < -16) {
			Tiles.field510 = -16;
		}

		if (Tiles.field510 > 16) {
			Tiles.field510 = 16;
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
			byte[][] var44 = class32.field282[var2];
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
					var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
					var20 = (var44[var12][var11 + 1] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2) + (var44[var12 + 1][var11] >> 3) + (var44[var12][var11] >> 1);
					Tiles.field515[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				ServerBuild.field3103[var11] = 0;
				Tiles.field508[var11] = 0;
				Tiles.field507[var11] = 0;
				DynamicObject.field1301[var11] = 0;
				Fonts.field3689[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = Tiles.field504[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var45 = ItemContainer.method1117(var14 - 1);
							var10000 = ServerBuild.field3103;
							var10000[var12] += var45.hue;
							var10000 = Tiles.field508;
							var10000[var12] += var45.saturation;
							var10000 = Tiles.field507;
							var10000[var12] += var45.lightness;
							var10000 = DynamicObject.field1301;
							var10000[var12] += var45.hueMultiplier;
							var10002 = Fonts.field3689[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = Tiles.field504[var2][var14][var12] & 255;
						if (var15 > 0) {
							var17 = var15 - 1;
							FloorUnderlayDefinition var46 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var17);
							FloorUnderlayDefinition var47;
							if (var46 != null) {
								var47 = var46;
							} else {
								byte[] var48 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var17);
								var46 = new FloorUnderlayDefinition();
								if (var48 != null) {
									var46.decode(new Buffer(var48), var17);
								}

								var46.postDecode();
								FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var46, (long)var17);
								var47 = var46;
							}

							var10000 = ServerBuild.field3103;
							var10000[var12] -= var47.hue;
							var10000 = Tiles.field508;
							var10000[var12] -= var47.saturation;
							var10000 = Tiles.field507;
							var10000[var12] -= var47.lightness;
							var10000 = DynamicObject.field1301;
							var10000[var12] -= var47.hueMultiplier;
							var10002 = Fonts.field3689[var12]--;
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
							var12 += ServerBuild.field3103[var18];
							var13 += Tiles.field508[var18];
							var14 += Tiles.field507[var18];
							var15 += DynamicObject.field1301[var18];
							var16 += Fonts.field3689[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= ServerBuild.field3103[var19];
							var13 -= Tiles.field508[var19];
							var14 -= Tiles.field507[var19];
							var15 -= DynamicObject.field1301[var19];
							var16 -= Fonts.field3689[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = Tiles.field504[var2][var11][var17] & 255;
							int var21 = Tiles.field505[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = Tiles.field515[var11][var17];
								int var27 = Tiles.field515[var11 + 1][var17];
								int var28 = Tiles.field515[var11 + 1][var17 + 1];
								int var29 = Tiles.field515[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								int var34;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									var34 = var14 / var16;
									var30 = class327.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.field519 & 255;
									var34 += Tiles.field510;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = class327.hslToRgb(var32, var33, var34);
								}

								FloorOverlayDefinition var35;
								if (var2 > 0) {
									boolean var53 = true;
									if (var20 == 0 && Tiles.field506[var2][var11][var17] != 0) {
										var53 = false;
									}

									if (var21 > 0) {
										var34 = var21 - 1;
										var35 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var34);
										FloorOverlayDefinition var49;
										if (var35 != null) {
											var49 = var35;
										} else {
											byte[] var36 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var34);
											var35 = new FloorOverlayDefinition();
											if (var36 != null) {
												var35.decode(new Buffer(var36), var34);
											}

											var35.postDecode();
											FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var35, (long)var34);
											var49 = var35;
										}

										if (!var49.hideUnderlay) {
											var53 = false;
										}
									}

									if (var53 && var23 == var22 && var22 == var24 && var25 == var22) {
										var10000 = FaceNormal.field1887[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[GraphicsObject.method1948(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, GraphicsObject.method1948(var30, var26), GraphicsObject.method1948(var30, var27), GraphicsObject.method1948(var30, var28), GraphicsObject.method1948(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = Tiles.field506[var2][var11][var17] + 1;
									byte var54 = class268.field3561[var2][var11][var17];
									int var50 = var21 - 1;
									FloorOverlayDefinition var37 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var50);
									if (var37 != null) {
										var35 = var37;
									} else {
										byte[] var38 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var50);
										var37 = new FloorOverlayDefinition();
										if (var38 != null) {
											var37.decode(new Buffer(var38), var50);
										}

										var37.postDecode();
										FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var37, (long)var50);
										var35 = var37;
									}

									int var51 = var35.texture;
									int var39;
									int var40;
									int var41;
									int var42;
									if (var51 >= 0) {
										var40 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var51);
										var39 = -1;
									} else if (var35.primaryRgb == 16711935) {
										var39 = -2;
										var51 = -1;
										var40 = -2;
									} else {
										var39 = class327.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var41 = var35.hue + Tiles.field519 & 255;
										var42 = var35.lightness + Tiles.field510;
										if (var42 < 0) {
											var42 = 0;
										} else if (var42 > 255) {
											var42 = 255;
										}

										var40 = class327.hslToRgb(var41, var35.saturation, var42);
									}

									var41 = 0;
									if (var40 != -2) {
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[Decimator.method2517(var40, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var42 = var35.secondaryHue + Tiles.field519 & 255;
										int var43 = var35.secondaryLightness + Tiles.field510;
										if (var43 < 0) {
											var43 = 0;
										} else if (var43 > 255) {
											var43 = 255;
										}

										var40 = class327.hslToRgb(var42, var35.secondarySaturation, var43);
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[Decimator.method2517(var40, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var54, var51, var22, var23, var24, var25, GraphicsObject.method1948(var30, var26), GraphicsObject.method1948(var30, var27), GraphicsObject.method1948(var30, var28), GraphicsObject.method1948(var30, var29), Decimator.method2517(var39, var26), Decimator.method2517(var39, var27), Decimator.method2517(var39, var28), Decimator.method2517(var39, var29), var32, var41);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var0.setTileMinPlane(var2, var12, var11, MilliClock.method3468(var2, var12, var11));
				}
			}

			Tiles.field504[var2] = null;
			Tiles.field505[var2] = null;
			Tiles.field506[var2] = null;
			class268.field3561[var2] = null;
			class32.field282[var2] = null;
		}

		var0.method3097(-50, -10, -50);

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
						short var52;
						if ((FaceNormal.field1887[var6][var8][var7] & var2) != 0) {
							var9 = var7;
							var10 = var7;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (FaceNormal.field1887[var6][var8][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (FaceNormal.field1887[var6][var8][var10 + 1] & var2) != 0) {
								++var10;
							}

							label478:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((FaceNormal.field1887[var11 - 1][var8][var13] & var2) == 0) {
										break label478;
									}
								}

								--var11;
							}

							label467:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((FaceNormal.field1887[var12 + 1][var8][var13] & var2) == 0) {
										break label467;
									}
								}

								++var12;
							}

							var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
							if (var13 >= 8) {
								var52 = 240;
								var15 = Tiles.Tiles_heights[var12][var8][var9] - var52;
								var16 = Tiles.Tiles_heights[var11][var8][var9];
								Scene.Scene_addOccluder(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = FaceNormal.field1887[var17][var8];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((FaceNormal.field1887[var6][var8][var7] & var3) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (FaceNormal.field1887[var6][var9 - 1][var7] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (FaceNormal.field1887[var6][var10 + 1][var7] & var3) != 0) {
								++var10;
							}

							label531:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((FaceNormal.field1887[var11 - 1][var13][var7] & var3) == 0) {
										break label531;
									}
								}

								--var11;
							}

							label520:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((FaceNormal.field1887[var12 + 1][var13][var7] & var3) == 0) {
										break label520;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var52 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var7] - var52;
								var16 = Tiles.Tiles_heights[var11][var9][var7];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = FaceNormal.field1887[var17][var18];
										var10000[var7] &= ~var3;
									}
								}
							}
						}

						if ((FaceNormal.field1887[var6][var8][var7] & var4) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var7;

							for (var12 = var7; var11 > 0 && (FaceNormal.field1887[var6][var8][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (FaceNormal.field1887[var6][var8][var12 + 1] & var4) != 0) {
								++var12;
							}

							label584:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((FaceNormal.field1887[var6][var9 - 1][var13] & var4) == 0) {
										break label584;
									}
								}

								--var9;
							}

							label573:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((FaceNormal.field1887[var6][var10 + 1][var13] & var4) == 0) {
										break label573;
									}
								}

								++var10;
							}

							if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var6][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = FaceNormal.field1887[var6][var14];
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

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "(Lhj;IIIIIII)V",
		garbageValue = "-2024126373"
	)
	static final void method71(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field719) {
			Client.field882 = 32;
		} else {
			Client.field882 = 0;
		}

		Client.field719 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				Strings.method4120(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				Strings.method4120(var0);
			} else if (var5 >= var1 - Client.field882 && var5 < Client.field882 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				Strings.method4120(var0);
				Client.field719 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				Strings.method4120(var0);
			}
		}

	}
}
