import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("av")
	static String field3288;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 928721065
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 92662329
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2061625257
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-1741375018"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "1555734488"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.baseVar = var1.readUnsignedShort();
			this.startBit = var1.readUnsignedByte();
			this.endBit = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-49"
	)
	static final void method4651(String var0) {
		StringBuilder var10000 = (new StringBuilder()).append(var0);
		Object var10001 = null;
		String var1 = var10000.append(" is already on your ignore list").toString();
		class30.addGameMessage(30, "", var1);
	}
}
