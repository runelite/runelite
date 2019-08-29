import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cb")
@Implements("Players")
public class Players {
	@ObfuscatedName("i")
	static byte[] field1221;
	@ObfuscatedName("k")
	static byte[] field1230;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Lky;"
	)
	static Buffer[] field1219;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1067165743
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("t")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2082496335
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("x")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("d")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("f")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("c")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 504447411
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("y")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	static Buffer field1233;

	static {
		field1221 = new byte[2048];
		field1230 = new byte[2048];
		field1219 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1233 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "578310351"
	)
	static int method2063(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class286.field3623 : class297.field3693;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
