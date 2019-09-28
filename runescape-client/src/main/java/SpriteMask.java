import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 470195623
	)
	@Export("width")
	public final int width;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1322653373
	)
	@Export("height")
	public final int height;
	@ObfuscatedName("v")
	@Export("xWidths")
	public final int[] xWidths;
	@ObfuscatedName("u")
	@Export("xStarts")
	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-886102829"
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
