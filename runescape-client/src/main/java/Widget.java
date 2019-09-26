import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("Widget_cachedSprites")
	public static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("Widget_cachedModels")
	public static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("Widget_cachedFonts")
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("t")
	public static boolean field2543;
	@ObfuscatedName("g")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -938462923
	)
	@Export("id")
	public int id;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 970038855
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1047333541
	)
	@Export("type")
	public int type;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -356920675
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -645037763
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -785941721
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2044954067
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1296359215
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 998396021
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1791986137
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1824790061
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1720123363
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 450063905
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 654358485
	)
	@Export("x")
	public int x;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -2047854973
	)
	@Export("y")
	public int y;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -1115212787
	)
	@Export("width")
	public int width;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 185246961
	)
	@Export("height")
	public int height;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 2031946853
	)
	public int field2655;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 540658479
	)
	public int field2629;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1499631501
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("an")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1553708193
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1983133743
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 993795721
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 319178445
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1588056221
	)
	@Export("color")
	public int color;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1094977017
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1010030427
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -214954083
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("aj")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1182281851
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1279506063
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 1520637795
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bx")
	public boolean field2579;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -660582185
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -842194727
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 1539845703
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bv")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -908982873
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 235051931
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bz")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bc")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -917602037
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 352337217
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1558533019
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1849612505
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -1921357951
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -803672091
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -617034503
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 263647227
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -899088195
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 744470751
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1532699993
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = -1859343581
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -516131825
	)
	public int field2667;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 820815763
	)
	public int field2601;
	@ObfuscatedName("bg")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bw")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1908099759
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 8724653
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("ck")
	@Export("text")
	public String text;
	@ObfuscatedName("cv")
	@Export("text2")
	public String text2;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -1471970549
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 275090821
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -2027130901
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cn")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 488082575
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = 1814601209
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cj")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cb")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cr")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("ct")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -349261461
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cu")
	public boolean field2619;
	@ObfuscatedName("ce")
	public byte[][] field2552;
	@ObfuscatedName("cc")
	public byte[][] field2621;
	@ObfuscatedName("ca")
	public int[] field2586;
	@ObfuscatedName("cf")
	public int[] field2548;
	@ObfuscatedName("dt")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dv")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dn")
	@ObfuscatedGetter(
		intValue = 613508017
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dq")
	@ObfuscatedGetter(
		intValue = -1263499789
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dy")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("de")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("df")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("dr")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("du")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("ds")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dc")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("di")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dk")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("dx")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dz")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("do")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dw")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dd")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("dj")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("dg")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("da")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dl")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("dh")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("db")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dp")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("ek")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ef")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ew")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ex")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("eq")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("er")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("eo")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("ee")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("ep")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ei")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("es")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("eg")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ej")
	public Object[] field2662;
	@ObfuscatedName("en")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("eh")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("em")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("ev")
	@ObfuscatedGetter(
		intValue = 1603621761
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("ez")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("ec")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("eu")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ed")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = -1532577883
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 878258425
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("ea")
	@ObfuscatedGetter(
		intValue = 758841865
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("et")
	@ObfuscatedGetter(
		intValue = 2093634115
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "[Lho;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fb")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fe")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = 1204314605
	)
	public int field2558;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = -162526605
	)
	public int field2620;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = 976944717
	)
	public int field2680;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = 1042446467
	)
	public int field2681;
	@ObfuscatedName("fk")
	@ObfuscatedGetter(
		intValue = -27098335
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fq")
	@ObfuscatedGetter(
		intValue = -433990399
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fc")
	public int[] field2684;
	@ObfuscatedName("fv")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fm")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fh")
	public boolean field2687;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2543 = false;
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
		this.field2655 = 1;
		this.field2629 = 1;
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
		this.field2579 = false;
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
		this.field2667 = 0;
		this.field2601 = 0;
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
		this.field2619 = false;
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
		this.field2558 = -1;
		this.field2620 = 0;
		this.field2680 = 0;
		this.field2681 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2687 = false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkl;S)V",
		garbageValue = "15127"
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
		signature = "(Lkl;I)V",
		garbageValue = "-508997564"
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
				this.field2667 = var1.readUnsignedShort();
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
			this.field2579 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkl;B)[Ljava/lang/Object;",
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkl;I)[I",
		garbageValue = "-132337395"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1452278640"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ZB)Llf;",
		garbageValue = "13"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2543 = false;
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
				var5 = NPCDefinition.SpriteBuffer_getSprite(ClientPreferences.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2543 = true;
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Lkn;",
		garbageValue = "2078221283"
	)
	@Export("getFont")
	public Font getFont() {
		field2543 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = ClanMate.method4964(ClientPreferences.Widget_spritesArchive, class2.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2543 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)Llf;",
		garbageValue = "378738987"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2543 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = NPCDefinition.SpriteBuffer_getSprite(ClientPreferences.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2543 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lix;IZLhr;I)Ldh;",
		garbageValue = "312121808"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2543 = false;
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
					var8 = ModelData.ModelData_get(TaskHandler.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2543 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = PacketBufferNode.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2543 = true;
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
						field2543 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = Occluder.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2543 = true;
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ZB)Lhz;",
		garbageValue = "0"
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
			long var3 = ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;S)V",
		garbageValue = "-24772"
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
}
