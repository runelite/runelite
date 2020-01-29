import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class288 {
	@ObfuscatedName("c")
	@Export("cp1252AsciiExtension")
	public static final char[] cp1252AsciiExtension;

	static {
		cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(Lbx;IIIIIB)V",
		garbageValue = "1"
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

			int var76 = Players.Players_count;
			int[] var7 = Players.Players_indices;
			byte var8 = 0;
			int var10;
			if (var1 < var76 && var0.playerCycle == Client.cycle && ClientPreferences.method1840((Player)var0)) {
				Player var9 = (Player)var0;
				if (var1 < var76) {
					var10 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var10);
					AbstractFont var11 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
					byte var12 = 9;
					var11.drawCentered(var9.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var12, 16777215, 0);
					var8 = 18;
				}
			}

			int var77 = -2;
			int var16;
			int var17;
			int var23;
			int var24;
			if (!var0.healthBars.method4886()) {
				var10 = var0.defaultHeight + 15;
				MouseRecorder.worldToScreen(var0.x, var0.y, var10);

				for (HealthBar var91 = (HealthBar)var0.healthBars.last(); var91 != null; var91 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var78 = var91.get(Client.cycle);
					if (var78 == null) {
						if (var91.isEmpty()) {
							var91.remove();
						}
					} else {
						HealthBarDefinition var13 = var91.definition;
						Sprite var14 = var13.getBackSprite();
						Sprite var15 = var13.getFrontSprite();
						var17 = 0;
						if (var14 != null && var15 != null) {
							if (var13.widthPadding * 2 < var15.subWidth) {
								var17 = var13.widthPadding;
							}

							var16 = var15.subWidth - var17 * 2;
						} else {
							var16 = var13.width;
						}

						int var18 = 255;
						boolean var19 = true;
						int var20 = Client.cycle - var78.cycle;
						int var21 = var16 * var78.health2 / var13.width;
						int var22;
						int var95;
						if (var78.cycleOffset > var20) {
							var22 = var13.field3283 == 0 ? 0 : var13.field3283 * (var20 / var13.field3283);
							var23 = var16 * var78.health / var13.width;
							var95 = var22 * (var21 - var23) / var78.cycleOffset + var23;
						} else {
							var95 = var21;
							var22 = var78.cycleOffset + var13.int5 - var20;
							if (var13.int3 >= 0) {
								var18 = (var22 << 8) / (var13.int5 - var13.int3);
							}
						}

						if (var78.health2 > 0 && var95 < 1) {
							var95 = 1;
						}

						if (var14 != null && var15 != null) {
							if (var16 == var95) {
								var95 += var17 * 2;
							} else {
								var95 += var17;
							}

							var22 = var14.subHeight;
							var77 += var22;
							var23 = var2 + Client.viewportTempX - (var16 >> 1);
							var24 = var3 + Client.viewportTempY - var77;
							var23 -= var17;
							if (var18 >= 0 && var18 < 255) {
								var14.drawTransAt(var23, var24, var18);
								Rasterizer2D.Rasterizer2D_expandClip(var23, var24, var23 + var95, var22 + var24);
								var15.drawTransAt(var23, var24, var18);
							} else {
								var14.drawTransBgAt(var23, var24);
								Rasterizer2D.Rasterizer2D_expandClip(var23, var24, var23 + var95, var22 + var24);
								var15.drawTransBgAt(var23, var24);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var77 += 2;
						} else {
							var77 += 5;
							if (Client.viewportTempX > -1) {
								var22 = var2 + Client.viewportTempX - (var16 >> 1);
								var23 = var3 + Client.viewportTempY - var77;
								Rasterizer2D.Rasterizer2D_fillRectangle(var22, var23, var95, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var95 + var22, var23, var16 - var95, 5, 16711680);
							}

							var77 += 2;
						}
					}
				}
			}

			if (var77 == -2) {
				var77 += 7;
			}

			var77 += var8;
			int var80;
			if (var1 < var76) {
				Player var79 = (Player)var0;
				if (var79.isHidden) {
					return;
				}

				if (var79.headIconPk != -1 || var79.headIconPrayer != -1) {
					var80 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var80);
					if (Client.viewportTempX > -1) {
						if (var79.headIconPk != -1) {
							var77 += 25;
							Ignored.headIconPkSprites[var79.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var77);
						}

						if (var79.headIconPrayer != -1) {
							var77 += 25;
							class40.headIconPrayerSprites[var79.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var77);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					var80 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var80);
					if (Client.viewportTempX > -1) {
						var77 += SecureRandomCallable.headIconHintSprites[1].subHeight;
						SecureRandomCallable.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var77);
					}
				}
			} else {
				NPCDefinition var97 = ((NPC)var0).definition;
				if (var97.transforms != null) {
					var97 = var97.transform();
				}

				if (var97.headIconPrayer >= 0 && var97.headIconPrayer < class40.headIconPrayerSprites.length) {
					var80 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var80);
					if (Client.viewportTempX > -1) {
						class40.headIconPrayerSprites[var97.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var76] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					var80 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var80);
					if (Client.viewportTempX > -1) {
						SecureRandomCallable.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var76 || !var0.field954 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				var10 = var0.defaultHeight;
				MouseRecorder.worldToScreen(var0.x, var0.y, var10);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = class1.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = class1.fontBold12.ascent;
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
				var80 = var0.hitSplatCycles[var10];
				int var92 = var0.hitSplatTypes[var10];
				HitSplatDefinition var93 = null;
				int var81 = 0;
				HitSplatDefinition var84;
				if (var92 >= 0) {
					if (var80 <= Client.cycle) {
						continue;
					}

					var16 = var0.hitSplatTypes[var10];
					var84 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var16);
					HitSplatDefinition var94;
					if (var84 != null) {
						var94 = var84;
					} else {
						byte[] var85 = class49.HitSplatDefinition_archive.takeFile(32, var16);
						var84 = new HitSplatDefinition();
						if (var85 != null) {
							var84.decode(new Buffer(var85));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var84, (long)var16);
						var94 = var84;
					}

					var93 = var94;
					var81 = var94.field3328;
					if (var94 != null && var94.transforms != null) {
						var93 = var94.transform();
						if (var93 == null) {
							var0.hitSplatCycles[var10] = -1;
							continue;
						}
					}
				} else if (var80 < 0) {
					continue;
				}

				int var82 = var0.hitSplatTypes2[var10];
				HitSplatDefinition var83 = null;
				if (var82 >= 0) {
					HitSplatDefinition var98 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var82);
					if (var98 != null) {
						var84 = var98;
					} else {
						byte[] var86 = class49.HitSplatDefinition_archive.takeFile(32, var82);
						var98 = new HitSplatDefinition();
						if (var86 != null) {
							var98.decode(new Buffer(var86));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var98, (long)var82);
						var84 = var98;
					}

					var83 = var84;
					if (var84 != null && var84.transforms != null) {
						var83 = var84.transform();
					}
				}

				if (var80 - var81 <= Client.cycle) {
					if (var93 == null) {
						var0.hitSplatCycles[var10] = -1;
					} else {
						var17 = var0.defaultHeight / 2;
						MouseRecorder.worldToScreen(var0.x, var0.y, var17);
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

							Sprite var99 = null;
							Sprite var87 = null;
							Sprite var88 = null;
							Sprite var89 = null;
							var23 = 0;
							var24 = 0;
							int var25 = 0;
							int var26 = 0;
							int var27 = 0;
							int var28 = 0;
							int var29 = 0;
							int var30 = 0;
							Sprite var31 = null;
							Sprite var32 = null;
							Sprite var33 = null;
							Sprite var34 = null;
							int var35 = 0;
							int var36 = 0;
							int var37 = 0;
							int var38 = 0;
							int var39 = 0;
							int var40 = 0;
							int var41 = 0;
							int var42 = 0;
							int var43 = 0;
							var99 = var93.method4649();
							int var44;
							if (var99 != null) {
								var23 = var99.subWidth;
								var44 = var99.subHeight;
								if (var44 > var43) {
									var43 = var44;
								}

								var27 = var99.xOffset;
							}

							var87 = var93.method4650();
							if (var87 != null) {
								var24 = var87.subWidth;
								var44 = var87.subHeight;
								if (var44 > var43) {
									var43 = var44;
								}

								var28 = var87.xOffset;
							}

							var88 = var93.method4651();
							if (var88 != null) {
								var25 = var88.subWidth;
								var44 = var88.subHeight;
								if (var44 > var43) {
									var43 = var44;
								}

								var29 = var88.xOffset;
							}

							var89 = var93.method4652();
							if (var89 != null) {
								var26 = var89.subWidth;
								var44 = var89.subHeight;
								if (var44 > var43) {
									var43 = var44;
								}

								var30 = var89.xOffset;
							}

							if (var83 != null) {
								var31 = var83.method4649();
								if (var31 != null) {
									var35 = var31.subWidth;
									var44 = var31.subHeight;
									if (var44 > var43) {
										var43 = var44;
									}

									var39 = var31.xOffset;
								}

								var32 = var83.method4650();
								if (var32 != null) {
									var36 = var32.subWidth;
									var44 = var32.subHeight;
									if (var44 > var43) {
										var43 = var44;
									}

									var40 = var32.xOffset;
								}

								var33 = var83.method4651();
								if (var33 != null) {
									var37 = var33.subWidth;
									var44 = var33.subHeight;
									if (var44 > var43) {
										var43 = var44;
									}

									var41 = var33.xOffset;
								}

								var34 = var83.method4652();
								if (var34 != null) {
									var38 = var34.subWidth;
									var44 = var34.subHeight;
									if (var44 > var43) {
										var43 = var44;
									}

									var42 = var34.xOffset;
								}
							}

							Font var90 = var93.getFont();
							if (var90 == null) {
								var90 = WorldMapData_0.fontPlain11;
							}

							Font var45;
							if (var83 != null) {
								var45 = var83.getFont();
								if (var45 == null) {
									var45 = WorldMapData_0.fontPlain11;
								}
							} else {
								var45 = WorldMapData_0.fontPlain11;
							}

							String var46 = null;
							String var47 = null;
							boolean var48 = false;
							int var49 = 0;
							var46 = var93.getString(var0.hitSplatValues[var10]);
							int var96 = var90.stringWidth(var46);
							if (var83 != null) {
								var47 = var83.getString(var0.hitSplatValues2[var10]);
								var49 = var45.stringWidth(var47);
							}

							int var50 = 0;
							int var51 = 0;
							if (var24 > 0) {
								if (var88 == null && var89 == null) {
									var50 = 1;
								} else {
									var50 = var96 / var24 + 1;
								}
							}

							if (var83 != null && var36 > 0) {
								if (var33 == null && var34 == null) {
									var51 = 1;
								} else {
									var51 = var49 / var36 + 1;
								}
							}

							int var52 = 0;
							int var53 = var52;
							if (var23 > 0) {
								var52 += var23;
							}

							var52 += 2;
							int var54 = var52;
							if (var25 > 0) {
								var52 += var25;
							}

							int var55 = var52;
							int var56 = var52;
							int var57;
							if (var24 > 0) {
								var57 = var24 * var50;
								var52 += var57;
								var56 += (var57 - var96) / 2;
							} else {
								var52 += var96;
							}

							var57 = var52;
							if (var26 > 0) {
								var52 += var26;
							}

							int var58 = 0;
							int var59 = 0;
							int var60 = 0;
							int var61 = 0;
							int var62 = 0;
							int var63;
							if (var83 != null) {
								var52 += 2;
								var58 = var52;
								if (var35 > 0) {
									var52 += var35;
								}

								var52 += 2;
								var59 = var52;
								if (var37 > 0) {
									var52 += var37;
								}

								var60 = var52;
								var62 = var52;
								if (var36 > 0) {
									var63 = var36 * var51;
									var52 += var63;
									var62 += (var63 - var49) / 2;
								} else {
									var52 += var49;
								}

								var61 = var52;
								if (var38 > 0) {
									var52 += var38;
								}
							}

							var63 = var0.hitSplatCycles[var10] - Client.cycle;
							int var64 = var93.field3323 - var63 * var93.field3323 / var93.field3328;
							int var65 = var63 * var93.field3334 / var93.field3328 + -var93.field3334;
							int var66 = var64 + (var2 + Client.viewportTempX - (var52 >> 1));
							int var67 = var3 + Client.viewportTempY - 12 + var65;
							int var68 = var67;
							int var69 = var67 + var43;
							int var70 = var67 + var93.field3338 + 15;
							int var71 = var70 - var90.maxAscent;
							int var72 = var70 + var90.maxDescent;
							if (var71 < var67) {
								var68 = var71;
							}

							if (var72 > var69) {
								var69 = var72;
							}

							int var73 = 0;
							int var74;
							int var75;
							if (var83 != null) {
								var73 = var67 + var83.field3338 + 15;
								var74 = var73 - var45.maxAscent;
								var75 = var73 + var45.maxDescent;
								if (var74 < var68) {
									;
								}

								if (var75 > var69) {
									;
								}
							}

							var74 = 255;
							if (var93.field3335 >= 0) {
								var74 = (var63 << 8) / (var93.field3328 - var93.field3335);
							}

							if (var74 >= 0 && var74 < 255) {
								if (var99 != null) {
									var99.drawTransAt(var53 + var66 - var27, var67, var74);
								}

								if (var88 != null) {
									var88.drawTransAt(var54 + var66 - var29, var67, var74);
								}

								if (var87 != null) {
									for (var75 = 0; var75 < var50; ++var75) {
										var87.drawTransAt(var24 * var75 + (var55 + var66 - var28), var67, var74);
									}
								}

								if (var89 != null) {
									var89.drawTransAt(var66 + var57 - var30, var67, var74);
								}

								var90.drawAlpha(var46, var66 + var56, var70, var93.textColor, 0, var74);
								if (var83 != null) {
									if (var31 != null) {
										var31.drawTransAt(var58 + var66 - var39, var67, var74);
									}

									if (var33 != null) {
										var33.drawTransAt(var66 + var59 - var41, var67, var74);
									}

									if (var32 != null) {
										for (var75 = 0; var75 < var51; ++var75) {
											var32.drawTransAt(var36 * var75 + (var60 + var66 - var40), var67, var74);
										}
									}

									if (var34 != null) {
										var34.drawTransAt(var66 + var61 - var42, var67, var74);
									}

									var45.drawAlpha(var47, var62 + var66, var73, var83.textColor, 0, var74);
								}
							} else {
								if (var99 != null) {
									var99.drawTransBgAt(var66 + var53 - var27, var67);
								}

								if (var88 != null) {
									var88.drawTransBgAt(var54 + var66 - var29, var67);
								}

								if (var87 != null) {
									for (var75 = 0; var75 < var50; ++var75) {
										var87.drawTransBgAt(var75 * var24 + (var66 + var55 - var28), var67);
									}
								}

								if (var89 != null) {
									var89.drawTransBgAt(var57 + var66 - var30, var67);
								}

								var90.draw(var46, var56 + var66, var70, var93.textColor | -16777216, 0);
								if (var83 != null) {
									if (var31 != null) {
										var31.drawTransBgAt(var58 + var66 - var39, var67);
									}

									if (var33 != null) {
										var33.drawTransBgAt(var59 + var66 - var41, var67);
									}

									if (var32 != null) {
										for (var75 = 0; var75 < var51; ++var75) {
											var32.drawTransBgAt(var36 * var75 + (var60 + var66 - var40), var67);
										}
									}

									if (var34 != null) {
										var34.drawTransBgAt(var61 + var66 - var42, var67);
									}

									var45.draw(var47, var62 + var66, var73, var83.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}
}
