import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2725(0, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2719(1, 0),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2720(2, 0),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2721(3, 0),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2739(9, 2),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2738(4, 1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2724(5, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2729(6, 1),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2726(7, 1),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2727(8, 1),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2728(12, 2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2718(13, 2),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2730(14, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2731(15, 2),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2732(16, 2),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2740(17, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2734(18, 2),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2735(19, 2),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2736(20, 2),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2737(21, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2733(10, 2),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2722(11, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	field2741(22, 3);

	@ObfuscatedName("ne")
	@ObfuscatedGetter(
		intValue = -797405515
	)
	static int field2742;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1119244565
	)
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
