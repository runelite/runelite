import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("c")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lv;Lv;S)I",
		garbageValue = "27782"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([BIIII[Lfj;I)V",
		garbageValue = "-1084526407"
	)
	static final void method1244(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
		int var7;
		int var8;
		for (int var6 = 0; var6 < 4; ++var6) {
			for (var7 = 0; var7 < 64; ++var7) {
				for (var8 = 0; var8 < 64; ++var8) {
					if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
						int[] var10000 = var5[var6].flags[var7 + var1];
						var10000[var8 + var2] &= -16777217;
					}
				}
			}
		}

		Buffer var10 = new Buffer(var0);

		for (var7 = 0; var7 < 4; ++var7) {
			for (var8 = 0; var8 < 64; ++var8) {
				for (int var9 = 0; var9 < 64; ++var9) {
					class32.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
				}
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1688016819"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-325368382"
	)
	static void method1232() {
		Login.worldSelectOpen = false;
		Login.leftTitleSprite.drawAt(Login.xPadding, 0);
		class191.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
		HealthBar.logoSprite.drawAt(Login.xPadding + 382 - HealthBar.logoSprite.subWidth / 2, 18);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "1088235300"
	)
	public static int method1245(String var0) {
		return var0.length() + 2;
	}
}
