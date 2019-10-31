import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bh")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1109035575
	)
	@Export("gameCyclesToDo")
	static int gameCyclesToDo;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lmz;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1458094845
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1936388269
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lij;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2053388584"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4436(var1) || this.archive.method4417(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "145350821"
	)
	public static boolean method1239(int var0) {
		return var0 == WorldMapDecorationType.field2723.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1915313873"
	)
	static int method1237(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 0) {
				var1 = 0;
			} else if (var1 > 127) {
				var1 = 127;
			}

			var1 = 127 - var1;
			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;I)V",
		garbageValue = "1291572583"
	)
	public static void method1235(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "49"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = class215.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - UserComparator8.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - HealthBar.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		Player.Client_plane = var2.plane = var4;
		if (Players.field1229[var1] != null) {
			var2.read(Players.field1229[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1227[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1227[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-561019342"
	)
	static int method1230(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)Lhi;",
		garbageValue = "-102"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = PacketBufferNode.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkc;II)Ljava/lang/String;",
		garbageValue = "1190041961"
	)
	static String method1234(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = class160.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)V",
		garbageValue = "2071952148"
	)
	static final void method1242(String var0, int var1) {
		PacketBufferNode var2 = SoundSystem.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.method5634(var1);
		Client.packetWriter.addNode(var2);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-79197837"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3128 != 0 && var3 > AbstractArchive.field3128) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 < 0 || AbstractArchive.field3128 != 0 && var6 > AbstractArchive.field3128) {
				throw new RuntimeException();
			} else {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			}
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "1460957872"
	)
	static int method1245(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WallDecoration.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					FontName.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ScriptEvent.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					ScriptEvent.clientPreferences.windowMode = var3;
					HitSplatDefinition.savePreferences();
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "-34"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		NetSocket.scrollBarSprites[0].drawAt(var0, var1);
		NetSocket.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field895);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field661);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field790);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field790);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field790);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field790);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field683);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field683);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field683);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field683);
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		signature = "([Lhi;IIIIIIII)V",
		garbageValue = "-954572124"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class195.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (WorldMapManager.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != ChatChannel.mousedOverWidgetIf1 && WorldMapManager.isComponentHidden(var9)) {
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
					Client.field695 = true;
					Client.field846 = var10;
					Client.field814 = var11;
				}

				boolean var32 = false;
				if (var9.field2606) {
					switch(Client.field828) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field794 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field794) {
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

								if (FloorDecoration.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									ClientPacket.addCancelMenuEntry();
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
							GrandExchangeOfferNameComparator.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						WorldMapIcon_1.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							Login.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								Login.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								class80.method2197(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2623.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2623[var20] != null) {
									for (var23 = 0; var23 < var9.field2623[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2627 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2623[var20][var23]];
										}

										if (Frames.method3400(var9.field2623[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2627 != null && var9.field2627[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2624[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										class287.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										InterfaceParent.Widget_runOnTargetLeave();
										class51.selectSpell(var9.id, var9.childIndex, UserComparator5.method3551(class195.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = SoundCache.method2666(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + AbstractArchive.colorStartTag(16777215);
									}

									var23 = var9.field2628[var20];
									if (var9.field2627 == null) {
										var9.field2627 = new int[var9.field2623.length];
									}

									if (var9.field2626 == null) {
										var9.field2626 = new int[var9.field2623.length];
									}

									if (var23 != 0) {
										if (var9.field2627[var20] == 0) {
											var9.field2627[var20] = var23 + Client.cycle + var9.field2626[var20];
										} else {
											var9.field2627[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2627[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2627 != null) {
									var9.field2627[var20] = 0;
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
							if ((MouseHandler.MouseHandler_currentButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								class4.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								Login.worldMap.method6429(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && TextureProvider.method2931(class195.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field809 = true;
								Client.field748 = var10;
								Client.field751 = var11;
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

								if (Client.clickedWidget != null || GrandExchangeOffer.dragInventoryWidget != null || Client.isMenuOpen) {
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
										Client.field832.addFirst(var29);
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
										Client.field832.addFirst(var29);
									}
								}

								if (var9.onTimer != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onTimer;
									Client.field813.addFirst(var29);
								}

								ScriptEvent var30;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field679 > var9.field2644) {
									if (var9.varTransmitTriggers != null && Client.field679 - var9.field2644 <= 32) {
										label886:
										for (var35 = var9.field2644; var35 < Client.field679; ++var35) {
											var23 = Client.field817[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var30);
													break label886;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2644 = Client.field679;
								}

								if (var9.onInvTransmit != null && Client.field820 > var9.field2567) {
									if (var9.invTransmitTriggers != null && Client.field820 - var9.field2567 <= 32) {
										label862:
										for (var35 = var9.field2567; var35 < Client.field820; ++var35) {
											var23 = Client.field816[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var30);
													break label862;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2567 = Client.field820;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2684) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2684 <= 32) {
										label838:
										for (var35 = var9.field2684; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var30);
													break label838;
												}
											}
										}
									} else {
										var29 = new ScriptEvent();
										var29.widget = var9;
										var29.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var29);
									}

									var9.field2684 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2681 && var9.onChatTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field824 > var9.field2681 && var9.onFriendTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field825 > var9.field2681 && var9.onClanTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field826 > var9.field2681 && var9.onStockTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field652 > var9.field2681 && var9.field2665 != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.field2665;
									Client.scriptEvents.addFirst(var29);
								}

								if (Client.field834 > var9.field2681 && var9.onMiscTransmit != null) {
									var29 = new ScriptEvent();
									var29.widget = var9;
									var29.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var29);
								}

								var9.field2681 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field866; ++var35) {
										ScriptEvent var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = Client.field854[var35];
										var31.keyPressed = Client.field853[var35];
										var31.args = var9.onKey;
										Client.scriptEvents.addFirst(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || GrandExchangeOffer.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									ChatChannel.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									ChatChannel.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								GrandExchangeEvents.field39 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								GrandExchangeOfferOwnWorldComparator.method1389(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
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

									if (FloorDecoration.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										ClientPacket.addCancelMenuEntry();
									}
								}

								ServerBuild.updateRootInterface(var27.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
