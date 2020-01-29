import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hy")
public class class223 {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
		garbageValue = "118076110"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-1273474206"
	)
	static int method4193(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			EnumDefinition var5 = GameObject.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				EnumDefinition var10 = GameObject.getEnum(var3);
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			class320.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			EnumDefinition var7 = GameObject.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}
