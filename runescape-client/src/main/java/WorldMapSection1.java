import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -202088829
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 844746677
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 577078223
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -98820949
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1420932505
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1812674669
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lac;I)V",
		garbageValue = "2098672163"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-327883108"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1535371561"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-1322751923"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)Lhb;",
		garbageValue = "1439979703"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-99"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1580543944"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;ZLkn;I)V",
		garbageValue = "956714191"
	)
	public static void method608(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
		ItemDefinition.ItemDefinition_archive = var0;
		ItemDefinition.ItemDefinition_modelArchive = var1;
		class162.ItemDefinition_inMembersWorld = var2;
		JagexCache.ItemDefinition_fileCount = ItemDefinition.ItemDefinition_archive.getGroupFileCount(10);
		FaceNormal.ItemDefinition_fontPlain11 = var3;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)Lcu;",
		garbageValue = "-1499115361"
	)
	static Script method591(int var0, int var1) {
		Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = GrandExchangeOfferOwnWorldComparator.archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = GrandExchangeOfferOwnWorldComparator.archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = class3.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long)(var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1323185906"
	)
	public static final void method582(int var0, int var1) {
		ViewportMouse.ViewportMouse_x = var0;
		ViewportMouse.ViewportMouse_y = var1;
		ViewportMouse.ViewportMouse_isInViewport = true;
		ViewportMouse.ViewportMouse_entityCount = 0;
		ViewportMouse.ViewportMouse_false0 = false;
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIIB)V",
		garbageValue = "-11"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			GrandExchangeEvent.method88(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field916 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;B)V",
		garbageValue = "31"
	)
	@Export("widgetDefaultMenuAction")
	static void widgetDefaultMenuAction(int opIndex, int parent, int childIdx, int itemID, String target) {
		Widget var5 = GrandExchangeOfferWorldComparator.getWidgetChild(parent, childIdx);
		if (var5 != null) {
			if (var5.onOp != null) {
				ScriptEvent var6 = new ScriptEvent();
				var6.widget = var5;
				var6.opIndex = opIndex;
				var6.targetName = target;
				var6.args = var5.onOp;
				ParamDefinition.runScriptEvent(var6);
			}

			boolean var11 = true;
			if (var5.contentType > 0) {
				var11 = class43.method840(var5);
			}

			if (var11) {
				int var8 = class2.getWidgetClickMask(var5);
				int var9 = opIndex - 1;
				boolean var7 = (var8 >> var9 + 1 & 1) != 0;
				if (var7) {
					PacketBufferNode var10;
					if (opIndex == 1) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 2) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 3) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 4) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2194, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 5) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 6) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2200, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 7) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 8) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2203, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 9) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

					if (opIndex == 10) {
						var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2285, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(parent);
						var10.packetBuffer.writeShort(childIdx);
						var10.packetBuffer.writeShort(itemID);
						Client.packetWriter.addNode(var10);
					}

				}
			}
		}
	}
}
