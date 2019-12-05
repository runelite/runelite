import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ly;Ly;B)I",
		garbageValue = "72"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;I)Ljava/lang/String;",
		garbageValue = "2005210038"
	)
	public static String method142(Buffer var0) {
		return GrandExchangeEvent.method92(var0, 32767);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "76"
	)
	public static int method143(int var0) {
		return WorldMapSectionType.method271(ViewportMouse.ViewportMouse_entityTags[var0]);
	}
}
