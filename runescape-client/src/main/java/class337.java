import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("li")
public class class337 {
	@ObfuscatedName("f")
	static final int[] field4046;
	@ObfuscatedName("m")
	static final int[] field4047;

	static {
		field4046 = new int[2048];
		field4047 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4046[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
			field4047[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
