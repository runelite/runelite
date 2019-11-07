import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[[Lhi;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedSprites")
	public static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedModels")
	public static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedFonts")
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("r")
	public static boolean field2546;
	@ObfuscatedName("e")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -280672731
	)
	@Export("id")
	public int id;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1645861549
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2128964865
	)
	@Export("type")
	public int type;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1250480087
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1066235227
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1730159061
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1386350927
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -439179557
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1461401323
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1233899185
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -890893837
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1159275423
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1892483003
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 48491411
	)
	@Export("x")
	public int x;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1737418803
	)
	@Export("y")
	public int y;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -369065525
	)
	@Export("width")
	public int width;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -977437037
	)
	@Export("height")
	public int height;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -146103693
	)
	public int field2565;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -1709587935
	)
	public int field2566;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -952068239
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("ap")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -1718942179
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -951483361
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1463139927
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -957272581
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1271206161
	)
	@Export("color")
	public int color;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1941262011
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 514588633
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 2103331161
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ao")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 980252295
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 86266387
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -698709205
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("ba")
	public boolean field2641;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 984904481
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 2067815265
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 656330525
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bx")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1324246855
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 1573371851
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bu")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("br")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -593024897
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -114763821
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1742375397
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 211034615
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -802962767
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1552321185
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 932822481
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 869171029
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -326232143
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 445360869
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 1367930315
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -1834112819
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -456160553
	)
	public int field2577;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -617398221
	)
	public int field2604;
	@ObfuscatedName("bf")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("by")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 864768915
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -1260051363
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cv")
	@Export("text")
	public String text;
	@ObfuscatedName("ce")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -437750021
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1459879157
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -1045469939
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cr")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 305602759
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -782099123
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cl")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("co")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cu")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("cz")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 1435074299
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cj")
	public boolean field2606;
	@ObfuscatedName("cm")
	public byte[][] field2623;
	@ObfuscatedName("cb")
	public byte[][] field2624;
	@ObfuscatedName("ct")
	public int[] field2628;
	@ObfuscatedName("cc")
	public int[] field2626;
	@ObfuscatedName("db")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dq")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dl")
	@ObfuscatedGetter(
		intValue = 1506915571
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = 1786356727
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("di")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dn")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dr")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("do")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("ds")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("dz")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dj")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("df")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("da")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("dg")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dp")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("dy")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("du")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dk")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("dx")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("dt")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dw")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dh")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("dv")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("dc")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("de")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("eu")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("eg")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ee")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ek")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("ef")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("ep")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("et")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("eq")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("em")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ew")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("eh")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("ei")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("ex")
	public Object[] field2665;
	@ObfuscatedName("ev")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("er")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("eb")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = -2064419495
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("en")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("eo")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("ed")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ea")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("ec")
	@ObfuscatedGetter(
		intValue = 1669892041
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = 953415941
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("ez")
	@ObfuscatedGetter(
		intValue = 1038717705
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("ej")
	@ObfuscatedGetter(
		intValue = -1473974595
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "[Lhi;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("ft")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fe")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fs")
	@ObfuscatedGetter(
		intValue = 364825415
	)
	public int field2681;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = -249487125
	)
	public int field2644;
	@ObfuscatedName("fp")
	@ObfuscatedGetter(
		intValue = -1173942703
	)
	public int field2567;
	@ObfuscatedName("fu")
	@ObfuscatedGetter(
		intValue = -309907897
	)
	public int field2684;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = -1761314171
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = 31407323
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fg")
	public int[] field2627;
	@ObfuscatedName("fw")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("ff")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fh")
	public boolean field2690;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2546 = false;
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
		this.field2565 = 1;
		this.field2566 = 1;
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
		this.field2641 = false;
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
		this.field2577 = 0;
		this.field2604 = 0;
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
		this.field2606 = false;
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
		this.field2681 = -1;
		this.field2644 = 0;
		this.field2567 = 0;
		this.field2684 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2690 = false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "1429632695"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "2011634679"
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
				this.field2577 = var1.readUnsignedShort();
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
			this.field2641 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkc;I)[Ljava/lang/Object;",
		garbageValue = "2071602540"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkc;I)[I",
		garbageValue = "-1637703224"
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
		garbageValue = "998252428"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ZB)Llx;",
		garbageValue = "125"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2546 = false;
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
				var5 = MenuAction.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2546 = true;
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
		signature = "(B)Lks;",
		garbageValue = "21"
	)
	@Export("getFont")
	public Font getFont() {
		field2546 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class269.method5114(Widget_spritesArchive, Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2546 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(II)Llx;",
		garbageValue = "1720917117"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2546 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = MenuAction.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2546 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Liv;IZLhe;I)Ldv;",
		garbageValue = "-1533310000"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2546 = false;
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
					var8 = ModelData.ModelData_get(StructDefinition.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2546 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = SecureRandomCallable.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2546 = true;
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
						field2546 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = class222.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2546 = true;
						return null;
					}

					var7 = var8.toModel(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
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
		signature = "(ZI)Lhn;",
		garbageValue = "1756032034"
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
			long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.spriteShadow << 40);
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1842763844"
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
