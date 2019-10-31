import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("az")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1532996023
	)
	@Export("width")
	int width;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1074261311
	)
	@Export("height")
	int height;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 829209927
	)
	@Export("x")
	int x;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2070361413
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lax;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhq;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "1156517965"
	)
	public static void method330(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
		int var5 = var0.getGroupId(var1);
		int var6 = var0.getFileId(var5, var2);
		MusicPatchNode2.playMusicTrack(var0, var5, var6, var3, var4);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1565854351"
	)
	public static void method331() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1573335888"
	)
	static void method329(int var0) {
		Client.oculusOrbState = var0;
	}
}
