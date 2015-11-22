package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public abstract class class124 {
   @ObfuscatedName("m")
   static boolean field2023 = false;

   @ObfuscatedName("j")
   abstract byte[] vmethod2818();

   @ObfuscatedName("m")
   abstract void vmethod2820(byte[] var1);

   @ObfuscatedName("bv")
   static final String method2833(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class74.method1617(16711680):(var2 < -6?class74.method1617(16723968):(var2 < -3?class74.method1617(16740352):(var2 < 0?class74.method1617(16756736):(var2 > 9?class74.method1617('\uff00'):(var2 > 6?class74.method1617(4259584):(var2 > 3?class74.method1617(8453888):(var2 > 0?class74.method1617(12648192):class74.method1617(16776960))))))));
   }

   @ObfuscatedName("f")
   static void method2839(int var0, class133 var1, class167 var2) {
      byte[] var3 = null;
      class198 var4 = class169.field2694;
      synchronized(class169.field2694) {
         for(class168 var5 = (class168)class169.field2694.method3871(); var5 != null; var5 = (class168)class169.field2694.method3873()) {
            if(var5.field3104 == (long)var0 && var5.field2683 == var1 && var5.field2684 == 0) {
               var3 = var5.field2685;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3406(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2898(var0);
         var2.method3406(var1, var0, var8, true);
      }
   }
}
