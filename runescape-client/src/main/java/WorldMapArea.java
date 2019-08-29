import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1092118655
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("i")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -254766629
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1599697543
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -798691043
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -415983949
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -103515401
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1136743993
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("f")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("c")
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;IB)V",
		garbageValue = "25"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)Lac;",
		garbageValue = "1253292592"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE2, WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE1};
		WorldMapSectionType var4 = (WorldMapSectionType)FriendSystem.findEnumerated(var3, var2);
		Object var5 = null;
		switch(var4.type) {
		case 0:
			var5 = new WorldMapSection0();
			break;
		case 1:
			var5 = new WorldMapSection1();
			break;
		case 2:
			var5 = new class42();
			break;
		case 3:
			var5 = new WorldMapSection2();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var5).read(var1);
		return (WorldMapSection)var5;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-80"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1925873214"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1386977444"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)Lhd;",
		garbageValue = "-1952348656"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-205538232"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-848943890"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-731208789"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "5"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-10827335"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1129400396"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1627458520"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1112975954"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1527013006"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-492028203"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "789236832"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1012366175"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "50"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "840568751"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)Lhd;",
		garbageValue = "63"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;I)V",
		garbageValue = "-1168462803"
	)
	@Export("NpcDefinition_setArchives")
	public static void NpcDefinition_setArchives(AbstractArchive var0, AbstractArchive var1) {
		NPCDefinition.NpcDefinition_archive = var0;
		NPCDefinition.NpcDefinition_modelArchive = var1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Ldz;S)V",
		garbageValue = "7503"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1974361592"
	)
	static final void method358(boolean var0) {
		if (var0) {
			Client.field870 = Login.field1171 ? class160.field1982 : class160.field1983;
		} else {
			LinkedHashMap var1 = GrandExchangeOffer.clientPreferences.parameters;
			String var3 = Login.Login_username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field870 = var1.containsKey(var5) ? class160.field1988 : class160.field1984;
		}

	}
}
