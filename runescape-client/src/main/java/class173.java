import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class173 {
	@ObfuscatedName("b")
	@Export("directions")
	static int[][] directions;
	@ObfuscatedName("g")
	@Export("distances")
	static int[][] distances;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1442430251
	)
	static int field2103;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -101086935
	)
	static int field2100;
	@ObfuscatedName("y")
	@Export("bufferX")
	static int[] bufferX;
	@ObfuscatedName("w")
	@Export("bufferY")
	static int[] bufferY;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "826703684"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
