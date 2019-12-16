import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -402020319
	)
	@Export("id")
	int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 260716727
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "822221372"
	)
	@Export("getModel")
	protected final Model getModel() {
		return PacketBufferNode.ItemDefinition_get(this.id).getModel(this.quantity);
	}
}
