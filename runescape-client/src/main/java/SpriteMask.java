import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("gy")
	@ObfuscatedGetter(
		intValue = 1141179073
	)
	static int field2501;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 2130033561
	)
	@Export("width")
	public final int width;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 395939847
	)
	@Export("height")
	public final int height;
	@ObfuscatedName("n")
	@Export("xWidths")
	public final int[] xWidths;
	@ObfuscatedName("q")
	@Export("xStarts")
	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-337520284"
	)
	@Export("contains")
	public boolean contains(int var1, int var2) {
		if (var2 >= 0 && var2 < this.xStarts.length) {
			int var3 = this.xStarts[var2];
			if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
				return true;
			}
		}

		return false;
	}
}
