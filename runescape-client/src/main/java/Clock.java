import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("Clock")
public abstract class Clock {
	@ObfuscatedName("qq")
	@ObfuscatedGetter(
		intValue = 1800617984
	)
	static int field2039;

	Clock() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "569029249"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1663360326"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1644538233"
	)
	static final int method3463() {
		return ViewportMouse.ViewportMouse_x;
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-31"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = InterfaceParent.getPacketBufferNode(ClientPacket.field2185, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE16(var0);
		var2.packetBuffer.writeShort(var1);
		Client.packetWriter.addNode(var2);
	}
}
