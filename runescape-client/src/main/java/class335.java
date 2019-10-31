import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public abstract class class335 {
	@ObfuscatedName("bq")
	static String field4016;

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhi;B)Ljava/lang/String;",
		garbageValue = "38"
	)
	static String method6661(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					var0 = var0.substring(0, var3) + class173.method3728(class4.method73(var1, var2 - 1)) + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
