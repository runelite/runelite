import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
	@ObfuscatedName("t")
	@Export("nextComparator")
	Comparator nextComparator;

	protected AbstractUserComparator() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "71"
	)
	@Export("addComparator")
	final void addComparator(Comparator var1) {
		if (this.nextComparator == null) {
			this.nextComparator = var1;
		} else if (this.nextComparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.nextComparator).addComparator(var1);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljk;Ljk;I)I",
		garbageValue = "-1613196050"
	)
	@Export("compareUser")
	protected final int compareUser(User var1, User var2) {
		return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1320582539"
	)
	static int method5119(int var0, int var1) {
		FloorOverlayDefinition var2 = ArchiveLoader.FloorUnderlayDefinition_get(var0);
		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else if (var2.texture >= 0) {
			int var3 = class218.method4178(Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture), 96);
			return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
		} else if (var2.primaryRgb == 16711935) {
			return var1;
		} else {
			int var4 = var2.hue;
			int var5 = var2.saturation;
			int var6 = var2.lightness;
			if (var6 > 179) {
				var5 /= 2;
			}

			if (var6 > 192) {
				var5 /= 2;
			}

			if (var6 > 217) {
				var5 /= 2;
			}

			if (var6 > 243) {
				var5 /= 2;
			}

			int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
			int var8 = class218.method4178(var7, 96);
			return Rasterizer3D.Rasterizer3D_colorPalette[var8] | -16777216;
		}
	}
}
