import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2748(0, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2732(1, 0),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2727(2, 0),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2730(3, 0),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2731(9, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2739(4, 1),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2733(5, 1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2734(6, 1),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2735(7, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2729(8, 1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2737(12, 2),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2738(13, 2),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2742(14, 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2736(15, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2741(16, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2740(17, 2),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2743(18, 2),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2744(19, 2),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2750(20, 2),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2746(21, 2),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2747(10, 2),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2728(11, 2),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	field2749(22, 3);

	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -719905739
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-242773745"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}
}
