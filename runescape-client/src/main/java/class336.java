import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
public class class336 {
	@ObfuscatedName("z")
	static final int[] field4016;
	@ObfuscatedName("n")
	static final int[] field4020;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("NetCache_responseArchiveBuffer")
	public static Buffer NetCache_responseArchiveBuffer;

	static {
		field4016 = new int[2048];
		field4020 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4016[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4020[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
