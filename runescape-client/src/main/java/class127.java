import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class127 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2088868997"
   )
   static final int method2851(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & '\uff00') + (var0 & '\uff00') * var3 & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1523977194"
   )
   public static int method2854(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
