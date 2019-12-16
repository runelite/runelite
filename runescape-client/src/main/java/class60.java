import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("by")
public class class60 {
	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -1555429919
	)
	@Export("cameraY")
	static int cameraY;

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "64"
	)
	@Export("performReflectionCheck")
	public static void performReflectionCheck(PacketBuffer var0) {
		ReflectionCheck var1 = (ReflectionCheck)class117.reflectionChecks.last();
		if (var1 != null) {
			int var2 = var0.offset;
			var0.writeInt(var1.id);

			for (int var3 = 0; var3 < var1.size; ++var3) {
				if (var1.creationErrors[var3] != 0) {
					var0.writeByte(var1.creationErrors[var3]);
				} else {
					try {
						int var4 = var1.operations[var3];
						Field var5;
						int var6;
						if (var4 == 0) {
							var5 = var1.fields[var3];
							var6 = Reflection.getInt(var5, (Object)null);
							var0.writeByte(0);
							var0.writeInt(var6);
						} else if (var4 == 1) {
							var5 = var1.fields[var3];
							Reflection.setInt(var5, (Object)null, var1.intReplaceValues[var3]);
							var0.writeByte(0);
						} else if (var4 == 2) {
							var5 = var1.fields[var3];
							var6 = var5.getModifiers();
							var0.writeByte(0);
							var0.writeInt(var6);
						}

						Method var25;
						if (var4 != 3) {
							if (var4 == 4) {
								var25 = var1.methods[var3];
								var6 = var25.getModifiers();
								var0.writeByte(0);
								var0.writeInt(var6);
							}
						} else {
							var25 = var1.methods[var3];
							byte[][] var10 = var1.arguments[var3];
							Object[] var7 = new Object[var10.length];

							for (int var8 = 0; var8 < var10.length; ++var8) {
								ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
								var7[var8] = var9.readObject();
							}

							Object var11 = Reflection.invoke(var25, (Object)null, var7);
							if (var11 == null) {
								var0.writeByte(0);
							} else if (var11 instanceof Number) {
								var0.writeByte(1);
								var0.writeLong(((Number)var11).longValue());
							} else if (var11 instanceof String) {
								var0.writeByte(2);
								var0.writeStringCp1252NullTerminated((String)var11);
							} else {
								var0.writeByte(4);
							}
						}
					} catch (ClassNotFoundException var13) {
						var0.writeByte(-10);
					} catch (InvalidClassException var14) {
						var0.writeByte(-11);
					} catch (StreamCorruptedException var15) {
						var0.writeByte(-12);
					} catch (OptionalDataException var16) {
						var0.writeByte(-13);
					} catch (IllegalAccessException var17) {
						var0.writeByte(-14);
					} catch (IllegalArgumentException var18) {
						var0.writeByte(-15);
					} catch (InvocationTargetException var19) {
						var0.writeByte(-16);
					} catch (SecurityException var20) {
						var0.writeByte(-17);
					} catch (IOException var21) {
						var0.writeByte(-18);
					} catch (NullPointerException var22) {
						var0.writeByte(-19);
					} catch (Exception var23) {
						var0.writeByte(-20);
					} catch (Throwable var24) {
						var0.writeByte(-21);
					}
				}
			}

			var0.writeCrc(var2);
			var1.remove();
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "102357643"
	)
	static int method1170(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			var4 = Tile.getWidget(var3);
		} else {
			var4 = var2 ? UserComparator7.field1946 : class197.field2398;
		}

		if (var0 == ScriptOpcodes.CC_SETPOSITION) {
			class188.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			LoginPacket.invalidateWidget(var4);
			class206.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) {
			class188.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			LoginPacket.invalidateWidget(var4);
			class206.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) {
			boolean var5 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				LoginPacket.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "81"
	)
	static int method1171(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == ScriptOpcodes.APPEND_NUM) {
			var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == ScriptOpcodes.APPEND) {
				class65.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
				var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3 + class65.intToString(var4, true);
				return 1;
			} else if (var0 == ScriptOpcodes.LOWERCASE) {
				var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == ScriptOpcodes.FROMDATE) {
					var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					long var11 = 86400000L * ((long)var10 + 11745L);
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != ScriptOpcodes.TEXT_GENDER) {
					if (var0 == ScriptOpcodes.TOSTRING) {
						var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.COMPARE) {
						class65.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = ViewportMouse.method2993(class195.compareStrings(Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1], Varps.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == ScriptOpcodes.PARAHEIGHT) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							class188.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var13 = WorldMapSection1.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.PARAWIDTH) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							class188.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var13 = WorldMapSection1.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
							class65.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ESCAPE) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == ScriptOpcodes.APPEND_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
							var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapID.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class191.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
							var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapManager.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class237.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_LENGTH) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.SUBSTRING) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							class188.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.REMOVETAGS) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							StringBuilder var17 = new StringBuilder(var3.length());
							boolean var15 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var15 = true;
								} else if (var7 == '>') {
									var15 = false;
								} else if (!var15) {
									var17.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
							class65.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.UPPERCASE) {
							var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					class65.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
					if (Message.localPlayer.appearance != null && Message.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "18"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field841 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (ItemDefinition.getWindowedMode() == 1) {
			class206.client.setMaxCanvasSize(765, 503);
		} else {
			class206.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			class219.method4076();
		}

	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(Lha;I)Ljava/lang/String;",
		garbageValue = "762808761"
	)
	static String method1167(Widget var0) {
		if (class14.method157(WorldMapSection0.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
