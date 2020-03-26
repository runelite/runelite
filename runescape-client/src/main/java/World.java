import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("World")
public class World {
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1328454415
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 89189373
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("z")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("t")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1023289861
	)
	@Export("id")
	int id;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -522510299
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1229908449
	)
	@Export("population")
	int population;
	@ObfuscatedName("u")
	@Export("host")
	String host;
	@ObfuscatedName("h")
	@Export("activity")
	String activity;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1299711201
	)
	@Export("location")
	int location;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -281997857
	)
	@Export("index")
	int index;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-87"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1374980076"
	)
	boolean method1869() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1915504932"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "53"
	)
	boolean method1871() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "248561667"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1399101886"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "20"
	)
	boolean method1879() {
		return (1073741824 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;Liy;Liy;Liy;S)V",
		garbageValue = "-3755"
	)
	public static void method1908(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		Widget.Widget_archive = var0;
		SoundSystem.Widget_modelsArchive = var1;
		Varps.Widget_spritesArchive = var2;
		Widget.Widget_fontsArchive = var3;
		Widget.Widget_interfaceComponents = new Widget[Widget.Widget_archive.getGroupCount()][];
		Widget.Widget_loadedInterfaces = new boolean[Widget.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "34"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1848249905"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[ScriptEvent.Client_plane][var0][var1];
		if (var2 == null) {
			GrandExchangeOfferWorldComparator.scene.removeGroundItemPile(ScriptEvent.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = AbstractWorldMapData.ItemDefinition_get(var6.id);
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
				GrandExchangeOfferWorldComparator.scene.removeGroundItemPile(ScriptEvent.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var12.id != var6.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = IsaacCipher.calculateTag(var0, var1, 3, false, 0);
				GrandExchangeOfferWorldComparator.scene.newGroundItemPile(ScriptEvent.Client_plane, var0, var1, class277.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, ScriptEvent.Client_plane), var5, var9, var12, var11);
			}
		}
	}
}
