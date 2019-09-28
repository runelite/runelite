import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	field3856(1, 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	field3857(2, 2);

	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -640256921
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -532498775
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Llf;",
		garbageValue = "1508787563"
	)
	static Sprite method6030() {
		Sprite var0 = new Sprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = Frames.SpriteBuffer_spriteHeight;
		var0.xOffset = class325.SpriteBuffer_xOffsets[0];
		var0.yOffset = MusicPatchPcmStream.SpriteBuffer_yOffsets[0];
		var0.subWidth = class325.SpriteBuffer_spriteWidths[0];
		var0.subHeight = RunException.SpriteBuffer_spriteHeights[0];
		int var1 = var0.subHeight * var0.subWidth;
		byte[] var2 = PacketBufferNode.SpriteBuffer_pixels[0];
		var0.pixels = new int[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var0.pixels[var3] = class325.SpriteBuffer_spritePalette[var2[var3] & 255];
		}

		class325.SpriteBuffer_xOffsets = null;
		MusicPatchPcmStream.SpriteBuffer_yOffsets = null;
		class325.SpriteBuffer_spriteWidths = null;
		RunException.SpriteBuffer_spriteHeights = null;
		class325.SpriteBuffer_spritePalette = null;
		PacketBufferNode.SpriteBuffer_pixels = null;
		return var0;
	}
}
