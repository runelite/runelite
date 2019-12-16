import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class173 {
	@ObfuscatedName("y")
	@Export("directions")
	public static int[][] directions;
	@ObfuscatedName("w")
	@Export("distances")
	public static int[][] distances;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1981163643
	)
	public static int field2072;
	@ObfuscatedName("x")
	@Export("bufferX")
	public static int[] bufferX;
	@ObfuscatedName("a")
	@Export("bufferY")
	public static int[] bufferY;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "Lbo;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;IIIZI)V",
		garbageValue = "1828345963"
	)
	@Export("playMusicTrack")
	public static void playMusicTrack(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2392 = 1;
		Coord.musicTrackArchive = var0;
		class16.musicTrackGroupId = var1;
		GrandExchangeOffer.musicTrackFileId = var2;
		class197.musicTrackVolume = var3;
		WorldMapDecoration.musicTrackBoolean = var4;
		ParamDefinition.field3275 = 10000;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/io/File;ZI)Z",
		garbageValue = "969136252"
	)
	static boolean method3561(File var0, boolean var1) {
		try {
			RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
			int var3 = var2.read();
			var2.seek(0L);
			var2.write(var3);
			var2.seek(0L);
			var2.close();
			if (var1) {
				var0.delete();
			}

			return true;
		} catch (Exception var4) {
			return false;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-974427465"
	)
	public static void method3560() {
		while (true) {
			ArchiveDiskAction var0;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var0 == null) {
				return;
			}

			var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
		}
	}
}
