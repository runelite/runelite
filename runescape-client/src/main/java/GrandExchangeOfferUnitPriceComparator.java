import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("ar")
	@Export("null_string")
	protected static String null_string;
	@ObfuscatedName("la")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;B)I",
		garbageValue = "0"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2056490791"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = class287.VarbitDefinition_archive.takeFile(14, var0);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.decode(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}

	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "(I)Lly;",
		garbageValue = "-710096744"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return WorldMapIcon_0.worldMap;
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "2147483647"
	)
	@Export("setViewportShape")
	static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) {
			var2 = 1;
		}

		if (var3 < 1) {
			var3 = 1;
		}

		int var5 = var3 - 334;
		int var6;
		if (var5 < 0) {
			var6 = Client.field908;
		} else if (var5 >= 100) {
			var6 = Client.field897;
		} else {
			var6 = (Client.field897 - Client.field908) * var5 / 100 + Client.field908;
		}

		int var7 = var3 * var6 * 512 / (var2 * 334);
		int var8;
		int var9;
		short var10;
		if (var7 < Client.field819) {
			var10 = Client.field819;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 > Client.field673) {
				var6 = Client.field673;
				var8 = var3 * var6 * 512 / (var10 * 334);
				var9 = (var2 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
				}

				var0 += var9;
				var2 -= var9 * 2;
			}
		} else if (var7 > Client.field903) {
			var10 = Client.field903;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 < Client.field900) {
				var6 = Client.field900;
				var8 = var10 * var2 * 334 / (var6 * 512);
				var9 = (var3 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
				}

				var1 += var9;
				var3 -= var9 * 2;
			}
		}

		Client.viewportZoom = var3 * var6 / 334;
		if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
			CollisionMap.method3650(var2, var3);
		}

		Client.viewportOffsetX = var0;
		Client.viewportOffsetY = var1;
		Client.viewportWidth = var2;
		Client.viewportHeight = var3;
	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1156773916"
	)
	static void method141() {
		if (class192.localPlayer.x >> 7 == Client.destinationX && class192.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-1682009725"
	)
	static final void method135(int var0, int var1, int var2, boolean var3) {
		if (ScriptFrame.loadInterface(var0)) {
			FloorUnderlayDefinition.resizeInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}
}
