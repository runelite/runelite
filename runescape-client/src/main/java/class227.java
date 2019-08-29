import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public final class class227 {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lln;ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-102"
	)
	static String method4041(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Lbi;",
		garbageValue = "-93383433"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1725811836"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
