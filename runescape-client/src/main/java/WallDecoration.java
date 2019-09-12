import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 100665877
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 653989891
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1548950965
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1639714203
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -625987959
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -582928969
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -134264581
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 6602395642985356173L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1233883707
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)Liy;",
		garbageValue = "-29"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = GrandExchangeOfferNameComparator.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "2"
	)
	public static void method3256(int var0) {
		class197.field2376 = 1;
		class197.musicTrackArchive = null;
		class197.musicTrackGroupId = -1;
		class197.musicTrackFileId = -1;
		Canvas.field395 = 0;
		MouseRecorder.musicTrackBoolean = false;
		ModelData0.field1833 = var0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lep;[Lfj;I)V",
		garbageValue = "1960688399"
	)
	static final void method3257(Scene var0, CollisionMap[] var1) {
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

		Tiles.field483 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field483 < -8) {
			Tiles.field483 = -8;
		}

		if (Tiles.field483 > 8) {
			Tiles.field483 = 8;
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
			byte[][] var44 = Tiles.field473[var2];
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
					var20 = (var44[var12][var11 + 1] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2) + (var44[var12 + 1][var11] >> 3) + (var44[var12][var11] >> 1);
					class160.field1977[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				UserComparator7.Tiles_hue[var11] = 0;
				TileItem.Tiles_saturation[var11] = 0;
				class1.Tiles_lightness[var11] = 0;
				class42.Tiles_hueMultiplier[var11] = 0;
				Tiles.field488[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = Tiles.field476[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var49 = ServerPacket.FloorUnderlayDefinition_get(var14 - 1);
							var10000 = UserComparator7.Tiles_hue;
							var10000[var12] += var49.hue;
							var10000 = TileItem.Tiles_saturation;
							var10000[var12] += var49.saturation;
							var10000 = class1.Tiles_lightness;
							var10000[var12] += var49.lightness;
							var10000 = class42.Tiles_hueMultiplier;
							var10000[var12] += var49.hueMultiplier;
							var10002 = Tiles.field488[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = Tiles.field476[var2][var14][var12] & 255;
						if (var15 > 0) {
							FloorUnderlayDefinition var45 = ServerPacket.FloorUnderlayDefinition_get(var15 - 1);
							var10000 = UserComparator7.Tiles_hue;
							var10000[var12] -= var45.hue;
							var10000 = TileItem.Tiles_saturation;
							var10000[var12] -= var45.saturation;
							var10000 = class1.Tiles_lightness;
							var10000[var12] -= var45.lightness;
							var10000 = class42.Tiles_hueMultiplier;
							var10000[var12] -= var45.hueMultiplier;
							var10002 = Tiles.field488[var12]--;
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
							var12 += UserComparator7.Tiles_hue[var18];
							var13 += TileItem.Tiles_saturation[var18];
							var14 += class1.Tiles_lightness[var18];
							var15 += class42.Tiles_hueMultiplier[var18];
							var16 += Tiles.field488[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= UserComparator7.Tiles_hue[var19];
							var13 -= TileItem.Tiles_saturation[var19];
							var14 -= class1.Tiles_lightness[var19];
							var15 -= class42.Tiles_hueMultiplier[var19];
							var16 -= Tiles.field488[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = Tiles.field476[var2][var11][var17] & 255;
							int var21 = class30.field257[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = class160.field1977[var11][var17];
								int var27 = class160.field1977[var11 + 1][var17];
								int var28 = class160.field1977[var11 + 1][var17 + 1];
								int var29 = class160.field1977[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								int var34;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									var34 = var14 / var16;
									var30 = Entity.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.field483 & 255;
									var34 += Tiles.field486;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = Entity.hslToRgb(var32, var33, var34);
								}

								FloorOverlayDefinition var35;
								if (var2 > 0) {
									boolean var51 = true;
									if (var20 == 0 && Tiles.field477[var2][var11][var17] != 0) {
										var51 = false;
									}

									if (var21 > 0) {
										var34 = var21 - 1;
										var35 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var34);
										FloorOverlayDefinition var46;
										if (var35 != null) {
											var46 = var35;
										} else {
											byte[] var36 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var34);
											var35 = new FloorOverlayDefinition();
											if (var36 != null) {
												var35.decode(new Buffer(var36), var34);
											}

											var35.postDecode();
											FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var35, (long)var34);
											var46 = var35;
										}

										if (!var46.hideUnderlay) {
											var51 = false;
										}
									}

									if (var51 && var23 == var22 && var22 == var24 && var25 == var22) {
										var10000 = UserComparator3.field1961[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[MusicPatchNode.method3812(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, MusicPatchNode.method3812(var30, var26), MusicPatchNode.method3812(var30, var27), MusicPatchNode.method3812(var30, var28), MusicPatchNode.method3812(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = Tiles.field477[var2][var11][var17] + 1;
									byte var52 = HealthBar.field1089[var2][var11][var17];
									int var47 = var21 - 1;
									FloorOverlayDefinition var37 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var47);
									if (var37 != null) {
										var35 = var37;
									} else {
										byte[] var38 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var47);
										var37 = new FloorOverlayDefinition();
										if (var38 != null) {
											var37.decode(new Buffer(var38), var47);
										}

										var37.postDecode();
										FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var37, (long)var47);
										var35 = var37;
									}

									int var48 = var35.texture;
									int var39;
									int var40;
									int var41;
									int var42;
									if (var48 >= 0) {
										var40 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var48);
										var39 = -1;
									} else if (var35.primaryRgb == 16711935) {
										var39 = -2;
										var48 = -1;
										var40 = -2;
									} else {
										var39 = Entity.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var41 = var35.hue + Tiles.field483 & 255;
										var42 = var35.lightness + Tiles.field486;
										if (var42 < 0) {
											var42 = 0;
										} else if (var42 > 255) {
											var42 = 255;
										}

										var40 = Entity.hslToRgb(var41, var35.saturation, var42);
									}

									var41 = 0;
									if (var40 != -2) {
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[FloorDecoration.method2812(var40, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var42 = var35.secondaryHue + Tiles.field483 & 255;
										int var43 = var35.secondaryLightness + Tiles.field486;
										if (var43 < 0) {
											var43 = 0;
										} else if (var43 > 255) {
											var43 = 255;
										}

										var40 = Entity.hslToRgb(var42, var35.secondarySaturation, var43);
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[FloorDecoration.method2812(var40, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var52, var48, var22, var23, var24, var25, MusicPatchNode.method3812(var30, var26), MusicPatchNode.method3812(var30, var27), MusicPatchNode.method3812(var30, var28), MusicPatchNode.method3812(var30, var29), FloorDecoration.method2812(var39, var26), FloorDecoration.method2812(var39, var27), FloorDecoration.method2812(var39, var28), FloorDecoration.method2812(var39, var29), var32, var41);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var0.setTileMinPlane(var2, var12, var11, Language.method3634(var2, var12, var11));
				}
			}

			Tiles.field476[var2] = null;
			class30.field257[var2] = null;
			Tiles.field477[var2] = null;
			HealthBar.field1089[var2] = null;
			Tiles.field473[var2] = null;
		}

		var0.method3072(-50, -10, -50);

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
						if ((UserComparator3.field1961[var6][var8][var7] & var2) != 0) {
							var9 = var7;
							var10 = var7;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (UserComparator3.field1961[var6][var8][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (UserComparator3.field1961[var6][var8][var10 + 1] & var2) != 0) {
								++var10;
							}

							label495:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((UserComparator3.field1961[var11 - 1][var8][var13] & var2) == 0) {
										break label495;
									}
								}

								--var11;
							}

							label484:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((UserComparator3.field1961[var12 + 1][var8][var13] & var2) == 0) {
										break label484;
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
										var10000 = UserComparator3.field1961[var17][var8];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((UserComparator3.field1961[var6][var8][var7] & var3) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var6;

							for (var12 = var6; var9 > 0 && (UserComparator3.field1961[var6][var9 - 1][var7] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (UserComparator3.field1961[var6][var10 + 1][var7] & var3) != 0) {
								++var10;
							}

							label548:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((UserComparator3.field1961[var11 - 1][var13][var7] & var3) == 0) {
										break label548;
									}
								}

								--var11;
							}

							label537:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((UserComparator3.field1961[var12 + 1][var13][var7] & var3) == 0) {
										break label537;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var50 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var7] - var50;
								var16 = Tiles.Tiles_heights[var11][var9][var7];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = UserComparator3.field1961[var17][var18];
										var10000[var7] &= ~var3;
									}
								}
							}
						}

						if ((UserComparator3.field1961[var6][var8][var7] & var4) != 0) {
							var9 = var8;
							var10 = var8;
							var11 = var7;

							for (var12 = var7; var11 > 0 && (UserComparator3.field1961[var6][var8][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (UserComparator3.field1961[var6][var8][var12 + 1] & var4) != 0) {
								++var12;
							}

							label601:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((UserComparator3.field1961[var6][var9 - 1][var13] & var4) == 0) {
										break label601;
									}
								}

								--var9;
							}

							label590:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((UserComparator3.field1961[var6][var10 + 1][var13] & var4) == 0) {
										break label590;
									}
								}

								++var10;
							}

							if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var6][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = UserComparator3.field1961[var6][var14];
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "7"
	)
	protected static final void method3259() {
		FriendSystem.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.field427[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.field418[var0] = 0L;
		}

		GameShell.field423 = 0;
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2004053653"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		class192.method3648();
		if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
			GrandExchangeOfferUnitPriceComparator.clanChat.clearFriends();
		}

	}
}
