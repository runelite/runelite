import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class293 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_modelsArchive")
	static AbstractArchive Widget_modelsArchive;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "97"
	)
	public static void method5298(AbstractArchive var0) {
		VarcInt.VarcInt_archive = var0;
	}
}
