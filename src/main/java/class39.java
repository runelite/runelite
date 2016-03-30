import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -944412443
   )
   public int field885 = 1;
   @ObfuscatedName("t")
   static class193 field886 = new class193(64);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1256892495
   )
   public int field887 = -1;
   @ObfuscatedName("p")
   static class193 field888 = new class193(50);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1107108535
   )
   @Export("id")
   public int field889;
   @ObfuscatedName("y")
   @Export("name")
   public String field890 = "null";
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1506863509
   )
   int field891 = 128;
   @ObfuscatedName("c")
   @Export("models")
   int[] field892;
   @ObfuscatedName("k")
   @Export("actions")
   public String[] field893 = new String[5];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -376427251
   )
   int field894 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1280338233
   )
   public int field895 = -1;
   @ObfuscatedName("ac")
   public boolean field896 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -837326671
   )
   int field897 = 128;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1746114985
   )
   public int field898 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -756672049
   )
   @Export("combatLevel")
   public int field899 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -986083155
   )
   public int field900 = -1;
   @ObfuscatedName("u")
   short[] field901;
   @ObfuscatedName("i")
   short[] field902;
   @ObfuscatedName("o")
   short[] field903;
   @ObfuscatedName("h")
   short[] field904;
   @ObfuscatedName("w")
   public static class167 field905;
   @ObfuscatedName("f")
   @Export("isMinimapVisible")
   public boolean field906 = true;
   @ObfuscatedName("x")
   public static class167 field907;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1261469603
   )
   int field908 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -903216633
   )
   public int field909 = -1;
   @ObfuscatedName("b")
   @Export("isVisible")
   public boolean field910 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 731766127
   )
   public int field911 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1516908977
   )
   int field912 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1979658381
   )
   public int field913 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -604363671
   )
   public int field914 = 32;
   @ObfuscatedName("ai")
   public int[] field915;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1905576079
   )
   int field916 = -1;
   @ObfuscatedName("bw")
   static class168 field917;
   @ObfuscatedName("v")
   int[] field918;
   @ObfuscatedName("ah")
   @Export("isClickable")
   public boolean field919 = true;
   @ObfuscatedName("ae")
   public boolean field920 = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1110705333
   )
   public int field921 = 30;
   @ObfuscatedName("ag")
   static boolean field922;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1266727597
   )
   public int field923 = -1;

   @ObfuscatedName("x")
   void method788() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1176136884"
   )
   void method790(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2506();
         this.field892 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field892[var4] = var1.method2508();
         }
      } else if(var2 == 2) {
         this.field890 = var1.method2683();
      } else if(var2 == 12) {
         this.field885 = var1.method2506();
      } else if(var2 == 13) {
         this.field923 = var1.method2508();
      } else if(var2 == 14) {
         this.field911 = var1.method2508();
      } else if(var2 == 15) {
         this.field895 = var1.method2508();
      } else if(var2 == 16) {
         this.field909 = var1.method2508();
      } else if(var2 == 17) {
         this.field911 = var1.method2508();
         this.field898 = var1.method2508();
         this.field887 = var1.method2508();
         this.field900 = var1.method2508();
      } else if(var2 >= 30 && var2 < 35) {
         this.field893[var2 - 30] = var1.method2683();
         if(this.field893[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field893[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2506();
         this.field901 = new short[var3];
         this.field902 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field901[var4] = (short)var1.method2508();
            this.field902[var4] = (short)var1.method2508();
         }
      } else if(41 == var2) {
         var3 = var1.method2506();
         this.field903 = new short[var3];
         this.field904 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field903[var4] = (short)var1.method2508();
            this.field904[var4] = (short)var1.method2508();
         }
      } else if(var2 == 60) {
         var3 = var1.method2506();
         this.field918 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field918[var4] = var1.method2508();
         }
      } else if(93 == var2) {
         this.field906 = false;
      } else if(95 == var2) {
         this.field899 = var1.method2508();
      } else if(var2 == 97) {
         this.field891 = var1.method2508();
      } else if(98 == var2) {
         this.field897 = var1.method2508();
      } else if(var2 == 99) {
         this.field910 = true;
      } else if(100 == var2) {
         this.field894 = var1.method2524();
      } else if(var2 == 101) {
         this.field912 = var1.method2524() * 5;
      } else if(var2 == 102) {
         this.field913 = var1.method2508();
      } else if(var2 == 103) {
         this.field914 = var1.method2508();
      } else if(106 == var2) {
         this.field916 = var1.method2508();
         if(this.field916 == '\uffff') {
            this.field916 = -1;
         }

         this.field908 = var1.method2508();
         if('\uffff' == this.field908) {
            this.field908 = -1;
         }

         var3 = var1.method2506();
         this.field915 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field915[var4] = var1.method2508();
            if(this.field915[var4] == '\uffff') {
               this.field915[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field896 = false;
      } else if(var2 == 109) {
         this.field919 = false;
      } else if(111 == var2) {
         this.field920 = true;
      } else if(var2 == 112) {
         this.field921 = var1.method2506();
      }

   }

   @ObfuscatedName("e")
   public final class105 method792(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field915) {
         class39 var11 = this.method793();
         return null == var11?null:var11.method792(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field888.method3771((long)this.field889);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field892.length; ++var7) {
               if(!field907.method3290(this.field892[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field892.length];

            int var9;
            for(var9 = 0; var9 < this.field892.length; ++var9) {
               var8[var9] = class100.method2214(field907, this.field892[var9], 0);
            }

            class100 var12;
            if(1 == var8.length) {
               var12 = var8[0];
            } else {
               var12 = new class100(var8, var8.length);
            }

            if(null != this.field901) {
               for(var9 = 0; var9 < this.field901.length; ++var9) {
                  var12.method2238(this.field901[var9], this.field902[var9]);
               }
            }

            if(this.field903 != null) {
               for(var9 = 0; var9 < this.field903.length; ++var9) {
                  var12.method2205(this.field903[var9], this.field904[var9]);
               }
            }

            var5 = var12.method2212(this.field894 + 64, 850 + this.field912, -30, -50, -30);
            field888.method3773(var5, (long)this.field889);
         }

         class105 var10;
         if(null != var1 && null != var3) {
            var10 = var1.method909(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method902(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method902(var5, var4);
         } else {
            var10 = var5.method2311(true);
         }

         if(128 != this.field891 || 128 != this.field897) {
            var10.method2315(this.field891, this.field897, this.field891);
         }

         return var10;
      }
   }

   @ObfuscatedName("m")
   public final class39 method793() {
      int var1 = -1;
      if(-1 != this.field916) {
         var1 = class152.method3179(this.field916);
      } else if(-1 != this.field908) {
         var1 = class176.field2916[this.field908];
      }

      return var1 >= 0 && var1 < this.field915.length && -1 != this.field915[var1]?class36.method759(this.field915[var1]):null;
   }

   @ObfuscatedName("c")
   public boolean method794() {
      if(this.field915 == null) {
         return true;
      } else {
         int var1 = -1;
         if(-1 != this.field916) {
            var1 = class152.method3179(this.field916);
         } else if(-1 != this.field908) {
            var1 = class176.field2916[this.field908];
         }

         return var1 >= 0 && var1 < this.field915.length && -1 != this.field915[var1];
      }
   }

   @ObfuscatedName("ct")
   static final void method797(int var0, int var1) {
      if(method817(var0)) {
         class9.method114(class173.field2830[var0], var1);
      }
   }

   @ObfuscatedName("t")
   void method798(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method790(var1, var2);
      }
   }

   @ObfuscatedName("y")
   public final class100 method809() {
      if(this.field915 != null) {
         class39 var5 = this.method793();
         return null == var5?null:var5.method809();
      } else if(this.field918 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field918.length; ++var2) {
            if(!field907.method3290(this.field918[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var6 = new class100[this.field918.length];

            for(int var3 = 0; var3 < this.field918.length; ++var3) {
               var6[var3] = class100.method2214(field907, this.field918[var3], 0);
            }

            class100 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class100(var6, var6.length);
            }

            int var4;
            if(this.field901 != null) {
               for(var4 = 0; var4 < this.field901.length; ++var4) {
                  var7.method2238(this.field901[var4], this.field902[var4]);
               }
            }

            if(this.field903 != null) {
               for(var4 = 0; var4 < this.field903.length; ++var4) {
                  var7.method2205(this.field903[var4], this.field904[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-37"
   )
   static final void method814(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field396 + var5 * (client.field549 - client.field396) / 100;
      int var7 = var6 * var3 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field527) {
         var14 = client.field527;
         var6 = 334 * var14 * var2 / (512 * var3);
         if(var6 > client.field553) {
            var6 = client.field553;
            var8 = var3 * var6 * 512 / (var14 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1772();
               class79.method1800(var0, var1, var9, var3, -16777216);
               class79.method1800(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field555) {
         var14 = client.field555;
         var6 = 334 * var2 * var14 / (512 * var3);
         if(var6 < client.field383) {
            var6 = client.field383;
            var8 = var2 * var14 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1772();
               class79.method1800(var0, var1, var2, var9, -16777216);
               class79.method1800(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = client.field564 + (client.field551 - client.field564) * var5 / 100;
      client.field560 = var8 * var3 * var6 / 85504 << 1;
      if(client.field306 != var2 || client.field559 != var3) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = 600 + var11 * 3;
            int var13 = class91.field1573[var11];
            var15[var10] = var13 * var12 >> 16;
         }

         class86.method1951(var15, 500, 800, var2, var3);
      }

      client.field428 = var0;
      client.field557 = var1;
      client.field306 = var2;
      client.field559 = var3;
   }

   @ObfuscatedName("w")
   public static String method815(long var0) {
      class111.field1965.setTime(new Date(var0));
      int var2 = class111.field1965.get(7);
      int var3 = class111.field1965.get(5);
      int var4 = class111.field1965.get(2);
      int var5 = class111.field1965.get(1);
      int var6 = class111.field1965.get(11);
      int var7 = class111.field1965.get(12);
      int var8 = class111.field1965.get(13);
      return class111.field1963[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class111.field1966[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("p")
   public static boolean method817(int var0) {
      if(class173.field2759[var0]) {
         return true;
      } else if(!class138.field2153.method3291(var0)) {
         return false;
      } else {
         int var1 = class138.field2153.method3330(var0);
         if(var1 == 0) {
            class173.field2759[var0] = true;
            return true;
         } else {
            if(class173.field2830[var0] == null) {
               class173.field2830[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class173.field2830[var0][var2]) {
                  byte[] var3 = class138.field2153.method3335(var0, var2);
                  if(var3 != null) {
                     class173.field2830[var0][var2] = new class173();
                     class173.field2830[var0][var2].field2838 = (var0 << 16) + var2;
                     if(-1 == var3[0]) {
                        class173.field2830[var0][var2].method3416(new class119(var3));
                     } else {
                        class173.field2830[var0][var2].method3415(new class119(var3));
                     }
                  }
               }
            }

            class173.field2759[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   public static int method818(byte[] var0, int var1) {
      return class82.method1877(var0, 0, var1);
   }

   @ObfuscatedName("x")
   public static void method819(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2968 = 1;
      class151.field2279 = var0;
      class72.field1358 = var1;
      class183.field2964 = var2;
      class183.field2970 = var3;
      class14.field225 = var4;
      class75.field1384 = 10000;
   }

   @ObfuscatedName("t")
   static class78[] method820(class167 var0, int var1, int var2) {
      return !class121.method2747(var0, var1, var2)?null:class22.method594();
   }
}
