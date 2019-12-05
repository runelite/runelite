import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("po")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	static final WorldMapID field268;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	static final WorldMapID field264;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1597448419
	)
	@Export("value")
	final int value;

	static {
		field268 = new WorldMapID(0);
		field264 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "2011689467"
	)
	public static int method566(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "(Lhl;I)Z",
		garbageValue = "1728709220"
	)
	static final boolean method567(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.logoutTimer = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.changeAppearance(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method4068(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.changeSex(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.changeSex(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = ModelData0.getPacketBufferNode(ClientPacket.field2322, Client.packetWriter.isaacCipher);
				Client.playerAppearance.write(var4.packetBuffer);
				Client.packetWriter.addNode(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
