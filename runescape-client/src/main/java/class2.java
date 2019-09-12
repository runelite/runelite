import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class2 implements class0 {
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkz;B)V",
		garbageValue = "1"
	)
	public void vmethod42(Object var1, Buffer var2) {
		this.method20((Long)var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;S)Ljava/lang/Object;",
		garbageValue = "31810"
	)
	public Object vmethod41(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkz;B)V",
		garbageValue = "3"
	)
	void method20(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "291099501"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x * -78439701 >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.size == 1 && (var2.x * -78439701 & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = WorldMapIcon_1.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					WorldMapIcon_1.scene.drawEntity(MouseRecorder.plane, var2.x * -78439701, var2.y, WorldMapAreaData.getTileHeight(var2.x * -78439701 + (var2.size * 64 - 64), var2.size * 64 - 64 + var2.y, MouseRecorder.plane), var2.size * 64 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}
}
