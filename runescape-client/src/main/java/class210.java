import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class210 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhc;"
	)
	@Export("huffman")
	static Huffman huffman;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1848259847"
	)
	public static int method4029(int var0, int var1) {
		return (var0 + 40000 << 8) + var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "11236"
	)
	static void method4032(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		NetFileRequest var4 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var2);
		if (var4 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var4);
		}
	}
}
