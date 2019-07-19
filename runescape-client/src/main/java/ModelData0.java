import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eu")
@Implements("ModelData0")
public class ModelData0 {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 109358047
	)
	static int field1871;
	@ObfuscatedName("b")
	public static short[] field1870;
	@ObfuscatedName("i")
	@Export("inMembersWorld")
	public static boolean inMembersWorld;

	ModelData0() {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Lbk;",
		garbageValue = "1887842280"
	)
	@Export("loadClientPreferences")
	static ClientPreferences loadClientPreferences() {
		AccessFile var0 = null;
		ClientPreferences var1 = new ClientPreferences();

		try {
			var0 = WorldMapIcon_0.getPreferencesFile("", WorldMapRegion.field248.name, false);
			byte[] var2 = new byte[(int)var0.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var0.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var1 = new ClientPreferences(new Buffer(var2));
		} catch (Exception var6) {
		}

		try {
			if (var0 != null) {
				var0.close();
			}
		} catch (Exception var5) {
		}

		return var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "-93"
	)
	static int method3250(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			var4 = class80.getWidget(var3);
		} else {
			var4 = var2 ? Interpreter.field1111 : Calendar.field2507;
		}

		if (var0 == ScriptOpcodes.CC_SETPOSITION) {
			HealthBarUpdate.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			Strings.method4120(var4);
			WorldMapSprite.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) {
			HealthBarUpdate.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			Strings.method4120(var4);
			WorldMapSprite.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) {
			boolean var5 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				Strings.method4120(var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}
}
