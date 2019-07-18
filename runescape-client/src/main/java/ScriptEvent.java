import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bb")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("sr")
	@ObfuscatedSignature(
		signature = "Lkm;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 804778347
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("o")
	static String field586;
	@ObfuscatedName("q")
	@Export("args")
	Object[] args;
	@ObfuscatedName("w")
	@Export("boolean1")
	boolean boolean1;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 360702413
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -863206641
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1116555521
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1918711245
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1718694615
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("f")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1456070935
	)
	int field583;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1715146039
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;B)V",
		garbageValue = "27"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "141891736"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2123129182"
	)
	static int method1121() {
		return 11;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-2135238303"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		class14.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "1342533566"
	)
	static int method1127(int var0, Script var1, boolean var2) {
		Widget var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(IIIS)I",
		garbageValue = "-366"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] * var6 + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var7 * var9 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1493130068"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(Lhj;I)Z",
		garbageValue = "2063123103"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}
