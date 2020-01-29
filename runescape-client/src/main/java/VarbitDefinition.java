import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	static Widget field3296;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1323501577
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1019762327
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1631697359
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "2025380106"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "-1332372720"
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
