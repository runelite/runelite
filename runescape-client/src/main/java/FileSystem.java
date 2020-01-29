import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("pk")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("c")
	@Export("FileSystem_hasPermissions")
	static boolean FileSystem_hasPermissions;
	@ObfuscatedName("t")
	@Export("FileSystem_cacheDir")
	static File FileSystem_cacheDir;
	@ObfuscatedName("o")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1674158829"
	)
	static boolean method3572(int var0, int var1) {
		return var0 != 4 || var1 < 8;
	}
}
