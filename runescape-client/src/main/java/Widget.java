import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("x")
	@Export("Widget_loadedInterfaces")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_modelsArchive")
	static AbstractArchive Widget_modelsArchive;
	@ObfuscatedName("v")
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
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedFonts")
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("t")
	public static boolean field2549;
	@ObfuscatedName("j")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1299476265
	)
	@Export("id")
	public int id;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -433623057
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 169687735
	)
	@Export("type")
	public int type;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1927968519
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -300120459
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 526386257
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -881640361
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1294049187
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 282021115
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1359404571
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 426334007
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 477325163
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -365864037
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -2146904513
	)
	@Export("x")
	public int x;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -787900839
	)
	@Export("y")
	public int y;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 372029795
	)
	@Export("width")
	public int width;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1882269787
	)
	@Export("height")
	public int height;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1726055513
	)
	public int field2617;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 227763001
	)
	public int field2569;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -782776051
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("ay")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1944956525
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -405454075
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1082844581
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 557803519
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1855119185
	)
	@Export("color")
	public int color;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1166086105
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1149435031
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1092901165
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("af")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -808988025
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -2007030025
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 567629033
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bj")
	public boolean field2676;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 161600005
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 754156307
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 515570621
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bl")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -469270917
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 150600095
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bc")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("by")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -807433521
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -1129211799
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1125389583
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -392341679
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 309774183
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 942088921
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -85793983
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 41223313
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -1935540911
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 1626422203
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1986701179
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -2039159593
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 558694563
	)
	public int field2645;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1622987205
	)
	public int field2607;
	@ObfuscatedName("br")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bt")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1456776345
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -600879771
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cp")
	@Export("text")
	public String text;
	@ObfuscatedName("cd")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -1209305235
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -188667201
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -116044435
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("cf")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -573415153
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 1908229703
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("ca")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cn")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cx")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("ck")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -1025051947
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("cu")
	public boolean field2625;
	@ObfuscatedName("cg")
	public byte[][] field2626;
	@ObfuscatedName("ct")
	public byte[][] field2629;
	@ObfuscatedName("cm")
	public int[] field2631;
	@ObfuscatedName("cl")
	public int[] field2670;
	@ObfuscatedName("do")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("dk")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("de")
	@ObfuscatedGetter(
		intValue = 1517424383
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("df")
	@ObfuscatedGetter(
		intValue = -1198293361
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("di")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dr")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("dg")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("dh")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("dl")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("da")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dp")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("ds")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("db")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("dn")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("dt")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("dc")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dd")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("dv")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("du")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("dq")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dj")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dy")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("dw")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("dz")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dm")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("et")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ef")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ek")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ej")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("ew")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("ep")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("er")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("es")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("eq")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ev")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("en")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("ee")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("el")
	public Object[] field2562;
	@ObfuscatedName("eo")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("ex")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("ei")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -131581019
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("ec")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("eh")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("eu")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ea")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("ez")
	@ObfuscatedGetter(
		intValue = 1299822723
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("ed")
	@ObfuscatedGetter(
		intValue = 1473504869
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = 1336103723
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = 699084427
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "[Lha;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fd")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("ff")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = -871911491
	)
	public int field2583;
	@ObfuscatedName("fk")
	@ObfuscatedGetter(
		intValue = 629520423
	)
	public int field2685;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		intValue = 1203722621
	)
	public int field2686;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = -1940308273
	)
	public int field2687;
	@ObfuscatedName("fq")
	@ObfuscatedGetter(
		intValue = 1802978635
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = 1843642963
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fy")
	public int[] field2655;
	@ObfuscatedName("fu")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fl")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fr")
	public boolean field2602;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2549 = false;
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
		this.field2617 = 1;
		this.field2569 = 1;
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
		this.field2676 = false;
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
		this.field2645 = 0;
		this.field2607 = 0;
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
		this.field2625 = false;
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
		this.field2583 = -1;
		this.field2685 = 0;
		this.field2686 = 0;
		this.field2687 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2602 = false;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-1975844484"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "-13"
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
				this.field2645 = var1.readUnsignedShort();
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
			this.field2676 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkq;B)[Ljava/lang/Object;",
		garbageValue = "19"
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lkq;I)[I",
		garbageValue = "-417686868"
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
		garbageValue = "1303509958"
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
		signature = "(ZB)Lls;",
		garbageValue = "-9"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2549 = false;
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
				var5 = FloorUnderlayDefinition.SpriteBuffer_getSprite(BoundaryObject.Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2549 = true;
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Lko;",
		garbageValue = "-2105081267"
	)
	@Export("getFont")
	public Font getFont() {
		field2549 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class14.method160(BoundaryObject.Widget_spritesArchive, MilliClock.Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2549 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Lls;",
		garbageValue = "517596117"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2549 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = FloorUnderlayDefinition.SpriteBuffer_getSprite(BoundaryObject.Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2549 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Liv;IZLhh;I)Ldw;",
		garbageValue = "-3726019"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2549 = false;
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
					var8 = ModelData.ModelData_get(Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2549 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = AbstractUserComparator.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2549 = true;
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
						field2549 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = PacketBufferNode.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2549 = true;
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ZB)Lhy;",
		garbageValue = "127"
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
			long var3 = ((long)this.spriteShadow << 40) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipV ? 1L : 0L) << 38) + ((this.spriteFlipH ? 1L : 0L) << 39);
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1803915534"
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
