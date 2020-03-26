import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("a")
	public static String[] field3871;
	@ObfuscatedName("k")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2037520285
	)
	@Export("width")
	public int width;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -645523785
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1321130014"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIIS)V",
		garbageValue = "32475"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1783812684"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
