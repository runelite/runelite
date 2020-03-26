import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("aa")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("ag")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1637377849
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1999475083
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1574888169
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1761506511
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2112462573
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 731154353
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-240937232"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.regionEndX * 64 - this.regionStartX * 64), var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.regionEndY * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1986942295"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "-1"
	)
	public static int method663(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "-116"
	)
	static int method683(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapRectangle.method388(ScriptEvent.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(Lcw;IIIIII)V",
		garbageValue = "-1464461419"
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
					boolean var77;
					if (var10 != ByteArrayPool.localPlayer) {
						var77 = (Client.drawPlayerNames & 4) != 0;
						boolean var78 = var77 || WorldMapRectangle.method386() && var10.isFriend();
						if (!var78) {
							boolean var13 = (Client.drawPlayerNames & 2) != 0;
							var78 = var13 && var10.isClanMember();
						}

						var9 = var78;
					} else {
						var77 = (Client.drawPlayerNames & 8) != 0;
						var9 = var77;
					}
				}

				if (var9) {
					Player var11 = (Player)var0;
					if (var1 < var75) {
						KeyHandler.method939(var0, var0.defaultHeight + 15);
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
			if (!var0.healthBars.method4891()) {
				KeyHandler.method939(var0, var0.defaultHeight + 15);

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
							var21 = var91.field3272 == 0 ? 0 : var91.field3272 * (var19 / var91.field3272);
							var22 = var15 * var89.health / var91.width;
							var93 = var21 * (var20 - var22) / var89.cycleOffset + var22;
						} else {
							var93 = var20;
							var21 = var91.int5 + var89.cycleOffset - var19;
							if (var91.int3 >= 0) {
								var17 = (var21 << 8) / (var91.int5 - var91.int3);
							}
						}

						if (var89.health2 > 0 && var93 < 1) {
							var93 = 1;
						}

						if (var76 != null && var14 != null) {
							if (var15 == var93) {
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
								var76.drawTransAt(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var93, var23 + var21);
								var14.drawTransAt(var22, var23, var17);
							} else {
								var76.drawTransBgAt(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var93, var23 + var21);
								var14.drawTransBgAt(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var87 += 2;
						} else {
							var87 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var87;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var93, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var93 + var21, var22, var15 - var93, 5, 16711680);
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
					KeyHandler.method939(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var10.headIconPk != -1) {
							var87 += 25;
							class52.headIconPkSprites[var10.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}

						if (var10.headIconPrayer != -1) {
							var87 += 25;
							ReflectionCheck.headIconPrayerSprites[var10.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					KeyHandler.method939(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						var87 += class4.headIconHintSprites[1].subHeight;
						class4.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
					}
				}
			} else {
				NPCDefinition var90 = ((NPC)var0).definition;
				if (var90.transforms != null) {
					var90 = var90.transform();
				}

				if (var90.headIconPrayer >= 0 && var90.headIconPrayer < ReflectionCheck.headIconPrayerSprites.length) {
					KeyHandler.method939(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						ReflectionCheck.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					KeyHandler.method939(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						class4.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var75 || !var0.field988 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				KeyHandler.method939(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = TaskHandler.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = TaskHandler.fontBold12.ascent;
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
				int var96 = var0.hitSplatCycles[var79];
				int var97 = var0.hitSplatTypes[var79];
				HitSplatDefinition var95 = null;
				int var80 = 0;
				if (var97 >= 0) {
					if (var96 <= Client.cycle) {
						continue;
					}

					var95 = GrandExchangeOfferUnitPriceComparator.method213(var0.hitSplatTypes[var79]);
					var80 = var95.field3329;
					if (var95 != null && var95.transforms != null) {
						var95 = var95.transform();
						if (var95 == null) {
							var0.hitSplatCycles[var79] = -1;
							continue;
						}
					}
				} else if (var96 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var79];
				HitSplatDefinition var81 = null;
				if (var15 >= 0) {
					var81 = GrandExchangeOfferUnitPriceComparator.method213(var15);
					if (var81 != null && var81.transforms != null) {
						var81 = var81.transform();
					}
				}

				if (var96 - var80 <= Client.cycle) {
					if (var95 == null) {
						var0.hitSplatCycles[var79] = -1;
					} else {
						KeyHandler.method939(var0, var0.defaultHeight / 2);
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
							var82 = var95.method4642();
							int var43;
							if (var82 != null) {
								var22 = var82.subWidth;
								var43 = var82.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var82.xOffset;
							}

							var83 = var95.method4631();
							if (var83 != null) {
								var23 = var83.subWidth;
								var43 = var83.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var83.xOffset;
							}

							var84 = var95.method4632();
							if (var84 != null) {
								var24 = var84.subWidth;
								var43 = var84.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var84.xOffset;
							}

							var85 = var95.method4633();
							if (var85 != null) {
								var25 = var85.subWidth;
								var43 = var85.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var85.xOffset;
							}

							if (var81 != null) {
								var30 = var81.method4642();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.xOffset;
								}

								var31 = var81.method4631();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.xOffset;
								}

								var32 = var81.method4632();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.xOffset;
								}

								var33 = var81.method4633();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.xOffset;
								}
							}

							Font var86 = var95.getFont();
							if (var86 == null) {
								var86 = Script.fontPlain11;
							}

							Font var44;
							if (var81 != null) {
								var44 = var81.getFont();
								if (var44 == null) {
									var44 = Script.fontPlain11;
								}
							} else {
								var44 = Script.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var95.getString(var0.hitSplatValues[var79]);
							int var94 = var86.stringWidth(var45);
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
								var56 = var49 * var23;
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

							var62 = var0.hitSplatCycles[var79] - Client.cycle;
							int var63 = var95.field3338 - var62 * var95.field3338 / var95.field3329;
							int var64 = var62 * var95.field3341 / var95.field3329 + -var95.field3341;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var64 + (var3 + Client.viewportTempY - 12);
							int var67 = var66;
							int var68 = var66 + var42;
							int var69 = var66 + var95.field3339 + 15;
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
								var72 = var66 + var81.field3339 + 15;
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
							if (var95.field3334 >= 0) {
								var73 = (var62 << 8) / (var95.field3329 - var95.field3334);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var82 != null) {
									var82.drawTransAt(var52 + var65 - var26, var66, var73);
								}

								if (var84 != null) {
									var84.drawTransAt(var65 + var53 - var28, var66, var73);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.drawTransAt(var23 * var74 + (var65 + var54 - var27), var66, var73);
									}
								}

								if (var85 != null) {
									var85.drawTransAt(var65 + var56 - var29, var66, var73);
								}

								var86.drawAlpha(var45, var55 + var65, var69, var95.textColor, 0, var73);
								if (var81 != null) {
									if (var30 != null) {
										var30.drawTransAt(var65 + var57 - var38, var66, var73);
									}

									if (var32 != null) {
										var32.drawTransAt(var65 + var58 - var40, var66, var73);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransAt(var74 * var35 + (var65 + var59 - var39), var66, var73);
										}
									}

									if (var33 != null) {
										var33.drawTransAt(var60 + var65 - var41, var66, var73);
									}

									var44.drawAlpha(var46, var61 + var65, var72, var81.textColor, 0, var73);
								}
							} else {
								if (var82 != null) {
									var82.drawTransBgAt(var52 + var65 - var26, var66);
								}

								if (var84 != null) {
									var84.drawTransBgAt(var53 + var65 - var28, var66);
								}

								if (var83 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var83.drawTransBgAt(var74 * var23 + (var65 + var54 - var27), var66);
									}
								}

								if (var85 != null) {
									var85.drawTransBgAt(var56 + var65 - var29, var66);
								}

								var86.draw(var45, var55 + var65, var69, var95.textColor | -16777216, 0);
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

									var44.draw(var46, var61 + var65, var72, var81.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}
}
