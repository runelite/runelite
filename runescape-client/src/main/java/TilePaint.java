import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 4463315
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 404094577
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1273471255
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1327164447
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 111176121
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("b")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -387555393
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
