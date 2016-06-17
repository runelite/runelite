import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class155 {
   @ObfuscatedName("g")
   public static final boolean[] field2280 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("j")
   public static int[] field2282 = new int[99];
   @ObfuscatedName("u")
   @Export("worldServersDownload")
   static class18 field2283;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "88"
   )
   static int method3176(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2282[var1] = var0 / 4;
      }

   }
}
