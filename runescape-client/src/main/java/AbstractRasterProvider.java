import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("b")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1041400109
	)
	@Export("width")
	public int width;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -854439651
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "0"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-787999204"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-30907"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
