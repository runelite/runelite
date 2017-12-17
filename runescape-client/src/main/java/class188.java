import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class188 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field2537;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 1601651043437361307L
   )
   public static long field2539;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 31531005
   )
   static int field2540;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-90691275"
   )
   static final int method3534(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }
}
