import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2710(0, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2700(1, 0),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2701(2, 0),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2702(3, 0),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2708(9, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2712(4, 1),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2705(5, 1),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2713(6, 1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2703(7, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2706(8, 1),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2709(12, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2719(13, 2),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2711(14, 2),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2707(15, 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2699(16, 2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2714(17, 2),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2715(18, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2716(19, 2),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2717(20, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2718(21, 2),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2704(10, 2),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2720(11, 2),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	field2721(22, 3);

	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -240297385
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
