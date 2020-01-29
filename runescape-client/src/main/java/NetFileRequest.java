import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -335622229
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("o")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([I[IB)V",
		garbageValue = "100"
	)
	public static void method4217(int[] var0, int[] var1) {
		if (var0 != null && var1 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var0;
			VerticalAlignment.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
			ByteArrayPool.ByteArrayPool_arrays = new byte[var0.length][][];

			for (int var2 = 0; var2 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var2) {
				ByteArrayPool.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
			}

		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			VerticalAlignment.ByteArrayPool_altSizeArrayCounts = null;
			ByteArrayPool.ByteArrayPool_arrays = null;
		}
	}
}
