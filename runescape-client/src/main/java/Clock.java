import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("Clock")
public abstract class Clock {
	@ObfuscatedName("by")
	static String field2037;

	Clock() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-779324795"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "930751718"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;IIB)Llq;",
		garbageValue = "-2"
	)
	@Export("SpriteBuffer_getIndexedSprite")
	static IndexedSprite SpriteBuffer_getIndexedSprite(AbstractArchive var0, int var1, int var2) {
		if (!World.SpriteBuffer_bufferFile(var0, var1, var2)) {
			return null;
		} else {
			IndexedSprite var4 = new IndexedSprite();
			var4.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
			var4.height = class325.SpriteBuffer_spriteHeight;
			var4.xOffset = class325.SpriteBuffer_xOffsets[0];
			var4.yOffset = class325.SpriteBuffer_yOffsets[0];
			var4.subWidth = class325.SpriteBuffer_spriteWidths[0];
			var4.subHeight = class225.SpriteBuffer_spriteHeights[0];
			var4.palette = class325.SpriteBuffer_spritePalette;
			var4.pixels = WorldMapSection1.SpriteBuffer_pixels[0];
			UserComparator7.SpriteBuffer_clear();
			return var4;
		}
	}
}
