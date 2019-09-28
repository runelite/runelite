import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("VarcInt_cached")
	public static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("v")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	public VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "32"
	)
	public void method4372(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4375(var1, var2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-773678840"
	)
	void method4375(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}
}
