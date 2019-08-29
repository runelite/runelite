import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	static StudioGame field166;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = 161269475
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -35093497
	)
	@Export("width")
	int width;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -975025893
	)
	@Export("height")
	int height;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1556626299
	)
	@Export("x")
	int x;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1692274853
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lao;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IB)V",
		garbageValue = "87"
	)
	static final void method281(String var0, int var1) {
		PacketBufferNode var2 = MenuAction.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.writeByte(var1);
		Client.packetWriter.addNode(var2);
	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1711181474"
	)
	static final void method280() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				class1.calculateActorPosition(var2, var2.definition.size);
			}
		}

	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(Lhp;B)Z",
		garbageValue = "1"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}
