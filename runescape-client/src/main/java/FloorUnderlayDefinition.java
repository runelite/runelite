import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("FloorUnderlayDefinition_archive")
	public static AbstractArchive FloorUnderlayDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("FloorUnderlayDefinition_cached")
	public static EvictingDualNodeHashTable FloorUnderlayDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1923870903
	)
	@Export("rgb")
	int rgb;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2031878355
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 922832793
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1084903515
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 568958993
	)
	@Export("hueMultiplier")
	public int hueMultiplier;

	static {
		FloorUnderlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorUnderlayDefinition() {
		this.rgb = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2090929650"
	)
	@Export("postDecode")
	void postDecode() {
		this.setHsl(this.rgb);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-840924474"
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
		signature = "(Lkl;III)V",
		garbageValue = "-1673078715"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.rgb = var1.readMedium();
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "307020215"
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
			} else if (var6 == var10) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.saturation = (int)(256.0D * var14);
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

		if (var16 > 0.5D) {
			this.hueMultiplier = (int)(512.0D * var14 * (1.0D - var16));
		} else {
			this.hueMultiplier = (int)(512.0D * var16 * var14);
		}

		if (this.hueMultiplier < 1) {
			this.hueMultiplier = 1;
		}

		this.hue = (int)((double)this.hueMultiplier * var12);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Lcn;",
		garbageValue = "126"
	)
	static AttackOption[] method4395() {
		return new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels};
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "1"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}
}
