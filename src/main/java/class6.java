import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 463915821
   )
   int field103;
   @ObfuscatedName("z")
   double field104;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1140250907
   )
   int field105;
   @ObfuscatedName("n")
   double field106;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2024470285
   )
   int field107;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 317254691
   )
   int field108;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1081548261
   )
   int field109;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1428151417
   )
   int field111;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1277162305
   )
   int field112;
   @ObfuscatedName("x")
   @Export("isMoving")
   boolean field114 = false;
   @ObfuscatedName("t")
   double field115;
   @ObfuscatedName("i")
   @Export("velocityZ")
   double field116;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1946559505
   )
   int field117;
   @ObfuscatedName("u")
   @Export("scalar")
   double field118;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -899070171
   )
   int field119;
   @ObfuscatedName("g")
   @Export("velocityY")
   double field120;
   @ObfuscatedName("j")
   @Export("velocityX")
   double field121;
   @ObfuscatedName("h")
   double field122;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 816992931
   )
   int field123;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1088303681
   )
   int field124;
   @ObfuscatedName("b")
   @Export("animationSequence")
   class42 field125;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1904634341
   )
   int field126 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1519511067
   )
   int field127 = 0;
   @ObfuscatedName("me")
   static byte field128;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1949427567
   )
   int field129;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 567938899
   )
   int field132;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "0"
   )
   static int method119(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class119.field1991[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1186927086"
   )
   public static void method122(Component var0) {
      var0.addMouseListener(class140.field2145);
      var0.addMouseMotionListener(class140.field2145);
      var0.addFocusListener(class140.field2145);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIII[Lclass108;I)V",
      garbageValue = "535163529"
   )
   static final void method125(byte[] var0, int var1, int var2, int var3, int var4, class108[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].field1896[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class119 var10 = new class119(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class10.method170(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      class43 var1 = class25.method693(this.field124);
      class105 var2 = var1.method994(this.field126);
      if(null == var2) {
         return null;
      } else {
         var2.method2401(this.field108);
         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-82"
   )
   final void method129(int var1) {
      this.field114 = true;
      this.field104 += this.field106 * (double)var1;
      this.field116 += (double)var1 * this.field118;
      this.field115 += (double)var1 * 0.5D * this.field122 * (double)var1 + this.field121 * (double)var1;
      this.field121 += this.field122 * (double)var1;
      this.field123 = (int)(Math.atan2(this.field106, this.field118) * 325.949D) + 1024 & 2047;
      this.field108 = (int)(Math.atan2(this.field121, this.field120) * 325.949D) & 2047;
      if(this.field125 != null) {
         this.field127 += var1;

         while(true) {
            do {
               do {
                  if(this.field127 <= this.field125.field995[this.field126]) {
                     return;
                  }

                  this.field127 -= this.field125.field995[this.field126];
                  ++this.field126;
               } while(this.field126 < this.field125.field989.length);

               this.field126 -= this.field125.field998;
            } while(this.field126 >= 0 && this.field126 < this.field125.field989.length);

            this.field126 = 0;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static final int method132(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field124 = var1;
      this.field129 = var2;
      this.field105 = var3;
      this.field119 = var4;
      this.field107 = var5;
      this.field109 = var6;
      this.field132 = var7;
      this.field111 = var8;
      this.field112 = var9;
      this.field103 = var10;
      this.field117 = var11;
      this.field114 = false;
      int var12 = class25.method693(this.field124).field1021;
      if(-1 != var12) {
         this.field125 = class96.method2279(var12);
      } else {
         this.field125 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)Lclass80;",
      garbageValue = "-1075753469"
   )
   public static class80 method133(class167 var0, String var1, String var2) {
      int var3 = var0.method3377(var1);
      int var4 = var0.method3378(var3, var2);
      class80 var5;
      if(!class30.method748(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class74.method1700();
      }

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-229604407"
   )
   final void method134(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field114) {
         var5 = (double)(var1 - this.field105);
         double var7 = (double)(var2 - this.field119);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.field104 = var5 * (double)this.field112 / var9 + (double)this.field105;
         this.field116 = (double)this.field119 + (double)this.field112 * var7 / var9;
         this.field115 = (double)this.field107;
      }

      var5 = (double)(1 + this.field132 - var4);
      this.field106 = ((double)var1 - this.field104) / var5;
      this.field118 = ((double)var2 - this.field116) / var5;
      this.field120 = Math.sqrt(this.field118 * this.field118 + this.field106 * this.field106);
      if(!this.field114) {
         this.field121 = -this.field120 * Math.tan(0.02454369D * (double)this.field111);
      }

      this.field122 = ((double)var3 - this.field115 - var5 * this.field121) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "680100072"
   )
   static final void method135(String var0) {
      if(null != class59.field1226) {
         client.field338.method2873(185);
         client.field338.method2603(class104.method2383(var0));
         client.field338.method2694(var0);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass190;",
      garbageValue = "-1731149774"
   )
   public static class190[] method136() {
      return new class190[]{class190.field3062, class190.field3060, class190.field3061, class190.field3073, class190.field3067, class190.field3068, class190.field3069, class190.field3074, class190.field3071, class190.field3063, class190.field3070, class190.field3064, class190.field3066, class190.field3072, class190.field3065};
   }
}
