import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class142 {
   @ObfuscatedName("x")
   static int[] field2170;
   @ObfuscatedName("u")
   public static String[] field2173;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "9"
   )
   static String method3093(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; 0 != var4; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
