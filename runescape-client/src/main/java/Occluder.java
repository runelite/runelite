import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("sy")
	@ObfuscatedGetter(
		longValue = 8542381925418177619L
	)
	static long field1890;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 969777385
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1553227311
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1059981865
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -448814067
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 234253745
	)
	@Export("type")
	int type;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1608934267
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -610653481
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 399594661
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1267632165
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 912132207
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -646575611
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2144638079
	)
	int field1883;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1502602097
	)
	int field1882;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -21293905
	)
	int field1885;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -2138791857
	)
	int field1886;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1127843117
	)
	int field1887;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1866279201
	)
	int field1872;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -650664545
	)
	int field1888;

	Occluder() {
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "([Lhp;IIIIIIII)V",
		garbageValue = "-438614783"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || ParamDefinition.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (WorldMapRectangle.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != class65.mousedOverWidgetIf1 && WorldMapRectangle.isComponentHidden(var9)) {
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
					Client.field804 = true;
					Client.field805 = var10;
					Client.field806 = var11;
				}

				boolean var32 = false;
				if (var9.field2620) {
					switch(Client.field638) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field786 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field786) {
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

								if (class60.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									LoginScreenAnimation.addCancelMenuEntry();
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
							Calendar.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						MidiPcmStream.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							WorldMapCacheName.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								WorldMapCacheName.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								ClientPacket.method3558(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2631.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2631[var20] != null) {
									for (var23 = 0; var23 < var9.field2631[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2685 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2631[var20][var23]];
										}

										if (class2.method40(var9.field2631[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2685 != null && var9.field2685[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2622[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										InterfaceParent.method1127(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										WorldMapRegion.Widget_runOnTargetLeave();
										class223.method4036(var9.id, var9.childIndex, WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = class173.method3529(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + class16.colorStartTag(16777215);
									}

									var23 = var9.field2623[var20];
									if (var9.field2685 == null) {
										var9.field2685 = new int[var9.field2631.length];
									}

									if (var9.field2581 == null) {
										var9.field2581 = new int[var9.field2631.length];
									}

									if (var23 != 0) {
										if (var9.field2685[var20] == 0) {
											var9.field2685[var20] = var23 + Client.cycle + var9.field2581[var20];
										} else {
											var9.field2685[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2685[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2685 != null) {
									var9.field2685[var20] = 0;
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
							if ((MouseHandler.MouseHandler_currentButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								WorldMapRegion.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								WorldMapCacheName.worldMap.method6185(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && Message.method1173(ParamDefinition.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field641 = true;
								Client.field802 = var10;
								Client.field803 = var11;
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

								if (Client.clickedWidget != null || class188.dragInventoryWidget != null || Client.isMenuOpen) {
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
										Client.field824.addFirst(var27);
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
										Client.field824.addFirst(var27);
									}
								}

								if (var9.onTimer != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onTimer;
									Client.field633.addFirst(var27);
								}

								ScriptEvent var30;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field800 > var9.field2680) {
									if (var9.varTransmitTriggers != null && Client.field800 - var9.field2680 <= 32) {
										label899:
										for (var35 = var9.field2680; var35 < Client.field800; ++var35) {
											var23 = Client.field809[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var30);
													break label899;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2680 = Client.field800;
								}

								if (var9.onInvTransmit != null && Client.field812 > var9.field2681) {
									if (var9.invTransmitTriggers != null && Client.field812 - var9.field2681 <= 32) {
										label875:
										for (var35 = var9.field2681; var35 < Client.field812; ++var35) {
											var23 = Client.field811[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var30);
													break label875;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2681 = Client.field812;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2591) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2591 <= 32) {
										label851:
										for (var35 = var9.field2591; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var30);
													break label851;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var27);
									}

									var9.field2591 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2679 && var9.onChatTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field629 > var9.field2679 && var9.onFriendTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field817 > var9.field2679 && var9.onClanTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field818 > var9.field2679 && var9.onStockTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field819 > var9.field2679 && var9.field2663 != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.field2663;
									Client.scriptEvents.addFirst(var27);
								}

								if (Client.field820 > var9.field2679 && var9.onMiscTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var27);
								}

								var9.field2679 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field677; ++var35) {
										ScriptEvent var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = Client.field815[var35];
										var31.keyPressed = Client.field845[var35];
										var31.args = var9.onKey;
										Client.scriptEvents.addFirst(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || class188.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									class65.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									class65.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								WorldMapDecoration.field198 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								WorldMapData_1.method682(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var28 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var28 != null) {
								if (var28.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var29.isMouseInputEvent) {
											var29.remove();
											var29.widget.containsMouse = false;
										}
									}

									if (class60.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										LoginScreenAnimation.addCancelMenuEntry();
									}
								}

								MouseRecorder.updateRootInterface(var28.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
