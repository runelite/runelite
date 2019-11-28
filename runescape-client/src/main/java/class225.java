import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class225 {
	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "([Lhl;IIIZI)V",
		garbageValue = "-1828804382"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				WorldMapSection1.alignWidgetSize(var6, var2, var3, var4);
				PendingSpawn.alignWidgetPosition(var6, var2, var3);
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
					MilliClock.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}
