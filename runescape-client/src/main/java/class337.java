import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ls")
public class class337 {
	@ObfuscatedName("m")
	static final int[] field4016;
	@ObfuscatedName("p")
	static final int[] field4025;

	static {
		field4016 = new int[2048];
		field4025 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4016[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4025[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}
