import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 100138419
	)
	int field1057;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -520446837
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -902080545
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1320380601
	)
	@Export("y")
	int y;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1376822595
	)
	int field1052;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 925684059
	)
	int field1053;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -980426623
	)
	int field1054;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -752039095
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 708593769
	)
	int field1058;
	@ObfuscatedName("c")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	@Export("obj")
	ObjectDefinition obj;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1871367873
	)
	int field1056;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("stream2")
	RawPcmStream stream2;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-68"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1054 = var2.int4 * 128;
			this.field1057 = var2.int5;
			this.field1058 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1054 = 0;
			this.field1057 = 0;
			this.field1058 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			IgnoreList.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)J",
		garbageValue = "14"
	)
	static long method1836() {
		try {
			URL var0 = new URL(RouteStrategy.method3534("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while(var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(Lbu;IIIIIB)V",
		garbageValue = "7"
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
				if (Client.drawPlayerNames == 0) {
					var9 = false;
				} else {
					boolean var76;
					if (var10 == WorldMapIcon_1.localPlayer) {
						var76 = (Client.drawPlayerNames & 8) != 0;
						var9 = var76;
					} else {
						var76 = HitSplatDefinition.method4497() || GrandExchangeEvents.method81() && var10.isFriend();
						if (!var76) {
							boolean var77 = (Client.drawPlayerNames & 2) != 0;
							var76 = var77 && var10.isClanMember();
						}

						var9 = var76;
					}
				}

				if (var9) {
					Player var11 = (Player)var0;
					if (var1 < var75) {
						Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);
						AbstractFont var12 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
						byte var13 = 9;
						var12.drawCentered(var11.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var13, 16777215, 0);
						var8 = 18;
					}
				}
			}

			int var87 = -2;
			int var15;
			int var22;
			int var23;
			if (!var0.healthBars.method4729()) {
				Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);

				for (HealthBar var88 = (HealthBar)var0.healthBars.last(); var88 != null; var88 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var89 = var88.get(Client.cycle);
					if (var89 == null) {
						if (var88.isEmpty()) {
							var88.remove();
						}
					} else {
						HealthBarDefinition var91 = var88.definition;
						Sprite var78 = var91.getBackSprite();
						Sprite var14 = var91.getFrontSprite();
						int var16 = 0;
						if (var78 != null && var14 != null) {
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
						int var92;
						if (var89.cycleOffset > var19) {
							var21 = var91.int4 == 0 ? 0 : var91.int4 * (var19 / var91.int4);
							var22 = var15 * var89.health / var91.width;
							var92 = var21 * (var20 - var22) / var89.cycleOffset + var22;
						} else {
							var92 = var20;
							var21 = var89.cycleOffset + var91.int5 - var19;
							if (var91.int3 >= 0) {
								var17 = (var21 << 8) / (var91.int5 - var91.int3);
							}
						}

						if (var89.health2 > 0 && var92 < 1) {
							var92 = 1;
						}

						if (var78 != null && var14 != null) {
							if (var92 == var15) {
								var92 += var16 * 2;
							} else {
								var92 += var16;
							}

							var21 = var78.subHeight;
							var87 += var21;
							var22 = var2 + Client.viewportTempX - (var15 >> 1);
							var23 = var3 + Client.viewportTempY - var87;
							var22 -= var16;
							if (var17 >= 0 && var17 < 255) {
								var78.drawTransAt(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var92 + var22, var21 + var23);
								var14.drawTransAt(var22, var23, var17);
							} else {
								var78.drawTransBgAt(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var92 + var22, var23 + var21);
								var14.drawTransBgAt(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var87 += 2;
						} else {
							var87 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var87;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var92, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var92 + var21, var22, var15 - var92, 5, 16711680);
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
					Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var10.headIconPk != -1) {
							var87 += 25;
							UserComparator6.headIconPkSprites[var10.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}

						if (var10.headIconPrayer != -1) {
							var87 += 25;
							IntHashTable.headIconPrayerSprites[var10.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						var87 += WorldMapData_1.headIconHintSprites[1].subHeight;
						WorldMapData_1.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
					}
				}
			} else {
				NPCDefinition var90 = ((NPC)var0).definition;
				if (var90.transforms != null) {
					var90 = var90.transform();
				}

				if (var90.headIconPrayer >= 0 && var90.headIconPrayer < IntHashTable.headIconPrayerSprites.length) {
					Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						IntHashTable.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					Entity.getActorScreenLocation(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						WorldMapData_1.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var75 || !var0.field926 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				Entity.getActorScreenLocation(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = class43.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = class43.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
					Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
					Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
					Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
					Client.overheadText[Client.overheadTextCount] = var0.overheadText;
					++Client.overheadTextCount;
				}
			}

			for (int var79 = 0; var79 < 4; ++var79) {
				int var94 = var0.hitSplatCycles[var79];
				int var95 = var0.hitSplatTypes[var79];
				HitSplatDefinition var96 = null;
				int var80 = 0;
				if (var95 >= 0) {
					if (var94 <= Client.cycle) {
						continue;
					}

					var96 = StructDefinition.HitSplatDefinition_get(var0.hitSplatTypes[var79]);
					var80 = var96.field3314;
					if (var96 != null && var96.transforms != null) {
						var96 = var96.transform();
						if (var96 == null) {
							var0.hitSplatCycles[var79] = -1;
							continue;
						}
					}
				} else if (var94 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var79];
				HitSplatDefinition var81 = null;
				if (var15 >= 0) {
					var81 = StructDefinition.HitSplatDefinition_get(var15);
					if (var81 != null && var81.transforms != null) {
						var81 = var81.transform();
					}
				}

				if (var94 - var80 <= Client.cycle) {
					if (var96 == null) {
						var0.hitSplatCycles[var79] = -1;
					} else {
						Entity.getActorScreenLocation(var0, var0.defaultHeight / 2);
						if (Client.viewportTempX > -1) {
							if (var79 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var79 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var79 == 3) {
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
							var82 = var96.method4494();
							int var43;
							if (var82 != null) {
								var22 = var82.subWidth;
								var43 = var82.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var82.xOffset;
							}

							var83 = var96.method4468();
							if (var83 != null) {
								var23 = var83.subWidth;
								var43 = var83.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var83.xOffset;
							}

							var84 = var96.method4472();
							if (var84 != null) {
								var24 = var84.subWidth;
								var43 = var84.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var84.xOffset;
							}

							var85 = var96.method4470();
							if (var85 != null) {
								var25 = var85.subWidth;
								var43 = var85.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var85.xOffset;
							}

							if (var81 != null) {
								var30 = var81.method4494();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.xOffset;
								}

								var31 = var81.method4468();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.xOffset;
								}

								var32 = var81.method4472();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.xOffset;
								}

								var33 = var81.method4470();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.xOffset;
								}
							}

							Font var86 = var96.getFont();
							if (var86 == null) {
								var86 = class30.fontPlain11;
							}

							Font var44;
							if (var81 != null) {
								var44 = var81.getFont();
								if (var44 == null) {
									var44 = class30.fontPlain11;
								}
							} else {
								var44 = class30.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var96.getString(var0.hitSplatValues[var79]);
							int var93 = var86.stringWidth(var45);
							if (var81 != null) {
								var46 = var81.getString(var0.hitSplatValues2[var79]);
								var48 = var44.stringWidth(var46);
							}

							int var49 = 0;
							int var50 = 0;
							if (var23 > 0) {
								if (var84 == null && var85 == null) {
									var49 = 1;
								} else {
									var49 = var93 / var23 + 1;
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

							var62 = var0.hitSplatCycles[var79] - Client.cycle;
							int var63 = var96.field3319 - var62 * var96.field3319 / var96.field3314;
							int var64 = var62 * var96.field3307 / var96.field3314 + -var96.field3307;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var64 + (var3 + Client.viewportTempY - 12);
							int var67 = var66;
							int var68 = var66 + var42;
							int var69 = var66 + var96.field3324 + 15;
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
								var72 = var66 + var81.field3324 + 15;
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
							if (var96.field3318 >= 0) {
								var73 = (var62 << 8) / (var96.field3314 - var96.field3318);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var82 != null) {
									var82.drawTransAt(var65 + var52 - var26, var66, var73);
								}

								if (var84 != null) {
									var84.drawTransAt(var65 + var53 - var28, var66, var73);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.drawTransAt(var74 * var23 + (var65 + var54 - var27), var66, var73);
									}
								}

								if (var85 != null) {
									var85.drawTransAt(var65 + var56 - var29, var66, var73);
								}

								var86.drawAlpha(var45, var55 + var65, var69, var96.textColor, 0, var73);
								if (var81 != null) {
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

									var44.drawAlpha(var46, var61 + var65, var72, var81.textColor, 0, var73);
								}
							} else {
								if (var82 != null) {
									var82.drawTransBgAt(var65 + var52 - var26, var66);
								}

								if (var84 != null) {
									var84.drawTransBgAt(var65 + var53 - var28, var66);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.drawTransBgAt(var74 * var23 + (var54 + var65 - var27), var66);
									}
								}

								if (var85 != null) {
									var85.drawTransBgAt(var65 + var56 - var29, var66);
								}

								var86.draw(var45, var65 + var55, var69, var96.textColor | -16777216, 0);
								if (var81 != null) {
									if (var30 != null) {
										var30.drawTransBgAt(var65 + var57 - var38, var66);
									}

									if (var32 != null) {
										var32.drawTransBgAt(var65 + var58 - var40, var66);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransBgAt(var35 * var74 + (var65 + var59 - var39), var66);
										}
									}

									if (var33 != null) {
										var33.drawTransBgAt(var60 + var65 - var41, var66);
									}

									var44.draw(var46, var65 + var61, var72, var81.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-103"
	)
	static final void method1837(int var0) {
		WorldMapIcon_0.method207();
		class49.method810();
		int var1 = class16.method180(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				class42.method753();
			}

			if (var1 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.field856) {
					if (Client.field856 == 0 && Client.field857 != -1) {
						PacketBufferNode.method3574(GrandExchangeEvent.archive6, Client.field857, 0, var3, false);
						Client.field858 = false;
					} else if (var3 == 0) {
						class197.midiPcmStream.clear();
						class197.field2378 = 1;
						WorldMapDecoration.musicTrackArchive = null;
						Client.field858 = false;
					} else {
						ChatChannel.method2163(var3);
					}

					Client.field856 = var3;
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
				Client.field788 = var2;
			}

			if (var1 == 10) {
				if (var2 == 0) {
					Client.field860 = 127;
				}

				if (var2 == 1) {
					Client.field860 = 96;
				}

				if (var2 == 2) {
					Client.field860 = 64;
				}

				if (var2 == 3) {
					Client.field860 = 32;
				}

				if (var2 == 4) {
					Client.field860 = 0;
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			AttackOption[] var4;
			if (var1 == 18) {
				var4 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable};
				Client.playerAttackOption = (AttackOption)FriendSystem.findEnumerated(var4, var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				var4 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable};
				Client.npcAttackOption = (AttackOption)FriendSystem.findEnumerated(var4, var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
