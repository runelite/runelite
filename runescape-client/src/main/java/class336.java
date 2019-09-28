import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lc")
public class class336 {
	@ObfuscatedName("i")
	static final int[] field4019;
	@ObfuscatedName("c")
	static final int[] field4023;

	static {
		field4019 = new int[2048];
		field4023 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4019[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4023[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}
