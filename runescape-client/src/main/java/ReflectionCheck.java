import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cc")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("qz")
	@ObfuscatedGetter(
		intValue = -799338112
	)
	static int field1319;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -677956283
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1081173073
	)
	@Export("size")
	int size;
	@ObfuscatedName("o")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("e")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("i")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("g")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("d")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("l")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1634047659"
	)
	static int method2348(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) {
			class320.Interpreter_intStackSize -= 2;
			Client.field908 = (short)GrandExchangeEvent.method97(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize]);
			if (Client.field908 <= 0) {
				Client.field908 = 256;
			}

			Client.field897 = (short)GrandExchangeEvent.method97(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
			if (Client.field897 <= 0) {
				Client.field897 = 256;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) {
			class320.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) {
			class320.Interpreter_intStackSize -= 4;
			Client.field900 = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			if (Client.field900 <= 0) {
				Client.field900 = 1;
			}

			Client.field673 = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (Client.field673 <= 0) {
				Client.field673 = 32767;
			} else if (Client.field673 < Client.field900) {
				Client.field673 = Client.field900;
			}

			Client.field819 = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			if (Client.field819 <= 0) {
				Client.field819 = 1;
			}

			Client.field903 = (short)Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			if (Client.field903 <= 0) {
				Client.field903 = 32767;
			} else if (Client.field903 < Client.field819) {
				Client.field903 = Client.field819;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.viewportWidget != null) {
				GrandExchangeOfferUnitPriceComparator.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = UserComparator3.method3499(Client.field908);
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = UserComparator3.method3499(Client.field897);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Username.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapData_1.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
