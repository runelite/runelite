import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("pa")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("sb")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -135135315
	)
	static int field75;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lv;Lv;I)I",
		garbageValue = "-1189972175"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lgn;",
		garbageValue = "-20"
	)
	public static class185[] method116() {
		return new class185[]{class185.field2298, class185.field2300, class185.field2297, class185.field2299, class185.field2304, class185.field2296, class185.field2302, class185.field2301, class185.field2303, class185.field2305};
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Lmr;",
		garbageValue = "48"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(InvDefinition.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (ViewportMouse.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (ViewportMouse.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(Message.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}
}
