import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 6093441288787933891L
   )
   static long field2102;
   @ObfuscatedName("p")
   static class182 field2106;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 8811431874580119745L
   )
   static long field2107;

   class155() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "579031530"
   )
   static final int method3109(int var0, int var1, int var2) {
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

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-119"
   )
   static final void method3110(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class10.tileHeights[var0][var1 + var3][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1][var3 + var2] = class10.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1 + var3][var2] = class10.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class10.tileHeights[var0][var1 - 1][var2] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class10.tileHeights[var0][var1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class10.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
