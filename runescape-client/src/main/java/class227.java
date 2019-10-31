import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public final class class227 {
	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "401085216"
	)
	static void method4276() {
		if (Client.renderSelf) {
			Player.addPlayerToScene(class215.localPlayer, false);
		}

	}
}
