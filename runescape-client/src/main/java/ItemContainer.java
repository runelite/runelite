import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = -1316536921
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("n")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("v")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;I)V",
		garbageValue = "376678600"
	)
	public static void method1190(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		SequenceDefinition.SequenceDefinition_animationsArchive = var1;
		class188.SequenceDefinition_skeletonsArchive = var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Lfz;",
		garbageValue = "1488138254"
	)
	@Export("newClock")
	public static Clock newClock() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-57501603"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (WorldMapData_0.loadInterface(var0)) {
			GrandExchangeOffer.field61 = null;
			ScriptEvent.drawInterface(UserComparator5.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (GrandExchangeOffer.field61 != null) {
				ScriptEvent.drawInterface(GrandExchangeOffer.field61, -1412584499, var1, var2, var3, var4, class227.field3061, Occluder.field1889, var7);
				GrandExchangeOffer.field61 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field841[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field841[var8] = true;
				}
			}

		}
	}
}
