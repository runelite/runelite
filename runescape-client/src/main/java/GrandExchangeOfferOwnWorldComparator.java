import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("rs")
	@ObfuscatedGetter(
		intValue = 756915395
	)
	static int field623;
	@ObfuscatedName("eu")
	static int[] field626;
	@ObfuscatedName("gf")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;
	@ObfuscatedName("f")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lx;Lx;I)I",
		garbageValue = "-1149746990"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-524151860"
	)
	static final int method1288() {
		return Client.menuOptionsCount - 1;
	}
}
