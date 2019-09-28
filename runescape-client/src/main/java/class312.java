import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
public enum class312 implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3818(4, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3809(1, 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3816(8, 2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3811(2, 3),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3808(6, 4),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3813(5, 5),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3815(0, 6),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3812(7, 7),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	field3814(3, 8);

	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -504561675
	)
	final int field3817;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2131314821
	)
	@Export("id")
	final int id;

	class312(int var3, int var4) {
		this.field3817 = var3;
		this.id = var4;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(Lby;IIIIII)V",
		garbageValue = "2106384053"
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
			if (var1 < var75 && var0.playerCycle == Client.cycle && GrandExchangeOfferUnitPriceComparator.method134((Player)var0)) {
				Player var9 = (Player)var0;
				if (var1 < var75) {
					World.getActorScreenLocation(var0, var0.defaultHeight + 15);
					AbstractFont var10 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
					byte var11 = 9;
					var10.drawCentered(var9.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var11, 16777215, 0);
					var8 = 18;
				}
			}

			int var76 = -2;
			int var15;
			int var16;
			int var22;
			int var23;
			if (!var0.healthBars.method4775()) {
				World.getActorScreenLocation(var0, var0.defaultHeight + 15);

				for (HealthBar var89 = (HealthBar)var0.healthBars.last(); var89 != null; var89 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var77 = var89.get(Client.cycle);
					if (var77 == null) {
						if (var89.isEmpty()) {
							var89.remove();
						}
					} else {
						HealthBarDefinition var12 = var89.definition;
						Sprite var13 = var12.getBackSprite();
						Sprite var14 = var12.getFrontSprite();
						var16 = 0;
						if (var13 != null && var14 != null) {
							if (var12.widthPadding * 2 < var14.subWidth) {
								var16 = var12.widthPadding;
							}

							var15 = var14.subWidth - var16 * 2;
						} else {
							var15 = var12.width;
						}

						int var17 = 255;
						boolean var18 = true;
						int var19 = Client.cycle - var77.cycle;
						int var20 = var15 * var77.health2 / var12.width;
						int var21;
						int var94;
						if (var77.cycleOffset > var19) {
							var21 = var12.int4 == 0 ? 0 : var12.int4 * (var19 / var12.int4);
							var22 = var15 * var77.health / var12.width;
							var94 = var21 * (var20 - var22) / var77.cycleOffset + var22;
						} else {
							var94 = var20;
							var21 = var12.int5 + var77.cycleOffset - var19;
							if (var12.int3 >= 0) {
								var17 = (var21 << 8) / (var12.int5 - var12.int3);
							}
						}

						if (var77.health2 > 0 && var94 < 1) {
							var94 = 1;
						}

						if (var13 != null && var14 != null) {
							if (var15 == var94) {
								var94 += var16 * 2;
							} else {
								var94 += var16;
							}

							var21 = var13.subHeight;
							var76 += var21;
							var22 = var2 + Client.viewportTempX - (var15 >> 1);
							var23 = var3 + Client.viewportTempY - var76;
							var22 -= var16;
							if (var17 >= 0 && var17 < 255) {
								var13.drawTransAt(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var94, var23 + var21);
								var14.drawTransAt(var22, var23, var17);
							} else {
								var13.drawTransBgAt(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var94 + var22, var23 + var21);
								var14.drawTransBgAt(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var76 += 2;
						} else {
							var76 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var76;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var94, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var94, var22, var15 - var94, 5, 16711680);
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
			if (var1 < var75) {
				Player var90 = (Player)var0;
				if (var90.isHidden) {
					return;
				}

				if (var90.headIconPk != -1 || var90.headIconPrayer != -1) {
					World.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var90.headIconPk != -1) {
							var76 += 25;
							StructDefinition.headIconPkSprites[var90.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
						}

						if (var90.headIconPrayer != -1) {
							var76 += 25;
							WorldMapRegion.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					World.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						var76 += ReflectionCheck.headIconHintSprites[1].subHeight;
						ReflectionCheck.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var76);
					}
				}
			} else {
				NPCDefinition var91 = ((NPC)var0).definition;
				if (var91.transforms != null) {
					var91 = var91.transform();
				}

				if (var91.headIconPrayer >= 0 && var91.headIconPrayer < WorldMapRegion.headIconPrayerSprites.length) {
					World.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						WorldMapRegion.headIconPrayerSprites[var91.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					World.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						ReflectionCheck.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var75 || !var0.field944 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				World.getActorScreenLocation(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = class173.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = class173.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
					Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
					Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
					Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
					Client.overheadText[Client.overheadTextCount] = var0.overheadText;
					++Client.overheadTextCount;
				}
			}

			for (int var78 = 0; var78 < 4; ++var78) {
				int var92 = var0.hitSplatCycles[var78];
				int var79 = var0.hitSplatTypes[var78];
				HitSplatDefinition var93 = null;
				int var80 = 0;
				HitSplatDefinition var81;
				if (var79 >= 0) {
					if (var92 <= Client.cycle) {
						continue;
					}

					var16 = var0.hitSplatTypes[var78];
					var81 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var16);
					HitSplatDefinition var82;
					if (var81 != null) {
						var82 = var81;
					} else {
						byte[] var83 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var16);
						var81 = new HitSplatDefinition();
						if (var83 != null) {
							var81.decode(new Buffer(var83));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var81, (long)var16);
						var82 = var81;
					}

					var93 = var82;
					var80 = var82.field3318;
					if (var82 != null && var82.transforms != null) {
						var93 = var82.transform();
						if (var93 == null) {
							var0.hitSplatCycles[var78] = -1;
							continue;
						}
					}
				} else if (var92 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var78];
				HitSplatDefinition var84 = null;
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

					var84 = var81;
					if (var81 != null && var81.transforms != null) {
						var84 = var81.transform();
					}
				}

				if (var92 - var80 <= Client.cycle) {
					if (var93 == null) {
						var0.hitSplatCycles[var78] = -1;
					} else {
						World.getActorScreenLocation(var0, var0.defaultHeight / 2);
						if (Client.viewportTempX > -1) {
							if (var78 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var78 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var78 == 3) {
								Client.viewportTempX += 15;
								Client.viewportTempY -= 10;
							}

							var96 = null;
							Sprite var98 = null;
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
							Sprite var97 = var93.method4520();
							int var43;
							if (var97 != null) {
								var22 = var97.subWidth;
								var43 = var97.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var97.xOffset;
							}

							var98 = var93.method4517();
							if (var98 != null) {
								var23 = var98.subWidth;
								var43 = var98.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var98.xOffset;
							}

							var86 = var93.method4518();
							if (var86 != null) {
								var24 = var86.subWidth;
								var43 = var86.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var86.xOffset;
							}

							var87 = var93.method4542();
							if (var87 != null) {
								var25 = var87.subWidth;
								var43 = var87.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var87.xOffset;
							}

							if (var84 != null) {
								var30 = var84.method4520();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.xOffset;
								}

								var31 = var84.method4517();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.xOffset;
								}

								var32 = var84.method4518();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.xOffset;
								}

								var33 = var84.method4542();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.xOffset;
								}
							}

							Font var88 = var93.getFont();
							if (var88 == null) {
								var88 = GrandExchangeOfferOwnWorldComparator.fontPlain11;
							}

							Font var44;
							if (var84 != null) {
								var44 = var84.getFont();
								if (var44 == null) {
									var44 = GrandExchangeOfferOwnWorldComparator.fontPlain11;
								}
							} else {
								var44 = GrandExchangeOfferOwnWorldComparator.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var93.getString(var0.hitSplatValues[var78]);
							int var95 = var88.stringWidth(var45);
							if (var84 != null) {
								var46 = var84.getString(var0.hitSplatValues2[var78]);
								var48 = var44.stringWidth(var46);
							}

							int var49 = 0;
							int var50 = 0;
							if (var23 > 0) {
								if (var86 == null && var87 == null) {
									var49 = 1;
								} else {
									var49 = var95 / var23 + 1;
								}
							}

							if (var84 != null && var35 > 0) {
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
								var55 += (var56 - var95) / 2;
							} else {
								var51 += var95;
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
							if (var84 != null) {
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

							var62 = var0.hitSplatCycles[var78] - Client.cycle;
							int var63 = var93.field3323 - var62 * var93.field3323 / var93.field3318;
							int var64 = var62 * var93.field3311 / var93.field3318 + -var93.field3311;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var64 + (var3 + Client.viewportTempY - 12);
							int var67 = var66;
							int var68 = var66 + var42;
							int var69 = var66 + var93.field3334 + 15;
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
							if (var84 != null) {
								var72 = var66 + var84.field3334 + 15;
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
							if (var93.field3325 >= 0) {
								var73 = (var62 << 8) / (var93.field3318 - var93.field3325);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var97 != null) {
									var97.drawTransAt(var65 + var52 - var26, var66, var73);
								}

								if (var86 != null) {
									var86.drawTransAt(var53 + var65 - var28, var66, var73);
								}

								if (var98 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var98.drawTransAt(var23 * var74 + (var54 + var65 - var27), var66, var73);
									}
								}

								if (var87 != null) {
									var87.drawTransAt(var56 + var65 - var29, var66, var73);
								}

								var88.drawAlpha(var45, var55 + var65, var69, var93.textColor, 0, var73);
								if (var84 != null) {
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
										var33.drawTransAt(var60 + var65 - var41, var66, var73);
									}

									var44.drawAlpha(var46, var65 + var61, var72, var84.textColor, 0, var73);
								}
							} else {
								if (var97 != null) {
									var97.drawTransBgAt(var65 + var52 - var26, var66);
								}

								if (var86 != null) {
									var86.drawTransBgAt(var65 + var53 - var28, var66);
								}

								if (var98 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var98.drawTransBgAt(var74 * var23 + (var54 + var65 - var27), var66);
									}
								}

								if (var87 != null) {
									var87.drawTransBgAt(var56 + var65 - var29, var66);
								}

								var88.draw(var45, var55 + var65, var69, var93.textColor | -16777216, 0);
								if (var84 != null) {
									if (var30 != null) {
										var30.drawTransBgAt(var65 + var57 - var38, var66);
									}

									if (var32 != null) {
										var32.drawTransBgAt(var65 + var58 - var40, var66);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransBgAt(var74 * var35 + (var59 + var65 - var39), var66);
										}
									}

									if (var33 != null) {
										var33.drawTransBgAt(var60 + var65 - var41, var66);
									}

									var44.draw(var46, var61 + var65, var72, var84.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}
}
