import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("da")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("c")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1731432655
	)
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 2096475085
	)
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("e")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1611746101
	)
	static int field1729;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -684242185
	)
	static int field1731;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -658996083
	)
	static int field1736;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1011039225
	)
	static int field1733;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1153902533
	)
	static int field1742;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1095575825
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("x")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("t")
	static double method3061(double var0, double var2, double var4) {
		return TileItemPile.method2836((var0 - var2) / var4) / var4;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1872781717"
	)
	public static int method3059(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var1;
		} else if (var2 == 1) {
			return 7 - var0;
		} else {
			return var2 == 2 ? 7 - var1 : var0;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1104105387"
	)
	@Export("Login_promptCredentials")
	static void Login_promptCredentials(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (WorldMapSection2.clientPreferences.rememberedUsername != null) {
				Login.Login_username = WorldMapSection2.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		class81.method2099();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1906637930"
	)
	static int method3037(int var0, Script var1, boolean var2) {
		Widget var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTEXT) {
			Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(Lhn;IIS)V",
		garbageValue = "-7160"
	)
	static final void method3060(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			GraphicsObject.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = PcmPlayer.method2542(var0);
			if (var3 != null) {
				GraphicsObject.insertMenuItemNoShift(var3, PacketWriter.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			GraphicsObject.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			GraphicsObject.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			GraphicsObject.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			GraphicsObject.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var13;
		if (var0.type == 2) {
			var13 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (int var5 = 0; var5 < var0.width; ++var5) {
					int var6 = (var0.paddingX + 32) * var5;
					int var7 = (var0.paddingY + 32) * var4;
					if (var13 < 20) {
						var6 += var0.inventoryXOffsets[var13];
						var7 += var0.inventoryYOffsets[var13];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var13;
						FloorDecoration.field1604 = var0;
						if (var0.itemIds[var13] > 0) {
							ItemDefinition var8 = HealthBarDefinition.ItemDefinition_get(var0.itemIds[var13] - 1);
							if (Client.isItemSelected == 1 && WorldMapManager.method673(WorldMapIcon_0.getWidgetClickMask(var0))) {
								if (var0.id != FriendSystem.selectedItemWidget || var13 != class65.selectedItemSlot) {
									GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + PacketWriter.colorStartTag(16748608) + var8.name, 31, var8.id, var13, var0.id);
								}
							} else if (Client.isSpellSelected && WorldMapManager.method673(WorldMapIcon_0.getWidgetClickMask(var0))) {
								if ((NetSocket.selectedSpellFlags & 16) == 16) {
									GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + PacketWriter.colorStartTag(16748608) + var8.name, 32, var8.id, var13, var0.id);
								}
							} else {
								String[] var9 = var8.inventoryActions;
								int var10 = -1;
								if (Client.shiftClickDrop && Players.method2201()) {
									var10 = var8.getShiftClickIndex();
								}

								int var11;
								if (WorldMapManager.method673(WorldMapIcon_0.getWidgetClickMask(var0))) {
									for (var11 = 4; var11 >= 3; --var11) {
										if (var10 != var11) {
											GrandExchangeEvents.addWidgetItemMenuItem(var0, var8, var13, var11, false);
										}
									}
								}

								if (class268.method5042(WorldMapIcon_0.getWidgetClickMask(var0))) {
									GraphicsObject.insertMenuItemNoShift("Use", PacketWriter.colorStartTag(16748608) + var8.name, 38, var8.id, var13, var0.id);
								}

								if (WorldMapManager.method673(WorldMapIcon_0.getWidgetClickMask(var0))) {
									for (var11 = 2; var11 >= 0; --var11) {
										if (var11 != var10) {
											GrandExchangeEvents.addWidgetItemMenuItem(var0, var8, var13, var11, false);
										}
									}

									if (var10 >= 0) {
										GrandExchangeEvents.addWidgetItemMenuItem(var0, var8, var13, var10, true);
									}
								}

								var9 = var0.itemActions;
								if (var9 != null) {
									for (var11 = 4; var11 >= 0; --var11) {
										if (var9[var11] != null) {
											byte var12 = 0;
											if (var11 == 0) {
												var12 = 39;
											}

											if (var11 == 1) {
												var12 = 40;
											}

											if (var11 == 2) {
												var12 = 41;
											}

											if (var11 == 3) {
												var12 = 42;
											}

											if (var11 == 4) {
												var12 = 43;
											}

											GraphicsObject.insertMenuItemNoShift(var9[var11], PacketWriter.colorStartTag(16748608) + var8.name, var12, var8.id, var13, var0.id);
										}
									}
								}

								GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(16748608) + var8.name, 1005, var8.id, var13, var0.id);
							}
						}
					}

					++var13;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				if (NPC.method2088(WorldMapIcon_0.getWidgetClickMask(var0)) && (NetSocket.selectedSpellFlags & 32) == 32) {
					GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var13 = 9; var13 >= 5; --var13) {
					String var14 = class80.method2098(var0, var13);
					if (var14 != null) {
						GraphicsObject.insertMenuItemNoShift(var14, var0.dataText, 1007, var13 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = PcmPlayer.method2542(var0);
				if (var3 != null) {
					GraphicsObject.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					String var15 = class80.method2098(var0, var4);
					if (var15 != null) {
						class160.insertMenuItem(var15, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2713);
					}
				}

				if (AttackOption.method2117(WorldMapIcon_0.getWidgetClickMask(var0))) {
					GraphicsObject.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}
