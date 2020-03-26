import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class234 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SB)V",
		garbageValue = "-127"
	)
	public static void method4221(String[] var0, short[] var1) {
		GrandExchangeOffer.sortItemsByName(var0, var1, 0, var0.length - 1);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "-31"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
