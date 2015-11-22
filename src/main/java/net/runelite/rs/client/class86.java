package net.runelite.rs.client;

import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
public final class class86 {
   @ObfuscatedName("h")
   public class84 field1505;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1680202377
   )
   int field1506;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1089403757
   )
   int field1507 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -7910203
   )
   int field1508;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1580436473
   )
   int field1509;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 742105871
   )
   int field1510;
   @ObfuscatedName("a")
   public class84 field1511;
   @ObfuscatedName("bf")
   protected static FontMetrics field1512;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2013349905
   )
   public int field1513 = 0;
   @ObfuscatedName("aa")
   static int[] field1514;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 543843765
   )
   int field1515;
   @ObfuscatedName("rr")
   protected static boolean field1516;
   @ObfuscatedName("e")
   public static class59 field1518;

   @ObfuscatedName("m")
   static void method2096(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field171.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class27();
         class11.field171.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method687(var0, var1, var2, var3);
      class11.field166.method3850(var5, (long)var5.field769);
      class11.field172.method3899(var5);
      client.field466 = client.field459;
   }

   @ObfuscatedName("m")
   public static int method2097(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var1:(1 == var2?7 - var0:(2 == var2?7 - var1:var0));
   }

   @ObfuscatedName("t")
   static final int method2098(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) + ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) >> 8;
   }
}
