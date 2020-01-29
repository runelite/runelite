import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("Varps")
public class Varps {
	@ObfuscatedName("c")
	@Export("Varps_masks")
	static int[] Varps_masks;
	@ObfuscatedName("t")
	@Export("Varps_temp")
	public static int[] Varps_temp;
	@ObfuscatedName("o")
	@Export("Varps_main")
	public static int[] Varps_main;

	static {
		Varps_masks = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			Varps_masks[var1] = var0 - 1;
			var0 += var0;
		}

		Varps_temp = new int[4000];
		Varps_main = new int[4000];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1638867489"
	)
	static int method4043(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lhn;",
		garbageValue = "1215015650"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (WorldMapLabel.Widget_interfaceComponents[var1] == null || WorldMapLabel.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = ScriptFrame.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return WorldMapLabel.Widget_interfaceComponents[var1][var2];
	}
}
