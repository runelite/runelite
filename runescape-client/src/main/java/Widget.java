import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 630827261
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("g")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1272949223
   )
   public int field2187;
   @ObfuscatedName("q")
   public static class182 field2188;
   @ObfuscatedName("k")
   public static class182 field2189;
   @ObfuscatedName("j")
   public static NodeCache field2190 = new NodeCache(200);
   @ObfuscatedName("ei")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -387417313
   )
   public int field2192;
   @ObfuscatedName("a")
   public static NodeCache field2193 = new NodeCache(8);
   @ObfuscatedName("ec")
   public boolean field2194;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1093216055
   )
   public int field2195 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1091713821
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 564788339
   )
   @Export("index")
   public int index = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1495255755
   )
   @Export("type")
   public int type;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -2098452967
   )
   public int field2199;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1503211879
   )
   @Export("contentType")
   public int contentType = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 123310171
   )
   public int field2201 = 0;
   @ObfuscatedName("p")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1369036363
   )
   @Export("scrollWidth")
   public int scrollWidth = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1086960813
   )
   public int field2204 = 0;
   @ObfuscatedName("du")
   public Object[] field2205;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -947082267
   )
   @Export("originalY")
   public int originalY = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 708576873
   )
   @Export("originalWidth")
   public int originalWidth = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -2060190567
   )
   @Export("scrollY")
   public int scrollY = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1682187597
   )
   @Export("relativeX")
   public int relativeX = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1486213585
   )
   @Export("relativeY")
   public int relativeY = 0;
   @ObfuscatedName("cj")
   public boolean field2211;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2090478989
   )
   @Export("height")
   public int height = 0;
   @ObfuscatedName("cn")
   public Object[] field2213;
   @ObfuscatedName("m")
   @Export("hasScript")
   public boolean hasScript = false;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1052127167
   )
   @Export("parentId")
   public int parentId = -1;
   @ObfuscatedName("ak")
   @Export("isHidden")
   public boolean isHidden = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1532608119
   )
   @Export("scrollX")
   public int scrollX = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 465156919
   )
   @Export("width")
   public int width = 0;
   @ObfuscatedName("dg")
   public Object[] field2219;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1166595531
   )
   @Export("scrollHeight")
   public int scrollHeight = 0;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 750496843
   )
   public int field2221;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1569245817
   )
   public int field2222;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1601947087
   )
   public int field2223 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -928276511
   )
   public int field2224 = 0;
   @ObfuscatedName("ab")
   public boolean field2225 = false;
   @ObfuscatedName("an")
   public class221 field2226;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1439365003
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 345782327
   )
   public int field2228;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1101599171
   )
   public int field2229;
   @ObfuscatedName("ap")
   public boolean field2230;
   @ObfuscatedName("o")
   public static NodeCache field2231 = new NodeCache(20);
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -952219245
   )
   public int field2232;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1254188035
   )
   public int field2233;
   @ObfuscatedName("az")
   public boolean field2234;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1890480043
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1532776353
   )
   @Export("id")
   public int id = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 221554587
   )
   public int field2237 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -663772105
   )
   @Export("originalX")
   public int originalX = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -343963229
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1009075129
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1407955937
   )
   public int field2241 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -786674569
   )
   int field2242;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -161501209
   )
   public int field2243;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 540784273
   )
   public int field2244;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1491359313
   )
   public int field2245;
   @ObfuscatedName("bw")
   public boolean field2246;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2090545127
   )
   public int field2247;
   @ObfuscatedName("de")
   public Object[] field2248;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 44112147
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1924598963
   )
   public int field2250;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1010906841
   )
   public int field2251 = 0;
   @ObfuscatedName("bu")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("dv")
   public Object[] field2253;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -241898751
   )
   public int field2254 = 1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -439110489
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("bq")
   @Export("text")
   public String text;
   @ObfuscatedName("df")
   public Object[] field2257;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1364188483
   )
   public int field2258;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -2110111635
   )
   public int field2259;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 870883145
   )
   public int field2260;
   @ObfuscatedName("bd")
   public boolean field2261;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1068597909
   )
   public int field2262;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1778737495
   )
   public int field2263;
   @ObfuscatedName("co")
   public int[] field2264;
   @ObfuscatedName("cq")
   public int[] field2265;
   @ObfuscatedName("cw")
   public int[] field2266;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 913565577
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1768319045
   )
   public int field2268;
   @ObfuscatedName("cc")
   @Export("name")
   public String name;
   @ObfuscatedName("cd")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("cb")
   @Export("parent")
   public Widget parent;
   @ObfuscatedName("ef")
   public boolean field2272;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -269325557
   )
   public int field2273;
   @ObfuscatedName("ct")
   public Object[] field2274;
   @ObfuscatedName("ce")
   public String field2275;
   @ObfuscatedName("cp")
   public boolean field2276;
   @ObfuscatedName("cz")
   public Object[] field2277;
   @ObfuscatedName("da")
   public int[] field2278;
   @ObfuscatedName("ca")
   public Object[] field2279;
   @ObfuscatedName("cu")
   public Object[] field2280;
   @ObfuscatedName("x")
   public static class182 field2281;
   @ObfuscatedName("cr")
   public Object[] field2282;
   @ObfuscatedName("s")
   public static NodeCache field2283 = new NodeCache(50);
   @ObfuscatedName("bo")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("dy")
   public Object[] field2285;
   @ObfuscatedName("dd")
   public Object[] field2286;
   @ObfuscatedName("dk")
   public Object[] field2287;
   @ObfuscatedName("dl")
   public Object[] field2288;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1927918769
   )
   public int field2289 = 0;
   @ObfuscatedName("di")
   public Object[] field2290;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1768703035
   )
   public int field2291 = 1;
   @ObfuscatedName("dq")
   public int[] field2292;
   @ObfuscatedName("cx")
   public Object[] field2293;
   @ObfuscatedName("dz")
   public int[] field2294;
   @ObfuscatedName("ck")
   public Object[] field2295;
   @ObfuscatedName("dr")
   public Object[] field2296;
   @ObfuscatedName("eo")
   public boolean field2297;
   @ObfuscatedName("dt")
   public Object[] field2298;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -378559159
   )
   public int field2299;
   @ObfuscatedName("ds")
   public Object[] field2300;
   @ObfuscatedName("dh")
   public Object[] field2301;
   @ObfuscatedName("dj")
   public Object[] field2302;
   @ObfuscatedName("do")
   public Object[] field2303;
   @ObfuscatedName("dw")
   public int[] field2304;
   @ObfuscatedName("dc")
   public Object[] field2305;
   @ObfuscatedName("dn")
   public Object[] field2306;
   @ObfuscatedName("dx")
   public Object[] field2307;
   @ObfuscatedName("db")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1537369633
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("dp")
   public int[] field2310;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1653988521
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("bk")
   public String field2312;
   @ObfuscatedName("eh")
   public String field2313;
   @ObfuscatedName("eu")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("ee")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 2145007683
   )
   @Export("item")
   public int item;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -489857115
   )
   @Export("stackSize")
   public int stackSize;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -275781157
   )
   public int field2318;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1390159739
   )
   public int field2319;
   @ObfuscatedName("em")
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -605636557
   )
   @Export("textColor")
   public int textColor = 0;
   @ObfuscatedName("er")
   public boolean field2322;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1082275575
   )
   public int field2323;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -1985809213
   )
   public int field2324;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -705169851
   )
   public int field2325;
   @ObfuscatedName("c")
   public static boolean field2326 = false;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -722679731
   )
   int field2327;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1913264065
   )
   public int field2328;
   @ObfuscatedName("ci")
   public String[] field2329;
   @ObfuscatedName("dm")
   public Object[] field2330;
   @ObfuscatedName("d")
   static File field2332;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-773119601"
   )
   void method3172(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2237 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.field2241 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2222 = var1.readUnsignedShort();
      if(this.field2222 == '\uffff') {
         this.field2222 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.field2278 = new int[var2];
         this.field2310 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field2278[var3] = var1.readUnsignedByte();
            this.field2310[var3] = var1.readUnsignedShort();
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
         this.itemIds = new int[this.field2241 * this.originalWidth];
         this.itemQuantities = new int[this.originalWidth * this.field2241];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2268 |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.field2268 |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if(var6 == 1) {
            this.field2268 |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.field2268 |= 536870912;
         }

         this.field2262 = var1.readUnsignedByte();
         this.field2318 = var1.readUnsignedByte();
         this.field2264 = new int[20];
         this.field2265 = new int[20];
         this.field2266 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var10 = var1.readUnsignedByte();
            if(var10 == 1) {
               this.field2264[var8] = var1.readShort();
               this.field2265[var8] = var1.readShort();
               this.field2266[var8] = var1.method2819();
            } else {
               this.field2266[var8] = -1;
            }
         }

         this.field2329 = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var9 = var1.method2846();
            if(var9.length() > 0) {
               this.field2329[var8] = var9;
               this.field2268 |= 1 << 23 + var8;
            }
         }
      }

      if(this.type == 3) {
         this.field2225 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2259 = var1.readUnsignedByte();
         this.field2263 = var1.readUnsignedByte();
         this.field2258 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2261 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.method2846();
         this.field2312 = var1.method2846();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.method2819();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2289 = var1.method2819();
         this.field2223 = var1.method2819();
         this.field2224 = var1.method2819();
      }

      if(this.type == 5) {
         this.textureId = var1.method2819();
         this.field2232 = var1.method2819();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2327 = 1;
         this.field2242 = var1.readUnsignedShort();
         if(this.field2242 == '\uffff') {
            this.field2242 = -1;
         }

         this.field2243 = var1.readUnsignedShort();
         if(this.field2243 == '\uffff') {
            this.field2243 = -1;
         }

         this.field2299 = var1.readUnsignedShort();
         if(this.field2299 == '\uffff') {
            this.field2299 = -1;
         }

         this.field2250 = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.field2241 * this.originalWidth];
         this.itemQuantities = new int[this.field2241 * this.originalWidth];
         this.field2259 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2261 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method2819();
         this.field2262 = var1.readShort();
         this.field2318 = var1.readShort();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2268 |= 1073741824;
         }

         this.field2329 = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var11 = var1.method2846();
            if(var11.length() > 0) {
               this.field2329[var5] = var11;
               this.field2268 |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.method2846();
      }

      if(this.field2237 == 2 || this.type == 2) {
         this.field2275 = var1.method2846();
         this.field2313 = var1.method2846();
         var4 = var1.readUnsignedShort() & 63;
         this.field2268 |= var4 << 11;
      }

      if(this.field2237 == 1 || this.field2237 == 4 || this.field2237 == 5 || this.field2237 == 6) {
         this.tooltip = var1.method2846();
         if(this.tooltip.length() == 0) {
            if(this.field2237 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2237 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2237 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2237 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2237 == 1 || this.field2237 == 4 || this.field2237 == 5) {
         this.field2268 |= 4194304;
      }

      if(this.field2237 == 6) {
         this.field2268 |= 1;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "2107545614"
   )
   public SpritePixels method3173(boolean var1) {
      field2326 = false;
      int var2;
      if(var1) {
         var2 = this.field2232;
      } else {
         var2 = this.textureId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedVertically?1L:0L) << 38) + (long)var2 + ((long)this.borderThickness << 36) + ((this.flippedHorizontally?1L:0L) << 39);
         SpritePixels var5 = (SpritePixels)field2190.get(var3);
         if(null != var5) {
            return var5;
         } else {
            var5 = class186.method3417(class9.field83, var2, 0);
            if(null == var5) {
               field2326 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method4139();
               }

               if(this.flippedHorizontally) {
                  var5.method4138();
               }

               if(this.borderThickness > 0) {
                  var5.method4137(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method4140(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method4140(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method4141(this.sprite2);
               }

               field2190.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)[Ljava/lang/Object;",
      garbageValue = "7"
   )
   Object[] method3174(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if(var5 == 0) {
               var3[var4] = new Integer(var1.method2819());
            } else if(var5 == 1) {
               var3[var4] = var1.method2846();
            }
         }

         this.field2276 = true;
         return var3;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)[I",
      garbageValue = "0"
   )
   int[] method3175(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.method2819();
         }

         return var3;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-164347204"
   )
   public Font method3178() {
      field2326 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)field2231.get((long)this.fontId);
         if(null != var1) {
            return var1;
         } else {
            var1 = Friend.method182(class9.field83, field2189, this.fontId, 0);
            if(null != var1) {
               field2231.put(var1, (long)this.fontId);
            } else {
               field2326 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)LSpritePixels;",
      garbageValue = "-19709"
   )
   public SpritePixels method3179(int var1) {
      field2326 = false;
      if(var1 >= 0 && var1 < this.field2266.length) {
         int var2 = this.field2266[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2190.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = class186.method3417(class9.field83, var2, 0);
               if(null != var3) {
                  field2190.put(var3, (long)var2);
               } else {
                  field2326 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LSequence;IZLPlayerComposition;B)LModel;",
      garbageValue = "99"
   )
   public Model method3180(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2326 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2327;
         var6 = this.field2242;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2283.get((long)(var6 + (var5 << 16)));
         if(null == var7) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method1459(field2188, var6, 0);
               if(null == var8) {
                  field2326 = true;
                  return null;
               }

               var7 = var8.method1479(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = Tile.getNpcDefinition(var6).method3702();
               if(null == var8) {
                  field2326 = true;
                  return null;
               }

               var7 = var8.method1479(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(null == var4) {
                  return null;
               }

               var8 = var4.method3127();
               if(var8 == null) {
                  field2326 = true;
                  return null;
               }

               var7 = var8.method1479(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class36.getItemDefinition(var6);
               var8 = var9.method3655(10);
               if(var8 == null) {
                  field2326 = true;
                  return null;
               }

               var7 = var8.method1479(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            field2283.put(var7, (long)(var6 + (var5 << 16)));
         }

         if(null != var1) {
            var7 = var1.method3754(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-313564209"
   )
   public void method3182(int var1, String var2) {
      if(null == this.actions || this.actions.length <= var1) {
         String[] var3 = new String[1 + var1];
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
      signature = "(LBuffer;I)V",
      garbageValue = "-156087979"
   )
   void method3189(Buffer var1) {
      var1.readUnsignedByte();
      this.hasScript = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      if(this.type == 9) {
         this.field2241 = var1.readShort();
      } else {
         this.field2241 = var1.readUnsignedShort();
      }

      this.field2251 = var1.readByte();
      this.field2204 = var1.readByte();
      this.field2201 = var1.readByte();
      this.field2195 = var1.readByte();
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
         this.field2194 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.textureId = var1.method2819();
         this.field2233 = var1.readUnsignedShort();
         this.field2234 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
         this.borderThickness = var1.readUnsignedByte();
         this.sprite2 = var1.method2819();
         this.flippedVertically = var1.readUnsignedByte() == 1;
         this.flippedHorizontally = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2245 = var1.readShort();
         this.field2247 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.field2250 = var1.readUnsignedShort();
         this.field2243 = var1.readUnsignedShort();
         if(this.field2243 == '\uffff') {
            this.field2243 = -1;
         }

         this.field2246 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2251 != 0) {
            this.field2199 = var1.readUnsignedShort();
         }

         if(this.field2204 != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.text = var1.method2846();
         this.field2258 = var1.readUnsignedByte();
         this.field2259 = var1.readUnsignedByte();
         this.field2263 = var1.readUnsignedByte();
         this.field2261 = var1.readUnsignedByte() == 1;
         this.textColor = var1.method2819();
      }

      if(this.type == 3) {
         this.textColor = var1.method2819();
         this.field2225 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2229 = var1.readUnsignedByte();
         this.textColor = var1.method2819();
         this.field2230 = var1.readUnsignedByte() == 1;
      }

      this.field2268 = var1.read24BitInt();
      this.name = var1.method2846();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.method2846();
         }
      }

      this.field2260 = var1.readUnsignedByte();
      this.field2273 = var1.readUnsignedByte();
      this.field2211 = var1.readUnsignedByte() == 1;
      this.field2275 = var1.method2846();
      this.field2277 = this.method3174(var1);
      this.field2282 = this.method3174(var1);
      this.field2274 = this.method3174(var1);
      this.field2253 = this.method3174(var1);
      this.field2287 = this.method3174(var1);
      this.field2248 = this.method3174(var1);
      this.field2330 = this.method3174(var1);
      this.field2288 = this.method3174(var1);
      this.field2219 = this.method3174(var1);
      this.field2296 = this.method3174(var1);
      this.field2213 = this.method3174(var1);
      this.field2295 = this.method3174(var1);
      this.field2279 = this.method3174(var1);
      this.field2280 = this.method3174(var1);
      this.field2293 = this.method3174(var1);
      this.field2285 = this.method3174(var1);
      this.field2286 = this.method3174(var1);
      this.field2205 = this.method3174(var1);
      this.field2304 = this.method3175(var1);
      this.field2292 = this.method3175(var1);
      this.field2294 = this.method3175(var1);
   }

   public Widget() {
      this.field2226 = class221.field3186;
      this.opacity = 0;
      this.field2228 = 0;
      this.field2229 = 1;
      this.field2230 = false;
      this.textureId = -1;
      this.field2232 = -1;
      this.field2233 = 0;
      this.field2234 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2327 = 1;
      this.field2242 = -1;
      this.field2243 = -1;
      this.field2299 = -1;
      this.field2245 = 0;
      this.field2247 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.field2250 = 100;
      this.field2199 = 0;
      this.field2192 = 0;
      this.field2246 = false;
      this.field2187 = 2;
      this.fontId = -1;
      this.text = "";
      this.field2312 = "";
      this.field2258 = 0;
      this.field2259 = 0;
      this.field2263 = 0;
      this.field2261 = false;
      this.field2262 = 0;
      this.field2318 = 0;
      this.field2268 = 0;
      this.name = "";
      this.parent = null;
      this.field2260 = 0;
      this.field2273 = 0;
      this.field2211 = false;
      this.field2275 = "";
      this.field2276 = false;
      this.field2222 = -1;
      this.field2313 = "";
      this.tooltip = "Ok";
      this.item = -1;
      this.stackSize = 0;
      this.field2221 = 0;
      this.field2319 = 0;
      this.field2272 = false;
      this.field2322 = false;
      this.field2323 = -1;
      this.field2324 = 0;
      this.field2325 = 0;
      this.field2244 = 0;
      this.boundsIndex = -1;
      this.field2328 = -1;
      this.field2194 = false;
      this.field2297 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "650241009"
   )
   public void method3206(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass186;",
      garbageValue = "1853540391"
   )
   public static class186 method3213(int var0) {
      class186 var1 = (class186)class186.field2764.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class186.field2767.getConfigData(5, var0);
         var1 = new class186();
         if(var2 != null) {
            var1.method3412(new Buffer(var2));
         }

         class186.field2764.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "-77"
   )
   static final int method3216(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2799(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2802(var3.nextInt());
      }

      var4.method2802(var6[0]);
      var4.method2802(var6[1]);
      var4.method2804(var0);
      var4.method2804(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2802(var3.nextInt());
      }

      var4.method2884(class36.field766, class36.field768);
      var5.method2799(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2802(var3.nextInt());
      }

      var5.method2804(var3.nextLong());
      var5.method2826(var3.nextLong());
      class48.method877(var5);
      var5.method2804(var3.nextLong());
      var5.method2884(class36.field766, class36.field768);
      var7 = class37.method737(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method2805(var2);
      var8.offset = var7;
      var8.method2830(var6);
      Buffer var9 = new Buffer(var5.offset + var4.offset + 5 + var8.offset);
      var9.method2799(2);
      var9.method2799(var4.offset);
      var9.method2808(var4.payload, 0, var4.offset);
      var9.method2799(var5.offset);
      var9.method2808(var5.payload, 0, var5.offset);
      var9.method2837(var8.offset);
      var9.method2808(var8.payload, 0, var8.offset);
      String var10 = CollisionData.method2288(var9.payload);

      try {
         URL var11 = new URL(MessageNode.method203("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class213.method3959(var10) + "&dest=" + class213.method3959("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var16 = new String(var9.payload);
               if(var16.startsWith("OFFLINE")) {
                  return 4;
               } else if(var16.startsWith("WRONG")) {
                  return 7;
               } else if(var16.startsWith("RELOAD")) {
                  return 3;
               } else if(var16.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method2972(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var16 = new String(var9.payload, 0, var9.offset);
                  if(FileOnDisk.method1407(var16)) {
                     NPC.method714(var16, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var17) {
         var17.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass164;",
      garbageValue = "1787789600"
   )
   public class164 method3218(boolean var1) {
      if(this.field2232 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2232:this.textureId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally?1L:0L) << 39) + ((long)this.borderThickness << 36) + (long)var2 + ((this.flippedVertically?1L:0L) << 38);
         class164 var5 = (class164)field2193.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method3173(var1);
            if(var6 == null) {
               return null;
            } else {
               SpritePixels var7 = var6.method4197();
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
                     if(var7.image[var13 + var10 * var7.width] == 0) {
                        var12 = 1 + var13;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class164(var7.width, var7.height, var9, var8, var2);
               field2193.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "519728679"
   )
   static void method3221(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2691 = 0;
      var3.hash = (long)var0;
      var3.field2693 = var1;
      var3.field2690 = var2;
      Deque var4 = class183.field2727;
      synchronized(class183.field2727) {
         class183.field2727.method2407(var3);
      }

      Object var9 = class183.field2728;
      synchronized(class183.field2728) {
         if(class183.field2725 == 0) {
            class45.field899.method1968(new class183(), 5);
         }

         class183.field2725 = 600;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)V",
      garbageValue = "7"
   )
   static final void method3223(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field909 = 0;
      class88.method1884(var0);

      for(int var3 = 0; var3 < class45.field909; ++var3) {
         int var4 = class45.field906[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 128) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         byte var7 = -1;
         int var8;
         if((var6 & 32) != 0) {
            var8 = var0.readUnsignedByte();
            byte[] var9 = new byte[var8];
            Buffer var10 = new Buffer(var9);
            var0.method2824(var9, 0, var8);
            class45.field897[var4] = var10;
            var5.method220(var10);
         }

         int var20;
         if((var6 & 4) != 0) {
            var8 = var0.readUnsignedShort();
            if(var8 == '\uffff') {
               var8 = -1;
            }

            var20 = var0.readUnsignedByte();
            class175.method3242(var5, var8, var20);
         }

         if((var6 & 16) != 0) {
            var5.interacting = var0.readUnsignedShort();
            if(var5.interacting == '\uffff') {
               var5.interacting = -1;
            }
         }

         if((var6 & 1) != 0) {
            var5.overhead = var0.method2846();
            if(var5.overhead.charAt(0) == 126) {
               var5.overhead = var5.overhead.substring(1);
               class103.sendGameMessage(2, var5.name, var5.overhead);
            } else if(class16.localPlayer == var5) {
               class103.sendGameMessage(2, var5.name, var5.overhead);
            }

            var5.field606 = false;
            var5.field594 = 0;
            var5.field609 = 0;
            var5.field608 = 150;
         }

         int var11;
         int var12;
         if((var6 & 8) != 0) {
            var8 = var0.readUnsignedByte();
            int var13;
            int var14;
            int var21;
            if(var8 > 0) {
               for(var20 = 0; var20 < var8; ++var20) {
                  var11 = -1;
                  var12 = -1;
                  var13 = -1;
                  var21 = var0.method2979();
                  if(var21 == 32767) {
                     var21 = var0.method2979();
                     var12 = var0.method2979();
                     var11 = var0.method2979();
                     var13 = var0.method2979();
                  } else if(var21 != 32766) {
                     var12 = var0.method2979();
                  } else {
                     var21 = -1;
                  }

                  var14 = var0.method2979();
                  var5.method592(var21, var12, var11, var13, Client.gameCycle, var14);
               }
            }

            var20 = var0.readUnsignedByte();
            if(var20 > 0) {
               for(var21 = 0; var21 < var20; ++var21) {
                  var11 = var0.method2979();
                  var12 = var0.method2979();
                  if(var12 != 32767) {
                     var13 = var0.method2979();
                     var14 = var0.readUnsignedByte();
                     int var15 = var12 > 0?var0.readUnsignedByte():var14;
                     var5.method587(var11, Client.gameCycle, var12, var13, var14, var15);
                  } else {
                     var5.method584(var11);
                  }
               }
            }
         }

         if((var6 & 2) != 0) {
            var5.field620 = var0.readUnsignedShort();
            if(var5.field646 == 0) {
               var5.field643 = var5.field620;
               var5.field620 = -1;
            }
         }

         if((var6 & 64) != 0) {
            var8 = var0.readUnsignedShort();
            class177 var26 = (class177)TextureProvider.method1454(CombatInfoListHolder.method696(), var0.readUnsignedByte());
            boolean var29 = var0.readUnsignedByte() == 1;
            var11 = var0.readUnsignedByte();
            var12 = var0.offset;
            if(null != var5.name && var5.composition != null) {
               boolean var28 = false;
               if(var26.field2665 && class170.method3237(var5.name)) {
                  var28 = true;
               }

               if(!var28 && Client.field397 == 0 && !var5.field266) {
                  class45.field894.offset = 0;
                  var0.method2824(class45.field894.payload, 0, var11);
                  class45.field894.offset = 0;
                  Buffer var22 = class45.field894;

                  String var16;
                  int var17;
                  try {
                     var17 = var22.method2979();
                     if(var17 > 32767) {
                        var17 = 32767;
                     }

                     byte[] var18 = new byte[var17];
                     var22.offset += class210.field3117.method2745(var22.payload, var22.offset, var18, 0, var17);
                     String var19 = World.method610(var18, 0, var17);
                     var16 = var19;
                  } catch (Exception var25) {
                     var16 = "Cabbage";
                  }

                  var16 = FontTypeFace.method3919(class2.method22(var16));
                  var5.overhead = var16.trim();
                  var5.field594 = var8 >> 8;
                  var5.field609 = var8 & 255;
                  var5.field608 = 150;
                  var5.field606 = var29;
                  var5.inSequence = var5 != class16.localPlayer && var26.field2665 && Client.field297 != "" && var16.toLowerCase().indexOf(Client.field297) == -1;
                  if(var26.field2664) {
                     var17 = var29?91:1;
                  } else {
                     var17 = var29?90:2;
                  }

                  if(var26.field2663 != -1) {
                     class103.sendGameMessage(var17, class167.method3163(var26.field2663) + var5.name, var16);
                  } else {
                     class103.sendGameMessage(var17, var5.name, var16);
                  }
               }
            }

            var0.offset = var11 + var12;
         }

         if((var6 & 4096) != 0) {
            var5.graphic = var0.readUnsignedShort();
            var8 = var0.method2819();
            var5.field633 = var8 >> 16;
            var5.field618 = Client.gameCycle + (var8 & '\uffff');
            var5.field630 = 0;
            var5.field631 = 0;
            if(var5.field618 > Client.gameCycle) {
               var5.field630 = -1;
            }

            if(var5.graphic == '\uffff') {
               var5.graphic = -1;
            }
         }

         if((var6 & 256) != 0) {
            var5.field634 = var0.readByte();
            var5.field636 = var0.readByte();
            var5.field610 = var0.readByte();
            var5.field647 = var0.readByte();
            var5.field652 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field639 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field592 = var0.readUnsignedShort();
            if(var5.field262) {
               var5.field634 += var5.field245;
               var5.field636 += var5.field265;
               var5.field610 += var5.field245;
               var5.field647 += var5.field265;
               var5.field646 = 0;
            } else {
               var5.field634 += var5.pathX[0];
               var5.field636 += var5.pathY[0];
               var5.field610 += var5.pathX[0];
               var5.field647 += var5.pathY[0];
               var5.field646 = 1;
            }

            var5.field651 = 0;
         }

         if((var6 & 2048) != 0) {
            class45.field910[var4] = var0.readByte();
         }

         if((var6 & 1024) != 0) {
            var7 = var0.readByte();
         }

         if((var6 & 512) != 0) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.actions[var8] = var0.method2846();
            }
         }

         if(var5.field262) {
            if(var7 == 127) {
               var5.method224(var5.field245, var5.field265);
            } else {
               byte var27;
               if(var7 != -1) {
                  var27 = var7;
               } else {
                  var27 = class45.field910[var4];
               }

               var5.method247(var5.field245, var5.field265, var27);
            }
         }
      }

      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
