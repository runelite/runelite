import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1355900291
	)
	@Export("width")
	public final int width;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1444758519
	)
	@Export("height")
	public final int height;
	@ObfuscatedName("k")
	@Export("xWidths")
	public final int[] xWidths;
	@ObfuscatedName("d")
	@Export("xStarts")
	public final int[] xStarts;

	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1;
		this.height = var2;
		this.xWidths = var3;
		this.xStarts = var4;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-822552656"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IS)Liu;",
		garbageValue = "14194"
	)
	public static VarbitDefinition method4061(int var0) {
		VarbitDefinition var1 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var1 = new VarbitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
