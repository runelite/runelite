import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class227 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-673521466"
	)
	public static int method4200(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1891530232"
	)
	static final void method4184() {
		PacketBufferNode var0 = FaceNormal.getPacketBufferNode(ClientPacket.field2245, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				class41.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			ItemContainer.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
