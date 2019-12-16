import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("Clock")
public abstract class Clock {
	Clock() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "670539248"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "90199453"
	)
	static int method3489(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		return PrivateChatMode.NetCache_currentResponse != null && PrivateChatMode.NetCache_currentResponse.key == var2 ? NetCache.NetCache_responseArchiveBuffer.offset * 99 / (NetCache.NetCache_responseArchiveBuffer.array.length - PrivateChatMode.NetCache_currentResponse.padding) + 1 : 0;
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1974720745"
	)
	static final void method3488() {
		PacketBufferNode var0 = class2.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				VarpDefinition.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			LoginPacket.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
