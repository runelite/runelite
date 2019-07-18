import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Decimator")
public class Decimator {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1067673039
	)
	@Export("inputRate")
	int inputRate;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1870278153
	)
	@Export("outputRate")
	int outputRate;
	@ObfuscatedName("l")
	@Export("table")
	int[][] table;

	public Decimator(int var1, int var2) {
		if (var2 != var1) {
			int var3 = FriendSystem.method1819(var1, var2);
			var1 /= var3;
			var2 /= var3;
			this.inputRate = var1;
			this.outputRate = var2;
			this.table = new int[var1][14];

			for (int var4 = 0; var4 < var1; ++var4) {
				int[] var5 = this.table[var4];
				double var6 = (double)var4 / (double)var1 + 6.0D;
				int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
				if (var8 < 0) {
					var8 = 0;
				}

				int var9 = (int)Math.ceil(7.0D + var6);
				if (var9 > 14) {
					var9 = 14;
				}

				for (double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
					double var12 = 3.141592653589793D * ((double)var8 - var6);
					double var14 = var10;
					if (var12 < -1.0E-4D || var12 > 1.0E-4D) {
						var14 = var10 * (Math.sin(var12) / var12);
					}

					var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
					var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
				}
			}

		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BB)[B",
		garbageValue = "68"
	)
	@Export("resample")
	byte[] resample(byte[] var1) {
		if (this.table != null) {
			int var2 = (int)((long)this.outputRate * (long)var1.length / (long)this.inputRate) + 14;
			int[] var3 = new int[var2];
			int var4 = 0;
			int var5 = 0;

			int var6;
			for (var6 = 0; var6 < var1.length; ++var6) {
				byte var7 = var1[var6];
				int[] var8 = this.table[var5];

				int var9;
				for (var9 = 0; var9 < 14; ++var9) {
					var3[var4 + var9] += var7 * var8[var9];
				}

				var5 += this.outputRate;
				var9 = var5 / this.inputRate;
				var4 += var9;
				var5 -= var9 * this.inputRate;
			}

			var1 = new byte[var2];

			for (var6 = 0; var6 < var2; ++var6) {
				int var10 = var3[var6] + 32768 >> 16;
				if (var10 < -128) {
					var1[var6] = -128;
				} else if (var10 > 127) {
					var1[var6] = 127;
				} else {
					var1[var6] = (byte)var10;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1569802818"
	)
	@Export("scaleRate")
	int scaleRate(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate);
		}

		return var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1732624791"
	)
	@Export("scalePosition")
	int scalePosition(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
		}

		return var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "1"
	)
	static final int method2517(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(Lbq;IIIIII)V",
		garbageValue = "-1193836953"
	)
	@Export("drawActor2d")
	static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
		if (var0 != null && var0.isVisible()) {
			if (var0 instanceof NPC) {
				NPCDefinition var6 = ((NPC)var0).definition;
				if (var6.transforms != null) {
					var6 = var6.transform();
				}

				if (var6 == null) {
					return;
				}
			}

			int var75 = Players.Players_count;
			int[] var7 = Players.Players_indices;
			byte var8 = 0;
			Player var10;
			if (var1 < var75 && var0.playerCycle == Client.cycle) {
				var10 = (Player)var0;
				boolean var9;
				if (Client.field774 == 0) {
					var9 = false;
				} else {
					boolean var78;
					if (var10 != Client.localPlayer) {
						var78 = (Client.field774 & 4) != 0;
						boolean var79 = var78;
						boolean var13;
						if (!var78) {
							var13 = (Client.field774 & 1) != 0;
							var79 = var13 && var10.isFriend();
						}

						var13 = var79;
						if (!var79) {
							boolean var80 = (Client.field774 & 2) != 0;
							var13 = var80 && var10.isClanMember();
						}

						var9 = var13;
					} else {
						var78 = (Client.field774 & 8) != 0;
						var9 = var78;
					}
				}

				if (var9) {
					Player var11 = (Player)var0;
					if (var1 < var75) {
						class219.getActorScreenLocation(var0, var0.defaultHeight + 15);
						AbstractFont var12 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
						byte var92 = 9;
						var12.drawCentered(var11.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var92, 16777215, 0);
						var8 = 18;
					}
				}
			}

			int var87 = -2;
			int var15;
			int var22;
			int var23;
			if (!var0.healthBars.isEmpty()) {
				class219.getActorScreenLocation(var0, var0.defaultHeight + 15);

				for (HealthBar var88 = (HealthBar)var0.healthBars.last(); var88 != null; var88 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var89 = var88.get(Client.cycle);
					if (var89 == null) {
						if (var88.isEmpty()) {
							var88.remove();
						}
					} else {
						HealthBarDefinition var91 = var88.definition;
						Sprite var76 = var91.getBackSprite();
						Sprite var14 = var91.getFrontSprite();
						int var16 = 0;
						if (var76 != null && var14 != null) {
							if (var91.widthPadding * 2 < var14.subWidth) {
								var16 = var91.widthPadding;
							}

							var15 = var14.subWidth - var16 * 2;
						} else {
							var15 = var91.width;
						}

						int var17 = 255;
						boolean var18 = true;
						int var19 = Client.cycle - var89.cycle;
						int var20 = var15 * var89.health2 / var91.width;
						int var21;
						int var93;
						if (var89.cycleOffset > var19) {
							var21 = var91.int4 == 0 ? 0 : var91.int4 * (var19 / var91.int4);
							var22 = var15 * var89.health / var91.width;
							var93 = var21 * (var20 - var22) / var89.cycleOffset + var22;
						} else {
							var93 = var20;
							var21 = var89.cycleOffset + var91.int5 - var19;
							if (var91.int3 >= 0) {
								var17 = (var21 << 8) / (var91.int5 - var91.int3);
							}
						}

						if (var89.health2 > 0 && var93 < 1) {
							var93 = 1;
						}

						if (var76 != null && var14 != null) {
							if (var93 == var15) {
								var93 += var16 * 2;
							} else {
								var93 += var16;
							}

							var21 = var76.subHeight;
							var87 += var21;
							var22 = var2 + Client.viewportTempX - (var15 >> 1);
							var23 = var3 + Client.viewportTempY - var87;
							var22 -= var16;
							if (var17 >= 0 && var17 < 255) {
								var76.method6129(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var93 + var22, var21 + var23);
								var14.method6129(var22, var23, var17);
							} else {
								var76.drawAt2(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var93 + var22, var21 + var23);
								var14.drawAt2(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var87 += 2;
						} else {
							var87 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var87;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var93, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var93, var22, var15 - var93, 5, 16711680);
							}

							var87 += 2;
						}
					}
				}
			}

			if (var87 == -2) {
				var87 += 7;
			}

			var87 += var8;
			if (var1 < var75) {
				var10 = (Player)var0;
				if (var10.isHidden) {
					return;
				}

				if (var10.headIconPk != -1 || var10.headIconPrayer != -1) {
					class219.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var10.headIconPk != -1) {
							var87 += 25;
							UserComparator3.headIconPkSprites[var10.headIconPk].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}

						if (var10.headIconPrayer != -1) {
							var87 += 25;
							SoundCache.headIconPrayerSprites[var10.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					class219.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						var87 += class173.headIconHintSprites[1].subHeight;
						class173.headIconHintSprites[1].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
					}
				}
			} else {
				NPCDefinition var90 = ((NPC)var0).definition;
				if (var90.transforms != null) {
					var90 = var90.transform();
				}

				if (var90.headIconPrayer >= 0 && var90.headIconPrayer < SoundCache.headIconPrayerSprites.length) {
					class219.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						SoundCache.headIconPrayerSprites[var90.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					class219.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						class173.headIconHintSprites[0].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var75 || !var0.field998 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				class219.getActorScreenLocation(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = WorldMapIcon_1.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = WorldMapIcon_1.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
					Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
					Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
					Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
					Client.overheadText[Client.overheadTextCount] = var0.overheadText;
					++Client.overheadTextCount;
				}
			}

			for (int var77 = 0; var77 < 4; ++var77) {
				int var96 = var0.hitSplatCycles[var77];
				int var97 = var0.hitSplatTypes[var77];
				HitSplatDefinition var95 = null;
				int var98 = 0;
				if (var97 >= 0) {
					if (var96 <= Client.cycle) {
						continue;
					}

					var95 = Projectile.getHitSplatDefinition(var0.hitSplatTypes[var77]);
					var98 = var95.field3344;
					if (var95 != null && var95.transforms != null) {
						var95 = var95.transform();
						if (var95 == null) {
							var0.hitSplatCycles[var77] = -1;
							continue;
						}
					}
				} else if (var96 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var77];
				HitSplatDefinition var81 = null;
				if (var15 >= 0) {
					var81 = Projectile.getHitSplatDefinition(var15);
					if (var81 != null && var81.transforms != null) {
						var81 = var81.transform();
					}
				}

				if (var96 - var98 <= Client.cycle) {
					if (var95 == null) {
						var0.hitSplatCycles[var77] = -1;
					} else {
						class219.getActorScreenLocation(var0, var0.defaultHeight / 2);
						if (Client.viewportTempX > -1) {
							if (var77 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var77 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var77 == 3) {
								Client.viewportTempX += 15;
								Client.viewportTempY -= 10;
							}

							Sprite var82 = null;
							Sprite var83 = null;
							Sprite var84 = null;
							Sprite var85 = null;
							var22 = 0;
							var23 = 0;
							int var24 = 0;
							int var25 = 0;
							int var26 = 0;
							int var27 = 0;
							int var28 = 0;
							int var29 = 0;
							Sprite var30 = null;
							Sprite var31 = null;
							Sprite var32 = null;
							Sprite var33 = null;
							int var34 = 0;
							int var35 = 0;
							int var36 = 0;
							int var37 = 0;
							int var38 = 0;
							int var39 = 0;
							int var40 = 0;
							int var41 = 0;
							int var42 = 0;
							var82 = var95.method4551();
							int var43;
							if (var82 != null) {
								var22 = var82.subWidth;
								var43 = var82.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var82.yOffset;
							}

							var83 = var95.method4557();
							if (var83 != null) {
								var23 = var83.subWidth;
								var43 = var83.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var83.yOffset;
							}

							var84 = var95.method4558();
							if (var84 != null) {
								var24 = var84.subWidth;
								var43 = var84.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var84.yOffset;
							}

							var85 = var95.method4583();
							if (var85 != null) {
								var25 = var85.subWidth;
								var43 = var85.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var85.yOffset;
							}

							if (var81 != null) {
								var30 = var81.method4551();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.yOffset;
								}

								var31 = var81.method4557();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.yOffset;
								}

								var32 = var81.method4558();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.yOffset;
								}

								var33 = var81.method4583();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.yOffset;
								}
							}

							Font var86 = var95.getFont();
							if (var86 == null) {
								var86 = Coord.fontPlain11;
							}

							Font var44;
							if (var81 != null) {
								var44 = var81.getFont();
								if (var44 == null) {
									var44 = Coord.fontPlain11;
								}
							} else {
								var44 = Coord.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var95.getString(var0.hitSplatValues[var77]);
							int var94 = var86.stringWidth(var45);
							if (var81 != null) {
								var46 = var81.getString(var0.hitSplatValues2[var77]);
								var48 = var44.stringWidth(var46);
							}

							int var49 = 0;
							int var50 = 0;
							if (var23 > 0) {
								if (var84 == null && var85 == null) {
									var49 = 1;
								} else {
									var49 = var94 / var23 + 1;
								}
							}

							if (var81 != null && var35 > 0) {
								if (var32 == null && var33 == null) {
									var50 = 1;
								} else {
									var50 = var48 / var35 + 1;
								}
							}

							int var51 = 0;
							int var52 = var51;
							if (var22 > 0) {
								var51 += var22;
							}

							var51 += 2;
							int var53 = var51;
							if (var24 > 0) {
								var51 += var24;
							}

							int var54 = var51;
							int var55 = var51;
							int var56;
							if (var23 > 0) {
								var56 = var23 * var49;
								var51 += var56;
								var55 += (var56 - var94) / 2;
							} else {
								var51 += var94;
							}

							var56 = var51;
							if (var25 > 0) {
								var51 += var25;
							}

							int var57 = 0;
							int var58 = 0;
							int var59 = 0;
							int var60 = 0;
							int var61 = 0;
							int var62;
							if (var81 != null) {
								var51 += 2;
								var57 = var51;
								if (var34 > 0) {
									var51 += var34;
								}

								var51 += 2;
								var58 = var51;
								if (var36 > 0) {
									var51 += var36;
								}

								var59 = var51;
								var61 = var51;
								if (var35 > 0) {
									var62 = var50 * var35;
									var51 += var62;
									var61 += (var62 - var48) / 2;
								} else {
									var51 += var48;
								}

								var60 = var51;
								if (var37 > 0) {
									var51 += var37;
								}
							}

							var62 = var0.hitSplatCycles[var77] - Client.cycle;
							int var63 = var95.field3335 - var62 * var95.field3335 / var95.field3344;
							int var64 = var62 * var95.field3340 / var95.field3344 + -var95.field3340;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var3 + Client.viewportTempY - 12 + var64;
							int var67 = var66;
							int var68 = var42 + var66;
							int var69 = var66 + var95.field3328 + 15;
							int var70 = var69 - var86.maxAscent;
							int var71 = var69 + var86.maxDescent;
							if (var70 < var66) {
								var67 = var70;
							}

							if (var71 > var68) {
								var68 = var71;
							}

							int var72 = 0;
							int var73;
							int var74;
							if (var81 != null) {
								var72 = var66 + var81.field3328 + 15;
								var73 = var72 - var44.maxAscent;
								var74 = var72 + var44.maxDescent;
								if (var73 < var67) {
									;
								}

								if (var74 > var68) {
									;
								}
							}

							var73 = 255;
							if (var95.field3341 >= 0) {
								var73 = (var62 << 8) / (var95.field3344 - var95.field3341);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var82 != null) {
									var82.method6129(var65 + var52 - var26, var66, var73);
								}

								if (var84 != null) {
									var84.method6129(var65 + var53 - var28, var66, var73);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.method6129(var23 * var74 + (var54 + var65 - var27), var66, var73);
									}
								}

								if (var85 != null) {
									var85.method6129(var56 + var65 - var29, var66, var73);
								}

								var86.drawAlpha(var45, var55 + var65, var69, var95.field3333, 0, var73);
								if (var81 != null) {
									if (var30 != null) {
										var30.method6129(var65 + var57 - var38, var66, var73);
									}

									if (var32 != null) {
										var32.method6129(var65 + var58 - var40, var66, var73);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.method6129(var74 * var35 + (var65 + var59 - var39), var66, var73);
										}
									}

									if (var33 != null) {
										var33.method6129(var60 + var65 - var41, var66, var73);
									}

									var44.drawAlpha(var46, var65 + var61, var72, var81.field3333, 0, var73);
								}
							} else {
								if (var82 != null) {
									var82.drawAt2(var52 + var65 - var26, var66);
								}

								if (var84 != null) {
									var84.drawAt2(var53 + var65 - var28, var66);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.drawAt2(var74 * var23 + (var65 + var54 - var27), var66);
									}
								}

								if (var85 != null) {
									var85.drawAt2(var65 + var56 - var29, var66);
								}

								var86.draw(var45, var65 + var55, var69, var95.field3333 | -16777216, 0);
								if (var81 != null) {
									if (var30 != null) {
										var30.drawAt2(var57 + var65 - var38, var66);
									}

									if (var32 != null) {
										var32.drawAt2(var58 + var65 - var40, var66);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawAt2(var74 * var35 + (var65 + var59 - var39), var66);
										}
									}

									if (var33 != null) {
										var33.drawAt2(var60 + var65 - var41, var66);
									}

									var44.draw(var46, var61 + var65, var72, var81.field3333 | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1767057302"
	)
	static void method2510(int var0) {
		Client.tempMenuAction = new MenuAction();
		Client.tempMenuAction.argument1 = Client.menuArguments1[var0];
		Client.tempMenuAction.argument2 = Client.menuArguments2[var0];
		Client.tempMenuAction.opcode = Client.menuOpcodes[var0];
		Client.tempMenuAction.argument0 = Client.menuArguments0[var0];
		Client.tempMenuAction.action = Client.menuActions[var0];
	}
}
