import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1053912573
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 684195751
	)
	@Export("height")
	int height;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -2140499041
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1955373001
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -472959783
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1045037505
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 820155369
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1317685703
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1799608733
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 262139045
	)
	int field1909;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -792485469
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = -9063285699696577959L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1504732917
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lgo;S)V",
		garbageValue = "-26939"
	)
	public static void method3296(Huffman var0) {
		class206.huffman = var0;
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1099485994"
	)
	static boolean method3298() {
		return (Client.drawPlayerNames & 1) != 0;
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "3"
	)
	static final void method3297(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetWidths[var4] + Client.rootWidgetXs[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field833[var4] = true;
			}
		}

	}
}
