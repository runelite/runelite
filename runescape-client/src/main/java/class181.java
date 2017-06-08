import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class181 {
   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-124"
   )
   static final int method3424(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class61.tileHeights[var5][var3 + 1][var4] + class61.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
