import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("x")
	@Export("FileSystem_hasPermissions")
	public static boolean FileSystem_hasPermissions;
	@ObfuscatedName("m")
	@Export("FileSystem_cacheDir")
	public static File FileSystem_cacheDir;
	@ObfuscatedName("k")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-28"
	)
	static final boolean method3588(int var0, int var1) {
		ObjectDefinition var2 = WorldMapSection2.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4661(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Lds;S)V",
		garbageValue = "4477"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}
}
