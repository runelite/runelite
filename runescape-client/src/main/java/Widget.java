import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("Widget")
public class Widget extends Node {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1695835809
   )
   public int field2196;
   @ObfuscatedName("n")
   static IndexDataBase field2197;
   @ObfuscatedName("q")
   static IndexDataBase field2198;
   @ObfuscatedName("p")
   static IndexDataBase field2199;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 247112443
   )
   public int field2200;
   @ObfuscatedName("c")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("z")
   public static NodeCache field2202 = new NodeCache(50);
   @ObfuscatedName("ej")
   public boolean field2203;
   @ObfuscatedName("v")
   public static NodeCache field2204 = new NodeCache(8);
   @ObfuscatedName("g")
   public static boolean field2205 = false;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1581772209
   )
   public int field2206 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -521365795
   )
   @Export("id")
   public int id = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1995904041
   )
   @Export("index")
   public int index = -1;
   @ObfuscatedName("cv")
   public Object[] field2209;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2107442863
   )
   public int field2210 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1909504737
   )
   @Export("contentType")
   public int contentType = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -883602349
   )
   public int field2212 = 0;
   @ObfuscatedName("en")
   public String field2213;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 852625173
   )
   public int field2214;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1511403033
   )
   public int field2215 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1548897025
   )
   @Export("originalX")
   public int originalX = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1765191697
   )
   @Export("originalY")
   public int originalY = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 368253995
   )
   @Export("originalWidth")
   public int originalWidth = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1962510781
   )
   public int field2219 = 0;
   @ObfuscatedName("dc")
   public Object[] field2220;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1381872461
   )
   @Export("relativeY")
   public int relativeY = 0;
   @ObfuscatedName("dr")
   public Object[] field2222;
   @ObfuscatedName("cm")
   public int[] field2223;
   @ObfuscatedName("br")
   @Export("flippedVertically")
   public boolean flippedVertically;
   @ObfuscatedName("an")
   public boolean field2225;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1722293023
   )
   @Export("parentId")
   public int parentId = -1;
   @ObfuscatedName("aa")
   @Export("isHidden")
   public boolean isHidden = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -875368155
   )
   @Export("scrollX")
   public int scrollX = 0;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -48015137
   )
   public int field2229;
   @ObfuscatedName("bh")
   public boolean field2230;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -71948017
   )
   @Export("modelId")
   public int modelId;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1409189791
   )
   @Export("textColor")
   public int textColor = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1989543145
   )
   @Export("scrollY")
   public int scrollY = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -645853793
   )
   public int field2234 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1196715691
   )
   public int field2235 = 0;
   @ObfuscatedName("ar")
   public boolean field2236 = false;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 649935261
   )
   public int field2237;
   @ObfuscatedName("ab")
   public class225 field2238;
   @ObfuscatedName("l")
   public static NodeCache field2239 = new NodeCache(20);
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1593959261
   )
   @Export("scrollWidth")
   public int scrollWidth = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1463367757
   )
   @Export("opacity")
   public int opacity;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -307750191
   )
   @Export("textureId")
   public int textureId;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1324992533
   )
   public int field2243;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -522103111
   )
   public int field2244;
   @ObfuscatedName("ap")
   public boolean field2245;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1140303713
   )
   @Export("borderThickness")
   public int borderThickness;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 293509327
   )
   @Export("sprite2")
   public int sprite2;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -796468665
   )
   public int field2248;
   @ObfuscatedName("bk")
   @Export("flippedHorizontally")
   public boolean flippedHorizontally;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1549513609
   )
   @Export("modelType")
   public int modelType;
   @ObfuscatedName("t")
   static IndexDataBase field2251;
   @ObfuscatedName("cq")
   @Export("dragParent")
   public Widget dragParent;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 244033193
   )
   int field2253;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -441554369
   )
   public int field2254;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1208269969
   )
   public int field2255;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -826385575
   )
   public int field2256;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -917322825
   )
   public int field2257;
   @ObfuscatedName("u")
   public static NodeCache field2258 = new NodeCache(200);
   @ObfuscatedName("cz")
   @Export("name")
   public String name;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 517141667
   )
   public int field2260;
   @ObfuscatedName("dl")
   public Object[] field2261;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1509976927
   )
   @Export("scrollHeight")
   public int scrollHeight = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1607778841
   )
   @Export("rotationX")
   public int rotationX;
   @ObfuscatedName("dq")
   public int[] field2264;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -378540757
   )
   public int field2265;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -883345185
   )
   @Export("fontId")
   public int fontId;
   @ObfuscatedName("bg")
   @Export("text")
   public String text;
   @ObfuscatedName("ba")
   public String field2268;
   @ObfuscatedName("dx")
   public Object[] field2269;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2058985715
   )
   public int field2270;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 55380583
   )
   public int field2271;
   @ObfuscatedName("bt")
   public boolean field2272;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1918153715
   )
   public int field2273;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1593829579
   )
   public int field2274;
   @ObfuscatedName("ew")
   public boolean field2275;
   @ObfuscatedName("ck")
   public int[] field2276;
   @ObfuscatedName("cf")
   public int[] field2277;
   @ObfuscatedName("cj")
   public String[] field2278;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -365137369
   )
   public int field2279 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -406228719
   )
   public int field2280 = 0;
   @ObfuscatedName("ct")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1905201711
   )
   public int field2282;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 103815475
   )
   public int field2283;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1490517497
   )
   public int field2284;
   @ObfuscatedName("cc")
   public boolean field2285;
   @ObfuscatedName("cr")
   public String field2286;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 801326607
   )
   public int field2287;
   @ObfuscatedName("ci")
   public Object[] field2288;
   @ObfuscatedName("co")
   public Object[] field2289;
   @ObfuscatedName("ce")
   public boolean field2290;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1770827179
   )
   @Export("boundsIndex")
   public int boundsIndex;
   @ObfuscatedName("ca")
   public Object[] field2292;
   @ObfuscatedName("cd")
   public Object[] field2293;
   @ObfuscatedName("cw")
   public Object[] field2294;
   @ObfuscatedName("ch")
   public Object[] field2295;
   @ObfuscatedName("dg")
   public Object[] field2296;
   @ObfuscatedName("dt")
   public Object[] field2297;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -235099573
   )
   public int field2298;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 457087063
   )
   @Export("rotationZ")
   public int rotationZ;
   @ObfuscatedName("do")
   public Object[] field2300;
   @ObfuscatedName("dy")
   public int[] field2301;
   @ObfuscatedName("cp")
   public Object[] field2302;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -104414591
   )
   int field2303;
   @ObfuscatedName("dp")
   public Object[] field2304;
   @ObfuscatedName("df")
   public int[] field2305;
   @ObfuscatedName("dw")
   public Object[] field2306;
   @ObfuscatedName("dh")
   public Object[] field2307;
   @ObfuscatedName("ds")
   public Object[] field2308;
   @ObfuscatedName("dj")
   public Object[] field2309;
   @ObfuscatedName("di")
   public Object[] field2310;
   @ObfuscatedName("da")
   public Object[] field2311;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1295500677
   )
   @Export("rotationY")
   public int rotationY;
   @ObfuscatedName("em")
   @Export("tooltip")
   public String tooltip;
   @ObfuscatedName("de")
   public Object[] field2314;
   @ObfuscatedName("dn")
   public Object[] field2315;
   @ObfuscatedName("dm")
   public Object[] field2316;
   @ObfuscatedName("dv")
   public Object[] field2317;
   @ObfuscatedName("dz")
   public Object[] field2318;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1416143611
   )
   @Export("relativeX")
   public int relativeX = 0;
   @ObfuscatedName("dd")
   public int[] field2320;
   @ObfuscatedName("du")
   public int[] field2321;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -439260841
   )
   public int field2322;
   @ObfuscatedName("w")
   @Export("hasScript")
   public boolean hasScript = false;
   @ObfuscatedName("db")
   @Export("dynamicValues")
   public int[][] dynamicValues;
   @ObfuscatedName("eh")
   @Export("itemIds")
   public int[] itemIds;
   @ObfuscatedName("es")
   @Export("itemQuantities")
   public int[] itemQuantities;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1236134309
   )
   @Export("item")
   public int item;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -2058219481
   )
   @Export("stackSize")
   public int stackSize;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1056431989
   )
   public int field2329;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1591319963
   )
   @Export("type")
   public int type;
   @ObfuscatedName("et")
   @Export("children")
   public Widget[] children;
   @ObfuscatedName("ef")
   public boolean field2332;
   @ObfuscatedName("ep")
   public boolean field2333;
   @ObfuscatedName("dk")
   public Object[] field2334;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1846735173
   )
   @Export("width")
   public int width = 0;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1412992169
   )
   public int field2336;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 850517457
   )
   public int field2337;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 724396741
   )
   public int field2338 = 1;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 1195127585
   )
   public int field2339;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1573207255
   )
   @Export("height")
   public int height = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1508859163
   )
   public int field2341 = 1;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-251613776"
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
         this.field2219 = var1.readShort();
      } else {
         this.field2219 = var1.readUnsignedShort();
      }

      this.field2280 = var1.readByte();
      this.field2215 = var1.readByte();
      this.field2212 = var1.readByte();
      this.field2206 = var1.readByte();
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
         this.field2275 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.textureId = var1.readInt();
         this.field2196 = var1.readUnsignedShort();
         this.field2245 = var1.readUnsignedByte() == 1;
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

         this.field2256 = var1.readShort();
         this.field2257 = var1.readShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
         this.rotationY = var1.readUnsignedShort();
         this.field2244 = var1.readUnsignedShort();
         this.field2254 = var1.readUnsignedShort();
         if(this.field2254 == '\uffff') {
            this.field2254 = -1;
         }

         this.field2230 = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.field2280 != 0) {
            this.field2298 = var1.readUnsignedShort();
         }

         if(this.field2215 != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.text = var1.readString();
         this.field2287 = var1.readUnsignedByte();
         this.field2270 = var1.readUnsignedByte();
         this.field2271 = var1.readUnsignedByte();
         this.field2272 = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
      }

      if(this.type == 3) {
         this.textColor = var1.readInt();
         this.field2236 = var1.readUnsignedByte() == 1;
         this.opacity = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.field2282 = var1.readUnsignedByte();
         this.textColor = var1.readInt();
         this.field2225 = var1.readUnsignedByte() == 1;
      }

      this.field2237 = var1.read24BitInt();
      this.name = var1.readString();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.readString();
         }
      }

      this.field2283 = var1.readUnsignedByte();
      this.field2284 = var1.readUnsignedByte();
      this.field2290 = var1.readUnsignedByte() == 1;
      this.field2286 = var1.readString();
      this.field2288 = this.method3190(var1);
      this.field2293 = this.method3190(var1);
      this.field2295 = this.method3190(var1);
      this.field2334 = this.method3190(var1);
      this.field2261 = this.method3190(var1);
      this.field2300 = this.method3190(var1);
      this.field2269 = this.method3190(var1);
      this.field2304 = this.method3190(var1);
      this.field2306 = this.method3190(var1);
      this.field2307 = this.method3190(var1);
      this.field2294 = this.method3190(var1);
      this.field2289 = this.method3190(var1);
      this.field2209 = this.method3190(var1);
      this.field2302 = this.method3190(var1);
      this.field2292 = this.method3190(var1);
      this.field2296 = this.method3190(var1);
      this.field2297 = this.method3190(var1);
      this.field2308 = this.method3190(var1);
      this.field2301 = this.method3223(var1);
      this.field2264 = this.method3223(var1);
      this.field2305 = this.method3223(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[Ljava/lang/Object;",
      garbageValue = "1366362290"
   )
   Object[] method3190(Buffer var1) {
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

         this.field2285 = true;
         return var3;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1111444242"
   )
   public void method3192(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "-949710054"
   )
   public SpritePixels method3193(boolean var1) {
      field2205 = false;
      int var2;
      if(var1) {
         var2 = this.field2243;
      } else {
         var2 = this.textureId;
      }

      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally?1L:0L) << 39) + ((this.flippedVertically?1L:0L) << 38) + (long)var2 + ((long)this.borderThickness << 36);
         SpritePixels var5 = (SpritePixels)field2258.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            var5 = Ignore.method203(field2251, var2, 0);
            if(var5 == null) {
               field2205 = true;
               return null;
            } else {
               if(this.flippedVertically) {
                  var5.method4305();
               }

               if(this.flippedHorizontally) {
                  var5.method4278();
               }

               if(this.borderThickness > 0) {
                  var5.method4302(this.borderThickness);
               }

               if(this.borderThickness >= 1) {
                  var5.method4226(1);
               }

               if(this.borderThickness >= 2) {
                  var5.method4226(16777215);
               }

               if(this.sprite2 != 0) {
                  var5.method4225(this.sprite2);
               }

               field2258.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "686236510"
   )
   public Font method3194() {
      field2205 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)field2239.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Tile.method1568(field2251, field2199, this.fontId, 0);
            if(var1 != null) {
               field2239.put(var1, (long)this.fontId);
            } else {
               field2205 = true;
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)LSpritePixels;",
      garbageValue = "-60"
   )
   public SpritePixels method3195(int var1) {
      field2205 = false;
      if(var1 >= 0 && var1 < this.field2277.length) {
         int var2 = this.field2277[var1];
         if(var2 == -1) {
            return null;
         } else {
            SpritePixels var3 = (SpritePixels)field2258.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = Ignore.method203(field2251, var2, 0);
               if(var3 != null) {
                  field2258.put(var3, (long)var2);
               } else {
                  field2205 = true;
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
      signature = "(LSequence;IZLPlayerComposition;I)LModel;",
      garbageValue = "-396707552"
   )
   public Model method3196(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
      field2205 = false;
      int var5;
      int var6;
      if(var3) {
         var5 = this.field2303;
         var6 = this.field2253;
      } else {
         var5 = this.modelType;
         var6 = this.modelId;
      }

      if(var5 == 0) {
         return null;
      } else if(var5 == 1 && var6 == -1) {
         return null;
      } else {
         Model var7 = (Model)field2202.get((long)(var6 + (var5 << 16)));
         if(var7 == null) {
            ModelData var8;
            if(var5 == 1) {
               var8 = ModelData.method1479(field2198, var6, 0);
               if(var8 == null) {
                  field2205 = true;
                  return null;
               }

               var7 = var8.method1502(64, 768, -50, -10, -50);
            }

            if(var5 == 2) {
               var8 = getNpcDefinition(var6).method3832();
               if(var8 == null) {
                  field2205 = true;
                  return null;
               }

               var7 = var8.method1502(64, 768, -50, -10, -50);
            }

            if(var5 == 3) {
               if(var4 == null) {
                  return null;
               }

               var8 = var4.method3155();
               if(var8 == null) {
                  field2205 = true;
                  return null;
               }

               var7 = var8.method1502(64, 768, -50, -10, -50);
            }

            if(var5 == 4) {
               ItemComposition var9 = class47.getItemDefinition(var6);
               var8 = var9.method3785(10);
               if(var8 == null) {
                  field2205 = true;
                  return null;
               }

               var7 = var8.method1502(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            field2202.put(var7, (long)((var5 << 16) + var6));
         }

         if(var1 != null) {
            var7 = var1.method3865(var7, var2);
         }

         return var7;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass166;",
      garbageValue = "212121291"
   )
   public class166 method3211(boolean var1) {
      if(this.field2243 == -1) {
         var1 = false;
      }

      int var2 = var1?this.field2243:this.textureId;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((long)this.sprite2 << 40) + ((this.flippedVertically?1L:0L) << 38) + ((long)this.borderThickness << 36) + (long)var2 + ((this.flippedHorizontally?1L:0L) << 39);
         class166 var5 = (class166)field2204.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            SpritePixels var6 = this.method3193(var1);
            if(var6 == null) {
               return null;
            } else {
               SpritePixels var7 = var6.method4308();
               int[] var8 = new int[var7.height];
               int[] var9 = new int[var7.height];

               for(int var10 = 0; var10 < var7.height; ++var10) {
                  int var11 = 0;
                  int var12 = var7.width;

                  int var13;
                  for(var13 = 0; var13 < var7.width; ++var13) {
                     if(var7.image[var13 + var7.width * var10] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.width - 1; var13 >= var11; --var13) {
                     if(var7.image[var13 + var10 * var7.width] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new class166(var7.width, var7.height, var9, var8, var2);
               field2204.put(var5, var3);
               return var5;
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1025406237"
   )
   void method3218(Buffer var1) {
      this.hasScript = false;
      this.type = var1.readUnsignedByte();
      this.field2210 = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.originalX = var1.readShort();
      this.originalY = var1.readShort();
      this.originalWidth = var1.readUnsignedShort();
      this.field2219 = var1.readUnsignedShort();
      this.opacity = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == '\uffff') {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.field2322 = var1.readUnsignedShort();
      if(this.field2322 == '\uffff') {
         this.field2322 = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.field2320 = new int[var2];
         this.field2321 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field2320[var3] = var1.readUnsignedByte();
            this.field2321[var3] = var1.readUnsignedShort();
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
         this.itemIds = new int[this.originalWidth * this.field2219];
         this.itemQuantities = new int[this.originalWidth * this.field2219];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2237 |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.field2237 |= 1073741824;
         }

         var10 = var1.readUnsignedByte();
         if(var10 == 1) {
            this.field2237 |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.field2237 |= 536870912;
         }

         this.field2273 = var1.readUnsignedByte();
         this.field2274 = var1.readUnsignedByte();
         this.field2223 = new int[20];
         this.field2276 = new int[20];
         this.field2277 = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var11 = var1.readUnsignedByte();
            if(var11 == 1) {
               this.field2223[var8] = var1.readShort();
               this.field2276[var8] = var1.readShort();
               this.field2277[var8] = var1.readInt();
            } else {
               this.field2277[var8] = -1;
            }
         }

         this.field2278 = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var9 = var1.readString();
            if(var9.length() > 0) {
               this.field2278[var8] = var9;
               this.field2237 |= 1 << var8 + 23;
            }
         }
      }

      if(this.type == 3) {
         this.field2236 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.field2270 = var1.readUnsignedByte();
         this.field2271 = var1.readUnsignedByte();
         this.field2287 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2272 = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readString();
         this.field2268 = var1.readString();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.field2279 = var1.readInt();
         this.field2234 = var1.readInt();
         this.field2235 = var1.readInt();
      }

      if(this.type == 5) {
         this.textureId = var1.readInt();
         this.field2243 = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == '\uffff') {
            this.modelId = -1;
         }

         this.field2303 = 1;
         this.field2253 = var1.readUnsignedShort();
         if(this.field2253 == '\uffff') {
            this.field2253 = -1;
         }

         this.field2254 = var1.readUnsignedShort();
         if(this.field2254 == '\uffff') {
            this.field2254 = -1;
         }

         this.field2255 = var1.readUnsignedShort();
         if(this.field2255 == '\uffff') {
            this.field2255 = -1;
         }

         this.field2244 = var1.readUnsignedShort();
         this.rotationX = var1.readUnsignedShort();
         this.rotationZ = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.originalWidth * this.field2219];
         this.itemQuantities = new int[this.field2219 * this.originalWidth];
         this.field2270 = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == '\uffff') {
            this.fontId = -1;
         }

         this.field2272 = var1.readUnsignedByte() == 1;
         this.textColor = var1.readInt();
         this.field2273 = var1.readShort();
         this.field2274 = var1.readShort();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.field2237 |= 1073741824;
         }

         this.field2278 = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var6 = var1.readString();
            if(var6.length() > 0) {
               this.field2278[var5] = var6;
               this.field2237 |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.readString();
      }

      if(this.field2210 == 2 || this.type == 2) {
         this.field2286 = var1.readString();
         this.field2213 = var1.readString();
         var4 = var1.readUnsignedShort() & 63;
         this.field2237 |= var4 << 11;
      }

      if(this.field2210 == 1 || this.field2210 == 4 || this.field2210 == 5 || this.field2210 == 6) {
         this.tooltip = var1.readString();
         if(this.tooltip.length() == 0) {
            if(this.field2210 == 1) {
               this.tooltip = "Ok";
            }

            if(this.field2210 == 4) {
               this.tooltip = "Select";
            }

            if(this.field2210 == 5) {
               this.tooltip = "Select";
            }

            if(this.field2210 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if(this.field2210 == 1 || this.field2210 == 4 || this.field2210 == 5) {
         this.field2237 |= 4194304;
      }

      if(this.field2210 == 6) {
         this.field2237 |= 1;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)[I",
      garbageValue = "-167851585"
   )
   int[] method3223(Buffer var1) {
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
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-56"
   )
   public void method3232(int var1, String var2) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "2067600948"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3035.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3038.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3825(new Buffer(var2));
         }

         var1.method3800();
         NPCComposition.field3035.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1112169496"
   )
   public static boolean method3242(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-1893487566"
   )
   static void method3243(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1684, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.method2376(var0.getPath());
         if(var1 != null) {
            var3.method2376("");
         }

         var2.method1424(var3.payload, 0, var3.offset);
         var2.method1425();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public Widget() {
      this.field2238 = class225.field3224;
      this.opacity = 0;
      this.field2248 = 0;
      this.field2282 = 1;
      this.field2225 = false;
      this.textureId = -1;
      this.field2243 = -1;
      this.field2196 = 0;
      this.field2245 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.field2303 = 1;
      this.field2253 = -1;
      this.field2254 = -1;
      this.field2255 = -1;
      this.field2256 = 0;
      this.field2257 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.field2244 = 100;
      this.field2298 = 0;
      this.field2260 = 0;
      this.field2230 = false;
      this.field2265 = 2;
      this.fontId = -1;
      this.text = "";
      this.field2268 = "";
      this.field2287 = 0;
      this.field2270 = 0;
      this.field2271 = 0;
      this.field2272 = false;
      this.field2273 = 0;
      this.field2274 = 0;
      this.field2237 = 0;
      this.name = "";
      this.dragParent = null;
      this.field2283 = 0;
      this.field2284 = 0;
      this.field2290 = false;
      this.field2286 = "";
      this.field2285 = false;
      this.field2322 = -1;
      this.field2213 = "";
      this.tooltip = "Ok";
      this.item = -1;
      this.stackSize = 0;
      this.field2329 = 0;
      this.field2214 = 0;
      this.field2332 = false;
      this.field2333 = false;
      this.field2200 = -1;
      this.field2229 = 0;
      this.field2336 = 0;
      this.field2337 = 0;
      this.boundsIndex = -1;
      this.field2339 = -1;
      this.field2275 = false;
      this.field2203 = false;
   }
}
