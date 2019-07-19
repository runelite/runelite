import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ha")
public class class208 {
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "17"
	)
	static int method3941(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == ScriptOpcodes.APPEND_NUM) {
			var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == ScriptOpcodes.APPEND) {
				Skills.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
				var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3 + class195.intToString(var4, true);
				return 1;
			} else if (var0 == ScriptOpcodes.LOWERCASE) {
				var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == ScriptOpcodes.FROMDATE) {
					var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					long var11 = (11745L + (long)var10) * 86400000L;
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != ScriptOpcodes.TEXT_GENDER) {
					if (var0 == ScriptOpcodes.TOSTRING) {
						var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.COMPARE) {
						Skills.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WallDecoration.method3292(MenuAction.method1993(Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1], ScriptFrame.field528));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == ScriptOpcodes.PARAHEIGHT) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var13 = class2.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.PARAWIDTH) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							var13 = class2.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
							Skills.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ESCAPE) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == ScriptOpcodes.APPEND_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
							var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Ignored.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
							var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class185.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class49.isCharDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_LENGTH) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.SUBSTRING) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.REMOVETAGS) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
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

							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
							Skills.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.UPPERCASE) {
							var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					Skills.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
					if (Client.localPlayer.appearance != null && Client.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}
}
