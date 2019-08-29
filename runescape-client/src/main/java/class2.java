import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class2 implements class0 {
	@ObfuscatedName("sl")
	@ObfuscatedSignature(
		signature = "Lt;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("ed")
	@Export("secureRandom")
	static SecureRandom secureRandom;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lky;I)V",
		garbageValue = "254789492"
	)
	public void vmethod58(Object var1, Buffer var2) {
		this.method38((Long)var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)Ljava/lang/Object;",
		garbageValue = "1267204541"
	)
	public Object vmethod70(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lky;B)V",
		garbageValue = "6"
	)
	void method38(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lgq;",
		garbageValue = "-764914873"
	)
	public static PacketBufferNode method29() {
		PacketBufferNode var0 = Buffer.method5567();
		var0.clientPacket = null;
		var0.clientPacketLength = 0;
		var0.packetBuffer = new PacketBuffer(5000);
		return var0;
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1255572967"
	)
	static final void method31() {
		if (Client.logoutTimer > 0) {
			class65.method1182();
		} else {
			Client.timer.method4898();
			FloorDecoration.updateGameState(40);
			Bounds.field3845 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "742937665"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (Projectile.loadInterface(var0)) {
			WorldMapIcon_1.field174 = null;
			WorldMapSectionType.drawInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (WorldMapIcon_1.field174 != null) {
				WorldMapSectionType.drawInterface(WorldMapIcon_1.field174, -1412584499, var1, var2, var3, var4, HealthBarUpdate.field986, Tile.field1648, var7);
				WorldMapIcon_1.field174 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field703[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field703[var8] = true;
				}
			}

		}
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "361090625"
	)
	static boolean method40(int var0) {
		for (int var1 = 0; var1 < Client.field677; ++var1) {
			if (Client.field815[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
