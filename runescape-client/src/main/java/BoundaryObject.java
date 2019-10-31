import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("r")
	static String[] field1859;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -14166733
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -591706183
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1799577875
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1720763557
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1635831629
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		longValue = 7223116526443198487L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1447474805
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1336245402"
	)
	static void method3393() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (TextureProvider.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = Widget.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = PacketBufferNode.getWidget(var4);
					if (var5 != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(var5);
					}
				}
			}
		}

	}

	@ObfuscatedName("lw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "-2087337765"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < ItemDefinition.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = class222.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					MouseHandler.foundItemIdCount = -1;
					UserComparator4.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		UserComparator4.foundItemIds = var2;
		WorldMapManager.foundItemIndex = 0;
		MouseHandler.foundItemIdCount = var3;
		String[] var8 = new String[MouseHandler.foundItemIdCount];

		for (int var9 = 0; var9 < MouseHandler.foundItemIdCount; ++var9) {
			var8[var9] = class222.ItemDefinition_get(var2[var9]).name;
		}

		short[] var10 = UserComparator4.foundItemIds;
		RouteStrategy.sortItemsByName(var8, var10, 0, var8.length - 1);
	}

	@ObfuscatedName("lj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "124156386"
	)
	static void method3394() {
		if (GrandExchangeOfferWorldComparator.field30 != null) {
			Client.field900 = Client.cycle;
			GrandExchangeOfferWorldComparator.field30.method4482();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					GrandExchangeOfferWorldComparator.field30.method4476(UserComparator8.baseX * 64 + (Client.players[var0].x >> 7), HealthBar.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
