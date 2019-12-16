import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	field3850(1, 1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	field3853(2, 2);

	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1693216809
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -19931109
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-1700551628"
	)
	public static void method6117(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}
}
