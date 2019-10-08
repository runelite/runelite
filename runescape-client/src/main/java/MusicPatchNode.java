import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("fs")
	@ObfuscatedGetter(
		intValue = 327716875
	)
	static int field2422;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -517286067
	)
	int field2420;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lch;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	MusicPatchNode2 field2435;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1862096009
	)
	int field2423;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1854182163
	)
	int field2424;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1256664635
	)
	int field2425;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 137135897
	)
	int field2426;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -24850439
	)
	int field2427;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1793031461
	)
	int field2441;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 625260661
	)
	int field2429;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2120695939
	)
	int field2428;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -641551353
	)
	int field2431;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1163841633
	)
	int field2432;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1406869545
	)
	int field2433;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 641640947
	)
	int field2434;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1726198003
	)
	int field2439;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -417116593
	)
	int field2436;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 41547951
	)
	int field2438;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1840443907
	)
	int field2419;

	MusicPatchNode() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	void method3794() {
		this.patch = null;
		this.rawSound = null;
		this.field2435 = null;
		this.stream = null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(CLgt;I)I",
		garbageValue = "888672970"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		signature = "(Lho;III)V",
		garbageValue = "1345950027"
	)
	static final void method3798(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			WorldMapData_1.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = VerticalAlignment.method4321(var0);
			if (var3 != null) {
				WorldMapData_1.insertMenuItemNoShift(var3, World.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			WorldMapData_1.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			WorldMapData_1.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			WorldMapData_1.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			WorldMapData_1.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var5;
		int var19;
		if (var0.type == 2) {
			var19 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (var5 = 0; var5 < var0.width; ++var5) {
					int var6 = (var0.paddingX + 32) * var5;
					int var7 = (var0.paddingY + 32) * var4;
					if (var19 < 20) {
						var6 += var0.inventoryXOffsets[var19];
						var7 += var0.inventoryYOffsets[var19];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var19;
						DevicePcmPlayerProvider.field391 = var0;
						if (var0.itemIds[var19] > 0) {
							label331: {
								ItemDefinition var8 = Occluder.ItemDefinition_get(var0.itemIds[var19] - 1);
								boolean var9;
								int var10;
								if (Client.isItemSelected == 1) {
									var10 = class2.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if (var0.id != class2.selectedItemWidget || var19 != DevicePcmPlayerProvider.selectedItemSlot) {
											WorldMapData_1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + World.colorStartTag(16748608) + var8.name, 31, var8.id, var19, var0.id);
										}
										break label331;
									}
								}

								if (Client.isSpellSelected) {
									var10 = class2.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if ((ItemContainer.selectedSpellFlags & 16) == 16) {
											WorldMapData_1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + World.colorStartTag(16748608) + var8.name, 32, var8.id, var19, var0.id);
										}
										break label331;
									}
								}

								String[] var20 = var8.inventoryActions;
								var10 = -1;
								if (Client.shiftClickDrop && class14.method174()) {
									var10 = var8.getShiftClickIndex();
								}

								int var12 = class2.getWidgetClickMask(var0);
								boolean var11 = (var12 >> 30 & 1) != 0;
								if (var11) {
									for (int var13 = 4; var13 >= 3; --var13) {
										if (var13 != var10) {
											UrlRequest.addWidgetItemMenuItem(var0, var8, var19, var13, false);
										}
									}
								}

								int var14 = class2.getWidgetClickMask(var0);
								boolean var24 = (var14 >> 31 & 1) != 0;
								if (var24) {
									WorldMapData_1.insertMenuItemNoShift("Use", World.colorStartTag(16748608) + var8.name, 38, var8.id, var19, var0.id);
								}

								int var16 = class2.getWidgetClickMask(var0);
								boolean var15 = (var16 >> 30 & 1) != 0;
								int var17;
								if (var15) {
									for (var17 = 2; var17 >= 0; --var17) {
										if (var10 != var17) {
											UrlRequest.addWidgetItemMenuItem(var0, var8, var19, var17, false);
										}
									}

									if (var10 >= 0) {
										UrlRequest.addWidgetItemMenuItem(var0, var8, var19, var10, true);
									}
								}

								var20 = var0.itemActions;
								if (var20 != null) {
									for (var17 = 4; var17 >= 0; --var17) {
										if (var20[var17] != null) {
											byte var18 = 0;
											if (var17 == 0) {
												var18 = 39;
											}

											if (var17 == 1) {
												var18 = 40;
											}

											if (var17 == 2) {
												var18 = 41;
											}

											if (var17 == 3) {
												var18 = 42;
											}

											if (var17 == 4) {
												var18 = 43;
											}

											WorldMapData_1.insertMenuItemNoShift(var20[var17], World.colorStartTag(16748608) + var8.name, var18, var8.id, var19, var0.id);
										}
									}
								}

								WorldMapData_1.insertMenuItemNoShift("Examine", World.colorStartTag(16748608) + var8.name, 1005, var8.id, var19, var0.id);
							}
						}
					}

					++var19;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				var4 = class2.getWidgetClickMask(var0);
				boolean var25 = (var4 >> 21 & 1) != 0;
				if (var25 && (ItemContainer.selectedSpellFlags & 32) == 32) {
					WorldMapData_1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var19 = 9; var19 >= 5; --var19) {
					String var21 = FaceNormal.method3228(var0, var19);
					if (var21 != null) {
						WorldMapData_1.insertMenuItemNoShift(var21, var0.dataText, 1007, var19 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = VerticalAlignment.method4321(var0);
				if (var3 != null) {
					WorldMapData_1.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					String var22 = FaceNormal.method3228(var0, var4);
					if (var22 != null) {
						AttackOption.insertMenuItem(var22, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2687);
					}
				}

				var5 = class2.getWidgetClickMask(var0);
				boolean var23 = (var5 & 1) != 0;
				if (var23) {
					WorldMapData_1.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "([Lho;IIIIIIIB)V",
		garbageValue = "-61"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class2.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (WorldMapSectionType.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != NetSocket.mousedOverWidgetIf1 && WorldMapSectionType.isComponentHidden(var9)) {
					continue;
				}

				int var10 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var17;
				int var18;
				if (var9.type == 2) {
					var12 = var2;
					var13 = var3;
					var14 = var4;
					var15 = var5;
				} else {
					int var16;
					if (var9.type == 9) {
						var16 = var10;
						var17 = var11;
						var18 = var10 + var9.width;
						int var19 = var11 + var9.height;
						if (var18 < var10) {
							var16 = var18;
							var18 = var10;
						}

						if (var19 < var11) {
							var17 = var19;
							var19 = var11;
						}

						++var18;
						++var19;
						var12 = var16 > var2 ? var16 : var2;
						var13 = var17 > var3 ? var17 : var3;
						var14 = var18 < var4 ? var18 : var4;
						var15 = var19 < var5 ? var19 : var5;
					} else {
						var16 = var10 + var9.width;
						var17 = var11 + var9.height;
						var12 = var10 > var2 ? var10 : var2;
						var13 = var11 > var3 ? var11 : var3;
						var14 = var16 < var4 ? var16 : var4;
						var15 = var17 < var5 ? var17 : var5;
					}
				}

				if (var9 == Client.clickedWidget) {
					Client.field817 = true;
					Client.field818 = var10;
					Client.field819 = var11;
				}

				boolean var32 = false;
				if (var9.field2619) {
					switch(Client.field798) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field824 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field824) {
							var32 = true;
						}
					}
				}

				if (var32 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var26;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var26 = (ScriptEvent)Client.scriptEvents.last(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.previous()) {
									if (var26.isMouseInputEvent) {
										var26.remove();
										var26.widget.containsMouse = false;
									}
								}

								if (ViewportMouse.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									KeyHandler.addCancelMenuEntry();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var26 = (ScriptEvent)Client.scriptEvents.last(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var26.isMouseInputEvent && var26.widget.onScroll == var26.args) {
									var26.remove();
								}
							}
						}
					}

					var17 = MouseHandler.MouseHandler_x;
					var18 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var17 = MouseHandler.MouseHandler_lastPressedX;
						var18 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var33 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var33) {
							class32.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						BufferedSink.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							Tiles.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								Tiles.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								method3798(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2552.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2552[var20] != null) {
									for (var23 = 0; var23 < var9.field2552[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2684 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2552[var20][var23]];
										}

										if (MusicPatchNode2.method3658(var9.field2552[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2684 != null && var9.field2684[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2621[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										WorldMapSection1.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										class208.Widget_runOnTargetLeave();
										class32.selectSpell(var9.id, var9.childIndex, class2.method30(class2.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = VerticalAlignment.method4321(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + World.colorStartTag(16777215);
									}

									var23 = var9.field2586[var20];
									if (var9.field2684 == null) {
										var9.field2684 = new int[var9.field2552.length];
									}

									if (var9.field2548 == null) {
										var9.field2548 = new int[var9.field2552.length];
									}

									if (var23 != 0) {
										if (var9.field2684[var20] == 0) {
											var9.field2684[var20] = var23 + Client.cycle + var9.field2548[var20];
										} else {
											var9.field2684[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2684[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2684 != null) {
									var9.field2684[var20] = 0;
								}
							}
						}

						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var33 = true;
							} else {
								var33 = false;
							}

							boolean var34 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !WorldMapIcon_1.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapIcon_1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								class227.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								Tiles.worldMap.method6445(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && GrandExchangeOfferTotalQuantityComparator.method93(class2.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field814 = true;
								Client.field695 = var10;
								Client.field816 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var27;
								if (var33 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseY = Client.mouseWheelRotation;
									var27.args = var9.onScroll;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.clickedWidget != null || Frames.dragInventoryWidget != null || Client.isMenuOpen) {
									var21 = false;
									var34 = false;
									var33 = false;
								}

								if (!var9.isClicked && var21) {
									var9.isClicked = true;
									if (var9.onClick != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
										var27.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var27.args = var9.onClick;
										Client.scriptEvents.addFirst(var27);
									}
								}

								if (var9.isClicked && var34 && var9.onClickRepeat != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var27);
								}

								if (var9.isClicked && !var34) {
									var9.isClicked = false;
									if (var9.onRelease != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onRelease;
										Client.field763.addFirst(var27);
									}
								}

								if (var34 && var9.onHold != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onHold;
									Client.scriptEvents.addFirst(var27);
								}

								if (!var9.containsMouse && var33) {
									var9.containsMouse = true;
									if (var9.onMouseOver != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var27);
									}
								}

								if (var9.containsMouse && var33 && var9.onMouseRepeat != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var27);
								}

								if (var9.containsMouse && !var33) {
									var9.containsMouse = false;
									if (var9.onMouseLeave != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onMouseLeave;
										Client.field763.addFirst(var27);
									}
								}

								if (var9.onTimer != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onTimer;
									Client.field836.addFirst(var27);
								}

								ScriptEvent var28;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field823 > var9.field2620) {
									if (var9.varTransmitTriggers != null && Client.field823 - var9.field2620 <= 32) {
										label876:
										for (var35 = var9.field2620; var35 < Client.field823; ++var35) {
											var23 = Client.field782[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var28 = new ScriptEvent();
													var28.widget = var9;
													var28.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var28);
													break label876;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2620 = Client.field823;
								}

								if (var9.onInvTransmit != null && Client.field825 > var9.field2680) {
									if (var9.invTransmitTriggers != null && Client.field825 - var9.field2680 <= 32) {
										label852:
										for (var35 = var9.field2680; var35 < Client.field825; ++var35) {
											var23 = Client.field820[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var28 = new ScriptEvent();
													var28.widget = var9;
													var28.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var28);
													break label852;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2680 = Client.field825;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2681) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2681 <= 32) {
										label828:
										for (var35 = var9.field2681; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var28 = new ScriptEvent();
													var28.widget = var9;
													var28.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var28);
													break label828;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2681 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2558 && var9.onChatTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field744 > var9.field2558 && var9.onFriendTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field830 > var9.field2558 && var9.onClanTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field831 > var9.field2558 && var9.onStockTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field832 > var9.field2558 && var9.field2662 != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.field2662;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field833 > var9.field2558 && var9.onMiscTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								var9.field2558 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field857; ++var35) {
										ScriptEvent var29 = new ScriptEvent();
										var29.widget = var9;
										var29.keyTyped = Client.field859[var35];
										var29.keyPressed = Client.field858[var35];
										var29.args = var9.onKey;
										Client.scriptEvents.addFirst(var29);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || Frames.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									NetSocket.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									NetSocket.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								Strings.field2767 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								WorldMapAreaData.method719(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var30 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var30 != null) {
								if (var30.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var31 = (ScriptEvent)Client.scriptEvents.last(); var31 != null; var31 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var31.isMouseInputEvent) {
											var31.remove();
											var31.widget.containsMouse = false;
										}
									}

									if (ViewportMouse.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										KeyHandler.addCancelMenuEntry();
									}
								}

								AbstractWorldMapData.updateRootInterface(var30.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
