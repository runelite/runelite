import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("qq")
	@ObfuscatedGetter(
		intValue = 1818020345
	)
	static int field211;
	@ObfuscatedName("bs")
	static String field217;
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1655735229
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("t")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1137317827
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1994031909
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1491107613
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 606325911
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2012001011
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -303428785
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("n")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("h")
	@Export("sections")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "-895936628"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;B)Lab;",
		garbageValue = "-54"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE1, WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE2};
		WorldMapSectionType var4 = (WorldMapSectionType)ServerPacket.findEnumerated(var3, var2);
		Object var5 = null;
		switch(var4.type) {
		case 0:
			var5 = new WorldMapSection1();
			break;
		case 1:
			var5 = new class42();
			break;
		case 2:
			var5 = new WorldMapSection2();
			break;
		case 3:
			var5 = new WorldMapSection0();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var5).read(var1);
		return (WorldMapSection)var5;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "937674966"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return true;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1788477948"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection)var5.next();
				} while(!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "124"
	)
	@Export("position")
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "-63"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection)var3.next();
		} while(!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1096430580"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-25"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "63"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1625444828"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "69"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1831557755"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "201981881"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1169721837"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "255"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1241081128"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-711950518"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "35"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-377438716"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2063463136"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Lhj;",
		garbageValue = "-1241114474"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IILfw;Lfj;I)Z",
		garbageValue = "-2082294853"
	)
	static final boolean method315(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
		int var4 = var0;
		int var5 = var1;
		byte var6 = 64;
		byte var7 = 64;
		int var8 = var0 - var6;
		int var9 = var1 - var7;
		class173.directions[var6][var7] = 99;
		class173.distances[var6][var7] = 0;
		byte var10 = 0;
		int var11 = 0;
		class173.bufferX[var10] = var0;
		byte var10001 = var10;
		int var18 = var10 + 1;
		class173.bufferY[var10001] = var1;
		int[][] var12 = var3.flags;

		while (var11 != var18) {
			var4 = class173.bufferX[var11];
			var5 = class173.bufferY[var11];
			var11 = var11 + 1 & 4095;
			int var16 = var4 - var8;
			int var17 = var5 - var9;
			int var13 = var4 - var3.xInset;
			int var14 = var5 - var3.yInset;
			if (var2.hasArrived(2, var4, var5, var3)) {
				class173.field2063 = var4;
				class173.field2068 = var5;
				return true;
			}

			int var15 = class173.distances[var16][var17] + 1;
			if (var16 > 0 && class173.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17] = 2;
				class173.distances[var16 - 1][var17] = var15;
			}

			if (var16 < 126 && class173.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17] = 8;
				class173.distances[var16 + 1][var17] = var15;
			}

			if (var17 > 0 && class173.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 - 1] = 1;
				class173.distances[var16][var17 - 1] = var15;
			}

			if (var17 < 126 && class173.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 + 1] = 4;
				class173.distances[var16][var17 + 1] = var15;
			}

			if (var16 > 0 && var17 > 0 && class173.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 - 1] = 3;
				class173.distances[var16 - 1][var17 - 1] = var15;
			}

			if (var16 < 126 && var17 > 0 && class173.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 - 1] = 9;
				class173.distances[var16 + 1][var17 - 1] = var15;
			}

			if (var16 > 0 && var17 < 126 && class173.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 + 1] = 6;
				class173.distances[var16 - 1][var17 + 1] = var15;
			}

			if (var16 < 126 && var17 < 126 && class173.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 + 1] = 12;
				class173.distances[var16 + 1][var17 + 1] = var15;
			}
		}

		class173.field2063 = var4;
		class173.field2068 = var5;
		return false;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "127"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}
}
