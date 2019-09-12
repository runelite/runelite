import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("gl")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = 221806607
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lcq;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgt;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lgs;[IIIII)V",
		garbageValue = "-1588228900"
	)
	void method3884(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2395[var1.field2431] & 4) != 0 && var1.field2425 < 0) {
			int var6 = this.superStream.field2400[var1.field2431] / GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2422) / var6;
				if (var7 > var4) {
					var1.field2422 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2422 += var6 * var7 - 1048576;
				int var8 = GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2398[var1.field2431] == 0) {
					var1.stream = RawPcmStream.method2511(var1.rawSound, var10.method2604(), var10.method2517(), var10.method2518());
				} else {
					var1.stream = RawPcmStream.method2511(var1.rawSound, var10.method2604(), 0, var10.method2518());
					this.superStream.method3698(var1, var1.patch.field2450[var1.field2413] < 0);
					var1.stream.method2522(var8, var10.method2517());
				}

				if (var1.patch.field2450[var1.field2413] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2541(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2606()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lgs;IS)V",
		garbageValue = "-4402"
	)
	void method3885(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2395[var1.field2431] & 4) != 0 && var1.field2425 < 0) {
			int var3 = this.superStream.field2400[var1.field2431] / GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate;
			int var4 = (var3 + 1048575 - var1.field2422) / var3;
			var1.field2422 = var3 * var2 + var1.field2422 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2398[var1.field2431] == 0) {
					var1.stream = RawPcmStream.method2511(var1.rawSound, var1.stream.method2604(), var1.stream.method2517(), var1.stream.method2518());
				} else {
					var1.stream = RawPcmStream.method2511(var1.rawSound, var1.stream.method2604(), 0, var1.stream.method2518());
					this.superStream.method3698(var1, var1.patch.field2450[var1.field2413] < 0);
				}

				if (var1.patch.field2450[var1.field2413] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2422 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
		if (var1 == null) {
			return null;
		} else {
			return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		MusicPatchNode var1;
		do {
			var1 = (MusicPatchNode)this.queue.previous();
			if (var1 == null) {
				return null;
			}
		} while(var1.stream == null);

		return var1.stream;
	}

	@ObfuscatedName("v")
	protected int vmethod3881() {
		return 0;
	}

	@ObfuscatedName("d")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3720(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2430) {
						this.method3884(var6, var1, var4, var5, var5 + var4);
						var6.field2430 -= var5;
						break;
					}

					this.method3884(var6, var1, var4, var6.field2430, var4 + var5);
					var4 += var6.field2430;
					var5 -= var6.field2430;
				} while(!this.superStream.method3721(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("s")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3720(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2430) {
						this.method3885(var3, var2);
						var3.field2430 -= var2;
						break;
					}

					this.method3885(var3, var3.field2430);
					var2 -= var3.field2430;
				} while(!this.superStream.method3721(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "([Lhy;IIIIIIIII)V",
		garbageValue = "-1121461534"
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
				if (!var10.isIf3 || !NetCache.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						class14.method143(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							SoundCache.field1410 = var0;
							WorldMapSection0.field138 = var6;
							GrandExchangeOfferNameComparator.field79 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field800) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field801) {
								var15 = Client.field801;
							}

							if (var15 + var10.width > Client.field801 + Client.clickedWidgetParent.width) {
								var15 = Client.field801 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field706) {
								var16 = Client.field706;
							}

							if (var16 + var10.height > Client.field706 + Client.clickedWidgetParent.height) {
								var16 = Client.field706 + Client.clickedWidgetParent.height - var10.height;
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
					int var19;
					int var20;
					int var21;
					int var22;
					if (var10.type == 2) {
						var15 = var2;
						var16 = var3;
						var17 = var4;
						var18 = var5;
					} else if (var10.type == 9) {
						var19 = var12;
						var20 = var13;
						var21 = var12 + var10.width;
						var22 = var13 + var10.height;
						if (var21 < var12) {
							var19 = var21;
							var21 = var12;
						}

						if (var22 < var13) {
							var20 = var22;
							var22 = var13;
						}

						++var21;
						++var22;
						var15 = var19 > var2 ? var19 : var2;
						var16 = var20 > var3 ? var20 : var3;
						var17 = var21 < var4 ? var21 : var4;
						var18 = var22 < var5 ? var22 : var5;
					} else {
						var19 = var12 + var10.width;
						var20 = var13 + var10.height;
						var15 = var12 > var2 ? var12 : var2;
						var16 = var13 > var3 ? var13 : var3;
						var17 = var19 < var4 ? var19 : var4;
						var18 = var20 < var5 ? var20 : var5;
					}

					if (!var10.isIf3 || var15 < var17 && var16 < var18) {
						if (var10.contentType != 0) {
							if (var10.contentType == 1336) {
								if (Client.displayFps) {
									var13 += 15;
									class197.fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var42 = Runtime.getRuntime();
									var20 = (int)((var42.totalMemory() - var42.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									class197.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								ScriptEvent.drawEntities(var12, var13, var10.width, var10.height);
								Client.field827[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								class65.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								ScriptEvent.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								GrandExchangeOfferUnitPriceComparator.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								GrandExchangeOfferUnitPriceComparator.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								UserComparator5.loginScreenRunesAnimation.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && NetCache.isComponentHidden(var10) && var10 != class32.mousedOverWidgetIf1) {
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

							InterfaceParent var30 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
							if (var30 != null) {
								AbstractWorldMapIcon.drawWidgets(var30.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
						}

						if (Client.isResizable || Client.field647[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								ServerPacket.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
							}

							if (var10.type != 1) {
								int var23;
								int var24;
								int var25;
								int var26;
								if (var10.type == 2) {
									var19 = 0;

									for (var20 = 0; var20 < var10.rawHeight; ++var20) {
										for (var21 = 0; var21 < var10.rawWidth; ++var21) {
											var22 = var12 + var21 * (var10.paddingX + 32);
											var23 = var13 + var20 * (var10.paddingY + 32);
											if (var19 < 20) {
												var22 += var10.inventoryXOffsets[var19];
												var23 += var10.inventoryYOffsets[var19];
											}

											if (var10.itemIds[var19] <= 0) {
												if (var10.inventorySprites != null && var19 < 20) {
													Sprite var45 = var10.getInventorySprite(var19);
													if (var45 != null) {
														var45.drawTransBgAt(var22, var23);
													} else if (Widget.field2668) {
														WorldMapID.invalidateWidget(var10);
													}
												}
											} else {
												boolean var37 = false;
												boolean var38 = false;
												var26 = var10.itemIds[var19] - 1;
												if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class4.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
													Sprite var27;
													if (Client.isItemSelected == 1 && var19 == ModelData0.selectedItemSlot && var10.id == selectedItemWidget) {
														var27 = Player.getItemSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
													} else {
														var27 = Player.getItemSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
													}

													if (var27 != null) {
														if (var10 == class4.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.field730;
															var25 = MouseHandler.MouseHandler_y - Client.field870;
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

															var27.drawTransAt(var22 + var24, var25 + var23, 128);
															if (var1 != -1) {
																Widget var28 = var0[var1 & 65535];
																int var29;
																if (var23 + var25 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
																	var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field683 / 3;
																	if (var29 > Client.field683 * 10) {
																		var29 = Client.field683 * 10;
																	}

																	if (var29 > var28.scrollY) {
																		var29 = var28.scrollY;
																	}

																	var28.scrollY -= var29;
																	Client.field870 += var29;
																	WorldMapID.invalidateWidget(var28);
																}

																if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
																	var29 = (var25 + var23 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field683 / 3;
																	if (var29 > Client.field683 * 10) {
																		var29 = Client.field683 * 10;
																	}

																	if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
																		var29 = var28.scrollHeight - var28.height - var28.scrollY;
																	}

																	var28.scrollY += var29;
																	Client.field870 -= var29;
																	WorldMapID.invalidateWidget(var28);
																}
															}
														} else if (var10 == Entity.field1835 && var19 == Client.field728) {
															var27.drawTransAt(var22, var23, 128);
														} else {
															var27.drawTransBgAt(var22, var23);
														}
													} else {
														WorldMapID.invalidateWidget(var10);
													}
												}
											}

											++var19;
										}
									}
								} else if (var10.type == 3) {
									if (Tile.runCs1(var10)) {
										var19 = var10.color2;
										if (var10 == class32.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var19 = var10.mouseOverColor2;
										}
									} else {
										var19 = var10.color;
										if (var10 == class32.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
											var19 = var10.mouseOverColor;
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
												Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var19);
											} else {
												Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
											}
										}
									} else if (var14 == 0) {
										Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var19);
									} else {
										Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
									}
								} else {
									Font var39;
									if (var10.type == 4) {
										var39 = var10.getFont();
										if (var39 == null) {
											if (Widget.field2668) {
												WorldMapID.invalidateWidget(var10);
											}
										} else {
											String var44 = var10.text;
											if (Tile.runCs1(var10)) {
												var20 = var10.color2;
												if (var10 == class32.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var20 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var44 = var10.text2;
												}
											} else {
												var20 = var10.color;
												if (var10 == class32.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var20 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var47 = Player.ItemDefinition_get(var10.itemId);
												var44 = var47.name;
												if (var44 == null) {
													var44 = "null";
												}

												if ((var47.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var44 = UserComparator7.colorStartTag(16748608) + var44 + "</col>" + " " + 'x' + FriendSystem.formatItemStacks(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var44 = "Please wait...";
												var20 = var10.color;
											}

											if (!var10.isIf3) {
												var44 = WorldMapSection1.method551(var44, var10);
											}

											var39.drawLines(var44, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var40;
										if (!var10.isIf3) {
											var40 = var10.getSprite(Tile.runCs1(var10));
											if (var40 != null) {
												var40.drawTransBgAt(var12, var13);
											} else if (Widget.field2668) {
												WorldMapID.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var40 = Player.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var40 = var10.getSprite(false);
											}

											if (var40 == null) {
												if (Widget.field2668) {
													WorldMapID.invalidateWidget(var10);
												}
											} else {
												var20 = var40.width;
												var21 = var40.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var40.method6105(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
													} else if (var14 != 0) {
														var40.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
													} else if (var20 == var10.width && var21 == var10.height) {
														var40.drawTransBgAt(var12, var13);
													} else {
														var40.drawScaledAt(var12, var13, var10.width, var10.height);
													}
												} else {
													Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
													var22 = (var20 - 1 + var10.width) / var20;
													var23 = (var21 - 1 + var10.height) / var21;

													for (var24 = 0; var24 < var22; ++var24) {
														for (var25 = 0; var25 < var23; ++var25) {
															if (var10.spriteAngle != 0) {
																var40.method6105(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var40.drawTransAt(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
															} else {
																var40.drawTransBgAt(var12 + var20 * var24, var13 + var25 * var21);
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
											boolean var36 = Tile.runCs1(var10);
											if (var36) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var41 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												var32 = Player.ItemDefinition_get(var10.itemId);
												if (var32 != null) {
													var32 = var32.getCountObj(var10.itemQuantity);
													var41 = var32.getModel(1);
													if (var41 != null) {
														var41.calculateBoundsCylinder();
														var22 = var41.height / 2;
													} else {
														WorldMapID.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var41 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var41 = Varps.localPlayer.getModel();
												}
											} else if (var20 == -1) {
												var41 = var10.getModel((SequenceDefinition)null, -1, var36, Varps.localPlayer.appearance);
												if (var41 == null && Widget.field2668) {
													WorldMapID.invalidateWidget(var10);
												}
											} else {
												SequenceDefinition var46 = class83.SequenceDefinition_get(var20);
												var41 = var10.getModel(var46, var10.modelFrame, var36, Varps.localPlayer.appearance);
												if (var41 == null && Widget.field2668) {
													WorldMapID.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method3033(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var41 != null) {
												if (!var10.isIf3) {
													var41.method2854(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var41.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var41.method2921(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var41.method2854(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.Rasterizer3D_method3();
										} else {
											if (var10.type == 7) {
												var39 = var10.getFont();
												if (var39 == null) {
													if (Widget.field2668) {
														WorldMapID.invalidateWidget(var10);
													}
													continue;
												}

												var20 = 0;

												for (var21 = 0; var21 < var10.rawHeight; ++var21) {
													for (var22 = 0; var22 < var10.rawWidth; ++var22) {
														if (var10.itemIds[var20] > 0) {
															var32 = Player.ItemDefinition_get(var10.itemIds[var20] - 1);
															String var33;
															if (var32.isStackable != 1 && var10.itemQuantities[var20] == 1) {
																var33 = UserComparator7.colorStartTag(16748608) + var32.name + "</col>";
															} else {
																var33 = UserComparator7.colorStartTag(16748608) + var32.name + "</col>" + " " + 'x' + FriendSystem.formatItemStacks(var10.itemQuantities[var20]);
															}

															var25 = var12 + var22 * (var10.paddingX + 115);
															var26 = var13 + (var10.paddingY + 12) * var21;
															if (var10.textXAlignment == 0) {
																var39.draw(var33, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var39.drawCentered(var33, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var39.drawRightAligned(var33, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var20;
													}
												}
											}

											if (var10.type == 8 && var10 == AbstractWorldMapIcon.field292 && Client.field738 == Client.field773) {
												var19 = 0;
												var20 = 0;
												Font var31 = class197.fontPlain12;
												String var34 = var10.text;

												String var43;
												for (var34 = WorldMapSection1.method551(var34, var10); var34.length() > 0; var20 = var20 + var31.ascent + 1) {
													var24 = var34.indexOf("<br>");
													if (var24 != -1) {
														var43 = var34.substring(0, var24);
														var34 = var34.substring(var24 + 4);
													} else {
														var43 = var34;
														var34 = "";
													}

													var25 = var31.stringWidth(var43);
													if (var25 > var19) {
														var19 = var25;
													}
												}

												var19 += 6;
												var20 += 7;
												var24 = var12 + var10.width - 5 - var19;
												var25 = var13 + var10.height + 5;
												if (var24 < var12 + 5) {
													var24 = var12 + 5;
												}

												if (var19 + var24 > var4) {
													var24 = var4 - var19;
												}

												if (var20 + var25 > var5) {
													var25 = var5 - var20;
												}

												Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
												Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var19, var20, 0);
												var34 = var10.text;
												var26 = var25 + var31.ascent + 2;

												for (var34 = WorldMapSection1.method551(var34, var10); var34.length() > 0; var26 = var26 + var31.ascent + 1) {
													int var35 = var34.indexOf("<br>");
													if (var35 != -1) {
														var43 = var34.substring(0, var35);
														var34 = var34.substring(var35 + 4);
													} else {
														var43 = var34;
														var34 = "";
													}

													var31.draw(var43, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2675) {
													var19 = var12;
													var20 = var13 + var10.height;
													var21 = var12 + var10.width;
													var22 = var13;
												} else {
													var19 = var12;
													var20 = var13;
													var21 = var12 + var10.width;
													var22 = var13 + var10.height;
												}

												if (var10.lineWid == 1) {
													Rasterizer2D.Rasterizer2D_drawLine(var19, var20, var21, var22, var10.color);
												} else {
													WorldMapIcon_1.method278(var19, var20, var21, var22, var10.color, var10.lineWid);
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
}
