package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("h")
@Implements("Projectile")
public final class class6 extends class84 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 938442557
   )
   int field93 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1347045971
   )
   int field95;
   @ObfuscatedName("p")
   double field96;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1264387123
   )
   int field97;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -53072601
   )
   int field98;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -938599759
   )
   int field99;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -960726461
   )
   int field100;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 272715533
   )
   int field101;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2095267285
   )
   int field102;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1270639005
   )
   int field103;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 391488407
   )
   int field104;
   @ObfuscatedName("e")
   double field105;
   @ObfuscatedName("z")
   double field106;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1745101241
   )
   int field107;
   @ObfuscatedName("r")
   @Export("velocityX")
   double field108;
   @ObfuscatedName("g")
   @Export("velocityY")
   double field109;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1628637399
   )
   int field110;
   @ObfuscatedName("y")
   @Export("velocityZ")
   double field111;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1621802997
   )
   int field112;
   @ObfuscatedName("v")
   double field113;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1688485275
   )
   int field114;
   @ObfuscatedName("d")
   @Export("animationSequence")
   class42 field115;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1540389339
   )
   int field116 = 0;
   @ObfuscatedName("n")
   @Export("scalar")
   double field117;
   @ObfuscatedName("w")
   @Export("isMoving")
   boolean field120 = false;

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field107 = var1;
      this.field95 = var2;
      this.field110 = var3;
      this.field112 = var4;
      this.field97 = var5;
      this.field99 = var6;
      this.field100 = var7;
      this.field101 = var8;
      this.field102 = var9;
      this.field103 = var10;
      this.field98 = var11;
      this.field120 = false;
      int var12 = class10.method156(this.field107).field1005;
      if(-1 != var12) {
         this.field115 = client.method584(var12);
      } else {
         this.field115 = null;
      }

   }

   @ObfuscatedName("m")
   final void method103(int var1) {
      this.field120 = true;
      this.field105 += (double)var1 * this.field108;
      this.field106 += this.field109 * (double)var1;
      this.field96 += (double)var1 * this.field111 + this.field113 * 0.5D * (double)var1 * (double)var1;
      this.field111 += (double)var1 * this.field113;
      this.field104 = (int)(Math.atan2(this.field108, this.field109) * 325.949D) + 1024 & 2047;
      this.field114 = (int)(Math.atan2(this.field111, this.field117) * 325.949D) & 2047;
      if(null != this.field115) {
         this.field116 += var1;

         while(true) {
            do {
               do {
                  if(this.field116 <= this.field115.field975[this.field93]) {
                     return;
                  }

                  this.field116 -= this.field115.field975[this.field93];
                  ++this.field93;
               } while(this.field93 < this.field115.field973.length);

               this.field93 -= this.field115.field977 * -1;
            } while(this.field93 >= 0 && this.field93 < this.field115.field973.length);

            this.field93 = 0;
         }
      }
   }

   @ObfuscatedName("ap")
   static final void method112(class33 var0) {
      if(client.field537 == class0.field12.field846 >> 7 && class0.field12.field834 >> 7 == client.field294) {
         client.field537 = 0;
      }

      int var1 = class32.field733;
      int[] var2 = class32.field730;
      int var3 = var1;
      if(var0 == class33.field753 || class33.field748 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field753 == var0) {
            var5 = class0.field12;
            var6 = class0.field12.field58 << 14;
         } else if(var0 == class33.field748) {
            var5 = client.field397[client.field406];
            var6 = client.field406 << 14;
         } else {
            var5 = client.field397[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class33.field750 && client.field406 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod791() && !var5.field35) {
            var5.field49 = false;
            if((client.field527 && var1 > 50 || var1 > 200) && class33.field753 != var0 && var5.field826 == var5.field803) {
               var5.field49 = true;
            }

            int var7 = var5.field846 >> 7;
            int var8 = var5.field834 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.field44 && client.field286 >= var5.field39 && client.field286 < var5.field40) {
                  var5.field49 = false;
                  var5.field38 = class34.method774(var5.field846, var5.field834, class8.field134);
                  class24.field610.method1944(class8.field134, var5.field846, var5.field834, var5.field38, var5, var5.field800, var6, var5.field45, var5.field52, var5.field47, var5.field48);
               } else {
                  if((var5.field846 & 127) == 64 && 64 == (var5.field834 & 127)) {
                     if(client.field381 == client.field305[var7][var8]) {
                        continue;
                     }

                     client.field305[var7][var8] = client.field381;
                  }

                  var5.field38 = class34.method774(var5.field846, var5.field834, class8.field134);
                  class24.field610.method1943(class8.field134, var5.field846, var5.field834, var5.field38, 60, var5, var5.field800, var6, var5.field801);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      class43 var1 = class10.method156(this.field107);
      class104 var2 = var1.method948(this.field93);
      if(var2 == null) {
         return null;
      } else {
         var2.method2343(this.field114);
         return var2;
      }
   }

   @ObfuscatedName("j")
   final void method116(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field120) {
         var5 = (double)(var1 - this.field110);
         double var7 = (double)(var2 - this.field112);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.field105 = (double)this.field102 * var5 / var9 + (double)this.field110;
         this.field106 = var7 * (double)this.field102 / var9 + (double)this.field112;
         this.field96 = (double)this.field97;
      }

      var5 = (double)(this.field100 + 1 - var4);
      this.field108 = ((double)var1 - this.field105) / var5;
      this.field109 = ((double)var2 - this.field106) / var5;
      this.field117 = Math.sqrt(this.field109 * this.field109 + this.field108 * this.field108);
      if(!this.field120) {
         this.field111 = -this.field117 * Math.tan((double)this.field101 * 0.02454369D);
      }

      this.field113 = ((double)var3 - this.field96 - var5 * this.field111) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("de")
   static void method118(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1092; ++var4) {
         class51 var5 = class10.method158(var4);
         if((!var1 || var5.field1137) && var5.field1114 == -1 && var5.field1099.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class19.field268 = -1;
               class110.field1939 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class110.field1939 = var2;
      class89.field1544 = 0;
      class19.field268 = var3;
      String[] var8 = new String[class19.field268];

      for(int var9 = 0; var9 < class19.field268; ++var9) {
         var8[var9] = class10.method158(var2[var9]).field1099;
      }

      short[] var10 = class110.field1939;
      class19.method263(var8, var10, 0, var8.length - 1);
   }

   @ObfuscatedName("k")
   public static byte[] method119(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class141.method3018(var3):var3;
      } else if(var0 instanceof class124) {
         class124 var2 = (class124)var0;
         return var2.vmethod2818();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   static int method120(class121 var0) {
      int var1 = var0.method2786(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2786(5);
      } else if(2 == var1) {
         var2 = var0.method2786(8);
      } else {
         var2 = var0.method2786(11);
      }

      return var2;
   }
}
