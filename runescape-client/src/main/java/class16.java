import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class16 {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "572816821"
	)
	@Export("SpriteBuffer_clear")
	public static void SpriteBuffer_clear() {
		Varps.SpriteBuffer_xOffsets = null;
		SpriteBuffer.SpriteBuffer_yOffsets = null;
		SpriteBuffer.SpriteBuffer_spriteWidths = null;
		class216.SpriteBuffer_spriteHeights = null;
		Frames.SpriteBuffer_spritePalette = null;
		SpriteBuffer.SpriteBuffer_pixels = null;
	}
}
