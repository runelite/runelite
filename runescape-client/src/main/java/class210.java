import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class210 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhg;"
	)
	@Export("huffman")
	static Huffman huffman;
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive15")
	static Archive archive15;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "1"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}
