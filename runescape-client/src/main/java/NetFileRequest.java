import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("re")
	@ObfuscatedGetter(
		intValue = 642121189
	)
	static int field3126;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive")
	public Archive archive;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -782171773
	)
	@Export("crc")
	public int crc;
	@ObfuscatedName("k")
	@Export("padding")
	public byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lje;",
		garbageValue = "534124687"
	)
	static HorizontalAlignment[] method4244() {
		return new HorizontalAlignment[]{HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3453, HorizontalAlignment.field3458};
	}
}
