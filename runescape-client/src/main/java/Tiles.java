import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("c")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("x")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -103165029
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("g")
	static byte[][][] field476;
	@ObfuscatedName("u")
	static byte[][][] field477;
	@ObfuscatedName("v")
	static byte[][][] field473;
	@ObfuscatedName("s")
	static int[] field488;
	@ObfuscatedName("y")
	static final int[] field480;
	@ObfuscatedName("r")
	static final int[] field481;
	@ObfuscatedName("k")
	static final int[] field482;
	@ObfuscatedName("w")
	static final int[] field487;
	@ObfuscatedName("m")
	static final int[] field484;
	@ObfuscatedName("o")
	static final int[] field485;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1299931197
	)
	static int field483;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 420970565
	)
	static int field486;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field480 = new int[]{1, 2, 4, 8};
		field481 = new int[]{16, 32, 64, 128};
		field482 = new int[]{1, 0, -1, 0};
		field487 = new int[]{0, -1, 0, 1};
		field484 = new int[]{1, -1, -1, 1};
		field485 = new int[]{-1, -1, 1, 1};
		field483 = (int)(Math.random() * 17.0D) - 8;
		field486 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Lcu;",
		garbageValue = "946612961"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Message.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = AttackOption.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "361955202"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			Actor.clientPreferences.roofsHidden = !Actor.clientPreferences.roofsHidden;
			class296.savePreferences();
			if (Actor.clientPreferences.roofsHidden) {
				WorldMapCacheName.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				WorldMapCacheName.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			Client.displayFps = !Client.displayFps;
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				GrandExchangeOfferUnitPriceComparator.worldMap.showCoord = !GrandExchangeOfferUnitPriceComparator.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				Client.displayFps = true;
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				Client.displayFps = false;
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				class185.method3607();
			}
		}

		PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(var0.length() + 1);
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIII)V",
		garbageValue = "1821175447"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			class16.method164(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field911 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "([Lhy;IIIIIIII)V",
		garbageValue = "1552145390"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class60.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (NetCache.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != class32.mousedOverWidgetIf1 && NetCache.isComponentHidden(var9)) {
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
					Client.field803 = true;
					Client.field804 = var10;
					Client.field699 = var11;
				}

				boolean var32 = false;
				if (var9.field2612) {
					switch(Client.field784) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field785 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field785) {
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

								if (ArchiveLoader.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									GraphicsObject.addCancelMenuEntry();
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
							ModelData0.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						class223.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							GrandExchangeOfferUnitPriceComparator.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								GrandExchangeOfferUnitPriceComparator.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								WorldMapSection0.method217(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2671.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2671[var20] != null) {
									for (var23 = 0; var23 < var9.field2671[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2656 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2671[var20][var23]];
										}

										if (WorldMapSection0.method216(var9.field2671[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2656 != null && var9.field2656[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2614[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										TileItem.method2093(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										FloorDecoration.Widget_runOnTargetLeave();
										Player.selectSpell(var9.id, var9.childIndex, WorldMapElement.method4390(class60.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = class16.method165(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + UserComparator7.colorStartTag(16777215);
									}

									var23 = var9.field2615[var20];
									if (var9.field2656 == null) {
										var9.field2656 = new int[var9.field2671.length];
									}

									if (var9.field2616 == null) {
										var9.field2616 = new int[var9.field2671.length];
									}

									if (var23 != 0) {
										if (var9.field2656[var20] == 0) {
											var9.field2656[var20] = var23 + Client.cycle + var9.field2616[var20];
										} else {
											var9.field2656[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2656[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2656 != null) {
									var9.field2656[var20] = 0;
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
							if ((MouseHandler.MouseHandler_currentButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								class83.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								GrandExchangeOfferUnitPriceComparator.worldMap.method6284(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && class222.method4101(class60.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field800 = true;
								Client.field801 = var10;
								Client.field706 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var29;
								if (var33 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var29 = new ScriptEvent();
									var29.isMouseInputEvent = true;
									var29.widget = var9;
									var29.mouseY = Client.mouseWheelRotation;
									var29.args = var9.onScroll;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.clickedWidget != null || class4.dragInventoryWidget != null || Client.isMenuOpen) {
									var21 = false;
									var34 = false;
									var33 = false;
								}

								if (!var9.isClicked && var21) {
									var9.isClicked = true;
									if (var9.onClick != null) {
										var29 = new ScriptEvent();
										var29.isMouseInputEvent = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
										var29.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var29.args = var9.onClick;
										Client.scriptEvents.addFirst(var29);
									}
								}

								if (var9.isClicked && var34 && var9.onClickRepeat != null) {
									var29 = new ScriptEvent();
									var29.isMouseInputEvent = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var29);
								}

								if (var9.isClicked && !var34) {
									var9.isClicked = false;
									if (var9.onRelease != null) {
										var29 = new ScriptEvent();
										var29.isMouseInputEvent = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onRelease;
										Client.field823.addFirst(var29);
									}
								}

								if (var34 && var9.onHold != null) {
									var29 = new ScriptEvent();
									var29.isMouseInputEvent = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onHold;
									Client.scriptEvents.addFirst(var29);
								}

								if (!var9.containsMouse && var33) {
									var9.containsMouse = true;
									if (var9.onMouseOver != null) {
										var29 = new ScriptEvent();
										var29.isMouseInputEvent = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var29);
									}
								}

								if (var9.containsMouse && var33 && var9.onMouseRepeat != null) {
									var29 = new ScriptEvent();
									var29.isMouseInputEvent = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var29);
								}

								if (var9.containsMouse && !var33) {
									var9.containsMouse = false;
									if (var9.onMouseLeave != null) {
										var29 = new ScriptEvent();
										var29.isMouseInputEvent = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onMouseLeave;
										Client.field823.addFirst(var29);
									}
								}

								if (var9.onTimer != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onTimer;
									Client.field822.addFirst(var29);
								}

								ScriptEvent var30;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field809 > var9.field2672) {
									if (var9.varTransmitTriggers != null && Client.field809 - var9.field2672 <= 32) {
										label900:
										for (var35 = var9.field2672; var35 < Client.field809; ++var35) {
											var23 = Client.field808[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var30);
													break label900;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2672 = Client.field809;
								}

								if (var9.onInvTransmit != null && Client.field811 > var9.field2673) {
									if (var9.invTransmitTriggers != null && Client.field811 - var9.field2673 <= 32) {
										label876:
										for (var35 = var9.field2673; var35 < Client.field811; ++var35) {
											var23 = Client.field810[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var30);
													break label876;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2673 = Client.field811;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2674) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2674 <= 32) {
										label852:
										for (var35 = var9.field2674; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var30);
													break label852;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2674 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2529 && var9.onChatTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field815 > var9.field2529 && var9.onFriendTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field816 > var9.field2529 && var9.onClanTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field866 > var9.field2529 && var9.onStockTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field818 > var9.field2529 && var9.field2655 != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.field2655;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field670 > var9.field2529 && var9.onMiscTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								var9.field2529 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field844; ++var35) {
										ScriptEvent var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = Client.field846[var35];
										var31.keyPressed = Client.field845[var35];
										var31.args = var9.onKey;
										Client.scriptEvents.addFirst(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || class4.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									class32.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									class32.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								AbstractWorldMapIcon.field292 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								class1.method16(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var27 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var27 != null) {
								if (var27.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var28 = (ScriptEvent)Client.scriptEvents.last(); var28 != null; var28 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var28.isMouseInputEvent) {
											var28.remove();
											var28.widget.containsMouse = false;
										}
									}

									if (ArchiveLoader.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										GraphicsObject.addCancelMenuEntry();
									}
								}

								TextureProvider.updateRootInterface(var27.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
