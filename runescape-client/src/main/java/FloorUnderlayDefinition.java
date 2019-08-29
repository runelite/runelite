import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("FloorUnderlayDefinition_archive")
	static AbstractArchive FloorUnderlayDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("FloorUnderlayDefinition_cached")
	public static EvictingDualNodeHashTable FloorUnderlayDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1690185973
	)
	@Export("rgb")
	int rgb;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1561731435
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 56370407
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1143874615
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -780904451
	)
	@Export("hueMultiplier")
	public int hueMultiplier;

	static {
		FloorUnderlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorUnderlayDefinition() {
		this.rgb = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "38"
	)
	@Export("postDecode")
	void postDecode() {
		this.setHsl(this.rgb);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lky;IB)V",
		garbageValue = "118"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lky;III)V",
		garbageValue = "2131813988"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.rgb = var1.readMedium();
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-28210148"
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
		if (var10 != var8) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var10 == var2) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var10 == var4) {
				var12 = 2.0D + (var6 - var2) / (var10 - var8);
			} else if (var10 == var6) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
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

		if (var16 > 0.5D) {
			this.hueMultiplier = (int)(512.0D * var14 * (1.0D - var16));
		} else {
			this.hueMultiplier = (int)(var16 * var14 * 512.0D);
		}

		if (this.hueMultiplier < 1) {
			this.hueMultiplier = 1;
		}

		this.hue = (int)(var12 * (double)this.hueMultiplier);
	}
}
