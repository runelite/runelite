import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class81 {
	@ObfuscatedName("qg")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("bg")
	@Export("otp")
	static String otp;

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "910653188"
	)
	static final String method2032(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}
}
