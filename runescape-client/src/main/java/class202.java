import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class202 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 631680721
   )
   int field2466;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1540128575
   )
   int field2459;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1284386443
   )
   int field2464;
   @ObfuscatedName("c")
   byte[] field2467;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1201061897
   )
   int field2465;
   @ObfuscatedName("o")
   byte[] field2458;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -230661677
   )
   int field2462;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2070503585
   )
   int field2460;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 352848941
   )
   int field2461;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfu;S)Z",
      garbageValue = "-15757"
   )
   public static final boolean method3622(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2262[var6][var7] = 99;
      class162.field2265[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2268[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2269[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class162.field2268[var11];
         var5 = class162.field2269[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2998(2, var4, var5, var3)) {
            class162.field2266 = var4;
            class162.field2267 = var5;
            return true;
         }

         int var15 = class162.field2265[var16][var17] + 1;
         if(var16 > 0 && class162.field2262[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17] = 2;
            class162.field2265[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class162.field2262[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17] = 8;
            class162.field2265[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2262[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class162.field2268[var18] = var4;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16][var17 - 1] = 1;
            class162.field2265[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && 0 == class162.field2262[var16][var17 + 1] && (var12[var13][var14 + 2] & 19136824) == 0 && 0 == (var12[var13 + 1][var14 + 2] & 19136992)) {
            class162.field2268[var18] = var4;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16][var17 + 1] = 4;
            class162.field2265[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2262[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17 - 1] = 3;
            class162.field2265[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class162.field2262[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17 - 1] = 9;
            class162.field2265[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class162.field2262[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17 + 1] = 6;
            class162.field2265[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class162.field2262[var16 + 1][var17 + 1] == 0 && 0 == (var12[var13 + 1][var14 + 2] & 19137016) && 0 == (var12[var13 + 2][var14 + 2] & 19136992) && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17 + 1] = 12;
            class162.field2265[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2266 = var4;
      class162.field2267 = var5;
      return false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "-1209800035"
   )
   public static void method3623(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }
}
