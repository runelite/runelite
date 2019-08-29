import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2701(0, 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2703(1, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2702(2, 0),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2704(3, 0),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2721(9, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2718(4, 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2706(5, 1),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2707(6, 1),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2708(7, 1),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2709(8, 1),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2710(12, 2),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2700(13, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2712(14, 2),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2713(15, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2714(16, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2715(17, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2716(18, 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2717(19, 2),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2720(20, 2),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2719(21, 2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2711(10, 2),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2705(11, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	field2722(22, 3);

	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1508062065
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "10"
	)
	static final void method4030(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field733 == -1) {
				Client.field733 = var0.spriteId2;
				Client.field888 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field733;
			} else {
				var0.spriteId2 = Client.field888;
			}

		} else if (var1 == 325) {
			if (Client.field733 == -1) {
				Client.field733 = var0.spriteId2;
				Client.field888 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field888;
			} else {
				var0.spriteId2 = Client.field733;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}
