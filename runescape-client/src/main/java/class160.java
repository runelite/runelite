import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public enum class160 implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	field2009(1, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	field2008(0, 1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	field2006(3, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	field2005(2, 3);

	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -406777895
	)
	public final int field2007;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -141760123
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field2007 = var3;
		this.id = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "684662102"
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

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "7"
	)
	static final void method3494(int var0) {
		if (UserComparator3.loadInterface(var0)) {
			MusicPatchPcmStream.drawModelComponents(FloorDecoration.Widget_interfaceComponents[var0], -1);
		}
	}
}
