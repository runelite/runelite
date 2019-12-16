import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Players")
public class Players {
	@ObfuscatedName("y")
	static byte[] field1230;
	@ObfuscatedName("w")
	static byte[] field1231;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lkq;"
	)
	static Buffer[] field1228;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 563300255
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("e")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2029432023
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("a")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("d")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("c")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("o")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1629507645
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("k")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	static Buffer field1242;

	static {
		field1230 = new byte[2048];
		field1231 = new byte[2048];
		field1228 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1242 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([I[II)V",
		garbageValue = "635493100"
	)
	public static void method2161(int[] var0, int[] var1) {
		if (var0 != null && var1 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var0;
			Interpreter.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
			ByteArrayPool.ByteArrayPool_arrays = new byte[var0.length][][];

			for (int var2 = 0; var2 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var2) {
				ByteArrayPool.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
			}

		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			Interpreter.ByteArrayPool_altSizeArrayCounts = null;
			ByteArrayPool.ByteArrayPool_arrays = null;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "98747389"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (MusicPatch.loadInterface(var0)) {
				Widget[] var1 = UserComparator7.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						GrandExchangeEvents.runScript(var4, 5000000);
					}
				}

			}
		}
	}
}
