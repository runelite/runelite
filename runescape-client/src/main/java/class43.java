import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public final class class43 {
	@ObfuscatedName("qp")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2015849949
	)
	static int field381;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lbn;",
		garbageValue = "-983073165"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1093470855"
	)
	public static int method816(int var0) {
		return class14.method169(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lks;B)V",
		garbageValue = "-25"
	)
	static final void method813(PacketBuffer var0) {
		for (int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
			int var2 = Players.Players_pendingUpdateIndices[var1];
			Player var3 = Client.players[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 4) != 0) {
				var4 += var0.readUnsignedByte() << 8;
			}

			AbstractWorldMapIcon.method613(var0, var2, var3, var4);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-67193374"
	)
	static final void method817(String var0) {
		PacketBufferNode var1 = TilePaint.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
