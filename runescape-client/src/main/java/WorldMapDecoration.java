import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("z")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1778683289
	)
	static int field212;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1500590687
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1614020575
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1580531439
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "-119"
	)
	static int method324(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		}

		Strings.method4120(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = Client.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = WorldMapArea.getItemDefinition(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | var6.isStackable == 1) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2619 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2619;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)V",
		garbageValue = "-125"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < ItemDefinition.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = WorldMapArea.getItemDefinition(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					FloorOverlayDefinition.foundItemIdCount = -1;
					WorldMapData_1.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		WorldMapData_1.foundItemIds = var2;
		class32.foundItemIndex = 0;
		FloorOverlayDefinition.foundItemIdCount = var3;
		String[] var8 = new String[FloorOverlayDefinition.foundItemIdCount];

		for (int var9 = 0; var9 < FloorOverlayDefinition.foundItemIdCount; ++var9) {
			var8[var9] = WorldMapArea.getItemDefinition(var2[var9]).name;
		}

		MenuAction.startSortingItemsByName(var8, WorldMapData_1.foundItemIds);
	}
}
