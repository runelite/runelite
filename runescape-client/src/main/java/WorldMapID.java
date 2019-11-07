import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final WorldMapID field259;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final WorldMapID field257;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1391599195
	)
	static int field260;
	@ObfuscatedName("at")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -679981673
	)
	@Export("value")
	final int value;

	static {
		field259 = new WorldMapID(0);
		field257 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(Lij;Ljava/lang/String;I)V",
		garbageValue = "1051917503"
	)
	static void method610(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field903 += var2.groupCount;
	}
}
