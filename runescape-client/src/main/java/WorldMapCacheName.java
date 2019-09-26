import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	public static final WorldMapCacheName field284;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	public static final WorldMapCacheName field289;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	public static final WorldMapCacheName field283;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	static final WorldMapCacheName field285;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	public static final WorldMapCacheName field287;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1366497929
	)
	static int field286;
	@ObfuscatedName("p")
	@Export("name")
	public final String name;

	static {
		field284 = new WorldMapCacheName("details");
		field289 = new WorldMapCacheName("compositemap");
		field283 = new WorldMapCacheName("compositetexture");
		field285 = new WorldMapCacheName("area");
		field287 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1512894139"
	)
	static final void method644() {
		EnumDefinition.method4496("Your ignore list is full. Max of 100 for free users, and 400 for members");
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2059241635"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[WorldMapRectangle.plane][var0][var1];
		if (var2 == null) {
			PacketWriter.scene.removeGroundItemPile(WorldMapRectangle.plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = Occluder.ItemDefinition_get(var6.id);
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
				PacketWriter.scene.removeGroundItemPile(WorldMapRectangle.plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var5.id != var6.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = class267.calculateTag(var0, var1, 3, false, 0);
				PacketWriter.scene.newGroundItemPile(WorldMapRectangle.plane, var0, var1, MusicPatchPcmStream.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, WorldMapRectangle.plane), var5, var9, var12, var11);
			}
		}
	}
}
