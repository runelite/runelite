import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("su")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	public static class237 field30;
	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lo;Lo;I)I",
		garbageValue = "-1039066060"
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)[Lgs;",
		garbageValue = "-126362707"
	)
	static LoginPacket[] method105() {
		return new LoginPacket[]{LoginPacket.field2287, LoginPacket.field2284, LoginPacket.field2286, LoginPacket.field2283, LoginPacket.field2285};
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIIB)V",
		garbageValue = "-70"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			FaceNormal.method3396(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field917 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}

	@ObfuscatedName("ld")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "-1416348373"
	)
	static void method103(Buffer var0, int var1) {
		ClanMate.method5151(var0.array, var1);
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}
}
