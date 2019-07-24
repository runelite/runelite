import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Players")
public class Players {
	@ObfuscatedName("e")
	static byte[] field1252;
	@ObfuscatedName("p")
	static byte[] field1250;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "[Lkf;"
	)
	static Buffer[] field1254;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1230820149
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("b")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1347586957
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("c")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("f")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("m")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("u")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1998791081
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("r")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	static Buffer field1264;

	static {
		field1252 = new byte[2048];
		field1250 = new byte[2048];
		field1254 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1264 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-86"
	)
	static final void method2092(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					class32.field282[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var5 == var0 + var2 && var5 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
					}

					if (var4 == var3 + var1 && var4 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
					}
				}
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	public static void method2093() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3144 != 0) {
				ArchiveDiskActionHandler.field3144 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "2142202681"
	)
	static final boolean method2091(int var0, int var1) {
		ObjectDefinition var2 = ViewportMouse.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4589(var1);
	}
}
