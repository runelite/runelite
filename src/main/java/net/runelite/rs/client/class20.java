package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("q")
public class class20 implements class111 {
   @ObfuscatedName("f")
   static final class20 field557 = new class20(2);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1325903549
   )
   final int field558;
   @ObfuscatedName("j")
   static final class20 field559 = new class20(0);
   @ObfuscatedName("l")
   static final class20 field560 = new class20(3);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -157544855
   )
   public static int field562;
   @ObfuscatedName("eu")
   static class78 field563;
   @ObfuscatedName("m")
   static final class20 field565 = new class20(1);

   @ObfuscatedName("m")
   public int vmethod3208() {
      return this.field558;
   }

   class20(int var1) {
      this.field558 = var1;
   }

   @ObfuscatedName("r")
   public static void method593() {
      class51.field1093.method3806();
      class51.field1136.method3806();
      class51.field1095.method3806();
   }

   @ObfuscatedName("a")
   public static class78 method594(class166 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3323(var3, var2);
      return class40.method883(var0, var3, var4);
   }

   @ObfuscatedName("j")
   public static final boolean method595(int var0, int var1, class106 var2, class107 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class105.field1842[var6][var7] = 99;
      class105.field1843[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class105.field1845[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class105.field1848[var10001] = var1;
      int[][] var12 = var3.field1879;

      while(var11 != var18) {
         var4 = class105.field1845[var11];
         var5 = class105.field1848[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1881;
         int var14 = var5 - var3.field1883;
         if(var2.vmethod2416(var4, var5)) {
            class105.field1844 = var4;
            class105.field1851 = var5;
            return true;
         }

         int var15 = 1 + class105.field1843[var16][var17];
         if(var16 > 0 && 0 == class105.field1842[var16 - 1][var17] && (var12[var13 - 1][var14] & 19136776) == 0) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = var5;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16 - 1][var17] = 2;
            class105.field1843[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && 0 == class105.field1842[1 + var16][var17] && 0 == (var12[1 + var13][var14] & 19136896)) {
            class105.field1845[var18] = 1 + var4;
            class105.field1848[var18] = var5;
            var18 = 1 + var18 & 4095;
            class105.field1842[var16 + 1][var17] = 8;
            class105.field1843[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && 0 == class105.field1842[var16][var17 - 1] && 0 == (var12[var13][var14 - 1] & 19136770)) {
            class105.field1845[var18] = var4;
            class105.field1848[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16][var17 - 1] = 1;
            class105.field1843[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class105.field1842[var16][var17 + 1] == 0 && 0 == (var12[var13][1 + var14] & 19136800)) {
            class105.field1845[var18] = var4;
            class105.field1848[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16][1 + var17] = 4;
            class105.field1843[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class105.field1842[var16 - 1][var17 - 1] == 0 && 0 == (var12[var13 - 1][var14 - 1] & 19136782) && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class105.field1842[var16 - 1][var17 - 1] = 3;
            class105.field1843[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class105.field1842[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class105.field1845[var18] = 1 + var4;
            class105.field1848[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[1 + var16][var17 - 1] = 9;
            class105.field1843[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class105.field1842[var16 - 1][var17 + 1] == 0 && 0 == (var12[var13 - 1][var14 + 1] & 19136824) && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][1 + var14] & 19136800)) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16 - 1][1 + var17] = 6;
            class105.field1843[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && 0 == class105.field1842[var16 + 1][var17 + 1] && 0 == (var12[1 + var13][1 + var14] & 19136992) && 0 == (var12[1 + var13][var14] & 19136896) && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class105.field1845[var18] = 1 + var4;
            class105.field1848[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[1 + var16][1 + var17] = 12;
            class105.field1843[1 + var16][1 + var17] = var15;
         }
      }

      class105.field1844 = var4;
      class105.field1851 = var5;
      return false;
   }

   @ObfuscatedName("dt")
   static final void method596() {
      client.field318.method2785(254);

      for(class3 var0 = (class3)client.field304.method3835(); var0 != null; var0 = (class3)client.field304.method3840()) {
         if(var0.field61 == 0 || 3 == var0.field61) {
            class7.method125(var0, true);
         }
      }

      if(null != client.field545) {
         class42.method942(client.field545);
         client.field545 = null;
      }

   }

   @ObfuscatedName("t")
   public static int method597(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
