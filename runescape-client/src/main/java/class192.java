import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public enum class192 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2380("", 0, new class191[]{class191.field2373}),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2375("", 1, new class191[]{class191.field2368, class191.field2373}),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2376("", 2, new class191[]{class191.field2368, class191.field2370, class191.field2373}),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2382("", 3, new class191[]{class191.field2368}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2378("", 4),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2379("", 5, new class191[]{class191.field2368, class191.field2373}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2377("", 6, new class191[]{class191.field2373}),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2390("", 8, new class191[]{class191.field2368, class191.field2373}),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2384("", 9, new class191[]{class191.field2368, class191.field2370}),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2383("", 10, new class191[]{class191.field2368}),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2395("", 11, new class191[]{class191.field2368}),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2385("", 12, new class191[]{class191.field2368, class191.field2373}),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	field2374("", 13, new class191[]{class191.field2368});

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;
	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "Lba;"
	)
	@Export("localPlayer")
	static Player localPlayer;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1568676187
	)
	@Export("id")
	final int id;
	@ObfuscatedName("x")
	final Set field2388;

	static {
		method3732();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgx;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2388 = new HashSet();
		this.id = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2388.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2388 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lgp;",
		garbageValue = "39"
	)
	static class192[] method3732() {
		return new class192[]{field2376, field2390, field2378, field2395, field2382, field2383, field2377, field2375, field2385, field2380, field2379, field2384, field2374};
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lhn;II)V",
		garbageValue = "558596528"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2702 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2711 == null) {
				var0.field2711 = new int[var0.field2702.length];
			}

			var0.field2711[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1858643445"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}
