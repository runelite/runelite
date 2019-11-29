import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class266 {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("ItemDefinition_modelArchive")
	static AbstractArchive ItemDefinition_modelArchive;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1187459015"
	)
	public static int method5065(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-67"
	)
	static final int method5066(int var0, int var1) {
		int var2 = GrandExchangeOfferWorldComparator.method76(var0 - 1, var1 - 1) + GrandExchangeOfferWorldComparator.method76(1 + var0, var1 - 1) + GrandExchangeOfferWorldComparator.method76(var0 - 1, 1 + var1) + GrandExchangeOfferWorldComparator.method76(1 + var0, var1 + 1);
		int var3 = GrandExchangeOfferWorldComparator.method76(var0 - 1, var1) + GrandExchangeOfferWorldComparator.method76(1 + var0, var1) + GrandExchangeOfferWorldComparator.method76(var0, var1 - 1) + GrandExchangeOfferWorldComparator.method76(var0, 1 + var1);
		int var4 = GrandExchangeOfferWorldComparator.method76(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "(Lij;Ljava/lang/String;I)V",
		garbageValue = "-1313176939"
	)
	static void method5064(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field914 += var2.groupCount;
	}
}
