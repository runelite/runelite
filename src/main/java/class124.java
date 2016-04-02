import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public class class124 {
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1742096675
   )
   static int field2018;
   @ObfuscatedName("ct")
   static class224 field2022;
   @ObfuscatedName("bh")
   static class168 field2023;
   @ObfuscatedName("p")
   static byte[][][] field2024;

   @ObfuscatedName("f")
   public static int method2788(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("f")
   public static final boolean method2790() {
      class137 var0 = class137.field2104;
      synchronized(class137.field2104) {
         if(class137.field2093 == class137.field2109) {
            return false;
         } else {
            class141.field2158 = class137.field2108[class137.field2093];
            class108.field1883 = class137.field2107[class137.field2093];
            class137.field2093 = 1 + class137.field2093 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("m")
   static final int method2793(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class14.method172(var3, var5);
      int var8 = class14.method172(var3 + 1, var5);
      int var9 = class14.method172(var3, var5 + 1);
      int var10 = class14.method172(var3 + 1, var5 + 1);
      int var12 = 65536 - class91.field1554[1024 * var4 / var2] >> 1;
      int var11 = (var7 * (65536 - var12) >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class91.field1554[1024 * var4 / var2] >> 1;
      int var13 = (var9 * (65536 - var14) >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - class91.field1554[1024 * var6 / var2] >> 1;
      int var15 = (var13 * var16 >> 16) + (var11 * (65536 - var16) >> 16);
      return var15;
   }
}
