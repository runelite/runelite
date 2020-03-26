import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mc")
public class class346 {
	@ObfuscatedName("e")
	static final int[] field4043;
	@ObfuscatedName("s")
	static final int[] field4047;

	static {
		field4043 = new int[2048];
		field4047 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4043[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4047[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}
