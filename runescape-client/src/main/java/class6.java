import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("i")
   @Export("animationSequence")
   class42 field107;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 178886471
   )
   @Export("floor")
   int field108;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 172761113
   )
   @Export("x1")
   int field109;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2022490565
   )
   @Export("y1")
   int field110;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 497477045
   )
   int field111;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1854245067
   )
   int field112;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1170168809
   )
   @Export("startTime")
   int field113;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1305639931
   )
   int field114;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1585860901
   )
   int field115;
   @ObfuscatedName("t")
   @Export("velocityY")
   double field116;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1456061825
   )
   @Export("interacting")
   int field117;
   @ObfuscatedName("k")
   @Export("isMoving")
   boolean field118 = false;
   @ObfuscatedName("o")
   @Export("x")
   double field119;
   @ObfuscatedName("q")
   @Export("velocityZ")
   double field120;
   @ObfuscatedName("p")
   @Export("z")
   double field121;
   @ObfuscatedName("h")
   double field122;
   @ObfuscatedName("e")
   @Export("scalar")
   double field123;
   @ObfuscatedName("w")
   @Export("velocityX")
   double field124;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1108764545
   )
   int field125 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 238318589
   )
   @Export("z1")
   int field126;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 592125549
   )
   int field127;
   @ObfuscatedName("ni")
   static class56 field128;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -105097701
   )
   @Export("start")
   int field129;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 739456223
   )
   int field130 = 0;
   @ObfuscatedName("v")
   @Export("az")
   double field131;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -410226201
   )
   @Export("id")
   int field132;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "730685138"
   )
   static int method92(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return class142.field2173 != null && class142.field2173.field3115 == var2?1 + class171.field2712.field1998 * 99 / (class171.field2712.field2000.length - class142.field2173.field2737):0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)Lclass80;",
      garbageValue = "-91"
   )
   static class80 method93(class167 var0, int var1, int var2) {
      return !class94.method2227(var0, var1, var2)?null:class158.method3192();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      class43 var1 = class1.method12(this.field132);
      class105 var2 = var1.method952(this.field130);
      if(var2 == null) {
         return null;
      } else {
         var2.method2372(this.field111);
         return var2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "954713332"
   )
   final void method96(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field118) {
         var5 = (double)(var1 - this.field109);
         double var7 = (double)(var2 - this.field110);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field119 = (double)this.field129 * var5 / var9 + (double)this.field109;
         this.field120 = var7 * (double)this.field129 / var9 + (double)this.field110;
         this.field121 = (double)this.field126;
      }

      var5 = (double)(1 + this.field114 - var4);
      this.field122 = ((double)var1 - this.field119) / var5;
      this.field123 = ((double)var2 - this.field120) / var5;
      this.field116 = Math.sqrt(this.field122 * this.field122 + this.field123 * this.field123);
      if(!this.field118) {
         this.field124 = -this.field116 * Math.tan((double)this.field115 * 0.02454369D);
      }

      this.field131 = ((double)var3 - this.field121 - var5 * this.field124) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public static void method97() {
      class173.field2748.method3796();
      class173.field2749.method3796();
      class173.field2760.method3796();
      class173.field2861.method3796();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "273773033"
   )
   final void method104(int var1) {
      this.field118 = true;
      this.field119 += (double)var1 * this.field122;
      this.field120 += (double)var1 * this.field123;
      this.field121 += this.field124 * (double)var1 + (double)var1 * 0.5D * this.field131 * (double)var1;
      this.field124 += this.field131 * (double)var1;
      this.field127 = (int)(Math.atan2(this.field122, this.field123) * 325.949D) + 1024 & 2047;
      this.field111 = (int)(Math.atan2(this.field124, this.field116) * 325.949D) & 2047;
      if(null != this.field107) {
         this.field125 += var1;

         while(true) {
            do {
               do {
                  if(this.field125 <= this.field107.field1004[this.field130]) {
                     return;
                  }

                  this.field125 -= this.field107.field1004[this.field130];
                  ++this.field130;
               } while(this.field130 < this.field107.field999.length);

               this.field130 -= this.field107.field1014;
            } while(this.field130 >= 0 && this.field130 < this.field107.field999.length);

            this.field130 = 0;
         }
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field132 = var1;
      this.field108 = var2;
      this.field109 = var3;
      this.field110 = var4;
      this.field126 = var5;
      this.field113 = var6;
      this.field114 = var7;
      this.field115 = var8;
      this.field129 = var9;
      this.field117 = var10;
      this.field112 = var11;
      this.field118 = false;
      int var12 = class1.method12(this.field132).field1020;
      if(var12 != -1) {
         this.field107 = class34.method768(var12);
      } else {
         this.field107 = null;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass37;IB)V",
      garbageValue = "1"
   )
   static final void method106(class37 var0, int var1) {
      int var3;
      int var4;
      int var8;
      if(var0.field823 > client.field301) {
         class11.method160(var0);
      } else if(var0.field866 >= client.field301) {
         if(var0.field866 == client.field301 || var0.field822 == -1 || var0.field855 != 0 || var0.field854 + 1 > class34.method768(var0.field822).field1004[var0.field853]) {
            var8 = var0.field866 - var0.field823;
            var3 = client.field301 - var0.field823;
            var4 = var0.field862 * 128 + var0.field825 * 64;
            int var5 = var0.field864 * 128 + var0.field825 * 64;
            int var6 = var0.field825 * 64 + var0.field838 * 128;
            int var7 = var0.field825 * 64 + var0.field844 * 128;
            var0.field837 = ((var8 - var3) * var4 + var6 * var3) / var8;
            var0.field880 = ((var8 - var3) * var5 + var3 * var7) / var8;
         }

         var0.field865 = 0;
         var0.field871 = var0.field850;
         var0.field883 = var0.field871;
      } else {
         class17.method200(var0);
      }

      if(var0.field837 < 128 || var0.field880 < 128 || var0.field837 >= 13184 || var0.field880 >= 13184) {
         var0.field822 = -1;
         var0.field857 = -1;
         var0.field823 = 0;
         var0.field866 = 0;
         var0.field837 = 128 * var0.field875[0] + var0.field825 * 64;
         var0.field880 = var0.field825 * 64 + 128 * var0.field876[0];
         var0.method792();
      }

      if(var0 == class15.field225 && (var0.field837 < 1536 || var0.field880 < 1536 || var0.field837 >= 11776 || var0.field880 >= 11776)) {
         var0.field822 = -1;
         var0.field857 = -1;
         var0.field823 = 0;
         var0.field866 = 0;
         var0.field837 = var0.field825 * 64 + var0.field875[0] * 128;
         var0.field880 = var0.field876[0] * 128 + var0.field825 * 64;
         var0.method792();
      }

      if(var0.field873 != 0) {
         if(var0.field846 != -1) {
            Object var2 = null;
            if(var0.field846 < '耀') {
               var2 = client.field328[var0.field846];
            } else if(var0.field846 >= '耀') {
               var2 = client.field302[var0.field846 - '耀'];
            }

            if(null != var2) {
               var3 = var0.field837 - ((class37)var2).field837;
               var4 = var0.field880 - ((class37)var2).field880;
               if(var3 != 0 || var4 != 0) {
                  var0.field871 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field847) {
               var0.field846 = -1;
               var0.field847 = false;
            }
         }

         if(var0.field848 != -1 && (var0.field874 == 0 || var0.field865 > 0)) {
            var0.field871 = var0.field848;
            var0.field848 = -1;
         }

         var8 = var0.field871 - var0.field883 & 2047;
         if(var8 == 0 && var0.field847) {
            var0.field846 = -1;
            var0.field847 = false;
         }

         if(var8 != 0) {
            ++var0.field872;
            boolean var11;
            if(var8 > 1024) {
               var0.field883 -= var0.field873;
               var11 = true;
               if(var8 < var0.field873 || var8 > 2048 - var0.field873) {
                  var0.field883 = var0.field871;
                  var11 = false;
               }

               if(var0.field826 == var0.field849 && (var0.field872 > 25 || var11)) {
                  if(var0.field827 != -1) {
                     var0.field849 = var0.field827;
                  } else {
                     var0.field849 = var0.field829;
                  }
               }
            } else {
               var0.field883 += var0.field873;
               var11 = true;
               if(var8 < var0.field873 || var8 > 2048 - var0.field873) {
                  var0.field883 = var0.field871;
                  var11 = false;
               }

               if(var0.field826 == var0.field849 && (var0.field872 > 25 || var11)) {
                  if(var0.field845 != -1) {
                     var0.field849 = var0.field845;
                  } else {
                     var0.field849 = var0.field829;
                  }
               }
            }

            var0.field883 &= 2047;
         } else {
            var0.field872 = 0;
         }
      }

      var0.field858 = false;
      class42 var10;
      if(var0.field849 != -1) {
         var10 = class34.method768(var0.field849);
         if(var10 != null && var10.field999 != null) {
            ++var0.field851;
            if(var0.field868 < var10.field999.length && var0.field851 > var10.field1004[var0.field868]) {
               var0.field851 = 1;
               ++var0.field868;
               class33.method750(var10, var0.field868, var0.field837, var0.field880);
            }

            if(var0.field868 >= var10.field999.length) {
               var0.field851 = 0;
               var0.field868 = 0;
               class33.method750(var10, var0.field868, var0.field837, var0.field880);
            }
         } else {
            var0.field849 = -1;
         }
      }

      if(var0.field857 != -1 && client.field301 >= var0.field860) {
         if(var0.field821 < 0) {
            var0.field821 = 0;
         }

         var8 = class1.method12(var0.field857).field1020;
         if(var8 != -1) {
            class42 var9 = class34.method768(var8);
            if(var9 != null && var9.field999 != null) {
               ++var0.field859;
               if(var0.field821 < var9.field999.length && var0.field859 > var9.field1004[var0.field821]) {
                  var0.field859 = 1;
                  ++var0.field821;
                  class33.method750(var9, var0.field821, var0.field837, var0.field880);
               }

               if(var0.field821 >= var9.field999.length && (var0.field821 < 0 || var0.field821 >= var9.field999.length)) {
                  var0.field857 = -1;
               }
            } else {
               var0.field857 = -1;
            }
         } else {
            var0.field857 = -1;
         }
      }

      if(var0.field822 != -1 && var0.field855 <= 1) {
         var10 = class34.method768(var0.field822);
         if(var10.field1008 == 1 && var0.field879 > 0 && var0.field823 <= client.field301 && var0.field866 < client.field301) {
            var0.field855 = 1;
            return;
         }
      }

      if(var0.field822 != -1 && var0.field855 == 0) {
         var10 = class34.method768(var0.field822);
         if(var10 != null && var10.field999 != null) {
            ++var0.field854;
            if(var0.field853 < var10.field999.length && var0.field854 > var10.field1004[var0.field853]) {
               var0.field854 = 1;
               ++var0.field853;
               class33.method750(var10, var0.field853, var0.field837, var0.field880);
            }

            if(var0.field853 >= var10.field999.length) {
               var0.field853 -= var10.field1014;
               ++var0.field856;
               if(var0.field856 >= var10.field1012) {
                  var0.field822 = -1;
               } else if(var0.field853 >= 0 && var0.field853 < var10.field999.length) {
                  class33.method750(var10, var0.field853, var0.field837, var0.field880);
               } else {
                  var0.field822 = -1;
               }
            }

            var0.field858 = var10.field1019;
         } else {
            var0.field822 = -1;
         }
      }

      if(var0.field855 > 0) {
         --var0.field855;
      }

   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "2121375375"
   )
   static boolean method107(class173 var0) {
      if(client.field534) {
         if(class18.method205(var0) != 0) {
            return false;
         }

         if(var0.field2798 == 0) {
            return false;
         }
      }

      return var0.field2774;
   }
}
