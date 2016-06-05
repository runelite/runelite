import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("a")
   @Export("scalar")
   double field101;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -664863369
   )
   @Export("x1")
   int field103;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -974309449
   )
   @Export("y1")
   int field104;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2007842749
   )
   @Export("z1")
   int field105;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1333016377
   )
   @Export("id")
   int field106;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1754186119
   )
   @Export("startTime")
   int field107;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1994360637
   )
   int field108;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1113604463
   )
   int field109;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1477568815
   )
   @Export("start")
   int field110;
   @ObfuscatedName("p")
   @Export("isMoving")
   boolean field112 = false;
   @ObfuscatedName("k")
   @Export("x")
   double field113;
   @ObfuscatedName("o")
   @Export("velocityZ")
   double field114;
   @ObfuscatedName("b")
   @Export("z")
   double field115;
   @ObfuscatedName("v")
   @Export("animationSequence")
   class42 field116;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 654052169
   )
   @Export("floor")
   int field117;
   @ObfuscatedName("u")
   @Export("velocityY")
   double field118;
   @ObfuscatedName("c")
   @Export("velocityX")
   double field119;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 521538453
   )
   @Export("interacting")
   int field120;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -501857753
   )
   int field121;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -533887983
   )
   int field122;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -136201141
   )
   int field123;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -234071869
   )
   int field124 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1372553705
   )
   int field125 = 0;
   @ObfuscatedName("go")
   static class173 field126;
   @ObfuscatedName("n")
   @Export("az")
   double field127;
   @ObfuscatedName("j")
   double field128;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass130;",
      garbageValue = "-1314775086"
   )
   public static class130 method68(int var0) {
      class130[] var1 = new class130[]{class130.field2075, class130.field2070, class130.field2068};
      class130[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class130 var4 = var2[var3];
         if(var0 == var4.field2069) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "112"
   )
   final void method69(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field112) {
         var5 = (double)(var1 - this.field103);
         double var7 = (double)(var2 - this.field104);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field113 = (double)this.field103 + var5 * (double)this.field110 / var9;
         this.field114 = (double)this.field104 + (double)this.field110 * var7 / var9;
         this.field115 = (double)this.field105;
      }

      var5 = (double)(this.field123 + 1 - var4);
      this.field128 = ((double)var1 - this.field113) / var5;
      this.field101 = ((double)var2 - this.field114) / var5;
      this.field118 = Math.sqrt(this.field101 * this.field101 + this.field128 * this.field128);
      if(!this.field112) {
         this.field119 = -this.field118 * Math.tan(0.02454369D * (double)this.field109);
      }

      this.field127 = 2.0D * ((double)var3 - this.field115 - this.field119 * var5) / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      class43 var1 = class16.method162(this.field106);
      class105 var2 = var1.method883(this.field124);
      if(null == var2) {
         return null;
      } else {
         var2.method2277(this.field122);
         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1831352221"
   )
   final void method74(int var1) {
      this.field112 = true;
      this.field113 += (double)var1 * this.field128;
      this.field114 += this.field101 * (double)var1;
      this.field115 += (double)var1 * this.field127 * 0.5D * (double)var1 + this.field119 * (double)var1;
      this.field119 += (double)var1 * this.field127;
      this.field121 = (int)(Math.atan2(this.field128, this.field101) * 325.949D) + 1024 & 2047;
      this.field122 = (int)(Math.atan2(this.field119, this.field118) * 325.949D) & 2047;
      if(this.field116 != null) {
         this.field125 += var1;

         while(true) {
            do {
               do {
                  if(this.field125 <= this.field116.field987[this.field124]) {
                     return;
                  }

                  this.field125 -= this.field116.field987[this.field124];
                  ++this.field124;
               } while(this.field124 < this.field116.field985.length);

               this.field124 -= this.field116.field981;
            } while(this.field124 >= 0 && this.field124 < this.field116.field985.length);

            this.field124 = 0;
         }
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-1178570883"
   )
   static final void method79(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(null != var4) {
         int var6 = client.field302 + client.field355 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1602[var6];
            int var9 = class91.field1603[var6];
            var8 = 256 * var8 / (256 + client.field357);
            var9 = var9 * 256 / (client.field357 + 256);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1685(var5.field2918 / 2 + var10 - var4.field1408 / 2, var5.field2917 / 2 - var11 - var4.field1411 / 2, var0, var1, var5.field2918, var5.field2917, var5.field2920, var5.field2922);
            } else {
               var4.method1667(var10 + var0 + var5.field2918 / 2 - var4.field1408 / 2, var1 + var5.field2917 / 2 - var11 - var4.field1411 / 2);
            }

         }
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field106 = var1;
      this.field117 = var2;
      this.field103 = var3;
      this.field104 = var4;
      this.field105 = var5;
      this.field107 = var6;
      this.field123 = var7;
      this.field109 = var8;
      this.field110 = var9;
      this.field120 = var10;
      this.field108 = var11;
      this.field112 = false;
      int var12 = class16.method162(this.field106).field1014;
      if(var12 != -1) {
         this.field116 = class18.method177(var12);
      } else {
         this.field116 = null;
      }

   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "326"
   )
   static final void method80(String var0) {
      if(!var0.equals("")) {
         client.field325.method2733(93);
         client.field325.method2453(class102.method2237(var0));
         client.field325.method2586(var0);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IS)I",
      garbageValue = "256"
   )
   public static int method83(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class99.method2158(var9);
         var8 = class99.method2158(var10);
         var9 = class50.method989(var9, var2);
         var10 = class50.method989(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class74.method1544(var9, var2) - class74.method1544(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var12 != var11) {
               return class74.method1544(var11, var2) - class74.method1544(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return class74.method1544(var12, var2) - class74.method1544(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass22;",
      garbageValue = "-40883761"
   )
   static class22 method84(int var0) {
      class22 var1 = (class22)class22.field593.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class129.field2067.method3221(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field2000 = var3.field2001.length - 12;
            int var4 = var3.method2505();
            var1.field583 = var3.method2470();
            var1.field584 = var3.method2470();
            var1.field585 = var3.method2470();
            var1.field594 = var3.method2470();
            var3.field2000 = 0;
            var3.method2566();
            var1.field580 = new int[var4];
            var1.field586 = new int[var4];
            var1.field582 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2000 < var3.field2001.length - 12; var1.field580[var5++] = var6) {
               var6 = var3.method2470();
               if(var6 == 3) {
                  var1.field582[var5] = var3.method2476();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field586[var5] = var3.method2505();
               } else {
                  var1.field586[var5] = var3.method2494();
               }
            }

            class22.field593.method3724(var1, (long)var0);
            return var1;
         }
      }
   }
}
