import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class247 {
	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-197171985"
	)
	static final void method4484() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.hitpoints == -1) {
				var0.delay = 0;
				class16.method164(var0);
			} else {
				var0.remove();
			}
		}

	}
}
