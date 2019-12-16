import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public final class class227 {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-2145751121"
	)
	static boolean method4102(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}
}
