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
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("l")
   @Export("loadedWidgetGroups")
   public static boolean[] loadedWidgetGroups;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("Widget_indexCache")
   public static AbstractIndexCache Widget_indexCache;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__ho_d")
   public static AbstractIndexCache __ho_d;
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
   @Export("__ho_z")
   static EvictingDualNodeHashTable __ho_z;
   @ObfuscatedName("j")
   @Export("__ho_j")
   public static boolean __ho_j;
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
   @Export("__aw")
   public int __aw;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1047989223
   )
   @Export("__al")
   public int __al;
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
   @Export("__af")
   public int __af;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -110526699
   )
   @Export("lineWid")
   public int lineWid;
   @ObfuscatedName("ba")
   @Export("__ba")
   public boolean __ba;
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
   @Export("__bf")
   public int __bf;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 727421593
   )
   @Export("__bh")
   public int __bh;
   @ObfuscatedName("be")
   @Export("modelOrthog")
   public boolean modelOrthog;
   @ObfuscatedName("bv")
   @Export("__bv")
   public boolean __bv;
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
   @Export("__cg")
   public boolean __cg;
   @ObfuscatedName("cf")
   @Export("__cf")
   public byte[][] __cf;
   @ObfuscatedName("cp")
   @Export("__cp")
   public byte[][] __cp;
   @ObfuscatedName("cc")
   @Export("__cc")
   public int[] __cc;
   @ObfuscatedName("ci")
   @Export("__ci")
   public int[] __ci;
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
   @Export("__em")
   public Object[] __em;
   @ObfuscatedName("ed")
   @Export("onKeyListener")
   public Object[] onKeyListener;
   @ObfuscatedName("ex")
   @Export("__ex")
   public Object[] __ex;
   @ObfuscatedName("ej")
   @Export("__ej")
   public Object[] __ej;
   @ObfuscatedName("el")
   @Export("__el")
   public Object[] __el;
   @ObfuscatedName("en")
   @Export("onDialogAbortListener")
   public Object[] onDialogAbortListener;
   @ObfuscatedName("ei")
   @Export("__ei")
   public Object[] __ei;
   @ObfuscatedName("ee")
   @Export("__ee")
   public Object[] __ee;
   @ObfuscatedName("eq")
   @Export("__eq")
   public Object[] __eq;
   @ObfuscatedName("eh")
   @Export("__eh")
   public Object[] __eh;
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
   @Export("__fq")
   public boolean __fq;
   @ObfuscatedName("fw")
   @Export("__fw")
   public boolean __fw;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1520351537
   )
   @Export("__fg")
   public int __fg;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 209458049
   )
   @Export("__fc")
   public int __fc;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -672198209
   )
   @Export("__fl")
   public int __fl;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 876695207
   )
   @Export("__fj")
   public int __fj;
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
   @Export("__fh")
   public int[] __fh;
   @ObfuscatedName("fx")
   @Export("noClickThrough")
   public boolean noClickThrough;
   @ObfuscatedName("fm")
   @Export("noScrollThrough")
   public boolean noScrollThrough;
   @ObfuscatedName("fz")
   @Export("__fz")
   public boolean __fz;

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
      this.__aw = 1;
      this.__al = 1;
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
      this.rectangleMode = RectangleMode.__lj_m;
      this.transparency = 0;
      this.__af = 0;
      this.lineWid = 1;
      this.__ba = false;
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
      this.__bf = 0;
      this.__bh = 0;
      this.modelOrthog = false;
      this.__bv = false;
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
      this.__cg = false;
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
      this.__fq = false;
      this.__fw = false;
      this.__fg = -1;
      this.__fc = 0;
      this.__fl = 0;
      this.__fj = 0;
      this.rootIndex = -1;
      this.cycle = -1;
      this.noClickThrough = false;
      this.noScrollThrough = false;
      this.__fz = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "688173225"
   )
   @Export("decodeLegacy")
   void decodeLegacy(Buffer var1) {
      this.isIf3 = false;
      this.type = var1.readUnsignedByte();
      this.buttonType = var1.readUnsignedByte();
      this.contentType = var1.__ag_302();
      this.rawX = var1.__aq_303();
      this.rawY = var1.__aq_303();
      this.rawWidth = var1.__ag_302();
      this.rawHeight = var1.__ag_302();
      this.transparency = var1.readUnsignedByte();
      this.parentId = var1.__ag_302();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.mouseOverRedirect = var1.__ag_302();
      if(this.mouseOverRedirect == 65535) {
         this.mouseOverRedirect = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.cs1Comparisons = new int[var2];
         this.cs1ComparisonValues = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.cs1Comparisons[var3] = var1.readUnsignedByte();
            this.cs1ComparisonValues[var3] = var1.__ag_302();
         }
      }

      var3 = var1.readUnsignedByte();
      int var4;
      int var5;
      int var6;
      if(var3 > 0) {
         this.cs1Instructions = new int[var3][];

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var1.__ag_302();
            this.cs1Instructions[var4] = new int[var5];

            for(var6 = 0; var6 < var5; ++var6) {
               this.cs1Instructions[var4][var6] = var1.__ag_302();
               if(this.cs1Instructions[var4][var6] == 65535) {
                  this.cs1Instructions[var4][var6] = -1;
               }
            }
         }
      }

      if(this.type == 0) {
         this.scrollHeight = var1.__ag_302();
         this.isHidden = var1.readUnsignedByte() == 1;
      }

      if(this.type == 1) {
         var1.__ag_302();
         var1.readUnsignedByte();
      }

      if(this.type == 2) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.clickMask |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.clickMask |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if(var6 == 1) {
            this.clickMask |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.clickMask |= 536870912;
         }

         this.paddingX = var1.readUnsignedByte();
         this.paddingY = var1.readUnsignedByte();
         this.inventoryXOffsets = new int[20];
         this.inventoryYOffsets = new int[20];
         this.inventorySprites = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.inventoryXOffsets[var8] = var1.__aq_303();
               this.inventoryYOffsets[var8] = var1.__aq_303();
               this.inventorySprites[var8] = var1.readInt();
            } else {
               this.inventorySprites[var8] = -1;
            }
         }

         this.itemActions = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var11 = var1.readStringCp1252NullTerminated();
            if(var11.length() > 0) {
               this.itemActions[var8] = var11;
               this.clickMask |= 1 << var8 + 23;
            }
         }
      }

      if(this.type == 3) {
         this.fill = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textLineHeight = var1.readUnsignedByte();
         this.fontId = var1.__ag_302();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readStringCp1252NullTerminated();
         this.text2 = var1.readStringCp1252NullTerminated();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.color = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.color2 = var1.readInt();
         this.mouseOverColor = var1.readInt();
         this.mouseOverColor2 = var1.readInt();
      }

      if(this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteId = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.__ag_302();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelType2 = 1;
         this.modelId2 = var1.__ag_302();
         if(this.modelId2 == 65535) {
            this.modelId2 = -1;
         }

         this.sequenceId = var1.__ag_302();
         if(this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.sequenceId2 = var1.__ag_302();
         if(this.sequenceId2 == 65535) {
            this.sequenceId2 = -1;
         }

         this.modelZoom = var1.__ag_302();
         this.modelAngleX = var1.__ag_302();
         this.modelAngleY = var1.__ag_302();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         this.textXAlignment = var1.readUnsignedByte();
         this.fontId = var1.__ag_302();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
         this.paddingX = var1.__aq_303();
         this.paddingY = var1.__aq_303();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.clickMask |= 1073741824;
         }

         this.itemActions = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var10 = var1.readStringCp1252NullTerminated();
            if(var10.length() > 0) {
               this.itemActions[var5] = var10;
               this.clickMask |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.readStringCp1252NullTerminated();
      }

      if(this.buttonType == 2 || this.type == 2) {
         this.spellActionName = var1.readStringCp1252NullTerminated();
         this.spellName = var1.readStringCp1252NullTerminated();
         var4 = var1.__ag_302() & 63;
         this.clickMask |= var4 << 11;
      }

      if(this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
         this.buttonText = var1.readStringCp1252NullTerminated();
         if(this.buttonText.length() == 0) {
            if(this.buttonType == 1) {
               this.buttonText = "Ok";
            }

            if(this.buttonType == 4) {
               this.buttonText = "Select";
            }

            if(this.buttonType == 5) {
               this.buttonText = "Select";
            }

            if(this.buttonType == 6) {
               this.buttonText = "Continue";
            }
         }
      }

      if(this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
         this.clickMask |= 4194304;
      }

      if(this.buttonType == 6) {
         this.clickMask |= 1;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-1967445442"
   )
   @Export("decode")
   void decode(Buffer var1) {
      var1.readUnsignedByte();
      this.isIf3 = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.__ag_302();
      this.rawX = var1.__aq_303();
      this.rawY = var1.__aq_303();
      this.rawWidth = var1.__ag_302();
      if(this.type == 9) {
         this.rawHeight = var1.__aq_303();
      } else {
         this.rawHeight = var1.__ag_302();
      }

      this.widthAlignment = var1.readByte();
      this.heightAlignment = var1.readByte();
      this.xAlignment = var1.readByte();
      this.yAlignment = var1.readByte();
      this.parentId = var1.__ag_302();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = var1.readUnsignedByte() == 1;
      if(this.type == 0) {
         this.scrollWidth = var1.__ag_302();
         this.scrollHeight = var1.__ag_302();
         this.noClickThrough = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteAngle = var1.__ag_302();
         this.spriteTiling = var1.readUnsignedByte() == 1;
         this.transparency = var1.readUnsignedByte();
         this.outline = var1.readUnsignedByte();
         this.spriteShadow = var1.readInt();
         this.spriteFlipV = var1.readUnsignedByte() == 1;
         this.spriteFlipH = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.__ag_302();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelOffsetX = var1.__aq_303();
         this.modelOffsetY = var1.__aq_303();
         this.modelAngleX = var1.__ag_302();
         this.modelAngleY = var1.__ag_302();
         this.modelAngleZ = var1.__ag_302();
         this.modelZoom = var1.__ag_302();
         this.sequenceId = var1.__ag_302();
         if(this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.modelOrthog = var1.readUnsignedByte() == 1;
         var1.__ag_302();
         if(this.widthAlignment != 0) {
            this.__bf = var1.__ag_302();
         }

         if(this.heightAlignment != 0) {
            var1.__ag_302();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.__ag_302();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = var1.readStringCp1252NullTerminated();
         this.textLineHeight = var1.readUnsignedByte();
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
      }

      if(this.type == 3) {
         this.color = var1.readInt();
         this.fill = var1.readUnsignedByte() == 1;
         this.transparency = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.lineWid = var1.readUnsignedByte();
         this.color = var1.readInt();
         this.__ba = var1.readUnsignedByte() == 1;
      }

      this.clickMask = var1.readMedium();
      this.dataText = var1.readStringCp1252NullTerminated();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgr;I)[Ljava/lang/Object;",
      garbageValue = "1906438788"
   )
   @Export("readListener")
   Object[] readListener(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if(var5 == 0) {
               var3[var4] = new Integer(var1.readInt());
            } else if(var5 == 1) {
               var3[var4] = var1.readStringCp1252NullTerminated();
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
   int[] readListenerTriggers(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.readInt();
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
   public void swapItems(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Lln;",
      garbageValue = "1271984781"
   )
   @Export("getSprite")
   public Sprite getSprite(boolean var1) {
      __ho_j = false;
      int var2;
      if(var1) {
         var2 = this.spriteId;
      } else {
         var2 = this.spriteId2;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((this.spriteFlipV?1L:0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipH?1L:0L) << 39) + ((long)this.spriteShadow << 40);
         Sprite var5 = (Sprite)widgetSpriteCache.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = class322.readSprite(__ho_d, var2, 0);
            if(var5 == null) {
               __ho_j = true;
               return null;
            } else {
               if(this.spriteFlipV) {
                  var5.__g_501();
               }

               if(this.spriteFlipH) {
                  var5.__u_500();
               }

               if(this.outline > 0) {
                  var5.__o_499(this.outline);
               }

               if(this.outline >= 1) {
                  var5.__l_502(1);
               }

               if(this.outline >= 2) {
                  var5.__l_502(16777215);
               }

               if(this.spriteShadow != 0) {
                  var5.__e_503(this.spriteShadow);
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
      __ho_j = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SpriteIds.method5823(__ho_d, class27.__aq_k, this.fontId, 0);
            if(var1 != null) {
               Widget_cachedFonts.put(var1, (long)this.fontId);
            } else {
               __ho_j = true;
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
      __ho_j = false;
      if(var1 >= 0 && var1 < this.inventorySprites.length) {
         int var2 = this.inventorySprites[var1];
         if(var2 == -1) {
            return null;
         } else {
            Sprite var3 = (Sprite)widgetSpriteCache.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = class322.readSprite(__ho_d, var2, 0);
               if(var3 != null) {
                  widgetSpriteCache.put(var3, (long)var2);
               } else {
                  __ho_j = true;
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
   public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4) {
      __ho_j = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.modelType2;
         var6 = this.modelId2;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)Widget_cachedModels.get((long)(var6 + (var5 << 16)));
         if(var7 == null) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method2788(BufferedSource.__fh_x, var6, 0);
               if(var8 == null) {
                  __ho_j = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = ObjectDefinition.getNpcDefinition(var6).getModelData();
               if(var8 == null) {
                  __ho_j = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(var4 == null) {
                  return null;
               }

               var8 = var4.getModelData();
               if(var8 == null) {
                  __ho_j = true;
                  return null;
               }

               var7 = var8.toModel(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemDefinition var9 = Skills.getItemDefinition(var6);
               var8 = var9.__l_429(10);
               if(var8 == null) {
                  __ho_j = true;
                  return null;
               }

               var7 = var8.toModel(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
            }

            Widget_cachedModels.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(var1 != null) {
            var7 = var1.animateWidget(var7, var2);
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
      if(this.spriteId == -1) {
         var1 = false;
      }

      int var2 = var1?this.spriteId:this.spriteId2;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH?1L:0L) << 39) + ((this.spriteFlipV?1L:0L) << 38) + ((long)this.outline << 36) + (long)var2;
         SpriteMask var5 = (SpriteMask)__ho_z.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            Sprite var6 = this.getSprite(var1);
            if(var6 == null) {
               return null;
            } else {
               Sprite var7 = var6.copyNormalized();
               int[] var8 = new int[var7.subHeight];
               int[] var9 = new int[var7.subHeight];

               for(int var10 = 0; var10 < var7.subHeight; ++var10) {
                  int var11 = 0;
                  int var12 = var7.subWidth;

                  int var13;
                  for(var13 = 0; var13 < var7.subWidth; ++var13) {
                     if(var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.subWidth - 1; var13 >= var11; --var13) {
                     if(var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
               __ho_z.put(var5, var3);
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
   public void setAction(int var1, String var2) {
      if(this.actions == null || this.actions.length <= var1) {
         String[] var3 = new String[var1 + 1];
         if(this.actions != null) {
            for(int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[var1] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BLff;I)V",
      garbageValue = "-1287305716"
   )
   static void method4499(int var0, byte[] var1, IndexStore var2) {
      IndexStoreAction var3 = new IndexStoreAction();
      var3.type = 0;
      var3.key = (long)var0;
      var3.data = var1;
      var3.indexStore = var2;
      NodeDeque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      NodeDeque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFirst(var3);
      }

      Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      Object var6 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.__iv_q == 0) {
            Frames.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            Frames.IndexStoreActionHandler_thread.setDaemon(true);
            Frames.IndexStoreActionHandler_thread.start();
            Frames.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.__iv_q = 600;
      }
   }

   static {
      widgetSpriteCache = new EvictingDualNodeHashTable(200);
      Widget_cachedModels = new EvictingDualNodeHashTable(50);
      Widget_cachedFonts = new EvictingDualNodeHashTable(20);
      __ho_z = new EvictingDualNodeHashTable(8);
      __ho_j = false;
   }
}
