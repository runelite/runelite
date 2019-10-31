import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 731743959
	)
	@Export("clientType")
	public static int clientType;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1432392447
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -423063441
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Ldv;",
		garbageValue = "-40"
	)
	@Export("getModel")
	protected final Model getModel() {
		return class222.ItemDefinition_get(this.id).getModel(this.quantity);
	}
}
