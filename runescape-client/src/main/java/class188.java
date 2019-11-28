import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class188 {
	@ObfuscatedName("u")
	static int[] field2353;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	static Widget field2352;

	static {
		new Object();
		field2353 = new int[33];
		field2353[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2353[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "470925087"
	)
	static final int method3692(int var0, int var1) {
		int var2 = RouteStrategy.method3640(45365 + var0, 91923 + var1, 4) - 128 + (RouteStrategy.method3640(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (RouteStrategy.method3640(var0, var1, 1) - 128 >> 2);
		var2 = (int)(0.3D * (double)var2) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}
}
