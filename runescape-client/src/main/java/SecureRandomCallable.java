import java.security.SecureRandom;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("su")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("pcmPlayerProvider")
	static PcmPlayerProvider pcmPlayerProvider;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1643871529
	)
	static int field500;
	@ObfuscatedName("ej")
	@ObfuscatedGetter(
		intValue = 1838360693
	)
	@Export("port3")
	static int port3;

	SecureRandomCallable() {
	}

	public Object call() {
		SecureRandom var2 = new SecureRandom();
		var2.nextInt();
		return var2;
	}
}
