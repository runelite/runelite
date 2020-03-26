import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("he")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[[Lhe;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("z")
	@Export("Widget_loadedInterfaces")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("Widget_cachedSprites")
	public static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("Widget_cachedModels")
	public static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("Widget_cachedFonts")
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("i")
	public static boolean field2565;
	@ObfuscatedName("a")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -957641141
	)
	@Export("id")
	public int id;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -611900971
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -802488779
	)
	@Export("type")
	public int type;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -248776571
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1856343159
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1508256889
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 286003577
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1131410983
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 357993753
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1997338621
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1586734249
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1225404085
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -568238685
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 893339967
	)
	@Export("x")
	public int x;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -426365475
	)
	@Export("y")
	public int y;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1065823023
	)
	@Export("width")
	public int width;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 379197055
	)
	@Export("height")
	public int height;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 162401447
	)
	public int field2584;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1885155777
	)
	public int field2585;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1237608307
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("ao")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 615773905
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1171290753
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 108625295
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1982360223
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1176894453
	)
	@Export("color")
	public int color;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 306036279
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 466751965
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1324656195
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ad")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("fillMode")
	public class332 fillMode;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 14590311
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 974116043
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 2009428193
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bf")
	public boolean field2601;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 66057751
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1011748949
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -911208959
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bk")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -551996645
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 898417273
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bg")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bt")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1679439917
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 483051319
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 125406963
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1734767957
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -166910705
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -389521949
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1269071469
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -924975785
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -1358169901
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 283299325
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1945900441
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1346742871
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -1413539479
	)
	public int field2622;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1706662487
	)
	public int field2623;
	@ObfuscatedName("bi")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bl")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1321908019
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1118352365
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cc")
	@Export("text")
	public String text;
	@ObfuscatedName("ch")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -1838623877
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -1124877935
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 1212909225
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cm")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 99927781
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -534420979
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cg")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cd")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cx")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("cn")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 1025348499
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cz")
	public boolean field2641;
	@ObfuscatedName("cb")
	public byte[][] field2555;
	@ObfuscatedName("cy")
	public byte[][] field2643;
	@ObfuscatedName("cj")
	public int[] field2644;
	@ObfuscatedName("cp")
	public int[] field2695;
	@ObfuscatedName("dv")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dd")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dz")
	@ObfuscatedGetter(
		intValue = -1434163873
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dg")
	@ObfuscatedGetter(
		intValue = -1149387947
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dq")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dj")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dl")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("dm")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("db")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("dw")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("de")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("dh")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dk")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("da")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("do")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("dr")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dx")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dy")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("dc")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("ds")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dt")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dp")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("df")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("di")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dn")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("ea")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ex")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("eo")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("et")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("eh")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("eq")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("el")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("ei")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("en")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ec")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("ev")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("eb")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ej")
	public Object[] field2691;
	@ObfuscatedName("ed")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("ee")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("ep")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 58254591
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("ef")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("eu")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("em")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ez")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("ek")
	@ObfuscatedGetter(
		intValue = -1761852993
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = 612667463
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = 1022717263
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -1039552423
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "[Lhe;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fk")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fw")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fl")
	@ObfuscatedGetter(
		intValue = -1024561307
	)
	public int field2700;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = 1220339105
	)
	public int field2701;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = -524679265
	)
	public int field2620;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = -1480837579
	)
	public int field2588;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = -612332201
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = 847308047
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fv")
	public int[] field2706;
	@ObfuscatedName("fc")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fp")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fg")
	public boolean field2658;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2565 = false;
	}

	public Widget() {
		this.isIf3 = false;
		this.id = -1;
		this.childIndex = -1;
		this.buttonType = 0;
		this.contentType = 0;
		this.xAlignment = 0;
		this.yAlignment = 0;
		this.widthAlignment = 0;
		this.heightAlignment = 0;
		this.rawX = 0;
		this.rawY = 0;
		this.rawWidth = 0;
		this.rawHeight = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.field2584 = 1;
		this.field2585 = 1;
		this.parentId = -1;
		this.isHidden = false;
		this.scrollX = 0;
		this.scrollY = 0;
		this.scrollWidth = 0;
		this.scrollHeight = 0;
		this.color = 0;
		this.color2 = 0;
		this.mouseOverColor = 0;
		this.mouseOverColor2 = 0;
		this.fill = false;
		this.fillMode = class332.SOLID;
		this.transparencyTop = 0;
		this.transparencyBot = 0;
		this.lineWid = 1;
		this.field2601 = false;
		this.spriteId2 = -1;
		this.spriteId = -1;
		this.spriteAngle = 0;
		this.spriteTiling = false;
		this.outline = 0;
		this.spriteShadow = 0;
		this.modelType = 1;
		this.modelId = -1;
		this.modelType2 = 1;
		this.modelId2 = -1;
		this.sequenceId = -1;
		this.sequenceId2 = -1;
		this.modelOffsetX = 0;
		this.modelOffsetY = 0;
		this.modelAngleX = 0;
		this.modelAngleY = 0;
		this.modelAngleZ = 0;
		this.modelZoom = 100;
		this.field2622 = 0;
		this.field2623 = 0;
		this.modelOrthog = false;
		this.modelTransparency = false;
		this.itemQuantityMode = 2;
		this.fontId = -1;
		this.text = "";
		this.text2 = "";
		this.textLineHeight = 0;
		this.textXAlignment = 0;
		this.textYAlignment = 0;
		this.textShadowed = false;
		this.paddingX = 0;
		this.paddingY = 0;
		this.clickMask = 0;
		this.field2641 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.spellName = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.containsMouse = false;
		this.isClicked = false;
		this.field2700 = -1;
		this.field2701 = 0;
		this.field2620 = 0;
		this.field2588 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2658 = false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-113"
	)
	@Export("decodeLegacy")
	void decodeLegacy(Buffer var1) {
		this.isIf3 = false;
		this.type = var1.readUnsignedByte();
		this.buttonType = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		this.rawHeight = var1.readUnsignedShort();
		this.transparencyTop = var1.readUnsignedByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.mouseOverRedirect = var1.readUnsignedShort();
		if (this.mouseOverRedirect == 65535) {
			this.mouseOverRedirect = -1;
		}

		int var2 = var1.readUnsignedByte();
		int var3;
		if (var2 > 0) {
			this.cs1Comparisons = new int[var2];
			this.cs1ComparisonValues = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.cs1Comparisons[var3] = var1.readUnsignedByte();
				this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
			}
		}

		var3 = var1.readUnsignedByte();
		int var4;
		int var5;
		int var6;
		if (var3 > 0) {
			this.cs1Instructions = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				var5 = var1.readUnsignedShort();
				this.cs1Instructions[var4] = new int[var5];

				for (var6 = 0; var6 < var5; ++var6) {
					this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
					if (this.cs1Instructions[var4][var6] == 65535) {
						this.cs1Instructions[var4][var6] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = var1.readUnsignedShort();
			this.isHidden = var1.readUnsignedByte() == 1;
		}

		if (this.type == 1) {
			var1.readUnsignedShort();
			var1.readUnsignedByte();
		}

		if (this.type == 2) {
			this.itemIds = new int[this.rawWidth * this.rawHeight];
			this.itemQuantities = new int[this.rawHeight * this.rawWidth];
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.clickMask |= 268435456;
			}

			var5 = var1.readUnsignedByte();
			if (var5 == 1) {
				this.clickMask |= 1073741824;
			}

			var6 = var1.readUnsignedByte();
			if (var6 == 1) {
				this.clickMask |= Integer.MIN_VALUE;
			}

			int var7 = var1.readUnsignedByte();
			if (var7 == 1) {
				this.clickMask |= 536870912;
			}

			this.paddingX = var1.readUnsignedByte();
			this.paddingY = var1.readUnsignedByte();
			this.inventoryXOffsets = new int[20];
			this.inventoryYOffsets = new int[20];
			this.inventorySprites = new int[20];

			int var8;
			for (var8 = 0; var8 < 20; ++var8) {
				int var9 = var1.readUnsignedByte();
				if (var9 == 1) {
					this.inventoryXOffsets[var8] = var1.readShort();
					this.inventoryYOffsets[var8] = var1.readShort();
					this.inventorySprites[var8] = var1.readInt();
				} else {
					this.inventorySprites[var8] = -1;
				}
			}

			this.itemActions = new String[5];

			for (var8 = 0; var8 < 5; ++var8) {
				String var11 = var1.readStringCp1252NullTerminated();
				if (var11.length() > 0) {
					this.itemActions[var8] = var11;
					this.clickMask |= 1 << var8 + 23;
				}
			}
		}

		if (this.type == 3) {
			this.fill = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textLineHeight = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4) {
			this.text = var1.readStringCp1252NullTerminated();
			this.text2 = var1.readStringCp1252NullTerminated();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.color = var1.readInt();
		}

		if (this.type == 3 || this.type == 4) {
			this.color2 = var1.readInt();
			this.mouseOverColor = var1.readInt();
			this.mouseOverColor2 = var1.readInt();
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteId = var1.readInt();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelType2 = 1;
			this.modelId2 = var1.readUnsignedShort();
			if (this.modelId2 == 65535) {
				this.modelId2 = -1;
			}

			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.sequenceId2 = var1.readUnsignedShort();
			if (this.sequenceId2 == 65535) {
				this.sequenceId2 = -1;
			}

			this.modelZoom = var1.readUnsignedShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
		}

		if (this.type == 7) {
			this.itemIds = new int[this.rawHeight * this.rawWidth];
			this.itemQuantities = new int[this.rawWidth * this.rawHeight];
			this.textXAlignment = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
			this.color = var1.readInt();
			this.paddingX = var1.readShort();
			this.paddingY = var1.readShort();
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.clickMask |= 1073741824;
			}

			this.itemActions = new String[5];

			for (var5 = 0; var5 < 5; ++var5) {
				String var10 = var1.readStringCp1252NullTerminated();
				if (var10.length() > 0) {
					this.itemActions[var5] = var10;
					this.clickMask |= 1 << var5 + 23;
				}
			}
		}

		if (this.type == 8) {
			this.text = var1.readStringCp1252NullTerminated();
		}

		if (this.buttonType == 2 || this.type == 2) {
			this.spellActionName = var1.readStringCp1252NullTerminated();
			this.spellName = var1.readStringCp1252NullTerminated();
			var4 = var1.readUnsignedShort() & 63;
			this.clickMask |= var4 << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.buttonText = var1.readStringCp1252NullTerminated();
			if (this.buttonText.length() == 0) {
				if (this.buttonType == 1) {
					this.buttonText = "Ok";
				}

				if (this.buttonType == 4) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 5) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 6) {
					this.buttonText = "Continue";
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.clickMask |= 4194304;
		}

		if (this.buttonType == 6) {
			this.clickMask |= 1;
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1292756714"
	)
	@Export("decode")
	void decode(Buffer var1) {
		var1.readUnsignedByte();
		this.isIf3 = true;
		this.type = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		if (this.type == 9) {
			this.rawHeight = var1.readShort();
		} else {
			this.rawHeight = var1.readUnsignedShort();
		}

		this.widthAlignment = var1.readByte();
		this.heightAlignment = var1.readByte();
		this.xAlignment = var1.readByte();
		this.yAlignment = var1.readByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.isHidden = var1.readUnsignedByte() == 1;
		if (this.type == 0) {
			this.scrollWidth = var1.readUnsignedShort();
			this.scrollHeight = var1.readUnsignedShort();
			this.noClickThrough = var1.readUnsignedByte() == 1;
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteAngle = var1.readUnsignedShort();
			this.spriteTiling = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
			this.outline = var1.readUnsignedByte();
			this.spriteShadow = var1.readInt();
			this.spriteFlipV = var1.readUnsignedByte() == 1;
			this.spriteFlipH = var1.readUnsignedByte() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelOffsetX = var1.readShort();
			this.modelOffsetY = var1.readShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
			this.modelAngleZ = var1.readUnsignedShort();
			this.modelZoom = var1.readUnsignedShort();
			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.modelOrthog = var1.readUnsignedByte() == 1;
			var1.readUnsignedShort();
			if (this.widthAlignment != 0) {
				this.field2622 = var1.readUnsignedShort();
			}

			if (this.heightAlignment != 0) {
				var1.readUnsignedShort();
			}
		}

		if (this.type == 4) {
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.text = var1.readStringCp1252NullTerminated();
			this.textLineHeight = var1.readUnsignedByte();
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textShadowed = var1.readUnsignedByte() == 1;
			this.color = var1.readInt();
		}

		if (this.type == 3) {
			this.color = var1.readInt();
			this.fill = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
		}

		if (this.type == 9) {
			this.lineWid = var1.readUnsignedByte();
			this.color = var1.readInt();
			this.field2601 = var1.readUnsignedByte() == 1;
		}

		this.clickMask = var1.readMedium();
		this.dataText = var1.readStringCp1252NullTerminated();
		int var2 = var1.readUnsignedByte();
		if (var2 > 0) {
			this.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3) {
				this.actions[var3] = var1.readStringCp1252NullTerminated();
			}
		}

		this.dragZoneSize = var1.readUnsignedByte();
		this.dragThreshold = var1.readUnsignedByte();
		this.isScrollBar = var1.readUnsignedByte() == 1;
		this.spellActionName = var1.readStringCp1252NullTerminated();
		this.onLoad = this.readListener(var1);
		this.onMouseOver = this.readListener(var1);
		this.onMouseLeave = this.readListener(var1);
		this.onTargetLeave = this.readListener(var1);
		this.onTargetEnter = this.readListener(var1);
		this.onVarTransmit = this.readListener(var1);
		this.onInvTransmit = this.readListener(var1);
		this.onStatTransmit = this.readListener(var1);
		this.onTimer = this.readListener(var1);
		this.onOp = this.readListener(var1);
		this.onMouseRepeat = this.readListener(var1);
		this.onClick = this.readListener(var1);
		this.onClickRepeat = this.readListener(var1);
		this.onRelease = this.readListener(var1);
		this.onHold = this.readListener(var1);
		this.onDrag = this.readListener(var1);
		this.onDragComplete = this.readListener(var1);
		this.onScroll = this.readListener(var1);
		this.varTransmitTriggers = this.readListenerTriggers(var1);
		this.invTransmitTriggers = this.readListenerTriggers(var1);
		this.statTransmitTriggers = this.readListenerTriggers(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkb;I)[Ljava/lang/Object;",
		garbageValue = "2142536544"
	)
	@Export("readListener")
	Object[] readListener(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				int var5 = var1.readUnsignedByte();
				if (var5 == 0) {
					var3[var4] = new Integer(var1.readInt());
				} else if (var5 == 1) {
					var3[var4] = var1.readStringCp1252NullTerminated();
				}
			}

			this.hasListener = true;
			return var3;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkb;I)[I",
		garbageValue = "-1956943483"
	)
	@Export("readListenerTriggers")
	int[] readListenerTriggers(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				var3[var4] = var1.readInt();
			}

			return var3;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "880946996"
	)
	@Export("swapItems")
	public void swapItems(int var1, int var2) {
		int var3 = this.itemIds[var2];
		this.itemIds[var2] = this.itemIds[var1];
		this.itemIds[var1] = var3;
		var3 = this.itemQuantities[var2];
		this.itemQuantities[var2] = this.itemQuantities[var1];
		this.itemQuantities[var1] = var3;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ZB)Lla;",
		garbageValue = "-39"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2565 = false;
		int var2;
		if (var1) {
			var2 = this.spriteId;
		} else {
			var2 = this.spriteId2;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH ? 1L : 0L) << 39) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipV ? 1L : 0L) << 38);
			Sprite var5 = (Sprite)Widget_cachedSprites.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = MusicPatchNode2.SpriteBuffer_getSprite(Varps.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2565 = true;
					return null;
				} else {
					if (this.spriteFlipV) {
						var5.flipVertically();
					}

					if (this.spriteFlipH) {
						var5.flipHorizontally();
					}

					if (this.outline > 0) {
						var5.pad(this.outline);
					}

					if (this.outline >= 1) {
						var5.outline(1);
					}

					if (this.outline >= 2) {
						var5.outline(16777215);
					}

					if (this.spriteShadow != 0) {
						var5.shadow(this.spriteShadow);
					}

					Widget_cachedSprites.put(var5, var3);
					return var5;
				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Lkx;",
		garbageValue = "-18"
	)
	@Export("getFont")
	public Font getFont() {
		field2565 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				AbstractArchive var3 = Varps.Widget_spritesArchive;
				AbstractArchive var4 = Widget_fontsArchive;
				int var5 = this.fontId;
				Font var2;
				if (!UserComparator7.method3516(var3, var5, 0)) {
					var2 = null;
				} else {
					var2 = VertexNormal.method3094(var4.takeFile(var5, 0));
				}

				if (var2 != null) {
					Widget_cachedFonts.put(var2, (long)this.fontId);
				} else {
					field2565 = true;
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Lla;",
		garbageValue = "14"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2565 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = MusicPatchNode2.SpriteBuffer_getSprite(Varps.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2565 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljc;IZLhk;B)Lel;",
		garbageValue = "73"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2565 = false;
		int var5;
		int var6;
		if (var3) {
			var5 = this.modelType2;
			var6 = this.modelId2;
		} else {
			var5 = this.modelType;
			var6 = this.modelId;
		}

		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			Model var7 = (Model)Widget_cachedModels.get((long)(var6 + (var5 << 16)));
			if (var7 == null) {
				ModelData var8;
				if (var5 == 1) {
					var8 = ModelData.ModelData_get(SoundSystem.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2565 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = class237.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2565 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 3) {
					if (var4 == null) {
						return null;
					}

					var8 = var4.getModelData();
					if (var8 == null) {
						field2565 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = AbstractWorldMapData.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2565 = true;
						return null;
					}

					var7 = var8.toModel(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
				}

				Widget_cachedModels.put(var7, (long)(var6 + (var5 << 16)));
			}

			if (var1 != null) {
				var7 = var1.transformWidgetModel(var7, var2);
			}

			return var7;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ZB)Lhg;",
		garbageValue = "-84"
	)
	@Export("getSpriteMask")
	public SpriteMask getSpriteMask(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId * -1011748949 * -1444834557 : this.spriteId2 * -2111921753 * 66057751;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
			SpriteMask var5 = (SpriteMask)Widget_cachedSpriteMasks.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				Sprite var6 = this.getSprite(var1);
				if (var6 == null) {
					return null;
				} else {
					Sprite var7 = var6.copyNormalized();
					int[] var8 = new int[var7.subHeight];
					int[] var9 = new int[var7.subHeight];

					for (int var10 = 0; var10 < var7.subHeight; ++var10) {
						int var11 = 0;
						int var12 = var7.subWidth;

						int var13;
						for (var13 = 0; var13 < var7.subWidth; ++var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var11 = var13;
								break;
							}
						}

						for (var13 = var7.subWidth - 1; var13 >= var11; --var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var12 = var13 + 1;
								break;
							}
						}

						var8[var10] = var11;
						var9[var10] = var12 - var11;
					}

					var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
					Widget_cachedSpriteMasks.put(var5, var3);
					return var5;
				}
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-207986115"
	)
	@Export("setAction")
	public void setAction(int var1, String var2) {
		if (this.actions == null || this.actions.length <= var1) {
			String[] var3 = new String[var1 + 1];
			if (this.actions != null) {
				for (int var4 = 0; var4 < this.actions.length; ++var4) {
					var3[var4] = this.actions[var4];
				}
			}

			this.actions = var3;
		}

		this.actions[var1] = var2;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1024781244"
	)
	static int method4183(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			Skeleton.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			Interpreter.Interpreter_intStackSize -= 2;
			GrandExchangeOfferWorldComparator.performPlayerAnimation(ByteArrayPool.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1126) {
				Interpreter.field1125 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				var10 = 0;
				if (MusicPatch.isNumber(var3)) {
					var10 = Tiles.parseInt(var3);
				}

				PacketBufferNode var12 = FaceNormal.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var14 = FaceNormal.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var14 = FaceNormal.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						class39.method646(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						Interpreter.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						Widget var13 = MusicPatchNode.getWidget(var9);
						Player.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						Interpreter.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
						Player.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						class217.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						WorldMapArea.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						Script.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var14 = FaceNormal.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = FaceNormal.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + class234.stringCp1252NullTerminatedByteSize(var7) + class234.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.method5727(var15);
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						class2.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class51.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						Interpreter.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapLabel.canvasWidth;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field842 = 3;
						Client.field843 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field842 = 2;
						Client.field843 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field842 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field842 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field842 = 3;
						Client.field843 = var2 ? GrandExchangeOfferNameComparator.field115.id * -1381479581 * -957641141 : Interpreter.field1130.id * -1381479581 * -957641141;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername = var8;
							WorldMapArea.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = "";
								WorldMapArea.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (var8 == GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled) {
								GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled = !var8;
								WorldMapArea.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferWorldComparator.method147();
							return 1;
						} else if (var0 == 3155) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							Interpreter.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--Interpreter.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}
}
