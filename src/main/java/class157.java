import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fp")
public class class157 {
   @ObfuscatedName("dx")
   static int[] field2579;

   @ObfuscatedName("f")
   public static int method3178(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var1:(1 == var2?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
