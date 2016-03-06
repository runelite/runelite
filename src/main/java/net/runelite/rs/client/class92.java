package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ct")
public final class class92 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1496878825
   )
   int field1593;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1860217749
   )
   public int field1596;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1304520221
   )
   int field1597;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1241787625
   )
   @Export("baseY")
   static int field1598;
   @ObfuscatedName("i")
   public class84 field1599;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1577445453
   )
   int field1600;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1063024523
   )
   int field1602;

   @ObfuscatedName("r")
   static final String method2135(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("h")
   static class78 method2136() {
      class78 var0 = new class78();
      var0.field1421 = class76.field1390;
      var0.field1416 = class76.field1391;
      var0.field1413 = class76.field1392[0];
      var0.field1420 = class106.field1884[0];
      var0.field1411 = class215.field3153[0];
      var0.field1414 = class147.field2230[0];
      int var1 = var0.field1414 * var0.field1411;
      byte[] var2 = class41.field977[0];
      var0.field1412 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1412[var3] = class126.field2048[var2[var3] & 255];
      }

      class76.field1392 = null;
      class106.field1884 = null;
      class215.field3153 = null;
      class147.field2230 = null;
      class126.field2048 = null;
      class41.field977 = (byte[][])null;
      return var0;
   }
}
