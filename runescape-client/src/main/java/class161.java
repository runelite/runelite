import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class161 {
   @ObfuscatedName("pe")
   static class8 field2659;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1439488948"
   )
   static final int method3205(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = (15731 * var2 * var2 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
