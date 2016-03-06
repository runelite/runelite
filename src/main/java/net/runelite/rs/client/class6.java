import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("o")
@Implements("Projectile")
public final class class6 extends class84 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -713746405
   )
   int field105;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1108650279
   )
   int field106;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 658278759
   )
   int field107;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 497914173
   )
   int field108;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1546062935
   )
   int field109;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 561082663
   )
   int field110 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 594521111
   )
   static int field111;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -46271889
   )
   int field112;
   @ObfuscatedName("q")
   double field113;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -932250583
   )
   int field114;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1189948143
   )
   int field115;
   @ObfuscatedName("b")
   @Export("isMoving")
   boolean field116 = false;
   @ObfuscatedName("u")
   @Export("velocityZ")
   double field117;
   @ObfuscatedName("d")
   @Export("velocityY")
   double field118;
   @ObfuscatedName("y")
   double field120;
   @ObfuscatedName("s")
   @Export("scalar")
   double field121;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1117354203
   )
   int field122;
   @ObfuscatedName("g")
   double field123;
   @ObfuscatedName("p")
   double field124;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1759038597
   )
   int field125;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -47179107
   )
   int field126;
   @ObfuscatedName("c")
   @Export("animationSequence")
   class42 field127;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1642777661
   )
   int field128;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1505552255
   )
   int field129 = 0;
   @ObfuscatedName("z")
   @Export("velocityX")
   double field130;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -196598653
   )
   static int field131;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 948816275
   )
   int field132;

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field114 = var1;
      this.field106 = var2;
      this.field107 = var3;
      this.field132 = var4;
      this.field109 = var5;
      this.field105 = var6;
      this.field112 = var7;
      this.field128 = var8;
      this.field108 = var9;
      this.field115 = var10;
      this.field122 = var11;
      this.field116 = false;
      int var12 = class26.method635(this.field114).field1012;
      if(var12 != -1) {
         this.field127 = class36.method741(var12);
      } else {
         this.field127 = null;
      }

   }

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      class43 var1 = class26.method635(this.field114);
      class104 var2 = var1.method899(this.field110);
      if(var2 == null) {
         return null;
      } else {
         var2.method2269(this.field126);
         return var2;
      }
   }

   @ObfuscatedName("j")
   final void method85(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field116) {
         var5 = (double)(var1 - this.field107);
         double var7 = (double)(var2 - this.field132);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field113 = var5 * (double)this.field108 / var9 + (double)this.field107;
         this.field117 = (double)this.field132 + var7 * (double)this.field108 / var9;
         this.field123 = (double)this.field109;
      }

      var5 = (double)(1 + this.field112 - var4);
      this.field120 = ((double)var1 - this.field113) / var5;
      this.field121 = ((double)var2 - this.field117) / var5;
      this.field118 = Math.sqrt(this.field120 * this.field120 + this.field121 * this.field121);
      if(!this.field116) {
         this.field130 = -this.field118 * Math.tan((double)this.field128 * 0.02454369D);
      }

      this.field124 = 2.0D * ((double)var3 - this.field123 - this.field130 * var5) / (var5 * var5);
   }

   @ObfuscatedName("b")
   static void method86() {
      if(class139.field2168 == 1 || !class94.field1617 && 4 == class139.field2168) {
         int var0 = 280 + class31.field732;
         if(class139.field2169 >= var0 && class139.field2169 <= 14 + var0 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(0, 0);
            return;
         }

         if(class139.field2169 >= 15 + var0 && class139.field2169 <= 80 + var0 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(0, 1);
            return;
         }

         int var1 = class31.field732 + 390;
         if(class139.field2169 >= var1 && class139.field2169 <= 14 + var1 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(1, 0);
            return;
         }

         if(class139.field2169 >= 15 + var1 && class139.field2169 <= 80 + var1 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(1, 1);
            return;
         }

         int var2 = 500 + class31.field732;
         if(class139.field2169 >= var2 && class139.field2169 <= var2 + 14 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(2, 0);
            return;
         }

         if(class139.field2169 >= 15 + var2 && class139.field2169 <= 80 + var2 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(2, 1);
            return;
         }

         int var3 = class31.field732 + 610;
         if(class139.field2169 >= var3 && class139.field2169 <= var3 + 14 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(3, 0);
            return;
         }

         if(class139.field2169 >= 15 + var3 && class139.field2169 <= 80 + var3 && class139.field2163 >= 4 && class139.field2163 <= 18) {
            class36.method747(3, 1);
            return;
         }

         if(class139.field2169 >= class31.field732 + 708 && class139.field2163 >= 4 && class139.field2169 <= 50 + 708 + class31.field732 && class139.field2163 <= 20) {
            class31.field721 = false;
            class24.field625.method1744(class31.field732, 0);
            class31.field712.method1744(382 + class31.field732, 0);
            class31.field713.method1838(382 + class31.field732 - class31.field713.field1431 / 2, 18);
            return;
         }

         if(class31.field739 != -1) {
            class25 var4 = class25.field632[class31.field739];
            class1.method8(var4);
            class31.field721 = false;
            class24.field625.method1744(class31.field732, 0);
            class31.field712.method1744(382 + class31.field732, 0);
            class31.field713.method1838(class31.field732 + 382 - class31.field713.field1431 / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("bc")
   static final void method91() {
      for(int var0 = 0; var0 < client.field327; ++var0) {
         int var1 = client.field328[var0];
         class34 var2 = client.field324[var1];
         int var3 = client.field293.method2453();
         int var4;
         int var5;
         if(0 != (var3 & 1)) {
            var4 = client.field293.method2571();
            var5 = client.field293.method2453();
            var2.method754(var4, var5, client.field394);
            var2.field849 = client.field394 + 300;
            var2.field812 = client.field293.method2488();
            var2.field834 = client.field293.method2487();
         }

         int var6;
         if((var3 & 8) != 0) {
            var4 = client.field293.method2487();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field293.method2571();
            if(var4 == var2.field820 && var4 != -1) {
               var6 = class36.method741(var4).field990;
               if(var6 == 1) {
                  var2.field827 = 0;
                  var2.field837 = 0;
                  var2.field844 = var5;
                  var2.field845 = 0;
               }

               if(2 == var6) {
                  var2.field845 = 0;
               }
            } else if(var4 == -1 || -1 == var2.field820 || class36.method741(var4).field993 >= class36.method741(var2.field820).field993) {
               var2.field820 = var4;
               var2.field827 = 0;
               var2.field837 = 0;
               var2.field844 = var5;
               var2.field845 = 0;
               var2.field868 = var2.field824;
            }
         }

         if((var3 & 32) != 0) {
            var2.field835 = client.field293.method2488();
            if('\uffff' == var2.field835) {
               var2.field835 = -1;
            }
         }

         if(0 != (var3 & 4)) {
            var4 = client.field293.method2487();
            var5 = client.field293.method2489();
            var6 = var2.field839 - (var4 - class98.field1683 - class98.field1683) * 64;
            int var7 = var2.field848 - 64 * (var5 - class92.field1598 - class92.field1598);
            if(var6 != 0 || var7 != 0) {
               var2.field853 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if(0 != (var3 & 128)) {
            var4 = client.field293.method2481();
            var5 = client.field293.method2453();
            var2.method754(var4, var5, client.field394);
            var2.field849 = 300 + client.field394;
            var2.field812 = client.field293.method2487();
            var2.field834 = client.field293.method2455();
         }

         if((var3 & 2) != 0) {
            var2.field846 = client.field293.method2487();
            var4 = client.field293.method2509();
            var2.field850 = var4 >> 16;
            var2.field833 = (var4 & '\uffff') + client.field394;
            var2.field847 = 0;
            var2.field841 = 0;
            if(var2.field833 > client.field394) {
               var2.field847 = -1;
            }

            if('\uffff' == var2.field846) {
               var2.field846 = -1;
            }
         }

         if((var3 & 16) != 0) {
            var2.field779 = class14.method162(client.field293.method2489());
            var2.field814 = var2.field779.field885;
            var2.field862 = var2.field779.field908;
            var2.field818 = var2.field779.field906 * -1;
            var2.field819 = var2.field779.field887 * -1;
            var2.field811 = var2.field779.field893 * -1;
            var2.field821 = var2.field779.field907 * -1;
            var2.field815 = var2.field779.field888 * -1;
            var2.field816 = var2.field779.field889 * -1;
            var2.field857 = var2.field779.field890 * -1;
         }

         if((var3 & 64) != 0) {
            var2.field823 = client.field293.method2461();
            var2.field826 = 100;
         }
      }

   }

   @ObfuscatedName("l")
   final void method92(int var1) {
      this.field116 = true;
      this.field113 += (double)var1 * this.field120;
      this.field117 += (double)var1 * this.field121;
      this.field123 += (double)var1 * this.field130 + this.field124 * 0.5D * (double)var1 * (double)var1;
      this.field130 += this.field124 * (double)var1;
      this.field125 = (int)(Math.atan2(this.field120, this.field121) * 325.949D) + 1024 & 2047;
      this.field126 = (int)(Math.atan2(this.field130, this.field118) * 325.949D) & 2047;
      if(null != this.field127) {
         this.field129 += var1;

         while(true) {
            do {
               do {
                  if(this.field129 <= this.field127.field988[this.field110]) {
                     return;
                  }

                  this.field129 -= this.field127.field988[this.field110];
                  ++this.field110;
               } while(this.field110 < this.field127.field986.length);

               this.field110 -= this.field127.field983 * -1;
            } while(this.field110 >= 0 && this.field110 < this.field127.field986.length);

            this.field110 = 0;
         }
      }
   }

   @ObfuscatedName("j")
   public static int method93(int var0, int var1, int var2, class106 var3, class107 var4, int[] var5, int[] var6) {
      int var8;
      for(int var7 = 0; var7 < 128; ++var7) {
         for(var8 = 0; var8 < 128; ++var8) {
            class105.field1870[var7][var8] = 0;
            class105.field1880[var7][var8] = 99999999;
         }
      }

      int var9;
      int var10;
      byte var11;
      byte var12;
      int var13;
      int var14;
      byte var15;
      int var16;
      int[][] var17;
      int var18;
      int var19;
      int var20;
      int var21;
      boolean var26;
      boolean var27;
      int var28;
      int var29;
      int var31;
      if(1 == var2) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class105.field1870[var11][var12] = 99;
         class105.field1880[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class105.field1875[var15] = var0;
         var31 = var15 + 1;
         class105.field1877[var15] = var1;
         var17 = var4.field1904;

         while(true) {
            if(var16 == var31) {
               class105.field1872 = var9;
               class105.field1873 = var10;
               var27 = false;
               break;
            }

            var9 = class105.field1875[var16];
            var10 = class105.field1877[var16];
            var16 = var16 + 1 & 4095;
            var28 = var9 - var13;
            var29 = var10 - var14;
            var18 = var9 - var4.field1895;
            var19 = var10 - var4.field1901;
            if(var3.vmethod2336(var9, var10)) {
               class105.field1872 = var9;
               class105.field1873 = var10;
               var27 = true;
               break;
            }

            var20 = class105.field1880[var28][var29] + 1;
            if(var28 > 0 && 0 == class105.field1870[var28 - 1][var29] && 0 == (var17[var18 - 1][var19] & 19136776)) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 - 1][var29] = 2;
               class105.field1880[var28 - 1][var29] = var20;
            }

            if(var28 < 127 && 0 == class105.field1870[1 + var28][var29] && (var17[var18 + 1][var19] & 19136896) == 0) {
               class105.field1875[var31] = 1 + var9;
               class105.field1877[var31] = var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 + 1][var29] = 8;
               class105.field1880[var28 + 1][var29] = var20;
            }

            if(var29 > 0 && class105.field1870[var28][var29 - 1] == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
               class105.field1875[var31] = var9;
               class105.field1877[var31] = var10 - 1;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28][var29 - 1] = 1;
               class105.field1880[var28][var29 - 1] = var20;
            }

            if(var29 < 127 && 0 == class105.field1870[var28][1 + var29] && 0 == (var17[var18][var19 + 1] & 19136800)) {
               class105.field1875[var31] = var9;
               class105.field1877[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class105.field1870[var28][1 + var29] = 4;
               class105.field1880[var28][1 + var29] = var20;
            }

            if(var28 > 0 && var29 > 0 && 0 == class105.field1870[var28 - 1][var29 - 1] && (var17[var18 - 1][var19 - 1] & 19136782) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1870[var28 - 1][var29 - 1] = 3;
               class105.field1880[var28 - 1][var29 - 1] = var20;
            }

            if(var28 < 127 && var29 > 0 && 0 == class105.field1870[var28 + 1][var29 - 1] && 0 == (var17[1 + var18][var19 - 1] & 19136899) && 0 == (var17[var18 + 1][var19] & 19136896) && 0 == (var17[var18][var19 - 1] & 19136770)) {
               class105.field1875[var31] = 1 + var9;
               class105.field1877[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1870[1 + var28][var29 - 1] = 9;
               class105.field1880[var28 + 1][var29 - 1] = var20;
            }

            if(var28 > 0 && var29 < 127 && 0 == class105.field1870[var28 - 1][var29 + 1] && (var17[var18 - 1][var19 + 1] & 19136824) == 0 && 0 == (var17[var18 - 1][var19] & 19136776) && (var17[var18][1 + var19] & 19136800) == 0) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class105.field1870[var28 - 1][var29 + 1] = 6;
               class105.field1880[var28 - 1][var29 + 1] = var20;
            }

            if(var28 < 127 && var29 < 127 && 0 == class105.field1870[var28 + 1][1 + var29] && (var17[1 + var18][1 + var19] & 19136992) == 0 && 0 == (var17[1 + var18][var19] & 19136896) && 0 == (var17[var18][var19 + 1] & 19136800)) {
               class105.field1875[var31] = var9 + 1;
               class105.field1877[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 + 1][var29 + 1] = 12;
               class105.field1880[1 + var28][1 + var29] = var20;
            }
         }

         var26 = var27;
      } else if(var2 == 2) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class105.field1870[var11][var12] = 99;
         class105.field1880[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class105.field1875[var15] = var0;
         var31 = var15 + 1;
         class105.field1877[var15] = var1;
         var17 = var4.field1904;

         while(true) {
            if(var16 == var31) {
               class105.field1872 = var9;
               class105.field1873 = var10;
               var27 = false;
               break;
            }

            var9 = class105.field1875[var16];
            var10 = class105.field1877[var16];
            var16 = var16 + 1 & 4095;
            var28 = var9 - var13;
            var29 = var10 - var14;
            var18 = var9 - var4.field1895;
            var19 = var10 - var4.field1901;
            if(var3.vmethod2336(var9, var10)) {
               class105.field1872 = var9;
               class105.field1873 = var10;
               var27 = true;
               break;
            }

            var20 = class105.field1880[var28][var29] + 1;
            if(var28 > 0 && class105.field1870[var28 - 1][var29] == 0 && 0 == (var17[var18 - 1][var19] & 19136782) && 0 == (var17[var18 - 1][1 + var19] & 19136824)) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 - 1][var29] = 2;
               class105.field1880[var28 - 1][var29] = var20;
            }

            if(var28 < 126 && class105.field1870[1 + var28][var29] == 0 && (var17[var18 + 2][var19] & 19136899) == 0 && (var17[var18 + 2][var19 + 1] & 19136992) == 0) {
               class105.field1875[var31] = var9 + 1;
               class105.field1877[var31] = var10;
               var31 = 1 + var31 & 4095;
               class105.field1870[1 + var28][var29] = 8;
               class105.field1880[var28 + 1][var29] = var20;
            }

            if(var29 > 0 && class105.field1870[var28][var29 - 1] == 0 && 0 == (var17[var18][var19 - 1] & 19136782) && (var17[var18 + 1][var19 - 1] & 19136899) == 0) {
               class105.field1875[var31] = var9;
               class105.field1877[var31] = var10 - 1;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28][var29 - 1] = 1;
               class105.field1880[var28][var29 - 1] = var20;
            }

            if(var29 < 126 && 0 == class105.field1870[var28][1 + var29] && 0 == (var17[var18][var19 + 2] & 19136824) && (var17[1 + var18][var19 + 2] & 19136992) == 0) {
               class105.field1875[var31] = var9;
               class105.field1877[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28][var29 + 1] = 4;
               class105.field1880[var28][1 + var29] = var20;
            }

            if(var28 > 0 && var29 > 0 && class105.field1870[var28 - 1][var29 - 1] == 0 && 0 == (var17[var18 - 1][var19] & 19136830) && 0 == (var17[var18 - 1][var19 - 1] & 19136782) && 0 == (var17[var18][var19 - 1] & 19136911)) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = var10 - 1;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 - 1][var29 - 1] = 3;
               class105.field1880[var28 - 1][var29 - 1] = var20;
            }

            if(var28 < 126 && var29 > 0 && class105.field1870[var28 + 1][var29 - 1] == 0 && (var17[var18 + 1][var19 - 1] & 19136911) == 0 && (var17[var18 + 2][var19 - 1] & 19136899) == 0 && (var17[var18 + 2][var19] & 19136995) == 0) {
               class105.field1875[var31] = 1 + var9;
               class105.field1877[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1870[1 + var28][var29 - 1] = 9;
               class105.field1880[1 + var28][var29 - 1] = var20;
            }

            if(var28 > 0 && var29 < 126 && class105.field1870[var28 - 1][1 + var29] == 0 && 0 == (var17[var18 - 1][1 + var19] & 19136830) && (var17[var18 - 1][var19 + 2] & 19136824) == 0 && (var17[var18][var19 + 2] & 19137016) == 0) {
               class105.field1875[var31] = var9 - 1;
               class105.field1877[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class105.field1870[var28 - 1][1 + var29] = 6;
               class105.field1880[var28 - 1][1 + var29] = var20;
            }

            if(var28 < 126 && var29 < 126 && class105.field1870[var28 + 1][1 + var29] == 0 && 0 == (var17[var18 + 1][2 + var19] & 19137016) && (var17[var18 + 2][2 + var19] & 19136992) == 0 && (var17[2 + var18][var19 + 1] & 19136995) == 0) {
               class105.field1875[var31] = var9 + 1;
               class105.field1877[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[1 + var28][var29 + 1] = 12;
               class105.field1880[1 + var28][var29 + 1] = var20;
            }
         }

         var26 = var27;
      } else {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class105.field1870[var11][var12] = 99;
         class105.field1880[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class105.field1875[var15] = var0;
         var31 = var15 + 1;
         class105.field1877[var15] = var1;
         var17 = var4.field1904;

         label888:
         while(true) {
            label886:
            while(true) {
               do {
                  do {
                     do {
                        label863:
                        do {
                           if(var16 == var31) {
                              class105.field1872 = var9;
                              class105.field1873 = var10;
                              var27 = false;
                              break label888;
                           }

                           var9 = class105.field1875[var16];
                           var10 = class105.field1877[var16];
                           var16 = var16 + 1 & 4095;
                           var28 = var9 - var13;
                           var29 = var10 - var14;
                           var18 = var9 - var4.field1895;
                           var19 = var10 - var4.field1901;
                           if(var3.vmethod2336(var9, var10)) {
                              class105.field1872 = var9;
                              class105.field1873 = var10;
                              var27 = true;
                              break label888;
                           }

                           var20 = class105.field1880[var28][var29] + 1;
                           if(var28 > 0 && class105.field1870[var28 - 1][var29] == 0 && (var17[var18 - 1][var19] & 19136782) == 0 && (var17[var18 - 1][var2 + var19 - 1] & 19136824) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class105.field1875[var31] = var9 - 1;
                                    class105.field1877[var31] = var10;
                                    var31 = var31 + 1 & 4095;
                                    class105.field1870[var28 - 1][var29] = 2;
                                    class105.field1880[var28 - 1][var29] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var18 - 1][var21 + var19] & 19136830)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 < 128 - var2 && 0 == class105.field1870[1 + var28][var29] && 0 == (var17[var18 + var2][var19] & 19136899) && (var17[var2 + var18][var2 + var19 - 1] & 19136992) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class105.field1875[var31] = 1 + var9;
                                    class105.field1877[var31] = var10;
                                    var31 = 1 + var31 & 4095;
                                    class105.field1870[var28 + 1][var29] = 8;
                                    class105.field1880[1 + var28][var29] = var20;
                                    break;
                                 }

                                 if((var17[var2 + var18][var21 + var19] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var29 > 0 && class105.field1870[var28][var29 - 1] == 0 && (var17[var18][var19 - 1] & 19136782) == 0 && 0 == (var17[var18 + var2 - 1][var19 - 1] & 19136899)) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class105.field1875[var31] = var9;
                                    class105.field1877[var31] = var10 - 1;
                                    var31 = 1 + var31 & 4095;
                                    class105.field1870[var28][var29 - 1] = 1;
                                    class105.field1880[var28][var29 - 1] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var21 + var18][var19 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var29 < 128 - var2 && class105.field1870[var28][1 + var29] == 0 && (var17[var18][var2 + var19] & 19136824) == 0 && (var17[var18 + var2 - 1][var19 + var2] & 19136992) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class105.field1875[var31] = var9;
                                    class105.field1877[var31] = var10 + 1;
                                    var31 = var31 + 1 & 4095;
                                    class105.field1870[var28][var29 + 1] = 4;
                                    class105.field1880[var28][1 + var29] = var20;
                                    break;
                                 }

                                 if((var17[var18 + var21][var2 + var19] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 > 0 && var29 > 0 && class105.field1870[var28 - 1][var29 - 1] == 0 && (var17[var18 - 1][var19 - 1] & 19136782) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2) {
                                    class105.field1875[var31] = var9 - 1;
                                    class105.field1877[var31] = var10 - 1;
                                    var31 = var31 + 1 & 4095;
                                    class105.field1870[var28 - 1][var29 - 1] = 3;
                                    class105.field1880[var28 - 1][var29 - 1] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var18 - 1][var19 - 1 + var21] & 19136830) || (var17[var18 - 1 + var21][var19 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 < 128 - var2 && var29 > 0 && 0 == class105.field1870[1 + var28][var29 - 1] && 0 == (var17[var18 + var2][var19 - 1] & 19136899)) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2) {
                                    class105.field1875[var31] = var9 + 1;
                                    class105.field1877[var31] = var10 - 1;
                                    var31 = 1 + var31 & 4095;
                                    class105.field1870[var28 + 1][var29 - 1] = 9;
                                    class105.field1880[var28 + 1][var29 - 1] = var20;
                                    break;
                                 }

                                 if((var17[var18 + var2][var21 + (var19 - 1)] & 19136995) != 0 || (var17[var21 + var18][var19 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 > 0 && var29 < 128 - var2 && 0 == class105.field1870[var28 - 1][var29 + 1] && (var17[var18 - 1][var19 + var2] & 19136824) == 0) {
                              for(var21 = 1; var21 < var2; ++var21) {
                                 if(0 != (var17[var18 - 1][var21 + var19] & 19136830) || (var17[var18 - 1 + var21][var2 + var19] & 19137016) != 0) {
                                    continue label863;
                                 }
                              }

                              class105.field1875[var31] = var9 - 1;
                              class105.field1877[var31] = 1 + var10;
                              var31 = var31 + 1 & 4095;
                              class105.field1870[var28 - 1][var29 + 1] = 6;
                              class105.field1880[var28 - 1][1 + var29] = var20;
                           }
                        } while(var28 >= 128 - var2);
                     } while(var29 >= 128 - var2);
                  } while(class105.field1870[1 + var28][1 + var29] != 0);
               } while((var17[var18 + var2][var2 + var19] & 19136992) != 0);

               for(var21 = 1; var21 < var2; ++var21) {
                  if((var17[var18 + var21][var2 + var19] & 19137016) != 0 || (var17[var18 + var2][var21 + var19] & 19136995) != 0) {
                     continue label886;
                  }
               }

               class105.field1875[var31] = var9 + 1;
               class105.field1877[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class105.field1870[var28 + 1][var29 + 1] = 12;
               class105.field1880[1 + var28][1 + var29] = var20;
            }
         }

         var26 = var27;
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class105.field1872;
      var28 = class105.field1873;
      if(!var26) {
         var29 = Integer.MAX_VALUE;
         var13 = Integer.MAX_VALUE;
         byte var30 = 10;
         var31 = var3.field1889;
         var16 = var3.field1885;
         int var32 = var3.field1886;
         var18 = var3.field1888;

         for(var19 = var31 - var30; var19 <= var31 + var30; ++var19) {
            for(var20 = var16 - var30; var20 <= var16 + var30; ++var20) {
               var21 = var19 - var8;
               int var22 = var20 - var9;
               if(var21 >= 0 && var22 >= 0 && var21 < 128 && var22 < 128 && class105.field1880[var21][var22] < 100) {
                  int var23 = 0;
                  if(var19 < var31) {
                     var23 = var31 - var19;
                  } else if(var19 > var32 + var31 - 1) {
                     var23 = var19 - (var31 + var32 - 1);
                  }

                  int var24 = 0;
                  if(var20 < var16) {
                     var24 = var16 - var20;
                  } else if(var20 > var16 + var18 - 1) {
                     var24 = var20 - (var18 + var16 - 1);
                  }

                  int var25 = var24 * var24 + var23 * var23;
                  if(var25 < var29 || var29 == var25 && class105.field1880[var21][var22] < var13) {
                     var29 = var25;
                     var13 = class105.field1880[var21][var22];
                     var10 = var19;
                     var28 = var20;
                  }
               }
            }
         }

         if(var29 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var10 == var0 && var28 == var1) {
         return 0;
      } else {
         var12 = 0;
         class105.field1875[var12] = var10;
         var29 = var12 + 1;
         class105.field1877[var12] = var28;

         for(var13 = var14 = class105.field1870[var10 - var8][var28 - var9]; var0 != var10 || var1 != var28; var13 = class105.field1870[var10 - var8][var28 - var9]) {
            if(var13 != var14) {
               var14 = var13;
               class105.field1875[var29] = var10;
               class105.field1877[var29++] = var28;
            }

            if(0 != (var13 & 2)) {
               ++var10;
            } else if(0 != (var13 & 8)) {
               --var10;
            }

            if((var13 & 1) != 0) {
               ++var28;
            } else if((var13 & 4) != 0) {
               --var28;
            }
         }

         var31 = 0;

         while(var29-- > 0) {
            var5[var31] = class105.field1875[var29];
            var6[var31++] = class105.field1877[var29];
            if(var31 >= var5.length) {
               break;
            }
         }

         return var31;
      }
   }

   @ObfuscatedName("j")
   static int method94(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3744((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.field223.length?var2.field223[var1]:-1);
   }
}
