import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class267 {
	@ObfuscatedName("ai")
	@Export("hasFocus")
	protected static boolean hasFocus;

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1804556356"
	)
	static final void method4986() {
		Client.field849 = Client.cycleCntr;
		GrandExchangeEvent.ClanChat_inClanChat = true;
	}
}
