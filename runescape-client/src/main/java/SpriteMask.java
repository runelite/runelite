import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
	@ObfuscatedName("cu")
	public static char field2499;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1889581331
	)
	@Export("width")
	public final int width;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -300799133
	)
	@Export("height")
	public final int height;
	@ObfuscatedName("i")
	@Export("xWidths")
	public final int[] xWidths;
	@ObfuscatedName("k")
	@Export("xStarts")
	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1169016407"
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

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "57"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}
}
