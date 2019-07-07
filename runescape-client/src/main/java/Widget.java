import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lic;"
   )
   @Export("WorldMapElement_cached")
   public static WorldMapElement[] WorldMapElement_cached;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[[Lho;"
   )
   @Export("interfaceComponents")
   public static Widget[][] interfaceComponents;
   @ObfuscatedName("l")
   @Export("loadedInterfaces")
   public static boolean[] loadedInterfaces;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("Widget_archive")
   public static AbstractArchive Widget_archive;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractArchive field955;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("widgetSpriteCache")
   static EvictingDualNodeHashTable widgetSpriteCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("Widget_cachedModels")
   static EvictingDualNodeHashTable Widget_cachedModels;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("Widget_cachedFonts")
   static EvictingDualNodeHashTable Widget_cachedFonts;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   static EvictingDualNodeHashTable field956;
   @ObfuscatedName("j")
   public static boolean field957;
   @ObfuscatedName("s")
   @Export("isIf3")
   public boolean isIf3;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -941148335
   )
   @Export("id")
   public int id;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -648033351
   )
   @Export("childIndex")
   public int childIndex;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1521310729
   )
   @Export("type")
   public int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1412102151
   )
   @Export("buttonType")
   public int buttonType;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -581762425
   )
   @Export("contentType")
   public int contentType;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 523318277
   )
   @Export("xAlignment")
   public int xAlignment;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1300531185
   )
   @Export("yAlignment")
   public int yAlignment;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1628640897
   )
   @Export("widthAlignment")
   public int widthAlignment;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -709256449
   )
   @Export("heightAlignment")
   public int heightAlignment;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -872904863
   )
   @Export("rawX")
   public int rawX;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1814696937
   )
   @Export("rawY")
   public int rawY;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2001402777
   )
   @Export("rawWidth")
   public int rawWidth;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1202342839
   )
   @Export("rawHeight")
   public int rawHeight;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1271321381
   )
   @Export("x")
   public int x;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1492291497
   )
   @Export("y")
   public int y;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1716081883
   )
   @Export("width")
   public int width;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1656646737
   )
   @Export("height")
   public int height;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 206556853
   )
   public int field958;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1047989223
   )
   public int field959;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -617209253
   )
   @Export("parentId")
   public int parentId;
   @ObfuscatedName("ae")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 2090399935
   )
   @Export("scrollX")
   public int scrollX;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -537618643
   )
   @Export("scrollY")
   public int scrollY;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -623790443
   )
   @Export("scrollWidth")
   public int scrollWidth;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -867175629
   )
   @Export("scrollHeight")
   public int scrollHeight;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2022638615
   )
   @Export("color")
   public int color;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -365781561
   )
   @Export("color2")
   public int color2;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1831692129
   )
   @Export("mouseOverColor")
   public int mouseOverColor;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1236161275
   )
   @Export("mouseOverColor2")
   public int mouseOverColor2;
   @ObfuscatedName("ao")
   @Export("fill")
   public boolean fill;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("rectangleMode")
   public RectangleMode rectangleMode;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -638557371
   )
   @Export("transparency")
   public int transparency;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1853255291
   )
   public int field960;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -110526699
   )
   @Export("lineWid")
   public int lineWid;
   @ObfuscatedName("ba")
   public boolean field961;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1074168553
   )
   @Export("spriteId2")
   public int spriteId2;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1573420153
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1361791123
   )
   @Export("spriteAngle")
   public int spriteAngle;
   @ObfuscatedName("bn")
   @Export("spriteTiling")
   public boolean spriteTiling;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -594884327
   )
   @Export("outline")
   public int outline;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 215797483
   )
   @Export("spriteShadow")
   public int spriteShadow;
   @ObfuscatedName("bc")
   @Export("spriteFlipV")
   public boolean spriteFlipV;
   @ObfuscatedName("bo")
   @Export("spriteFlipH")
   public boolean spriteFlipH;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 630750753
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -2013625215
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 138222099
   )
   @Export("modelType2")
   int modelType2;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -201557389
   )
   @Export("modelId2")
   int modelId2;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1423753745
   )
   @Export("sequenceId")
   public int sequenceId;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -856053301
   )
   @Export("sequenceId2")
   public int sequenceId2;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -459670781
   )
   @Export("modelOffsetX")
   public int modelOffsetX;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -2018053063
   )
   @Export("modelOffsetY")
   public int modelOffsetY;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2044722063
   )
   @Export("modelAngleX")
   public int modelAngleX;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1253859481
   )
   @Export("modelAngleY")
   public int modelAngleY;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -692411223
   )
   @Export("modelAngleZ")
   public int modelAngleZ;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -2133338643
   )
   @Export("modelZoom")
   public int modelZoom;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1692331135
   )
   public int field962;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 727421593
   )
   public int field963;
   @ObfuscatedName("be")
   @Export("modelOrthog")
   public boolean modelOrthog;
   @ObfuscatedName("bv")
   @Export("modelTransparency")
   public boolean modelTransparency;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1658511475
   )
   @Export("itemQuantityMode")
   public int itemQuantityMode;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1435746863
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("cv")
   @Export("text")
   public String text;
   @ObfuscatedName("ce")
   @Export("text2")
   public String text2;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1401272343
   )
   @Export("textLineHeight")
   public int textLineHeight;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1527989635
   )
   @Export("textXAlignment")
   public int textXAlignment;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1271997981
   )
   @Export("textYAlignment")
   public int textYAlignment;
   @ObfuscatedName("cj")
   @Export("textShadowed")
   public boolean textShadowed;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -23173063
   )
   @Export("paddingX")
   public int paddingX;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 720760323
   )
   @Export("paddingY")
   public int paddingY;
   @ObfuscatedName("ck")
   @Export("inventoryXOffsets")
   public int[] inventoryXOffsets;
   @ObfuscatedName("cn")
   @Export("inventoryYOffsets")
   public int[] inventoryYOffsets;
   @ObfuscatedName("cq")
   @Export("inventorySprites")
   public int[] inventorySprites;
   @ObfuscatedName("ch")
   @Export("itemActions")
   public String[] itemActions;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1856618959
   )
   @Export("clickMask")
   public int clickMask;
   @ObfuscatedName("cg")
   public boolean field965;
   @ObfuscatedName("cf")
   public byte[][] field966;
   @ObfuscatedName("cp")
   public byte[][] field967;
   @ObfuscatedName("cc")
   public int[] field968;
   @ObfuscatedName("ci")
   public int[] field969;
   @ObfuscatedName("de")
   @Export("dataText")
   public String dataText;
   @ObfuscatedName("dx")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("parent")
   public Widget parent;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 2092800189
   )
   @Export("dragZoneSize")
   public int dragZoneSize;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1021798347
   )
   @Export("dragThreshold")
   public int dragThreshold;
   @ObfuscatedName("da")
   @Export("isScrollBar")
   public boolean isScrollBar;
   @ObfuscatedName("dp")
   @Export("spellActionName")
   public String spellActionName;
   @ObfuscatedName("ds")
   @Export("hasListener")
   public boolean hasListener;
   @ObfuscatedName("di")
   @Export("onLoad")
   public Object[] onLoad;
   @ObfuscatedName("dc")
   @Export("onClick")
   public Object[] onClick;
   @ObfuscatedName("dg")
   @Export("onClickRepeat")
   public Object[] onClickRepeat;
   @ObfuscatedName("db")
   @Export("onRelease")
   public Object[] onRelease;
   @ObfuscatedName("dd")
   @Export("onHold")
   public Object[] onHold;
   @ObfuscatedName("dy")
   @Export("onMouseOver")
   public Object[] onMouseOver;
   @ObfuscatedName("dk")
   @Export("onMouseRepeat")
   public Object[] onMouseRepeat;
   @ObfuscatedName("dl")
   @Export("onMouseLeave")
   public Object[] onMouseLeave;
   @ObfuscatedName("dr")
   @Export("onDrag")
   public Object[] onDrag;
   @ObfuscatedName("dw")
   @Export("onDragComplete")
   public Object[] onDragComplete;
   @ObfuscatedName("dv")
   @Export("onTargetEnter")
   public Object[] onTargetEnter;
   @ObfuscatedName("do")
   @Export("onTargetLeave")
   public Object[] onTargetLeave;
   @ObfuscatedName("dh")
   @Export("onVarTransmit")
   public Object[] onVarTransmit;
   @ObfuscatedName("dz")
   @Export("varTransmitTriggers")
   public int[] varTransmitTriggers;
   @ObfuscatedName("dj")
   @Export("onInvTransmit")
   public Object[] onInvTransmit;
   @ObfuscatedName("du")
   @Export("invTransmitTriggers")
   public int[] invTransmitTriggers;
   @ObfuscatedName("dm")
   @Export("onStatTransmit")
   public Object[] onStatTransmit;
   @ObfuscatedName("dq")
   @Export("statTransmitTriggers")
   public int[] statTransmitTriggers;
   @ObfuscatedName("et")
   @Export("onTimer")
   public Object[] onTimer;
   @ObfuscatedName("eb")
   @Export("onOp")
   public Object[] onOp;
   @ObfuscatedName("ek")
   @Export("onScroll")
   public Object[] onScroll;
   @ObfuscatedName("em")
   @Export("onChatTransmit")
   public Object[] onChatTransmit;
   @ObfuscatedName("ed")
   @Export("onKey")
   public Object[] onKey;
   @ObfuscatedName("ex")
   @Export("onFriendTransmit")
   public Object[] onFriendTransmit;
   @ObfuscatedName("ej")
   @Export("onClanTransmit")
   public Object[] onClanTransmit;
   @ObfuscatedName("el")
   @Export("onMiscTransmit")
   public Object[] onMiscTransmit;
   @ObfuscatedName("en")
   @Export("onDialogAbort")
   public Object[] onDialogAbort;
   @ObfuscatedName("ei")
   @Export("onSubChange")
   public Object[] onSubChange;
   @ObfuscatedName("ee")
   @Export("onResize")
   public Object[] onResize;
   @ObfuscatedName("eq")
   @Export("onStockTransmit")
   public Object[] onStockTransmit;
   @ObfuscatedName("eh")
   public Object[] field977;
   @ObfuscatedName("eo")
   @Export("cs1Instructions")
   public int[][] cs1Instructions;
   @ObfuscatedName("ey")
   @Export("cs1Comparisons")
   public int[] cs1Comparisons;
   @ObfuscatedName("er")
   @Export("cs1ComparisonValues")
   public int[] cs1ComparisonValues;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1390352887
   )
   @Export("mouseOverRedirect")
   public int mouseOverRedirect;
   @ObfuscatedName("eu")
   @Export("spellName")
   public String spellName;
   @ObfuscatedName("ec")
   @Export("buttonText")
   public String buttonText;
   @ObfuscatedName("ef")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("ev")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1248629915
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 340244859
   )
   @Export("itemQuantity")
   public int itemQuantity;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -431656963
   )
   @Export("modelFrame")
   public int modelFrame;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -95117407
   )
   @Export("modelFrameCycle")
   public int modelFrameCycle;
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "[Lho;"
   )
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("fq")
   public boolean field978;
   @ObfuscatedName("fw")
   public boolean field979;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1520351537
   )
   public int field980;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 209458049
   )
   public int field981;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -672198209
   )
   public int field982;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 876695207
   )
   public int field983;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 365867737
   )
   @Export("rootIndex")
   public int rootIndex;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1995006949
   )
   @Export("cycle")
   public int cycle;
   @ObfuscatedName("fh")
   public int[] field984;
   @ObfuscatedName("fx")
   @Export("noClickThrough")
   public boolean noClickThrough;
   @ObfuscatedName("fm")
   @Export("noScrollThrough")
   public boolean noScrollThrough;
   @ObfuscatedName("fz")
   public boolean field985;

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
      this.field958 = 1;
      this.field959 = 1;
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
      this.rectangleMode = RectangleMode.field757;
      this.transparency = 0;
      this.field960 = 0;
      this.lineWid = 1;
      this.field961 = false;
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
      this.field962 = 0;
      this.field963 = 0;
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
      this.field965 = false;
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
      this.field978 = false;
      this.field979 = false;
      this.field980 = -1;
      this.field981 = 0;
      this.field982 = 0;
      this.field983 = 0;
      this.rootIndex = -1;
      this.cycle = -1;
      this.noClickThrough = false;
      this.noScrollThrough = false;
      this.field985 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "688173225"
   )
   @Export("decodeLegacy")
   void decodeLegacy(Buffer buffer) {
      this.isIf3 = false;
      this.type = buffer.readUnsignedByte();
      this.buttonType = buffer.readUnsignedByte();
      this.contentType = buffer.readUnsignedShort();
      this.rawX = buffer.method44();
      this.rawY = buffer.method44();
      this.rawWidth = buffer.readUnsignedShort();
      this.rawHeight = buffer.readUnsignedShort();
      this.transparency = buffer.readUnsignedByte();
      this.parentId = buffer.readUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.mouseOverRedirect = buffer.readUnsignedShort();
      if (this.mouseOverRedirect == 65535) {
         this.mouseOverRedirect = -1;
      }

      int var2 = buffer.readUnsignedByte();
      int var3;
      if (var2 > 0) {
         this.cs1Comparisons = new int[var2];
         this.cs1ComparisonValues = new int[var2];

         for (var3 = 0; var3 < var2; ++var3) {
            this.cs1Comparisons[var3] = buffer.readUnsignedByte();
            this.cs1ComparisonValues[var3] = buffer.readUnsignedShort();
         }
      }

      var3 = buffer.readUnsignedByte();
      int var4;
      int var5;
      int var6;
      if (var3 > 0) {
         this.cs1Instructions = new int[var3][];

         for (var4 = 0; var4 < var3; ++var4) {
            var5 = buffer.readUnsignedShort();
            this.cs1Instructions[var4] = new int[var5];

            for (var6 = 0; var6 < var5; ++var6) {
               this.cs1Instructions[var4][var6] = buffer.readUnsignedShort();
               if (this.cs1Instructions[var4][var6] == 65535) {
                  this.cs1Instructions[var4][var6] = -1;
               }
            }
         }
      }

      if (this.type == 0) {
         this.scrollHeight = buffer.readUnsignedShort();
         this.isHidden = buffer.readUnsignedByte() == 1;
      }

      if (this.type == 1) {
         buffer.readUnsignedShort();
         buffer.readUnsignedByte();
      }

      if (this.type == 2) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         var4 = buffer.readUnsignedByte();
         if (var4 == 1) {
            this.clickMask |= 268435456;
         }

         var5 = buffer.readUnsignedByte();
         if (var5 == 1) {
            this.clickMask |= 1073741824;
         }

         var6 = buffer.readUnsignedByte();
         if (var6 == 1) {
            this.clickMask |= Integer.MIN_VALUE;
         }

         int var7 = buffer.readUnsignedByte();
         if (var7 == 1) {
            this.clickMask |= 536870912;
         }

         this.paddingX = buffer.readUnsignedByte();
         this.paddingY = buffer.readUnsignedByte();
         this.inventoryXOffsets = new int[20];
         this.inventoryYOffsets = new int[20];
         this.inventorySprites = new int[20];

         int var8;
         for (var8 = 0; var8 < 20; ++var8) {
            int var9 = buffer.readUnsignedByte();
            if (var9 == 1) {
               this.inventoryXOffsets[var8] = buffer.method44();
               this.inventoryYOffsets[var8] = buffer.method44();
               this.inventorySprites[var8] = buffer.readInt();
            } else {
               this.inventorySprites[var8] = -1;
            }
         }

         this.itemActions = new String[5];

         for (var8 = 0; var8 < 5; ++var8) {
            String var11 = buffer.readStringCp1252NullTerminated();
            if (var11.length() > 0) {
               this.itemActions[var8] = var11;
               this.clickMask |= 1 << var8 + 23;
            }
         }
      }

      if (this.type == 3) {
         this.fill = buffer.readUnsignedByte() == 1;
      }

      if (this.type == 4 || this.type == 1) {
         this.textXAlignment = buffer.readUnsignedByte();
         this.textYAlignment = buffer.readUnsignedByte();
         this.textLineHeight = buffer.readUnsignedByte();
         this.fontId = buffer.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer.readUnsignedByte() == 1;
      }

      if (this.type == 4) {
         this.text = buffer.readStringCp1252NullTerminated();
         this.text2 = buffer.readStringCp1252NullTerminated();
      }

      if (this.type == 1 || this.type == 3 || this.type == 4) {
         this.color = buffer.readInt();
      }

      if (this.type == 3 || this.type == 4) {
         this.color2 = buffer.readInt();
         this.mouseOverColor = buffer.readInt();
         this.mouseOverColor2 = buffer.readInt();
      }

      if (this.type == 5) {
         this.spriteId2 = buffer.readInt();
         this.spriteId = buffer.readInt();
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = buffer.readUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelType2 = 1;
         this.modelId2 = buffer.readUnsignedShort();
         if (this.modelId2 == 65535) {
            this.modelId2 = -1;
         }

         this.sequenceId = buffer.readUnsignedShort();
         if (this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.sequenceId2 = buffer.readUnsignedShort();
         if (this.sequenceId2 == 65535) {
            this.sequenceId2 = -1;
         }

         this.modelZoom = buffer.readUnsignedShort();
         this.modelAngleX = buffer.readUnsignedShort();
         this.modelAngleY = buffer.readUnsignedShort();
      }

      if (this.type == 7) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         this.textXAlignment = buffer.readUnsignedByte();
         this.fontId = buffer.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer.readUnsignedByte() == 1;
         this.color = buffer.readInt();
         this.paddingX = buffer.method44();
         this.paddingY = buffer.method44();
         var4 = buffer.readUnsignedByte();
         if (var4 == 1) {
            this.clickMask |= 1073741824;
         }

         this.itemActions = new String[5];

         for (var5 = 0; var5 < 5; ++var5) {
            String var10 = buffer.readStringCp1252NullTerminated();
            if (var10.length() > 0) {
               this.itemActions[var5] = var10;
               this.clickMask |= 1 << var5 + 23;
            }
         }
      }

      if (this.type == 8) {
         this.text = buffer.readStringCp1252NullTerminated();
      }

      if (this.buttonType == 2 || this.type == 2) {
         this.spellActionName = buffer.readStringCp1252NullTerminated();
         this.spellName = buffer.readStringCp1252NullTerminated();
         var4 = buffer.readUnsignedShort() & 63;
         this.clickMask |= var4 << 11;
      }

      if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
         this.buttonText = buffer.readStringCp1252NullTerminated();
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-1967445442"
   )
   @Export("decode")
   void decode(Buffer buffer) {
      buffer.readUnsignedByte();
      this.isIf3 = true;
      this.type = buffer.readUnsignedByte();
      this.contentType = buffer.readUnsignedShort();
      this.rawX = buffer.method44();
      this.rawY = buffer.method44();
      this.rawWidth = buffer.readUnsignedShort();
      if (this.type == 9) {
         this.rawHeight = buffer.method44();
      } else {
         this.rawHeight = buffer.readUnsignedShort();
      }

      this.widthAlignment = buffer.readByte();
      this.heightAlignment = buffer.readByte();
      this.xAlignment = buffer.readByte();
      this.yAlignment = buffer.readByte();
      this.parentId = buffer.readUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = buffer.readUnsignedByte() == 1;
      if (this.type == 0) {
         this.scrollWidth = buffer.readUnsignedShort();
         this.scrollHeight = buffer.readUnsignedShort();
         this.noClickThrough = buffer.readUnsignedByte() == 1;
      }

      if (this.type == 5) {
         this.spriteId2 = buffer.readInt();
         this.spriteAngle = buffer.readUnsignedShort();
         this.spriteTiling = buffer.readUnsignedByte() == 1;
         this.transparency = buffer.readUnsignedByte();
         this.outline = buffer.readUnsignedByte();
         this.spriteShadow = buffer.readInt();
         this.spriteFlipV = buffer.readUnsignedByte() == 1;
         this.spriteFlipH = buffer.readUnsignedByte() == 1;
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = buffer.readUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelOffsetX = buffer.method44();
         this.modelOffsetY = buffer.method44();
         this.modelAngleX = buffer.readUnsignedShort();
         this.modelAngleY = buffer.readUnsignedShort();
         this.modelAngleZ = buffer.readUnsignedShort();
         this.modelZoom = buffer.readUnsignedShort();
         this.sequenceId = buffer.readUnsignedShort();
         if (this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.modelOrthog = buffer.readUnsignedByte() == 1;
         buffer.readUnsignedShort();
         if (this.widthAlignment != 0) {
            this.field962 = buffer.readUnsignedShort();
         }

         if (this.heightAlignment != 0) {
            buffer.readUnsignedShort();
         }
      }

      if (this.type == 4) {
         this.fontId = buffer.readUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = buffer.readStringCp1252NullTerminated();
         this.textLineHeight = buffer.readUnsignedByte();
         this.textXAlignment = buffer.readUnsignedByte();
         this.textYAlignment = buffer.readUnsignedByte();
         this.textShadowed = buffer.readUnsignedByte() == 1;
         this.color = buffer.readInt();
      }

      if (this.type == 3) {
         this.color = buffer.readInt();
         this.fill = buffer.readUnsignedByte() == 1;
         this.transparency = buffer.readUnsignedByte();
      }

      if (this.type == 9) {
         this.lineWid = buffer.readUnsignedByte();
         this.color = buffer.readInt();
         this.field961 = buffer.readUnsignedByte() == 1;
      }

      this.clickMask = buffer.readMedium();
      this.dataText = buffer.readStringCp1252NullTerminated();
      int var2 = buffer.readUnsignedByte();
      if (var2 > 0) {
         this.actions = new String[var2];

         for (int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = buffer.readStringCp1252NullTerminated();
         }
      }

      this.dragZoneSize = buffer.readUnsignedByte();
      this.dragThreshold = buffer.readUnsignedByte();
      this.isScrollBar = buffer.readUnsignedByte() == 1;
      this.spellActionName = buffer.readStringCp1252NullTerminated();
      this.onLoad = this.readListener(buffer);
      this.onMouseOver = this.readListener(buffer);
      this.onMouseLeave = this.readListener(buffer);
      this.onTargetLeave = this.readListener(buffer);
      this.onTargetEnter = this.readListener(buffer);
      this.onVarTransmit = this.readListener(buffer);
      this.onInvTransmit = this.readListener(buffer);
      this.onStatTransmit = this.readListener(buffer);
      this.onTimer = this.readListener(buffer);
      this.onOp = this.readListener(buffer);
      this.onMouseRepeat = this.readListener(buffer);
      this.onClick = this.readListener(buffer);
      this.onClickRepeat = this.readListener(buffer);
      this.onRelease = this.readListener(buffer);
      this.onHold = this.readListener(buffer);
      this.onDrag = this.readListener(buffer);
      this.onDragComplete = this.readListener(buffer);
      this.onScroll = this.readListener(buffer);
      this.varTransmitTriggers = this.readListenerTriggers(buffer);
      this.invTransmitTriggers = this.readListenerTriggers(buffer);
      this.statTransmitTriggers = this.readListenerTriggers(buffer);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgr;I)[Ljava/lang/Object;",
      garbageValue = "1906438788"
   )
   @Export("readListener")
   Object[] readListener(Buffer buffer) {
      int var2 = buffer.readUnsignedByte();
      if (var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for (int var4 = 0; var4 < var2; ++var4) {
            int var5 = buffer.readUnsignedByte();
            if (var5 == 0) {
               var3[var4] = new Integer(buffer.readInt());
            } else if (var5 == 1) {
               var3[var4] = buffer.readStringCp1252NullTerminated();
            }
         }

         this.hasListener = true;
         return var3;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgr;B)[I",
      garbageValue = "1"
   )
   @Export("readListenerTriggers")
   int[] readListenerTriggers(Buffer buffer) {
      int var2 = buffer.readUnsignedByte();
      if (var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = buffer.readInt();
         }

         return var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1403134294"
   )
   @Export("swapItems")
   public void swapItems(int indexA, int indexB) {
      int var3 = this.itemIds[indexB];
      this.itemIds[indexB] = this.itemIds[indexA];
      this.itemIds[indexA] = var3;
      var3 = this.itemQuantities[indexB];
      this.itemQuantities[indexB] = this.itemQuantities[indexA];
      this.itemQuantities[indexA] = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Lln;",
      garbageValue = "1271984781"
   )
   @Export("getSprite")
   public Sprite getSprite(boolean var1) {
      field957 = false;
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
         Sprite var5 = (Sprite)widgetSpriteCache.get(var3);
         if (var5 != null) {
            return var5;
         } else {
            var5 = class322.readSprite(field955, var2, 0);
            if (var5 == null) {
               field957 = true;
               return null;
            } else {
               if (this.spriteFlipV) {
                  var5.method306();
               }

               if (this.spriteFlipH) {
                  var5.method305();
               }

               if (this.outline > 0) {
                  var5.method304(this.outline);
               }

               if (this.outline >= 1) {
                  var5.method307(1);
               }

               if (this.outline >= 2) {
                  var5.method307(16777215);
               }

               if (this.spriteShadow != 0) {
                  var5.method308(this.spriteShadow);
               }

               widgetSpriteCache.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lkk;",
      garbageValue = "-2"
   )
   @Export("getFont")
   public Font getFont() {
      field957 = false;
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            var1 = GraphicsDefaults.method5823(field955, class27.field1143, this.fontId, 0);
            if (var1 != null) {
               Widget_cachedFonts.put(var1, (long)this.fontId);
            } else {
               field957 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lln;",
      garbageValue = "285832400"
   )
   @Export("getInventorySprite")
   public Sprite getInventorySprite(int var1) {
      field957 = false;
      if (var1 >= 0 && var1 < this.inventorySprites.length) {
         int var2 = this.inventorySprites[var1];
         if (var2 == -1) {
            return null;
         } else {
            Sprite var3 = (Sprite)widgetSpriteCache.get((long)var2);
            if (var3 != null) {
               return var3;
            } else {
               var3 = class322.readSprite(field955, var2, 0);
               if (var3 != null) {
                  widgetSpriteCache.put(var3, (long)var2);
               } else {
                  field957 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljh;IZLhi;I)Ldu;",
      garbageValue = "1082545676"
   )
   @Export("getModel")
   public Model getModel(SequenceDefinition sequence, int frame, boolean var3, PlayerAppearance appearance) {
      field957 = false;
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
               var8 = ModelData.method2788(BufferedSource.field54, var6, 0);
               if (var8 == null) {
                  field957 = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if (var5 == 2) {
               var8 = ObjectDefinition.getNpcDefinition(var6).getModelData();
               if (var8 == null) {
                  field957 = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if (var5 == 3) {
               if (appearance == null) {
                  return null;
               }

               var8 = appearance.getModelData();
               if (var8 == null) {
                  field957 = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if (var5 == 4) {
               ItemDefinition var9 = Skills.getItemDefinition(var6);
               var8 = var9.method143(10);
               if (var8 == null) {
                  field957 = true;
                  return null;
               }

               var7 = var8.toModel(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
            }

            Widget_cachedModels.put(var7, (long)(var6 + (var5 << 16)));
         }

         if (sequence != null) {
            var7 = sequence.animateWidget(var7, frame);
         }

         return var7;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)Lhp;",
      garbageValue = "4"
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
         long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2;
         SpriteMask var5 = (SpriteMask)field956.get(var3);
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
               field956.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-30"
   )
   @Export("setAction")
   public void setAction(int index, String var2) {
      if (this.actions == null || this.actions.length <= index) {
         String[] var3 = new String[index + 1];
         if (this.actions != null) {
            for (int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[index] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BLff;I)V",
      garbageValue = "-1287305716"
   )
   static void method4499(int var0, byte[] var1, ArchiveDisk var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 0;
      var3.key = (long)var0;
      var3.data = var1;
      var3.archiveDisk = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
      }

      Object var5 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field412 == 0) {
            Frames.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
            Frames.ArchiveDiskActionHandler_thread.setDaemon(true);
            Frames.ArchiveDiskActionHandler_thread.start();
            Frames.ArchiveDiskActionHandler_thread.setPriority(5);
         }

         ArchiveDiskActionHandler.field412 = 600;
      }
   }

   static {
      widgetSpriteCache = new EvictingDualNodeHashTable(200);
      Widget_cachedModels = new EvictingDualNodeHashTable(50);
      Widget_cachedFonts = new EvictingDualNodeHashTable(20);
      field956 = new EvictingDualNodeHashTable(8);
      field957 = false;
   }
}
