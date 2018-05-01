import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class205 {
   @ObfuscatedName("g")
   public static void method3924(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      if(var2 == var0) {
         if(var3 == var1) {
            return;
         }

         if(var3 > var1 && var3 < var4 + var1) {
            --var4;
            var1 += var4;
            var3 += var4;
            var4 = var1 - var4;

            for(var4 += 7; var1 >= var4; var2[var3--] = var0[var1--]) {
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
               var2[var3--] = var0[var1--];
            }

            for(var4 -= 7; var1 >= var4; var2[var3--] = var0[var1--]) {
               ;
            }

            return;
         }
      }

      var4 += var1;

      for(var4 -= 7; var1 < var4; var2[var3++] = var0[var1++]) {
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
         var2[var3++] = var0[var1++];
      }

      for(var4 += 7; var1 < var4; var2[var3++] = var0[var1++]) {
         ;
      }

   }

   @ObfuscatedName("o")
   public static void method3943(int[] var0, int var1, int var2) {
      for(var2 = var2 + var1 - 7; var1 < var2; var0[var1++] = 0) {
         var0[var1++] = 0;
         var0[var1++] = 0;
         var0[var1++] = 0;
         var0[var1++] = 0;
         var0[var1++] = 0;
         var0[var1++] = 0;
         var0[var1++] = 0;
      }

      for(var2 += 7; var1 < var2; var0[var1++] = 0) {
         ;
      }

   }
}
