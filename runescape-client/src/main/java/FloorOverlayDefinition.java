import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("FloorOverlayDefinition_cached")
	static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 935951655
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1095526673
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("i")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1729092423
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -29355705
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1250783645
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1922537883
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 291644117
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1538627711
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1197825263
	)
	@Export("secondaryLightness")
	public int secondaryLightness;

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "342799854"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.secondaryRgb != -1) {
			this.setHsl(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.setHsl(this.primaryRgb);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;IB)V",
		garbageValue = "-45"
	)
	@Export("decode")
	void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IIB)V",
		garbageValue = "16"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.primaryRgb = var1.readMedium();
		} else if (var2 == 2) {
			this.texture = var1.readUnsignedByte();
		} else if (var2 == 5) {
			this.hideUnderlay = false;
		} else if (var2 == 7) {
			this.secondaryRgb = var1.readMedium();
		} else if (var2 == 8) {
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1731410531"
	)
	@Export("setHsl")
	void setHsl(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var10 == var4) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var6 == var10) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(var12 * 256.0D);
		this.saturation = (int)(256.0D * var14);
		this.lightness = (int)(var16 * 256.0D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "([Lhn;IIIIIIIIB)V",
		garbageValue = "40"
	)
	@Export("drawInterface")
	static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();

		for (int var9 = 0; var9 < var0.length; ++var9) {
			Widget var10 = var0[var9];
			if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
				int var11;
				if (var8 == -1) {
					Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
					Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
					Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
					Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
					var11 = ++Client.rootWidgetCount - 1;
				} else {
					var11 = var8;
				}

				var10.rootIndex = var11;
				var10.cycle = Client.cycle;
				if (!var10.isIf3 || !VarcInt.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						GrandExchangeEvent.method93(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							Entity.field1866 = var0;
							WorldMapIcon_0.field142 = var6;
							UserComparator9.field1965 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field824) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field919) {
								var15 = Client.field919;
							}

							if (var15 + var10.width > Client.field919 + Client.clickedWidgetParent.width) {
								var15 = Client.field919 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field826) {
								var16 = Client.field826;
							}

							if (var16 + var10.height > Client.field826 + Client.clickedWidgetParent.height) {
								var16 = Client.field826 + Client.clickedWidgetParent.height - var10.height;
							}

							var12 = var15;
							var13 = var16;
						}

						if (!var10.isScrollBar) {
							var14 = 128;
						}
					}

					int var17;
					int var18;
					int var20;
					int var21;
					int var22;
					int var30;
					if (var10.type == 2) {
						var15 = var2;
						var16 = var3;
						var17 = var4;
						var18 = var5;
					} else if (var10.type == 9) {
						var30 = var12;
						var20 = var13;
						var21 = var12 + var10.width;
						var22 = var13 + var10.height;
						if (var21 < var12) {
							var30 = var21;
							var21 = var12;
						}

						if (var22 < var13) {
							var20 = var22;
							var22 = var13;
						}

						++var21;
						++var22;
						var15 = var30 > var2 ? var30 : var2;
						var16 = var20 > var3 ? var20 : var3;
						var17 = var21 < var4 ? var21 : var4;
						var18 = var22 < var5 ? var22 : var5;
					} else {
						var30 = var12 + var10.width;
						var20 = var13 + var10.height;
						var15 = var12 > var2 ? var12 : var2;
						var16 = var13 > var3 ? var13 : var3;
						var17 = var30 < var4 ? var30 : var4;
						var18 = var20 < var5 ? var20 : var5;
					}

					if (!var10.isIf3 || var15 < var17 && var16 < var18) {
						if (var10.contentType != 0) {
							if (var10.contentType == 1336) {
								if (Client.displayFps) {
									var13 += 15;
									class13.fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var38 = Runtime.getRuntime();
									var20 = (int)((var38.totalMemory() - var38.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									class13.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								WorldMapSection1.drawEntities(var12, var13, var10.width, var10.height);
								Client.field851[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								WorldMapRegion.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								UserComparator8.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								WorldMapIcon_0.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								WorldMapIcon_0.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								WorldMapLabelSize.loginScreenRunesAnimation.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && VarcInt.isComponentHidden(var10) && var10 != GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1) {
								continue;
							}

							if (!var10.isIf3) {
								if (var10.scrollY > var10.scrollHeight - var10.height) {
									var10.scrollY = var10.scrollHeight - var10.height;
								}

								if (var10.scrollY < 0) {
									var10.scrollY = 0;
								}
							}

							drawInterface(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							if (var10.children != null) {
								drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							}

							InterfaceParent var19 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
							if (var19 != null) {
								ServerPacket.drawWidgets(var19.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
						}

						if (Client.isResizable || Client.field853[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								WorldMapRectangle.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
							}

							if (var10.type != 1) {
								int var23;
								int var24;
								int var25;
								int var26;
								if (var10.type == 2) {
									var30 = 0;

									for (var20 = 0; var20 < var10.rawHeight; ++var20) {
										for (var21 = 0; var21 < var10.rawWidth; ++var21) {
											var22 = var21 * (var10.paddingX + 32) + var12;
											var23 = var20 * (var10.paddingY + 32) + var13;
											if (var30 < 20) {
												var22 += var10.inventoryXOffsets[var30];
												var23 += var10.inventoryYOffsets[var30];
											}

											if (var10.itemIds[var30] <= 0) {
												if (var10.inventorySprites != null && var30 < 20) {
													Sprite var46 = var10.getInventorySprite(var30);
													if (var46 != null) {
														var46.drawTransBgAt(var22, var23);
													} else if (Widget.field2697) {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											} else {
												boolean var39 = false;
												boolean var40 = false;
												var26 = var10.itemIds[var30] - 1;
												if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class185.dragInventoryWidget && var30 == Client.dragItemSlotSource) {
													Sprite var35;
													if (Client.isItemSelected == 1 && var30 == class65.selectedItemSlot && var10.id == FriendSystem.selectedItemWidget) {
														var35 = AttackOption.getItemSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
													} else {
														var35 = AttackOption.getItemSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
													}

													if (var35 != null) {
														if (var10 == class185.dragInventoryWidget && var30 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.draggedWidgetX;
															var25 = MouseHandler.MouseHandler_y - Client.draggedWidgetY;
															if (var24 < 5 && var24 > -5) {
																var24 = 0;
															}

															if (var25 < 5 && var25 > -5) {
																var25 = 0;
															}

															if (Client.itemDragDuration < 5) {
																var24 = 0;
																var25 = 0;
															}

															var35.drawTransAt(var22 + var24, var25 + var23, 128);
															if (var1 != -1) {
																Widget var28 = var0[var1 & 65535];
																int var29;
																if (var25 + var23 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
																	var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field707 / 3;
																	if (var29 > Client.field707 * 10) {
																		var29 = Client.field707 * 10;
																	}

																	if (var29 > var28.scrollY) {
																		var29 = var28.scrollY;
																	}

																	var28.scrollY -= var29;
																	Client.draggedWidgetY += var29;
																	NPCDefinition.invalidateWidget(var28);
																}

																if (var25 + var23 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
																	var29 = (var23 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field707 / 3;
																	if (var29 > Client.field707 * 10) {
																		var29 = Client.field707 * 10;
																	}

																	if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
																		var29 = var28.scrollHeight - var28.height - var28.scrollY;
																	}

																	var28.scrollY += var29;
																	Client.draggedWidgetY -= var29;
																	NPCDefinition.invalidateWidget(var28);
																}
															}
														} else if (var10 == Skeleton.field1793 && var30 == Client.field752) {
															var35.drawTransAt(var22, var23, 128);
														} else {
															var35.drawTransBgAt(var22, var23);
														}
													} else {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											}

											++var30;
										}
									}
								} else if (var10.type == 3) {
									if (ScriptFrame.runCs1(var10)) {
										var30 = var10.color2;
										if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var30 = var10.mouseOverColor2;
										}
									} else {
										var30 = var10.color;
										if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
											var30 = var10.mouseOverColor;
										}
									}

									if (var10.fill) {
										switch(var10.fillMode.value) {
										case 1:
											Rasterizer2D.Rasterizer2D_fillRectangleGradient(var12, var13, var10.width, var10.height, var10.color, var10.color2);
											break;
										case 2:
											Rasterizer2D.Rasterizer2D_fillRectangleGradientAlpha(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparencyTop & 255), 255 - (var10.transparencyBot & 255));
											break;
										default:
											if (var14 == 0) {
												Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var30);
											} else {
												Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
											}
										}
									} else if (var14 == 0) {
										Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var30);
									} else {
										Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
									}
								} else {
									Font var36;
									if (var10.type == 4) {
										var36 = var10.getFont();
										if (var36 == null) {
											if (Widget.field2697) {
												NPCDefinition.invalidateWidget(var10);
											}
										} else {
											String var43 = var10.text;
											if (ScriptFrame.runCs1(var10)) {
												var20 = var10.color2;
												if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var20 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var43 = var10.text2;
												}
											} else {
												var20 = var10.color;
												if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var20 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var47 = HealthBarDefinition.ItemDefinition_get(var10.itemId);
												var43 = var47.name;
												if (var43 == null) {
													var43 = "null";
												}

												if ((var47.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var43 = PacketWriter.colorStartTag(16748608) + var43 + "</col>" + " " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var43 = "Please wait...";
												var20 = var10.color;
											}

											if (!var10.isIf3) {
												var43 = MouseHandler.method1096(var43, var10);
											}

											var36.drawLines(var43, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var37;
										if (!var10.isIf3) {
											var37 = var10.getSprite(ScriptFrame.runCs1(var10));
											if (var37 != null) {
												var37.drawTransBgAt(var12, var13);
											} else if (Widget.field2697) {
												NPCDefinition.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var37 = AttackOption.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var37 = var10.getSprite(false);
											}

											if (var37 == null) {
												if (Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											} else {
												var20 = var37.width;
												var21 = var37.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var37.method6210(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
													} else if (var14 != 0) {
														var37.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
													} else if (var20 == var10.width && var21 == var10.height) {
														var37.drawTransBgAt(var12, var13);
													} else {
														var37.drawScaledAt(var12, var13, var10.width, var10.height);
													}
												} else {
													Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
													var22 = (var20 - 1 + var10.width) / var20;
													var23 = (var21 - 1 + var10.height) / var21;

													for (var24 = 0; var24 < var22; ++var24) {
														for (var25 = 0; var25 < var23; ++var25) {
															if (var10.spriteAngle != 0) {
																var37.method6210(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var37.drawTransAt(var12 + var24 * var20, var13 + var21 * var25, 256 - (var14 & 255));
															} else {
																var37.drawTransBgAt(var12 + var24 * var20, var13 + var25 * var21);
															}
														}
													}

													Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
												}
											}
										}
									} else {
										ItemDefinition var32;
										if (var10.type == 6) {
											boolean var44 = ScriptFrame.runCs1(var10);
											if (var44) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var41 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												var32 = HealthBarDefinition.ItemDefinition_get(var10.itemId);
												if (var32 != null) {
													var32 = var32.getCountObj(var10.itemQuantity);
													var41 = var32.getModel(1);
													if (var41 != null) {
														var41.calculateBoundsCylinder();
														var22 = var41.height / 2;
													} else {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var41 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var41 = class192.localPlayer.getModel();
												}
											} else if (var20 == -1) {
												var41 = var10.getModel((SequenceDefinition)null, -1, var44, class192.localPlayer.appearance);
												if (var41 == null && Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											} else {
												SequenceDefinition var45 = GraphicsDefaults.SequenceDefinition_get(var20);
												var41 = var10.getModel(var45, var10.modelFrame, var44, class192.localPlayer.appearance);
												if (var41 == null && Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method3101(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var41 != null) {
												if (!var10.isIf3) {
													var41.method2946(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var41.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var41.method2938(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var41.method2946(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.Rasterizer3D_method3();
										} else {
											if (var10.type == 7) {
												var36 = var10.getFont();
												if (var36 == null) {
													if (Widget.field2697) {
														NPCDefinition.invalidateWidget(var10);
													}
													continue;
												}

												var20 = 0;

												for (var21 = 0; var21 < var10.rawHeight; ++var21) {
													for (var22 = 0; var22 < var10.rawWidth; ++var22) {
														if (var10.itemIds[var20] > 0) {
															var32 = HealthBarDefinition.ItemDefinition_get(var10.itemIds[var20] - 1);
															String var34;
															if (var32.isStackable != 1 && var10.itemQuantities[var20] == 1) {
																var34 = PacketWriter.colorStartTag(16748608) + var32.name + "</col>";
															} else {
																var34 = PacketWriter.colorStartTag(16748608) + var32.name + "</col>" + " " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantities[var20]);
															}

															var25 = var12 + var22 * (var10.paddingX + 115);
															var26 = (var10.paddingY + 12) * var21 + var13;
															if (var10.textXAlignment == 0) {
																var36.draw(var34, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var36.drawCentered(var34, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var36.drawRightAligned(var34, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var20;
													}
												}
											}

											if (var10.type == 8 && var10 == VarbitDefinition.field3296 && Client.field796 == Client.field797) {
												var30 = 0;
												var20 = 0;
												Font var31 = class13.fontPlain12;
												String var33 = var10.text;

												String var42;
												for (var33 = MouseHandler.method1096(var33, var10); var33.length() > 0; var20 = var20 + var31.ascent + 1) {
													var24 = var33.indexOf("<br>");
													if (var24 != -1) {
														var42 = var33.substring(0, var24);
														var33 = var33.substring(var24 + 4);
													} else {
														var42 = var33;
														var33 = "";
													}

													var25 = var31.stringWidth(var42);
													if (var25 > var30) {
														var30 = var25;
													}
												}

												var30 += 6;
												var20 += 7;
												var24 = var12 + var10.width - 5 - var30;
												var25 = var13 + var10.height + 5;
												if (var24 < var12 + 5) {
													var24 = var12 + 5;
												}

												if (var24 + var30 > var4) {
													var24 = var4 - var30;
												}

												if (var20 + var25 > var5) {
													var25 = var5 - var20;
												}

												Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var30, var20, 16777120);
												Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var30, var20, 0);
												var33 = var10.text;
												var26 = var25 + var31.ascent + 2;

												for (var33 = MouseHandler.method1096(var33, var10); var33.length() > 0; var26 = var26 + var31.ascent + 1) {
													int var27 = var33.indexOf("<br>");
													if (var27 != -1) {
														var42 = var33.substring(0, var27);
														var33 = var33.substring(var27 + 4);
													} else {
														var42 = var33;
														var33 = "";
													}

													var31.draw(var42, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2606) {
													var30 = var12;
													var20 = var13 + var10.height;
													var21 = var12 + var10.width;
													var22 = var13;
												} else {
													var30 = var12;
													var20 = var13;
													var21 = var12 + var10.width;
													var22 = var13 + var10.height;
												}

												if (var10.lineWid == 1) {
													Rasterizer2D.Rasterizer2D_drawLine(var30, var20, var21, var22, var10.color);
												} else {
													GrandExchangeOfferWorldComparator.method74(var30, var20, var21, var22, var10.color, var10.lineWid);
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
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-825352084"
	)
	public static boolean method4835() {
		return Client.staffModLevel >= 2;
	}
}
