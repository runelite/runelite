import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1722853761
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("b")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;I)V",
		garbageValue = "-568024441"
	)
	public static void method4230(AbstractArchive var0) {
		StructDefinition.StructDefinition_archive = var0;
	}
}
