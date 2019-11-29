import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class99 {
	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Lde;",
		garbageValue = "2104968763"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2048125775"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		class40.logOut();
		switch(var0) {
		case 1:
			Login.loginIndex = 24;
			PacketWriter.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			Login.loginIndex = 24;
			PacketWriter.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}
}
