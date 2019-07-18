import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -907427363
	)
	@Export("type")
	int type;
	@ObfuscatedName("w")
	@Export("data")
	public byte[] data;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkm;"
	)
	@Export("archiveDisk")
	public ArchiveDisk archiveDisk;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive")
	public Archive archive;

	ArchiveDiskAction() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lim;",
		garbageValue = "-738252140"
	)
	@Export("getKitDefinition")
	public static KitDefinition getKitDefinition(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
