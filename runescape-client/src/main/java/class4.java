import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class4 implements class0 {
	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkl;B)V",
		garbageValue = "0"
	)
	public void vmethod64(Object var1, Buffer var2) {
		this.method54((String)var1, var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;B)Ljava/lang/Object;",
		garbageValue = "-93"
	)
	public Object vmethod55(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkl;I)V",
		garbageValue = "-1135540783"
	)
	void method54(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-25"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lbo;I)V",
		garbageValue = "688122635"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			class1.method16(var0.isMembersOnly());
		}

		class160.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		HitSplatDefinition.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		BZip2State.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		NPC.port3 = HitSplatDefinition.port1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1757923424"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (AbstractUserComparator.garbageCollector == null || !AbstractUserComparator.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						AbstractUserComparator.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (AbstractUserComparator.garbageCollector != null) {
			long var9 = class30.currentTimeMillis();
			long var3 = AbstractUserComparator.garbageCollector.getCollectionTime();
			if (GameShell.garbageCollectorLastCollectionTime != -1L) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (0L != var7) {
					var0 = (int)(var5 * 100L / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "57"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.size * 1669471931 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = class267.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					PacketWriter.scene.drawEntity(WorldMapRectangle.plane, var2.x, var2.y, MusicPatchPcmStream.getTileHeight(var2.size * -527978816 - 64 + var2.x, var2.size * -527978816 - 64 + var2.y, WorldMapRectangle.plane), var2.size * -527978816 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}
}
