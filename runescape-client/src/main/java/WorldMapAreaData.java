import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("qe")
	@ObfuscatedGetter(
		intValue = 333326797
	)
	static int field323;
	@ObfuscatedName("ew")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 837015313
	)
	static int field329;
	@ObfuscatedName("h")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("k")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("x")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "(Lkc;Lkc;IZI)V",
		garbageValue = "-146974626"
	)
	@Export("init")
	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		signature = "(Lkc;ZB)V",
		garbageValue = "114"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5638();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;IIB)Llw;",
		garbageValue = "-96"
	)
	static IndexedSprite method762(AbstractArchive var0, int var1, int var2) {
		if (!class32.method618(var0, var1, var2)) {
			return null;
		} else {
			IndexedSprite var4 = new IndexedSprite();
			var4.width = class325.SpriteBuffer_spriteWidth;
			var4.height = class325.SpriteBuffer_spriteHeight;
			var4.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[0];
			var4.yOffset = HealthBar.SpriteBuffer_yOffsets[0];
			var4.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[0];
			var4.subHeight = AttackOption.SpriteBuffer_spriteHeights[0];
			var4.palette = class325.SpriteBuffer_spritePalette;
			var4.pixels = class325.SpriteBuffer_pixels[0];
			WorldMapData_1.method787();
			return var4;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)[Lge;",
		garbageValue = "-90"
	)
	public static class185[] method763() {
		return new class185[]{class185.field2296, class185.field2292, class185.field2293, class185.field2294, class185.field2295, class185.field2291, class185.field2298, class185.field2297, class185.field2299, class185.field2300};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "59"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1229220823"
	)
	static boolean method755(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var1)) {
				return true;
			}
		}

		return false;
	}
}
