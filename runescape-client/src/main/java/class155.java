import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class155 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -590259008304774307L
   )
   static long field2108;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 987846418709483427L
   )
   static long field2109;
   @ObfuscatedName("h")
   static class208 field2112;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZS)Ljava/lang/String;",
      garbageValue = "25651"
   )
   public static String method2947(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - 10 * var3;
               if(var9 >= 10) {
                  var6[var7] = (char)(87 + var9);
               } else {
                  var6[var7] = (char)(48 + var9);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-105"
   )
   static String method2949(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
