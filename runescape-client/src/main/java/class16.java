import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class16 {
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static StudioGame field101;

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-194801296"
	)
	static boolean method195() {
		return (Client.drawPlayerNames & 8) != 0;
	}
}
