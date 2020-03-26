import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class5 implements class12 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;)Lkb;"
	)
	public Buffer vmethod131(Buffer var1) {
		Buffer var2 = new Buffer(100);
		this.method81(var1, var2);
		return var2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;Lkb;)V"
	)
	void method81(Buffer var1, Buffer var2) {
		class10 var3 = new class10(var1);
		class6 var4 = new class6(var3);

		long var5;
		for (var5 = 0L; !var4.method83(var3.method127(), var3.method125(), var5); ++var5) {
		}

		var2.writeLong(var5);
	}
}
