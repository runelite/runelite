import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("dg")
	@ObfuscatedGetter(
		longValue = 151185411405630583L
	)
	static long field519;
	@ObfuscatedName("i")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("y")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-83"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (MusicPatch.loadInterface(var0)) {
			DynamicObject.runComponentCloseListeners(UserComparator7.Widget_interfaceComponents[var0], var1);
		}
	}
}
