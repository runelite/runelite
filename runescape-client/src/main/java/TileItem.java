import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("sf")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1909413627
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1504274747
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected final Model getModel() {
		return HealthBarDefinition.ItemDefinition_get(this.id).getModel(this.quantity);
	}
}
