import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1141206621
	)
	static int field218;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -321078873
	)
	@Export("id")
	int id;
	@ObfuscatedName("n")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("v")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 795826291
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1782121101
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 546610083
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 178341683
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1886608901
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1084185477
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("c")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("b")
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-2114218332"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;B)Lad;",
		garbageValue = "-32"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE2, WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE1};
		WorldMapSectionType var4 = (WorldMapSectionType)NetSocket.findEnumerated(var3, var2);
		Object var5 = null;
		switch(var4.type) {
		case 0:
			var5 = new WorldMapSection2();
			break;
		case 1:
			var5 = new class42();
			break;
		case 2:
			var5 = new WorldMapSection0();
			break;
		case 3:
			var5 = new WorldMapSection1();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var5).read(var1);
		return (WorldMapSection)var5;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIS)Z",
		garbageValue = "-5877"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1223580997"
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-244878470"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIS)Lhb;",
		garbageValue = "4910"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1572539094"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "5"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1098544212"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-109"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "24"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-614914706"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-441315832"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1245166704"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "895043593"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1302627979"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2005373633"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-98"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "6"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "87434352"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Lhb;",
		garbageValue = "1917961065"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;I)V",
		garbageValue = "-757431099"
	)
	public static void method430(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		HitSplatDefinition.HitSplatDefinition_archive = var0;
		GrandExchangeOfferNameComparator.field66 = var1;
		HitSplatDefinition.HitSplatDefinition_fontsArchive = var2;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILkg;Lie;I)V",
		garbageValue = "-1765321046"
	)
	static void method429(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if ((long)var0 == var5.key && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}
	}
}
