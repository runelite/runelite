import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1797463595
   )
   int field1744;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1876407645
   )
   @Export("x")
   int field1745;
   @ObfuscatedName("z")
   boolean field1746;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 990371579
   )
   int field1747;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1413843015
   )
   @Export("plane")
   int field1748;
   @ObfuscatedName("u")
   class97 field1749;
   @ObfuscatedName("o")
   @Export("wallObject")
   class87 field1750;
   @ObfuscatedName("b")
   @Export("decorativeObject")
   class94 field1751;
   @ObfuscatedName("k")
   @Export("groundObject")
   class93 field1752;
   @ObfuscatedName("c")
   @Export("itemLayer")
   class99 field1753;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2064989995
   )
   int field1754;
   @ObfuscatedName("t")
   @Export("objects")
   class98[] field1755 = new class98[5];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 453772879
   )
   int field1756;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -66320025
   )
   int field1757 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -523613943
   )
   int field1758;
   @ObfuscatedName("e")
   boolean field1759;
   @ObfuscatedName("h")
   boolean field1760;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1164895499
   )
   int field1761;
   @ObfuscatedName("i")
   int[] field1762 = new int[5];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1164348179
   )
   int field1763;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1601653821
   )
   @Export("y")
   int field1765;
   @ObfuscatedName("f")
   class101 field1766;
   @ObfuscatedName("d")
   class89 field1767;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-848048036"
   )
   public static int method2264(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class94.method2145(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2018128991"
   )
   static final void method2265() {
      short var0 = 256;
      int var1;
      if(class31.field724 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field724 > 768) {
               class31.field722[var1] = class40.method809(class1.field26[var1], class11.field169[var1], 1024 - class31.field724);
            } else if(class31.field724 > 256) {
               class31.field722[var1] = class11.field169[var1];
            } else {
               class31.field722[var1] = class40.method809(class11.field169[var1], class1.field26[var1], 256 - class31.field724);
            }
         }
      } else if(class31.field735 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field735 > 768) {
               class31.field722[var1] = class40.method809(class1.field26[var1], class31.field741[var1], 1024 - class31.field735);
            } else if(class31.field735 > 256) {
               class31.field722[var1] = class31.field741[var1];
            } else {
               class31.field722[var1] = class40.method809(class31.field741[var1], class1.field26[var1], 256 - class31.field735);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class31.field722[var1] = class1.field26[var1];
         }
      }

      class79.method1767(class31.field748, 9, class31.field748 + 128, var0 + 7);
      class20.field569.method1674(class31.field748, 0);
      class79.method1766();
      var1 = 0;
      int var2 = class135.field2094.field1397 * 9 + class31.field748;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field721[var3] * (var0 - var3) / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class27.field665[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class31.field722[var7];
               var10 = class135.field2094.field1401[var2];
               class135.field2094.field1401[var2++] = ((var7 & 16711935) * var8 + var9 * (var10 & 16711935) & -16711936) + ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class135.field2094.field1397 - 128;
      }

      class79.method1767(class31.field748 + 765 - 128, 9, 765 + class31.field748, 7 + var0);
      class121.field2016.method1674(class31.field748 + 382, 0);
      class79.method1766();
      var1 = 0;
      var2 = class31.field748 + 637 + 24 + class135.field2094.field1397 * 9;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class31.field721[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class27.field665[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class31.field722[var7];
               var10 = class135.field2094.field1401[var2];
               class135.field2094.field1401[var2++] = ((var7 & '\uff00') * var8 + (var10 & '\uff00') * var9 & 16711680) + (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class135.field2094.field1397 - var5 - var4;
      }

   }

   class101(int var1, int var2, int var3) {
      this.field1748 = var1 * -1413843015;
      this.field1747 = var1;
      this.field1745 = var2;
      this.field1765 = var3;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2073796392"
   )
   static final void method2266() {
      for(class6 var0 = (class6)client.field414.method3812(); var0 != null; var0 = (class6)client.field414.method3817()) {
         if(class21.field581 == var0.field108 && client.field335 <= var0.field109) {
            if(client.field335 >= var0.field127) {
               if(var0.field112 > 0) {
                  class34 var1 = client.field515[var0.field112 - 1];
                  if(var1 != null && var1.field823 >= 0 && var1.field823 < 13312 && var1.field813 >= 0 && var1.field813 < 13312) {
                     var0.method91(var1.field823, var1.field813, class107.method2369(var1.field823, var1.field813, var0.field108) - var0.field107, client.field335);
                  }
               }

               if(var0.field112 < 0) {
                  int var3 = -var0.field112 - 1;
                  class2 var2;
                  if(client.field291 == var3) {
                     var2 = class106.field1881;
                  } else {
                     var2 = client.field491[var3];
                  }

                  if(null != var2 && var2.field823 >= 0 && var2.field823 < 13312 && var2.field813 >= 0 && var2.field813 < 13312) {
                     var0.method91(var2.field823, var2.field813, class107.method2369(var2.field823, var2.field813, var0.field108) - var0.field107, client.field335);
                  }
               }

               var0.method92(client.field356);
               client.field339.method1906(class21.field581, (int)var0.field114, (int)var0.field115, (int)var0.field103, 60, var0, var0.field122, -1, false);
            }
         } else {
            var0.method3898();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-92"
   )
   public static void method2267(class119 var0) {
      byte[] var1 = new byte[24];

      try {
         class149.field2242.method4141(0L);
         class149.field2242.method4130(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2486(var1, 0, 24);
   }
}
