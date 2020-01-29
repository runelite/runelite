import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hl")
public class class215 {
	@ObfuscatedName("c")
	public static final short[] field2552;
	@ObfuscatedName("t")
	public static final short[][] field2553;
	@ObfuscatedName("o")
	public static final short[] field2551;
	@ObfuscatedName("e")
	public static final short[][] field2550;

	static {
		field2552 = new short[]{6798, 8741, 25238, 4626, 4550};
		field2553 = new short[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574, 17050, 0, 127, -31821, -17991}};
		field2551 = new short[]{-10304, 9104, -1, -1, -1};
		field2550 = new short[][]{{6554, 115, 10304, 28, 5702, 7756, 5681, 4510, -31835, 22437, 2859, -11339, 16, 5157, 10446, 3658, -27314, -21965, 472, 580, 784, 21966, 28950, -15697, -14002}, {9104, 10275, 7595, 3610, 7975, 8526, 918, -26734, 24466, 10145, -6882, 5027, 1457, 16565, -30545, 25486, 24, 5392, 10429, 3673, -27335, -21957, 192, 687, 412, 21821, 28835, -15460, -14019}, new short[0], new short[0], new short[0]};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1561173160"
	)
	public static boolean method4098(int var0) {
		return var0 >= WorldMapDecorationType.field2745.id && var0 <= WorldMapDecorationType.field2743.id || var0 == WorldMapDecorationType.field2731.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "694265638"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		Tile.method2927(var0, var1, "openjs", var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-329192495"
	)
	public static void method4095() {
		ParamDefinition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2141747621"
	)
	static void method4101(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1319059426"
	)
	static int method4100(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.OC_NAME) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == ScriptOpcodes.OC_OP) {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				var5 = HealthBarDefinition.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_IOP) {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				var5 = HealthBarDefinition.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_COST) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == ScriptOpcodes.OC_STACKABLE) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == ScriptOpcodes.OC_CERT) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					var6 = HealthBarDefinition.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNCERT) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					var6 = HealthBarDefinition.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_MEMBERS) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = HealthBarDefinition.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.OC_PLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					var6 = HealthBarDefinition.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNPLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					var6 = HealthBarDefinition.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_FIND) {
					String var7 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					class42.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class162.foundItemIdCount;
					return 1;
				} else if (var0 != ScriptOpcodes.OC_FINDNEXT) {
					if (var0 == ScriptOpcodes.OC_FINDRESET) {
						AbstractByteArrayCopier.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (WorldMapData_0.foundItemIds != null && AbstractByteArrayCopier.foundItemIndex < class162.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapData_0.foundItemIds[++AbstractByteArrayCopier.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}
}
