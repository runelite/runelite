import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1187188727
   )
   public int field2057;
   @ObfuscatedName("df")
   public Object[] field2058;
   @ObfuscatedName("m")
   static class182 field2059;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 952929543
   )
   public int field2060;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1676778291
   )
   public int field2061 = 1;
   @ObfuscatedName("r")
   static class182 field2062;
   @ObfuscatedName("c")
   static NodeCache field2063 = new NodeCache(200);
   @ObfuscatedName("p")
   static NodeCache field2064 = new NodeCache(50);
   @ObfuscatedName("ah")
   public class221 field2065;
   @ObfuscatedName("h")
   static class182 field2066;
   @ObfuscatedName("q")
   public static boolean field2067 = false;
   @ObfuscatedName("l")
   public boolean field2068 = false;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1109301929
   )
   @Export("id")
   public int id = -1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1945297385
   )
   public int field2070;
   @ObfuscatedName("w")
   static class182 field2071;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -224175581
   )
   public int field2072 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1081927075
   )
   @Export("contentType")
   public int contentType = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 923331509
   )
   public int field2074 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 772946849
   )
   public int field2075 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 239961417
   )
   public int field2076 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1256279505
   )
   public int field2077 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1355385585
   )
   public int field2078 = 0;
   @ObfuscatedName("dw")
   public int[] field2079;
   @ObfuscatedName("cc")
   public String[] field2080;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1978088433
   )
   public int field2081 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1682352945
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1338969381
   )
   @Export("relativeY")
   public int relativeY = 0;
   @ObfuscatedName("ac")
   @Export("isHidden")
   public boolean isHidden = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 321766519
   )
   @Export("height")
   public int height = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 2116384787
   )
   public int field2086;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2033044237
   )
   public int field2087 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 228632765
   )
   @Export("parentId")
   public int parentId = -1;
   @ObfuscatedName("dp")
   public int[] field2089;
   @ObfuscatedName("cu")
   @Export("parent")
   public Widget parent;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1070522449
   )
   @Export("scrollY")
   public int scrollY = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1679067935
   )
   @Export("scrollWidth")
   public int scrollWidth = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 330907229
   )
   @Export("scrollHeight")
   public int scrollHeight = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2142409617
   )
   @Export("textColor")
   public int textColor = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1015057301
   )
   public int field2095 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -180243845
   )
   public int field2096 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 69550153
   )
   public int field2097 = 0;
   @ObfuscatedName("ad")
   public boolean field2098 = false;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1550470281
   )
   @Export("relativeX")
   public int relativeX = 0;
   @ObfuscatedName("dd")
   public Object[] field2100;
   @ObfuscatedName("g")
   static NodeCache field2101 = new NodeCache(20);
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 362365567
   )
   public int field2102;
   @ObfuscatedName("at")
   public boolean field2103;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -971576375
   )
   @Export("item")
   public int item;
   @ObfuscatedName("dc")
   public Object[] field2105;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1095681367
   )
   public int field2106;
   @ObfuscatedName("aj")
   public boolean field2107;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -523849921
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -524542639
   )
   @Export("width")
   public int width = 0;
   @ObfuscatedName("bt")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("bv")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1614723001
   )
   public int field2112;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1217768391
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1090457329
   )
   int field2114;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -887658515
   )
   int field2115;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 494113099
   )
   public int field2116;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1319005167
   )
   public int field2117;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1560467031
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -368974571
   )
   public int field2119;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1402818557
   )
   public int field2120;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -548577869
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 368575149
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1256809445
   )
   @Export("index")
   public int index = -1;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -509190657
   )
   public int field2124;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 592648359
   )
   public int field2125;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 30858893
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1596584567
   )
   public int field2127;
   @ObfuscatedName("el")
   public boolean field2128;
   @ObfuscatedName("cw")
   public int[] field2129;
   @ObfuscatedName("bs")
   public String field2130;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -2067874833
   )
   public int field2131;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1098855905
   )
   public int field2132;
   @ObfuscatedName("ec")
   public String field2133;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 144139121
   )
   public int field2134;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 2117636101
   )
   public int field2135;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -951710501
   )
   public int field2136;
   @ObfuscatedName("cg")
   public int[] field2137;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 110036207
   )
   public int field2138 = 1;
   @ObfuscatedName("ca")
   public int[] field2139;
   @ObfuscatedName("bg")
   public boolean field2140;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -122353825
   )
   public int field2141;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 203378257
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("dk")
   public int[] field2143;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1482284425
   )
   public int field2144 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -18107029
   )
   public int field2145;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 61432117
   )
   public int field2146;
   @ObfuscatedName("cq")
   public boolean field2147;
   @ObfuscatedName("cr")
   public String field2148;
   @ObfuscatedName("cv")
   public boolean field2149;
   @ObfuscatedName("cy")
   @Export("name")
   public String name;
   @ObfuscatedName("cl")
   public Object[] field2151;
   @ObfuscatedName("co")
   public Object[] field2152;
   @ObfuscatedName("ct")
   public Object[] field2153;
   @ObfuscatedName("cf")
   public Object[] field2154;
   @ObfuscatedName("cx")
   public Object[] field2155;
   @ObfuscatedName("cn")
   public Object[] field2156;
   @ObfuscatedName("ci")
   public Object[] field2157;
   @ObfuscatedName("de")
   public Object[] field2158;
   @ObfuscatedName("cp")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("dj")
   public Object[] field2160;
   @ObfuscatedName("da")
   public Object[] field2161;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -638407393
   )
   @Export("type")
   public int type;
   @ObfuscatedName("cm")
   public Object[] field2163;
   @ObfuscatedName("do")
   public Object[] field2164;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -500778255
   )
   @Export("scrollX")
   public int itemId = 0;
   @ObfuscatedName("dr")
   public Object[] field2166;
   @ObfuscatedName("dl")
   public Object[] field2167;
   @ObfuscatedName("db")
   public Object[] field2168;
   @ObfuscatedName("dq")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("dy")
   public Object[] field2170;
   @ObfuscatedName("ds")
   public Object[] field2171;
   @ObfuscatedName("n")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("bw")
   public boolean field2173;
   @ObfuscatedName("du")
   public Object[] field2174;
   @ObfuscatedName("dz")
   public Object[] field2175;
   @ObfuscatedName("dg")
   public Object[] field2176;
   @ObfuscatedName("dv")
   public Object[] field2177;
   @ObfuscatedName("dm")
   public Object[] field2178;
   @ObfuscatedName("d")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("di")
   public Object[] field2180;
   @ObfuscatedName("dh")
   public int[] field2181;
   @ObfuscatedName("dn")
   public Object[] field2182;
   @ObfuscatedName("dx")
   public int[] field2183;
   @ObfuscatedName("eo")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("bq")
   @Export("text")
   public String text;
   @ObfuscatedName("et")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("es")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1126083263
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("dt")
   public Object[] field2189;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -697429855
   )
   public int field2190;
   @ObfuscatedName("z")
   static NodeCache field2191 = new NodeCache(8);
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 615057881
   )
   public int field2192;
   @ObfuscatedName("ei")
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("ee")
   public boolean field2194;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -890212039
   )
   @Export("stackSize")
   public int stackSize;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 599185427
   )
   public int field2196;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 18369771
   )
   public int field2197;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 1845972945
   )
   public int field2198;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1224025383
   )
   public int field2199;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1079226149
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1483698473
   )
   public int field2201;
   @ObfuscatedName("eg")
   public boolean field2202;
   @ObfuscatedName("ep")
   public boolean field2203;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "-13"
   )
   static final void method2836(Actor var0) {
      if(Client.gameCycle == var0.field642 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field595 > class9.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field642 - var0.field648;
         int var2 = Client.gameCycle - var0.field648;
         int var3 = var0.field637 * 128 + var0.field599 * 64;
         int var4 = var0.field599 * 64 + var0.field639 * 128;
         int var5 = var0.field638 * 128 + var0.field599 * 64;
         int var6 = var0.field599 * 64 + var0.field640 * 128;
         var0.x = (var2 * var5 + (var1 - var2) * var3) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field634 = 0;
      var0.field646 = var0.field643;
      var0.angle = var0.field646;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1530194197"
   )
   void method2838(Buffer var1) {
      var1.readUnsignedByte();
      this.field2068 = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.field2078 = var1.method2993();
      this.field2087 = var1.method2993();
      this.field2144 = var1.readUnsignedShort();
      if(this.type == 9) {
         this.field2081 = var1.method2993();
      } else {
         this.field2081 = var1.readUnsignedShort();
      }

      this.field2076 = var1.method3047();
      this.field2077 = var1.method3047();
      this.field2074 = var1.method3047();
      this.field2075 = var1.method3047();
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
         this.field2202 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.textureId = var1.method2995();
         this.field2106 = var1.readUnsignedShort();
         this.field2107 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
         this.borderThickness = var1.readUnsignedByte();
         this.sprite2 = var1.method2995();
         this.flippedVertically = var1.readUnsignedByte() == 1;
         this.flippedHorizontally = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2131 = var1.method2993();
         this.field2119 = var1.method2993();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.field2134 = var1.readUnsignedShort();
         this.field2116 = var1.readUnsignedShort();
         if(this.field2116 == '\uffff') {
            this.field2116 = -1;
         }

         this.field2140 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2076 != 0) {
            this.field2124 = var1.readUnsignedShort();
         }

         if(this.field2077 != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.field2190 = var1.readUnsignedShort();
         if(this.field2190 == '\uffff') {
            this.field2190 = -1;
         }

         this.text = var1.method3057();
         this.field2086 = var1.readUnsignedByte();
         this.field2132 = var1.readUnsignedByte();
         this.field2070 = var1.readUnsignedByte();
         this.field2173 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method2995();
      }

      if(this.type == 3) {
         this.textColor = var1.method2995();
         this.field2098 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2102 = var1.readUnsignedByte();
         this.textColor = var1.method2995();
         this.field2103 = var1.readUnsignedByte() == 1;
      }

      this.field2141 = var1.read24BitInt();
      this.name = var1.method3057();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.method3057();
         }
      }

      this.field2125 = var1.readUnsignedByte();
      this.field2146 = var1.readUnsignedByte();
      this.field2147 = var1.readUnsignedByte() == 1;
      this.field2148 = var1.method3057();
      this.field2163 = this.method2868(var1);
      this.field2155 = this.method2868(var1);
      this.field2157 = this.method2868(var1);
      this.field2161 = this.method2868(var1);
      this.field2160 = this.method2868(var1);
      this.field2189 = this.method2868(var1);
      this.field2164 = this.method2868(var1);
      this.field2166 = this.method2868(var1);
      this.field2168 = this.method2868(var1);
      this.field2178 = this.method2868(var1);
      this.field2156 = this.method2868(var1);
      this.field2151 = this.method2868(var1);
      this.field2152 = this.method2868(var1);
      this.field2153 = this.method2868(var1);
      this.field2154 = this.method2868(var1);
      this.field2158 = this.method2868(var1);
      this.field2058 = this.method2868(var1);
      this.field2170 = this.method2868(var1);
      this.field2079 = this.method2840(var1);
      this.field2143 = this.method2840(var1);
      this.field2089 = this.method2840(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[I",
      garbageValue = "1812004754"
   )
   int[] method2840(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.method2995();
         }

         return var3;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1650956316"
   )
   public void method2841(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZB)LSpritePixels;",
      garbageValue = "-112"
   )
   public SpritePixels method2842(boolean var1) {
      field2067 = false;
      int var2;
      if(var1) {
         var2 = this.field2060;
      } else {
         var2 = this.textureId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedVertically?1L:0L) << 38) + ((this.flippedHorizontally?1L:0L) << 39) + ((long)this.sprite2 << 40);
         SpritePixels var5 = (SpritePixels)field2063.get(var3);
         if(null != var5) {
            return var5;
         } else {
            var5 = class207.method3894(field2071, var2, 0);
            if(var5 == null) {
               field2067 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method4220();
               }

               if(this.flippedHorizontally) {
                  var5.method4236();
               }

               if(this.borderThickness > 0) {
                  var5.method4218(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method4276(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method4276(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method4189(this.sprite2);
               }

               field2063.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass208;",
      garbageValue = "-779092800"
   )
   public class208 method2843() {
      field2067 = false;
      if(this.field2190 == -1) {
         return null;
      } else {
         class208 var1 = (class208)field2101.get((long)this.field2190);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class186.method3474(field2071, field2062, this.field2190, 0);
            if(var1 != null) {
               field2101.put(var1, (long)this.field2190);
            } else {
               field2067 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "1179258023"
   )
   public SpritePixels method2844(int var1) {
      field2067 = false;
      if(var1 >= 0 && var1 < this.field2139.length) {
         int var2 = this.field2139[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2063.get((long)var2);
            if(null != var3) {
               return var3;
            } else {
               var3 = class207.method3894(field2071, var2, 0);
               if(var3 != null) {
                  field2063.put(var3, (long)var2);
               } else {
                  field2067 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LSequence;IZLPlayerComposition;I)LModel;",
      garbageValue = "1656030758"
   )
   public Model method2845(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2067 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2114;
         var6 = this.field2115;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2064.get((long)(var6 + (var5 << 16)));
         if(null == var7) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method1491(field2066, var6, 0);
               if(var8 == null) {
                  field2067 = true;
                  return null;
               }

               var7 = var8.method1512(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = class152.getNpcDefinition(var6).method3748();
               if(null == var8) {
                  field2067 = true;
                  return null;
               }

               var7 = var8.method1512(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(null == var4) {
                  return null;
               }

               var8 = var4.method2800();
               if(var8 == null) {
                  field2067 = true;
                  return null;
               }

               var7 = var8.method1512(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class18.getItemDefinition(var6);
               var8 = var9.method3737(10);
               if(null == var8) {
                  field2067 = true;
                  return null;
               }

               var7 = var8.method1512(64 + var9.field2965, 768 + var9.field2985, -50, -10, -50);
            }

            field2064.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(var1 != null) {
            var7 = var1.method3823(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass145;",
      garbageValue = "-1889619359"
   )
   public class145 method2846(boolean var1) {
      if(this.field2060 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2060:this.textureId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedVertically?1L:0L) << 38) + (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedHorizontally?1L:0L) << 39);
         class145 var5 = (class145)field2191.get(var3);
         if(null != var5) {
            return var5;
         } else {
            SpritePixels var6 = this.method2842(var1);
            if(null == var6) {
               return null;
            } else {
               SpritePixels var7 = var6.method4181();
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

               var5 = new class145(var7.width, var7.height, var9, var8, var2);
               field2191.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1562694552"
   )
   public void method2847(int var1, String var2) {
      if(null == this.actions || this.actions.length <= var1) {
         String[] var3 = new String[1 + var1];
         if(null != this.actions) {
            for(int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[var1] = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "122"
   )
   void method2854(Buffer var1) {
      this.field2068 = false;
      this.type = var1.readUnsignedByte();
      this.field2072 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.field2078 = var1.method2993();
      this.field2087 = var1.method2993();
      this.field2144 = var1.readUnsignedShort();
      this.field2081 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2120 = var1.readUnsignedShort();
      if(this.field2120 == '\uffff') {
         this.field2120 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.field2181 = new int[var2];
         this.field2183 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field2181[var3] = var1.readUnsignedByte();
            this.field2183[var3] = var1.readUnsignedShort();
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
         this.itemIds = new int[this.field2144 * this.field2081];
         this.itemQuantities = new int[this.field2081 * this.field2144];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2141 |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.field2141 |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if(var6 == 1) {
            this.field2141 |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.field2141 |= 536870912;
         }

         this.field2135 = var1.readUnsignedByte();
         this.field2136 = var1.readUnsignedByte();
         this.field2137 = new int[20];
         this.field2129 = new int[20];
         this.field2139 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.field2137[var8] = var1.method2993();
               this.field2129[var8] = var1.method2993();
               this.field2139[var8] = var1.method2995();
            } else {
               this.field2139[var8] = -1;
            }
         }

         this.field2080 = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var10 = var1.method3057();
            if(var10.length() > 0) {
               this.field2080[var8] = var10;
               this.field2141 |= 1 << var8 + 23;
            }
         }
      }

      if(this.type == 3) {
         this.field2098 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2132 = var1.readUnsignedByte();
         this.field2070 = var1.readUnsignedByte();
         this.field2086 = var1.readUnsignedByte();
         this.field2190 = var1.readUnsignedShort();
         if(this.field2190 == '\uffff') {
            this.field2190 = -1;
         }

         this.field2173 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.method3057();
         this.field2130 = var1.method3057();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.method2995();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2095 = var1.method2995();
         this.field2096 = var1.method2995();
         this.field2097 = var1.method2995();
      }

      if(this.type == 5) {
         this.textureId = var1.method2995();
         this.field2060 = var1.method2995();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2114 = 1;
         this.field2115 = var1.readUnsignedShort();
         if(this.field2115 == '\uffff') {
            this.field2115 = -1;
         }

         this.field2116 = var1.readUnsignedShort();
         if(this.field2116 == '\uffff') {
            this.field2116 = -1;
         }

         this.field2117 = var1.readUnsignedShort();
         if(this.field2117 == '\uffff') {
            this.field2117 = -1;
         }

         this.field2134 = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.field2081 * this.field2144];
         this.itemQuantities = new int[this.field2144 * this.field2081];
         this.field2132 = var1.readUnsignedByte();
         this.field2190 = var1.readUnsignedShort();
         if(this.field2190 == '\uffff') {
            this.field2190 = -1;
         }

         this.field2173 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method2995();
         this.field2135 = var1.method2993();
         this.field2136 = var1.method2993();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2141 |= 1073741824;
         }

         this.field2080 = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var11 = var1.method3057();
            if(var11.length() > 0) {
               this.field2080[var5] = var11;
               this.field2141 |= 1 << 23 + var5;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.method3057();
      }

      if(this.field2072 == 2 || this.type == 2) {
         this.field2148 = var1.method3057();
         this.field2133 = var1.method3057();
         var4 = var1.readUnsignedShort() & 63;
         this.field2141 |= var4 << 11;
      }

      if(this.field2072 == 1 || this.field2072 == 4 || this.field2072 == 5 || this.field2072 == 6) {
         this.tooltip = var1.method3057();
         if(this.tooltip.length() == 0) {
            if(this.field2072 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2072 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2072 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2072 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2072 == 1 || this.field2072 == 4 || this.field2072 == 5) {
         this.field2141 |= 4194304;
      }

      if(this.field2072 == 6) {
         this.field2141 |= 1;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[Ljava/lang/Object;",
      garbageValue = "1112359742"
   )
   Object[] method2868(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if(var5 == 0) {
               var3[var4] = new Integer(var1.method2995());
            } else if(var5 == 1) {
               var3[var4] = var1.method3057();
            }
         }

         this.field2149 = true;
         return var3;
      }
   }

   public Widget() {
      this.field2065 = class221.field3180;
      this.opacity = 0;
      this.field2145 = 0;
      this.field2102 = 1;
      this.field2103 = false;
      this.textureId = -1;
      this.field2060 = -1;
      this.field2106 = 0;
      this.field2107 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2114 = 1;
      this.field2115 = -1;
      this.field2116 = -1;
      this.field2117 = -1;
      this.field2131 = 0;
      this.field2119 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.field2134 = 100;
      this.field2124 = 0;
      this.field2112 = 0;
      this.field2140 = false;
      this.field2127 = 2;
      this.field2190 = -1;
      this.text = "";
      this.field2130 = "";
      this.field2086 = 0;
      this.field2132 = 0;
      this.field2070 = 0;
      this.field2173 = false;
      this.field2135 = 0;
      this.field2136 = 0;
      this.field2141 = 0;
      this.name = "";
      this.parent = null;
      this.field2125 = 0;
      this.field2146 = 0;
      this.field2147 = false;
      this.field2148 = "";
      this.field2149 = false;
      this.field2120 = -1;
      this.field2133 = "";
      this.tooltip = "Ok";
      this.item = -1;
      this.stackSize = 0;
      this.field2057 = 0;
      this.field2192 = 0;
      this.field2194 = false;
      this.field2128 = false;
      this.field2196 = -1;
      this.field2197 = 0;
      this.field2198 = 0;
      this.field2199 = 0;
      this.boundsIndex = -1;
      this.field2201 = -1;
      this.field2202 = false;
      this.field2203 = false;
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "-96"
   )
   static final int method2893(Widget var0, int var1) {
      if(null != var0.dynamicValues && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class5.method79(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class18.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class146.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2362[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class146.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class40.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2364[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class5.method79(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class18.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class146.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class37.method765(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class16.baseX + (class40.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (class40.localPlayer.y >> 7) + Client.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;Lclass208;ZB)V",
      garbageValue = "-102"
   )
   static void method2894(class208 var0, class208 var1, class208 var2, boolean var3) {
      if(var3) {
         class41.field848 = (class16.field169 - Client.field500) / 2;
         class41.loginWindowX = class41.field848 + 202;
      }

      if(class41.worldSelectShown) {
         class33.method712(var0, var1);
      } else {
         if(var3) {
            class41.field821.method4190(class41.field848, 0);
            class41.field822.method4190(382 + class41.field848, 0);
            class41.field823.method4146(382 + class41.field848 - class41.field823.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3907("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class219.method4053(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            class219.method4053(class41.loginWindowX + 180 - 151, 1 + var5, 302, 32, 0);
            class219.method4071(class41.loginWindowX + 180 - 150, 2 + var5, class41.field833 * 3, 30, 9179409);
            class219.method4071(class41.field833 * 3 + (class41.loginWindowX + 180 - 150), var5 + 2, 300 - class41.field833 * 3, 30, 0);
            var0.method3907(class41.field826, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var6;
         short var19;
         int var20;
         short var21;
         if(Client.gameState == 20) {
            class41.field818.method4146(class41.loginWindowX + 180 - class41.field818.originalWidth / 2, 271 - class41.field818.height / 2);
            var19 = 211;
            var0.method3907(class41.loginMessage1, 180 + class41.loginWindowX, var19, 16776960, 0);
            var20 = var19 + 15;
            var0.method3907(class41.loginMessage2, class41.loginWindowX + 180, var20, 16776960, 0);
            var20 += 15;
            var0.method3907(class41.loginMessage3, 180 + class41.loginWindowX, var20, 16776960, 0);
            var20 += 15;
            var20 += 10;
            if(class41.loginIndex != 4) {
               var0.method3920("Login: ", 180 + class41.loginWindowX - 110, var20, 16777215, 0);
               var21 = 200;

               for(var6 = class41.username; var0.method3912(var6) > var21; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3920(class209.method3979(var6), class41.loginWindowX + 180 - 70, var20, 16777215, 0);
               var20 += 15;
               var0.method3920("Password: " + class60.method1140(class41.field834), 180 + class41.loginWindowX - 108, var20, 16777215, 0);
               var20 += 15;
            }
         }

         int var7;
         int var22;
         int var25;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field818.method4146(class41.loginWindowX, 171);
            short var15;
            if(class41.loginIndex == 0) {
               var19 = 251;
               var0.method3907("Welcome to RuneScape", class41.loginWindowX + 180, var19, 16776960, 0);
               var20 = var19 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var15 = 291;
               class41.field819.method4146(var5 - 73, var15 - 20);
               var0.method3921("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field819.method4146(var5 - 73, var15 - 20);
               var0.method3921("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3907(class41.field836, class41.loginWindowX + 180, 211, 16776960, 0);
               var19 = 236;
               var0.method3907(class41.loginMessage1, 180 + class41.loginWindowX, var19, 16777215, 0);
               var20 = var19 + 15;
               var0.method3907(class41.loginMessage2, class41.loginWindowX + 180, var20, 16777215, 0);
               var20 += 15;
               var0.method3907(class41.loginMessage3, class41.loginWindowX + 180, var20, 16777215, 0);
               var20 += 15;
               var5 = 180 + class41.loginWindowX - 80;
               var15 = 321;
               class41.field819.method4146(var5 - 73, var15 - 20);
               var0.method3907("Continue", var5, var15 + 5, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field819.method4146(var5 - 73, var15 - 20);
               var0.method3907("Cancel", var5, 5 + var15, 16777215, 0);
            } else {
               short var8;
               if(class41.loginIndex == 2) {
                  var19 = 211;
                  var0.method3907(class41.loginMessage1, class41.loginWindowX + 180, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var0.method3907(class41.loginMessage2, 180 + class41.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var0.method3907(class41.loginMessage3, 180 + class41.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var20 += 10;
                  var0.method3920("Login: ", class41.loginWindowX + 180 - 110, var20, 16777215, 0);
                  var21 = 200;

                  for(var6 = class41.username; var0.method3912(var6) > var21; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3920(class209.method3979(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class13.method182(16776960) + "|":""), class41.loginWindowX + 180 - 70, var20, 16777215, 0);
                  var20 += 15;
                  var0.method3920("Password: " + class60.method1140(class41.field834) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class13.method182(16776960) + "|":""), 180 + class41.loginWindowX - 108, var20, 16777215, 0);
                  var20 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  class41.field819.method4146(var7 - 73, var8 - 20);
                  var0.method3907("Login", var7, 5 + var8, 16777215, 0);
                  var7 = class41.loginWindowX + 180 + 80;
                  class41.field819.method4146(var7 - 73, var8 - 20);
                  var0.method3907("Cancel", var7, var8 + 5, 16777215, 0);
                  var19 = 357;
                  var1.method3907("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var19, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var19 = 201;
                  var0.method3907("Invalid username or password.", 180 + class41.loginWindowX, var19, 16776960, 0);
                  var20 = var19 + 20;
                  var1.method3907("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var1.method3907("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var15 = 276;
                  class41.field819.method4146(var5 - 73, var15 - 20);
                  var2.method3907("Try again", var5, 5 + var15, 16777215, 0);
                  var5 = 180 + class41.loginWindowX;
                  var15 = 326;
                  class41.field819.method4146(var5 - 73, var15 - 20);
                  var2.method3907("Forgotten password?", var5, 5 + var15, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3907("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
                  var19 = 236;
                  var0.method3907(class41.loginMessage1, class41.loginWindowX + 180, var19, 16777215, 0);
                  var20 = var19 + 15;
                  var0.method3907(class41.loginMessage2, class41.loginWindowX + 180, var20, 16777215, 0);
                  var20 += 15;
                  var0.method3907(class41.loginMessage3, 180 + class41.loginWindowX, var20, 16777215, 0);
                  var20 += 15;
                  var0.method3920("PIN: " + class60.method1140(class22.authCode) + (Client.gameCycle % 40 < 20?class13.method182(16776960) + "|":""), 180 + class41.loginWindowX - 108, var20, 16777215, 0);
                  var20 -= 8;
                  var0.method3920("Trust this computer", 180 + class41.loginWindowX - 9, var20, 16776960, 0);
                  var20 += 15;
                  var0.method3920("for 30 days: ", class41.loginWindowX + 180 - 9, var20, 16776960, 0);
                  var5 = class41.loginWindowX + 180 - 9 + var0.method3912("for 30 days: ") + 15;
                  var25 = var20 - var0.field3091;
                  ModIcon var16;
                  if(class41.field843) {
                     var16 = class6.field56;
                  } else {
                     var16 = class8.field69;
                  }

                  var16.method4146(var5, var25);
                  var20 += 15;
                  var22 = class41.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class41.field819.method4146(var22 - 73, var9 - 20);
                  var0.method3907("Continue", var22, 5 + var9, 16777215, 0);
                  var22 = class41.loginWindowX + 180 + 80;
                  class41.field819.method4146(var22 - 73, var9 - 20);
                  var0.method3907("Cancel", var22, var9 + 5, 16777215, 0);
                  var1.method3907("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class41.loginIndex == 5) {
                  var0.method3907("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
                  var19 = 221;
                  var2.method3907(class41.loginMessage1, class41.loginWindowX + 180, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var2.method3907(class41.loginMessage2, 180 + class41.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var2.method3907(class41.loginMessage3, 180 + class41.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var20 += 14;
                  var0.method3920("Username/email: ", class41.loginWindowX + 180 - 145, var20, 16777215, 0);
                  var21 = 174;

                  for(var6 = class41.username; var0.method3912(var6) > var21; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3920(class209.method3979(var6) + (Client.gameCycle % 40 < 20?class13.method182(16776960) + "|":""), 180 + class41.loginWindowX - 34, var20, 16777215, 0);
                  var20 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  class41.field819.method4146(var7 - 73, var8 - 20);
                  var0.method3907("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = class41.loginWindowX + 180 + 80;
                  class41.field819.method4146(var7 - 73, var8 - 20);
                  var0.method3907("Back", var7, 5 + var8, 16777215, 0);
               } else if(class41.loginIndex == 6) {
                  var19 = 211;
                  var0.method3907(class41.loginMessage1, class41.loginWindowX + 180, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var0.method3907(class41.loginMessage2, class41.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var0.method3907(class41.loginMessage3, 180 + class41.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var15 = 321;
                  class41.field819.method4146(var5 - 73, var15 - 20);
                  var0.method3907("Back", var5, 5 + var15, 16777215, 0);
               }
            }
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var23;
         if(class41.field852 > 0) {
            var20 = class41.field852;
            var21 = 256;
            class41.field847 += 128 * var20;
            if(class41.field847 > class188.field2780.length) {
               class41.field847 -= class188.field2780.length;
               var25 = (int)(Math.random() * 12.0D);
               class34.method728(class41.field820[var25]);
            }

            var25 = 0;
            var7 = var20 * 128;
            var22 = 128 * (var21 - var20);

            for(var23 = 0; var23 < var22; ++var23) {
               var10 = class8.field72[var7 + var25] - var20 * class188.field2780[var25 + class41.field847 & class188.field2780.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class8.field72[var25++] = var10;
            }

            for(var23 = var21 - var20; var23 < var21; ++var23) {
               var10 = 128 * var23;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class8.field72[var11 + var10] = 255;
                  } else {
                     class8.field72[var10 + var11] = 0;
                  }
               }
            }

            if(class41.field827 > 0) {
               class41.field827 -= var20 * 4;
            }

            if(class41.field828 > 0) {
               class41.field828 -= 4 * var20;
            }

            if(class41.field827 == 0 && class41.field828 == 0) {
               var23 = (int)(Math.random() * (double)(2000 / var20));
               if(var23 == 0) {
                  class41.field827 = 1024;
               }

               if(var23 == 1) {
                  class41.field828 = 1024;
               }
            }

            for(var23 = 0; var23 < var21 - var20; ++var23) {
               class41.field817[var23] = class41.field817[var23 + var20];
            }

            for(var23 = var21 - var20; var23 < var21; ++var23) {
               class41.field817[var23] = (int)(Math.sin((double)class41.field832 / 14.0D) * 16.0D + Math.sin((double)class41.field832 / 15.0D) * 14.0D + Math.sin((double)class41.field832 / 16.0D) * 12.0D);
               ++class41.field832;
            }

            class41.field816 += var20;
            var23 = ((Client.gameCycle & 1) + var20) / 2;
            if(var23 > 0) {
               for(var10 = 0; var10 < class41.field816 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class8.field72[var11 + (var12 << 7)] = 192;
               }

               class41.field816 = 0;
               var10 = 0;

               label392:
               while(true) {
                  if(var10 >= var21) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label392;
                        }

                        var11 = 0;

                        for(var12 = -var23; var12 < var21; ++var12) {
                           var13 = var12 * 128;
                           if(var23 + var12 < var21) {
                              var11 += class119.field1848[var23 * 128 + var13 + var10];
                           }

                           if(var12 - (1 + var23) >= 0) {
                              var11 -= class119.field1848[var13 + var10 - (var23 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class8.field72[var13 + var10] = var11 / (1 + var23 * 2);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var23; var13 < 128; ++var13) {
                     if(var13 + var23 < 128) {
                        var11 += class8.field72[var23 + var12 + var13];
                     }

                     if(var13 - (1 + var23) >= 0) {
                        var11 -= class8.field72[var12 + var13 - (1 + var23)];
                     }

                     if(var13 >= 0) {
                        class119.field1848[var13 + var12] = var11 / (var23 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class41.field852 = 0;
         }

         var19 = 256;
         if(class41.field827 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field827 > 768) {
                  class107.field1730[var5] = class146.method2789(class137.field1909[var5], class38.field800[var5], 1024 - class41.field827);
               } else if(class41.field827 > 256) {
                  class107.field1730[var5] = class38.field800[var5];
               } else {
                  class107.field1730[var5] = class146.method2789(class38.field800[var5], class137.field1909[var5], 256 - class41.field827);
               }
            }
         } else if(class41.field828 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field828 > 768) {
                  class107.field1730[var5] = class146.method2789(class137.field1909[var5], class18.field200[var5], 1024 - class41.field828);
               } else if(class41.field828 > 256) {
                  class107.field1730[var5] = class18.field200[var5];
               } else {
                  class107.field1730[var5] = class146.method2789(class18.field200[var5], class137.field1909[var5], 256 - class41.field828);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class107.field1730[var5] = class137.field1909[var5];
            }
         }

         class219.method4041(class41.field848, 9, 128 + class41.field848, var19 + 7);
         class41.field821.method4190(class41.field848, 0);
         class219.method4040();
         var5 = 0;
         var25 = class41.field848 + class34.bufferProvider.width * 9;

         int var14;
         for(var7 = 1; var7 < var19 - 1; ++var7) {
            var22 = (var19 - var7) * class41.field817[var7] / var19;
            var23 = var22 + 22;
            if(var23 < 0) {
               var23 = 0;
            }

            var5 += var23;

            for(var10 = var23; var10 < 128; ++var10) {
               var11 = class8.field72[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class107.field1730[var11];
                  var14 = class34.bufferProvider.pixels[var25];
                  class34.bufferProvider.pixels[var25++] = (var13 * (var14 & 16711935) + var12 * (var11 & 16711935) & -16711936) + (var12 * (var11 & '\uff00') + (var14 & '\uff00') * var13 & 16711680) >> 8;
               } else {
                  ++var25;
               }
            }

            var25 += var23 + class34.bufferProvider.width - 128;
         }

         class219.method4041(765 + class41.field848 - 128, 9, 765 + class41.field848, var19 + 7);
         class41.field822.method4190(class41.field848 + 382, 0);
         class219.method4040();
         var5 = 0;
         var25 = 637 + class34.bufferProvider.width * 9 + 24 + class41.field848;

         for(var7 = 1; var7 < var19 - 1; ++var7) {
            var22 = (var19 - var7) * class41.field817[var7] / var19;
            var23 = 103 - var22;
            var25 += var22;

            for(var10 = 0; var10 < var23; ++var10) {
               var11 = class8.field72[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class107.field1730[var11];
                  var14 = class34.bufferProvider.pixels[var25];
                  class34.bufferProvider.pixels[var25++] = ((var11 & 16711935) * var12 + var13 * (var14 & 16711935) & -16711936) + (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var25;
               }
            }

            var5 += 128 - var23;
            var25 += class34.bufferProvider.width - var23 - var22;
         }

         class181.field2706[Tile.field1343.field688?1:0].method4146(class41.field848 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field289 == 0) {
            if(null != class41.field841) {
               var20 = 5 + class41.field848;
               var21 = 463;
               byte var26 = 100;
               byte var24 = 35;
               class41.field841.method4146(var20, var21);
               var0.method3907("World" + " " + Client.world, var26 / 2 + var20, var21 + var24 / 2 - 2, 16777215, 0);
               if(null != class206.worldServersDownload) {
                  var1.method3907("Loading...", var26 / 2 + var20, var21 + var24 / 2 + 12, 16777215, 0);
               } else {
                  var1.method3907("Click to switch", var20 + var26 / 2, var24 / 2 + var21 + 12, 16777215, 0);
               }
            } else {
               class41.field841 = class189.method3506(class156.field2240, "sl_button", "");
            }
         }

         try {
            Graphics var17 = class107.canvas.getGraphics();
            class34.bufferProvider.draw(var17, 0, 0);
         } catch (Exception var18) {
            class107.canvas.repaint();
         }

      }
   }
}
