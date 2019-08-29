import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[[Lhp;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("g")
	public static boolean field2579;
	@ObfuscatedName("e")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1708719923
	)
	@Export("id")
	public int id;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 467661249
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1925555435
	)
	@Export("type")
	public int type;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -275504647
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 939098119
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -672675163
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2007868025
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 341778039
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1959652011
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 2096231869
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1182032235
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 2138399125
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1680813471
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1019695869
	)
	@Export("x")
	public int x;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1173334909
	)
	@Export("y")
	public int y;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -330046731
	)
	@Export("width")
	public int width;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -1817487801
	)
	@Export("height")
	public int height;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -959032847
	)
	public int field2538;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -275378447
	)
	public int field2612;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1923401589
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("ar")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1482452977
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -2016289711
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 260494285
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -2146218681
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -510289111
	)
	@Export("color")
	public int color;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 69172767
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1460620473
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1672372405
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("al")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1495392275
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1571027933
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1813251577
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bk")
	public boolean field2601;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1520736473
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1571387993
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -332735913
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bp")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1938856491
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 854730489
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bv")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bj")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 20966337
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1167866435
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 1287087547
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1636240977
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1464893801
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 102645467
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1360150457
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -453431795
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 787059755
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -1741571787
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 1967716375
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 1984472705
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -1968433305
	)
	public int field2638;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1213259299
	)
	public int field2602;
	@ObfuscatedName("bg")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("be")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1215332137
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 1192242139
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("ci")
	@Export("text")
	public String text;
	@ObfuscatedName("ck")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1510391685
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = -1557971945
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -1274290249
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cw")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -705081305
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 1539639069
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cu")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cm")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cb")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("ch")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -518716407
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cr")
	public boolean field2620;
	@ObfuscatedName("cl")
	public byte[][] field2631;
	@ObfuscatedName("cg")
	public byte[][] field2622;
	@ObfuscatedName("cq")
	public int[] field2623;
	@ObfuscatedName("ct")
	public int[] field2581;
	@ObfuscatedName("dr")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dd")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("da")
	@ObfuscatedGetter(
		intValue = -288578645
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dh")
	@ObfuscatedGetter(
		intValue = 340622083
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dm")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dj")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dc")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("db")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("dx")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("dp")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dz")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("dw")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dn")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("ds")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dt")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("du")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dq")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dg")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("dy")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("dk")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("di")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("de")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("do")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("df")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dl")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("eo")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ef")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ex")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ea")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("em")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("en")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("ey")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("ei")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("ee")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("eh")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("eq")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("ec")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ej")
	public Object[] field2663;
	@ObfuscatedName("eg")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("er")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("ep")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("ek")
	@ObfuscatedGetter(
		intValue = 43324545
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("et")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("ed")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("es")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ez")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = 516422107
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = -46773205
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 311105125
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = -1489750537
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("ev")
	@ObfuscatedSignature(
		signature = "[Lhp;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fz")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fd")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = -1141206537
	)
	public int field2679;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = -1086259501
	)
	public int field2680;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = -1915688435
	)
	public int field2681;
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		intValue = -1456076353
	)
	public int field2591;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		intValue = 1549084931
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = -139544989
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fg")
	public int[] field2685;
	@ObfuscatedName("ft")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fu")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fh")
	public boolean field2688;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2579 = false;
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
		this.field2538 = 1;
		this.field2612 = 1;
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
		this.fillMode = FillMode.SOLID;
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
		this.field2638 = 0;
		this.field2602 = 0;
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
		this.field2620 = false;
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
		this.field2679 = -1;
		this.field2680 = 0;
		this.field2681 = 0;
		this.field2591 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2688 = false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-1799471265"
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
			this.itemQuantities = new int[this.rawWidth * this.rawHeight];
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
				String var10 = var1.readStringCp1252NullTerminated();
				if (var10.length() > 0) {
					this.itemActions[var8] = var10;
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
			this.itemIds = new int[this.rawWidth * this.rawHeight];
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
				String var11 = var1.readStringCp1252NullTerminated();
				if (var11.length() > 0) {
					this.itemActions[var5] = var11;
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "-52"
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
				this.field2638 = var1.readUnsignedShort();
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lky;B)[Ljava/lang/Object;",
		garbageValue = "0"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lky;I)[I",
		garbageValue = "1234207038"
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-311647147"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ZI)Lls;",
		garbageValue = "1931893864"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2579 = false;
		int var2;
		if (var1) {
			var2 = this.spriteId;
		} else {
			var2 = this.spriteId2;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((long)this.spriteShadow << 40);
			Sprite var5 = (Sprite)Widget_cachedSprites.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = TilePaint.SpriteBuffer_getSprite(WorldMapSprite.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2579 = true;
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Lkb;",
		garbageValue = "114"
	)
	@Export("getFont")
	public Font getFont() {
		field2579 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FileSystem.SpriteBuffer_getFont(WorldMapSprite.Widget_spritesArchive, Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2579 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)Lls;",
		garbageValue = "1971687026"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2579 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = TilePaint.SpriteBuffer_getSprite(WorldMapSprite.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2579 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lij;IZLhy;I)Ldo;",
		garbageValue = "1039139865"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2579 = false;
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
					var8 = ModelData.ModelData_get(Huffman.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2579 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = ViewportMouse.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2579 = true;
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
						field2579 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = WorldMapData_0.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2579 = true;
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ZB)Lhg;",
		garbageValue = "-6"
	)
	@Export("getSpriteMask")
	public SpriteMask getSpriteMask(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId : this.spriteId2;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipH ? 1L : 0L) << 39);
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "425838029"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Lij;",
		garbageValue = "981086484"
	)
	@Export("SequenceDefinition_get")
	public static SequenceDefinition SequenceDefinition_get(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
