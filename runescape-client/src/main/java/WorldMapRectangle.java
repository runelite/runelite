import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("gs")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1996817297
	)
	@Export("width")
	int width;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 625891879
	)
	@Export("height")
	int height;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1380746691
	)
	@Export("x")
	int x;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1337066781
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lao;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "205706610"
	)
	static final void method275() {
		for (GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var0.plane == class42.plane && !var0.isFinished) {
				if (Client.cycle >= var0.cycleStart) {
					var0.advance(Client.field718);
					if (var0.isFinished) {
						var0.remove();
					} else {
						GrandExchangeOfferWorldComparator.scene.drawEntity(var0.plane, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
					}
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(Lhj;Liq;IIZI)V",
		garbageValue = "106659698"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			Entity.insertMenuItem(var7, ClientPreferences.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}
