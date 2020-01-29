import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cz")
@Implements("Players")
public class Players {
	@ObfuscatedName("o")
	static byte[] field1236;
	@ObfuscatedName("e")
	static byte[] field1237;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Lkp;"
	)
	static Buffer[] field1235;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 896237733
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("d")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1595990081
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("j")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("m")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("p")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("h")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -564068269
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("n")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	static Buffer field1248;

	static {
		field1236 = new byte[2048];
		field1237 = new byte[2048];
		field1235 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1248 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static void method2179() {
		Tiles.field502 = null;
		Tiles.field514 = null;
		Tiles.field507 = null;
		Tiles.field518 = null;
		UrlRequest.field1940 = null;
		InterfaceParent.field565 = null;
		Tiles.field509 = null;
		class268.Tiles_hue = null;
		HorizontalAlignment.Tiles_saturation = null;
		class30.Tiles_lightness = null;
		class40.Tiles_hueMultiplier = null;
		TileItemPile.field1529 = null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "41"
	)
	static int method2203(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		NPCDefinition.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = class192.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			class320.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = HealthBarDefinition.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2627 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2627;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-603173589"
	)
	static int method2200(int var0, Script var1, boolean var2) {
		Widget var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class83.method2108(WorldMapIcon_0.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.IF_GETOP) {
			if (var0 == ScriptOpcodes.IF_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1574244944"
	)
	static boolean method2201() {
		return Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1351198777"
	)
	static final void method2189() {
		Client.field823 = Client.cycleCntr;
		FileSystem.ClanChat_inClanChat = true;
	}
}
