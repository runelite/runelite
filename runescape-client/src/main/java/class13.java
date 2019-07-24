import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class13 {
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("gp")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-1481103738"
	)
	public static int method152(String var0) {
		return var0.length() + 2;
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "246973533"
	)
	static final int method151() {
		return Client.menuOptionsCount - 1;
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "([Lhj;IIIZI)V",
		garbageValue = "1879036172"
	)
	@Export("resizeWidget")
	static void resizeWidget(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				class219.alignWidgetSize(var6, var2, var3, var4);
				PcmPlayer.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					WorldMapSprite.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}
