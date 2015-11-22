package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fc")
public final class class162 {
   @ObfuscatedName("t")
   static class80[] field2634;

   @ObfuscatedName("a")
   public static String method3270(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(0 != var6) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class164.field2646[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("g")
   static void method3271() {
      client.field318.field1981 = 0;
      client.field320.field1981 = 0;
      client.field446 = -1;
      client.field325 = 1;
      client.field326 = -1;
      client.field327 = -1;
      client.field289 = 0;
      client.field323 = 0;
      client.field486 = 0;
      client.field416 = 0;
      client.field500 = false;
      client.field510 = 0;
      client.field537 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field397[var0] = null;
      }

      class0.field12 = null;

      for(var0 = 0; var0 < client.field313.length; ++var0) {
         class34 var1 = client.field313[var0];
         if(var1 != null) {
            var1.field823 = -1;
            var1.field824 = false;
         }
      }

      class15.method205();
      class31.method714(30);

      for(var0 = 0; var0 < 100; ++var0) {
         client.field370[var0] = true;
      }

      class19.method256();
   }
}
