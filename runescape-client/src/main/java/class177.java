import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class177 {
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 1221144581
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljx;",
      garbageValue = "-1351819322"
   )
   public static class285[] method3269() {
      return new class285[]{class285.field3786, class285.field3785, class285.field3787};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "16"
   )
   static final int method3267(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
   }
}
