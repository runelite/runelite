import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public enum class160 implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field1988(2, 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field1982(1, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field1984(3, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field1983(0, 3);

	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1967639255
	)
	public final int field1986;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -2042694255
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field1986 = var3;
		this.id = var4;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "1"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIS)I",
		garbageValue = "338"
	)
	static int method3383(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		return NetCache.NetCache_currentResponse != null && NetCache.NetCache_currentResponse.key == var2 ? NetCache.NetCache_responseArchiveBuffer.offset * 99 / (NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1 : 0;
	}
}
