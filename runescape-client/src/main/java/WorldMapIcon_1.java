import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = -395695129
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1547579339
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1354598699
	)
	@Export("element")
	int element;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 152564965
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1072450563
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILao;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lau;",
		garbageValue = "2077771117"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "650401890"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1828864081"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "10774"
	)
	@Export("init")
	void init() {
		this.element = WorldMapSection2.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(class25.WorldMapElement_get(this.element));
		WorldMapElement var1 = class25.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "39"
	)
	public static int method407(int var0) {
		return WorldMapRectangle.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "265635085"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field893 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (class74.getWindowedMode() == 1) {
			WorldMapSection1.client.setMaxCanvasSize(765, 503);
		} else {
			WorldMapSection1.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			PacketBufferNode var1 = FaceNormal.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class74.getWindowedMode());
			var1.packetBuffer.writeShort(WorldMapLabel.canvasWidth);
			var1.packetBuffer.writeShort(Varps.canvasHeight);
			Client.packetWriter.addNode(var1);
		}

	}
}
