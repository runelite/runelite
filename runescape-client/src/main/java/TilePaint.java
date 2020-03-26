import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ev")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		longValue = 8743466258274073007L
	)
	static long field1802;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2078169707
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 321008861
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -841305589
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 658515107
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1776502689
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("v")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1035631343
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}
}
