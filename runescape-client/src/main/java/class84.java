import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("FaceNormal")
public class class84 {
   @ObfuscatedName("bb")
   static class168 field1422;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1518580475
   )
   int field1424;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -91037469
   )
   int field1425;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -950883371
   )
   int field1426;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass144;B)V",
      garbageValue = "-126"
   )
   static void method1908(class144 var0) {
      if(class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4) {
         int var1 = 280 + class31.field695;
         if(class140.field2141 >= var1 && class140.field2141 <= 14 + var1 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(0, 0);
            return;
         }

         if(class140.field2141 >= 15 + var1 && class140.field2141 <= var1 + 80 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(0, 1);
            return;
         }

         int var2 = 390 + class31.field695;
         if(class140.field2141 >= var2 && class140.field2141 <= var2 + 14 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(1, 0);
            return;
         }

         if(class140.field2141 >= var2 + 15 && class140.field2141 <= var2 + 80 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(1, 1);
            return;
         }

         int var3 = 500 + class31.field695;
         if(class140.field2141 >= var3 && class140.field2141 <= var3 + 14 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(2, 0);
            return;
         }

         if(class140.field2141 >= 15 + var3 && class140.field2141 <= 80 + var3 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(2, 1);
            return;
         }

         int var4 = class31.field695 + 610;
         if(class140.field2141 >= var4 && class140.field2141 <= var4 + 14 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(3, 0);
            return;
         }

         if(class140.field2141 >= 15 + var4 && class140.field2141 <= var4 + 80 && class140.field2142 >= 4 && class140.field2142 <= 18) {
            class99.method2206(3, 1);
            return;
         }

         if(class140.field2141 >= class31.field695 + 708 && class140.field2142 >= 4 && class140.field2141 <= 708 + class31.field695 + 50 && class140.field2142 <= 20) {
            class31.field727 = false;
            class31.field699.method1771(class31.field695, 0);
            class31.field730.method1771(class31.field695 + 382, 0);
            class31.field696.method1873(class31.field695 + 382 - class31.field696.field1390 / 2, 18);
            return;
         }

         if(class31.field728 != -1) {
            class25 var5 = class25.field635[class31.field728];
            class7.method93(var5);
            class31.field727 = false;
            class31.field699.method1771(class31.field695, 0);
            class31.field730.method1771(382 + class31.field695, 0);
            class31.field696.method1873(class31.field695 + 382 - class31.field696.field1390 / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-950116740"
   )
   public static boolean method1909(int var0) {
      if(class173.field2788[var0]) {
         return true;
      } else if(!class173.field2739.method3269(var0)) {
         return false;
      } else {
         int var1 = class173.field2739.method3276(var0);
         if(var1 == 0) {
            class173.field2788[var0] = true;
            return true;
         } else {
            if(class173.field2750[var0] == null) {
               class173.field2750[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class173.field2750[var0][var2]) {
                  byte[] var3 = class173.field2739.method3266(var0, var2);
                  if(null != var3) {
                     class173.field2750[var0][var2] = new class173();
                     class173.field2750[var0][var2].field2748 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class173.field2750[var0][var2].method3402(new class119(var3));
                     } else {
                        class173.field2750[var0][var2].method3401(new class119(var3));
                     }
                  }
               }
            }

            class173.field2788[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "99"
   )
   public static int method1910(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }
}
