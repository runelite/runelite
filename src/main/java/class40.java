import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("ObjectComposition")
public class class40 extends class203 {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -348176159
   )
   int field922 = -1;
   @ObfuscatedName("ah")
   boolean field923 = false;
   @ObfuscatedName("f")
   public static class166 field924;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -581214571
   )
   public int field925 = 2;
   @ObfuscatedName("m")
   static class99[] field926 = new class99[4];
   @ObfuscatedName("e")
   public static class192 field927 = new class192(30);
   @ObfuscatedName("au")
   public int[] field928;
   @ObfuscatedName("w")
   public boolean field929 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2008846663
   )
   public int field930;
   @ObfuscatedName("n")
   int[] field931;
   @ObfuscatedName("l")
   int[] field932;
   @ObfuscatedName("y")
   public static class192 field933 = new class192(500);
   @ObfuscatedName("g")
   public static class192 field934 = new class192(30);
   @ObfuscatedName("v")
   short[] field935;
   @ObfuscatedName("z")
   short[] field936;
   @ObfuscatedName("u")
   short[] field937;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1790266409
   )
   public int field938 = 1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2094329729
   )
   public int field939 = 1;
   @ObfuscatedName("a")
   public static boolean field940 = false;
   @ObfuscatedName("x")
   public boolean field941 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1992128375
   )
   public int field942 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -122418777
   )
   public int field943 = -1;
   @ObfuscatedName("q")
   boolean field944 = false;
   @ObfuscatedName("s")
   public static class192 field945 = new class192(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2142789655
   )
   public int field946 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 923250961
   )
   int field947 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -152279859
   )
   int field948 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1896017759
   )
   int field949 = 0;
   @ObfuscatedName("aw")
   @Export("actions")
   public String[] field950 = new String[5];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1062840563
   )
   public int field951 = 16;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 148765475
   )
   public int field952 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -432514111
   )
   int field953 = 128;
   @ObfuscatedName("h")
   @Export("name")
   public String field954 = "null";
   @ObfuscatedName("an")
   public int[] field955;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 419625921
   )
   int field956 = 128;
   @ObfuscatedName("i")
   short[] field957;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2096658407
   )
   int field958 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1239652733
   )
   int field959 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1815964191
   )
   int field960 = 0;
   @ObfuscatedName("ar")
   public boolean field961 = false;
   @ObfuscatedName("aa")
   boolean field962 = false;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1785130145
   )
   public int field963 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1371080783
   )
   int field964 = 1;
   @ObfuscatedName("r")
   public static class166 field965;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 844074625
   )
   int field966 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1074506537
   )
   public int field967 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 422935881
   )
   public int field968 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -326809113
   )
   public int field969 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1336830613
   )
   public int field970 = 0;
   @ObfuscatedName("ac")
   public boolean field971 = true;
   @ObfuscatedName("no")
   static class55 field973;

   @ObfuscatedName("f")
   void method808(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method820(var1, var2);
      }
   }

   @ObfuscatedName("e")
   public final boolean method810() {
      if(null == this.field931) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field931.length; ++var2) {
            var1 &= field924.method3265(this.field931[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   public final class84 method811(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field932 == null) {
         var7 = (long)((this.field930 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field930 << 10) + (var1 << 3));
      }

      Object var9 = (class84)field927.method3792(var7);
      if(var9 == null) {
         class99 var10 = this.method817(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field944) {
            var9 = var10.method2239(64 + this.field948, 768 + this.field949, -50, -10, -50);
         } else {
            var10.field1711 = (short)(this.field948 + 64);
            var10.field1712 = (short)(this.field949 + 768);
            var10.method2235();
            var9 = var10;
         }

         field927.method3794((class203)var9, var7);
      }

      if(this.field944) {
         var9 = ((class99)var9).method2223();
      }

      if(this.field964 * -1 >= 0) {
         if(var9 instanceof class104) {
            var9 = ((class104)var9).method2307(var3, var4, var5, var6, true, this.field964 * -1);
         } else if(var9 instanceof class99) {
            var9 = ((class99)var9).method2224(var3, var4, var5, var6, this.field964 * -1);
         }
      }

      return (class84)var9;
   }

   @ObfuscatedName("m")
   public final class104 method812(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field932 == null) {
         var7 = (long)(var2 + (this.field930 << 10));
      } else {
         var7 = (long)((this.field930 << 10) + (var1 << 3) + var2);
      }

      class104 var9 = (class104)field934.method3792(var7);
      if(null == var9) {
         class99 var10 = this.method817(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2239(64 + this.field948, 768 + this.field949, -50, -10, -50);
         field934.method3794(var9, var7);
      }

      if(this.field964 * -1 >= 0) {
         var9 = var9.method2307(var3, var4, var5, var6, true, this.field964 * -1);
      }

      return var9;
   }

   @ObfuscatedName("j")
   public final class104 method813(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(null == this.field932) {
         var9 = (long)(var2 + (this.field930 << 10));
      } else {
         var9 = (long)((this.field930 << 10) + (var1 << 3) + var2);
      }

      class104 var11 = (class104)field934.method3792(var9);
      if(var11 == null) {
         class99 var12 = this.method817(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2239(64 + this.field948, 768 + this.field949, -50, -10, -50);
         field934.method3794(var11, var9);
      }

      if(var7 == null && this.field964 * -1 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method882(var11, var8, var2);
         } else {
            var11 = var11.method2351(true);
         }

         if(this.field964 * -1 >= 0) {
            var11 = var11.method2307(var3, var4, var5, var6, false, this.field964 * -1);
         }

         return var11;
      }
   }

   @ObfuscatedName("h")
   public boolean method816() {
      if(null == this.field955) {
         return this.field967 != -1 || null != this.field928;
      } else {
         for(int var1 = 0; var1 < this.field955.length; ++var1) {
            if(this.field955[var1] != -1) {
               class40 var2 = class156.method3176(this.field955[var1]);
               if(var2.field967 != -1 || var2.field928 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   final class99 method817(int var1, int var2) {
      class99 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field932 == null) {
         if(10 != var1) {
            return null;
         }

         if(null == this.field931) {
            return null;
         }

         var4 = this.field923;
         if(2 == var1 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field931.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field931[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class99)field933.method3792((long)var7);
            if(null == var3) {
               var3 = class99.method2219(field924, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2267();
               }

               field933.method3794(var3, (long)var7);
            }

            if(var5 > 1) {
               field926[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class99(field926, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field932.length; ++var5) {
            if(var1 == this.field932[var5]) {
               var8 = var5;
               break;
            }
         }

         if(var8 == -1) {
            return null;
         }

         var5 = this.field931[var8];
         boolean var9 = this.field923 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class99)field933.method3792((long)var5);
         if(var3 == null) {
            var3 = class99.method2219(field924, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var9) {
               var3.method2267();
            }

            field933.method3794(var3, (long)var5);
         }
      }

      if(this.field947 == 128 && 128 == this.field956 && 128 == this.field953) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(0 == this.field958 && this.field959 == 0 && 0 == this.field960) {
         var10 = false;
      } else {
         var10 = true;
      }

      class99 var11 = new class99(var3, 0 == var2 && !var4 && !var10, null == this.field957, null == this.field936, true);
      if(var1 == 4 && var2 > 3) {
         var11.method2229(256);
         var11.method2286(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var11.method2250();
      } else if(var2 == 2) {
         var11.method2233();
      } else if(var2 == 3) {
         var11.method2284();
      }

      if(this.field957 != null) {
         for(var7 = 0; var7 < this.field957.length; ++var7) {
            var11.method2254(this.field957[var7], this.field935[var7]);
         }
      }

      if(null != this.field936) {
         for(var7 = 0; var7 < this.field936.length; ++var7) {
            var11.method2274(this.field936[var7], this.field937[var7]);
         }
      }

      if(var4) {
         var11.method2234(this.field947, this.field956, this.field953);
      }

      if(var10) {
         var11.method2286(this.field958, this.field959, this.field960);
      }

      return var11;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass118;IB)V",
      garbageValue = "-32"
   )
   void method820(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2579();
         if(var3 > 0) {
            if(this.field931 != null && !field940) {
               var1.field1979 += var3 * 3;
            } else {
               this.field932 = new int[var3];
               this.field931 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field931[var4] = var1.method2514();
                  this.field932[var4] = var1.method2579();
               }
            }
         }
      } else if(2 == var2) {
         this.field954 = var1.method2520();
      } else if(var2 == 5) {
         var3 = var1.method2579();
         if(var3 > 0) {
            if(this.field931 != null && !field940) {
               var1.field1979 += var3 * 2;
            } else {
               this.field932 = null;
               this.field931 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field931[var4] = var1.method2514();
               }
            }
         }
      } else if(var2 == 14) {
         this.field938 = var1.method2579();
      } else if(15 == var2) {
         this.field939 = var1.method2579();
      } else if(var2 == 17) {
         this.field925 = 0;
         this.field941 = false;
      } else if(18 == var2) {
         this.field941 = false;
      } else if(19 == var2) {
         this.field942 = var1.method2579();
      } else if(21 == var2) {
         this.field964 = 0;
      } else if(22 == var2) {
         this.field944 = true;
      } else if(23 == var2) {
         this.field929 = true;
      } else if(var2 == 24) {
         this.field946 = var1.method2514();
         if('\uffff' == this.field946) {
            this.field946 = -1;
         }
      } else if(var2 == 27) {
         this.field925 = 1;
      } else if(var2 == 28) {
         this.field951 = var1.method2579();
      } else if(var2 == 29) {
         this.field948 = var1.method2707();
      } else if(39 == var2) {
         this.field949 = var1.method2707() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field950[var2 - 30] = var1.method2520();
         if(this.field950[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field950[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2579();
         this.field957 = new short[var3];
         this.field935 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field957[var4] = (short)var1.method2514();
            this.field935[var4] = (short)var1.method2514();
         }
      } else if(var2 == 41) {
         var3 = var1.method2579();
         this.field936 = new short[var3];
         this.field937 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field936[var4] = (short)var1.method2514();
            this.field937[var4] = (short)var1.method2514();
         }
      } else if(var2 == 60) {
         this.field943 = var1.method2514();
      } else if(var2 == 62) {
         this.field923 = true;
      } else if(64 == var2) {
         this.field971 = false;
      } else if(65 == var2) {
         this.field947 = var1.method2514();
      } else if(var2 == 66) {
         this.field956 = var1.method2514();
      } else if(var2 == 67) {
         this.field953 = var1.method2514();
      } else if(68 == var2) {
         this.field952 = var1.method2514();
      } else if(69 == var2) {
         var1.method2579();
      } else if(70 == var2) {
         this.field958 = var1.method2515();
      } else if(var2 == 71) {
         this.field959 = var1.method2515();
      } else if(72 == var2) {
         this.field960 = var1.method2515();
      } else if(73 == var2) {
         this.field961 = true;
      } else if(74 == var2) {
         this.field962 = true;
      } else if(var2 == 75) {
         this.field963 = var1.method2579();
      } else if(77 == var2) {
         this.field922 = var1.method2514();
         if(this.field922 == '\uffff') {
            this.field922 = -1;
         }

         this.field966 = var1.method2514();
         if('\uffff' == this.field966) {
            this.field966 = -1;
         }

         var3 = var1.method2579();
         this.field955 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field955[var4] = var1.method2514();
            if(this.field955[var4] == '\uffff') {
               this.field955[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field967 = var1.method2514();
         this.field968 = var1.method2579();
      } else if(var2 == 79) {
         this.field969 = var1.method2514();
         this.field970 = var1.method2514();
         this.field968 = var1.method2579();
         var3 = var1.method2579();
         this.field928 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field928[var4] = var1.method2514();
         }
      } else if(var2 == 81) {
         this.field964 = var1.method2579() * -256;
      }

   }

   @ObfuscatedName("a")
   static class22 method823(int var0) {
      class22 var1 = (class22)class22.field604.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class24.field623.method3263(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class118 var3 = new class118(var2);
            var3.field1979 = var3.field1980.length - 12;
            int var4 = var3.method2517();
            var1.field599 = var3.method2514();
            var1.field600 = var3.method2514();
            var1.field601 = var3.method2514();
            var1.field595 = var3.method2514();
            var3.field1979 = 0;
            var3.method2519();
            var1.field596 = new int[var4];
            var1.field597 = new int[var4];
            var1.field598 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1979 < var3.field1980.length - 12; var1.field596[var5++] = var6) {
               var6 = var3.method2514();
               if(3 == var6) {
                  var1.field598[var5] = var3.method2520();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && var6 != 39) {
                  var1.field597[var5] = var3.method2517();
               } else {
                  var1.field597[var5] = var3.method2579();
               }
            }

            class22.field604.method3794(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1714308767"
   )
   void method829() {
      if(-1 == this.field942) {
         this.field942 = 0;
         if(null != this.field931 && (null == this.field932 || this.field932[0] == 10)) {
            this.field942 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field950[var1]) {
               this.field942 = 1;
            }
         }
      }

      if(-1 == this.field963) {
         this.field963 = this.field925 != 0?1:0;
      }

   }

   @ObfuscatedName("y")
   public final boolean method831(int var1) {
      if(this.field932 != null) {
         for(int var4 = 0; var4 < this.field932.length; ++var4) {
            if(this.field932[var4] == var1) {
               return field924.method3265(this.field931[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field931) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field931.length; ++var3) {
            var2 &= field924.method3265(this.field931[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   public final class40 method848() {
      int var1 = -1;
      if(-1 != this.field922) {
         var1 = class126.method2820(this.field922);
      } else if(-1 != this.field966) {
         var1 = class175.field2890[this.field966];
      }

      return var1 >= 0 && var1 < this.field955.length && -1 != this.field955[var1]?class156.method3176(this.field955[var1]):null;
   }
}
