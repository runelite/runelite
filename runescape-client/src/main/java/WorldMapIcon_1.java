import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("ql")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("pcmPlayer0")
	static PcmPlayer pcmPlayer0;
	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 638368553
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lav;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 815655685
	)
	@Export("element")
	int element;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1653555009
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -499996175
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILav;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "861849893"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lao;",
		garbageValue = "1066707711"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1386026878"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "174908718"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "3174"
	)
	@Export("init")
	void init() {
		this.element = WallDecoration.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(WorldMapSection1.WorldMapElement_get(this.element));
		WorldMapElement var1 = WorldMapSection1.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIZII)J",
		garbageValue = "583805703"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-116"
	)
	static final void method278(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method2970(var17, var18, var19);
			Rasterizer3D.method2990(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method2970(var17, var19, var20);
			Rasterizer3D.method2990(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
