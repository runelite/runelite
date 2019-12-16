import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive6")
	static Archive archive6;

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lx;Lx;I)I",
		garbageValue = "1333549485"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1794257509"
	)
	static void method70(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(ZLkl;I)V",
		garbageValue = "386675414"
	)
	static final void method71(boolean var0, PacketBuffer var1) {
		while (true) {
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
				int var2 = var1.readBits(15);
				if (var2 != 32767) {
					boolean var3 = false;
					if (Client.npcs[var2] == null) {
						Client.npcs[var2] = new NPC();
						var3 = true;
					}

					NPC var4 = Client.npcs[var2];
					Client.npcIndices[++Client.npcCount - 1] = var2;
					var4.npcCycle = Client.cycle;
					int var5;
					if (var0) {
						var5 = var1.readBits(8);
						if (var5 > 127) {
							var5 -= 256;
						}
					} else {
						var5 = var1.readBits(5);
						if (var5 > 15) {
							var5 -= 32;
						}
					}

					int var6 = Client.defaultRotations[var1.readBits(3)];
					if (var3) {
						var4.orientation = var4.rotation = var6;
					}

					int var7 = var1.readBits(1);
					int var8 = var1.readBits(1);
					if (var8 == 1) {
						Client.field720[++Client.field673 - 1] = var2;
					}

					var4.definition = AbstractUserComparator.getNpcDefinition(var1.readBits(14));
					int var9;
					if (var0) {
						var9 = var1.readBits(8);
						if (var9 > 127) {
							var9 -= 256;
						}
					} else {
						var9 = var1.readBits(5);
						if (var9 > 15) {
							var9 -= 32;
						}
					}

					var4.field925 = var4.definition.size;
					var4.field968 = var4.definition.rotation;
					if (var4.field968 == 0) {
						var4.rotation = 0;
					}

					var4.walkSequence = var4.definition.walkSequence;
					var4.walkBackSequence = var4.definition.walkBackSequence;
					var4.walkLeftSequence = var4.definition.walkLeftSequence;
					var4.walkRightSequence = var4.definition.walkRightSequence;
					var4.readySequence = var4.definition.readySequence;
					var4.turnLeftSequence = var4.definition.turnLeftSequence;
					var4.turnRightSequence = var4.definition.turnRightSequence;
					var4.method2045(Message.localPlayer.pathX[0] + var5, Message.localPlayer.pathY[0] + var9, var7 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}
}
