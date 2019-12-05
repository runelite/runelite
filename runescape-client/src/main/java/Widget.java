import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("y")
	@Export("Widget_loadedInterfaces")
	public static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("Widget_spritesArchive")
	public static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("Widget_fontsArchive")
	public static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Widget_cachedSprites")
	static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Widget_cachedModels")
	static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Widget_cachedFonts")
	static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Widget_cachedSpriteMasks")
	static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("c")
	public static boolean field2647;
	@ObfuscatedName("a")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1682461819
	)
	@Export("id")
	public int id;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 304580101
	)
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1464178541
	)
	@Export("type")
	public int type;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1207146159
	)
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -436688561
	)
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 797702061
	)
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1839904363
	)
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 932537707
	)
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -861293309
	)
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1387465487
	)
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 69728839
	)
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1496687489
	)
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1477852971
	)
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1601823443
	)
	@Export("x")
	public int x;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -543253817
	)
	@Export("y")
	public int y;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 201590315
	)
	@Export("width")
	public int width;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1083073471
	)
	@Export("height")
	public int height;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1082009517
	)
	public int field2594;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 701840215
	)
	public int field2694;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -603142629
	)
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("aq")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 559295079
	)
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1519015545
	)
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 1743610313
	)
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -768640271
	)
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 875298849
	)
	@Export("color")
	public int color;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1946590123
	)
	@Export("color2")
	public int color2;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1868971829
	)
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1913787705
	)
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("ay")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "Llz;"
	)
	@Export("fillMode")
	public FillMode fillMode;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -944834953
	)
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 565283995
	)
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1175693173
	)
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("bi")
	public boolean field2709;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -3923559
	)
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -1169722885
	)
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 1021847911
	)
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("bd")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 433329709
	)
	@Export("outline")
	public int outline;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1127682419
	)
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("bm")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("bq")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1709757885
	)
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1705471533
	)
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 178630707
	)
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1939746225
	)
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 29524191
	)
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -540899077
	)
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -1645734867
	)
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1267088937
	)
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 1658631801
	)
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 922344031
	)
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -1525531675
	)
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -1852880265
	)
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -268605009
	)
	public int field2711;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -751685799
	)
	public int field2633;
	@ObfuscatedName("bc")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("bh")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -137614795
	)
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -1844014927
	)
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("cd")
	@Export("text")
	public String text;
	@ObfuscatedName("cv")
	@Export("text2")
	public String text2;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -1989359281
	)
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = 19289147
	)
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = -1956461255
	)
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("co")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 604950213
	)
	@Export("paddingX")
	public int paddingX;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 2056205059
	)
	@Export("paddingY")
	public int paddingY;
	@ObfuscatedName("cb")
	@Export("inventoryXOffsets")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cy")
	@Export("inventoryYOffsets")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cn")
	@Export("inventorySprites")
	public int[] inventorySprites;
	@ObfuscatedName("cj")
	@Export("itemActions")
	public String[] itemActions;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -748818631
	)
	@Export("clickMask")
	public int clickMask;
	@ObfuscatedName("ci")
	public boolean field2651;
	@ObfuscatedName("cu")
	public byte[][] field2592;
	@ObfuscatedName("cs")
	public byte[][] field2653;
	@ObfuscatedName("ca")
	public int[] field2654;
	@ObfuscatedName("cf")
	public int[] field2655;
	@ObfuscatedName("dw")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("de")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("dc")
	@ObfuscatedGetter(
		intValue = 1585908023
	)
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("dk")
	@ObfuscatedGetter(
		intValue = -608176245
	)
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("dj")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("dp")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("di")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("dn")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("ds")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("dh")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("dt")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("dz")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("dr")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("dl")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("db")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("da")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("dq")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("do")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("du")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("dv")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("dg")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dm")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("df")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("dd")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("dy")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("eg")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("ey")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("ec")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("el")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("em")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("ee")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("eu")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("ea")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("er")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("ek")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("ej")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("et")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("eh")
	public Object[] field2689;
	@ObfuscatedName("ew")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("ez")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("ef")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = -453666205
	)
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("ep")
	@Export("spellName")
	public String spellName;
	@ObfuscatedName("ev")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("eo")
	@Export("itemIds")
	public int[] itemIds;
	@ObfuscatedName("ei")
	@Export("itemQuantities")
	public int[] itemQuantities;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -741280037
	)
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = -1517426203
	)
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = 41842763
	)
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("ed")
	@ObfuscatedGetter(
		intValue = -1337602571
	)
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		signature = "[Lhl;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("fe")
	@Export("containsMouse")
	public boolean containsMouse;
	@ObfuscatedName("fl")
	@Export("isClicked")
	public boolean isClicked;
	@ObfuscatedName("fj")
	@ObfuscatedGetter(
		intValue = 1602512459
	)
	public int field2631;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		intValue = 2143092137
	)
	public int field2652;
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = -24022081
	)
	public int field2585;
	@ObfuscatedName("fm")
	@ObfuscatedGetter(
		intValue = -620656701
	)
	public int field2565;
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		intValue = 405715237
	)
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = -1777882267
	)
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("fi")
	public int[] field2695;
	@ObfuscatedName("fo")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("fu")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("fs")
	public boolean field2719;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2647 = false;
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
		this.field2594 = 1;
		this.field2694 = 1;
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
		this.field2709 = false;
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
		this.field2711 = 0;
		this.field2633 = 0;
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
		this.field2651 = false;
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
		this.field2631 = -1;
		this.field2652 = 0;
		this.field2585 = 0;
		this.field2565 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2719 = false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "39"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "77"
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
				this.field2711 = var1.readUnsignedShort();
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
			this.field2709 = var1.readUnsignedByte() == 1;
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lkg;I)[Ljava/lang/Object;",
		garbageValue = "2111872716"
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
		signature = "(Lkg;B)[I",
		garbageValue = "-106"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "36"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ZI)Lln;",
		garbageValue = "-988203301"
	)
	@Export("getSprite")
	public Sprite getSprite(boolean var1) {
		field2647 = false;
		int var2;
		if (var1) {
			var2 = this.spriteId;
		} else {
			var2 = this.spriteId2;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
			Sprite var5 = (Sprite)Widget_cachedSprites.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = class288.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
				if (var5 == null) {
					field2647 = true;
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(S)Lky;",
		garbageValue = "12527"
	)
	@Export("getFont")
	public Font getFont() {
		field2647 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class60.method1195(Widget_spritesArchive, Widget_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, (long)this.fontId);
				} else {
					field2647 = true;
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lln;",
		garbageValue = "-121704848"
	)
	@Export("getInventorySprite")
	public Sprite getInventorySprite(int var1) {
		field2647 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = class288.SpriteBuffer_getSprite(Widget_spritesArchive, var2, 0);
					if (var3 != null) {
						Widget_cachedSprites.put(var3, (long)var2);
					} else {
						field2647 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Liy;IZLhd;I)Ldf;",
		garbageValue = "-527330743"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
		field2647 = false;
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
					var8 = ModelData.ModelData_get(FriendLoginUpdate.Widget_modelsArchive, var6, 0);
					if (var8 == null) {
						field2647 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = VarcInt.getNpcDefinition(var6).getModelData();
					if (var8 == null) {
						field2647 = true;
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
						field2647 = true;
						return null;
					}

					var7 = var8.toModel(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemDefinition var9 = Interpreter.ItemDefinition_get(var6);
					var8 = var9.getModelData(10);
					if (var8 == null) {
						field2647 = true;
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
		signature = "(ZI)Lhn;",
		garbageValue = "-92649703"
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
			long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((long)this.spriteShadow << 40);
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-663551109"
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
