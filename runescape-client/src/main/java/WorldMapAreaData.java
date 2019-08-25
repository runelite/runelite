import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	static Bounds field332;
	@ObfuscatedName("x")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("r")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("v")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "(Lkf;Lkf;IZB)V",
		garbageValue = "-52"
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

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(Lkf;ZI)V",
		garbageValue = "2146657354"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5511();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(III)Lfl;",
		garbageValue = "2134464513"
	)
	static RouteStrategy method667(int var0, int var1) {
		Client.field735.approxDestinationX = var0;
		Client.field735.approxDestinationY = var1;
		Client.field735.approxDestinationSizeX = 1;
		Client.field735.approxDestinationSizeY = 1;
		return Client.field735;
	}
}
