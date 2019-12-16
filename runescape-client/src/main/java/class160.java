import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public enum class160 implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	field1988(2, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	field1984(1, 1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	field1985(3, 2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	field1986(0, 3);

	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -410013457
	)
	public final int field1987;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1136729991
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field1987 = var3;
		this.id = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "1384182754"
	)
	public static void method3432(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}
}
