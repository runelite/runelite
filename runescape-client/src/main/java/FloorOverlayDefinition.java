import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("FloorOverlayDefinition_cached")
	static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	static Widget field3507;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1374985713
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -2103886801
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("z")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1548545133
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -2117743259
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 259844631
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1486642951
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1953195007
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1833494779
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1532984689
	)
	@Export("secondaryLightness")
	public int secondaryLightness;

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1381729137"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.secondaryRgb != -1) {
			this.setHsl(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.setHsl(this.primaryRgb);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "-157824233"
	)
	@Export("decode")
	void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;III)V",
		garbageValue = "-2104384515"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.primaryRgb = var1.readMedium();
		} else if (var2 == 2) {
			this.texture = var1.readUnsignedByte();
		} else if (var2 == 5) {
			this.hideUnderlay = false;
		} else if (var2 == 7) {
			this.secondaryRgb = var1.readMedium();
		} else if (var2 == 8) {
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1137503330"
	)
	@Export("setHsl")
	void setHsl(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var8 + var10) / 2.0D;
		if (var10 != var8) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var10 + var8);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var4 == var10) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var6 == var10) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(256.0D * var12);
		this.saturation = (int)(var14 * 256.0D);
		this.lightness = (int)(var16 * 256.0D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "([BI)Lky;",
		garbageValue = "1533965281"
	)
	static Font method4853(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, UrlRequester.SpriteBuffer_xOffsets, class216.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, VarcInt.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, FillMode.SpriteBuffer_pixels);
			PcmPlayer.method2510();
			return var1;
		}
	}
}
