import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("VarcInt_archive")
	static AbstractArchive VarcInt_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("VarcInt_cached")
	static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -59845961
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("t")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;B)V",
		garbageValue = "9"
	)
	void method4394(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4395(var1, var2);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkz;IB)V",
		garbageValue = "-46"
	)
	void method4395(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-1900079219"
	)
	public static void method4407(AbstractArchive var0) {
		ParamDefinition.ParamDefinition_archive = var0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lie;",
		garbageValue = "-105"
	)
	static HorizontalAlignment[] method4396() {
		return new HorizontalAlignment[]{HorizontalAlignment.field3430, HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3428};
	}
}
