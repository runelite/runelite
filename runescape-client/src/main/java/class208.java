import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class208 {
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "15"
	)
	@Export("getHighestVisiblePlane")
	static final int getHighestVisiblePlane() {
		if (AbstractArchive.clientPreferences.roofsHidden) {
			return WorldMapRectangle.plane;
		} else {
			int var0 = MusicPatchPcmStream.getTileHeight(GrandExchangeOfferOwnWorldComparator.cameraX, WorldMapIcon_1.cameraZ, WorldMapRectangle.plane);
			return var0 - Varcs.cameraY < 800 && (Tiles.Tiles_renderFlags[WorldMapRectangle.plane][GrandExchangeOfferOwnWorldComparator.cameraX >> 7][WorldMapIcon_1.cameraZ >> 7] & 4) != 0 ? WorldMapRectangle.plane : 3;
		}
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "73357396"
	)
	@Export("Widget_runOnTargetLeave")
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = GrandExchangeOfferWorldComparator.getWidgetChild(AttackOption.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				ParamDefinition.runScriptEvent(var1);
			}

			Client.isSpellSelected = false;
			WorldMapSectionType.invalidateWidget(var0);
		}
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(IIIILlf;Lhz;I)V",
		garbageValue = "1204804321"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6088(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
