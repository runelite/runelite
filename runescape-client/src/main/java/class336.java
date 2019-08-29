import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lr")
public class class336 {
	@ObfuscatedName("d")
	static final int[] field4022;
	@ObfuscatedName("f")
	static final int[] field4015;

	static {
		field4022 = new int[2048];
		field4015 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4022[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4015[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
