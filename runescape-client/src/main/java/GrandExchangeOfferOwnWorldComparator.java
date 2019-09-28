import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("qs")
	@ObfuscatedGetter(
		intValue = 683599059
	)
	static int field627;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("KitDefinition_modelsArchive")
	public static AbstractArchive KitDefinition_modelsArchive;
	@ObfuscatedName("r")
	@Export("cacheDir")
	public static File cacheDir;
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 1137329779
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	static Widget field628;
	@ObfuscatedName("z")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lm;Lm;I)I",
		garbageValue = "-1661947065"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)Liz;",
		garbageValue = "123"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IS)Lbe;",
		garbageValue = "-12583"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}
}
