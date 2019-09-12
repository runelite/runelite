import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("qa")
	@ObfuscatedGetter(
		intValue = -159199451
	)
	static int field301;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	public static final WorldMapCacheName field294;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	public static final WorldMapCacheName field295;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	public static final WorldMapCacheName field296;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	static final WorldMapCacheName field297;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	public static final WorldMapCacheName field298;
	@ObfuscatedName("u")
	@Export("name")
	public final String name;

	static {
		field294 = new WorldMapCacheName("details");
		field295 = new WorldMapCacheName("compositemap");
		field296 = new WorldMapCacheName("compositetexture");
		field297 = new WorldMapCacheName("area");
		field298 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "105"
	)
	static int method594() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1942800503"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var1 = Language.method3627(var0);
		int var2 = var1.baseVar;
		int var3 = var1.startBit;
		int var4 = var1.endBit;
		int var5 = Varps.Varps_masks[var4 - var3];
		return Varps.Varps_main[var2] >> var3 & var5;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "63"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		UserComparator9.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1635496001"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[MouseRecorder.plane][var0][var1];
		if (var2 == null) {
			WorldMapIcon_1.scene.removeGroundItemPile(MouseRecorder.plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = Player.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= (long)(var6.quantity + 1);
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				WorldMapIcon_1.scene.removeGroundItemPile(MouseRecorder.plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = WorldMapIcon_1.calculateTag(var0, var1, 3, false, 0);
				WorldMapIcon_1.scene.newGroundItemPile(MouseRecorder.plane, var0, var1, WorldMapAreaData.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, MouseRecorder.plane), var5, var9, var12, var11);
			}
		}
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2017044879"
	)
	@Export("getNewestMenuIdx")
	static final int getNewestMenuIdx() {
		return Client.menuOptionsCount - 1;
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-415764372"
	)
	static final void method592() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsInClanChat();
		}

	}
}
