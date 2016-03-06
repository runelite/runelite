package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dn")
public class class105 {
   @ObfuscatedName("a")
   static int[][] field1870 = new int[128][128];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 677121575
   )
   static int field1872;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 456020337
   )
   static int field1873;
   @ObfuscatedName("h")
   static int[] field1875 = new int[4096];
   @ObfuscatedName("n")
   static int[] field1877 = new int[4096];
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 852360541
   )
   static int field1878;
   @ObfuscatedName("i")
   static int[][] field1880 = new int[128][128];
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 390297391
   )
   static int field1883;

   @ObfuscatedName("j")
   public static final void method2332(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("az")
   static final void method2334(class37 var0) {
      int var1 = var0.field855 - client.field394;
      int var2 = var0.field851 * 128 + var0.field814 * 64;
      int var3 = var0.field814 * 64 + var0.field832 * 128;
      var0.field839 += (var2 - var0.field839) / var1;
      var0.field848 += (var3 - var0.field848) / var1;
      var0.field867 = 0;
      var0.field860 = var0.field865;
   }

   @ObfuscatedName("au")
   static final int method2335(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field81[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.field93[var5][1 + var3][var4] * var6 + (128 - var6) * class5.field93[var5][var3][var4] >> 7;
         int var9 = class5.field93[var5][1 + var3][var4 + 1] * var6 + class5.field93[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
