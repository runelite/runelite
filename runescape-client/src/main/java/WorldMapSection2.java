import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = 1762244161
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("gn")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2107748955
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -841656425
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1431840249
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 537268121
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1669995065
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 188092539
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 954202009
	)
	int field177;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -51242925
	)
	int field181;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 169848389
	)
	int field182;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1576272075
	)
	int field183;

	WorldMapSection2() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "515570621"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field177) {
			var1.regionLowX = this.field177;
		}

		if (var1.regionHighX < this.field182) {
			var1.regionHighX = this.field182;
		}

		if (var1.regionLowY > this.field181) {
			var1.regionLowY = this.field181;
		}

		if (var1.regionHighY < this.field183) {
			var1.regionHighY = this.field183;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "2033433479"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-66"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field177 && var1 >> 6 <= this.field182 && var2 >> 6 >= this.field181 && var2 >> 6 <= this.field183;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1684413985"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field177 * 64 - this.regionStartX * 64 + var2, var3 + (this.field181 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lht;",
		garbageValue = "21"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field177 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field181 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "74"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field177 = var1.readUnsignedShort();
		this.field181 = var1.readUnsignedShort();
		this.field182 = var1.readUnsignedShort();
		this.field183 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1724317369"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-261996704"
	)
	public static int method322(int var0) {
		return class2.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(Lha;IIIIIIB)V",
		garbageValue = "16"
	)
	static final void method321(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field695) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field695 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !NetFileRequest.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				LoginPacket.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				LoginPacket.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				LoginPacket.invalidateWidget(var0);
				Client.field695 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				LoginPacket.invalidateWidget(var0);
			}
		}

	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1461101470"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = class2.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
