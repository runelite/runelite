import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ks")
public class class286 {
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	static Widget field3623;

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-2004076029"
	)
	static int method5166(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			EnumDefinition var5 = MenuAction.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				EnumDefinition var10 = MenuAction.getEnum(var3);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			EnumDefinition var7 = MenuAction.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}
