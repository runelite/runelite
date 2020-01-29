import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("pb")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1400048681
	)
	@Export("width")
	int width;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1470820319
	)
	@Export("height")
	int height;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -86733365
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 204657909
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lak;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lmx;",
		garbageValue = "636335371"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(JagexCache.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (GrandExchangeOfferOwnWorldComparator.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (GrandExchangeOfferOwnWorldComparator.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(UserComparator4.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIS)Lbn;",
		garbageValue = "-2264"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1219570731"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "2037508438"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		class192.scrollBarSprites[0].drawAt(var0, var1);
		class192.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field870);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field709);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field711);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field711);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field711);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field711);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field710);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field710);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field710);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field710);
	}
}
