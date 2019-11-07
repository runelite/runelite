import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("li")
public class class319 {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "-107"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		DevicePcmPlayerProvider.method919(var0);
		class2.method49(var0);
		if (var0.offset - var2 != var1) {
			throw new RuntimeException(var0.offset - var2 + " " + var1);
		}
	}
}
