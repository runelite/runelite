import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "Lbn;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive19")
	static Archive archive19;
	@ObfuscatedName("z")
	@Export("text")
	String text;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -38349507
	)
	@Export("width")
	int width;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -212014043
	)
	@Export("height")
	int height;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILg;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(ILhb;ZI)V",
		garbageValue = "203573450"
	)
	static void method439(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = Decimator.getWorldMap().getMapArea(var0);
		int var4 = class223.localPlayer.plane;
		int var5 = class223.baseX * 64 + (class223.localPlayer.x >> 7);
		int var6 = class286.baseY * 64 + (class223.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		Decimator.getWorldMap().method6449(var3, var7, var1, var2);
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "125"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = InterfaceParent.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}
}
