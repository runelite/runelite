import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class198 {
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static ServerBuild field2353;

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "1"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (LoginScreenAnimation.loadInterface(var0)) {
			SecureRandomCallable.runComponentCloseListeners(Widget.Widget_interfaceComponents[var0], var1);
		}
	}
}
