import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1040001761
	)
	@Export("width")
	public final int width;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1175946867
	)
	@Export("height")
	public final int height;
	@ObfuscatedName("o")
	@Export("xWidths")
	public final int[] xWidths;
	@ObfuscatedName("e")
	@Export("xStarts")
	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "2110686779"
	)
	@Export("contains")
	public boolean contains(int var1, int var2) {
		if (var2 >= 0 && var2 < this.xStarts.length) {
			int var3 = this.xStarts[var2];
			if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Lhn;",
		garbageValue = "-27"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = Varps.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "398303875"
	)
	public static int method4038() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-1864431963"
	)
	@Export("SpriteBuffer_decode")
	public static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class326.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		Huffman.SpriteBuffer_xOffsets = new int[class326.SpriteBuffer_spriteCount];
		NPC.SpriteBuffer_yOffsets = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_spriteWidths = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_spriteHeights = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_pixels = new byte[class326.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class326.SpriteBuffer_spriteCount * 8;
		GZipDecompressor.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class326.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			Huffman.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			NPC.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			class326.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			class326.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class326.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class326.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class326.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class326.SpriteBuffer_spritePalette[var3] == 0) {
				class326.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			int var4 = class326.SpriteBuffer_spriteWidths[var3];
			int var5 = class326.SpriteBuffer_spriteHeights[var3];
			int var6 = var5 * var4;
			byte[] var7 = new byte[var6];
			class326.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}
}
