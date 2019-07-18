import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hl")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3107("runescape", "RuneScape", 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3106("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3112("game3", "Game 3", 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3108("game4", "Game 4", 3),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3109("game5", "Game 5", 4),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	field3110("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("b")
	@Export("name")
	public final String name;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1180818879
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-1636258729"
	)
	static int method4137(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = HealthBar.method1957(class268.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
