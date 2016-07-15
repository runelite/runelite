import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class79 {
   @ObfuscatedName("h")
   public static int[] field1449;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1869540373
   )
   static int field1450;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1071846099
   )
   public static int field1452;
   @ObfuscatedName("dt")
   @Export("region")
   static class89 field1453;
   @ObfuscatedName("y")
   static int[] field1456;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 80584009
   )
   public static int field1458;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-346840922"
   )
   static final int method1737(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) + ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) >> 8;
   }
}
