import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 563892135
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1489030815
	)
	@Export("health")
	int health;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1355122563
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -716904445
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1563848755"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-330956579"
	)
	static void method1708() {
		if (Client.renderSelf) {
			GameObject.addPlayerToScene(Varps.localPlayer, false);
		}

	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-86"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
			GrandExchangeOfferUnitPriceComparator.clanChat.invalidateIgnoreds();
		}

	}
}
