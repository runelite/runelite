import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 129403551
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -774334227
	)
	@Export("element")
	int element;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -246439835
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1431818505
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;ILaq;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1878632225"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lar;",
		garbageValue = "-77909992"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "60677286"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-92"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "55"
	)
	@Export("init")
	void init() {
		this.element = WorldMapDecorationType.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(class65.WorldMapElement_get(this.element));
		WorldMapElement var1 = class65.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([Lgy;IS)Lgy;",
		garbageValue = "9030"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Lcj;",
		garbageValue = "-1901279289"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var6 = (Script)Script.Script_cached.get((long)(var3 << 16));
		Script var5;
		if (var6 != null) {
			var5 = var6;
		} else {
			String var7 = String.valueOf(var3);
			int var8 = Occluder.archive12.getGroupId(var7);
			if (var8 == -1) {
				var5 = null;
			} else {
				label56: {
					byte[] var9 = Occluder.archive12.takeFileFlat(var8);
					if (var9 != null) {
						if (var9.length <= 1) {
							var5 = null;
							break label56;
						}

						var6 = WorldMapIcon_0.newScript(var9);
						if (var6 != null) {
							Script.Script_cached.put(var6, (long)(var3 << 16));
							var5 = var6;
							break label56;
						}
					}

					var5 = null;
				}
			}
		}

		if (var5 != null) {
			return var5;
		} else {
			int var13 = (var2 + 40000 << 8) + var0;
			Script var15 = (Script)Script.Script_cached.get((long)(var13 << 16));
			Script var14;
			if (var15 != null) {
				var14 = var15;
			} else {
				String var10 = String.valueOf(var13);
				int var11 = Occluder.archive12.getGroupId(var10);
				if (var11 == -1) {
					var14 = null;
				} else {
					byte[] var12 = Occluder.archive12.takeFileFlat(var11);
					if (var12 != null) {
						if (var12.length <= 1) {
							var14 = null;
							return var14 != null ? var14 : null;
						}

						var15 = WorldMapIcon_0.newScript(var12);
						if (var15 != null) {
							Script.Script_cached.put(var15, (long)(var13 << 16));
							var14 = var15;
							return var14 != null ? var14 : null;
						}
					}

					var14 = null;
				}
			}

			return var14 != null ? var14 : null;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Lbt;",
		garbageValue = "1340255179"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkc;J)V"
	)
	static void method354(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.writeShort((int)var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-318673135"
	)
	static final void method355(String var0) {
		StringBuilder var10000 = new StringBuilder();
		Object var10001 = null;
		var10000 = var10000.append("Please remove ").append(var0);
		var10001 = null;
		String var1 = var10000.append(" from your friend list first").toString();
		class30.addGameMessage(30, "", var1);
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(Lhi;III)V",
		garbageValue = "-894965575"
	)
	@Export("checkIfMinimapClicked")
	static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
		if (Client.minimapState == 0 || Client.minimapState == 3) {
			if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
				SpriteMask var3 = var0.getSpriteMask(true);
				if (var3 == null) {
					return;
				}

				int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
				int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
				if (var3.contains(var4, var5)) {
					var4 -= var3.width / 2;
					var5 -= var3.height / 2;
					int var6 = Client.camAngleY & 2047;
					int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
					int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
					int var9 = var5 * var7 + var4 * var8 >> 11;
					int var10 = var8 * var5 - var7 * var4 >> 11;
					int var11 = var9 + class215.localPlayer.x >> 7;
					int var12 = class215.localPlayer.y - var10 >> 7;
					PacketBufferNode var13 = SoundSystem.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
					var13.packetBuffer.writeByte(18);
					var13.packetBuffer.writeShort(UserComparator8.baseX * 64 + var11);
					var13.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
					var13.packetBuffer.writeShort(HealthBar.baseY * 64 + var12);
					var13.packetBuffer.writeByte(var4);
					var13.packetBuffer.writeByte(var5);
					var13.packetBuffer.writeShort(Client.camAngleY);
					var13.packetBuffer.writeByte(57);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(89);
					var13.packetBuffer.writeShort(class215.localPlayer.x);
					var13.packetBuffer.writeShort(class215.localPlayer.y);
					var13.packetBuffer.writeByte(63);
					Client.packetWriter.addNode(var13);
					Client.destinationX = var11;
					Client.destinationY = var12;
				}
			}

		}
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1825518437"
	)
	static boolean method351(int var0) {
		return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
	}
}
