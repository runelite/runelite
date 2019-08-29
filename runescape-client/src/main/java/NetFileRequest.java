import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("eh")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 450253051
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("i")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}
}
