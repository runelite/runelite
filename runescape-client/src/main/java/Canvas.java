import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("qn")
	@ObfuscatedGetter(
		intValue = 739574061
	)
	static int field397;
	@ObfuscatedName("gk")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("f")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-7"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;I)Lli;",
		garbageValue = "-1768952191"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite var5;
		if (!HitSplatDefinition.method4586(var0, var3, var4)) {
			var5 = null;
		} else {
			var5 = WorldMapDecoration.method327();
		}

		return var5;
	}

	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		signature = "(I)Lld;",
		garbageValue = "-228805350"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return GrandExchangeEvent.worldMap;
	}
}
