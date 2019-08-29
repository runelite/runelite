import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("i")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -436554829
	)
	@Export("width")
	public int width;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1168028289
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "314023161"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "333545527"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1451326676"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
