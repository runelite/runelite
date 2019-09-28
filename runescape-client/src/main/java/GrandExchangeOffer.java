import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("nx")
	@ObfuscatedSignature(
		signature = "[Lho;"
	)
	static Widget[] field61;
	@ObfuscatedName("z")
	@Export("state")
	byte state;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 152227217
	)
	@Export("id")
	public int id;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1304592967
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1942003277
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 244433103
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 22250551
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkl;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-719257783"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-9"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1269791927"
	)
	void method110(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "3"
	)
	void method117(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "2022647645"
	)
	static final void method129(boolean var0) {
		WorldMapID.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field730 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = InterfaceParent.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.field730 = true;
				}
			}

		}
	}
}
