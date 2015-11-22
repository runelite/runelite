package net.runelite.rs.client;

import java.awt.Frame;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ac")
public class class39 extends class203 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2074828397
   )
   public int field866 = 1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1029029235
   )
   public int field867 = 1;
   @ObfuscatedName("g")
   short[] field868;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 209287787
   )
   public int field869;
   @ObfuscatedName("a")
   public String field870 = "null";
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -61110503
   )
   public int field871 = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -531852821
   )
   public int field872 = 1;
   @ObfuscatedName("t")
   int[] field873;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1589039629
   )
   int field874 = -1;
   @ObfuscatedName("i")
   int[] field875;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -651449459
   )
   int field876 = 128;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1821428005
   )
   public int field877 = 1;
   @ObfuscatedName("f")
   static class192 field879 = new class192(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1400001233
   )
   public int field880 = 1;
   @ObfuscatedName("ay")
   public boolean field881 = true;
   @ObfuscatedName("n")
   short[] field882;
   @ObfuscatedName("y")
   short[] field883;
   @ObfuscatedName("l")
   static class192 field884 = new class192(50);
   @ObfuscatedName("q")
   public String[] field885 = new String[5];
   @ObfuscatedName("x")
   public boolean field886 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 638513191
   )
   public int field887 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1685021823
   )
   int field888 = 128;
   @ObfuscatedName("b")
   public boolean field890 = false;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1436827567
   )
   int field891 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1118190007
   )
   int field892 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -637704171
   )
   public int field893 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 419972269
   )
   public int field894 = 32;
   @ObfuscatedName("ai")
   public int[] field895;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1991211053
   )
   public int field896 = 1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2056722197
   )
   int field897 = -1;
   @ObfuscatedName("av")
   public boolean field898 = false;
   @ObfuscatedName("az")
   public boolean field899 = true;
   @ObfuscatedName("v")
   short[] field900;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1152643655
   )
   public int field901 = 30;
   @ObfuscatedName("qi")
   protected static Frame field902;
   @ObfuscatedName("j")
   static class166 field903;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2118685993
   )
   public int field904 = 1;

   @ObfuscatedName("l")
   void method809(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method810(var1, var2);
      }
   }

   @ObfuscatedName("u")
   void method810(class118 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2536();
         this.field875 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field875[var4] = var1.method2538();
         }
      } else if(var2 == 2) {
         this.field870 = var1.method2544();
      } else if(12 == var2) {
         this.field871 = var1.method2536();
      } else if(var2 == 13) {
         this.field872 = var1.method2538() * -1;
      } else if(var2 == 14) {
         this.field877 = var1.method2538() * -1;
      } else if(var2 == 15) {
         this.field866 = var1.method2538() * -1;
      } else if(16 == var2) {
         this.field867 = var1.method2538() * -1;
      } else if(var2 == 17) {
         this.field877 = var1.method2538() * -1;
         this.field904 = var1.method2538() * -1;
         this.field896 = var1.method2538() * -1;
         this.field880 = var1.method2538() * -1;
      } else if(var2 >= 30 && var2 < 35) {
         this.field885[var2 - 30] = var1.method2544();
         if(this.field885[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field885[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2536();
         this.field868 = new short[var3];
         this.field882 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field868[var4] = (short)var1.method2538();
            this.field882[var4] = (short)var1.method2538();
         }
      } else if(var2 == 41) {
         var3 = var1.method2536();
         this.field883 = new short[var3];
         this.field900 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field883[var4] = (short)var1.method2538();
            this.field900[var4] = (short)var1.method2538();
         }
      } else if(var2 == 60) {
         var3 = var1.method2536();
         this.field873 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field873[var4] = var1.method2538();
         }
      } else if(var2 == 93) {
         this.field886 = false;
      } else if(95 == var2) {
         this.field887 = var1.method2538();
      } else if(var2 == 97) {
         this.field888 = var1.method2538();
      } else if(var2 == 98) {
         this.field876 = var1.method2538();
      } else if(99 == var2) {
         this.field890 = true;
      } else if(100 == var2) {
         this.field891 = var1.method2537();
      } else if(101 == var2) {
         this.field892 = var1.method2537();
      } else if(var2 == 102) {
         this.field893 = var1.method2538();
      } else if(var2 == 103) {
         this.field894 = var1.method2538();
      } else if(var2 == 106) {
         this.field874 = var1.method2538();
         if('\uffff' == this.field874) {
            this.field874 = -1;
         }

         this.field897 = var1.method2538();
         if(this.field897 == '\uffff') {
            this.field897 = -1;
         }

         var3 = var1.method2536();
         this.field895 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field895[var4] = var1.method2538();
            if(this.field895[var4] == '\uffff') {
               this.field895[var4] = -1;
            }
         }
      } else if(107 == var2) {
         this.field881 = false;
      } else if(var2 == 109) {
         this.field899 = false;
      } else if(var2 == 111) {
         this.field898 = true;
      } else if(var2 == 112) {
         this.field901 = var1.method2536();
      }

   }

   @ObfuscatedName("h")
   public final class99 method812() {
      if(this.field895 != null) {
         class39 var5 = this.method813();
         return var5 == null?null:var5.method812();
      } else if(null == this.field873) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field873.length; ++var2) {
            if(!class177.field2895.method3314(this.field873[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class99[] var6 = new class99[this.field873.length];

            for(int var3 = 0; var3 < this.field873.length; ++var3) {
               var6[var3] = class99.method2218(class177.field2895, this.field873[var3], 0);
            }

            class99 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class99(var6, var6.length);
            }

            int var4;
            if(this.field868 != null) {
               for(var4 = 0; var4 < this.field868.length; ++var4) {
                  var7.method2298(this.field868[var4], this.field882[var4]);
               }
            }

            if(null != this.field883) {
               for(var4 = 0; var4 < this.field883.length; ++var4) {
                  var7.method2233(this.field883[var4], this.field900[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   public final class39 method813() {
      int var1 = -1;
      if(this.field874 != -1) {
         var1 = class160.method3227(this.field874);
      } else if(this.field897 != -1) {
         var1 = class175.field2884[this.field897];
      }

      return var1 >= 0 && var1 < this.field895.length && this.field895[var1] != -1?class22.method618(this.field895[var1]):null;
   }

   @ObfuscatedName("a")
   public final class104 method823(class42 var1, int var2, class42 var3, int var4) {
      if(this.field895 != null) {
         class39 var11 = this.method813();
         return var11 == null?null:var11.method823(var1, var2, var3, var4);
      } else {
         class104 var5 = (class104)field884.method3808((long)this.field869);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field875.length; ++var7) {
               if(!class177.field2895.method3314(this.field875[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class99[] var8 = new class99[this.field875.length];

            int var9;
            for(var9 = 0; var9 < this.field875.length; ++var9) {
               var8[var9] = class99.method2218(class177.field2895, this.field875[var9], 0);
            }

            class99 var12;
            if(var8.length == 1) {
               var12 = var8[0];
            } else {
               var12 = new class99(var8, var8.length);
            }

            if(null != this.field868) {
               for(var9 = 0; var9 < this.field868.length; ++var9) {
                  var12.method2298(this.field868[var9], this.field882[var9]);
               }
            }

            if(null != this.field883) {
               for(var9 = 0; var9 < this.field883.length; ++var9) {
                  var12.method2233(this.field883[var9], this.field900[var9]);
               }
            }

            var5 = var12.method2247(64 + this.field891, this.field892 * 5 + 850, -30, -50, -30);
            field884.method3805(var5, (long)this.field869);
         }

         class104 var10;
         if(var1 != null && null != var3) {
            var10 = var1.method918(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method905(var5, var2);
         } else if(null != var3) {
            var10 = var3.method905(var5, var4);
         } else {
            var10 = var5.method2366(true);
         }

         if(this.field888 != 128 || 128 != this.field876) {
            var10.method2355(this.field888, this.field876, this.field888);
         }

         return var10;
      }
   }

   @ObfuscatedName("t")
   public boolean method827() {
      if(this.field895 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field874 != -1) {
            var1 = class160.method3227(this.field874);
         } else if(this.field897 != -1) {
            var1 = class175.field2884[this.field897];
         }

         return var1 >= 0 && var1 < this.field895.length && -1 != this.field895[var1];
      }
   }

   @ObfuscatedName("m")
   public static class52 method833(int var0) {
      class52 var1 = (class52)class52.field1144.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1149.method3352(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1117(new class118(var2));
         }

         class52.field1144.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   void method840() {
   }

   @ObfuscatedName("i")
   public static class80 method843(class166 var0, int var1) {
      if(!class152.method3190(var0, var1)) {
         return null;
      } else {
         class80 var3 = new class80();
         var3.field1413 = class76.field1367;
         var3.field1414 = class76.field1368;
         var3.field1411 = class76.field1366[0];
         var3.field1409 = class76.field1370[0];
         var3.field1407 = class76.field1371[0];
         var3.field1410 = class76.field1373[0];
         var3.field1412 = class76.field1369;
         var3.field1408 = class17.field236[0];
         class135.method2935();
         return var3;
      }
   }
}
