import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class80 {
	@ObfuscatedName("z")
	static final BigInteger field1129;
	@ObfuscatedName("p")
	static final BigInteger field1130;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -1429349443
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;

	static {
		field1129 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1130 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(Lbt;IIIIII)V",
		garbageValue = "-309785570"
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
			int var10;
			if (var1 < var75 && var0.playerCycle == Client.cycle && class30.method563((Player)var0)) {
				Player var9 = (Player)var0;
				if (var1 < var75) {
					var10 = var0.defaultHeight + 15;
					TextureProvider.worldToScreen(var0.x, var0.y, var10);
					AbstractFont var11 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
					byte var12 = 9;
					var11.drawCentered(var9.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var12, 16777215, 0);
					var8 = 18;
				}
			}

			int var76 = -2;
			int var15;
			int var16;
			int var22;
			int var23;
			if (!var0.healthBars.method4911()) {
				ItemContainer.getActorScreenLocation(var0, var0.defaultHeight + 15);

				for (HealthBar var77 = (HealthBar)var0.healthBars.last(); var77 != null; var77 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var89 = var77.get(Client.cycle);
					if (var89 == null) {
						if (var77.isEmpty()) {
							var77.remove();
						}
					} else {
						HealthBarDefinition var78 = var77.definition;
						Sprite var13 = var78.getBackSprite();
						Sprite var14 = var78.getFrontSprite();
						var16 = 0;
						if (var13 != null && var14 != null) {
							if (var78.widthPadding * 2 < var14.subWidth) {
								var16 = var78.widthPadding;
							}

							var15 = var14.subWidth - var16 * 2;
						} else {
							var15 = var78.width;
						}

						int var17 = 255;
						boolean var18 = true;
						int var19 = Client.cycle - var89.cycle;
						int var20 = var15 * var89.health2 / var78.width;
						int var21;
						int var92;
						if (var89.cycleOffset > var19) {
							var21 = var78.int4 == 0 ? 0 : var78.int4 * (var19 / var78.int4);
							var22 = var15 * var89.health / var78.width;
							var92 = var21 * (var20 - var22) / var89.cycleOffset + var22;
						} else {
							var92 = var20;
							var21 = var89.cycleOffset + var78.int5 - var19;
							if (var78.int3 >= 0) {
								var17 = (var21 << 8) / (var78.int5 - var78.int3);
							}
						}

						if (var89.health2 > 0 && var92 < 1) {
							var92 = 1;
						}

						if (var13 != null && var14 != null) {
							if (var15 == var92) {
								var92 += var16 * 2;
							} else {
								var92 += var16;
							}

							var21 = var13.subHeight;
							var76 += var21;
							var22 = var2 + Client.viewportTempX - (var15 >> 1);
							var23 = var3 + Client.viewportTempY - var76;
							var22 -= var16;
							if (var17 >= 0 && var17 < 255) {
								var13.drawTransAt(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var92, var23 + var21);
								var14.drawTransAt(var22, var23, var17);
							} else {
								var13.drawTransBgAt(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var92, var23 + var21);
								var14.drawTransBgAt(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var76 += 2;
						} else {
							var76 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var76;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var92, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var92, var22, var15 - var92, 5, 16711680);
							}

							var76 += 2;
						}
					}
				}
			}

			if (var76 == -2) {
				var76 += 7;
			}

			var76 += var8;
			int var79;
			if (var1 < var75) {
				Player var94 = (Player)var0;
				if (var94.isHidden) {
					return;
				}

				if (var94.headIconPk != -1 || var94.headIconPrayer != -1) {
					ItemContainer.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var94.headIconPk != -1) {
							var76 += 25;
							FontName.headIconPkSprites[var94.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
						}

						if (var94.headIconPrayer != -1) {
							var76 += 25;
							UrlRequest.headIconPrayerSprites[var94.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					var79 = var0.defaultHeight + 15;
					TextureProvider.worldToScreen(var0.x, var0.y, var79);
					if (Client.viewportTempX > -1) {
						var76 += SequenceDefinition.headIconHintSprites[1].subHeight;
						SequenceDefinition.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
					}
				}
			} else {
				NPCDefinition var95 = ((NPC)var0).definition;
				if (var95.transforms != null) {
					var95 = var95.transform();
				}

				if (var95.headIconPrayer >= 0 && var95.headIconPrayer < UrlRequest.headIconPrayerSprites.length) {
					ItemContainer.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						UrlRequest.headIconPrayerSprites[var95.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					ItemContainer.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						SequenceDefinition.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var75 || !var0.field950 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				ItemContainer.getActorScreenLocation(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = JagexCache.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = JagexCache.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
					Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
					Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
					Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
					Client.overheadText[Client.overheadTextCount] = var0.overheadText;
					++Client.overheadTextCount;
				}
			}

			for (var10 = 0; var10 < 4; ++var10) {
				var79 = var0.hitSplatCycles[var10];
				int var90 = var0.hitSplatTypes[var10];
				HitSplatDefinition var91 = null;
				int var80 = 0;
				HitSplatDefinition var81;
				if (var90 >= 0) {
					if (var79 <= Client.cycle) {
						continue;
					}

					var16 = var0.hitSplatTypes[var10];
					var81 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var16);
					HitSplatDefinition var82;
					if (var81 != null) {
						var82 = var81;
					} else {
						byte[] var84 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var16);
						var81 = new HitSplatDefinition();
						if (var84 != null) {
							var81.decode(new Buffer(var84));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var81, (long)var16);
						var82 = var81;
					}

					var91 = var82;
					var80 = var82.field3338;
					if (var82 != null && var82.transforms != null) {
						var91 = var82.transform();
						if (var91 == null) {
							var0.hitSplatCycles[var10] = -1;
							continue;
						}
					}
				} else if (var79 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var10];
				HitSplatDefinition var83 = null;
				HitSplatDefinition var96;
				if (var15 >= 0) {
					var96 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var15);
					if (var96 != null) {
						var81 = var96;
					} else {
						byte[] var85 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var15);
						var96 = new HitSplatDefinition();
						if (var85 != null) {
							var96.decode(new Buffer(var85));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var96, (long)var15);
						var81 = var96;
					}

					var83 = var81;
					if (var81 != null && var81.transforms != null) {
						var83 = var81.transform();
					}
				}

				if (var79 - var80 <= Client.cycle) {
					if (var91 == null) {
						var0.hitSplatCycles[var10] = -1;
					} else {
						ItemContainer.getActorScreenLocation(var0, var0.defaultHeight / 2);
						if (Client.viewportTempX > -1) {
							if (var10 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var10 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var10 == 3) {
								Client.viewportTempX += 15;
								Client.viewportTempY -= 10;
							}

							var96 = null;
							Sprite var97 = null;
							Sprite var86 = null;
							Sprite var87 = null;
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
							Sprite var98 = var91.method4662();
							int var43;
							if (var98 != null) {
								var22 = var98.subWidth;
								var43 = var98.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var98.xOffset;
							}

							var97 = var91.method4663();
							if (var97 != null) {
								var23 = var97.subWidth;
								var43 = var97.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var97.xOffset;
							}

							var86 = var91.method4671();
							if (var86 != null) {
								var24 = var86.subWidth;
								var43 = var86.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var86.xOffset;
							}

							var87 = var91.method4657();
							if (var87 != null) {
								var25 = var87.subWidth;
								var43 = var87.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var87.xOffset;
							}

							if (var83 != null) {
								var30 = var83.method4662();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.xOffset;
								}

								var31 = var83.method4663();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.xOffset;
								}

								var32 = var83.method4671();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.xOffset;
								}

								var33 = var83.method4657();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.xOffset;
								}
							}

							Font var88 = var91.getFont();
							if (var88 == null) {
								var88 = AttackOption.fontPlain11;
							}

							Font var44;
							if (var83 != null) {
								var44 = var83.getFont();
								if (var44 == null) {
									var44 = AttackOption.fontPlain11;
								}
							} else {
								var44 = AttackOption.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var91.getString(var0.hitSplatValues[var10]);
							int var93 = var88.stringWidth(var45);
							if (var83 != null) {
								var46 = var83.getString(var0.hitSplatValues2[var10]);
								var48 = var44.stringWidth(var46);
							}

							int var49 = 0;
							int var50 = 0;
							if (var23 > 0) {
								if (var86 == null && var87 == null) {
									var49 = 1;
								} else {
									var49 = var93 / var23 + 1;
								}
							}

							if (var83 != null && var35 > 0) {
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
								var55 += (var56 - var93) / 2;
							} else {
								var51 += var93;
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
							if (var83 != null) {
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
									var62 = var35 * var50;
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

							var62 = var0.hitSplatCycles[var10] - Client.cycle;
							int var63 = var91.field3343 - var62 * var91.field3343 / var91.field3338;
							int var64 = var62 * var91.field3327 / var91.field3338 + -var91.field3327;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var3 + Client.viewportTempY - 12 + var64;
							int var67 = var66;
							int var68 = var66 + var42;
							int var69 = var66 + var91.field3333 + 15;
							int var70 = var69 - var88.maxAscent;
							int var71 = var69 + var88.maxDescent;
							if (var70 < var66) {
								var67 = var70;
							}

							if (var71 > var68) {
								var68 = var71;
							}

							int var72 = 0;
							int var73;
							int var74;
							if (var83 != null) {
								var72 = var66 + var83.field3333 + 15;
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
							if (var91.field3348 >= 0) {
								var73 = (var62 << 8) / (var91.field3338 - var91.field3348);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var98 != null) {
									var98.drawTransAt(var52 + var65 - var26, var66, var73);
								}

								if (var86 != null) {
									var86.drawTransAt(var65 + var53 - var28, var66, var73);
								}

								if (var97 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var97.drawTransAt(var23 * var74 + (var65 + var54 - var27), var66, var73);
									}
								}

								if (var87 != null) {
									var87.drawTransAt(var56 + var65 - var29, var66, var73);
								}

								var88.drawAlpha(var45, var55 + var65, var69, var91.textColor, 0, var73);
								if (var83 != null) {
									if (var30 != null) {
										var30.drawTransAt(var57 + var65 - var38, var66, var73);
									}

									if (var32 != null) {
										var32.drawTransAt(var58 + var65 - var40, var66, var73);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransAt(var35 * var74 + (var65 + var59 - var39), var66, var73);
										}
									}

									if (var33 != null) {
										var33.drawTransAt(var65 + var60 - var41, var66, var73);
									}

									var44.drawAlpha(var46, var61 + var65, var72, var83.textColor, 0, var73);
								}
							} else {
								if (var98 != null) {
									var98.drawTransBgAt(var65 + var52 - var26, var66);
								}

								if (var86 != null) {
									var86.drawTransBgAt(var53 + var65 - var28, var66);
								}

								if (var97 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var97.drawTransBgAt(var23 * var74 + (var65 + var54 - var27), var66);
									}
								}

								if (var87 != null) {
									var87.drawTransBgAt(var56 + var65 - var29, var66);
								}

								var88.draw(var45, var55 + var65, var69, var91.textColor | -16777216, 0);
								if (var83 != null) {
									if (var30 != null) {
										var30.drawTransBgAt(var57 + var65 - var38, var66);
									}

									if (var32 != null) {
										var32.drawTransBgAt(var65 + var58 - var40, var66);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransBgAt(var74 * var35 + (var65 + var59 - var39), var66);
										}
									}

									if (var33 != null) {
										var33.drawTransBgAt(var65 + var60 - var41, var66);
									}

									var44.draw(var46, var61 + var65, var72, var83.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}
}
