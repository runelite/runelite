import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive0")
	static Archive archive0;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1964239455
	)
	@Export("type")
	int type;
	@ObfuscatedName("m")
	@Export("data")
	public byte[] data;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("archiveDisk")
	public ArchiveDisk archiveDisk;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive")
	public Archive archive;

	ArchiveDiskAction() {
	}
}
