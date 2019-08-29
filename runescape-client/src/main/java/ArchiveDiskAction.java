import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1794438743
	)
	@Export("type")
	int type;
	@ObfuscatedName("j")
	@Export("data")
	byte[] data;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive")
	Archive archive;

	ArchiveDiskAction() {
	}
}
