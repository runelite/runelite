import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ly")
public class class336 {
	@ObfuscatedName("d")
	static final int[] field4022;
	@ObfuscatedName("m")
	static final int[] field4017;

	static {
		field4022 = new int[2048];
		field4017 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4022[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4017[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}
