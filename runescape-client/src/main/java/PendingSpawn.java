import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1216764751
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1571459421
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1864356937
	)
	@Export("type")
	int type;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1344797441
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1245486001
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -547933481
	)
	int field968;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1800022501
	)
	int field963;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1336190783
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1244443099
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -668527737
	)
	int field967;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -297028933
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 718779675
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-42"
	)
	static void method1840() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lby;",
		garbageValue = "755627010"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "287596023"
	)
	public static void method1838() {
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
	}
}
