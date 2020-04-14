import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("PlayerProvider")
public interface PlayerProvider {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "65536"
	)
	@Export("player")
	PcmPlayer player();
}
