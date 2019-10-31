import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field288;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field289;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field290;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	static final WorldMapCacheName field298;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field292;
	@ObfuscatedName("gu")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("l")
	@Export("name")
	public final String name;

	static {
		field288 = new WorldMapCacheName("details");
		field289 = new WorldMapCacheName("compositemap");
		field290 = new WorldMapCacheName("compositetexture");
		field298 = new WorldMapCacheName("area");
		field292 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1535608049"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-887333641"
	)
	public static void method682() {
		KitDefinition.KitDefinition_cached.clear();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhi;IB)V",
		garbageValue = "-113"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2623 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2627 == null) {
				var0.field2627 = new int[var0.field2623.length];
			}

			var0.field2627[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1095915325"
	)
	static final int method686(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "6"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = GraphicsObject.getTileHeight(var0, var1, Player.Client_plane) - var2;
			var0 -= UrlRequester.cameraX;
			var3 -= class16.cameraY;
			var1 -= GrandExchangeOfferAgeComparator.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class247.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class247.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapData_1.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapData_1.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var4 * var3 + var5 * var1 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = Client.viewportHeight / 2 + var8 * Client.viewportZoom / var1;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(IIS)Lfc;",
		garbageValue = "-31136"
	)
	static RouteStrategy method685(int var0, int var1) {
		Client.field904.approxDestinationX = var0;
		Client.field904.approxDestinationY = var1;
		Client.field904.approxDestinationSizeX = 1;
		Client.field904.approxDestinationSizeY = 1;
		return Client.field904;
	}
}
