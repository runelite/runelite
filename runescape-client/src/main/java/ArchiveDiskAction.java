import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1673038183
	)
	@Export("type")
	int type;
	@ObfuscatedName("n")
	@Export("data")
	public byte[] data;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("archiveDisk")
	public ArchiveDisk archiveDisk;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive")
	public Archive archive;

	ArchiveDiskAction() {
	}
}
