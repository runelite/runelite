import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
public final class class296 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -8842260306920147949L
	)
	static long field3680;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = 5493991192687993425L
	)
	static long field3681;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-227117259"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = GrandExchangeOfferUnitPriceComparator.getPreferencesFile("", class43.field359.name, true);
			Buffer var1 = Actor.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}
}
