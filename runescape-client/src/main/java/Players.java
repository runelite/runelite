import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Players")
public class Players {
	@ObfuscatedName("rh")
	@ObfuscatedGetter(
		intValue = 1328419047
	)
	static int field1280;
	@ObfuscatedName("k")
	static byte[] field1267;
	@ObfuscatedName("d")
	static byte[] field1273;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lkb;"
	)
	static Buffer[] field1269;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2104068463
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("q")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1941416783
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("t")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("e")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("s")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("p")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1119363991
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("u")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	static Buffer field1268;

	static {
		field1267 = new byte[2048];
		field1273 = new byte[2048];
		field1269 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1268 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;I)V",
		garbageValue = "731875079"
	)
	public static void method2251(AbstractArchive var0) {
		VarcInt.VarcInt_archive = var0;
	}
}
