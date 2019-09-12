import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eo")
@Implements("ModelData0")
public class ModelData0 {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -80152223
	)
	public static int field1833;
	@ObfuscatedName("lv")
	@ObfuscatedGetter(
		intValue = 1005444901
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;

	ModelData0() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1253284688"
	)
	static int method3221(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		if (var0 == ScriptOpcodes.CC_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTEXT) {
			Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "44"
	)
	static int method3219(int var0, Script var1, boolean var2) {
		Widget var3 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (ClientPreferences.pcmPlayer1 != null) {
			ClientPreferences.pcmPlayer1.run();
		}

		if (WorldMapIcon_1.pcmPlayer0 != null) {
			WorldMapIcon_1.pcmPlayer0.run();
		}

	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "353830109"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			FontName.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < WorldMapSection2.method300(); ++var8) {
			long var9 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var9 != var6) {
				var6 = var9;
				long var15 = ViewportMouse.ViewportMouse_entityTags[var8];
				int var14 = (int)(var15 >>> 0 & 127L);
				var14 = var14;
				int var28 = Language.ViewportMouse_unpackX(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var16 = var28;
				int var17 = UserComparator2.ViewportMouse_unpackY(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var19 = SecureRandomFuture.method2101(var8);
				if (var17 == 2 && WorldMapIcon_1.scene.getObjectFlags(MouseRecorder.plane, var14, var28, var9) >= 0) {
					ObjectDefinition var20 = WallDecoration.getObjectDefinition(var19);
					if (var20.transforms != null) {
						var20 = var20.transform();
					}

					if (var20 == null) {
						continue;
					}

					if (Client.isItemSelected == 1) {
						FontName.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + UserComparator7.colorStartTag(65535) + var20.name, 1, var19, var14, var28);
					} else if (Client.isSpellSelected) {
						if ((BuddyRankComparator.selectedSpellFlags & 4) == 4) {
							FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + UserComparator7.colorStartTag(65535) + var20.name, 2, var19, var14, var28);
						}
					} else {
						String[] var29 = var20.actions;
						if (var29 != null) {
							for (int var30 = 4; var30 >= 0; --var30) {
								if (var29[var30] != null) {
									short var23 = 0;
									if (var30 == 0) {
										var23 = 3;
									}

									if (var30 == 1) {
										var23 = 4;
									}

									if (var30 == 2) {
										var23 = 5;
									}

									if (var30 == 3) {
										var23 = 6;
									}

									if (var30 == 4) {
										var23 = 1001;
									}

									FontName.insertMenuItemNoShift(var29[var30], UserComparator7.colorStartTag(65535) + var20.name, var23, var19, var14, var16);
								}
							}
						}

						FontName.insertMenuItemNoShift("Examine", UserComparator7.colorStartTag(65535) + var20.name, 1002, var20.id, var14, var16);
					}
				}

				int var21;
				NPC var22;
				Player var24;
				int[] var36;
				int var38;
				if (var17 == 1) {
					NPC var33 = Client.npcs[var19];
					if (var33 == null) {
						continue;
					}

					if (var33.definition.size == 1 && (var33.x * -78439701 & 127) == 64 && (var33.y & 127) == 64) {
						for (var21 = 0; var21 < Client.npcCount; ++var21) {
							var22 = Client.npcs[Client.npcIndices[var21]];
							if (var22 != null && var22 != var33 && var22.definition.size == 1 && var33.x * -78439701 == var22.x * -78439701 && var33.y == var22.y) {
								InterfaceParent.addNpcToMenu(var22.definition, Client.npcIndices[var21], var14, var16);
							}
						}

						var21 = Players.Players_count;
						var36 = Players.Players_indices;

						for (var38 = 0; var38 < var21; ++var38) {
							var24 = Client.players[var36[var38]];
							if (var24 != null && var24.x * -78439701 == var33.x * -78439701 && var24.y == var33.y) {
								NetFileRequest.addPlayerToMenu(var24, var36[var38], var14, var16);
							}
						}
					}

					InterfaceParent.addNpcToMenu(var33.definition, var19, var14, var16);
				}

				if (var17 == 0) {
					Player var34 = Client.players[var19];
					if (var34 == null) {
						continue;
					}

					if ((var34.x * -78439701 & 127) == 64 && (var34.y & 127) == 64) {
						for (var21 = 0; var21 < Client.npcCount; ++var21) {
							var22 = Client.npcs[Client.npcIndices[var21]];
							if (var22 != null && var22.definition.size == 1 && var34.x * -78439701 == var22.x * -78439701 && var34.y == var22.y) {
								InterfaceParent.addNpcToMenu(var22.definition, Client.npcIndices[var21], var14, var16);
							}
						}

						var21 = Players.Players_count;
						var36 = Players.Players_indices;

						for (var38 = 0; var38 < var21; ++var38) {
							var24 = Client.players[var36[var38]];
							if (var24 != null && var24 != var34 && var34.x * -78439701 == var24.x * -78439701 && var34.y == var24.y) {
								NetFileRequest.addPlayerToMenu(var24, var36[var38], var14, var16);
							}
						}
					}

					if (var19 != Client.combatTargetPlayerIndex) {
						NetFileRequest.addPlayerToMenu(var34, var19, var14, var16);
					} else {
						var4 = var9;
					}
				}

				if (var17 == 3) {
					NodeDeque var35 = Client.groundItems[MouseRecorder.plane][var14][var16];
					if (var35 != null) {
						for (TileItem var39 = (TileItem)var35.first(); var39 != null; var39 = (TileItem)var35.next()) {
							ItemDefinition var37 = Player.ItemDefinition_get(var39.id);
							if (Client.isItemSelected == 1) {
								FontName.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + UserComparator7.colorStartTag(16748608) + var37.name, 16, var39.id, var14, var16);
							} else if (Client.isSpellSelected) {
								if ((BuddyRankComparator.selectedSpellFlags & 1) == 1) {
									FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + UserComparator7.colorStartTag(16748608) + var37.name, 17, var39.id, var14, var16);
								}
							} else {
								String[] var31 = var37.groundActions;

								for (int var32 = 4; var32 >= 0; --var32) {
									if (var31 != null && var31[var32] != null) {
										byte var25 = 0;
										if (var32 == 0) {
											var25 = 18;
										}

										if (var32 == 1) {
											var25 = 19;
										}

										if (var32 == 2) {
											var25 = 20;
										}

										if (var32 == 3) {
											var25 = 21;
										}

										if (var32 == 4) {
											var25 = 22;
										}

										FontName.insertMenuItemNoShift(var31[var32], UserComparator7.colorStartTag(16748608) + var37.name, var25, var39.id, var14, var16);
									} else if (var32 == 2) {
										FontName.insertMenuItemNoShift("Take", UserComparator7.colorStartTag(16748608) + var37.name, 20, var39.id, var14, var16);
									}
								}

								FontName.insertMenuItemNoShift("Examine", UserComparator7.colorStartTag(16748608) + var37.name, 1004, var39.id, var14, var16);
							}
						}
					}
				}
			}
		}

		if (var4 != -1L) {
			var8 = (int)(var4 >>> 0 & 127L);
			int var10 = Language.ViewportMouse_unpackX(var4);
			Player var27 = Client.players[Client.combatTargetPlayerIndex];
			NetFileRequest.addPlayerToMenu(var27, Client.combatTargetPlayerIndex, var8, var10);
		}

	}
}
