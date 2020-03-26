import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class10 {
	@ObfuscatedName("x")
	final int field53;
	@ObfuscatedName("m")
	final int field54;
	@ObfuscatedName("k")
	final String field55;

	@ObfuscatedSignature(
		signature = "(Lkb;)V"
	)
	class10(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class10(int var1, int var2, String var3) {
		this.field53 = var1;
		this.field54 = var2;
		this.field55 = var3;
	}

	@ObfuscatedName("x")
	String method125() {
		return Integer.toHexString(this.field53) + Integer.toHexString(this.field54) + this.field55;
	}

	@ObfuscatedName("m")
	int method127() {
		return this.field54;
	}
}
