import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class248 {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Z",
		garbageValue = "-1891456461"
	)
	@Export("isNumber")
	public static boolean isNumber(CharSequence var0) {
		return ClanMate.method5073(var0, 10, true);
	}
}
