import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("rn")
	@ObfuscatedGetter(
		intValue = -1797586275
	)
	static int field570;
	@ObfuscatedName("z")
	@Export("args")
	Object[] args;
	@ObfuscatedName("n")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -536253001
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 339811595
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 523814267
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 890448357
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -463436489
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("i")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1373208137
	)
	int field568;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1041391975
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "345377680"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2089299641"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Lli;I)Ljava/lang/String;",
		garbageValue = "254330677"
	)
	public static String method1198(CharSequence var0, LoginType var1) {
		if (var0 == null) {
			return null;
		} else {
			int var2 = 0;

			int var3;
			for (var3 = var0.length(); var2 < var3 && BoundaryObject.method3226(var0.charAt(var2)); ++var2) {
			}

			while (var3 > var2 && BoundaryObject.method3226(var0.charAt(var3 - 1))) {
				--var3;
			}

			int var4 = var3 - var2;
			if (var4 >= 1 && var4 <= BufferedSink.method5794(var1)) {
				StringBuilder var5 = new StringBuilder(var4);

				for (int var6 = var2; var6 < var3; ++var6) {
					char var7 = var0.charAt(var6);
					boolean var8;
					if (Character.isISOControl(var7)) {
						var8 = false;
					} else if (AbstractArchive.isAlphaNumeric(var7)) {
						var8 = true;
					} else {
						char[] var12 = class338.field4036;
						int var10 = 0;

						label73:
						while (true) {
							char var11;
							if (var10 >= var12.length) {
								var12 = class338.field4037;

								for (var10 = 0; var10 < var12.length; ++var10) {
									var11 = var12[var10];
									if (var7 == var11) {
										var8 = true;
										break label73;
									}
								}

								var8 = false;
								break;
							}

							var11 = var12[var10];
							if (var11 == var7) {
								var8 = true;
								break;
							}

							++var10;
						}
					}

					if (var8) {
						char var9 = class32.method577(var7);
						if (var9 != 0) {
							var5.append(var9);
						}
					}
				}

				if (var5.length() == 0) {
					return null;
				} else {
					return var5.toString();
				}
			} else {
				return null;
			}
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2065771075"
	)
	static void method1205() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "([Lho;IIIIIIIIB)V",
		garbageValue = "50"
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
				if (!var10.isIf3 || !WorldMapSectionType.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						WorldMapIcon_0.method221(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							GrandExchangeOffer.field61 = var0;
							class227.field3061 = var6;
							Occluder.field1889 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field814) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field695) {
								var15 = Client.field695;
							}

							if (var15 + var10.width > Client.field695 + Client.clickedWidgetParent.width) {
								var15 = Client.field695 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field816) {
								var16 = Client.field816;
							}

							if (var16 + var10.height > Client.field816 + Client.clickedWidgetParent.height) {
								var16 = Client.field816 + Client.clickedWidgetParent.height - var10.height;
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
									GraphicsDefaults.fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var41 = Runtime.getRuntime();
									var20 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									GraphicsDefaults.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								Friend.drawEntities(var12, var13, var10.width, var10.height);
								Client.field841[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								ClientPreferences.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								SoundSystem.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								Tiles.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								Tiles.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								BufferedSink.loginScreenRunesAnimation.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && WorldMapSectionType.isComponentHidden(var10) && var10 != NetSocket.mousedOverWidgetIf1) {
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
								ItemContainer.drawWidgets(var30.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
						}

						if (Client.isResizable || Client.field847[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								GameShell.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
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
													Sprite var43 = var10.getInventorySprite(var19);
													if (var43 != null) {
														var43.drawTransBgAt(var22, var23);
													} else if (Widget.field2543) {
														WorldMapSectionType.invalidateWidget(var10);
													}
												}
											} else {
												boolean var37 = false;
												boolean var38 = false;
												var26 = var10.itemIds[var19] - 1;
												if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == Frames.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
													Sprite var27;
													if (Client.isItemSelected == 1 && var19 == DevicePcmPlayerProvider.selectedItemSlot && var10.id == class2.selectedItemWidget) {
														var27 = GrandExchangeOfferWorldComparator.getItemSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
													} else {
														var27 = GrandExchangeOfferWorldComparator.getItemSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
													}

													if (var27 != null) {
														if (var10 == Frames.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.field745;
															var25 = MouseHandler.MouseHandler_y - Client.field746;
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

															var27.drawTransAt(var22 + var24, var23 + var25, 128);
															if (var1 != -1) {
																Widget var28 = var0[var1 & 65535];
																int var29;
																if (var23 + var25 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
																	var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field698 / 3;
																	if (var29 > Client.field698 * 10) {
																		var29 = Client.field698 * 10;
																	}

																	if (var29 > var28.scrollY) {
																		var29 = var28.scrollY;
																	}

																	var28.scrollY -= var29;
																	Client.field746 += var29;
																	WorldMapSectionType.invalidateWidget(var28);
																}

																if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
																	var29 = (var25 + var23 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field698 / 3;
																	if (var29 > Client.field698 * 10) {
																		var29 = Client.field698 * 10;
																	}

																	if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
																		var29 = var28.scrollHeight - var28.height - var28.scrollY;
																	}

																	var28.scrollY += var29;
																	Client.field746 -= var29;
																	WorldMapSectionType.invalidateWidget(var28);
																}
															}
														} else if (var10 == GrandExchangeOfferOwnWorldComparator.field628 && var19 == Client.field743) {
															var27.drawTransAt(var22, var23, 128);
														} else {
															var27.drawTransBgAt(var22, var23);
														}
													} else {
														WorldMapSectionType.invalidateWidget(var10);
													}
												}
											}

											++var19;
										}
									}
								} else if (var10.type == 3) {
									if (Projectile.runCs1(var10)) {
										var19 = var10.color2;
										if (var10 == NetSocket.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var19 = var10.mouseOverColor2;
										}
									} else {
										var19 = var10.color;
										if (var10 == NetSocket.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
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
											if (Widget.field2543) {
												WorldMapSectionType.invalidateWidget(var10);
											}
										} else {
											String var45 = var10.text;
											if (Projectile.runCs1(var10)) {
												var20 = var10.color2;
												if (var10 == NetSocket.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var20 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var45 = var10.text2;
												}
											} else {
												var20 = var10.color;
												if (var10 == NetSocket.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var20 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var46 = Occluder.ItemDefinition_get(var10.itemId);
												var45 = var46.name;
												if (var45 == null) {
													var45 = "null";
												}

												if ((var46.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var45 = World.colorStartTag(16748608) + var45 + "</col>" + " " + 'x' + class42.formatItemStacks(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var45 = "Please wait...";
												var20 = var10.color;
											}

											if (!var10.isIf3) {
												var45 = InvDefinition.method4335(var45, var10);
											}

											var39.drawLines(var45, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var40;
										if (!var10.isIf3) {
											var40 = var10.getSprite(Projectile.runCs1(var10));
											if (var40 != null) {
												var40.drawTransBgAt(var12, var13);
											} else if (Widget.field2543) {
												WorldMapSectionType.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var40 = GrandExchangeOfferWorldComparator.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var40 = var10.getSprite(false);
											}

											if (var40 == null) {
												if (Widget.field2543) {
													WorldMapSectionType.invalidateWidget(var10);
												}
											} else {
												var20 = var40.width;
												var21 = var40.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var40.method6091(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
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
																var40.method6091(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var40.drawTransAt(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
															} else {
																var40.drawTransBgAt(var12 + var24 * var20, var13 + var25 * var21);
															}
														}
													}

													Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
												}
											}
										}
									} else {
										ItemDefinition var34;
										if (var10.type == 6) {
											boolean var36 = Projectile.runCs1(var10);
											if (var36) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var42 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												var34 = Occluder.ItemDefinition_get(var10.itemId);
												if (var34 != null) {
													var34 = var34.getCountObj(var10.itemQuantity);
													var42 = var34.getModel(1);
													if (var42 != null) {
														var42.calculateBoundsCylinder();
														var22 = var42.height / 2;
													} else {
														WorldMapSectionType.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var42 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var42 = class223.localPlayer.getModel();
												}
											} else if (var20 == -1) {
												var42 = var10.getModel((SequenceDefinition)null, -1, var36, class223.localPlayer.appearance);
												if (var42 == null && Widget.field2543) {
													WorldMapSectionType.invalidateWidget(var10);
												}
											} else {
												SequenceDefinition var47 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var20);
												var42 = var10.getModel(var47, var10.modelFrame, var36, class223.localPlayer.appearance);
												if (var42 == null && Widget.field2543) {
													WorldMapSectionType.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method2992(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var42 != null) {
												if (!var10.isIf3) {
													var42.method2870(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var42.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var42.method2871(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var42.method2870(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.Rasterizer3D_method3();
										} else {
											if (var10.type == 7) {
												var39 = var10.getFont();
												if (var39 == null) {
													if (Widget.field2543) {
														WorldMapSectionType.invalidateWidget(var10);
													}
													continue;
												}

												var20 = 0;

												for (var21 = 0; var21 < var10.rawHeight; ++var21) {
													for (var22 = 0; var22 < var10.rawWidth; ++var22) {
														if (var10.itemIds[var20] > 0) {
															var34 = Occluder.ItemDefinition_get(var10.itemIds[var20] - 1);
															String var31;
															if (var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
																var31 = World.colorStartTag(16748608) + var34.name + "</col>";
															} else {
																var31 = World.colorStartTag(16748608) + var34.name + "</col>" + " " + 'x' + class42.formatItemStacks(var10.itemQuantities[var20]);
															}

															var25 = var12 + var22 * (var10.paddingX + 115);
															var26 = var13 + (var10.paddingY + 12) * var21;
															if (var10.textXAlignment == 0) {
																var39.draw(var31, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var39.drawCentered(var31, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var39.drawRightAligned(var31, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var20;
													}
												}
											}

											if (var10.type == 8 && var10 == Strings.field2767 && Client.field787 == Client.field788) {
												var19 = 0;
												var20 = 0;
												Font var32 = GraphicsDefaults.fontPlain12;
												String var33 = var10.text;

												String var44;
												for (var33 = InvDefinition.method4335(var33, var10); var33.length() > 0; var20 = var20 + var32.ascent + 1) {
													var24 = var33.indexOf("<br>");
													if (var24 != -1) {
														var44 = var33.substring(0, var24);
														var33 = var33.substring(var24 + 4);
													} else {
														var44 = var33;
														var33 = "";
													}

													var25 = var32.stringWidth(var44);
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

												if (var24 + var19 > var4) {
													var24 = var4 - var19;
												}

												if (var25 + var20 > var5) {
													var25 = var5 - var20;
												}

												Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
												Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var19, var20, 0);
												var33 = var10.text;
												var26 = var25 + var32.ascent + 2;

												for (var33 = InvDefinition.method4335(var33, var10); var33.length() > 0; var26 = var26 + var32.ascent + 1) {
													int var35 = var33.indexOf("<br>");
													if (var35 != -1) {
														var44 = var33.substring(0, var35);
														var33 = var33.substring(var35 + 4);
													} else {
														var44 = var33;
														var33 = "";
													}

													var32.draw(var44, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2579) {
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
													DevicePcmPlayerProvider.method877(var19, var20, var21, var22, var10.color, var10.lineWid);
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

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-374133932"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}
}
