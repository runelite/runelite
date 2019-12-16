import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lj;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lj;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lj;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = 1779595595
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 753179293
	)
	final int field113;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1705085615
	)
	final int field110;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1894041549
	)
	final int field109;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(2, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(1, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(0, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field113 = var1;
		this.field110 = var2;
		this.field109 = var3;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-886615284"
	)
	boolean method183(float var1) {
		return var1 >= (float)this.field109;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lj;",
		garbageValue = "1782583414"
	)
	static WorldMapLabelSize method182(int var0) {
		WorldMapLabelSize[] var1 = new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_large, WorldMapLabelSize_medium};
		WorldMapLabelSize[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			WorldMapLabelSize var4 = var2[var3];
			if (var0 == var4.field110) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILkg;Lif;I)V",
		garbageValue = "408985273"
	)
	static void method186(int var0, ArchiveDisk var1, Archive var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 1;
		var3.key = (long)var0;
		var3.archiveDisk = var1;
		var3.archive = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		class32.method549();
	}
}
