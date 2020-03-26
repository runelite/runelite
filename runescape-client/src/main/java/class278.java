import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class278 {
	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive19")
	static Archive archive19;

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2135141314"
	)
	static int method5039(int var0) {
		return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
	}
}
