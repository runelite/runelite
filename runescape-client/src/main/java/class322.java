import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public enum class322 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3825(1, 0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3826(2, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3827(3, 5),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3832(0, 6),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3829(5, 7),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	field3830(4, 8);

	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1073054417
	)
	final int field3831;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1340728697
	)
	final int field3828;

	class322(int var3, int var4) {
		this.field3831 = var3;
		this.field3828 = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3828;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Liy;II)Lle;",
		garbageValue = "-1469260030"
	)
	public static IndexedSprite method5972(AbstractArchive var0, int var1) {
		return !class228.method4202(var0, var1) ? null : AttackOption.method2165();
	}
}
