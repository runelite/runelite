import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1955262787
   )
   static int field915;
   @ObfuscatedName("w")
   @Export("username")
   String username;
   @ObfuscatedName("s")
   String field919;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1909463667
   )
   @Export("world")
   int world;
   @ObfuscatedName("o")
   @Export("rank")
   byte rank;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILfc;Lfw;I)Z",
      garbageValue = "-1342626355"
   )
   static final boolean method1138(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2302[var6][var7] = 99;
      class162.field2295[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2298[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2299[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class162.field2298[var11];
         var5 = class162.field2299[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3126(1, var4, var5, var3)) {
            class162.field2296 = var4;
            class162.field2292 = var5;
            return true;
         }

         int var15 = class162.field2295[var16][var17] + 1;
         if(var16 > 0 && class162.field2302[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17] = 2;
            class162.field2295[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class162.field2302[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17] = 8;
            class162.field2295[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2302[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2298[var18] = var4;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16][var17 - 1] = 1;
            class162.field2295[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class162.field2302[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2298[var18] = var4;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16][var17 + 1] = 4;
            class162.field2295[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2302[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17 - 1] = 3;
            class162.field2295[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class162.field2302[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17 - 1] = 9;
            class162.field2295[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class162.field2302[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2298[var18] = var4 - 1;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 - 1][var17 + 1] = 6;
            class162.field2295[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class162.field2302[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2298[var18] = var4 + 1;
            class162.field2299[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2302[var16 + 1][var17 + 1] = 12;
            class162.field2295[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2296 = var4;
      class162.field2292 = var5;
      return false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1788669673"
   )
   static int method1139(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2141037149"
   )
   static void method1140() {
      class94.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class94.field1488[var0] = null;
         class94.field1487[var0] = 1;
      }

   }
}
