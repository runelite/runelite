import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class13 {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(CS)Z",
		garbageValue = "32317"
	)
	public static final boolean method200(char var0) {
		return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	static final void method199() {
		Scene.Scene_isLowDetail = false;
		Client.isLowDetail = false;
	}
}
