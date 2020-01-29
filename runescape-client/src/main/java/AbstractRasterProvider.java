import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("o")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -677565243
	)
	@Export("width")
	public int width;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1515017949
	)
	@Export("height")
	public int height;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-529782293"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "934582222"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-96"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-569880085"
	)
	static boolean method6151() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			while (Client.archiveLoadersDone < Client.archiveLoaders.size()) {
				ArchiveLoader var0 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
				if (!var0.isLoaded()) {
					return false;
				}

				++Client.archiveLoadersDone;
			}

			return true;
		} else {
			return true;
		}
	}
}
