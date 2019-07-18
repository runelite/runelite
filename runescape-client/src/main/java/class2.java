import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class2 implements class0 {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = -8967154126905967921L
	)
	static long field4;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive13")
	static Archive archive13;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkf;I)V",
		garbageValue = "1977897097"
	)
	public void vmethod43(Object var1, Buffer var2) {
		this.method19((Long)var1, var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)Ljava/lang/Object;",
		garbageValue = "-408972538"
	)
	public Object vmethod42(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkf;I)V",
		garbageValue = "-338982282"
	)
	void method19(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1315693887"
	)
	static int method27(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "1766587749"
	)
	public static int method18(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "([Lhj;IIIIIIIS)V",
		garbageValue = "29276"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class268.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (ScriptEvent.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != LoginScreenAnimation.mousedOverWidgetIf1 && ScriptEvent.isComponentHidden(var9)) {
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
					Client.field745 = true;
					Client.field837 = var10;
					Client.field838 = var11;
				}

				boolean var32 = false;
				if (var9.field2704) {
					switch(Client.field817) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field818 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field818) {
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
									if (var26.boolean1) {
										var26.remove();
										var26.widget.field2642 = false;
									}
								}

								if (class80.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									GraphicsObject.resetMenuEntries();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var26 = (ScriptEvent)Client.scriptEvents.last(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var26.boolean1 && var26.widget.onScroll == var26.args) {
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
							class65.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						WorldMapIcon_0.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							BoundaryObject.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								BoundaryObject.worldMap.method6482(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								class40.method703(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2650.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2650[var20] != null) {
									for (var23 = 0; var23 < var9.field2650[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2578 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2650[var20][var23]];
										}

										if (PacketWriter.method2244(var9.field2650[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2578 != null && var9.field2578[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2625[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										Messages.method2163(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										WorldMapID.method542();
										GroundItem.method2053(var9.id, var9.childIndex, HealthBar.method1957(class268.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = FontName.method5318(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + ClientPreferences.colorStartTag(16777215);
									}

									var23 = var9.field2641[var20];
									if (var9.field2578 == null) {
										var9.field2578 = new int[var9.field2650.length];
									}

									if (var9.field2588 == null) {
										var9.field2588 = new int[var9.field2650.length];
									}

									if (var23 != 0) {
										if (var9.field2578[var20] == 0) {
											var9.field2578[var20] = var23 + Client.cycle + var9.field2588[var20];
										} else {
											var9.field2578[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2578[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2578 != null) {
									var9.field2578[var20] = 0;
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
							if ((MouseHandler.MouseHandler_currentButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								class60.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								BoundaryObject.worldMap.method6301(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && WorldMapIcon_1.method295(class268.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field873 = true;
								Client.field834 = var10;
								Client.field835 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var29;
								if (var33 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var29 = new ScriptEvent();
									var29.boolean1 = true;
									var29.widget = var9;
									var29.mouseY = Client.mouseWheelRotation;
									var29.args = var9.onScroll;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.clickedWidget != null || WorldMapIcon_0.dragInventoryWidget != null || Client.isMenuOpen) {
									var21 = false;
									var34 = false;
									var33 = false;
								}

								if (!var9.field2589 && var21) {
									var9.field2589 = true;
									if (var9.onClick != null) {
										var29 = new ScriptEvent();
										var29.boolean1 = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
										var29.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var29.args = var9.onClick;
										Client.scriptEvents.addFirst(var29);
									}
								}

								if (var9.field2589 && var34 && var9.onClickRepeat != null) {
									var29 = new ScriptEvent();
									var29.boolean1 = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var29);
								}

								if (var9.field2589 && !var34) {
									var9.field2589 = false;
									if (var9.onRelease != null) {
										var29 = new ScriptEvent();
										var29.boolean1 = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onRelease;
										Client.field856.addFirst(var29);
									}
								}

								if (var34 && var9.onHold != null) {
									var29 = new ScriptEvent();
									var29.boolean1 = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onHold;
									Client.scriptEvents.addFirst(var29);
								}

								if (!var9.field2642 && var33) {
									var9.field2642 = true;
									if (var9.onMouseOver != null) {
										var29 = new ScriptEvent();
										var29.boolean1 = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var29);
									}
								}

								if (var9.field2642 && var33 && var9.onMouseRepeat != null) {
									var29 = new ScriptEvent();
									var29.boolean1 = true;
									var29.widget = var9;
									var29.mouseX = MouseHandler.MouseHandler_x - var10;
									var29.mouseY = MouseHandler.MouseHandler_y - var11;
									var29.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var29);
								}

								if (var9.field2642 && !var33) {
									var9.field2642 = false;
									if (var9.onMouseLeave != null) {
										var29 = new ScriptEvent();
										var29.boolean1 = true;
										var29.widget = var9;
										var29.mouseX = MouseHandler.MouseHandler_x - var10;
										var29.mouseY = MouseHandler.MouseHandler_y - var11;
										var29.args = var9.onMouseLeave;
										Client.field856.addFirst(var29);
									}
								}

								if (var9.onTimer != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onTimer;
									Client.field852.addFirst(var29);
								}

								ScriptEvent var31;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field806 > var9.field2592) {
									if (var9.varTransmitTriggers != null && Client.field806 - var9.field2592 <= 32) {
										label865:
										for (var35 = var9.field2592; var35 < Client.field806; ++var35) {
											var23 = Client.field863[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var31 = new ScriptEvent();
													var31.widget = var9;
													var31.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var31);
													break label865;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2592 = Client.field806;
								}

								if (var9.onInvTransmit != null && Client.field671 > var9.field2603) {
									if (var9.invTransmitTriggers != null && Client.field671 - var9.field2603 <= 32) {
										label841:
										for (var35 = var9.field2603; var35 < Client.field671; ++var35) {
											var23 = Client.field888[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var31 = new ScriptEvent();
													var31.widget = var9;
													var31.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var31);
													break label841;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2603 = Client.field671;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2700) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2700 <= 32) {
										label817:
										for (var35 = var9.field2700; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var31 = new ScriptEvent();
													var31.widget = var9;
													var31.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var31);
													break label817;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2700 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2689 && var9.onChatTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field672 > var9.field2689 && var9.onFriendTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field849 > var9.field2689 && var9.onClanTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field915 > var9.field2689 && var9.onStockTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field851 > var9.field2689 && var9.field2681 != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.field2681;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field844 > var9.field2689 && var9.onMiscTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								var9.field2689 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field754; ++var35) {
										ScriptEvent var30 = new ScriptEvent();
										var30.widget = var9;
										var30.keyTyped = Client.field921[var35];
										var30.keyPressed = Client.field877[var35];
										var30.args = var9.onKey;
										Client.scriptEvents.addFirst(var30);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || WorldMapIcon_0.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									LoginScreenAnimation.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									LoginScreenAnimation.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								class32.field284 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								GrandExchangeEvents.method71(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
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
										if (var28.boolean1) {
											var28.remove();
											var28.widget.field2642 = false;
										}
									}

									if (class80.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										GraphicsObject.resetMenuEntries();
									}
								}

								Skills.updateRootInterface(var27.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-949997341"
	)
	static final void method28() {
		UserComparator10.method3405();
		if (DevicePcmPlayerProvider.clanChat != null) {
			DevicePcmPlayerProvider.clanChat.clearIgnoreds();
		}

	}
}
