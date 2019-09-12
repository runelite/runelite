import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ac")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements PcmPlayerProvider {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lmw;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("NetCache_reference")
	static Buffer NetCache_reference;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -102001369
	)
	@Export("selectedItemId")
	static int selectedItemId;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldh;",
		garbageValue = "-131796443"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "24"
	)
	static final int method811(int var0, int var1) {
		int var2 = method805(var0 - 1, var1 - 1) + method805(var0 + 1, var1 - 1) + method805(var0 - 1, var1 + 1) + method805(1 + var0, 1 + var1);
		int var3 = method805(var0 - 1, var1) + method805(1 + var0, var1) + method805(var0, var1 - 1) + method805(var0, 1 + var1);
		int var4 = method805(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "118"
	)
	static final int method805(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "13"
	)
	static int method809(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			EnumDefinition var5 = NetFileRequest.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				EnumDefinition var10 = NetFileRequest.getEnum(var3);
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			class160.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3];
			EnumDefinition var7 = NetFileRequest.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "105"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (TaskHandler.loadInterface(var0)) {
			Widget[] var1 = class289.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}
