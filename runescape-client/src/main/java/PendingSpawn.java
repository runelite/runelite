import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1584679065
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1530621461
	)
	@Export("type")
	int type;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1386695055
	)
	@Export("x")
	int x;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1902286249
	)
	@Export("y")
	int y;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1162414355
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1880086587
	)
	int field913;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1367998823
	)
	int field914;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1222529831
	)
	@Export("id")
	int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 235222743
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2005302789
	)
	int field917;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1677449417
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 2086246849
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "1594273687"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Lff;IIB)Ldq;",
		garbageValue = "0"
	)
	public static final PcmPlayer method1856(TaskHandler var0, int var1, int var2) {
		if (PcmPlayer.PcmPlayer_sampleRate * 22050 == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = class188.pcmPlayerProvider.player();
				var3.samples = new int[256 * (InterfaceParent.PcmPlayer_stereo ? 2 : 1)];
				var3.field1388 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (ParamDefinition.PcmPlayer_count > 0 && VerticalAlignment.soundSystem == null) {
					VerticalAlignment.soundSystem = new SoundSystem();
					SecureRandomCallable.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					SecureRandomCallable.soundSystemExecutor.scheduleAtFixedRate(VerticalAlignment.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (VerticalAlignment.soundSystem != null) {
					if (VerticalAlignment.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					VerticalAlignment.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("lm")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "92"
	)
	public static boolean method1854() {
		return Client.staffModLevel >= 2;
	}
}
