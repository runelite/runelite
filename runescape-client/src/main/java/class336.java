import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lv")
public class class336 {
	@ObfuscatedName("i")
	static final int[] field4020;
	@ObfuscatedName("k")
	static final int[] field4021;

	static {
		field4020 = new int[2048];
		field4021 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4020[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4021[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
