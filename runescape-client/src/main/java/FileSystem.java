import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fg")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("z")
	@Export("FileSystem_hasPermissions")
	public static boolean FileSystem_hasPermissions;
	@ObfuscatedName("n")
	@Export("FileSystem_cacheDir")
	public static File FileSystem_cacheDir;
	@ObfuscatedName("v")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}
}
