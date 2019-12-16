import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eu")
@Implements("UserComparator7")
public class UserComparator7 extends AbstractUserComparator {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "[[Lha;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static Widget field1946;
	@ObfuscatedName("f")
	@Export("reversed")
	final boolean reversed;

	public UserComparator7(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;B)I",
		garbageValue = "-30"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "([BIIIIIIILej;[Lfp;I)V",
		garbageValue = "678267199"
	)
	static final void method3344(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
		Buffer var10 = new Buffer(var0);
		int var11 = -1;

		while (true) {
			int var12 = var10.method5558();
			if (var12 == 0) {
				return;
			}

			var11 += var12;
			int var13 = 0;

			while (true) {
				int var14 = var10.readUShortSmart();
				if (var14 == 0) {
					break;
				}

				var13 += var14 - 1;
				int var15 = var13 & 63;
				int var16 = var13 >> 6 & 63;
				int var17 = var13 >> 12;
				int var18 = var10.readUnsignedByte();
				int var19 = var18 >> 2;
				int var20 = var18 & 3;
				if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
					ObjectDefinition var21 = Coord.getObjectDefinition(var11);
					int var24 = var16 & 7;
					int var25 = var15 & 7;
					int var27 = var21.sizeX;
					int var28 = var21.sizeY;
					int var29;
					if ((var20 & 1) == 1) {
						var29 = var27;
						var27 = var28;
						var28 = var29;
					}

					int var26 = var7 & 3;
					int var23;
					if (var26 == 0) {
						var23 = var24;
					} else if (var26 == 1) {
						var23 = var25;
					} else if (var26 == 2) {
						var23 = 7 - var24 - (var27 - 1);
					} else {
						var23 = 7 - var25 - (var28 - 1);
					}

					var29 = var23 + var2;
					int var32 = var16 & 7;
					int var33 = var15 & 7;
					int var35 = var21.sizeX;
					int var36 = var21.sizeY;
					int var37;
					if ((var20 & 1) == 1) {
						var37 = var35;
						var35 = var36;
						var36 = var37;
					}

					int var34 = var7 & 3;
					int var31;
					if (var34 == 0) {
						var31 = var33;
					} else if (var34 == 1) {
						var31 = 7 - var32 - (var35 - 1);
					} else if (var34 == 2) {
						var31 = 7 - var33 - (var36 - 1);
					} else {
						var31 = var32;
					}

					var37 = var31 + var3;
					if (var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
						int var38 = var1;
						if ((Tiles.Tiles_renderFlags[1][var29][var37] & 2) == 2) {
							var38 = var1 - 1;
						}

						CollisionMap var39 = null;
						if (var38 >= 0) {
							var39 = var9[var38];
						}

						VarbitDefinition.method4500(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
					}
				}
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "2063896690"
	)
	static int method3345(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "([Lha;IIIIIIIII)V",
		garbageValue = "-1693835764"
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
				if (!var10.isIf3 || !Varcs.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						SoundSystem.method2507(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							ClientPacket.field2223 = var0;
							GrandExchangeEvents.field31 = var6;
							class81.field1126 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field806) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field807) {
								var15 = Client.field807;
							}

							if (var15 + var10.width > Client.field807 + Client.clickedWidgetParent.width) {
								var15 = Client.field807 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field808) {
								var16 = Client.field808;
							}

							if (var16 + var10.height > Client.field808 + Client.clickedWidgetParent.height) {
								var16 = Client.field808 + Client.clickedWidgetParent.height - var10.height;
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
									ScriptFrame.fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var38 = Runtime.getRuntime();
									var20 = (int)((var38.totalMemory() - var38.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									ScriptFrame.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								class192.drawEntities(var12, var13, var10.width, var10.height);
								Client.field833[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								Occluder.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								FriendSystem.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								GrandExchangeEvent.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								GrandExchangeEvent.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								StructDefinition.loginScreenRunesAnimation.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && Varcs.isComponentHidden(var10) && var10 != class16.mousedOverWidgetIf1) {
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
								class13.drawWidgets(var19.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
						}

						if (Client.isResizable || Client.field835[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								ClanMate.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
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
											var22 = var12 + var21 * (var10.paddingX + 32);
											var23 = var13 + var20 * (var10.paddingY + 32);
											if (var30 < 20) {
												var22 += var10.inventoryXOffsets[var30];
												var23 += var10.inventoryYOffsets[var30];
											}

											if (var10.itemIds[var30] <= 0) {
												if (var10.inventorySprites != null && var30 < 20) {
													Sprite var45 = var10.getInventorySprite(var30);
													if (var45 != null) {
														var45.drawTransBgAt(var22, var23);
													} else if (Widget.field2549) {
														LoginPacket.invalidateWidget(var10);
													}
												}
											} else {
												boolean var39 = false;
												boolean var40 = false;
												var26 = var10.itemIds[var30] - 1;
												if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == ClientPreferences.dragInventoryWidget && var30 == Client.dragItemSlotSource) {
													Sprite var27;
													if (Client.isItemSelected == 1 && var30 == KeyHandler.selectedItemSlot && var10.id == Occluder.selectedItemWidget) {
														var27 = StudioGame.getItemSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
													} else {
														var27 = StudioGame.getItemSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
													}

													if (var27 != null) {
														if (var10 == ClientPreferences.dragInventoryWidget && var30 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.field863;
															var25 = MouseHandler.MouseHandler_y - Client.field738;
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

															var27.drawTransAt(var24 + var22, var25 + var23, 128);
															if (var1 != -1) {
																Widget var28 = var0[var1 & 65535];
																int var29;
																if (var25 + var23 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
																	var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field690 / 3;
																	if (var29 > Client.field690 * 10) {
																		var29 = Client.field690 * 10;
																	}

																	if (var29 > var28.scrollY) {
																		var29 = var28.scrollY;
																	}

																	var28.scrollY -= var29;
																	Client.field738 += var29;
																	LoginPacket.invalidateWidget(var28);
																}

																if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
																	var29 = (var25 + var23 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field690 / 3;
																	if (var29 > Client.field690 * 10) {
																		var29 = Client.field690 * 10;
																	}

																	if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
																		var29 = var28.scrollHeight - var28.height - var28.scrollY;
																	}

																	var28.scrollY += var29;
																	Client.field738 -= var29;
																	LoginPacket.invalidateWidget(var28);
																}
															}
														} else if (var10 == class192.field2372 && var30 == Client.field735) {
															var27.drawTransAt(var22, var23, 128);
														} else {
															var27.drawTransBgAt(var22, var23);
														}
													} else {
														LoginPacket.invalidateWidget(var10);
													}
												}
											}

											++var30;
										}
									}
								} else if (var10.type == 3) {
									if (WorldMapData_0.runCs1(var10)) {
										var30 = var10.color2;
										if (var10 == class16.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var30 = var10.mouseOverColor2;
										}
									} else {
										var30 = var10.color;
										if (var10 == class16.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
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
											if (Widget.field2549) {
												LoginPacket.invalidateWidget(var10);
											}
										} else {
											String var43 = var10.text;
											if (WorldMapData_0.runCs1(var10)) {
												var20 = var10.color2;
												if (var10 == class16.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var20 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var43 = var10.text2;
												}
											} else {
												var20 = var10.color;
												if (var10 == class16.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var20 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var47 = PacketBufferNode.ItemDefinition_get(var10.itemId);
												var43 = var47.name;
												if (var43 == null) {
													var43 = "null";
												}

												if ((var47.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var43 = NPC.colorStartTag(16748608) + var43 + "</col>" + " " + 'x' + WorldMapSectionType.formatItemStacks(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var43 = "Please wait...";
												var20 = var10.color;
											}

											if (!var10.isIf3) {
												var43 = class32.method553(var43, var10);
											}

											var36.drawLines(var43, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var37;
										if (!var10.isIf3) {
											var37 = var10.getSprite(WorldMapData_0.runCs1(var10));
											if (var37 != null) {
												var37.drawTransBgAt(var12, var13);
											} else if (Widget.field2549) {
												LoginPacket.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var37 = StudioGame.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var37 = var10.getSprite(false);
											}

											if (var37 == null) {
												if (Widget.field2549) {
													LoginPacket.invalidateWidget(var10);
												}
											} else {
												var20 = var37.width;
												var21 = var37.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var37.method6243(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
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
																var37.method6243(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var37.drawTransAt(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
															} else {
																var37.drawTransBgAt(var12 + var20 * var24, var13 + var25 * var21);
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
											boolean var44 = WorldMapData_0.runCs1(var10);
											if (var44) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var41 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												var32 = PacketBufferNode.ItemDefinition_get(var10.itemId);
												if (var32 != null) {
													var32 = var32.getCountObj(var10.itemQuantity);
													var41 = var32.getModel(1);
													if (var41 != null) {
														var41.calculateBoundsCylinder();
														var22 = var41.height / 2;
													} else {
														LoginPacket.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var41 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var41 = Message.localPlayer.getModel();
												}
											} else if (var20 == -1) {
												var41 = var10.getModel((SequenceDefinition)null, -1, var44, Message.localPlayer.appearance);
												if (var41 == null && Widget.field2549) {
													LoginPacket.invalidateWidget(var10);
												}
											} else {
												SequenceDefinition var46 = WorldMapSection0.SequenceDefinition_get(var20);
												var41 = var10.getModel(var46, var10.modelFrame, var44, Message.localPlayer.appearance);
												if (var41 == null && Widget.field2549) {
													LoginPacket.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method3086(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var41 != null) {
												if (!var10.isIf3) {
													var41.method2907(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var41.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var41.method2905(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var41.method2907(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.Rasterizer3D_method3();
										} else {
											if (var10.type == 7) {
												var36 = var10.getFont();
												if (var36 == null) {
													if (Widget.field2549) {
														LoginPacket.invalidateWidget(var10);
													}
													continue;
												}

												var20 = 0;

												for (var21 = 0; var21 < var10.rawHeight; ++var21) {
													for (var22 = 0; var22 < var10.rawWidth; ++var22) {
														if (var10.itemIds[var20] > 0) {
															var32 = PacketBufferNode.ItemDefinition_get(var10.itemIds[var20] - 1);
															String var33;
															if (var32.isStackable != 1 && var10.itemQuantities[var20] == 1) {
																var33 = NPC.colorStartTag(16748608) + var32.name + "</col>";
															} else {
																var33 = NPC.colorStartTag(16748608) + var32.name + "</col>" + " " + 'x' + WorldMapSectionType.formatItemStacks(var10.itemQuantities[var20]);
															}

															var25 = var12 + var22 * (var10.paddingX + 115);
															var26 = var21 * (var10.paddingY + 12) + var13;
															if (var10.textXAlignment == 0) {
																var36.draw(var33, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var36.drawCentered(var33, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var36.drawRightAligned(var33, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var20;
													}
												}
											}

											if (var10.type == 8 && var10 == class14.field90 && Client.field674 == Client.field798) {
												var30 = 0;
												var20 = 0;
												Font var31 = ScriptFrame.fontPlain12;
												String var34 = var10.text;

												String var42;
												for (var34 = class32.method553(var34, var10); var34.length() > 0; var20 = var20 + var31.ascent + 1) {
													var24 = var34.indexOf("<br>");
													if (var24 != -1) {
														var42 = var34.substring(0, var24);
														var34 = var34.substring(var24 + 4);
													} else {
														var42 = var34;
														var34 = "";
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
												var34 = var10.text;
												var26 = var25 + var31.ascent + 2;

												for (var34 = class32.method553(var34, var10); var34.length() > 0; var26 = var26 + var31.ascent + 1) {
													int var35 = var34.indexOf("<br>");
													if (var35 != -1) {
														var42 = var34.substring(0, var35);
														var34 = var34.substring(var35 + 4);
													} else {
														var42 = var34;
														var34 = "";
													}

													var31.draw(var42, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2676) {
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
													DevicePcmPlayerProvider.method839(var30, var20, var21, var22, var10.color, var10.lineWid);
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
