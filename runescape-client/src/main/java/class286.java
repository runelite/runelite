import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class286 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([I[II)V",
		garbageValue = "1632761415"
	)
	public static void method5353(int[] var0, int[] var1) {
		if (var0 != null && var1 != null) {
			WorldMapSprite.ByteArrayPool_alternativeSizes = var0;
			class216.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
			ByteArrayPool.ByteArrayPool_arrays = new byte[var0.length][][];

			for (int var2 = 0; var2 < WorldMapSprite.ByteArrayPool_alternativeSizes.length; ++var2) {
				ByteArrayPool.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
			}

		} else {
			WorldMapSprite.ByteArrayPool_alternativeSizes = null;
			class216.ByteArrayPool_altSizeArrayCounts = null;
			ByteArrayPool.ByteArrayPool_arrays = null;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-62"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lba;",
		garbageValue = "-1661188846"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIII)I",
		garbageValue = "1010446499"
	)
	static final int method5346(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}
}
