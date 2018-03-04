import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public final class class33 {
   @ObfuscatedName("z")
   final int[] field467;

   class33() {
      this.field467 = new int[4096];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "1642662394"
   )
   final void method357(class44 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field467[var2 * 64 + var3] = var1.method628(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1481676868"
   )
   final int method360(int var1, int var2) {
      return this.field467[var1 * 64 + var2];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "900623208"
   )
   static int method366(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
