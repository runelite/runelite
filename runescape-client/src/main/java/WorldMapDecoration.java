import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("j")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1750985939
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1852317111
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -999220947
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "-80"
	)
	static int method355(int var0, Script var1, boolean var2) {
		Widget var3 = Language.getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.method1655(MenuAction.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.IF_GETOP) {
			if (var0 == ScriptOpcodes.IF_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
