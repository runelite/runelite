import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -461319929
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("v")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}
}
