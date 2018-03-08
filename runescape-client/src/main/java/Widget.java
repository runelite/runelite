import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[[Lig;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field2811;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("Widget_cachedModels")
   static NodeCache Widget_cachedModels;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("Widget_cachedFonts")
   static NodeCache Widget_cachedFonts;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field2814;
   @ObfuscatedName("j")
   public static boolean field2885;
   @ObfuscatedName("k")
   @Export("hasScript")
   public boolean hasScript;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1880197651
   )
   @Export("id")
   public int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1457457375
   )
   @Export("index")
   public int index;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1470058023
   )
   @Export("type")
   public int type;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1282303213
   )
   public int field2853;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1540981811
   )
   @Export("contentType")
   public int contentType;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1507676971
   )
   @Export("dynamicX")
   public int dynamicX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1783152579
   )
   @Export("dynamicY")
   public int dynamicY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 659419763
   )
   @Export("dynamicWidth")
   public int dynamicWidth;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -44543897
   )
   @Export("buttonType")
   public int buttonType;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1702785571
   )
   @Export("originalX")
   public int originalX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -890689755
   )
   @Export("originalY")
   public int originalY;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 124683281
   )
   @Export("originalWidth")
   public int originalWidth;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -943269555
   )
   @Export("originalHeight")
   public int originalHeight;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1841182519
   )
   @Export("relativeX")
   public int relativeX;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1025377605
   )
   @Export("relativeY")
   public int relativeY;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 713056063
   )
   @Export("width")
   public int width;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1423266539
   )
   @Export("height")
   public int height;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -652029943
   )
   public int field2834;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 915755037
   )
   public int field2835;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1638194267
   )
   @Export("parentId")
   public int parentId;
   @ObfuscatedName("ar")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1060447571
   )
   @Export("scrollX")
   public int scrollX;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 357743019
   )
   @Export("scrollY")
   public int scrollY;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -114053627
   )
   @Export("scrollWidth")
   public int scrollWidth;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1852015425
   )
   @Export("scrollHeight")
   public int scrollHeight;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1930717813
   )
   @Export("textColor")
   public int textColor;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2138910257
   )
   public int field2879;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1024632107
   )
   public int field2844;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1058827719
   )
   public int field2893;
   @ObfuscatedName("aa")
   @Export("filled")
   public boolean filled;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public class329 field2808;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -505326517
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1643058963
   )
   public int field2952;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -932675497
   )
   @Export("lineWidth")
   public int lineWidth;
   @ObfuscatedName("ad")
   public boolean field2851;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1199092541
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1883959941
   )
   public int field2880;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 814742207
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("bk")
   @Export("spriteTiling")
   public boolean spriteTiling;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 2084111271
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1088569003
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("bm")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("bh")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 884549769
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -663178983
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 507723869
   )
   int field2862;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1295344663
   )
   int field2876;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1623327531
   )
   public int field2838;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 406509315
   )
   public int field2865;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1526297981
   )
   public int field2866;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2006437099
   )
   public int field2867;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 89578305
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1184544451
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1450762583
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -2039357279
   )
   @Export("modelZoom")
   public int modelZoom;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1117654627
   )
   public int field2872;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 505479381
   )
   public int field2815;
   @ObfuscatedName("bl")
   public boolean field2874;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -656061939
   )
   public int field2864;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1285150211
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("bd")
   @Export("text")
   public String text;
   @ObfuscatedName("cb")
   @Export("string1")
   public String string1;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -654551917
   )
   public int field2813;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -892174819
   )
   public int field2827;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1985511707
   )
   public int field2881;
   @ObfuscatedName("ct")
   @Export("textShadowed")
   public boolean textShadowed;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 447124217
   )
   @Export("paddingX")
   public int paddingX;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -58466895
   )
   @Export("paddingY")
   public int paddingY;
   @ObfuscatedName("cr")
   @Export("xSprites")
   public int[] xSprites;
   @ObfuscatedName("co")
   public int[] field2886;
   @ObfuscatedName("cv")
   public int[] field2887;
   @ObfuscatedName("cd")
   @Export("configActions")
   public String[] configActions;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 881095157
   )
   @Export("config")
   public int config;
   @ObfuscatedName("ci")
   @Export("name")
   public String name;
   @ObfuscatedName("cc")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("dragParent")
   public Widget dragParent;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -568409323
   )
   public int field2817;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -91992637
   )
   public int field2894;
   @ObfuscatedName("cz")
   public boolean field2895;
   @ObfuscatedName("cn")
   @Export("selectedAction")
   public String selectedAction;
   @ObfuscatedName("ca")
   public boolean field2878;
   @ObfuscatedName("cf")
   public Object[] field2898;
   @ObfuscatedName("cp")
   public Object[] field2899;
   @ObfuscatedName("ck")
   public Object[] field2900;
   @ObfuscatedName("db")
   public Object[] field2901;
   @ObfuscatedName("dp")
   public Object[] field2902;
   @ObfuscatedName("da")
   @Export("mouseEnterListener")
   public Object[] mouseEnterListener;
   @ObfuscatedName("dr")
   @Export("mouseHoverListener")
   public Object[] mouseHoverListener;
   @ObfuscatedName("dj")
   @Export("mouseExitListener")
   public Object[] mouseExitListener;
   @ObfuscatedName("dh")
   public Object[] field2906;
   @ObfuscatedName("dc")
   public Object[] field2907;
   @ObfuscatedName("dl")
   public Object[] field2908;
   @ObfuscatedName("df")
   public Object[] field2807;
   @ObfuscatedName("dq")
   @Export("configListenerArgs")
   public Object[] configListenerArgs;
   @ObfuscatedName("dt")
   @Export("configTriggers")
   public int[] configTriggers;
   @ObfuscatedName("dy")
   @Export("tableListenerArgs")
   public Object[] tableListenerArgs;
   @ObfuscatedName("dn")
   @Export("tableModTriggers")
   public int[] tableModTriggers;
   @ObfuscatedName("do")
   @Export("skillListenerArgs")
   public Object[] skillListenerArgs;
   @ObfuscatedName("dw")
   @Export("skillTriggers")
   public int[] skillTriggers;
   @ObfuscatedName("dd")
   @Export("renderListener")
   public Object[] renderListener;
   @ObfuscatedName("du")
   public Object[] field2917;
   @ObfuscatedName("dk")
   @Export("scrollListener")
   public Object[] scrollListener;
   @ObfuscatedName("de")
   public Object[] field2919;
   @ObfuscatedName("dg")
   public Object[] field2920;
   @ObfuscatedName("dx")
   public Object[] field2921;
   @ObfuscatedName("di")
   public Object[] field2922;
   @ObfuscatedName("dv")
   public Object[] field2923;
   @ObfuscatedName("dz")
   public Object[] field2924;
   @ObfuscatedName("ds")
   public Object[] field2925;
   @ObfuscatedName("dm")
   public Object[] field2926;
   @ObfuscatedName("eb")
   public Object[] field2873;
   @ObfuscatedName("ek")
   public Object[] field2820;
   @ObfuscatedName("ej")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("ee")
   @Export("tableActions")
   public int[] tableActions;
   @ObfuscatedName("eu")
   public int[] field2931;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1329888515
   )
   public int field2932;
   @ObfuscatedName("ed")
   @Export("spellName")
   public String spellName;
   @ObfuscatedName("ew")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("ey")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("en")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1154993115
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1886167625
   )
   @Export("itemQuantity")
   public int itemQuantity;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -869492263
   )
   public int field2939;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -960085775
   )
   public int field2940;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "[Lig;"
   )
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("el")
   public boolean field2942;
   @ObfuscatedName("eo")
   public boolean field2875;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -28358265
   )
   public int field2944;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 2139071609
   )
   public int field2945;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1502791629
   )
   public int field2946;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -669178299
   )
   public int field2947;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1177672773
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1367805683
   )
   @Export("loopCycle")
   public int loopCycle;
   @ObfuscatedName("er")
   @Export("noClickThrough")
   public boolean noClickThrough;
   @ObfuscatedName("eh")
   public boolean field2951;

   static {
      field2811 = new NodeCache(200);
      Widget_cachedModels = new NodeCache(50);
      Widget_cachedFonts = new NodeCache(20);
      field2814 = new NodeCache(8);
      field2885 = false;
   }

   public Widget() {
      this.hasScript = false;
      this.id = -1;
      this.index = -1;
      this.field2853 = 0;
      this.contentType = 0;
      this.dynamicX = 0;
      this.dynamicY = 0;
      this.dynamicWidth = 0;
      this.buttonType = 0;
      this.originalX = 0;
      this.originalY = 0;
      this.originalWidth = 0;
      this.originalHeight = 0;
      this.relativeX = 0;
      this.relativeY = 0;
      this.width = 0;
      this.height = 0;
      this.field2834 = 1;
      this.field2835 = 1;
      this.parentId = -1;
      this.isHidden = false;
      this.scrollX = 0;
      this.scrollY = 0;
      this.scrollWidth = 0;
      this.scrollHeight = 0;
      this.textColor = 0;
      this.field2879 = 0;
      this.field2844 = 0;
      this.field2893 = 0;
      this.filled = false;
      this.field2808 = class329.field3969;
      this.opacity = 0;
      this.field2952 = 0;
      this.lineWidth = 1;
      this.field2851 = false;
      this.spriteId = -1;
      this.field2880 = -1;
      this.textureId = 0;
      this.spriteTiling = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2862 = 1;
      this.field2876 = -1;
      this.field2838 = -1;
      this.field2865 = -1;
      this.field2866 = 0;
      this.field2867 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.modelZoom = 100;
      this.field2872 = 0;
      this.field2815 = 0;
      this.field2874 = false;
      this.field2864 = 2;
      this.fontId = -1;
      this.text = "";
      this.string1 = "";
      this.field2813 = 0;
      this.field2827 = 0;
      this.field2881 = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.config = 0;
      this.name = "";
      this.dragParent = null;
      this.field2817 = 0;
      this.field2894 = 0;
      this.field2895 = false;
      this.selectedAction = "";
      this.field2878 = false;
      this.field2932 = -1;
      this.spellName = "";
      this.tooltip = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.field2939 = 0;
      this.field2940 = 0;
      this.field2942 = false;
      this.field2875 = false;
      this.field2944 = -1;
      this.field2945 = 0;
      this.field2946 = 0;
      this.field2947 = 0;
      this.boundsIndex = -1;
      this.loopCycle = -1;
      this.noClickThrough = false;
      this.field2951 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-1564236824"
   )
   @Export("decode")
   void decode(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2853 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.originalHeight = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2932 = var1.readUnsignedShort();
      if(this.field2932 == 65535) {
         this.field2932 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.tableActions = new int[var2];
         this.field2931 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.tableActions[var3] = var1.readUnsignedByte();
            this.field2931[var3] = var1.readUnsignedShort();
         }
      }

      var3 = var1.readUnsignedByte();
      int var4;
      int var5;
      int var6;
      if(var3 > 0) {
         this.dynamicValues = new int[var3][];

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var1.readUnsignedShort();
            this.dynamicValues[var4] = new int[var5];

            for(var6 = 0; var6 < var5; ++var6) {
               this.dynamicValues[var4][var6] = var1.readUnsignedShort();
               if(this.dynamicValues[var4][var6] == 65535) {
                  this.dynamicValues[var4][var6] = -1;
               }
            }
         }
      }

      if(this.type == 0) {
         this.scrollHeight = var1.readUnsignedShort();
         this.isHidden = var1.readUnsignedByte() == 1;
      }

      if(this.type == 1) {
         var1.readUnsignedShort();
         var1.readUnsignedByte();
      }

      if(this.type == 2) {
         this.itemIds = new int[this.originalWidth * this.originalHeight];
         this.itemQuantities = new int[this.originalWidth * this.originalHeight];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.config |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.config |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if(var6 == 1) {
            this.config |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.config |= 536870912;
         }

         this.paddingX = var1.readUnsignedByte();
         this.paddingY = var1.readUnsignedByte();
         this.xSprites = new int[20];
         this.field2886 = new int[20];
         this.field2887 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.xSprites[var8] = var1.readShort();
               this.field2886[var8] = var1.readShort();
               this.field2887[var8] = var1.readInt();
            } else {
               this.field2887[var8] = -1;
            }
         }

         this.configActions = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var10 = var1.readString();
            if(var10.length() > 0) {
               this.configActions[var8] = var10;
               this.config |= 1 << var8 + 23;
            }
         }
      }

      if(this.type == 3) {
         this.filled = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2827 = var1.readUnsignedByte();
         this.field2881 = var1.readUnsignedByte();
         this.field2813 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readString();
         this.string1 = var1.readString();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2879 = var1.readInt();
         this.field2844 = var1.readInt();
         this.field2893 = var1.readInt();
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.field2880 = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.field2862 = 1;
         this.field2876 = var1.readUnsignedShort();
         if(this.field2876 == 65535) {
            this.field2876 = -1;
         }

         this.field2838 = var1.readUnsignedShort();
         if(this.field2838 == 65535) {
            this.field2838 = -1;
         }

         this.field2865 = var1.readUnsignedShort();
         if(this.field2865 == 65535) {
            this.field2865 = -1;
         }

         this.modelZoom = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.originalWidth * this.originalHeight];
         this.itemQuantities = new int[this.originalWidth * this.originalHeight];
         this.field2827 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
         this.paddingX = var1.readShort();
         this.paddingY = var1.readShort();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.config |= 1073741824;
         }

         this.configActions = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var11 = var1.readString();
            if(var11.length() > 0) {
               this.configActions[var5] = var11;
               this.config |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.readString();
      }

      if(this.field2853 == 2 || this.type == 2) {
         this.selectedAction = var1.readString();
         this.spellName = var1.readString();
         var4 = var1.readUnsignedShort() & 63;
         this.config |= var4 << 11;
      }

      if(this.field2853 == 1 || this.field2853 == 4 || this.field2853 == 5 || this.field2853 == 6) {
         this.tooltip = var1.readString();
         if(this.tooltip.length() == 0) {
            if(this.field2853 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2853 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2853 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2853 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2853 == 1 || this.field2853 == 4 || this.field2853 == 5) {
         this.config |= 4194304;
      }

      if(this.field2853 == 6) {
         this.config |= 1;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "2043634892"
   )
   @Export("decodeActive")
   void decodeActive(Buffer var1) {
      var1.readUnsignedByte();
      this.hasScript = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      if(this.type == 9) {
         this.originalHeight = var1.readShort();
      } else {
         this.originalHeight = var1.readUnsignedShort();
      }

      this.dynamicWidth = var1.readByte();
      this.buttonType = var1.readByte();
      this.dynamicX = var1.readByte();
      this.dynamicY = var1.readByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = var1.readUnsignedByte() == 1;
      if(this.type == 0) {
         this.scrollWidth = var1.readUnsignedShort();
         this.scrollHeight = var1.readUnsignedShort();
         this.noClickThrough = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.textureId = var1.readUnsignedShort();
         this.spriteTiling = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
         this.borderThickness = var1.readUnsignedByte();
         this.sprite2 = var1.readInt();
         this.flippedVertically = var1.readUnsignedByte() == 1;
         this.flippedHorizontally = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.field2866 = var1.readShort();
         this.field2867 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.modelZoom = var1.readUnsignedShort();
         this.field2838 = var1.readUnsignedShort();
         if(this.field2838 == 65535) {
            this.field2838 = -1;
         }

         this.field2874 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.dynamicWidth != 0) {
            this.field2872 = var1.readUnsignedShort();
         }

         if(this.buttonType != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = var1.readString();
         this.field2813 = var1.readUnsignedByte();
         this.field2827 = var1.readUnsignedByte();
         this.field2881 = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
      }

      if(this.type == 3) {
         this.textColor = var1.readInt();
         this.filled = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.lineWidth = var1.readUnsignedByte();
         this.textColor = var1.readInt();
         this.field2851 = var1.readUnsignedByte() == 1;
      }

      this.config = var1.read24BitInt();
      this.name = var1.readString();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.readString();
         }
      }

      this.field2817 = var1.readUnsignedByte();
      this.field2894 = var1.readUnsignedByte();
      this.field2895 = var1.readUnsignedByte() == 1;
      this.selectedAction = var1.readString();
      this.field2898 = this.method4463(var1);
      this.mouseEnterListener = this.method4463(var1);
      this.mouseExitListener = this.method4463(var1);
      this.field2807 = this.method4463(var1);
      this.field2908 = this.method4463(var1);
      this.configListenerArgs = this.method4463(var1);
      this.tableListenerArgs = this.method4463(var1);
      this.skillListenerArgs = this.method4463(var1);
      this.renderListener = this.method4463(var1);
      this.field2917 = this.method4463(var1);
      this.mouseHoverListener = this.method4463(var1);
      this.field2899 = this.method4463(var1);
      this.field2900 = this.method4463(var1);
      this.field2901 = this.method4463(var1);
      this.field2902 = this.method4463(var1);
      this.field2906 = this.method4463(var1);
      this.field2907 = this.method4463(var1);
      this.scrollListener = this.method4463(var1);
      this.configTriggers = this.method4464(var1);
      this.tableModTriggers = this.method4464(var1);
      this.skillTriggers = this.method4464(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)[Ljava/lang/Object;",
      garbageValue = "1325399982"
   )
   Object[] method4463(Buffer var1) {
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
               var3[var4] = var1.readString();
            }
         }

         this.field2878 = true;
         return var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgb;I)[I",
      garbageValue = "341288288"
   )
   int[] method4464(Buffer var1) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-89"
   )
   public void method4465(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)Lla;",
      garbageValue = "1936791558"
   )
   public SpritePixels method4481(boolean var1) {
      field2885 = false;
      int var2;
      if(var1) {
         var2 = this.field2880;
      } else {
         var2 = this.spriteId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally?1L:0L) << 39) + ((this.flippedVertically?1L:0L) << 38) + ((long)this.borderThickness << 36) + (long)var2;
         SpritePixels var5 = (SpritePixels)field2811.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = class1.method1(Varcs.field1417, var2, 0);
            if(var5 == null) {
               field2885 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method5931();
               }

               if(this.flippedHorizontally) {
                  var5.method5865();
               }

               if(this.borderThickness > 0) {
                  var5.method5835(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method5838(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method5838(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method5886(this.sprite2);
               }

               field2811.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lkm;",
      garbageValue = "0"
   )
   @Export("getFont")
   public Font getFont() {
      field2885 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractSoundSystem.method2222(Varcs.field1417, SoundTaskDataProvider.field618, this.fontId, 0);
            if(var1 != null) {
               Widget_cachedFonts.put(var1, (long)this.fontId);
            } else {
               field2885 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lla;",
      garbageValue = "369132031"
   )
   public SpritePixels method4468(int var1) {
      field2885 = false;
      if(var1 >= 0 && var1 < this.field2887.length) {
         int var2 = this.field2887[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2811.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = class1.method1(Varcs.field1417, var2, 0);
               if(var3 != null) {
                  field2811.put(var3, (long)var2);
               } else {
                  field2885 = true;
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
      signature = "(Lkf;IZLif;B)Lek;",
      garbageValue = "125"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2885 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2862;
         var6 = this.field2876;
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
               var8 = ModelData.method2594(Nameable.field3824, var6, 0);
               if(var8 == null) {
                  field2885 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = class233.getNpcDefinition(var6).method5113();
               if(var8 == null) {
                  field2885 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(var4 == null) {
                  return null;
               }

               var8 = var4.method4420();
               if(var8 == null) {
                  field2885 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class81.getItemDefinition(var6);
               var8 = var9.method5082(10);
               if(var8 == null) {
                  field2885 = true;
                  return null;
               }

               var7 = var8.light(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            Widget_cachedModels.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(var1 != null) {
            var7 = var1.method5172(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)Liq;",
      garbageValue = "-1686179149"
   )
   public class236 method4470(boolean var1) {
      if(this.field2880 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2880:this.spriteId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally?1L:0L) << 39) + (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedVertically?1L:0L) << 38);
         class236 var5 = (class236)field2814.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method4481(var1);
            if(var6 == null) {
               return null;
            } else {
               SpritePixels var7 = var6.copy();
               int[] var8 = new int[var7.height];
               int[] var9 = new int[var7.height];

               for(int var10 = 0; var10 < var7.height; ++var10) {
                  int var11 = 0;
                  int var12 = var7.width;

                  int var13;
                  for(var13 = 0; var13 < var7.width; ++var13) {
                     if(var7.pixels[var13 + var10 * var7.width] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.width - 1; var13 >= var11; --var13) {
                     if(var7.pixels[var13 + var10 * var7.width] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class236(var7.width, var7.height, var9, var8, var2);
               field2814.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-114"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "682575612"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class332.field3997 = var1.readUnsignedShort();
      class90.field1360 = new int[class332.field3997];
      class153.offsetsY = new int[class332.field3997];
      class332.field3998 = new int[class332.field3997];
      GrandExchangeOffer.field294 = new int[class332.field3997];
      ClassInfo.spritePixels = new byte[class332.field3997][];
      var1.offset = var0.length - 7 - class332.field3997 * 8;
      class332.field3995 = var1.readUnsignedShort();
      class332.field3996 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class332.field3997; ++var3) {
         class90.field1360[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.field3997; ++var3) {
         class153.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.field3997; ++var3) {
         class332.field3998[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.field3997; ++var3) {
         GrandExchangeOffer.field294[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class332.field3997 * 8 - (var2 - 1) * 3;
      class332.field3994 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class332.field3994[var3] = var1.read24BitInt();
         if(class332.field3994[var3] == 0) {
            class332.field3994[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class332.field3997; ++var3) {
         int var4 = class332.field3998[var3];
         int var5 = GrandExchangeOffer.field294[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         ClassInfo.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
