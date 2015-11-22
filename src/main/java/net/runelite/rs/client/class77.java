package net.runelite.rs.client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public abstract class class77 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2124541695
   )
   int field1380;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 308152869
   )
   public int field1381;
   @ObfuscatedName("a")
   public Image field1382;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -6688031250077942173L
   )
   static long field1384;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -849353623
   )
   static int field1386;
   @ObfuscatedName("f")
   public int[] field1387;

   @ObfuscatedName("y")
   static final void method1699() {
      if(null != class11.field170) {
         class11.field170.method3022();
         class11.field170 = null;
      }

      class173.method3505();
      class24.field610.method2072();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field335[var0].method2441();
      }

      System.gc();
      class51.method1115(2);
      client.field512 = -1;
      client.field513 = false;
      class174.method3508();
      class31.method714(10);
   }

   @ObfuscatedName("j")
   public abstract void vmethod1896(int var1, int var2, Component var3);

   @ObfuscatedName("f")
   public abstract void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("m")
   public abstract void vmethod1895(Graphics var1, int var2, int var3);

   @ObfuscatedName("m")
   public static final boolean method1712(int var0, int var1, class106 var2, class107 var3) {
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

         int var15 = class105.field1843[var16][var17] + 1;
         if(var16 > 0 && 0 == class105.field1842[var16 - 1][var17] && 0 == (var12[var13 - 1][var14] & 19136782) && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = var5;
            var18 = 1 + var18 & 4095;
            class105.field1842[var16 - 1][var17] = 2;
            class105.field1843[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class105.field1842[var16 + 1][var17] == 0 && 0 == (var12[var13 + 2][var14] & 19136899) && 0 == (var12[var13 + 2][1 + var14] & 19136992)) {
            class105.field1845[var18] = 1 + var4;
            class105.field1848[var18] = var5;
            var18 = var18 + 1 & 4095;
            class105.field1842[1 + var16][var17] = 8;
            class105.field1843[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class105.field1842[var16][var17 - 1] == 0 && 0 == (var12[var13][var14 - 1] & 19136782) && 0 == (var12[1 + var13][var14 - 1] & 19136899)) {
            class105.field1845[var18] = var4;
            class105.field1848[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class105.field1842[var16][var17 - 1] = 1;
            class105.field1843[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class105.field1842[var16][var17 + 1] == 0 && 0 == (var12[var13][2 + var14] & 19136824) && 0 == (var12[var13 + 1][var14 + 2] & 19136992)) {
            class105.field1845[var18] = var4;
            class105.field1848[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class105.field1842[var16][1 + var17] = 4;
            class105.field1843[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class105.field1842[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16 - 1][var17 - 1] = 3;
            class105.field1843[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class105.field1842[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class105.field1845[var18] = var4 + 1;
            class105.field1848[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[1 + var16][var17 - 1] = 9;
            class105.field1843[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class105.field1842[var16 - 1][1 + var17] == 0 && 0 == (var12[var13 - 1][var14 + 1] & 19136830) && 0 == (var12[var13 - 1][var14 + 2] & 19136824) && (var12[var13][2 + var14] & 19137016) == 0) {
            class105.field1845[var18] = var4 - 1;
            class105.field1848[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16 - 1][1 + var17] = 6;
            class105.field1843[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 126 && var17 < 126 && 0 == class105.field1842[1 + var16][1 + var17] && 0 == (var12[var13 + 1][var14 + 2] & 19137016) && (var12[2 + var13][var14 + 2] & 19136992) == 0 && (var12[2 + var13][1 + var14] & 19136995) == 0) {
            class105.field1845[var18] = var4 + 1;
            class105.field1848[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class105.field1842[var16 + 1][1 + var17] = 12;
            class105.field1843[var16 + 1][1 + var17] = var15;
         }
      }

      class105.field1844 = var4;
      class105.field1851 = var5;
      return false;
   }

   @ObfuscatedName("ax")
   public final void method1713() {
      class79.method1814(this.field1387, this.field1381, this.field1380);
   }

   @ObfuscatedName("l")
   public static int method1715(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("au")
   static final void method1716(class37 var0, int var1) {
      class9.method150(var0.field846, var0.field834, var1);
   }
}
