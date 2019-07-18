import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("NetCache_reference")
	static Buffer NetCache_reference;
	@ObfuscatedName("e")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1276568955
	)
	@Export("width")
	public int width;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1637041543
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1942972544"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1902391505"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "106"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
