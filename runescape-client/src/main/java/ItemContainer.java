import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("x")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("t")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lii;",
		garbageValue = "-1732973980"
	)
	static VerticalAlignment[] method1120() {
		return new VerticalAlignment[]{VerticalAlignment.field3170, VerticalAlignment.field3172, VerticalAlignment.VerticalAlignment_centered};
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-476511275"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
