import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -927244413
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -326860353
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1659687913
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "113"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "842018241"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.baseVar = var1.readUnsignedShort();
			this.startBit = var1.readUnsignedByte();
			this.endBit = var1.readUnsignedByte();
		}

	}
}
