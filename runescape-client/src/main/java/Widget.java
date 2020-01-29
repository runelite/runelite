import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("k")
	public static boolean field2697;
	@ObfuscatedName("q")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 966798893
	)
	@Export("id")
	public int id;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -637939151
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1589308129
	)
	@Export("type")
	public int type;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -480153267
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1797201679
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 488943743
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 77257793
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1510245031
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1453424457
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -817220413
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1957231607
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 298003119
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -270154123
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 2093770327
	)
	@Export("x")
	public int x;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -227555657
	)
	@Export("y")
	public int y;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1253665371
	)
	@Export("width")
	public int width;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -476310133
	)
	@Export("height")
	public int height;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -605973757
	)
	public int field2589;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 955244305
	)
	public int field2590;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1653380789
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("aw")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 536473649
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -612088835
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 559224257
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -193403105
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1950193909
	)
	@Export("color")
	public int color;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -518404755
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 277012843
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 699027547
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ag")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -2036464857
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1652123329
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -74460937
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bq")
	public boolean field2606;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1818205057
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1993820815
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 2121453977
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bb")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 254544941
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -360859493
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bl")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("by")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 1914949917
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1077227953
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -1140271877
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 2003629181
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -240596143
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1235474681
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -940655057
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1529824909
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 2062525789
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1899528959
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -844495371
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -950068119
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 291649371
	)
	public int field2627;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -233029925
	)
	public int field2696;
	@ObfuscatedName("bv")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bo")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = -55381355
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 364892773
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cg")
	@Export("text")
	public String text;
	@ObfuscatedName("cr")
	@Export("text2")
	public String text2;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 252801441
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 17386837
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1637258997
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cd")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 1431326299
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -174543693
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cf")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cm")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cz")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("cu")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = 1317072949
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("ce")
	public boolean field2646;
	@ObfuscatedName("cw")
	public byte[][] field2702;
	@ObfuscatedName("cq")
	public byte[][] field2648;
	@ObfuscatedName("ch")
	public int[] field2649;
	@ObfuscatedName("cx")
	public int[] field2560;
	@ObfuscatedName("dm")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dw")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dl")
	@ObfuscatedGetter(
		intValue = 185265687
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dv")
	@ObfuscatedGetter(
		intValue = -1309236317
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("do")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("di")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dc")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("dj")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("de")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("df")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dn")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("dy")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dq")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("dd")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dr")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("dk")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dg")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dt")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("du")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("db")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dh")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dz")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("dx")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("da")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dp")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("ey")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ee")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ec")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("em")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("el")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("eq")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("eu")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("et")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("es")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ep")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("er")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("en")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ea")
	public Object[] field2674;
	@ObfuscatedName("ei")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("eg")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("eh")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("ev")
	@ObfuscatedGetter(
		intValue = -855026753
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("eb")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("ef")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("ek")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ej")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("ez")
	@ObfuscatedGetter(
		intValue = 145382301
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("eo")
	@ObfuscatedGetter(
		intValue = -833257617
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = 835608255
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = -925535589
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "[Lhn;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fl")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fp")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = -1014136325
	)
	public int field2705;
	@ObfuscatedName("fs")
	@ObfuscatedGetter(
		intValue = 2094586807
	)
	public int field2706;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = -1366369507
	)
	public int field2570;
	@ObfuscatedName("fh")
	@ObfuscatedGetter(
		intValue = -668838765
	)
	public int field2708;
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = 604114463
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = -1831666503
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fj")
	public int[] field2711;
	@ObfuscatedName("fw")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("ff")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fm")
	public boolean field2713;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2697 = false;
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
		this.field2589 = 1;
		this.field2590 = 1;
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
		this.field2606 = false;
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
		this.field2627 = 0;
		this.field2696 = 0;
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
		this.field2646 = false;
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
		this.field2705 = -1;
		this.field2706 = 0;
		this.field2570 = 0;
		this.field2708 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2713 = false;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-1287824768"
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
			this.itemIds = new int[this.rawHeight * this.rawWidth];
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
			this.itemIds = new int[this.rawWidth * this.rawHeight];
			this.itemQuantities = new int[this.rawHeight * this.rawWidth];
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "2093742106"
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
				this.field2627 = var1.readUnsignedShort();
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
			this.field2606 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkp;I)[Ljava/lang/Object;",
		garbageValue = "2009798278"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lkp;I)[I",
		garbageValue = "1361123043"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-16"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ZB)Llt;",
		garbageValue = "50"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2697 = false;
		int var2;
		if (var1) {
			var2 = this.spriteId;
		} else {
			var2 = this.spriteId2;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((long)this.spriteShadow << 40);
			Sprite var5 = (Sprite)Widget_cachedSprites.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = WorldMapSection1.SpriteBuffer_getSprite(Username.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2697 = true;
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Lko;",
		garbageValue = "-700257512"
	)
	@Export("getFont")
	public Font getFont() {
		field2697 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FaceNormal.method3335(Username.Widget_spritesArchive, class162.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2697 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Llt;",
		garbageValue = "610412077"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2697 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = WorldMapSection1.SpriteBuffer_getSprite(Username.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2697 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lip;IZLhp;I)Ldx;",
		garbageValue = "-1566575380"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2697 = false;
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
					var8 = ModelData.ModelData_get(Calendar.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2697 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = NetCache.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2697 = true;
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
						field2697 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = HealthBarDefinition.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2697 = true;
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ZI)Lhf;",
		garbageValue = "-1393385488"
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
			long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipV ? 1L : 0L) << 38);
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "121"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-855485303"
	)
	public static int method4119(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}
}
