import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("c")
   public static boolean field2759;
   @ObfuscatedName("u")
   static NodeCache field2647;
   @ObfuscatedName("l")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("e")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("k")
   static NodeCache field2684;
   @ObfuscatedName("g")
   static NodeCache field2783;
   @ObfuscatedName("t")
   static NodeCache field2650;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1644060259
   )
   public int field2689;
   @ObfuscatedName("co")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 881706521
   )
   @Export("parentId")
   public int parentId;
   @ObfuscatedName("eb")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("o")
   @Export("hasScript")
   public boolean hasScript;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1013409803
   )
   @Export("loopCycle")
   public int loopCycle;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 792145667
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1723636709
   )
   int field2774;
   @ObfuscatedName("cv")
   public int[] field2723;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1683177769
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1800109113
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 883752153
   )
   @Export("width")
   public int width;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -850122627
   )
   int field2699;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 589579359
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("cr")
   public boolean field2733;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1578166125
   )
   @Export("id")
   public int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1412734455
   )
   @Export("type")
   public int type;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -204227897
   )
   @Export("height")
   public int height;
   @ObfuscatedName("bn")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 806847107
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -934377297
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("em")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -114054147
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -203597509
   )
   @Export("index")
   public int index;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -803789665
   )
   public int field2658;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -647517445
   )
   public int field2640;
   @ObfuscatedName("bb")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1271249067
   )
   public int field2656;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1983285519
   )
   @Export("originalX")
   public int originalX;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1388827997
   )
   @Export("originalWidth")
   public int originalWidth;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1324568607
   )
   @Export("relativeX")
   public int relativeX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2128034497
   )
   @Export("contentType")
   public int contentType;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 565074443
   )
   @Export("buttonType")
   public int buttonType;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 270413671
   )
   public int field2659;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2104032097
   )
   @Export("originalY")
   public int originalY;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 336718587
   )
   public int field2736;
   @ObfuscatedName("aj")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -258357249
   )
   @Export("relativeY")
   public int relativeY;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1878412617
   )
   @Export("scrollX")
   public int scrollX;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 395570395
   )
   @Export("scrollWidth")
   public int scrollWidth;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 14423145
   )
   public int field2777;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1952872981
   )
   public int field2701;
   @ObfuscatedName("ej")
   @Export("tableActions")
   public int[] tableActions;
   @ObfuscatedName("et")
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1528534317
   )
   public int field2715;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1832020987
   )
   public int field2671;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1193061745
   )
   public int field2709;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1735490701
   )
   @Export("scrollY")
   public int scrollY;
   @ObfuscatedName("ew")
   public int[] field2654;
   @ObfuscatedName("ei")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1930596453
   )
   @Export("scrollHeight")
   public int scrollHeight;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -436505833
   )
   @Export("config")
   public int config;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -128872751
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -595651525
   )
   public int field2776;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -125779373
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1721579979
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1956140077
   )
   public int field2772;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1329326303
   )
   public int field2768;
   @ObfuscatedName("dq")
   public Object[] field2732;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 337531675
   )
   @Export("textColor")
   public int textColor;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1087168601
   )
   public int field2703;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 803248969
   )
   public int field2729;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1164071873
   )
   public int field2680;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -572668953
   )
   public int field2730;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 327951077
   )
   public int field2645;
   @ObfuscatedName("ah")
   public boolean field2682;
   @ObfuscatedName("an")
   public class283 field2683;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 81930697
   )
   public int field2708;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 170146837
   )
   public int field2643;
   @ObfuscatedName("af")
   public boolean field2721;
   @ObfuscatedName("ev")
   public boolean field2786;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1560048099
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("ds")
   public Object[] field2742;
   @ObfuscatedName("bd")
   public boolean field2691;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -2043993667
   )
   public int field2716;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1041682831
   )
   public int field2749;
   @ObfuscatedName("dc")
   public Object[] field2726;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -752014129
   )
   public int field2651;
   @ObfuscatedName("cq")
   public boolean field2731;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1839092245
   )
   public int field2702;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 338273353
   )
   public int field2670;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1142908975
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -750965663
   )
   @Export("paddingX")
   public int paddingX;
   @ObfuscatedName("cn")
   @Export("textShadowed")
   public boolean textShadowed;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1410042969
   )
   @Export("modelZoom")
   public int modelZoom;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 800549747
   )
   public int field2648;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1225723731
   )
   @Export("paddingY")
   public int paddingY;
   @ObfuscatedName("ck")
   @Export("xSprites")
   public int[] xSprites;
   @ObfuscatedName("be")
   public boolean field2687;
   @ObfuscatedName("ch")
   public int[] field2722;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -344205107
   )
   public int field2711;
   @ObfuscatedName("by")
   @Export(
      value = "text",
      setter = true
   )
   public String text;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1425227791
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("ca")
   public String field2686;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 461803317
   )
   @Export("itemQuantity")
   public int itemQuantity;
   @ObfuscatedName("cc")
   @Export("configActions")
   public String[] configActions;
   @ObfuscatedName("ci")
   @Export("name")
   public String name;
   @ObfuscatedName("cj")
   @Export("dragParent")
   public Widget dragParent;
   @ObfuscatedName("cg")
   @Export("selectedAction")
   public String selectedAction;
   @ObfuscatedName("ep")
   public String field2769;
   @ObfuscatedName("ez")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("eh")
   public boolean field2778;
   @ObfuscatedName("er")
   public boolean field2779;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1529360451
   )
   public int field2780;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -356295165
   )
   public int field2781;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1147629531
   )
   public int field2782;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -638534495
   )
   public int field2735;
   @ObfuscatedName("en")
   public boolean field2787;
   @ObfuscatedName("cm")
   public Object[] field2775;
   @ObfuscatedName("de")
   @Export("mouseEnterListener")
   public Object[] mouseEnterListener;
   @ObfuscatedName("db")
   @Export("mouseExitListener")
   public Object[] mouseExitListener;
   @ObfuscatedName("du")
   public Object[] field2745;
   @ObfuscatedName("dx")
   public Object[] field2744;
   @ObfuscatedName("dn")
   @Export("configListenerArgs")
   public Object[] configListenerArgs;
   @ObfuscatedName("di")
   @Export("tableListenerArgs")
   public Object[] tableListenerArgs;
   @ObfuscatedName("dr")
   @Export("skillListenerArgs")
   public Object[] skillListenerArgs;
   @ObfuscatedName("df")
   @Export("renderListener")
   public Object[] renderListener;
   @ObfuscatedName("dp")
   public Object[] field2753;
   @ObfuscatedName("dm")
   @Export("mouseHoverListener")
   public Object[] mouseHoverListener;
   @ObfuscatedName("ce")
   public Object[] field2667;
   @ObfuscatedName("cz")
   public Object[] field2675;
   @ObfuscatedName("dd")
   public Object[] field2737;
   @ObfuscatedName("dl")
   public Object[] field2738;
   @ObfuscatedName("dh")
   @Export("scrollListener")
   public Object[] scrollListener;
   @ObfuscatedName("dy")
   @Export("configTriggers")
   public int[] configTriggers;
   @ObfuscatedName("do")
   @Export("tableModTriggers")
   public int[] tableModTriggers;
   @ObfuscatedName("dz")
   @Export("skillTriggers")
   public int[] skillTriggers;
   @ObfuscatedName("dw")
   public Object[] field2755;
   @ObfuscatedName("dg")
   public Object[] field2756;
   @ObfuscatedName("dk")
   public Object[] field2757;
   @ObfuscatedName("da")
   public Object[] field2758;
   @ObfuscatedName("dj")
   public Object[] field2669;
   @ObfuscatedName("dv")
   public Object[] field2760;
   @ObfuscatedName("dt")
   public Object[] field2761;
   @ObfuscatedName("eo")
   public Object[] field2763;
   @ObfuscatedName("eg")
   public Object[] field2764;

   static {
      field2647 = new NodeCache(200);
      field2783 = new NodeCache(50);
      field2684 = new NodeCache(20);
      field2650 = new NodeCache(8);
      field2759 = false;
   }

   public Widget() {
      this.hasScript = false;
      this.id = -1;
      this.index = -1;
      this.field2656 = 0;
      this.contentType = 0;
      this.field2658 = 0;
      this.field2659 = 0;
      this.field2640 = 0;
      this.buttonType = 0;
      this.originalX = 0;
      this.originalY = 0;
      this.originalWidth = 0;
      this.field2736 = 0;
      this.relativeX = 0;
      this.relativeY = 0;
      this.width = 0;
      this.height = 0;
      this.field2715 = 1;
      this.field2671 = 1;
      this.parentId = -1;
      this.isHidden = false;
      this.scrollX = 0;
      this.scrollY = 0;
      this.scrollWidth = 0;
      this.scrollHeight = 0;
      this.textColor = 0;
      this.field2703 = 0;
      this.field2680 = 0;
      this.field2645 = 0;
      this.field2682 = false;
      this.field2683 = class283.field3769;
      this.opacity = 0;
      this.field2708 = 0;
      this.field2643 = 1;
      this.field2721 = false;
      this.spriteId = -1;
      this.field2689 = -1;
      this.textureId = 0;
      this.field2691 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2774 = 1;
      this.field2699 = -1;
      this.field2777 = -1;
      this.field2701 = -1;
      this.field2702 = 0;
      this.field2670 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.modelZoom = 100;
      this.field2648 = 0;
      this.field2709 = 0;
      this.field2687 = false;
      this.field2711 = 2;
      this.fontId = -1;
      this.text = "";
      this.field2686 = "";
      this.field2651 = 0;
      this.field2716 = 0;
      this.field2749 = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.config = 0;
      this.name = "";
      this.dragParent = null;
      this.field2729 = 0;
      this.field2730 = 0;
      this.field2731 = false;
      this.selectedAction = "";
      this.field2733 = false;
      this.field2768 = -1;
      this.field2769 = "";
      this.tooltip = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.field2772 = 0;
      this.field2776 = 0;
      this.field2778 = false;
      this.field2779 = false;
      this.field2780 = -1;
      this.field2781 = 0;
      this.field2782 = 0;
      this.field2735 = 0;
      this.boundsIndex = -1;
      this.loopCycle = -1;
      this.field2786 = false;
      this.field2787 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)LSpritePixels;",
      garbageValue = "121"
   )
   public SpritePixels method4011(boolean var1) {
      field2759 = false;
      int var2;
      if(var1) {
         var2 = this.field2689;
      } else {
         var2 = this.spriteId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((this.flippedHorizontally?1L:0L) << 39) + (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedVertically?1L:0L) << 38) + ((long)this.sprite2 << 40);
         SpritePixels var5 = (SpritePixels)field2647.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = class27.method217(class214.field2637, var2, 0);
            if(var5 == null) {
               field2759 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method4978();
               }

               if(this.flippedHorizontally) {
                  var5.method4996();
               }

               if(this.borderThickness > 0) {
                  var5.method4976(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method4979(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method4979(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method4980(this.sprite2);
               }

               field2647.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1915353826"
   )
   @Export("decode")
   void decode(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2656 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.field2736 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2768 = var1.readUnsignedShort();
      if(this.field2768 == '\uffff') {
         this.field2768 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.tableActions = new int[var2];
         this.field2654 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.tableActions[var3] = var1.readUnsignedByte();
            this.field2654[var3] = var1.readUnsignedShort();
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
               if(this.dynamicValues[var4][var6] == '\uffff') {
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
         this.itemIds = new int[this.originalWidth * this.field2736];
         this.itemQuantities = new int[this.field2736 * this.originalWidth];
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
         this.field2722 = new int[20];
         this.field2723 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.xSprites[var8] = var1.readShort();
               this.field2722[var8] = var1.readShort();
               this.field2723[var8] = var1.readInt();
            } else {
               this.field2723[var8] = -1;
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
         this.field2682 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2716 = var1.readUnsignedByte();
         this.field2749 = var1.readUnsignedByte();
         this.field2651 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readString();
         this.field2686 = var1.readString();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2703 = var1.readInt();
         this.field2680 = var1.readInt();
         this.field2645 = var1.readInt();
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.field2689 = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2774 = 1;
         this.field2699 = var1.readUnsignedShort();
         if(this.field2699 == '\uffff') {
            this.field2699 = -1;
         }

         this.field2777 = var1.readUnsignedShort();
         if(this.field2777 == '\uffff') {
            this.field2777 = -1;
         }

         this.field2701 = var1.readUnsignedShort();
         if(this.field2701 == '\uffff') {
            this.field2701 = -1;
         }

         this.modelZoom = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.field2736 * this.originalWidth];
         this.itemQuantities = new int[this.field2736 * this.originalWidth];
         this.field2716 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
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

      if(this.field2656 == 2 || this.type == 2) {
         this.selectedAction = var1.readString();
         this.field2769 = var1.readString();
         var4 = var1.readUnsignedShort() & 63;
         this.config |= var4 << 11;
      }

      if(this.field2656 == 1 || this.field2656 == 4 || this.field2656 == 5 || this.field2656 == 6) {
         this.tooltip = var1.readString();
         if(this.tooltip.length() == 0) {
            if(this.field2656 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2656 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2656 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2656 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2656 == 1 || this.field2656 == 4 || this.field2656 == 5) {
         this.config |= 4194304;
      }

      if(this.field2656 == 6) {
         this.config |= 1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1314014150"
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
         this.field2736 = var1.readShort();
      } else {
         this.field2736 = var1.readUnsignedShort();
      }

      this.field2640 = var1.readByte();
      this.buttonType = var1.readByte();
      this.field2658 = var1.readByte();
      this.field2659 = var1.readByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = var1.readUnsignedByte() == 1;
      if(this.type == 0) {
         this.scrollWidth = var1.readUnsignedShort();
         this.scrollHeight = var1.readUnsignedShort();
         this.field2786 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.textureId = var1.readUnsignedShort();
         this.field2691 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
         this.borderThickness = var1.readUnsignedByte();
         this.sprite2 = var1.readInt();
         this.flippedVertically = var1.readUnsignedByte() == 1;
         this.flippedHorizontally = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2702 = var1.readShort();
         this.field2670 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.modelZoom = var1.readUnsignedShort();
         this.field2777 = var1.readUnsignedShort();
         if(this.field2777 == '\uffff') {
            this.field2777 = -1;
         }

         this.field2687 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2640 != 0) {
            this.field2648 = var1.readUnsignedShort();
         }

         if(this.buttonType != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.text = var1.readString();
         this.field2651 = var1.readUnsignedByte();
         this.field2716 = var1.readUnsignedByte();
         this.field2749 = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
      }

      if(this.type == 3) {
         this.textColor = var1.readInt();
         this.field2682 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2643 = var1.readUnsignedByte();
         this.textColor = var1.readInt();
         this.field2721 = var1.readUnsignedByte() == 1;
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

      this.field2729 = var1.readUnsignedByte();
      this.field2730 = var1.readUnsignedByte();
      this.field2731 = var1.readUnsignedByte() == 1;
      this.selectedAction = var1.readString();
      this.field2775 = this.method3973(var1);
      this.mouseEnterListener = this.method3973(var1);
      this.mouseExitListener = this.method3973(var1);
      this.field2745 = this.method3973(var1);
      this.field2744 = this.method3973(var1);
      this.configListenerArgs = this.method3973(var1);
      this.tableListenerArgs = this.method3973(var1);
      this.skillListenerArgs = this.method3973(var1);
      this.renderListener = this.method3973(var1);
      this.field2753 = this.method3973(var1);
      this.mouseHoverListener = this.method3973(var1);
      this.field2667 = this.method3973(var1);
      this.field2675 = this.method3973(var1);
      this.field2737 = this.method3973(var1);
      this.field2738 = this.method3973(var1);
      this.field2742 = this.method3973(var1);
      this.field2726 = this.method3973(var1);
      this.scrollListener = this.method3973(var1);
      this.configTriggers = this.method3974(var1);
      this.tableModTriggers = this.method3974(var1);
      this.skillTriggers = this.method3974(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass210;",
      garbageValue = "-973123110"
   )
   public class210 method3980(boolean var1) {
      if(this.field2689 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2689:this.spriteId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedVertically?1L:0L) << 38) + ((this.flippedHorizontally?1L:0L) << 39);
         class210 var5 = (class210)field2650.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method4011(var1);
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
                     if(var7.image[var13 + var10 * var7.width] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.width - 1; var13 >= var11; --var13) {
                     if(var7.image[var13 + var7.width * var10] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class210(var7.width, var7.height, var9, var8, var2);
               field2650.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "309277874"
   )
   public Font method3977() {
      field2759 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)field2684.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = class214.field2637;
            IndexDataBase var4 = class271.field3685;
            int var5 = this.fontId;
            Font var2;
            if(!IndexData.method4200(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class286.field3795, class31.offsetsY, class286.field3797, class90.field1405, class286.field3796, class177.spritePixels);
                  class18.method138();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field2684.put(var2, (long)this.fontId);
            } else {
               field2759 = true;
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "-787324995"
   )
   public SpritePixels method3976(int var1) {
      field2759 = false;
      if(var1 >= 0 && var1 < this.field2723.length) {
         int var2 = this.field2723[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2647.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = class27.method217(class214.field2637, var2, 0);
               if(var3 != null) {
                  field2647.put(var3, (long)var2);
               } else {
                  field2759 = true;
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
      signature = "(LSequence;IZLPlayerComposition;B)LModel;",
      garbageValue = "16"
   )
   public Model method3979(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2759 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2774;
         var6 = this.field2699;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2783.get((long)(var6 + (var5 << 16)));
         if(var7 == null) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method2396(class47.field592, var6, 0);
               if(var8 == null) {
                  field2759 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = class224.getNpcDefinition(var6).method4571();
               if(var8 == null) {
                  field2759 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(var4 == null) {
                  return null;
               }

               var8 = var4.method3947();
               if(var8 == null) {
                  field2759 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class83.getItemDefinition(var6);
               var8 = var9.method4508(10);
               if(var8 == null) {
                  field2759 = true;
                  return null;
               }

               var7 = var8.light(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            field2783.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(var1 != null) {
            var7 = var1.method4629(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)[Ljava/lang/Object;",
      garbageValue = "0"
   )
   Object[] method3973(Buffer var1) {
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

         this.field2733 = true;
         return var3;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "969295290"
   )
   public void method3975(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1049862937"
   )
   public void method4002(int var1, String var2) {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[I",
      garbageValue = "1570128146"
   )
   int[] method3974(Buffer var1) {
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

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-55"
   )
   static final void method4009(int var0, int var1, int var2, int var3, int var4) {
      class226.field3142[0].method4952(var0, var1);
      class226.field3142[1].method4952(var0, var3 + var1 - 16);
      Rasterizer2D.method4921(var0, var1 + 16, 16, var3 - 32, Client.field983);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4921(var0, var6 + var1 + 16, 16, var5, Client.field974);
      Rasterizer2D.method4865(var0, var6 + var1 + 16, var5, Client.field1144);
      Rasterizer2D.method4865(var0 + 1, var6 + var1 + 16, var5, Client.field1144);
      Rasterizer2D.method4927(var0, var6 + var1 + 16, 16, Client.field1144);
      Rasterizer2D.method4927(var0, var6 + var1 + 17, 16, Client.field1144);
      Rasterizer2D.method4865(var0 + 15, var6 + var1 + 16, var5, Client.field985);
      Rasterizer2D.method4865(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field985);
      Rasterizer2D.method4927(var0, var6 + var1 + 15 + var5, 16, Client.field985);
      Rasterizer2D.method4927(var0 + 1, var5 + var1 + 14 + var6, 15, Client.field985);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-2032808093"
   )
   static boolean method4024(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
