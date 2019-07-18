import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public final class class227 {
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(Lbd;ZB)V",
		garbageValue = "22"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.readySequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = Tile.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = ScriptEvent.getTileHeight(var0.x, var0.y, class42.plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.method3079(class42.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.field950, var4, var0.field627, var0.field625, var0.field612, var0.field630);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = ScriptEvent.getTileHeight(var0.x, var0.y, class42.plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.drawEntity(class42.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.field950, var4, var0.field967);
				}
			}
		}

	}
}
