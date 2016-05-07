import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("r")
   short[] field925;
   @ObfuscatedName("x")
   static class193 field926 = new class193(64);
   @ObfuscatedName("d")
   public static class193 field927 = new class193(500);
   @ObfuscatedName("u")
   static class193 field928 = new class193(30);
   @ObfuscatedName("ay")
   boolean field929 = false;
   @ObfuscatedName("b")
   static class100[] field930 = new class100[4];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1613543749
   )
   public int field931;
   @ObfuscatedName("c")
   int[] field932;
   @ObfuscatedName("l")
   int[] field933;
   @ObfuscatedName("t")
   @Export("name")
   public String field934 = "null";
   @ObfuscatedName("i")
   short[] field935;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1698741927
   )
   public int field936 = -1;
   @ObfuscatedName("m")
   short[] field937;
   @ObfuscatedName("e")
   short[] field938;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -355385623
   )
   public int field939 = 1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 445600573
   )
   public int field940 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -359022501
   )
   public int field941 = 2;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1377231093
   )
   int field942 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -643684765
   )
   public int field943 = -1;
   @ObfuscatedName("aq")
   public boolean field944 = false;
   @ObfuscatedName("f")
   boolean field945 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1080372867
   )
   public int field946 = 16;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -820190299
   )
   int field947 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 537442021
   )
   int field948 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -430869757
   )
   int field949 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1673084567
   )
   int field950 = 0;
   @ObfuscatedName("s")
   public static boolean field951 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 379780533
   )
   public int field952 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1918262345
   )
   public int field953 = -1;
   @ObfuscatedName("am")
   boolean field954 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 375252283
   )
   public int field955 = -1;
   @ObfuscatedName("o")
   static class193 field956 = new class193(30);
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 109938977
   )
   int field957 = 128;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2043013413
   )
   int field958 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -218687671
   )
   int field959 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2137067267
   )
   int field960 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1596020273
   )
   int field961 = 0;
   @ObfuscatedName("an")
   @Export("actions")
   public String[] field962 = new String[5];
   @ObfuscatedName("w")
   public boolean field963 = true;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -523459163
   )
   public int field964 = -1;
   @ObfuscatedName("ar")
   public int[] field965;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1126528687
   )
   public int field966 = 1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1959912877
   )
   int field967 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1139372259
   )
   public int field968 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -966052597
   )
   public int field969 = 0;
   @ObfuscatedName("q")
   public boolean field970 = false;
   @ObfuscatedName("ae")
   public boolean field971 = true;
   @ObfuscatedName("ak")
   public int[] field972;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-2126520750"
   )
   void method773(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2492();
         if(var3 > 0) {
            if(this.field932 != null && !field951) {
               var1.field2005 += 3 * var3;
            } else {
               this.field933 = new int[var3];
               this.field932 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field932[var4] = var1.method2584();
                  this.field933[var4] = var1.method2492();
               }
            }
         }
      } else if(2 == var2) {
         this.field934 = var1.method2500();
      } else if(5 == var2) {
         var3 = var1.method2492();
         if(var3 > 0) {
            if(null != this.field932 && !field951) {
               var1.field2005 += var3 * 2;
            } else {
               this.field933 = null;
               this.field932 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field932[var4] = var1.method2584();
               }
            }
         }
      } else if(var2 == 14) {
         this.field939 = var1.method2492();
      } else if(15 == var2) {
         this.field966 = var1.method2492();
      } else if(17 == var2) {
         this.field941 = 0;
         this.field963 = false;
      } else if(18 == var2) {
         this.field963 = false;
      } else if(19 == var2) {
         this.field943 = var1.method2492();
      } else if(21 == var2) {
         this.field948 = 0;
      } else if(var2 == 22) {
         this.field945 = true;
      } else if(23 == var2) {
         this.field970 = true;
      } else if(var2 == 24) {
         this.field955 = var1.method2584();
         if('\uffff' == this.field955) {
            this.field955 = -1;
         }
      } else if(var2 == 27) {
         this.field941 = 1;
      } else if(var2 == 28) {
         this.field946 = var1.method2492();
      } else if(var2 == 29) {
         this.field942 = var1.method2493();
      } else if(var2 == 39) {
         this.field950 = var1.method2493() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field962[var2 - 30] = var1.method2500();
         if(this.field962[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field962[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2492();
         this.field935 = new short[var3];
         this.field925 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field935[var4] = (short)var1.method2584();
            this.field925[var4] = (short)var1.method2584();
         }
      } else if(var2 == 41) {
         var3 = var1.method2492();
         this.field937 = new short[var3];
         this.field938 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field937[var4] = (short)var1.method2584();
            this.field938[var4] = (short)var1.method2584();
         }
      } else if(var2 == 60) {
         this.field952 = var1.method2584();
      } else if(62 == var2) {
         this.field954 = true;
      } else if(var2 == 64) {
         this.field971 = false;
      } else if(var2 == 65) {
         this.field949 = var1.method2584();
      } else if(var2 == 66) {
         this.field957 = var1.method2584();
      } else if(67 == var2) {
         this.field958 = var1.method2584();
      } else if(68 == var2) {
         this.field953 = var1.method2584();
      } else if(69 == var2) {
         var1.method2492();
      } else if(70 == var2) {
         this.field959 = var1.method2495();
      } else if(71 == var2) {
         this.field960 = var1.method2495();
      } else if(var2 == 72) {
         this.field961 = var1.method2495();
      } else if(var2 == 73) {
         this.field944 = true;
      } else if(var2 == 74) {
         this.field929 = true;
      } else if(var2 == 75) {
         this.field964 = var1.method2492();
      } else if(77 == var2) {
         this.field947 = var1.method2584();
         if('\uffff' == this.field947) {
            this.field947 = -1;
         }

         this.field967 = var1.method2584();
         if('\uffff' == this.field967) {
            this.field967 = -1;
         }

         var3 = var1.method2492();
         this.field965 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field965[var4] = var1.method2584();
            if(this.field965[var4] == '\uffff') {
               this.field965[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field936 = var1.method2584();
         this.field969 = var1.method2492();
      } else if(var2 == 79) {
         this.field940 = var1.method2584();
         this.field968 = var1.method2584();
         this.field969 = var1.method2492();
         var3 = var1.method2492();
         this.field972 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field972[var4] = var1.method2584();
         }
      } else if(81 == var2) {
         this.field948 = var1.method2492() * 256;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "84145187"
   )
   void method775(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(0 == var2) {
            return;
         }

         this.method773(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass85;",
      garbageValue = "656111299"
   )
   public final class85 method779(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field933 == null) {
         var7 = (long)(var2 + (this.field931 << 10));
      } else {
         var7 = (long)(var2 + (this.field931 << 10) + (var1 << 3));
      }

      Object var9 = (class85)field928.method3743(var7);
      if(var9 == null) {
         class100 var10 = this.method782(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field945) {
            var9 = var10.method2202(this.field942 + 64, 768 + this.field950, -50, -10, -50);
         } else {
            var10.field1717 = (short)(this.field942 + 64);
            var10.field1732 = (short)(768 + this.field950);
            var10.method2198();
            var9 = var10;
         }

         field928.method3745((class204)var9, var7);
      }

      if(this.field945) {
         var9 = ((class100)var9).method2186();
      }

      if(this.field948 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2283(var3, var4, var5, var6, true, this.field948);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2187(var3, var4, var5, var6, true, this.field948);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lclass105;",
      garbageValue = "59"
   )
   public final class105 method780(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field933 == null) {
         var7 = (long)(var2 + (this.field931 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field931 << 10));
      }

      class105 var9 = (class105)field956.method3743(var7);
      if(var9 == null) {
         class100 var10 = this.method782(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2202(this.field942 + 64, 768 + this.field950, -50, -10, -50);
         field956.method3745(var9, var7);
      }

      if(this.field948 >= 0) {
         var9 = var9.method2283(var3, var4, var5, var6, true, this.field948);
      }

      return var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Lclass100;",
      garbageValue = "739567683"
   )
   final class100 method782(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field933) {
         if(10 != var1) {
            return null;
         }

         if(this.field932 == null) {
            return null;
         }

         var4 = this.field954;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field932.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field932[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field927.method3743((long)var7);
            if(null == var3) {
               var3 = class100.method2181(class21.field574, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2228();
               }

               field927.method3745(var3, (long)var7);
            }

            if(var5 > 1) {
               field930[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field930, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field933.length; ++var5) {
            if(this.field933[var5] == var1) {
               var8 = var5;
               break;
            }
         }

         if(-1 == var8) {
            return null;
         }

         var5 = this.field932[var8];
         boolean var9 = this.field954 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class100)field927.method3743((long)var5);
         if(var3 == null) {
            var3 = class100.method2181(class21.field574, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var9) {
               var3.method2228();
            }

            field927.method3745(var3, (long)var5);
         }
      }

      if(128 == this.field949 && this.field957 == 128 && 128 == this.field958) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(0 == this.field959 && 0 == this.field960 && this.field961 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var11 = new class100(var3, var2 == 0 && !var4 && !var10, this.field935 == null, null == this.field937, true);
      if(var1 == 4 && var2 > 3) {
         var11.method2192(256);
         var11.method2193(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var11.method2189();
      } else if(2 == var2) {
         var11.method2190();
      } else if(var2 == 3) {
         var11.method2191();
      }

      if(this.field935 != null) {
         for(var7 = 0; var7 < this.field935.length; ++var7) {
            var11.method2194(this.field935[var7], this.field925[var7]);
         }
      }

      if(this.field937 != null) {
         for(var7 = 0; var7 < this.field937.length; ++var7) {
            var11.method2195(this.field937[var7], this.field938[var7]);
         }
      }

      if(var4) {
         var11.method2197(this.field949, this.field957, this.field958);
      }

      if(var10) {
         var11.method2193(this.field959, this.field960, this.field961);
      }

      return var11;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "1050971925"
   )
   public final class40 method783() {
      int var1 = -1;
      if(-1 != this.field947) {
         var1 = class32.method691(this.field947);
      } else if(this.field967 != -1) {
         var1 = class176.field2920[this.field967];
      }

      return var1 >= 0 && var1 < this.field965.length && -1 != this.field965[var1]?class9.method120(this.field965[var1]):null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "89154783"
   )
   public boolean method784() {
      if(this.field965 == null) {
         return this.field936 != -1 || this.field972 != null;
      } else {
         for(int var1 = 0; var1 < this.field965.length; ++var1) {
            if(-1 != this.field965[var1]) {
               class40 var2 = class9.method120(this.field965[var1]);
               if(var2.field936 != -1 || null != var2.field972) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;II)Lclass105;",
      garbageValue = "6869289"
   )
   public final class105 method796(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(null == this.field933) {
         var9 = (long)((this.field931 << 10) + var2);
      } else {
         var9 = (long)((this.field931 << 10) + (var1 << 3) + var2);
      }

      class105 var11 = (class105)field956.method3743(var9);
      if(var11 == null) {
         class100 var12 = this.method782(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2202(64 + this.field942, this.field950 + 768, -50, -10, -50);
         field956.method3745(var11, var9);
      }

      if(var7 == null && this.field948 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method845(var11, var8, var2);
         } else {
            var11 = var11.method2284(true);
         }

         if(this.field948 >= 0) {
            var11 = var11.method2283(var3, var4, var5, var6, false, this.field948);
         }

         return var11;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-978724483"
   )
   void method797() {
      if(-1 == this.field943) {
         this.field943 = 0;
         if(null != this.field932 && (this.field933 == null || 10 == this.field933[0])) {
            this.field943 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field962[var1]) {
               this.field943 = 1;
            }
         }
      }

      if(this.field964 == -1) {
         this.field964 = this.field941 != 0?1:0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2010038307"
   )
   public final boolean method807(int var1) {
      if(null != this.field933) {
         for(int var4 = 0; var4 < this.field933.length; ++var4) {
            if(var1 == this.field933[var4]) {
               return class21.field574.method3272(this.field932[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field932) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field932.length; ++var3) {
            var2 &= class21.field574.method3272(this.field932[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1922364749"
   )
   public final boolean method808() {
      if(null == this.field932) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field932.length; ++var2) {
            var1 &= class21.field574.method3272(this.field932[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "426536956"
   )
   static final int method809(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + var2 * (var1 & 16711935) & -16711936) + (var3 * (var0 & '\uff00') + var2 * (var1 & '\uff00') & 16711680) >> 8;
   }
}
