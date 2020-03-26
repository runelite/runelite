import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1084826611
	)
	public static int field1187;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1589469367
	)
	static int field1182;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1155763571
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "2128537982"
	)
	static int method2157(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lle;",
		garbageValue = "-2121463415"
	)
	static IndexedSprite method2165() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class335.SpriteBuffer_spriteWidth;
		var0.height = class335.SpriteBuffer_spriteHeight;
		var0.xOffset = class335.SpriteBuffer_xOffsets[0];
		var0.yOffset = StructDefinition.SpriteBuffer_yOffsets[0];
		var0.subWidth = class335.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class335.SpriteBuffer_spriteHeights[0];
		var0.palette = DefaultsGroup.SpriteBuffer_spritePalette;
		var0.pixels = class4.SpriteBuffer_pixels[0];
		Ignored.method5235();
		return var0;
	}
}
