import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("jz")
	@ObfuscatedGetter(
		intValue = 1984702959
	)
	@Export("plane")
	static int plane;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1437732891
	)
	@Export("width")
	int width;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 2120102399
	)
	@Export("height")
	int height;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1194762567
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1496265891
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lal;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lhp;Ljava/lang/String;Ljava/lang/String;I)Llp;",
		garbageValue = "669461373"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite var5;
		if (!VertexNormal.method2962(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite var7 = new IndexedSprite();
			var7.width = class325.SpriteBuffer_spriteWidth;
			var7.height = Frames.SpriteBuffer_spriteHeight;
			var7.xOffset = class325.SpriteBuffer_xOffsets[0];
			var7.yOffset = MusicPatchPcmStream.SpriteBuffer_yOffsets[0];
			var7.subWidth = class325.SpriteBuffer_spriteWidths[0];
			var7.subHeight = RunException.SpriteBuffer_spriteHeights[0];
			var7.palette = class325.SpriteBuffer_spritePalette;
			var7.pixels = PacketBufferNode.SpriteBuffer_pixels[0];
			class325.SpriteBuffer_xOffsets = null;
			MusicPatchPcmStream.SpriteBuffer_yOffsets = null;
			class325.SpriteBuffer_spriteWidths = null;
			RunException.SpriteBuffer_spriteHeights = null;
			class325.SpriteBuffer_spritePalette = null;
			PacketBufferNode.SpriteBuffer_pixels = null;
			var5 = var7;
		}

		return var5;
	}
}
