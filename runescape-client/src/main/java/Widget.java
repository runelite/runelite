import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("Widget_cachedSprites")
	public static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("Widget_cachedModels")
	public static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("Widget_cachedFonts")
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("i")
	public static boolean field2668;
	@ObfuscatedName("q")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1907672421
	)
	@Export("id")
	public int id;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1945226707
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -772276819
	)
	@Export("type")
	public int type;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 328267473
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -454562685
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 895820023
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1916882485
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 2100474417
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1973607169
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 1858248381
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 240913587
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 861849893
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -2044035335
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -761589597
	)
	@Export("x")
	public int x;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 319484797
	)
	@Export("y")
	public int y;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1718038251
	)
	@Export("width")
	public int width;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -674853749
	)
	@Export("height")
	public int height;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1080920081
	)
	public int field2632;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -907952667
	)
	public int field2556;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1035091827
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("af")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 104714479
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 170496061
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -830534739
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1176297831
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 949515665
	)
	@Export("color")
	public int color;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 921596793
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -2025808895
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -195673481
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("az")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1731186671
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1268087391
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -2139231195
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bg")
	public boolean field2675;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 934417717
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 851339945
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1927880711
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bu")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -339926563
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -300201401
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bf")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bm")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 37345555
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -679429735
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -1068399227
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1060754229
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1598461627
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 903177661
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 968200291
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1396301049
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 2074763115
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -741034463
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1685270553
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1323312973
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -2064112683
	)
	public int field2582;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 2124528455
	)
	public int field2594;
	@ObfuscatedName("br")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bx")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 1270925291
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 1153372709
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("ct")
	@Export("text")
	public String text;
	@ObfuscatedName("ch")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1787043177
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 1569630349
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -324536737
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cl")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -1161115165
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 1095310931
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cm")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("ce")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cn")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("cj")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 1071371379
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cu")
	public boolean field2612;
	@ObfuscatedName("cd")
	public byte[][] field2671;
	@ObfuscatedName("cs")
	public byte[][] field2614;
	@ObfuscatedName("cq")
	public int[] field2615;
	@ObfuscatedName("co")
	public int[] field2616;
	@ObfuscatedName("dj")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dh")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = -429080415
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dy")
	@ObfuscatedGetter(
		intValue = -1509482099
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dd")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dp")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dn")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("de")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("da")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("dl")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dg")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("dz")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dw")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("di")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dt")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("dc")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("ds")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dv")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("db")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("du")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dx")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dq")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("dr")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("dk")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("df")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("ej")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ec")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("en")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ep")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("eo")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("el")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("ea")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("em")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("ev")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("eg")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("ek")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("es")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ef")
	public Object[] field2655;
	@ObfuscatedName("ed")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("eq")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("et")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = 2026797669
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("ei")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("ey")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("ez")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ee")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 1832105135
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("eh")
	@ObfuscatedGetter(
		intValue = 79160241
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = -511310017
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = 1679664873
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		signature = "[Lhy;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("ft")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("ff")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fh")
	@ObfuscatedGetter(
		intValue = 2080687433
	)
	public int field2529;
	@ObfuscatedName("fm")
	@ObfuscatedGetter(
		intValue = 1067729441
	)
	public int field2672;
	@ObfuscatedName("fr")
	@ObfuscatedGetter(
		intValue = -1462037203
	)
	public int field2673;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = -884787153
	)
	public int field2674;
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = -1645890297
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = 1918887051
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fs")
	public int[] field2656;
	@ObfuscatedName("fc")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fq")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fy")
	public boolean field2680;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2668 = false;
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
		this.field2632 = 1;
		this.field2556 = 1;
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
		this.field2675 = false;
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
		this.field2582 = 0;
		this.field2594 = 0;
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
		this.field2612 = false;
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
		this.field2529 = -1;
		this.field2672 = 0;
		this.field2673 = 0;
		this.field2674 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2680 = false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;B)V",
		garbageValue = "2"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1464139968"
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
				this.field2582 = var1.readUnsignedShort();
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
			this.field2675 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkz;I)[Ljava/lang/Object;",
		garbageValue = "1663050003"
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkz;B)[I",
		garbageValue = "-96"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1566748217"
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
		signature = "(ZI)Lli;",
		garbageValue = "29959208"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2668 = false;
		int var2;
		if (var1) {
			var2 = this.spriteId;
		} else {
			var2 = this.spriteId2;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipH ? 1L : 0L) << 39);
			Sprite var5 = (Sprite)Widget_cachedSprites.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = FillMode.SpriteBuffer_getSprite(HealthBar.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2668 = true;
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
		signature = "(I)Lkf;",
		garbageValue = "-925854975"
	)
	@Export("getFont")
	public Font getFont() {
		field2668 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				AbstractArchive var3 = HealthBar.Widget_spritesArchive;
				AbstractArchive var4 = WorldMapSprite.Widget_fontsArchive;
				int var5 = this.fontId;
				byte[] var7 = var3.takeFile(var5, 0);
				boolean var6;
				if (var7 == null) {
					var6 = false;
				} else {
					GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var7);
					var6 = true;
				}

				Font var2;
				if (!var6) {
					var2 = null;
				} else {
					byte[] var8 = var4.takeFile(var5, 0);
					Font var10;
					if (var8 == null) {
						var10 = null;
					} else {
						Font var9 = new Font(var8, class325.SpriteBuffer_xOffsets, SecureRandomCallable.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, SoundSystem.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, InvDefinition.SpriteBuffer_pixels);
						class192.SpriteBuffer_clear();
						var10 = var9;
					}

					var2 = var10;
				}

				if (var2 != null) {
					Widget_cachedFonts.put(var2, (long)this.fontId);
				} else {
					field2668 = true;
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Lli;",
		garbageValue = "-1753653810"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2668 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = FillMode.SpriteBuffer_getSprite(HealthBar.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2668 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Liw;IZLhl;I)Ldr;",
		garbageValue = "927690576"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2668 = false;
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
					var8 = ModelData.ModelData_get(class293.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2668 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = FontName.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2668 = true;
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
						field2668 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = Player.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2668 = true;
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ZI)Lhi;",
		garbageValue = "-689140907"
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
			long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((long)this.spriteShadow << 40);
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1185181318"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-847806020"
	)
	static void method4074() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				class51.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				class51.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}
}
