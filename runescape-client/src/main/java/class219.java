import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class219 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("huffman")
	public static Huffman huffman;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2118207893
	)
	@Export("musicTrackVolume")
	public static int musicTrackVolume;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1086176429
	)
	static int field2515;

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)Llg;",
		garbageValue = "1957450330"
	)
	public static PrivateChatMode method4052(int var0) {
		PrivateChatMode[] var1 = class300.method5368();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PrivateChatMode var3 = var1[var2];
			if (var0 == var3.field3804) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1658769285"
	)
	public static void method4057(int var0) {
		if (class206.field2406 != 0) {
			musicTrackVolume = var0;
		} else {
			class206.midiPcmStream.setPcmStreamVolume(var0);
		}

	}
}
