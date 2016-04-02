import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1100115307
   )
   int field102;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -452903941
   )
   int field103;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -572036403
   )
   int field104 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 881523817
   )
   int field105;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 721902589
   )
   int field106;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 42918333
   )
   int field107;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1714967603
   )
   int field108;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1906901581
   )
   int field109;
   @ObfuscatedName("t")
   @Export("animationSequence")
   class42 field110;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 18577167
   )
   int field111;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2121876277
   )
   int field112;
   @ObfuscatedName("n")
   @Export("isMoving")
   boolean field113 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1802779949
   )
   int field114;
   @ObfuscatedName("l")
   double field115;
   @ObfuscatedName("j")
   double field116;
   @ObfuscatedName("b")
   double field117;
   @ObfuscatedName("o")
   @Export("scalar")
   double field118;
   @ObfuscatedName("c")
   @Export("velocityY")
   double field119;
   @ObfuscatedName("x")
   @Export("velocityX")
   double field120;
   @ObfuscatedName("y")
   double field121;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1445721923
   )
   int field122 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2014273293
   )
   int field123;
   @ObfuscatedName("i")
   @Export("velocityZ")
   double field124;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 794896431
   )
   int field125;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1941674599
   )
   int field126;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1441882377
   )
   @Export("baseY")
   static int field128;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "110"
   )
   final void method93(int var1) {
      this.field113 = true;
      this.field121 += (double)var1 * this.field115;
      this.field124 += (double)var1 * this.field118;
      this.field116 += (double)var1 * 0.5D * this.field117 * (double)var1 + this.field120 * (double)var1;
      this.field120 += (double)var1 * this.field117;
      this.field112 = (int)(Math.atan2(this.field115, this.field118) * 325.949D) + 1024 & 2047;
      this.field111 = (int)(Math.atan2(this.field120, this.field119) * 325.949D) & 2047;
      if(this.field110 != null) {
         this.field122 += var1;

         while(true) {
            do {
               do {
                  if(this.field122 <= this.field110.field968[this.field104]) {
                     return;
                  }

                  this.field122 -= this.field110.field968[this.field104];
                  ++this.field104;
               } while(this.field104 < this.field110.field975.length);

               this.field104 -= this.field110.field965;
            } while(this.field104 >= 0 && this.field104 < this.field110.field975.length);

            this.field104 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "120"
   )
   final void method94(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field113) {
         var5 = (double)(var1 - this.field114);
         double var7 = (double)(var2 - this.field105);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.field121 = var5 * (double)this.field102 / var9 + (double)this.field114;
         this.field124 = (double)this.field105 + var7 * (double)this.field102 / var9;
         this.field116 = (double)this.field106;
      }

      var5 = (double)(this.field109 + 1 - var4);
      this.field115 = ((double)var1 - this.field121) / var5;
      this.field118 = ((double)var2 - this.field124) / var5;
      this.field119 = Math.sqrt(this.field115 * this.field115 + this.field118 * this.field118);
      if(!this.field113) {
         this.field120 = -this.field119 * Math.tan((double)this.field126 * 0.02454369D);
      }

      this.field117 = 2.0D * ((double)var3 - this.field116 - var5 * this.field120) / (var5 * var5);
   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      class43 var1 = class82.method1906(this.field123);
      class105 var2 = var1.method914(this.field104);
      if(var2 == null) {
         return null;
      } else {
         var2.method2379(this.field111);
         return var2;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIII)V",
      garbageValue = "-411746358"
   )
   static final void method99(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field361) {
         client.field362 = 32;
      } else {
         client.field362 = 0;
      }

      client.field361 = false;
      int var7;
      if(1 == class140.field2136 || !class3.field66 && class140.field2136 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2815 -= 4;
            class9.method133(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.field2815 += 4;
            class9.method133(var0);
         } else if(var5 >= var1 - client.field362 && var5 < client.field362 + 16 + var1 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2815 = var8 * (var4 - var3) / var9;
            class9.method133(var0);
            client.field361 = true;
         }
      }

      if(0 != client.field476) {
         var7 = var0.field2770;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2815 += client.field476 * 45;
            class9.method133(var0);
         }
      }

   }

   @ObfuscatedName("w")
   static class80 method101(class167 var0, int var1, int var2) {
      if(!class23.method586(var0, var1, var2)) {
         return null;
      } else {
         class80 var4 = new class80();
         var4.field1395 = class76.field1356;
         var4.field1392 = class76.field1354;
         var4.field1393 = class76.field1357[0];
         var4.field1394 = class84.field1437[0];
         var4.field1390 = class5.field86[0];
         var4.field1391 = class76.field1355[0];
         var4.field1396 = class215.field3152;
         var4.field1389 = class76.field1352[0];
         class30.method670();
         return var4;
      }
   }

   @ObfuscatedName("ct")
   static final void method103(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null) {
            if(var3.field2757 == 0) {
               if(null != var3.field2879) {
                  method103(var3.field2879, var1);
               }

               class3 var4 = (class3)client.field439.method3788((long)var3.field2794);
               if(null != var4) {
                  class9.method134(var4.field69, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && null != var3.field2862) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field11 = var3.field2862;
               class93.method2183(var5);
            }

            if(var1 == 1 && null != var3.field2744) {
               if(var3.field2816 >= 0) {
                  class173 var6 = class148.method3129(var3.field2794);
                  if(null == var6 || var6.field2879 == null || var3.field2816 >= var6.field2879.length || var3 != var6.field2879[var3.field2816]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field11 = var3.field2744;
               class93.method2183(var5);
            }
         }
      }

   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field123 = var1;
      this.field103 = var2;
      this.field114 = var3;
      this.field105 = var4;
      this.field106 = var5;
      this.field108 = var6;
      this.field109 = var7;
      this.field126 = var8;
      this.field102 = var9;
      this.field125 = var10;
      this.field107 = var11;
      this.field113 = false;
      int var12 = class82.method1906(this.field123).field988;
      if(-1 != var12) {
         this.field110 = class46.method974(var12);
      } else {
         this.field110 = null;
      }

   }
}
