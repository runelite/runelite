import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 399748255
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1594551933
	)
	@Export("element")
	int element;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Law;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 2144976415
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 649203899
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lht;Lht;ILas;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "63"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "-1801186977"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2033351231"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1873129621"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("init")
	void init() {
		this.element = Coord.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(this.element));
		WorldMapElement var1 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lij;",
		garbageValue = "-754699522"
	)
	@Export("getParamDefinition")
	public static ParamDefinition getParamDefinition(int var0) {
		ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ParamDefinition.ParamDefinition_archive.takeFile(11, var0);
			var1 = new ParamDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			ParamDefinition.ParamDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1785574656"
	)
	static void method277() {
		Tiles.Tiles_minPlane = 99;
		class14.field88 = new byte[4][104][104];
		Tiles.field498 = new byte[4][104][104];
		Tiles.field494 = new byte[4][104][104];
		Tiles.field493 = new byte[4][104][104];
		Tiles.field501 = new int[4][105][105];
		Tiles.field496 = new byte[4][105][105];
		ArchiveLoader.field512 = new int[105][105];
		UrlRequest.Tiles_hue = new int[104];
		MenuAction.Tiles_saturation = new int[104];
		PacketBufferNode.Tiles_lightness = new int[104];
		Tiles.Tiles_hueMultiplier = new int[104];
		Varcs.field1244 = new int[104];
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "57"
	)
	static void method296() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				class14.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "75"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (Calendar.clanChat != null) {
			PacketBufferNode var1 = class2.getPacketBufferNode(ClientPacket.field2245, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
