import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("FloorOverlayDefinition_cached")
	public static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 54951813
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1779680487
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("l")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -707302109
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1456521303
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 688606529
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -870998143
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1714187585
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1373753821
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1682451449
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-55"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "1739304063"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkz;III)V",
		garbageValue = "-1287071458"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-809760850"
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
				var14 = (var10 - var8) / (var10 + var8);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var10 == var2) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var4 == var10) {
				var12 = 2.0D + (var6 - var2) / (var10 - var8);
			} else if (var6 == var10) {
				var12 = (var2 - var4) / (var10 - var8) + 4.0D;
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;Llj;I)Llj;",
		garbageValue = "1335279742"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			int var4 = var2 - 1;
			var4 |= var4 >>> 1;
			var4 |= var4 >>> 2;
			var4 |= var4 >>> 4;
			var4 |= var4 >>> 8;
			var4 |= var4 >>> 16;
			var3 = var4 + 1;
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var7 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var7) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		signature = "(IZZZI)Lio;",
		garbageValue = "90068714"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, DevicePcmPlayerProvider.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, RouteStrategy.masterDisk, var0, var1, var2, var3);
	}
}
