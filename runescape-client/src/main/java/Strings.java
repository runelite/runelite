import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("rx")
	@ObfuscatedGetter(
		intValue = 2019355049
	)
	static int field2759;
	@ObfuscatedName("bd")
	public static String field2811;
	@ObfuscatedName("cy")
	public static String field2914;
	@ObfuscatedName("jm")
	public static String field3026;
	@ObfuscatedName("jh")
	public static String field2898;
	@ObfuscatedName("jk")
	public static String field2807;

	static {
		field2811 = "Please visit the support page for assistance.";
		field2914 = "Please visit the support page for assistance.";
		field3026 = "";
		field2898 = "Page has opened in a new window.";
		field2807 = "(Please check your popup blocker.)";
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IS)Lii;",
		garbageValue = "18624"
	)
	public static ServerBuild method4219(int var0) {
		ServerBuild[] var1 = Language.method3751();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			ServerBuild var3 = var1[var2];
			if (var0 == var3.field3101) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1791203071"
	)
	static final int method4220(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
