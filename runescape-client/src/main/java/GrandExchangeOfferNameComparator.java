import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("GrandExchangeOfferNameComparator")
final class GrandExchangeOfferNameComparator implements Comparator {
	@ObfuscatedName("ne")
	@ObfuscatedGetter(
		intValue = 1296404691
	)
	static int field79;
	@ObfuscatedName("sp")
	@ObfuscatedGetter(
		intValue = -1426574287
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("ObjectDefinition_archive")
	public static AbstractArchive ObjectDefinition_archive;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lv;Lv;I)I",
		garbageValue = "576633421"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;I)[Llt;",
		garbageValue = "-527219234"
	)
	public static IndexedSprite[] method122(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		byte[] var7 = var0.takeFile(var3, var4);
		boolean var6;
		if (var7 == null) {
			var6 = false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var7);
			var6 = true;
		}

		IndexedSprite[] var5;
		if (!var6) {
			var5 = null;
		} else {
			var5 = FileSystem.method3489();
		}

		return var5;
	}
}
