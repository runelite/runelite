import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class173 {
	@ObfuscatedName("n")
	@Export("directions")
	static int[][] directions;
	@ObfuscatedName("q")
	@Export("distances")
	static int[][] distances;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1388693747
	)
	static int field2070;
	@ObfuscatedName("o")
	@Export("bufferX")
	static int[] bufferX;
	@ObfuscatedName("i")
	@Export("bufferY")
	static int[] bufferY;
	@ObfuscatedName("ed")
	static int[] field2074;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(CI)C",
		garbageValue = "-1784750626"
	)
	static char method3720(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "0"
	)
	static final String method3728(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}
}
