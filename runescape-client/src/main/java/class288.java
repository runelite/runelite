import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public final class class288 {
	@ObfuscatedName("f")
	@Export("base37Table")
	static final char[] base37Table;
	@ObfuscatedName("i")
	static long[] field3631;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3631 = new long[12];

		for (int var0 = 0; var0 < field3631.length; ++var0) {
			field3631[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("w")
	public static int method5334(long var0) {
		return (int)(var0 >>> 0 & 127L);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "56"
	)
	static final void method5335(String var0) {
		Tiles.method1143(var0 + " is already on your friend list");
	}
}
