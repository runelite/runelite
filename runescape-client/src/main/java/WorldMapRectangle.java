import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("m")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -862599519
	)
	@Export("width")
	int width;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1046105525
	)
	@Export("height")
	int height;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -686803507
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1467646057
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Laj;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1965047031"
	)
	static int method255(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-228783790"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (TaskHandler.loadInterface(var0)) {
			class32.runComponentCloseListeners(class289.Widget_interfaceComponents[var0], var1);
		}
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "262144"
	)
	static void method257() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (TaskHandler.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = class289.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = Player.getWidget(var4);
					if (var5 != null) {
						WorldMapID.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
