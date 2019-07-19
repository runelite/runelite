import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("sh")
	@ObfuscatedGetter(
		intValue = -739683293
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("FloorOverlayDefinition_cached")
	public static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1387781245
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -138481691
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("k")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1829885045
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1785369295
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 844527765
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -649539923
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1982106487
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -241902903
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2090498171
	)
	@Export("secondaryLightness")
	public int secondaryLightness;

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	public FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-866326245"
	)
	@Export("postDecode")
	public void postDecode() {
		if (this.secondaryRgb != -1) {
			this.setHsl(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.setHsl(this.primaryRgb);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "-93"
	)
	@Export("decode")
	public void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;IIB)V",
		garbageValue = "0"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1232631755"
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
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var10 == var4) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var10 == var6) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(256.0D * var12);
		this.saturation = (int)(256.0D * var14);
		this.lightness = (int)(256.0D * var16);
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhj;I[B[BI)V",
		garbageValue = "610677249"
	)
	static final void method4756(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2650 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2650 = new byte[11][];
			var0.field2625 = new byte[11][];
			var0.field2641 = new int[11];
			var0.field2588 = new int[11];
		}

		var0.field2650[var1] = var2;
		if (var2 != null) {
			var0.field2704 = true;
		} else {
			var0.field2704 = false;

			for (int var4 = 0; var4 < var0.field2650.length; ++var4) {
				if (var0.field2650[var4] != null) {
					var0.field2704 = true;
					break;
				}
			}
		}

		var0.field2625[var1] = var3;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "127"
	)
	static final int method4757(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = GroundItemPile.method2765(var3, var5);
		int var8 = GroundItemPile.method2765(var3 + 1, var5);
		int var9 = GroundItemPile.method2765(var3, var5 + 1);
		int var10 = GroundItemPile.method2765(var3 + 1, var5 + 1);
		int var11 = class4.method49(var7, var8, var4, var2);
		int var12 = class4.method49(var9, var10, var4, var2);
		return class4.method49(var11, var12, var6, var2);
	}
}
