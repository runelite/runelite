import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("lv")
	@ObfuscatedGetter(
		intValue = 147472747
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;
	@ObfuscatedName("o")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("e")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("n")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(Lkg;Lkg;IZI)V",
		garbageValue = "-2087275167"
	)
	@Export("init")
	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(Lkg;ZI)V",
		garbageValue = "83812464"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5618();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lhe;",
		garbageValue = "-2010559080"
	)
	public static StudioGame[] method709() {
		return new StudioGame[]{StudioGame.runescape, StudioGame.game3, StudioGame.oldscape, StudioGame.game4, StudioGame.game5, StudioGame.stellardawn};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "-1808835985"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		class191.method3721(var0, var1, "openjs", var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-67"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-316979952"
	)
	static final String method711(int var0) {
		if (var0 < 100000) {
			return "<col=ffff00>" + var0 + "</col>";
		} else {
			return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>" : "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1095185077"
	)
	public static void method703() {
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(Lbt;I)V",
		garbageValue = "-2077720731"
	)
	static final void method707(Actor var0) {
		if (var0.field982 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
			int var1 = var0.field982 - var0.field934;
			int var2 = Client.cycle - var0.field934;
			int var3 = var0.field946 * 128 + var0.field938 * 64;
			int var4 = var0.field979 * 128 + var0.field938 * 64;
			int var5 = var0.field978 * 128 + var0.field938 * 64;
			int var6 = var0.field980 * 128 + var0.field938 * 64;
			var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
			var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
		}

		var0.field976 = 0;
		var0.orientation = var0.field983;
		var0.rotation = var0.orientation;
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "74366885"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = ModelData0.getPacketBufferNode(ClientPacket.field2314, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
