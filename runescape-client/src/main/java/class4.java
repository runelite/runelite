import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("v")
final class class4 implements class0 {
	@ObfuscatedName("po")
	@ObfuscatedSignature(
		signature = "Ljp;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	static IndexedSprite field23;
	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkc;B)V",
		garbageValue = "25"
	)
	public void vmethod89(Object var1, Buffer var2) {
		this.method85((String)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;I)Ljava/lang/Object;",
		garbageValue = "242985434"
	)
	public Object vmethod74(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkc;B)V",
		garbageValue = "0"
	)
	void method85(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lbi;II)V",
		garbageValue = "-2040444199"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (PlayerAppearance.isWorldMapEvent(var0.type)) {
			WorldMapSprite.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = class65.WorldMapElement_get(WorldMapSprite.worldMapEvent.mapElement);
			var3 = WorldMapIcon_1.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = GrandExchangeOffer.getScript(var17);
		}

		if (var3 != null) {
			Interpreter.Interpreter_intStackSize = 0;
			WorldMapDecoration.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1075 = false;

			try {
				int var10;
				try {
					World.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					Interpreter.Interpreter_stringLocals = new String[var3.localStringCount];
					int var9 = 0;

					int var11;
					String var18;
					for (var10 = 1; var10 < var2.length; ++var10) {
						if (var2[var10] instanceof Integer) {
							var11 = (Integer)var2[var10];
							if (var11 == -2147483647) {
								var11 = var0.mouseX;
							}

							if (var11 == -2147483646) {
								var11 = var0.mouseY;
							}

							if (var11 == -2147483645) {
								var11 = var0.widget != null ? var0.widget.id : -1;
							}

							if (var11 == -2147483644) {
								var11 = var0.opIndex;
							}

							if (var11 == -2147483643) {
								var11 = var0.widget != null ? var0.widget.childIndex : -1;
							}

							if (var11 == -2147483642) {
								var11 = var0.dragTarget != null ? var0.dragTarget.id : -1;
							}

							if (var11 == -2147483641) {
								var11 = var0.dragTarget != null ? var0.dragTarget.childIndex : -1;
							}

							if (var11 == -2147483640) {
								var11 = var0.keyTyped;
							}

							if (var11 == -2147483639) {
								var11 = var0.keyPressed;
							}

							World.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							Interpreter.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1080 = var0.field550;

					while (true) {
						++var10;
						if (var10 > var1) {
							throw new RuntimeException();
						}

						++var17;
						int var29 = var5[var17];
						int var20;
						if (var29 >= 100) {
							boolean var32;
							if (var3.intOperands[var17] == 1) {
								var32 = true;
							} else {
								var32 = false;
							}

							var20 = ScriptFrame.method1218(var29, var3, var32);
							switch(var20) {
							case 0:
								return;
							case 1:
							default:
								break;
							case 2:
								throw new IllegalStateException();
							}
						} else if (var29 == ScriptOpcodes.ICONST) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							WorldMapDecoration.changeGameOptions(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.RETURN) {
							if (Interpreter.Interpreter_frameDepth == 0) {
								return;
							}

							ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
							var3 = var34.script;
							var5 = var3.opcodes;
							var6 = var3.intOperands;
							var17 = var34.pc;
							World.Interpreter_intLocals = var34.intLocals;
							Interpreter.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator9.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							Message.method1299(var11, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = World.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							World.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							Interpreter.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							WorldMapDecoration.Interpreter_stringStackSize -= var11;
							String var31 = WorldMapDecorationType.method4270(Interpreter.Interpreter_stringStack, WorldMapDecoration.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--Interpreter.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--WorldMapDecoration.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class1.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									class1.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var21 < 0 || var21 > 5000) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrayLengths[var11] = var21;
									byte var22 = -1;
									if (var20 == 105) {
										var22 = 0;
									}

									for (var15 = 0; var15 < var21; ++var15) {
										Interpreter.Interpreter_arrays[var11][var15] = var22;
									}
								} else if (var29 == ScriptOpcodes.GET_ARRAY_INT) {
									var11 = var6[var17];
									var20 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									Interpreter.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = class1.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									class1.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = class1.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									class1.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = GrandExchangeOffer.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (Interpreter.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (WorldMapDecoration.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								Interpreter.Interpreter_intStackSize -= var12.intArgumentCount;
								WorldMapDecoration.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = World.Interpreter_intLocals;
								var19.stringLocals = Interpreter.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								World.Interpreter_intLocals = var13;
								Interpreter.Interpreter_stringLocals = var14;
							}
						}
					}
				} catch (Exception var27) {
					StringBuilder var24 = new StringBuilder(30);
					var24.append("").append(var3.key).append(" ");

					for (var10 = Interpreter.Interpreter_frameDepth - 1; var10 >= 0; --var10) {
						var24.append("").append(Interpreter.Interpreter_frames[var10].script.key).append(" ");
					}

					var24.append("").append(var7);
					User.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1075) {
					Interpreter.field1076 = true;
					Skills.method4271();
					Interpreter.field1076 = false;
					Interpreter.field1075 = false;
				}

			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;I)Ljava/lang/String;",
		garbageValue = "-1998352105"
	)
	public static String method90(Buffer var0) {
		return ArchiveLoader.method1234(var0, 32767);
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-230464245"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[Player.Client_plane][var0][var1];
		if (var2 == null) {
			WorldMapArea.scene.removeGroundItemPile(Player.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = class222.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= (long)(var6.quantity + 1);
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				WorldMapArea.scene.removeGroundItemPile(Player.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = class160.calculateTag(var0, var1, 3, false, 0);
				WorldMapArea.scene.newGroundItemPile(Player.Client_plane, var0, var1, GraphicsObject.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, Player.Client_plane), var5, var9, var12, var11);
			}
		}
	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(Lhi;IB)I",
		garbageValue = "0"
	)
	static final int method73(Widget var0, int var1) {
		if (var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
			try {
				int[] var2 = var0.cs1Instructions[var1];
				int var3 = 0;
				int var4 = 0;
				byte var5 = 0;

				while (true) {
					int var6 = var2[var4++];
					int var7 = 0;
					byte var8 = 0;
					if (var6 == 0) {
						return var3;
					}

					if (var6 == 1) {
						var7 = Client.currentLevels[var2[var4++]];
					}

					if (var6 == 2) {
						var7 = Client.levels[var2[var4++]];
					}

					if (var6 == 3) {
						var7 = Client.experience[var2[var4++]];
					}

					int var9;
					Widget var10;
					int var11;
					int var12;
					if (var6 == 4) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = PacketBufferNode.getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!class222.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 += var10.itemQuantities[var12];
								}
							}
						}
					}

					if (var6 == 5) {
						var7 = Varps.Varps_main[var2[var4++]];
					}

					if (var6 == 6) {
						var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
					}

					if (var6 == 7) {
						var7 = Varps.Varps_main[var2[var4++]] * 100 / 46875;
					}

					if (var6 == 8) {
						var7 = class215.localPlayer.combatLevel;
					}

					if (var6 == 9) {
						for (var9 = 0; var9 < 25; ++var9) {
							if (Skills.Skills_enabled[var9]) {
								var7 += Client.levels[var9];
							}
						}
					}

					if (var6 == 10) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = PacketBufferNode.getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!class222.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 = 999999999;
									break;
								}
							}
						}
					}

					if (var6 == 11) {
						var7 = Client.runEnergy;
					}

					if (var6 == 12) {
						var7 = Client.weight;
					}

					if (var6 == 13) {
						var9 = Varps.Varps_main[var2[var4++]];
						int var13 = var2[var4++];
						var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
					}

					if (var6 == 14) {
						var9 = var2[var4++];
						var7 = UserComparator9.getVarbit(var9);
					}

					if (var6 == 15) {
						var8 = 1;
					}

					if (var6 == 16) {
						var8 = 2;
					}

					if (var6 == 17) {
						var8 = 3;
					}

					if (var6 == 18) {
						var7 = UserComparator8.baseX * 64 + (class215.localPlayer.x >> 7);
					}

					if (var6 == 19) {
						var7 = HealthBar.baseY * 64 + (class215.localPlayer.y >> 7);
					}

					if (var6 == 20) {
						var7 = var2[var4++];
					}

					if (var8 == 0) {
						if (var5 == 0) {
							var3 += var7;
						}

						if (var5 == 1) {
							var3 -= var7;
						}

						if (var5 == 2 && var7 != 0) {
							var3 /= var7;
						}

						if (var5 == 3) {
							var3 *= var7;
						}

						var5 = 0;
					} else {
						var5 = var8;
					}
				}
			} catch (Exception var14) {
				return -1;
			}
		} else {
			return -2;
		}
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(Lhi;III)V",
		garbageValue = "-879504077"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && class30.method604(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = class30.method604(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				FloorDecoration.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var3 = class16.getNewestMenuIdx();
				if (var3 != -1) {
					Script.method2384(var3);
				}

			}
		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(Lhi;IIII)V",
		garbageValue = "1498154785"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		ChatChannel.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = class215.localPlayer.x / 32 + 48;
				int var7 = 464 - class215.localPlayer.y / 32;
				FloorDecoration.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - class215.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - class215.localPlayer.y / 32;
					Message.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[Player.Client_plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - class215.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - class215.localPlayer.y / 32;
							Message.drawSpriteOnMinimap(var1, var2, var11, var12, class42.mapDotSprites[0], var4);
						}
					}
				}

				for (var8 = 0; var8 < Client.npcCount; ++var8) {
					NPC var16 = Client.npcs[Client.npcIndices[var8]];
					if (var16 != null && var16.isVisible()) {
						NPCDefinition var18 = var16.definition;
						if (var18 != null && var18.transforms != null) {
							var18 = var18.transform();
						}

						if (var18 != null && var18.drawMapDot && var18.isInteractable) {
							var11 = var16.x / 32 - class215.localPlayer.x / 32;
							var12 = var16.y / 32 - class215.localPlayer.y / 32;
							Message.drawSpriteOnMinimap(var1, var2, var11, var12, class42.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != class215.localPlayer) {
						var12 = var17.x / 32 - class215.localPlayer.x / 32;
						int var13 = var17.y / 32 - class215.localPlayer.y / 32;
						boolean var14 = false;
						if (class215.localPlayer.team != 0 && var17.team != 0 && var17.team == class215.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							Message.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[3], var4);
						} else if (var14) {
							Message.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							Message.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[5], var4);
						} else {
							Message.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - class215.localPlayer.x / 32;
							var12 = var20.y / 32 - class215.localPlayer.y / 32;
							WorldMapManager.worldToMinimap(var1, var2, var11, var12, GrandExchangeOfferOwnWorldComparator.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - UserComparator8.baseX * 256 + 2 - class215.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - HealthBar.baseY * 256 + 2 - class215.localPlayer.y / 32;
						WorldMapManager.worldToMinimap(var1, var2, var10, var11, GrandExchangeOfferOwnWorldComparator.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - class215.localPlayer.x / 32;
							var12 = var21.y / 32 - class215.localPlayer.y / 32;
							WorldMapManager.worldToMinimap(var1, var2, var11, var12, GrandExchangeOfferOwnWorldComparator.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - class215.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - class215.localPlayer.y / 32;
					Message.drawSpriteOnMinimap(var1, var2, var10, var11, GrandExchangeOfferOwnWorldComparator.mapMarkerSprites[0], var4);
				}

				if (!class215.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field837[var3] = true;
		}
	}
}
