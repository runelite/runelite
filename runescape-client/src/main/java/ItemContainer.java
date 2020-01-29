import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field547;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("t")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("o")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IZB)Ljava/lang/String;",
		garbageValue = "-71"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? Actor.method1741(var0, 10, var1) : Integer.toString(var0);
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1888961685"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.field942 * 367011904 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = GameShell.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					ServerBuild.scene.drawEntity(Clock.Client_plane, var2.x, var2.y, WorldMapSectionType.getTileHeight(var2.field942 * 2013925376 - 64 + var2.x, var2.field942 * 2013925376 - 64 + var2.y, Clock.Client_plane), var2.field942 * 2013925376 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(Lhn;I)Lhn;",
		garbageValue = "701959243"
	)
	static Widget method1184(Widget var0) {
		int var2 = WorldMapIcon_0.getWidgetClickMask(var0);
		int var1 = var2 >> 17 & 7;
		int var3 = var1;
		if (var1 == 0) {
			return null;
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				var0 = Varps.getWidget(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}
