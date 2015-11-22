package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class155 {
   @ObfuscatedName("bj")
   static class80[] field2289;

   @ObfuscatedName("j")
   static final void method3205(class121 var0) {
      var0.method2787();
      int var1 = client.field523;
      class2 var2 = class0.field12 = client.field397[var1] = new class2();
      var2.field58 = var1;
      int var3 = var0.method2786(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field809[0] = var5 - class47.field1053;
      var2.field846 = (var2.field809[0] << 7) + (var2.method15() << 6);
      var2.field816[0] = var6 - class161.field2629;
      var2.field834 = (var2.field816[0] << 7) + (var2.method15() << 6);
      class8.field134 = var2.field56 = var4;
      if(null != class32.field732[var1]) {
         var2.method14(class32.field732[var1]);
      }

      class32.field733 = 0;
      class32.field730[++class32.field733 - 1] = var1;
      class32.field728[var1] = 0;
      class32.field742 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2786(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field737[var7] = var11 + (var10 << 14) + (var9 << 28);
            class32.field738[var7] = 0;
            class32.field735[var7] = -1;
            class32.field736[++class32.field742 - 1] = var7;
            class32.field728[var7] = 0;
         }
      }

      var0.method2800();
   }
}
