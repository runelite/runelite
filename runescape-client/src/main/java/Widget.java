import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("dk")
   public int[] field2041;
   @ObfuscatedName("k")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("q")
   static NodeCache field2043 = new NodeCache(200);
   @ObfuscatedName("d")
   static NodeCache field2044 = new NodeCache(50);
   @ObfuscatedName("n")
   static NodeCache field2045 = new NodeCache(20);
   @ObfuscatedName("c")
   static NodeCache field2046 = new NodeCache(8);
   @ObfuscatedName("s")
   public static boolean field2047 = false;
   @ObfuscatedName("g")
   @Export("hasScript")
   public boolean hasScript = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1084644105
   )
   @Export("id")
   public int id = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 410844093
   )
   @Export("index")
   public int index = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -497819735
   )
   @Export("originalWidth")
   public int originalWidth = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1271362633
   )
   public int field2052 = 0;
   @ObfuscatedName("ed")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -663852127
   )
   public int field2054;
   @ObfuscatedName("do")
   public Object[] field2055;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1832213405
   )
   public int field2056 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1666412627
   )
   public int field2057;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1562510003
   )
   @Export("originalX")
   public int originalX = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 551941133
   )
   @Export("originalY")
   public int originalY = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1093737651
   )
   @Export("contentType")
   public int contentType = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1499841355
   )
   public int field2061 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1249085413
   )
   public int field2062;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 443329775
   )
   @Export("relativeY")
   public int relativeY = 0;
   @ObfuscatedName("dc")
   public Object[] field2064;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 2019303675
   )
   @Export("item")
   public int item;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1732300317
   )
   public int field2066 = 1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -784236199
   )
   public int field2067 = 1;
   @ObfuscatedName("bu")
   public String field2068;
   @ObfuscatedName("ai")
   @Export("isHidden")
   public boolean isHidden = false;
   @ObfuscatedName("de")
   public Object[] field2070;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1042321287
   )
   @Export("scrollY")
   public int scrollY = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1621781869
   )
   @Export("scrollWidth")
   public int scrollWidth = 0;
   @ObfuscatedName("dt")
   public Object[] field2073;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -424841805
   )
   public int field2074;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 743167339
   )
   public int field2075 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1196372493
   )
   public int field2076 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -738358639
   )
   public int field2077 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1253175353
   )
   public int field2078;
   @ObfuscatedName("at")
   public class221 field2079;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1457898799
   )
   public int field2080;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 270484021
   )
   public int field2081;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2079030273
   )
   public int field2082;
   @ObfuscatedName("ab")
   public boolean field2083;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -180275677
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 1342645337
   )
   public int field2085;
   @ObfuscatedName("du")
   public Object[] field2086;
   @ObfuscatedName("ak")
   public boolean field2087;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1905113467
   )
   @Export("type")
   public int type;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -805233523
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("bm")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("bz")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1816747291
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1225850029
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 922112325
   )
   @Export("scrollX")
   public int scrollX = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1288736859
   )
   int field2095;
   @ObfuscatedName("dn")
   public Object[] field2096;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -984302427
   )
   public int field2097;
   @ObfuscatedName("cn")
   @Export("name")
   public String name;
   @ObfuscatedName("ag")
   public boolean field2099 = false;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 843956941
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 688123865
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 250202799
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -980663203
   )
   public int field2103;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1065184611
   )
   public int field2104;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1982951033
   )
   public int field2105;
   @ObfuscatedName("dx")
   public Object[] field2106;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1692967795
   )
   @Export("width")
   public int width = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1429486403
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("ct")
   public int[] field2109;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2039925057
   )
   @Export("scrollHeight")
   public int scrollHeight = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -557402629
   )
   public int field2111 = 0;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1887547977
   )
   public int field2112;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -677129535
   )
   public int field2113;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -985209469
   )
   public int field2114;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1332025921
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1013253089
   )
   public int field2116;
   @ObfuscatedName("cf")
   public int[] field2117;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 559394755
   )
   public int field2118;
   @ObfuscatedName("dh")
   public int[] field2119;
   @ObfuscatedName("ck")
   public String[] field2120;
   @ObfuscatedName("ba")
   public boolean field2121;
   @ObfuscatedName("cu")
   public int[] field2122;
   @ObfuscatedName("co")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ca")
   @Export("parent")
   public Widget parent;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1372003783
   )
   public int field2125;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -119763401
   )
   @Export("parentId")
   public int parentId = -1;
   @ObfuscatedName("dd")
   public int[] field2127;
   @ObfuscatedName("cl")
   public String field2128;
   @ObfuscatedName("cm")
   public boolean field2129;
   @ObfuscatedName("cr")
   public Object[] field2130;
   @ObfuscatedName("cs")
   public Object[] field2131;
   @ObfuscatedName("cj")
   public Object[] field2132;
   @ObfuscatedName("ce")
   public Object[] field2133;
   @ObfuscatedName("cq")
   public Object[] field2134;
   @ObfuscatedName("cd")
   public Object[] field2135;
   @ObfuscatedName("cc")
   public Object[] field2136;
   @ObfuscatedName("cb")
   public Object[] field2137;
   @ObfuscatedName("dj")
   public Object[] field2138;
   @ObfuscatedName("dv")
   public Object[] field2139;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -939838047
   )
   int field2140;
   @ObfuscatedName("dq")
   public Object[] field2141;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1357818025
   )
   @Export("relativeX")
   public int relativeX = 0;
   @ObfuscatedName("bt")
   @Export("text")
   public String text;
   @ObfuscatedName("da")
   public Object[] field2144;
   @ObfuscatedName("dm")
   public int[] field2145;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1214010523
   )
   public int field2146;
   @ObfuscatedName("dr")
   public int[] field2147;
   @ObfuscatedName("ds")
   public Object[] field2148;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 46030289
   )
   public int field2149;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1067198983
   )
   @Export("textColor")
   public int textColor = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -109674711
   )
   public int field2151 = 0;
   @ObfuscatedName("dy")
   public Object[] field2152;
   @ObfuscatedName("dl")
   public Object[] field2153;
   @ObfuscatedName("dz")
   public Object[] field2154;
   @ObfuscatedName("dg")
   public Object[] field2155;
   @ObfuscatedName("di")
   public Object[] field2156;
   @ObfuscatedName("df")
   public Object[] field2157;
   @ObfuscatedName("dp")
   public Object[] field2158;
   @ObfuscatedName("dw")
   public Object[] field2159;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1695667767
   )
   public int field2160;
   @ObfuscatedName("db")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("et")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("bq")
   public boolean field2163;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1863007933
   )
   public int field2164;
   @ObfuscatedName("ec")
   public String field2165;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 2082214131
   )
   public int field2166;
   @ObfuscatedName("ei")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1871365705
   )
   @Export("height")
   public int height = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 239850919
   )
   public int field2169;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -857758291
   )
   @Export("stackSize")
   public int stackSize;
   @ObfuscatedName("y")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("cx")
   public boolean field2172;
   @ObfuscatedName("ex")
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("eg")
   public boolean field2174;
   @ObfuscatedName("eq")
   public boolean field2175;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -2090232171
   )
   public int field2176;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -876517951
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1194566879
   )
   public int field2178;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 910718075
   )
   public int field2179 = 0;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1167966953
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 747107709
   )
   public int field2181;
   @ObfuscatedName("ez")
   public boolean field2182;
   @ObfuscatedName("ek")
   public boolean field2183;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "11"
   )
   void method2776(Buffer var1) {
      var1.readUnsignedByte();
      this.hasScript = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      if(this.type == 9) {
         this.field2061 = var1.readShort();
      } else {
         this.field2061 = var1.readUnsignedShort();
      }

      this.field2056 = var1.readByte();
      this.field2151 = var1.readByte();
      this.field2111 = var1.readByte();
      this.field2179 = var1.readByte();
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
         this.field2182 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.textureId = var1.method3062();
         this.field2078 = var1.readUnsignedShort();
         this.field2087 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
         this.borderThickness = var1.readUnsignedByte();
         this.sprite2 = var1.method3062();
         this.flippedVertically = var1.readUnsignedByte() == 1;
         this.flippedHorizontally = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2160 = var1.readShort();
         this.field2114 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.field2103 = var1.readUnsignedShort();
         this.field2164 = var1.readUnsignedShort();
         if(this.field2164 == '\uffff') {
            this.field2164 = -1;
         }

         this.field2121 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2056 != 0) {
            this.field2104 = var1.readUnsignedShort();
         }

         if(this.field2151 != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.text = var1.method2934();
         this.field2113 = var1.readUnsignedByte();
         this.field2112 = var1.readUnsignedByte();
         this.field2080 = var1.readUnsignedByte();
         this.field2163 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method3062();
      }

      if(this.type == 3) {
         this.textColor = var1.method3062();
         this.field2099 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2082 = var1.readUnsignedByte();
         this.textColor = var1.method3062();
         this.field2083 = var1.readUnsignedByte() == 1;
      }

      this.field2169 = var1.read24BitInt();
      this.name = var1.method2934();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.method2934();
         }
      }

      this.field2125 = var1.readUnsignedByte();
      this.field2097 = var1.readUnsignedByte();
      this.field2172 = var1.readUnsignedByte() == 1;
      this.field2128 = var1.method2934();
      this.field2130 = this.method2777(var1);
      this.field2135 = this.method2777(var1);
      this.field2137 = this.method2777(var1);
      this.field2141 = this.method2777(var1);
      this.field2096 = this.method2777(var1);
      this.field2073 = this.method2777(var1);
      this.field2144 = this.method2777(var1);
      this.field2086 = this.method2777(var1);
      this.field2148 = this.method2777(var1);
      this.field2064 = this.method2777(var1);
      this.field2136 = this.method2777(var1);
      this.field2131 = this.method2777(var1);
      this.field2132 = this.method2777(var1);
      this.field2133 = this.method2777(var1);
      this.field2134 = this.method2777(var1);
      this.field2138 = this.method2777(var1);
      this.field2139 = this.method2777(var1);
      this.field2106 = this.method2777(var1);
      this.field2127 = this.method2820(var1);
      this.field2145 = this.method2820(var1);
      this.field2147 = this.method2820(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[Ljava/lang/Object;",
      garbageValue = "-590520438"
   )
   Object[] method2777(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if(var5 == 0) {
               var3[var4] = new Integer(var1.method3062());
            } else if(var5 == 1) {
               var3[var4] = var1.method2934();
            }
         }

         this.field2129 = true;
         return var3;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZB)Lclass145;",
      garbageValue = "7"
   )
   public class145 method2778(boolean var1) {
      if(this.field2062 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2062:this.textureId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((this.flippedHorizontally?1L:0L) << 39) + ((this.flippedVertically?1L:0L) << 38) + (long)var2 + ((long)this.borderThickness << 36) + ((long)this.sprite2 << 40);
         class145 var5 = (class145)field2046.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method2823(var1);
            if(null == var6) {
               return null;
            } else {
               SpritePixels var7 = var6.method4175();
               int[] var8 = new int[var7.height];
               int[] var9 = new int[var7.height];

               for(int var10 = 0; var10 < var7.height; ++var10) {
                  int var11 = 0;
                  int var12 = var7.width;

                  int var13;
                  for(var13 = 0; var13 < var7.width; ++var13) {
                     if(var7.image[var10 * var7.width + var13] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.width - 1; var13 >= var11; --var13) {
                     if(var7.image[var7.width * var10 + var13] == 0) {
                        var12 = 1 + var13;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class145(var7.width, var7.height, var9, var8, var2);
               field2046.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)LFont;",
      garbageValue = "104"
   )
   public Font method2780() {
      field2047 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)field2045.get((long)this.fontId);
         if(null != var1) {
            return var1;
         } else {
            var1 = class44.method825(class210.field3109, class44.field896, this.fontId, 0);
            if(null != var1) {
               field2045.put(var1, (long)this.fontId);
            } else {
               field2047 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "39"
   )
   public void method2783(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   void method2806(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2052 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.field2061 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2146 = var1.readUnsignedShort();
      if(this.field2146 == '\uffff') {
         this.field2146 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.field2041 = new int[var2];
         this.field2119 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field2041[var3] = var1.readUnsignedByte();
            this.field2119[var3] = var1.readUnsignedShort();
         }
      }

      var3 = var1.readUnsignedByte();
      int var4;
      int var5;
      int var10;
      if(var3 > 0) {
         this.dynamicValues = new int[var3][];

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var1.readUnsignedShort();
            this.dynamicValues[var4] = new int[var5];

            for(var10 = 0; var10 < var5; ++var10) {
               this.dynamicValues[var4][var10] = var1.readUnsignedShort();
               if(this.dynamicValues[var4][var10] == '\uffff') {
                  this.dynamicValues[var4][var10] = -1;
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
         this.itemIds = new int[this.originalWidth * this.field2061];
         this.itemQuantities = new int[this.originalWidth * this.field2061];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2169 |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.field2169 |= 1073741824;
         }

         var10 = var1.readUnsignedByte();
         if(var10 == 1) {
            this.field2169 |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.field2169 |= 536870912;
         }

         this.field2118 = var1.readUnsignedByte();
         this.field2116 = var1.readUnsignedByte();
         this.field2117 = new int[20];
         this.field2109 = new int[20];
         this.field2122 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.field2117[var8] = var1.readShort();
               this.field2109[var8] = var1.readShort();
               this.field2122[var8] = var1.method3062();
            } else {
               this.field2122[var8] = -1;
            }
         }

         this.field2120 = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var11 = var1.method2934();
            if(var11.length() > 0) {
               this.field2120[var8] = var11;
               this.field2169 |= 1 << 23 + var8;
            }
         }
      }

      if(this.type == 3) {
         this.field2099 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2112 = var1.readUnsignedByte();
         this.field2080 = var1.readUnsignedByte();
         this.field2113 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2163 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.method2934();
         this.field2068 = var1.method2934();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.method3062();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2075 = var1.method3062();
         this.field2076 = var1.method3062();
         this.field2077 = var1.method3062();
      }

      if(this.type == 5) {
         this.textureId = var1.method3062();
         this.field2062 = var1.method3062();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2140 = 1;
         this.field2095 = var1.readUnsignedShort();
         if(this.field2095 == '\uffff') {
            this.field2095 = -1;
         }

         this.field2164 = var1.readUnsignedShort();
         if(this.field2164 == '\uffff') {
            this.field2164 = -1;
         }

         this.field2074 = var1.readUnsignedShort();
         if(this.field2074 == '\uffff') {
            this.field2074 = -1;
         }

         this.field2103 = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.field2061 * this.originalWidth];
         this.itemQuantities = new int[this.field2061 * this.originalWidth];
         this.field2112 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2163 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method3062();
         this.field2118 = var1.readShort();
         this.field2116 = var1.readShort();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2169 |= 1073741824;
         }

         this.field2120 = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var6 = var1.method2934();
            if(var6.length() > 0) {
               this.field2120[var5] = var6;
               this.field2169 |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.method2934();
      }

      if(this.field2052 == 2 || this.type == 2) {
         this.field2128 = var1.method2934();
         this.field2165 = var1.method2934();
         var4 = var1.readUnsignedShort() & 63;
         this.field2169 |= var4 << 11;
      }

      if(this.field2052 == 1 || this.field2052 == 4 || this.field2052 == 5 || this.field2052 == 6) {
         this.tooltip = var1.method2934();
         if(this.tooltip.length() == 0) {
            if(this.field2052 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2052 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2052 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2052 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2052 == 1 || this.field2052 == 4 || this.field2052 == 5) {
         this.field2169 |= 4194304;
      }

      if(this.field2052 == 6) {
         this.field2169 |= 1;
      }

   }

   public Widget() {
      this.field2079 = class221.field3183;
      this.opacity = 0;
      this.field2081 = 0;
      this.field2082 = 1;
      this.field2083 = false;
      this.textureId = -1;
      this.field2062 = -1;
      this.field2078 = 0;
      this.field2087 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2140 = 1;
      this.field2095 = -1;
      this.field2164 = -1;
      this.field2074 = -1;
      this.field2160 = 0;
      this.field2114 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.field2103 = 100;
      this.field2104 = 0;
      this.field2105 = 0;
      this.field2121 = false;
      this.field2057 = 2;
      this.fontId = -1;
      this.text = "";
      this.field2068 = "";
      this.field2113 = 0;
      this.field2112 = 0;
      this.field2080 = 0;
      this.field2163 = false;
      this.field2118 = 0;
      this.field2116 = 0;
      this.field2169 = 0;
      this.name = "";
      this.parent = null;
      this.field2125 = 0;
      this.field2097 = 0;
      this.field2172 = false;
      this.field2128 = "";
      this.field2129 = false;
      this.field2146 = -1;
      this.field2165 = "";
      this.tooltip = "Ok";
      this.item = -1;
      this.stackSize = 0;
      this.field2054 = 0;
      this.field2176 = 0;
      this.field2174 = false;
      this.field2175 = false;
      this.field2166 = -1;
      this.field2085 = 0;
      this.field2178 = 0;
      this.field2149 = 0;
      this.boundsIndex = -1;
      this.field2181 = -1;
      this.field2182 = false;
      this.field2183 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LSequence;IZLPlayerComposition;I)LModel;",
      garbageValue = "-264216767"
   )
   public Model method2815(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2047 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2140;
         var6 = this.field2095;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2044.get((long)((var5 << 16) + var6));
         if(null == var7) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method1470(class105.field1724, var6, 0);
               if(var8 == null) {
                  field2047 = true;
                  return null;
               }

               var7 = var8.method1491(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = class45.getNpcDefinition(var6).method3704();
               if(null == var8) {
                  field2047 = true;
                  return null;
               }

               var7 = var8.method1491(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(null == var4) {
                  return null;
               }

               var8 = var4.method2732();
               if(var8 == null) {
                  field2047 = true;
                  return null;
               }

               var7 = var8.method1491(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = PlayerComposition.getItemDefinition(var6);
               var8 = var9.method3647(10);
               if(null == var8) {
                  field2047 = true;
                  return null;
               }

               var7 = var8.method1491(var9.ambient + 64, 768 + var9.contrast, -50, -10, -50);
            }

            field2044.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(null != var1) {
            var7 = var1.method3767(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)[I",
      garbageValue = "-46"
   )
   int[] method2820(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.method3062();
         }

         return var3;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZB)LSpritePixels;",
      garbageValue = "-46"
   )
   public SpritePixels method2823(boolean var1) {
      field2047 = false;
      int var2;
      if(var1) {
         var2 = this.field2062;
      } else {
         var2 = this.textureId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((long)this.borderThickness << 36) + (long)var2 + ((this.flippedVertically?1L:0L) << 38) + ((this.flippedHorizontally?1L:0L) << 39);
         SpritePixels var5 = (SpritePixels)field2043.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = class60.method1158(class210.field3109, var2, 0);
            if(var5 == null) {
               field2047 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method4109();
               }

               if(this.flippedHorizontally) {
                  var5.method4108();
               }

               if(this.borderThickness > 0) {
                  var5.method4107(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method4110(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method4110(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method4177(this.sprite2);
               }

               field2043.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "15"
   )
   public void method2824(int var1, String var2) {
      if(null == this.actions || this.actions.length <= var1) {
         String[] var3 = new String[var1 + 1];
         if(null != this.actions) {
            for(int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[var1] = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "-1777012050"
   )
   public SpritePixels method2829(int var1) {
      field2047 = false;
      if(var1 >= 0 && var1 < this.field2122.length) {
         int var2 = this.field2122[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2043.get((long)var2);
            if(null != var3) {
               return var3;
            } else {
               var3 = class60.method1158(class210.field3109, var2, 0);
               if(null != var3) {
                  field2043.put(var3, (long)var2);
               } else {
                  field2047 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "38"
   )
   static final void method2830(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class65.region.method1733(var0, var1, var2);
      int var6;
      int var8;
      int var9;
      int var11;
      int var17;
      int var19;
      if(var5 != 0) {
         var6 = class65.region.method1737(var0, var1, var2, var5);
         var19 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class7.field56.image;
         var11 = 2048 * (103 - var2) + 4 * var1 + 24624;
         var17 = var5 >> 14 & 32767;
         ObjectComposition var18 = class156.getObjectDefinition(var17);
         if(var18.mapSceneId != -1) {
            ModIcon var14 = MessageNode.field234[var18.mapSceneId];
            if(var14 != null) {
               int var15 = (var18.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var18.sizeY * 4 - var14.height) / 2;
               var14.method4064(var15 + 48 + var1 * 4, var16 + (104 - var2 - var18.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var19 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var19 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var19 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var19 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var19 == 0) {
                  var10[var11] = var9;
               } else if(var19 == 1) {
                  var10[3 + var11] = var9;
               } else if(var19 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var19 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var19 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var19 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var19 == 1) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var19 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class65.region.method1840(var0, var1, var2);
      if(var5 != 0) {
         var6 = class65.region.method1737(var0, var1, var2, var5);
         var19 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class156.getObjectDefinition(var9);
         int var13;
         if(var23.mapSceneId != -1) {
            ModIcon var20 = MessageNode.field234[var23.mapSceneId];
            if(var20 != null) {
               var17 = (var23.sizeX * 4 - var20.originalWidth) / 2;
               var13 = (var23.sizeY * 4 - var20.height) / 2;
               var20.method4064(var1 * 4 + 48 + var17, var13 + 48 + (104 - var2 - var23.sizeY) * 4);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class7.field56.image;
            var13 = (103 - var2) * 2048 + 24624 + 4 * var1;
            if(var19 != 0 && var19 != 2) {
               var12[var13] = var11;
               var12[512 + var13 + 1] = var11;
               var12[2 + 1024 + var13] = var11;
               var12[var13 + 1536 + 3] = var11;
            } else {
               var12[1536 + var13] = var11;
               var12[1 + 1024 + var13] = var11;
               var12[2 + var13 + 512] = var11;
               var12[var13 + 3] = var11;
            }
         }
      }

      var5 = class65.region.method1736(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var7 = class156.getObjectDefinition(var6);
         if(var7.mapSceneId != -1) {
            ModIcon var21 = MessageNode.field234[var7.mapSceneId];
            if(var21 != null) {
               var9 = (var7.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var7.sizeY * 4 - var21.height) / 2;
               var21.method4064(48 + 4 * var1 + var9, 48 + 4 * (104 - var2 - var7.sizeY) + var22);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-1578149494"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3036.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class182 var3 = Sequence.field3048;
         class182 var4 = Sequence.field3034;
         boolean var5 = true;
         int[] var6 = var3.method3282(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3279(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3279(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(null != var2) {
            Sequence.field3036.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "101"
   )
   public static void method2832() {
      Overlay.field3020.reset();
   }
}
