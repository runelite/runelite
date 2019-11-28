import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -614413985
	)
	@Export("SpriteBuffer_spriteHeight")
	static int SpriteBuffer_spriteHeight;
	@ObfuscatedName("al")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("u")
	@Export("reversed")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;B)I",
		garbageValue = "-1"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkn;ZB)V",
		garbageValue = "-115"
	)
	public static void method3436(AbstractSocket var0, boolean var1) {
		if (NetCache.NetCache_socket != null) {
			try {
				NetCache.NetCache_socket.close();
			} catch (Exception var8) {
			}

			NetCache.NetCache_socket = null;
		}

		NetCache.NetCache_socket = var0;
		Buffer var2;
		if (NetCache.NetCache_socket != null) {
			try {
				var2 = new Buffer(4);
				var2.writeByte(var1 ? 2 : 3);
				var2.writeMedium(0);
				NetCache.NetCache_socket.write(var2.array, 0, 4);
			} catch (IOException var7) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var6) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
			}
		}

		NetCache.NetCache_responseHeaderBuffer.offset = 0;
		NetCache.NetCache_currentResponse = null;
		class32.NetCache_responseArchiveBuffer = null;
		NetCache.field3188 = 0;

		while (true) {
			NetFileRequest var9 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
			if (var9 == null) {
				while (true) {
					var9 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
					if (var9 == null) {
						if (NetCache.field3184 != 0) {
							try {
								var2 = new Buffer(4);
								var2.writeByte(4);
								var2.writeByte(NetCache.field3184);
								var2.writeShort(0);
								NetCache.NetCache_socket.write(var2.array, 0, 4);
							} catch (IOException var5) {
								try {
									NetCache.NetCache_socket.close();
								} catch (Exception var4) {
								}

								++NetCache.NetCache_ioExceptions;
								NetCache.NetCache_socket = null;
							}
						}

						NetCache.NetCache_loadTime = 0;
						NetCache.field3171 = TaskHandler.currentTimeMillis();
						return;
					}

					NetCache.NetCache_pendingWritesQueue.addLast(var9);
					NetCache.NetCache_pendingWrites.put(var9, var9.key);
					++NetCache.NetCache_pendingWritesCount;
					--NetCache.NetCache_pendingResponsesCount;
				}
			}

			NetCache.NetCache_pendingPriorityWrites.put(var9, var9.key);
			++NetCache.NetCache_pendingPriorityWritesCount;
			--NetCache.NetCache_pendingPriorityResponsesCount;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1705481710"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "33"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (UserComparator3.loadInterface(var0)) {
				Widget[] var1 = FloorDecoration.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						GrandExchangeOfferNameComparator.runScript(var4, 5000000);
					}
				}

			}
		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "([Lhl;IIIIIIIB)V",
		garbageValue = "-75"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || MenuAction.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (AbstractByteArrayCopier.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != class185.mousedOverWidgetIf1 && AbstractByteArrayCopier.isComponentHidden(var9)) {
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
					Client.field823 = true;
					Client.field808 = var10;
					Client.field825 = var11;
				}

				boolean var32 = false;
				if (var9.field2651) {
					switch(Client.field804) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field805 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field805) {
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

								if (class3.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									class2.addCancelMenuEntry();
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
							Varcs.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						UrlRequester.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							WorldMapRegion.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								WorldMapRegion.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								PlayerAppearance.method4079(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2592.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2592[var20] != null) {
									for (var23 = 0; var23 < var9.field2592[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2695 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2592[var20][var23]];
										}

										if (UserComparator3.method3476(var9.field2592[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2695 != null && var9.field2695[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2653[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										WorldMapData_1.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										Actor.Widget_runOnTargetLeave();
										TextureProvider.selectSpell(var9.id, var9.childIndex, Client.method1655(MenuAction.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = LoginPacket.method3662(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + class222.colorStartTag(16777215);
									}

									var23 = var9.field2654[var20];
									if (var9.field2695 == null) {
										var9.field2695 = new int[var9.field2592.length];
									}

									if (var9.field2655 == null) {
										var9.field2655 = new int[var9.field2592.length];
									}

									if (var23 != 0) {
										if (var9.field2695[var20] == 0) {
											var9.field2695[var20] = var23 + Client.cycle + var9.field2655[var20];
										} else {
											var9.field2695[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2695[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2695 != null) {
									var9.field2695[var20] = 0;
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
							if ((MouseHandler.MouseHandler_currentButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								UserComparator3.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								WorldMapRegion.worldMap.method6378(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && WorldMapData_0.method192(MenuAction.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field820 = true;
								Client.field698 = var10;
								Client.field822 = var11;
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

								if (Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
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
										Client.field843.addFirst(var29);
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
										Client.field843.addFirst(var29);
									}
								}

								if (var9.onTimer != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onTimer;
									Client.field900.addFirst(var29);
								}

								ScriptEvent var30;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field829 > var9.field2652) {
									if (var9.varTransmitTriggers != null && Client.field829 - var9.field2652 <= 32) {
										label880:
										for (var35 = var9.field2652; var35 < Client.field829; ++var35) {
											var23 = Client.field828[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var30);
													break label880;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2652 = Client.field829;
								}

								if (var9.onInvTransmit != null && Client.field898 > var9.field2585) {
									if (var9.invTransmitTriggers != null && Client.field898 - var9.field2585 <= 32) {
										label856:
										for (var35 = var9.field2585; var35 < Client.field898; ++var35) {
											var23 = Client.changedItemContainers[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var30);
													break label856;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2585 = Client.field898;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2565) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2565 <= 32) {
										label832:
										for (var35 = var9.field2565; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var30);
													break label832;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2565 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2631 && var9.onChatTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field833 > var9.field2631 && var9.onFriendTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field836 > var9.field2631 && var9.onClanTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field645 > var9.field2631 && var9.onStockTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field734 > var9.field2631 && var9.field2689 != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.field2689;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field834 > var9.field2631 && var9.onMiscTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								var9.field2631 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field889; ++var35) {
										ScriptEvent var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = Client.field865[var35];
										var31.keyPressed = Client.field864[var35];
										var31.args = var9.onKey;
										Client.scriptEvents.addFirst(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									class185.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									class185.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								GrandExchangeOfferWorldComparator.field31 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								GrandExchangeEvents.method82(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
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

									if (class3.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										class2.addCancelMenuEntry();
									}
								}

								Script.updateRootInterface(var27.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
