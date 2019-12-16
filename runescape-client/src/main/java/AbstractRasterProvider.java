import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("y")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2051103705
	)
	@Export("width")
	public int width;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 705915003
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1570881200"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-116"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1390931728"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
