import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("af")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive17")
	static Archive archive17;
	@ObfuscatedName("w")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-97"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var2 * 64 + var1];
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "-2096884458"
	)
	@Export("FloorUnderlayDefinition_setArchives")
	public static void FloorUnderlayDefinition_setArchives(AbstractArchive var0) {
		FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1522656478"
	)
	@Export("drawMenuActionTextAt")
	static final void drawMenuActionTextAt(int var0, int var1) {
		if (Client.menuOptionsCount < 2 && Client.isItemSelected == 0 && !Client.isSpellSelected) {
			return;
		}
		if (!Client.showMouseOverText) {
			return;
		}
		int var2 = class13.getNewestMenuIdx();
		String var3;
		if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
			var3 = "Use" + " " + Client.selectedItemName + " " + "->";
		} else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
			var3 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " " + "->";
		} else {
			var3 = WorldMapLabel.getMenuText(var2);
		}

		if (Client.menuOptionsCount > 2) {
			var3 = var3 + ClientPreferences.colorStartTag(0xffffff) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
		}

		WorldMapIcon_1.fontBold12.drawRandomAlphaAndSpacing(var3, var0 + 4, var1 + 15, 0xffffff, 0, Client.cycle / 1000);
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		signature = "([Lhj;Lhj;ZI)V",
		garbageValue = "280712117"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		class13.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			class13.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			resizeComponents(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-2115353122"
	)
	@Export("resizeComponents")
	static final void resizeComponents(int var0, int var1, int var2, boolean var3) {
		if (class162.loadInterface(var0)) {
			class13.resizeInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "291436994"
	)
	@Export("writeNewRandomDat")
	static void writeNewRandomDat(Buffer var0, int var1) {
		byte[] var2 = var0.array;
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class301.writeRandomDat(var2, var1, Client.randomDatData, 0, 24);
		if (JagexCache.JagexCache_randomDat == null) {
			return;
		}
		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
		} catch (Exception var4) {
		}

	}
}
