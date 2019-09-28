import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("v")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1221954905
	)
	@Export("width")
	public int width;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 809652275
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1952064900"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-67564732"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-997992638"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}
}
