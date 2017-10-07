import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("f")
   public static boolean field2719;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field2652;
   @ObfuscatedName("r")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field2654;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field2735;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2681;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2651;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2782;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field2759;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1130862905
   )
   public int field2683;
   @ObfuscatedName("ci")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 523966163
   )
   @Export("parentId")
   public int parentId;
   @ObfuscatedName("eo")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("j")
   @Export("hasScript")
   public boolean hasScript;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 67043481
   )
   @Export("loopCycle")
   public int loopCycle;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 422382079
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1039762885
   )
   int field2703;
   @ObfuscatedName("cn")
   public int[] field2728;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 253348859
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -184996115
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 465564697
   )
   @Export("width")
   public int width;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -439457311
   )
   int field2755;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 959682483
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("cr")
   public boolean field2785;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1783844909
   )
   @Export("id")
   public int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1797088875
   )
   @Export("type")
   public int type;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1295566703
   )
   @Export("height")
   public int height;
   @ObfuscatedName("bd")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1223024101
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -525123953
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1799240543
   )
   @Export("index")
   public int index;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 708910981
   )
   public int field2645;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2114284991
   )
   public int field2665;
   @ObfuscatedName("bn")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -562102831
   )
   public int field2661;
   @ObfuscatedName("ee")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1036899919
   )
   @Export("originalX")
   public int originalX;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1226932903
   )
   @Export("originalWidth")
   public int originalWidth;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -209137431
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 672455567
   )
   @Export("relativeX")
   public int relativeX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1618672645
   )
   @Export("contentType")
   public int contentType;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1918054421
   )
   @Export("buttonType")
   public int buttonType;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -215420925
   )
   public int field2664;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1319998847
   )
   @Export("originalY")
   public int originalY;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1898512787
   )
   public int field2670;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -870339331
   )
   @Export("relativeY")
   public int relativeY;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1847987819
   )
   @Export("scrollX")
   public int scrollX;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 438356665
   )
   @Export("scrollWidth")
   public int scrollWidth;
   @ObfuscatedName("av")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1984090477
   )
   public int field2675;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2025513383
   )
   public int field2657;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1548825553
   )
   public int field2649;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -129250099
   )
   public int field2706;
   @ObfuscatedName("es")
   @Export("tableActions")
   public int[] tableActions;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "[Lhj;"
   )
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1984650105
   )
   public int field2714;
   @ObfuscatedName("el")
   public int[] field2687;
   @ObfuscatedName("ew")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 298043615
   )
   @Export("scrollY")
   public int scrollY;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1219860915
   )
   @Export("scrollHeight")
   public int scrollHeight;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1071007993
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 101553153
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -413937187
   )
   public int field2781;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1275258513
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("dm")
   public Object[] field2767;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -2014956617
   )
   public int field2776;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1312218809
   )
   public int field2740;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 49277709
   )
   @Export("config")
   public int config;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1352238773
   )
   @Export("textColor")
   public int textColor;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 527852961
   )
   public int field2779;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1962125569
   )
   public int field2734;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1053917547
   )
   public int field2685;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1516399139
   )
   public int field2757;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1126690107
   )
   public int field2686;
   @ObfuscatedName("ax")
   public boolean field2650;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public class284 field2688;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 746071393
   )
   public int field2690;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1336748969
   )
   public int field2702;
   @ObfuscatedName("ak")
   public boolean field2723;
   @ObfuscatedName("eh")
   public boolean field2791;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1628476999
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("de")
   public Object[] field2747;
   @ObfuscatedName("bc")
   public boolean field2696;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 921474745
   )
   public int field2721;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 71614303
   )
   public int field2722;
   @ObfuscatedName("di")
   public Object[] field2748;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -18986779
   )
   public int field2720;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 916940841
   )
   public int field2707;
   @ObfuscatedName("bp")
   @Export(
      value = "text",
      setter = true
   )
   public String text;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -2055993649
   )
   public int field2708;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 78242311
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 473812629
   )
   @Export("paddingX")
   public int paddingX;
   @ObfuscatedName("cd")
   @Export("textShadowed")
   public boolean textShadowed;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1521531
   )
   @Export("modelZoom")
   public int modelZoom;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1486418043
   )
   public int field2713;
   @ObfuscatedName("cc")
   public boolean field2736;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1437240131
   )
   @Export("paddingY")
   public int paddingY;
   @ObfuscatedName("cb")
   @Export("xSprites")
   public int[] xSprites;
   @ObfuscatedName("be")
   public boolean field2715;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 187442103
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("cq")
   public int[] field2727;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1314081947
   )
   public int field2716;
   @ObfuscatedName("cz")
   public Object[] field2739;
   @ObfuscatedName("cg")
   public String field2730;
   @ObfuscatedName("ck")
   @Export("configActions")
   public String[] configActions;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -737123673
   )
   @Export("itemQuantity")
   public int itemQuantity;
   @ObfuscatedName("ca")
   @Export("name")
   public String name;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("dragParent")
   public Widget dragParent;
   @ObfuscatedName("cw")
   @Export("selectedAction")
   public String selectedAction;
   @ObfuscatedName("ek")
   public String field2774;
   @ObfuscatedName("em")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("ea")
   public boolean field2695;
   @ObfuscatedName("eu")
   public boolean field2784;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -129577795
   )
   public int field2698;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 653847615
   )
   public int field2762;
   @ObfuscatedName("dq")
   public Object[] field2765;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 906364025
   )
   public int field2711;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1362460183
   )
   public int field2718;
   @ObfuscatedName("ez")
   public boolean field2792;
   @ObfuscatedName("dt")
   public Object[] field2766;
   @ObfuscatedName("dr")
   @Export("mouseEnterListener")
   public Object[] mouseEnterListener;
   @ObfuscatedName("da")
   @Export("mouseExitListener")
   public Object[] mouseExitListener;
   @ObfuscatedName("dg")
   public Object[] field2750;
   @ObfuscatedName("dc")
   public Object[] field2749;
   @ObfuscatedName("df")
   @Export("configListenerArgs")
   public Object[] configListenerArgs;
   @ObfuscatedName("dx")
   @Export("tableListenerArgs")
   public Object[] tableListenerArgs;
   @ObfuscatedName("dd")
   @Export("skillListenerArgs")
   public Object[] skillListenerArgs;
   @ObfuscatedName("du")
   @Export("renderListener")
   public Object[] renderListener;
   @ObfuscatedName("dv")
   public Object[] field2758;
   @ObfuscatedName("dk")
   @Export("mouseHoverListener")
   public Object[] mouseHoverListener;
   @ObfuscatedName("ce")
   public Object[] field2655;
   @ObfuscatedName("cf")
   public Object[] field2741;
   @ObfuscatedName("dn")
   public Object[] field2742;
   @ObfuscatedName("do")
   public Object[] field2783;
   @ObfuscatedName("dz")
   @Export("scrollListener")
   public Object[] scrollListener;
   @ObfuscatedName("dy")
   @Export("configTriggers")
   public int[] configTriggers;
   @ObfuscatedName("ds")
   @Export("tableModTriggers")
   public int[] tableModTriggers;
   @ObfuscatedName("dp")
   @Export("skillTriggers")
   public int[] skillTriggers;
   @ObfuscatedName("dw")
   public Object[] field2760;
   @ObfuscatedName("dh")
   public Object[] field2761;
   @ObfuscatedName("dj")
   public Object[] field2653;
   @ObfuscatedName("dl")
   public Object[] field2691;
   @ObfuscatedName("db")
   public Object[] field2775;
   @ObfuscatedName("ed")
   public Object[] field2768;
   @ObfuscatedName("eb")
   public Object[] field2769;

   static {
      field2652 = new NodeCache(200);
      field2735 = new NodeCache(50);
      field2654 = new NodeCache(20);
      field2759 = new NodeCache(8);
      field2719 = false;
   }

   public Widget() {
      this.hasScript = false;
      this.id = -1;
      this.index = -1;
      this.field2661 = 0;
      this.contentType = 0;
      this.field2645 = 0;
      this.field2664 = 0;
      this.field2665 = 0;
      this.buttonType = 0;
      this.originalX = 0;
      this.originalY = 0;
      this.originalWidth = 0;
      this.field2670 = 0;
      this.relativeX = 0;
      this.relativeY = 0;
      this.width = 0;
      this.height = 0;
      this.field2675 = 1;
      this.field2657 = 1;
      this.parentId = -1;
      this.isHidden = false;
      this.scrollX = 0;
      this.scrollY = 0;
      this.scrollWidth = 0;
      this.scrollHeight = 0;
      this.textColor = 0;
      this.field2779 = 0;
      this.field2685 = 0;
      this.field2686 = 0;
      this.field2650 = false;
      this.field2688 = class284.field3781;
      this.opacity = 0;
      this.field2690 = 0;
      this.field2702 = 1;
      this.field2723 = false;
      this.spriteId = -1;
      this.field2683 = -1;
      this.textureId = 0;
      this.field2696 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2703 = 1;
      this.field2755 = -1;
      this.field2649 = -1;
      this.field2706 = -1;
      this.field2707 = 0;
      this.field2708 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.modelZoom = 100;
      this.field2713 = 0;
      this.field2714 = 0;
      this.field2715 = false;
      this.field2716 = 2;
      this.fontId = -1;
      this.text = "";
      this.field2730 = "";
      this.field2720 = 0;
      this.field2721 = 0;
      this.field2722 = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.config = 0;
      this.name = "";
      this.dragParent = null;
      this.field2734 = 0;
      this.field2757 = 0;
      this.field2736 = false;
      this.selectedAction = "";
      this.field2785 = false;
      this.field2740 = -1;
      this.field2774 = "";
      this.tooltip = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.field2776 = 0;
      this.field2781 = 0;
      this.field2695 = false;
      this.field2784 = false;
      this.field2698 = -1;
      this.field2762 = 0;
      this.field2711 = 0;
      this.field2718 = 0;
      this.boundsIndex = -1;
      this.loopCycle = -1;
      this.field2791 = false;
      this.field2792 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZB)Lkr;",
      garbageValue = "16"
   )
   public SpritePixels method4152(boolean var1) {
      field2719 = false;
      int var2;
      if(var1) {
         var2 = this.field2683;
      } else {
         var2 = this.spriteId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((this.flippedHorizontally?1L:0L) << 39) + ((this.flippedVertically?1L:0L) << 38) + ((long)this.borderThickness << 36) + (long)var2 + ((long)this.sprite2 << 40);
         SpritePixels var5 = (SpritePixels)field2652.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = AbstractSoundSystem.method2136(field2681, var2, 0);
            if(var5 == null) {
               field2719 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method5170();
               }

               if(this.flippedHorizontally) {
                  var5.method5265();
               }

               if(this.borderThickness > 0) {
                  var5.method5168(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method5171(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method5171(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method5193(this.sprite2);
               }

               field2652.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1913025382"
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
         this.field2670 = var1.readShort();
      } else {
         this.field2670 = var1.readUnsignedShort();
      }

      this.field2665 = var1.readByte();
      this.buttonType = var1.readByte();
      this.field2645 = var1.readByte();
      this.field2664 = var1.readByte();
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
         this.field2791 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.textureId = var1.readUnsignedShort();
         this.field2696 = var1.readUnsignedByte() == 1;
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

         this.field2707 = var1.readShort();
         this.field2708 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.modelZoom = var1.readUnsignedShort();
         this.field2649 = var1.readUnsignedShort();
         if(this.field2649 == '\uffff') {
            this.field2649 = -1;
         }

         this.field2715 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2665 != 0) {
            this.field2713 = var1.readUnsignedShort();
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
         this.field2720 = var1.readUnsignedByte();
         this.field2721 = var1.readUnsignedByte();
         this.field2722 = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
      }

      if(this.type == 3) {
         this.textColor = var1.readInt();
         this.field2650 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2702 = var1.readUnsignedByte();
         this.textColor = var1.readInt();
         this.field2723 = var1.readUnsignedByte() == 1;
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

      this.field2734 = var1.readUnsignedByte();
      this.field2757 = var1.readUnsignedByte();
      this.field2736 = var1.readUnsignedByte() == 1;
      this.selectedAction = var1.readString();
      this.field2739 = this.method4111(var1);
      this.mouseEnterListener = this.method4111(var1);
      this.mouseExitListener = this.method4111(var1);
      this.field2750 = this.method4111(var1);
      this.field2749 = this.method4111(var1);
      this.configListenerArgs = this.method4111(var1);
      this.tableListenerArgs = this.method4111(var1);
      this.skillListenerArgs = this.method4111(var1);
      this.renderListener = this.method4111(var1);
      this.field2758 = this.method4111(var1);
      this.mouseHoverListener = this.method4111(var1);
      this.field2655 = this.method4111(var1);
      this.field2741 = this.method4111(var1);
      this.field2742 = this.method4111(var1);
      this.field2783 = this.method4111(var1);
      this.field2747 = this.method4111(var1);
      this.field2748 = this.method4111(var1);
      this.scrollListener = this.method4111(var1);
      this.configTriggers = this.method4139(var1);
      this.tableModTriggers = this.method4139(var1);
      this.skillTriggers = this.method4139(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "56"
   )
   @Export("decode")
   void decode(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2661 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.field2670 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2740 = var1.readUnsignedShort();
      if(this.field2740 == '\uffff') {
         this.field2740 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.tableActions = new int[var2];
         this.field2687 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.tableActions[var3] = var1.readUnsignedByte();
            this.field2687[var3] = var1.readUnsignedShort();
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
         this.itemIds = new int[this.field2670 * this.originalWidth];
         this.itemQuantities = new int[this.originalWidth * this.field2670];
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
         this.field2727 = new int[20];
         this.field2728 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.xSprites[var8] = var1.readShort();
               this.field2727[var8] = var1.readShort();
               this.field2728[var8] = var1.readInt();
            } else {
               this.field2728[var8] = -1;
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
         this.field2650 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2721 = var1.readUnsignedByte();
         this.field2722 = var1.readUnsignedByte();
         this.field2720 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readString();
         this.field2730 = var1.readString();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2779 = var1.readInt();
         this.field2685 = var1.readInt();
         this.field2686 = var1.readInt();
      }

      if(this.type == 5) {
         this.spriteId = var1.readInt();
         this.field2683 = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2703 = 1;
         this.field2755 = var1.readUnsignedShort();
         if(this.field2755 == '\uffff') {
            this.field2755 = -1;
         }

         this.field2649 = var1.readUnsignedShort();
         if(this.field2649 == '\uffff') {
            this.field2649 = -1;
         }

         this.field2706 = var1.readUnsignedShort();
         if(this.field2706 == '\uffff') {
            this.field2706 = -1;
         }

         this.modelZoom = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.originalWidth * this.field2670];
         this.itemQuantities = new int[this.field2670 * this.originalWidth];
         this.field2721 = var1.readUnsignedByte();
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

      if(this.field2661 == 2 || this.type == 2) {
         this.selectedAction = var1.readString();
         this.field2774 = var1.readString();
         var4 = var1.readUnsignedShort() & 63;
         this.config |= var4 << 11;
      }

      if(this.field2661 == 1 || this.field2661 == 4 || this.field2661 == 5 || this.field2661 == 6) {
         this.tooltip = var1.readString();
         if(this.tooltip.length() == 0) {
            if(this.field2661 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2661 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2661 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2661 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2661 == 1 || this.field2661 == 4 || this.field2661 == 5) {
         this.config |= 4194304;
      }

      if(this.field2661 == 6) {
         this.config |= 1;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)Lhu;",
      garbageValue = "104"
   )
   public class210 method4117(boolean var1) {
      if(this.field2683 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2683:this.spriteId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally?1L:0L) << 39) + ((this.flippedVertically?1L:0L) << 38) + (long)var2 + ((long)this.borderThickness << 36);
         class210 var5 = (class210)field2759.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method4152(var1);
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
                     if(var7.image[var10 * var7.width + var13] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class210(var7.width, var7.height, var9, var8, var2);
               field2759.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lju;",
      garbageValue = "-1490748058"
   )
   public Font method4122() {
      field2719 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)field2654.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field2681;
            IndexDataBase var4 = field2651;
            int var5 = this.fontId;
            Font var2;
            if(!class249.method4517(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class287.field3807, World.offsetsY, class236.field3238, FileSystem.field3207, class181.field2456, class208.spritePixels);
                  Actor.method1605();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field2654.put(var2, (long)this.fontId);
            } else {
               field2719 = true;
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljl;IZLhv;I)Leb;",
      garbageValue = "1766589163"
   )
   public Model method4146(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2719 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2703;
         var6 = this.field2755;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2735.get((long)(var6 + (var5 << 16)));
         if(var7 == null) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method2498(field2782, var6, 0);
               if(var8 == null) {
                  field2719 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = class72.getNpcDefinition(var6).method4744();
               if(var8 == null) {
                  field2719 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(var4 == null) {
                  return null;
               }

               var8 = var4.method4086();
               if(var8 == null) {
                  field2719 = true;
                  return null;
               }

               var7 = var8.light(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class46.getItemDefinition(var6);
               var8 = var9.method4712(10);
               if(var8 == null) {
                  field2719 = true;
                  return null;
               }

               var7 = var8.light(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            field2735.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(var1 != null) {
            var7 = var1.method4802(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lkr;",
      garbageValue = "928662372"
   )
   public SpritePixels method4115(int var1) {
      field2719 = false;
      if(var1 >= 0 && var1 < this.field2728.length) {
         int var2 = this.field2728[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2652.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = AbstractSoundSystem.method2136(field2681, var2, 0);
               if(var3 != null) {
                  field2652.put(var3, (long)var2);
               } else {
                  field2719 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfg;I)[Ljava/lang/Object;",
      garbageValue = "704353134"
   )
   Object[] method4111(Buffer var1) {
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

         this.field2785 = true;
         return var3;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfg;I)[I",
      garbageValue = "239526849"
   )
   int[] method4139(Buffer var1) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1547822066"
   )
   public void method4118(int var1, String var2) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "809587940"
   )
   public void method4113(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)Lkr;",
      garbageValue = "1916529028"
   )
   public static final SpritePixels method4157(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }
}
