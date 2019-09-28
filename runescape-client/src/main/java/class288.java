import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public final class class288 {
	@ObfuscatedName("z")
	@Export("base37Table")
	public static final char[] base37Table;
	@ObfuscatedName("n")
	static long[] field3638;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3638 = new long[12];

		for (int var0 = 0; var0 < field3638.length; ++var0) {
			field3638[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "757556043"
	)
	public static int method5224(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}
}
