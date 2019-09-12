import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class43 {
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	static StudioGame field359;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 121062689
	)
	public static int field361;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkt;I)I",
		garbageValue = "-1826944981"
	)
	@Export("decode")
	static int decode(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-980502076"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}
}
