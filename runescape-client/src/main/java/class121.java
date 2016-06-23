import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class121 {
   @ObfuscatedName("l")
   static byte[][] field2008 = new byte[250][];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2112349305
   )
   static int field2010 = 0;
   @ObfuscatedName("px")
   static Clipboard field2011;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 78191233
   )
   static int field2012 = 0;
   @ObfuscatedName("d")
   static byte[][] field2013 = new byte[50][];
   @ObfuscatedName("nn")
   static class55 field2014;
   @ObfuscatedName("b")
   static byte[][] field2015 = new byte[1000][];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -27422653
   )
   static int field2017 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "502511783"
   )
   static synchronized byte[] method2765(int var0) {
      byte[] var1;
      if(var0 == 100 && field2017 > 0) {
         var1 = field2015[--field2017];
         field2015[field2017] = null;
         return var1;
      } else if(var0 == 5000 && field2010 > 0) {
         var1 = field2008[--field2010];
         field2008[field2010] = null;
         return var1;
      } else if(var0 == 30000 && field2012 > 0) {
         var1 = field2013[--field2012];
         field2013[field2012] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)Z",
      garbageValue = "1612924187"
   )
   static boolean method2766(class122 var0, int var1) {
      int var2 = var0.method2776(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2776(1) != 0) {
            method2766(var0, var1);
         }

         var3 = var0.method2776(6);
         var4 = var0.method2776(6);
         boolean var12 = var0.method2776(1) == 1;
         if(var12) {
            class32.field768[++class32.field765 - 1] = var1;
         }

         if(client.field302[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var6 = client.field302[var1] = new class2();
            var6.field37 = var1;
            if(null != class32.field756[var1]) {
               var6.method15(class32.field756[var1]);
            }

            var6.field871 = class32.field763[var1];
            var6.field846 = class32.field764[var1];
            var7 = class32.field762[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field828[0] = class32.field767[var1];
            var6.field35 = (byte)var8;
            var6.method33(var3 + (var9 << 6) - class172.field2734, (var10 << 6) + var4 - class20.field576);
            var6.field58 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2776(2);
         var4 = class32.field762[var1];
         class32.field762[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2776(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class32.field762[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field762[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2776(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class32.field762[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class32.field762[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "48"
   )
   public static int method2768(CharSequence var0, CharSequence var1, int var2) {
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

         var7 = class157.method3188(var9);
         var8 = class157.method3188(var10);
         var9 = class140.method3000(var9, var2);
         var10 = class140.method3000(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class111.method2480(var9, var2) - class111.method2480(var10, var2);
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
            if(var11 != var12) {
               return class111.method2480(var11, var2) - class111.method2480(var12, var2);
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
            if(var13 != var12) {
               return class111.method2480(var12, var2) - class111.method2480(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   static final void method2769() {
      short var0 = 256;
      int var1;
      if(class31.field714 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field714 > 768) {
               class84.field1463[var1] = class15.method179(class151.field2253[var1], class25.field644[var1], 1024 - class31.field714);
            } else if(class31.field714 > 256) {
               class84.field1463[var1] = class25.field644[var1];
            } else {
               class84.field1463[var1] = class15.method179(class25.field644[var1], class151.field2253[var1], 256 - class31.field714);
            }
         }
      } else if(class31.field723 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field723 > 768) {
               class84.field1463[var1] = class15.method179(class151.field2253[var1], class10.field174[var1], 1024 - class31.field723);
            } else if(class31.field723 > 256) {
               class84.field1463[var1] = class10.field174[var1];
            } else {
               class84.field1463[var1] = class15.method179(class10.field174[var1], class151.field2253[var1], 256 - class31.field723);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class84.field1463[var1] = class151.field2253[var1];
         }
      }

      class79.method1848(class31.field725, 9, class31.field725 + 128, 7 + var0);
      class31.field717.method1761(class31.field725, 0);
      class79.method1847();
      var1 = 0;
      int var2 = class12.field196.field1402 * 9 + class31.field725;

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
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class18.field270[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class84.field1463[var7];
               var10 = class12.field196.field1406[var2];
               class12.field196.field1406[var2++] = (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) + (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class12.field196.field1402 - 128;
      }

      class79.method1848(765 + class31.field725 - 128, 9, 765 + class31.field725, var0 + 7);
      class172.field2738.method1761(class31.field725 + 382, 0);
      class79.method1847();
      var1 = 0;
      var2 = 637 + 24 + class12.field196.field1402 * 9 + class31.field725;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class31.field721[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class18.field270[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class84.field1463[var7];
               var10 = class12.field196.field1406[var2];
               class12.field196.field1406[var2++] = ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) + (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class12.field196.field1402 - var5 - var4;
      }

   }
}
