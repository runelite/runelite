import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class80 {
	@ObfuscatedName("u")
	static final BigInteger field1108;
	@ObfuscatedName("n")
	static final BigInteger field1110;

	static {
		field1108 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1110 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhp;I[B[BI)V",
		garbageValue = "-1438393709"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2631 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2631 = new byte[11][];
			var0.field2622 = new byte[11][];
			var0.field2623 = new int[11];
			var0.field2581 = new int[11];
		}

		var0.field2631[var1] = var2;
		if (var2 != null) {
			var0.field2620 = true;
		} else {
			var0.field2620 = false;

			for (int var4 = 0; var4 < var0.field2631.length; ++var4) {
				if (var0.field2631[var4] != null) {
					var0.field2620 = true;
					break;
				}
			}
		}

		var0.field2622[var1] = var3;
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(Lbd;ZB)V",
		garbageValue = "1"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.readySequence == var0.movementSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = WorldMapSprite.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0.x, var0.y, ItemContainer.plane);
					var0.playerCycle = Client.cycle;
					Player.scene.addNullableObject(ItemContainer.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field603, var0.field604, var0.field616, var0.field606);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0.x, var0.y, ItemContainer.plane);
					var0.playerCycle = Client.cycle;
					Player.scene.drawEntity(ItemContainer.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}
}
