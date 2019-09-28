import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ah")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("oc")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("mouseWheel")
	static MouseWheel mouseWheel;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lah;"
	)
	@Export("KeyHandler_instance")
	public static KeyHandler KeyHandler_instance;
	@ObfuscatedName("cy")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("cj")
	public static char field381;
	@ObfuscatedName("cr")
	public static int[] field365;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 1575072845
	)
	public static int field372;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -939573745
	)
	public static int field373;
	@ObfuscatedName("cu")
	static char[] field374;
	@ObfuscatedName("ce")
	static int[] field375;
	@ObfuscatedName("cc")
	public static int[] field376;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1675440071
	)
	public static int field361;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1686544141
	)
	public static int field378;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 900188775
	)
	public static int field371;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -1429227913
	)
	public static int field380;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -844580135
	)
	@Export("KeyHandler_idleCycles")
	public static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("cx")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field365 = new int[128];
		field372 = 0;
		field373 = 0;
		field374 = new char[128];
		field375 = new int[128];
		field376 = new int[128];
		field361 = 0;
		field378 = 0;
		field371 = 0;
		field380 = 0;
		KeyHandler_idleCycles = 0;
		KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	}

	KeyHandler() {
	}

	public final synchronized void keyReleased(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2] & -129;
			} else {
				var2 = -1;
			}

			if (field373 >= 0 && var2 >= 0) {
				field365[field373] = ~var2;
				field373 = field373 + 1 & 127;
				if (field373 == field372) {
					field373 = -1;
				}
			}
		}

		var1.consume();
	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field373 = -1;
		}

	}

	public final synchronized void keyPressed(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2];
				if ((var2 & 128) != 0) {
					var2 = -1;
				}
			} else {
				var2 = -1;
			}

			if (field373 >= 0 && var2 >= 0) {
				field365[field373] = var2;
				field373 = field373 + 1 & 127;
				if (field372 == field373) {
					field373 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field371 + 1 & 127;
				if (var3 != field378) {
					field375[field371] = var2;
					field374[field371] = 0;
					field371 = var3;
				}
			}

			var3 = var1.getModifiers();
			if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
				var1.consume();
			}
		}

	}

	public final void keyTyped(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			char var2 = var1.getKeyChar();
			if (var2 != 0 && var2 != '\uffff' && LoginScreenAnimation.method1843(var2)) {
				int var3 = field371 + 1 & 127;
				if (var3 != field378) {
					field375[field371] = -1;
					field374[field371] = var2;
					field371 = var3;
				}
			}
		}

		var1.consume();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "1410088025"
	)
	@Export("InvDefinition_setArchives")
	public static void InvDefinition_setArchives(AbstractArchive var0) {
		InvDefinition.InvDefinition_archive = var0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lba;IB)V",
		garbageValue = "0"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (Strings.isWorldMapEvent(var0.type)) {
			EnumDefinition.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = Decimator.WorldMapElement_get(EnumDefinition.worldMapEvent.mapElement);
			var3 = class42.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = LoginPacket.getScript(var17);
		}

		if (var3 != null) {
			Interpreter.Interpreter_intStackSize = 0;
			Interpreter.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1074 = false;

			try {
				int var10;
				try {
					Interpreter.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					UrlRequester.Interpreter_stringLocals = new String[var3.localStringCount];
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

							Interpreter.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							UrlRequester.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1089 = var0.field568;

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

							var20 = TileItem.method2129(var29, var3, var32);
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
							NetSocket.method3472(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
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
							Interpreter.Interpreter_intLocals = var34.intLocals;
							UrlRequester.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSprite.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							WorldMapElement.method4360(var11, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
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
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							Interpreter.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = UrlRequester.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							UrlRequester.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							Interpreter.Interpreter_stringStackSize -= var11;
							String var31 = FloorOverlayDefinition.method4716(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--Interpreter.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--Interpreter.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class197.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									class197.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
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
									var18 = class197.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									class197.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = class197.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									class197.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
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
								Script var12 = LoginPacket.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (Interpreter.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (Interpreter.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								Interpreter.Interpreter_intStackSize -= var12.intArgumentCount;
								Interpreter.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = Interpreter.Interpreter_intLocals;
								var19.stringLocals = UrlRequester.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								Interpreter.Interpreter_intLocals = var13;
								UrlRequester.Interpreter_stringLocals = var14;
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
					class32.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1074) {
					Interpreter.field1075 = true;
					class51.method922();
					Interpreter.field1075 = false;
					Interpreter.field1074 = false;
				}

			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "96"
	)
	static void method873() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromFriend();
		}

	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "133309082"
	)
	static final void method851() {
		GrandExchangeOffer.method129(false);
		Client.field689 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < WorldMapIcon_1.regionLandArchives.length; ++var1) {
			if (class197.regionMapArchiveIds[var1] != -1 && WorldMapIcon_1.regionLandArchives[var1] == null) {
				WorldMapIcon_1.regionLandArchives[var1] = class3.archive5.takeFile(class197.regionMapArchiveIds[var1], 0);
				if (WorldMapIcon_1.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field689;
				}
			}

			if (class60.regionLandArchiveIds[var1] != -1 && ArchiveLoader.regionMapArchives[var1] == null) {
				ArchiveLoader.regionMapArchives[var1] = class3.archive5.takeFileEncrypted(class60.regionLandArchiveIds[var1], 0, class296.xteaKeys[var1]);
				if (ArchiveLoader.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field689;
				}
			}
		}

		if (!var0) {
			Client.field693 = 1;
		} else {
			Client.field691 = 0;
			var0 = true;

			int var3;
			int var4;
			Buffer var8;
			int var9;
			int var10;
			int var11;
			int var13;
			int var14;
			int var15;
			int var16;
			int var17;
			int var18;
			for (var1 = 0; var1 < WorldMapIcon_1.regionLandArchives.length; ++var1) {
				byte[] var2 = ArchiveLoader.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (MouseHandler.regions[var1] >> 8) * 64 - class223.baseX * 64;
					var4 = (MouseHandler.regions[var1] & 255) * 64 - class286.baseY * 64;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					boolean var7 = true;
					var8 = new Buffer(var2);
					var9 = -1;

					label1329:
					while (true) {
						var10 = var8.method5457();
						if (var10 == 0) {
							var0 &= var7;
							break;
						}

						var9 += var10;
						var11 = 0;
						boolean var12 = false;

						while (true) {
							while (!var12) {
								var13 = var8.readUShortSmart();
								if (var13 == 0) {
									continue label1329;
								}

								var11 += var13 - 1;
								var14 = var11 & 63;
								var15 = var11 >> 6 & 63;
								var16 = var8.readUnsignedByte() >> 2;
								var17 = var3 + var15;
								var18 = var4 + var14;
								if (var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
									ObjectDefinition var19 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var9);
									if (var16 != 22 || !Client.isLowDetail || var19.int1 != 0 || var19.interactType == 1 || var19.boolean2) {
										if (!var19.needsModelFiles()) {
											++Client.field691;
											var7 = false;
										}

										var12 = true;
									}
								}
							}

							var13 = var8.readUShortSmart();
							if (var13 == 0) {
								break;
							}

							var8.readUnsignedByte();
						}
					}
				}
			}

			if (!var0) {
				Client.field693 = 2;
			} else {
				if (Client.field693 != 0) {
					WorldMapSprite.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				WorldMapID.playPcmPlayers();
				PacketWriter.scene.clear();

				for (var1 = 0; var1 < 4; ++var1) {
					Client.collisionMaps[var1].clear();
				}

				int var46;
				for (var1 = 0; var1 < 4; ++var1) {
					for (var46 = 0; var46 < 104; ++var46) {
						for (var3 = 0; var3 < 104; ++var3) {
							Tiles.Tiles_renderFlags[var1][var46][var3] = 0;
						}
					}
				}

				WorldMapID.playPcmPlayers();
				TextureProvider.method2757();
				var1 = WorldMapIcon_1.regionLandArchives.length;
				ClientPacket.method3581();
				GrandExchangeOffer.method129(true);
				int var5;
				int var20;
				int var21;
				int var51;
				int var66;
				if (!Client.isInInstance) {
					byte[] var47;
					for (var46 = 0; var46 < var1; ++var46) {
						var3 = (MouseHandler.regions[var46] >> 8) * 64 - class223.baseX * 64;
						var4 = (MouseHandler.regions[var46] & 255) * 64 - class286.baseY * 64;
						var47 = WorldMapIcon_1.regionLandArchives[var46];
						if (var47 != null) {
							WorldMapID.playPcmPlayers();
							class40.method787(var47, var3, var4, ServerPacket.field2131 * 8 - 48, MusicPatchNode.field2422 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var46 = 0; var46 < var1; ++var46) {
						var3 = (MouseHandler.regions[var46] >> 8) * 64 - class223.baseX * 64;
						var4 = (MouseHandler.regions[var46] & 255) * 64 - class286.baseY * 64;
						var47 = WorldMapIcon_1.regionLandArchives[var46];
						if (var47 == null && MusicPatchNode.field2422 < 800) {
							WorldMapID.playPcmPlayers();
							class30.method561(var3, var4, 64, 64);
						}
					}

					GrandExchangeOffer.method129(true);

					for (var46 = 0; var46 < var1; ++var46) {
						byte[] var52 = ArchiveLoader.regionMapArchives[var46];
						if (var52 != null) {
							var4 = (MouseHandler.regions[var46] >> 8) * 64 - class223.baseX * 64;
							var5 = (MouseHandler.regions[var46] & 255) * 64 - class286.baseY * 64;
							WorldMapID.playPcmPlayers();
							Scene var53 = PacketWriter.scene;
							CollisionMap[] var54 = Client.collisionMaps;
							var8 = new Buffer(var52);
							var9 = -1;

							while (true) {
								var10 = var8.method5457();
								if (var10 == 0) {
									break;
								}

								var9 += var10;
								var11 = 0;

								while (true) {
									var66 = var8.readUShortSmart();
									if (var66 == 0) {
										break;
									}

									var11 += var66 - 1;
									var13 = var11 & 63;
									var14 = var11 >> 6 & 63;
									var15 = var11 >> 12;
									var16 = var8.readUnsignedByte();
									var17 = var16 >> 2;
									var18 = var16 & 3;
									var51 = var14 + var4;
									var20 = var5 + var13;
									if (var51 > 0 && var20 > 0 && var51 < 103 && var20 < 103) {
										var21 = var15;
										if ((Tiles.Tiles_renderFlags[1][var51][var20] & 2) == 2) {
											var21 = var15 - 1;
										}

										CollisionMap var55 = null;
										if (var21 >= 0) {
											var55 = var54[var21];
										}

										GrandExchangeOfferAgeComparator.method165(var15, var51, var20, var9, var18, var17, var53, var55);
									}
								}
							}
						}
					}
				}

				int var6;
				int[] var10000;
				int var22;
				int var26;
				int var27;
				int var28;
				int var29;
				int var32;
				int var34;
				int var35;
				int var36;
				int var48;
				int var65;
				if (Client.isInInstance) {
					for (var46 = 0; var46 < 4; ++var46) {
						WorldMapID.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								boolean var64 = false;
								var6 = Client.instanceChunkTemplates[var46][var3][var4];
								if (var6 != -1) {
									var65 = var6 >> 24 & 3;
									var48 = var6 >> 1 & 3;
									var9 = var6 >> 14 & 1023;
									var10 = var6 >> 3 & 2047;
									var11 = (var9 / 8 << 8) + var10 / 8;

									for (var66 = 0; var66 < MouseHandler.regions.length; ++var66) {
										if (MouseHandler.regions[var66] == var11 && WorldMapIcon_1.regionLandArchives[var66] != null) {
											byte[] var49 = WorldMapIcon_1.regionLandArchives[var66];
											var14 = var3 * 8;
											var15 = var4 * 8;
											var16 = (var9 & 7) * 8;
											var17 = (var10 & 7) * 8;
											CollisionMap[] var50 = Client.collisionMaps;

											for (var51 = 0; var51 < 8; ++var51) {
												for (var20 = 0; var20 < 8; ++var20) {
													if (var14 + var51 > 0 && var51 + var14 < 103 && var15 + var20 > 0 && var20 + var15 < 103) {
														var10000 = var50[var46].flags[var14 + var51];
														var10000[var15 + var20] &= -16777217;
													}
												}
											}

											Buffer var67 = new Buffer(var49);

											for (var20 = 0; var20 < 4; ++var20) {
												for (var21 = 0; var21 < 64; ++var21) {
													for (var22 = 0; var22 < 64; ++var22) {
														if (var20 == var65 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
															var27 = var21 & 7;
															var28 = var22 & 7;
															var29 = var48 & 3;
															if (var29 == 0) {
																var26 = var27;
															} else if (var29 == 1) {
																var26 = var28;
															} else if (var29 == 2) {
																var26 = 7 - var27;
															} else {
																var26 = 7 - var28;
															}

															var32 = var14 + var26;
															var35 = var21 & 7;
															var36 = var22 & 7;
															int var37 = var48 & 3;
															if (var37 == 0) {
																var34 = var36;
															} else if (var37 == 1) {
																var34 = 7 - var35;
															} else if (var37 == 2) {
																var34 = 7 - var36;
															} else {
																var34 = var35;
															}

															GrandExchangeOfferWorldComparator.loadTerrain(var67, var46, var32, var34 + var15, 0, 0, var48);
														} else {
															GrandExchangeOfferWorldComparator.loadTerrain(var67, 0, -1, -1, 0, 0, 0);
														}
													}
												}
											}

											var64 = true;
											break;
										}
									}
								}

								if (!var64) {
									WorldMapID.method569(var46, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var46 = 0; var46 < 13; ++var46) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var46][var3];
							if (var4 == -1) {
								class30.method561(var46 * 8, var3 * 8, 8, 8);
							}
						}
					}

					GrandExchangeOffer.method129(true);

					for (var46 = 0; var46 < 4; ++var46) {
						WorldMapID.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var5 = Client.instanceChunkTemplates[var46][var3][var4];
								if (var5 != -1) {
									var6 = var5 >> 24 & 3;
									var65 = var5 >> 1 & 3;
									var48 = var5 >> 14 & 1023;
									var9 = var5 >> 3 & 2047;
									var10 = (var48 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < MouseHandler.regions.length; ++var11) {
										if (MouseHandler.regions[var11] == var10 && ArchiveLoader.regionMapArchives[var11] != null) {
											class80.method2051(ArchiveLoader.regionMapArchives[var11], var46, var3 * 8, var4 * 8, var6, (var48 & 7) * 8, (var9 & 7) * 8, var65, PacketWriter.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				GrandExchangeOffer.method129(true);
				WorldMapID.playPcmPlayers();
				Scene var63 = PacketWriter.scene;
				CollisionMap[] var75 = Client.collisionMaps;

				for (var4 = 0; var4 < 4; ++var4) {
					for (var5 = 0; var5 < 104; ++var5) {
						for (var6 = 0; var6 < 104; ++var6) {
							if ((Tiles.Tiles_renderFlags[var4][var5][var6] & 1) == 1) {
								var65 = var4;
								if ((Tiles.Tiles_renderFlags[1][var5][var6] & 2) == 2) {
									var65 = var4 - 1;
								}

								if (var65 >= 0) {
									var75[var65].setBlockedByFloor(var5, var6);
								}
							}
						}
					}
				}

				Tiles.field482 += (int)(Math.random() * 5.0D) - 2;
				if (Tiles.field482 < -8) {
					Tiles.field482 = -8;
				}

				if (Tiles.field482 > 8) {
					Tiles.field482 = 8;
				}

				Tiles.field496 += (int)(Math.random() * 5.0D) - 2;
				if (Tiles.field496 < -16) {
					Tiles.field496 = -16;
				}

				if (Tiles.field496 > 16) {
					Tiles.field496 = 16;
				}

				for (var4 = 0; var4 < 4; ++var4) {
					byte[][] var71 = Tiles.field486[var4];
					var11 = (int)Math.sqrt(5100.0D);
					var66 = var11 * 768 >> 8;

					for (var13 = 1; var13 < 103; ++var13) {
						for (var14 = 1; var14 < 103; ++var14) {
							var15 = Tiles.Tiles_heights[var4][var14 + 1][var13] - Tiles.Tiles_heights[var4][var14 - 1][var13];
							var16 = Tiles.Tiles_heights[var4][var14][var13 + 1] - Tiles.Tiles_heights[var4][var14][var13 - 1];
							var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
							var18 = (var15 << 8) / var17;
							var51 = 65536 / var17;
							var20 = (var16 << 8) / var17;
							var21 = (var18 * -50 + var20 * -50 + var51 * -10) / var66 + 96;
							var22 = (var71[var14][var13 + 1] >> 3) + (var71[var14 - 1][var13] >> 2) + (var71[var14][var13 - 1] >> 2) + (var71[var14 + 1][var13] >> 3) + (var71[var14][var13] >> 1);
							DevicePcmPlayerProvider.field386[var14][var13] = var21 - var22;
						}
					}

					for (var13 = 0; var13 < 104; ++var13) {
						Tiles.Tiles_hue[var13] = 0;
						ArchiveLoader.Tiles_saturation[var13] = 0;
						Tiles.Tiles_lightness[var13] = 0;
						FontName.Tiles_hueMultiplier[var13] = 0;
						Tiles.field487[var13] = 0;
					}

					for (var13 = -5; var13 < 109; ++var13) {
						for (var14 = 0; var14 < 104; ++var14) {
							var15 = var13 + 5;
							int var10002;
							if (var15 >= 0 && var15 < 104) {
								var16 = Tiles.field501[var4][var15][var14] & 255;
								if (var16 > 0) {
									FloorUnderlayDefinition var56 = UserComparator9.FloorUnderlayDefinition_get(var16 - 1);
									var10000 = Tiles.Tiles_hue;
									var10000[var14] += var56.hue;
									var10000 = ArchiveLoader.Tiles_saturation;
									var10000[var14] += var56.saturation;
									var10000 = Tiles.Tiles_lightness;
									var10000[var14] += var56.lightness;
									var10000 = FontName.Tiles_hueMultiplier;
									var10000[var14] += var56.hueMultiplier;
									var10002 = Tiles.field487[var14]++;
								}
							}

							var16 = var13 - 5;
							if (var16 >= 0 && var16 < 104) {
								var17 = Tiles.field501[var4][var16][var14] & 255;
								if (var17 > 0) {
									FloorUnderlayDefinition var74 = UserComparator9.FloorUnderlayDefinition_get(var17 - 1);
									var10000 = Tiles.Tiles_hue;
									var10000[var14] -= var74.hue;
									var10000 = ArchiveLoader.Tiles_saturation;
									var10000[var14] -= var74.saturation;
									var10000 = Tiles.Tiles_lightness;
									var10000[var14] -= var74.lightness;
									var10000 = FontName.Tiles_hueMultiplier;
									var10000[var14] -= var74.hueMultiplier;
									var10002 = Tiles.field487[var14]--;
								}
							}
						}

						if (var13 >= 1 && var13 < 103) {
							var14 = 0;
							var15 = 0;
							var16 = 0;
							var17 = 0;
							var18 = 0;

							for (var51 = -5; var51 < 109; ++var51) {
								var20 = var51 + 5;
								if (var20 >= 0 && var20 < 104) {
									var14 += Tiles.Tiles_hue[var20];
									var15 += ArchiveLoader.Tiles_saturation[var20];
									var16 += Tiles.Tiles_lightness[var20];
									var17 += FontName.Tiles_hueMultiplier[var20];
									var18 += Tiles.field487[var20];
								}

								var21 = var51 - 5;
								if (var21 >= 0 && var21 < 104) {
									var14 -= Tiles.Tiles_hue[var21];
									var15 -= ArchiveLoader.Tiles_saturation[var21];
									var16 -= Tiles.Tiles_lightness[var21];
									var17 -= FontName.Tiles_hueMultiplier[var21];
									var18 -= Tiles.field487[var21];
								}

								if (var51 >= 1 && var51 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var13][var51] & 2) != 0 || (Tiles.Tiles_renderFlags[var4][var13][var51] & 16) == 0)) {
									if (var4 < Tiles.Tiles_minPlane) {
										Tiles.Tiles_minPlane = var4;
									}

									var22 = Tiles.field501[var4][var13][var51] & 255;
									int var57 = Tiles.field483[var4][var13][var51] & 255;
									if (var22 > 0 || var57 > 0) {
										int var24 = Tiles.Tiles_heights[var4][var13][var51];
										int var25 = Tiles.Tiles_heights[var4][var13 + 1][var51];
										var26 = Tiles.Tiles_heights[var4][var13 + 1][var51 + 1];
										var27 = Tiles.Tiles_heights[var4][var13][var51 + 1];
										var28 = DevicePcmPlayerProvider.field386[var13][var51];
										var29 = DevicePcmPlayerProvider.field386[var13 + 1][var51];
										int var58 = DevicePcmPlayerProvider.field386[var13 + 1][var51 + 1];
										int var31 = DevicePcmPlayerProvider.field386[var13][var51 + 1];
										var32 = -1;
										int var33 = -1;
										if (var22 > 0) {
											var34 = var14 * 256 / var17;
											var35 = var15 / var18;
											var36 = var16 / var18;
											var32 = GrandExchangeOfferAgeComparator.hslToRgb(var34, var35, var36);
											var34 = var34 + Tiles.field482 & 255;
											var36 += Tiles.field496;
											if (var36 < 0) {
												var36 = 0;
											} else if (var36 > 255) {
												var36 = 255;
											}

											var33 = GrandExchangeOfferAgeComparator.hslToRgb(var34, var35, var36);
										}

										FloorOverlayDefinition var59;
										if (var4 > 0) {
											boolean var69 = true;
											if (var22 == 0 && DevicePcmPlayerProvider.field393[var4][var13][var51] != 0) {
												var69 = false;
											}

											if (var57 > 0) {
												var36 = var57 - 1;
												var59 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var36);
												FloorOverlayDefinition var60;
												if (var59 != null) {
													var60 = var59;
												} else {
													byte[] var62 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var36);
													var59 = new FloorOverlayDefinition();
													if (var62 != null) {
														var59.decode(new Buffer(var62), var36);
													}

													var59.postDecode();
													FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var59, (long)var36);
													var60 = var59;
												}

												if (!var60.hideUnderlay) {
													var69 = false;
												}
											}

											if (var69 && var24 == var25 && var24 == var26 && var27 == var24) {
												var10000 = Tiles.field488[var4][var13];
												var10000[var51] |= 2340;
											}
										}

										var34 = 0;
										if (var33 != -1) {
											var34 = Rasterizer3D.Rasterizer3D_colorPalette[class192.method3648(var33, 96)];
										}

										if (var57 == 0) {
											var63.addTile(var4, var13, var51, 0, 0, -1, var24, var25, var26, var27, class192.method3648(var32, var28), class192.method3648(var32, var29), class192.method3648(var32, var58), class192.method3648(var32, var31), 0, 0, 0, 0, var34, 0);
										} else {
											var35 = DevicePcmPlayerProvider.field393[var4][var13][var51] + 1;
											byte var70 = class287.field3634[var4][var13][var51];
											int var38 = var57 - 1;
											FloorOverlayDefinition var39 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var38);
											if (var39 != null) {
												var59 = var39;
											} else {
												byte[] var61 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var38);
												var39 = new FloorOverlayDefinition();
												if (var61 != null) {
													var39.decode(new Buffer(var61), var38);
												}

												var39.postDecode();
												FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var39, (long)var38);
												var59 = var39;
											}

											int var40 = var59.texture;
											int var41;
											int var42;
											int var43;
											int var44;
											if (var40 >= 0) {
												var42 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var40);
												var41 = -1;
											} else if (var59.primaryRgb == 16711935) {
												var41 = -2;
												var40 = -1;
												var42 = -2;
											} else {
												var41 = GrandExchangeOfferAgeComparator.hslToRgb(var59.hue, var59.saturation, var59.lightness);
												var43 = var59.hue + Tiles.field482 & 255;
												var44 = var59.lightness + Tiles.field496;
												if (var44 < 0) {
													var44 = 0;
												} else if (var44 > 255) {
													var44 = 255;
												}

												var42 = GrandExchangeOfferAgeComparator.hslToRgb(var43, var59.saturation, var44);
											}

											var43 = 0;
											if (var42 != -2) {
												var43 = Rasterizer3D.Rasterizer3D_colorPalette[WorldMapEvent.method800(var42, 96)];
											}

											if (var59.secondaryRgb != -1) {
												var44 = var59.secondaryHue + Tiles.field482 & 255;
												int var45 = var59.secondaryLightness + Tiles.field496;
												if (var45 < 0) {
													var45 = 0;
												} else if (var45 > 255) {
													var45 = 255;
												}

												var42 = GrandExchangeOfferAgeComparator.hslToRgb(var44, var59.secondarySaturation, var45);
												var43 = Rasterizer3D.Rasterizer3D_colorPalette[WorldMapEvent.method800(var42, 96)];
											}

											var63.addTile(var4, var13, var51, var35, var70, var40, var24, var25, var26, var27, class192.method3648(var32, var28), class192.method3648(var32, var29), class192.method3648(var32, var58), class192.method3648(var32, var31), WorldMapEvent.method800(var41, var28), WorldMapEvent.method800(var41, var29), WorldMapEvent.method800(var41, var58), WorldMapEvent.method800(var41, var31), var34, var43);
										}
									}
								}
							}
						}
					}

					for (var13 = 1; var13 < 103; ++var13) {
						for (var14 = 1; var14 < 103; ++var14) {
							var63.setTileMinPlane(var4, var14, var13, class189.method3612(var4, var14, var13));
						}
					}

					Tiles.field501[var4] = null;
					Tiles.field483[var4] = null;
					DevicePcmPlayerProvider.field393[var4] = null;
					class287.field3634[var4] = null;
					Tiles.field486[var4] = null;
				}

				var63.method3071(-50, -10, -50);

				for (var4 = 0; var4 < 104; ++var4) {
					for (var5 = 0; var5 < 104; ++var5) {
						if ((Tiles.Tiles_renderFlags[1][var4][var5] & 2) == 2) {
							var63.setLinkBelow(var4, var5);
						}
					}
				}

				var4 = 1;
				var5 = 2;
				var6 = 4;

				for (var65 = 0; var65 < 4; ++var65) {
					if (var65 > 0) {
						var4 <<= 3;
						var5 <<= 3;
						var6 <<= 3;
					}

					for (var48 = 0; var48 <= var65; ++var48) {
						for (var9 = 0; var9 <= 104; ++var9) {
							for (var10 = 0; var10 <= 104; ++var10) {
								short var68;
								if ((Tiles.field488[var48][var10][var9] & var4) != 0) {
									var11 = var9;
									var66 = var9;
									var13 = var48;

									for (var14 = var48; var11 > 0 && (Tiles.field488[var48][var10][var11 - 1] & var4) != 0; --var11) {
									}

									while (var66 < 104 && (Tiles.field488[var48][var10][var66 + 1] & var4) != 0) {
										++var66;
									}

									label901:
									while (var13 > 0) {
										for (var15 = var11; var15 <= var66; ++var15) {
											if ((Tiles.field488[var13 - 1][var10][var15] & var4) == 0) {
												break label901;
											}
										}

										--var13;
									}

									label890:
									while (var14 < var65) {
										for (var15 = var11; var15 <= var66; ++var15) {
											if ((Tiles.field488[var14 + 1][var10][var15] & var4) == 0) {
												break label890;
											}
										}

										++var14;
									}

									var15 = (var66 - var11 + 1) * (var14 + 1 - var13);
									if (var15 >= 8) {
										var68 = 240;
										var17 = Tiles.Tiles_heights[var14][var10][var11] - var68;
										var18 = Tiles.Tiles_heights[var13][var10][var11];
										Scene.Scene_addOccluder(var65, 1, var10 * 128, var10 * 128, var11 * 128, var66 * 128 + 128, var17, var18);

										for (var51 = var13; var51 <= var14; ++var51) {
											for (var20 = var11; var20 <= var66; ++var20) {
												var10000 = Tiles.field488[var51][var10];
												var10000[var20] &= ~var4;
											}
										}
									}
								}

								if ((Tiles.field488[var48][var10][var9] & var5) != 0) {
									var11 = var10;
									var66 = var10;
									var13 = var48;

									for (var14 = var48; var11 > 0 && (Tiles.field488[var48][var11 - 1][var9] & var5) != 0; --var11) {
									}

									while (var66 < 104 && (Tiles.field488[var48][var66 + 1][var9] & var5) != 0) {
										++var66;
									}

									label954:
									while (var13 > 0) {
										for (var15 = var11; var15 <= var66; ++var15) {
											if ((Tiles.field488[var13 - 1][var15][var9] & var5) == 0) {
												break label954;
											}
										}

										--var13;
									}

									label943:
									while (var14 < var65) {
										for (var15 = var11; var15 <= var66; ++var15) {
											if ((Tiles.field488[var14 + 1][var15][var9] & var5) == 0) {
												break label943;
											}
										}

										++var14;
									}

									var15 = (var14 + 1 - var13) * (var66 - var11 + 1);
									if (var15 >= 8) {
										var68 = 240;
										var17 = Tiles.Tiles_heights[var14][var11][var9] - var68;
										var18 = Tiles.Tiles_heights[var13][var11][var9];
										Scene.Scene_addOccluder(var65, 2, var11 * 128, var66 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

										for (var51 = var13; var51 <= var14; ++var51) {
											for (var20 = var11; var20 <= var66; ++var20) {
												var10000 = Tiles.field488[var51][var20];
												var10000[var9] &= ~var5;
											}
										}
									}
								}

								if ((Tiles.field488[var48][var10][var9] & var6) != 0) {
									var11 = var10;
									var66 = var10;
									var13 = var9;

									for (var14 = var9; var13 > 0 && (Tiles.field488[var48][var10][var13 - 1] & var6) != 0; --var13) {
									}

									while (var14 < 104 && (Tiles.field488[var48][var10][var14 + 1] & var6) != 0) {
										++var14;
									}

									label1007:
									while (var11 > 0) {
										for (var15 = var13; var15 <= var14; ++var15) {
											if ((Tiles.field488[var48][var11 - 1][var15] & var6) == 0) {
												break label1007;
											}
										}

										--var11;
									}

									label996:
									while (var66 < 104) {
										for (var15 = var13; var15 <= var14; ++var15) {
											if ((Tiles.field488[var48][var66 + 1][var15] & var6) == 0) {
												break label996;
											}
										}

										++var66;
									}

									if ((var14 - var13 + 1) * (var66 - var11 + 1) >= 4) {
										var15 = Tiles.Tiles_heights[var48][var11][var13];
										Scene.Scene_addOccluder(var65, 4, var11 * 128, var66 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

										for (var16 = var11; var16 <= var66; ++var16) {
											for (var17 = var13; var17 <= var14; ++var17) {
												var10000 = Tiles.field488[var48][var16];
												var10000[var17] &= ~var6;
											}
										}
									}
								}
							}
						}
					}
				}

				GrandExchangeOffer.method129(true);
				var4 = Tiles.Tiles_minPlane;
				if (var4 > WorldMapRectangle.plane) {
					var4 = WorldMapRectangle.plane;
				}

				if (var4 < WorldMapRectangle.plane - 1) {
					var4 = WorldMapRectangle.plane - 1;
				}

				if (Client.isLowDetail) {
					PacketWriter.scene.init(Tiles.Tiles_minPlane);
				} else {
					PacketWriter.scene.init(0);
				}

				for (var5 = 0; var5 < 104; ++var5) {
					for (var6 = 0; var6 < 104; ++var6) {
						WorldMapCacheName.updateItemPile(var5, var6);
					}
				}

				WorldMapID.playPcmPlayers();

				for (PendingSpawn var72 = (PendingSpawn)Client.pendingSpawns.last(); var72 != null; var72 = (PendingSpawn)Client.pendingSpawns.previous()) {
					if (var72.hitpoints == -1) {
						var72.delay = 0;
						GrandExchangeEvent.method88(var72);
					} else {
						var72.remove();
					}
				}

				ObjectDefinition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var73;
				if (ViewportMouse.client.hasFrame()) {
					var73 = InterfaceParent.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
					var73.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var73);
				}

				if (!Client.isInInstance) {
					var5 = (ServerPacket.field2131 - 6) / 8;
					var6 = (ServerPacket.field2131 + 6) / 8;
					var65 = (MusicPatchNode.field2422 - 6) / 8;
					var48 = (MusicPatchNode.field2422 + 6) / 8;

					for (var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
						for (var10 = var65 - 1; var10 <= var48 + 1; ++var10) {
							if (var9 < var5 || var9 > var6 || var10 < var65 || var10 > var48) {
								class3.archive5.loadRegionFromName("m" + var9 + "_" + var10);
								class3.archive5.loadRegionFromName("l" + var9 + "_" + var10);
							}
						}
					}
				}

				MouseRecorder.updateGameState(30);
				WorldMapID.playPcmPlayers();
				Friend.method5148();
				var73 = InterfaceParent.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var73);
				WorldMapDecoration.method343();
			}
		}
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "819665124"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		ScriptEvent.method1205();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
