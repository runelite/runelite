package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
@Implements("GameObject")
public final class class97 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1691294757
   )
   @Export("flags")
   int field1641 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 919293527
   )
   @Export("height")
   int field1642;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1460744763
   )
   @Export("plane")
   int field1643;
   @ObfuscatedName("a")
   @Export("renderable")
   public class84 field1644;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1616526365
   )
   int field1645;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1655844155
   )
   @Export("orientation")
   int field1646;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1852021673
   )
   @Export("relativeX")
   int field1647;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1481383257
   )
   @Export("offsetX")
   int field1648;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 895022087
   )
   @Export("relativeY")
   int field1649;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 981018825
   )
   @Export("offsetY")
   int field1650;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1046625625
   )
   @Export("y")
   int field1651;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1516740967
   )
   int field1652;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -819960345
   )
   @Export("hash")
   public int field1653 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 635743121
   )
   @Export("x")
   int field1654;
   @ObfuscatedName("mu")
   static class78 field1655;

   @ObfuscatedName("bw")
   static void method2214(int var0, int var1) {
      client.field318.method2785(66);
      client.field318.method2547(var1);
      client.field318.method2577(var0);
   }

   @ObfuscatedName("m")
   public static class41 method2215(int var0) {
      class41 var1 = (class41)class41.field957.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class41.field963.method3352(1, var0);
         var1 = new class41();
         if(null != var2) {
            var1.method886(new class118(var2));
         }

         var1.method885();
         class41.field957.method3805(var1, (long)var0);
         return var1;
      }
   }
}
