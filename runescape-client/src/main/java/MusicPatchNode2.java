import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gg")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "Llr;"
	)
	static Bounds field2369;
	@ObfuscatedName("c")
	byte[] field2365;
	@ObfuscatedName("x")
	byte[] field2361;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 111263501
	)
	int field2368;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 618770801
	)
	int field2360;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 616473833
	)
	int field2364;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -479359019
	)
	int field2363;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1576699207
	)
	int field2366;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2126224299
	)
	int field2367;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 339059033
	)
	int field2370;

	MusicPatchNode2() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-634952153"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "-15"
	)
	static int method3666(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.OC_NAME) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = Player.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == ScriptOpcodes.OC_OP) {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				var5 = Player.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_IOP) {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				var5 = Player.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_COST) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Player.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == ScriptOpcodes.OC_STACKABLE) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Player.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == ScriptOpcodes.OC_CERT) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					var6 = Player.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNCERT) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					var6 = Player.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_MEMBERS) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Player.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.OC_PLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					var6 = Player.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNPLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					var6 = Player.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_FIND) {
					String var7 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					KeyHandler.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GrandExchangeOfferNameComparator.foundItemIdCount;
					return 1;
				} else if (var0 != ScriptOpcodes.OC_FINDNEXT) {
					if (var0 == ScriptOpcodes.OC_FINDRESET) {
						ArchiveLoader.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (BoundaryObject.foundItemIds != null && ArchiveLoader.foundItemIndex < GrandExchangeOfferNameComparator.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = BoundaryObject.foundItemIds[++ArchiveLoader.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}
}
