import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("n")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1627177537
	)
	@Export("width")
	public int width;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -594636233
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "3"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2086134046"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2129049965"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
