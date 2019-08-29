import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 343295379
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -213865641
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1172808511
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-404678806"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;IB)V",
		garbageValue = "40"
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
