import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("pg")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lgs;"
	)
	@Export("Language_valuesOrdered")
	public static final Language[] Language_valuesOrdered;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = 1873129621
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;
	@ObfuscatedName("x")
	final String field2342;
	@ObfuscatedName("a")
	@Export("language")
	final String language;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1397403577
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2369, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2369, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2369, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2369, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2360, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2360, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2369, 6, "MX");
		Language[] var0 = new Language[]{Language_PT, Language_FR, Language_ES, Language_ES_MX, Language_NL, Language_DE, Language_EN};
		Language_valuesOrdered = new Language[var0.length];
		Language[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Language var4 = var2[var3];
			if (Language_valuesOrdered[var4.id] != null) {
				throw new IllegalStateException();
			}

			Language_valuesOrdered[var4.id] = var4;
		}

	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgb;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2342 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1974687232"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "525966126"
	)
	static int method3627(int var0, int var1) {
		FloorOverlayDefinition var2 = Messages.FloorUnderlayDefinition_get(var0);
		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else {
			int var3;
			if (var2.texture >= 0) {
				var3 = class80.method2053(Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture), 96);
				return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var3 = Varcs.method2168(var2.hue, var2.saturation, var2.lightness);
				int var4 = class80.method2053(var3, 96);
				return Rasterizer3D.Rasterizer3D_colorPalette[var4] | -16777216;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "-119"
	)
	public static String method3636(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class289.field3634[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class289.field3634[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class289.field3634[(var6 & 15) << 2 | var7 >>> 6]).append(class289.field3634[var7 & 63]);
				} else {
					var3.append(class289.field3634[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class289.field3634[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lej;[Lfp;S)V",
		garbageValue = "-23635"
	)
	static final void method3624(Scene var0, CollisionMap[] var1) {
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

		Tiles.field505 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field505 < -8) {
			Tiles.field505 = -8;
		}

		if (Tiles.field505 > 8) {
			Tiles.field505 = 8;
		}

		Tiles.field492 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field492 < -16) {
			Tiles.field492 = -16;
		}

		if (Tiles.field492 > 16) {
			Tiles.field492 = 16;
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
			byte[][] var42 = Tiles.field496[var2];
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
					var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
					var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11] >> 1);
					ArchiveLoader.field512[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				UrlRequest.Tiles_hue[var11] = 0;
				MenuAction.Tiles_saturation[var11] = 0;
				PacketBufferNode.Tiles_lightness[var11] = 0;
				Tiles.Tiles_hueMultiplier[var11] = 0;
				Varcs.field1244[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = class14.field88[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var43 = WorldMapArea.method405(var14 - 1);
							var10000 = UrlRequest.Tiles_hue;
							var10000[var12] += var43.hue;
							var10000 = MenuAction.Tiles_saturation;
							var10000[var12] += var43.saturation;
							var10000 = PacketBufferNode.Tiles_lightness;
							var10000[var12] += var43.lightness;
							var10000 = Tiles.Tiles_hueMultiplier;
							var10000[var12] += var43.hueMultiplier;
							var10002 = Varcs.field1244[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = class14.field88[var2][var14][var12] & 255;
						if (var15 > 0) {
							FloorUnderlayDefinition var44 = WorldMapArea.method405(var15 - 1);
							var10000 = UrlRequest.Tiles_hue;
							var10000[var12] -= var44.hue;
							var10000 = MenuAction.Tiles_saturation;
							var10000[var12] -= var44.saturation;
							var10000 = PacketBufferNode.Tiles_lightness;
							var10000[var12] -= var44.lightness;
							var10000 = Tiles.Tiles_hueMultiplier;
							var10000[var12] -= var44.hueMultiplier;
							var10002 = Varcs.field1244[var12]--;
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
							var12 += UrlRequest.Tiles_hue[var18];
							var13 += MenuAction.Tiles_saturation[var18];
							var14 += PacketBufferNode.Tiles_lightness[var18];
							var15 += Tiles.Tiles_hueMultiplier[var18];
							var16 += Varcs.field1244[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= UrlRequest.Tiles_hue[var19];
							var13 -= MenuAction.Tiles_saturation[var19];
							var14 -= PacketBufferNode.Tiles_lightness[var19];
							var15 -= Tiles.Tiles_hueMultiplier[var19];
							var16 -= Varcs.field1244[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = class14.field88[var2][var11][var17] & 255;
							int var21 = Tiles.field498[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = ArchiveLoader.field512[var11][var17];
								int var27 = ArchiveLoader.field512[var11 + 1][var17];
								int var28 = ArchiveLoader.field512[var11 + 1][var17 + 1];
								int var29 = ArchiveLoader.field512[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									int var34 = var14 / var16;
									var30 = GameShell.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.field505 & 255;
									var34 += Tiles.field492;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = GameShell.hslToRgb(var32, var33, var34);
								}

								if (var2 > 0) {
									boolean var47 = true;
									if (var20 == 0 && Tiles.field494[var2][var11][var17] != 0) {
										var47 = false;
									}

									if (var21 > 0 && !Messages.FloorUnderlayDefinition_get(var21 - 1).hideUnderlay) {
										var47 = false;
									}

									if (var47 && var23 == var22 && var22 == var24 && var22 == var25) {
										var10000 = Tiles.field501[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[class32.method555(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class32.method555(var30, var26), class32.method555(var30, var27), class32.method555(var30, var28), class32.method555(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = Tiles.field494[var2][var11][var17] + 1;
									byte var48 = Tiles.field493[var2][var11][var17];
									FloorOverlayDefinition var35 = Messages.FloorUnderlayDefinition_get(var21 - 1);
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
										var37 = GameShell.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var39 = var35.hue + Tiles.field505 & 255;
										var40 = var35.lightness + Tiles.field492;
										if (var40 < 0) {
											var40 = 0;
										} else if (var40 > 255) {
											var40 = 255;
										}

										var38 = GameShell.hslToRgb(var39, var35.saturation, var40);
									}

									var39 = 0;
									if (var38 != -2) {
										var39 = Rasterizer3D.Rasterizer3D_colorPalette[ScriptEvent.method1184(var38, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var40 = var35.secondaryHue + Tiles.field505 & 255;
										int var41 = var35.secondaryLightness + Tiles.field492;
										if (var41 < 0) {
											var41 = 0;
										} else if (var41 > 255) {
											var41 = 255;
										}

										var38 = GameShell.hslToRgb(var40, var35.secondarySaturation, var41);
										var39 = Rasterizer3D.Rasterizer3D_colorPalette[ScriptEvent.method1184(var38, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class32.method555(var30, var26), class32.method555(var30, var27), class32.method555(var30, var28), class32.method555(var30, var29), ScriptEvent.method1184(var37, var26), ScriptEvent.method1184(var37, var27), ScriptEvent.method1184(var37, var28), ScriptEvent.method1184(var37, var29), var32, var39);
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

			class14.field88[var2] = null;
			Tiles.field498[var2] = null;
			Tiles.field494[var2] = null;
			Tiles.field493[var2] = null;
			Tiles.field496[var2] = null;
		}

		var0.method3191(-50, -10, -50);

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
						if ((Tiles.field501[var6][var8][var7] & var2) != 0) {
							var9 = var7;
							var10 = var7;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (Tiles.field501[var6][var8][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (Tiles.field501[var6][var8][var10 + 1] & var2) != 0) {
								++var10;
							}

							label462:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field501[var11 - 1][var8][var13] & var2) == 0) {
										break label462;
									}
								}

								--var11;
							}

							label451:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field501[var12 + 1][var8][var13] & var2) == 0) {
										break label451;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var46 = 240;
								var15 = Tiles.Tiles_heights[var12][var8][var9] - var46;
								var16 = Tiles.Tiles_heights[var11][var8][var9];
								Scene.Scene_addOccluder(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = Tiles.field501[var17][var8];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((Tiles.field501[var6][var8][var7] & var3) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (Tiles.field501[var6][var9 - 1][var7] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (Tiles.field501[var6][var10 + 1][var7] & var3) != 0) {
								++var10;
							}

							label515:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field501[var11 - 1][var13][var7] & var3) == 0) {
										break label515;
									}
								}

								--var11;
							}

							label504:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((Tiles.field501[var12 + 1][var13][var7] & var3) == 0) {
										break label504;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var46 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var7] - var46;
								var16 = Tiles.Tiles_heights[var11][var9][var7];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = Tiles.field501[var17][var18];
										var10000[var7] &= ~var3;
									}
								}
							}
						}

						if ((Tiles.field501[var6][var8][var7] & var4) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var7;

							for (var12 = var7; var11 > 0 && (Tiles.field501[var6][var8][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (Tiles.field501[var6][var8][var12 + 1] & var4) != 0) {
								++var12;
							}

							label568:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((Tiles.field501[var6][var9 - 1][var13] & var4) == 0) {
										break label568;
									}
								}

								--var9;
							}

							label557:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((Tiles.field501[var6][var10 + 1][var13] & var4) == 0) {
										break label557;
									}
								}

								++var10;
							}

							if ((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var6][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = Tiles.field501[var6][var14];
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

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-38759309"
	)
	static void method3634(int var0, int var1) {
		int[] var2 = new int[9];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			int var4 = var3 * 32 + 15 + 128;
			int var5 = var4 * 3 + 600;
			int var7 = Rasterizer3D.Rasterizer3D_sine[var4];
			int var6 = WorldMapManager.method635(var5, var1);
			var2[var3] = var6 * var7 >> 16;
		}

		Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
	}
}
