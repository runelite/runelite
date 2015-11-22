package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fm")
public class class156 {
   @ObfuscatedName("h")
   static String method3206(int var0, int var1, boolean var2) {
      if(var2 && var0 >= 0) {
         int var3 = 2;

         for(int var4 = var0 / var1; 0 != var4; ++var3) {
            var4 /= var1;
         }

         char[] var5 = new char[var3];
         var5[0] = 43;

         for(int var6 = var3 - 1; var6 > 0; --var6) {
            int var7 = var0;
            var0 /= var1;
            int var8 = var7 - var0 * var1;
            if(var8 >= 10) {
               var5[var6] = (char)(87 + var8);
            } else {
               var5[var6] = (char)(48 + var8);
            }
         }

         return new String(var5);
      } else {
         return Integer.toString(var0, var1);
      }
   }
}
