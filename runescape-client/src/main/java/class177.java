import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class177 {
   @ObfuscatedName("i")
   static int[][] field2249;
   @ObfuscatedName("a")
   static int[][] field2250;
   @ObfuscatedName("x")
   static int[] field2251;
   @ObfuscatedName("p")
   static int[] field2253;

   static {
      field2249 = new int[128][128];
      field2250 = new int[128][128];
      field2251 = new int[4096];
      field2253 = new int[4096];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "2087177062"
   )
   public static String method3421(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = '+';

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - var3 * 10;
               if(var9 >= 10) {
                  var6[var7] = (char)(var9 + 87);
               } else {
                  var6[var7] = (char)(var9 + 48);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }
}
