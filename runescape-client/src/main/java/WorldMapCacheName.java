import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("sr")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	public static final WorldMapCacheName field295;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	public static final WorldMapCacheName field290;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	public static final WorldMapCacheName field291;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	static final WorldMapCacheName field292;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	public static final WorldMapCacheName field293;
	@ObfuscatedName("n")
	@Export("name")
	public final String name;

	static {
		field295 = new WorldMapCacheName("details");
		field290 = new WorldMapCacheName("compositemap");
		field291 = new WorldMapCacheName("compositetexture");
		field292 = new WorldMapCacheName("area");
		field293 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "40"
	)
	static void method593() {
		PacketBufferNode var0 = MenuAction.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(UserComparator7.getWindowedMode());
		var0.packetBuffer.writeShort(KitDefinition.canvasWidth);
		var0.packetBuffer.writeShort(class30.canvasHeight);
		Client.packetWriter.addNode(var0);
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "350490543"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (Client.clanChat != null) {
			PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
